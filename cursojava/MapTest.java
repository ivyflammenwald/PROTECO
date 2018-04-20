
public class Animal {   
		String nombre;

    	public Animal(String nombre) {
    		this.nombre=nombre;	
    	}

}

public class Persona {
   	String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    int edad;
	
	Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int edad) {
    	this(nombre, apellidoPaterno, apellidoMaterno);
    	this.edad = edad;
	}
	Persona(){    
    }
	Persona(String nombre, String apellidoPaterno, String apellidoMaterno){
 		this(nombre,apellidoPaterno);
    	this.apellidoMaterno = apellidoMaterno;
	}
	Persona(String nombre){
    	this.nombre = nombre;
	}
	Persona(String nombre, String apellidoPaterno){
   		this(nombre);
    	this.apellidoPaterno = apellidoPaterno;
	}
	void diHola() {
        System.out.println("Hola, soy " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + " y tengo " + edad + " años.");
   	}
}


public class MapTest{
	static Map<Persona, Animal> mascotas = new HashMap <Persona,Animal>();
	public static void main(String [] args){
		Persona p1 = new Persona(" name, lastname");
		Persona p2 = new Persona(" name2, lastname2");
		Animal a1 = new Animal("snoopdogg");
		Animal a2 = new Animal("canario");

		mascotas.put(p1,a1);
		mascotas.put(p2,a2);

		System.out.println(p1+" tiene "+mascotas.get(p1));

	}

	public static void Imprimir(){
		System.out.println("\n contenido del mapa");
		for (Persona p: mascotas.keySet()){
			System.out.println(p.nombre+" tiene "+mascotas.get(p).nombre);
		}

		System.out.println("total de mascotas : "+mascotas.size());
	}
}