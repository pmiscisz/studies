#include <stdio.h>

struct Pracownik {
    char imie[20];
    char nazwisko[20];
    int liczbaGodzin;
    float stawka;
    float premia;
};


void wczytajDane(struct Pracownik *pracownik) {
    printf("Podaj imie pracownika: ");
    scanf("%s", &pracownik->imie);
    printf("Podaj nazwisko pracownika: ");
    scanf("%s", &pracownik->nazwisko);
    printf("Podaj liczbe godzin przepracowanych przez pracownika: ");
    scanf("%d", &pracownik->liczbaGodzin);
    printf("Podaj stawke za godzine pracy: ");
    scanf("%f", &pracownik->stawka);
    printf("Podaj premie w procentach: ");
    scanf("%f", &pracownik->premia);
}

float obliczPlace(struct Pracownik pracownik) {
    return pracownik.liczbaGodzin * pracownik.stawka * (1 + pracownik.premia / 100);
}

void wyswietlDane(struct Pracownik pracownik) {
    printf("Dane pracownika:\n");
    printf("Imie: %s\n", pracownik.imie);
    printf("Nazwisko: %s\n", pracownik.nazwisko);
    printf("Liczba godzin przepracowanych: %d\n", pracownik.liczbaGodzin);
    printf("Stawka za godzine: %.2f\n", pracownik.stawka);
    printf("Premia: %.2f%%\n", pracownik.premia);
    printf("Placa: %.2f\n", obliczPlace(pracownik));
}

int main() {
    struct Pracownik pracownik;
    wczytajDane(&pracownik);
    wyswietlDane(pracownik);
    return 0;
}
