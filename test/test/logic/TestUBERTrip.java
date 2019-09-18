package test.logic;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.logic.UBERTrip;

public class TestUBERTrip extends TestCase
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	private UBERTrip viaje1;

	private UBERTrip viaje2;

	private UBERTrip viaje3;

	private UBERTrip viaje4;

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Construye tres fichas con valores diferentes
	 */
	@Before
	private void setupEscenario1( )
	{
		viaje1=new UBERTrip("1", "2", "3", "4", "5", "6", "7");
		viaje2=new UBERTrip("7", "6", "5", "4", "3", "2", "1");
		viaje3=new UBERTrip("14", "15", "16", "17", "18", "19", "20");
		viaje4=new UBERTrip("7", "6", "5", "8", "3", "2", "1");
	}

	@Test
	public void TestGet()
	{
		assertEquals(1, viaje1.getSourceid());
		assertEquals(2, viaje1.getDstid());
		assertEquals(3, viaje1.getHod());
		assertEquals(4, viaje1.getMean_travel_time());
		assertEquals(5, viaje1.getStandard_deviation_travel_time());
		assertEquals(6, viaje1.getGeometric_mean_travel_time());
		assertEquals(7, viaje1.getGeometric_standard_deviation_travel_time());

	}

	@Test
	public void TestSet()
	{
		viaje1.setSourceid(7);
		viaje1.setDstid(8);
		viaje1.setHod(9);
		viaje1.setMean_travel_time(10);
		viaje1.setStandard_deviation_travel_time(11);
		viaje1.setGeometric_mean_travel_time(12);
		viaje1.setGeometric_standard_deviation_travel_time(13);

		assertEquals(7, viaje1.getSourceid());
		assertEquals(8, viaje1.getDstid());
		assertEquals(9, viaje1.getHod());
		assertEquals(10, viaje1.getMean_travel_time());
		assertEquals(11, viaje1.getStandard_deviation_travel_time());
		assertEquals(12, viaje1.getGeometric_mean_travel_time());
		assertEquals(13, viaje1.getGeometric_standard_deviation_travel_time());
	}

	@Test
	public void TestCompareTo()
	{
		assertEquals(0, viaje2.compareTo(viaje2));
		assertEquals(1, viaje2.compareTo(viaje3));
		assertEquals(-1, viaje4.compareTo(viaje3));
	}

}
