package engine;

import enemies.Enemy;
import players.Player;

import java.util.ArrayList;

public class Fights{

    String path;
    ArrayList<Entity> enemies= new ArrayList<>();

    public Fights(String path, ArrayList<Entity> players) {
        this.path = path;
        //Enemy e = new Enemy("test",1,1,1,1);
        //e.getAgility();

        ArrayList<Entity> priorityQueue= new ArrayList<>();
        priorityQueue.addAll(players);
        priorityQueue.addAll(enemies);
        //priorityQueue.get(0).setHP(99);
        //System.out.println(players.get(0).getHP());

    }


}
