//package ba.unsa.etf.si.tim11.forms;
//
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JSeparator;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.JTree;
//import javax.swing.ListSelectionModel;
//import javax.swing.SwingConstants;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.DefaultTreeModel;
//
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
//import com.toedter.calendar.JCalendar;

//public class MuhaTest {
//
//	private JFrame frame;
//	
//	private JTextField textFieldPretragaKorisnika;
//	private JTable tableKorisnici;
//	private JPasswordField passwordFieldNovaSifra;
//	private JPasswordField passwordFieldPonovi;
//	private JTextField textField;
//	private JTable tableBrisanjeKorisnika;
//	private JTextField textFieldNazivGrupe;
//	private JTable tableKorisniciGrupe;
//	private JTextField textFieldPretragaGrupe;
//	private JTextField textField_1PretragaKorisnikaIzmjenaGrupe;
//	private JTable tableIzmjenaKorisnikaUGrupi;
//	private JTextField textFieldIme;
//	private JTextField textFieldPrezime;
//	private JTextField textFieldAdresa;
//	private JTextField textFieldPretragaKorisnikaZahtjev;
//	private JTable table;
//	private JTextField textFieldPretragDokumenata;
//	private JTable table_1;
//	private JTextField textFieldPoruka;
//	private JTextField textField_1;
//	private JTextField textFieldPrikazIzabranogDokumenta;
//	private JTextField textFieldNazivDokumenta;
//	private JTextField textFieldKomentar;
//	private JTable table_2;
//	private JTextField textField_2;
//	private JTable table_3;
//	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MuhaTest window = new MuhaTest();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public MuhaTest() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize()
//	{
//		frame = new JFrame();
//		frame.setBounds(100, 100, 1350, 832);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setFont(new Font("Dialog", Font.PLAIN, 16));
//		frame.setJMenuBar(menuBar);
//		
//		JMenu mnDatoteka = new JMenu("Datoteka");
//		mnDatoteka.setFont(new Font("Dialog", Font.PLAIN, 16));
//		menuBar.add(mnDatoteka);
//		
//		JMenuItem mntmIzlaz = new JMenuItem("Izlaz");
//		mntmIzlaz.setHorizontalAlignment(SwingConstants.RIGHT);
//		mntmIzlaz.setFont(new Font("Dialog", Font.PLAIN, 16));
//		mnDatoteka.add(mntmIzlaz);
//		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),}));
//		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
//		tabbedPane.setFont(new Font("Dialog", Font.PLAIN, 16));
//		frame.getContentPane().add(tabbedPane, "2, 2, fill, fill");
//		
//		JPanel panel = new JPanel();
//		panel.setToolTipText("");
//		tabbedPane.addTab("Dodavanje Korisnika", null, panel, null);
//		panel.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("pref:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.MIN_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.MIN_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		JLabel lblIme = new JLabel("Ime:");
//		lblIme.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel.add(lblIme, "10, 6, right, default");
//		
//		textFieldIme = new JTextField();
//		textFieldIme.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel.add(textFieldIme, "12, 6, fill, default");
//		textFieldIme.setColumns(10);
//		
//		JSeparator separator = new JSeparator();
//		separator.setOrientation(SwingConstants.VERTICAL);
//		panel.add(separator, "62, 6, 1, 2");
//		
//		JLabel lblPrezime = new JLabel("Prezime:");
//		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblPrezime.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel.add(lblPrezime, "10, 12, right, default");
//		
//		textFieldPrezime = new JTextField();
//		textFieldPrezime.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel.add(textFieldPrezime, "12, 12, fill, default");
//		textFieldPrezime.setColumns(10);
//		
//		JLabel lblAdresa = new JLabel("Adresa:");
//		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblAdresa.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel.add(lblAdresa, "10, 18, right, default");
//		
//		textFieldAdresa = new JTextField();
//		textFieldAdresa.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel.add(textFieldAdresa, "12, 18, fill, default");
//		textFieldAdresa.setColumns(10);
//		
//		JLabel lblDatumroenja = new JLabel("Datum Ro\u0111enja:");
//		lblDatumroenja.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblDatumroenja.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel.add(lblDatumroenja, "10, 24");
//		
//		JCalendar calendar = new JCalendar();
//		panel.add(calendar, "12, 24, left, top");
//		
//		JLabel lblPozicijaUOrganizaciji = new JLabel("Pozicija u Organizaciji:");
//		lblPozicijaUOrganizaciji.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblPozicijaUOrganizaciji.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel.add(lblPozicijaUOrganizaciji, "10, 28");
//		
//		JComboBox comboBoxPozicijaUOrg = new JComboBox();
//		comboBoxPozicijaUOrg.setModel(new DefaultComboBoxModel(new String[] {"\u0160ef", "Administrator", "Radnik"}));
//		comboBoxPozicijaUOrg.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel.add(comboBoxPozicijaUOrg, "12, 28, fill, default");
//		
//		JButton btnDodajKorisnika = new JButton("Dodaj Korisnika");
//		btnDodajKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel.add(btnDodajKorisnika, "12, 32, right, default");
//		
//		JPanel panel_1 = new JPanel();
//		tabbedPane.addTab("Izmjena Korisnika", null, panel_1, null);
//		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("max(102dlu;default):grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.MIN_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.MIN_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		tableKorisnici = new JTable();
//		tableKorisnici.setCellSelectionEnabled(true);
//		tableKorisnici.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		tableKorisnici.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"},
//				{null, "", null, null, null, null},
//			},
//			new String[] {
//				"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, String.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//			boolean[] columnEditables = new boolean[] {
//				false, true, true, true, true, true
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
//		tableKorisnici.getColumnModel().getColumn(4).setPreferredWidth(87);
//		tableKorisnici.getColumnModel().getColumn(5).setPreferredWidth(115);
//		
//		JLabel lblIzaberiteKorisnika = new JLabel("Pretraga Korisnika:");
//		lblIzaberiteKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblIzaberiteKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_1.add(lblIzaberiteKorisnika, "16, 8");
//		
//		textFieldPretragaKorisnika = new JTextField();
//		textFieldPretragaKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_1.add(textFieldPretragaKorisnika, "20, 8, fill, default");
//		textFieldPretragaKorisnika.setColumns(10);
//		
//		JButton btnTraziIzmjenaKorisnika = new JButton("Tra\u017Ei");
//		btnTraziIzmjenaKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_1.add(btnTraziIzmjenaKorisnika, "22, 8");
//		tableKorisnici.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_1.add(tableKorisnici, "13, 14, 8, 1, fill, fill");
//		
//		JLabel lblNovaifra = new JLabel("Nova \u0160ifra:");
//		lblNovaifra.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblNovaifra.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_1.add(lblNovaifra, "16, 18");
//		
//		passwordFieldNovaSifra = new JPasswordField();
//		passwordFieldNovaSifra.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_1.add(passwordFieldNovaSifra, "20, 18, fill, default");
//		
//		JLabel lblPonoviifru = new JLabel("Ponovi \u0160ifru:");
//		lblPonoviifru.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblPonoviifru.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_1.add(lblPonoviifru, "16, 22");
//		
//		passwordFieldPonovi = new JPasswordField();
//		passwordFieldPonovi.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_1.add(passwordFieldPonovi, "20, 22, fill, default");
//		
//		JButton btnIzmijeniPodatke = new JButton("Izmijeni Podatke");
//		btnIzmijeniPodatke.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_1.add(btnIzmijeniPodatke, "20, 28, right, default");
//		
//		JSeparator separator_2 = new JSeparator();
//		panel_1.add(separator_2, "2, 42, 52, 1");
//		
//		JPanel panel_2 = new JPanel();
//		tabbedPane.addTab("Brisanje Korisnika", null, panel_2, null);
//		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.MIN_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		JLabel lblPretragaKorisnika = new JLabel("Pretraga Korisnika:");
//		lblPretragaKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_2.add(lblPretragaKorisnika, "20, 8, right, default");
//		
//		textField = new JTextField();
//		textField.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_2.add(textField, "22, 8, 7, 1, fill, default");
//		textField.setColumns(10);
//		
//		tableBrisanjeKorisnika = new JTable();
//		tableBrisanjeKorisnika.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"},
//			},
//			new String[] {
//				"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				Object.class, String.class, String.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		tableBrisanjeKorisnika.getColumnModel().getColumn(0).setPreferredWidth(91);
//		tableBrisanjeKorisnika.getColumnModel().getColumn(4).setPreferredWidth(99);
//		tableBrisanjeKorisnika.getColumnModel().getColumn(5).setPreferredWidth(133);
//		
//		JButton btnTraziBrisanjeKorisnika = new JButton("Tra\u017Ei");
//		btnTraziBrisanjeKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_2.add(btnTraziBrisanjeKorisnika, "30, 8");
//		tableBrisanjeKorisnika.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//		tableBrisanjeKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		tableBrisanjeKorisnika.setCellSelectionEnabled(true);
//		panel_2.add(tableBrisanjeKorisnika, "18, 12, 13, 17, fill, fill");
//		
//		JButton btnIzbriiKorisnika = new JButton("Izbri\u0161i Korisnika");
//		btnIzbriiKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_2.add(btnIzbriiKorisnika, "30, 32");
//		
//		JPanel panel_3 = new JPanel();
//		tabbedPane.addTab("Kreiranje Grupa", null, panel_3, null);
//		panel_3.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.MIN_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		JLabel lblNazivGrupe = new JLabel("Naziv Grupe:");
//		lblNazivGrupe.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblNazivGrupe.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_3.add(lblNazivGrupe, "16, 6");
//		
//		textFieldNazivGrupe = new JTextField();
//		panel_3.add(textFieldNazivGrupe, "18, 6, 35, 1, fill, default");
//		textFieldNazivGrupe.setColumns(10);
//		
//		JSeparator separator_1 = new JSeparator();
//		separator_1.setOrientation(SwingConstants.VERTICAL);
//		panel_3.add(separator_1, "92, 8, 1, 3");
//		
//		JLabel lblOpisGrupe = new JLabel("Opis Grupe:");
//		lblOpisGrupe.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblOpisGrupe.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_3.add(lblOpisGrupe, "16, 10");
//		
//		JTextArea textAreaOpis = new JTextArea();
//		textAreaOpis.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_3.add(textAreaOpis, "18, 10, 35, 1, fill, fill");
//		
//		JLabel lblPretragaKorisnika_1 = new JLabel("Pretraga Korisnika:");
//		lblPretragaKorisnika_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblPretragaKorisnika_1.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_3.add(lblPretragaKorisnika_1, "16, 14");
//		
//		textFieldPretragaGrupe = new JTextField();
//		textFieldPretragaGrupe.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_3.add(textFieldPretragaGrupe, "18, 14, 35, 1, fill, default");
//		textFieldPretragaGrupe.setColumns(10);
//		
//		JButton btnTraziKreiranje = new JButton("Tra\u017Ei");
//		btnTraziKreiranje.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_3.add(btnTraziKreiranje, "54, 14");
//		
//		JLabel lblKorisnici = new JLabel("Korisnici:");
//		lblKorisnici.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblKorisnici.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_3.add(lblKorisnici, "16, 18");
//		
//		tableKorisniciGrupe = new JTable();
//		tableKorisniciGrupe.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Korisni\u010Dko Ime", "Ime", "Prezime", "Prezime", "Datum Ro\u0111enja", "Pozicija u Organizaciji"},
//			},
//			new String[] {
//				"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, String.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		tableKorisniciGrupe.getColumnModel().getColumn(0).setPreferredWidth(131);
//		tableKorisniciGrupe.getColumnModel().getColumn(4).setPreferredWidth(89);
//		tableKorisniciGrupe.getColumnModel().getColumn(5).setPreferredWidth(121);
//		panel_3.add(tableKorisniciGrupe, "18, 18, 37, 9, fill, fill");
//		
//		JButton btnDodajKorisnike = new JButton("Dodaj Korisnika:");
//		btnDodajKorisnike.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_3.add(btnDodajKorisnike, "54, 30");
//		
//		JLabel lblPravaPristupa = new JLabel("Prava pristupa:");
//		lblPravaPristupa.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblPravaPristupa.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_3.add(lblPravaPristupa, "16, 34");
//		
//		JCheckBox chckbxPostavljanjeKreiranje = new JCheckBox("Postavljanje");
//		chckbxPostavljanjeKreiranje.setHorizontalAlignment(SwingConstants.RIGHT);
//		chckbxPostavljanjeKreiranje.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_3.add(chckbxPostavljanjeKreiranje, "28, 34");
//		
//		JCheckBox chckbxSkidanjeKreiranje = new JCheckBox("Skidanje");
//		chckbxSkidanjeKreiranje.setFont(new Font("Dialog", Font.PLAIN, 16));
//		chckbxSkidanjeKreiranje.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_3.add(chckbxSkidanjeKreiranje, "42, 34");
//		
//		JButton btnKreirajGrupu = new JButton("Kreiraj Grupu:");
//		btnKreirajGrupu.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_3.add(btnKreirajGrupu, "54, 40");
//		
//		JSeparator separator_3 = new JSeparator();
//		panel_3.add(separator_3, "20, 56, 48, 1");
//		
//		JPanel panel_4 = new JPanel();
//		tabbedPane.addTab("Izmjena Grupe", null, panel_4, null);
//		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		JLabel lblIzborGrupe = new JLabel("Izbor grupe:");
//		lblIzborGrupe.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblIzborGrupe.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(lblIzborGrupe, "20, 8");
//		
//		JComboBox comboBoxIzborGrupeIzmjena = new JComboBox();
//		comboBoxIzborGrupeIzmjena.setModel(new DefaultComboBoxModel(new String[] {"Grupa 1", "Grupa 2", "Grupa 3"}));
//		comboBoxIzborGrupeIzmjena.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(comboBoxIzborGrupeIzmjena, "24, 8, 27, 1, fill, default");
//		
//		JLabel lblNewLabel = new JLabel("Pretraga korisnika:");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(lblNewLabel, "20, 14");
//		
//		textField_1PretragaKorisnikaIzmjenaGrupe = new JTextField();
//		textField_1PretragaKorisnikaIzmjenaGrupe.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(textField_1PretragaKorisnikaIzmjenaGrupe, "24, 14, 27, 1, fill, default");
//		textField_1PretragaKorisnikaIzmjenaGrupe.setColumns(10);
//		
//		JButton btnTraziKorisIzmjena = new JButton("Tra\u017Ei");
//		panel_4.add(btnTraziKorisIzmjena, "54, 14");
//		
//		JCheckBox chckbxlanGrupe = new JCheckBox("\u010Clan Grupe");
//		chckbxlanGrupe.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(chckbxlanGrupe, "26, 18");
//		
//		JSeparator separator_4 = new JSeparator();
//		separator_4.setOrientation(SwingConstants.VERTICAL);
//		panel_4.add(separator_4, "62, 20");
//		
//		JLabel lblKorisnici_1 = new JLabel("Korisnici:");
//		lblKorisnici_1.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblKorisnici_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(lblKorisnici_1, "20, 22");
//		
//		tableIzmjenaKorisnikaUGrupi = new JTable();
//		tableIzmjenaKorisnikaUGrupi.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"},
//			},
//			new String[] {
//				"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, String.class, String.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//			boolean[] columnEditables = new boolean[] {
//				false, false, false, false, false, false
//			};
//			public boolean isCellEditable(int row, int column) {
//				return columnEditables[column];
//			}
//		});
//		tableIzmjenaKorisnikaUGrupi.getColumnModel().getColumn(0).setPreferredWidth(95);
//		tableIzmjenaKorisnikaUGrupi.getColumnModel().getColumn(4).setPreferredWidth(91);
//		tableIzmjenaKorisnikaUGrupi.getColumnModel().getColumn(5).setPreferredWidth(119);
//		tableIzmjenaKorisnikaUGrupi.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(tableIzmjenaKorisnikaUGrupi, "24, 22, 27, 9, fill, fill");
//		
//		JLabel lblIzmijenaPravaPristupa = new JLabel("Izmijena Prava Pristupa:");
//		lblIzmijenaPravaPristupa.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblIzmijenaPravaPristupa.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_4.add(lblIzmijenaPravaPristupa, "20, 34");
//		
//		JCheckBox chckbxPostavljanjeIzmjena = new JCheckBox("Postavljanje");
//		chckbxPostavljanjeIzmjena.setFont(new Font("Dialog", Font.PLAIN, 16));
//		chckbxPostavljanjeIzmjena.setHorizontalAlignment(SwingConstants.LEFT);
//		panel_4.add(chckbxPostavljanjeIzmjena, "26, 34, left, top");
//		
//		JCheckBox chckbxSkidanjeIzmjena = new JCheckBox("Skidanje");
//		chckbxSkidanjeIzmjena.setHorizontalAlignment(SwingConstants.LEFT);
//		chckbxSkidanjeIzmjena.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(chckbxSkidanjeIzmjena, "32, 34");
//		
//		JButton btnIzmijeniKorisnika = new JButton("Izmijeni Korisnika");
//		btnIzmijeniKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(btnIzmijeniKorisnika, "48, 34");
//		
//		JLabel lblDodavanjeKorisnika = new JLabel("Dodavanje Korisnika:");
//		lblDodavanjeKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblDodavanjeKorisnika.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(lblDodavanjeKorisnika, "20, 38");
//		
//		JCheckBox chckbxPostavljanjeDodaj = new JCheckBox("Postavljanje");
//		chckbxPostavljanjeDodaj.setFont(new Font("Dialog", Font.PLAIN, 16));
//		chckbxPostavljanjeDodaj.setHorizontalAlignment(SwingConstants.LEFT);
//		panel_4.add(chckbxPostavljanjeDodaj, "26, 38");
//		
//		JCheckBox chckbxSkidanjeDodaj = new JCheckBox("Skidanje");
//		chckbxSkidanjeDodaj.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(chckbxSkidanjeDodaj, "32, 38");
//		
//		JButton btnDodajKorisnikaIzmjenaGrupe = new JButton("Dodaj Korisnika");
//		btnDodajKorisnikaIzmjenaGrupe.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		btnDodajKorisnikaIzmjenaGrupe.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(btnDodajKorisnikaIzmjenaGrupe, "48, 38");
//		
//		JLabel lblBrisanjeGrupe = new JLabel("Brisanje Grupe:");
//		lblBrisanjeGrupe.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblBrisanjeGrupe.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_4.add(lblBrisanjeGrupe, "20, 50");
//		
//		JCheckBox chckbxOmoguiBrisanje = new JCheckBox("Omogu\u0107i Brisanje");
//		chckbxOmoguiBrisanje.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(chckbxOmoguiBrisanje, "26, 50");
//		
//		JButton btnObriiGrupu = new JButton("Obri\u0161i Grupu");
//		btnObriiGrupu.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_4.add(btnObriiGrupu, "48, 50");
//		
//		JPanel panel_5 = new JPanel();
//		tabbedPane.addTab("Zahtjev za Odobrenje", null, panel_5, null);
//		panel_5.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		JLabel lblPretragaKorisnikaZahtjev = new JLabel("Pretraga Korisnika");
//		lblPretragaKorisnikaZahtjev.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblPretragaKorisnikaZahtjev.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_5.add(lblPretragaKorisnikaZahtjev, "22, 8");
//		
//		textFieldPretragaKorisnikaZahtjev = new JTextField();
//		textFieldPretragaKorisnikaZahtjev.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_5.add(textFieldPretragaKorisnikaZahtjev, "26, 8, fill, default");
//		textFieldPretragaKorisnikaZahtjev.setColumns(10);
//		
//		JButton btnTraziKorZahtjev = new JButton("Tra\u017Ei");
//		btnTraziKorZahtjev.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_5.add(btnTraziKorZahtjev, "32, 8");
//		
//		JSeparator separator_5 = new JSeparator();
//		separator_5.setOrientation(SwingConstants.VERTICAL);
//		panel_5.add(separator_5, "90, 8");
//		
//		JLabel lblKorisnici_2 = new JLabel("Korisnici:");
//		lblKorisnici_2.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblKorisnici_2.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_5.add(lblKorisnici_2, "22, 12");
//		
//		table = new JTable();
//		panel_5.add(table, "26, 12, 1, 4, fill, fill");
//		
//		JLabel lblPretragaDokumenata = new JLabel("Pretraga Dokumenata:");
//		lblPretragaDokumenata.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblPretragaDokumenata.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_5.add(lblPretragaDokumenata, "22, 18");
//		
//		textFieldPretragDokumenata = new JTextField();
//		textFieldPretragDokumenata.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_5.add(textFieldPretragDokumenata, "26, 18, fill, default");
//		textFieldPretragDokumenata.setColumns(10);
//		
//		JButton buttonTraziDokumente = new JButton("Tra\u017Ei");
//		buttonTraziDokumente.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_5.add(buttonTraziDokumente, "32, 18");
//		
//		JLabel lblDokumenti = new JLabel("Dokumenti:");
//		lblDokumenti.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblDokumenti.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_5.add(lblDokumenti, "22, 22");
//		
//		table_1 = new JTable();
//		panel_5.add(table_1, "26, 22, 1, 7, fill, fill");
//		
//		JLabel lblKomentar = new JLabel("Poruka:");
//		lblKomentar.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblKomentar.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_5.add(lblKomentar, "22, 32");
//		
//		textFieldPoruka = new JTextField();
//		textFieldPoruka.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_5.add(textFieldPoruka, "26, 32, 1, 9, fill, default");
//		textFieldPoruka.setColumns(10);
//		
//		JCheckBox chckbxPrikazivanje = new JCheckBox("Prikazivanje");
//		chckbxPrikazivanje.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_5.add(chckbxPrikazivanje, "26, 44");
//		
//		JButton btnPoaljiZahtjev = new JButton("Po\u0161alji Zahtjev");
//		btnPoaljiZahtjev.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_5.add(btnPoaljiZahtjev, "26, 46, right, default");
//		
//		JSeparator separator_6 = new JSeparator();
//		panel_5.add(separator_6, "34, 58");
//		
//		JPanel panel_6 = new JPanel();
//		tabbedPane.addTab("Dodavanje Dokumenta/Foldera/Komentara", null, panel_6, null);
//		panel_6.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		JLabel lblFolderi = new JLabel("Folderi:");
//		lblFolderi.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblFolderi.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_6.add(lblFolderi, "16, 4, default, top");
//		
//		JSeparator separator_7 = new JSeparator();
//		separator_7.setOrientation(SwingConstants.VERTICAL);
//		panel_6.add(separator_7, "94, 4, 1, 5");
//		
//		JTree tree = new JTree();
//		tree.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("Folderi") {
//				{
//					DefaultMutableTreeNode node_1;
//					node_1 = new DefaultMutableTreeNode("Grupa1");
//						node_1.add(new DefaultMutableTreeNode("dokument1"));
//						node_1.add(new DefaultMutableTreeNode("dokument2"));
//						node_1.add(new DefaultMutableTreeNode("dokument3"));
//						node_1.add(new DefaultMutableTreeNode("dokument4"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("Grupa2");
//						node_1.add(new DefaultMutableTreeNode("dokument1"));
//						node_1.add(new DefaultMutableTreeNode("dokument2"));
//						node_1.add(new DefaultMutableTreeNode("dokument3"));
//					add(node_1);
//				}
//			}
//		));
//		tree.setFont(new Font("Dialog", Font.PLAIN, 16));
//		tree.setEditable(true);
//		panel_6.add(tree, "20, 4, 17, 7, fill, fill");
//		
//		JLabel lblNazivFoldera = new JLabel("Naziv Foldera:");
//		lblNazivFoldera.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblNazivFoldera.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_6.add(lblNazivFoldera, "16, 14");
//		
//		textField_1 = new JTextField();
//		panel_6.add(textField_1, "20, 14, 17, 1, fill, default");
//		textField_1.setColumns(10);
//		
//		JButton btnNewButton = new JButton("Dodaj Folder");
//		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 16));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		panel_6.add(btnNewButton, "36, 18, right, default");
//		
//		JButton btnIzborDokumenta = new JButton("Izbor Dokumenta");
//		btnIzborDokumenta.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_6.add(btnIzborDokumenta, "36, 22, right, default");
//		
//		JLabel lblIzabraniDokument = new JLabel("Izabrani Dokument:");
//		lblIzabraniDokument.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblIzabraniDokument.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_6.add(lblIzabraniDokument, "16, 26");
//		
//		textFieldPrikazIzabranogDokumenta = new JTextField();
//		textFieldPrikazIzabranogDokumenta.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_6.add(textFieldPrikazIzabranogDokumenta, "20, 26, 17, 1, fill, default");
//		textFieldPrikazIzabranogDokumenta.setColumns(10);
//		
//		JLabel lblNazivDokumenta = new JLabel("Naziv Dokumenta:");
//		lblNazivDokumenta.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblNazivDokumenta.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_6.add(lblNazivDokumenta, "16, 30");
//		
//		textFieldNazivDokumenta = new JTextField();
//		textFieldNazivDokumenta.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_6.add(textFieldNazivDokumenta, "20, 30, 17, 1, fill, default");
//		textFieldNazivDokumenta.setColumns(10);
//		
//		JLabel lblKomentar_1 = new JLabel("Komentar:");
//		lblKomentar_1.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblKomentar_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_6.add(lblKomentar_1, "16, 34");
//		
//		textFieldKomentar = new JTextField();
//		textFieldKomentar.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_6.add(textFieldKomentar, "20, 34, 17, 1, fill, default");
//		textFieldKomentar.setColumns(10);
//		
//		JButton btnDodajKomentar = new JButton("Dodaj Komentar");
//		btnDodajKomentar.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_6.add(btnDodajKomentar, "20, 38, left, default");
//		
//		JButton btnPostaviDokument = new JButton("Postavi Dokument");
//		btnPostaviDokument.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_6.add(btnPostaviDokument, "36, 38");
//		
//		JSeparator separator_8 = new JSeparator();
//		panel_6.add(separator_8, "26, 58, 33, 1");
//		
//		JPanel panel_7 = new JPanel();
//		tabbedPane.addTab("Brisanje Dokumenata", null, panel_7, null);
//		panel_7.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		JTree tree_1 = new JTree();
//		tree_1.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("Folderi") {
//				{
//					DefaultMutableTreeNode node_1;
//					node_1 = new DefaultMutableTreeNode("Grupa1");
//						node_1.add(new DefaultMutableTreeNode("dokument1"));
//						node_1.add(new DefaultMutableTreeNode("dokument2"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("Grupa2");
//						node_1.add(new DefaultMutableTreeNode("dokument1"));
//						node_1.add(new DefaultMutableTreeNode("dokument2"));
//						node_1.add(new DefaultMutableTreeNode(""));
//					add(node_1);
//				}
//			}
//		));
//		tree_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		tree_1.setEditable(true);
//		panel_7.add(tree_1, "26, 4, 17, 7, fill, fill");
//		
//		JLabel lblFolderi_1 = new JLabel("Folderi:");
//		lblFolderi_1.setVerticalAlignment(SwingConstants.TOP);
//		lblFolderi_1.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblFolderi_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_7.add(lblFolderi_1, "22, 6, default, top");
//		
//		JSeparator separator_9 = new JSeparator();
//		separator_9.setOrientation(SwingConstants.VERTICAL);
//		panel_7.add(separator_9, "98, 8");
//		
//		JButton btnIzbriiFolder = new JButton("Izbri\u0161i Folder");
//		btnIzbriiFolder.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_7.add(btnIzbriiFolder, "42, 14");
//		
//		JLabel lblPoetniDatum = new JLabel("Po\u010Detni Datum:");
//		lblPoetniDatum.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblPoetniDatum.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_7.add(lblPoetniDatum, "22, 20, default, top");
//		
//		JCalendar calendar_1 = new JCalendar();
//		panel_7.add(calendar_1, "26, 20, center, center");
//		
//		JLabel lblKrajnjiDatum = new JLabel("Krajnji Datum:");
//		lblKrajnjiDatum.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_7.add(lblKrajnjiDatum, "40, 20, default, top");
//		
//		JCalendar calendar_2 = new JCalendar();
//		panel_7.add(calendar_2, "42, 20, center, center");
//		
//		JLabel lblIzabraniDokument_1 = new JLabel("Dokumenti:");
//		lblIzabraniDokument_1.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblIzabraniDokument_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_7.add(lblIzabraniDokument_1, "22, 24");
//		
//		table_2 = new JTable();
//		panel_7.add(table_2, "26, 24, 17, 12, fill, fill");
//		
//		JButton btnArhivirajDokument = new JButton("Arhiviraj Dokumente");
//		btnArhivirajDokument.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_7.add(btnArhivirajDokument, "42, 38");
//		
//		JButton btnBriiDokumente = new JButton("Bri\u0161i Dokumente");
//		btnBriiDokumente.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_7.add(btnBriiDokumente, "42, 44");
//		
//		JSeparator separator_10 = new JSeparator();
//		panel_7.add(separator_10, "34, 60");
//		
//		JPanel panel_8 = new JPanel();
//		tabbedPane.addTab("Pretraga Dokumenata", null, panel_8, null);
//		panel_8.setLayout(new FormLayout(new ColumnSpec[] {
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("min:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				ColumnSpec.decode("min:grow"),
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,
//				FormSpecs.RELATED_GAP_COLSPEC,
//				FormSpecs.DEFAULT_COLSPEC,},
//			new RowSpec[] {
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.MIN_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				RowSpec.decode("default:grow"),
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,
//				FormSpecs.RELATED_GAP_ROWSPEC,
//				FormSpecs.DEFAULT_ROWSPEC,}));
//		
//		JLabel lblNewLabel_1 = new JLabel("Po\u010Detni Datum:");
//		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_8.add(lblNewLabel_1, "14, 6, default, top");
//		
//		JCalendar calendar_3 = new JCalendar();
//		panel_8.add(calendar_3, "16, 6, center, center");
//		
//		JLabel lblKrajnjiDatum_1 = new JLabel("Krajnji Datum:");
//		lblKrajnjiDatum_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_8.add(lblKrajnjiDatum_1, "32, 6, default, top");
//		
//		JCalendar calendar_4 = new JCalendar();
//		panel_8.add(calendar_4, "34, 6, center, center");
//		
//		JSeparator separator_11 = new JSeparator();
//		separator_11.setOrientation(SwingConstants.VERTICAL);
//		panel_8.add(separator_11, "96, 6");
//		
//		JLabel lblKorisnik = new JLabel("Korisnik:");
//		lblKorisnik.setFont(new Font("Dialog", Font.PLAIN, 16));
//		lblKorisnik.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_8.add(lblKorisnik, "14, 10, right, default");
//		
//		textField_2 = new JTextField();
//		textField_2.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_8.add(textField_2, "16, 10, 19, 1, fill, default");
//		textField_2.setColumns(10);
//		
//		JButton btnTraiDokumente = new JButton("Tra\u017Ei");
//		btnTraiDokumente.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_8.add(btnTraiDokumente, "34, 14");
//		
//		JLabel lblDokumenti_1 = new JLabel("Dokumenti:");
//		lblDokumenti_1.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_8.add(lblDokumenti_1, "14, 18, right, top");
//		
//		table_3 = new JTable();
//		panel_8.add(table_3, "16, 18, 19, 9, fill, fill");
//		
//		JComboBox comboBoxTipIzvjestaja = new JComboBox();
//		comboBoxTipIzvjestaja.setModel(new DefaultComboBoxModel(new String[] {"Tip Izvje\u0161taja", "Korisnik", "Dokument ", "Zahtjev", "Odobrenje"}));
//		comboBoxTipIzvjestaja.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_8.add(comboBoxTipIzvjestaja, "34, 30, fill, default");
//		
//		JButton btnKreirajIzvjetaj = new JButton("Kreiraj Izvje\u0161taj");
//		btnKreirajIzvjetaj.setFont(new Font("Dialog", Font.PLAIN, 16));
//		panel_8.add(btnKreirajIzvjetaj, "34, 36");
//		
//		JSeparator separator_12 = new JSeparator();
//		panel_8.add(separator_12, "28, 58");
//	
//	}
//
//}
