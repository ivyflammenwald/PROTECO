/**@author prebe17
@version 1.0
*/
import java.lang.Math;

class Circulo{
	double radio;
	final double pi=3.1416; //pi es una constante por lo que su valor nunca va a cambiar 

	Circulo(){
		this.radio=3;
	}

	Circulo(int r){
		this.radio = r;
	}

	void setRadio(double r){
		this.radio=r;
	}

	double getRadio(){
		return this.radio;
	}

	double perimetro(){
		return (pi*(2*(this.getRadio())));
	}

	double area(){
		return (pi*Math.pow(this.getRadio(),2));
	}
}

class Poligono{

	public String nombre;
	final int lados; //utilizo lados como final porque una vez creada (por ejemplo dibujada) una figura, no se altera su numero de lados,
					//se puden alterar sus medidas, pero si se cambiara el numero de lados dejaria de ser si misma y seria un ente ilogico 
	double medidaLado;
	int apotema;

	void setApotema (int change){
		this.apotema = change ;
		}

	int getApotema (){
		return this.apotema ;
	}

	int getLados (){
		return this.lados ;
	}

	double getMedida(){
		return this.medidaLado;
	}

	void setMedida(int med){
		this.medidaLado = med;
	}

	String getNombre(){
		return this.nombre;
	}

	Poligono(){
		this.lados = 4;
		this.medidaLado =12; 
		String l = Integer.toString(4);
		this.nombre = "poligono de "+l+" lados";
	}

	Poligono (int lad, int med) {
		this.lados=lad;
		this.medidaLado =med;
		String l = Integer.toString(lados);
		this.nombre = "poligono de "+l+" lados";
		this.medidaLado =10;
		if(lados>4){
			this.apotema=8;
		}
	}

	Poligono(int lad, int ap, int med){
		this.lados =lad;
		this.medidaLado = med;
		String l = Integer.toString(lados);
		this.nombre = "poligono de "+l+" lados";
		this.apotema = ap;
	}

	double perimetro(){
		return (this.getLados()*this.getMedida());
	}

	double area(){
		double are;
		if (this.getLados()<5){
			are = Math.pow(this.getMedida(), 2); //pow es un metodo de math para sacar potencias
		}else{
			are = (this.perimetro()*this.getApotema())/2;
		}
		return are;
	}
}

class Ejercicio2{	
	public static void main(String[] args){
		Poligono p1 = new Poligono();
		Poligono p2 = new Poligono(12,5,4);
		Circulo c1 = new Circulo(14);

		double a1 = p1.area();
		double pp1 = p1.perimetro();

		double a2 = p2.area();
		double pp2 = p2.perimetro();

		double a3 = c1.area();
		double pp3 = c1.perimetro();

		System.out.println("el "+p1.getNombre()+" tiene "+a1+" cm^2 de area y "+pp1+" cm de perimetro");
		System.out.println("sus medidas iniciales son "+p1.getLados()+" lados de "+p1.getMedida()+" cm y "+p1.getApotema()+" cm de apotema");
		System.out.println("el poligono de "+p2.getLados()+" lados tiene "+a2+" cm^2 de area y "+pp2+" cm de perimetro");
		System.out.println("sus medidas iniciales son "+p2.getLados()+" lados de "+p2.getMedida()+" cm y "+p2.getApotema()+" cm de apotema");
		System.out.println("el circulo tiene "+a3+" cm^2 de area y "+pp3+" cm de perimetro ");
		System.out.println("su radio es de "+c1.getRadio()+" cm");
		System.out.println("");

	}
}
