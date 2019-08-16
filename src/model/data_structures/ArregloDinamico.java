package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de objetos genericos.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T> 
{
	private T value;
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( T o )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[] copia = elementos;
			elementos = (T[])new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = o;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public String darElemento(int pos) {
		// TODO implementar
		return elementos[pos].toString();
	}

	public String buscar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		String rta=null;
		for(int i=0; i<tamanoAct;i++)
		{
			if(elementos[i].compareTo(dato)==0)
			{
				rta=elementos[i].toString();
			}
		}
		return rta;
	}

	public String eliminar(T dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		String rta=null;
		if(buscar(dato)!=null)
		{
			rta=buscar(dato);
		}
		return rta;
	}


}
