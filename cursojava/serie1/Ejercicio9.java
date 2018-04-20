/**@author prebe17
@version 1.0
*/

import java.util.ArrayList;

class Empleado{

	String nombre;  

	Empleado(){
		this.nombre="Empleado";
	}

	Empleado(String nom){
		this.nombre =nom;
	}

	public String toString(){
		return String.format("\neste metodo se ejecuta como instancia de un empleado\n	");
	}	


	public void saludar(Empleado emp){
		System.out.println(this.nombre+" saluda al empleado "+emp.nombre);
	}

	String getNombre(){
		return this.nombre;
	}

}

class Ejecutivo extends Empleado{

	Ejecutivo(String nombre){
		super ();
	}

	public String toString(){
		return String.format("\neste metodo se ejecuta como instancia de un Ejecutivo\n	");
	}	

}

class Boss extends Ejecutivo{

	Boss(String nombre){
		super (nombre);
	}

	public String toString(){
		return String.format("\neste metodo se ejecuta como instancia de un Boss\n	");
	}
}

class  Ceo extends Boss{

	Ceo(String nombre){
		super (nombre);
	}

	public String toString(){
		return String.format("\neste metodo solo es ejecutado por un CEO\n	");
	}

}

class  Ejercicio9{
	
	public static void main (String[] args){

		Ceo ce = new Ceo(" instancia de  ceo");//
		System.out.println(ce);
		Ejecutivo ej = (Ejecutivo)ce;
		System.out.println(ej);
		Boss bo = (Boss)ej;
		System.out.println(bo);


		ArrayList <Empleado> emps = new ArrayList<Empleado>();

		for (int i = 0; i<3;i++){
			emps.add(new Empleado());
		}

		for (int i = 0; i<3;i++){
			emps.add(new Ejecutivo("Ejecutivo"));
		}

		for (int i = 0; i<3;i++){
			emps.add(new Boss("Boss"));
		}

		emps.add(ce);

		for (Empleado i: emps){
			System.out.println(i);
		}
		
	}
}

/* se Crea un Arraylist de tipo empleado que permite a todas las subclases ser tratadas como una instancia de la clase padre, Empleado,
lo que permite almacenar valores de diferentes subclases en el mismo arreglo.
asi  mismo se instancia un objeto CEO el cual es referenciado mediante variables de tipo ejecutivo y boss para realizar sus metodos */