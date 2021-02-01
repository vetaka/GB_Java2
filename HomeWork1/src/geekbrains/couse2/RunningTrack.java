package geekbrains.couse2;
// Класс Беговая Дорожка
public class RunningTrack implements Obstacle {

    private float distance;

    public RunningTrack(float distance) {

        this.distance = distance;
    }

    @Override
    public boolean createObstacle(Able a) {  // переопределение пустого метода класса Able

        if(!(a instanceof Running)) { //если участник не способен бегать, т.е. объект не является наследником CapableOfRunning
            return false;
        }
        else {
            return ((Running)a).run(distance);// casting
        }
    }


    @Override
    public String toString() {
        return "\n************************\n"
                + "RunningTrack of "+distance+" meters"+
                "\n************************";
    }



}


