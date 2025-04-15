// public class AttackCommand implements Command { public void execute(Player p, GameContext c) {} }
package com.example.demo;
public class AttackCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();
        Monster monster = currentRoom.getMonster();

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有可以攻擊的怪物。");
            return;
        }

        int damage = player.getAttack();
        monster.takeDamage(damage);
        player.addDamage(damage);
        System.out.println("你攻擊了「" + monster.getName() + "」，造成 " + damage + " 點傷害！");
        System.out.println(monster.getName() + "還剩下 " + monster.getHp() + " 血量！");
        if (!monster.isAlive()) {
            System.out.println("你擊敗了「" + monster.getName() + "」！");
            player.addKill();
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