package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.data_structures.ArregloDinamico;
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
				modelo.crearLista(0);
				modelo.crearLista(1);
				view.printMessage("Lista creada");
				view.printMessage("Viajes mes 1: " + modelo.darViajesMes(1)+ "\n---------");
				view.printMessage("Viajes mes 2: " + modelo.darViajesMes(2)+ "\n---------");
				view.printMessage("Viajes mes 3: " + modelo.darViajesMes(3)+ "\n---------");
				view.printMessage("Viajes mes 4 :" + modelo.darViajesMes(4)+ "\n---------");
				view.printMessage("Viajes mes 5: " + modelo.darViajesMes(5)+ "\n---------");
				view.printMessage("Viajes mes 6: " + modelo.darViajesMes(6)+ "\n---------");
				break;

			case 2:
				view.printMessage("--------- \n Seleccione la zona: ");
				int zona = lector.nextInt();
				System.out.println("--------- \n Seleccione el mes: ");
				int mes= lector.nextInt()-1;
				ArregloDinamico<Viaje> viajes = modelo.nuevosServicios(mes, zona);
				for(Viaje i:viajes)
				{
					view.printMessage("Zona Origen:"+i.getSourceid()+"; Zona destino:"+ i.getDstid() +"; tiempo promedio:" + i.getMean_travel_time() +"; Desviación estandar:" + i.getGeometric_standard_deviation_travel_time());
				}


				view.printMessage("Fin de los viajes con zona y mes especificados");
				break;

			case 3:
				view.printMessage("--------- \\n Seleccione el trimestre:");
				int trimestre0 = lector.nextInt();
				view.printMessage("El numero total de viajes es:" + modelo.darTamano(trimestre0));
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
				ArregloDinamico<Viaje> viajes2 = modelo.nuevosServicios(mes3, zona1);
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
