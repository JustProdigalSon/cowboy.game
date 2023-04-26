package westernGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameHandler {
    private boolean dynamite;
    //For DEBUG only
    private ArrayList<Player> players = new ArrayList<>();
    Actions action = new Actions(players);
    Utilities ut = new Utilities();
    Scanner inPut = new Scanner(System.in);

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
        Collections.shuffle(players);
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

    private int sherifId(){
        int index = 0;
        for(Player player: players) {
            if (player.getRole() == 's') {
                index = players.indexOf(player);
            }
        }
        return index;
    }
    private boolean checkIfSherifIsNear(ArrayList<Player> availablePlayers){
        for(Player player: availablePlayers){
            if(player.getRole() == 's') return true;
        }
        return false;
    }

    public int chosetarget(int playersRange, int playersId) {
        int target = 0;
        ArrayList<Player> range = playersInRange(playersRange, playersId);
        System.out.println("chose your victim");
        System.out.println(ut.rangeToString(range));
        String answer = inPut.next();
        boolean noTargetFind = false;
        while (!noTargetFind){
            for (int i = 0; i < range.size(); i++) {
                if(players.get(playersId).getRole() == 's'){
                    System.out.println(range.get(i).getPlayerName()+range.get(i).getPlayerName());
                }
                System.out.println(range.get(i).getPlayerName());
                if (answer.equals(range.get(i).getPlayerName())) {
                    target = i;
                    return target;
                }
            }
            System.out.println("Player nick is not in range");
            noTargetFind = true;
            chosetarget(playersRange, playersId);
        }
        return target;
    }

    public void choseAction(int playerId, Player player){
        String answer = inPut.next().toUpperCase();
        ArrayList<String> actions = player.getActions();
        if (actions.contains(answer)) {

            switch (answer) {
                case "SHOOT" -> {
                    int target = chosetarget(player.getRange(),playerId);
                    action.shoot(playerId, target);
                }

                //System.out.println(gameHandler.playersInRange(player.getRange(), players.indexOf(player),players));
                case "HEAL" -> {
                    if(player.getRole() == 'c') {
                        if (checkIfSherifIsNear(playersInRange(1, playerId))) {
                            action.heal(sherifId());
                        }
                    }
                        int target = chosetarget(playerId, player.getRange());
                    action.heal(target);
                }

                case "GET" -> {
                    player.drawAtcionCard();
                    System.out.println(player.getActions());
                }

                case "DYNAMITE" -> {
                    int target = chosetarget(player.getRange(),playerId);
                    action.dynamiteSomeone(playerId, target);
                }

                default ->{ System.out.println("you can't do that sily, chose another action");
                    round();}
            }

        }else{
            System.out.println("you can't do that sily, chose another action");
            choseAction(playerId,player);}
    }



    public void round() {

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
//            ArrayList<Player> playersInRange = playersInRange(player.getRange(), i);

            System.out.println("-------------------------------");
            System.out.println("---------Player Nick-----------");
            System.out.println("-------------------------------");
            System.out.println(player.getPlayerName());

            System.out.println("-------------------------------");
            System.out.println("---------Your Actions----------");
            System.out.println("-------------------------------");

            ArrayList<String> actions = player.getActions();
            System.out.println(actions);
            System.out.println("-------------------------------");

            System.out.println("What Do you want to do?");
            choseAction(i,player);
        }

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
