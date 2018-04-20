/**@author prebe17
@version 1.1
*/

interface Automotriz{
	void avanzar(int metros);
	void reversa(int metros);
	void llenarTanque(int monto);
	void encender();	
}

class Auto implements Automotriz{

	Auto(){
		this.marca = "Cadillac" ;
		this.modelo = "CTS";
		this.anio = 2014;
		this.gasolina = 100;
	}

	Auto(String mar, String mod, int an){
		this.marca = mar;
		this.modelo = mod;
		this.anio = an;
		this.gasolina = 100;
	}

	protected final String marca;
	protected final String modelo;
	protected final int anio;
	public  int gasolina;
	protected boolean encendido = false;


	String getMarca (){
		return this.marca ;
	}

	String getModelo (){
		return this.modelo ;
	}

	int getAnio (){
		return this.anio ;
	}

	void setEncendido (){
		if (this.encendido){
			this.encendido = false ;
		}else{
			this.encendido = true;
		}
	}

	boolean getEncendido(){
		return this.encendido;
	}
	//no se definen set y get  de gasolina (porque es publico)
	// para ejemplificar el encapsulamiento 

	//@param monto - entero para suponer la regarga de combustible
	//@return	 	void
	

	public void llenarTanque(int monto){
		int gas = (int)(monto/20);
		this.gasolina+=gas;
		System.out.println("el auto "+this.getMarca()+" tiene "+this.gasolina+" litros ");
	}

	//@param  ()
	//@return void
	

	public void encender(){
		if(this.getEncendido()==true){
			System.out.println(" se ha apagado el auto ");
			this.setEncendido();
		}else if(this.gasolina == 0){
			System.out.println(" no tienes gasolina suficiente, pasa a cargar ");
		}else{
			System.out.println(" -ruido de motor- ");
			this.setEncendido();
		}
	}


	//@param metros - entero -  cantidad de metros a avanzar
	//@return
	public void avanzar(int metros){
		if (this.getEncendido() == false){
			System.out.println("primero debes encender el auto ");
		}else if (this.gasolina < 15 ){
			System.out.println(" pasa a cargar gasolina ");
		}else  if(this.getMarca()==  " Cadillac " &&  metros > 200){
			System.out.println(" te ha parado la patrulla, el auto fue reportado como robado y tienes aliento alcoholico, te espera una larga sentencia  ");
		}else{
			int gasto =  (int)(metros/200);
			this.gasolina-= gasto;
			System.out.println(" has avanzado  "+metros+" metros");
			if (this.gasolina <= 0){ 
				System.out.println(" el tanque esta vacio y no puedes avanzar, estas estorbando a media calle");
				this.gasolina = 0;
				this.setEncendido();
			}
		}
	}

	public void reversa(int metros){
		if (this.getEncendido() == false){
			System.out.println("primero debes encender el auto");
		}else{
			int gasto =  (int)(metros/200);
			this.gasolina-= gasto;
			System.out.println("has avanzado  "+metros+" metros en reversa");
			if(metros > 30){
				System.out.println("has chocado alv, llama a tu agente de seguros");
				this.setEncendido();
			}
			if (this.gasolina <= 0){ 
				System.out.println("el tanque esta vacio y no puedes avanzar, estas estorbando a media calle");
				this.gasolina = 0;
				this.setEncendido();
			}
		}
	}
}

class Ejercicio1{	
	public static void main(String[] args){
		Auto a1 = new Auto();
		Auto a2 = new Auto("Ford", "Lobo", 2010);

		a1.avanzar(10);
		a2.reversa(10);

		a1.encender();
		a2.encender();

		a1.llenarTanque(1000);
		a2.llenarTanque(2000);

		a1.avanzar(100);
		a2.reversa (25);

		a1.avanzar(150);
		a2.reversa(35);

		a1.avanzar(3000);
		a2.encender();
		a2.avanzar(20000);


	}
}

/* esta clase manda el error 

Error: no se ha encontrado o cargado la clase principal ejercicio1

y no encuentro el motivo, si lo encuentras podrias avisarme para no seguir
cometiendo el mismo error en mis programas?*/
