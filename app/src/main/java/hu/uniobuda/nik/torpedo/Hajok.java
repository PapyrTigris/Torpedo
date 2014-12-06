package hu.uniobuda.nik.torpedo;

import java.util.Random;

/**
 * Created by Papír Tigris on 2014.12.06..
 */
public class Hajok {
    Hajo[] hajok;
    Hajo lotthajo;
    Random R ;


    public Hajok() {
        //A hajók száma legyen mondjuk 5
        hajok = new Hajo[5];
        R = new Random();
        HajoLetrehoz(5);
        HajoLetrehoz(3);
        HajoLetrehoz(3);
        HajoLetrehoz(2);
        HajoLetrehoz(2);
    }

    public void Loves(int xy)
    {
      int  x=xy/Solo_Multy_Activity.oszlop;
      int  y=xy%Solo_Multy_Activity.oszlop;
        Loves(x,y);
    }

    public void Loves(int x, int y)
    {
      if (Hajoe(x,y)){Sullyedt(lotthajo);};
    }


    public boolean Hajoe(int x,int y)
    {
        boolean hajo =false;
        //debugoz
        int z = hajok.length;
        for (int i= 0;i<hajok.length;i++)
        {
           //debughoz
           int r  = hajok[i].getHajo().length;
            for (int j=0;j<hajok[i].getHajo().length;j++)

                if (hajok[i].getHajo()[j].getX()==x&&hajok[i].getHajo()[j].getY()==y) {
                    hajo=true;
                    lotthajo = hajok[i];
                }
        }
        return hajo;
    }
    public void Sullyedt(Hajo lotthajo)
    {
       //return false;

    }

    public void HajoLetrehoz(int hajohossz)
    {
        int irany;
        int x = R.nextInt(Solo_Multy_Activity.oszlop);
        int y = R.nextInt(Solo_Multy_Activity.sor);
        irany = R.nextInt(1);
        Pozicio pozicio= new Pozicio(x,y);

        if(Tablabaesik(pozicio,hajohossz,irany)&&Nincshajokozel(pozicio,irany,hajohossz))
        {
            Hajo H = new Hajo(x,y,hajohossz,irany);
        }
        else
        {HajoLetrehoz(hajohossz);}

    }
    private boolean Tablabaesik(Pozicio pozicio,int hajohossz, int irany)
    {

        boolean esik=false;
        if (irany==0)
        {
            //vízszintes
            if (pozicio.getX()+hajohossz-1<Solo_Multy_Activity.oszlop){esik =  true;}
        }
        else
        {
            if (pozicio.getX()+hajohossz-1<Solo_Multy_Activity.oszlop){esik =  true;}
        }
        return esik;
    }
    public boolean Nincshajokozel(Pozicio p,int irany,int hajohossz )
    {

        int Kezdox ;//= p.getX()-1;
        int Kezdoy ;//= p.getY()-1;
        if (irany == 0 && p.getX()==0){Kezdox = 0;}else {Kezdox = p.getX();}
        if (irany == 1 && p.getY()==0){Kezdoy = 0;}else {Kezdoy = p.getY();}
        if (irany == 0)
        {
            for (int i = 0; i < hajohossz+1;i++)
            {
                if (Hajoe(Kezdox+i,Kezdoy )){return false;}
            }
          if (Kezdoy!=0&&Kezdox+hajohossz+1<Solo_Multy_Activity.oszlop){
            for (int i= 0;i<3;i++)
            {
             //nagyobb valószínűséggel fut ez az ág

                    if (Hajoe(Kezdox+hajohossz+1,Kezdoy-1+i)){return false;}

            }
        }else
          {
              if(Kezdox+hajohossz+1<Solo_Multy_Activity.oszlop){
              for (int i= 0;i<2;i++)
              {
                  if (Hajoe(Kezdox+hajohossz+1,Kezdoy+i)){return false;}
              }
              }
          }
        }
        else
        {
            //ha függőleges
            if (Kezdoy+hajohossz+1<Solo_Multy_Activity.sor){
            for (int i = 0; i < hajohossz+1;i++)
            {
                if (Hajoe(Kezdox,Kezdoy+i)){return false;}
            }
           //az utolső 3 mezőt is meg kell vizsgálni, ha nem esik a pályán kívülre
            if (Kezdox!=0){
                for (int i= 0;i<3;i++)
                {
                    //nagyobb valószínűséggel fut ez az ág
                    if (Hajoe(Kezdox-1+i,Kezdoy+hajohossz+1)){return false;}
                }
            }else
            {
                //ha szélre esik
                for (int i= 0;i<2;i++)
                {
                    if (Hajoe(Kezdox+i,Kezdoy+hajohossz+1)){return false;}
                }
            }
        }
        }

        return true;
    }

}
