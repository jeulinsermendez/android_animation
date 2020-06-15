package com.leynor.practica2d;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Pilota {

    int x, y;
    float radio;
    Paint paint;
    int dirV;
    int dirH;
    int speed;
    int color;
    static final int RIGHT = 0;
    static final int LEFT = 1;
    static final int UP = 1;
    static final int DOWN = 0;

    public Pilota() {
        x = 0;
        y = 0;
        radio = 30;
        dirV = 0;
        dirH = 0;
        speed = 1;
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
    }


    public Pilota(int x, int y) {
        this.x = x;
        this.y = y;
        radio = 30;
        dirV = 0;
        dirH = 0;
        this.speed = 200;
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
    }
    public Pilota(int x, int y,int color, int radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        dirV = 0;
        dirH = 0;
        this.speed = 200;
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }
    public Pilota(int x, int y, int xMax, int yMax, int s) {
        this.x = x;
        this.y = y;
        radio = 30;
        dirV = 0;
        dirH = 0;
        this.speed = s;
        paint = new Paint();
        paint.setColor(Color.RED);
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
        // mo vertical
        if (getDirV() == UP) {
            this.setY(this.getY() + this.getSpeed());
        } else {

            this.setY(this.getY() - this.getSpeed());
        }
        //Colisiones margenes
        //margen izquierdo
        if (this.getX() - this.getRadio() < 0) {
            this.setDirH(RIGHT);
            this.setX(this.getX() + this.getSpeed());
        }
        //margen derecho
        if (this.getX() + this.getRadio() > limitX) {
            this.setDirH(LEFT);
            this.setX(this.getX() - this.getSpeed());
        }
        //margen izquierdo
        if (this.getY() - this.getRadio() < 0) {
            this.setDirV(UP);
            this.setY(this.getY() + this.getSpeed());
        }
        //margen derecho
        if (this.getY() + this.getRadio() > limitY) {
            this.setDirV(DOWN);
            this.setY(this.getY() - this.getSpeed());
        }

    }

    public boolean collision(int x, int y, float radio) {
        boolean hasCollision = false;
        Double d = Math.sqrt(Math.pow(this.getX() - x, 2) + Math.pow(this.getY() - y, 2));
        if (d < this.getRadio() + radio) {
            hasCollision = true;
        }
        return hasCollision;

    }

    public void moveCollision(int limitX, int limitY) {

        if (getDirH() == RIGHT) {
            if (this.getX() > this.getRadio()) {
                this.setDirH(LEFT);
            }
        } else if (getDirH() == LEFT) {
            if (this.getX() < limitX - this.getRadio()) {
                this.setDirH(RIGHT);
            }

        }
        if (getDirV() == UP) {
            if (this.getY() < limitY - this.getRadio()) {
                this.setDirV(DOWN);
            }
        } else if (getDirV() == DOWN) {
            if (this.getY() > this.getRadio()) {
                this.setDirV(UP);
            }

        }

    }

    public boolean collision(Pilota b) {
        boolean hasCollision = false;
        Double d = Math.sqrt(Math.pow(this.getX() - b.getX(), 2) + Math.pow(this.getY() - b.getY(), 2));
        if (d < this.getRadio() + b.getRadio()) {
            hasCollision = true;
        }
        return hasCollision;
    }

    public void onDraw(Canvas c) {
        c.drawCircle(getX(), getY(), getRadio(), getPaint());
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

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public int getDirV() {
        return dirV;
    }

    public void setDirV(int dirV) {
        this.dirV = dirV;
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

}
