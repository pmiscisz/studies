#include <iostream>
#include <list>
#include <vector>
#include <cstdlib>
#include <ctime>
using namespace std;

int main() {
    srand(static_cast<int>(time(0)));
    int n = rand() % 100 + 1;
    cout << "Wylosowana liczba n: " << n << endl;

    list<int> liczby;
    for (int i = 0; i < n; ++i) {
        int losowa = rand() % 201 - 100;
        liczby.push_back(losowa);
    }


    vector<int> nieujemne;
    vector<int> ujemne;


    for (int liczba : liczby) {
        if (liczba >= 0) {
            nieujemne.push_back(liczba);
        } else {
            ujemne.push_back(liczba);
        }
    }


    liczby.clear();
    liczby.insert(liczby.end(), nieujemne.begin(), nieujemne.end());
    liczby.insert(liczby.end(), ujemne.begin(), ujemne.end());


    cout << "Zawartosc listy: ";
    for (int liczba : liczby) {
        cout << liczba << " ";
    }
    cout << endl;

    return 0;
}
