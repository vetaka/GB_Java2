package geekbrains.couse2;
// Класс кота
public class Cat implements Running, Jumping{

private static float limitRun;
private static float limitJump;
    Cat(float limitRun,float limitJump){
        this.limitRun = limitRun;
        this.limitJump = limitJump;
    }

    @Override
    public String toString() {
        return "Cat ";
    }


    @Override
    public boolean jump(float height) {
        boolean canJump = height<=limitJump;
        System.out.println(canJump?"Cat is jumping":"Cat can't jump");
        return canJump;
    }


    @Override
    public boolean run(float distance) {   //переопределение метода из род.кл. Able -> CapableOfRunning
        boolean canRun = distance<=limitRun;
        limitRun-=distance;
        System.out.println(canRun?"Cat is running":"Cat can't run");
        return canRun;
    }
}