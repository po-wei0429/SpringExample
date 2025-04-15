// public class LookCommand implements Command { public void execute(Player p, GameContext c) {} }
package com.example.demo;
public class LookCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();
        System.out.println("你觀察四周...\n");
        System.out.println("地點：「" + currentRoom.getName() + "」");
        System.out.println(currentRoom.getDescription());

        // 顯示怪物狀態
        Monster monster = currentRoom.getMonster();
        if (monster != null && monster.isAlive()) {
            System.out.println("你看到了怪物：「" + monster.getName() + "」，HP: " + monster.getHp());
        } else {
            System.out.println("這裡沒有活著的怪物。");
        }

        // 顯示藥水
        if (currentRoom.hasPotion()) {
            System.out.println("你發現了一瓶藥水！");
        }

        // 顯示出口
        String exits = currentRoom.getExitString();
        if (!exits.isEmpty()) {
            System.out.println("可移動方向：" + exits);
        } else {
            System.out.println("這裡似乎沒有出口。");
        }
    }
}