package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.omg.stub.java.rmi._Remote_Stub;

import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodavanjeFoldera {

	private JFrame frmDodavanjeFoldera;
	
	public JFrame getFrmDodavanjeFoldera() {
		return frmDodavanjeFoldera;
	}

	private JTextField txtNaziv;

	private UnitOfWork uow = new UnitOfWork();
	private Integer _roditeljFolderID;
	/**
	 * Launch the application.
	 */
	public static void pokreni(final GlavnaForma glavnaForma, final Integer roditeljFolderId) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeFoldera window = new DodavanjeFoldera(glavnaForma,roditeljFolderId);
					window.frmDodavanjeFoldera.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void dodajFolder(){
		FolderDbModel folder = new FolderDbModel();
		
		if(txtNaziv.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Molimo unesite naziv foldera.", "Upozorenje", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		folder.setFolderNaziv(txtNaziv.getText());
		folder.setAktivan(true);
		if(_roditeljFolderID != -1)
			uow.getFolderRepository().dodajFolder(_roditeljFolderID, folder);
		else
			uow.getFolderRepository().dodajFolder(null, folder);
	}
	/**
	 * Create the application.
	 */
	public DodavanjeFoldera(GlavnaForma glavnaForma, Integer roditeljFolderId) {
		_roditeljFolderID = roditeljFolderId;
		initialize(glavnaForma);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final GlavnaForma glavnaForma) {
		frmDodavanjeFoldera = new JFrame();
		frmDodavanjeFoldera.setTitle("Dodavanje foldera");
		frmDodavanjeFoldera.setBounds(100, 100, 350, 88);
		frmDodavanjeFoldera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDodavanjeFoldera.getContentPane().setLayout(null);
		
		txtNaziv = new JTextField();
		txtNaziv.setBounds(41, 12, 184, 20);
		frmDodavanjeFoldera.getContentPane().add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajFolder();
				
				//glavnaForma.ucitajTreeViewModel();
				//glavnaForma.txtPretraga.setText("JEBEM MU MAJKU");
				frmDodavanjeFoldera.dispose();
				//glavnaForma.initialize();
			}
		});
		btnDodaj.setBounds(235, 11, 89, 23);
		frmDodavanjeFoldera.getContentPane().add(btnDodaj);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(10, 15, 41, 14);
		frmDodavanjeFoldera.getContentPane().add(lblNaziv);
	}
}
