package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.data_structures.DoubleLinkedList;
import model.logic.MVCModelo;
import model.logic.Viaje;
import view.MVCView;
import com.opencsv.CSVReader;
public class Controller 
{

	/* Instancia del Modelo*/
	private static MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	public void run()
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				view.printMessage("--------- \n Cargando Viajes ");
				modelo = new MVCModelo();
				view.printMessage("--------- \n Seleccione 0 si quiere cargar los datos para el primer trimestre del ano, y 1 si quiere cargar los datos para el segundo trimestre del ano: ");
				int trimestre=lector.nextInt();

				view.printMessage("--------- \n Escriba mes si quiere cargar la informacion por mes, escriba dia si quiere cargar la informacion por dia, y escriba hora si quiere cargar la informacion por hora: ");
				String info=lector.nextLine();
				try
				{
					modelo.crearLista(trimestre, info);
				}
				catch(Exception e)
				{
					view.printMessage(e.getMessage());
				}
				view.printMessage("Archivos cargados");
				view.printMessage("El total de viajes por" + info+ "para el trimestre "+ trimestre+ "es: "+modelo.darTamano(trimestre, info)+"\n---------");
				view.printMessage("La zona con menor identificador " + modelo.menorZona(info, trimestre)+ "\n---------");
				view.printMessage("La zona con menor identificador " + modelo.mayorZona(info, trimestre)+ "\n---------");
				break;

			case 2:
				view.printMessage("--------- \n Seleccione la zona de origen: ");
				int zonaOrigen = lector.nextInt();
				view.printMessage("--------- \n Seleccione la zona de destino: ");
				int zonaDestino = lector.nextInt();
				System.out.println("--------- \n Seleccione el mes: ");
				int info2= lector.nextInt();
				try
				{
					DoubleLinkedList<Viaje> viajes = modelo.darViajesZonaOZonaD(info, info2, zonaOrigen, zonaDestino);
					for(int h=0; h<viajes.size(); h++)
					{
						Viaje i=viajes.get(h);
						view.printMessage("Viaje"+h+": Tiempo promedio:" + i.getMean_travel_time() +"; Desviación estandar:" + i.getStandard_deviation_travel_time());
					}
				}
				catch(Exception e)
				{
					view.printMessage(e.getMessage());
				}
				break;

			case 3:
				view.printMessage("--------- \\n Seleccione el numero de viajes que quiere consultar:");
				int N = lector.nextInt();
				DoubleLinkedList<Viaje> vs= modelo.consultarNViajes(info, info2, N);
				for(int o=0; o<vs.size(); o++)
				{
					Viaje t=vs.get(o);
					view.printMessage("Viaje"+o+"Zona Origen: "+t.getSourceid()+" Zona Destino: "+t.getDstid()+" Tiempo promedio:" + t.getMean_travel_time() +"; Desviación estandar:" + t.getStandard_deviation_travel_time());
				}
				break;

			case 4:
				view.printMessage("--------- \nDar Seleccionar el mes deseado: ");
				int mes2 = lector.nextInt();
				int trimestre1;
				if(mes2<=3)
				{
					trimestre1=0;
				}
				else
				{
					trimestre1=1;
				}
				int numero = modelo.darViajesMes(mes2);
				double porcentaje = (numero*100)/modelo.darTamano(trimestre1);
				view.printMessage("El total de viajes del mes "+mes2+ " Es: "+numero+ ". Y su porcentaje es: "+porcentaje );
				break;

			case 5: 
				view.printMessage("--------- \n Seleccione la zona: ");
				int zona1 = lector.nextInt();
				System.out.println("--------- \n Seleccione el mes: ");
				int mes3= lector.nextInt();
				DoubleLinkedList<Viaje> viajes2 = modelo.nuevosServicios(mes3, zona1);
				int cont0=0;
				int trimestre2;
				if(mes3<=3)
				{
					trimestre2=0;
				}
				else
				{
					trimestre2=1;
				}
				for(Viaje i: viajes2)
				{
					if(i.getMonth()==mes3&&i.getSourceid()==zona1)
					{
						cont0++;
					}
				}
				double porcentaje2 = (cont0*100)/modelo.darTamano(trimestre2);
				view.printMessage("El total de viajes del mes "+mes3+ " y zona de origen: "+zona1+" Es: "+cont0+ ". Y su porcentaje es: "+porcentaje2);
				break;	

			case 6: 
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}

		}	

	}
}
