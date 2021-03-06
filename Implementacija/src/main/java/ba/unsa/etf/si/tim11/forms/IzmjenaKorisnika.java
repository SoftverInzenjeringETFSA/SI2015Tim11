package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.Validator;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

@SuppressWarnings("unused")
public class IzmjenaKorisnika
{

	private JDialog frmIzmjenaKorisnika;
	private JTextField textFieldIzmjenaPretragaKorisnika;
	private JTable tableIzmjenaPretraga;
	private JPasswordField passwordFieldIzmjenaNovaSifra;
	private JPasswordField passwordFieldIzmjenaPonoviSifru;
	private JButton buttonIzmjenaTrazi;
	private JButton buttonIzmjenaBrisiKorisnika;
	
	final static Logger logger = Logger.getLogger(IzmjenaKorisnika.class.toString());
	KorisnikRepository korisnikRepository = new KorisnikRepository();
	KorisnikDbModel korisnik;
	Integer korisnikId;
	
	private Boolean uredu[]={false,false};//Niz za provjeru da li su polja ispravno popunjena
	
	//Funkcija koja provjerava da li su svi elementi niza "uredu" postavljeni na true ili false
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
					IzmjenaKorisnika window = new IzmjenaKorisnika();
					window.frmIzmjenaKorisnika.setVisible(true);
				} 
				catch (RuntimeException e) 
				{
					throw e;
				}
				catch (Exception e)
				{
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
	public IzmjenaKorisnika()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmIzmjenaKorisnika = new JDialog();
		frmIzmjenaKorisnika.setModal(true);
		frmIzmjenaKorisnika.setTitle("Izmjena Korisnika");
		frmIzmjenaKorisnika.setBounds(100, 100, 748, 516);
		frmIzmjenaKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIzmjenaKorisnika.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Pretraga Korisnika:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(10, 55, 135, 21);
		frmIzmjenaKorisnika.getContentPane().add(label);
		
		textFieldIzmjenaPretragaKorisnika = new JTextField();
		textFieldIzmjenaPretragaKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldIzmjenaPretragaKorisnika.setColumns(10);
		textFieldIzmjenaPretragaKorisnika.setBounds(155, 52, 461, 27);
		frmIzmjenaKorisnika.getContentPane().add(textFieldIzmjenaPretragaKorisnika);
		
		tableIzmjenaPretraga = new JTable();		
		tableIzmjenaPretraga.setToolTipText("Izmjene u tabeli imaju iste validacije kao i unos korisnika.");
		tableIzmjenaPretraga.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
			},
			new String[] {
			}
		));
		tableIzmjenaPretraga.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableIzmjenaPretraga.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableIzmjenaPretraga.setCellSelectionEnabled(true);
		tableIzmjenaPretraga.setBounds(155, 114, 566, 157);
		frmIzmjenaKorisnika.getContentPane().add(tableIzmjenaPretraga);
		
		JLabel label_1 = new JLabel("Nova Šifra:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(10, 328, 135, 21);
		frmIzmjenaKorisnika.getContentPane().add(label_1);
		
		passwordFieldIzmjenaNovaSifra = new JPasswordField();
		passwordFieldIzmjenaNovaSifra.setFont(new Font("Dialog", Font.PLAIN, 11));
		passwordFieldIzmjenaNovaSifra.setBounds(155, 325, 510, 27);
		frmIzmjenaKorisnika.getContentPane().add(passwordFieldIzmjenaNovaSifra);
		
		JLabel label_2 = new JLabel("Ponovi Šifru:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(52, 366, 95, 21);
		frmIzmjenaKorisnika.getContentPane().add(label_2);
		
		passwordFieldIzmjenaPonoviSifru = new JPasswordField();
		
		passwordFieldIzmjenaPonoviSifru.setFont(new Font("Dialog", Font.PLAIN, 11));
		passwordFieldIzmjenaPonoviSifru.setBounds(155, 363, 510, 27);
		frmIzmjenaKorisnika.getContentPane().add(passwordFieldIzmjenaPonoviSifru);
		
		final JButton buttonIzmjenaIzmjeniSifru = new JButton("Izmijeni Šifru");
		
		buttonIzmjenaIzmjeniSifru.setEnabled(false);
		buttonIzmjenaIzmjeniSifru.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaIzmjeniSifru.setBounds(605, 401, 115, 27);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaIzmjeniSifru);
		
		final JLabel lblIzmjenaPretraga = new JLabel("");
		lblIzmjenaPretraga.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblIzmjenaPretraga.setBounds(155, 27, 461, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblIzmjenaPretraga);
		frmIzmjenaKorisnika.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{label, textFieldIzmjenaPretragaKorisnika, buttonIzmjenaTrazi, tableIzmjenaPretraga, label_1, passwordFieldIzmjenaNovaSifra, label_2, passwordFieldIzmjenaPonoviSifru, buttonIzmjenaIzmjeniSifru, buttonIzmjenaBrisiKorisnika}));
		
		buttonIzmjenaTrazi = new JButton("Traži");
		buttonIzmjenaTrazi.setEnabled(false);
		
		buttonIzmjenaTrazi.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaTrazi.setBounds(626, 50, 95, 29);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaTrazi);
		
		buttonIzmjenaBrisiKorisnika = new JButton("Izbriši Korisnika");
		buttonIzmjenaBrisiKorisnika.setEnabled(false);
		buttonIzmjenaBrisiKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaBrisiKorisnika.setBounds(605, 439, 116, 27);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaBrisiKorisnika);
		
		final JButton btnIzmijeniKorisnika = new JButton("Spremi Promjene");
		btnIzmijeniKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnIzmijeniKorisnika.setEnabled(false);
		btnIzmijeniKorisnika.setBounds(605, 282, 116, 27);
		frmIzmjenaKorisnika.getContentPane().add(btnIzmijeniKorisnika);
		
		final JLabel lblOKNS = new JLabel("");
		lblOKNS.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblOKNS.setBounds(675, 332, 46, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblOKNS);
		
		final JLabel labelOKPS = new JLabel("");
		labelOKPS.setFont(new Font("Dialog", Font.PLAIN, 11));
		labelOKPS.setBounds(675, 370, 46, 14);
		frmIzmjenaKorisnika.getContentPane().add(labelOKPS);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(155, 90, 46, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(239, 89, 62, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblPrezime);
		
		JLabel lblDatumRoenja = new JLabel("Datum Rođenja");
		lblDatumRoenja.setBounds(311, 89, 95, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblDatumRoenja);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(425, 90, 46, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblAdresa);
		
		JLabel lblTipKorisnika = new JLabel("Tip Korisnika");
		lblTipKorisnika.setBounds(481, 90, 79, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblTipKorisnika);
		
		JLabel lblPozicijaKorisnika = new JLabel("Pozicija");
		lblPozicijaKorisnika.setBounds(586, 90, 51, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblPozicijaKorisnika);
		
		JLabel lblAktivan = new JLabel("Aktivan");
		lblAktivan.setBounds(675, 89, 46, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblAktivan);
		
		//Events
		
		buttonIzmjenaTrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String pretraga=textFieldIzmjenaPretragaKorisnika.getText();
					if(korisnikRepository.dajIdKorisnikaPoUsername(pretraga)!=null)
					{
						korisnikId=korisnikRepository.dajIdKorisnikaPoUsername(pretraga);
						korisnik=korisnikRepository.dajKorisnika(korisnikId);
						ModelTabele mt=new ModelTabele();
						mt.dodajElement(korisnik);
						tableIzmjenaPretraga.setModel(mt);
						buttonIzmjenaBrisiKorisnika.setEnabled(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(frmIzmjenaKorisnika,"Nema korisnika s tim korisničkim imenom!");
						textFieldIzmjenaPretragaKorisnika.setText("");
						buttonIzmjenaBrisiKorisnika.setEnabled(false);
						ModelTabele mt=new ModelTabele();
						tableIzmjenaPretraga.setModel(mt);
						btnIzmijeniKorisnika.setEnabled(false);
					}
				}
				catch (RuntimeException e) 
				{
					throw e;
				}
				catch(Exception e)
				{
					String poruka=e.getMessage();
					logger.info(poruka);
					JOptionPane.showMessageDialog(frmIzmjenaKorisnika,poruka);
					throw new RuntimeException(e);
				}
				
			}
		});
		
		textFieldIzmjenaPretragaKorisnika.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pretraga=textFieldIzmjenaPretragaKorisnika.getText();
				if(!Validator.daLiJeStringPrazan(pretraga)&&Validator.daLiJeStringSlovaIBrojevi(pretraga))
				{
					lblIzmjenaPretraga.setText("OK");
					lblIzmjenaPretraga.setForeground(new Color(0, 128, 0));
					buttonIzmjenaTrazi.setEnabled(true);
					
					
				}
				else
				{
					lblIzmjenaPretraga.setForeground(Color.red);
					lblIzmjenaPretraga.setText("Niste unijeli korisničko ime za pretragu");
					buttonIzmjenaTrazi.setEnabled(false);
					
				}
			}
		});
		
		buttonIzmjenaBrisiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog(frmIzmjenaKorisnika, "Da li ste sigurni da želite obrisati korisnika?");
				if(dialogResult==JOptionPane.YES_OPTION)
				{
					korisnikRepository.obrisiKorisnika(korisnikId);
					ModelTabele mt=new ModelTabele();
					tableIzmjenaPretraga.setModel(mt);
					textFieldIzmjenaPretragaKorisnika.setText("");
					buttonIzmjenaBrisiKorisnika.setEnabled(false);
					btnIzmijeniKorisnika.setEnabled(false);
				}
								
			}
		});
		
		btnIzmijeniKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				korisnikRepository.izmijeniKorisnika(korisnik);
				JOptionPane.showMessageDialog(frmIzmjenaKorisnika, "Podaci spremljeni");
				ModelTabele mt=new ModelTabele();
				tableIzmjenaPretraga.setModel(mt);
				textFieldIzmjenaPretragaKorisnika.setText("");
				buttonIzmjenaBrisiKorisnika.setEnabled(false);
				btnIzmijeniKorisnika.setEnabled(false);
				
			}
		});
		
		tableIzmjenaPretraga.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
					if(!korisnik.equals(null))
					{
						btnIzmijeniKorisnika.setEnabled(true);
					}
			}
		});
		
		
		passwordFieldIzmjenaNovaSifra.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent arg0) {
				String s=passwordFieldIzmjenaNovaSifra.getText();
				if(!Validator.daLiJeStringPrazan(s))
				{
					lblOKNS.setText("OK");
					lblOKNS.setForeground(new Color(0, 128, 0));
					uredu[0]=true;
				}
				else
				{
					lblOKNS.setText("NOTOK");
					lblOKNS.setForeground(Color.red);
					uredu[0]=false;
				}
				if(provjeriPolja())
				{
					buttonIzmjenaIzmjeniSifru.setEnabled(true);
				}
				else
				{
					buttonIzmjenaIzmjeniSifru.setEnabled(false);
				}
				
			}
		});
		
		passwordFieldIzmjenaPonoviSifru.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent arg0) {
				String s1=passwordFieldIzmjenaPonoviSifru.getText();
				String s2=passwordFieldIzmjenaNovaSifra.getText();
				
				if(!Validator.daLiJeStringPrazan(s1)&&!Validator.daLiJeStringPrazan(s2)&&s1.equals(s2))
				{
					labelOKPS.setText("OK");
					labelOKPS.setForeground(new Color(0, 128, 0));
					uredu[1]=true;
				}
				else
				{
					labelOKPS.setText("NOTOK");
					labelOKPS.setForeground(Color.red);
					uredu[1]=false;
				}
				if(provjeriPolja())
				{
					buttonIzmjenaIzmjeniSifru.setEnabled(true);
				}
				else
				{
					buttonIzmjenaIzmjeniSifru.setEnabled(false);
				}
			}
		});
		
		buttonIzmjenaIzmjeniSifru.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				korisnik.setPassword(passwordFieldIzmjenaPonoviSifru.getText());
				korisnikRepository.izmijeniKorisnika(korisnik);
				passwordFieldIzmjenaNovaSifra.setText("");
				passwordFieldIzmjenaPonoviSifru.setText("");
				JOptionPane.showMessageDialog(frmIzmjenaKorisnika, "Sifra Promijenjena");
				ModelTabele mt=new ModelTabele();
				tableIzmjenaPretraga.setModel(mt);
				textFieldIzmjenaPretragaKorisnika.setText("");
				buttonIzmjenaIzmjeniSifru.setEnabled(false);
				buttonIzmjenaBrisiKorisnika.setEnabled(false);
				btnIzmijeniKorisnika.setEnabled(false);
				for(int i=0;i<uredu.length;i++)
				{
					uredu[i]=false;
				}
			}
		});
		
		
	}
}
