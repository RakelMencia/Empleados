package tk.rakel.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Informatico.
 */
public class Informatico extends Empleado implements Imprimible{

	/**
	 * Instantiates a new informatico.
	 *
	 * @param nombre the nombre
	 * @param apellidos the apellidos
	 * @param categoria the categoria
	 * @param tarifa the tarifa
	 */
	public Informatico(String nombre, String apellidos, String categoria, int tarifa) {
		super(nombre, apellidos, categoria, tarifa);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see tk.rakel.model.Imprimible#mostrar()
	 */
	@Override
	public void mostrar() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellidos: " + this.apellidos);
		System.out.println("Categoria: " + this.categoria);
		System.out.println("Tarifa: " + this.tarifa);
		System.out.println("Salario: " + this.salario);		
	}

	/* (non-Javadoc)
	 * @see tk.rakel.model.Empleado#calcularSalario()
	 */
	@Override
	public int calcularSalario() {
		// TODO Auto-generated method stub
		return 0;
	}

}
