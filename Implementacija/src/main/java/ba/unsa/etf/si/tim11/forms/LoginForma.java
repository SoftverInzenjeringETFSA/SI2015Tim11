package ba.unsa.etf.si.tim11.forms;

import java.awt.EventQueue;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDmsLogin = new JFrame();
		frmDmsLogin.setTitle("DMS Login");
		frmDmsLogin.setBounds(100, 100, 300, 202);
		frmDmsLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDmsLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(35, 34, 59, 14);
		frmDmsLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(35, 59, 59, 14);
		frmDmsLogin.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(107, 31, 130, 20);
		frmDmsLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 56, 130, 20);
		frmDmsLogin.getContentPane().add(passwordField);
		
		JButton btnPrijaviSe = new JButton("Prijavi se");
		btnPrijaviSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(KorisnikRepository.korisnikAutenticiran(txtUsername.getText(), passwordField.getText())){
					JOptionPane.showMessageDialog(null, "Uspjesno", "Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
					GlavnaForma glavnaForma = new GlavnaForma();
					glavnaForma.PokreniFormu();
					frmDmsLogin.setVisible(false);
					
				}else{
					JOptionPane.showMessageDialog(null, "GRESKA", "Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
		btnPrijaviSe.setBounds(107, 87, 98, 23);
		frmDmsLogin.getContentPane().add(btnPrijaviSe);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDmsLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmDmsLogin.dispatchEvent(new WindowEvent(frmDmsLogin, WindowEvent.WINDOW_CLOSING));
			}
		});
		btnIzlaz.setBounds(107, 121, 98, 20);
		frmDmsLogin.getContentPane().add(btnIzlaz);
	}
}
