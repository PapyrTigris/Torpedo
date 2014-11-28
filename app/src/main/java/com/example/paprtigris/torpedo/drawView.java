package com.example.paprtigris.torpedo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

/**
 * Created by Papír Tigris on 2014.11.26..
 */
public class drawView extends View {

    Paint paint = new Paint();

    public drawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    public drawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public drawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public void onDraw(Canvas canvas)
    {

        int keret = 20;
        int width = canvas.getWidth()-keret;
        int height = canvas.getHeight()-keret-120;
        int sor = 10;
        int oszlop =10;
        sor++;
        oszlop++;
        if (width < height){height = width;}else {width = height;}

        for(float i = keret; i < width;i+=  (width/oszlop)) {
            for (float j = keret; j < height; j +=  (height / sor)) {
                //Start x, y , Final x, y

                canvas.drawLine(keret, j, width, j , paint);
                canvas.drawLine(i, keret, i,height , paint);

            }
        }
    }
}
