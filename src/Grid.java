import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid{
    public int row= 48*12 , col = 48*16;
    public Window window;
    public JPanel grid = new JPanel();
    public JButton start, pause, reset, change_grid_size;
    public Grid(Window window){
        this.window = window;
    }
    public Grid(Window window, int row, int col){
        this.window = window;
        this.row = row;
        this.col = col;
    }
    public void createGrid(){
        this.grid.setBounds(0, 48,col, row);
        this.grid.setBackground(new Color(0x123456));
        this.grid.setLayout(null);

        start = new JButton("start");
        
        // start.setBounds(JLabel.BOTTOM,JLabel.BOTTOM,10,15);
        start.setBackground(Color.CYAN);
        start.setFocusable(false);
        
        // start.setLayout(null);
        start.addActionListener(s -> System.out.println("start button has been pressed"));
        start.setBounds(48, row-96, 70, 30);
        
        pause = new JButton("pause");
        pause.setBackground(Color.CYAN);
        pause.setFocusable(false);
        pause.addActionListener(s -> System.out.println("pause button has been pressed"));
        pause.setBounds(48, row-96, 70, 30);
        //pause.setLayout(null);

        reset = new JButton("reset");
        reset.setBackground(Color.CYAN);
        reset.setFocusable(false);
        reset.addActionListener(s -> System.out.println("reset button has been pressed"));
        reset.setBounds(48, row-9, 70, 30);
        //reset.setLayout(new FlowLayout());
        // change can take input rather than using a button

        
        this.grid.add(start);
        this.grid.add(pause);
        this.grid.add(reset);
        
        this.window.frame.add(grid);

    }
}