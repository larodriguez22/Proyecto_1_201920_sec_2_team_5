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
	/**
     * Cabeza de la lista encadenada
     */
    private Node<T> primero;

    /**
     * �ltimo elemento de la lista encadenada
     */
    private Node<T> ultimo;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamano;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		primero = null;
		ultimo = null;
		tamano = 0;
	}

	public void agregar( T o )
	{
		Node<T> act= new Node<T>(o);
		if( primero == null )
        {
            primero = act;
            ultimo = act;
        }
        else
        {
            ultimo.agregar(act);;
            ultimo = act;
        }
        tamano++;
	}

	public int darTamano() 
	{
		return tamano;
	}

	public T buscar(T dato) {
		
		for( Node<T> p = primero; p != null; p = p.darSiguiente( ) )
        {
            if( p.darElemento( ).compareTo(dato)==0 )
            {
                return p.darElemento( );
            }
        }
        return null;
	}

	public Node<T> eliminar(Node<T> dato) throws NoExisteException 
	{
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		if(  dato.eliminar()== null )
        {
            throw new NoExisteException( "El nodo especificado no pertenece a la lista" );
        }
		return dato.eliminar();
        
	}
}

