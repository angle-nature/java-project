package package07;

public class Hero {

    private String name;
    private Skill skill;

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public void attack(){
        System.out.println(name + "释放了技能");
        skill.use();
        System.out.println("技能释放完成！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }
}
