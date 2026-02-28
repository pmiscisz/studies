#ifndef CAR_H
#define CAR_H

#include <string>
#include <iostream>

using namespace std;

class Car {
private:
    string model;
    int rocznik;
    double pojemnoscSilnika;

public:
    Car(const string& model, int rocznik, double pojemnoscSilnika);
    string getModel() const;
    int getRocznik() const;
    double getPojemnoscSilnika() const;
    void setModel(const string& model);
    void setRocznik(int rocznik);
    void setpojemnoscSilnika(double pojemnoscSilnika);

    void Informacje() const;
};

#endif // CAR_H
