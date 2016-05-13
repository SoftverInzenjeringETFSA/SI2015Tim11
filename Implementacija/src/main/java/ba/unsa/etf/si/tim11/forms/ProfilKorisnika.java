package ba.unsa.etf.si.tim11.forms;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.bll.Sesija;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class ProfilKorisnika extends JFrame {

	private JPanel contentPane;
	private JLabel label_imeKorisnika;
	private JLabel label_prezimeKorisnika;
	private JLabel label_adresaKorisnika;
	private JLabel label_datumRodenjaKorisnika;
	private JLabel label_tipKorisnika;
	private JLabel label_pozicijaKorisnika;
	private JPasswordField password_novaSifra;
	private JPasswordField password_ponovljenaSifra;
	private String userNameKorisnika = "";
	private KorisnikDbModel prijavljeniKorisnik;
	private KorisnikRepository korisnikRep = new KorisnikRepository();
	final static Logger logger = Logger.getLogger(DodavanjeKorisnika.class.toString());

	/**
	 * Launch the application.
	 */
	public void PokreniFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilKorisnika frame = new ProfilKorisnika();
					frame.setVisible(true);
				} catch (Exception e) {
					logger.info(e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProfilKorisnika() 
	{
		setResizable(false);
		setTitle("Moj Profil");
		initialize();
		postaviUserNameKorisnika();
		postaviKorisnika();
	}
	
	private void postaviKorisnika() {
		
		int idKorisnika = korisnikRep.dajIdKorisnikaPoUsername(userNameKorisnika);
		prijavljeniKorisnik = korisnikRep.dajKorisnika(idKorisnika);
		label_imeKorisnika.setText(prijavljeniKorisnik.getIme());
		label_prezimeKorisnika.setText(prijavljeniKorisnik.getPrezime());
		label_adresaKorisnika.setText(prijavljeniKorisnik.getAdresa());
		int dan = prijavljeniKorisnik.getDatumRodjenja().getDate();
		int mjesec = prijavljeniKorisnik.getDatumRodjenja().getMonth() + 1;
		int godina = prijavljeniKorisnik.getDatumRodjenja().getYear()+1900;
		label_datumRodenjaKorisnika.setText(dan + "." + mjesec +"."+godina+"");
		label_tipKorisnika.setText(prijavljeniKorisnik.getKorisnikTip().getKorisnikTipNaziv());
		label_pozicijaKorisnika.setText(prijavljeniKorisnik.getKorisnikPozicija().getKorisnikPozicijaNaziv());
	}

	private void postaviUserNameKorisnika() {
		try{
			userNameKorisnika = Sesija.getUsername();
		}
		catch(Exception ex)
		{
			logger.info(ex.getMessage());
			userNameKorisnika = "";
		}
		
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Li\u010Dni podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Promjena \u0161ifre ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
							.addGap(8))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNovaifra = new JLabel("Nova šifra:");
		
		JLabel lblPonoviteifru = new JLabel("Ponovite šifru:");
		
		password_novaSifra = new JPasswordField();
		
		password_ponovljenaSifra = new JPasswordField();
		
		JButton btnPromijeniSifru = new JButton("Promijeni");
		btnPromijeniSifru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(password_novaSifra.getText().equals("") || password_ponovljenaSifra.getText().equals(" "))
				{
					JOptionPane.showMessageDialog(null, "Oba polja za promjenu šifre moraju biti popunjena!", "Greška", JOptionPane.INFORMATION_MESSAGE);			
					return;
				}
				if(!password_novaSifra.getText().equals(password_ponovljenaSifra.getText()))
				{
					JOptionPane.showMessageDialog(null, "Šifre se ne slažu!", "Greška", JOptionPane.INFORMATION_MESSAGE);			
					return;
				}
				
				prijavljeniKorisnik.setPassword(password_novaSifra.getText());
				
				korisnikRep.izmijeniKorisnika(prijavljeniKorisnik);
				JOptionPane.showMessageDialog(null, "Šifra uspješno promijenjena!", "Info", JOptionPane.INFORMATION_MESSAGE);			

			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPromijeniSifru)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNovaifra)
								.addComponent(lblPonoviteifru))
							.addGap(23)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(password_ponovljenaSifra)
								.addComponent(password_novaSifra, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNovaifra)
						.addComponent(password_novaSifra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPonoviteifru)
						.addComponent(password_ponovljenaSifra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPromijeniSifru)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblIme = new JLabel("Ime:");
		
		JLabel lblPrezime = new JLabel("Prezime:");
		
		JLabel lblAdresa = new JLabel("Adresa:");
		
		JLabel lblDatumRoenja = new JLabel("Datum rođenja:");
		
		JLabel lblTipKorisnika = new JLabel("Tip korisnika:");
		
		JLabel lblPozicija = new JLabel("Pozicija:");
		
		label_imeKorisnika = new JLabel("");
		
		label_prezimeKorisnika = new JLabel("");
		
		label_adresaKorisnika = new JLabel("");
		
		label_datumRodenjaKorisnika = new JLabel("");
		
		label_tipKorisnika = new JLabel("");
		
		label_pozicijaKorisnika = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrezime)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIme)
								.addComponent(lblAdresa)
								.addComponent(lblDatumRoenja)
								.addComponent(lblTipKorisnika)
								.addComponent(lblPozicija))
							.addGap(35)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_pozicijaKorisnika)
								.addComponent(label_tipKorisnika)
								.addComponent(label_datumRodenjaKorisnika)
								.addComponent(label_adresaKorisnika)
								.addComponent(label_prezimeKorisnika)
								.addComponent(label_imeKorisnika))))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIme)
						.addComponent(label_imeKorisnika))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrezime)
						.addComponent(label_prezimeKorisnika))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdresa)
						.addComponent(label_adresaKorisnika))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDatumRoenja)
						.addComponent(label_datumRodenjaKorisnika))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipKorisnika)
						.addComponent(label_tipKorisnika))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPozicija)
						.addComponent(label_pozicijaKorisnika))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
}
