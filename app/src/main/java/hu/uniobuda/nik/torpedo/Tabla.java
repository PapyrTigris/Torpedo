package hu.uniobuda.nik.torpedo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class Tabla extends BaseAdapter {

    Context mContext;
    public Integer[] alapkockak;
    int db;
    View.OnClickListener OCL;

    public Tabla(final Context mContext) {
        this.mContext = mContext;
        db = Solo_Multy_Activity.sor * Solo_Multy_Activity.oszlop;
        alapkockak = new Integer[db];
        for (int i = 0; i < db; i++) {
            alapkockak[i] = R.drawable.alap;
        }
        OCL = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Lőhetsz
                int i = view.getId();
                alapkockak[i] = R.drawable.viz;

            }
        };
    }

    @Override
    public int getCount() {
        return alapkockak.length;
    }

    @Override
    public Object getItem(int i) {
        return alapkockak[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(alapkockak[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        imageView.setId(i);
        imageView.setOnClickListener(OCL);
        return imageView;
    }
}
