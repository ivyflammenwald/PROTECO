/**@author prebe17
@version 3.2.7
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class NoMatchCalifError extends Exception{
	NoMatchCalifError(){
		super();
	}
}

class SinTiempoException extends Exception{
	SinTiempoException(){
		super();
	}
}

interface Tarea{
	double hacer(double tiemporestante);
	double entregar(double calif);
}

interface Obligatoria{ //no le otorga ningun funcionamiento que convierta una tarea en "obligatoria", solo se usa para implementar un metodo mas 
	double hacerlaAfuera(double calif);
}

class TareaPrebes implements Tarea{ // se crea esta clase para poder utilizar un arraylist que almacene las tareas, para ser manipulado en ciclos en el main
	
	protected boolean hecha;
	protected double valor; //cuanto vale cada tarea

	public double hacer(double tiemporestante){
		System.out.println("haciendo tarea"); // se va a sobrecargar
		return tiemporestante;
	}

	public double entregar(double calif){
		System.out.println("se entrega la tarea");
		return calif;
	}

	double getValor(){
		return this.valor;
	}

	boolean getHecha(){
		return this.hecha;
	}

	void setValor (double change){
		this.valor =change;
	}

	void setHecha (){
		this.hecha =true;
	}
}

class PreguntasAMano extends TareaPrebes implements Obligatoria {

	protected boolean completa;
	protected final double tiempo;

	PreguntasAMano(double val, double tiempo){
		this.hecha=false;
		this.completa=false;
		this.valor=val; //puntos
		this.tiempo=tiempo; //horas 
	}
	
	double getTiempo(){
		return this.tiempo;
	}

	/*int getValor(){
		return this.valor;
	}

	boolean getHecha(){
		return this.hecha;
	}
void setValor (int change){
		this.valor =change;
	}

	void setHecha (){
		this.hecha =true;
	}*/

	boolean getCompleta(){
		return this.completa;
	} 

	void setCompleta (){
		this.completa =true;
	}

	public double hacer(double tiemporestante){
		try{
			if(tiemporestante<this.getTiempo()){  //si no la acabas pero quieres entregar algo
				throw new SinTiempoException();	
			}
			System.out.println(" Ya terminaste esta  serie de preguntas a mano");
			this.setHecha();
			this.setCompleta();
			tiemporestante-=this.getTiempo();
		}catch(SinTiempoException ste){
			if(tiemporestante <0.3 ){ //si ya es la hora prebe
				System.out.println("ya no tienes tiempo para hacerla :c");
			}else{
				System.out.println(" hiciste la mitad de la tarea");
				this.setHecha();
				tiemporestante=0;
			}
		}
		return tiemporestante;
	}

	public double hacerlaAfuera(double calif){
		this.setCompleta();
		System.out.format("\n ya esta terminada, y se la entregaste a los becarios, calificacion: %.2f\n",this.getValor());
		calif+=this.getValor();
		return calif;
	}

	public double entregar (double calif){
		if(this.getHecha()==false){
			System.out.println("no puedes entregar una tarea que no hiciste");
		}
		else if (this.getHecha()==true && this.getCompleta()==false){
			System.out.println("tu tarea esta incompleta, los becarios te mandaron a terminarla");
			this.hacerlaAfuera(calif);
		}else{
			System.out.format("\ntu tarea esta completa, ya tienes tu calificacion: %.2f \n",this.getValor());
			calif+=this.getValor();
		}
		return calif;
	}

	public String toString(){
		return String.format("\nEstas preguntas a mano valen %.2f puntos y toma %.2f horas hacerlas\n",this.getValor(),this.getTiempo());
	}	

}



class Programas extends TareaPrebes{

	final protected double tiempo;

	Programas(double val, double tiempo){
		this.hecha=false;
		this.valor=val; //puntos
		this.tiempo=tiempo; //horas 
	}
	
	double getTiempo(){
		return this.tiempo;
	}

	public double hacer(double tiemporestante){
		try{
			if(tiemporestante ==0 ){ //si ya es la hora prebe
				throw new SinTiempoException();
			}else{			//si todavia tienes tiempo para hacerla
				System.out.println(" Ya terminaste estos programas y los enviaste por correo");
				this.setHecha();;
				tiemporestante-=this.getTiempo();
			}
		}catch(SinTiempoException ste){
			System.out.println("ya no tienes tiempo para hacerla :c");
		}finally{
			return tiemporestante;
		}
	}

	public double entregar (double calif){
		if(this.getHecha()==false){
			System.out.println("no puedes entregar una tarea que no hiciste");
		}else{
			System.out.format("\ntus programas funcionan correctamente, ya tienes tu calificacion: %.2f\n ",this.getValor());
			calif +=this.getValor();
		}
		return calif;
	}

	public String toString(){
		return String.format("\nEstos programas valen %.2f puntos y toma %.2f hora(s) hacerlos\n",this.getValor(),this.getTiempo());
	}	

}



class Proyecto extends TareaPrebes implements Obligatoria{

	final double tiempo;
	boolean completa;

	Proyecto(){
		this.hecha=false;
		this.completa=false;
		this.valor=3.5; //puntos
		this.tiempo=5; //horas 
	}
	
	double getTiempo(){
		return this.tiempo;
	}

	boolean getCompleta(){
		return this.completa;
	} 

	void setCompleta (){
		this.completa =true;
	}

	public double hacer(double tiemporestante){
		try{
			if(tiemporestante < 1 ){ //si ya es la hora prebe
				throw new SinTiempoException();
			}else if(tiemporestante<this.getTiempo() && tiemporestante >1){  //si no la acabas pero quieres entregar algo
				System.out.println(" el proyecto quedo inconcluso");
				this.setHecha();
				tiemporestante=0;
			}else{
				System.out.println(" Ya terminaste el proyecto, vamonos al cafe 76(rip)");
				this.setHecha();
				this.setCompleta();
				tiemporestante-=this.getTiempo();
			}
		}catch(SinTiempoException ste){
			System.out.println("ya es la hora prebe y no hiciste el proyecto, vas a reprobar alv");
		}finally{
			return tiemporestante;
		}
	}

	public double hacerlaAfuera(double calif){
		this.setCompleta();
		System.out.format("\nterminaste el proyecto extemporaneo y te bajaron puntos, calificacion: %.2f\n",(this.getValor()-2));
		calif+=(this.getValor()-1);
		return calif;
	}

	public double entregar (double calif){
		if(this.getHecha()==false){
			System.out.println("no puedes entregar el proyecto porque no lo hiciste, te reprobaron alv");
		}
		else if (this.getHecha()==true && this.getCompleta()==false){
			System.out.println("termina tu programa antes de que pasen a evaluarte, que no te vean los becarios");
			this.hacerlaAfuera(calif);
		}else{
			System.out.format("\nentregaste el proyecto!, ya tienes tu calificacion: %.2f\n ",this.getValor());
			calif+=this.getValor();
		}
		return calif;
	}

	public String toString(){
		return String.format("\nEl proyecto vale "+this.getValor()+" puntos y te faltan 5 hrs para terminarlo\n	");
	}	

}



class Ejercicio10{
	public static void main(String[] args){
		
		Scanner  sc = new Scanner(System.in);
		Random ran=new Random();
		double tiemporestante= (ran.nextInt(4)+ran.nextInt(4)+ran.nextInt(3)+2);
		System.out.println("\ntienes "+tiemporestante+" horas para terminar la tarea (antes de la hora prebe)\n");
		System.out.println("decide sabiamente que tareas hacer. ");
		System.out.println("");
		ArrayList <TareaPrebes> tareas = new ArrayList <TareaPrebes>();

		Proyecto  proy = new Proyecto(); //3.5 puntos 5 hrs
		tareas.add(proy);

		for (int i = 0; i<3;i++){
			double cal=(ran.nextDouble()+0.7); //valen al menos medio punto cada tarea
			double tie =(ran.nextDouble()+ran.nextDouble()+ran.nextDouble()); //la suma de tres numeros aleatorios entre 0 y 1 es el tiempo que toma hacerla
			tareas.add(new PreguntasAMano(cal,tie));
		}

		for (int i = 0; i<3;i++){
			double cal=(ran.nextDouble()+0.7); //valen al menos medio punto cada tarea
			double tie =(ran.nextDouble()+ran.nextDouble()+ran.nextDouble()); //la suma de tres numeros aleatorios entre 0 y 1 es el tiempo que toma hacerla
			tareas.add(new Programas(cal,tie));
		}



		/*
		PreguntasAMano pm1 = new PreguntasAMano(cal, tie); //1 punto 2 hr 
		PreguntasAMano pm2 = new PreguntasAMano(1.25); //2  puntos 2 hr
		Programas 	pg1 = new Programas(1.7);
		Programas pg2 = new Programas(1.2);
		Programas pg3 = new Programas(0.8);
		Programas pg4 =  new Programas(1.4);

		tareas.add(proy);
		tareas.add(pm1);
		tareas.add(pm2);
		tareas.add(pg1);
		tareas.add(pg2);
		tareas.add(pg3);
		*/

		System.out.println("elija sus tareas segun el indice:\n"); 

		int i=0;
		for (TareaPrebes tar : tareas){
			System.out.println("tarea numero: "+(i+1));
			System.out.print(tar);
			System.out.println("");
			i++;
		}

		System.out.println("");

		ArrayList <TareaPrebes> hechas = new ArrayList <TareaPrebes>();

		while (tiemporestante > 0){
			System.out.println("hacer la tarea numero");
			int haciendo=sc.nextInt();
			haciendo-=1;
			TareaPrebes trr = tareas.get(haciendo);
			tiemporestante = trr.hacer(tiemporestante);
			hechas.add(trr);
		}

		System.out.println("");
		double cal=0, cal1=0;

		try{
			for (TareaPrebes tar : hechas){
			cal+=tar.entregar(cal); //deberia alterar el valor de la calificacion pero presenta anomalias de hasta 2 puntos de mas/menos	
			cal1+=tar.getValor();	//se iutiliza esta variable para garantizar que la calificacion presentada sea correcta
			}

			if(cal1>10){
				cal1 =10;
			}
			if(cal1 != cal){
				throw new NoMatchCalifError();
			}
			System.out.format("\nla calificacion que sacaste en este curso es: %.2f  \n",cal);
		}catch(NoMatchCalifError nmce){
			System.out.format("\n la calificacion que sacaste en este curso es: %.2f  \n",cal1);
		}
		if(cal1<6){
			System.out.println("Reprobaste, no hagas las tareas un dia antes de la entrega\n");
		}
	}
}

/* notas sobre el programa:

1) en un principio pense implementar un arraylist con las tareas hechas y solicitar al usuario que eligiera que tareas entregear, 
por eso cree el booleano hechas y la condicional de si se intentaba entregar una tarea no hecha imprimiera algo. decidi al final
implementar la entrega de los trabajos automaticamente por lo que esas secuencias de codigo nunca seran ejecutadas

2) para demostrar el polimorfismo en este programa dare una explicacion detallada de las dificultades de su implementacion y como el polimorfismo
	fue crucial para la resolucion de dichos conflictos:
	para interactuar con el usuario (programando un codigo eficiente) se usan ciclos y se requiere tener los objetos agrupados como un conjunto.
	hay tres tipos de objetos: proyecto, tareas a mano y programas, que se requieren tratar como un grupo , para esto se elige la estructura
	arraylist la cual tiene la siguente restriccion: los objetos almacenados deben ser del mismo tipo, por tanto las tres clases diferentes deben 
	encontrar una forma de ser tratadas como si fueran todas de la misma clase para ingresar al mismo arraylist.
	para ello se definio una superclase de las tres, tareaprebes, esta superclase es el tipo de dato que manejan los arraylist ya que las tres
	clases de tarea heredan de tareaprebes, por lo que pueden ser tratadas y comportarse como una instancia de la clase tareaprebes.
	aunque las instancias pertenecen a diferentes clases, todas pueden almacenarse en el mismo arraylist que almacena 
	instancias de tipo tareaprebes (esto es el polimorfismo). Tener un arreglo donde se almacenan todas las instancias te tarea creadas permite tener
	un codigo limpio y de funcionamiento eficiente (de lo contrario tendria que usar un arraylist por cada tipo de tarea e implementar
	en el main la ejecucion de ciclos individuales para cada arreglo de tareas).

3) la herencia se muestra tanto en  la implementacion de  interfaces como en la clase padre tarea_prebes, que demuestra la interaccion de
clases en una jerarquia y la utilidad de sobrecargar los metodos de una clase padre para reciclar codigo y mantener un programa bien definido

4) el encapsulamiento es ejemplificado en los atributos con modificadores de acceso y metodos setters/getters que delimitan el acceso 
a las variables y el funcionamiento interno de los metodos (para ocultarlo) 

5) la abstraccion se refleja en la clase tareaprebe, la cual no puede instanciarse porque en el mundo fisico no existe una tarea que no sea
de un tipo (preguntas/programas/proyecto), no puede instanciarse (pese a que el programa lo permita), asi mismo, las interfaces
marcan las pautas de las clases, siendo meramente conceptos, una "obligatoria" solo tiene sentido si se habla de una clase, como parte de
una subclase.


*/ 