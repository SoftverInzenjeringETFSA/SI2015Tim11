package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import ba.unsa.etf.si.tim11.bll.DokumentRepository;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.izvjestajmodels.Dokument;
import com.toedter.calendar.JCalendar;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

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

	private String[] izvjestaji = new String[] {"Tip Izvještaja", "Korisnik", "Dokument", "Zahtjev", "Odobrenje"};
	
	final static Logger logger = Logger.getLogger(Pretraga.class.toString());

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
					logger.info(e.getMessage());
					throw new RuntimeException(e);
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
		
		final JCalendar calendarPretragaPocetni = new JCalendar();
		calendarPretragaPocetni.setBounds(91, 11, 198, 157);
		frmPretragaizvjetaji.getContentPane().add(calendarPretragaPocetni);
		calendarPretragaPocetni.setMaxSelectableDate(new Date());
		
		JLabel label_1 = new JLabel("Krajnji Datum:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(299, 11, 65, 21);
		frmPretragaizvjetaji.getContentPane().add(label_1);
		
		final JCalendar calendarPretragaKrajnji = new JCalendar();
		calendarPretragaKrajnji.setBounds(374, 11, 198, 157);
		frmPretragaizvjetaji.getContentPane().add(calendarPretragaKrajnji);
		calendarPretragaKrajnji.setMaxSelectableDate(new Date());
		
		final JLabel label_2 = new JLabel("Korisnik:");
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
		buttonPretragaTrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calendarPretragaPocetni.getDate().after(calendarPretragaKrajnji.getDate())) {
					Integer id = new KorisnikRepository().dajIdKorisnikaPoUsername(label_2.getText());
					List<DokumentDbModel> dokumentsi = new DokumentRepository().getDokumentByKorisnikAjDi(id);
					List<DokumentVerzijaDbModel> verzijeDokumenta = new ArrayList<DokumentVerzijaDbModel>();
					for (DokumentDbModel aDokumentsi : dokumentsi) {
						verzijeDokumenta.addAll(new DokumentRepository().dajVerzijeDokumenta((int) aDokumentsi.getDokumentId()));
					}
					Object[][] array = new Object[verzijeDokumenta.size()][5];
					for(int i = 0; i < verzijeDokumenta.size(); i++) {
						array[i][0] = verzijeDokumenta.get(i).getDokumentId();
						array[i][1] = verzijeDokumenta.get(i).getDokument().getDokumentNaziv();
						array[i][2] = verzijeDokumenta.get(i).getDokumentVerzijaId();
						array[i][3] = verzijeDokumenta.get(i).getPostavioKorisnikId();
						array[i][4] = "Not yet implemeted.";
					}
					tablePretragaDokumenti.setModel(new DefaultTableModel(array, new String[] {
							"ID Dokumenta", "Naziv Dokumenta", "Verzija", "Korisnik Postavio", "Datum Postavljanja"
					} ));
				}
			}
		});
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
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(izvjestaji));
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		comboBox.setBounds(458, 349, 114, 27);
		frmPretragaizvjetaji.getContentPane().add(comboBox);
		
		JButton button_1 = new JButton("Kreiraj Izvještaj");
		button_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		button_1.setBounds(458, 387, 114, 29);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() != 0) {
					List<Dokument> dokumenti = new ArrayList<Dokument>();
					for(int i = 0; i < tablePretragaDokumenti.getRowCount(); i++) {
						Dokument novi = new Dokument();
						novi.setDatum(new Date());
						novi.setNaziv((String)tablePretragaDokumenti.getValueAt(i, 2));
						novi.setBrojZahtjeva(new Random().nextInt());
						novi.setZadnjiStatus("Odobreno");
						dokumenti.add(novi);
					}
					try {
						InputStream is = new FileInputStream("templates/template_za_dokument_izvjestaj.xls");
						try {
							OutputStream os = new FileOutputStream("target/rezultat.xls");
							Context context = new Context();
							context.putVar("dokumenti", dokumenti);
							JxlsHelper.getInstance().processTemplate(is, os, context);
						} catch (Exception ex) {
							logger.info(ex.getMessage());
							throw new RuntimeException(ex);
						}
					} catch (Exception ex) {
						logger.info(ex.getMessage());
						throw new RuntimeException(ex);
					}
				}
			}
		});
		frmPretragaizvjetaji.getContentPane().add(button_1);
	}
}
