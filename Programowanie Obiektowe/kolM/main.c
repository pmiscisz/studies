#include <stdio.h>
#include <math.h>

double zad1(double x,double y){
    double wynik;
    if(x < 0 && y >= 0)
        wynik = x*x - sqrt(y);
    else if(x > 0 && y == 0)
        wynik = x*x;
    else if(x >= 0 && y > 0)
        wynik = x * x + y * y;
    return wynik;
}

double zad2(double a,double b){
    return 2 * a + 2 * b;
}
double zad3(int n){
    double suma = 0;
    double pomocnicza;
    for(int i=0;i<n;i++){
        printf("Podaj %d wartosc zbioru: ",i+1);
        scanf("%lf",&pomocnicza);
        if(pomocnicza < 0)
            suma = suma + pomocnicza;

    }
    if(suma != 0)
        return suma;
    else{
        printf("Brak liczb spelniajacych zalozenia");
        return 0;
    }
}

int main()
{
    int n;
    double x, y,a,b;
    int ktoreZadanie;
    printf("Ktore zadanie chcesz wykonca: ");
    scanf("%d",&ktoreZadanie);
    switch(ktoreZadanie){
    case 1:
        printf("Podaj x: ");
        scanf("%lf",&x);
        printf("Podaj y: ");
        scanf("%lf",&y);
        printf("Wynik tego rownania to: %2.lf\n",zad1(x,y));
        break;
    case 2:
        printf("Podaj pierwszy bok prostokata: ");
        scanf("%lf",&a);
        printf("Podaj drugi bok prostokata: ");
        scanf("%lf",&b);
        printf("Obwod prostokata to: %2.lf\n",zad2(a,b));
        break;
    case 3:
        printf("Podaj wielkosc zbioru: ");
        scanf("%d",&n);
        printf("Suma ujemnych liczb zbioru: %2.lf\n",zad3(n));
        break;
    default:
        printf("Wybierz liczby od 1 do 3: ");
        break;
    }


    return 0;
}
