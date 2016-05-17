package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Container;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class IzmjenaGrupe
{

	private JDialog frmIzmjenaGrupa;
	private JTextField text_noviNazivGrupe;
	private JList list_grupeKorisnika;
	private JList list_sviKorisnici;
	private JList list_dodaniKorisnici;
	private JList list_sviFolderi;
	private JList list_dodaniFolderi;
	private JCheckBox checkBox_Pisanje;
	private JCheckBox checkBox_Citanje;
	private DefaultListModel listaGrupaKorisnika = new DefaultListModel();
	private DefaultListModel listaSvihKorisnika = new DefaultListModel();
	private DefaultListModel listaDodanihKorisnikaGrupe = new DefaultListModel();
	private DefaultListModel listaSvihFoldera = new DefaultListModel();
	private DefaultListModel listaDodanihFolderaGrupe = new DefaultListModel();
	private KorisnikRepository korisnikRep = new KorisnikRepository();
	private GrupaRepository grupaRep = new GrupaRepository();
	private FolderRepository folderRep = new FolderRepository();
	String userNameKorisnika;
	
	final static Logger logger = Logger.getLogger(IzmjenaGrupe.class.toString());
	private JLabel lbl_trenutnaPrava;
	
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
					IzmjenaGrupe window = new IzmjenaGrupe();
					window.frmIzmjenaGrupa.setVisible(true);
				} catch (Exception e)
				{
					logger.info(e.getMessage());
					throw new RuntimeException(e);
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
		ocistiSve();
		postaviUserNameKorisnika();
		ucitajListeForme(userNameKorisnika);
		ucitajGrupeKorisnika(userNameKorisnika);
	}
	
	private boolean daLiVecPostojiUListiDodanihFoldera(int idFoldera)
	{
		for(int i=0; i<listaDodanihFolderaGrupe.size(); i++)
			if(((FolderDbModel)listaDodanihFolderaGrupe.get(i)).getFolderId() == idFoldera)
				return true;
			 
		return false;
	}
	private void ocistiSve()
	{
		list_grupeKorisnika.removeAll();
		list_sviKorisnici.removeAll();
		list_dodaniKorisnici.removeAll();
		list_sviFolderi.removeAll();
		list_dodaniFolderi.removeAll();
		
		listaDodanihKorisnikaGrupe.clear();
		listaSvihKorisnika.clear();
		listaSvihFoldera.clear();
		listaDodanihFolderaGrupe.clear();
		listaGrupaKorisnika.clear();
	}
	
	private void ucitajListeForme(String userNameKorisnika)
	{
		listaSvihKorisnika.clear();
		List<KorisnikDbModel> listaKorisnika = korisnikRep.dajSveKorisnike();
		for(KorisnikDbModel kor : listaKorisnika)
			listaSvihKorisnika.addElement(kor);
		
		listaSvihFoldera.clear();
		List<FolderDbModel> listaFolderaa = folderRep.dajSveFoldereNaKojeImaPravo(userNameKorisnika);
		 for(FolderDbModel f : listaFolderaa)
			if(!listaSvihFoldera.contains(f))
			 listaSvihFoldera.addElement(f);
	}
	private void ucitajKorisnikeGrupe()
	{
		if(list_grupeKorisnika.getSelectedIndex() != -1)
		{
			List<KorisnikDbModel> korisniciGrupe = korisnikRep.dajKorisnikeGrupe((int)(((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId()));
			
			listaDodanihKorisnikaGrupe.clear();
			
			for(KorisnikDbModel korisnik : korisniciGrupe)
				if(!listaDodanihKorisnikaGrupe.contains(korisnik))
				listaDodanihKorisnikaGrupe.addElement(korisnik);
		}
		else
			listaDodanihKorisnikaGrupe.clear();
	}
	
	private void ucitajFoldereGrupe()
	{
		if(list_grupeKorisnika.getSelectedIndex() != -1)
		{
			List<FolderDbModel> folderiGrupe = folderRep.dajFoldereGrupe((int)(((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId()));
			
			listaDodanihFolderaGrupe.clear();
			
			for(FolderDbModel folder : folderiGrupe)
				if(!listaDodanihFolderaGrupe.contains(folder))
				listaDodanihFolderaGrupe.addElement(folder);
		}
		else
			listaDodanihFolderaGrupe.clear();
		
	}
	private void izbrisiGrupuNaFormi(Integer index)
	{
		listaGrupaKorisnika.removeElementAt(index);
	}
	private void ucitajGrupeKorisnika(String userName) 
	{
		listaGrupaKorisnika.clear();
		List<GrupaDbModel> listaGrupaVlasnika = grupaRep.dajGrupeVlasnika(korisnikRep.dajIdKorisnikaPoUsername(userName));
		for(GrupaDbModel grupa : listaGrupaVlasnika)
			listaGrupaKorisnika.addElement(grupa);
		
	}

	private void postaviUserNameKorisnika() {
		try{
		    userNameKorisnika = Sesija.getUsername();
		}
		catch(Exception ex){
			logger.info(ex.getMessage());
			userNameKorisnika = "";
			throw new RuntimeException(ex);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmIzmjenaGrupa = new JDialog();
		frmIzmjenaGrupa.setModal(true);
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
		list_grupeKorisnika.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ucitajKorisnikeGrupe();
				ucitajFoldereGrupe();
			}
		});
		scrollPane.setViewportView(list_grupeKorisnika);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Izmjena naziva grupe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(216, 11, 459, 96);
		frmIzmjenaGrupa.getContentPane().add(panel);
		
		JLabel lblNoviNaziv = new JLabel("Novi naziv:");
		
		text_noviNazivGrupe = new JTextField();
		text_noviNazivGrupe.setColumns(10);
		
		JButton btnSpremiIzmjenu = new JButton("Spremi izmjenu");
		btnSpremiIzmjenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_grupeKorisnika.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Nije izabrana nijedna grupa za izmjenu!", "Greška", JOptionPane.INFORMATION_MESSAGE);			
					return;
				}
				
				if(text_noviNazivGrupe.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Novi naziv grupe ne može biti prazno polje!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;	
				}
				
				if(grupaRep.dajGrupuPoNazivu(text_noviNazivGrupe.getText()) != null)
				{
					JOptionPane.showMessageDialog(null, "Grupa sa navedenim nazivom postoji! Izaberite drugo ime grupe!", "Greška", JOptionPane.INFORMATION_MESSAGE);			
					return;
				}	
				
				GrupaDbModel grupaZaIzmjenu = (GrupaDbModel)listaGrupaKorisnika.getElementAt(list_grupeKorisnika.getSelectedIndex());
				grupaZaIzmjenu.setGrupaNaziv(text_noviNazivGrupe.getText());
				grupaRep.azurirajGrupu(grupaZaIzmjenu);
				text_noviNazivGrupe.setText("");
				ucitajGrupeKorisnika(userNameKorisnika);
				
					
			}
		});
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
		btnBrisanjeGrupe.setBounds(49, 410, 157, 30);
		frmIzmjenaGrupa.getContentPane().add(btnBrisanjeGrupe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Izmjena korisnika u grupi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(216, 118, 459, 322);
		frmIzmjenaGrupa.getContentPane().add(panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblSviKorisnici = new JLabel("Svi korisnici:");
		
		JButton btnDodajKorisnika = new JButton("Dodaj korisnika");
		btnDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(list_grupeKorisnika.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Nije odabrana grupa u koju će se korisnik dodati!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}	
				if(list_sviKorisnici.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Nije odabran nijedan korisnika za dodavanje iz liste svih korisnika!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(((KorisnikDbModel)list_sviKorisnici.getSelectedValue()).getUsername().equals(userNameKorisnika))
				{
					  JOptionPane.showMessageDialog(null, "Ne možete dodati sebe u vasu grupu!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					  return;
				}	
				//KorisnikDbModel selektovaniKorisnik = (KorisnikDbModel)list_sviKorisnici.getSelectedValue();
				if(grupaRep.daLiPostojiKorisnikUGrupi((int)((KorisnikDbModel)list_sviKorisnici.getSelectedValue()).getKorisnikID(), (int)((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId()))
				{
					JOptionPane.showMessageDialog(null, "Korisnik već postoji u grupi!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				GrupaXKorisnikDbModel novi = new GrupaXKorisnikDbModel();
				novi.setAktivan(true);
				novi.setDatumPristupa(new Date());
				novi.setDatumZadnjeIzmjene(new Date());
				novi.setGrupaId((int)((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId());
				novi.setKorisnikId((int)((KorisnikDbModel)list_sviKorisnici.getSelectedValue()).getKorisnikID());
				
				grupaRep.dodajKorisnikaUGrupu(novi);
				ucitajKorisnikeGrupe();
				JOptionPane.showMessageDialog(null, "Korisnik uspjesno dodan u grupu!", "Info", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblPostojeiKorisniciU = new JLabel("Postojeći korisnici u grupi:");
		
		JButton btnObriiKorisnika = new JButton("Obriši korisnika");
		btnObriiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_grupeKorisnika.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Nije odabrana nijedna grupa, te njeni korisnici ne mogu biti prikazani!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(list_dodaniKorisnici.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Nije odabran nijedan korisnik! Odaberite korisnika za brisanje iz grupe!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				grupaRep.odbrisiKorisnikaIzGrupe((int)((KorisnikDbModel)list_dodaniKorisnici.getSelectedValue()).getKorisnikID(), (int)((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId());
				ucitajKorisnikeGrupe();
			}
		});
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
		panel_2.setBounds(685, 11, 486, 429);
		frmIzmjenaGrupa.getContentPane().add(panel_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblSviFolderi = new JLabel("Svi folderi:");
		
		JButton btnDodajFolder = new JButton("Dodaj folder");
		btnDodajFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list_grupeKorisnika.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Niste selektovali nijednu grupu kojoj dajete prava na folder!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(list_sviFolderi.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Niste selektovali nijedan folder za definisanje prava pristupa!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(!checkBox_Pisanje.isSelected() && !checkBox_Citanje.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Niste definisali prava pristupa!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(!daLiVecPostojiUListiDodanihFoldera((int)((FolderDbModel)list_sviFolderi.getSelectedValue()).getFolderId()))
				{		
					FolderXGrupaDbModel novi = new FolderXGrupaDbModel();
					FolderDbModel trenutni = (FolderDbModel)list_sviFolderi.getSelectedValue();
					
					novi.setFolderId((int)trenutni.getFolderId());
					novi.setAktivan(true);
					novi.setPravoDodavanja(checkBox_Pisanje.isSelected());
					novi.setPravoSkidanja(checkBox_Citanje.isSelected());
					
					List<FolderXGrupaDbModel> listaDefinisanihPravaPristupa = new ArrayList<FolderXGrupaDbModel>();
					listaDefinisanihPravaPristupa.add(novi);
					
					int idNoveGrupe = (int)((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId();
					grupaRep.dodajFolderXGrupaDbModele(listaDefinisanihPravaPristupa, idNoveGrupe);
					ucitajFoldereGrupe();
					
					checkBox_Citanje.setSelected(false);
					checkBox_Pisanje.setSelected(false);
					
					JOptionPane.showMessageDialog(null, "Folder uspješno dodan!", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Folder već postoji među dodanim folderima!", "Greška", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		checkBox_Pisanje = new JCheckBox("Pravo pisanja");
		checkBox_Pisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkBox_Pisanje.isSelected())
					checkBox_Citanje.setSelected(true);
					
			}
		});
		
		checkBox_Citanje = new JCheckBox("Pravo čitanja");
		checkBox_Citanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_Pisanje.isSelected())
					checkBox_Citanje.setSelected(true);
			}
		});
		
		JLabel lblDodaniFolderi = new JLabel("Dodani folderi:");
		
		JButton btnUkloniPravoPristupa = new JButton("Ukloni pravo pristupa");
		btnUkloniPravoPristupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_grupeKorisnika.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Niste selektovali nijednu grupu, te folderi na koje grupa ima pravo ne mogu biti prikazani!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(list_dodaniFolderi.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Niste selektovali nijedan folder kako bi uklonili prava grupe na njega!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int idFoldera = (int)((FolderDbModel)list_dodaniFolderi.getSelectedValue()).getFolderId();
				int idGrupe = (int)((GrupaDbModel)list_grupeKorisnika.getSelectedValue()).getGrupaId();
				grupaRep.oduzmiPravaPristupaGrupeNaFolder(idFoldera, idGrupe);
				ucitajFoldereGrupe();
				
				JOptionPane.showMessageDialog(null, "Uspjesno ste uklonili sva prava pristupa grupe na izabrani folder!", "Info", JOptionPane.INFORMATION_MESSAGE);


			}
		});
		
		lbl_trenutnaPrava = new JLabel("");
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
										.addComponent(checkBox_Citanje)
										.addComponent(checkBox_Pisanje)
										.addComponent(btnDodajFolder, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblSviFolderi))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(lblDodaniFolderi)))
						.addComponent(btnUkloniPravoPristupa, Alignment.TRAILING)
						.addComponent(lbl_trenutnaPrava))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
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
								.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(109)
							.addComponent(checkBox_Pisanje)
							.addGap(18)
							.addComponent(checkBox_Citanje)
							.addGap(18)
							.addComponent(btnDodajFolder)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUkloniPravoPristupa)
					.addGap(18)
					.addComponent(lbl_trenutnaPrava)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		list_dodaniFolderi = new JList(listaDodanihFolderaGrupe);
		list_dodaniFolderi.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String poruka = "";
				if(list_dodaniFolderi.getSelectedIndex() != -1)
				{
					GrupaDbModel grupa = ((GrupaDbModel)list_grupeKorisnika.getSelectedValue());
					FolderDbModel folder = ((FolderDbModel)list_dodaniFolderi.getSelectedValue());
					int prava = grupaRep.dajPravaGrupeNaFolder((int)grupa.getGrupaId(), (int)folder.getFolderId());
					
					if(prava != -1 && prava == 1) // -1 vraca u slucaju greske odredivanja prava
					{
						poruka = "pravo pisanja i čitanja";
					}
					else if(prava != -1 && prava == 2)
					{
						poruka = "pravo čitanja";
					}
					else
					{
						poruka = "";
					}
					
					String nazivGrupe = grupa.getGrupaNaziv();
					String nazivFoldera = folder.getFolderNaziv();
					
					lbl_trenutnaPrava.setText("Grupa " + nazivGrupe + " nad folderom "+nazivFoldera+" ima "+poruka);
					
				}
				else
					lbl_trenutnaPrava.setText("");
			}
		});
		scrollPane_4.setViewportView(list_dodaniFolderi);
		
		list_sviFolderi = new JList(listaSvihFoldera);
		list_sviFolderi.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				int prava = korisnikRep.dajPravaKorisnikaNaFolder(userNameKorisnika, (FolderDbModel)list_sviFolderi.getSelectedValue());
				
				if(prava == 2)
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
		scrollPane_3.setViewportView(list_sviFolderi);
		panel_2.setLayout(gl_panel_2);
	}
}
