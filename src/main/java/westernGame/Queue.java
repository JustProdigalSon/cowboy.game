package westernGame;

import java.util.ArrayList;
import java.util.HashMap;

public class Queue {

    private HashMap<Integer, Player> players = new HashMap<>();

    public HashMap<Integer, Player> getPlayers() {
        return players;
    }
    public void removePlayer(int place){
        this.players.remove(place);
    }
    public void addPlayer(int queueId, Player player){
        this.players.put(queueId,player);
    }

    public void setPlayers(HashMap<Integer, Player> players) {
        this.players = players;
    }



    public ArrayList<Integer> nearPlayers(int place,int range) {
        ArrayList<Integer> nearPlayer = new ArrayList<>();
        for(int i = 1; i < range; i++){
            nearPlayer.add(place-i);
            nearPlayer.add(place+i);
        }
        return nearPlayer;
    }
//TODO make place in queue random

//    public void randomPlaceInQueue(){
//
//    }




}
