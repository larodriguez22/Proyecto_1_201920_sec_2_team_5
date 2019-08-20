package model.data_structures;

public interface IArregloDinamico <T>{

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return
	 */
	int darTamano( );

	/**
	 * Agregar un dato de forma compacta (en la primera casilla disponible) 
	 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
	 * @param dato nuevo elemento
	 */
	public void agregar( T dato );
		
	/**
	 * Buscar un dato en el arreglo.
	 * @param dato Objeto de busqueda en el arreglo
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 */
	T buscar(T dato);
	
	/**
	 * Eliminar un dato del arreglo.
	 * Los datos restantes deben quedar "compactos" desde la posicion 0.
	 * @param dato Objeto de eliminacion en el arreglo
	 * @return dato eliminado
	 */
	Node<T> eliminar( Node<T> dato )throws Exception;
	

}
