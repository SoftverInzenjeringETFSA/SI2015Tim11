package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import com.mysql.jdbc.Blob;

import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KomentarDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

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
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class GlavnaForma {

	private JFrame frmDobrodoaolaUDms;
	private JTable table;
	private JLabel lblMojiPodaci;
	private JLabel lblKomentari;
	private JButton btnDodajKomentar;
	private JButton btnDodajRootFolder;
	private JTable table_1;
	private JLabel lblVerzijeIzabranogDokumenta;
	private JButton btnDodajVerziju;
	private JButton btnPreuzmiVerziju;
	private JMenuBar menuBar;
	private JMenu mnGlavna;
	private JMenuItem mntmMojProfil;
	private JMenuItem mntmIzlaz;
	private JMenu mnGrupe;
	private JMenuItem mntmDodavanjeGrupe;
	private JMenuItem mntmIzmjenaGrupe;
	private JMenu mnKorisnici;
	private JMenuItem mntmDodavanjeKorisnika;
	private JMenuItem mntmBrisanjeKorisnika;
	private JMenu mnZahtjevi;
	private JMenuItem mntmDodavanjeZahtjeva;
	private JMenuItem mntmPregledZahtjeva;
	private JLabel lblIzabraniDokumentNaziv;
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
	private JEditorPane txtKomentar;
	
	final static Logger logger = Logger.getLogger(GlavnaForma.class.toString());
	
	private UnitOfWork uow = new UnitOfWork();
	private JScrollPane scrollPaneDokumenti;
	private JScrollPane scrollPaneVerzije;
	private JScrollPane scrollPaneKomentari;
	private JScrollPane scrollPaneDodajKomentar;

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
					String poruka=e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
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
	private void prikazTopMenija(){
		try {
			KorisnikDbModel korisnik =uow.getKorisnikRepository().dajKorisnika( 
					uow.getKorisnikRepository().dajIdKorisnikaPoUsername(Sesija.getUsername()));
			
			if(korisnik.getKorisnikTip() != null){
				if(korisnik.getKorisnikTip().getKorisnikTipNaziv().equals("Administrator")){
					mnGrupe.setVisible(true);
					mnKorisnici.setVisible(true);
				}
				else{
					mnGrupe.setVisible(true);
					mnKorisnici.setVisible(false);
				}
			}
			else{
				mnGrupe.setVisible(false);
				mnKorisnici.setVisible(false);
			}
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Niste ulogovani.",
					"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
			frmDobrodoaolaUDms.dispose();
			String poruka=e.getMessage();
			logger.info(poruka);
			throw new RuntimeException(e);
		}
	}
	private void otvoriProzorZaDodavanjeFoldera() {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFolderView.getLastSelectedPathComponent();

		if (node.getUserObject() instanceof DokumentDbModel) {

		}

		if (node.getUserObject() instanceof FolderDbModel) {
			FolderDbModel folder = (FolderDbModel) node.getUserObject();

			try {
				if(!uow.getFolderRepository().logovaniKorisnikImaPravoDodavanja((Integer)(int)folder.getFolderId())){
					JOptionPane.showMessageDialog(null, "Nemate pravo dodavanja ili brisanja novih stavki u odabranom folderu.",
							"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} catch (HeadlessException e1) {
				
				logger.info(e1.getMessage());
				throw new RuntimeException(e1);
			} catch (Exception e1) {
				logger.info(e1.getMessage());
				throw new RuntimeException(e1);
			}

			DodavanjeFoldera.pokreni(this, (Integer) (int) folder.getFolderId());
		}
	}
	private void otvoriProzorZaDodavanjeRootFoldera() {
		DodavanjeFoldera.pokreni(this, -1);
	}

	/*
	 * OVA METODA JE ZMAJ!!!!!
	 */
	private DefaultMutableTreeNode PopuniDrvo(DefaultMutableTreeNode roditeljNode, FolderDbModel folder) {
		System.out.println("Usao");
		List<DokumentDbModel> dokumenti = uow.getDokumentRepository()
				.dajDokumente((Integer) (int) folder.getFolderId());
		DefaultMutableTreeNode node = null;
		for (DokumentDbModel dokumentDbModel : dokumenti) {
			node = new DefaultMutableTreeNode(dokumentDbModel);
			node.setAllowsChildren(false);
			roditeljNode.add(node);
		}
		System.out.println("Dodao dokumente");
		List<FolderDbModel> podfolderi = uow.getFolderRepository().dajPodfoldere((Integer) (int) folder.getFolderId());
		if (podfolderi.size() != 0) {
			System.out.println("Dodavane podfoldera-----------------------------");
			for (FolderDbModel folderDbModel : podfolderi) {
				System.out.println("podfolderi: " + folderDbModel.getFolderNaziv());
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
	private void ucitajKomentareNaVerziju(long dokumentVerzijaId) {

		table.setModel(new DefaultTableModel(new Object[][] { },
				new String[] { "Korisnik postavio", "Vrijeme", "Komentar" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(233);

		System.out.println("Nasao komentare");
		List<KomentarDbModel> komentariNaVerziju = uow.getKomentarRepository()
				.dajKomentare((Integer) (int) dokumentVerzijaId);
		for (KomentarDbModel komentarDbModel : komentariNaVerziju) {
			Object[] row = { komentarDbModel.getKorisnik().getIme() + " " + komentarDbModel.getKorisnik().getPrezime(),
					komentarDbModel.getDatumVrijemeKomentara(), komentarDbModel.getKomentar() };

			((DefaultTableModel) table.getModel()).addRow(row);
			System.out.println("dodao: " + komentarDbModel.getKomentar());
		}
	}
	
	private void dodajKomentarNaVerziju(long dokumentVerzijaId){
		KomentarDbModel komentar = new KomentarDbModel();
		komentar.setAktivan(true);
		komentar.setDatumVrijemeKomentara(new Date());
		komentar.setDokumentVerzijaId((Integer)(int)dokumentVerzijaId);
		komentar.setKomentar(txtKomentar.getText());
		try {
			komentar.setKorisnikId(uow.getKorisnikRepository().dajIdKorisnikaPoUsername(Sesija.getUsername()));
			uow.getKomentarRepository().dodajKomentar(komentar);
		} catch (Exception e) {
						
			JOptionPane.showMessageDialog(null, "Došlo je do greške, dokument nije spašen.", "Upozorenje",
					JOptionPane.INFORMATION_MESSAGE);
			logger.info(e.getMessage());
			throw new RuntimeException(e);
			
		}
		txtKomentar.setText("");
		ucitajKomentareNaVerziju(dokumentVerzijaId);
	}

	/*
	 * Metoda puni tabelu verzija izabragog dokumenta.
	 */
	private void preuzmiVerzijuDokumenta(long dokumentVerzijaId) {
		DokumentVerzijaDbModel verzija = uow.getDokumentRepository().dajVerzijuDokumenta(dokumentVerzijaId);

		JFileChooser choser = new JFileChooser();
		choser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		choser.setDialogTitle("Odaberite mjesto za pohranu");
		if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = choser.getSelectedFile();
			
			JOptionPane.showMessageDialog(null, file.getPath(), "Obavjestenje",
					JOptionPane.INFORMATION_MESSAGE);
			
			if(verzija.getDokument()!= null){
				String putanja = file.getPath()+"\\"; //.replace("\\", "\\\\");
				
				String naziv = verzija.getDokument().getDokumentNaziv()+"_v"+verzija.getDokumentVerzijaId()+
									verzija.getDokument().getEkstenzija();
				String punaPutanja = putanja+naziv;
				
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(punaPutanja);
					fos.write(verzija.getSadrzaj());
					fos.close();
					
					Runtime.getRuntime().exec("explorer.exe /select," + punaPutanja);
				} catch (FileNotFoundException e) {
					
					JOptionPane.showMessageDialog(null, "Došlo je do greške, dokument nije spašen.", "Upozorenje",
							JOptionPane.INFORMATION_MESSAGE);
					logger.info(e.getMessage());
					throw new RuntimeException(e);
				} catch (IOException e) {
					
					JOptionPane.showMessageDialog(null, "Došlo je do greške, dokument nije spašen.", "Upozorenje",
							JOptionPane.INFORMATION_MESSAGE);
					logger.info(e.getMessage());
					throw new RuntimeException(e);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Došlo je do greške, dokument nije spašen.", "Upozorenje",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
	}

	/*
	 * Metoda puni tabelu verzija izabragog dokumenta.
	 */
	private void ucitajVerzijeDokumenta(long dokumentId) {
		
		table_1.setModel(new DefaultTableModel(
				new Object[][] {  },
				new String[] { "ID", "Postavio korisnik", "Verzija", "Vrijeme postavljanja" }));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(174);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(112);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(322);

		List<DokumentVerzijaDbModel> verzijeDokumenta = uow.getDokumentRepository()
				.dajVerzijeDokumenta((Integer) (int) dokumentId);

		System.out.println("Nasao verzije");
		for (DokumentVerzijaDbModel dokumentVerzijaDbModel : verzijeDokumenta) {
			Object[] row = { (Integer) (int) dokumentVerzijaDbModel.getDokumentVerzijaId(),
					dokumentVerzijaDbModel.getPostavioKorisnik().getIme() + " "
							+ dokumentVerzijaDbModel.getPostavioKorisnik().getPrezime(),
					"v" + dokumentVerzijaDbModel.getDokumentVerzijaId(), "22.05.2015. 22:57" };

			((DefaultTableModel) table_1.getModel()).addRow(row);
		}
	}

	private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
		for (int i = startingIndex; i < rowCount; ++i) {
			tree.expandRow(i);
		}

		if (tree.getRowCount() != rowCount) {
			expandAllNodes(tree, rowCount, tree.getRowCount());
		}
	}

	public void ucitajTreeViewModel() {
		// JOptionPane.showMessageDialog(null, "UCITAVAM MODEL", "Naziv",
		// JOptionPane.INFORMATION_MESSAGE);
		System.out.print("UCITAVAM MODEL-----------------------");
		treeFolderView.clearSelection();
		treeFolderView.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Root") {
			{
				DefaultMutableTreeNode node;
				List<FolderDbModel> pocetniFolderi = null;

				try {
					pocetniFolderi = uow.getFolderRepository().dajFoldere();
				} catch (Exception e) {
						logger.info(e.getMessage());
						throw new RuntimeException(e);
				}

				if (pocetniFolderi != null) {
					for (FolderDbModel folderDbModel : pocetniFolderi) {
						node = new DefaultMutableTreeNode(folderDbModel);
						add(PopuniDrvo(node, folderDbModel));
					}
				}
			}
		}));
		expandAllNodes(treeFolderView, 0, treeFolderView.getRowCount());
	}

	public void ucitajTreeViewModel(final String filter) {
		treeFolderView.setCellRenderer(new DefaultTreeCellRenderer() {
			private JLabel lblNull = new JLabel();

			@Override
			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean arg2, boolean arg3,
					boolean arg4, int arg5, boolean arg6) {

				Component c = super.getTreeCellRendererComponent(tree, value, arg2, arg3, arg4, arg5, arg6);

				DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
				if (matchesFilter(node)) {
					c.setForeground(Color.BLACK);
					return c;
				} else if (containsMatchingChild(node)) {
					c.setForeground(Color.GRAY);
					return c;
				} else {
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
		frmDobrodoaolaUDms.setResizable(false);
		frmDobrodoaolaUDms.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				ucitajTreeViewModel();
			}

			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		frmDobrodoaolaUDms.setTitle("Dobrodošao/la u DMS");
		frmDobrodoaolaUDms.setBounds(100, 100, 858, 510);

		frmDobrodoaolaUDms.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // samo
																				// ce
																				// se
																				// zatvorit
																				// prozor,
																				// nece
																				// sve

		frmDobrodoaolaUDms.getContentPane().setLayout(null);

		treeFolderView.setShowsRootHandles(true);
		treeFolderView.setRootVisible(false);

		treeFolderView.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); // moguce
																										// odabrati
																										// samo
																										// jednu
																										// stavku
		ucitajTreeViewModel();
		
		mnGrupe = new JMenu("Grupe");
		
		treeFolderView.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFolderView.getLastSelectedPathComponent();
				if (node != null) {
					if (node.getUserObject() instanceof DokumentDbModel) {
						DokumentDbModel dokument = (DokumentDbModel) node.getUserObject();
						lblIzabraniDokumentNaziv.setText(dokument.getDokumentNaziv()+dokument.getEkstenzija());
						ucitajVerzijeDokumenta(dokument.getDokumentId());
						
						sakrijSveOpcijeMenijaZaDrvo();
						
						mntmDodajVerzijuDokumenta.setVisible(true);
						mntmObrisiDokument.setVisible(true);
					}

					if (node.getUserObject() instanceof FolderDbModel) {
						FolderDbModel folder = (FolderDbModel) node.getUserObject();
						sakrijSveOpcijeMenijaZaDrvo();
						mntmDodajDokument_1.setVisible(true);
						mntmDodajFolder.setVisible(true);
						mntmObrisiFolder.setVisible(true);
						mntmPostavkePravaPristupa.setVisible(true);
						
					}
				}
			}
		});
		treeFolderView.setBounds(373, 440, 93, 32);

		//frmDobrodoaolaUDms.getContentPane().add(treeFolderView);

		popupMenu = new JPopupMenu();	
		addPopup(treeFolderView, popupMenu);

		mntmPostavkePravaPristupa = new JMenuItem("Postavke prava pristupa");
		mntmPostavkePravaPristupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFolderView.getLastSelectedPathComponent();
				FolderDbModel folder = null;
				if (node != null && node.getUserObject() instanceof FolderDbModel) {
					folder = (FolderDbModel) node.getUserObject();
				}
				
				if(folder == null) return;
				System.out.println(folder.getFolderId());
				FolderPravaPristupa forma = new FolderPravaPristupa(folder.getFolderId());
				forma.setVisible(true);
			}
		});
		popupMenu.add(mntmPostavkePravaPristupa);		

		mntmDodajFolder = new JMenuItem("Dodaj folder");
		mntmDodajFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				otvoriProzorZaDodavanjeFoldera();
			}
		});
		
		popupMenu.add(mntmDodajFolder);
		
		mntmObrisiFolder = new JMenuItem("Obrisi folder");
		mntmObrisiFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFolderView.getLastSelectedPathComponent();
				if (node != null) {
					if (node.getUserObject() instanceof FolderDbModel) { 

						FolderDbModel folder = (FolderDbModel) node.getUserObject();
						
						try {
							if(!uow.getFolderRepository().logovaniKorisnikImaPravoDodavanja((Integer)(int)folder.getFolderId())){
								JOptionPane.showMessageDialog(null, "Nemate pravo dodavanja ili brisanja novih stavki u odabranom folderu.",
										"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						} catch (HeadlessException e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						} catch (Exception e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						}
						
						int dialogResult = JOptionPane.showConfirmDialog (null, "Jeste li sigurni da želite obrisati?","Upozorenje",JOptionPane.INFORMATION_MESSAGE);
						if(dialogResult == JOptionPane.YES_OPTION){
							if(uow.getFolderRepository().obrisiFolder((Integer)(int)folder.getFolderId())){
								ucitajTreeViewModel();
							}
							else{
								JOptionPane.showMessageDialog(null, "Došlo je do greške, dokument se nije dodao.",
										"Greška", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
					}
				}
			}
		});
		popupMenu.add(mntmObrisiFolder);

		mntmDodajDokument_1 = new JMenuItem("Dodaj dokument");
		mntmDodajDokument_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFolderView.getLastSelectedPathComponent();
				if (node != null) {
					if (node.getUserObject() instanceof DokumentDbModel) { // dodavanje
																			// verzije
						DokumentDbModel dokument = (DokumentDbModel) node.getUserObject();
						
						try {
							if(!uow.getFolderRepository().logovaniKorisnikImaPravoDodavanja(dokument.getFolderId())){
								JOptionPane.showMessageDialog(null, "Nemate pravo dodavanja ili brisanja novih stavki u odabranom folderu.",
										"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						} catch (HeadlessException e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						} catch (Exception e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						}
						
						JFileChooser choser = new JFileChooser();
						if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
							File file = choser.getSelectedFile();
							DokumentVerzijaDbModel verzija = new DokumentVerzijaDbModel();
							verzija.setAktivan(true);
							verzija.setDokumentId((Integer) (int) dokument.getDokumentId());
							try {
								verzija.setPostavioKorisnikId(
										uow.getKorisnikRepository().dajIdKorisnikaPoUsername(Sesija.getUsername()));
							} catch (Exception e) {
								logger.info(e.getMessage());
								throw new RuntimeException(e);
							}
							Path putanja = Paths.get(file.getPath());
							try {
								verzija.setSadrzaj(Files.readAllBytes(putanja));
							} catch (IOException e) {
								
								JOptionPane.showMessageDialog(null, "Došlo je do greške, dokument se nije dodao.",
										"Greška", JOptionPane.INFORMATION_MESSAGE);
								logger.info(e.getMessage());
								throw new RuntimeException(e);
							}
							// sadrzaj
							uow.getDokumentRepository().dodajverzijuDokumenta(verzija);
							ucitajVerzijeDokumenta(dokument.getDokumentId());
							JOptionPane.showMessageDialog(null, file.getName(), "Obavjestenje",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

					if (node.getUserObject() instanceof FolderDbModel) { // dodavanje
																			// novog
																			// dokumenta
						FolderDbModel folder = (FolderDbModel) node.getUserObject();
						
						try {
							if(!uow.getFolderRepository().logovaniKorisnikImaPravoDodavanja((Integer)(int)folder.getFolderId())){
								JOptionPane.showMessageDialog(null, "Nemate pravo dodavanja ili brisanja novih stavki u odabranom folderu.",
										"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						} catch (HeadlessException e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						} catch (Exception e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						}
						
						JFileChooser choser = new JFileChooser();
						if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
							File file = choser.getSelectedFile();
							DokumentDbModel dokument = new DokumentDbModel();
							int pozicija = file.getName().lastIndexOf('.');
							dokument.setDokumentNaziv(file.getName().substring(0, pozicija));

							dokument.setEkstenzija(file.getName().substring(pozicija));
							dokument.setFolderId((Integer) (int) folder.getFolderId());
							dokument.setAktivan(true);

							Path putanja = Paths.get(file.getPath());

							try {
								byte[] sadrzaj = Files.readAllBytes(putanja);
								uow.getDokumentRepository().dodajDokument(dokument, sadrzaj);
							} catch (IOException e) {
								
								JOptionPane.showMessageDialog(null, "Došlo je do greške, dokument se nije dodao.",
										"Greška", JOptionPane.INFORMATION_MESSAGE);
								logger.info(e.getMessage());
								throw new RuntimeException(e);
							}

							ucitajTreeViewModel();
							JOptionPane.showMessageDialog(null, file.getName(), "Obavjestenje",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}

			}
		});
		popupMenu.add(mntmDodajDokument_1);

		mntmObrisiDokument = new JMenuItem("Obrisi dokument");
		mntmObrisiDokument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFolderView.getLastSelectedPathComponent();
				if (node != null) {
					if (node.getUserObject() instanceof DokumentDbModel) { // dodavanje
																			// verzije
						DokumentDbModel dokument = (DokumentDbModel) node.getUserObject();
						
						try {
							if(!uow.getFolderRepository().logovaniKorisnikImaPravoDodavanja(dokument.getFolderId())){
								JOptionPane.showMessageDialog(null, "Nemate pravo dodavanja ili brisanja novih stavki u odabranom folderu.",
										"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						} catch (HeadlessException e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						} catch (Exception e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						}
						
						int dialogResult = JOptionPane.showConfirmDialog (null, "Jeste li sigurni da želite obrisati?","Upozorenje",JOptionPane.INFORMATION_MESSAGE);
						if(dialogResult == JOptionPane.YES_OPTION){
							if(uow.getDokumentRepository().obrisiDokument((Integer)(int)dokument.getDokumentId())){
								ucitajTreeViewModel();
							}
							else{
								JOptionPane.showMessageDialog(null, "Došlo je do greške, dokument se nije dodao.",
										"Greška", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
					}
				}
			}
		});
		popupMenu.add(mntmObrisiDokument);

		mntmDodajVerzijuDokumenta = new JMenuItem("Dodaj verziju dokumenta");
		mntmDodajVerzijuDokumenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFolderView.getLastSelectedPathComponent();
				if (node != null) {
					if (node.getUserObject() instanceof DokumentDbModel) { // dodavanje
																			// verzije
						DokumentDbModel dokument = (DokumentDbModel) node.getUserObject();
						
						try {
							if(!uow.getFolderRepository().logovaniKorisnikImaPravoDodavanja(dokument.getFolderId())){
								JOptionPane.showMessageDialog(null, "Nemate pravo dodavanja ili brisanja novih stavki u odabranom folderu.",
										"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						} catch (HeadlessException e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						} catch (Exception e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						}
						
						JFileChooser choser = new JFileChooser();
						if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
							File file = choser.getSelectedFile();
							DokumentVerzijaDbModel verzija = new DokumentVerzijaDbModel();
							verzija.setAktivan(true);
							verzija.setDokumentId((Integer) (int) dokument.getDokumentId());
							try {
								verzija.setPostavioKorisnikId(
										uow.getKorisnikRepository().dajIdKorisnikaPoUsername(Sesija.getUsername()));
							} catch (Exception e) {
								logger.info(e.getMessage());
								throw new RuntimeException(e);
							}
							Path putanja = Paths.get(file.getPath());
							try {
								verzija.setSadrzaj(Files.readAllBytes(putanja));
							} catch (IOException e) {
								logger.info(e.getMessage());
								throw new RuntimeException(e);
							}
							// sadrzaj
							uow.getDokumentRepository().dodajverzijuDokumenta(verzija);
							ucitajVerzijeDokumenta(dokument.getDokumentId());
						}
					}
				}
			}
		});
		popupMenu.add(mntmDodajVerzijuDokumenta);
		
		sakrijSveOpcijeMenijaZaDrvo();

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(
				new DefaultTableModel(new Object[][] { }
				, new String[] { "Korisnik postavio", "Vrijeme", "Komentar" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(233);
		table.setBounds(363, 326, 469, 41);
		//frmDobrodoaolaUDms.getContentPane().add(table);
		
		try {
			KorisnikDbModel korisnik =uow.getKorisnikRepository().dajKorisnika( 
					uow.getKorisnikRepository().dajIdKorisnikaPoUsername(Sesija.getUsername()));
			String podaci = "Moji dokumenti: ";
			if(korisnik != null)
				podaci += korisnik.getIme()+" "+korisnik.getPrezime();
			
			if(korisnik.getKorisnikPozicija() != null)
				podaci+= ", "+korisnik.getKorisnikPozicija().getKorisnikPozicijaNaziv();
			lblMojiPodaci = new JLabel(podaci);
		} catch (Exception e2) {

			JOptionPane.showMessageDialog(null, "Niste logovani.",
					"Greška", JOptionPane.INFORMATION_MESSAGE);
			frmDobrodoaolaUDms.dispose();
			logger.info(e2.getMessage());
			throw new RuntimeException(e2);
		}
		
		if(lblMojiPodaci == null)
			lblMojiPodaci = new JLabel("");
		
		lblMojiPodaci.setBounds(363, 28, 318, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblMojiPodaci);

		lblKomentari = new JLabel("Komentari za izabranu verziju");
		lblKomentari.setBounds(363, 233, 177, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblKomentari);

		btnDodajKomentar = new JButton("Dodaj komentar");
		btnDodajKomentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer verzijaId = null; 
				 try { 
					 verzijaId = (Integer)table_1.getValueAt(table_1.getSelectedRow(), 0);
					 dodajKomentarNaVerziju((long)(int)verzijaId); 
				 } 
				 catch (Exception e) {
					 table.setModel(new DefaultTableModel(new Object[][] { },
								new String[] { "Korisnik postavio", "Vrijeme", "Komentar" }));
						table.getColumnModel().getColumn(0).setPreferredWidth(115);
						table.getColumnModel().getColumn(1).setPreferredWidth(112);
						table.getColumnModel().getColumn(2).setPreferredWidth(233);
						logger.info(e.getMessage());
						throw new RuntimeException(e);
				 }
			}
		});
		btnDodajKomentar.setBounds(685, 447, 157, 23);
		frmDobrodoaolaUDms.getContentPane().add(btnDodajKomentar);

		btnDodajRootFolder = new JButton("Dodaj root folder");
		btnDodajRootFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				otvoriProzorZaDodavanjeRootFoldera();
			}
		});
		btnDodajRootFolder.setBounds(709, 24, 136, 23);
		frmDobrodoaolaUDms.getContentPane().add(btnDodajRootFolder);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Integer verzijaId = null; 
				 try { 
					 verzijaId = (Integer)table_1.getValueAt(table_1.getSelectedRow(), 0);
					 ucitajKomentareNaVerziju((long)(int)verzijaId); 
					 } 
				 catch (Exception e) {
					 logger.info(e.getMessage());
					 throw new RuntimeException(e);
				 }
			}
		});
		table_1.setModel(new DefaultTableModel(
				new Object[][] { },
				new String[] { "ID", "Postavio korisnik", "Verzija", "Vrijeme postavljanja" } ));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(174);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(112);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(322);
		table_1.setBounds(363, 132, 469, 82);
		//frmDobrodoaolaUDms.getContentPane().add(table_1);

		lblVerzijeIzabranogDokumenta = new JLabel("Verzije dokumenta: ");
		lblVerzijeIzabranogDokumenta.setBounds(363, 53, 123, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblVerzijeIzabranogDokumenta);

		btnDodajVerziju = new JButton("Dodaj verziju");
		btnDodajVerziju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) treeFolderView.getLastSelectedPathComponent();
				if (node != null) {
					if (node.getUserObject() instanceof DokumentDbModel) { // dodavanje
																			// verzije
						DokumentDbModel dokument = (DokumentDbModel) node.getUserObject();
						
						try {
							if(!uow.getFolderRepository().logovaniKorisnikImaPravoDodavanja(dokument.getFolderId())){
								JOptionPane.showMessageDialog(null, "Nemate pravo dodavanja ili brisanja novih stavki u odabranom folderu.",
										"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						} catch (HeadlessException e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						} catch (Exception e1) {
							logger.info(e1.getMessage());
							throw new RuntimeException(e1);
						}
						
						JFileChooser choser = new JFileChooser();
						if (choser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
							File file = choser.getSelectedFile();
							DokumentVerzijaDbModel verzija = new DokumentVerzijaDbModel();
							verzija.setAktivan(true);
							verzija.setDokumentId((Integer) (int) dokument.getDokumentId());
							try {
								verzija.setPostavioKorisnikId(
										uow.getKorisnikRepository().dajIdKorisnikaPoUsername(Sesija.getUsername()));
							} catch (Exception e1) {
								logger.info(e1.getMessage());
								throw new RuntimeException(e1);
							}
							Path putanja = Paths.get(file.getPath());
							try {
								verzija.setSadrzaj(Files.readAllBytes(putanja));
							} catch (IOException e1) {
								logger.info(e1.getMessage());
								throw new RuntimeException(e1);
							}
							// sadrzaj
							uow.getDokumentRepository().dodajverzijuDokumenta(verzija);
							ucitajVerzijeDokumenta(dokument.getDokumentId());
							
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Molimo odaberite dokument iz pregleda dokumenata.", "Obavjestenje",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnDodajVerziju.setBounds(586, 224, 123, 23);
		frmDobrodoaolaUDms.getContentPane().add(btnDodajVerziju);

		btnPreuzmiVerziju = new JButton("Preuzmi");
		btnPreuzmiVerziju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 Integer verzijaId = null; 
				 try { 
					 verzijaId = (Integer)table_1.getValueAt(table_1.getSelectedRow(), 0);
					 preuzmiVerzijuDokumenta((long)(int)verzijaId); 
					 } 
				 catch (Exception e) {
				 JOptionPane.showMessageDialog(null, "Nista", "Naziv",
						 			JOptionPane.INFORMATION_MESSAGE); 
				 logger.info(e.getMessage());
					throw new RuntimeException(e);
				 }
				 
			}
		});
		btnPreuzmiVerziju.setBounds(719, 224, 123, 23);
		frmDobrodoaolaUDms.getContentPane().add(btnPreuzmiVerziju);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 852, 21);
		frmDobrodoaolaUDms.getContentPane().add(menuBar);

		mnGlavna = new JMenu("Glavna");
		menuBar.add(mnGlavna);

		mntmMojProfil = new JMenuItem("Moj profil");
		mntmMojProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfilKorisnika forma = new ProfilKorisnika();
				forma.PokreniFormu();
			}
		});
		mnGlavna.add(mntmMojProfil);

		mntmIzlaz = new JMenuItem("Izlaz");
		mntmIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDobrodoaolaUDms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmDobrodoaolaUDms.dispatchEvent(new WindowEvent(frmDobrodoaolaUDms, WindowEvent.WINDOW_CLOSING));
			}
		});
		mnGlavna.add(mntmIzlaz);

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
		mntmBrisanjeKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IzmjenaKorisnika izmjenaKorisnikaForma= new IzmjenaKorisnika();
				izmjenaKorisnikaForma.pokreniFormu();
			}
		});
		mnKorisnici.add(mntmBrisanjeKorisnika);

		mnZahtjevi = new JMenu("Zahtjevi");
		menuBar.add(mnZahtjevi);

		mntmPregledZahtjeva = new JMenuItem("Pregled zahtjeva");
		mnZahtjevi.add(mntmPregledZahtjeva);

		mntmDodavanjeZahtjeva = new JMenuItem("Dodavanje zahtjeva");
		mnZahtjevi.add(mntmDodavanjeZahtjeva);
		
		JMenu mnNewMenu = new JMenu("Izvještaji");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pregled izvještaja");
		mnNewMenu.add(mntmNewMenuItem);
		
		//prikaz menija zavisno od tipa korisnika
		prikazTopMenija();
		
		lblIzabraniDokumentNaziv = new JLabel("");
		lblIzabraniDokumentNaziv.setBounds(492, 53, 177, 14);
		frmDobrodoaolaUDms.getContentPane().add(lblIzabraniDokumentNaziv);

		txtKomentar = new JEditorPane();
		txtKomentar.setToolTipText("Unesite tekst komentara..");
		txtKomentar.setBounds(363, 437, 265, 23);
		//frmDobrodoaolaUDms.getContentPane().add(txtKomentar);

		txtPretraga = new JTextField();
		txtPretraga.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (!txtPretraga.getText().equals("")) {
					// JOptionPane.showMessageDialog(null, "Filtriram", "Naziv",
					// JOptionPane.INFORMATION_MESSAGE);
					ucitajTreeViewModel(txtPretraga.getText());
				} else {
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
		
		scrollPaneDokumenti = new JScrollPane();
		scrollPaneDokumenti.setBounds(10, 53, 343, 417);
		//scrollPaneDokumenti.add(treeFolderView);
		scrollPaneDokumenti.setViewportView(treeFolderView);
		
		frmDobrodoaolaUDms.getContentPane().add(scrollPaneDokumenti);
		
		scrollPaneVerzije = new JScrollPane();
		scrollPaneVerzije.setBounds(363, 75, 482, 138);
		scrollPaneVerzije.setViewportView(table_1);
		frmDobrodoaolaUDms.getContentPane().add(scrollPaneVerzije);
		
		scrollPaneKomentari = new JScrollPane();
		scrollPaneKomentari.setBounds(363, 258, 482, 118);
		scrollPaneKomentari.setViewportView(table);
		frmDobrodoaolaUDms.getContentPane().add(scrollPaneKomentari);
		
		scrollPaneDodajKomentar = new JScrollPane();
		scrollPaneDodajKomentar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDodajKomentar.setBounds(363, 387, 482, 49);
		scrollPaneDodajKomentar.setViewportView(txtKomentar);
		frmDobrodoaolaUDms.getContentPane().add(scrollPaneDodajKomentar);
		
		
	}

	private void sakrijSveOpcijeMenijaZaDrvo() {
		mntmPostavkePravaPristupa.setVisible(false);
		mntmDodajDokument_1.setVisible(false);
		mntmObrisiDokument.setVisible(false);
		mntmObrisiDokument.setVisible(false);
		mntmDodajVerzijuDokumenta.setVisible(false);
		
		mntmDodajFolder.setVisible(false);
		mntmObrisiFolder.setVisible(false);
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
