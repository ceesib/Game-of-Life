
import java.util.concurrent.TimeUnit;

public class GameThread implements Runnable{
    @Override
    public void run(){
        while(!Population.population.isEmpty()){
            Population.nextGeneration();
            try {
                 TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        }
    }


}