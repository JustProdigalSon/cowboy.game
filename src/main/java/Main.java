import westernGame.*;


public class Main {

     public static void main(String[] args) {
         Player sherif = new Sherif(4,'C');
         Bandit bandit = new Bandit(4,'B');
        int temp = bandit.getHealth();
         System.out.println(temp);
         Queue queue = new Queue();
         queue.addPlayer(1,sherif);
         queue.addPlayer(2,bandit);
         System.out.println(queue.getPlayers());

     }



}
