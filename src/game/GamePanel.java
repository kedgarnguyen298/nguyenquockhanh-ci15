package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    BufferedImage bulletImage;
//    Vector2D[] bulletPositions;
    ArrayList<Vector2D> bulletPositions;
    Background background;
    Player player;

    public GamePanel() {
        background = new Background();
        player = new Player();
        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        bulletPositions = new ArrayList<>();
        // bulletPosition.add() //them phan tu vao mang
        // bulletPosition.get() //lay ra phan tu o vi tri cu the
        // bulletPosition.size() //lay ra kich thuoc cua mang
    }

    @Override
    public void paint(Graphics g) {

        // ve anh
        background.render(g);
        player.render(g);
        for(int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            g.drawImage(bulletImage, (int)bulletPosition.x, (int)bulletPosition.y, null);
        }
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
        background.run();
        player.run();
        bulletsRun();
    }

    private void bulletsRun() {
        for(int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            bulletPosition.y -= 3;
        }
    }

}
