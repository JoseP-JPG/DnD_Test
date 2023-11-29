package engine;

import enemies.Enemy;
import players.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Levels {

    String path;
    ArrayList<String> fights = new ArrayList<>();

    public Levels(String path, ArrayList<Entity> players) {
        this.path = path;
        System.out.println(path);
        long amount = 1;
        for (File f : Objects.requireNonNull(new File(path).listFiles())) {

            if (f.getName().contains("param.json")) {
                Object obj = null;
                try {
                    obj = new JSONParser().parse(new FileReader(path + "\\param.json"));
                    JSONObject jo = (JSONObject) obj;
                    amount = (long) jo.get("amount");
                    System.out.println("amount: " + amount);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else {
                fights.add(path + "\\" + f.getName());

            }
        }

            System.out.println(fights.size());
            for (int i = 0; i < amount; i++) {
                Random rand = new Random();
                int rand_int = rand.nextInt(fights.size());
                Fights fight = new Fights(fights.get(rand_int), players);
                fights.remove(rand_int);
            }

        }


    }

