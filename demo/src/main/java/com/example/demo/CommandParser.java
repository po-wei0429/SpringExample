package com.example.demo;
public class CommandParser {
    public static Command parse(String input) {
        if (input.startsWith("move ")) return new MoveCommand(input.substring(5));
        if (input.equals("attack")) return new AttackCommand();
        if (input.equals("look")) return new LookCommand();
        if (input.equals("use potion")) return new UsePotionCommand();
        if (input.startsWith("skill ")) return new SkillCommand(input.substring(6));
        if (input.startsWith("exit")){
            System.out.println("旅途結束。");
            System.exit(0);
        }
        return null;
    }
}

