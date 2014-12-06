package hu.uniobuda.nik.torpedo;

import java.util.List;
import java.util.Random;

/**
 * Created by Papír Tigris on 2014.12.06..
 */
public class Hajo {
    private Pozicio[] hajo;
    Random R;
    int elet;

    // 0-ha vízszintes, 1 ha függőleges

    public boolean TalaltSullyedt()
    {
        elet--;
        if (elet ==0){return true;}else {return false;}
    }



    public Hajo(int x, int y, int hajohossz, int irany)
    {
        elet = hajohossz;
        hajo = new Pozicio[hajohossz];
        if(irany == 1){
        for(int i = 0;i<hajohossz;i++){
         hajo[i].setY(y+i);
         hajo[i].setX(x);
        }
        }else
        {
            for(int i = 0;i<hajohossz;i++){
                hajo[i].setY(y);
                hajo[i].setX(x+i);
            }

        }
    }



    /*
    public boolean Hajohelyjo(int x, int y, int hajoirany,int hajohossz)
    {
        boolean ter = true;

        if (hajoirany == 1) {
            for (int i = 0; i < hajohossz + 2; i++) {
                try {

                    if (getTable()[x - 1 + i][y - 1] == 'X') {
                        ter = false;
                    }
                    if (getTable()[x - 1 + i][y] == 'X') {
                        ter = false;
                    }
                    if (getTable()[x - 1 + i][y + 1] == 'X') {
                        ter = false;
                    }
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < hossz + 2; i++) {
                try {
                    if (getTable()[x - 1][y - 1 + i] == 'X') {
                        ter = false;
                    }
                    if (getTable()[x][y - 1 + i] == 'X') {
                        ter = false;
                    }
                    if (getTable()[x + 1][y - 1 + i] == 'X') {
                        ter = false;
                    }
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }

        }

        return ter;

    }
*/
    public Pozicio[] getHajo() {
        return hajo;
    }

    public void setHajo(Pozicio[] hajo) {
        this.hajo = hajo;
    }
}
