package src.leto.cv01;

public class HmotnyBod {
    public HmotnyBod(double x, double y, double m){
        this.x = x;
        this.y = y;
        this.weight = m;
    }
    double x;
    double y;
    double weight;

    public double getWeight() {
        return weight;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
