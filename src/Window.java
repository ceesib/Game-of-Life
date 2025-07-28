
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window{
    public static final int HEIGHT = 48 * 16;
    public static final int  WIDTH = 48 * 13;
    public final int BUTTONHEIGHT = 10, BUTTONWIDTH = 8;
    public JFrame frame;
    public JLabel name;

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
        bp.setBounds(60, GamePanel.y_prime, GamePanel.screenCol-ButtonManager.X,GamePanel.screenRow-ButtonManager.Y);
        // Border b = BorderFactory.createLineBorder(Color.WHITE);
        // bp.setBorder(b);
        bp.setBackground(new Color(0x123456));
        bp.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
                
        StartButton sb = new StartButton(new JButton(),"Start",bp, this,gbc);
        sb.addButtonToPanel();
        PauseButton pb = new PauseButton(new JButton(), "Pause", bp,this, gbc);
        pb.addButtonToPanel();
        ResetButton rb = new ResetButton(new JButton(), "Reset", bp,this, gbc);
        rb.addButtonToPanel();

        this.frame.add(bp);
        this.frame.setVisible(true);

    }
    
}