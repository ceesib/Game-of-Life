import java.util.*;
public class Game{
    public static Map<String, Boolean> cellState;
    public Game(){
        cellState = new HashMap<>();
    }
    public static void nextState(Cell cell,int neighbour_count){
        if(neighbour_count <2 && cell.state) cellState. put(cell.y+" "+cell.x, false);
        else if(neighbour_count>1 && neighbour_count<4 && cell.state) cellState. put(cell.y+" "+cell.x, true);
        else if (neighbour_count==3 && !cell.state) cellState. put(cell.y+" "+cell.x, true);
        else if (neighbour_count>3 && cell.state) cellState. put(cell.y+" "+cell.x, false);
        else cellState.put(cell.y+" "+cell.x, false);
       // System.out.println("("+cell.y+","+cell.x+") with futureState: "+cellState.get(cell));
    }
   
}