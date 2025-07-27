import javax.swing.JButton;
import javax.swing.JPanel;
public class ResetButton extends Button{
    public Window window ;
    public JPanel buttonPanel;
    public ResetButton(JButton button,String name,Window window, JPanel buttonPanel){
        super(button,name);
        this.window = window;
        this.buttonPanel = buttonPanel;
        ButtonManager resetButton = new ButtonManager(super.button, this.window, this.buttonPanel, super.name);
        resetButton.createButton(0,1);
        pressed();
    }
    @Override
    public void pressed(){
        this.button.addActionListener(s -> System.out.printf("%s pressed \n",super.name));
    }
    

}