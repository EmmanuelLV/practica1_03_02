package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Convierte un ResultSet en un DefaultTableModel
 * @author Chuidiang
 *
 */
public class ConversorResultSetADefaultTableModel
{
	/**
	 * Rellena el DefaultTableModel con los datos del ResultSet.
	 * Vacía el DefaultTableModel completamente y le mete los datos que hay
	 * en el ResultSet.
	 * @param rs El resultado de lac onsula a base de datos.
	 * @param modelo El DefaultTableModel que queremos rellenar
	 */
	public static void rellena(ResultSet rs, DefaultTableModel modelo)
	{
		configuraColumnas(rs, modelo);
		vaciaFilasModelo(modelo);
		anhadeFilasDeDatos(rs, modelo);
	}

	/**
	 * Añade al DefaultTableModel las filas correspondientes al ResultSet.
	 * @param rs El resultado de la consulta a base de datos
	 * @param modelo El DefaultTableModel que queremos rellenar.
	 */
	public static void anhadeFilasDeDatos(ResultSet rs,
			DefaultTableModel modelo)
	{
		int numeroFila = 0;
		try
		{
			// Para cada registro de resultado en la consulta 
			while (rs.next())
			{
				// Se crea y rellena la fila para el modelo de la tabla.
				Object[] datosFila = new Object[modelo.getColumnCount()];
				for (int i = 0; i < modelo.getColumnCount(); i++)
					datosFila[i] = rs.getObject(i + 1);
				modelo.addRow(datosFila);
				numeroFila++;
			}
			rs.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Borra todas las filas del modelo.
	 * @param modelo El modelo para la tabla.
	 */
	public static void vaciaFilasModelo(final DefaultTableModel modelo)
	{
		while (modelo.getRowCount() > 0)
			modelo.removeRow(0);
	}

	public static void configuraColumnas(final ResultSet rs,
			final DefaultTableModel modelo)
	{
		try{
			ResultSetMetaData metaDatos = rs.getMetaData();
			int numeroColumnas = metaDatos.getColumnCount();

			Object[] etiquetas = new Object[numeroColumnas];
			for (int i = 0; i < numeroColumnas; i++)
			{
				etiquetas[i] = metaDatos.getColumnLabel(i + 1);
			}
			modelo.setColumnIdentifiers(etiquetas);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
