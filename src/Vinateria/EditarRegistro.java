package Vinateria;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Dimension;

public class EditarRegistro {
	private JPanel pnAgregarProducto;
	private JFrame frame;
	private JTextField txtNombreproducto;
	private JTextField txtIdProducto;
	private JTextField txtPrecioventa;
	private JTextField txtPreciocosto;
	private JTextField txtTipoproducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarRegistro window = new EditarRegistro();
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
	public EditarRegistro(String [] info) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 819, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
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
		
		frame.getContentPane().add(pnAgregarProducto);
		pnAgregarProducto.setVisible(true);
	
	
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
	
	
	
	
	
	
	
	}

}
