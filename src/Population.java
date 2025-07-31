import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Population{
    public  static Map<String , Cell> population;
    public static  Map<String,Queue<Cell>> neighbour;
    public static Map<String,Boolean> cellState ;
    public Population(){
        population = new HashMap<>();
        neighbour = new HashMap<>();
        cellState = new HashMap<>();
    }
    public static void createNeighbours(){
        // check all 8 directions
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
       
        for(Map.Entry<String,Cell> c: population.entrySet()){
            Queue<Cell> q = new LinkedList<>();
            Cell cell = c.getValue();
            int newX = 0,newY = 0;
            String key = cell.x+" " + cell.y;
            if(!neighbour.containsKey(key)){
                q.offer(cell);
                //System.out.println(cell.toString());
                for(int i = 0;i<d.length;i++){
                    newX = cell.x+d[i][0];
                    newY = cell.y+d[i][1];
                    if(newX>-1 && newX<31 && newY>-1 && newY<19){
                        String xy = newX+" " + newY;
                        if(!population.containsKey(xy)){
                            Cell newCell = new Cell(newX, newY, false);
                            q.offer(newCell);
                        }
                        else {
                            Cell newCell = population.get(xy);
                            q.offer(newCell);
                        }
                    }
                }
                neighbour.put(key,  q);
            }
        }
    }

    public static void nextGen(){
        for(Map.Entry<String,Queue<Cell>> q: neighbour.entrySet()){
            Queue<Cell> temp = q.getValue();
            while(!temp.isEmpty()){
                Cell cell = temp.poll();
                int neighbour_count = countNeighbours(cell);
                System.out.printf("neighbour count: %s for cell(%s,%s) \n",neighbour_count, cell.y, cell.x);
            }
        }
    }
    public static  Integer countNeighbours(Cell cell){
        int count = 0;
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i = 0;i<d.length;i++){
            int newX = cell.x+d[i][0],newY = cell.y+d[i][1];
            if(newX>-1 && newX<31 && newY>-1 && newY<19) if(cell.getState(newX, newY)) count++;
        }
        return count;
    }
  

}