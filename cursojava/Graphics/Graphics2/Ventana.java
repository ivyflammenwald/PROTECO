import javax.swing.JPanel;
import javax.swing.JFrame;


class Ventana extends JFrame{

	public Ventana(){
		super("lineas");

		Lienzo lienzo = new Lienzo();
		this.add(lienzo);

		setSize(350,250);
		setDefaultCloseOperation(EXIT ON CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ventana();
	}
}