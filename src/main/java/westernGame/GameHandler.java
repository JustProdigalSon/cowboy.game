package westernGame;
import java.util.ArrayList;
import java.util.Random;


public class GameHandler {
    public int randomInRange(int low, int high){
        Random random = new Random();
        return random.nextInt(high + 1 - low) + low;
    }
    public String displayPlayerInfo(int currentPlayerQueueId){
        return "PlaceHolder";
    }



    public void startGame(){
    }

    public void gamePlay() {
    }
}
