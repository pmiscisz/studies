#include "car.h"

Car::Car(const string& model, int rocznik, double pojemnoscSilnika)
    : model(model), rocznik(rocznik), pojemnoscSilnika(pojemnoscSilnika) {}

string Car::getModel() const {
    return model;
}

int Car::getRocznik() const {
    return rocznik;
}

double Car::getPojemnoscSilnika() const {
    return pojemnoscSilnika;
}


void Car::setModel(const string& model) {
    this->model = model;
}

void Car::setRocznik(int rocznik) {
    this->rocznik = rocznik;
}

void Car::setpojemnoscSilnika(double pojemnoscSilnika) {
    this->pojemnoscSilnika = pojemnoscSilnika;
}


void Car::Informacje() const {
    cout << "Model: " << model << ", Rok produkcji: " << rocznik<< ", Pojemnosc silnika: " << pojemnoscSilnika << "L" << endl;
}
