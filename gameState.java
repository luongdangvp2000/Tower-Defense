import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class gameState extends State {
    private List<Player> enermy;
    private Player player;
    private List<Tower> towers;
    private Tower tower;
    private int towerX = 150, towerY = 150, select = 0;

    private double[] ranX;
    private boolean win = false, lose = false;


    public gameState(Game game) {
        super(game);
        intiEnermy();
        initiTower();
    }

    public void intiEnermy () {
        numberEnermy = 8;
        ranX = new double[numberEnermy];
        enermy = new ArrayList<>();
        player = new Player(game, 0 ,0);
        for(int i = 0; i< numberEnermy; ++i){
            ranX[i] = Math.random()*((50-(-50))+1)-50;
            Player e = new Player(game, ranX[i]-150 , -5);
            enermy.add(e);
        }
    }

    public void initiTower () {
        towers = new ArrayList<>();
        tower = new Tower(towerX, towerY);
        towers.add(new Tower(towerX*6, 140));
        towers.add(new Tower(towerX,towerY*3));
        towers.add(new Tower(towerX*6, towerY*3));
    }



    @Override
    public void tick() {
        // Select random enermy in scope to hit
        if(enermy.size() > 0 ) {
            if (!isInside(enermy.get(select).x, enermy.get(select).y))
                select++;

            if (select >= enermy.size() - 1)
                select = 0;

            tower.tick(enermy.get(select).x, enermy.get(select).y);
            for (Tower t : towers) {
                t.tick(enermy.get(select).x, enermy.get(select).y);
            }
        } else {
            win = true;
        }
        //End select

        for(int i = 0; i < enermy.size(); ++i){
            enermy.get(i).tick();
        }

        //Collision
        for(int i = 0; i < enermy.size(); ++i) {
            if (isCollision(this.tower, enermy.get(i))) {
                enermy.get(i).health -= tower.getDame();
            }
        }

        //is die
        for(int i = 0; i < numberEnermy; ++i){
            if(enermy.get(i).health <=0 ) {
                tower.resetXb();
                tower.restYb();
                enermy.remove(i);
                numberEnermy--;
            }
        }

    }

    @Override
    public void render(Graphics g) {

        tower.render(g);

        for(int i = 0; i < numberEnermy; ++i){
            enermy.get(i).render(g);
        }

        for (Tower t : towers) {
            t.render(g);
        }
        //win
        if(game.Score > 0 && enermy.size()<=0) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
            g.setColor(Color.red);
            g.drawString("YOU WIN", 400, 400);
        }
        //lose
        if(game.getScore() <=0) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
            g.setColor(Color.red);
            g.drawString("LOSE", 400, 400);
        }
    }

    // function
    private boolean isInside(double x, double y){
        return x - towerX <= 200 && y - towerY <=200;
    }

    private boolean isCollision(Tower tower, Player enermy){
        return isInside(enermy.getX(), enermy.getY()) && Math.abs(tower.getxB() - enermy.getX())<= 10 && Math.abs(tower.getyB() - enermy.getY())<=10;
    }

}
