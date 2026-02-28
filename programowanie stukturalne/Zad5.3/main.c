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
    if ( t >= 0 && t <= 3)
    {
        printf("Przypadek od 0 do 3\n");
        z = ((1+cos(radiana))/2);
        printf("Z jest rowne: %f\n", z);
    }
    else if ( t >= 4 && t <= 7)
    {
        printf("Przypadek od 4 do 7\n");
        z = sqrt((kat*kat) + 1);
        printf("Z jest rowne: %f\n", z);
    }
    else if ( t == 8)
    {
        printf("Przypadek 8\n");
        z = 1 - (sin(kat));
        printf("Z jest rowne: %f\n", z);
    }
    else
        printf("Nieprawidlowe t");
    return 0;
}
