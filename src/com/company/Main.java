package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
	    Player p1 = new Player(100, 0, 15);

        System.out.println("You awaken after a fall in a dark cave");
        System.out.println("You have a broken sword in your hand ");
        System.out.println("Type s to view your stats, type e to start encounter, type b to fight the boss, type h to use a health potion, and type q to quit");
                 /*
                    The player is given a choice to look at their stats, quit the game, heal, fight a boss when they feel prepared
                    and fight a monster. If the player's health drops below 0 the game ends.
                 */
        while(Player.getplayerHealth() > 0) {
            String answer = scan.nextLine();

                if (answer.equals("s")) {
                    System.out.println(p1.showStats());
                }

                if (answer.equals("q")){
                    break;
                }
                if (answer.equals("h")) {
                    System.out.println(p1.usePotion());
                }
                    /*
                        When the player feels that their stats are high enough they can choose to fight the boss who has much higher stats that are not randomized.
                        If the player kills the minotaur they win and the game ends.
                     */
                if(answer.equals("b")){
                    Monster boss = new Monster("Minotaur", 250, 5, 30);
                    System.out.println("The " + boss.getName() + " appears in front of you!");
                    System.out.println(boss.monsterStats());
                    while (boss.getHealth() > 0) {

                        System.out.println("What is your next move? Type a to attack, d to dodge, b to block, and f to flee");


                        String encounterAnswer = scan.nextLine();
                        System.out.println(boss.handle(encounterAnswer));
                        if(encounterAnswer.equals("f")){
                            System.out.println("You got away safely!");
                            break;
                        }
                        if(Player.getplayerHealth() <= 0){
                            System.out.println("You died!");
                            break;
                        }

                    }
                    if (boss.getHealth() <= 0) {
                        System.out.println("You killed the " + boss.getName() + "!");
                        System.out.println("Congratulations! You beat the game!");
                    }

                }

                /*
                    If the player chooses to fight a monster, a monster will be created with 1 of 5 names and stats that are randomized but have
                    floors and ceilings in the value so that they are not too strong or too weak.
                 */

                if (answer.equals("e")) {
                    String[] mName = new String[] {"Zombie", "Skeleton", "Giant Spider", "Giant Moth", "Demon"};
                    Random nameSelect = new Random();
                    int upperbound = 5;
                    Random healthSelect = new Random();
                    int hUpperbound = 100;
                    int hLowerbound = 45;
                    Random defenseSelect = new Random();
                    int dUpperbound = 5;
                    Random strengthSelect = new Random();
                    int sUpperbound = 15;
                    int sLowerbound = 10;
                    Monster m = new Monster(mName[nameSelect.nextInt(upperbound)], healthSelect.nextInt(hUpperbound - hLowerbound + 1) +hLowerbound , defenseSelect.nextInt(dUpperbound), strengthSelect.nextInt(sUpperbound - sLowerbound +1) + sLowerbound);
                    System.out.println("A " + m.getName() + " appears in front of you!");
                    System.out.println(m.monsterStats());
                    while (m.getHealth() > 0) {

                       /*
                       While the monster is alive the player will be given a choice on whether to attack dodge block or flee.
                       This choice will repeat until either the player or monster dies.
                        */

                        System.out.println("What is your next move? Type a to attack, d to dodge, b to block, and f to flee");


                        String encounterAnswer = scan.nextLine();
                        System.out.println(m.handle(encounterAnswer));
                        if(encounterAnswer.equals("f")){
                            System.out.println("You got away safely!");
                            break;
                        }
                        if(Player.getplayerHealth() <= 0){
                            System.out.println("You died!");
                                    break;
                        }

                    }
                    /*
                    After the monster is killed the player will recieve a boost to their stats with the victory method and
                    a chance for an item from the reward method.
                     */
                    if (m.getHealth() <= 0) {
                        System.out.println("You killed the " + m.getName() + "!");
                        System.out.println(p1.victory());
                        System.out.println(p1.Reward());
                        System.out.println("Type s to view your stats, type e to start encounter, type h to use a health potion, and type q to quit");
                    }


                }
                else{
                    System.out.println("Not an option.");

                }





        }
        System.out.println("Game Over!");

    }
}
