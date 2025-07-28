
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Cell extends JPanel {
    public int x,y;
    public static final int CWIDTH = 20;
    public static final int CHEIGHT= 20;
    public Cell(int x,int y){
        this.x = x;
        this.y = y;
        this.setSize(new Dimension(CWIDTH,CHEIGHT));
        
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics g2 = (Graphics2D) g;
        g2.setColor(Color.CYAN);
        g2.fillRect(0, 0, CWIDTH, CHEIGHT);
        //
        this.setLocation(this.x*20, this.y*20);
        this.setLayout(null);
        System.out.printf("x: %s y: %s \n",this.x,this.y);
    }

  
}