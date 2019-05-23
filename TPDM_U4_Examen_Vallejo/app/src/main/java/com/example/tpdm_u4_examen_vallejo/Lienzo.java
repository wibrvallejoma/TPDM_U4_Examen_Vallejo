package com.example.tpdm_u4_examen_vallejo;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Lienzo extends View {
    Thread hilo;
    Boca boca_limpia;
    CountDownTimer timer;
    Random random;
    String mensajeFinal = null;
    String nota = "";

    int tiempo = 60;
    Toothbrush cepillo;
    boolean juegoEmpezado = false;
    ArrayList<Carie> caries = new ArrayList<>();
    boolean intro = true;
    EstadoAnimo estadoAnimo;
    String cadenaTemporal = null;
    boolean cadTemporal = true;
    MediaPlayer brushsfx, fondo, aplausos;
    boolean tiempoTerminado = false;
    public Lienzo(Context context) {
        super(context);
        if (fondo == null) {
            fondo = MediaPlayer.create(this.getContext(), R.raw.fondo);
            fondo.setVolume((float) 0.0, (float) 0.5);
            fondo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    fondo.start();
                }
            });
        }
        fondo.start();
        cadenaTemporal = "PRESIONA LA PANTALLA";

        crearBoca();
        random =new Random();
        cepillo = new Toothbrush(this);
        estadoAnimo = new EstadoAnimo(80, 0, this);
        //estadoAnimo = new EstadoAnimo(0, 0, this);
        hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                    while (true) {
                        if (mensajeFinal == null) {
                            if (caries.size() <= 2) {
                                System.out.println("ANIMO CHIDO");
                                estadoAnimo.cambiarAnimo(0);
                            } else if (caries.size() <= 10) {
                                System.out.println("ANIMO BIEN");
                                estadoAnimo.cambiarAnimo(1);
                            } else if (caries.size() <= 15) {
                                System.out.println("ANIMO SAD");
                                estadoAnimo.cambiarAnimo(2);
                            } else if (caries.size() <= 22) {
                                System.out.println("ANIMO SADDEST");
                                estadoAnimo.cambiarAnimo(3);
                            } else {
                                System.out.println("ANIMO ded");
                                estadoAnimo.cambiarAnimo(4);
                            }
                        }

                    invalidate();

                }
            }
        });


        timer = new CountDownTimer( 60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempo = (int) TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                System.out.println("Tiempo: " + tiempo);

                carieRandom();

            }

            @Override
            public void onFinish() {
                if (fondo != null) {
                    fondo.release();
                    fondo = null;
                }
                if (caries.size() <= 2) {
                    mensajeFinal = "ERES 100% GUAPISIMO";
                    nota = "Tienes una sonrisa hermosa :D";

                    if (aplausos == null) {
                        aplausos = MediaPlayer.create(getContext(), R.raw.aplausos);
                        aplausos.setVolume((float) 0.0, (float) 0.5);
                        aplausos.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                aplausos.release();
                            }
                        });
                    }
                    aplausos.start();
                } else if (caries.size() <= 10) {
                    mensajeFinal = "ERES CASI GUAPISIMO";
                    nota = "Sigue lavando así tus dientes :)";
                } else if (caries.size() <= 15) {
                    mensajeFinal = "ERES UN POCO GUAPISIMO";
                    nota = "Intenta lavar mas seguido tus dientes :(";
                } else {
                    mensajeFinal = "NO ERES GUAPISIMO";
                    nota = "Lava tus dientes por favor :'(";
                }
                tiempoTerminado = true;
            }
        };

        invalidate();
    }

    public void crearBoca(){
        boca_limpia = (new Boca(0,200, this));
    }
    public void carieRandom(){
        System.out.println(caries.size());
        if (caries.size() > 32) {

            return;
        }
        switch (random.nextInt(31)+1){
            case 1:
                crearCarie(140, 960);
                break;
            case 2:
                crearCarie(150, 890);
                break;
            case 3:
                crearCarie(160, 830);
                break;
            case 4:
                crearCarie(180, 760);
                break;
            case 5:
                crearCarie(200, 680);
                break;
            case 6:
                crearCarie(270, 620);
                break;
            case 7:
                crearCarie(370, 570);
                break;
            case 8:
                crearCarie(470, 540);
                break;
            case 9:
                crearCarie(600, 540);
                break;
            case 10:
                crearCarie(700, 540);
                break;
            case 11:
                crearCarie(790, 570);
                break;
            case 12:
                crearCarie(870, 630);
                break;
            case 13:
                crearCarie(900, 760);
                break;
            case 14:
                crearCarie(940, 830);
                break;
            case 15:
                crearCarie(950, 890);
                break;
            case 16:
                crearCarie(950, 960);
                break;
            case 17:
                crearCarie(130, 1140);
                break;
            case 18:
                crearCarie(115, 1225);
                break;
            case 19:
                crearCarie(120, 1350);
                break;
            case 20:
                crearCarie(185, 1440);
                break;
            case 21:
                crearCarie(255, 1520);
                break;
            case 22:
                crearCarie(330, 1550);
                break;
            case 23:
                crearCarie(420, 1570);
                break;
            case 24:
                crearCarie(500, 1590);
                break;
            case 25:
                crearCarie(580, 1590);
                break;
            case 26:
                crearCarie(660, 1575);
                break;
            case 27:
                crearCarie(740, 1560);
                break;
            case 28:
                crearCarie(810, 1520);
                break;
            case 29:
                crearCarie(890, 1450);
                break;
            case 30:
                crearCarie(945, 1340);
                break;
            case 31:
                crearCarie(980, 1250);
                break;
            default:
                crearCarie(980, 1140);
                break;
        }
    }
    public void crearCarie(int x, int y){
        caries.add(new Carie(x,y, this));

        /*
        POSICIONES DIENTES:
        DE IZQ A DERECHA
        ARRIBA
        1: crearCarie(140, 960);
        2: crearCarie(150, 890);
        3: crearCarie(160, 830);
        4: crearCarie(180, 760);
        5: crearCarie(200, 680);
        6: crearCarie(270, 620);
        7: crearCarie(370, 570);
        8: crearCarie(470, 540);
        9: crearCarie(600, 540);
        10: crearCarie(700, 540);
        11: crearCarie(790, 570);
        12: crearCarie(870, 630);
        13: crearCarie(900, 760);
        14: crearCarie(940, 830);
        15: crearCarie(950, 890);
        16: crearCarie(950, 960);
        ABAJO
        1: crearCarie(130, 1140);
        2: crearCarie(115, 1225);
        3: crearCarie(120, 1350);
        4: crearCarie(185, 1440);
        5: crearCarie(255, 1520);
        6: crearCarie(330, 1550);
        7: crearCarie(420, 1570);
        8: crearCarie(500, 1590);
        9: crearCarie(580, 1590);
        10: crearCarie(660, 1575);
        11: crearCarie(740, 1560);
        12: crearCarie(810, 1520);
        13: crearCarie(890, 1450);
        14: crearCarie(945, 1340);
        15: crearCarie(980, 1250);
        16: crearCarie(980, 1140);
         */
    }
    boolean cuadroFondo = false;
    @Override
    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        //System.out.println("width " + getWidth());
        //System.out.println("height " + getHeight());
        //if (!cuadroFondo) {
            p.setColor(Color.WHITE);
            canvas.drawRect(0,0,10000,10000,p);
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.consultorio),0,200,p);
            cuadroFondo = true;
        //}
        if (!juegoEmpezado) {
            p.setColor(Color.BLUE);
            p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
            p.setTextSize(72);

            canvas.drawText("PRESIONA PARA COMENZAR", getWidth()/2 - 480, getHeight()/2 + 950, p);
            p.setColor(Color.CYAN);
            canvas.drawText("Lavando tus dientes", getWidth()/2 - 480, 150, p);
        } else {

            p.setColor(Color.BLACK);
            p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
            p.setTextSize(72);

            canvas.drawText("Tiempo restante: "+ tiempo, getWidth()/2 - 480, getHeight() - 100, p);

            boca_limpia.pintar(canvas, p);
            for(int i = 0; i < caries.size(); i ++){
                caries.get(i).pintar(canvas, p);
            }
            try {
                cepillo.pintar(canvas, p);
            } catch (Exception e) {

            }



            estadoAnimo.pintar(canvas, p);




            p.setColor(Color.WHITE);
            p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
            p.setTextSize(86);

            //canvas.drawText("ERES 100% GUAPISIMO", getWidth()/2 - 460, getHeight()/2 + 20, p);
            if (mensajeFinal != null) {
                p.setColor(Color.WHITE);
                p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
                p.setTextSize(86);
                p.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(mensajeFinal, getWidth()/2 , getHeight()/2 + 20, p);
                p.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
                p.setTextSize(64);
                p.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(nota, getWidth()/2, getHeight()/2 + 80, p);

            }
        }

        //System.out.print(boca_limpia.imagen.getWidth());
    }
    private void stopPlayer(){
        if (brushsfx != null) {
            brushsfx.release();
            brushsfx = null;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int accion = event.getAction();
        int posx = (int) event.getX();
        int posy = (int) event.getY();

        switch (accion) {
            case MotionEvent.ACTION_MOVE:
                if (brushsfx == null) {
                    brushsfx = MediaPlayer.create(this.getContext(), R.raw.brushsfx);
                    brushsfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            stopPlayer();
                        }
                    });
                }
                brushsfx.start();
                cepillo.mover(posx, posy);
                for (int i = 0; i < caries.size(); i++) {
                    if (caries.get(i).inArea(posx, posy)) {
                        caries.remove(i);
                        break;
                    }
                }
                break;
            case MotionEvent.ACTION_DOWN:
                if (!juegoEmpezado) {
                    hilo.start();
                    timer.start();

                    juegoEmpezado = true;
                }
                cepillo.mover(posx, posy);
                break;
            case MotionEvent.ACTION_UP:
                stopPlayer();

                break;
        }

        return true;
    }
}
