package hu.uniobuda.nik.torpedo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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

        int sor = 10;
        int oszlop =10;

/*
        int keret = 20;
        int width = canvas.getWidth()-keret;
        int height = canvas.getHeight()-keret-120;

        sor++;
        oszlop++;
        if (width < height){height = width;}else {width = height;}

        for(double i = keret; i < width;i+=  (width/oszlop)) {
            for (double j = keret; j < height; j +=  (height / sor)) {
                //Start x, y , Final x, y

                canvas.drawLine(keret, (float)j, width,(float) j , paint);
                canvas.drawLine((float)i, keret, (float)i,height , paint);

            }
        }*/
        TextView TX = new TextView(getContext().getApplicationContext());
        TX.setText("42");

        TableLayout TL = new TableLayout(getContext());
         for (int i = 0;i<sor;i++)
            {
                TL.addView(new TableRow(getContext()));
                for (int j = 0;j<oszlop;j++)
                {
                    Button B = new Button(getContext());
                    B.setId(i+j);
                    TL.addView(B);
                }
            }




    }
}
