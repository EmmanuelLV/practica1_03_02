package Vinateria;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import database.Conexion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {
	public Idioma idiom;
	public JFrame frame;
	private JPasswordField pwdContrasea;
	
	final int caracter = 20;
	final int caracter2 = 5;
	private JLabel jlbUsuario;
	private JLabel lblPass;
	private JButton btnEntrar;
	private JMenu mnIdioma;
	private JMenuItem mntmIngles;
	private JMenuItem mntmEspaol;
	private JMenu mnAccesibiladad;
	private JMenuItem mntmMonochromatismo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		idiom =  new Idioma("Ingles");
		frame = new JFrame();
		frame.setTitle(idiom.getProperty("logintitle"));
		frame.setBounds(100, 100, 568, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		
		
		jlbUsuario = new JLabel ("");
		jlbUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		jlbUsuario.setForeground(Color.WHITE);
		frame.getContentPane().add(jlbUsuario);
		jlbUsuario.setText(idiom.getProperty("loginUsuario"));
		jlbUsuario.setBounds(340, 54, 212, 20);
	
		JTextField jtxUsuario = new JTextField();
		jtxUsuario.setBackground(Color.white);
		jtxUsuario.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (validar(jtxUsuario.getText(), "^([A-Z || 0-9]){9}?$")) {
					jtxUsuario.setBackground(new Color(152, 251, 152));
				}else{
					jtxUsuario.setBackground(new Color(250, 128, 114));
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if (jtxUsuario.getText().length() > 8) {
					e.consume();
					LoginNoExist lb = new LoginNoExist("La contraseña no puede ser mas larga");
					lb.setVisible(true);
				}
			}
		});
		jtxUsuario.setBounds(350, 85, 150, 20);
		frame.getContentPane().add(jtxUsuario);
		jtxUsuario.setVisible(true);
		jtxUsuario.setToolTipText(idiom.getProperty("jtxUsuarioTooltip"));
		
		pwdContrasea = new JPasswordField();
		pwdContrasea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if (pwdContrasea.getText().length() > 7) {
					e.consume();
					LoginNoExist lb = new LoginNoExist("La contraseña no puede ser mas larga");
					lb.setVisible(true);
				}
			}
		});
		pwdContrasea.setBounds(350, 138, 150, 20);
		frame.getContentPane().add(pwdContrasea);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(68, 50, 197, 187);
		frame.getContentPane().add(lblLogo);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/Vinateria/Res/Logo.png"));
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(imagen);
		frame.getContentPane().add(lblLogo);

		btnEntrar = new JButton();
		btnEntrar.setText(idiom.getProperty("btnEntrar"));
		frame.getContentPane().add(btnEntrar);
		btnEntrar.setBounds(400, 210, 100, 30);
		btnEntrar.setToolTipText(idiom.getProperty("btnEntrar"));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(32, 178, 170));
		btnEntrar.setBorder(new LineBorder(Color.WHITE,2));
		
		lblPass = new JLabel("");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPass.setText(idiom.getProperty("loginContrasena"));
		lblPass.setForeground(Color.WHITE);
		lblPass.setBounds(340, 116, 212, 20);
		frame.getContentPane().add(lblPass);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnIdioma = new JMenu("Idioma");
		menuBar.add(mnIdioma);
		
		mntmIngles = new JMenuItem("Ingles");
		mntmIngles.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				idiom = new Idioma("Ingles");
				cambiarTexto();
			}
		});
		mnIdioma.add(mntmIngles);
		
		mntmEspaol = new JMenuItem("Espa\u00F1ol");
		mntmEspaol.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				idiom = new Idioma("Español");
				cambiarTexto();
			}
		});
		mnIdioma.add(mntmEspaol);
		
		mnAccesibiladad = new JMenu("Accesibiladad");
		menuBar.add(mnAccesibiladad);
		
		mntmMonochromatismo = new JMenuItem("Monocromatismo");
		mnAccesibiladad.add(mntmMonochromatismo);
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String myLogin = jtxUsuario.getText().trim ();
				String myPass = new String (pwdContrasea.getPassword()).trim();
				Boolean siPass = false;
				try {
					siPass = verificapass(myLogin, myPass);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(siPass);
				if (siPass){
					frame.setVisible(false);
					frame.dispose();
					Main main = new Main(idiom);
				}	
			}
		});
	cambiarTexto();

		
}		
		private void cambiarTexto() {
			jlbUsuario.setText(idiom.getProperty("loginUsuario"));
			lblPass.setText(idiom.getProperty("loginContrasena"));
			frame.setTitle(idiom.getProperty("logintitle"));
			btnEntrar.setText(idiom.getProperty("btnEntrar"));
			mnIdioma.setText(idiom.getProperty("mnIdioma"));
			mntmIngles.setText(idiom.getProperty("mntmIngles"));
			mntmEspaol.setText(idiom.getProperty("mntmEspaol"));
			mnAccesibiladad.setText(idiom.getProperty("mnAccesibiladad"));
			mntmMonochromatismo.setText(idiom.getProperty(""));
		}
		
		private boolean verificapass(String login, String password) throws SQLException{
			try {
			 ResultSet Rs = Conexion.select("RFC,Contraseña","empleados");
			 while (Rs.next()) {
				 //System.out.println(Rs.getString("RFC")+" "+Rs.getString("Contraseña"));
				if (Rs.getString("RFC").equals(login) && Rs.getString("Contraseña").equals(password))
					return true;
			 }
			}catch (SQLException e) {
				e.printStackTrace();
				new LoginNoExist("No hay conexión a la base de datos").setVisible(true);
				System.out.println("no conexion");
			}
			return false;
		}
		
		private boolean validar(String cadena,String regex) {
			if(cadena.matches(regex))
			return true;
			return false;
		}
}
