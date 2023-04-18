package westernGame;

import java.util.ArrayList;

public abstract class Player {
    GameHandler gameUtilites = new GameHandler();

    private char role;
    private int ammo = 1;
    private int  health = gameUtilites.randomInRange(3,5);
    private int range = 1;
    private  ArrayList<String> cardsHeld = new ArrayList<>();
    private int placeInQueue;


    public Player(int health,char role) {

        this.health = health;
        this.role = role;
    }

//    public Player(char role, int health){
//        this.role = role;
//        this.health = health;
//
//    }

    public int getPlaceInQueue() {
        return placeInQueue;
    }

    public void setPlaceInQueue(int placeInQueue) {
        this.placeInQueue = placeInQueue;
    }


    public ArrayList<String> getCardsHeld() {
        return cardsHeld;

    }

    public void setCardsHeld(ArrayList<String> posesedCards) {
        this.cardsHeld = posesedCards;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }


}
