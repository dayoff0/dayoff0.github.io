package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean pressed_UP, pressed_DOWN, pressed_LEFT, pressed_RIGHT = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            pressed_UP = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            pressed_DOWN = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            pressed_LEFT = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            pressed_RIGHT = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            pressed_UP = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            pressed_DOWN = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            pressed_LEFT = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            pressed_RIGHT = false;
        }
    }
}
