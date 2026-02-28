#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int t;
    float kat, radiana, z;
    const float PI = 3.1459;
    printf("Podaj t: ");
    scanf("%d",&t);
    printf("Podaj kat: ");
    scanf("%f",&kat);
    radiana = kat * (PI / 180.0);
    printf("Cos(%f) = %f\n", kat, cos(radiana));
    switch(t)
    {
    case 0:
        z = (1 + cos(radiana))/2;
        printf("Wartosc z to: %f",z);
        break;
    case 1:
         z = (1 + cos(radiana))/2;
        printf("Wartosc z to: %f",z);
        break;
    case 2:
        z = (1 + cos(radiana))/2;
        printf("Wartosc z to: %f",z);
        break;
    case 3:
        z = (1 + cos(radiana))/2;
        printf("Wartosc z to: %f",z);
        break;
    case 4:
        z = sqrt((kat*kat)+1);
        printf("Wartosc z to: %f",z);
        break;
    case 6:
         z = sqrt((kat*kat)+1);
        printf("Wartosc z to: %f",z);
        break;
    case 7:
         z = sqrt((kat*kat)+1);
        printf("Wartosc z to: %f",z);
        break;
    case 8:
        z = 1 - (sin(radiana));
        printf("Wartosc z to: %f",z);
        break;
    default:
        printf("Nieprawidlowa wartosc t");
    }
    return 0;
}
