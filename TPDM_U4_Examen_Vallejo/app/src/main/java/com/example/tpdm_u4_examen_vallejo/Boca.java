package com.example.tpdm_u4_examen_vallejo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Boca {
    Bitmap imagen;
    int x, y;

    public Boca(int x, int y, Lienzo este) {
        this.x = x;
        this.y = y;

        this.imagen = BitmapFactory.decodeResource(este.getResources(), R.drawable.boca_limpia);

    }


    public void pintar (Canvas c, Paint p) {
        c.drawBitmap(imagen, x, y, p);
    }
}
