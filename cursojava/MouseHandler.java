import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class EventosMouse extends JFrame{
	private JPanel mousePanel;
	private JLabel barraEstado;

	EventosMouse(){
		super("mostrando eventos del mouse");
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);

		barraEstado = new JLabel("Mouse fuera del jpanel ");
		add(barraEstado, BorderLayout.SOUTH);
	
		MouseHandler manejador = new MouseHandler();
		mousePanel.addListener(manejador);
		mousePanel.addMouseListenerMotionListener(manejador);


	}
}


 class	MouseHandler implements MouseListener, MouseMotionListener{

	@Override
	public void mouseClicked(MouseEvent e){
		barraEstado.setText(String.format("click en %d,%d ",e.getX(),e.getY()));
	}
	

	@Override 
	public void mousePressed(MouseEvent e){
			barraEstado.setText(String.format("presionando en %d,%d ",e.getX(),e.getY()));
	}

	@Override 	
	public void mouseReleased(MouseEvent e){
			barraEstado.setText(String.format("soltado "));
		}
	@Override 	
	public void mouseEntered(MouseEvent e){
			barraEstado.setBackground(Color.CYAN);
		}


	@Override 	
	public void mouseDragged(MouseEvent e){
		barraEstado.setText(String.format("arrastrado en %d,%d ",e.getX(),e.getY()));
		}

		@Override 	
	public void mouseMoved(MouseEvent e){
		barraEstado.setText(String.format("moviendolo en %d,%d ",e.getX(),e.getY()));
		}


		@Override 	
	public void mouseExcited(MouseEvent e){
		barraEstado.setText(String.format("fuera de ventana ",e.getX(),e.getY()));
		}

		public static void main(String[] args) {
		EventosMouse eventos = new EventosMouse();
		eventos.setDefautlCloseOperaton(JFrame.EXIT_ON_CLOSE);
		eventos.setSize(600,600);
		eventos.setVisible(true);
	}

}