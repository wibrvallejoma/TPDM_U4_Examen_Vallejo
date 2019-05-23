package com.example.tpdm_u4_examen_vallejo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class EstadoAnimo {
    Bitmap imagen = null;
    int x, y;
    Bitmap chido;
    Bitmap feliz;
    Bitmap sad;
    Bitmap supersad;
    Bitmap memuero;

    public EstadoAnimo(int x, int y, Lienzo este) {
        this.x = x;
        this.y = y;

        this.chido = BitmapFactory.decodeResource(este.getResources(), R.drawable.arrogant);
        this.feliz = BitmapFactory.decodeResource(este.getResources(), R.drawable.cheeky);
        this.sad = BitmapFactory.decodeResource(este.getResources(), R.drawable.confused);
        this.supersad = BitmapFactory.decodeResource(este.getResources(), R.drawable.desperate);
        this.memuero = BitmapFactory.decodeResource(este.getResources(), R.drawable.crying);
        this.imagen = chido;

    }

    public void cambiarAnimo(int estadoAnimo){
        switch (estadoAnimo) {
            // 0 arrogant  = chido
            // 1 cheeky = feliz
            // 2 confused = sad
            // 3 desperate = super sad
            // 4 se muere xd
            case 0:
                this.imagen = chido;
                break;
            case 1:
                this.imagen = feliz;
                break;
            case 2:
                this.imagen = sad;
                break;
            case 3:
                this.imagen = supersad;
                break;
            case 4:
                this.imagen = memuero;
                break;
        }
    }
    public void pintar (Canvas c, Paint p) {
        c.drawBitmap(imagen, x, y, p);
    }

}
