#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int min(int* tab, int n) {
    int i, min = tab[0];
    for (i = 1; i < n; i++) {
        if (tab[i] < min) {
            min = tab[i];
        }
    }
    return min;
}

float srednia(int* tab, int n) {
    int i;
    float suma = 0;
    for (i = 0; i < n; i++) {
        suma += tab[i];
    }
    return suma / n;
}

void losuj(int* tab, int n) {
    int i;
    srand(time(NULL));
    for (i = 0; i < n; i++) {
        tab[i] = rand() % 10;
    }
}

int ileRazy2(int* tab, int n, int liczba) {
    int i, count = 0;
    for (i = 0; i < n; i++) {
        if (tab[i] == liczba) {
            count++;
        }
    }
    return count;
}

int main() {
    int DOLNA=2;
    int dolna=1;
    printf("%d",DOLNA);
    printf("%d",dolna);

    return 0;
}
