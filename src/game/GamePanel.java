package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class GamePanel extends JPanel {
    BufferedImage backgroundimage;
    BufferedImage playerimage;
    int backgroundx;
    int backgroundy;
    int playerx;
    int playery;

    public GamePanel() {
        backgroundimage = SpriteUtils.loadImage("assets/images/background/0.png");
        playerimage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        backgroundx = 0;
        backgroundy = 600 - 3109;
        playerx = 200;
        playery = 500;
    }

    @Override
    public void paint(Graphics g) {

        // ve anh
        g.drawImage(backgroundimage, backgroundx, backgroundy, null);
        g.drawImage(playerimage, playerx , playery , null);

    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000/60;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= delay) {
                // ve anh + chay logic
                runAll();
                renderAll();
                lastTime = currentTime;
            }
        }
    }

    private void renderAll() {
        repaint();
    }


    private void runAll() {
        if (backgroundy < 0) {
            backgroundy += 10;
        }

        if (GameWindow.isUpPress && playery > 0) {
            playery--;
        }
        if (GameWindow.isDownPress && playery < 500) {
            playery++;
        }
        if (GameWindow.isLeftPress && playerx > 0) {
            playerx--;
        }
        if (GameWindow.isRightPress && playerx < 350) {
            playerx++;
        }
    }
}
