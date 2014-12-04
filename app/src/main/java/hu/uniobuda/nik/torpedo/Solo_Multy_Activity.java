package hu.uniobuda.nik.torpedo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Solo_Multy_Activity extends ActionBarActivity {
    static int sor = 10;
    static int oszlop = 10;
Button Solo;
Button Multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo__multy_);


        Solo = (Button) findViewById(R.id.solo);
        Multi = (Button) findViewById(R.id.multi);


        Solo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //solo Activity behozása
                startActivity(new Intent(getApplicationContext(), solo_play.class));
    }
});

      Multi.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              //Multi elindítása
              startActivity(new Intent(getApplicationContext(), multi_play.class));
          }
      });
   }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.solo__multy_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
