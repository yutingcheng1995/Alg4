package craft;

import java.util.ArrayList;

public class Car {
    int id;
    int startCross;
    int endCross;
    int speedMax;
    int time;
    int actTime;

    public Car(ArrayList<Integer> cars) {
        this.id = cars.get(0);
        this.startCross = cars.get(1);
        this.endCross = cars.get(2);
        this.speedMax = cars.get(3);
        this.time = cars.get(4);
        this.actTime = cars.get(4);
    }

    public int getId() {
        return id;
    }

    public int getStartCross() {
        return startCross;
    }

    public int getEndCross() {
        return endCross;
    }

    public int getSpeedMax() {
        return speedMax;
    }

    public int getTime() {
        return time;
    }

    public int getActTime() {
        return actTime;
    }

    public void setActTime(int actTime) {
        this.actTime = actTime;
    }

   /* public DirectedEdge runCar(int time,int speed, ArrayList<DirectedEdge> path){
        for(int  i = 0 ;i < path.size();i++){

        }
    }*/
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", startCross=" + startCross +
                ", endCross=" + endCross +
                ", speedMax=" + speedMax +
                ", time=" + time +
                '}';
    }
}
