import java.awt.*;

public class Bullet {
    private int x, y, dame;

    public Bullet(int x, int y, int dame) {
        this.x = x;
        this.y = y;
        this.dame = dame;

    }

    public void tick(){

    }

    public void rend (Graphics g){
        g.drawImage(Assets.bullet, x, y, null);
    }


}
