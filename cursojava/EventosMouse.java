/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventosmouse;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Alumno
 */
public class EventosMouse extends JFrame{
    /**
     * @param args the command line arguments
     */
    private JPanel mousePanel;
    private JLabel barraEstado;
    
    public EventosMouse(){
        super("Demostrando eventos de mouse");
        mousePanel = new JPanel();
        mousePanel.setBackground(Color.RED);//color del panel //Color es una clase
        add(mousePanel,BorderLayout.CENTER ); //lo quiero en el centro
        
        barraEstado = new JLabel("Mouse fuera del JPanel");
        add(barraEstado, BorderLayout.SOUTH);
        
        MouseHandler manejador = new MouseHandler();
        mousePanel.addMouseListener(manejador);
        mousePanel.addMouseMotionListener(manejador);
    }
    
    private class MouseHandler implements MouseListener, MouseMotionListener{
        public void mouseClick(MouseEvent e){
            barraEstado.setText(String.format("Click en [%d, %d]", e.getX(), e.getY()));
        }
        @Override
        public void mousePressed(MouseEvent e){
            barraEstado.setText(String.format("Presionado en [%d, %d]", e.getX(), e.getY())); //con e.get podemos ver las coordenadas
        }
        @Override
        public void mouseReleased(MouseEvent e){
            barraEstado.setText(String.format("Soltado en [%d, %d]", e.getX(), e.getY())); //con e.get podemos ver las coordenadas
        }
        @Override
        public void mouseEntered(MouseEvent e){
            barraEstado.setBackground(Color.CYAN);
        }
        
        @Override
        public void mouseDragged(MouseEvent e){
            barraEstado.setText(String.format("Arrastrado en [%d, %d]", e.getX(), e.getY())); //con e.get podemos ver las coordenadas
        }
        @Override
        public void mouseMoved(MouseEvent e){
            barraEstado.setText(String.format("Movido en [%d, %d]", e.getX(), e.getY())); //con e.get podemos ver las coordenadas
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            barraEstado.setText(String.format("Salida")); //con e.get podemos ver las coordenadas

        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        EventosMouse eventos = new EventosMouse();
        eventos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventos.setSize(350,100);
        eventos.setVisible(true);
    }
    
}

