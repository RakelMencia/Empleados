package tk.rakel.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import tk.rakel.model.Informatico;


/**
 * Clase GestorFichero con los metodos para trabajar con el fichero de los datos de los empleados
 */
public class GestorFichero {
	
	/**
	 * Metodo para leer el fichero.
	 *
	 * @return ArrayList con los datos leidos del fichero
	 * @throws IOException cuando ocurre un error al leer este fichero
	 */
	//Metodo para cargar los datos del fichero "empleados.dat"
		public ArrayList <Informatico>leerFichero() throws IOException{
			ArrayList <Informatico> informaticos = new ArrayList<Informatico>();//Devolvemos el arrayList con los datos leidos
			String nombre=null;//Para almacenar el nombre del informático
			String apellidos=null;//Para almacenar los apellidos
			String tarifaLeida = null;//Para leer la tarifa 
			String categoria=null;//Para almacenar la categoria
			int tarifaNum=0;//Pasamos del String al int la tarifa
			Informatico inf = null;//Declaramos un objeto del tipo Informatico
			FileReader fr = null;
			try {
				fr = new FileReader("empleados.dat");// Abrimos para leer el fichero
			} catch (IOException ex) {
				System.out.println("Error al leer el fichero");
			}
			BufferedReader br = new BufferedReader(fr);// Envolvemos el fr
			//Leemos hasta fin de fichero
			while ((nombre = br.readLine()) != null) {
	            try {
	            	//Vamos a comparar lo que lea con la palabra "error". Si es esa palabra, devolverá true y
	            	//entrará por el if, en cuyo caso, pasará a la línea siguiente
	                if (nombre.equalsIgnoreCase("error")) {
	                    nombre = br.readLine();
	                }
	                apellidos = br.readLine();
	                tarifaLeida = br.readLine();
	                categoria = br.readLine();
	                tarifaNum = Integer.parseInt(tarifaLeida);//Convertimos el String leido en un int
	                inf = new Informatico(nombre, apellidos, categoria, tarifaNum);
	                informaticos.add(inf);
	            } catch (NumberFormatException e) {
	            	System.out.println("Error al cargar datos del informático " + nombre);
	            }
	        }
			fr.close();
			br.close();
			return informaticos;
		}
		
		/**
		 * Metodo para calcular el salario.
		 *
		 * @param ali ArrayList con los objetos de tipo Informatico
		 */
		public void calcularSalario(ArrayList<Informatico> ali){			
			int salario =0;//Inicializamos el salario a 0
			Properties p = new Properties();//Para tratar el fichero de properties
			int director=0;//Para almacenar el valor relativo a la categoria DIRECTOR
			int responsable=0;//Para almacenar el valor relativo a la categoria RESPONSABLE
			int programador=0;//Para almacenar el valor relativo a la categoria PROGRAMADOR
			for (Informatico inf : ali) {
				//Leemos el fichero de properties
				InputStream inputStream=null;
				String archivo = "util/salario.properties";//Leemos el archivo
				inputStream = getClass().getClassLoader().getResourceAsStream(archivo);
				try {
					p.load(inputStream);
				} catch (IOException e) {
					System.out.println("Error al cargar fichero");
				}
				//Recogemos los datos del archivo y los vamos almacenando en variables
				director = Integer.parseInt(p.getProperty("DIRECTOR"));
				responsable = Integer.parseInt(p.getProperty("RESPONSABLE"));
				programador = Integer.parseInt(p.getProperty("PROGRAMADOR"));
				//Comparamos para calcular el salario que le corresponde a cada uno
				if (inf.getCategoria().equals("DIRECTOR")){
					salario = inf.getTarifa()*director;
					//System.out.println(salario);
				} else if (inf.getCategoria().equals("PROGRAMADOR")){
					salario = inf.getTarifa()*programador;
				} else if (inf.getCategoria().equals("RESPONSABLE")){
					salario = inf.getTarifa()*responsable;
				}
				inf.setSalario(salario);
				//System.out.println(inf.getSalario());
			}			
		}
}
