package Main;
import java.util.Scanner;
import java.lang.Math; //i dont want to remove this but i dont think its being used ¯\_(ツ)_/¯ 
import static java.lang.System.exit;
/**
 *name: adventure game
 * description: adventure game where you go through the sewer and kill rats
 * with a boss fight and shops  
 * @author Daniel Axenti, Jarod Humby, Ryan Azizpour, Victor Jiang 
 */
public class adventureGame {
   public static int mcHealth = 20; //your health
    public static int mcDefense = 0; //your defense
    public static int mcAttack = 1; //your attack
    public static int ratHealth = 3; //basic enemy health
    public static int ratDefense = 0; //basic enemy defense
    public static int ratAttack = 1; //basic enemy attack
    public static int bossHealth = 200; //boss health
    public static int bossAttack = 5; //boss attack
    public static int turns=0; //turns
    public static int gold = 7; //gold
    public static String [ ] inventory = new String [4]; //global inventory array
    public static boolean secondBlock = true;  
    //^declaring global variables^
    public static void battleCode(int battle){ //Custom method made by Victor for the battles
    Scanner newScan = new Scanner(System.in);   
    boolean turnEnd=false;
    do{ // put this whole thing in a do loop
    int enemyTurn=0; // set the enemy turn integer to 0
    int playerTurn = 1; // set player turn to 1
        System.out.println("You encounter an enemy!!"); // tell the use what is happening
        System.out.println("A weak sewer Rat had appeared!"); // etc
        System.out.println("Your stats are: " + "Health:" + mcHealth + "  " +"Defense:" + mcDefense + "  " + "Attack:" + mcAttack);// tell the main character the stats
        System.out.println("The weak sewer rat's stats are: " + "Health:" +ratHealth + "  " + "Defense:" +ratDefense + "  " + " Attack:" +ratAttack); // tell the user the enemy's stats
        
        while (playerTurn==1){ // set te while loop so that this runs forever until some of the stuff is fufilled
        System.out.println("You can attack, press x to attack"); // tell the player how to attack
        String actionBattle=newScan.nextLine(); // scan for input on the next line
        if (actionBattle.equals("x")){ // if the user inputs "x" the code will inititate
            ratHealth=ratHealth-mcAttack; // ememy's health equals its health minus you value
            System.out.println("Enemy has " + ratHealth + " health"); // print and tell the user the enemy's health
            if (mcDefense>=0){ // state if the defense equals or is greater than zero the rats attack its attack minus the player's defense
                ratAttack = (ratAttack - mcDefense);
        }
        }//attack if statement
        if (enemyTurn==0){ // if the enemy's turn equals 0
            System.out.println("The enemy is now attacking!!");
            mcHealth=(mcHealth-ratAttack);
            System.out.println("Now you have " + mcHealth + " health");
        }
        if (ratHealth<=0){ // if the enemy's health equals 0 or less than zero
            System.out.println("You killed the enemy! Goodjob!");
            System.out.println("You have " + mcHealth + " health");     
            turnEnd=false; // set turnend to false 
            playerTurn=0; // set the player turn to zero
            ratHealth = (turns + 2 ); // special feature tat the rathealth increases per turn, making it stronger depending on the turns + 2 it will have 2 more health than the round number
            ratAttack = (turns + 1); 
        }
        
        if (mcHealth<=0){ // if the player's health equals 0 you are dead
            playerTurn=0; // reset the player turn count
             System.out.println("Game Over!!!You have died XD"); // you died
             break; // break the code so that it does not continue
            } 
        } //while loop for player turn
    }while (turnEnd==true);//do loop
    }//end of method
    
     public static void battleCode(double bossBattle){ //Custom method made by Jarod for the boss fight
        Scanner newScan = new Scanner(System.in);
        boolean finalBattle=false;
            int playerTurn = 0;
            do{
            playerTurn = 1;
                System.out.println("You have encountered the final boss! The King rat!"); 
                System.out.println("Are you ready to fight the final boss? get ready!");
                System.out.println("Your stats are: " + "Health:" + mcHealth + "  " +"Defense:" + mcDefense + "  " + "Attack:" + mcAttack);
                //final boss intro
                while (playerTurn == 1){
                int bossTurn = 0; //local variable inside while loop that indicates when its the bosses turn
                String actionBattle=newScan.nextLine();
                    if (actionBattle.equals("x")){
                        bossHealth = bossHealth - mcAttack;
                        System.out.println("The boss now has:" + bossHealth + "health");
                        bossTurn = 0;
                    } //you attack the boss + boss health displayed
                    if (bossTurn==0){
                        System.out.println("The boss is now attacking!!");
                        mcHealth=(mcHealth-bossAttack);
                        playerTurn=1;
                        System.out.println("Now you have " + mcHealth + " health");
                    } //boss attacks + your health after attack is displayed  
                    if (bossHealth<=50){
                        System.out.println("THE BOSS IS ENRAGED!! ROAAAAAAR!! attacks are doubled.");
                        bossAttack= (bossAttack*2);
                    }// gives the boss double attack when he reaches 50 hp 
                    if (bossHealth<=0){
                        System.out.println("You killed the boss! Goodjob!");
                        finalBattle=true;
                        playerTurn=0;
                    } //ends game when you beat the boss/boss has 0 hp
                    if (mcHealth<=0){
                        System.out.println("Game Over!!!You have died XD");
                        break; //breaks while loop
                    } // ends battle when you have 0 hp or lower 
                }
            break; //breaks do loop 
           }while (finalBattle==false); //runs do loop until finalBattle = true (boss is killed)
    }//end of method

    public static void displayInventory(){ //custom method made by Daniel for displaying the inventory
        System.out.print("Inventory: ");
        System.out.println(" ");
        for (int x =0; x<3;x++){ //x is a local variable only used in the for loop
         System.out.print( inventory[x] + ", "); //prints out the inventory in order with commas
    }
        System.out.print(inventory[3]);
        System.out.println("");
        System.out.println("Stats");
        System.out.println("Health: " + mcHealth);
        System.out.println("Defense: " + mcDefense);
        System.out.println("Attack: " + mcAttack);
        System.out.println("Gold: " + gold);
        System.out.println("Turn: " + turns); //prints out the stats when checking the inventory
}//end of method
    public static void shopArea(int shopNumber){ //custom method made by Ryan for the shop to function
            String [] shopItems = {"","",""}; //declaring the shop item array (local only inside the method)
            String [] shopItemPricesGold = {"","",""}; //declaring the shop item attributes (local only inside the method)
            int [] shopItemPrices = {0, 0, 0}; //declaring the shop item prices array (local only inside the method)
            int [] shopItemStats = {0, 0, 0}; //declaring the shop item stats array (local only inside the method)
            if (shopNumber == 1){ //first shops items and their attributes
                shopItems[0] = "Rusty Pipe"; 
                shopItems[1] = "Damp Paper Bag";
                shopItems[2] = "Mossy ring"; //item names
                shopItemPricesGold [0] = "(attack for 10 Gold)";
                shopItemPricesGold [1] = "(defense for 10 Gold)";
                shopItemPricesGold [2] = "(health for 5 Gold)"; //text next to items
                shopItemPrices [0] = 10;
                shopItemPrices [1] = 10;
                shopItemPrices [2] = 5; //item prices
                shopItemStats [0] = 5;
                shopItemStats [1] = 5;
                shopItemStats [2] = 5; //item stats
            }
            if (shopNumber == 2){ //second shops items and their attributes
                shopItems [0] = "Sturdy Cleaver";
                shopItems [1] = "Leather Shirt";
                shopItems [2] = "Banana necklace"; //item names
                shopItemPricesGold [0] = "(attack++ for 20 Gold)";
                shopItemPricesGold [1] = "(defense++ for 15 Gold)";
                shopItemPricesGold [2] = "(health++ for 10 Gold)"; //text next to items
                shopItemPrices [0] = 20;
                shopItemPrices [1] = 15;
                shopItemPrices [2] = 10; //item prices
                shopItemStats [0] = 20;
                shopItemStats [1] = 15;
                shopItemStats [2] = 30; //item stats
            }
           System.out.println("You encounter a shop. The shop keeper looks untrustworthy.");
           System.out.println("Welcome to the shop! Please have a look at my wares.");
           System.out.println("Would you like to buy something?(Yes or No)");//shop dialogue
           System.out.println("(You have " + gold + " gold)"); //tells you your gold
                Scanner purchaseChoice = new Scanner(System.in); //prints out the shop items and their prices
                String yesOrNo = purchaseChoice.nextLine();
        if (yesOrNo.equalsIgnoreCase("no")){  //if they do not want to buy the loop never starts
            System.out.println("Alright then! Have a good day!");
            System.out.println();
        }
        if (yesOrNo.equalsIgnoreCase("yes")){ //if they want to buy it starts the loop
            while(true){ //start of shop loop
            System.out.println(shopItems[0] + " " + shopItemPricesGold[0] + ", " + shopItems[1] + " " + shopItemPricesGold[1] + ", " + shopItems[2] + " " + shopItemPricesGold[2]);
            System.out.println("Choose which item you would like to purchase (Press 1, 2, or 3)"); //< asks for user input. ^ prints out shop items ^
            String itemPurchase = purchaseChoice.nextLine(); //scans for user input
         //continues the loop if the user says yes
        if (itemPurchase.equalsIgnoreCase("1")){ 
            if (gold < shopItemPrices[0]){ //makes sure the user has enough gold to buy something
                System.out.println("You dont have enough gold for this.");
            }
            else if (inventory [0].equals(shopItems[0])){ //makes sure the user doesnt already own the item
            System.out.println("You already own this item."); 
        }
            else { 
        inventory [0] = shopItems[0]; //places the item in the inventory
        System.out.println("You have successfully purchased the " + shopItems [0]); //succesful purchase of the item
        gold = gold - shopItemPrices [0]; //subtracts the right amount of gold
        System.out.println("You now have " + gold + " gold."); //tells you the gold remaining
        mcAttack = shopItemStats [0]; //adds the new attack stat to your stats
        }
        }
        if (itemPurchase.equalsIgnoreCase("2")){
            if (gold < shopItemPrices[1]){ //makes sure the user has enough gold to buy something
                System.out.println("You dont have enough gold for this."); 
            } 
            else if (inventory [1].equals(shopItems[1])){ //makes sure the user doesnt already own the item
             System.out.println("You already own this item."); 
        }
            else { 
        inventory [1] = shopItems[1]; //places the item in the inventory  
        System.out.println("You have successfully purchased the " + shopItems [1]); //succesful purchase of the item
        gold = gold - shopItemPrices [1]; //subtracts the right amount of gold
        System.out.println("You now have " + gold + " gold."); //tells you the gold remaining
        mcDefense = shopItemStats [1]; //adds the new defense stat to your stats
            }
        }
        
        if (itemPurchase.equalsIgnoreCase("3")){
            if (gold < shopItemPrices[2]){ //makes sure the user has enough gold to buy something
                System.out.println("You dont have enough gold for this.");
            }
            else if (inventory [2].equals(shopItems[2])){ //makes sure the user doesnt already own the item
             System.out.println("You already own this item."); 
        }
            else { 
        inventory [2] = shopItems[2]; //places the item in the inventory  
        System.out.println("You have successfully purchased the " + shopItems [2]); //succesful purchase of the item
        gold = gold - shopItemPrices [2]; //subtracts the right amount of gold
        System.out.println("You now have " + gold + " gold."); //tells you the gold remaining
        mcHealth = mcHealth + shopItemStats [2]; //adds the new defense stat to your stats
            }
        }
        
        System.out.println( "Do you want to buy something else"); //asks the user if they want to buy something else
        String answer = purchaseChoice.nextLine(); //converts the input into a seperate string
        if (answer.equals("no")){
        break; //breaks the loop if the user says no; repeats the loop otherwise 
        }
        }//end of shop loop
        }//end of if statement
        }//end of method

    public static void main (String [] args){
        inventory [0] = "no weapon";
        inventory [1] = "no clothing";
        inventory [2] = "no consumables";
        inventory [3] = "no consumables"; //fills in the inventory with placeholders instead of "null"
    
    System.out.println("You wake up in a dirty sewer...");//lore :)
    System.out.println("You're naked, hungry, dirty, and smelly...");
        
        try {
        Thread.currentThread().sleep(1 * 2000);
    } catch (InterruptedException e) {//rest to build suspense :p
    e.printStackTrace();
    }
        
    System.out.println("You see a light in the distance...");
    //you find a stick
        
        try {
        Thread.currentThread().sleep(1 * 2000);
    } catch (InterruptedException e) {//rest to build suspense :p
    e.printStackTrace();
    }

    System.out.println("You enbark forwards towards the light.");
boolean turnEnd= false;//for turns to end
boolean firstBlock=true;// for the first five turns to loop
do{//do loop for the fisrt five turns
do{//do loop for the singular turns
if (turns <5 ){//loop
    while(true){//loop for the user to be able to press "inventory multiple times"
        Scanner newScan= new Scanner(System.in); 
        System.out.println();
        System.out.println("You can go forward (w) or check your inventory/use items (i)");
        String action=newScan.nextLine();    
    if (action.equalsIgnoreCase("i")){
        displayInventory();//displays inventory (references the method)
    }if (action.equalsIgnoreCase("w")){
        turns += 1;//increces turns so that the computer knows when shop is gonna be
        break;//moves on to the next code 
    }//end of turn "w"
    }//end of while
    double battleNum=Math.random();
    int max1=4;//deciding factor for the battles 
    int min1=1;
    int battle=(int)(battleNum* max1 + min1);
    //calculation to see if the battle will happen
    if (battle==1){//if battle is 1 the battle code runs
        battleCode(1);
        if (mcHealth<=0){//if the player dies the program ends
            System.out.println("YOU DIED! LOL!");
            exit(0);
        }
    }//battle if statement
    else{//if a battle does not happen you collect gold, and dont lose anything
        System.out.println("You pass freely (nothing happened).");
        System.out.println("you collect 5 gold!");
        gold += 5;
        turnEnd=true;//turnEnd makes the program run again
    }
    }else if (turns == 5){
    shopArea(1);
    firstBlock=false;//ends the first block to move onto the next
    turnEnd=false;//ends the turns loop moves onto the next block
    //at the end of the shop code make fistBlock equal false
}//turn if statement

}while (turnEnd==true);//do loop
}while (firstBlock==true);//do loop for first 5 turns

int turns2=0;
boolean secondBlock=true; //local variable
do{//do loop for the second 5 turns
do{//for the singular turns 
if (turns2<5){
while(true){
    Scanner newScan= new Scanner(System.in); 
    System.out.println();
    System.out.println("You can go go forward (w) or check your inventory/use items (i)");
    String action=newScan.nextLine();
    if (action.equalsIgnoreCase("i")){
    displayInventory();
    }
    if (action.equalsIgnoreCase("w")){
        turns2 += 1;
        turns += 1;
        break;
    }//end of turn 
}//end of while
    double battleNum=Math.random();
    int max1=3;//changes the chances of a battle to 33% instead of 25%
    int min1=1;
    int battle=(int)(battleNum* max1 + min1);
    
    if (battle==1){//if the computer randomly picks 1 a fight happens
        battleCode(1);//references the battle code method
        if (mcHealth<=0){//if you die the code exits
            exit(0);
            System.out.println("YOU DIED!! LOL");
        }
    }//battle if statement
    else{//if theres no fight you get gold
        System.out.println("You pass freely (nothing happened).");
        System.out.println("you collect 7 gold!");
        gold += 7;
        turnEnd=true;//runs through the code again 
    }//else
}//if statemetn for turns 5-9
else if (turns2 == 5){//if 5 turns happened in the second block you come to a shop
shopArea(2);//references the shop code method
secondBlock=false;//moves onto the next code
turnEnd=false;//moves onto the next code
}
//at the end of the shop code make fistBlock equal false
}while (turnEnd==true);//do loop
}while (secondBlock==true);//do loop for second 5 turns

System.out.println("Big boss fight!!! get ready!");
battleCode(1.0);//refences the boss fight code
//thanks for being a great teacher :P
    
    }//end of main
}//end of public class
