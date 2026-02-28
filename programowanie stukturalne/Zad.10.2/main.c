#include <stdio.h>

#define N 10

void wczytaj(int tab[], int n) {
    for (int i = 0; i < n; i++) {
        printf("Podaj element %d: ", i + 1);
        scanf("%d", &tab[i]);
    }
}

void wyswietl(int tab[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", tab[i]);
    }
    printf("\n");
}

int max(int tab[], int n) {
    int max = tab[0];
    for (int i = 1; i < n; i++) {
        if (tab[i] > max) {
            max = tab[i];
        }
    }
    return max;
}

int suma(int tab[], int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += tab[i];
    }
    return sum;
}

int ileRazy(int tab[], int n, int liczba) {
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (tab[i] == liczba) {
            count++;
        }
    }
    return count;
}

int main() {
    int tab1[N];
    int n;
    printf("Podaj liczbe elementow tablicy 2: ");
    scanf("%d", &n);
    int tab2[n];

    printf("Wczytywanie danych do tablicy 1...\n");
    wczytaj(tab1, N);
    printf("Wczytywanie danych do tablicy 2...\n");
    wczytaj(tab2, n);

    printf("Wyswietlanie elementow tablicy 1...\n");
    wyswietl(tab1, N);
    printf("Wyswietlanie elementow tablicy 2...\n");
    wyswietl(tab2, n);

    printf("Najwieksza wartosc tablicy 1: %d\n", max(tab1, N));
    printf("Najwieksza wartosc tablicy 2: %d\n", max(tab2, n));

    printf("Suma elementow tablicy 1: %d\n", suma(tab1, N));
    printf("Suma elementow tablicy 2: %d\n", suma(tab2, n));

    int liczba;
    printf("Podaj liczbe, ktorej chcesz szukac: ");
    scanf("%d", &liczba);
    printf("Liczba %d wystapila w tablicy 1 %d razy\n", liczba, ileRazy(tab1, N, liczba));
    printf("Liczba %d wystapila w tablicy 2 %d razy\n", liczba, ileRazy(tab2, n, liczba));
return 0;
}
