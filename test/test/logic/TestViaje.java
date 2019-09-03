package test.logic;

import junit.framework.TestCase;
import model.logic.Viaje;

public class TestViaje extends TestCase
{
	 // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private Viaje viaje1;

    private Viaje viaje2;

    private Viaje viaje3;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye tres fichas con valores diferentes
     */
    private void setupEscenario1( )
    {
    	viaje1=new Viaje("1", "2", "3", "4", "5", "6", "7");
		viaje2=new Viaje("7", "6", "5", "4", "3", "2", "1");
		viaje3=new Viaje("8", "9", "10", "11", "12", "13", "14");
    }
    
    private void setupEscenario2()
    {
    	viaje1=null;
    	viaje2=null;
    	viaje3=null;
    }
}
