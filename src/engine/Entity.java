package engine;

public abstract class Entity {

    String name;
    int priority;
    final int maxHP;
    int HP;
    int strength;
    int agility;
    int lvl=1;

    public Entity(String name, int HP, int strength, int agility, int priority) {
        this.name = name;
        this.maxHP = HP;
        this.HP = HP;
        this.strength = strength;
        this.agility = agility;
        this.priority=priority;
    }

    public int getAgility() {
        return agility;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getPriority() {
        return priority;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}
