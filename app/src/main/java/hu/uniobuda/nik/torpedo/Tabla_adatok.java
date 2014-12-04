package hu.uniobuda.nik.torpedo;

/**
 * Created by Papír Tigris on 2014.11.29..
 */
/*0 - Talált
  X - Mellé

  */
public class Tabla_adatok {

    int sor = 10;
    int oszlop = 10;

    char[][] table;

    char irany;


    public Tabla_adatok(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
    }

    public Tabla_adatok() {
        init();
    }

    //
    private void init() {
        irany = ' ';
        table = new char[sor][oszlop];
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < sor; j++) {
                table[i][j] = ' ';
            }
        }
    }

    public void Melle(int x, int y) {
        table[x][y] = 'X';
    }

    public void Talalt(int x, int y) {
        table[x][y] = 'O';
    }


    public void Sullyedt(int x, int y) {
        //lekezelni a széleket


        if (Loves_talalt(x, y)) {

            if (!Loves_talalt(x++, y)) {
                table[x++][y] = 'X';
                if (irany == ' ') irany = 'j';

            }
            if (!Loves_talalt(x, y++)) {
                table[x][y++] = 'X';
                if (irany == ' ') irany = 'l';
            }
            if (!Loves_talalt(x, y--)) {
                table[x][y--] = 'X';
                if (irany == ' ') irany = 'f';
            }
            if (!Loves_talalt(x--, y)) {
                table[x--][y] = 'X';
                if (irany == ' ') irany = 'b';
            }
        }
        switch (irany) {
            case 'j':
                Sullyedt(x++, y);
                break;
            case 'l':
                Sullyedt(x, y++);
                break;
            case 'f':
                Sullyedt(x, y--);
                break;
            case 'b':
                Sullyedt(x--, y);
                break;
        }
    }

    private boolean Loves_talalt(int x, int y) {
        if (table[x][y] == 'O') return true;
        else return false;
    }


}
