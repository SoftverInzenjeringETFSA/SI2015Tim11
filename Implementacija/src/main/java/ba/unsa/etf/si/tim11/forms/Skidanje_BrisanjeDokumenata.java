package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.table.DefaultTableModel;

public class Skidanje_BrisanjeDokumenata
{

	private JFrame frmSkidanjebrisanjeDokumenata;
	private JTable tableBrisanjeDokumenti;

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
					Skidanje_BrisanjeDokumenata window = new Skidanje_BrisanjeDokumenata();
					window.frmSkidanjebrisanjeDokumenata.setVisible(true);
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
	public Skidanje_BrisanjeDokumenata()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmSkidanjebrisanjeDokumenata = new JFrame();
		frmSkidanjebrisanjeDokumenata.setTitle("Skidanje/Brisanje Dokumenata");
		frmSkidanjebrisanjeDokumenata.setResizable(false);
		frmSkidanjebrisanjeDokumenata.setBounds(100, 100, 624, 620);
		frmSkidanjebrisanjeDokumenata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSkidanjebrisanjeDokumenata.getContentPane().setLayout(null);
		
		JTree treeBrisanjeFolderi = new JTree();
		treeBrisanjeFolderi.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Menadžment");
						node_2 = new DefaultMutableTreeNode("Upiti");
							node_2.add(new DefaultMutableTreeNode("Zahtjev1.doc"));
							node_2.add(new DefaultMutableTreeNode("Zahtjev2.doc"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Računovodstvo");
						node_2 = new DefaultMutableTreeNode("Ugovori");
							node_2.add(new DefaultMutableTreeNode("Ugovor1.doc"));
							node_2.add(new DefaultMutableTreeNode("Ugovor2.doc"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Fakture");
							node_2.add(new DefaultMutableTreeNode("Faktura1.pdf"));
							node_2.add(new DefaultMutableTreeNode("Faktura2.pdf"));
						node_1.add(node_2);
					add(node_1);
				}
			}
		));
		treeBrisanjeFolderi.setFont(new Font("Dialog", Font.PLAIN, 11));
		treeBrisanjeFolderi.setEditable(true);
		treeBrisanjeFolderi.setBounds(101, 13, 391, 142);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(treeBrisanjeFolderi);
		
		JLabel label = new JLabel("Folderi:");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(46, 14, 45, 15);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(label);
		
		JButton buttonBrisanjeIzbrisiFolder = new JButton("Izbriši Folder");
		buttonBrisanjeIzbrisiFolder.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonBrisanjeIzbrisiFolder.setBounds(502, 13, 97, 29);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(buttonBrisanjeIzbrisiFolder);
		
		JLabel label_1 = new JLabel("Početni Datum:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(20, 176, 71, 21);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(label_1);
		
		JCalendar calendarBrisanjePocetniDatum = new JCalendar();
		calendarBrisanjePocetniDatum.setBounds(101, 176, 198, 153);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(calendarBrisanjePocetniDatum);
		
		JLabel label_2 = new JLabel("Krajnji Datum:");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(320, 176, 71, 21);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(label_2);
		
		JCalendar calendarBrisanjeKrajnjiDatum = new JCalendar();
		calendarBrisanjeKrajnjiDatum.setBounds(401, 176, 198, 153);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(calendarBrisanjeKrajnjiDatum);
		
		JLabel label_3 = new JLabel("Dokumenti:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(39, 340, 52, 21);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(label_3);
		
		tableBrisanjeDokumenti = new JTable();
		tableBrisanjeDokumenti.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID Dokumenta", "Naziv Dokumenta", "Verzija", "Korisnik Postavio", "Datum Postavljanja"},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID Dokumenta", "Naziv Dokumenta", "Verzija", "Korisnik Postavio", "Datum Postavljanja"
			}
		));
		tableBrisanjeDokumenti.getColumnModel().getColumn(0).setPreferredWidth(87);
		tableBrisanjeDokumenti.getColumnModel().getColumn(1).setPreferredWidth(95);
		tableBrisanjeDokumenti.getColumnModel().getColumn(2).setPreferredWidth(55);
		tableBrisanjeDokumenti.getColumnModel().getColumn(3).setPreferredWidth(109);
		tableBrisanjeDokumenti.getColumnModel().getColumn(4).setPreferredWidth(107);
		tableBrisanjeDokumenti.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableBrisanjeDokumenti.setBounds(101, 344, 498, 152);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(tableBrisanjeDokumenti);
		
		JButton buttonBrisanjeArhiviraj = new JButton("Arhiviraj Dokumente");
		buttonBrisanjeArhiviraj.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonBrisanjeArhiviraj.setBounds(470, 507, 129, 29);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(buttonBrisanjeArhiviraj);
		
		JButton buttonBrisanjeBrisiDokumente = new JButton("Briši Dokumente");
		buttonBrisanjeBrisiDokumente.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonBrisanjeBrisiDokumente.setBounds(470, 547, 129, 29);
		frmSkidanjebrisanjeDokumenata.getContentPane().add(buttonBrisanjeBrisiDokumente);
	}

}
