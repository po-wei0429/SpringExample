// public class SkillCommand implements Command { public SkillCommand(String name) {} public void execute(Player p, GameContext c) {} }
package com.example.demo;
public class SkillCommand implements Command {
    private final String skillName;

    public SkillCommand(String name) {
        this.skillName = name;
    }

    @Override
    public void execute(Player player, GameContext context) {
        Room currentRoom = context.getCurrentRoom();
        Monster monster = currentRoom.getMonster();

        if (monster == null || !monster.isAlive()) {
            System.out.println("這裡沒有可以施放技能的對象。");
            return;
        }

        Skill skill = null;
        if ("fireball".equalsIgnoreCase(skillName)) {
            skill = new FireballSkill();
        }

        if (skill != null) {
            skill.use(player, monster);
        } else {
            System.out.println("你不會這個技能：「" + skillName + "」");
        }
    }
}
