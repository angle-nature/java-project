package package07;

public class DemoGame {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("艾希");
//        hero.setSkill(new SkillImp());
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("水晶箭");
            }
        });
        hero.attack();
    }
}
