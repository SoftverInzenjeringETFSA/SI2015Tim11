package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import com.toedter.calendar.JCalendar;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DodavanjeKorisnika {

	private JFrame frmDodavanjeizmjenaKorisnika;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtAdresa;

	/**
	 * Launch the application.
	 */
	public static void PokreniFormu() {
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
		frmDodavanjeizmjenaKorisnika.setTitle("Dodavanje/Izmjena korisnika");
		frmDodavanjeizmjenaKorisnika.setBounds(100, 100, 439, 399);
		frmDodavanjeizmjenaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeizmjenaKorisnika.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Ime:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(98, 11, 29, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label);
		
		txtIme = new JTextField();
		txtIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtIme.setColumns(10);
		txtIme.setBounds(133, 11, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(txtIme);
		
		JLabel label_1 = new JLabel("Prezime:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(65, 46, 62, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_1);
		
		txtPrezime = new JTextField();
		txtPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPrezime.setColumns(10);
		txtPrezime.setBounds(133, 43, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(txtPrezime);
		
		JLabel label_2 = new JLabel("Adresa:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(72, 81, 55, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_2);
		
		txtAdresa = new JTextField();
		txtAdresa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAdresa.setColumns(10);
		txtAdresa.setBounds(133, 81, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(txtAdresa);
		
		JLabel label_3 = new JLabel("Datum Rođenja:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(19, 115, 108, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_3);
		
		JCalendar calendarDatumRodjenja = new JCalendar();
		calendarDatumRodjenja.setBounds(133, 116, 198, 157);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(calendarDatumRodjenja);
		
		JLabel label_4 = new JLabel("Pozicija u Organizaciji:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(10, 290, 117, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(label_4);
		
		JComboBox cmbPozicija = new JComboBox();
		cmbPozicija.setFont(new Font("Dialog", Font.PLAIN, 16));
		cmbPozicija.setBounds(133, 287, 267, 21);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(cmbPozicija);
		
		JButton btnSpremi = new JButton("Spremi");
		btnSpremi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSpremi.setBounds(270, 322, 130, 29);
		frmDodavanjeizmjenaKorisnika.getContentPane().add(btnSpremi);
	}
}
