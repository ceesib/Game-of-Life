import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ResetButton extends Button{
    public Window window ;
    public JButton rb;
    public GridBagConstraints gbc;
    
    public ResetButton(JButton button,String name,JPanel buttonPanel,Window window, GridBagConstraints gbc){
        super(button, buttonPanel, name);
        this.window = window;
        this.gbc = gbc;
        ButtonManager resetButton = new ButtonManager(super.button, this.window, super.name);
        this.rb = resetButton.createButton();
        pressed();
    }
    @Override
    public void pressed(){
        this.button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
            Population.reset();
            }
        });
    }
    @Override
    public void addButtonToPanel(){
        this.gbc.fill  = GridBagConstraints.HORIZONTAL;
        this.gbc.weightx = 3;
        this.gbc.gridx = 3;
        this.gbc.gridy = 0;
        this.buttonPanel.add(this.rb,this.gbc);
    }
    

}