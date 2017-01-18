package cadenas;
import utiles.*;
/**
 * Entrega la clase CadenasConMenu que muestre el siguiente menu. 
	1.Capitaliza palabras: solicitar� al usuario una cadena por teclado y convertir� el primer caracter de cada palabra a may�sculas. 
	Mostrar� el resultado.
	2.Extrae may�sculas: solicitar� al usuario una cadena por teclado y extraer� las iniciales que est�n en may�sculas acompa�adas por 
	un punto. Necesitar�s el m�todo Character.isUpperCase(caracter). Mostrar� el resultado.
	3.Salir.
	
	Requisitos:
	Solo se recoger�n opciones de men� v�lidas (1, 2 y 3)
	Utiliza m�todos en la medida de lo posible
	Evita el uso de bucles infinitos
	
 * @author Nieves Borrero
 * @version 1.0
 */

public class CadenasConMenu {

	public static void main(String[] args) {
		
		Menu menu=new Menu("Opciones:", new String[]{"Capitalizar palabra", "Extraer mayusculas", "Salir"});
		int opcion;
		do{
			opcion=menu.gestionar();
			
			if(opcion<1||opcion>3){
				System.out.println("La opcion introducida no es valida. Introduce una de las opciones del menu");
			}
			
			switch(opcion){
			    case 1:System.out.println(capitalizarCadena());; break;
				case 2:System.out.println(extraerMayuscula());break;
				case 3:System.out.println("Hasta otra!");break;
			}
		}while(opcion!=3);
	}//main
	
	
	/**
	 * Convierte el primer caracter de cada palabra a mayuscula.
	 */
	public static String capitalizarCadena(){
		
		String cadena=new String(Teclado.leerCadena("Introduce una palabra:"));
		
		cadena=cadena.trim();//Elimino posibles espacios de delante y de detras
		
		char c;
		int aux=0;
		String nuevaCadena="";
		for(int i=0; i<cadena.length(); i++){ //Recorro la cadena
			c=cadena.charAt(i);
			if(i==0){
				c=Character.toUpperCase(c);
			}
			if(i>=1){
				c=Character.toLowerCase(c);
			}
			if(c==' '){
				aux=i+1; //Si hay espacio en auxiliar guardo la siguiente posicion
			}
			if(aux==i){
				c=Character.toUpperCase(c); // Si auxiliar es igual a la posicion de la letra por la que vamos, pasa a mayuscula.
			}
			nuevaCadena+=c; //Acumulamos
		}//for
		
		return nuevaCadena; 
	}
	
	/**
	 * Extrae las iniciales que estan en mayuscula acompañadas por un punto.
	 */
	private static String extraerMayuscula() {
		
		String cadena=new String(Teclado.leerCadena("Introduce una palabra:"));
		
		char c;
		String nuevaCadena="";
		
		for(int i=0; i<cadena.length(); i++){ //Recorro la cadena
			c=cadena.charAt(i);
			if(Character.isUpperCase(c)){
				nuevaCadena+=c+".";
			}
		}
		return nuevaCadena;
	}

}//class
