import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Population{
    private Map<String , Cell> population = GamePanel.cells;
    public static Set<String> neighbour = new HashSet<>();
    public Population(Map<String, Cell> population){
        this.population = population;
    }
    public void createNeighbours(){
        // check all 8 directions
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(Map.Entry<String,Cell> c: population.entrySet()){
            Cell cell = c.getValue();
            int newX = 0;
            int newY = 0;
            
            //System.out.printf("Checking neighbours for (%s,%s) \n",cell.x,cell.y);
            if(!neighbour.contains(cell.x+" " + cell.y)) neighbour.add(cell.x+" " + cell.y);
            for(int i = 0;i<d.length;i++){
                newX = cell.x+d[i][0];
                newY = cell.y+d[i][1];
                //System.out.printf("neighbour: (%s,%s) \n",newX,newY);
                if(newX>-1 && newX<31 && newY>-1 && newY<19){
                    String key = newX+" " + newY;
                    //System.out.printf("Valid neighbour: (%s,%s) \n",newX,newY);
                    if(!neighbour.contains(key)) neighbour.add(key);
                }
            }
        }
        System.out.println(neighbour);
    }

}