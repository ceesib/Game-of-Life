
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Cell extends JPanel {
    public int x;
    public int y;
    public static final int CWIDTH = 20;
    public static final int CHEIGHT= 20;
    public boolean state;
    public Cell(int x,int y, boolean state){
        this.x = x;
        this.y = y;
        this.state = state;
        this.setSize(new Dimension(CWIDTH,CHEIGHT));
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;
        g2.setColor(Color.yellow.darker());
        g2.fillRect(1,1, 18, 18);
        this.setLocation(this.x*CWIDTH, this.y*CHEIGHT);
    }

    public Boolean getState(int x, int y){
        if(Population.population.containsKey(x+" "+y)) {
            Cell c = Population.population.get(x+" "+y);
            return c.state;
        }
        return false;
    } 

    @Override
    public String toString(){
        return "(y,x): "+"("+y+","+x+")"+ " with state: "+ state;  
    }

  
}