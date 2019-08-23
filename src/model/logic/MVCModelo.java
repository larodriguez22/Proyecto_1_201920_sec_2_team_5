package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;


/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArrayList<ArregloDinamico<Viaje>> datos;

	private int tamano;
	private Viaje viaje;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ArrayList< ArregloDinamico<Viaje>>();
		datos.add(new ArregloDinamico<Viaje>());
		datos.add(new ArregloDinamico<Viaje>());
	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano(int lista)
	{
		return datos.get(lista).size();
	}
	public void crearLista(int lista) throws Exception
	{
		CSVReader reader=null;
		if(lista==0)
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv"));

		}
		else if(lista==1)
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv"));

		}
		String [] nextLine=reader.readNext();
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			
			datos.get(lista).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
		}
		reader.close();
	}
	
	public int darViajesMes(double mes)
	{
		int c=0;
		if(mes<=3)
		{
			for(Viaje viaje: datos.get(0))
			{
				if(viaje.getMonth()==mes)
				{
					c++;
				}
			}
		}
		else if(mes>3)
		{
			for(Viaje viaje: datos.get(0))
			{
				if(viaje.getMonth()==mes)
				{
					c++;
				}
			}
		}
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Viaje v, int lista)
	{	
		datos.get(lista).agregar(v);
	}

	/**
	 * Requerimiento buscar dato
	 * @param <T>
	 * @param dato Dato a buscar
	 * @return 
	 * @return dato encontrado
	 */
	public Viaje buscar(int pos, int lista)
	{
		return datos.get(lista).get(pos);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public void eliminar(int pos, int lista)
	{
		datos.get(lista).remove(pos);
	}
	
	public ArregloDinamico<Viaje> nuevosServicios(int mes, int zona)
	{
		
		ArregloDinamico<Viaje> pedidos= new ArregloDinamico<Viaje>();
		if(mes<=3)
		{
			for(Viaje i: datos.get(0))
			{
				if(i.getSourceid()==zona)
				{
					pedidos.agregar(i);
				}
			}
		}
		else
		{
			for(Viaje i: datos.get(1))
			{
				if(i.getSourceid()==zona)
				{
					pedidos.agregar(i);
				}
			}
		}
		
		return pedidos;
		
	}

}
