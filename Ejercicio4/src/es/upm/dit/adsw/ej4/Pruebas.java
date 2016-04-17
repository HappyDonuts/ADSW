package es.upm.dit.adsw.ej4;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Pruebas {

	public static void main(String[] args)
			 throws IOException {
			 File file = new File("D:\\Usuarios 2\\Javi\\Desktop\\prueba.txt");
			 WordCounter wordCounter = new WordCounter();
			 wordCounter.load(file);
			 
			 String listString = "";
				for (Registro s : wordCounter.getTop(4)){
					listString += s.getClave() +" " + s.getCnt() + "\n";
				}

				System.out.println(listString);
			 System.out.println("Tamaño: "+ wordCounter.size());
			 int max = 10;
			 List<Registro> top = wordCounter.getTop(max);
			 System.out.print("Primeras "+ max +": ");
			 for(int i = 0; i < top.size(); i++){
				 System.out.print(top.get(i).getClave());
				if (i < top.size()-1) System.out.print(", ");
			 }
			 System.out.print("\n");
			 int min = -10;
			 List<Registro> under = wordCounter.getTop(min);
			 System.out.print("Últimas "+ Math.abs(min) +": ");
			 for(int i = 0; i < under.size(); i++){
				 System.out.print(under.get(i).getClave());
				 if (i < top.size()-1) System.out.print(", ");
			 }
			 System.out.print("\n");
			 int cota = 10;
			 System.out.println("Cantidad de palabras con menos de "+cota+ " repeticiones: "+wordCounter.countBelow(cota));
			
	}
}
