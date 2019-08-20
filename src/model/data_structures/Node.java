package model.data_structures;

import java.io.Serializable;

public class Node <T> implements Serializable, INode<T>{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Constante para la serializaci�n
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Elemento del nodo
	 */
	private T elemento;

	/**
	 * Siguiente elemento encadenado
	 */
	private Node<T> sigNode;

	/**
	 * Anterior elemento encadenado
	 */
	private Node<T> antNode;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del nodo con el elemento especificado. <br>
	 * <b>post: </b> Se construy� el nodo con el elemento especificado, sigNodo= null, antNodo= null, elemento= pElemento.
	 * @param pElemento Elemento del nodo
	 * @param pLista Lista Encadenada a la cual pertenece el nodo
	 */
	public Node( T pElemento )
	{
		elemento = pElemento;
		sigNode = null;
		antNode = null;
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Retorna el elemento que se encuentra en el nodo. <br>
	 * <b>post: </b> Se retorn� el elemento del nodo.<br>
	 * @return Elemento del nodo<br>
	 */
	public T darElemento( )
	{
		return elemento;
	}

	/**
	 * Retorna el siguiente nodo en la lista. <br>
	 * <b>post: </b> Se retorn� el siguiente nodo en la lista.<br>
	 * @return Siguiente nodo en la lista. Puede ser null<br>
	 */
	public Node<T> darSiguiente( )
	{
		return sigNode;
	}

	/**
	 * Retorna el nodo anterior en la lista. <br>
	 * <b>post: </b>Se retorn� el nodo anterior en la lista.<br>
	 * @return Nodo anterior en la lista. Puede ser null<br>
	 */
	public Node<T> darAnterior( )
	{
		return antNode;
	}

	/**
	 * Inserta el nodo despu�s del actual. <br>
	 * <b>pre: </b> nodo!=null. <br>
	 * <b>post: </b> Se insert� el nodo especificado despu�s del nodo actual.<br>
	 * @param nodo Nodo a insertar<br>
	 */
	public void agregar( Node<T> nodo )
	{
		nodo.sigNode = sigNode;
		nodo.antNode = this;
		if( sigNode != null )
		{
			sigNode.antNode = nodo;
		}
		sigNode = nodo;
	}

	/**
	 * Convierte el nodo a un String. <br>
	 * <b>post: </b> Se retorn� la representaci�n en String del nodo. Dicha representaci�n corresponde a la representaci�n en String del elemento que contiene. <br>
	 * @return La representaci�n en String del nodo<br>
	 */
	@Override
	public String toString( )
	{
		return elemento.toString( );
	}

	public Node<T> eliminar() {
		// TODO Auto-generated method stub
		Node<T> act=null;
		if(antNode==null)
		{
			act=sigNode.darAnterior();
			Node<T> p = sigNode;
			sigNode = null;
			if( p != null )
			{
				p.antNode = null;
			}
			return act;
		}
		else
		{
			act=antNode.darSiguiente();
			Node<T> ant = antNode;
			Node<T> sig = sigNode;
			antNode = null;
			sigNode = null;
			ant.sigNode = sig;
			if( sig != null )
			{
				sig.antNode = ant;
			}
			return act;
		}
	}
}
