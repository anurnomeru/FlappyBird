package com.kingyu.flappybird.component;

import com.kingyu.flappybird.util.Constant;
import com.kingyu.flappybird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: HaappyEnding
 * @description: TODO
 * @author: pual(xuyi)
 * @create: 2022-01-05 17:28
 **/

public class HappyEnding {
    private int x; // 坐标
    private int y;
    private int speed; // 速度
    private List<BufferedImage> imgList;
    private BufferedImage currentImag;


    // 构造器
    public HappyEnding() {
        super();
        this.imgList = new ArrayList<>();
        this.imgList.add(GameUtil.loadBufferedImage(Constant.HAPPY_END_IMG_PATH));
        this.imgList.add(GameUtil.loadBufferedImage(Constant.HAPPY_END_IMG_2_PATH));
        this.imgList.add(GameUtil.loadBufferedImage(Constant.HAPPY_END_IMG_3_PATH));
//        this.currentImag = imgList.get(0);
        this.speed = Constant.GAME_SPEED; //云朵的速度
        this.reset();
//        this.x = Constant.FRAME_WIDTH;
//        this.y = Constant.FRAME_HEIGHT / 2;
    }

    // 绘制方法
    public void draw(Graphics g, Bird bird) {
        int speed = this.speed;
        if (bird.isDead())
            speed = 1;
        x -= speed;
        if (x == -20 * speed) {
            reset();
        }
        g.drawImage(currentImag, x, y, currentImag.getWidth(), currentImag.getHeight(), null);
    }

    public void reset() {
        Random r = new Random();
        this.currentImag = this.imgList.get( r.nextInt(3));
        this.x = Constant.FRAME_WIDTH;
        this.y = r.nextInt(Constant.FRAME_HEIGHT - 50) + 20;
    }


    public boolean isOutFrame() {
        return x < -1 * currentImag.getWidth();
    }

    public boolean intersects(Rectangle r) {
        Rectangle rr = new Rectangle(this.x, this.y, this.currentImag.getWidth(), this.currentImag.getHeight());
        return rr.intersects(r);
    }
}
