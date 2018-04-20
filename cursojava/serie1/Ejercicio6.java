/**@author prebe17
@version 1.1
*/

class Carro{

	double peso;
	double altura;
	boolean encendido = false;

	Carro(){
		this.peso=5500.25;
		this.altura= 2.3;
	}

	Carro(double peso, double altura){
		this.peso = peso;
		this.altura = altura;
	}

	double getPeso (){
		return this.peso ;
	}

	void setPeso(double p){
		this.peso=p;
	}

	double getAltura (){
		return this.altura ;
	}

	void setAltura(double p){
		this.altura=p;
	}

	boolean getEncendido(){
		return this.encendido;
	}

	void encender (){
		if (this.encendido){
			System.out.println("el auto ya estaba encendido");
		}else{
			System.out.println("Se ha encendido el automovil");
			this.encendido = true;
		}
	}

	void apagar(){
		if (this.encendido ==false){
			System.out.println("el auto ya estaba apagado");
		}else{
			System.out.println("Se ha apagado el automovil");
			this.encendido = false;
		}
	}

	void estado(){
		boolean turned = this.getEncendido();
		if (turned){
			System.out.println("el automovil se encuentra encendido");
		}else{
			System.out.println("el automovil se encuentra apagado");
		}
	}

	public String toString(){
		return String.format("el peso es: %.2f y la altura: %.2f",this.getPeso(),this.getAltura());
	}	
}

class Benz extends Carro{
	String modelo;

	Benz(){
		super(3800.75, 1.8);
		this.modelo="Benz Truck";
	}

	Benz(String modelo, double peso, double altura){
		super(peso, altura);
		this.modelo = modelo;
	}

	String getModelo(){
		return this.modelo;
	}

	void setModelo(String s){
		this.modelo = s;
	}

	void estado(){
		System.out.println("El modelo "+this.getModelo());
		super.estado();
	}

	public String toString(){
		return String.format("el modelo es "+this.getModelo()+" el peso es: %.2f kg y la altura: %.2f m",this.getPeso(),this.getAltura());
	}	

}

class Volkswagen extends Carro{
	String modelo;

	Volkswagen(){
		super(4200.2, 1.4);
		this.modelo="2010";
	}

	Volkswagen(String modelo, double peso, double altura){
		super(peso, altura);
		this.modelo = modelo;
	}

	String getModelo(){
		return this.modelo;
	}

	void setModelo(String s){
		this.modelo = s;
	}

	void estado(){
		System.out.println("El modelo "+this.getModelo());
		super.estado();
	}

	public String toString(){
		return String.format("el modelo es "+this.getModelo()+" el peso es: %.2f kg y la altura: %.2f m",this.getPeso(),this.getAltura());
	}	
}

class Ejercicio6{	
	public static void main(String[] args){

		Benz b1 = new Benz();
		Volkswagen v1 = new Volkswagen("2014",8560.60,2.4);

		System.out.println("la altura de los autos es: el Benz: "+b1.getAltura()+" el Volkswagen "+v1.getAltura()+" metros ");
		System.out.println("el peso de los autos es: el Benz: "+b1.getPeso()+" el Volkswagen "+v1.getPeso()+" kg ");
		
		double pesonuevo=b1.getPeso()+1340.80;
		b1.setPeso(pesonuevo);
		pesonuevo=v1.getPeso()+1340.80;
		v1.setPeso(pesonuevo);

		b1.encender();
		b1.encender();
		b1.estado();

		System.out.println("haz blindado tus autos, por lo que ahora pesan: el Benz: "+b1.getPeso()+" el Volkswagen "+v1.getPeso()+" kg ");
		System.out.println(v1);
		System.out.println(b1);
		v1.encender();
		b1.apagar();
		System.out.println(b1);
		System.out.println(v1);
		
	}
}