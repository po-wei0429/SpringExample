// public class Player {
//     private String name;
//     private int hp;
//     private int attack;
//     private int killCount = 0;
//     private int totalDamage = 0;

//     public Player(String name, int hp, int attack) {
//         this.name = name;
//         this.hp = hp;
//         this.attack = attack;
//     }

//     public boolean isAlive() { return hp > 0; }
//     public void takeDamage(int dmg) { hp -= dmg; }
//     public int getHp() { return hp; }
//     public int getAttack() { return attack; }
//     public void addKill() { killCount++; }
//     public void addDamage(int dmg) { totalDamage += dmg; }
// }
package com.example.demo;
public class Player {
    private String name;
    private int hp;
    private int attack;
    private int killCount = 0;
    private int totalDamage = 0;
    private int spendtime = 0;

    public Player(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }

    public int getHp() {
        return hp;
    }

    public int getspendtime() {
        return spendtime;
    }

    public int getAttack() {
        spendtime += 1;
        return attack;
    }

    public void addKill() {
        killCount++;
    }

    public void addDamage(int dmg) {
        totalDamage += dmg;
    }

    public int getKillCount() {
        return killCount;
    }

    public int getTotalDamage() {
        return totalDamage;
    }

    public void heal(int value) {
        hp += value;    
    }
    public void status() {
        System.out.println("======玩家狀態=====：");
        System.out.println("名稱: " + name);
        System.out.println("HP: " + hp);
        System.out.println("攻擊力: " + attack);
        System.out.println("擊殺數: " + killCount);
        System.out.println("總傷害: " + totalDamage);
    }
}
