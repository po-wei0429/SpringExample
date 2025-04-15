package com.example.demo;
// public class FireballSkill implements Skill { public String getName() { return "fireball"; } public void use(Player p, Monster m) {} }
public class FireballSkill implements Skill {
    @Override
    public String getName() {
        return "fireball";
    }

    @Override
    public void use(Player player, Monster monster) {
        int damage = player.getAttack() * 2;
        monster.takeDamage(damage);
        player.addDamage(damage);
        System.out.println("你施放了火球術🔥，對「" + monster.getName() + "」造成 " + damage + " 點火焰傷害！");
        System.out.println(monster.getName() + "還剩下 " + monster.getHp() + " 血量！");
        if (!monster.isAlive()) {
            System.out.println("你燒死了「" + monster.getName() + "」！");
            player.addKill();
            System.out.println("總共花了" + player.getspendtime() + "回合 ");
            player.status();
        } else {
            int counter = monster.getAttack();
            player.takeDamage(counter);
            System.out.println("「" + monster.getName() + "」反擊你，造成 " + counter + " 點傷害！");
            System.out.println("你目前剩下 HP: " + player.getHp());
            if (monster.getHp() <= 20) {
                System.out.println(monster.getName() + "暴走了！"); 
                monster.heal(10) ;
                monster.increasedamage();
                System.out.println(monster.getName() + "的傷害1.5倍了！" + "目前傷害為" + monster.getAttack());
                System.out.println(monster.getName() + "的血量回復了10點！目前血量為" + monster.getHp());
            }
        }
    }
}
