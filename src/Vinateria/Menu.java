package Vinateria;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import database.mostrarTabla;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Menu extends JFrame {
	public int abrir = 0;
	private JTextField txtNombreproducto;
	private JTextField txtIdProducto;
	private JTextField txtPrecioventa;
	private JTextField txtPreciocosto;
	private JTextField txtTipoproducto;
	private JPanel pnPuntoVenta;
	private JPanel pnAgregarProducto;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtTotalIva;
	private JTextField txtBuscarpoducto;
	
	public Menu(){
		
	setTitle("Menú");
	setVisible(true);
	setSize(1000,650);
	setLocationRelativeTo(null);
	getContentPane().setLayout(null);
	setResizable(false);
	getContentPane().setBackground(new Color(32, 178, 170));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JButton btnAProducto = new JButton();
	btnAProducto.setText("Agregar producto");
	getContentPane().add(btnAProducto);
	btnAProducto.setBounds(10, 11, 230, 190);
	btnAProducto.setToolTipText("Click aquí para agregar");
	btnAProducto.setForeground(Color.WHITE);
	btnAProducto.setBackground(new Color(32, 178, 170));
	btnAProducto.setBorder(new LineBorder(new Color(255, 255, 255), 4));
	btnAProducto.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (!pnAgregarProducto.isVisible()){
				getContentPane().add(pnAgregarProducto);
				pnAgregarProducto.setVisible(true);
				pnPuntoVenta.setVisible(false);
			}else{
				pnAgregarProducto.setVisible(false);
			}
		}
	});
	
	JButton btnPVenta = new JButton();
	btnPVenta.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (!pnPuntoVenta.isVisible()){
				getContentPane().add(pnPuntoVenta);
				pnPuntoVenta.setVisible(true);
				pnAgregarProducto.setVisible(false);
			}else{
				pnPuntoVenta.setVisible(false);
			}
		}
	});
	btnPVenta.setText("Punto de venta");
	getContentPane().add(btnPVenta);
	btnPVenta.setBounds(10, 215, 230, 190);
	btnPVenta.setToolTipText("Punto de venta");
	btnPVenta.setForeground(Color.WHITE);
	btnPVenta.setBackground(new Color(32, 178, 170));
	btnPVenta.setBorder(new LineBorder(new Color(255, 255, 255), 4));
	
	JButton btnSalir = new JButton();
	btnSalir.setText("Salir");
	getContentPane().add(btnSalir);
	btnSalir.setBounds(10, 420, 230, 190);
	btnSalir.setToolTipText("Salir");
	btnSalir.setForeground(Color.WHITE);
	btnSalir.setBackground(new Color(32, 178, 170));
	btnSalir.setBorder(new LineBorder(new Color(255, 255, 255), 4));
	
	pnPuntoVenta = new JPanel();
	pnPuntoVenta.setBackground(Color.WHITE);
	pnPuntoVenta.setAutoscrolls(true);
	pnPuntoVenta.setBounds(238, 11, 746, 599);
	//getContentPane().add(pnPuntoVenta);
	
	scrollPane = new JScrollPane();
	scrollPane.setAutoscrolls(true);
	
	JButton buttonRegresar = new JButton("Regresar");
	buttonRegresar.setMinimumSize(new Dimension(100, 30));
	buttonRegresar.setBorder(new LineBorder(new Color(0, 0, 0)));
	buttonRegresar.setBackground(Color.WHITE);
	
	JButton buttonPagar = new JButton("Regresar");
	buttonPagar.setMinimumSize(new Dimension(100, 30));
	buttonPagar.setBorder(new LineBorder(new Color(0, 0, 0)));
	buttonPagar.setBackground(Color.WHITE);
	
	JButton btnPFD = new JButton("PDF");
	btnPFD.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			mostrarTabla.pdftabla(table.getModel());
		}
	});
	btnPFD.setMinimumSize(new Dimension(100, 30));
	btnPFD.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnPFD.setBackground(Color.WHITE);
	
	txtTotalIva = new JTextField();
	txtTotalIva.setColumns(10);
	
	JLabel lblTotalIva = new JLabel("Total + IVA");
	lblTotalIva.setFont(new Font("Tahoma", Font.BOLD, 13));
	
	txtBuscarpoducto = new JTextField();
	txtBuscarpoducto.setText("BuscarPoducto");
	txtBuscarpoducto.setColumns(10);
	
	JButton btnBuscar = new JButton("Buscar");
	btnBuscar.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			
		}
	});
	btnBuscar.setMinimumSize(new Dimension(100, 30));
	btnBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnBuscar.setBackground(Color.WHITE);
	GroupLayout gl_pnPuntoVenta = new GroupLayout(pnPuntoVenta);
	gl_pnPuntoVenta.setHorizontalGroup(
		gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_pnPuntoVenta.createSequentialGroup()
				.addContainerGap()
				.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnPuntoVenta.createSequentialGroup()
						.addComponent(buttonRegresar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGap(212)
						.addComponent(btnPFD, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
						.addComponent(buttonPagar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
					.addGroup(Alignment.TRAILING, gl_pnPuntoVenta.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)
						.addGap(24))))
			.addGroup(Alignment.TRAILING, gl_pnPuntoVenta.createSequentialGroup()
				.addGap(39)
				.addComponent(txtBuscarpoducto, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
				.addComponent(lblTotalIva, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addComponent(txtTotalIva, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
				.addGap(60))
	);
	gl_pnPuntoVenta.setVerticalGroup(
		gl_pnPuntoVenta.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_pnPuntoVenta.createSequentialGroup()
				.addContainerGap()
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.BASELINE)
					.addComponent(txtTotalIva, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblTotalIva, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addComponent(txtBuscarpoducto, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
				.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
					.addComponent(buttonRegresar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.BASELINE)
						.addComponent(buttonPagar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPFD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
				.addGap(28))
	);
	
	table = new JTable();
	scrollPane.setViewportView(table);
	pnPuntoVenta.setLayout(gl_pnPuntoVenta);
	/*
	pnAgregarProducto = new JPanel();
	pnAgregarProducto.setVisible(false);
	pnAgregarProducto.setBackground(Color.WHITE);
	pnAgregarProducto.setBounds(238, 11, 746, 599);
	//getContentPane().add(pnAgregarProducto);
	GridBagLayout gbl_pnAgregarProducto = new GridBagLayout();
	gbl_pnAgregarProducto.columnWidths = new int[]{80, 0, 0, 0, 0, 66, 338, 306, 0, 0, 0};
	gbl_pnAgregarProducto.rowHeights = new int[]{0, 0, 115, 0, 48, 44, 38, 48, 0, 47, 0, 48, 0, 58, 0, 0, 0, 0, 0, 0};
	gbl_pnAgregarProducto.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
	gbl_pnAgregarProducto.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	pnAgregarProducto.setLayout(gbl_pnAgregarProducto);
	
	JLabel lblNombreDelProducto = new JLabel("Nombre del producto");
	GridBagConstraints gbc_lblNombreDelProducto = new GridBagConstraints();
	gbc_lblNombreDelProducto.insets = new Insets(0, 0, 5, 5);
	gbc_lblNombreDelProducto.gridx = 3;
	gbc_lblNombreDelProducto.gridy = 4;
	pnAgregarProducto.add(lblNombreDelProducto, gbc_lblNombreDelProducto);
	
	txtNombreproducto = new JTextField();
	GridBagConstraints gbc_txtNombreproducto = new GridBagConstraints();
	gbc_txtNombreproducto.insets = new Insets(0, 0, 5, 5);
	gbc_txtNombreproducto.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtNombreproducto.gridx = 6;
	gbc_txtNombreproducto.gridy = 4;
	pnAgregarProducto.add(txtNombreproducto, gbc_txtNombreproducto);
	txtNombreproducto.setColumns(10);
	
	JLabel lblIdDelProducto = new JLabel("Id del producto");
	GridBagConstraints gbc_lblIdDelProducto = new GridBagConstraints();
	gbc_lblIdDelProducto.insets = new Insets(0, 0, 5, 5);
	gbc_lblIdDelProducto.gridx = 3;
	gbc_lblIdDelProducto.gridy = 6;
	pnAgregarProducto.add(lblIdDelProducto, gbc_lblIdDelProducto);
	
	txtIdProducto = new JTextField();
	txtIdProducto.setText("\r\n");
	GridBagConstraints gbc_txtIdProducto = new GridBagConstraints();
	gbc_txtIdProducto.insets = new Insets(0, 0, 5, 5);
	gbc_txtIdProducto.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtIdProducto.gridx = 6;
	gbc_txtIdProducto.gridy = 6;
	pnAgregarProducto.add(txtIdProducto, gbc_txtIdProducto);
	txtIdProducto.setColumns(10);
	
	JLabel lblPrecioVenta = new JLabel("Precio venta");
	GridBagConstraints gbc_lblPrecioVenta = new GridBagConstraints();
	gbc_lblPrecioVenta.insets = new Insets(0, 0, 5, 5);
	gbc_lblPrecioVenta.gridx = 3;
	gbc_lblPrecioVenta.gridy = 8;
	pnAgregarProducto.add(lblPrecioVenta, gbc_lblPrecioVenta);
	
	txtPrecioventa = new JTextField();
	GridBagConstraints gbc_txtPrecioventa = new GridBagConstraints();
	gbc_txtPrecioventa.insets = new Insets(0, 0, 5, 5);
	gbc_txtPrecioventa.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtPrecioventa.gridx = 6;
	gbc_txtPrecioventa.gridy = 8;
	pnAgregarProducto.add(txtPrecioventa, gbc_txtPrecioventa);
	txtPrecioventa.setColumns(10);
	
	JLabel lblPrecioCosto = new JLabel("Precio costo");
	GridBagConstraints gbc_lblPrecioCosto = new GridBagConstraints();
	gbc_lblPrecioCosto.insets = new Insets(0, 0, 5, 5);
	gbc_lblPrecioCosto.gridx = 3;
	gbc_lblPrecioCosto.gridy = 10;
	pnAgregarProducto.add(lblPrecioCosto, gbc_lblPrecioCosto);
	
	txtPreciocosto = new JTextField();
	GridBagConstraints gbc_txtPreciocosto = new GridBagConstraints();
	gbc_txtPreciocosto.insets = new Insets(0, 0, 5, 5);
	gbc_txtPreciocosto.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtPreciocosto.gridx = 6;
	gbc_txtPreciocosto.gridy = 10;
	pnAgregarProducto.add(txtPreciocosto, gbc_txtPreciocosto);
	txtPreciocosto.setColumns(10);
	
	JLabel lblTipoProducto = new JLabel("Tipo Producto");
	GridBagConstraints gbc_lblTipoProducto = new GridBagConstraints();
	gbc_lblTipoProducto.insets = new Insets(0, 0, 5, 5);
	gbc_lblTipoProducto.gridx = 3;
	gbc_lblTipoProducto.gridy = 12;
	pnAgregarProducto.add(lblTipoProducto, gbc_lblTipoProducto);
	
	txtTipoproducto = new JTextField();
	GridBagConstraints gbc_txtTipoproducto = new GridBagConstraints();
	gbc_txtTipoproducto.insets = new Insets(0, 0, 5, 5);
	gbc_txtTipoproducto.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtTipoproducto.gridx = 6;
	gbc_txtTipoproducto.gridy = 12;
	pnAgregarProducto.add(txtTipoproducto, gbc_txtTipoproducto);
	txtTipoproducto.setColumns(10);
	
	JButton btnRegresar = new JButton("Regresar");
	btnRegresar.setMinimumSize(new Dimension(100, 30));
	btnRegresar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	btnRegresar.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnRegresar.setBackground(Color.WHITE);
	GridBagConstraints gbc_btnRegresar = new GridBagConstraints();
	gbc_btnRegresar.insets = new Insets(0, 0, 0, 5);
	gbc_btnRegresar.gridx = 2;
	gbc_btnRegresar.gridy = 18;
	pnAgregarProducto.add(btnRegresar, gbc_btnRegresar);
	
	JButton btnRegistrar = new JButton("Registrar");
	btnRegistrar.setMinimumSize(new Dimension(100, 30));
	btnRegistrar.setBorder(new LineBorder(new Color(0, 0, 0)));
	btnRegistrar.setBackground(Color.WHITE);
	GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
	gbc_btnRegistrar.insets = new Insets(0, 0, 0, 5);
	gbc_btnRegistrar.gridx = 7;
	gbc_btnRegistrar.gridy = 18;
	pnAgregarProducto.add(btnRegistrar, gbc_btnRegistrar);
	*/
	btnSalir.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			if (abrir == 0){
				JOptionPane.showMessageDialog(null, "Hasta luego");
				new Login().setVisible(true);
				abrir = 1;
				new Menu().setVisible(false);
				dispose();
				abrir = 0;
			}
		}
	});
	
	mostrarTabla mostTabla = new mostrarTabla(table);
	
	}
	
	private void pdf() {
		String ruta = "C:\\Users\\Emmanuel\\QrProyecto\\";
		String valor = "hola";
		
		//Codigo para la hora actual
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		System.out.println("Report date: "+reportDate);
		try {
			FileOutputStream archivo = new FileOutputStream(ruta+"archivo.pdf");
			com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
			PdfWriter.getInstance(doc, archivo);
			doc.open();
			doc.add(new Paragraph(reportDate+"\n\n"));
			doc.close();
			JOptionPane.showMessageDialog(null, "PDF Generado correctamente");
			
		} catch (Exception e) {
			System.out.println("func pdf error:\n"+e.getMessage());
		}

	}
}