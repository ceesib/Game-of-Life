import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JPanel;


public class StartButton extends Button{
    public Window window ;
    public JButton sb;
    public GridBagConstraints gbc;
    
    public StartButton(JButton button,String name,JPanel buttonPanel,Window window, GridBagConstraints gbc){
        super(button, buttonPanel, name);
        this.window = window;
        this.gbc = gbc;
        ButtonManager startButton = new ButtonManager(super.button, this.window, super.name);
        this.sb = startButton.createButton();
        pressed();
    }
    @Override
    public void pressed(){
        this.button.addActionListener(s -> System.out.printf("%s pressed \n",super.name));
    }
    @Override
    public void addButtonToPanel(){
        this.gbc.fill  = GridBagConstraints.HORIZONTAL;
        this.gbc.weightx = 3;
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;

        this.buttonPanel.add(this.sb,this.gbc);
    }
    

}