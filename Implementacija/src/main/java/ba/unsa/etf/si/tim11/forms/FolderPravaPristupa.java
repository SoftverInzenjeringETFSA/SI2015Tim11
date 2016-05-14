package ba.unsa.etf.si.tim11.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.CompoundBorder;

public class FolderPravaPristupa extends JFrame {

	private JPanel contentPane;
	private long folderId;
	private FolderDbModel folder = null;
	UnitOfWork uw = new UnitOfWork();
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public void PokreniFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//FolderPravaPristupa frame = new FolderPravaPristupa(0);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FolderPravaPristupa(long l) {
		setTitle("Promjena prava grupa nad folderom");
		
		initialize();
		
		postaviFolder(l);	
		
	}
	
	private void postaviFolder(long l) {
		
		folder = uw.getFolderRepository().dajFolderPoId((int)l);
		String poruka = "";
		
		if(folder != null)
		  poruka = "Promjena prava pristupa grupe za folder: " + folder.getFolderNaziv();
		
		panel.setBorder(new TitledBorder(null, poruka, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Text", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
}
