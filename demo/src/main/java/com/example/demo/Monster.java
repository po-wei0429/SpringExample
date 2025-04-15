package com.example.demo;
public class Monster {
    private String name;
    private int hp;
    private int attack;

    public Monster(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() { return name; }
    public boolean isAlive() { return hp > 0; }
    public void takeDamage(int damage) { hp -= damage; }
    public int getAttack() { return attack; }
    public int getHp() { return hp; }
    public void heal(int value) {
        hp += value;    
    }
    public void increasedamage() {
        attack *= 1.5;    
    }
}
