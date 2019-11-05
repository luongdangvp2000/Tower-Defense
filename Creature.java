public abstract class Creature extends Entity {


    protected int health;
    protected double speed;

    public Creature(double x, double y){
        super(x, y);
        health = 100;
        speed = 2;
    }

    public double getSpeed() {
        return speed;
    }
    public int getHealth() {
        return health;
    }
}
