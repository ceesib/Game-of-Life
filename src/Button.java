import javax.swing.JButton;
import javax.swing.JPanel;
public abstract class Button{
    // handles action relative to button
    public JButton button;
    public JPanel buttonPanel;
    public String name;
    public Button(JButton button,JPanel buttonPanel,String name){
        this.button = button;
        this.buttonPanel = buttonPanel;
        this.name = name;
    }
    public void pressed(){
        this.button.addActionListener(s -> System.out.printf("%s pressed \n",this.name));
    }
    public abstract void addButtonToPanel();
}