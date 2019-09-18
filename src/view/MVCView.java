package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar los viajes por un trimestre seleccionado por mes o dia de la semana o hora");
			System.out.println("2. Consultar el tiempo promedio de viaje y su desviación estándar de los viajes entre una zona de origen y una zona destino dada");
			System.out.println("3. Consultar el tiempo promedio de viaje y su desviación estándar de los viajes entre una zona de origen y una zona destino");
			System.out.println("4. Comparar los tiempos promedios de los viajes para una zona dada contra cada zona X en un rango de zonas dado");
			System.out.println("5. Generar una gráfica ASCII que muestre el tiempo promedio de los viajes entre una zona origen y una zona destino para cada hora del día");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}
