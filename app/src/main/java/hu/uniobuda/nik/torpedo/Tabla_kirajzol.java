package hu.uniobuda.nik.torpedo;

import android.content.Context;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;



public class Tabla_kirajzol extends BaseAdapter {

    Context mContext;
    Button[] gombok ;
    int db;
    View.OnClickListener OCL;
    Hajok hajok;

    public Tabla_kirajzol(final Context mContext) {
        this.mContext = mContext;
        db = Solo_Multy_Activity.sor * Solo_Multy_Activity.oszlop;
        gombok = new Button[Solo_Multy_Activity.oszlop*Solo_Multy_Activity.sor];
        hajok = new Hajok();
        //alapkockak = new Integer[db];


        //for (int i = 0; i < db; i++) {
        //    alapkockak[i] = R.drawable.alap;
        //}
        OCL = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Lőhetsz
                int i = view.getId();
                //alapkockak[i] = R.drawable.viz;
               // view.
                if (true){
                gombok[i].setText("X");}
                gombok[i].setEnabled(false);

                //mContext.startActivity(new Intent());
                view.invalidate();

            }
        };
    }

    @Override
    public int getCount() {
        return gombok.length;
    }

    @Override
    public Object getItem(int i) {
        return gombok[i];
    }

    @Override
    public long getItemId(int i) {
        return gombok[i].getId();
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button B = new Button(mContext);

        B.setId(i);
        B.setLayoutParams(new GridView.LayoutParams(70, 70));
        B.setOnClickListener(OCL);
        //  B.setTextAlignment(View.TEXT_ALIGNMENT_CENTER); Nem engedélyezett a 2.3 miatt

        gombok[i]= B;
        return B;
    }
}
