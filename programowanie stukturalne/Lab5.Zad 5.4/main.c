#include <stdio.h>
#include <stdlib.h>

int main()
{
    float x,y;
    printf("Podaj wspolrzedna X punktu: ");
    scanf("%f",&x);
    printf("Podaj wspolrzedna Y punktu: ");
    scanf("%f",&y);
    if (x >= -1 && x <=1 && y >= -1 && y <= 1)
        printf("Punkt nalezy do zamalowanego obszaru\n");
    else
        printf("Punkt nie nalezy do zamalowanego obszaru\n");

    return 0;
}
