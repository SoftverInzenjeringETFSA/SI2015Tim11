package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class ZahtjevZaOdobrenje
{

	private JFrame frmZahtjevZaOdobrenje;
	private JTextField textFieldZahtjevPretragaKorisnici;
	private JTable tableZahtjevKorisnici;
	private JTextField textFieldZahtjevPretragaDokumenti;
	private JTable tableZahtjevDokumenti;
	private JTextField textFieldZahtjevPoruka;
	final static Logger logger = Logger.getLogger(ZahtjevZaOdobrenje.class.toString());
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
					ZahtjevZaOdobrenje window = new ZahtjevZaOdobrenje();
					window.frmZahtjevZaOdobrenje.setVisible(true);
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
	public ZahtjevZaOdobrenje()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmZahtjevZaOdobrenje = new JFrame();
		frmZahtjevZaOdobrenje.setTitle("Zahtjev za Odobrenje");
		frmZahtjevZaOdobrenje.setResizable(false);
		frmZahtjevZaOdobrenje.setBounds(100, 100, 632, 528);
		frmZahtjevZaOdobrenje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZahtjevZaOdobrenje.getContentPane().setLayout(null);
		
		JLabel lblPretragaKorisnika = new JLabel("Pretraga Korisnika:");
		lblPretragaKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPretragaKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPretragaKorisnika.setBounds(22, 17, 94, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(lblPretragaKorisnika);
		
		textFieldZahtjevPretragaKorisnici = new JTextField();
		textFieldZahtjevPretragaKorisnici.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldZahtjevPretragaKorisnici.setColumns(10);
		textFieldZahtjevPretragaKorisnici.setBounds(126, 17, 383, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(textFieldZahtjevPretragaKorisnici);
		
		JButton buttonZahtjevTraziKorisnika = new JButton("Traži");
		buttonZahtjevTraziKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonZahtjevTraziKorisnika.setBounds(519, 17, 60, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(buttonZahtjevTraziKorisnika);
		
		JLabel label_1 = new JLabel("Korisnici:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(62, 55, 54, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(label_1);
		
		tableZahtjevKorisnici = new JTable();
		tableZahtjevKorisnici.setModel(new DefaultTableModel(
			new Object[][] {
				{"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"
			}
		));
		tableZahtjevKorisnici.getColumnModel().getColumn(0).setPreferredWidth(83);
		tableZahtjevKorisnici.getColumnModel().getColumn(1).setPreferredWidth(57);
		tableZahtjevKorisnici.getColumnModel().getColumn(4).setPreferredWidth(91);
		tableZahtjevKorisnici.getColumnModel().getColumn(5).setPreferredWidth(119);
		tableZahtjevKorisnici.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableZahtjevKorisnici.setBounds(126, 59, 453, 125);
		frmZahtjevZaOdobrenje.getContentPane().add(tableZahtjevKorisnici);
		
		JLabel label_2 = new JLabel("Pretraga Dokumenata:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(10, 197, 106, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(label_2);
		
		textFieldZahtjevPretragaDokumenti = new JTextField();
		textFieldZahtjevPretragaDokumenti.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldZahtjevPretragaDokumenti.setColumns(10);
		textFieldZahtjevPretragaDokumenti.setBounds(126, 197, 383, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(textFieldZahtjevPretragaDokumenti);
		
		JButton buttonZahtjevTraziDokument = new JButton("Traži");
		buttonZahtjevTraziDokument.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonZahtjevTraziDokument.setBounds(519, 197, 60, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(buttonZahtjevTraziDokument);
		
		JLabel label_3 = new JLabel("Dokumenti:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(56, 229, 60, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(label_3);
		
		tableZahtjevDokumenti = new JTable();
		tableZahtjevDokumenti.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID Dokumenta", "Naziv Dokumenta", "Verzija Dokumenta", "Korisnik Postavio", "Datum Postavljanja"},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID Dokumenta", "Naziv Dokumenta", "Verzija Dokumenta", "Korisnik Postavio", "Datum Postavljanja"
			}
		));
		tableZahtjevDokumenti.getColumnModel().getColumn(0).setPreferredWidth(89);
		tableZahtjevDokumenti.getColumnModel().getColumn(1).setPreferredWidth(99);
		tableZahtjevDokumenti.getColumnModel().getColumn(2).setPreferredWidth(105);
		tableZahtjevDokumenti.getColumnModel().getColumn(3).setPreferredWidth(97);
		tableZahtjevDokumenti.getColumnModel().getColumn(4).setPreferredWidth(109);
		tableZahtjevDokumenti.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableZahtjevDokumenti.setBounds(126, 233, 455, 96);
		frmZahtjevZaOdobrenje.getContentPane().add(tableZahtjevDokumenti);
		
		JLabel label_4 = new JLabel("Poruka:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(70, 339, 46, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(label_4);
		
		textFieldZahtjevPoruka = new JTextField();
		textFieldZahtjevPoruka.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldZahtjevPoruka.setColumns(10);
		textFieldZahtjevPoruka.setBounds(126, 340, 455, 63);
		frmZahtjevZaOdobrenje.getContentPane().add(textFieldZahtjevPoruka);
		
		JCheckBox checkBoxZahtjevZaPrikaz = new JCheckBox("Prikazivanje");
		checkBoxZahtjevZaPrikaz.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxZahtjevZaPrikaz.setBounds(126, 437, 83, 17);
		frmZahtjevZaOdobrenje.getContentPane().add(checkBoxZahtjevZaPrikaz);
		
		JButton buttonZahtjevPosaljiZahtjev = new JButton("Pošalji Zahtjev");
		buttonZahtjevPosaljiZahtjev.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonZahtjevPosaljiZahtjev.setBounds(473, 435, 106, 21);
		frmZahtjevZaOdobrenje.getContentPane().add(buttonZahtjevPosaljiZahtjev);
	}

}
