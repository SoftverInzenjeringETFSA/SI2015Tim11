package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class DodavanjeFolderaDokumenataKomentara
{

	private JFrame frmDodavanjeFolderadokumenatakomentara;
	private JTextField textFieldDFDKNazivFoldera;
	private JTextField textFieldDFDKIzabraniDokument;
	private JTextField textFieldDFDKNazivDokumenta;
	final static Logger logger = Logger.getLogger(DodavanjeFolderaDokumenataKomentara.class.toString());

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
					DodavanjeFolderaDokumenataKomentara window = new DodavanjeFolderaDokumenataKomentara();
					window.frmDodavanjeFolderadokumenatakomentara.setVisible(true);
				} catch (Exception e)
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
	public DodavanjeFolderaDokumenataKomentara()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmDodavanjeFolderadokumenatakomentara = new JFrame();
		frmDodavanjeFolderadokumenatakomentara.setTitle("Dodavanje Foldera/Dokumenata/Komentara");
		frmDodavanjeFolderadokumenatakomentara.setBounds(100, 100, 836, 406);
		frmDodavanjeFolderadokumenatakomentara.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Folderi:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(10, 11, 35, 21);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(label);
		
		JTree treeDFDKFolderi = new JTree();
		treeDFDKFolderi.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Menadžment");
						node_2 = new DefaultMutableTreeNode("Upiti");
							node_2.add(new DefaultMutableTreeNode("Upit1.pdf"));
							node_2.add(new DefaultMutableTreeNode("Upit2.pdf"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Računovodstvo");
						node_2 = new DefaultMutableTreeNode("Ugovori");
							node_2.add(new DefaultMutableTreeNode("Ugovor1.doc"));
						node_1.add(node_2);
						node_2 = new DefaultMutableTreeNode("Fakture");
							node_2.add(new DefaultMutableTreeNode("Faktura1.pdf"));
						node_1.add(node_2);
					add(node_1);
				}
			}
		));
		treeDFDKFolderi.setFont(new Font("Dialog", Font.PLAIN, 11));
		treeDFDKFolderi.setEditable(true);
		treeDFDKFolderi.setBounds(55, 13, 342, 330);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(treeDFDKFolderi);
		
		JLabel label_1 = new JLabel("Naziv Foldera:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(421, 13, 77, 21);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(label_1);
		
		textFieldDFDKNazivFoldera = new JTextField();
		textFieldDFDKNazivFoldera.setColumns(10);
		textFieldDFDKNazivFoldera.setBounds(508, 14, 292, 20);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(textFieldDFDKNazivFoldera);
		
		JButton buttonDFDKDodajFolder = new JButton("Dodaj Folder");
		buttonDFDKDodajFolder.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonDFDKDodajFolder.setBounds(679, 45, 121, 27);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(buttonDFDKDodajFolder);
		
		JButton buttonDFDKIzborDokumenta = new JButton("Izbor Dokumenta");
		buttonDFDKIzborDokumenta.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonDFDKIzborDokumenta.setBounds(679, 83, 121, 27);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(buttonDFDKIzborDokumenta);
		
		JLabel label_2 = new JLabel("Izabrani Dokument:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(407, 123, 91, 21);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(label_2);
		
		textFieldDFDKIzabraniDokument = new JTextField();
		textFieldDFDKIzabraniDokument.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldDFDKIzabraniDokument.setColumns(10);
		textFieldDFDKIzabraniDokument.setBounds(508, 121, 292, 21);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(textFieldDFDKIzabraniDokument);
		
		JLabel label_3 = new JLabel("Naziv Dokumenta:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(407, 153, 91, 21);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(label_3);
		
		textFieldDFDKNazivDokumenta = new JTextField();
		textFieldDFDKNazivDokumenta.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldDFDKNazivDokumenta.setColumns(10);
		textFieldDFDKNazivDokumenta.setBounds(508, 153, 292, 21);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(textFieldDFDKNazivDokumenta);
		
		JLabel label_4 = new JLabel("Komentar:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(443, 185, 55, 21);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(label_4);
		
		JButton button_2 = new JButton("Dodaj Komentar");
		button_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		button_2.setBounds(407, 314, 109, 29);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Postavi Dokument");
		button_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		button_3.setBounds(679, 318, 121, 25);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(button_3);
		
		JTextArea textAreaDFDKKomentar = new JTextArea();
		textAreaDFDKKomentar.setFont(new Font("Dialog", Font.PLAIN, 11));
		textAreaDFDKKomentar.setBounds(508, 185, 292, 106);
		frmDodavanjeFolderadokumenatakomentara.getContentPane().add(textAreaDFDKKomentar);
	}
}
