package tk.rakle.gui;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import tk.rakel.model.Informatico;

/**
 * Clase Tabla que será nuestro TableModel con los datos específicos para dibujar nuestra tabla
 */
public class Tabla implements TableModel {
	
	/** ArrayList con los datos a imprimir en la tabla */
	//ArrayList con los datos a mostrar
	private ArrayList <Informatico> informaticos;
	
	/**
	 * Constructor de la clase
	 *
	 * @param ArrayList de informaticos con los datos a mostrar en la tabla
	 */
	//Constructor de la clase
	public Tabla (ArrayList<Informatico> informaticos){
		this.informaticos=informaticos;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#addTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class cl = null;//Variable para almacenar el tipo de retorno
		// Tipos de datos que hay en cada columna
		if (columnIndex==0){
			cl = String.class;
		} else if (columnIndex==1){
			cl = String.class;
		} else if (columnIndex==2){
			cl= String.class;
		} else {
			cl = Integer.class;
		}
		return cl;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		// Nombre de la columna
		if (columnIndex==0){
			return "NOMBRE";
		} else if (columnIndex==1){
			return "APELLIDO";
		} else if (columnIndex==2){
			return "CATEGORIA";
		} else {
			return "SALARIO";
		}		
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		//El total de filas nos lo va a dar el tamaño del array
		return informaticos.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String resultado = null;
		// Qué hay que poner en cada celda
		switch(columnIndex){
		case 0:
			resultado = informaticos.get(rowIndex).getNombre();
			break;
		case 1:
			resultado = informaticos.get(rowIndex).getApellidos();
			break;
		case 2:
			resultado = informaticos.get(rowIndex).getCategoria();
		default:
			resultado = String.valueOf(informaticos.get(rowIndex).getSalario());
			break;
		}
		return resultado;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#removeTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
