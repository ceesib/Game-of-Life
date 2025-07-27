import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    public int x, y, s, row, col;
    public static int screenRow= 48*8 , screenCol = 48*13;
    public static int x_prime, y_prime;

    public GamePanel(){
        this.row = screenRow;
        this.col = screenCol;
        this.s = 20;
        this.setBounds(60, 48,screenCol,screenRow);
        this.setBackground(new Color(0x123456));
        x_prime = this.getWidth()+1;
        y_prime = this.getHeight()+1;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        this.setLayout(new FlowLayout());
        for(int i = 0; i<row;i++){
            g.drawLine(x,y+i*s,x+s*col,y+i*s);  
        }
        for(int j = 0; j<col;j++){
            g.drawLine(x+j*s,y,x+j*s,y+s*row);
        }
    }
}