
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonManager {
    public JButton button;
    public JPanel buttonPanel;
    public GridBagConstraints gbc = new GridBagConstraints();
    public Window window;
    public static final int X = 48 * 5;
    public static final int  Y = 48 * 11;
    public int x,y;
    private final int WIDTH=17, HEIGHT=7;
    public String name;
    public int shift;

    public ButtonManager(JButton button, Window window, JPanel buttonPanel,String name){
        this.button = button;
        this.window = window;
        this.buttonPanel =buttonPanel;
        this.name = name;
        this.buttonPanel.setBounds(X, Y, WIDTH, HEIGHT);
    }
    public void createButton(int x,int y){
        this.buttonPanel.setLayout(new GridBagLayout());
        
        this.gbc.gridx =this.x;
        this.gbc.gridy =this.y;

        this.button.setText(this.name);
        this.button.setForeground(Color.WHITE);
        this.button.setFocusable(false);

        this.button.setFont(new Font("BISON",Font.PLAIN,13));
        this.button.setBounds(new Rectangle(WIDTH,HEIGHT));
        this.buttonPanel.add(this.button,gbc);
        System.out.printf("%s\n",this.gbc.gridheight);
        this.button.setBackground(new Color(0x123456));
        
        this.buttonPanel.setBackground(new Color(0x123456));
       
        this.window.frame.add(this.buttonPanel);
        
    }
    
}