package Vinateria;

import java.awt.EventQueue;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.awt.EventQueue;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.barcodelib.barcode.QRCode;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Desktop;

public class qr {

	private JFrame frame;
	private JTextField txtCampo;
	int udm=0, resol=72, rot=0;
	float mi=0.000f, md=0.000f, ms=0.000f, min=0.000f, tam=5.00f;
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					qr window = new qr();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public qr(String dato) {
	//	initialize();
		generarQr(dato);
	}
	ByteArrayOutputStream out;
	private JLabel lblQr;
	public void generarQr(String dato) {
		String archivo=null;
		try {
			
			QRCode c=new QRCode();
			c.setData(dato);
			c.setDataMode(QRCode.MODE_BYTE);
			c.setUOM(udm);
			c.setLeftMargin(mi);
			c.setRightMargin(md);
			c.setTopMargin(ms);
			c.setBottomMargin(min);
			c.setResolution(resol);
			c.setRotate(rot);
			c.setModuleSize(tam);	
			
			archivo= System.getProperty("user.home")+"\\QrProyecto\\Hola.png";
			c.renderBarcode(archivo);
			
			Desktop d=Desktop.getDesktop();
			d.open(new File(archivo));
			

		}catch(Exception e) {
			System.out.println("Error "+e);
		}

		//cargarImg("qr");

		
//		final JPanel jpQr = new JPanel(){
//			protected void paintComponent(Graphics g)
//			{
//				Image imgIK = new ImageIcon(getClass().getResource("archivo")).getImage();
//				Dimension d = getSize ();
//				g.drawImage (imgIK,0,0, d.width, d.height, null);
//			}
//		};
//		jpQr.setBounds(30, 60, 150,150);
//		jpQr.setVisible(true);
//		jpQr.repaint();
//		
//		
//		
		
		
	}
	int a = 0;
	private JLabel lblA;
	private void cargarImg(String ruta) {
		System.out.println(ruta);
		lblQr.setIcon(null);
		lblQr.setIcon(new ImageIcon("C:\\Users\\Emmanuel\\QrProyecto\\"+ruta+a+".png"));
		lblA.setText("Emma"+a);
		lblQr.repaint();
		lblQr.validate();
		a++;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 350);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		txtCampo = new JTextField();
		txtCampo.setBounds(26, 55, 219, 41);
		frame.getContentPane().add(txtCampo);
		txtCampo.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String campo= txtCampo.getText();
				generarQr(campo);
				
			}
		});
		btnGenerar.setBounds(278, 55, 117, 41);
		frame.getContentPane().add(btnGenerar);
		
		lblQr = new JLabel("");
		lblQr.setToolTipText("Escanea el QR para ver la informacion\r\n");
		lblQr.setBounds(163, 154, 117, 113);
		frame.getContentPane().add(lblQr);
		
		lblA = new JLabel("A");
		lblA.setBounds(333, 199, 82, 33);
		frame.getContentPane().add(lblA);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
