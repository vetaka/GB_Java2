package geekbrains.couse2;

public class Robot implements Running, Jumping {
    private static float limitRun;
    private static float limitJump;

    Robot(float limitRun, float limitJump) {
        this.limitRun = limitRun;
        this.limitJump = limitJump;
    }

    @Override
    public String toString() {
        return "Robot";
    }


    @Override
    public boolean jump(float height) {
        boolean canJump = height<=limitJump;
        System.out.println(canJump?"Robot is jumping":"Robot can't jump");
        return canJump;
    }


    @Override
    public boolean run(float distance) {
        boolean canRun = distance<=limitRun;
        limitRun-=distance;
        System.out.println(canRun?"Robot is running":"Robot can't run");
        return canRun;
    }
}

