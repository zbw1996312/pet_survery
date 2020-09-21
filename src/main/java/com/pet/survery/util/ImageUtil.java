package com.pet.survery.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtil {
    // 验证码字符集
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    // 字符数量
    private static final int SIZE = 4;
    // 干扰线数量
    private static final int LINES = 5;
    // 宽度
    private static final int WIDTH = 80;
    // 高度
    private static final int HEIGHT = 40;
    // 字体大小
    private static final int FONT_SIZE = 30;
    private static Color color;

    /**
     * 生成随机验证码及图片
     * Object[0]：验证码字符串；
     * Object[1]：验证码图片。
     */
    public static Object[] createImage() {
        StringBuffer sb = new StringBuffer();

        //创建空白图片
        BufferedImage bufImg = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //获取图片画笔
        Graphics graphics = bufImg.getGraphics();
        //3.设置画笔颜色
        graphics.setColor(Color.lightGray);
        //4.绘制矩形背景
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        //5.画随机字符
        Random random = new Random();
        //根据字符数量生成验证码
        for (int i = 0; i < SIZE; i++) {
            // 取随机字符索引
            int n = random.nextInt(chars.length);

            //设置随机颜色
            graphics.setColor(getRandomColor());

            // 设置字体大小
            graphics.setFont(new Font(
                    null, Font.BOLD + Font.ITALIC, FONT_SIZE));

            // 画字符
            graphics.drawString(
                    chars[n] + "", i * WIDTH / SIZE, HEIGHT*2/3);
            // 记录字符
            sb.append(chars[n]);

        }
        // 6.画干扰线
        for (int i = 0; i < LINES; i++) {
            // 设置随机颜色
            graphics.setColor(getRandomColor());
            // 随机画线
            graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
                    random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
        // 7.返回验证码和图片
        return new Object[]{sb.toString(), bufImg};
    }


    //使用rgb的形式随机生成颜色
    public static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256),
                ran.nextInt(256), ran.nextInt(256));
        return color;
    }
}
