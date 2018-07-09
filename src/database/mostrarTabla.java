package database;

import java.sql.ResultSet;
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

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

public class mostrarTabla {
	public mostrarTabla(JTable table,String Comando) {
		DefaultTableModel modelo = new DefaultTableModel();
		ResultSet rs = Conexion.getTabla(Comando);
		modelo.setColumnIdentifiers(new Object[]{"IDRECIBIDO","IDProducto","nombre_p","TipoProducto","FechaRecibido","precioVenta","precioCosto","cantidad"});
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
}
