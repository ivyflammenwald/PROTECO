import java.awt.FlowLayout;
import 

class Eventos extends JFrame{
	J Button boton;
	JLabel etiqueta;
	JPanel panel;
	int contador=0;


	public Eventos(){
		panel=new JPanel();
		boton = new JButton("Presiona");
		etiqueta=new JLabel();
	}

	private void agregarElementos(){
		boton.addActionListener(new ActionListener()){
			@Override 
			public void actionPerformed(ActionEvent e){
				contador++;
				etiqueta.setText(""+contador);
			}
		});
		panel.add(boton);
		panel.add(etiqueta);
		agregarElementos();
		crearVentana();
	}

	public void crearVentana(){
		setLayout(new FlowLayout());
		add(panel);
		setVisible(true);
		setSize(600, 600); //x, y, pixeles
		setResizable(true);
		setLocation(300,300);//donde va a aparecer
		setDefaultCloseOperation(JFrame, EXIT ON CLOSE);
	}

	public static void main(String[] args) {
		new Eventos();
	}

}