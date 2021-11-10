package Main;
import java.util.Scanner;
import java.lang.Math; //i dont want to remove this but i dont think its being used ¯\_(ツ)_/¯ 
import static java.lang.System.exit;
/**
 *name: adventure game
 * description: adventure game where you go through the sewer and kill rats
 * with a boss fight and shops  
 * @author Daniel Axenti, Jarod Humby, Ryan Azizpour, Victor Jang 
 */
public class adventureGame {
    public static int mcHealth = 20; //your health
    public static int mcDefense = 0; //your defense
    public static int mcAttack = 1; //your attack
    public static int rathealth = 3; //basic enemy health
    public static int ratdefense = 0; //basic enemy defense
    public static int ratattack = 1; //basic enemy attack
    public static int bossHealth = 200; //boss health
    public static int bossAttack = 5; //boss attack
    public static int turns=0; //turns
    public static int gold = 7; //gold
    public static String [ ] inventory = new String [4]; //inventory array
    public static boolean secondBlock = true; 
    //^declaring global variables^
    public static void battleCode(){
    Scanner newScan = new Scanner(System.in);
    boolean turnEnd=false;
    do{
    int enemyTurn=0;
    int playerTurn = 1;
        System.out.println("You encounter an enemy!!");
        System.out.println("A weak sewer Rat had appeared!");
        System.out.println("Your stats are: " + "Health:" + mcHealth + "  " +"Defense:" + mcDefense + "  " + "Attack:" + mcAttack);
        System.out.println("The weak sewer rat's stats are: " + "Health:" +rathealth + "  " + "Defense:" +ratdefense + "  " + " Attack:" +ratattack);
        
        while (playerTurn==1){
        System.out.println("You can attack, press x to attack");
        String actionBattle=newScan.nextLine();
        if (actionBattle.equals("x")){
            rathealth=rathealth-mcAttack;
            System.out.println("Enemy has " + rathealth + " health");
            if (mcDefense>=0){
                ratattack = (ratattack - mcDefense);
            
        }
            
        }//attack if statement
        if (enemyTurn==0){
            System.out.println("The enemy is now attacking!!");
            mcHealth=(mcHealth-ratattack);
            System.out.println("Now you have " + mcHealth + " health");
        }
        if (rathealth<=0){
            System.out.println("You killed the enemy! Goodjob!");
            System.out.println("You have " + mcHealth + " health");     
            turnEnd=false;
            playerTurn=0;
            rathealth = (turns + 2 );
        }
        
        if (mcHealth<=0){
            playerTurn=0;
             System.out.println("Game Over!!!You have died XD");
             break;
            } 
        } //while loop for player turn
    }while (turnEnd==true);//do loop
    }
    
        public static void bossCode(){
        Scanner newScan = new Scanner(System.in);
        boolean finalBattle=false;
            int playerTurn = 0;
            do{
            playerTurn = 1;
                System.out.println("You have encountered the final boss! The King rat!");
                System.out.println("Are you ready to fight the final boss? get ready!");
                System.out.println("Your stats are: " + "Health:" + mcHealth + "  " +"Defense:" + mcDefense + "  " + "Attack:" + mcAttack);
                
                while (playerTurn == 1){
                int bossTurn = 0;
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
    }

    public static void displayInventory(){ //custom method made by Ryan for displaying the inventory
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
}
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
            System.out.println("Choose which item you would like to purchase (Press 1, 2, or 3"); //< asks for user input. ^ prints out shop items ^
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
    
    System.out.println("You wake up in a dirty sewer...");
    System.out.println("You're naked, hungry, dirty, and smelly...");
        
        try {
        Thread.currentThread().sleep(1 * 2000);
    } catch (InterruptedException e) {//rest to build suspense :p
    e.printStackTrace();
    }
        
    System.out.println("You see a light in the distance...");
    //yuou find a stick
        
        try {
        Thread.currentThread().sleep(1 * 2000);
    } catch (InterruptedException e) {//rest to build suspense :p
    e.printStackTrace();
    }

    System.out.println("You enbark forwards towards the light.");
boolean turnEnd= false;
boolean firstBlock=true;

do{//do loop for the fisrt five turns
do{//do loop for the singular turns
if (turns <5 ){
    while(true){
        Scanner newScan= new Scanner(System.in); 
        System.out.println();
        System.out.println("You can go forward (w) or check your inventory/use items (i)");
        String action=newScan.nextLine();    
    if (action.equalsIgnoreCase("i")){
        displayInventory();
    }
    if (action.equalsIgnoreCase("w")){
        turns += 1;
        break;
    }//end of turn "w"
    }//end of while
    double battleNum=Math.random();
    int max1=4;
    int min1=1;
    int battle=(int)(battleNum* max1 + min1);
  
    if (battle==1){
        battleCode();
        if (mcHealth<=0){
            exit(0);
        }
    }//battle if statement
    else{
        System.out.println("You pass freely (nothing happened).");
        System.out.println("you collect 10 gold!");
        gold += 10;
        turnEnd=true;
    }
    }else if (turns == 5){
    shopArea(1);
    firstBlock=false;
    turnEnd=false;
    //at the end of the shop code make fistBlock equal false
}//turn if statement

}while (turnEnd==true);//do loop
}while (firstBlock==true);//do loop for first 5 turns

int turns2=0;
boolean secondBlock=true;
do{
do{
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
    int max1=3;
    int min1=1;
    int battle=(int)(battleNum* max1 + min1);
    
    if (battle==1){
        battleCode();
        if (mcHealth<=0){
            exit(0);
        }
    }//battle if statement
    else{
        System.out.println("You pass freely (nothing happened).");
        System.out.println("you collect 10 gold!");
        gold += 10;
        turnEnd=true;
    }
}//if statemetn for turns 5-9
else if (turns2 == 5){
shopArea(2);
    secondBlock=false;
    turnEnd=false;
}
//at the end of the shop code make fistBlock equal false
}while (turnEnd==true);//do loop
}while (secondBlock==true);


    System.out.println("Big boss fight!!! get ready!");
    bossCode();

    
    }//end of main
}//end of public class

