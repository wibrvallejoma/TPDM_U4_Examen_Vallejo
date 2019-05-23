package com.example.tpdm_u4_examen_vallejo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Toothbrush {
    Bitmap imagen;
    int x, y;
    boolean tocando = false;
    public Toothbrush(Lienzo este) {
        this.x = 0;
        this.y = 0;

        this.imagen = BitmapFactory.decodeResource(este.getResources(), R.drawable.toothbrush);


    }

    public void mover(int x, int y){
        this.x = x - imagen.getWidth() + 50;
        this.y = y - 20;
    }

    public void pintar(Canvas c, Paint p){
        c.drawBitmap(imagen, x, y, p);
    }
}
