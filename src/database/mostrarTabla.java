package database;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JTable;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Vinateria.LoginNoExist;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

public class mostrarTabla {
	
	public mostrarTabla(JTable table,String Comando) {
		DefaultTableModel modelo = new DefaultTableModel();
 		modelo.setColumnIdentifiers(new Object[]{"IDRECIBIDO","IDProducto","nombre_p","TipoProducto","FechaRecibido","precioVenta","precioCosto","cantidad"});
		ResultSet rs = Conexion.getTabla(Comando);
		try {
			while(rs.next()) {
				modelo.addRow(new Object[] 
						{
								rs.getString("idRECIBIDO"),
								rs.getString("p.IdPRODUCTOS"),
								rs.getString("nombre_p"),
								rs.getString("TipoProducto"),
								rs.getString("FechaRecibido"),
								rs.getFloat("precioVenta"),
								rs.getFloat("precioCosto"),
								rs.getInt("cantidad")
						}
				);
			}
			table.setModel(modelo);
		} catch (Exception e) {
			System.out.println(e);
		}
	}


    
    public static void pdftabla(TableModel tableModel){
    	
        Document document = new Document();
        String ruta = "C:\\Users\\Emmanuel\\QrProyecto\\";
        try{
            PdfWriter.getInstance(document, new FileOutputStream(ruta+"tablas.pdf"));
            document.open();
            
            PdfPTable table = new PdfPTable(tableModel.getColumnCount());                
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
				for (int j = 0; j < tableModel.getColumnCount(); j++) {
					table.addCell(""+tableModel.getValueAt(i, j));
				}
            }
            
            Calendar cal = Calendar.getInstance();
            Date fecha = new Date( cal.getTimeInMillis() );
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            Image img = Image.getInstance("src\\Vinateria\\Res\\qr0.png");
            img.scalePercent(5);
            
            document.add(new Header("Vinateria Rocio", "Reporte de podructos disponibles en "+formato.format(fecha)));
            document.add(img);
            document.add(table);
            document.close();
            System.out.println("generado con exito");
            File pdfFile = new File(ruta+"tablas.pdf");
            Desktop.getDesktop().open(pdfFile);
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }
    
    
    
    
    public static void pdf(TableModel tableModel){
        Error e = new Error();
        String ruta = "C:\\Users\\Emmanuel\\QrProyecto\\";
        String ruta2="C:\\Users\\Emmanuel\\QrProyecto\\tablas.pdf";
        String valor="bss";
        /*Codigo hora actual*/
        DateFormat df=new SimpleDateFormat("MM/dd/yyyy:HH:mm:ss");
        //String reportDate = df.format(today);
        //System.out.println("Report Date: "+reportDate);
        try{
            FileOutputStream archivo = new FileOutputStream(ruta+"tablas.pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc,archivo);
            doc.open();
            Paragraph pe = new Paragraph("Registros Vinateria");
            pe.setAlignment(1);
            doc.add(pe);
            Paragraph ti = new Paragraph("Articulos en Stock");
            ti.setAlignment(1);
            doc.add(ti);
            String LOGO= "src\\Vinateria\\Res\\Logo.png";
            String SHOP="src\\Vinateria\\Res\\warning.png";  
            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
            Paragraph a = new Paragraph ("Fecha creación: "+date.format(now)+"Hora:"+hour.format(now));
            Image logo= Image.getInstance(LOGO);
            logo.setAbsolutePosition(510f, 740f);
            logo.scaleAbsoluteWidth(90.0f);
            logo.scaleAbsoluteHeight(80.0f);
            doc.add(logo);
            qr miqr = new qr("Hecho por Emmanuel Labra y Luis Angel Hernandez");
            Image ejqr= Image.getInstance("src\\Vinateria\\Res\\qr0.png");
            ejqr.setAbsolutePosition(490f, 20f);
            ejqr.scaleAbsoluteWidth(90.0f);
            ejqr.scaleAbsoluteHeight(80.0f);
            doc.add(ejqr);
            Image shop= Image.getInstance(SHOP);
            shop.setAbsolutePosition(10f, 740f);
            shop.scaleAbsoluteWidth(90.0f);
            shop.scaleAbsoluteHeight(80.0f);
            doc.add(shop);
            Paragraph espacios = new Paragraph("\n\n\n\n\n\n");
            doc.add(espacios);
            
       
            
            PdfPTable table = new PdfPTable(tableModel.getColumnCount());                
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
				for (int j = 0; j < tableModel.getColumnCount(); j++) {
					table.addCell(""+tableModel.getValueAt(i, j));
				}
            }
            table.setHeaderRows(1);
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                for (int column = 0; column < tableModel.getColumnCount(); column++) {
                    table.addCell(tableModel.getValueAt(row, column).toString());
                    
                }
            }
           doc.add(table);
            doc.add(espacios);
            doc.add(a);
            doc.close();
            LoginNoExist al = new LoginNoExist("Se genero con exito");
            Desktop d= Desktop.getDesktop();
            d.open(new File(ruta2));
        }catch(Exception ex){
            ex.printStackTrace();
            LoginNoExist al = new LoginNoExist("Error al generar el qr");
        }
    }
    
    public static void mostrarTablaColum(JTable table,String Comando) {
    	DefaultTableModel modelo = new DefaultTableModel();
 		modelo.setColumnIdentifiers(new Object[]{"IdPRODUCTOS","nombre_p","CodigoDeBarras","TipoProducto","stock"});
		ResultSet rs = Conexion.getTabla(Comando);
		try {
			while(rs.next()) {
				modelo.addRow(new Object[] 
						{
								rs.getInt("IdPRODUCTOS"),
								rs.getString("nombre_p"),
								rs.getString("CodigoDeBarras"),
								rs.getString("TipoProducto"),
								rs.getString("stock")
						}
				);
			}
			table.setModel(modelo);
		} catch (Exception e) {
			System.err.println(e);
		}
	}


}
