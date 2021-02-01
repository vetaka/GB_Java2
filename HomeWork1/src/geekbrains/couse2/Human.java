package geekbrains.couse2;

public class Human implements Running, Jumping{
//    public static float limitRun = 50;
//    public static float limitJump = 3;
    private static float limitRun;
    private static float limitJump;
    Human(float limitRun,float limitJump){
        this.limitRun = limitRun;
        this.limitJump = limitJump;
    }
    @Override
    public String toString() {
        return "Human";
    }


    @Override
    public boolean jump(float height) {
        boolean canJump = height<=limitJump;
        System.out.println(canJump?"Human is jumping":"Human can't jump");
        return canJump;
    }


    @Override
    public boolean run(float distance) {
        boolean canRun = distance<=limitRun;
        limitRun-=distance;
        System.out.println(canRun?"Human is running":"Person can't run");
        return canRun;
    }
}

