import westernGame.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {


     public static void startGameDebug(ArrayList<Player> players){
          GameHandler gameHandler = new GameHandler();
//          Actions action = new Actions();
          players.add(new Sherif("sherif"));
          for(int i=0;i<2;i++) players.add(new Cowboy("cowboy" + i));
          for(int i=0;i<3;i++) players.add(new Bandit("bandit" + i));
          for(int i = 0; i  < 7 ;i++ ){
               gameHandler.gameStatsPrinterDebug(players);
               //TODO: make it work with choosing another player in the given range
//               System.out.println("pifpaf");
//               action.shoot(players.get(1).playersInRange(1,1,players));
               if(players.get(0).isDead()) players.remove(0);
          }
          gameHandler.initializeGame();//         gameHandler.roundHandler();


     }

     public static void gamePlay(){
          GameHandler gameHandler = new GameHandler();
          Scanner inPut = new Scanner(System.in);
          Utilities ut = new Utilities();
          gameHandler.initializeGame();
          ArrayList<Player> players = gameHandler.getPlayers();
          Actions action = new Actions(players);

          for(int i = 1; i <= 42; i++) {
               System.out.println("########## round:" + i + " ############");
               for (int playerId = 0; playerId < players.size();i++) {
                    for(int j = 0; j < 7;j++){gameHandler.round();};

               }
          }
     }


     public static void main(String[] args) {
          gamePlay();
//          ArrayList<Player> players = new ArrayList<>();
//
//          //Sherif sherif = new Sherif();
//          //Bandit bandit = new Bandit();
//          GameHandler gameHandler = new GameHandler();
//          startGameDebug(players);
//          System.out.println("placeHolder");
//          //System.out.println(sherif.getHealth());
//          //System.out.println(bandit.getHealth());
//          System.out.println("placeHolder");
//          gameHandler.gameStatsPrinterDebug(players);




     }



}
