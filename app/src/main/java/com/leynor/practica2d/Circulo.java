package com.leynor.practica2d;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Circulo extends View {

    public boolean circuloazul = true;
    public Circulo(Context context) {
        super(context);
    }

    public Circulo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(circuloazul) {
            circuloazul = false;
            PintaCercleBlau(canvas);
        } else{
            PintaCercleVerd(canvas);
            circuloazul = true;
        }

    }


    public void PintaCercleBlau(Canvas canvas) {

        Paint pincel = new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(100, 100, 50, pincel);
    }

    public void PintaCercleVerd(Canvas canvas) {

        Paint pincel = new Paint();
        pincel.setColor(Color.GREEN);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(300, 300, 50, pincel);

    }
}
