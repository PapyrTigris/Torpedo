/**
 * Created by Papír Tigris on 2014.11.29..
 */
/*0 - Talált
  X - Mellé

  */
public class Tabla_adatok {
    int sor = 10;
    int oszlop = 10;
    char [][]table;

    public Tabla_adatok(int sor, int oszlop) {
        this.sor = sor;
        this.oszlop = oszlop;
    }

    public Tabla_adatok()
    {
        init();
    }
    //
    private void init()
    {
      table  = new char[sor] [oszlop];
        for(int i=0;i<sor;i++)
        {
            for(int j=0;j<sor;j++)
            {
                table[i][j]=' ';
            }
        }
    }
    public void Melle(int x, int y)
    {
        table[x][y] = 'X';
    }
    public void Talalt(int x, int y)
    {
        table[x][y] = 'O';
    }

    public  void Sullyedt(int x, int y)
    {
       char irany= ' ';

         if (Loves(x,y)) {

             if (!Loves(x++, y)) {
                 table[x++][y] = 'X';
                 irany = 'j';

             }
             if (!Loves(x, y++)) {
                 table[x][y++] = 'X';
                 irany = 'l';
             }
             if (!Loves(x, y--)) {
                 table[x][y--] = 'X';
                 irany = 'f';
             }
             if (!Loves(x--, y)) {
                 table[x--][y] = 'X';
                 irany = 'b';
             }
         }
        switch (irany)
        {
            case 'j'  : Sullyedt(x++,y); break;
            case 'l'  : Sullyedt(x,y++); break;
            case 'f'  : Sullyedt(x,y--); break;
            case 'b'  : Sullyedt(x--,y); break;
        }
    }
    private boolean Loves(int x, int y)
    {
        if (table[x][y] == 'O') return  true;
        else return false;
    }


}
