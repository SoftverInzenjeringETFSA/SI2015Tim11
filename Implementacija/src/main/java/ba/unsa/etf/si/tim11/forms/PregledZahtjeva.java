package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import com.mysql.jdbc.Blob;

import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KomentarDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import com.toedter.calendar.JCalendar;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.bll.ZahtjevRepository;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import java.util.ArrayList;
import java.util.Calendar;
import ba.unsa.etf.si.tim11.bll.DokumentRepository;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.Validator;
import ba.unsa.etf.si.tim11.dbmodels.ZahtjevDbModel;

import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class PregledZahtjeva {

	private UnitOfWork uow = new UnitOfWork();
	private JDialog frmPregledZahtjeva;
	private JTable tablePrimljeniZahtjevi;
	private JTable tablePoslaniZahtjevi;
	final static Logger logger = Logger.getLogger(PregledZahtjeva.class.toString());
	KorisnikRepository korisnikRepository = new KorisnikRepository();
	KorisnikDbModel korisnik;
	DokumentRepository dokumentRepository = new DokumentRepository();
	ZahtjevRepository zahtjevRepository = new ZahtjevRepository();
	Integer korisnikId;
	private JScrollPane scrollPanePrimljeni;
	private JScrollPane scrollPanePoslani;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledZahtjeva window = new PregledZahtjeva();
					window.frmPregledZahtjeva.setVisible(true);
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
					PregledZahtjeva window = new PregledZahtjeva();
					window.frmPregledZahtjeva.setVisible(true);
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
	public PregledZahtjeva() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPregledZahtjeva = new JDialog();
		frmPregledZahtjeva.setTitle("Dodavanje zahtjeva");
		frmPregledZahtjeva.setResizable(false);
		frmPregledZahtjeva.setBounds(100, 100, 632, 528);
		frmPregledZahtjeva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPregledZahtjeva.getContentPane().setLayout(null);

		JLabel lblPrimljeniZahtjevi = new JLabel("Primljeni zahtjevi:");
		lblPrimljeniZahtjevi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrimljeniZahtjevi.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPrimljeniZahtjevi.setBounds(44, 17, 94, 21);
		frmPregledZahtjeva.getContentPane().add(lblPrimljeniZahtjevi);

		tablePrimljeniZahtjevi = new JTable();
		tablePrimljeniZahtjevi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePrimljeniZahtjevi.setModel(new DefaultTableModel(new Object[][] { },
				new String[] { "ID", "Naziv dokumenta", "Verzija", "Tip zahtjeva" }));
		tablePrimljeniZahtjevi.getColumnModel().getColumn(0).setPreferredWidth(35);
		tablePrimljeniZahtjevi.getColumnModel().getColumn(1).setPreferredWidth(322);
		tablePrimljeniZahtjevi.getColumnModel().getColumn(2).setPreferredWidth(103);
		tablePrimljeniZahtjevi.getColumnModel().getColumn(3).setPreferredWidth(233);
		tablePrimljeniZahtjevi.setBounds(363, 326, 469, 41);
		
		scrollPanePrimljeni = new JScrollPane();
		scrollPanePrimljeni.setBounds(54, 49, 511, 196);
		scrollPanePrimljeni.setViewportView(tablePrimljeniZahtjevi);
		frmPregledZahtjeva.getContentPane().add(scrollPanePrimljeni);

		JLabel lblPoslaniZahtjevi = new JLabel("Poslani zahtjevi:");
		lblPoslaniZahtjevi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoslaniZahtjevi.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPoslaniZahtjevi.setBounds(32, 297, 106, 21);
		frmPregledZahtjeva.getContentPane().add(lblPoslaniZahtjevi);
		
		
		tablePoslaniZahtjevi = new JTable();
		tablePoslaniZahtjevi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePoslaniZahtjevi.setModel(new DefaultTableModel(new Object[][] { },
				new String[] { "ID", "Naziv dokumenta", "Verzija", "Primalac zahtjeva", "Status" }));
		tablePoslaniZahtjevi.getColumnModel().getColumn(0).setPreferredWidth(45);
		tablePoslaniZahtjevi.getColumnModel().getColumn(1).setPreferredWidth(303);
		tablePoslaniZahtjevi.getColumnModel().getColumn(2).setPreferredWidth(112);
		tablePoslaniZahtjevi.getColumnModel().getColumn(3).setPreferredWidth(200);
		tablePoslaniZahtjevi.getColumnModel().getColumn(4).setPreferredWidth(200);
		tablePoslaniZahtjevi.setBounds(363, 326, 469, 41);
		
		scrollPanePoslani = new JScrollPane();
		scrollPanePoslani.setBounds(54, 329, 511, 118);
		scrollPanePoslani.setViewportView(tablePoslaniZahtjevi);
		frmPregledZahtjeva.getContentPane().add(scrollPanePoslani);
		
		JButton btnOdobri = new JButton("Odobri");
		btnOdobri.setBounds(377, 256, 89, 23);
		frmPregledZahtjeva.getContentPane().add(btnOdobri);
		
		JButton btnOdbij = new JButton("Odbij");
		btnOdbij.setBounds(476, 256, 89, 23);
		frmPregledZahtjeva.getContentPane().add(btnOdbij);
		
		int id = 0;
		try {
			id = korisnikRepository.dajIdKorisnikaPoUsername(Sesija.getUsername());
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			String poruka = e.getMessage();
			logger.info(poruka);
			JOptionPane.showMessageDialog(frmPregledZahtjeva, poruka);
			throw new RuntimeException(e);
		}
		System.out.println(id);
		List<ZahtjevDbModel> primljeniZahtjevi = uow.getZahtjevRepository().dajPrimljeneZahtjeve(id);
		for (ZahtjevDbModel primZahtjevDbModel : primljeniZahtjevi) {
			Object[] row = { (Integer) (int) primZahtjevDbModel.getZahtjevId(), primZahtjevDbModel.getDokumentVerzija().getDokument().getDokumentNaziv(), "v" + primZahtjevDbModel.getDokumentVerzijaId(), primZahtjevDbModel.getZahtjevTip().getZahtjevTipNaziv() };
			((DefaultTableModel) tablePrimljeniZahtjevi.getModel()).addRow(row);
		}
		System.out.println(id);
		List<ZahtjevDbModel> poslaniZahtjevi = uow.getZahtjevRepository().dajPoslaneZahtjeve(id);
		for (ZahtjevDbModel poslZahtjevDbModel : poslaniZahtjevi) {
			Object[] row = { (Integer) (int) poslZahtjevDbModel.getZahtjevId(), poslZahtjevDbModel.getDokumentVerzija().getDokument().getDokumentNaziv(), "v" + poslZahtjevDbModel.getDokumentVerzijaId(), poslZahtjevDbModel.getUpucenoKorisnik().getUsername(), poslZahtjevDbModel.getZahtjevStatus().getZahtjevStatusNaziv() };
			((DefaultTableModel) tablePoslaniZahtjevi.getModel()).addRow(row);
		}
		
		btnOdobri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Integer zahtjevId = (Integer) tablePrimljeniZahtjevi.getValueAt(tablePrimljeniZahtjevi.getSelectedRow(), 0);
					zahtjevRepository.promijeniStatusZahtjev(2, zahtjevId);
					JOptionPane.showMessageDialog(null, "Uspješno odobreno",
							"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
					//zatvaranje forme
					frmPregledZahtjeva.dispose();
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					JOptionPane.showMessageDialog(frmPregledZahtjeva, poruka);
					throw new RuntimeException(e);
				}
				
			}
		});
		btnOdbij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Integer zahtjevId = (Integer) tablePrimljeniZahtjevi.getValueAt(tablePrimljeniZahtjevi.getSelectedRow(), 0);
					zahtjevRepository.promijeniStatusZahtjev(3, zahtjevId);
					JOptionPane.showMessageDialog(null, "Uspješno odbijeno",
							"Obavještenje", JOptionPane.INFORMATION_MESSAGE);
					//zatvaranje forme
					frmPregledZahtjeva.dispose();
				} catch (RuntimeException e) {
					throw e;
				} catch (Exception e) {
					String poruka = e.getMessage();
					logger.info(poruka);
					JOptionPane.showMessageDialog(frmPregledZahtjeva, poruka);
					throw new RuntimeException(e);
				}
				
			}
		});
		
}}
