package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;
import java.awt.RenderingHints.Key;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import net.sourceforge.jdatepicker.util.JDatePickerUtil;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginForma {
	
	private JFrame frmDmsLogin;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	final static Logger logger = Logger.getLogger(LoginForma.class.toString());
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForma window = new LoginForma();
					window.frmDmsLogin.setVisible(true);
				} catch (Exception e) {
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
	public LoginForma() {
		initialize();
	}
	
	private void prijavaKorisnika(){
		//autentikacija korisnika
		if(KorisnikRepository.korisnikAutenticiran(txtUsername.getText(), passwordField.getText())){
			JOptionPane.showMessageDialog(null, "Vaša prijava je uspješna.", "Dobrodošao "+txtUsername.getText(), JOptionPane.INFORMATION_MESSAGE);
			GlavnaForma glavnaForma = new GlavnaForma();
			glavnaForma.PokreniFormu();
			//frmDmsLogin.setVisible(false);
			frmDmsLogin.dispose();
			
		}else{
			JOptionPane.showMessageDialog(null, "Molimo provjerite vaše podatke za prijavu.", "Neuspješna prijava", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDmsLogin = new JFrame();
		frmDmsLogin.setTitle("DMS Login");
		frmDmsLogin.setBounds(100, 100, 278, 160);
		frmDmsLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDmsLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(25, 28, 59, 14);
		frmDmsLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(25, 53, 59, 14);
		frmDmsLogin.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(97, 25, 148, 20);
		frmDmsLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 50, 148, 20);
		frmDmsLogin.getContentPane().add(passwordField);
		
		JButton btnPrijaviSe = new JButton("Prijava");
		btnPrijaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prijavaKorisnika();
			}
		});
		btnPrijaviSe.setBounds(97, 81, 74, 21);
		frmDmsLogin.getContentPane().add(btnPrijaviSe);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDmsLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmDmsLogin.dispatchEvent(new WindowEvent(frmDmsLogin, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnIzlaz.setBounds(181, 81, 64, 21);
		frmDmsLogin.getContentPane().add(btnIzlaz);
		
		frmDmsLogin.getRootPane().setDefaultButton(btnPrijaviSe);
	}
}
