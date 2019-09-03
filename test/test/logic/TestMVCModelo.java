package test.logic;

import static org.junit.Assert.*;
import model.logic.MVCModelo;
import model.logic.Viaje;

import org.junit.Before;
import org.junit.Test;

public class TestMVCModelo {
	
	private MVCModelo modelo;
	private final static int CAPACIDAD=10;
	
	@Before
	public void setUp1() {
		modelo= new MVCModelo();
	}

	public void setUp2() {
			Viaje v1=new Viaje("1", "2", "3", "4", "5", "6", "7");
			Viaje v2=new Viaje("7", "6", "5", "4", "3", "2", "1");
			Viaje v3=new Viaje("8", "9", "10", "11", "12", "13", "14");
			modelo.agregar(v1, 1);
			modelo.agregar(v2, 0);
			modelo.agregar(v3, 1);
	}

	
}
