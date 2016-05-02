package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Pretraga
{

	private JFrame frmPretragaizvjetaji;
	private JTextField textFieldPretragaKorisnik;
	private JTable tablePretragaDokumenti;

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
					Pretraga window = new Pretraga();
					window.frmPretragaizvjetaji.setVisible(true);
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
	public Pretraga()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmPretragaizvjetaji = new JFrame();
		frmPretragaizvjetaji.setTitle("Pretraga/Izvještaji");
		frmPretragaizvjetaji.setResizable(false);
		frmPretragaizvjetaji.setBounds(100, 100, 596, 458);
		frmPretragaizvjetaji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPretragaizvjetaji.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Početni Datum:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(10, 11, 71, 21);
		frmPretragaizvjetaji.getContentPane().add(label);
		
		JCalendar calendarPretragaPocetni = new JCalendar();
		calendarPretragaPocetni.setBounds(91, 11, 198, 157);
		frmPretragaizvjetaji.getContentPane().add(calendarPretragaPocetni);
		
		JLabel label_1 = new JLabel("Krajnji Datum:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(299, 11, 65, 21);
		frmPretragaizvjetaji.getContentPane().add(label_1);
		
		JCalendar calendarPretragaKrajnji = new JCalendar();
		calendarPretragaKrajnji.setBounds(374, 11, 198, 157);
		frmPretragaizvjetaji.getContentPane().add(calendarPretragaKrajnji);
		
		JLabel label_2 = new JLabel("Korisnik:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(40, 187, 41, 21);
		frmPretragaizvjetaji.getContentPane().add(label_2);
		
		textFieldPretragaKorisnik = new JTextField();
		textFieldPretragaKorisnik.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldPretragaKorisnik.setColumns(10);
		textFieldPretragaKorisnik.setBounds(91, 185, 350, 21);
		frmPretragaizvjetaji.getContentPane().add(textFieldPretragaKorisnik);
		
		JButton buttonPretragaTrazi = new JButton("Traži");
		buttonPretragaTrazi.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonPretragaTrazi.setBounds(458, 185, 114, 24);
		frmPretragaizvjetaji.getContentPane().add(buttonPretragaTrazi);
		
		JLabel label_3 = new JLabel("Dokumenti:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(29, 219, 52, 21);
		frmPretragaizvjetaji.getContentPane().add(label_3);
		
		tablePretragaDokumenti = new JTable();
		tablePretragaDokumenti.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID Dokumenta", "Naziv Dokumenta", "Verzija", "Korisnik Postavio", "Datum Postavljanja"},
				{null, null, null, null, null},
			},
			new String[] {
				"ID Dokumenta", "Naziv Dokumenta", "Verzija", "Korisnik Postavio", "Datum Postavljanja"
			}
		));
		tablePretragaDokumenti.getColumnModel().getColumn(1).setPreferredWidth(99);
		tablePretragaDokumenti.getColumnModel().getColumn(3).setPreferredWidth(99);
		tablePretragaDokumenti.getColumnModel().getColumn(4).setPreferredWidth(103);
		tablePretragaDokumenti.setBounds(91, 217, 481, 121);
		frmPretragaizvjetaji.getContentPane().add(tablePretragaDokumenti);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tip Izvještaja", "Korisnik", "Dokument", "Zahtjev", "Odobrenje"}));
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		comboBox.setBounds(458, 349, 114, 27);
		frmPretragaizvjetaji.getContentPane().add(comboBox);
		
		JButton button_1 = new JButton("Kreiraj Izvještaj");
		button_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		button_1.setBounds(458, 387, 114, 29);
		frmPretragaizvjetaji.getContentPane().add(button_1);
	}
}
