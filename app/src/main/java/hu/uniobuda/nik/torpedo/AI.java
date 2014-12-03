package hu.uniobuda.nik.torpedo;

import java.util.Random;

/**
 * Created by Papír Tigris on 2014.12.02..
 */
public class AI
{
    private int table[][];
    private int sor;
    private int oszlop;
    private int max;
    private int maxdb;
    private Random R ;
    private char last;
    int[][] valaszthatok;

    public AI(int sorszam, int oszlopszam)
    {
        table = new int[sorszam][oszlopszam];
        this.oszlop=oszlopszam;
        this.sor=sorszam;
        TablaFeltolt();
        R = new Random();
        last = ' ';
        valaszthatok  = new int[maxdb][2];
    }

    private void  TablaFeltolt()
    {
        max =100;
        maxdb = sor*oszlop;
        for(int i= 0;i<sor;i++) {
            for (int j = 0; j < oszlop; j++) {
                table[i][j] = 100;
            }
        }
    }
    public int Loves_ki()
    {
        //a kimenő adatért felel(megfelelő formátum)
        //sor*y+x
        return  11;
    }
    private void Randomcsokkent()
    {
        int Rsor = R.nextInt(sor);
        int Roszlop = R.nextInt(oszlop);
        if (table[Rsor][Roszlop]==max)
        {
                 Csokkent(Rsor,Roszlop);
        }
        else
        {
            Randomcsokkent();
        }
    }
    private void tablecsokkent()
    {
        //A táblacsökkentés módjának meghatározása
        if (maxdb>(sor*oszlop/3))
        {
            Randomcsokkent();
            last ='r';
        }
        else
        {
            if (last=='r')
            {
                Valasztekfeltolt();
                Valasztvacsokkent();
            } else
            {
                Valasztvacsokkent();
            }
        }
    }
    private  void  Valasztekfeltolt()
    {
        //Mivel ez a megoldás drágább ezért csak 30% tól éri meg
        //Elsősorban a táblafeltöltés költséges, így ezt csak 1x végezzük max-onként
        int s = 0;
        for (int i=0;i<sor;i++)
        {
            for (int j=0;j<sor;j++)
            {
               if (table[i][j]==max)
               {
                   valaszthatok[s][0]= i;
                   valaszthatok[s][1]= j;
               }
            }
        }
    }
    private  void  Valasztvacsokkent()
    {
      int i =  R.nextInt(valaszthatok.length);
      Csokkent(valaszthatok[i][0],valaszthatok[i][1]);
        //valaszthatók tábblájának csökkentése


    }
    private void Csokkent(int sor, int oszlop)
    {
        //maga a tábla mezőértékeinek csökkentése
    }
}
