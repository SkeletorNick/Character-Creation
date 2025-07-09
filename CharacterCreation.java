/*
 * Title: CharacterCreation.java
 * Abstract: Makes a legal DnD chacracter guven a level and gives the optimized stat sheet given a 4d6 drop the lowest stat spread
 * Author: Nicholas Dimitriou
 * Email: 
 * Date: 3/8/2025
 */
import java.util.Random;
import java.util.Scanner;
public class CharacterCreation {
    public static void main(String[] args) {
        String levelDefiner = "Enter in desired legal level(1-20) type 0 to end: ";
        Scanner s = new Scanner(System.in);
        System.out.print(levelDefiner);
        int level = s.nextInt();
        while(level != 0){
            while(level > 20){
                System.out.print(levelDefiner);
                level = s.nextInt();
            }
            Random r = new Random();
            String[] classes = {"Artificer","Barbarian","Bard","Cleric","Druid","Fighter","Monk","Paladin","Ranger","Rogue","Sorcerer","Warlock","Wizard"};
            int number = Math.abs(r.nextInt()%13);
            String power = classes[number];
            System.out.println("Class: "+power);
            int[] stats = new int[6];
            for(int i = 0; i<stats.length;i++){
                int[] roll = new int[4];
                for(int j = 0; j<roll.length;j++){
                    int rolled = Math.abs(r.nextInt()%6) +1;

                    roll[j]= rolled;
                }
                int min = Integer.MAX_VALUE;
                int minPoint = 0;
                for(int j = 0; j<roll.length;j++){
                    if(roll[j]<min){
                        min = roll[j];
                        minPoint = j;
                    }

                }
                roll[minPoint]= 0;
                int val = 0;
                for(int j = 0; j<roll.length;j++){
                    val += roll[j];
                }
                stats[i]= val;
            }
            System.out.print("Stats: ");
            for(int k = 0; k <stats.length;k++){
                System.out.print(stats[k]+ " ");
            }
            for(int i = 1; i<stats.length;i++){
                int key =stats[i];
                int j = i-1;
                while(j>= 0 && stats[j]> key){
                    stats[j+1] = stats[j];
                    j= j-1;
                }
                stats[j+1]=key;
            }
            System.out.println();
            makeCharacter(power, stats, level, r, s);
            System.out.print(levelDefiner);
            level = s.nextInt();
        }
    }
    public static void makeCharacter(String power, int[] stats, int level, Random r, Scanner s){
        if(power == "Artificer"){
            artificer(stats, level, r);
        }else if(power == "Barbarian"){
            barbarian(stats, level ,r);
        }else if(power == "Bard"){
            bard(stats, level ,r);
        }else if(power == "Cleric"){
            cleric(stats, level ,r);
        }else if(power == "Druid"){
            druid(stats, level, r);
        }else if(power == "Fighter"){
            fighter(stats, level ,r);
        }else if(power == "Monk"){
            monk(stats, level, r);
        }else if(power == "Paladin"){
            paladin(stats, level ,r);
        }else if(power == "Ranger"){
            ranger(stats, level ,r);
        }else if(power == "Rogue"){
            rogue(stats, level ,r);
        }else if(power == "Sorcerer"){
            sorcerer(stats, level ,r);
        }else if(power == "Warlock"){
            warlock(stats, level ,r);
        }else{
            wizard(stats, level ,r);
        }
    }
    public static void artificer(int[] stats, int level, Random r){
        int conMod = getModifer(stats[4]);
        int hp = 8+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%8)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Dex: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Int: "+ stats[5]+" "+getModifer(stats[5]));
        System.out.println("Wis: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Cha: "+ stats[1]+" "+getModifer(stats[1]));
    }
    private static void barbarian(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[4]);
        int hp = 12+ conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%12)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[5]+" "+getModifer(stats[5]));
        System.out.println("Dex: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Int: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Wis: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Cha: "+ stats[1]+" "+getModifer(stats[1]));
    }
    private static void bard(int[] stats, int level, Random r){
        int conMod = getModifer(stats[3]);
        int hp = 8+ conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%8)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Dex: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Con: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Int: "+ stats[1]+" "+getModifer(stats[1]));
        System.out.println("Wis: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Cha: "+ stats[5]+" "+getModifer(stats[5]));
    }
    private static void cleric(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[3]);
        int hp = 8+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%8)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Dex: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Con: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Int: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Wis: "+ stats[5]+" "+getModifer(stats[5]));
        System.out.println("Cha: "+ stats[1]+" "+getModifer(stats[1]));
    }
    private static void druid(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[4]);
        int hp = 8+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%8)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Dex: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Int: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Wis: "+ stats[5]+" "+getModifer(stats[5]));
        System.out.println("Cha: "+ stats[1]+" "+getModifer(stats[1]));
    }
    private static void fighter(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[4]);
        int hp = 10+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%10)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[5]+" "+getModifer(stats[5]));
        System.out.println("Dex: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Int: "+ stats[1]+" "+getModifer(stats[1]));
        System.out.println("Wis: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Cha: "+ stats[0]+" "+getModifer(stats[0]));
    }
    private static void monk(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[3]);
        int hp = 8+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%8)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Dex: "+ stats[5]+" "+getModifer(stats[5]));
        System.out.println("Con: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Int: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Wis: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Cha: "+ stats[1]+" "+getModifer(stats[1]));
    }
    private static void paladin(int[] stats, int level, Random r) {
        System.out.print("Choose between Dex(0) and Str(1) build:");
        int conMod = getModifer(stats[3]);
        int hp = 10+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%10)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        Scanner s = new Scanner(System.in);
        String input = s.next();
        if (input.equals("0") || input.equals("Dex")) {
            System.out.println("Health: "+ hp);
            System.out.println("Str: "+ stats[1]+" "+getModifer(stats[1]));
            System.out.println("Dex: "+ stats[5]+" "+getModifer(stats[5]));
            System.out.println("Con: "+ stats[3]+" "+getModifer(stats[3]));
            System.out.println("Int: "+ stats[0]+" "+getModifer(stats[0]));
            System.out.println("Wis: "+ stats[2]+" "+getModifer(stats[2]));
            System.out.println("Cha: "+ stats[4]+" "+getModifer(stats[4]));
        }else{
            System.out.println("Health: "+ hp);
            System.out.println("Str: "+ stats[5]+" "+getModifer(stats[5]));
            System.out.println("Dex: "+ stats[1]+" "+getModifer(stats[1]));
            System.out.println("Con: "+ stats[3]+" "+getModifer(stats[3]));
            System.out.println("Int: "+ stats[0]+" "+getModifer(stats[0]));
            System.out.println("Wis: "+ stats[2]+" "+getModifer(stats[2]));
            System.out.println("Cha: "+ stats[4]+" "+getModifer(stats[4]));
        }
    }
    private static void ranger(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[3]);
        int hp = 10+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%10)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.print("Choose between Dex(0) Str(1) and Wis(2) build:");
        Scanner s = new Scanner(System.in);
        String input = s.next();
        if (input.equals("0") || input.equals("Dex")) {

            System.out.println("Health: "+ hp);
            System.out.println("Str: "+ stats[1]+" "+getModifer(stats[1]));
            System.out.println("Dex: "+ stats[5]+" "+getModifer(stats[5]));
            System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
            System.out.println("Int: "+ stats[2]+" "+getModifer(stats[2]));
            System.out.println("Wis: "+ stats[3]+" "+getModifer(stats[3]));
            System.out.println("Cha: "+ stats[0]+" "+getModifer(stats[0]));
        }else{
            if((input.equals("1") || input.equals("Str"))){
                System.out.println("Health: "+ hp);
                System.out.println("Str: "+ stats[5]+" "+getModifer(stats[5]));
                System.out.println("Dex: "+ stats[4]+" "+getModifer(stats[4]));
                System.out.println("Con: "+ stats[3]+" "+getModifer(stats[3]));
                System.out.println("Int: "+ stats[1]+" "+getModifer(stats[1]));
                System.out.println("Wis: "+ stats[2]+" "+getModifer(stats[2]));
                System.out.println("Cha: "+ stats[0]+" "+getModifer(stats[0]));
            }else{
                System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
                System.out.println("Dex: "+ stats[4]+" "+getModifer(stats[4]));
                System.out.println("Con: "+ stats[3]+" "+getModifer(stats[3]));
                System.out.println("Int: "+ stats[1]+" "+getModifer(stats[1]));
                System.out.println("Wis: "+ stats[5]+" "+getModifer(stats[5]));
                System.out.println("Cha: "+ stats[2]+" "+getModifer(stats[2]));
            }
        }
    }
    private static void rogue(int[] stats, int level, Random r) {
        System.out.print("Is this an Aracne Trickster y/n:");
        Scanner s = new Scanner(System.in);
        String input = s.next();
        if(input.equals("y")){
            int conMod = getModifer(stats[3]);
            int hp = 8+conMod;
            for(int i = 0; i< level-1;i++){
                int health = conMod+Math.abs(r.nextInt()%8)+1;
                if(health <= 0){
                    hp += 1;
                }else{
                    hp += health;
                }
            }
            System.out.println("Health: "+ hp);
            System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
            System.out.println("Dex: "+ stats[5]+" "+getModifer(stats[5]));
            System.out.println("Con: "+ stats[3]+" "+getModifer(stats[3]));
            System.out.println("Int: "+ stats[4]+" "+getModifer(stats[4]));
            System.out.println("Wis: "+ stats[2]+" "+getModifer(stats[2]));
            System.out.println("Cha: "+ stats[1]+" "+getModifer(stats[1]));
        }else{
            int conMod = getModifer(stats[4]);
            int hp = 8+conMod;
            for(int i = 0; i< level-1;i++){
                int health = conMod+Math.abs(r.nextInt()%8)+1;
                if(health <= 0){
                    hp += 1;
                }else{
                    hp += health;
                }
            }
            System.out.println("Health: "+ hp);
            System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
            System.out.println("Dex: "+ stats[5]+" "+getModifer(stats[5]));
            System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
            System.out.println("Int: "+ stats[1]+" "+getModifer(stats[1]));
            System.out.println("Wis: "+ stats[3]+" "+getModifer(stats[3]));
            System.out.println("Cha: "+ stats[2]+" "+getModifer(stats[2]));
        }
    }
    private static void sorcerer(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[4]);
        int hp = 6+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%6)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Dex: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Int: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Wis: "+ stats[1]+" "+getModifer(stats[1]));
        System.out.println("Cha: "+ stats[5]+" "+getModifer(stats[5]));
    }
    private static void warlock(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[4]);
        int hp = 8+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%8)+1;
            if(health <= 0){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Dex: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Int: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Wis: "+ stats[1]+" "+getModifer(stats[1]));
        System.out.println("Cha: "+ stats[5]+" "+getModifer(stats[5]));
    }
    private static void wizard(int[] stats, int level, Random r) {
        int conMod = getModifer(stats[4]);
        int hp = 6+conMod;
        for(int i = 0; i< level-1;i++){
            int health = conMod+Math.abs(r.nextInt()%6)+1;
            if(health < 1){
                hp += 1;
            }else{
                hp += health;
            }
        }
        System.out.println("Health: "+ hp);
        System.out.println("Str: "+ stats[0]+" "+getModifer(stats[0]));
        System.out.println("Dex: "+ stats[3]+" "+getModifer(stats[3]));
        System.out.println("Con: "+ stats[4]+" "+getModifer(stats[4]));
        System.out.println("Int: "+ stats[5]+" "+getModifer(stats[5]));
        System.out.println("Wis: "+ stats[2]+" "+getModifer(stats[2]));
        System.out.println("Cha: "+ stats[1]+" "+getModifer(stats[1]));
    }
    public static int getModifer(int baseValue){
        int modifier =(baseValue-10)/2;
        if(baseValue < 10 && baseValue%2 != 0){
            modifier--;
        }
        return modifier;
    }
}
