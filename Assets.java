import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {
    public static final int width = 70, height = 130, offset = 26, fOffset = 22;
    public static final int offsetf = 28, fOffsetf = 39, widthf = 70, offsetW = 12;
    public static BufferedImage p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, bg, resized;
    public static BufferedImage fp1, fp2, fp3, fp4, fp5, fp6, fp7, fp8, fp9, fp10, fp11, fp12,
                                t1, bullet, blood;

    public static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

    public static void init(){
        SpriteSheet sheet = new SpriteSheet((imageLoader.loadImage("image/bone1.png")));
        SpriteSheet fsheet = new SpriteSheet((imageLoader.loadImage("image/bonef.png")));
        SpriteSheet tower = new SpriteSheet(imageLoader.loadImage("image/tower/towers.png"));
        SpriteSheet Bullet = new SpriteSheet(imageLoader.loadImage("image/bullet/bullet.png"));
        SpriteSheet bloodBar = new SpriteSheet(imageLoader.loadImage("image/blood/bloodBar.png"));

        blood = bloodBar.crop(20,0,1250,90);
        blood = resize(blood,6,70);
        t1 = tower.crop(50,80,460,970);
        bullet = Bullet.crop(0,0,65,65);
        t1 = resize(t1,100,60);
        bullet = resize(bullet,12,12);

        p1 = sheet.crop(fOffset,565,width,height);
        p2 = sheet.crop(width + fOffset + offset,565,width,height);
        p3 = sheet.crop(2*width +fOffset+2*offset,565,width,height);
        p4 = sheet.crop(3*width +fOffset+ 3*offset,565,width,height);
        p5 = sheet.crop(4*width+fOffset+4*offset,565,width,height);
        p6 = sheet.crop(5*width+fOffset +5*offset,565,width,height);
        p7 = sheet.crop(6*width+fOffset + 6*offset,565,width,height);
        p8 = sheet.crop(7*width+fOffset + 7*offset,565,width,height);
        p9 = sheet.crop(8*width+fOffset + 8*offset,565,width,height);
        p10 = sheet.crop(9*width+fOffset + 9*offset,565,width,height);
        p11 = sheet.crop(10*width+fOffset + 10*offset,565,width,height);
        p12 = sheet.crop(11*width+fOffset + 11*offset,565,width,height);
        p1 = resize(p1,height/3, width/3);
        p2 = resize(p2,height/3, width/3);
        p3 = resize(p3,height/3, width/3);
        p4 = resize(p4,height/3, width/3);
        p5 = resize(p5,height/3, width/3);
        p6 = resize(p6,height/3, width/3);
        p7 = resize(p7,height/3, width/3);
        p8 = resize(p8,height/3, width/3);
        p9 = resize(p9,height/3, width/3);
        p10 = resize(p10,height/3, width/3);
        p11 = resize(p11,height/3, width/3);
        p12 = resize(p12,height/3, width/3);

        //flip

        fp1 = fsheet.crop(fOffset,565,width,height);
        fp2 = fsheet.crop(widthf + fOffsetf + offsetf,565,width+offsetW,height);
        fp3 = fsheet.crop(2*widthf +fOffsetf+2*offsetf,565,width+offsetW,height);
        fp4 = fsheet.crop(3*widthf +fOffsetf+ 3*offsetf,565,width+offsetW,height);
        fp5 = fsheet.crop(4*widthf+fOffsetf+4*offsetf,565,width+offsetW,height);
        fp6 = fsheet.crop(5*widthf+fOffsetf +5*offsetf,565,width+offsetW,height);
        fp7 = fsheet.crop(6*widthf+fOffsetf + 6*offsetf,565,width+offsetW,height);
        fp8 = fsheet.crop(7*widthf+fOffsetf + 7*offsetf,565,width+offsetW,height);
        fp9 = fsheet.crop(8*widthf+fOffsetf + 8*offsetf,565,width+offsetW,height);
        fp10 = fsheet.crop(9*widthf+fOffsetf + 9*offsetf,565,width+offsetW,height);
        fp11 = fsheet.crop(10*widthf+fOffsetf + 10*offsetf,565,width+offsetW,height);
        fp12 = fsheet.crop(11*widthf+fOffsetf + 11*offsetf,565,width+offsetW,height);
        fp1 = resize(fp1,height/3, (width+offsetW)/3);
        fp2 = resize(fp2,height/3, width/3+offsetW/3);
        fp3 = resize(fp3,height/3, width/3+offsetW/3);
        fp4 = resize(fp4,height/3, width/3+offsetW/3);
        fp5 = resize(fp5,height/3, width/3+offsetW/3);
        fp6 = resize(fp6,height/3, width/3+offsetW/3);
        fp7 = resize(fp7,height/3, width/3+offsetW/3);
        fp8 = resize(fp8,height/3, width/3+offsetW/3);
        fp9 = resize(fp9,height/3, width/3+offsetW/3);
        fp10 = resize(fp10,height/3, width/3+offsetW/3);
        fp11 = resize(fp11,height/3, width/3+offsetW/3);
        fp12 = resize(fp12,height/3, width/3+offsetW/3);


        bg = imageLoader.loadImage("image/back_ground/bg2.jpg");

    }

}
