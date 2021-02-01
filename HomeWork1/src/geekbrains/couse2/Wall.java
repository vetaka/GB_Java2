package geekbrains.couse2;
// Класс Стена
public class Wall implements Obstacle{
    private float height;

    public Wall(float height) {

        this.height = height;
    }

    @Override
    public boolean createObstacle(Able a) {
        if(!(a instanceof Jumping)) {
            return false;
        }
        else {
            return ((Jumping)a).jump(height);// нисходящее преобразование (Downcasting) интерфейса a из Able в Jumpable и вызов его метода jump()
        }
    }

    @Override
    public String toString() {
        return "\n************************\n"
                + "Wall of "+height+" meters"+
                "\n************************";
    }
}

