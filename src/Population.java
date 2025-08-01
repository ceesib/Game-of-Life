import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Population{
    public  static Map<String , Cell> population;
    public static  Map<String,Queue<Cell>> neighbour;
    public static GamePanel gamePanel;
    public Population(GamePanel gp){
        gamePanel = gp;
        population = new HashMap<>();
        neighbour = new HashMap<>();
        Game game =new Game();
        
    }
    public static void createNeighbours(){
        // check all 8 directions
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
       
        for(Map.Entry<String,Cell> c: population.entrySet()){
            Queue<Cell> q = new LinkedList<>();
            Cell cell = c.getValue();
            String key = cell.y+" "+ cell.x;
            if(!neighbour.containsKey(key)){
                q.offer(cell);
                for(int i = 0;i<d.length;i++){
                    int newX = cell.x+d[i][0];
                    int newY = cell.y+d[i][1];
                    if(newX>-1 && newX<31 && newY>-1 && newY<19){
                        String xy = newY+" "+newX;
                        //System.out.println("xy: "+ xy);
                        if(!population.containsKey(xy)){
                            Cell newCell = new Cell(newY, newX, false);
                            q.offer(newCell);
                        }
                        else {
                            //System.out.println("cell found: "+ xy);
                            Cell newCell = population.get(xy);
                            q.offer(newCell);
                        }
                    }
                }
                neighbour.put(key,  q);
            }
        }
    }

    public static void nextGeneration(){
        for(Map.Entry<String,Queue<Cell>> q: neighbour.entrySet()){
            Queue<Cell> temp = q.getValue();
            while(!temp.isEmpty()){
                Cell cell = temp.poll();
                int neighbour_count = countNeighbours(cell);
                if(!Game.cellState.containsKey(cell.y+" "+ cell.x)) Game.nextState(cell, neighbour_count);
                
                
            }
        }
        System.out.println(Game.cellState);
        updateGeneration();
    }

    private static  Integer countNeighbours(Cell cell){
        int count = 0;
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};

        for(int i = 0;i<d.length;i++){
            int newX = cell.x+d[i][0],newY = cell.y+d[i][1];
            if(newX>-1 && newX<31 && newY>-1 && newY<19) if(cell.getState(newY, newX)) count++;
        }
        System.out.printf("neighbour count: %s for cell(%s,%s) with state: %s \n",count, cell.y, cell.x, cell.state);
        return count;
    }
    public static void updateGeneration(){
        for(Map.Entry<String, Boolean> cell_state: Game.cellState.entrySet()){
            if(population.containsKey(cell_state.getKey())) {
                Cell cell = population.get(cell_state.getKey());
                if(cell.state!=cell_state.getValue()){
                    if(cell.state){
                        cell.state = false;
                        population.remove(cell_state.getKey());
                        Game.cellState.put(cell_state.getKey(),false);
                        //neighbour.clear();
                 
                        gamePanel.remove(cell);
                        gamePanel.repaint();

             
                        //System.out.println(neighbour);
                    }
                }

            }
            else{
                if(cell_state.getValue()) {
                    String[] yx = cell_state.getKey().split(" ");
                    Cell cell = new Cell(Integer.parseInt(yx[0]), Integer.parseInt(yx[1]), true);
                    population.put(cell_state.getKey(), cell);
                    //Game.cellState.put(cell_state.getKey(), cell.state);
                    gamePanel.add(cell);
                    gamePanel.repaint();
                }

            }
            //neighbour.clear();
            createNeighbours();
        }
        //System.out.println(population);
        //System.out.println(Game.cellState);

    }
  

}