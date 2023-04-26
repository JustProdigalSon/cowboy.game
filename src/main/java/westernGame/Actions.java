package westernGame;

import java.util.ArrayList;

public class Actions {
    Utilities ut = new Utilities();
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

//    public void shoot(int targetId){
//        Player target = players.get(targetId);
//        target.healthDecrease(1);
//    }

    public void heal(int targetId){
        Player target = players.get(targetId);
        target.healthIncrease(1);
    }


    public void shoot(int shooterId,int victimId){
        players.get(shooterId).removeAction("SHOOT");
        if(players.get(victimId).isDead()) players.remove(players.get(victimId));
    }

    public void dynamiteSomeone(int shooterId,int victimId){
        players.get(shooterId).removeAction("DYNAMITE");
        players.remove(victimId);
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
