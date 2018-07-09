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

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.GroupLayout.Alignment;
import javax.swing.InputMap;
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
	private JTextField txtCodigoBarras;
	private JTextField txtTipoproducto;
	private JPanel pnPuntoVenta;
	private JPanel pnAgregarProducto;
	private JPanel pnBienvenida;
	private JTextField txtBuscarproducto;
	private JTextField txtTotal;
	private JTable table;
	public  Idioma idiom;
	private JTextField txtNombreproducto;
	private JTable TablevistaProductos;
	private JPanel pnConPro;
	private String Comando= "Select idRECIBIDO,p.IdPRODUCTOS,nombre_p,TipoProducto,FechaRecibido,precioVenta,precioCosto,cantidad" + 
			" FROM productoactual as pa" + 
			" INNER JOIN PRODUCTOS AS p ON p.IdPRODUCTOS = pa.IdPRODUCTOS" + 
			" WHERE borrado = 0;" + 
			"";
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
					pnConPro.setVisible(false);
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
					pnConPro.setVisible(false);
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
		btnProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if (!pnConPro.isVisible()){
						pnConPro.setVisible(true);
						pnPuntoVenta.setVisible(false);
						pnAgregarProducto.setVisible(false);
						//pnBienvenida.setVisible(false);
					}else{
						pnConPro.setVisible(false);
					}
			}
		});
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
		
		pnConPro = new JPanel();
		pnConPro.setVisible(false);
		
		
		pnPuntoVenta = new JPanel();
		pnPuntoVenta.setVisible(false);
		pnPuntoVenta.setBackground(Color.WHITE);
		pnPuntoVenta.setAutoscrolls(true);
		pnPuntoVenta.setBounds(238, 11, 746, 599);
		//---------------
		frame.getContentPane().add(pnPuntoVenta);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAutoscrolls(true);
		
		txtBuscarproducto = new JTextField();
		txtBuscarproducto.setText("BuscarProducto");
		txtBuscarproducto.setColumns(10);
		
		JButton btnBusca = new JButton(idiom.getProperty("btnBusca"));
		btnBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String searchKey = txtBuscarproducto.getText();
				String com = "Select idRECIBIDO,p.IdPRODUCTOS,nombre_p,TipoProducto,FechaRecibido,precioVenta,precioCosto,cantidad " + 
						"FROM productoactual as pa " + 
						"INNER JOIN PRODUCTOS AS p ON p.IdPRODUCTOS = pa.IdPRODUCTOS " + 
						"WHERE borrado = 0 AND nombre_p like \"%"+searchKey+"%\" OR pa.IdPRODUCTOS = \""+searchKey+"\" OR TipoProducto like \"%"+searchKey+" %\";";
				new mostrarTabla(table, com);
				float a=0;
				for (int i = 0; i < table.getModel().getRowCount(); i++) {
					System.out.println( table.getModel().getValueAt(i, 5).toString());
					 a += Float.parseFloat(table.getModel().getValueAt(i, 5).toString())* 
							 Float.parseFloat(table.getModel().getValueAt(i, 7).toString());
				}
				a+=a*0.16;
				txtTotal.setText(""+a);
				
			}
		});
		btnBusca.setMinimumSize(new Dimension(100, 30));
		btnBusca.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBusca.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("Total + IVA");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTotal = new JTextField();
		txtTotal.setText("Total");
		txtTotal.setColumns(10);
		
		JButton btnRegre = new JButton("Regresar");

		btnRegre.setMinimumSize(new Dimension(100, 30));
		btnRegre.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRegre.setBackground(Color.WHITE);
		
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
									.addComponent(btnPdf, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(516)
									.addComponent(btnRegre, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pnPuntoVenta.createSequentialGroup()
							.addGap(28)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 694, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnPuntoVenta.setVerticalGroup(
			gl_pnPuntoVenta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPuntoVenta.createSequentialGroup()
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
					.addGroup(gl_pnPuntoVenta.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPdf, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		
		table = new JTable() {
			@Override
			public boolean isCellEditable(int row,int column) {
				if(column == 0 || column == 1)
					return false;
				else
					return true;
			};
		};
		
		

		

		mostrarTabla mosTabla = new mostrarTabla(table,Comando);
		table.getModel().addTableModelListener(new TableModelListener () {
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
                System.out.println(table.getModel().getColumnName(e.getColumn()));
				
                System.out.println("last" +e.getType()+" "+e.getColumn()+" "+e.getLastRow());
                String id="idRECIBIDO='"+table.getModel().getValueAt(e.getLastRow(), 0)+"'";
                String dato = "'"+table.getModel().getValueAt(e.getLastRow(), e.getColumn())+"'";
                String columnName = table.getModel().getColumnName(e.getColumn());
                
                String tabla = "productoactual";
                if (columnName.equals("TipoProducto") || columnName.equals("IDProducto") || columnName.equals("nombre_p")) {
					tabla = "productos"; 
					id="idPRODUCTOS='"+table.getModel().getValueAt(e.getLastRow(), 1)+"'";
				}
                try {
					Conexion.update(tabla, columnName+"="+dato,id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			
			});
		int con = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap inputMap = table.getInputMap(con);
		ActionMap actionMap = table.getActionMap();
		
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getValueAt(table.getSelectedRow(), 0));
			}
		});
		scrollPane_1.setViewportView(table);

		pnPuntoVenta.setLayout(gl_pnPuntoVenta);
		pnConPro.setBackground(Color.WHITE);
		pnConPro.setBounds(236, 11, 746, 599);
		frame.getContentPane().add(pnConPro);
		pnConPro.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 44, 701, 544);
		scrollPane.setAutoscrolls(true);
		pnConPro.add(scrollPane);
		
		TablevistaProductos = new JTable() {@Override
			public boolean isCellEditable(int row,int column) {
				if(column == 0 || column == 1)
					return false;
				else	
					return true;
				};
			};
			
			
			
			
			TablevistaProductos = new JTable() {
				@Override
				public boolean isCellEditable(int row,int column) {
					if(column == 0 || column == 1)
						return false;
					else
						return true;
				};
			};
			
			

			
			
			mostrarTabla mosTableVista = new mostrarTabla(TablevistaProductos,Comando);
			TablevistaProductos.getModel().addTableModelListener(new TableModelListener () {
				@Override
				public void tableChanged(TableModelEvent e) {
					// TODO Auto-generated method stub
	                System.out.println(TablevistaProductos.getModel().getColumnName(e.getColumn()));
					
	                System.out.println("last" +e.getType()+" "+e.getColumn()+" "+e.getLastRow());
	                String id="idRECIBIDO='"+TablevistaProductos.getModel().getValueAt(e.getLastRow(), 0)+"'";
	                String dato = "'"+TablevistaProductos.getModel().getValueAt(e.getLastRow(), e.getColumn())+"'";
	                String columnName = TablevistaProductos.getModel().getColumnName(e.getColumn());
	                
	                String tabla = "productoactual";
	                if (columnName.equals("TipoProducto") || columnName.equals("IDProducto") || columnName.equals("nombre_p")) {
						tabla = "productos"; 
						id="idPRODUCTOS='"+TablevistaProductos.getModel().getValueAt(e.getLastRow(), 1)+"'";
					}
	                try {
						Conexion.update(tabla, columnName+"="+dato,id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
				});
			
			
			  InputMap inMap = TablevistaProductos.getInputMap(con);
			  ActionMap actMap = TablevistaProductos.getActionMap();

			  // DELETE is a String constant that for me was defined as "Delete"
			  inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "DELETE");
			  actMap.put("DELETE", new AbstractAction() {
			     public void actionPerformed(ActionEvent e) {
			    	 String set = "borrado = 1";
			    	 String id = ""+TablevistaProductos.getModel().getValueAt(TablevistaProductos.getSelectedRow(), 0);
			    	 try {
						Conexion.update("productoActual", set, "idRecibido ="+id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    	 new mostrarTabla(TablevistaProductos,Comando);
			     }
			  });
			  
			
			
			
			TablevistaProductos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(TablevistaProductos.getValueAt(TablevistaProductos.getSelectedRow(), 0));
				}
			});

			
			btnRegre.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					mostrarTabla as = new mostrarTabla(TablevistaProductos, Comando);
					
				}
			});
		scrollPane.setViewportView(TablevistaProductos);
		
		
		  int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;

		  // DELETE is a String constant that for me was defined as "Delete"
		  inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "DELETE");
		  actionMap.put("DELETE", new AbstractAction() {
		     public void actionPerformed(ActionEvent e) {
		    	 String set = "borrado = 1";
		    	 String id = ""+table.getModel().getValueAt(table.getSelectedRow(), 0);
		    	 try {
					Conexion.update("productoActual", set, "idRecibido ="+id);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	 new mostrarTabla(table,Comando);
		     }
		  });
		
		btnSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if (abrir == 0){
					JOptionPane.showMessageDialog(null, "Hasta luego");
					JOptionPane.showMessageDialog(null, "Hasta luego");
					new Login().frame.setVisible(true);
					abrir = 1;
					frame.dispose();
					abrir = 0;
				}
			}
		});
		
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
		
		JLabel lblCodigoBarras = new JLabel("Codigo de barras");
		GridBagConstraints gbc_lblCodigoBarras = new GridBagConstraints();
		gbc_lblCodigoBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoBarras.gridx = 3;
		gbc_lblCodigoBarras.gridy = 6;
		pnAgregarProducto.add(lblCodigoBarras, gbc_lblCodigoBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setText("\r\n");
		GridBagConstraints gbc_txtCodigoBarras = new GridBagConstraints();
		gbc_txtCodigoBarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigoBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigoBarras.gridx = 6;
		gbc_txtCodigoBarras.gridy = 6;
		pnAgregarProducto.add(txtCodigoBarras, gbc_txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		JLabel lblTipoProducto = new JLabel("Tipo Producto");
		GridBagConstraints gbc_lblTipoProducto = new GridBagConstraints();
		gbc_lblTipoProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoProducto.gridx = 3;
		gbc_lblTipoProducto.gridy = 8;
		pnAgregarProducto.add(lblTipoProducto, gbc_lblTipoProducto);
		
		txtTipoproducto = new JTextField();
		GridBagConstraints gbc_txtTipoproducto = new GridBagConstraints();
		gbc_txtTipoproducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtTipoproducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTipoproducto.gridx = 6;
		gbc_txtTipoproducto.gridy = 8;
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
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String noPro = "'"+txtNombreproducto.getText()+"'";
				String idP = "'"+txtCodigoBarras.getText()+"'";
				String tipoPro = "'"+txtTipoproducto.getText()+"'";
				try {
					Conexion.insertar("productos", "nombre_p,CodigoDeBarras,TipoProducto", noPro+","+idP+","+tipoPro);
				} catch (SQLException e1) {
					LoginNoExist al = new LoginNoExist("Llene los campos");
					al.setVisible(true);
					e1.printStackTrace();
				}
			}
		});
		btnRegistrar.setMinimumSize(new Dimension(100, 30));
		btnRegistrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnRegistrar.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrar.gridx = 7;
		gbc_btnRegistrar.gridy = 18;
		pnAgregarProducto.add(btnRegistrar, gbc_btnRegistrar);
		
		
		
		
		
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
}