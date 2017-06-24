package tk.rakle.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tk.rakel.model.Informatico;
import tk.rakel.persistencia.GestorBBDD;
import tk.rakel.persistencia.GestorFichero;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

// TODO: Auto-generated Javadoc
/**
 * Clase Panel que es el JPanel
 */
public class Panel extends JFrame {
	
	/**
	 * Constantes para almacenar las posiciones del ArrayList y recorrerlo.
	 */
	private static final int POS_0 = 0;// La posición del ArrayList correspondiente al primer elemento	
	
	/** The Constant POS_1. */
	private static final int POS_1 = 1;// La posición del ArrayList correspondiente al segundo elemento
	
	/** The Constant POS_2. */
	private static final int POS_2 = 2;// La posición del ArrayList correspondiente al tercer elemento
	
	/** The Constant POS_3. */
	private static final int POS_3 = 3;// La posición del ArrayList correspondiente al cuarto elemento
	
	/** The Constant POS_4. */
	private static final int POS_4 = 4;// La posición del ArrayList correspondiente al quinto elemento
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The tabla. */
	private JTable tabla;

	/**
	 * Metodo por el que empieza a ejecutarse nuestra aplicación
	 *
	 * @param En este caso no recibe ningún parámetro
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 30, 387, 154);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		//Para rellenar el array con los datos, eliminar los erróneos e insertarlos en la bbdd
		GestorFichero gf = new GestorFichero();
		GestorBBDD gb = new GestorBBDD();
		ArrayList<String>datosConexion = new ArrayList<String>();
		ArrayList <Informatico> informaticos = new ArrayList<Informatico>();
		try {
			informaticos = gf.leerFichero();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo \"empleados.dat\"");
		}
		/*
		for (Informatico informatico : informaticos) {
			informatico.mostrar();
		}*/
		gf.calcularSalario(informaticos);
		try {
			datosConexion=gb.getCredenciales();
		} catch (FileNotFoundException e) {			
			System.out.println("Error, el archivo no se encuentra.");
		} catch (IOException e) {			
			System.out.println("Error al leer el archivo de credenciales.");
		}
		//Variables para almacenar los datos recogidos del archivo de properties
		String nombreBBDD = datosConexion.get(POS_0);
		String usuario = datosConexion.get(POS_1);
		String password = datosConexion.get(POS_2);
		String ip = datosConexion.get(POS_3);
		String puerto = datosConexion.get(POS_4);
		GestorBBDD gbd = new GestorBBDD(nombreBBDD, usuario, password, ip, puerto);
		try {
			gbd.establecerConexion();
			gbd.insertar(informaticos);
			gbd.cerrarConexion();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al conectarse.");
		} catch (SQLException e) {
			System.out.println("Error de la BBDD." + e.getErrorCode());
		}		
		tabla.setModel(new Tabla(informaticos));
	}
}
