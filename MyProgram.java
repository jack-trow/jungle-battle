import java.util.Scanner;
import java.util.Random;

public class MyProgram
{
    public static void main(String[] args)
    {
        // System Objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        // Game variables
        String[] enemies = { "Crocodile", "Jaguar", "Snake", "Piranha", "Electric Eel"};
        int maxEnemyHealth = 100; 
        int enemyAttackDamage = 30; 
        
        // Player variables
        int health = 100; 
        int attackDamage = 60; 
        int numHealthGummies = 3; 
        int healthGummyHealAmount = 25;
        int healthGummyDropChance = 25;
        int damageAbsorbedChance = 75;
        
        boolean running = true;
        
        System.out.println("\tWelcome to the Jungle!");
        
        GAME:
        while (running) {
            System.out.println("------------------------------------");
        
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! # \n");
            
            while(enemyHealth>0) {
                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP is " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Defend");
                System.out.println("\t3. Eat health gummy");
                System.out.println("\t4. Run Away");
                
                String input = in.nextLine();
                //You attack the enemy
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTakenAttack = rand.nextInt(enemyAttackDamage);
                    
                    enemyHealth -= damageDealt;
                    health -= damageTakenAttack;
                    
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You get hit for " + damageTakenAttack + " in revenge.");
                    
                    if(health< 1){
                        System.out.println("");
                        System.out.println("\tYou have been beaten by the " + enemy);
                        break;
                    }
                }
                //Chance to absorb some damage of enemy's attack
                else if(input.equals("2")) {
                    int damageTakenDefend = rand.nextInt(enemyAttackDamage);
                    if(rand.nextInt(100) < damageAbsorbedChance) {
                        int damageAbsorbed = rand.nextInt(20);
                        System.out.println("\tYour defense absorbed "+ damageAbsorbed + " damage.");
                        health -= damageAbsorbed;
                        int damageTakenAfterAbsorbed = damageTakenDefend - damageAbsorbed;
                        System.out.println("\t> You recieve " + damageTakenAfterAbsorbed + ".");
                    }
                    else {
                        System.out.println("\t# Your defense absorbed no damage #");
                        System.out.println("\t> You recieve " + damageTakenDefend + " damage.");
                    }
                    if(health< 1){
                        System.out.println("");
                        System.out.println("\tYou have been beaten by the " + enemy);
                        break;
                    }
                }
                //Get to eat a gummy that gives health
                else if(input.equals("3")) {
                    if(numHealthGummies > 0){
                        health += healthGummyHealAmount;
                        numHealthGummies--;
                        System.out.println("\t> You eat a health gummy, healing yourself for " + healthGummyHealAmount + "."
                                         + "\n\t> You now have " + health + " HP."
                                         + "\n\t> You now have " + numHealthGummies + " health gummies left.\n");
                    }
                    else {
                        System.out.println("\t> You have no health gummies left. Defeat enemies for a chance to get one.");
                    }
                }
                //Run away and get a new enemy
                else if(input.equals("4")) {
                    System.out.println("\tYou run away from the " + enemy + ".");
                    continue GAME;
                }
                else {
                    System.out.println("\tInvalid command");
                }
            }
            
            if(health < 1) {
                System.out.println("");
                break;
            }
            
            System.out.println("------------------------------------");
            System.out.println(" # " + enemy + " was defeated. # ");
            System.out.println(" # You have " + health + " HP left. # ");
            if(rand.nextInt(100) < healthGummyDropChance) {
                numHealthGummies++;
                System.out.println(" # The " + enemy + " has dropped a health potion. # ");
                System.out.println(" # You now have " + numHealthGummies + " health gummies. # ");
            }
            System.out.println("------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");
            
            String input = in.nextLine();
            
            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid command");
                input = in.nextLine();
            }
            
            if(input.equals("1")) {
                System.out.println("You continue on your adventure.");
            }
            else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventure.");
                break;
            }
            
        }
        
        System.out.println("------------------------------------");
        System.out.println("");
        System.out.println("# Thanks for Playing! #");
    }
    
}
