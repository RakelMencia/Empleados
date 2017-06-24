package tk.rakel.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import tk.rakel.model.Informatico;

/**
 * Clase GestorBBDD con los metodos necesarios para trabajar con la bbdd
 */
public class GestorBBDD {
	
	/**   String que representa el nombre de la bbdd. */
	protected String nombreBBDD;//Nombre de la bbdd a la que nos queremos conectar
	
	/**   String que representa el nombre de la bbdd. */
	protected String usuario;//Usuario de la bbdd
	
	/**   String que representa el nombre de la bbdd. */
	protected String password;//Contraseña de la bbdd
	
	/**   String que representa el nombre de la bbdd. */
	protected String ip;//Ip de  la bbdd
	
	/**   String que representa el nombre de la bbdd. */
	protected String puerto;//Puerto donde nos conectamos a la bbdd
	
	/**   ArrayList que almacena todos los datos necesarios para establecer la conexión como el nombre de la bbdd, usuario, password, ip y puerto. */
	protected ArrayList<String> datosConexion; // Almacena los datos necesarios para establecer la conexión,
											//leidos del fichero recursos
	
	/**   Conexión a la bbdd. */
	protected Connection conexion;
	
	/**
	 * Constructor de la clase.
	 *
	 * @param nombreBBDD String con el nombre de la bbdd
	 * @param usuario String usuario the usuario
	 * @param password String con la contraseña de la bbdd
	 * @param ip String con la ip de la bbdd
	 * @param puerto String con el puerto de la bbdd
	 */
	public GestorBBDD(String nombreBBDD, String usuario, String password, String ip, String puerto) {
		this.nombreBBDD = nombreBBDD;
		this.usuario = usuario;
		this.password = password;
		this.ip = ip;
		this.puerto = puerto;
	}
	
	/**
	 * Constructor vacio de la clase
	 */
	//Constructor vacio
	public GestorBBDD(){
		
	}

	/**
	 * Metodo para establecer la conexion con la bbdd
	 *
	 * @throws ClassNotFoundException cuando no encuentra la ruta al Driver
	 * @throws SQLException cuando no se puede conectar con la bbdd
	 */
	// Metodo para establecer conexion
	public void establecerConexion() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		// Instanciacion dinamica
		Class.forName(driver);
		String servidor_bbdd = "jdbc:mysql://" + ip + "/" + nombreBBDD;
		// Guardamos la conexion en la variable que hemos declarado antes
		conexion = DriverManager.getConnection(servidor_bbdd, usuario, password);
	}
	
	/**
	 * Metodo para cerrar la conexion a la bbdd
	 *
	 * @throws SQLException cuando no se puede cerrar la conexion con la bbdd
	 */
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}
	
	/**
	 * Metodo para recoger los datos de conexion de la bbdd del archivo de conexión.
	 *
	 * @return datosConexion ArrayList con los datos recogidos del archivo
	 * @throws FileNotFoundException si no encuentra el archivo con los datos de la conexión
	 * @throws IOException si no se ha podido cargar el driver jdbc
	 */
	public ArrayList<String> getCredenciales() throws FileNotFoundException, IOException {
		datosConexion = new ArrayList<String>();
		Properties credenciales = new Properties();
		FileInputStream fis = new FileInputStream("datosConexion.properties");
		credenciales.load(fis);
		datosConexion.add(credenciales.getProperty("nombre"));
		datosConexion.add(credenciales.getProperty("usuario"));
		datosConexion.add(credenciales.getProperty("password"));
		datosConexion.add(credenciales.getProperty("ip"));
		datosConexion.add(credenciales.getProperty("puerto"));
		fis.close();
		return datosConexion;
	}
	
	/**
	 * Metodo para insertar los registros en la bbdd.
	 *
	 * @param informaticos ArrayList con los datos a meter en la bbdd
	 * @throws SQLException cuando no se puede conectar con la bbdd
	 */
	//Metodo para hacer los INSERT en la bbdd
	public void insertar(ArrayList<Informatico> informaticos) throws SQLException{
		for (Informatico inf : informaticos) {
			String sentencia = "INSERT INTO informatico (NOMBRE, APELLIDOS, CATEGORIA, SALARIO) VALUES ('" + inf.getNombre() + "', '" + inf.getApellidos() + "', '"
					+ inf.getCategoria() + "', " + inf.getSalario() + ")";
			Statement st = conexion.createStatement();
			st.executeUpdate(sentencia);
			st.close();
		}
	}
}
