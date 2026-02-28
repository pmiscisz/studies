#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>


using namespace std;


int sumaCyfr(int liczba) {
    int sum = 0;
    liczba=abs(liczba);
    while (liczba > 0) {
        sum += liczba % 10;
        liczba /= 10;
    }
    return sum;
}


int ileLiczb(int liczba) {
    return to_string(abs(liczba)).length();
}


void wyswietl(vector<int>& vec) {
    for_each(vec.begin(), vec.end(), [](int n) {cout << n << " "; });
    cout << endl;
}

int main() {

    vector<int> liczby = {1, 13, 4, -8, 0, -643, 589, 121, 80};


    sort(liczby.begin(), liczby.end(), [](int a, int b) {
        return sumaCyfr(a) < sumaCyfr(b);
    });
    cout << "Sortowanie rosnaco wedlug sumy cyfr: ";
    wyswietl(liczby);

    // Sortowanie malejąco według liczby cyfr
    sort(liczby.begin(), liczby.end(), [](int a, int b) {
        return ileLiczb(a) < ileLiczb(b);
    });
    cout << "Sortowane malejaco wedlug liczby cyfr: ";
    wyswietl(liczby);

    return 0;
}
