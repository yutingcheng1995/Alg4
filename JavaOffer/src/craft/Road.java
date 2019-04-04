package craft;

import java.util.ArrayList;

public class Road {
    int rid;
    int length;
    int speedMax;
    int laneNumber;
    int startID;
    int endID;
    int isDual;
    float weight;
    public Road(ArrayList<Integer> roads) {
        this.rid = roads.get(0);
        this.length = roads.get(1);
        this.speedMax = roads.get(2);
        this.laneNumber = roads.get(3);
        this.startID = roads.get(4);
        this.endID = roads.get(5);
        this.isDual = roads.get(6);
        this.weight = 0;
    }
    public int getRid() {
        return rid;
    }

    public double getLength() {
        return length;
    }

    public double getSpeedMax() {
        return speedMax;
    }

    public int getLaneNumber() {
        return laneNumber;
    }

    public int getStartID() {
        return startID;
    }

    public int getEndID() {
        return endID;
    }

    public int getIsDual() {
        return isDual;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSpeedMax(int speedMax) {
        this.speedMax = speedMax;
    }

    public void setLaneNumber(int laneNumber) {
        this.laneNumber = laneNumber;
    }

    public void setStartID(int startID) {
        this.startID = startID;
    }

    public void setEndID(int endID) {
        this.endID = endID;
    }

    public void setIsDual(int isDual) {
        this.isDual = isDual;
    }

    @Override
    public String toString() {
        return "Road{" +
                "rid=" + rid +
                ", length=" + length +
                ", speedMax=" + speedMax +
                ", laneNumber=" + laneNumber +
                ", startID=" + startID +
                ", endID=" + endID +
                ", isDual=" + isDual +
                '}';
    }
}
