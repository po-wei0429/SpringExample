package com.example.demo;
// public class MoveCommand implements Command { public void execute(Player p, GameContext c) {} }
public class MoveCommand implements Command {
    private final String direction;

    public MoveCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom != null) {
            context.setCurrentRoom(nextRoom);
            System.out.println("你往 " + direction + " 方向移動。");
            System.out.println("你來到了「" + nextRoom.getName() + "」。");
            System.out.println(nextRoom.getDescription());
        } else {
            System.out.println("那個方向沒有路。");
        }
    }
}
