package Vinateria;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import database.Conexion;
import database.mostrarTabla;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

	private JFrame frame;
	public int abrir = 0;
	private JTextField txtNombreproducto;
	private JTextField txtIdProducto;
	private JTextField txtPrecioventa;
	private JTextField txtPreciocosto;
	private JTextField txtTipoproducto;
	private JPanel pnPuntoVenta;
	private JPanel pnAgregarProducto;
	private JPanel pnBienvenida;
	private JTextField txtBuscarproducto;
	private JTextField txtTotal;
	private JTable table;
	public  Idioma idiom;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					idiom = new Idioma("Español");
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public Main(Idioma idiom) {
		initialize(idiom);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize(Idioma idiom) {
		frame = new JFrame();
		frame.setTitle("Menú");
		frame.setVisible(true);
		frame.setSize(1000,650);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println(idiom.getIdiomaActual());
		
		JButton btnAProducto = new JButton();
		btnAProducto.setText("Agregar producto");
		frame.getContentPane().add(btnAProducto);
		btnAProducto.setBounds(10, 11, 230, 100);
		btnAProducto.setToolTipText("Click aquí para agregar");
		btnAProducto.setForeground(Color.WHITE);
		btnAProducto.setBackground(new Color(32, 178, 170));
		btnAProducto.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		btnAProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!pnAgregarProducto.isVisible()){
					pnAgregarProducto.setVisible(true);
					pnPuntoVenta.setVisible(false);
					//pnBienvenida.setVisible(false);
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
					pnPuntoVenta.setVisible(true);
					pnAgregarProducto.setVisible(false);
					//pnBienvenida.setVisible(false);
				}else{
					pnPuntoVenta.setVisible(false);
				}
			}
		});
		btnPVenta.setText("Punto de venta");
		frame.getContentPane().add(btnPVenta);
		btnPVenta.setBounds(10, 130, 230, 100);
		btnPVenta.setToolTipText("Punto de venta");
		btnPVenta.setForeground(Color.WHITE);
		btnPVenta.setBackground(new Color(32, 178, 170));
		btnPVenta.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		
		JButton btnSalir = new JButton();
		btnSalir.setText("Salir");
		frame.getContentPane().add(btnSalir);
		btnSalir.setBounds(10, 510, 230, 100);
		btnSalir.setToolTipText("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(32, 178, 170));
		btnSalir.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		
		JButton btnProductos = new JButton();
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProductos.setToolTipText("Punto de venta");
		btnProductos.setText("Consultar productos");
		btnProductos.setForeground(Color.WHITE);
		btnProductos.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		btnProductos.setBackground(new Color(32, 178, 170));
		btnProductos.setBounds(10, 251, 230, 100);
		frame.getContentPane().add(btnProductos);
		
		
		pnPuntoVenta = new JPanel();
		pnPuntoVenta.setBackground(Color.WHITE);
		pnPuntoVenta.setAutoscrolls(true);
		pnPuntoVenta.setBounds(238, 11, 746, 599);
		pnPuntoVenta.setVisible(false);
		//---------------
		frame.getContentPane().add(pnPuntoVenta);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAutoscrolls(true);
		
		txtBuscarproducto = new JTextField();
		txtBuscarproducto.setText("BuscarProducto");
		txtBuscarproducto.setColumns(10);
		
		JButton btnBusca = new JButton(idiom.getProperty("btnBusca"));
		btnBusca.setMinimumSize(new Dimension(100, 30));
		btnBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBusca.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("Total + IVA");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTotal = new JTextField();
		txtTotal.setText("Total");
		txtTotal.setColumns(10);
		
		JButton button_1 = new JButton("Regresar");
		button_1.setMinimumSize(new Dimension(100, 30));
		button_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_1.setBackground(Color.WHITE);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mostrarTabla.pdftabla(table.getModel());
			}
		});
		btnPdf.setMinimumSize(new Dimension(100, 30));
		btnPdf.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnPdf.setBackground(Color.WHITE);
		
		JButton btnRegresarr = new JButton("Regresar");
		btnRegresarr.setMinimumSize(new Dimension(100, 30));
		btnRegresarr.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRegresarr.setBackground(Color.WHITE);
		GroupLayout gl_pnPuntoVenta = new GroupLayout(pnPuntoVenta);
		gl_pnPuntoVenta.setHorizontalGroup(
			gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPuntoVenta.createSequentialGroup()
					.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnPuntoVenta.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnPuntoVenta.createSequentialGroup()
									.addGap(29)
									.addComponent(txtBuscarproducto, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnBusca, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(53)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnPuntoVenta.createSequentialGroup()
									.addComponent(btnRegresarr, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(212)
									.addComponent(btnPdf, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(214)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pnPuntoVenta.createSequentialGroup()
							.addGap(28)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(753, Short.MAX_VALUE))
		);
		gl_pnPuntoVenta.setVerticalGroup(
			gl_pnPuntoVenta.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnPuntoVenta.createSequentialGroup()
					.addGap(29)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnPuntoVenta.createSequentialGroup()
							.addGap(2)
							.addComponent(txtBuscarproducto, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBusca, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnPuntoVenta.createSequentialGroup()
							.addGap(3)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnPuntoVenta.createSequentialGroup()
							.addGap(2)
							.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(80)
					.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegresarr, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPdf, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(362, Short.MAX_VALUE))
		);
		
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row,int column) {
				if(column == 0)
					return false;
				else
					return true;
			};
		};
		mostrarTabla mosTabla = new mostrarTabla(table);
		table.getModel().addTableModelListener(new TableModelListener () {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
                System.out.println(table.getModel().getColumnName(e.getColumn()));
				
                System.out.println("last" +e.getType()+" "+e.getColumn()+" "+e.getLastRow());
                String id="'"+table.getModel().getValueAt(e.getLastRow(), 0)+"'";
                String dato = "'"+table.getModel().getValueAt(e.getLastRow(), e.getColumn())+"'";
                String columnName = table.getModel().getColumnName(e.getColumn());
                try {
					Conexion.update("aeropuerto", columnName+"="+dato,"idAEROPUERTO="+id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			} 
			});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getValueAt(table.getSelectedRow(), 0));
			}
		});
		scrollPane_1.setViewportView(table);
		pnPuntoVenta.setLayout(gl_pnPuntoVenta);
		
		pnAgregarProducto = new JPanel();
		pnAgregarProducto.setVisible(false);
		pnAgregarProducto.setBackground(Color.WHITE);
		pnAgregarProducto.setBounds(238, 11, 746, 599);
		//-------------------
		frame.getContentPane().add(pnAgregarProducto);
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
		
		btnSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if (abrir == 0){
					JOptionPane.showMessageDialog(null, "Hasta luego");
					JOptionPane.showMessageDialog(null, "Hasta luego");
					new Login().frame.setVisible(true);
					abrir = 1;
					new Menu().setVisible(false);
					frame.dispose();
					abrir = 0;
				}
			}
		});
		
		
		
		
		
		pnBienvenida = new JPanel();
		pnBienvenida.setBorder(new LineBorder(new Color(255, 255, 255), 4));
		pnBienvenida.setBackground(new Color(255, 255, 255));
		pnBienvenida.setBounds(236, 11, 746, 599);
		frame.getContentPane().add(pnBienvenida);
		pnBienvenida.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido",SwingConstants.CENTER);
		lblBienvenido.setBounds(10, 89, 726, 100);
		pnBienvenida.add(lblBienvenido);
		lblBienvenido.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 99));
		
		JLabel lblVinateriaRoci = new JLabel("Vinateria Rocio",SwingConstants.CENTER);
		lblVinateriaRoci.setBounds(10, 184, 726, 66);
		pnBienvenida.add(lblVinateriaRoci);
		lblVinateriaRoci.setFont(new Font("Gabriola", Font.PLAIN, 60));
		
		JLabel lblElijaUnaOpcion = new JLabel("Elija una opcion de la izquierda para comenzar ",SwingConstants.CENTER);
		lblElijaUnaOpcion.setBounds(10, 521, 726, 22);
		pnBienvenida.add(lblElijaUnaOpcion);
		lblElijaUnaOpcion.setVerticalTextPosition(SwingConstants.TOP);

		
	}

	public Idioma getIdiom() {
		return idiom;
	}

	public void setIdiom(String idiom) {
		this.idiom = new Idioma(idiom);
	}
	
		
	
		
		 /*
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
	*/
}