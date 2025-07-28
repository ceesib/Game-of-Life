import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
public class ButtonManager {
    public JButton button;
    public JPanel buttonPanel;

    public Window window;
    public static final int Y= 48 * 5;
    public static final int  X = 3;
    public String name;

    public ButtonManager(JButton button, Window window,String name){
        this.button = button;
        this.window = window;
        this.name = name;
    }
    public JButton createButton(){
        
        this.button.setText(this.name);
        this.button.setForeground(Color.WHITE);
        this.button.setFocusable(false);

        this.button.setFont(new Font("BISON",Font.PLAIN,13));
        
        this.button.setBackground(Color.green);

        return this.button;
        
    }
    
}