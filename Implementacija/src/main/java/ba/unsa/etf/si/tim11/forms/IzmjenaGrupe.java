package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.tim11.bll.FolderRepository;
import ba.unsa.etf.si.tim11.bll.GrupaRepository;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class IzmjenaGrupe
{

	private JFrame frmIzmjenaGrupa;
	private JTextField text_noviNazivGrupe;
	private JList list_grupeKorisnika;
	private JList list_sviKorisnici;
	private JList list_dodaniKorisnici;
	private JList list_sviFolderi;
	private JList list_dodaniFolderi;
	private JCheckBox chckbxPravoPisanja;
	private JCheckBox chckbxPraviitanja;
	private DefaultListModel listaGrupaKorisnika = new DefaultListModel();
	private DefaultListModel listaSvihKorisnika = new DefaultListModel();
	private DefaultListModel listaDodanihKorisnikaGrupe = new DefaultListModel();
	private DefaultListModel listaSvihFoldera = new DefaultListModel();
	private DefaultListModel listaDodanihFolderaGrupe = new DefaultListModel();
	private KorisnikRepository korisnikRep = new KorisnikRepository();
	private GrupaRepository grupaRep = new GrupaRepository();
	private FolderRepository folderRep = new FolderRepository();
	String userNameKorisnika;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					IzmjenaGrupe window = new IzmjenaGrupe();
					window.frmIzmjenaGrupa.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IzmjenaGrupe()
	{
		initialize();
		postaviUserNameKorisnika();
		ucitajListeForme(userNameKorisnika);
		ucitajGrupeKorisnika(userNameKorisnika);
	}
	
	private void ucitajListeForme(String userNameKorisnika)
	{
		List<KorisnikDbModel> listaKorisnika = korisnikRep.dajSveKorisnike();
		for(KorisnikDbModel kor : listaKorisnika)
			listaSvihKorisnika.addElement(kor);
		
		List<FolderDbModel> listaFolderaa = folderRep.dajSveFoldereNaKojeImaPravo(userNameKorisnika);
		 for(FolderDbModel f : listaFolderaa)
			if(!listaSvihFoldera.contains(f))
			 listaSvihFoldera.addElement(f);
	}
	private void izbrisiGrupuNaFormi(Integer index)
	{
		listaGrupaKorisnika.removeElementAt(index);
	}
	private void ucitajGrupeKorisnika(String userNameKorisnika2) 
	{
		 
		List<GrupaDbModel> listaGrupaVlasnika = grupaRep.dajGrupeVlasnika(korisnikRep.dajIdKorisnikaPoUsername(userNameKorisnika));
		for(GrupaDbModel grupa : listaGrupaVlasnika)
			listaGrupaKorisnika.addElement(grupa);
		
	}

	private void postaviUserNameKorisnika() {
		try{
		    userNameKorisnika = "rsmajic"; //Sesija.getUsername();
		}
		catch(Exception ex){
			userNameKorisnika = "";
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmIzmjenaGrupa = new JFrame();
		frmIzmjenaGrupa.setTitle("Izmjena Grupa");
		frmIzmjenaGrupa.setResizable(false);
		frmIzmjenaGrupa.setBounds(100, 100, 1194, 480);
		frmIzmjenaGrupa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIzmjenaGrupa.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Odabir grupe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 11, 196, 375);
		frmIzmjenaGrupa.getContentPane().add(scrollPane);
		
		list_grupeKorisnika = new JList(listaGrupaKorisnika);
		scrollPane.setViewportView(list_grupeKorisnika);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Izmjena naziva grupe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(216, 11, 459, 96);
		frmIzmjenaGrupa.getContentPane().add(panel);
		
		JLabel lblNoviNaziv = new JLabel("Novi naziv:");
		
		text_noviNazivGrupe = new JTextField();
		text_noviNazivGrupe.setColumns(10);
		
		JButton btnSpremiIzmjenu = new JButton("Spremi izmjenu");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNoviNaziv)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(text_noviNazivGrupe, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
						.addComponent(btnSpremiIzmjenu, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNoviNaziv)
						.addComponent(text_noviNazivGrupe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSpremiIzmjenu)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnBrisanjeGrupe = new JButton("Obriši grupu");
		btnBrisanjeGrupe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_grupeKorisnika.getSelectedIndex() != -1)
				{
				    grupaRep.ukloniSveKorisnikeIzGrupe((int)((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId());
				    grupaRep.ukloniSvaPravaPristupaGrupe((int)((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId());
				    grupaRep.obrisiGrupu((GrupaDbModel)list_grupeKorisnika.getSelectedValue());
				    izbrisiGrupuNaFormi(list_grupeKorisnika.getSelectedIndex());
				    JOptionPane.showMessageDialog(null, "Grupa uspješno obrisana!", "Obavještenje", JOptionPane.INFORMATION_MESSAGE);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Nije odabrana nijedna grupa!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnBrisanjeGrupe.setBounds(48, 397, 157, 26);
		frmIzmjenaGrupa.getContentPane().add(btnBrisanjeGrupe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Izmjena korisnika u grupi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(216, 118, 459, 308);
		frmIzmjenaGrupa.getContentPane().add(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblSviKorisnici = new JLabel("Svi korisnici:");
		
		JButton btnDodajKorisnika = new JButton("Dodaj korisnika");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblPostojeiKorisniciU = new JLabel("Postojeći korisnici u grupi:");
		
		JButton btnObriiKorisnika = new JButton("Obriši korisnika");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDodajKorisnika))
						.addComponent(lblSviKorisnici))
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPostojeiKorisniciU)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnObriiKorisnika)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(119)
							.addComponent(btnDodajKorisnika))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSviKorisnici)
								.addComponent(lblPostojeiKorisniciU))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane_2)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnObriiKorisnika)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		list_dodaniKorisnici = new JList(listaDodanihKorisnikaGrupe);
		scrollPane_2.setViewportView(list_dodaniKorisnici);
		
		list_sviKorisnici = new JList(listaSvihKorisnika);
		scrollPane_1.setViewportView(list_sviKorisnici);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Izmjena/Uklanjanje prava pristupa nad folderima", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(685, 11, 486, 412);
		frmIzmjenaGrupa.getContentPane().add(panel_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblSviFolderi = new JLabel("Svi folderi:");
		
		JButton btnDodajFolder = new JButton("Dodaj folder");
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		chckbxPravoPisanja = new JCheckBox("Pravo pisanja");
		
		chckbxPraviitanja = new JCheckBox("Pravi čitanja");
		
		JLabel lblDodaniFolderi = new JLabel("Dodani folderi:");
		
		JButton btnUkloniPravoPristupa = new JButton("Ukloni pravo pristupa");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(chckbxPraviitanja)
										.addComponent(chckbxPravoPisanja)
										.addComponent(btnDodajFolder, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblSviFolderi))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
								.addComponent(lblDodaniFolderi)))
						.addComponent(btnUkloniPravoPristupa, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSviFolderi)
								.addComponent(lblDodaniFolderi))
							.addGap(7)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(btnUkloniPravoPristupa))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(109)
							.addComponent(chckbxPravoPisanja)
							.addGap(18)
							.addComponent(chckbxPraviitanja)
							.addGap(18)
							.addComponent(btnDodajFolder)))
					.addContainerGap())
		);
		
		list_dodaniFolderi = new JList(listaDodanihFolderaGrupe);
		scrollPane_4.setViewportView(list_dodaniFolderi);
		
		list_sviFolderi = new JList(listaSvihFoldera);
		scrollPane_3.setViewportView(list_sviFolderi);
		panel_2.setLayout(gl_panel_2);
	}
}
