package westernGame;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Player {

    Utilities utility = new Utilities();

    //player name works like id
    //TODO check if name already exists among the players
    private String playerName;



    protected char role;
    protected int health = utility.randomInRange(3,5);
    protected  int range = 1;
    protected ArrayList<String> actions = new ArrayList<>(Arrays.asList("GET"));
    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public ArrayList<String> getActions() {
        return actions;
    }

    public void addAction(String action) {
        this.actions.add(action);
    }

    public void removeAction(String action) {
    //TODO: check if action is in actions and delet it if its not asked again
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead(){
        return this.health >= 0;
    }

    public void healthDecrease(int howMuch){
        health = health - howMuch ;
    }
    public void healthIncrease(int howMuch){
        health = health + howMuch ;
    }

    public void drawAtcionCard(){
        ActionCards[] actionCards = ActionCards.values();
        ActionCards actionCard = actionCards[utility.randomInRange(0,2)];
        addAction(String.valueOf(actionCard));
    }






}
