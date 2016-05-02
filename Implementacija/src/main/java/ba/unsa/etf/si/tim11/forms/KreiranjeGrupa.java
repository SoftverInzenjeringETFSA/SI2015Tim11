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
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class KreiranjeGrupa
{

	private JFrame frmKreiranjeGrupa;
	private JTextField textFieldKreiranjeGrupaPretraga;
	private JTextField textFieldKreiranjeGrupaNaziv;
	private JTable tableKreiranjeGrupaKorisnici;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmKreiranjeGrupa = new JFrame();
		frmKreiranjeGrupa.setResizable(false);
		frmKreiranjeGrupa.setTitle("Kreiranje Grupa");
		frmKreiranjeGrupa.setBounds(100, 100, 646, 448);
		frmKreiranjeGrupa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKreiranjeGrupa.getContentPane().setLayout(null);
		
		textFieldKreiranjeGrupaPretraga = new JTextField();
		textFieldKreiranjeGrupaPretraga.setColumns(10);
		textFieldKreiranjeGrupaPretraga.setBounds(131, 145, 392, 20);
		frmKreiranjeGrupa.getContentPane().add(textFieldKreiranjeGrupaPretraga);
		
		JTextArea textAreaKreiranjeGrupeOpis = new JTextArea();
		textAreaKreiranjeGrupeOpis.setFont(new Font("Dialog", Font.PLAIN, 16));
		textAreaKreiranjeGrupeOpis.setBounds(131, 51, 489, 83);
		frmKreiranjeGrupa.getContentPane().add(textAreaKreiranjeGrupeOpis);
		
		textFieldKreiranjeGrupaNaziv = new JTextField();
		textFieldKreiranjeGrupaNaziv.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldKreiranjeGrupaNaziv.setColumns(10);
		textFieldKreiranjeGrupaNaziv.setBounds(131, 13, 489, 27);
		frmKreiranjeGrupa.getContentPane().add(textFieldKreiranjeGrupaNaziv);
		
		JButton buttonKreiranjeGrupaTrazi = new JButton("Traži");
		buttonKreiranjeGrupaTrazi.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonKreiranjeGrupaTrazi.setBounds(533, 144, 87, 20);
		frmKreiranjeGrupa.getContentPane().add(buttonKreiranjeGrupaTrazi);
		
		tableKreiranjeGrupaKorisnici = new JTable();
		tableKreiranjeGrupaKorisnici.setModel(new DefaultTableModel(
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
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableKreiranjeGrupaKorisnici.getColumnModel().getColumn(0).setPreferredWidth(87);
		tableKreiranjeGrupaKorisnici.getColumnModel().getColumn(5).setPreferredWidth(113);
		tableKreiranjeGrupaKorisnici.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableKreiranjeGrupaKorisnici.setBounds(131, 176, 489, 136);
		frmKreiranjeGrupa.getContentPane().add(tableKreiranjeGrupaKorisnici);
		
		JButton buttonKreiranjeGrupaDodajKorisnika = new JButton("Dodaj Korisnika:");
		buttonKreiranjeGrupaDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonKreiranjeGrupaDodajKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonKreiranjeGrupaDodajKorisnika.setBounds(511, 323, 109, 20);
		frmKreiranjeGrupa.getContentPane().add(buttonKreiranjeGrupaDodajKorisnika);
		
		JCheckBox checkBoxKreiranjeGrupaPostavljanje = new JCheckBox("Postavljanje");
		checkBoxKreiranjeGrupaPostavljanje.setHorizontalAlignment(SwingConstants.RIGHT);
		checkBoxKreiranjeGrupaPostavljanje.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxKreiranjeGrupaPostavljanje.setBounds(137, 350, 99, 20);
		frmKreiranjeGrupa.getContentPane().add(checkBoxKreiranjeGrupaPostavljanje);
		
		JCheckBox checkBoxKreiranjeGrupaSkidanje = new JCheckBox("Skidanje");
		checkBoxKreiranjeGrupaSkidanje.setHorizontalAlignment(SwingConstants.RIGHT);
		checkBoxKreiranjeGrupaSkidanje.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxKreiranjeGrupaSkidanje.setBounds(278, 350, 73, 20);
		frmKreiranjeGrupa.getContentPane().add(checkBoxKreiranjeGrupaSkidanje);
		
		JButton buttonKreiranjeGrupaKreirajGrupu = new JButton("Kreiraj Grupu:");
		buttonKreiranjeGrupaKreirajGrupu.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonKreiranjeGrupaKreirajGrupu.setBounds(511, 377, 109, 20);
		frmKreiranjeGrupa.getContentPane().add(buttonKreiranjeGrupaKreirajGrupu);
		
		JLabel label = new JLabel("Naziv Grupe:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(48, 16, 73, 21);
		frmKreiranjeGrupa.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Opis Grupe:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(48, 55, 73, 21);
		frmKreiranjeGrupa.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("Korisnici:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(62, 172, 59, 21);
		frmKreiranjeGrupa.getContentPane().add(label_3);
		
		JLabel label_2 = new JLabel("Pretraga Korisnika:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(22, 144, 99, 21);
		frmKreiranjeGrupa.getContentPane().add(label_2);
		
		JLabel label_4 = new JLabel("Prava pristupa:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(34, 350, 87, 21);
		frmKreiranjeGrupa.getContentPane().add(label_4);
	}
}
