package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class DodavanjeKorisnika {

	private JFrame frmDodavanjeizmjenaKorisnika;
	private JTextField txtDodavanjeIme;
	private JTextField txtDodavanjePrezime;
	private JTextField txtDodavanjeAdresa;

	KorisnikRepository korisnikRepository = new KorisnikRepository(null);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKorisnika window = new DodavanjeKorisnika();
					window.frmDodavanjeizmjenaKorisnika.setVisible(true);
				} catch (Exception e) {
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeizmjenaKorisnika = new JFrame();
		frmDodavanjeizmjenaKorisnika.setResizable(false);
		frmDodavanjeizmjenaKorisnika.setTitle("Dodavanje Korisnika");
		frmDodavanjeizmjenaKorisnika.setBounds(100, 100, 439, 399);
		frmDodavanjeizmjenaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeizmjenaKorisnika.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Ime:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(98, 11, 29, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label);
		
		txtDodavanjeIme = new JTextField();
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
		txtDodavanjeAdresa.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtDodavanjeAdresa.setColumns(10);
		txtDodavanjeAdresa.setBounds(133, 81, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(txtDodavanjeAdresa);
		
		JLabel label_3 = new JLabel("Datum Rođenja:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(19, 115, 108, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_3);
		
		JCalendar calendarDodavanjeDatumRodjenja = new JCalendar();
		calendarDodavanjeDatumRodjenja.setBounds(133, 116, 198, 157);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(calendarDodavanjeDatumRodjenja);
		
		JLabel label_4 = new JLabel("Pozicija u Organizaciji:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(10, 287, 117, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_4);
		
		/*--------------------------------------------------------------*/
		//primjer koristenja comboboxa
		JComboBox cmbDodavanjePozicija = new JComboBox();
		cmbDodavanjePozicija.setFont(new Font("Dialog", Font.PLAIN, 11));
		cmbDodavanjePozicija.setBounds(133, 287, 267, 21);
		
		
		for (KorisnikTipDbModel korisnikTip : korisnikRepository.dajSveKorisnikTipove() ) {
			cmbDodavanjePozicija.addItem(korisnikTip);
		}
		
		//kad ti treba selektovano nesto
		//sto ti treba da upises u bazu
		long tipId = ((KorisnikTipDbModel)cmbDodavanjePozicija.getSelectedItem()).getKorisnikTipId();
		/*--------------------------------------------------------------*/
		
		frmDodavanjeizmjenaKorisnika.getContentPane().add(cmbDodavanjePozicija);
		
		JButton btnDodavanjeSpremi = new JButton("Spremi");
		btnDodavanjeSpremi.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnDodavanjeSpremi.setBounds(270, 322, 130, 29);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(btnDodavanjeSpremi);
	}
}
