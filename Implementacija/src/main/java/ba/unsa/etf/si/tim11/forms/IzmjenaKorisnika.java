package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.Validator;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IzmjenaKorisnika
{

	private JFrame frmIzmjenaKorisnika;
	private JTextField textFieldIzmjenaPretragaKorisnika;
	private JTable tableIzmjenaPretraga;
	private JPasswordField passwordFieldIzmjenaNovaSifra;
	private JPasswordField passwordFieldIzmjenaPonoviSifru;
	private JButton buttonIzmjenaTrazi;
	private JButton buttonIzmjenaBrisiKorisnika;
	
	KorisnikRepository korisnikRepository = new KorisnikRepository();
	KorisnikDbModel korisnik;
	Integer korisnikId;
	ModelTabele mt=new ModelTabele();
	private Boolean uredu[]={false,false};
	
	private Boolean provjeriPolja()
	{
		for(int i=0;i<uredu.length;i++)
		{
			if(uredu[i]==false)
			{
				return false;
			}
		}
		return true;
		
	}
	
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
					IzmjenaKorisnika window = new IzmjenaKorisnika();
					window.frmIzmjenaKorisnika.setVisible(true);
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
	public IzmjenaKorisnika()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmIzmjenaKorisnika = new JFrame();
		frmIzmjenaKorisnika.setTitle("Izmjena Korisnika");
		frmIzmjenaKorisnika.setBounds(100, 100, 748, 516);
		frmIzmjenaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIzmjenaKorisnika.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Pretraga Korisnika:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Dialog", Font.PLAIN, 11));
		label.setBounds(10, 55, 135, 21);
		frmIzmjenaKorisnika.getContentPane().add(label);
		
		textFieldIzmjenaPretragaKorisnika = new JTextField();
		textFieldIzmjenaPretragaKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		textFieldIzmjenaPretragaKorisnika.setColumns(10);
		textFieldIzmjenaPretragaKorisnika.setBounds(155, 52, 461, 27);
		frmIzmjenaKorisnika.getContentPane().add(textFieldIzmjenaPretragaKorisnika);
		
		tableIzmjenaPretraga = new JTable();		
		tableIzmjenaPretraga.setToolTipText("Izmjene u tabeli imaju iste validacije kao i unos korisnika.");
		tableIzmjenaPretraga.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
			},
			new String[] {
			}
		));
		tableIzmjenaPretraga.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tableIzmjenaPretraga.setFont(new Font("Dialog", Font.PLAIN, 11));
		tableIzmjenaPretraga.setCellSelectionEnabled(true);
		tableIzmjenaPretraga.setBounds(155, 98, 566, 173);
		frmIzmjenaKorisnika.getContentPane().add(tableIzmjenaPretraga);
		
		JLabel label_1 = new JLabel("Nova Šifra:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_1.setBounds(10, 328, 135, 21);
		frmIzmjenaKorisnika.getContentPane().add(label_1);
		
		passwordFieldIzmjenaNovaSifra = new JPasswordField();
		passwordFieldIzmjenaNovaSifra.setFont(new Font("Dialog", Font.PLAIN, 11));
		passwordFieldIzmjenaNovaSifra.setBounds(155, 325, 510, 27);
		frmIzmjenaKorisnika.getContentPane().add(passwordFieldIzmjenaNovaSifra);
		
		JLabel label_2 = new JLabel("Ponovi Šifru:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(52, 366, 95, 21);
		frmIzmjenaKorisnika.getContentPane().add(label_2);
		
		passwordFieldIzmjenaPonoviSifru = new JPasswordField();
		
		passwordFieldIzmjenaPonoviSifru.setFont(new Font("Dialog", Font.PLAIN, 11));
		passwordFieldIzmjenaPonoviSifru.setBounds(155, 363, 510, 27);
		frmIzmjenaKorisnika.getContentPane().add(passwordFieldIzmjenaPonoviSifru);
		
		final JButton buttonIzmjenaIzmjeniSifru = new JButton("Izmijeni Šifru");
		
		buttonIzmjenaIzmjeniSifru.setEnabled(false);
		buttonIzmjenaIzmjeniSifru.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaIzmjeniSifru.setBounds(605, 401, 115, 27);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaIzmjeniSifru);
		
		final JLabel lblIzmjenaPretraga = new JLabel("");
		lblIzmjenaPretraga.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblIzmjenaPretraga.setBounds(155, 27, 461, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblIzmjenaPretraga);
		frmIzmjenaKorisnika.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{label, textFieldIzmjenaPretragaKorisnika, buttonIzmjenaTrazi, tableIzmjenaPretraga, label_1, passwordFieldIzmjenaNovaSifra, label_2, passwordFieldIzmjenaPonoviSifru, buttonIzmjenaIzmjeniSifru, buttonIzmjenaBrisiKorisnika}));
		
		buttonIzmjenaTrazi = new JButton("Traži");
		buttonIzmjenaTrazi.setEnabled(false);
		buttonIzmjenaTrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String pretraga=textFieldIzmjenaPretragaKorisnika.getText();
					if(korisnikRepository.dajIdKorisnikaPoUsername(pretraga)!=null)
					{
						korisnikId=korisnikRepository.dajIdKorisnikaPoUsername(pretraga);
						korisnik=korisnikRepository.dajKorisnika(korisnikId);
						mt.dodajElement(korisnik);
						tableIzmjenaPretraga.setModel(mt);
						
					}
					else
					{
						JOptionPane.showMessageDialog(frmIzmjenaKorisnika,"Nema korisnika s tim korisničkim imenom!");
						textFieldIzmjenaPretragaKorisnika.setText("");
					}
				}
				catch(Exception e)
				{
					String poruka=e.getMessage();
					JOptionPane.showMessageDialog(frmIzmjenaKorisnika,poruka);
				}
				
			}
		});
		buttonIzmjenaTrazi.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaTrazi.setBounds(626, 50, 95, 29);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaTrazi);
		
		textFieldIzmjenaPretragaKorisnika.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String pretraga=textFieldIzmjenaPretragaKorisnika.getText();
				if(!Validator.daLiJeStringPrazan(pretraga)&&Validator.daLiJeStringSlovaIBrojevi(pretraga))
				{
					lblIzmjenaPretraga.setText("OK");
					lblIzmjenaPretraga.setForeground(new Color(0, 128, 0));
					buttonIzmjenaTrazi.setEnabled(true);
				}
				else
				{
					lblIzmjenaPretraga.setForeground(Color.red);
					lblIzmjenaPretraga.setText("Niste unijeli korisničko ime za pretragu");
					buttonIzmjenaTrazi.setEnabled(false);
				}
			}
		});
		
		buttonIzmjenaBrisiKorisnika = new JButton("Izbriši Korisnika");
		buttonIzmjenaBrisiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		buttonIzmjenaBrisiKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		buttonIzmjenaBrisiKorisnika.setBounds(605, 439, 116, 27);
		frmIzmjenaKorisnika.getContentPane().add(buttonIzmjenaBrisiKorisnika);
		
		final JButton btnIzmijeniKorisnika = new JButton("Spremi Promjene");
		btnIzmijeniKorisnika.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnIzmijeniKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				korisnikRepository.izmijeniKorisnika(korisnik);
				JOptionPane.showMessageDialog(frmIzmjenaKorisnika, "Podaci spremljeni");
				
			}
		});
		btnIzmijeniKorisnika.setEnabled(false);
		tableIzmjenaPretraga.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(1==1/*!korisnik.equals(null)*/)
				{
					btnIzmijeniKorisnika.setEnabled(true);
				}
				
			}
		});
		btnIzmijeniKorisnika.setBounds(605, 282, 116, 27);
		frmIzmjenaKorisnika.getContentPane().add(btnIzmijeniKorisnika);
		
		final JLabel lblOKNS = new JLabel("");
		lblOKNS.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblOKNS.setBounds(675, 332, 46, 14);
		frmIzmjenaKorisnika.getContentPane().add(lblOKNS);
		
		final JLabel labelOKPS = new JLabel("");
		labelOKPS.setFont(new Font("Dialog", Font.PLAIN, 11));
		labelOKPS.setBounds(675, 370, 46, 14);
		frmIzmjenaKorisnika.getContentPane().add(labelOKPS);
		passwordFieldIzmjenaNovaSifra.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String s=passwordFieldIzmjenaNovaSifra.getText();
				if(!Validator.daLiJeStringPrazan(s))
				{
					lblOKNS.setText("OK");
					lblOKNS.setForeground(new Color(0, 128, 0));
					uredu[0]=true;
				}
				else
				{
					lblOKNS.setText("NOTOK");
					lblOKNS.setForeground(Color.red);
					uredu[0]=false;
				}
				if(provjeriPolja())
				{
					buttonIzmjenaIzmjeniSifru.setEnabled(true);
				}
				else
				{
					buttonIzmjenaIzmjeniSifru.setEnabled(false);
				}
				
			}
		});
		
		passwordFieldIzmjenaPonoviSifru.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				String s1=passwordFieldIzmjenaPonoviSifru.getText();
				String s2=passwordFieldIzmjenaNovaSifra.getText();
				
				if(!Validator.daLiJeStringPrazan(s1)&&!Validator.daLiJeStringPrazan(s2)&&s1.equals(s2))
				{
					labelOKPS.setText("OK");
					labelOKPS.setForeground(new Color(0, 128, 0));
					uredu[1]=true;
				}
				else
				{
					labelOKPS.setText("NOTOK");
					labelOKPS.setForeground(Color.red);
					uredu[1]=false;
				}
				if(provjeriPolja())
				{
					buttonIzmjenaIzmjeniSifru.setEnabled(true);
				}
				else
				{
					buttonIzmjenaIzmjeniSifru.setEnabled(false);
				}
			}
		});
		
		buttonIzmjenaIzmjeniSifru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				korisnik.setPassword(passwordFieldIzmjenaPonoviSifru.getText());
				korisnikRepository.izmijeniKorisnika(korisnik);
				passwordFieldIzmjenaNovaSifra.setText("");
				passwordFieldIzmjenaPonoviSifru.setText("");
				JOptionPane.showMessageDialog(frmIzmjenaKorisnika, "Sifra Promijenjena");
			}
		});
		
		
	}
}
