/*
class Hilo extends Thread{

	public Hilo(String nombre){
			super(nombre);
	}

	public void run(){
		for(int i=0; i<5; i++){
			System.out.println("iteracion "+i+" de "+getName());
		}		
		System.out.println("fin");
	}

	public static void main(String[] args){
		Hilo h = new Hilo("nombre");https://docs.google.com/document/d/1gbzt58KnSmB8fgfTGyrC2yuo6RMSZJ6wxQLSZDwdg6M/edit
		Hilo h1 = new Hilo("nombre");
		h.run();
		h1.run();
	}
}

*/

class RunnablePrebe implements Runnable{

	String r;
	RunnablePrebe(String r){
		this.r=r;
	}

	public void run(){
		for(int i=0; i<5; i++){
			System.out.println("iteracion "+i+" de "+this.r);
		}		
		System.out.println("fin");
	}



	public static void main (String[] args){
		new Thread(new RunnablePrebe("name")).start();
		Thread t = new Thread();
		t.start();
		t.sleep(50000);

	}
}