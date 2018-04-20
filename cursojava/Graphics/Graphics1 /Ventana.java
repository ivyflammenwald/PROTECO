import javax.swing.JPanel;
import javax.swing.JFrame;


class Ventana extends JFrame{

	public Ventana(){
		super("hola mundo java 2d");

		Lienzo lienzo = new Lienzo();
		this.add(lienzo);

		setSize(100,200);
		setDefaultCloseOperation(EXIT ON CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ventana();
	}
}