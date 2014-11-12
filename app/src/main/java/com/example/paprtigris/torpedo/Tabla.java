package com.example.paprtigris.torpedo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created by Papír Tigris on 2014.10.03..
 */
public class Tabla extends View {
private char[][] tabla;
private int Sor = 10;
private int Oszlop = 10;
private TableLayout TL;

    public Tabla(Context context) {
        super(context);
    }

    public Tabla(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Tabla(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init()
    {
        for (int i = 0 ;i < Sor;i++)
        {
            for(int j=0;j<Oszlop;j++)
            {
                tabla[i][j] = ' ';
            }
        }
    }

    public  void onDraw()
    {


    }
}
