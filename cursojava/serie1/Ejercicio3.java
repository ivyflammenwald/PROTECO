/**@author prebe17
@version 1.4
*/

import java.util.Scanner;
import java.util.ArrayList;

class Persona{
	String nombre;
	int edad;
	double estatura;
	double peso;

	Persona(){}

	Persona(String nombre, int edad, double estatura, double peso){
	this.nombre=nombre;
	this.edad =edad;
	this.estatura= estatura;
	this.peso=peso;
	}

	void setNombre (String change){
		this.nombre = change ;
		}

	String getNombre (){
		return this.nombre ;
	}


	void setEdad (int change){
		this.edad = change ;
		}

	int getEdad (){
		return this.edad ;
	}

	void setEstatura (double change){
		this.estatura = change ;
		}

	double getEstatura (){
		return this.estatura ;
	}

	void setPeso (double change){
		this.peso = change ;
		}

	double getPeso (){
		return this.peso;
	}

}


class Ejercicio3{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<Persona> personas= new ArrayList <Persona>();

/* se habia implementado el programa de la siguiente manera, pero se cambia la forma en que se crean y almacenan las personas para utilizar
 el metodo set como lo requiere el pdf 
		boolean continuar =true;
		while(continuar){

			System.out.println("ingrese una persona");
			System.out.println(" nombre: ");
			String nomb = sc.nextLine();
			System.out.println("edad: ");
			int ed = sc.nextInt();
			System.out.println("estatura: ");
			double es = sc.nextDouble();
			System.out.println("peso: ");
			double pe= sc.nextDouble();

			personas.add(new Persona(nomb, ed, es, pe));

			System.out.println("desea agregar otro usuario? 1- si, !1 - no");
			int s = sc.nextInt();
			if (s != 1){
				continuar=false;
			}
		}

*/
		System.out.println("cuantas personas desea almacenar?");
		int cantidad = sc.nextInt();
		
		for (int i = 0; i < cantidad; i++){
			personas.add(new Persona());
		} 

		String nomb;
		System.out.println("");
		for (Persona perso: personas){
			System.out.println("ingrese una persona");
			System.out.println(" nombre: ");
			nomb = sc.nextLine();
			nomb = sc.nextLine();
			System.out.println("edad: ");
			int ed = sc.nextInt();
			System.out.println("estatura: ");
			double es = sc.nextDouble();
			System.out.println("peso: ");
			double pe= sc.nextDouble();
			perso.setNombre(nomb);
			perso.setPeso(pe);
			perso.setEstatura(es);
			perso.setEdad(ed);

		}

		//se crean arraylist con los atributos de las personas para ejemplificar el uso de clases envolventes 

		ArrayList<Integer> edades = new ArrayList<Integer>();
		ArrayList<Double> pesos = new ArrayList<Double>();
		ArrayList<Double> estaturas = new ArrayList<Double>();
		ArrayList<String> nombres = new ArrayList<String>();

		System.out.println("");
		for (Persona perso : personas ){
			nombres.add(perso.getNombre());
			estaturas.add((Double)perso.getEstatura());
			edades.add((Integer)perso.getEdad());
			pesos.add((Double)perso.getPeso());

			System.out.println("nombre: "+perso.getNombre()+", edad: "+perso.getEdad()+" anios, peso: "+perso.getPeso()+"[kg], estatura: "+perso.getEstatura()+"[m]");
		}

		System.out.println("");
		System.out.println("Arraylist de nombres");
		for (String nombre : nombres){
			System.out.println(nombre);
		}

		System.out.println("");
		System.out.println("Arraylist de edades, usando Integer"); 
		for (Integer edad : edades){
			System.out.println(edad);
		}

		System.out.println("");
		System.out.println("Arraylist de pesos, Double");
		for (Double peso : pesos){
			System.out.println(peso);
		}

		System.out.println("");
		System.out.println("Arraylist de estaturas, Double");
		for (Double estatura : estaturas){
			System.out.println(estatura);
		}
	}
}
