package com.example.demo;
import java.util.Scanner;

public class GameEngine {
    private GameContext context;
    private Scanner scanner = new Scanner(System.in);

    public GameEngine(GameContext context) {
        this.context = context;
    }

    public void start() {
        
        System.out.println("[ 遊戲開始！歡迎勇者！ ]");
    
        while (context.getPlayer().isAlive()) {
            System.out.println("\n你目前在：" + context.getCurrentRoom().getName());
            System.out.print("> ");
            String input = scanner.nextLine();
            Command command = CommandParser.parse(input);
            if (command != null) {
                command.execute(context.getPlayer(), context);
            } else {
                System.out.println("無效的指令。");
                System.out.println("可用指令：");
                System.out.println("move <方向> - 移動到指定方向");
                System.out.println("attack - 攻擊當前怪物");
                System.out.println("look - 查看當前房間");
                System.out.println("use potion - 使用藥水");
                System.out.println("skill <技能名稱> - 使用指定技能");
                System.out.println("可以使用技能：fireball");
                System.out.println("exit - 退出遊戲");
            }
        }
        System.out.println("你已死亡，遊戲結束。");
    }
}
