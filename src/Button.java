import javax.swing.JButton;
public class Button{
    // handles action relative to button
    public JButton button;
    public String name;
    public Button(JButton button,String name){
        this.button = button;
        this.name = name;
    }
    public void pressed(){
        this.button.addActionListener(s -> System.out.printf("%s pressed \n",this.name));

    }
}