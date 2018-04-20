import javax.swing.JFrame;


class Ventana extends JFrame{

	public Ventana(){
		super("juego");

		setSize(350,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		Lienzo lienzo = new Lienzo();
		this.add(lienzo);
		Thread t = new Thread (lienzo);
		t.start();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ventana();
	}
}