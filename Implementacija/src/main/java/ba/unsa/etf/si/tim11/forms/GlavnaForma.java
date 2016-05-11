package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField textField_1;

	
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDobrodoaolaUDms = new JFrame();
		frmDobrodoaolaUDms.setTitle("Dobrodošao/la u DMS");
		frmDobrodoaolaUDms.setBounds(100, 100, 858, 510);

		frmDobrodoaolaUDms.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //samo ce se zatvorit prozor, nece sve
		
		frmDobrodoaolaUDms.getContentPane().setLayout(null);
		
		JTree treeFolderView = new JTree();
		treeFolderView.setShowsRootHandles(true);
		treeFolderView.setRootVisible(false);
		
		
		
		
		treeFolderView.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2; 
					
					List<FolderDbModel> pocetniFolderi = null;
					
					try {
						pocetniFolderi = uow.getFolderRepository().dajFoldere();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "GRESKA", JOptionPane.INFORMATION_MESSAGE);
						e.printStackTrace();
					}
					for (FolderDbModel folderDbModel : pocetniFolderi) {
						node_1 = new DefaultMutableTreeNode(folderDbModel);
						add(node_1);
					}
					node_1 = new DefaultMutableTreeNode("faktura1.txt");
					add(node_1);
					
					try {
						JOptionPane.showMessageDialog(null, Sesija.getUsername().toString(), "GRESKA", JOptionPane.INFORMATION_MESSAGE);
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					/*node_1 = new DefaultMutableTreeNode("Racunovodstvo");
						node_2 = new DefaultMutableTreeNode("fakture");
							node_2.add(new DefaultMutableTreeNode("faktura1.txt"));
							node_2.add(new DefaultMutableTreeNode("faktura1.txt"));
							node_2.add(new DefaultMutableTreeNode("faktura1.txt"));
						node_1.add(node_2); 
						node_2 = new DefaultMutableTreeNode("Ugovori");
							node_2.add(new DefaultMutableTreeNode("ugovor1.docx"));
							node_2.add(new DefaultMutableTreeNode("ugovor2.docx"));
							node_2.add(new DefaultMutableTreeNode("ugovor3.docx"));
							node_2.add(new DefaultMutableTreeNode("ugovor4.docx"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Menadzment");
						node_2 = new DefaultMutableTreeNode("Upiti");
							node_2.add(new DefaultMutableTreeNode("Zahtjev za ugovor1.docx"));
							node_2.add(new DefaultMutableTreeNode("Zahtjev za ugovor2.docx"));
							node_2.add(new DefaultMutableTreeNode("Zahtjev za ugovor3.docx"));
							node_2.add(new DefaultMutableTreeNode("Zahtjev za ugovor4.docx"));
						node_1.add(node_2);
					add(node_1);*/
				}
			}
		));
		treeFolderView.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION); //moguce odabrati samo jednu stavku
		
		treeFolderView.setBounds(10, 53, 343, 407);
		frmDobrodoaolaUDms.getContentPane().add(treeFolderView);
		
		popupMenu = new JPopupMenu();
		addPopup(treeFolderView, popupMenu);
		
		mntmPostavkePravaPristupa = new JMenuItem("Postavke prava pristupa");
		popupMenu.add(mntmPostavkePravaPristupa);
		
		mntmDodajFolder = new JMenuItem("Dodaj folder");
		popupMenu.add(mntmDodajFolder);
		
		mntmObrisiFolder = new JMenuItem("Obrisi folder");
		popupMenu.add(mntmObrisiFolder);
		
		mntmDodajDokument_1 = new JMenuItem("Dodaj dokument");
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
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
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
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Postavio korisnik", "Verzija", "Vrijeme postavljanja"},
				{"Abid Sakalas", "v22", "22.05.2015. 22:35"},
				{"Buto Devijanovic", "v23", "22.05.2015. 22:57"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(174);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(112);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(322);
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
		mnGrupe.add(mntmDodavanjeGrupe);
		
		mntmIzmjenaGrupe = new JMenuItem("Izmjena grupe");
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(81, 25, 272, 20);
		frmDobrodoaolaUDms.getContentPane().add(textField_1);
		
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
