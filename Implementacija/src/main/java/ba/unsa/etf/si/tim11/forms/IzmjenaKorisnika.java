package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class IzmjenaKorisnika
{

	private JFrame frmIzmjenaKorisnika;
	private JTextField textFieldIzmjenaPretragaKorisnika;
	private JTable tableIzmjenaPretraga;
	private JPasswordField passwordFieldIzmjenaNovaSifra;
	private JPasswordField passwordField_1;
	private JButton buttonIzmjenaTrazi;
	private JButton buttonIzmjenaBrisiKorisnika;

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
					IzmjenaKorisnika window = new IzmjenaKorisnika();
					window.frmIzmjenaKorisnika.setVisible(true);
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
	public IzmjenaKorisnika()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmIzmjenaKorisnika = new JFrame();
		frmIzmjenaKorisnika.setTitle("Izmjena Korisnika");
		frmIzmjenaKorisnika.setBounds(100, 100, 748, 484);
		frmIzmjenaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		tableIzmjenaPretraga.setModel(new DefaultTableModel(
			new Object[][] {
				{"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableIzmjenaPretraga.getColumnModel().getColumn(0).setPreferredWidth(87);
		tableIzmjenaPretraga.getColumnModel().getColumn(4).setPreferredWidth(95);
		tableIzmjenaPretraga.getColumnModel().getColumn(5).setPreferredWidth(115);
		tableIzmjenaPretraga.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableIzmjenaPretraga.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableIzmjenaPretraga.setCellSelectionEnabled(true);
		tableIzmjenaPretraga.setBounds(155, 98, 566, 173);
		frmIzmjenaKorisnika.getContentPane().add(tableIzmjenaPretraga);
		
		JLabel label_1 = new JLabel("Nova Šifra:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(10, 285, 135, 21);
		frmIzmjenaKorisnika.getContentPane().add(label_1);
		
		passwordFieldIzmjenaNovaSifra = new JPasswordField();
		passwordFieldIzmjenaNovaSifra.setFont(new Font("Dialog", Font.PLAIN, 11));
		passwordFieldIzmjenaNovaSifra.setBounds(155, 282, 566, 27);
		frmIzmjenaKorisnika.getContentPane().add(passwordFieldIzmjenaNovaSifra);
		
		JLabel label_2 = new JLabel("Ponovi Šifru:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(52, 323, 95, 21);
		frmIzmjenaKorisnika.getContentPane().add(label_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		passwordField_1.setBounds(155, 320, 566, 27);
		frmIzmjenaKorisnika.getContentPane().add(passwordField_1);
		
		JButton buttonIzmjenaIzmjeniPodatke = new JButton("Izmijeni Podatke");
		buttonIzmjenaIzmjeniPodatke.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaIzmjeniPodatke.setBounds(605, 358, 115, 27);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaIzmjeniPodatke);
		
		buttonIzmjenaTrazi = new JButton("Traži");
		buttonIzmjenaTrazi.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaTrazi.setBounds(626, 50, 95, 29);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaTrazi);
		
		buttonIzmjenaBrisiKorisnika = new JButton("Izbriši Korisnika");
		buttonIzmjenaBrisiKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaBrisiKorisnika.setBounds(605, 396, 116, 27);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaBrisiKorisnika);
		frmIzmjenaKorisnika.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{label, textFieldIzmjenaPretragaKorisnika, buttonIzmjenaTrazi, tableIzmjenaPretraga, label_1, passwordFieldIzmjenaNovaSifra, label_2, passwordField_1, buttonIzmjenaIzmjeniPodatke, buttonIzmjenaBrisiKorisnika}));
	}
}
