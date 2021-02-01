package geekbrains.couse2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Able[] participants = {new Cat(6000, 3.5f), new Human(40000, 2.5f), new Robot(50000, 4.3f)}; // создаем ссылку на массив объектов с общим родительским интерфейсом Able
        Obstacle[] obstacles = {new Wall(2), new RunningTrack(1000),
                new Wall(3), new RunningTrack(1500), new Wall(4.3f)}; // создаем ссылку на массив объектов с общим родит интерфейсом Obstacle

        for (Obstacle obstacle : obstacles) {
            System.out.println(obstacle);
            for (int i = 0; i < participants.length; i++) {
                if (participants[i] != null) {
                    boolean isSucces = obstacle.createObstacle(participants[i]);
                    if (!isSucces) {
                        participants[i] = null; // если участник не может преодолеть препятствие, его удаляют = null
                    }
                }
            }
            System.out.print("Resting participants  :");
            printParticipants(participants);
        }
    }

    public static void printParticipants(Able[] participants) {
        for (Able participant : participants) {
            if (participant != null) {
                System.out.print(" " + participant);
            }

        }
    }
}
