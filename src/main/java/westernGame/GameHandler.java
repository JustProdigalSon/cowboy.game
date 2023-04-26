package westernGame;

import java.util.ArrayList;
import java.util.Scanner;

public class GameHandler {
    //For DEBUG only
    private ArrayList<Player> players = new ArrayList<>();
    public void gameStatsPrinterDebug(ArrayList<Player> players){
        for (Player player : players) {
            System.out.println(player.getPlayerName());
            System.out.println(player.health);
        }
    }
    //TODO: think about below + add name adding
    public void initializeGame(){
        players.add(new Sherif("sherif"));
        for(int i=0;i<2;i++) players.add(new Cowboy("cowboy"+ i ));
        for(int i=0;i<3;i++) players.add(new Bandit("bandit" + i));
    }

    public ArrayList<Player> playersInRange(int playerRange, int playerId){
        ArrayList<Player> playersInRange = new ArrayList<>();
        for(int i = 1;i <= playerRange; i++){
            if(playerId < playerRange){
                playersInRange.add(players.get(players.size()-playerRange));
            }else{
                playersInRange.add(players.get(playerId-i));
            }
            playersInRange.add(players.get(playerId+i));
        }
        return playersInRange;
    }

    public ArrayList<String> rangeToString(ArrayList<Player> playersInRange){
        ArrayList<String> output = new ArrayList<>();
        for(Player player: playersInRange) output.add(player.getPlayerName());
        return output;
    }




/*    public void roundHandler(){
        Scanner inPut = new Scanner(System.in);
        Actions action = new Actions(players);
        for(int i = 1; i <= 42; i++) {
            System.out.println("--------------- round:" + i + "-----------------");
            for (Player player : players) {
                System.out.println("round:" + i);
                System.out.println("-------------------------------");
                System.out.println("Player" + player.getPlayerName());
                System.out.println("-------------------------------");
                System.out.println(player.getActions());
                System.out.println("-------------------------------");


            }
        }

    }*/
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int playerToId(Player player){
        return players.indexOf(player);
    }
}
