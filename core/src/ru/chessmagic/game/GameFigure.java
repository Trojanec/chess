package ru.chessmagic.game;

public class GameFigure {
    private int x;
    private int y;

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

    public GameFigure(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void changeCoords(int x, int y) {
        if(y - this.y > 0 && y - this.y < 3 && this.x == x) {
            this.y = y;
        }
    }
}
