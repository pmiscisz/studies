#include <iostream>
#include<fstream>
#include<sstream>
#include <algorithm>

using namespace std;

struct student {
    string imie;
    string nazwisko;
    int punkty;

    public:
       string toString() const {
           return imie + " " + nazwisko + " " + to_string(punkty);
       }
};

void wyswietlStudentow_2(student *tab, int n) {
    int i = 0;
    cout << "Studenci z 10 punktami lub mniej" << endl;
    for (; i < n && tab[i].punkty <= 10; i++) {
        cout<< tab[i].toString() << endl;
    }
    cout << "Studenci z wiecej niz 10 punktami" << endl;
    for (; i < n; i++) {
        cout << tab[i].toString() << endl;
    }
}

void wyswietlStudentow_1(student *tab, int n) {
    for (int i = 0; i < n; i++) {
        cout << "Student nr " << i + 1 << " " << tab[i].toString() << endl;
    }
}

void wyswietlStudentow_3(student *tab, int n) {
    int i = 0;
    cout << "Studenci, ktorzy otrzymali liczbe punktow podzielnych przez 3" << endl;
    for (; i < n && tab[i].punkty % 3 == 0; i++) {
        cout<< tab[i].toString() << endl;
    }
    cout << "Studenci, ktorzy otrzymali liczbe punktow podzielnych przez 3 z reszta 1" << endl;
    for (; i < n && tab[i].punkty % 3 == 1; i++) {
        cout << tab[i].toString() << endl;
    }
    cout << "Studenci, ktorzy otrzymali liczbe punktow podzielnych przez 3 z reszta 2" << endl;
    for (; i < n; i++) {
        cout << tab[i].toString() << endl;
    }
}



void podzialDwaZbiory(student* tab, int n) {
    sort(tab, tab + n, [](student a, student b) { return a.punkty < b.punkty; });
}

void podzialTrzyZbiory(student* tab, int n) {
    sort(tab, tab + n, [](student a, student b) { return a.punkty % 3 < b.punkty % 3; });
}



int main() {
    string sciezka, linia, pomoc;
    int liczbaStudentow;
    ifstream plik;
    char sredniki;
    sciezka = "studenci.csv";
    plik.open(sciezka);
    plik >> liczbaStudentow;
    cout << liczbaStudentow << endl;

    student *tab;

    tab = new student[liczbaStudentow];

    for (int i = 0; i < 2; i++) {
        plik >> sredniki;
    }


    for (int i = 0; i < liczbaStudentow; i++) {
        plik >> linia;
        stringstream ss(linia);
        getline(ss, tab[i].imie, ';');
        getline(ss, tab[i].nazwisko, ';');
        getline(ss, pomoc);
        tab[i].punkty = atoi(pomoc.c_str());
    }


    plik.close();

    cout << "Przed podzialem" << endl;
    wyswietlStudentow_1(tab, 14);

    cout << "Po podziale na 2 zbiory" << endl;

    podzialDwaZbiory(tab, 14);

    wyswietlStudentow_2(tab, 14);

    cout << "Po podziale na 3 zbiory" << endl;

    podzialTrzyZbiory(tab, 14);

    wyswietlStudentow_3(tab, 14);


    return 0;
}
