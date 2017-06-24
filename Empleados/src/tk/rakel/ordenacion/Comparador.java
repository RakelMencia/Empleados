package tk.rakel.ordenacion;

import java.util.Comparator;

import tk.rakel.model.Informatico;

/**
 * Clase comparador para comparar los elementos de un array y ordenarlos primero por apellido y luego por nombre
 */
public class Comparador implements Comparator<Informatico>{
	
	/** Cte R1 que representa un retorno del metodo >0. */
	private static final int R1 = 10;//En el caso de que el retorno sea >0
	
	/** Cte R2 que representa un retorno del metodo <0. */
	private static final int R2 = -10;//En el caso de que el retorno sea <0
	
	/** Cte R0 que representa un retorno del metodo =0. */
	private static final int R0 = 0;//En el caso de que sean iguales.
	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Informatico inf1, Informatico inf2) {
		int retorno=0;//Variable para almacenar el retorno del metodo
		if (inf1.getApellidos().compareTo(inf2.getApellidos())>0){
			retorno=R1;
		} else if (inf1.getApellidos().compareTo(inf2.getApellidos())<0){
			retorno=R2;
		} else {
			//En el caso de que los apellidos coincidan, los ordena por nombre
			if (inf1.getNombre().compareTo(inf2.getNombre())>0){
				retorno=R1;
			} else if (inf1.getNombre().compareTo(inf2.getNombre())<0){
				retorno=R2;
			} else {
				retorno = R0;
			}
		}		
		return retorno;
	}

}
