package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KomentarDbModel;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GlavnaForma {

	private JFrame frmDobrodoaolaUDms;
	private JTable table;
	private JLabel lblDokumenti;
	private JLabel lblKomentari;
	private JButton btnDodajKomentar;
	private JTextField txtNoviDokumentPutanja;
	private JButton btnDodajDokument;
	private JTable table_1;
	private JLabel lblVerzijeIzabranogDokumenta;
	private JTextField textField;
	private JButton btnDodajVerziju;
	private JButton btnPreuzmiVerziju;
	private JMenuBar menuBar;
	private JMenu mnGlavna;
	private JMenuItem mntmMojProfil;
	private JMenuItem mntmIzlaz;
	private JMenu mnDokumenti;
	private JMenuItem mntmPregledDokumenta;
	private JMenu mnGrupe;
	private JMenuItem mntmDodavanjeGrupe;
	private JMenuItem mntmIzmjenaGrupe;
	private JMenu mnKorisnici;
	private JMenuItem mntmDodavanjeKorisnika;
	private JMenuItem mntmBrisanjeKorisnika;
	private JMenu mnZahtjevi;
	private JMenuItem mntmDodavanjeZahtjeva;
	private JMenuItem mntmPregledZahtjeva;
	private JLabel lblZahtjevZaUgovordocx;
	private JPopupMenu popupMenu;
	private JMenuItem mntmPostavkePravaPristupa;
	private JMenuItem mntmDodajFolder;
	private JMenuItem mntmObrisiFolder;
	private JMenuItem mntmDodajDokument_1;
	private JMenuItem mntmObrisiDokument;
	private JMenuItem mntmDodajVerzijuDokumenta;
	private JMenuItem mntmDodajVerzijuDokumenta_1;
	public JTextField txtPretraga;
	public final JTree treeFolderView = new JTree();;
	
	private UnitOfWork uow = new UnitOfWork();
	/**
	 * Launch the application.
	 */
	public static void PokreniFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavnaForma window = new GlavnaForma();
					window.frmDobrodoaolaUDms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavnaForma() {
		initialize();
	}
	
	private void otvoriProzorZaDodavanjeFoldera() {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
				treeFolderView.getLastSelectedPathComponent();
		
		if(node.getUserObject() instanceof DokumentDbModel){
			
		}
		
		if(node.getUserObject() instanceof FolderDbModel){
			FolderDbModel folder = (FolderDbModel)node.getUserObject();
			//DodavanjeFoldera dodavanjeFoldera = new DodavanjeFoldera(forma, (Integer)(int)folder.getFolderId());
			//dodavanjeFoldera.getFrmDodavanjeFoldera().setVisible(true);
			
			DodavanjeFoldera.pokreni(this, (Integer)(int)folder.getFolderId());
		}
	}
	
	/*
	 * OVA METODA JE ZMAJ!!!!!
	 */
	private DefaultMutableTreeNode PopuniDrvo(DefaultMutableTreeNode roditeljNode, FolderDbModel folder){
		System.out.println("Usao");
		List<DokumentDbModel> dokumenti = uow.getDokumentRepository().dajDokumente((Integer)(int)folder.getFolderId());
		DefaultMutableTreeNode node = null;
		for (DokumentDbModel dokumentDbModel : dokumenti) {
			node = new DefaultMutableTreeNode(dokumentDbModel);
			node.setAllowsChildren(false);
			roditeljNode.add(node);
		}
		System.out.println("Dodao dokumente");
		List<FolderDbModel> podfolderi = uow.getFolderRepository().dajPodfoldere((Integer)(int)folder.getFolderId());
		if(podfolderi.size() != 0){
			System.out.println("Dodavane podfoldera-----------------------------");
			for (FolderDbModel folderDbModel : podfolderi) {
				System.out.println("podfolderi: "+folderDbModel.getFolderNaziv());
				node = new DefaultMutableTreeNode(folderDbModel);
				roditeljNode.add(node);
				
				roditeljNode.add(PopuniDrvo(node, folderDbModel));
			}
			System.out.println("Zavrseno dodavane podfoldera-----------------------------");
		}
		System.out.println("Dodao foldere");
		return roditeljNode;
	}
	
	/*
	 * Metoda puni tabelu verzija izabragog dokumenta.
	 */
	private void ucitajKomentareNaVerziju(long dokumentVerzijaId){
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Korisnik postavio", "Vrijeme", "Komentar"}
				},
				new String[] {
					"Korisnik postavio", "Vrijeme", "Komentar"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(115);
			table.getColumnModel().getColumn(1).setPreferredWidth(112);
			table.getColumnModel().getColumn(2).setPreferredWidth(233);
			
			System.out.println("Nasao komentare");
		List<KomentarDbModel> komentariNaVerziju = uow.getKomentarRepository().dajKomentare((Integer)(int)dokumentVerzijaId);
		for (KomentarDbModel komentarDbModel : komentariNaVerziju) {
			Object[] row = {komentarDbModel.getKorisnik().getIme()+" "+
					komentarDbModel.getKorisnik().getPrezime(), 
					komentarDbModel.getDatumVrijemeKomentara(),
					komentarDbModel.getKomentar()};
	
			((DefaultTableModel)table.getModel()).addRow(row);
			System.out.println("dodao: "+komentarDbModel.getKomentar());
		}
	}
	
	/*
	 * Metoda puni tabelu verzija izabragog dokumenta.
	 */
	private void ucitajVerzijeDokumenta(long dokumentId){
		
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{"ID", "Postavio korisnik", "Verzija", "Vrijeme postavljanja"}
				},
				new String[] {
					"New column", "New column", "New column", "New column"
				}
			));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(174);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(112);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(322);
		
		List<DokumentVerzijaDbModel> verzijeDokumenta = uow.getDokumentRepository().dajVerzijeDokumenta((Integer)(int)dokumentId);
		
		System.out.println("Nasao verzije");
		for (DokumentVerzijaDbModel dokumentVerzijaDbModel : verzijeDokumenta) {
			Object[] row = {(Integer)(int)dokumentVerzijaDbModel.getDokumentVerzijaId(),
							dokumentVerzijaDbModel.getPostavioKorisnik().getIme()+" "+
							dokumentVerzijaDbModel.getPostavioKorisnik().getPrezime(), 
							"v"+dokumentVerzijaDbModel.getDokumentVerzijaId(), 
							"22.05.2015. 22:57"};
			
			((DefaultTableModel)table_1.getModel()).addRow(row);
		}
	}
	private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
	    for(int i=startingIndex;i<rowCount;++i){
	        tree.expandRow(i);
	    }

	    if(tree.getRowCount()!=rowCount){
	        expandAllNodes(tree, rowCount, tree.getRowCount());
	    }
	}
	
	public void ucitajTreeViewModel(){
		//JOptionPane.showMessageDialog(null, "UCITAVAM MODEL", "Naziv", JOptionPane.INFORMATION_MESSAGE);
		System.out.print("UCITAVAM MODEL-----------------------");
		treeFolderView.clearSelection();
		treeFolderView.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("Root") {
					{
						DefaultMutableTreeNode node;
						List<FolderDbModel> pocetniFolderi = null;
						
						try {
							pocetniFolderi = uow.getFolderRepository().dajFoldere();
						} catch (Exception e) {
						}
						
						if(pocetniFolderi != null){
							for (FolderDbModel folderDbModel : pocetniFolderi) {
								node = new DefaultMutableTreeNode(folderDbModel);
								add(PopuniDrvo(node, folderDbModel));
							}
						}
					}
				}
			));
		expandAllNodes(treeFolderView, 0, treeFolderView.getRowCount());
	}
	
	public void ucitajTreeViewModel(final String filter){
		treeFolderView.setCellRenderer(new DefaultTreeCellRenderer() {
            private JLabel lblNull = new JLabel();

            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value,
                    boolean arg2, boolean arg3, boolean arg4, int arg5, boolean arg6) {

                Component c = super.getTreeCellRendererComponent(tree, value, arg2, arg3, arg4, arg5, arg6);

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                if (matchesFilter(node)) {
                    c.setForeground(Color.BLACK);
                    return c;
                }
                else if (containsMatchingChild(node)) {
                    c.setForeground(Color.GRAY);
                    return c;
                }
                else {
                    return lblNull;
                }
            }

            private boolean matchesFilter(DefaultMutableTreeNode node) {
                return node.toString().contains(filter);
            }

            private boolean containsMatchingChild(DefaultMutableTreeNode node) {
                Enumeration<DefaultMutableTreeNode> e = node.breadthFirstEnumeration();
                while (e.hasMoreElements()) {
                    if (matchesFilter(e.nextElement())) {
                        return true;
                    }
                }
                return false;
            }
        });
		ucitajTreeViewModel();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmDobrodoaolaUDms = new JFrame();
		frmDobrodoaolaUDms.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				ucitajTreeViewModel();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		frmDobrodoaolaUDms.setTitle("Dobrodošao/la u DMS");
		frmDobrodoaolaUDms.setBounds(100, 100, 858, 510);

		frmDobrodoaolaUDms.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //samo ce se zatvorit prozor, nece sve
		
		frmDobrodoaolaUDms.getContentPane().setLayout(null);
		
		treeFolderView.setShowsRootHandles(true);
		treeFolderView.setRootVisible(false);
		
		treeFolderView.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); //moguce odabrati samo jednu stavku
		ucitajTreeViewModel();
		
		treeFolderView.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)
						treeFolderView.getLastSelectedPathComponent();
				if(node != null){
					if(node.getUserObject() instanceof DokumentDbModel){
						DokumentDbModel dokument = (DokumentDbModel)node.getUserObject();
						ucitajVerzijeDokumenta(dokument.getDokumentId());
						//JOptionPane.showMessageDialog(null, dokument.getDokumentNaziv(), "Naziv", JOptionPane.INFORMATION_MESSAGE);
					}
					
					if(node.getUserObject() instanceof FolderDbModel){
						FolderDbModel folder = (FolderDbModel)node.getUserObject();
						//JOptionPane.showMessageDialog(null, folder.getFolderNaziv(), "Naziv", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		treeFolderView.setBounds(10, 53, 343, 407);
		
		frmDobrodoaolaUDms.getContentPane().add(treeFolderView);
		
		popupMenu = new JPopupMenu();
		addPopup(treeFolderView, popupMenu);
		
		mntmPostavkePravaPristupa = new JMenuItem("Postavke prava pristupa");
		popupMenu.add(mntmPostavkePravaPristupa);
		
		mntmDodajFolder = new JMenuItem("Dodaj folder");
		

		mntmDodajFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				otvoriProzorZaDodavanjeFoldera();
			}
		});
		popupMenu.add(mntmDodajFolder);
		
		mntmObrisiFolder = new JMenuItem("Obrisi folder");
		popupMenu.add(mntmObrisiFolder);
		
		mntmDodajDokument_1 = new JMenuItem("Dodaj dokument");
		mntmDodajDokument_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)
						treeFolderView.getLastSelectedPathComponent();
				if(node != null){
					if(node.getUserObject() instanceof DokumentDbModel){ //dodavanje verzije
						DokumentDbModel dokument = (DokumentDbModel)node.getUserObject();
						
						JFileChooser choser = new JFileChooser();
						if(choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
							File file = choser.getSelectedFile();
							DokumentVerzijaDbModel verzija = new DokumentVerzijaDbModel();
							verzija.setAktivan(true);
							verzija.setDokumentId((Integer)(int)dokument.getDokumentId());
							try {
								verzija.setPostavioKorisnikId(uow.getKorisnikRepository().dajIdKorisnikaPoUsername(Sesija.getUsername()));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//sadrzaj
							uow.getDokumentRepository().dodajverzijuDokumenta(verzija);
							ucitajTreeViewModel();
							JOptionPane.showMessageDialog(null, file.getName(), "Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					
					if(node.getUserObject() instanceof FolderDbModel){ //dodavanje novog dokumenta
						FolderDbModel folder = (FolderDbModel)node.getUserObject();
						
						JFileChooser choser = new JFileChooser();
						if(choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
							File file = choser.getSelectedFile();
							DokumentDbModel dokument = new DokumentDbModel();
							int pozicija = file.getName().lastIndexOf('.');
							dokument.setDokumentNaziv(file.getName().substring(0, pozicija));
							
							dokument.setEkstenzija(file.getName().substring(pozicija));
							dokument.setFolderId((Integer)(int)folder.getFolderId());
							dokument.setAktivan(true);
							
							
							uow.getDokumentRepository().dodajDokument(dokument,"");
							ucitajTreeViewModel();
							JOptionPane.showMessageDialog(null, file.getName(), "Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				
				
			}
		});
		popupMenu.add(mntmDodajDokument_1);
		
		mntmObrisiDokument = new JMenuItem("Obrisi dokument");
		popupMenu.add(mntmObrisiDokument);
		
		mntmDodajVerzijuDokumenta = new JMenuItem("Dodaj verziju dokumenta");
		popupMenu.add(mntmDodajVerzijuDokumenta);
		
		mntmDodajVerzijuDokumenta_1 = new JMenuItem("Dodaj verziju dokumenta");
		popupMenu.add(mntmDodajVerzijuDokumenta_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Korisnik postavio", "Vrijeme", "Komentar"},
				{"Muhamed Smajevic", "24.05.2016. 24:22", "Mislim da bi trebalo da se doda jos jedna stavka."},
				{"Solomon Bicakcic", "24.05.2016. 24:38", "Bice dodano u sljedecoj verziji."},
				{null, null, null},
			},
			new String[] {
				"Korisnik postavio", "Vrijeme", "Komentar"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(233);
		table.setBounds(363, 277, 469, 90);
		frmDobrodoaolaUDms.getContentPane().add(table);
		
		lblDokumenti = new JLabel("Moji dokumenti: Muhamed Smajevic, Development Team");
		lblDokumenti.setBounds(363, 28, 469, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblDokumenti);
		
		lblKomentari = new JLabel("Komentari za izabranu verziju");
		lblKomentari.setBounds(363, 258, 177, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblKomentari);
		
		btnDodajKomentar = new JButton("Dodaj komentar");
		btnDodajKomentar.setBounds(675, 437, 157, 23);
		frmDobrodoaolaUDms.getContentPane().add(btnDodajKomentar);
		
		txtNoviDokumentPutanja = new JTextField();
		txtNoviDokumentPutanja.setBounds(363, 51, 302, 20);
		frmDobrodoaolaUDms.getContentPane().add(txtNoviDokumentPutanja);
		txtNoviDokumentPutanja.setColumns(10);
		
		btnDodajDokument = new JButton("Dodaj dokument");
		btnDodajDokument.setBounds(675, 50, 157, 23);
		frmDobrodoaolaUDms.getContentPane().add(btnDodajDokument);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*Integer verzijaId = null;
				try {
					verzijaId = (Integer)table_1.getValueAt(table_1.getSelectedRow(), 0);
					ucitajKomentareNaVerziju(verzijaId);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Nista", "Naziv", JOptionPane.INFORMATION_MESSAGE);
				}*/
				ucitajKomentareNaVerziju(2);
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Postavio korisnik", "Verzija", "Vrijeme postavljanja"}
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(174);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(112);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(322);
		table_1.setBounds(363, 99, 469, 115);
		frmDobrodoaolaUDms.getContentPane().add(table_1);
		
		lblVerzijeIzabranogDokumenta = new JLabel("Verzije izabranog dokumenta:");
		lblVerzijeIzabranogDokumenta.setBounds(363, 82, 177, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblVerzijeIzabranogDokumenta);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(363, 225, 203, 20);
		frmDobrodoaolaUDms.getContentPane().add(textField);
		
		btnDodajVerziju = new JButton("Dodaj verziju");
		btnDodajVerziju.setBounds(576, 224, 123, 23);
		frmDobrodoaolaUDms.getContentPane().add(btnDodajVerziju);
		
		btnPreuzmiVerziju = new JButton("Preuzmi");
		btnPreuzmiVerziju.setBounds(709, 224, 123, 23);
		frmDobrodoaolaUDms.getContentPane().add(btnPreuzmiVerziju);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 842, 21);
		frmDobrodoaolaUDms.getContentPane().add(menuBar);
		
		mnGlavna = new JMenu("Glavna");
		menuBar.add(mnGlavna);
		
		mntmMojProfil = new JMenuItem("Moj profil");
		mnGlavna.add(mntmMojProfil);
		
		mntmIzlaz = new JMenuItem("Izlaz");
		mnGlavna.add(mntmIzlaz);
		
		mnDokumenti = new JMenu("Dokumenti");
		menuBar.add(mnDokumenti);
		
		mntmPregledDokumenta = new JMenuItem("Pregled dokumenta");
		mnDokumenti.add(mntmPregledDokumenta);
		
		mnGrupe = new JMenu("Grupe");
		menuBar.add(mnGrupe);
		
		mntmDodavanjeGrupe = new JMenuItem("Dodavanje grupe");
		mntmDodavanjeGrupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KreiranjeGrupa forma = new KreiranjeGrupa();
				forma.PokreniFormu();
			}
		});
		mnGrupe.add(mntmDodavanjeGrupe);
		
		mntmIzmjenaGrupe = new JMenuItem("Izmjena grupe");
		mntmIzmjenaGrupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IzmjenaGrupe forma = new IzmjenaGrupe();
				forma.PokreniFormu();
			}
		});
		mnGrupe.add(mntmIzmjenaGrupe);
		
		mnKorisnici = new JMenu("Korisnici");
		menuBar.add(mnKorisnici);
		
		mntmDodavanjeKorisnika = new JMenuItem("Dodavanje korisnika");
		mntmDodavanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeKorisnika dodavanjeKorisnikaForma = new DodavanjeKorisnika();
				dodavanjeKorisnikaForma.pokreniFormu();
			}
		});
		mnKorisnici.add(mntmDodavanjeKorisnika);
		
		mntmBrisanjeKorisnika = new JMenuItem("Izmjena korisnika");
		mnKorisnici.add(mntmBrisanjeKorisnika);
		
		mnZahtjevi = new JMenu("Zahtjevi");
		menuBar.add(mnZahtjevi);
		
		mntmPregledZahtjeva = new JMenuItem("Pregled zahtjeva");
		mnZahtjevi.add(mntmPregledZahtjeva);
		
		mntmDodavanjeZahtjeva = new JMenuItem("Dodavanje zahtjeva");
		mnZahtjevi.add(mntmDodavanjeZahtjeva);
		
		lblZahtjevZaUgovordocx = new JLabel("Zahtjev za ugovor1.docx");
		lblZahtjevZaUgovordocx.setBounds(545, 82, 287, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblZahtjevZaUgovordocx);
		
		JEditorPane txtKomentar = new JEditorPane();
		txtKomentar.setBounds(363, 377, 469, 49);
		frmDobrodoaolaUDms.getContentPane().add(txtKomentar);
		
		txtPretraga = new JTextField();
		txtPretraga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!txtPretraga.getText().equals("")){
					//JOptionPane.showMessageDialog(null, "Filtriram", "Naziv", JOptionPane.INFORMATION_MESSAGE);
					ucitajTreeViewModel(txtPretraga.getText());
				}else{
					treeFolderView.setCellRenderer(null);
					ucitajTreeViewModel();
				}
			}
		});
		txtPretraga.setColumns(10);
		txtPretraga.setBounds(81, 25, 272, 20);
		frmDobrodoaolaUDms.getContentPane().add(txtPretraga);
		
		JLabel lblPretraga = new JLabel("Pretraga");
		lblPretraga.setBounds(10, 28, 65, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblPretraga);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
