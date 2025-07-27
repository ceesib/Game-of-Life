import javax.swing.JButton;
import javax.swing.JPanel;
public class PauseButton extends Button{
    public Window window ;
    public JPanel buttonPanel;
    public PauseButton(JButton button,String name,Window window, JPanel buttonPanel){
        super(button,name);
        this.window = window;
        this.buttonPanel = buttonPanel;
        ButtonManager pauseButton = new ButtonManager(super.button, this.window, this.buttonPanel, super.name);
        pauseButton.createButton(1,0);
        pressed();
    }
    @Override
    public void pressed(){
        this.button.addActionListener(s -> System.out.printf("%s pressed \n",super.name));
    }
    

}