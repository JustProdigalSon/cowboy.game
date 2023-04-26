package westernGame;

import java.util.ArrayList;

public class Actions {
    ArrayList<Player> players = new ArrayList<>();
    public Actions(ArrayList<Player> players) {
        this.players = players;
    }
    public ArrayList<Player> playersInRange(int playerRange, int playerId, ArrayList<Player> players){
        ArrayList<Player> playersInRange = new ArrayList<>();
        for(int i = 1;i <= playerRange; i++){
            playersInRange.add(players.get(playerId-i));
        }
        return playersInRange;
    }
    //TODO check ammo if no ammo no shooting :(

    public void shoot(int targetId){
        Player target = players.get(targetId);
        target.healthDecrease(1);
    }

    public void heal(int targetId){
        Player target = players.get(targetId);
        target.healthIncrease(1);
    }

    public void drawCard(){

    }

/*    public void shoot(int targetId){
        int targetId;
        ArrayList<Player> playersInRange = gameHandler.playersInRange(player.getRange(),players.indexOf(player),players );
        System.out.println(gameHandler.rangeToString(playersInRange));
        System.out.println("Podaj cel");
        String target = inPut.next();
        for(int j = 0; j < playersInRange.size(); j++){
            System.out.println(playersInRange.get(j).getPlayerName());
            if (target.equals(playersInRange.get(j).getPlayerName())) {
                targetId = i;
                System.out.println(players.get(targetId).getHealth());
                System.out.println("pifpaf ~;=== ---*  " + playersInRange.get(j).getPlayerName());
                action.shoot(targetId);
                System.out.println(players.get(targetId).getHealth());
                break;
            }
        }
    }*/
    private boolean checkIfSherifIsNear(ArrayList<Player> availablePlayers){
        for(Player player: availablePlayers){
            if(player.getRole() == 's') return true;
        }
        return false;
    }

    //TODO make heall function and neighbours in given range function(Make playersInRange better)

/*    public void heal(int playerId){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        ArrayList<Player> availablePlayers = new ArrayList<>(Arrays.asList(players.get(playerId-1),players.get(playerId),players.get(playerId+1)));
        Player currentPlayer = players.get(playerId);
        if(currentPlayer.getRole() != 's' && checkIfSherifIsNear(availablePlayers)){
            System.out.println("kogo chcesz uleczyć");
            for(Player player: availablePlayers){
                System.out.println(player.getPlayerName());
            }
        }

    }*/
}
