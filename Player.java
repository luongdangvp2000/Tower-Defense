import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Game game;

    private int act,k=0;
    private int[] maxY = {100,330,620};
    private int[] minY = {0,240,560};
    private boolean actX = true, actY = true, isFlip = false;
    private BufferedImage img;

    public Player(Game game, double x, double y) {
        super(x, y);
        this.game = game;
    }

    @Override
    public void tick() {
        // Move if actY enermy move cross by X
        if(actY) {

            // if actX enermy go ahead

            if (actX)
                x += speed;
            else
                x -= speed;

            // if(isFlip) enermy flip
            if(isFlip)
                actX = false;
            else
                actX = true;

            //State of enermy
            act++;
            if (act >= 10)
                act = 0;

            // Y
            double ran = Math.random() * ((1 - (-1.5)) +1)-1.5;
            y += ran;

            //Make sure enermy can be go out their way
            if (y >= maxY[k])
                y = maxY[k];
            if (y <= minY[k])
                y = minY[k];

            // enermy go to the new line
            if(x >= 1200){
                actY = false;
                if(k == 0)
                    k = 1;
            }
            if(x<=10 && isFlip){
                actY = false;
                if(k == 1)
                    k = 2;
            }

            //if enrmy go to their end way
            if(x>=1210 && y>= 560) {
                if(health > 0)
                    game.setScore(game.getScore()-1);
                this.health = 0;
            }
        } else {

            // enermy State
            act++;
            if (act >= 10)
                act = 0;

            // enermy moves folow y axis
            x+= 0.5;
            y += 3;
            if(y >= minY[k]){
                actY = true;
                if(k == 1)
                    isFlip = true;
                if(k == 2)
                    isFlip = false;
            }

        }

    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(Color.red);
        g.drawString("your Score " + game.getScore(),1000,50);
        double h1 = health*0.7;
        if (health > 0)
            img = Assets.resize(Assets.blood, 8, (int) h1);
        g.drawImage(img, (int) x-20, (int) y-20, null);
        if(!isFlip) {
            switch (act) {
                case 0:
                    g.drawImage(Assets.p1, (int) x, (int) y, null);
                    break;
                case 1:
                    g.drawImage(Assets.p2, (int) x, (int) y, null);
                    break;
                case 2:
                    g.drawImage(Assets.p3, (int) x, (int) y, null);
                    break;
                case 4:
                    g.drawImage(Assets.p5, (int) x, (int) y, null);
                    break;
                case 5:
                    g.drawImage(Assets.p6, (int) x, (int) y, null);
                    break;
                case 6:
                    g.drawImage(Assets.p7, (int) x, (int) y, null);
                    break;
                case 7:
                    g.drawImage(Assets.p8, (int) x, (int) y, null);
                    break;
                case 8:
                    g.drawImage(Assets.p9, (int) x, (int) y, null);
                    break;
                case 9:
                    g.drawImage(Assets.p10, (int) x, (int) y, null);
                    break;
                case 10:
                    g.drawImage(Assets.p11, (int) x, (int) y, null);
                    break;
                default:
                    g.drawImage(Assets.p1, (int) x, (int) y, null);
                    break;
            }
        }else{
            switch (act) {
                case 0:
                    g.drawImage(Assets.fp1, (int) x, (int) y, null);
                    break;
                case 1:
                    g.drawImage(Assets.fp2, (int) x, (int) y, null);
                    break;
                case 2:
                    g.drawImage(Assets.fp3, (int) x, (int) y, null);
                    break;
                case 4:
                    g.drawImage(Assets.fp5, (int) x, (int) y, null);
                    break;
                case 5:
                    g.drawImage(Assets.fp6, (int) x, (int) y, null);
                    break;
                case 6:
                    g.drawImage(Assets.fp7, (int) x, (int) y, null);
                    break;
                case 7:
                    g.drawImage(Assets.fp8, (int) x, (int) y, null);
                    break;
                case 8:
                    g.drawImage(Assets.fp9, (int) x, (int) y, null);
                    break;
                case 9:
                    g.drawImage(Assets.fp10, (int) x, (int) y, null);
                    break;
                case 10:
                    g.drawImage(Assets.fp11, (int) x, (int) y, null);
                    break;
                default:
                    g.drawImage(Assets.fp1, (int) x, (int) y, null);
                    break;
            }
        }
    }

    //Function
    public int getX(){
        return (int)this.x;
    }
    public int getY(){
        return (int)this.y;
    }
}
