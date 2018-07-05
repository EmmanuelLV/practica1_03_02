package Vinateria;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
	
	//Página principal

	public Idioma idiom =new Idioma("Ingles");
	public int abrir = 0;
	
	public JTextField jtxUsuario = new JTextField();
	public JPasswordField jtxPassword = new JPasswordField();
	
	public Login(){
		setTitle(idiom.getProperty("logintitle"));
		setVisible(true);
		setSize(580,300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		getContentPane().setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		Log ();
		setVisible (true);
								
		JButton btnEntrar = new JButton();
		btnEntrar.setText(idiom.getProperty("btnEntrar"));
		getContentPane().add(btnEntrar);
		btnEntrar.setBounds(400, 210, 100, 30);
		btnEntrar.setToolTipText(idiom.getProperty("btnEntrar"));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(32, 178, 170));
		btnEntrar.setBorder(new LineBorder(Color.WHITE,2));
				
		final JLabel jlbUsuario = new JLabel ("");
		jlbUsuario.setForeground(Color.WHITE);
		getContentPane().add(jlbUsuario);
		jlbUsuario.setText(idiom.getProperty("loginUsuario"));
		jlbUsuario.setBounds(230, 50, 50, 20);
	
		JTextField jtxUsuario = new JTextField();
		jtxUsuario.setBounds(350, 50, 150, 20);
		jtxUsuario.setText("luisangel@login.es");
		getContentPane().add(jtxUsuario);
		jtxUsuario.setVisible(true);
		jtxUsuario.setToolTipText(idiom.getProperty("jtxUsuarioTooltip"));
				
		final JLabel jlbContraseña = new JLabel ("");
		jlbContraseña.setForeground(Color.WHITE);
		getContentPane().add(jlbContraseña);
		jlbContraseña.setText(idiom.getProperty("loginContrasena"));
		jlbContraseña.setBounds(230, 130, 100, 20);
		
		JButton btnIdioma = new JButton("");
		btnIdioma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idiom = new Idioma("Español");
			}
		});
		btnIdioma.setBounds(0, 248, 21, 23);
		getContentPane().add(btnIdioma);
		
		final JPasswordField jtxPassword = new JPasswordField ();
		jtxPassword.setBounds(350, 130, 150, 20);
		jtxPassword.setText("luis123");
		super.add(jtxPassword);
		jtxPassword.setVisible(true);
		jtxPassword.setToolTipText(idiom.getProperty("jtxpassTooltip"));
	
		btnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				String myLogin = jtxUsuario.getText().trim ();
				String myPass = new String (jtxPassword.getPassword()).trim();
				
				int siPass = verificapass(myLogin, myPass);
				
				if (siPass == 1){
					new Login().setVisible(false);
					dispose();
					abrir=0;
					new Menu().setVisible(true);
					abrir=1;
				}
			}
		});
}
	private void Log (){
		getContentPane().setLayout (null);
		
		final JPanel jpEncabezado = new JPanel(){
			protected void paintComponent(Graphics g)
			{
				Image imgIK = new ImageIcon(getClass().getResource("Res/Logo.png")).getImage();
				Dimension d = getSize ();
				g.drawImage (imgIK,0,0, d.width, d.height, null);
			}
		};
		jpEncabezado.setBounds(30, 60, 150,150);
		getContentPane().add(jpEncabezado);
	
	}
		final int caracter = 20;
		final int caracter2 = 5;
		private int verificapass(String login, String password){
			if (login.contains("@")){
			}else
				JOptionPane.showMessageDialog(null, idiom.getProperty("noCorreoMessageDi"));
			if (password.length() <= caracter && password.length() >= caracter2){ 
			}else
				JOptionPane.showMessageDialog(null, idiom.getProperty("nologin"));
			if (login.equals("luisangel@login.es") && password.equals("luis123")){
				JOptionPane.showMessageDialog(null, idiom.getProperty("silogin"));
				return 1;
			}	return 0;
		}
		
		public static void main(String[] args) {
			
			new Login();
			//new Menu();
		}
}