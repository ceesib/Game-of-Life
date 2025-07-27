
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Window{
    public static final int HEIGHT = 48 * 16;
    public static final int  WIDTH = 48 * 13;
    public final int BUTTONHEIGHT = 10, BUTTONWIDTH = 8;
    public JFrame frame;
    public JLabel name;
    public Grid grid  = new Grid(this);
    public GamePanel gamePanel = new GamePanel();

    public Window(JFrame frame){
        this.frame =frame;
    }
    public void createWindow(int HEIGHT,int WIDTH){
        this.frame.setTitle("Game Of Life");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setLayout(null);

        this.frame.getContentPane().setBackground(new Color(0x123456));
        this.frame.setSize(new Dimension(HEIGHT,WIDTH));
     
        this.frame.setLocationRelativeTo(null);  

        name = new JLabel("Game of Life");
   

        name.setForeground(Color.GREEN);

        name.setFont(new Font("MV Boli",Font.PLAIN,30));
        name.setVerticalAlignment(JLabel.TOP);
        
        JPanel header = new JPanel();
        header.setBounds(0, 0, 48*16,48 );
        header.setBackground(new Color(0x123456));
        header.add(name);
        this.frame.add(header);
        this.frame.add(this.gamePanel);
        JPanel bp = new JPanel();
        
        bp.setBounds(this.gamePanel.getWidth()+1,this.gamePanel.getHeight()+1,this.gamePanel.screenCol,this.gamePanel.screenRow);
        Border b = BorderFactory.createLineBorder(Color.WHITE);
        bp.setBorder(b);
        //bp.setLayout(null);
        
        JButton s = new JButton();
        JButton p = new JButton();
        JButton r = new JButton();
                
        StartButton sb = new StartButton(s,"Start", this,bp );
        PauseButton pb = new PauseButton(p, "Pause", this, bp);
        ResetButton rb = new ResetButton(r, "Reset", this, bp);

           
        this.frame.setVisible(true);

    }
    
}