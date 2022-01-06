package com.kingyu.flappybird.component;

import com.kingyu.flappybird.util.Constant;
import com.kingyu.flappybird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName: HaappyEnding
 * @description: TODO
 * @author: pual(xuyi)
 * @create: 2022-01-05 17:28
 **/

public class HappyEnding {
    private int x; // 坐标
    private final int y;
    private final int speed; // 速度
    private final BufferedImage img;


    // 构造器
    public HappyEnding() {
        super();
        BufferedImage bufferedImage = GameUtil.loadBufferedImage(Constant.HAPPY_END_IMG_PATH);
        this.img = bufferedImage;
        this.speed = Constant.GAME_SPEED; //云朵的速度
        this.x = Constant.FRAME_WIDTH;
        this.y = Constant.FRAME_HEIGHT / 2;
    }

    // 绘制方法
    public void draw(Graphics g, Bird bird) {
        int speed = this.speed;
        if (bird.isDead())
            speed = 1;
        x -= speed;
        g.drawImage(img, x, y, img.getWidth(), img.getHeight(), null);
    }


    public boolean isOutFrame() {
        return x < -1 * img.getWidth();
    }

    public boolean intersects(Rectangle r) {
        Rectangle rr = new Rectangle(this.x, this.y, this.img.getWidth(), this.img.getHeight());
        return rr.intersects(r);
    }
}
