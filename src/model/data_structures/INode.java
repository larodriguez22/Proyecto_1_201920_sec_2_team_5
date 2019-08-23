	package model.data_structures;



public interface INode<T> {

	 /**
     * Retorna el nodo anterior
     * @return El nodo anterior
     */
    public INode<T> darAnterior( );

    /**
     * Retorna el nodo siguiente
     * @return El nodo siguiente
     */
    public INode<T> darSiguiente( );

    /**
     * Retorna el elemento del nodo
     * @return El elemento del nodo
     */
    public T darElemento( );

}
