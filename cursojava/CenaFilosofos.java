import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.Random;

class Filosofo extends Thread{
	
	int nombre;		//se usa el nombre para determinar el indice de los palillos que ocupan
	Filosofo derecha;// los palillos para comer se identificaran mediante un indice
	Filosofo izquierda;
	Semaphore[] sempalillos;
	int[][] palillos;
	int pizquierdo;
	int pderecho;
	Random tardar;
	boolean terminado;

	Filosofo(int nombre, Semaphore[] sempalillos, int[][] palillos){
	this.nombre = nombre+1;
	this.tardar = new Random();
	this.sempalillos = sempalillos;
	this.palillos = palillos;
	this.pizquierdo = palillos[nombre][0];
	this.pderecho = palillos[nombre][1];
	this.terminado = false;
	}

	void comer() {
		if(sempalillos[pizquierdo].tryAcquire()) { //toma el control de los palillos con tryAcquire
			if(sempalillos[pderecho].tryAcquire()) {
				System.out.println("filosofo "+this.nombre+ " COMIENDO");
				try
				{
					Thread.sleep(tardar.nextInt(500) + 800);
				} 
				catch(InterruptedException e) {
					System.out.println("ocurrio un error ");
					e.printStackTrace();
				}
				System.out.println("filosofo "+this.nombre+ " termino de comer");
				System.out.println("palillos "+this.pizquierdo+" y "+this.pderecho+"disponibles");
				sempalillos[pderecho].release();//libera los palillos con release
				this.terminado = true;
			}
			sempalillos[pizquierdo].release();
		}else{
			System.out.println("filosofo "+this.nombre+" hambriento");
		}
	}


	void pensar() {
		System.out.println("filosofo "+this.nombre+" pensando");
		try
		{
			Thread.sleep(tardar.nextInt(300) + 110);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(!this.terminado){
			pensar();
			comer();
		}
	}

}

class CenaFilosofos{
	public static void main(String[] args) {
		System.out.println("Cena de los filosofos,\nel programa termina cuando todos acaben de comer\n\n ");
		int asistentes = 5;
		Semaphore[] semaforopalillos = new Semaphore[asistentes];
		ArrayList <Filosofo> filosofos = new ArrayList <Filosofo>();
		int[][] palillos = {
			{0,4}, //el primer filosofo tiene el ultimo palillo a la izquierda y el primero a la derecha
			{1,0},
			{2,1},
			{3,2},
			{4,3}, //el ultimo filosofo tiene el penultimo palillo a la izquierda y el ultimo a la derecha 
		};

		
		try{
			for(int i =0; i<asistentes; i++){
				semaforopalillos[i]= new Semaphore(1); //se crea el semaforo para cad a
			}
			for (int i = 0; i < 5; i++){
				filosofos.add(new Filosofo(i,semaforopalillos, palillos));
			}
			for (Filosofo f : filosofos){
				f.start();
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
}


/* para solucionar este problema se asigna el turno de comida al filosofo
que tarde menos tiempo en pensar si comer o no, usando un random int se
decide que filosofo empieza y de alli continua el ciclo conforme los
palillos sean liberados. para los palillos se implementan los metodos
de semaphore tryAcquire() para tomar el recurso y release para liberarlo.
la ejecucion de cada hilo filosofo se realiza hasta que termine de comer*/