package Vinateria;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.BoxLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class loader {

	private JFrame frame;
	//public Timer timer;
	public javax.swing.Timer timer;
	public JFrame loader = frame;
	private JProgressBar barraProgreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loader window = new loader();

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
	public loader() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				timer = new javax.swing.Timer(100,new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int n = barraProgreso.getValue();
						if (n < 100) {
							n++;
							barraProgreso.setValue(n);
						} else {
							try {
								Thread.sleep(500);
							} catch (InterruptedException ex) {
								Logger.getLogger(loader.class.getName()).log(Level.SEVERE, null, ex);
							}
							timer.stop();
							Login l = new Login();
							l.setVisible(true);
							loader.getFrames()[0].setVisible(false);
						}

					}
				});
				timer.start();
			}
			});
		frame.setUndecorated(true);
		frame.setBackground(new Color(0,0,0,0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(loader.class.getResource("/Vinateria/Res/Logo.png")));
		frame.setBounds(100, 100, 450, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(72, 11, 314, 278);

		ImageIcon imagen = new ImageIcon(getClass().getResource("/Vinateria/Res/Logo.png"));
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
		lblLogo.setIcon(imagen);
		frame.getContentPane().add(lblLogo);
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 290, 314, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
				
		barraProgreso = new JProgressBar();
		barraProgreso.setForeground(new Color(25, 25, 112));
		panel.add(barraProgreso, BorderLayout.CENTER);
		barraProgreso.setStringPainted(true);
		barraProgreso.setAlignmentX(Component.RIGHT_ALIGNMENT);
		barraProgreso.setValue(1);
		
		
	}

	public class Progreso implements ActionListener{          
		private ActionListener Progreso(ActionEvent evt) {
			int n = barraProgreso.getValue();
			if (n < 100) {
				n++;
				barraProgreso.setValue(n);
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					Logger.getLogger(loader.class.getName()).log(Level.SEVERE, null, ex);
				}
				timer.stop();
				Login l = new Login();
				l.setVisible(true);
				loader.setVisible(false);
			}
			return null;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}

