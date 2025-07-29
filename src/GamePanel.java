import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener{
    public int x, y, s, row, col;
    public static int screenRow= 48*8, screenCol = 48*13;
    public static int x_prime, y_prime;
    public static  boolean flag = false;
    public final int W= 31, H= 13;
    public Graphics2D g_object;
    public GamePanel(){
        this.row = screenRow;
        this.col = screenCol;
        this.s = 20;
        this.setBounds(60, 48,screenCol-3,screenRow-3);
        this.setBackground(new Color(0x123456));
        x_prime = this.getWidth()+1;
        y_prime = this.getHeight()+1;
        this.addMouseListener(this);
    }
    public void setGraphics(Graphics2D g){
        this.g_object = g;
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
    // public void paintCell(Graphics2D g, Cell cell){
    //     System.out.println("Trying to paint a yellow square");
    //     g.setColor(Color.YELLOW);
    //     g.fillRect(0,0, Cell.WIDTH,Cell.HEIGHT);

    // }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawGrid(g);
        Graphics2D g2 = (Graphics2D) g;
        setGraphics(g2);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        double gx = this.getWidth()/W;
        double gy = this.getWidth()/W;

        double x = e.getX()/gx;
        double y = e.getY()/gy;

        System.out.printf("x: %s y: %s gx: %s gy: %s \n",x,y,gx,gy);
       
        x = Math.floor(x);
        y = Math.floor(y);

        Cell cell = new Cell((int)x,(int)y);
        this.add(cell);
        cell.repaint();
      
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