package test.logic;

import static org.junit.Assert.*;
import model.logic.MVCModelo;
import model.logic.UBERTrip;

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
			UBERTrip v1=new UBERTrip("1", "2", "3", "4", "5", "6", "7");
			UBERTrip v2=new UBERTrip("7", "6", "5", "4", "3", "2", "1");
			UBERTrip v3=new UBERTrip("8", "9", "10", "11", "12", "13", "14");
	}

	
}
