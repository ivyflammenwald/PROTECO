import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Lienzo extends JPanel{
	@override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d =(Graphics2D)g;
		g2d.drawString("ppcsalvc",10,20);
	}
}