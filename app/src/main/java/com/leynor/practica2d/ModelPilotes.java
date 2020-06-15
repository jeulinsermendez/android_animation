package com.leynor.practica2d;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class ModelPilotes {
    List<Pilota> pilotes;

    public ModelPilotes() {
        pilotes = new ArrayList<Pilota>();
        init();
    }

    private void init() {

        pilotes.add(new Pilota(100,100,Color.RED,30));
        pilotes.add(new Pilota(100,100,Color.RED,30));
        pilotes.add(new Pilota(100,100,Color.RED,30));
        pilotes.add(new Pilota(100,100,Color.RED,30));
    }
    public boolean  addPilota(int x, int y){
        return pilotes.add(new Pilota(x,y,Color.GREEN,30));
    }
}
