package com.fju.game;

public class Monkey extends Thread {
    public static final int DIRECTION_RIGHT = 0;
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_UP = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_NONE = -1;
    private final GameView gameView;
    int x = 0;
    int y = 0;
    int direction = DIRECTION_NONE;

    public Monkey(GameView gameView) {
        this.gameView = gameView;
    }

    @Override
    public void run() {
        while(direction != DIRECTION_NONE) {
            switch (direction) {
                case DIRECTION_RIGHT:
                    if (x < gameView.getWidth()-200) {
                        x = x + 50;
                    }
                    gameView.invalidate();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case DIRECTION_LEFT:
                    if (x > 50) {
                        x = x - 50;
                    }
                    gameView.invalidate();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case DIRECTION_DOWN:
                    if (y < gameView.getHeight()-200) {
                        y += 50;
                    }
                    gameView.invalidate();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case DIRECTION_UP:
                    if (y > 50) {
                        y -= 50;
                    }
                    gameView.invalidate();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if (this.direction == DIRECTION_NONE) {
            start();
        }
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
