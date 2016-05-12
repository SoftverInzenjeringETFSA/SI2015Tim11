package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzmjenaGrupe
{

	private JFrame frmIzmjenaGrupa;
	private JTextField textFieldIzmjenaGrPretraga;
	private JTable tableIzmjenaGrKorisnici;

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
					IzmjenaGrupe window = new IzmjenaGrupe();
					window.frmIzmjenaGrupa.setVisible(true);
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
	public IzmjenaGrupe()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmIzmjenaGrupa = new JFrame();
		frmIzmjenaGrupa.setTitle("Izmjena Grupa");
		frmIzmjenaGrupa.setResizable(false);
		frmIzmjenaGrupa.setBounds(100, 100, 664, 432);
		frmIzmjenaGrupa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIzmjenaGrupa.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Izbor grupe:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(51, 39, 75, 21);
		frmIzmjenaGrupa.getContentPane().add(label);
		
		JComboBox comboBoxIzmjenaGrIzbor = new JComboBox();
		comboBoxIzmjenaGrIzbor.setFont(new Font("Dialog", Font.PLAIN, 11));
		comboBoxIzmjenaGrIzbor.setBounds(136, 39, 498, 21);
		frmIzmjenaGrupa.getContentPane().add(comboBoxIzmjenaGrIzbor);
		
		JLabel label_1 = new JLabel("Pretraga korisnika:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(25, 71, 101, 21);
		frmIzmjenaGrupa.getContentPane().add(label_1);
		
		textFieldIzmjenaGrPretraga = new JTextField();
		textFieldIzmjenaGrPretraga.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldIzmjenaGrPretraga.setColumns(10);
		textFieldIzmjenaGrPretraga.setBounds(136, 71, 328, 21);
		frmIzmjenaGrupa.getContentPane().add(textFieldIzmjenaGrPretraga);
		
		JButton buttonIzmjenaGRTrazi = new JButton("Traži");
		buttonIzmjenaGRTrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonIzmjenaGRTrazi.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaGRTrazi.setBounds(559, 71, 75, 23);
		frmIzmjenaGrupa.getContentPane().add(buttonIzmjenaGRTrazi);
		
		JCheckBox checkBoxIzmjenaGRClan = new JCheckBox("Član Grupe");
		checkBoxIzmjenaGRClan.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxIzmjenaGRClan.setBounds(470, 71, 87, 21);
		frmIzmjenaGrupa.getContentPane().add(checkBoxIzmjenaGRClan);
		
		JLabel label_2 = new JLabel("Korisnici:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(71, 103, 55, 21);
		frmIzmjenaGrupa.getContentPane().add(label_2);
		
		tableIzmjenaGrKorisnici = new JTable();
		tableIzmjenaGrKorisnici.setModel(new DefaultTableModel(
			new Object[][] {
				{"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Korisni\u010Dko Ime", "Ime", "Prezime", "Adresa", "Datum Ro\u0111enja", "Pozicija u Organizaciji"
			}
		));
		tableIzmjenaGrKorisnici.getColumnModel().getColumn(0).setPreferredWidth(85);
		tableIzmjenaGrKorisnici.getColumnModel().getColumn(1).setPreferredWidth(49);
		tableIzmjenaGrKorisnici.getColumnModel().getColumn(3).setPreferredWidth(59);
		tableIzmjenaGrKorisnici.getColumnModel().getColumn(4).setPreferredWidth(91);
		tableIzmjenaGrKorisnici.getColumnModel().getColumn(5).setPreferredWidth(113);
		tableIzmjenaGrKorisnici.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableIzmjenaGrKorisnici.setBounds(136, 103, 498, 139);
		frmIzmjenaGrupa.getContentPane().add(tableIzmjenaGrKorisnici);
		
		JLabel label_3 = new JLabel("Izmijena Prava Pristupa:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(12, 253, 114, 21);
		frmIzmjenaGrupa.getContentPane().add(label_3);
		
		JCheckBox checkBoxIzmjenaGrIzmjenaPPPostavljanje = new JCheckBox("Postavljanje");
		checkBoxIzmjenaGrIzmjenaPPPostavljanje.setHorizontalAlignment(SwingConstants.LEFT);
		checkBoxIzmjenaGrIzmjenaPPPostavljanje.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxIzmjenaGrIzmjenaPPPostavljanje.setBounds(136, 253, 87, 21);
		frmIzmjenaGrupa.getContentPane().add(checkBoxIzmjenaGrIzmjenaPPPostavljanje);
		
		JCheckBox checkBoxIzmjenaGrIzmjenaPPSkidanje = new JCheckBox("Skidanje");
		checkBoxIzmjenaGrIzmjenaPPSkidanje.setHorizontalAlignment(SwingConstants.LEFT);
		checkBoxIzmjenaGrIzmjenaPPSkidanje.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxIzmjenaGrIzmjenaPPSkidanje.setBounds(225, 253, 65, 21);
		frmIzmjenaGrupa.getContentPane().add(checkBoxIzmjenaGrIzmjenaPPSkidanje);
		
		JButton buttonIzmjenaGrIzmjeniKorisnika = new JButton("Izmijeni Korisnika");
		buttonIzmjenaGrIzmjeniKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaGrIzmjeniKorisnika.setBounds(505, 253, 129, 21);
		frmIzmjenaGrupa.getContentPane().add(buttonIzmjenaGrIzmjeniKorisnika);
		
		JLabel label_4 = new JLabel("Dodavanje Korisnika:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(12, 285, 114, 21);
		frmIzmjenaGrupa.getContentPane().add(label_4);
		
		JCheckBox checkBoxIzmjenaGrDodavanjeKorisnikaPostavljanje = new JCheckBox("Postavljanje");
		checkBoxIzmjenaGrDodavanjeKorisnikaPostavljanje.setHorizontalAlignment(SwingConstants.LEFT);
		checkBoxIzmjenaGrDodavanjeKorisnikaPostavljanje.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxIzmjenaGrDodavanjeKorisnikaPostavljanje.setBounds(136, 285, 87, 21);
		frmIzmjenaGrupa.getContentPane().add(checkBoxIzmjenaGrDodavanjeKorisnikaPostavljanje);
		
		JCheckBox checkBoxIzmjenaGrDodavanjeKorisnikaSkidanje = new JCheckBox("Skidanje");
		checkBoxIzmjenaGrDodavanjeKorisnikaSkidanje.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxIzmjenaGrDodavanjeKorisnikaSkidanje.setBounds(225, 285, 65, 21);
		frmIzmjenaGrupa.getContentPane().add(checkBoxIzmjenaGrDodavanjeKorisnikaSkidanje);
		
		JButton buttonIzmjenaGrDodajKorisnika = new JButton("Dodaj Korisnika");
		buttonIzmjenaGrDodajKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaGrDodajKorisnika.setBounds(505, 285, 129, 21);
		frmIzmjenaGrupa.getContentPane().add(buttonIzmjenaGrDodajKorisnika);
		
		JLabel label_5 = new JLabel("Brisanje Grupe:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_5.setBounds(39, 331, 87, 21);
		frmIzmjenaGrupa.getContentPane().add(label_5);
		
		JCheckBox checkBoxIzmjenaGrOmoguciBrisanje = new JCheckBox("Omogući Brisanje");
		checkBoxIzmjenaGrOmoguciBrisanje.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBoxIzmjenaGrOmoguciBrisanje.setBounds(136, 331, 114, 21);
		frmIzmjenaGrupa.getContentPane().add(checkBoxIzmjenaGrOmoguciBrisanje);
		
		JButton buttonIzmjenaGrObrisiGrupu = new JButton("Obriši Grupu");
		buttonIzmjenaGrObrisiGrupu.setEnabled(false);
		buttonIzmjenaGrObrisiGrupu.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaGrObrisiGrupu.setBounds(505, 331, 129, 21);
		frmIzmjenaGrupa.getContentPane().add(buttonIzmjenaGrObrisiGrupu);
	}
}
