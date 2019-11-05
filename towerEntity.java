import java.awt.*;

public class towerEntity {

    private int x, y, scope, dame;

    public towerEntity(int x, int y, int scope, int dame){
        this.x = x;
        this.y = y;
        this.scope = 2*scope;
        this.dame = dame;
    }

    public void tick(){

    }
    public void render(Graphics g){
        g.drawImage(Assets.t1,x,y,null);
        g.drawOval(x - 150, y - 150, scope, scope);
    }

}
