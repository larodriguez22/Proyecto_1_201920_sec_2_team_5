package test.data_structures;

import model.data_structures.DoubleLinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestDoubleLinkedList {

	private DoubleLinkedList<String> arreglo;
	private static int TAMANO=10;

	@Before
	public void setUp1() {
		arreglo= new DoubleLinkedList<String>();
	}

	public void setUp2() {
		for(int i =0; i< TAMANO; i++){
			arreglo.agregar("pos"+i);
		}
	}

	@Test
	public void testDoubleLinkedListVacio() {
		setUp1();
		assertTrue(arreglo!=null);
		assertEquals(0, arreglo.size());
		
	}
	
	@Test
	public void testGet()
	{
		setUp2();
		assertTrue(arreglo.size()==100);
		assertEquals("pos3", arreglo.get(4));
	}
	
	@Test
	public void testRemove()
	{
		setUp2();
		arreglo.remove(6);
		assertEquals(9, arreglo.size());
	}

	@Test
	public void testDoubleLinkedListAgregar()
	{
		setUp1();
		arreglo.agregar("Hola");
		assertEquals(1, arreglo.size());
		assertEquals("Hola", equals(arreglo.get(0)));
	}


}
