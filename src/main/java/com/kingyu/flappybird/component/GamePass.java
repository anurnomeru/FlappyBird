package com.kingyu.flappybird.component;

import com.kingyu.flappybird.util.Constant;
import com.kingyu.flappybird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePass {

    private final BufferedImage passImg; // 计分牌
    private final BufferedImage overImg; // 结束标志
    private final BufferedImage againImg; // 继续标志

    public GamePass() {
        passImg = GameUtil.loadBufferedImage(Constant.PASS_IMG_PATH);
        overImg = GameUtil.loadBufferedImage(Constant.OVER_IMG_PATH);
        againImg = GameUtil.loadBufferedImage(Constant.AGAIN_IMG_PATH);
    }

    private int flash = 0; // 图片闪烁参数

    public void draw(Graphics g, Bird bird) {
//        int x = Constant.FRAME_WIDTH /4;
//        int y = Constant.FRAME_HEIGHT / 4;
//        g.drawImage(overImg, x, y, null);
//        x = Constant.FRAME_WIDTH /3;
//        y = Constant.FRAME_HEIGHT / 3;
        g.drawImage(passImg, 0, 0, null);

//        // 绘制继续游戏，图像闪烁
//        final int COUNT = 30; // 闪烁周期
//        if (flash++ > COUNT)
//            GameUtil.drawImage(againImg, Constant.FRAME_WIDTH - againImg.getWidth() >> 1, Constant.FRAME_HEIGHT / 5 * 3, g);
//        if (flash == COUNT * 2) // 重置闪烁参数
//            flash = 0;
    }
}
