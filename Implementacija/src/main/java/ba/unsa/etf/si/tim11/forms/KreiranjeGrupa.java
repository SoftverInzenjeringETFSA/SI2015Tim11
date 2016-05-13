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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


import ba.unsa.etf.si.tim11.bll.FolderRepository;
import ba.unsa.etf.si.tim11.bll.GrupaRepository;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class KreiranjeGrupa
{

	private JFrame frmKreiranjeGrupa;
	private JTextField txt_nazivGrupe;
	private JCheckBox checkBox_Citanje;
	private JList list_sviKorisnici;
	private JList list_dodaniKorisnici;
	private JList list_folderi;
	private JList list_dodaniFolderi;
	private JCheckBox checkBox_Pisanje;
	private DefaultListModel listaFoldera = new DefaultListModel();
	private DefaultListModel listaDodanihFoldera = new DefaultListModel();
	private DefaultListModel listaSvihKorisnika = new DefaultListModel();
	private DefaultListModel listaDodanihKorisnika = new DefaultListModel();
	private List<FolderXGrupaDbModel> listaDefinisanihPravaPristupa = new ArrayList<FolderXGrupaDbModel>();
	private KorisnikRepository korisnikRep = new KorisnikRepository();
	private FolderRepository folderRep = new FolderRepository();
	private GrupaRepository grupaRep = new GrupaRepository();
	private String userNameKorisnika = "";
	

	/**
	 * Launch the application.
	 */
	public void PokreniFormu()
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
			userNameKorisnika = Sesija.getUsername();
		}
		catch(Exception ex)
		{
			userNameKorisnika = "";
		}
		
	}

	private void ucitajSveListe() {
		
			// Ucitaj sve korisnike
			List<KorisnikDbModel> lista = korisnikRep.dajSveKorisnike();
			for(KorisnikDbModel kor : lista)
				listaSvihKorisnika.addElement(kor);	
			
			// Ucitaj sve foldere
			List<FolderDbModel> listaFolderaa = folderRep.dajSveFoldereNaKojeImaPravo(userNameKorisnika);
			 for(FolderDbModel f : listaFolderaa)
				if(!listaFoldera.contains(f))
				 listaFoldera.addElement(f);	
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
		frmKreiranjeGrupa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		txt_nazivGrupe.setText("");
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
				
				if(list_sviKorisnici.getSelectedIndex() == -1)
				{
				  JOptionPane.showMessageDialog(null, "Nije izabran nijedan korisnik iz liste svih korisnika!", "Greška", JOptionPane.INFORMATION_MESSAGE);
				  return;
				}
				if(((KorisnikDbModel)list_sviKorisnici.getSelectedValue()).getUsername().equals(userNameKorisnika))
				{
					  JOptionPane.showMessageDialog(null, "Ne možete dodati samog sebe u grupu koju pravite!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					  return;
				}	
				if(!listaDodanihKorisnika.contains(list_sviKorisnici.getSelectedValue()))
					listaDodanihKorisnika.addElement(list_sviKorisnici.getSelectedValue());
				else
					JOptionPane.showMessageDialog(null, "Korisnik već postoji!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					
				
			}
		});
		
		JScrollPane scrollPane_korisnici = new JScrollPane();
		
		JLabel lblSviKorisnici = new JLabel("Svi korisnici:");
		
		JScrollPane scrollPane_dodaniKorisnici = new JScrollPane();
		
		JLabel lblDodaniKorisnici = new JLabel("Dodani korisnici:");
		
		JButton btnUkloniKorisnika = new JButton("Ukloni korisnika");
		btnUkloniKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_dodaniKorisnici.getSelectedIndex() != -1)
					listaDodanihKorisnika.removeElementAt(list_dodaniKorisnici.getSelectedIndex());
			}
		});
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
						.addGroup(gl_panel_korisnikGrupa.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane_dodaniKorisnici, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUkloniKorisnika)))
					.addContainerGap(32, Short.MAX_VALUE))
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
					.addGroup(gl_panel_korisnikGrupa.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane_korisnici, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_panel_korisnikGrupa.createSequentialGroup()
							.addComponent(scrollPane_dodaniKorisnici)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUkloniKorisnika)))
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
		
		checkBox_Citanje = new JCheckBox("Pravo čitanja");
		
		checkBox_Pisanje = new JCheckBox("Pravo pisanja");
		
		JLabel lblFolderi = new JLabel("Folderi:");
		
		JButton btnDefinisiPristup = new JButton("Definiši pristup");
		btnDefinisiPristup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(list_folderi.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Niste selektovali nijedan folder za definisanje prava pristupa!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(!checkBox_Pisanje.isSelected() && !checkBox_Citanje.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Niste definisali prava pristupa!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(!listaDodanihFoldera.contains(list_folderi.getSelectedValue()))
				{
					
					listaDodanihFoldera.addElement((FolderDbModel)list_folderi.getSelectedValue());
					FolderXGrupaDbModel novi = new FolderXGrupaDbModel();
					FolderDbModel trenutni = (FolderDbModel)list_folderi.getSelectedValue();
					
					
					novi.setFolderId((int)trenutni.getFolderId());
					novi.setAktivan(true);
					novi.setPravoDodavanja(checkBox_Pisanje.isSelected());
					novi.setPravoSkidanja(checkBox_Citanje.isSelected());
					
					listaDefinisanihPravaPristupa.add(novi);		
				}
				else
					JOptionPane.showMessageDialog(null, "Folder već postoji među dodanim folderima!", "Greška", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JScrollPane scrollPane_dodaniFolderi = new JScrollPane();
		
		JLabel lblDodaniFolderi = new JLabel("Dodani folderi:");
		
		JButton btnUkloniFolder = new JButton("Ukloni folder");
		btnUkloniFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_dodaniFolderi.getSelectedIndex() != -1)
					listaDodanihFoldera.removeElementAt(list_dodaniFolderi.getSelectedIndex());
			}
		});
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
									.addComponent(checkBox_Citanje)
									.addComponent(checkBox_Pisanje, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addComponent(lblFolderi))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDodaniFolderi)
							.addGap(133))
						.addComponent(btnUkloniFolder)
						.addComponent(scrollPane_dodaniFolderi, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(110)
					.addComponent(checkBox_Citanje)
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
						.addComponent(scrollPane_folderi, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(scrollPane_dodaniFolderi)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUkloniFolder)))
					.addContainerGap())
		);
		
		list_dodaniFolderi = new JList(listaDodanihFoldera);
		scrollPane_dodaniFolderi.setViewportView(list_dodaniFolderi);
		
		list_folderi = new JList(listaFoldera);
		list_folderi.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				KorisnikRepository kr = new KorisnikRepository();
				int prava = kr.dajPravaKorisnikaNaFolder(userNameKorisnika, (FolderDbModel)list_folderi.getSelectedValue());
				
				if(prava == 1)
				{
					checkBox_Citanje.setSelected(false);
					checkBox_Citanje.setEnabled(false);
					checkBox_Pisanje.setEnabled(true);
				}
				else if(prava == 2)
				{
					checkBox_Pisanje.setSelected(false);
					checkBox_Pisanje.setEnabled(false);
					checkBox_Citanje.setEnabled(true);
				}
				else
				{
					
					checkBox_Pisanje.setEnabled(true);
					checkBox_Citanje.setEnabled(true);
				}
			}
		});
		scrollPane_folderi.setViewportView(list_folderi);
		panel.setLayout(gl_panel);
		
		JButton btnKreirajGrupu = new JButton("Kreiraj grupu");
		btnKreirajGrupu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txt_nazivGrupe.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Naziv grupe ne može biti prazno polje!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				GrupaRepository gRep = new GrupaRepository();
				if(gRep.dajGrupuPoNazivu(txt_nazivGrupe.getText()) != null)
				{
					JOptionPane.showMessageDialog(null, "Grupa sa unesenim nazivom već postoji! Odaberite drugi naziv!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(listaDodanihKorisnika.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Niste dodali nijednog korisnika u grupu!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(listaDodanihFoldera.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Niste dodali nijedan folder kojem grupa ima pravo pristupa!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				KorisnikRepository kor = new KorisnikRepository();
				GrupaDbModel nova = new GrupaDbModel();
				nova.setAktivan(true);
				nova.setDatumKreiranja(new Date());
				nova.setGrupaNaziv(txt_nazivGrupe.getText());
				nova.setOdgovorniKorisnikId(kor.dajIdKorisnikaPoUsername(userNameKorisnika));
				String naziv = nova.getGrupaNaziv();
				gRep.dodajGrupu(nova);
				
				Integer idNoveGrupe = (int)gRep.dajGrupuPoNazivu(naziv).getGrupaId();
				//System.out.println(listaDefinisanihPravaPristupa.get(0).getFolder().getFolderNaziv());
				
				gRep.dodajFolderXGrupaDbModele(listaDefinisanihPravaPristupa, idNoveGrupe);
				
				List <KorisnikDbModel> listaKorisnika = new ArrayList<KorisnikDbModel>();
				
				for(int i=0; i< listaDodanihKorisnika.size(); i++)
					listaKorisnika.add((KorisnikDbModel)listaDodanihKorisnika.get(i));
				
				gRep.dodajGrupaXKorisnikDbModele(listaKorisnika, idNoveGrupe);
				
				txt_nazivGrupe.setText("");
				list_dodaniKorisnici.setSelectedIndex(-1);
				list_dodaniFolderi.setSelectedIndex(-1);
				listaDodanihKorisnika.clear();
				listaDodanihFoldera.clear();
				checkBox_Pisanje.setSelected(false);
				checkBox_Citanje.setSelected(false);
				
				JOptionPane.showMessageDialog(null, "Grupa uspješno kreirana!", "Info", JOptionPane.INFORMATION_MESSAGE);

				
								
					
			}
		});
		btnKreirajGrupu.setBounds(927, 525, 258, 46);
		frmKreiranjeGrupa.getContentPane().add(btnKreirajGrupu);
	}
}
