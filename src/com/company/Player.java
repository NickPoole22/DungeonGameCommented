package com.company;
import java.util.Random;


public class Player {
    private static int playerHealth;
    private static int defense;
    private static int attackPower;
    private int healthPotions;
    private int monstersKilled;

    public Player(int playerHealth, int defense, int attackPower){
        Player.attackPower = attackPower;
        Player.defense = defense;
        Player.playerHealth = playerHealth;
    }
    /*
        This prints the players stats so they can see how they are progressing.
    */
    public String showStats(){
        return ("You have " + getplayerHealth() + " Health left, " + getDefense() + " Defense, and " + getAttackPower() + " Attack power, you have " + getHealthPotions() + " Health Potions left and " + getMonstersKilled() + " monsters killed.");
    }
    /*
        This uses the potion item and restores the player's health.
     */
    public String usePotion(){
        if(getHealthPotions() > 0){
            setplayerHealth(getplayerHealth() + 50);
            setHealthPotions(getHealthPotions() - 1);
            return ("You restored 50 health!");
        }return ("You have no health potions left");
    }

    /*
        When a player beats the monster they get an increase to their stats as a set reward.
     */
    public String victory(){
        setplayerHealth(getplayerHealth() + 5);
        setDefense(getDefense() + 2);
        setAttackPower(getAttackPower() + 1);
        setMonstersKilled(getMonstersKilled() +1);
        return "Your stats increased!";
    }
    /*
        Has a chance to give the player armor, health potion, or a weapon.
     */
    public String Reward(){
        Random reward = new Random();
        int upperbound = 5;
        int rewardPick = reward.nextInt(upperbound);
        if(rewardPick == 1){
            setHealthPotions(getHealthPotions() +1);
            return "You found a health potion!";
        }
        if(rewardPick == 2){
            setDefense(getDefense()+2);
            return "You found new armor, your defense increased by 2!";
        }
        if(rewardPick == 3){
            setAttackPower(getAttackPower()+3);
            return "You found a new weapon, your attack power increased by 3!";
        }
        else {
            return "You found nothing";

        }

    }
    /*
        Allows the player to take damage and takes the monsters power and players defense into account.
     */
    public static void takeDamage(int damage){
        int totalDamage = damage -Player.getDefense();
        setplayerHealth(getplayerHealth() -totalDamage);
    }


    public static int getplayerHealth() {
        return playerHealth;
    }

    public static void setplayerHealth(int playerHealth) {
        Player.playerHealth = playerHealth;
    }

    public static int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        Player.defense = defense;
    }

    public static int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        Player.attackPower = attackPower;
    }

    public int getHealthPotions() {
        return healthPotions;
    }

    public void setHealthPotions(int healthPotions) {
        this.healthPotions = healthPotions;
    }

    public int getMonstersKilled() {
        return monstersKilled;
    }

    public void setMonstersKilled(int monstersKilled) {
        this.monstersKilled = monstersKilled;
    }
}
