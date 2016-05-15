package ba.unsa.etf.si.tim11.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FolderPravaPristupa extends JFrame {

	private JPanel contentPane;
	private int folderId;
	private FolderDbModel folder = null;
	UnitOfWork uw = new UnitOfWork();
	private JPanel panel;
	private JLabel label_pravaPristupa;
	private JList list_grupe;
	private JButton btnDifiniiPravoPristupa;
	private JButton btnUkloniPravaPristupa;
	private JCheckBox checkBox_Pisanje;
	private JCheckBox checkBox_Citanje;
	private DefaultListModel<GrupaDbModel> listaGrupa = new DefaultListModel<GrupaDbModel>();
	private String userNameKorisnika = "";
	String poruka = "";
	int pravaKorisnikaNaFolder;
	
	final static Logger logger = Logger.getLogger(KreiranjeGrupa.class.toString());


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
					logger.info(e.getMessage());
					throw new RuntimeException(e);
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FolderPravaPristupa(long l) {
		
		setResizable(false);
		setTitle("Promjena prava grupa nad folderom");
		
		initialize();
		postaviKorisnika();
		postaviFolder(l);
		postaviPravaKorisnikaNaFolder();
		ucitajGrupeKorisnika();
		osvjeziPoruku();
	}
	
	private void postaviPravaKorisnikaNaFolder() {
		pravaKorisnikaNaFolder = uw.getKorisnikRepository().dajPravaKorisnikaNaFolder(userNameKorisnika, folder);
		if(pravaKorisnikaNaFolder == 2)
		{
			checkBox_Pisanje.setEnabled(false);
			checkBox_Citanje.setEnabled(true);
		}
		else
		{
			checkBox_Pisanje.setEnabled(true);
			checkBox_Citanje.setEnabled(true);
		}
	}
	
	private void osvjeziPoruku() {
		
		if(list_grupe.getSelectedIndex() != -1)
		{	
			int prava = uw.getGrupaRepository().dajPravaGrupeNaFolder((int)((GrupaDbModel)list_grupe.getSelectedValue()).getGrupaId(), (int)folder.getFolderId());
			
			if(prava == 1)
				poruka = "Grupa " + ((GrupaDbModel)list_grupe.getSelectedValue()).getGrupaNaziv() + " nad folderom " + folder.getFolderNaziv() + " ima pravo pisanja i čitanja.";
			else if(prava == 2)
				poruka = "Grupa " + ((GrupaDbModel)list_grupe.getSelectedValue()).getGrupaNaziv() + " nad folderom " + folder.getFolderNaziv() + " ima pravo čitanja.";
			else
				poruka = "Grupa " + ((GrupaDbModel)list_grupe.getSelectedValue()).getGrupaNaziv() + " nad folderom " + folder.getFolderNaziv() + " nema prava.";
		
			label_pravaPristupa.setText(poruka);
		}
		else
			label_pravaPristupa.setText("Odaberite grupu kako biste vidjeli njena prava!");
	}

	private void ucitajGrupeKorisnika() {
		
		Integer idKorisnika = uw.getKorisnikRepository().dajIdKorisnikaPoUsername(userNameKorisnika);
		
		List<GrupaDbModel> lista = uw.getGrupaRepository().dajGrupeVlasnika(idKorisnika);
		
		for(GrupaDbModel grupa : lista)
			if(!listaGrupa.contains(grupa))
				listaGrupa.addElement(grupa);
		
	}

	private void postaviKorisnika() {
		try {
			
			userNameKorisnika = Sesija.getUsername();
			
		} catch (Exception e) {
			userNameKorisnika = "";
			e.printStackTrace();
			logger.info(e.getMessage());
			throw new RuntimeException(e);
			
		}
		
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
		setBounds(100, 100, 714, 384);
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblGrupeKorisnika = new JLabel("Grupe korisnika:");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Trenutna prava pristupa selektovane grupe na folder", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Definisanje prava pristupa grupe na folder", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGrupeKorisnika)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(16, Short.MAX_VALUE)
							.addComponent(lblGrupeKorisnika)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		checkBox_Pisanje = new JCheckBox("Pravo Pisanja");
		checkBox_Pisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_Pisanje.isSelected())
					checkBox_Citanje.setSelected(true);
			}
		});
		
		checkBox_Citanje = new JCheckBox("Pravo Čitanja");
		checkBox_Citanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(checkBox_Pisanje.isSelected())
						checkBox_Citanje.setSelected(true);
				
			}
		});
		
		btnDifiniiPravoPristupa = new JButton("Difiniši pravo pristupa");
		btnDifiniiPravoPristupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_grupe.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Nijedna grupa nije odabrana!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(!checkBox_Pisanje.isSelected() && !checkBox_Citanje.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Niste definisali prava pristupa!", "Greška", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(uw.getGrupaRepository().dajPravaGrupeNaFolder((int)((GrupaDbModel)list_grupe.getSelectedValue()).getGrupaId(), (int)folder.getFolderId()) == -1)
				{	FolderXGrupaDbModel novi = new FolderXGrupaDbModel();
					novi.setFolderId((int)folder.getFolderId());
					novi.setAktivan(true);
					novi.setPravoDodavanja(checkBox_Pisanje.isSelected());
					novi.setPravoSkidanja(checkBox_Citanje.isSelected());
					
					List<FolderXGrupaDbModel> listaDefinisanihPravaPristupa = new ArrayList<FolderXGrupaDbModel>();
					listaDefinisanihPravaPristupa.add(novi);
					uw.getGrupaRepository().dodajFolderXGrupaDbModele(listaDefinisanihPravaPristupa , (int)((GrupaDbModel)list_grupe.getSelectedValue()).getGrupaId());
					osvjeziPoruku();
					checkBox_Pisanje.setSelected(false);
					checkBox_Citanje.setSelected(false);

					JOptionPane.showMessageDialog(null, "Prava uspješno definisana!", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Grupa već ima prava definisana, uklonite postojeća pa definišite nova!", "Greška", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(184, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(checkBox_Citanje)
								.addComponent(checkBox_Pisanje))
							.addGap(177))
						.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
							.addComponent(btnDifiniiPravoPristupa)
							.addGap(156))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(28)
					.addComponent(checkBox_Citanje)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkBox_Pisanje)
					.addGap(18)
					.addComponent(btnDifiniiPravoPristupa)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		label_pravaPristupa = new JLabel("");
		
		btnUkloniPravaPristupa = new JButton("Ukloni prava pristupa");
		btnUkloniPravaPristupa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_grupe.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Nije izabrana nijedna grupa!", "Greška", JOptionPane.INFORMATION_MESSAGE);			
					return;
				}
				
				if(!poruka.equals("Grupa " + ((GrupaDbModel)list_grupe.getSelectedValue()).getGrupaNaziv() + " nad folderom " + folder.getFolderNaziv() + " nema prava."))
				{
					uw.getGrupaRepository().oduzmiPravaPristupaGrupeNaFolder((int)folder.getFolderId(), (int)((GrupaDbModel)list_grupe.getSelectedValue()).getGrupaId());
				
					osvjeziPoruku();
				
				JOptionPane.showMessageDialog(null, "Uspjesno ste uklonili sva prava pristupa grupe na folder!", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Izabrana grupa već nema nikakva prava na folder!", "Greška", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_pravaPristupa)
					.addContainerGap(272, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(229, Short.MAX_VALUE)
					.addComponent(btnUkloniPravaPristupa)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_pravaPristupa)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnUkloniPravaPristupa)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		list_grupe = new JList(listaGrupa);
		list_grupe.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(list_grupe.getSelectedIndex() != -1)
				{
					
					osvjeziPoruku();
					
				}
				
			}

		});
		scrollPane.setViewportView(list_grupe);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
