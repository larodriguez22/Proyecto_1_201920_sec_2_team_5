package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.logic.MVCModelo;
import view.MVCView;
import com.opencsv.CSVReader;
public class Controller {

	/* Instancia del Modelo*/
	private static MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	private int hora;

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
				view.printMessage("Seleccione el trimestre que quiere visualizar, siendo 1 el primer trimestre y 4 el ultimo");
				int trimestre=lector.nextInt();
				try {
					modelo.crearLista(trimestre);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				view.printMessage("Lista creada");
				view.printMessage("La zona con menor identificador en todos los archivos del trimestre seleccionado es: "+modelo.darMenor());
				view.printMessage("La zona con mayor identificador en todos los archivos del trimestre seleccionado es: "+modelo.darMayor());
				break;

			case 2:
				view.printMessage("--------- \n Consultar el tiempo promedio de viaje y su desviación estándar de los viajes entre una zona de origen y una zona destino");
				view.printMessage("--------- \n Seleccione la zona de origen:");
				int origen=lector.nextInt();
				view.printMessage("--------- \n Seleccione la zona de destino:");
				int destino=lector.nextInt();
				view.printMessage("--------- \n Seleccione 0 en caso de que quiera consultar meses, 1 en caso de que quiera consultar dias, 2 en caso de que quiera consultar hora:");
				int info=lector.nextInt();
				
				modelo.consultarTiempoPromedioyDesviaciónEstandar(destino, origen, info);
				
			case 3:
				view.printMessage("--------- \n Consultar la información de los N viajes con mayor tiempo promedio");
				view.printMessage("--------- \n Seleccione el numero de viajes que desea consultar");
				int N=lector.nextInt();
				view.printMessage("--------- \n Seleccione 0 en caso de que quiera consultar meses, 1 en caso de que quiera consultar dias, 2 en caso de que quiera consultar hora:");
				int info2=lector.nextInt();
				modelo.mayorTiempoPromedio(N, info2);
				
			case 4:	
				view.printMessage("--------- \n Comparar los tiempos promedios de los viajes");
				view.printMessage("--------- \n Seleccione la zona que quiere comparar");
				int zonaDada=lector.nextInt();
				view.printMessage("--------- \n Seleccione la zona menor");
				int zonaMenor=lector.nextInt();
				view.printMessage("--------- \n Seleccione la zona mayor");
				int zonaMayor=lector.nextInt();
				view.printMessage("--------- \n Seleccione 0 en caso de que quiera comparar con la informacion en meses, 1 en caso de que quiera comparar con la informacion de dias");
				int info3=lector.nextInt();
				
				modelo.compararZonas(zonaDada, zonaMayor, zonaMenor,info3);
				
				
			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}

		}	

	}
}
