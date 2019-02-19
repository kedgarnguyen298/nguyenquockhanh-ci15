package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    Vector2D position;
    int fireCount;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position = new Vector2D(200, 500);
        fireCount = 0;
    }

    public void render(Graphics g) {
        g.drawImage(image, (int)position.x, (int)position.y, null);
    }

    public void run() {
        public void move();
        public void fire();

    }

    public void fire() {
        fireCount++;
        if(GameWindow.isFirePress && fireCount > 20) {
            Vector2D bulletPosition = new Vector2D(position.x, position.y);
            bulletPositions.add(bulletPosition);
            fireCount = 0;
        }
    }

    public void move() {
        if (GameWindow.isUpPress && position.y > 0) {
            position.y--;
        }
        if (GameWindow.isDownPress && position.y < 600 - 48) {
            position.y++;
        }
        if (GameWindow.isLeftPress && position.x > 0) {
            position.x--;
        }
        if (GameWindow.isRightPress && position.x < 384 - 32) {
            position.x++;
        }
    }
}
