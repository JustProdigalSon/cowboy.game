package westernGame;

import java.util.ArrayList;
import java.util.Random;

public class Utilities {
    public int randomInRange(int low, int high){
        Random random = new Random();
        return random.nextInt(high + 1 - low) + low;
    }
    public String displayPlayerInfo(int currentPlayerQueueId){
        return "PlaceHolder";
    }

    public ArrayList<String> rangeToString(ArrayList<Player> playersInRange){
        ArrayList<String> output = new ArrayList<>();
        for(Player player: playersInRange) output.add(player.getPlayerName());
        return output;
    }
}
