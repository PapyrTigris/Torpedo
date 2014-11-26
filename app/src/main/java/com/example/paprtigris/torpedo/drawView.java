package com.example.paprtigris.torpedo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.widget.RelativeLayout;

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
        RelativeLayout RL = (RelativeLayout) findViewById(R.id.soloRelative);
        int keret = 10;
        int width = canvas.getWidth()-keret;
        int height = canvas.getHeight()- RL.getHeight()-keret;
        int sor = 10;
        int oszlop =10;


        for(int i = keret; i < width;i+= (int) (width/oszlop)) {
            for (int j = keret; j < height; j += (int) (height / sor)) {
                //Start x, y , Final x, y

                canvas.drawLine(keret, j, width, j , paint);
                canvas.drawLine(i, keret, i,height , paint);

            }
        }
    }
}
