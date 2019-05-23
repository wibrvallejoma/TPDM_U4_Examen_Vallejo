package com.example.tpdm_u4_examen_vallejo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Carie {
    Bitmap imagen;
    int x, y;

    public Carie(int x, int y, Lienzo este) {
        this.x = x;
        this.y = y;

        this.imagen = BitmapFactory.decodeResource(este.getResources(), R.drawable.carie);


    }
    public boolean inArea(int xDedo,int yDedo) {
        return xDedo >= this.x && xDedo <= (x + imagen.getWidth()) && yDedo >= this.y && yDedo <= (y + imagen.getHeight());
    }

    public void pintar (Canvas c, Paint p) {
        p.setColor(Color.rgb(236,211,75));
        c.drawCircle(x,y,32, p);
        //c.drawBitmap(imagen, x, y, p);
    }
}
