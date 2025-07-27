import javax.swing.JButton;
import javax.swing.JPanel;
public class StopButton extends Button{
    public Window window ;
    public JPanel buttonPanel;
    public StopButton(JButton button,String name,Window window, JPanel buttonPanel){
        super(button,name);
        this.window = window;
        this.buttonPanel = buttonPanel;
        ButtonManager startButton = new ButtonManager(super.button, this.window, this.buttonPanel, super.name);
        startButton.createButton();
    }
    @Override
    public void pressed(){
        this.button.addActionListener(s -> System.out.printf("%s pressed \n",super.name));
    }
    

}