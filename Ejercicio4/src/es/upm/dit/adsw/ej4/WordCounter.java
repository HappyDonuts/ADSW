package es.upm.dit.adsw.ej4;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Analizador de textos.
 */
public class WordCounter {

	private Map<String, Registro> tabla1; 
	Registro[] datos;
	/**
	 * Constructor.
	 */
	public WordCounter() { 
		tabla1 = new HashMap<String, Registro>();
	}
	/**
	 * Carga un fichero de texto.
	 * @param file fichero.
	 * @throws IOException si hay problemas con el fichero.
	 */
	public void load(File file)throws IOException {
		tabla1.clear();
		Scanner scanner = new Scanner(file, "UTF-8");
		scanner.useDelimiter("[^\\p{javaLowerCase}\\p{javaUpperCase}]+");
		while (scanner.hasNext()) {
			String word = scanner.next().toLowerCase();	
		
			if(tabla1.get(word) == null){
				Registro regis = new Registro(word);
				tabla1.put(word, regis);
			}
			else{
				tabla1.get(word).inc();		
			}
			
		}
		scanner.close();

	}
	
	//es en descargas donde creamos datos porque en getDatos nos aseguramos de q exite o no
	private Registro[] descarga (Map<String, Registro> dict) {
		 Registro[] datos = new Registro[dict.size()];
		 int at = 0;
		 for (Registro registro : dict.values()){
		 datos[at++] = registro;}
		 
		 ordena(datos);
		 return datos;
		}
	

	//para saber si datos esta lleno 
	private Registro[] getDatos() {
		if (datos == null) {
			this.descarga(tabla1);
		}
		return datos;
	}


	/**
	 * Tamano de la tabla de contadores y del registro de palabras.
	 * @return numero de palabras.
	 */
	public int size(){
		return descarga(tabla1).length;
	}


	/**
	 * Devuelve las n palabras mas usadas (si n es positivo).
	 * Devuelve las n palabras menos utilizadas (si n es negativo).
	 * @param n
	 * @return
	 */
	public List<Registro> getTop(int n) { 
		List<Registro> list = new ArrayList<Registro>();
		 Registro[] aux = this.descarga(this.tabla1);

		if (n>0){
			for (int i = aux.length-1; (i >aux.length- (1 + Math.abs(n))) && (i >=0); --i){
				
				list.add(aux[i]);
					
			}
			return list;			
		}
		else if (n<0){
			for (int i = 0; (i < Math.abs(n)) && (i < aux.length); i++) {
				list.add(descarga(tabla1)[i]);
			}
			return list;
		}
		return null;

	}

	/**
	 * Devuelve cuantas palabras hay por debajo de un umbral c.
	 *
	 * @param c umbral de cuenta.
	 * @return numero de palabras que aparcecen en el texto menos de c veces.
	 */
	public int countBelow(int c) {
		int result = 0;
		for (int i = 0; i < descarga(tabla1).length; i++) {
			if(descarga(tabla1)[i].getCnt() < c){
				result++;
			}
			else{
				break;
			}
		}
		
		return result;
	}
	
	//Método de ordenación propio 
	public void ordena(Registro[] datos){
		 for(int i=0;i<(datos.length-1);i++){
             for(int j=i+1;j<datos.length;j++){
                 if(datos[i] != null && datos[j] != null && datos[i].getCnt() > (datos[j].getCnt())){
                     //Intercambiamos valores
                     Registro variableauxiliar=datos[i];
                     datos[i]=datos[j];
                     datos[j]=variableauxiliar;

                 }
             }
         }
	}

}