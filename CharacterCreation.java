
import java.util.Random;
import java.util.Scanner;

public class CharacterCreation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter in desired legal level type 0 to end: ");
        int level = s.nextInt();
        while(level != 0){
            while(level > 20){
                System.out.print("Enter in desired legal level type 0 to end: ");
                level = s.nextInt();
            }
            Random r = new Random();
            String[] classes = {"Artificer","Barbarian","Bard","Cleric","Druid","Fighter","Monk","Paladin","Ranger","Rouge","Sorcerer","Warlock","Wizard"};
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
            makeCharacter(power, stats, level, r);
            System.out.print("Enter in desired legal level type 0 to end: ");
            level = s.nextInt();
        }
    }

    public static void makeCharacter(String power, int[] stats, int level, Random r){
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
        }else if(power == "Rouge"){
            rouge(stats, level ,r);
        }else if(power == "Sorcerer"){
            sorcerer(stats, level ,r);
        }else if(power == "Warlock"){
            warlock(stats, level ,r);
        }else{
            wizard(stats, level ,r);
        }
    }
    public static void artificer(int[] stats, int level, Random r){
        int conMod = (stats[4]-10)/2;
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
        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[3]);
        System.out.println("Con: "+ stats[4]);
        System.out.println("Int: "+ stats[5]);
        System.out.println("Wis: "+ stats[2]);
        System.out.println("Cha: "+ stats[1]);
    }
    private static void barbarian(int[] stats, int level, Random r) {
        int conMod = (stats[4]-10)/2;
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
        System.out.println("Str: "+ stats[5]);
        System.out.println("Dex: "+ stats[3]);
        System.out.println("Con: "+ stats[4]);
        System.out.println("Int: "+ stats[0]);
        System.out.println("Wis: "+ stats[2]);
        System.out.println("Cha: "+ stats[1]);
    }
    private static void bard(int[] stats, int level, Random r){
        int conMod = (stats[3]-10)/2;
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
        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[4]);
        System.out.println("Con: "+ stats[3]);
        System.out.println("Int: "+ stats[1]);
        System.out.println("Wis: "+ stats[2]);
        System.out.println("Cha: "+ stats[5]);
    }
    private static void cleric(int[] stats, int level, Random r) {
        int conMod = (stats[3]-10)/2;
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
        System.out.println("Str: "+ stats[4]);
        System.out.println("Dex: "+ stats[0]);
        System.out.println("Con: "+ stats[3]);
        System.out.println("Int: "+ stats[2]);
        System.out.println("Wis: "+ stats[5]);
        System.out.println("Cha: "+ stats[1]);
    }
    private static void druid(int[] stats, int level, Random r) {
        int conMod = (stats[4]-10)/2;
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
        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[3]);
        System.out.println("Con: "+ stats[4]);
        System.out.println("Int: "+ stats[2]);
        System.out.println("Wis: "+ stats[5]);
        System.out.println("Cha: "+ stats[1]);
    }
    private static void fighter(int[] stats, int level, Random r) {
        int conMod = (stats[4]-10)/2;
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
        System.out.println("Str: "+ stats[5]);
        System.out.println("Dex: "+ stats[2]);
        System.out.println("Con: "+ stats[4]);
        System.out.println("Int: "+ stats[1]);
        System.out.println("Wis: "+ stats[3]);
        System.out.println("Cha: "+ stats[0]);
    }
    private static void monk(int[] stats, int level, Random r) {
        int conMod = (stats[3]-10)/2;
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
        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[5]);
        System.out.println("Con: "+ stats[3]);
        System.out.println("Int: "+ stats[2]);
        System.out.println("Wis: "+ stats[4]);
        System.out.println("Cha: "+ stats[1]);
    }
    private static void paladin(int[] stats, int level, Random r) {
        int conMod = (stats[3]-10)/2;
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
        System.out.println("Str: "+ stats[1]+" or "+stats[5]+"choose if you want ethier dex or str build");
        System.out.println("Dex: "+ stats[1]+" or "+stats[5]+"choose if you want ethier dex or str build");
        System.out.println("Con: "+ stats[3]);
        System.out.println("Int: "+ stats[0]);
        System.out.println("Wis: "+ stats[2]);
        System.out.println("Cha: "+ stats[4]);
    }
    private static void ranger(int[] stats, int level, Random r) {
        int conMod = (stats[3]-10)/2;
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
        System.out.println("Str based:");
        System.out.println("Str: "+ stats[5]);
        System.out.println("Dex: "+ stats[4]);
        System.out.println("Con: "+ stats[3]);
        System.out.println("Int: "+ stats[1]);
        System.out.println("Wis: "+ stats[2]);
        System.out.println("Cha: "+ stats[0]);
        System.out.println("Wis based:");
        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[4]);
        System.out.println("Con: "+ stats[3]);
        System.out.println("Int: "+ stats[1]);
        System.out.println("Wis: "+ stats[5]);
        System.out.println("Cha: "+ stats[2]);
    }
    private static void rouge(int[] stats, int level, Random r) {
        int conMod = (stats[4]-10)/2;
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
        System.out.println("This will not work for an Arcane trickster");
        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[5]);
        System.out.println("Con: "+ stats[4]);
        System.out.println("Int: "+ stats[1]);
        System.out.println("Wis: "+ stats[3]);
        System.out.println("Cha: "+ stats[2]);
    }
    private static void sorcerer(int[] stats, int level, Random r) {
        int conMod = (stats[4]-10)/2;
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

        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[3]);
        System.out.println("Con: "+ stats[4]);
        System.out.println("Int: "+ stats[2]);
        System.out.println("Wis: "+ stats[1]);
        System.out.println("Cha: "+ stats[5]);
    }
    private static void warlock(int[] stats, int level, Random r) {
        int conMod = (stats[4]-10)/2;
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
        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[3]);
        System.out.println("Con: "+ stats[4]);
        System.out.println("Int: "+ stats[2]);
        System.out.println("Wis: "+ stats[1]);
        System.out.println("Cha: "+ stats[5]);
    }
    private static void wizard(int[] stats, int level, Random r) {
        int conMod = (stats[4]-10)/2;
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
        System.out.println("Str: "+ stats[0]);
        System.out.println("Dex: "+ stats[3]);
        System.out.println("Con: "+ stats[4]);
        System.out.println("Int: "+ stats[5]);
        System.out.println("Wis: "+ stats[2]);
        System.out.println("Cha: "+ stats[1]);
    }









}