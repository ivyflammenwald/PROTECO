import java.util.*;

class Pokemon{

	String nombre;
	int vida;
	int nivel;
	int at;
	String ataque;
	boolean vivo = true;

	Pokemon(){
	this.vida = 500;
	this.nivel = 1;
	this.at = 100;
	this.ataque = "mordida";
	this.nombre = "Ratata";
	}

	Pokemon (String nombre, int vida, int nivel, int at, String ataque){
	this.vida = vida;
	this.nivel = nivel;
	this.ataque = ataque;
	this.at = 100;
	this.nombre = nombre;
	}
	
	Pokemon (String nombre){
	this.vida = 500;
	this.nivel = 1;
	this.at = 100;
	this.ataque = "mordida";
	this.nombre = nombre;
	}
	
	boolean vivo(){
		return this.vivo;
	}

	void muerto(){
		System.out.println(this.nombre+" se murio alv");
		this.vivo = false; 
	}

	void setVida(int vida){
		this.vida = vida;
	}

	int getVida(){
		return this.vida;
	}
	void setAt(int v){
		this.at = vida;
	}

	int getAT(){
		return this.at;
	}

	void setNivel(int v){
		this.nivel = v;
	}

	int getNivel(){
		return this.nivel;
	}

	void setAtaque(String v){
		this.ataque = v;
	}

	String getAtaque(){
		return this.ataque;
	}

	void setNombre(String n){
		this.nombre = n;
	}

	String getNombre(){
		return this.nombre;
	}

	public void atacar(Pokemon enemigo){
		System.out.println(this.getNombre()+" utilizo "+this.getAtaque()+" sobre "+enemigo.getNombre());
		int vid = enemigo.getVida();
		vid = vid-this.getAT();
		enemigo.setVida(vid);
		System.out.println("vida restante de "+enemigo.getNombre()+" = "+enemigo.getVida());
		if (enemigo.vida < 0){
			enemigo.muerto();
		}	
	}	
	
}

public class BatallaPoke{
	public static void main (String[] args){
		System.out.println("batalla pokemon a muerte ");
		Scanner teclado = new Scanner(System.in);	
		
		System.out.println("ingresa el primer pokemon ");
		String n1 = teclado.nextLine();
		Pokemon p1= new Pokemon(n1);
		Pokemon p2 = new Pokemon();
		
		System.out.println(p1.getNombre() + " vs "+p2.getNombre());
		while(p1.vivo() && p2.vivo()){
			p1.atacar(p2);
			p2.atacar(p1);
		}
		System.out.println("fin de la batalla");

	}
}

