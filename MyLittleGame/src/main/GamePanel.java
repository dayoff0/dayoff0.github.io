package main;

import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tiles
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 20;
    final int maxScreenRow = 14; //Screen size 16x12 tiles
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    Thread gameThread; // stopper
    KeyHandler keyHandler = new KeyHandler();

    //PLayer default position
    int playerX = screenWidth / 2;
    int playerY = screenHeight / 2;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        //GAME LOOP

        // FPS
        //noinspection InsertLiteralUnderscores
        double drawInterwal = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while (gameThread != null) {
            System.out.println("The game loop is running.");

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterwal;

            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        if (keyHandler.pressed_UP) {
            playerY -= playerSpeed;
        }
        if (keyHandler.pressed_DOWN) {
            playerY += playerSpeed;
        }
        if (keyHandler.pressed_LEFT) {
            playerX -= playerSpeed;
        }
        if (keyHandler.pressed_RIGHT) {
            playerX += playerSpeed;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.PINK);

        g.fillRect(playerX, playerY, tileSize, tileSize);

        g.dispose();
    }


}
