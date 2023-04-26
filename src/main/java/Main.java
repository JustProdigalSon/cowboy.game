import westernGame.*;
import java.util.ArrayList;
import java.util.Arrays;
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
               if(!players.get(0).isDead()) players.remove(0);
          }
          gameHandler.initializeGame();//         gameHandler.roundHandler();


     }

     public static void gamePlay(){
          GameHandler gameHandler = new GameHandler();
          Scanner inPut = new Scanner(System.in);
          gameHandler.initializeGame();
          ArrayList<Player> players = gameHandler.getPlayers();
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
                    System.out.println("What Do you want to do?");        ActionCards[] actionCards = ActionCards.values();
                    ActionCards actionCard = actionCards[1];

                    String answer = inPut.next();

                    switch(answer){
                         case "shoot" -> {
                              //TODO make shoot own fuction in actions and add heal and Player visibility setings
                              int targetId;
                              ArrayList<Player> playersInRange = gameHandler.playersInRange(player.getRange(),players.indexOf(player));
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

                         }

                         //System.out.println(gameHandler.playersInRange(player.getRange(), players.indexOf(player),players));
                         case "heal"-> {
                              //TODO make shoot own fuction in actions and add heal and change Player visibility setings
                              //TODO check for seherif nearby and allow to heal to players max health(also add max health)
                              int targetId;
                              ArrayList<Player> playersInRange = gameHandler.playersInRange(1, players.indexOf(player));
                              System.out.println(gameHandler.rangeToString(playersInRange));
                              System.out.println("kogo chcesz uleczyć");
                              String target = inPut.next();
                              for (int j = 0; j < playersInRange.size(); j++) {
                                   System.out.println(playersInRange.get(j).getPlayerName());
                                   if (target.equals(playersInRange.get(j).getPlayerName())) {
                                        targetId = i;
                                        System.out.println(players.get(targetId).getHealth());
                                        System.out.println("leczysz |--&==-->   :" + playersInRange.get(j).getPlayerName());
                                        action.heal(targetId);
                                        System.out.println(players.get(targetId).getHealth());
                                        break;
                                   }
                              }
                         }

                         case "GET" ->{
                              player.drawAtcionCard();
                              System.out.println(player.getActions());
                         }

                         //TODO make default return to first question
                         default ->

                              throw new IllegalStateException("Unexpected value: " + answer);
                    }
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
