import java.awt.*;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.event.*;

public class Lienzo extends JComponent implements Runnable{

	HashMap<String, Point> palabras;
	ArrayList <String> lista = new ArrayList<String>();
	String palabraUsuario;
	int score;
	
	public void Lienzo(){
		setPreferredSize(new Dimension(800, 600));
		palabras = new HashMap <String,Point>();
		palabraUsuario = "";
		setFocusable(true); //el componente podra estar en primer plano
		requestFocus(); //coloca el componente en primer plano
		llenarLista();
		Collections.shuffle(lista);

		addKeyListener(new KeyAdapter(){
			//@Override 
			public void KeyPressed(KeyEvent e){
				switch(e.getKeyCode()){
					case KeyEvent.VK_ENTER:
						break;
					default:
						palabraUsuario+=e.getKeyChar();
				}
			}
		});
	}

	private void llenarLista(){
		lista.add("hola");
		lista.add("teclado");
		lista.add("hola");
		lista.add("palabra");
		lista.add("prro");
		lista.add("java");
	}

	private void compararPalabra(){
		if(palabras.containsKey(palabraUsuario)){
			score++;
			palabras.remove(palabraUsuario);
		}
		palabraUsuario = "";
	}

	private void agregarPalabraMapa(){
		if(lista.size()>0){
			String s = lista.get(0);
			lista.remove(0);
			int x = new Random().nextInt(600);
			palabras.put(s, new Point(x,0));
		}
	}

	//@Override
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawString("SCORE : "+score,10,10);
		for(String s : palabras.keySet()){
			g2d.setColor(Color.blue);
			g2d.fillRect(palabras.get(s).x,palabras.get(s).y,s.length()*20,40);
			g2d.setColor(Color.white);
			Font f = new Font("Helvetica", Font.PLAIN, 24);
			g2d.setFont(f);
			g2d.drawString(s,palabras.get(s).x+20, palabras.get(s).y+20);
		}
	}
	//@Override
	public void run(){
		long referencia  = new Date().getTime();
		while(true){
			for(String s : palabras.keySet()){
				palabras.get(s).y+=2;
			}

			if(new Date().getTime()-referencia >= 1500){
				agregarPalabraMapa();
				referencia = new Date().getTime();
			}
			repaint();
			try{
				Thread.sleep(40);
			}catch(InterruptedException e){}
		}
	}
	
}