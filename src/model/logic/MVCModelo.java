package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

import model.data_structures.DoubleLinkedList;
import model.data_structures.IDoubleLinkedList;
import model.sort.QuickPedantic;


/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArrayList<DoubleLinkedList<Viaje>> datosMes;
	private ArrayList<DoubleLinkedList<Viaje>> datosDia;
	private ArrayList<DoubleLinkedList<Viaje>> datosHora;

	private int tamano;
	private Viaje viaje;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datosMes = new ArrayList< DoubleLinkedList<Viaje>>();
		datosMes.add(new DoubleLinkedList<Viaje>());
		datosMes.add(new DoubleLinkedList<Viaje>());
		datosMes.add(new DoubleLinkedList<Viaje>());
		datosMes.add(new DoubleLinkedList<Viaje>());

		datosDia = new ArrayList< DoubleLinkedList<Viaje>>();
		datosDia.add(new DoubleLinkedList<Viaje>());
		datosDia.add(new DoubleLinkedList<Viaje>());
		datosDia.add(new DoubleLinkedList<Viaje>());
		datosDia.add(new DoubleLinkedList<Viaje>());

		datosHora = new ArrayList< DoubleLinkedList<Viaje>>();
		datosHora.add(new DoubleLinkedList<Viaje>());
		datosHora.add(new DoubleLinkedList<Viaje>());
		datosHora.add(new DoubleLinkedList<Viaje>());
		datosHora.add(new DoubleLinkedList<Viaje>());
	}
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano(int lista, String info)
	{
		if(info.equals("mes"))
		{
			if(lista==0)
			{
				return datosMes.get(0).size();
			}
			else if(lista==1)
			{
				return datosMes.get(1).size();
			}
			else if(lista==2)
			{
				return datosMes.get(2).size();
			}
			else if(lista==3)
			{
				return datosMes.get(3).size();
			}
		}
		else if(info.equals("dia"))
		{
			if(lista==0)
			{
				return datosDia.get(0).size();
			}
			else if(lista==1)
			{
				return datosDia.get(1).size();
			}
			if(lista==2)
			{
				return datosDia.get(2).size();
			}
			else if(lista==3)
			{
				return datosDia.get(3).size();
			}
		}
		else if(info.equals("hora"))
		{
			if(lista==0)
			{
				return datosHora.get(0).size();
			}
			else if(lista==1)
			{
				return datosHora.get(1).size();
			}
			if(lista==2)
			{
				return datosHora.get(2).size();
			}
			else if(lista==3)
			{
				return datosHora.get(3).size();
			}
		}
		return 0;

	}

	public void crearLista(int lista, String info) throws Exception
	{

		CSVReader reader=null;
		if(info.equals("mes"))
		{
			if(lista==0)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-MonthlyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosMes.get(0).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			else if(lista==1)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosMes.get(1).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			else if(lista==2)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-4-All-MonthlyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosMes.get(2).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			else if(lista==3)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-MonthlyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosMes.get(3).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
		}

		else if(info.equals("dia"))
		{
			if(lista==0)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-WeeklyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosDia.get(0).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			else if(lista==1)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-WeeklyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosDia.get(1).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			else if(lista==2)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-3-All-WeeklyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosDia.get(2).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			else if(lista==3)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-4-All-WeeklyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosDia.get(3).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
		}

		else if(info.equals("hora"))
		{
			if(lista==0)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-HourlyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosHora.get(0).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			else if(lista==1)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-All-HourlyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosHora.get(1).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			else if(lista==2)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-3-All-HourlyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosHora.get(2).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
			if(lista==3)
			{
				reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-4-All-HourlyAggregate.csv"));
				String [] nextLine=reader.readNext();
				while (nextLine != null) {
					// nextLine[] is an array of values from the line
					datosHora.get(3).agregar(new Viaje(nextLine[0],nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5], nextLine[6]));
					nextLine = reader.readNext();
				}
			}
		}
		else
		{
			throw new Exception("Revisar si se introdujo mal el trimestre o la informacion de mes, dia, hora (asegurarse de que esta en minuscula)");
		}
	}

	public DoubleLinkedList<Viaje> darViajesZonaOZonaD(String info, double info2, double zonaOrigen, double zonaDestino) throws Exception
	{
		DoubleLinkedList<Viaje> viajes=new DoubleLinkedList<Viaje>();
		if(info.equals("mes"))
		{
			if(info2<=3)
			{
				for(Viaje viaje: datosMes.get(0))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>3&&info2<=6)
			{
				for(Viaje viaje: datosMes.get(1))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>6&&info2<=12)
			{
				for(Viaje viaje: datosMes.get(2))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>12)
			{
				for(Viaje viaje: datosMes.get(3))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
		}
		else if(info.equals("dia"))
		{
			if(info2<=3)
			{
				for(Viaje viaje: datosDia.get(0))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>3&&info2<=6)
			{
				for(Viaje viaje: datosDia.get(1))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>6&&info2<=12)
			{
				for(Viaje viaje: datosDia.get(2))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>12)
			{
				for(Viaje viaje: datosDia.get(3))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
		}
		else if(info.equals("hora"))
		{
			if(info2<=3)
			{
				for(Viaje viaje: datosHora.get(0))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>3&&info2<=6)
			{
				for(Viaje viaje: datosHora.get(1))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>6&&info2<=12)
			{
				for(Viaje viaje: datosHora.get(2))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>12)
			{
				for(Viaje viaje: datosHora.get(3))
				{
					if(viaje.getInfo()==info2&&viaje.getSourceid()==zonaOrigen&&viaje.getDstid()==zonaDestino)
					{
						viajes.agregar(viaje);
					}
				}
			}
		}
		else
		{
			throw new Exception("No existe información al respecto");
		}
		return viajes;
	}

	public double menorZona(String info, int trimestre)
	{
		Viaje rta=null;
		if(info.equals("mes"))
		{
			if(trimestre<=3)
			{
				double identificador=datosMes.get(0).get(0).getSourceid();
				rta= datosMes.get(0).get(0);
				for(int i=0; i<datosMes.get(0).size(); i++)
				{
					Viaje v= datosMes.get(0).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>3&&trimestre<=6)
			{
				double identificador=datosMes.get(1).get(0).getSourceid();
				rta= datosMes.get(1).get(0);
				for(int i=0; i<datosMes.get(1).size(); i++)
				{
					Viaje v= datosMes.get(1).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>6&&trimestre<=12)
			{
				double identificador=datosMes.get(2).get(0).getSourceid();
				rta= datosMes.get(2).get(0);
				for(int i=0; i<datosMes.get(2).size(); i++)
				{
					Viaje v= datosMes.get(2).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>12)
			{
				double identificador=datosMes.get(3).get(0).getSourceid();
				rta= datosMes.get(3).get(0);
				for(int i=0; i<datosMes.get(3).size(); i++)
				{
					Viaje v= datosMes.get(3).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
		}
		
		else if(info.equals("dia"))
		{
			if(trimestre<=3)
			{
				double identificador=datosDia.get(0).get(0).getSourceid();
				rta= datosDia.get(0).get(0);
				for(int i=0; i<datosDia.get(0).size(); i++)
				{
					Viaje v= datosDia.get(0).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>3&&trimestre<=6)
			{
				double identificador=datosDia.get(1).get(0).getSourceid();
				rta= datosDia.get(1).get(0);
				for(int i=0; i<datosDia.get(1).size(); i++)
				{
					Viaje v= datosDia.get(1).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>6&&trimestre<=12)
			{
				double identificador=datosDia.get(2).get(0).getSourceid();
				rta= datosDia.get(2).get(0);
				for(int i=0; i<datosDia.get(2).size(); i++)
				{
					Viaje v= datosDia.get(2).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>12)
			{
				double identificador=datosDia.get(3).get(0).getSourceid();
				rta= datosDia.get(3).get(0);
				for(int i=0; i<datosDia.get(3).size(); i++)
				{
					Viaje v= datosDia.get(3).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
		}
		
		else if(info.equals("hora"))
		{
			if(trimestre<=3)
			{
				double identificador=datosHora.get(0).get(0).getSourceid();
				rta= datosHora.get(0).get(0);
				for(int i=0; i<datosHora.get(0).size(); i++)
				{
					Viaje v= datosHora.get(0).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>3&&trimestre<=6)
			{
				double identificador=datosHora.get(1).get(0).getSourceid();
				rta= datosHora.get(1).get(0);
				for(int i=0; i<datosHora.get(1).size(); i++)
				{
					Viaje v= datosHora.get(1).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>6&&trimestre<=12)
			{
				double identificador=datosHora.get(2).get(0).getSourceid();
				rta= datosHora.get(2).get(0);
				for(int i=0; i<datosHora.get(2).size(); i++)
				{
					Viaje v= datosHora.get(2).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(trimestre>12)
			{
				double identificador=datosHora.get(3).get(0).getSourceid();
				rta= datosHora.get(3).get(0);
				for(int i=0; i<datosHora.get(3).size(); i++)
				{
					Viaje v= datosHora.get(3).get(i);
					if(v.getSourceid()<identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
		}

		return rta.getSourceid();
	}

	public double mayorZona(String info, int mes)
	{
		Viaje rta=null;
		if(info.equals(info))
		{
			if(mes<=3)
			{
				double identificador=datosMes.get(0).get(0).getSourceid();
				rta= datosMes.get(0).get(0);
				for(int i=0; i<datosMes.get(0).size(); i++)
				{
					Viaje v= datosMes.get(0).get(i);
					if(v.getSourceid()>identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(mes>3&&mes<=6)
			{
				double identificador=datosMes.get(1).get(0).getSourceid();
				rta= datosMes.get(1).get(0);
				for(int i=0; i<datosMes.get(1).size(); i++)
				{
					Viaje v= datosMes.get(1).get(i);
					if(v.getSourceid()>identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(mes>6&&mes<=12)
			{
				double identificador=datosMes.get(2).get(0).getSourceid();
				rta= datosMes.get(2).get(0);
				for(int i=0; i<datosMes.get(2).size(); i++)
				{
					Viaje v= datosMes.get(2).get(i);
					if(v.getSourceid()>identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
			else if(mes>12)
			{
				double identificador=datosMes.get(3).get(0).getSourceid();
				rta= datosMes.get(3).get(0);
				for(int i=0; i<datosMes.get(3).size(); i++)
				{
					Viaje v= datosMes.get(3).get(i);
					if(v.getSourceid()>identificador)
					{
						identificador=v.getSourceid();
						rta=v;
					}
				}
			}
		}

		return rta.getSourceid();
	}
	
	public Comparable[] ordenarPorQuick(Comparable[] lista)
	{
		QuickPedantic ordenar= new QuickPedantic();
		ordenar.sort(lista);
		return lista;
	}

	public DoubleLinkedList<Viaje> consultarNViajes(String info, double info2, int N)
	{
		DoubleLinkedList<Viaje> viajes=new DoubleLinkedList<Viaje>();
		if(info.equals("mes"))
		{
			if(info2<=3)
			{
				for(Viaje viaje: datosMes.get(0))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>3&&info2<=6)
			{
				for(Viaje viaje: datosMes.get(1))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>6&&info2<=12)
			{
				for(Viaje viaje: datosMes.get(2))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>12)
			{
				for(Viaje viaje: datosMes.get(3))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
		}
		else if(info.equals("dia"))
		{
			if(info2<=3)
			{
				for(Viaje viaje: datosDia.get(0))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>3&&info2<=6)
			{
				for(Viaje viaje: datosDia.get(1))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>6&&info2<=12)
			{
				for(Viaje viaje: datosDia.get(2))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>12)
			{
				for(Viaje viaje: datosDia.get(3))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
		}
		else if(info.equals("hora"))
		{
			if(info2<=3)
			{
				for(Viaje viaje: datosHora.get(0))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>3&&info2<=6)
			{
				for(Viaje viaje: datosHora.get(1))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>6&&info2<=12)
			{
				for(Viaje viaje: datosHora.get(2))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
			else if(info2>12)
			{
				for(Viaje viaje: datosHora.get(3))
				{
					if(viaje.getInfo()==info2)
					{
						viajes.agregar(viaje);
					}
				}
			}
		}
		Comparable[] lista= sacarLista(viajes, info2);
		ordenarPorQuick(lista);
		int contador=0;
		for(int i=lista.length; i>0||contador<=N; i--)
		{
			viajes.agregar(lista[i]);
			contador++;
		}
		
		return viajes;
	}

	public Comparable[] sacarLista(DoubleLinkedList<Viaje> viajes, double info2) 
	{
		int i=0;
		Iterator iterador=viajes.iterator();
		Iterator ite=viajes.iterator();
		while(ite.hasNext())
		{
			Viaje viaje=(Viaje) ite.next();
			if(viaje.getInfo()==info2)
			{
				i++;
			}
		}
		Comparable[] lista= new Comparable[i];
		int j=0;
		while(iterador.hasNext())
		{
			Viaje viaje=(Viaje) iterador.next();
			if(viaje.getInfo()==info2)
			{
				lista[j]=viaje;
				j++;
			}
		}
		return lista;
		
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

	public DoubleLinkedList<Viaje> nuevosServicios(int mes, int zona)
	{

		DoubleLinkedList<Viaje> pedidos= new DoubleLinkedList<Viaje>();
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
