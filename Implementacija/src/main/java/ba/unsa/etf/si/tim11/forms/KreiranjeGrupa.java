package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


import ba.unsa.etf.si.tim11.bll.FolderRepository;
import ba.unsa.etf.si.tim11.bll.GrupaRepository;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;

public class KreiranjeGrupa
{

	private JFrame frmKreiranjeGrupa;
	private JTextField txt_nazivGrupe;
	private JCheckBox chckbxPravoitanja;
	private JList list_sviKorisnici;
	private JList list_dodaniKorisnici;
	private JList list_folderi;
	private JList list_dodaniFolderi;
	private JCheckBox checkBox_Pisanje;
	private DefaultListModel listaFoldera = new DefaultListModel();
	private DefaultListModel listaDodanihFoldera = new DefaultListModel();
	private DefaultListModel listaSvihKorisnika = new DefaultListModel();
	private DefaultListModel listaDodanihKorisnika = new DefaultListModel();
	private KorisnikRepository korisnikRep = new KorisnikRepository();
	private FolderRepository folderRep = new FolderRepository();
	private GrupaRepository grupaRep = new GrupaRepository();
	private String userNameKorisnika = "";

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
					KreiranjeGrupa window = new KreiranjeGrupa();
					window.frmKreiranjeGrupa.setVisible(true);
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
	public KreiranjeGrupa()
	{
		initialize();
		postaviUserNameKorisnika();
		ucitajSveListe();
		
	}

	private void postaviUserNameKorisnika() {
		
		try{
			Sesija nova = new Sesija();
			userNameKorisnika = "rsmajic"; //nova.getUsername();
		}
		catch(Exception ex)
		{
			
		}
		
	}

	private void ucitajSveListe() {
		
			// Ucitaj sve korisnike
			List<KorisnikDbModel> lista = korisnikRep.dajSveKorisnike();
			for(KorisnikDbModel kor : lista)
				listaSvihKorisnika.addElement(kor);	
			System.out.println(lista.get(0).getKorisnikPozicija());
			
			System.out.println(userNameKorisnika);
			// Ucitaj sve foldere
			List<FolderDbModel> listaFolderaa = folderRep.dajSveFoldereNaKojeImaPravo(userNameKorisnika);
			 for(FolderDbModel f : listaFolderaa)
				listaFoldera.addElement(f);
			
			//JOptionPane.showMessageDialog(null, "Radi", "Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
			
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmKreiranjeGrupa = new JFrame();
		frmKreiranjeGrupa.setResizable(false);
		frmKreiranjeGrupa.setTitle("Kreiranje Grupa");
		frmKreiranjeGrupa.setBounds(100, 100, 1209, 630);
		frmKreiranjeGrupa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKreiranjeGrupa.getContentPane().setLayout(null);
		
		JPanel panel_podaciGrupe = new JPanel();
		panel_podaciGrupe.setBorder(new TitledBorder(null, "Podaci za grupu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_podaciGrupe.setBounds(10, 11, 1175, 67);
		frmKreiranjeGrupa.getContentPane().add(panel_podaciGrupe);
		
		JLabel lblNazivGrupe = new JLabel("Naziv grupe:");
		
		txt_nazivGrupe = new JTextField();
		txt_nazivGrupe.setColumns(10);
		GroupLayout gl_panel_podaciGrupe = new GroupLayout(panel_podaciGrupe);
		gl_panel_podaciGrupe.setHorizontalGroup(
			gl_panel_podaciGrupe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_podaciGrupe.createSequentialGroup()
					.addGap(401)
					.addComponent(lblNazivGrupe, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txt_nazivGrupe, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(466, Short.MAX_VALUE))
		);
		gl_panel_podaciGrupe.setVerticalGroup(
			gl_panel_podaciGrupe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_podaciGrupe.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_podaciGrupe.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNazivGrupe, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_nazivGrupe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_podaciGrupe.setLayout(gl_panel_podaciGrupe);
		
		JPanel panel_korisnikGrupa = new JPanel();
		panel_korisnikGrupa.setBorder(new TitledBorder(null, "Dodavanje korisnika u grupu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_korisnikGrupa.setBounds(10, 89, 565, 425);
		frmKreiranjeGrupa.getContentPane().add(panel_korisnikGrupa);
		
		JButton btnDodajKorisnika = new JButton("Dodaj korisnika");
		btnDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JScrollPane scrollPane_korisnici = new JScrollPane();
		
		JLabel lblSviKorisnici = new JLabel("Svi korisnici:");
		
		JScrollPane scrollPane_dodaniKorisnici = new JScrollPane();
		
		JLabel lblDodaniKorisnici = new JLabel("Dodani korisnici:");
		GroupLayout gl_panel_korisnikGrupa = new GroupLayout(panel_korisnikGrupa);
		gl_panel_korisnikGrupa.setHorizontalGroup(
			gl_panel_korisnikGrupa.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_korisnikGrupa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_korisnikGrupa.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_korisnikGrupa.createSequentialGroup()
							.addComponent(scrollPane_korisnici, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDodajKorisnika))
						.addComponent(lblSviKorisnici))
					.addGap(10)
					.addGroup(gl_panel_korisnikGrupa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDodaniKorisnici)
						.addComponent(scrollPane_dodaniKorisnici, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_panel_korisnikGrupa.setVerticalGroup(
			gl_panel_korisnikGrupa.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_korisnikGrupa.createSequentialGroup()
					.addGap(175)
					.addComponent(btnDodajKorisnika)
					.addContainerGap(204, Short.MAX_VALUE))
				.addGroup(gl_panel_korisnikGrupa.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addGroup(gl_panel_korisnikGrupa.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSviKorisnici)
						.addComponent(lblDodaniKorisnici))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_korisnikGrupa.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_dodaniKorisnici)
						.addComponent(scrollPane_korisnici, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		list_dodaniKorisnici = new JList(listaDodanihKorisnika);
		scrollPane_dodaniKorisnici.setViewportView(list_dodaniKorisnici);
		
		list_sviKorisnici = new JList(listaSvihKorisnika);
		scrollPane_korisnici.setViewportView(list_sviKorisnici);
		panel_korisnikGrupa.setLayout(gl_panel_korisnikGrupa);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Definisanje prava pristupa folderima od strane grupe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(597, 89, 588, 425);
		frmKreiranjeGrupa.getContentPane().add(panel);
		
		JScrollPane scrollPane_folderi = new JScrollPane();
		
		chckbxPravoitanja = new JCheckBox("Pravo čitanja");
		
		checkBox_Pisanje = new JCheckBox("Pravo pisanja");
		
		JLabel lblFolderi = new JLabel("Folderi:");
		
		JButton btnDefinisiPristup = new JButton("Definiši pristup");
		
		JScrollPane scrollPane_dodaniFolderi = new JScrollPane();
		
		JLabel lblDodaniFolderi = new JLabel("Dodani folderi:");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane_folderi, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDefinisiPristup)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(chckbxPravoitanja)
									.addComponent(checkBox_Pisanje, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addComponent(lblFolderi))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDodaniFolderi)
						.addComponent(scrollPane_dodaniFolderi, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(110)
					.addComponent(chckbxPravoitanja)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(checkBox_Pisanje)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDefinisiPristup)
					.addContainerGap(216, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFolderi)
						.addComponent(lblDodaniFolderi))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_dodaniFolderi, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_folderi, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		list_dodaniFolderi = new JList(listaDodanihFoldera);
		scrollPane_dodaniFolderi.setViewportView(list_dodaniFolderi);
		
		list_folderi = new JList(listaFoldera);
		scrollPane_folderi.setViewportView(list_folderi);
		panel.setLayout(gl_panel);
		
		JButton btnKreirajGrupu = new JButton("Kreiraj grupu");
		btnKreirajGrupu.setBounds(927, 525, 258, 46);
		frmKreiranjeGrupa.getContentPane().add(btnKreirajGrupu);
	}
}
