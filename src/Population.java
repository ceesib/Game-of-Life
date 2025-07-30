import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Population{
    public  static Map<String , Cell> population;
    public static  Map<String,Queue<String>> neighbour;
    public Population(){
        population = new HashMap<>();
        neighbour = new HashMap<>();
    }
    public static void createNeighbours(){
        // check all 8 directions
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
       
        for(Map.Entry<String,Cell> c: population.entrySet()){
            Queue<String> q = new LinkedList<>();
            Cell cell = c.getValue();
            int newX = 0;
            int newY = 0;
            String key = cell.x+" " + cell.y;

            q.offer(Arrays.toString(new Integer[]{cell.x,cell.y}));
            for(int i = 0;i<d.length;i++){
                newX = cell.x+d[i][0];
                newY = cell.y+d[i][1];
                if(newX>-1 && newX<31 && newY>-1 && newY<19){
                    q.offer(Arrays.toString(new Integer[]{newX,newY}));
                    //if(!neighbour.contains(key)) neighbour.add(key);
                }
            }
            neighbour.put(key,  q);
        }
        //System.out.println(population);
        System.out.println(neighbour);
    }

}