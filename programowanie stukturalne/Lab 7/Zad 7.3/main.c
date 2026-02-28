#include <stdio.h>
#include <stdlib.h>

int slp(int a)
{
    float suma;
    int liczba, ilosc = 0;
    for (int i = 0; i < a; i++)
    {
        printf("Podaj liczbe: ");
        scanf("%d",&liczba);
        if (liczba % 2 == 0)
            {
                suma += liczba;
                ilosc++;
            }
    }
    printf("Srednia liczb parzystych to: %f",suma / ilosc);
    return 0;
}

int main()
{
    int n;
    printf("Podaj ilosc liczb: ");
    scanf("%d",&n);
    slp(n);
    return 0;
}
