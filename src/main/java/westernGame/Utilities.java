package westernGame;

import java.util.Random;

public class Utilities {
    public int randomInRange(int low, int high){
        Random random = new Random();
        return random.nextInt(high + 1 - low) + low;
    }
    public String displayPlayerInfo(int currentPlayerQueueId){
        return "PlaceHolder";
    }
}
