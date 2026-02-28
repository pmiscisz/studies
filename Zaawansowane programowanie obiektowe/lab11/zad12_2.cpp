//#include <iostream>
//#include <vector>
//#include <algorithm>
//#include "car.h"

//using namespace std;

//int main() {
//    vector<Car> cars = {
//        Car("Fiat Multipla", 2010, 1.0),
//        Car("Ford", 2004, 5.0),
//        Car("Mercedes", 2020, 1.9),
//        Car("BMW", 2003, 2.5),
//        Car("Audi", 2019, 2.0)
//    };

//    cout << "Początkowa lista samochodów:\n";
//    int counter = 1;
//    for (const auto& car : cars) {
//        cout << counter++ << ". ";
//        car.Informacje();
//    }

//    sort(cars.begin(), cars.end(), [](const Car& a, const Car& b) {
//        return a.getRocznik() < b.getRocznik();
//    });

//    cout << "Samochody posortowane rosnąco według roku produkcji:\n";
//    counter = 1;
//    for (const auto& car : cars) {
//        cout << counter++ << ". ";
//        car.Informacje();
//    }


//    sort(cars.begin(), cars.end(), [](const Car& a, const Car& b) {
//        return a.getPojemnoscSilnika() > b.getPojemnoscSilnika();
//    });

//    cout << "Samochody posortowane malejąco według pojemności silnika:\n";
//    counter = 1;
//    for (const auto& car : cars) {
//        cout << counter++ << ". ";
//        car.Informacje();
//    }

//    return 0;
//}
