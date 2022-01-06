package com.kingyu.flappybird.component;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.kingyu.flappybird.util.Constant;
import com.kingyu.flappybird.util.MusicUtil;
import com.sun.tools.internal.jxc.ap.Const;

/**
 * 游戏计时器, 使用静态内部类实现了单例模式
 *
 * @author Kingyu
 */
public class ScoreCounter {

    private static class ScoreCounterHolder {
        private static final ScoreCounter scoreCounter = new ScoreCounter(0);
        private static final ScoreCounter scoreCounterForShow = new ScoreCounter(Constant.PASS_COUNT);
        private static final ScoreCounter scoreCounterForPipe = new ScoreCounter(Constant.PASS_COUNT);
    }

    public static ScoreCounter getInstance() {
        return ScoreCounterHolder.scoreCounter;
    }

    public static ScoreCounter getInstanceForShow() {
        return ScoreCounterHolder.scoreCounterForShow;
    }

    public static ScoreCounter getInstanceForPipe() {
        return ScoreCounterHolder.scoreCounterForPipe;
    }

    private long initialScore = 0;
    private long score = 0; // 分数
    private long bestScore; // 最高分数

    private ScoreCounter(int initialScore) {
        this.initialScore = initialScore;
        score = initialScore;
        bestScore = -1;
        try {
            loadBestScore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 装载最高纪录
    private void loadBestScore() throws Exception {
        File file = new File(Constant.SCORE_FILE_PATH);
        if (file.exists()) {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            bestScore = dis.readLong();
            dis.close();
        }
    }

    public void saveScore() {
        bestScore = Math.max(bestScore, getCurrentScore());
        try {
            File file = new File(Constant.SCORE_FILE_PATH);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            dos.writeLong(bestScore);
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void score(Bird bird) {
        if (!bird.isDead()) {
            MusicUtil.playScore();
            score += 1;
        }
    }

    public void scoreDown(Bird bird) {
        if (!bird.isDead()) {
            MusicUtil.playScore();
            score -= 1;
        }
    }

    public long getBestScore() {
        return bestScore;
    }

    public long getCurrentScore() {
        return score;
    }

    public void reset() {
        score = initialScore;
    }

    public boolean isWin() {
        return score > 1 && score == initialScore;
    }
}
