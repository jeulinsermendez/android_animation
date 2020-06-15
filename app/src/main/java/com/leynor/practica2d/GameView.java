package com.leynor.practica2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View {
    Paint estil;
    Pilota b1, b2;
    ArrayList<Pilota> balls;
    int maxXView, maxYView;
    Base base;
    ModelPilotes modelPilotes;

    public GameView(Context context) {
        super(context);
        balls = new ArrayList<>();
        modelPilotes = new ModelPilotes();

        setStyles();
        initScene();

    }

    public GameView(Context context,
                    AttributeSet attrs) {
        super(context, attrs);
        balls = new ArrayList<>();
        setStyles();
        initScene();


    }

    private void initScene() {
        balls.clear();
        base = new Base();
        b1 = new Pilota(30, 100, this.maxXView, this.maxYView, 200);
        b2 = new Pilota(5, 200, this.maxXView, this.maxYView, 100);
        balls.add(b1);
        balls.add(b2);
    }

    protected void onSizeChanged(int x, int y, int old_x, int old_y) {
        super.onSizeChanged(x, y, old_x, old_y);
        this.maxXView = x;
        this.maxYView = y;

    }

    public void move() {

        for (Pilota b : balls) {
            b.move(this.maxXView, this.maxYView);
        }
        base.move(this.maxXView, this.maxYView);
    }

    public void collision() {
        for (int i = 0; i < balls.size(); i++) {
            if (base.collision(balls.get(i))) {
                balls.get(i).moveCollision(maxXView, maxYView);
            }
            for (int j = i + 1; j < balls.size(); j++) {
                if (balls.get(i).collision(balls.get(j))) {
                    balls.get(j).moveCollision(maxXView, maxYView);
                    balls.get(i).moveCollision(maxXView, maxYView);
                }

            }


        }

    }

    public void setStyles() {
        estil = new Paint();
        estil.setColor(Color.CYAN);
        estil.setStrokeWidth(10);
        estil.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        base.onDraw(canvas);
        for (Pilota b : balls) {
            b.onDraw(canvas);
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
               // modelPilotes.addPilota(x,y);
                base.movePoint(x);
        }
        return true;
    }
}

