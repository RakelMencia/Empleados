package tk.rakel.model;

/**
 * Clase que representa a un Empleado.
 */
public abstract class Empleado {
	/** Nombre del empleado. */
	protected String nombre;//Nombre del empleado
	
	/**  Apellidos del empleado. */
	protected String apellidos;//Apellidos del empleado
	
	/**  Categoria del empleado. */
	protected String categoria;//Categoria profesional del empleado
	
	/**  Tarifa del empleado. */
	protected int tarifa;//Tarifa del empleado
	
	/**  Salario del empleado. */
	protected int salario;//Salario
	
	/**
	 * Constructor de la clase.
	 *
	 * @param nombre String con el nombre del empleado
	 * @param apellidos String con los apellidos del empleado
	 * @param categoria String con la categoria del empleado
	 * @param tarifa int con la tarifa
	 * @param salario int con el salario
	 */
	//Constructor de la clase empleado
	public Empleado(String nombre, String apellidos, String categoria, int tarifa, int salario){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.categoria = categoria;
		this.tarifa = tarifa;
		this.salario = salario;
	}
	
	/**
	 * Otro constructor.
	 *
	 * @param nombre String con el nombre del empleado
	 * @param apellidos String con los apellidos del empleado
	 * @param categoria String con la categoria del empleado
	 * @param tarifa int con la tarifa
	 */
	//Otro constructor
	public Empleado(String nombre, String apellidos, String categoria, int tarifa){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.categoria = categoria;
		this.tarifa = tarifa;
	}

	/**
	 * Getter para el atributo nombre.
	 *
	 * @return String con el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Set del atributo nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Get del atributo apellidos.
	 *
	 * @return String con apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Set de apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Get con la categoria.
	 *
	 * @return String con la categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Set con la categoria.
	 *
	 * @param categoria the new categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Get con la tarifa.
	 *
	 * @return int con la tarifa
	 */
	public int getTarifa() {
		return tarifa;
	}

	/**
	 * Set de la tarifa.
	 *
	 * @param tarifa the new tarifa
	 */
	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	/**
	 * Get del salario.
	 *
	 * @return int con el salario
	 */
	public int getSalario() {
		return salario;
	}

	/**
	 * Set del salario.
	 *
	 * @param salario the new salario
	 */
	public void setSalario(int salario) {
		this.salario = salario;
	}

	/**
	 * Metodo abstracto para calcular el salario.
	 *
	 * @return int con el salario
	 */
	public abstract int calcularSalario();
}
