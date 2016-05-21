package ba.unsa.etf.si.tim11.forms;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import ba.unsa.etf.si.tim11.bll.DokumentRepository;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.izvjestajmodels.Dokument;
import com.toedter.calendar.JCalendar;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import sun.util.calendar.LocalGregorianCalendar;

import javax.swing.table.DefaultTableModel;

public class Pretraga
{

	private JFrame frmPretragaizvjetaji;
	private JTextField textFieldPretragaKorisnik;
	private JTable tablePretragaDokumenti;

	private String[] izvjestaji = new String[] {"Tip Izvještaja", "Korisnik", "Dokument", "Zahtjev", "Odobrenje"};
	
	final static Logger logger = Logger.getLogger(Pretraga.class.toString());

	public static void pokreniFormu()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					if(window == null) {
						window = new Pretraga();
					}
					window.frmPretragaizvjetaji.setVisible(true);
				} catch (Exception e)
				{
					logger.info(e.getMessage());
					throw new RuntimeException(e);
				}
			}
		});
	}

	private static Pretraga window;

	/**
	 * Create the application.
	 */
	private Pretraga()
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
		frmPretragaizvjetaji.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				if(calendarPretragaPocetni.getDate().before(calendarPretragaKrajnji.getDate())) {
					Integer id = new KorisnikRepository().dajIdKorisnikaPoUsername(label_2.getText());
					logger.info("Id usera " + id);
					List<DokumentVerzijaDbModel> verzijeDokumenta = new DokumentRepository().getDokumentByKorisnikAjDi(id);
					Object[][] array = new Object[verzijeDokumenta.size()+1][5];
					logger.info("Broj dokumenata: " + verzijeDokumenta.size());
					array[0] = new Object[]{"ID Dokumenta", "Naziv Dokumenta", "Verzija", "Korisnik Postavio", "Datum Postavljanja"};
					for(int i = 0; i < verzijeDokumenta.size(); i++) {
						array[i+1][0] = verzijeDokumenta.get(i).getDokumentId();
						array[i+1][1] = verzijeDokumenta.get(i).getDokument().getDokumentNaziv();
						array[i+1][2] = verzijeDokumenta.get(i).getDokumentVerzijaId();
						array[i+1][3] = verzijeDokumenta.get(i).getPostavioKorisnikId();
						array[i+1][4] = "Not yet implemeted.";
					}
					tablePretragaDokumenti.setModel(new DefaultTableModel(array, new String[] {
							"ID Dokumenta", "Naziv Dokumenta", "Verzija", "Korisnik Postavio", "Datum Postavljanja"
					} ));
				} else {
					JOptionPane.showMessageDialog(null, "Krajnji datum mora biti veći od početnog.", "Neuspješna operacija", JOptionPane.WARNING_MESSAGE);

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
                    List<DokumentDbModel> dokumentDbModels = DbDMSContext.getInstance().getDokumenti().ucitajSve();
					for(int i = 0; i < dokumentDbModels.size(); i++) {
						Dokument novi = new Dokument();
						novi.setDatum(new Date().toString());
						novi.setNaziv(dokumentDbModels.get(i).getDokumentNaziv());
						novi.setBroj(0);
						novi.setStatus("Odobreno");
						dokumenti.add(novi);
					}
                    String location = promptForFolder();
                    if(location == null) {
                        JOptionPane.showMessageDialog(null, "Lokacija nije validna.", "Neuspješna operacija", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
					try {
                        InputStream is = new FileInputStream(new File("./templates/template_za_dokument_izvjestaj.xlsx"));
						try {
                            location = String.format("%s/%sizvjestaj.xls", location, new Date().toString());
							OutputStream os = new FileOutputStream(location);
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
                JOptionPane.showMessageDialog(null, "Izvještaj generisan.", "Uspješna operacija", JOptionPane.INFORMATION_MESSAGE);
            }
        });
		frmPretragaizvjetaji.getContentPane().add(button_1);
	}

    private String promptForFolder()
    {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );

        if( fc.showOpenDialog( frmPretragaizvjetaji ) == JFileChooser.APPROVE_OPTION )
        {
            return fc.getSelectedFile().getAbsolutePath();
        }

        return null;
    }
}
