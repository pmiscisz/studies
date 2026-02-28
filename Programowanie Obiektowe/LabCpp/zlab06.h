#ifndef ZLAB06_H
#define ZLAB06_H
#include "zlab03.h"
#include<iostream>

using namespace std;

class Obliczenia {
protected:
    const double pi = 3.14;
public:
    virtual double promienKolaWgPola() = 0;
    virtual double promienOkreguWgObwodu() = 0;
    virtual ~Obliczenia(){}
    Obliczenia(){}
};

 class Kwadrat : public Prostokat, public Obliczenia
{
public:
      double promienKolaWgPola();
      double promienOkreguWgObwodu();


    Kwadrat(string nazwa = "?", double bok =0):Prostokat(nazwa,bok,bok),Obliczenia(){}

    ~Kwadrat()
    {
        cout <<"Kwadrat: " << nazwa << "Konczy dzialanie" << endl;
    }

    string doTekstu();
};



#endif // ZLAB06_H

