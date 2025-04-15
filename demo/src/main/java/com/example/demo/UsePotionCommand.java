// public class UsePotionCommand implements Command { public void execute(Player p, GameContext c) {} }
package com.example.demo;
public class UsePotionCommand implements Command {
    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();

        if (!currentRoom.hasPotion()) {
            System.out.println("這裡沒有藥水可用。");
            return;
        }

        currentRoom.removePotion();
        player.heal(30);
        System.out.println("你喝下了藥水，恢復了 30 點 HP！");
        System.out.println("你現在的 HP 是: " + player.getHp());
    }
}
