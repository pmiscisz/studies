#include <stdio.h>
#include <stdlib.h>

int place(int a)
{
    float placa;
    float suma = 0;
    for(int i = 0; i < a; i++)
    {
        printf("Podaj zarobki: ");
        scanf("%f",&placa);
        if (placa > 5000)
        {
            placa = placa + placa * 0.05;
            suma += placa;
        }
        else
        {
            placa = placa + placa * 0.1;
            suma += placa;
        }
        printf("%3d. Zarobki po podwyzce: %f\n",i+1,placa);

    }
    printf("Suma nowych zarobkow wynosi: %f",suma);
}

int main()
{
    int n;
    printf("Podaj ilosc osob: ");
    scanf("%d",&n);
    place(n);
    return 0;
}
