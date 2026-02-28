#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric> // dla accumulate
#include "car.h"

using namespace std;

void wyswietl(const vector<int>& vec) {
    for (const auto& el : vec) {
        cout << el << " | ";
    }
    cout << endl;
}

double sredniaArytm(const vector<int>& vec) {
    if (vec.empty()) return 0;
    return static_cast<double>(accumulate(vec.begin(), vec.end(), 0)) / vec.size();
}

int iloscParzystych(const vector<int>& vec) {
    return count_if(vec.begin(), vec.end(), [](int n) { return n % 2 == 0; });
}

void usunUjemne(vector<int>& vec) {
    vec.erase(remove_if(vec.begin(), vec.end(), [](int n) { return n < 0; }), vec.end());
}

void sortParzysteNieparzyste(vector<int>& vec) {
    sort(vec.begin(), vec.end(), [](int a, int b) {
        return (a % 2 == 0) && (b % 2 != 0);
    });
}

void liczbaPrzeciwna(vector<int>& vec) {
    transform(vec.begin(), vec.end(), vec.begin(), [](int n) { return -n; });
}

int iloscMniejszse(const vector<int>& vec, int value) {
    return count_if(vec.begin(), vec.end(), [value](int n) { return n < value; });
}

int main() {
    vector<int> vec = {5, -2, 10, 3, -7, 8, -1, 4};

    cout << "Poczatkowy wektor:\n";
    wyswietl(vec);

    double avg = sredniaArytm(vec);
    cout << "Srednia arytmetyczna: " << avg << "\n\n";

    int evenCount = iloscParzystych(vec);
    cout << "Liczba elementow parzystych: " << evenCount << "\n\n";

    usunUjemne(vec);
    cout << "Wektor po usunieciu elementow ujemnych:\n";
    wyswietl(vec);

    sortParzysteNieparzyste(vec);
    cout << "Wektor po sortowaniu (parzyste przed nieparzystymi):\n";
    wyswietl(vec);

    liczbaPrzeciwna(vec);
    cout << "Wektor po nadpisaniu elementow liczbami przeciwnymi:\n";
    wyswietl(vec);

    int n = 0;
    int mniejszeNizN = iloscMniejszse(vec, n);
    cout << "Liczba elementow mniejszych niz " << n << ": " << mniejszeNizN << "\n";

    vector<Car> cars = {
        Car("Fiat Multipla", 2010, 1.0),
        Car("Ford", 2004, 5.0),
        Car("Mercedes", 2020, 1.9),
        Car("BMW", 2003, 2.5),
        Car("Audi", 2019, 2.0)
    };

    cout << "Poczatkowa lista samochodow:\n";
    int counter = 1;
    for (const auto& car : cars) {
        cout << counter++ << ". ";
        car.Informacje();
    }

    sort(cars.begin(), cars.end(), [](const Car& a, const Car& b) {
        return a.getRocznik() < b.getRocznik();
    });

    cout << "Samochody posortowane rosnaco wedlug roku produkcji:\n";
    counter = 1;
    for (const auto& car : cars) {
        cout << counter++ << ". ";
        car.Informacje();
    }


    sort(cars.begin(), cars.end(), [](const Car& a, const Car& b) {
        return a.getPojemnoscSilnika() > b.getPojemnoscSilnika();
    });

    cout << "Samochody posortowane malejaco wedlug pojemnosci silnika:\n";
    counter = 1;
    for (const auto& car : cars) {
        cout << counter++ << ". ";
        car.Informacje();
    }

    return 0;
}
