package test.data_structures;

import model.data_structures.ListaEncadenada;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestListaEncadenada {

	private ListaEncadenada<String> arreglo;
	private static int TAMANO=10;

	@Before
	public void setUp1() {
		arreglo= new ListaEncadenada<String>();
	}

	public void setUp2() {
		for(int i =0; i< TAMANO; i++){
			arreglo.insertar("pos"+i, i);
		}
	}

	@Test
	public void testDoubleLinkedListVacio() {
		setUp1();
		assertTrue(arreglo!=null);
		assertEquals(0, arreglo.darLongitud());
		
	}
	
	@Test
	public void testGet()
	{
		setUp2();
		assertTrue(arreglo.darLongitud()==100);
		assertEquals("pos3", arreglo.dar(4));
	}
	
	@Test
	public void testRemove()
	{
		setUp2();
		arreglo.eliminar(6);
		assertEquals(9, arreglo.darLongitud());
	}


}
