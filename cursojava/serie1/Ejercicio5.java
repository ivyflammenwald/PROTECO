/**@author prebe17
@version 2.3.1
*/

import java.util.Scanner;
import java.util.ArrayList;

/* class ListaProductos{

	ArrayList <String> nombres;
	ArrayList <Double> precios;

	ListaProductos(){
		this.nombres = new ArrayList <String>();
		this.precios = new ArrayList <Double>();
	} 

	ArrayList getNombres(){
		return this.nombres;
	}

	ArrayList getPrecios(){
		return this.precios;
	}

} */

/*debido a los multiples errores encontrados al implementar este programa, tales como la no impresion de el primer elemento del
ArrayList de articulos, se implementa todo en la clase main, esperando que con ello se resuelvan estas inconsistencias */

class Ejercicio5{

	public static void main (String[] args){

		ArrayList <String> tiendaArticulos = new ArrayList <String>();
		ArrayList <Double> tiendaPrecios = new ArrayList <Double>();
		ArrayList <String> carrito = new ArrayList <String>();

		Scanner sc = new Scanner(System.in);
		boolean continuar= true;

		System.out.println("\nPrebemart - ingrese la lista de articulos \n");

		double precio;
		String prod;

		while(continuar){ //llenado de la lista de articulos de la tienda
			System.out.println("ingrese un articulo, si es el primer articulo pulsar enter e ingrese el nombre despues. nombre:");
			prod = sc.nextLine(); // limpia el buffer de entrada
			prod = sc.nextLine(); 
			System.out.println("cual es su precio ");
			precio = sc.nextInt();
			
			tiendaArticulos.add(prod);
			tiendaPrecios.add(precio);
			
			System.out.println("desea ingresar otro articulo? 1 - si , !1 - no");
			if (sc.nextInt() != 1){
				continuar = false;
			}
		}

		System.out.println("\n");
		System.out.println("lista de productos del prebemart");
		//mostrando la lista de productos, no se por que razon no muestra el primer elemento del arreglo
		for (int i =0; i<tiendaArticulos.size(); i++) {
			System.out.println("articulo numero/indice en el catalogo de la tienda: "+(i+1));
			System.out.println("nombre : "+tiendaArticulos.get(i));
			//System.out.println("precio : "+tiendaPrecios.get(i));
		}
		System.out.println("");
		System.out.println("cuanto dinero tiene para las compras de esta semana?");//el pdf especificaba 500 pero se me hizo mas interactivo que cada usuario definiera el monto maximo que puede pagar
		int dineroCliente =sc.nextInt(); 

		boolean seguirComprando = true;

		System.out.println("");
		while(seguirComprando){ //llenado del carrito con los articulos deseados
			System.out.println("elija un articulo para comprar, segun el indice en la lista de productos");
			int choice =sc.nextInt();
			choice-=1;
			carrito.add(tiendaArticulos.get(choice));

			System.out.println("desea agregar otro articulo al carrito? 1 - si , !1 - no");
			if (sc.nextInt() != 1){
				seguirComprando = false;
			}
		}

		int cuenta=0;
		int indi=0;

		System.out.println("\n\nestos son los articulos contenidos en su carrito: ");
		for (String art : carrito){
			System.out.println("articulo numero/indice_carrito "+(indi+1));
			System.out.println("nombre : "+carrito.get(indi));
			int ind = tiendaArticulos.indexOf(art);
			System.out.println("precio : "+tiendaPrecios.get(ind));
			indi+=1;
			cuenta+= tiendaPrecios.get(ind); //cada articulo tiene el mismo indice en las listas de nombres y de precios de la tienda 
		}
		System.out.println("su cuenta es "+cuenta+" pesos");

		boolean irse = false;
		int sacar, ii=0;
		while(irse == false){
			if (cuenta < dineroCliente){
				System.out.println("usted ha pagado y ahora puede irse, muchas gracias por su compra!!!");
				irse = true;
			}else{
				System.out.println("no tiene dinero para todo lo que contiene su carrito, remueva articulos usando el indice de su carrito");
				System.out.println("que articulo desea remover? ");
				sacar = sc.nextInt();
				sacar-=1;
				int quit = tiendaArticulos.indexOf(carrito.get(sacar)); 
				cuenta-= tiendaPrecios.get(quit);	
				carrito.remove(sacar);

				System.out.println("el monto a pagar luego de remover el articulo es: "+cuenta);
				System.out.println("");
				System.out.println("sus articulos restantes son: ");
				ii=0;
				for (String art : carrito){
					System.out.println("articulo numero/indice_carrito "+(ii+1));
					System.out.println("nombre : "+art);
					int ind = tiendaArticulos.indexOf(art);
					System.out.println("precio : "+tiendaPrecios.get(ind));
					ii+=1;
				}
			}

		}
		
	}
}