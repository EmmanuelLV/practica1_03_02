package Vinateria;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.Font;

public class LoginNoExist extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final  JPanel contentPanel = new JPanel();
	private JTextPane txtpnMensaje;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public LoginNoExist(String mensaje) {
		getContentPane().setBackground(Color.ORANGE);
		setBackground(Color.WHITE);
		setUndecorated(true);
		setBounds(100, 100, 369, 150);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
			buttonPane.setBorder(new LineBorder(new Color(32, 178, 170), 6, true));
			buttonPane.setBounds(6, 114, 357, 32);
			buttonPane.setBackground(new Color(32, 178, 170));
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				okButton.setBounds(247, 8, 100, 20);
				buttonPane.add(okButton);
				okButton.setMargin(new Insets(2, 30, 2, 14));
				okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				okButton.setForeground(Color.WHITE);
				okButton.setMaximumSize(new Dimension(100, 20));
				okButton.setMinimumSize(new Dimension(100, 40));
				okButton.setBorder(new LineBorder(Color.WHITE, 2));
				okButton.setBackground(new Color(32, 178, 170));
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
		}
		contentPanel.setBounds(6, 5, 357, 118);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(new Color(32, 178, 170), 5, true));
		getContentPane().add(contentPanel);
		{
			JLabel lblIcono = new JLabel("Icono");
			contentPanel.setLayout(null);
			lblIcono.setBounds(10, 11, 84, 75);
			ImageIcon imagen = new ImageIcon(getClass().getResource("/Vinateria/Res/warning.png"));
			imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblIcono.getWidth(), lblIcono.getHeight(), Image.SCALE_DEFAULT));
			lblIcono.setIcon(imagen);
			contentPanel.add(lblIcono);
		}
		
		JLabel lblAdvertencia = new JLabel("Advertencia:  ");
		lblAdvertencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdvertencia.setForeground(new Color(255, 0, 0));
		lblAdvertencia.setBounds(144, 19, 187, 14);
		contentPanel.add(lblAdvertencia);
		
		txtpnMensaje = new JTextPane();
		txtpnMensaje.setEditable(false);
		txtpnMensaje.setText(mensaje);
		txtpnMensaje.setBounds(154, 44, 177, 63);
		contentPanel.add(txtpnMensaje);
	}
}
