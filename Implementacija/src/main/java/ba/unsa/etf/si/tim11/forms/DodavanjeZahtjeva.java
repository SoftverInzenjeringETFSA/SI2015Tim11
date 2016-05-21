package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import com.toedter.calendar.JCalendar;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.bll.ZahtjevRepository;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.bll.DokumentRepository;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import ba.unsa.etf.si.tim11.dbmodels.Validator;
import ba.unsa.etf.si.tim11.dbmodels.ZahtjevDbModel;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class DodavanjeZahtjeva {

	private UnitOfWork uow = new UnitOfWork();
	private JDialog frmDodavanjeZahtjeva;
	private JTextField textFieldZahtjevPretragaKorisnici;
	private JTable tableZahtjevKorisnici;
	private JTextField textFieldZahtjevPretragaDokumenti;
	private JTable tableZahtjevDokumenti;
	private JTextField textFieldZahtjevPoruka;
	final static Logger logger = Logger.getLogger(DodavanjeZahtjeva.class.toString());
	KorisnikRepository korisnikRepository = new KorisnikRepository();
	KorisnikDbModel korisnik;
	DokumentRepository dokumentRepository = new DokumentRepository();
	ZahtjevRepository zahtjevRepository = new ZahtjevRepository();
	Integer korisnikId;
	private JScrollPane scrollPaneKorisnici;
	private JScrollPane scrollPaneDokumenti;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeZahtjeva window = new DodavanjeZahtjeva();
					window.frmDodavanjeZahtjeva.setVisible(true);
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}
	
	public static void pokreniFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeZahtjeva window = new DodavanjeZahtjeva();
					window.frmDodavanjeZahtjeva.setVisible(true);
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeZahtjeva() {
		initialize();
	}

	
	/*private void ucitajDokumente() throws Exception {
		int id = korisnikRepository.dajIdKorisnikaPoUsername(Sesija.getUsername());
		System.out.println(id);
		List<DokumentDbModel> dokumenti = uow.getDokumentRepository().getDokumentByKorisnikAjDi(id);
		for (DokumentDbModel dokumentDbModel : dokumenti) {
			Object[] row = { (Integer) (int) dokumentDbModel.getDokumentId(), dokumentDbModel.getDokumentNaziv(), dokumentDbModel.getAktivan() };
			((DefaultTableModel) tableZahtjevDokumenti.getModel()).addRow(row);
		}
	}*/
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeZahtjeva = new JDialog();
		frmDodavanjeZahtjeva.setTitle("Dodavanje zahtjeva");
		frmDodavanjeZahtjeva.setResizable(false);
		frmDodavanjeZahtjeva.setBounds(100, 100, 632, 528);
		frmDodavanjeZahtjeva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDodavanjeZahtjeva.getContentPane().setLayout(null);

		JLabel lblPretragaKorisnika = new JLabel("Pretraga Korisnika:");
		lblPretragaKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPretragaKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPretragaKorisnika.setBounds(22, 17, 94, 21);
		frmDodavanjeZahtjeva.getContentPane().add(lblPretragaKorisnika);

		textFieldZahtjevPretragaKorisnici = new JTextField();
		textFieldZahtjevPretragaKorisnici.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldZahtjevPretragaKorisnici.setColumns(10);
		textFieldZahtjevPretragaKorisnici.setBounds(126, 17, 383, 21);
		frmDodavanjeZahtjeva.getContentPane().add(textFieldZahtjevPretragaKorisnici);

		JButton buttonZahtjevTraziKorisnika = new JButton("Traži");
		buttonZahtjevTraziKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonZahtjevTraziKorisnika.setBounds(519, 17, 60, 21);
		frmDodavanjeZahtjeva.getContentPane().add(buttonZahtjevTraziKorisnika);

		JLabel label_1 = new JLabel("Korisnici:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(32, 52, 54, 21);
		frmDodavanjeZahtjeva.getContentPane().add(label_1);

		tableZahtjevKorisnici = new JTable();
		tableZahtjevKorisnici.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableZahtjevKorisnici.setModel(new DefaultTableModel(new Object[][] { },
				new String[] { "Ime", "Prezime", "Korisničko ime" }));
		tableZahtjevKorisnici.getColumnModel().getColumn(0).setPreferredWidth(115);
		tableZahtjevKorisnici.getColumnModel().getColumn(1).setPreferredWidth(112);
		tableZahtjevKorisnici.getColumnModel().getColumn(2).setPreferredWidth(233);
		tableZahtjevKorisnici.setBounds(363, 326, 469, 41);
		
		scrollPaneKorisnici = new JScrollPane();
		scrollPaneKorisnici.setBounds(126, 49, 383, 85);
		scrollPaneKorisnici.setViewportView(tableZahtjevKorisnici);
		frmDodavanjeZahtjeva.getContentPane().add(scrollPaneKorisnici);

		JLabel label_2 = new JLabel("Pretraga Dokumenata:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(10, 164, 106, 21);
		frmDodavanjeZahtjeva.getContentPane().add(label_2);
		
		
		tableZahtjevDokumenti = new JTable();
		tableZahtjevDokumenti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableZahtjevDokumenti.setModel(new DefaultTableModel(new Object[][] { },
				new String[] { "ID", "Naziv", "Verzija" }));
		tableZahtjevDokumenti.getColumnModel().getColumn(0).setPreferredWidth(45);
		tableZahtjevDokumenti.getColumnModel().getColumn(1).setPreferredWidth(303);
		tableZahtjevDokumenti.getColumnModel().getColumn(2).setPreferredWidth(112);
		//tableZahtjevDokumenti.getColumnModel().getColumn(3).setPreferredWidth(200);
		tableZahtjevDokumenti.setBounds(363, 326, 469, 41);
		
		scrollPaneDokumenti = new JScrollPane();
		scrollPaneDokumenti.setBounds(126, 196, 383, 118);
		scrollPaneDokumenti.setViewportView(tableZahtjevDokumenti);
		frmDodavanjeZahtjeva.getContentPane().add(scrollPaneDokumenti);
		
		
		
		
		textFieldZahtjevPretragaDokumenti = new JTextField();
		textFieldZahtjevPretragaDokumenti.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldZahtjevPretragaDokumenti.setColumns(10);
		textFieldZahtjevPretragaDokumenti.setBounds(126, 164, 383, 21);
		frmDodavanjeZahtjeva.getContentPane().add(textFieldZahtjevPretragaDokumenti);
		JButton buttonZahtjevTraziDokument = new JButton("Traži");
		buttonZahtjevTraziDokument.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonZahtjevTraziDokument.setBounds(519, 164, 60, 21);
		frmDodavanjeZahtjeva.getContentPane().add(buttonZahtjevTraziDokument);
		
		
		

		JLabel label_3 = new JLabel("Dokumenti:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_3.setBounds(56, 199, 60, 21);
		frmDodavanjeZahtjeva.getContentPane().add(label_3);
		
		/*tableZahtjevDokumenti = new JTable();
		tableZahtjevDokumenti.setModel(new DefaultTableModel(
				new Object[][] {
						{ "ID Dokumenta", "Naziv Dokumenta", "Verzija Dokumenta", "Korisnik Postavio",
								"Datum Postavljanja" },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "ID Dokumenta", "Naziv Dokumenta", "Verzija Dokumenta", "Korisnik Postavio",
						"Datum Postavljanja" }));
		tableZahtjevDokumenti.getColumnModel().getColumn(0).setPreferredWidth(89);
		tableZahtjevDokumenti.getColumnModel().getColumn(1).setPreferredWidth(99);
		tableZahtjevDokumenti.getColumnModel().getColumn(2).setPreferredWidth(105);
		tableZahtjevDokumenti.getColumnModel().getColumn(3).setPreferredWidth(97);
		tableZahtjevDokumenti.getColumnModel().getColumn(4).setPreferredWidth(109);
		tableZahtjevDokumenti.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableZahtjevDokumenti.setBounds(126, 233, 455, 96);
		frmDodavanjeZahtjeva.getContentPane().add(tableZahtjevDokumenti);*/

		JLabel label_4 = new JLabel("Poruka:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(70, 339, 46, 21);
		frmDodavanjeZahtjeva.getContentPane().add(label_4);

		textFieldZahtjevPoruka = new JTextField();
		textFieldZahtjevPoruka.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldZahtjevPoruka.setColumns(10);
		textFieldZahtjevPoruka.setBounds(126, 340, 383, 63);
		frmDodavanjeZahtjeva.getContentPane().add(textFieldZahtjevPoruka);

		JButton buttonZahtjevPosaljiZahtjev = new JButton("Pošalji Zahtjev");
		buttonZahtjevPosaljiZahtjev.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonZahtjevPosaljiZahtjev.setBounds(403, 414, 106, 21);
		frmDodavanjeZahtjeva.getContentPane().add(buttonZahtjevPosaljiZahtjev);
		
		final JRadioButton rdbtnPrikazivanje = new JRadioButton("Prikazivanje");
		rdbtnPrikazivanje.setBounds(126, 414, 109, 23);
		frmDodavanjeZahtjeva.getContentPane().add(rdbtnPrikazivanje);
		
		final JRadioButton rdbtnOdobravanje = new JRadioButton("Odobravanje");
		rdbtnOdobravanje.setBounds(237, 414, 109, 23);
		frmDodavanjeZahtjeva.getContentPane().add(rdbtnOdobravanje);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnPrikazivanje);
		group.add(rdbtnOdobravanje);
		
		JLabel lblTipZahtjeva = new JLabel("Tip zahtjeva:");
		lblTipZahtjeva.setBounds(46, 418, 70, 14);
		frmDodavanjeZahtjeva.getContentPane().add(lblTipZahtjeva);
		
		buttonZahtjevTraziKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String pretraga = textFieldZahtjevPretragaKorisnici.getText();
					if (korisnikRepository.dajIdKorisnikaPoUsername(pretraga) != null) {
						int korisnikId = korisnikRepository.dajIdKorisnikaPoUsername(pretraga);
						KorisnikDbModel korisnik = korisnikRepository.dajKorisnika(korisnikId);
						Object[] row = { korisnik.getIme(), korisnik.getPrezime(), korisnik.getUsername() };
						((DefaultTableModel) tableZahtjevKorisnici.getModel()).addRow(row);
					} else {
						JOptionPane.showMessageDialog(frmDodavanjeZahtjeva, "Nema korisnika s tim korisničkim imenom!");
						textFieldZahtjevPretragaKorisnici.setText("");
					}	
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					JOptionPane.showMessageDialog(frmDodavanjeZahtjeva, poruka);
					throw new RuntimeException(e);
				}
			}
		});
		int id = 0;
		try {
			id = korisnikRepository.dajIdKorisnikaPoUsername(Sesija.getUsername());
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			String poruka = e.getMessage();
			logger.info(poruka);
			JOptionPane.showMessageDialog(frmDodavanjeZahtjeva, poruka);
			throw new RuntimeException(e);
		}
		System.out.println(id);
		List<DokumentVerzijaDbModel> dokumentiVerzije = uow.getDokumentRepository().getDokumentVerzijaByKorisnikAjDi((Integer) id);
		for (DokumentVerzijaDbModel dokumentVerzijaDbModel : dokumentiVerzije) {
			Object[] row = { (Integer) (int) dokumentVerzijaDbModel.getDokumentVerzijaId(), dokumentVerzijaDbModel.getDokument().getDokumentNaziv(), "v" + dokumentVerzijaDbModel.getDokumentVerzijaId() };
			((DefaultTableModel) tableZahtjevDokumenti.getModel()).addRow(row);
		}
		
		buttonZahtjevPosaljiZahtjev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer dokumentVerzijaId = null;
				try {
					dokumentVerzijaId = (Integer) tableZahtjevDokumenti.getValueAt(tableZahtjevDokumenti.getSelectedRow(), 0);
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					JOptionPane.showMessageDialog(frmDodavanjeZahtjeva, poruka);
					throw new RuntimeException(e);
				}
				int id = 0;
				try {
					id = korisnikRepository.dajIdKorisnikaPoUsername(Sesija.getUsername());
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					JOptionPane.showMessageDialog(frmDodavanjeZahtjeva, poruka);
					throw new RuntimeException(e);
				}
				int id2 = 0;
				try {
					id2 = korisnikRepository.dajIdKorisnikaPoUsername((String) tableZahtjevKorisnici.getValueAt(0, 2));
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					JOptionPane.showMessageDialog(frmDodavanjeZahtjeva, poruka);
					throw new RuntimeException(e);
				}
				Integer tip = 1;
				if (rdbtnOdobravanje.isSelected()) {
					tip = 2;
				}
				try {
					ZahtjevDbModel z = new ZahtjevDbModel();
					z.setAktivan(true);
					Date d = new Date();
					z.setDatumVrijemeKreiranja(d);
					z.setDokumentVerzijaId(dokumentVerzijaId);
					z.setKreiraoKorisnikId(id);
					z.setUpucenoKorisnikId(id2);
					z.setZahtjevTipId(tip);
					z.setZahtjevStatusId(1);
					zahtjevRepository.dodajZahtjev(z);
					JOptionPane.showMessageDialog(frmDodavanjeZahtjeva, "Uspjeh!");
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					JOptionPane.showMessageDialog(frmDodavanjeZahtjeva, poruka);
					throw new RuntimeException(e);
				}
			}
		});
	}
}
