package com.company;
import java.util.Random;
public class Monster {
    private String name;
    private int health;
    private int defense;
   static private int monsterStrength;

    public Monster(String name, int health, int defense, int monsterStrength){
        this.name = name;
        this.health = health;
        this.defense = defense;
        Monster.monsterStrength = monsterStrength;
    }
    /*
    monsterStats prints the monsters name, health, defense, and strength so the player can make an educated decision.
     */
    public String monsterStats(){
        return ("The " + getName() + " has " + getHealth() + " Health, " + getDefense() + " Defense, and " + getmonsterStrength() + " Attack power.");
    }

    /*
     This method takes the users choice and processes it. Throughout the different options there is a chance that the choice
     is successful and a chance that it fails. This is done with randoms. It then either uses the takeDamage method to do
     damage to the player or sets the monster's health subtracting the damage done to it or increasing the player's health.
     */
    public String handle(String command) {

            /*
            The player has a 5/6 chance to damage the mosnter and a 1/6 chance to take damage when they choose attack.
             */

        if(command.equals("a")) {
            Random parryChance = new Random();
            int upperbound = 6;
            int parry = parryChance.nextInt(upperbound);
            if (parry == 1){
                Player.takeDamage(getmonsterStrength());
                return "The " + getName() + " Blocked your attack and struck you! You have " + Player.getplayerHealth() + " Health left.";
            }

                setHealth(getHealth() - (Player.getAttackPower() - getDefense()));
                return "You cut the " + getName() + "! The " + getName() + " has " + getHealth() + " health left.";
        }

                /*
                If the player chooses to block to have that block broken and take double damage from the monster. Otherwise
                they will gain 10 health.
                 */

        else if(command.equals("b")){
            Random blockChance = new Random();
            int upperbound = 10;
            int block = blockChance.nextInt(upperbound);
            if (block == 1){
                Player.takeDamage(getmonsterStrength() * 2);
                return "The monster broke your parry! You were hit badly! " + "You have " + Player.getplayerHealth() + " health left.";
            }
            Player.setplayerHealth(Player.getplayerHealth() + 10);
            return "You used your sword to parry the " + getName() + "'s attack! You regenerated some health!";

        }

                /*
                If the player chooses to dodge they have a chance to fail the dodge and take damage. If they are successful
                they will gain 5 health.
                 */

        else if(command.equals("d")){

            Random dodgeChance = new Random();
            int upperbound = 15;
            int dodge = dodgeChance.nextInt(upperbound);
                    if(dodge == 1){
                        Player.takeDamage(getmonsterStrength());
                        return "You failed to dodge the attack! You were struck by the monster! You have " + Player.getplayerHealth() + "health left.";
                    }
                    Player.setplayerHealth(Player.getplayerHealth() + 5);
                    return "You dodged the " + getName() + "'s attack! You regenerated a small amount of health";


        }
        else if(command.equals("f")){
            return "";
        }
        else {
            return "Not an option.";
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public static int getmonsterStrength() {
        return monsterStrength;
    }

    public void setAttackPower(int monsterStrength) {
        Monster.monsterStrength = monsterStrength;
    }
}
