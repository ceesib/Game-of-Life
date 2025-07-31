import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener{
    public int x, y, s, row, col;
    public static int screenRow= 48*8, screenCol = 48*13;
    public static int x_prime, y_prime;
    public static  boolean flag = false;
    public final int W= 31, H= 13;
    public static Map<String, Cell> cells = new HashMap<>();

    public GamePanel(){
        this.row = screenRow;
        this.col = screenCol;
        this.s = 20;
        this.setBounds(60, 48,screenCol-3,screenRow-3);
        this.setBackground(new Color(0x123456));
        x_prime = this.getWidth()+1;
        y_prime = this.getHeight()+1;
        this.addMouseListener(this);
        Population p = new Population();
    }
    public void drawGrid(Graphics g){
        g.setColor(Color.GREEN);
        this.setLayout(new FlowLayout());
        for(int i = 0; i<=row;i++){
            g.drawLine(x,y+i*s,x+s*col,y+i*s);  
        }
        for(int j = 0; j<=col;j++){
            g.drawLine(x+j*s,y,x+j*s,y+s*row);
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGrid(g);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        double gx = this.getWidth()/W;
        double gy = this.getWidth()/W;

        double x = e.getX()/gx;
        double y = e.getY()/gy;
       
        x = Math.floor(x);
        y = Math.floor(y);

        Integer x_ = (int) x;
        Integer y_ = (int) y;
        Integer[] p = {x_,y_};

        String key = x_+" "+y_;
        if(Population.population.containsKey(key)){
           // System.out.printf("cells contain {%s ,%s} \n",x_,y_);
            Cell cell = Population.population.get(key);
            this.remove(cell);
            this.repaint();
            Population.population.remove(key);
            Population.neighbour.remove(key);
            System.out.println(Population.neighbour);
            
        }
        else{
            Cell cell = new Cell(x_, y_, false);
            this.add(cell);
            this.repaint();
            cell.state = true;
            Population.population.put(key,cell);
            Population.createNeighbours();
        }
   

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.printf("x: %s y: %s \n",x,y);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}