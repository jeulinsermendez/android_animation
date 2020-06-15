package com.leynor.practica2d;

public class ThreadAnimacio extends Thread {
    GameView v;

    public ThreadAnimacio(GameView scene) {
        this.v = scene;
    }

    @Override
    public void run() {
        super.run();
        try {

            while (true) {
                this.v.move();
                this.v.collision();
                this.v.postInvalidate();
                sleep(100);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
