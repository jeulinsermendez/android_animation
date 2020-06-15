package com.leynor.practica2d;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Base {
    int x, y, maxX, dirH, speed;
    Paint paint;
    static final int RIGHT = 0;
    static final int LEFT = 1;
    static final int _WIDTH = 200;
    static final int _HEIGHT = 10;

    public Base() {
        x = 0;
        y = 1100;
        dirH = 0;
        speed = 10;
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
    }

    public void move(int limitX, int limitY) {
        //moviment horitzontal
        //derecha
        if (getDirH() == RIGHT) {
            this.setX(this.getX() + this.getSpeed());
        }
        //izquierda
        else {

            this.setX(this.getX() - this.getSpeed());
        }
        //Colisiones margenes
        //margen izquierdo
        if (this.getX() - _WIDTH < 0) {
            this.setDirH(RIGHT);
            this.setX(this.getX() + this.getSpeed());
        }
        //margen derecho
        if (this.getX() + _WIDTH > limitX) {
            this.setDirH(LEFT);
            this.setX(this.getX() - this.getSpeed());
        }


    }

    public void movePoint(int x) {
        if (x < this.getX()) {
            this.setDirH(LEFT);
            this.setX(this.getX() - this.getSpeed());
        } else if (x > this.getX()) {
            this.setDirH(RIGHT);
            this.setX(this.getX() + this.getSpeed());
        }


    }


    public boolean collision(Pilota b) {
        boolean hasCollision = false;
        int px = b.getX();
        if (px < x) {
            px = x;
        }
        if (px > x + _WIDTH) {
            px = x + _WIDTH;
        }
        int py = b.getY();
        if (py < y) {
            py = y;
        }
        if (py > y + _HEIGHT) {
            py = x + _HEIGHT;
        }
        double distance = Math.sqrt((b.getX() - px) * (b.getX() - px) + (b.getY() - py) * (b.getY() - py));
        if (distance < b.getRadio()) {
            hasCollision = true;
        }
        return hasCollision;


    }

    public void onDraw(Canvas c) {
        c.drawRect(this.getX(), this.getY(), this.getX() + _WIDTH, this.getY() + _HEIGHT, this.getPaint());

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getDirH() {
        return dirH;
    }

    public void setDirH(int dirH) {
        this.dirH = dirH;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}