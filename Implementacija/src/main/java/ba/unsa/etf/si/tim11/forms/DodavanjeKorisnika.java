package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import com.toedter.calendar.JCalendar;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import ba.unsa.etf.si.tim11.dbmodels.Validator;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DodavanjeKorisnika {

	private JFrame frmDodavanjeizmjenaKorisnika;
	private JTextField txtDodavanjeIme;
	private JTextField txtDodavanjePrezime;
	private JTextField txtDodavanjeAdresa;
	private JTextField textFieldDodavanjeKorisnikaUsername;
	private JPasswordField passwordFieldDodavanjeKorisnikaPass;
	private JPasswordField passwordFieldDodavanjePonoviSifru;

	KorisnikRepository korisnikRepository = new KorisnikRepository();
	
	/**
	 * Launch the application.
	 */	
	public void pokreniFormu()
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					DodavanjeKorisnika window = new DodavanjeKorisnika();
					window.frmDodavanjeizmjenaKorisnika.setVisible(true);
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
	public DodavanjeKorisnika() {
		initialize();
	}
	KorisnikRepository kr=new KorisnikRepository();
	private Boolean uredu[]={false,false,false,false,false,false};//Niz za provjeru validnosti svakog polja
	
	private Boolean provjeriPolja()
	{
		for(int i=0;i<uredu.length;i++)
		{
			if(uredu[i]==false)
			{
				return false;
			}
		}
		return true;
		
	}
	
	
	
	
	/*List<KorisnikPozicijaDbModel> kp = DbDMSContext.getInstance().getKorisnikPozicije().ucitajSve();
	String [] pozicije={kp.get(0).getKorisnikPozicijaNaziv(),kp.get(1).getKorisnikPozicijaNaziv(),kp.get(2).getKorisnikPozicijaNaziv()};
	*/		
	/*List<KorisnikTipDbModel> kt= DbDMSContext.getInstance().getKorisnikTipovi().ucitajSve();
	String [] tipovi={kt.get(0).getKorisnikTipNaziv(),kt.get(1).getKorisnikTipNaziv()};*/
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeizmjenaKorisnika = new JFrame();
		frmDodavanjeizmjenaKorisnika.setResizable(false);
		frmDodavanjeizmjenaKorisnika.setTitle("Dodavanje Korisnika");
		frmDodavanjeizmjenaKorisnika.setBounds(100, 100, 485, 529);
		frmDodavanjeizmjenaKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDodavanjeizmjenaKorisnika.getContentPane().setLayout(null);
		
		
		final JButton btnDodavanjeSpremi = new JButton("Spremi");
		btnDodavanjeSpremi.setEnabled(false);
		
		final JLabel lblOkIme = new JLabel("");
		lblOkIme.setForeground(new Color(0, 128, 0));
		lblOkIme.setToolTipText("Ime može sadržavati samo slova");
		lblOkIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOkIme.setBounds(410, 15, 59, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(lblOkIme);
		
		final JLabel labelOkPrezime = new JLabel("");
		labelOkPrezime.setToolTipText("Prezime Mora sadržavati samo slova");
		labelOkPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		labelOkPrezime.setForeground(new Color(0, 128, 0));
		labelOkPrezime.setBounds(410, 50, 59, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(labelOkPrezime);
		
		final JLabel labelOkAdresa = new JLabel("");
		labelOkAdresa.setToolTipText("Adresa Mora sadržavati samo slova i brojeve");
		labelOkAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		labelOkAdresa.setForeground(new Color(0, 128, 0));
		labelOkAdresa.setBounds(410, 85, 59, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(labelOkAdresa);
		
		final JLabel labelOkUsername = new JLabel("");
		labelOkUsername.setToolTipText("Korisničko ime ne smije biti prazno");
		labelOkUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		labelOkUsername.setForeground(new Color(0, 128, 0));
		labelOkUsername.setBounds(410, 351, 59, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(labelOkUsername);
		
		final JLabel labelOkSifra = new JLabel("");
		labelOkSifra.setToolTipText("Sifra ne smije biti prazna");
		labelOkSifra.setHorizontalAlignment(SwingConstants.RIGHT);
		labelOkSifra.setForeground(new Color(0, 128, 0));
		labelOkSifra.setBounds(410, 382, 59, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(labelOkSifra);
		
		final JLabel labelOkPonoviSifru = new JLabel("");
		labelOkPonoviSifru.setToolTipText("Ponovna sifra ne smije biti prazna i mora biti ista kao sifra");
		labelOkPonoviSifru.setHorizontalAlignment(SwingConstants.RIGHT);
		labelOkPonoviSifru.setForeground(new Color(0, 128, 0));
		labelOkPonoviSifru.setBounds(410, 415, 59, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(labelOkPonoviSifru);
		
		JLabel label = new JLabel("Ime:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(98, 11, 29, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label);
		
		
		txtDodavanjeIme = new JTextField();
		txtDodavanjeIme.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
								
				String s=txtDodavanjeIme.getText();
				if(!Validator.daLiJeStringPrazan(s)&&Validator.daLiJeStringSamoSlova(s))
				{
					lblOkIme.setText("OK");
					lblOkIme.setForeground(new Color(0, 128, 0));
					uredu[0]=true;
				}
				else
				{
					lblOkIme.setText("NOTOK");
					lblOkIme.setForeground(Color.red);
					uredu[0]=false;
				}
				if(provjeriPolja())
				{
					btnDodavanjeSpremi.setEnabled(true);
				}
				else
				{
					btnDodavanjeSpremi.setEnabled(false);
				}
			}
		});
		txtDodavanjeIme.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtDodavanjeIme.setColumns(10);
		txtDodavanjeIme.setBounds(133, 11, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(txtDodavanjeIme);
		
		JLabel label_1 = new JLabel("Prezime:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(65, 46, 62, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_1);
		
		txtDodavanjePrezime = new JTextField();
		txtDodavanjePrezime.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String s=txtDodavanjePrezime.getText();
				if(!Validator.daLiJeStringPrazan(s)&&Validator.daLiJeStringSamoSlova(s))
				{
					labelOkPrezime.setText("OK");
					labelOkPrezime.setForeground(new Color(0, 128, 0));
					uredu[1]=true;
				}
				else
				{
					labelOkPrezime.setText("NOTOK");
					labelOkPrezime.setForeground(Color.red);
					uredu[1]=false;
				}
				if(provjeriPolja())
				{
					btnDodavanjeSpremi.setEnabled(true);
				}
				else
				{
					btnDodavanjeSpremi.setEnabled(false);
				}
			}
		});
		txtDodavanjePrezime.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtDodavanjePrezime.setColumns(10);
		txtDodavanjePrezime.setBounds(133, 43, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(txtDodavanjePrezime);
		
		JLabel label_2 = new JLabel("Adresa:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(72, 81, 55, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_2);
		
		txtDodavanjeAdresa = new JTextField();
		txtDodavanjeAdresa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String s=txtDodavanjeAdresa.getText();
				if(!Validator.daLiJeStringPrazan(s)&&Validator.daLiJeStringSlovaIBrojevi(s))
				{
					labelOkAdresa.setText("OK");
					labelOkAdresa.setForeground(new Color(0, 128, 0));
					uredu[2]=true;
				}
				else
				{
					labelOkAdresa.setText("NOTOK");
					labelOkAdresa.setForeground(Color.red);
					uredu[2]=false;
				}
				if(provjeriPolja())
				{
					btnDodavanjeSpremi.setEnabled(true);
				}
				else
				{
					btnDodavanjeSpremi.setEnabled(false);
				}
			}
		});
		txtDodavanjeAdresa.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtDodavanjeAdresa.setColumns(10);
		txtDodavanjeAdresa.setBounds(133, 81, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(txtDodavanjeAdresa);
		
		JLabel label_3 = new JLabel("Datum Rođenja:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(19, 115, 108, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_3);
		
		final JCalendar calendarDodavanjeDatumRodjenja = new JCalendar();
		calendarDodavanjeDatumRodjenja.setBounds(133, 116, 198, 157);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(calendarDodavanjeDatumRodjenja);
		
		JLabel label_4 = new JLabel("Pozicija u Organizaciji:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(10, 315, 117, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_4);
		
		final JComboBox cmbDodavanjePozicija = new JComboBox();
		//cmbDodavanjePozicija.setModel(new DefaultComboBoxModel(pozicije));
		cmbDodavanjePozicija.setFont(new Font("Dialog", Font.PLAIN, 11));
		cmbDodavanjePozicija.setBounds(133, 315, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(cmbDodavanjePozicija);
		
		for(KorisnikPozicijaDbModel kPozicija:kr.dajSvePozicijeKorisnika())
		{
			cmbDodavanjePozicija.addItem(kPozicija);
		}
		
		
		JLabel lblKorisnikoIme = new JLabel("Korisničko Ime:");
		lblKorisnikoIme.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblKorisnikoIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKorisnikoIme.setBounds(45, 350, 84, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(lblKorisnikoIme);
		
		textFieldDodavanjeKorisnikaUsername = new JTextField();
		textFieldDodavanjeKorisnikaUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String s=textFieldDodavanjeKorisnikaUsername.getText();
				if(!Validator.daLiJeStringPrazan(s)&&Validator.daLiJeStringSlovaIBrojevi(s))
				{
					labelOkUsername.setText("OK");
					labelOkUsername.setForeground(new Color(0, 128, 0));
					uredu[3]=true;
				}
				else
				{
					labelOkUsername.setText("NOTOK");
					labelOkUsername.setForeground(Color.red);
					uredu[3]=false;
				}
				if(provjeriPolja())
				{
					btnDodavanjeSpremi.setEnabled(true);
				}
				else
				{
					btnDodavanjeSpremi.setEnabled(false);
				}
			}
		});
		textFieldDodavanjeKorisnikaUsername.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldDodavanjeKorisnikaUsername.setBounds(133, 347, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(textFieldDodavanjeKorisnikaUsername);
		textFieldDodavanjeKorisnikaUsername.setColumns(10);
		
		JLabel lblifra = new JLabel("Šifra:");
		lblifra.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblifra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblifra.setBounds(81, 381, 46, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(lblifra);
		
		passwordFieldDodavanjeKorisnikaPass = new JPasswordField();
		passwordFieldDodavanjeKorisnikaPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				char s[]=passwordFieldDodavanjeKorisnikaPass.getPassword();
				if(!Validator.daLiJeNizPrazan(s))
				{
					labelOkSifra.setText("OK");
					labelOkSifra.setForeground(new Color(0, 128, 0));
					uredu[4]=true;
				}
				else
				{
					labelOkSifra.setText("NOTOK");
					labelOkSifra.setForeground(Color.red);
					uredu[4]=false;
				}
				if(provjeriPolja())
				{
					btnDodavanjeSpremi.setEnabled(true);
				}
				else
				{
					btnDodavanjeSpremi.setEnabled(false);
				}
			}
		});
		passwordFieldDodavanjeKorisnikaPass.setFont(new Font("Dialog", Font.PLAIN, 11));
		passwordFieldDodavanjeKorisnikaPass.setBounds(133, 381, 267, 20);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(passwordFieldDodavanjeKorisnikaPass);
		
		JLabel lblPonoviifru = new JLabel("Ponovi Šifru:");
		lblPonoviifru.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPonoviifru.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPonoviifru.setBounds(65, 414, 62, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(lblPonoviifru);
		
		passwordFieldDodavanjePonoviSifru = new JPasswordField();
		passwordFieldDodavanjePonoviSifru.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				char s1[]=passwordFieldDodavanjePonoviSifru.getPassword();
				char s2[]=passwordFieldDodavanjeKorisnikaPass.getPassword();
				
				if(!Validator.daLiJeNizPrazan(s1)&&!Validator.daLiJeNizPrazan(s2)&&Validator.istiNizovi(s1,s2))
				{
					labelOkPonoviSifru.setText("OK");
					labelOkPonoviSifru.setForeground(new Color(0, 128, 0));
					uredu[5]=true;
				}
				else
				{
					labelOkPonoviSifru.setText("NOTOK");
					labelOkPonoviSifru.setForeground(Color.red);
					uredu[5]=false;
				}
				if(provjeriPolja())
				{
					btnDodavanjeSpremi.setEnabled(true);
				}
				else
				{
					btnDodavanjeSpremi.setEnabled(false);
				}
			}
		});
		passwordFieldDodavanjePonoviSifru.setBounds(133, 412, 267, 20);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(passwordFieldDodavanjePonoviSifru);
		
		JLabel lblTipKorisnika = new JLabel("Tip Korisnika:");
		lblTipKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblTipKorisnika.setBounds(45, 286, 82, 14);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(lblTipKorisnika);
		
		final JComboBox comboBoxDodavanjeTip = new JComboBox();
		comboBoxDodavanjeTip.setFont(new Font("Dialog", Font.PLAIN, 11));
		comboBoxDodavanjeTip.setBounds(133, 284, 267, 20);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(comboBoxDodavanjeTip);
		
		for(KorisnikTipDbModel kTip:kr.dajSveTipoveKorisnika())
		{
			comboBoxDodavanjeTip.addItem(kTip);
		}
		
		btnDodavanjeSpremi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String ime=txtDodavanjeIme.getText();
					String prezime=txtDodavanjePrezime.getText();
					String adresa=txtDodavanjeAdresa.getText();
					Date datumRodjenja=calendarDodavanjeDatumRodjenja.getDate();
					Integer korisnikTipId=(int)((KorisnikTipDbModel)comboBoxDodavanjeTip.getSelectedItem()).getKorisnikTipId();
					//Integer korisnikTipId=comboBoxDodavanjeTip.getSelectedIndex()+1;
					Integer korisnikPozicijaId=(int)((KorisnikPozicijaDbModel)cmbDodavanjePozicija.getSelectedItem()).getKorisnikPozicijaId();
					
					String username=textFieldDodavanjeKorisnikaUsername.getText();
					String sifra=passwordFieldDodavanjeKorisnikaPass.getText();
					String ponovnaSifra=passwordFieldDodavanjePonoviSifru.getText().toString();
					String porukaUspjeh="Uspjesno ste spremili korisnika";
					String porukaNe="Greska prilikom spremanja korisnika";
					KorisnikDbModel k=new KorisnikDbModel();
					k.setIme(ime);
					k.setPrezime(prezime);
					k.setAdresa(adresa);
					k.setDatumRodjenja(datumRodjenja);
					k.setUsername(username);
					k.setPassword(sifra);
					k.setKorisnikTipId(korisnikTipId);
					k.setKorisnikPozicijaId(korisnikPozicijaId);
					k.setAktivan(true);
					kr.dodajKorisnika(k);
					JOptionPane.showMessageDialog(frmDodavanjeizmjenaKorisnika, porukaUspjeh);
					txtDodavanjeIme.setText("");
					txtDodavanjePrezime.setText("");
					txtDodavanjeAdresa.setText("");
					calendarDodavanjeDatumRodjenja.setDate(null);
					comboBoxDodavanjeTip.setSelectedIndex(0);
					cmbDodavanjePozicija.setSelectedIndex(0);
					textFieldDodavanjeKorisnikaUsername.setText("");
					passwordFieldDodavanjeKorisnikaPass.setText("");
					passwordFieldDodavanjePonoviSifru.setText("");
					
					
				}
				catch(Exception e)
				{
					String poruka=e.getMessage();
					JOptionPane.showMessageDialog(frmDodavanjeizmjenaKorisnika,poruka);
				}
				
			}
		});
		btnDodavanjeSpremi.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnDodavanjeSpremi.setBounds(270, 450, 130, 29);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(btnDodavanjeSpremi);
		
		
		
		
	}
}
