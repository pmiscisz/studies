#include <stdio.h>

void wczytaj(int n, int m, float tab[n][m]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("Podaj element [%d][%d]: ", i + 1, j + 1);
            scanf("%f", &tab[i][j]);
        }
    }
}

void wyswietl(int n, int m, float tab[n][m]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%f\t", tab[i][j]);
        }
        printf("\n");
    }
}

float suma(int n, int m, float tab[n][m]) {
    float sum = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            sum += tab[i][j];
        }
    }
    return sum;
}

float srednia(int n, int m, float tab[n][m]) {
    return suma(n,m,tab) / (n * m);
}

int main() {
    int n,m;
    printf("Podaj liczbe wierszy: \n");
    scanf("%d",&n);
    printf("Podaj liczbe kolumn: \n");
    scanf("%d",&m);
    float tab[n][m];

    printf("Wczytywanie danych do tablicy: \n");
    wczytaj(n,m,tab);
    printf("Wyswietlanie elementow tablicy:\n");
    wyswietl(n,m,tab);
    printf("Suma elementow tablicy: %f\n", suma(n,m,tab));
    printf("Srednia elementow tablicy: %f\n", srednia(n,m,tab));

    return 0;
}
