package engine;


import players.*;
import javax.swing.*;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static File absolutePath;

    public static ArrayList<Entity> players= new ArrayList<>();
    static ArrayList<String> levels= new ArrayList<>();
    static int numberLevels;
    public static void main(String[] args) {

        try {
            absolutePath = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        GameWorking();

        }

    public static void GameWorking() {
        levels();
        Scanner myObj = new Scanner(System.in);
        System.out.println("How many players");

        int playercount = myObj.nextInt();
        myObj.nextLine();
        pointAllocation(playercount, myObj);
        myObj.close();

        for (String s:levels) {

            Levels level= new Levels(s,players);

        }

    }

    static void levels(){
        int n;
        System.out.println(absolutePath.getAbsolutePath());
        String path=absolutePath.getAbsolutePath()+"\\engine\\levels\\";

        for (File f: Objects.requireNonNull(new File(path).listFiles())) {

            levels.add(path+f.getName());

        }

        n= Objects.requireNonNull(new File(path).list()).length;
        numberLevels= n;
    }

    static void pointAllocation(int playercount, Scanner myObj){

        for (int i = 0; i < playercount; i++) {
            System.out.println(i);

            System.out.println("Character name?");
            String playername = myObj.nextLine();


            Player p = new Player(playername, 1, 1, 1, 1);

            System.out.println("You have 3 points to allocate.");
            System.out.println("How many point to add to HP?");
            int points = myObj.nextInt();
            myObj.nextLine();

            while (points > 3) {
                System.out.println("You tried to allocate too many points.");
                System.out.println("You have 3 points to allocate.");
                System.out.println("How many point to add to HP?");
                points = myObj.nextInt();
                myObj.nextLine();
            }

            p.setHP(p.getHP() + points);
            int temp = 3 - points;
            if (temp > 0) {
                System.out.println("--------------------------------");
                System.out.println("You have " + temp + " points to allocate.");
                System.out.println("How many point to add to strength?");
                points = myObj.nextInt();
                myObj.nextLine();

                while (points > temp) {
                    System.out.println("You tried to allocate too many points.");
                    System.out.println("You have " + temp + " points to allocate.");
                    System.out.println("How many point to add to strength?");
                    points = myObj.nextInt();
                    myObj.nextLine();
                }

                p.setStrength(p.getStrength() + points);
                temp = temp - points;
                if (temp > 0) {
                    System.out.println("--------------------------------");
                    System.out.println("You have " + temp + " points to allocate.");
                    System.out.println("How many point to add to agility?");
                    points = myObj.nextInt();
                    myObj.nextLine();

                    while (points > temp) {
                        System.out.println("You tried to allocate too many points.");
                        System.out.println("You have " + temp + " points to allocate.");
                        System.out.println("How many point to add to agility?");
                        points = myObj.nextInt();
                        myObj.nextLine();
                    }

                    p.setAgility(p.getAgility() + points);
                    temp = temp - points;
                }
            }

            if(temp>0){
                System.out.println("--------------------------------");
                System.out.println("You have not allocated the points correctly.");
                System.out.println("You have "+temp+" points left.");
                System.out.println("Idiot!");
                System.out.println("Restarting character creation...");
                System.out.println("--------------------------------");
                pointAllocation(playercount, myObj);
            }else {
                System.out.println("--------------------------------");
                System.out.println("You have allocated all points.");

                players.add(p);
            }



        }

    }

    }
