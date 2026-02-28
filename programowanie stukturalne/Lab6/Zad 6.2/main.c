#include <stdio.h>
#include <stdlib.h>

float sredniaWhile(float a)
{
    float suma, srednia, x;
    float b = a;
    while (a > 0)
    {
        printf("Podaj liczbe: ");
        scanf("%f",&x);
        suma = suma + x;
        a--;
    }
    srednia = suma / b;
    printf("While Srednia wynosi: %f",srednia);
}

float sredniaDoWhile (float b)
{
    float suma2=0, srednia2=0, x2=0;
    float b2 = b;
    do
    {
        printf("Podaj liczbe: ");
        scanf("%f",&x2);
        suma2 = suma2 + x2;
        b--;
    }while (b > 0);
    srednia2 = suma2 / b2;
    printf("Do while Srednia wynosi: %f",srednia2);
}

int main()
{
    float n;
    printf("Podaj ilosc liczb: ");
    scanf("%f",&n);
    sredniaWhile(n);
    printf("\n");
    sredniaDoWhile(n);
    return 0;
}
