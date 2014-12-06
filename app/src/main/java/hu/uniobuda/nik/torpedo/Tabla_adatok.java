package hu.uniobuda.nik.torpedo;

import java.util.Random;

/**
 * Created by Papír Tigris on 2014.11.29..
 */
/*X - Talált
  O - Mellé

  */
public class Tabla_adatok {

    int sor = 10;
    int oszlop = 10;
    Random R;
    char[][] table;




    public Tabla_adatok(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
    }

    public Tabla_adatok() {
        init();
    }

    //
    private void init() {

        table = new char[sor][oszlop];
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < sor; j++) {
                table[i][j] = ' ';
            }
        }
    }

    public void Melle(int x, int y) {
        table[x][y] = 'O';
    }

    public void Talalt(int x, int y) {
        table[x][y] = 'X';
    }


    public void Sullyedt(int x, int y, char irany) {
        //lekezelni a széleket

       // irányt is a konstruktorba
        if (Loves_talalt(x, y)&&irany==' ') {

            if (!Loves_talalt(x++, y)||!Loves_talalt(x--, y)) {
                Sullyedt(x++,y,'j');
                Sullyedt(x--,y,'b');
            }
            if (!Loves_talalt(x, y++)||!Loves_talalt(x, y--)) {
                Sullyedt(x,y--,'f');
                Sullyedt(x,y++,'l');
            }

        }
        switch (irany) {
            case 'j':
                if (Loves_talalt(x,y)){Korbelo(x,y); Sullyedt(x++, y,irany);}
                break;
            case 'l':
                if (Loves_talalt(x,y)){Korbelo(x,y); Sullyedt(x, y++,irany);}
                break;
            case 'f':
                if (Loves_talalt(x,y)){Korbelo(x,y); Sullyedt(y--, y,irany);}
                break;
            case 'b':
                if (Loves_talalt(x,y)){Korbelo(x,y); Sullyedt(x--, y,irany);}
                break;
            default:
                break;
        }
        //Vissza is meg kell csinálni mert lehet h a közepénél süllyeztettek
    }
    public void Korbelo(int x, int y)
    {
            //  pályaszél
            try {
                if (table[x++][y]==' '){Melle(x,y);};
                if (table[x--][y]==' '){Melle(x,y);};
                if (table[x][y++]==' '){Melle(x,y);};
                if (table[x][y--]==' '){Melle(x,y);};
            }catch (IndexOutOfBoundsException e)
            {

            }
    }

    private boolean Loves_talalt(int x, int y) {
        if (table[x][y] == 'X') return true;
        else return false;
    }
    private void Hajohozzaad(int Hajohossz)
    {
       int Rsor = R.nextInt(sor);
       int Roszlop = R.nextInt(oszlop);
       char irany;
        if ((Rsor*Roszlop)%2==1){irany = 'f';}else {irany='v';}
        if (Hajotervan(Rsor,Roszlop,irany,Hajohossz))
        {
            if (irany == 'v') {
            for (int i=1;i<Hajohossz;i++) {

                    table[Rsor][Roszlop+i] = 'X';
                }
            }else{
            for (int i=1;i<Hajohossz;i++) {

                table[Rsor+i][Roszlop] = 'X';
            }
        }
        }
    }
    private boolean Hajotervan(int x, int y, char irany, int hossz)
    {
        boolean ter = true;

            if (irany == 'v') {
                for (int i = 0; i < hossz + 2; i++) {
                    try {

                        if (table[x - 1 + i][y - 1] == 'X') {
                            ter = false;
                        }
                        if (table[x - 1 + i][y] == 'X') {
                            ter = false;
                        }
                        if (table[x - 1 + i][y + 1] == 'X') {
                            ter = false;
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            } else {
                for (int i = 0; i < hossz + 2; i++) {
                    try {
                        if (table[x - 1][y - 1 + i] == 'X') {
                            ter = false;
                        }
                        if (table[x][y - 1 + i] == 'X') {
                            ter = false;
                        }
                        if (table[x + 1][y - 1 + i] == 'X') {
                            ter = false;
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                }

            }

        return ter;
    }

}
