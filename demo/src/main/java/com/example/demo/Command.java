package com.example.demo;

public interface Command {
    void execute(Player player, GameContext context);
}
