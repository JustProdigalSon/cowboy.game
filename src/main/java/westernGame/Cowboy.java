package westernGame;

public class Cowboy extends Player{
   char roleCowboy = 'C';
    public Cowboy(int health, char role) {
        super(health, role);
        this.roleCowboy = role;
    }
}
