#include <stdio.h>
#include <stdlib.h>

void dekompozycja()
{
    float x,y;
    printf("Podaj liczbe: ");
    scanf("%f",&x);
    int z = (int)x;
    y = x - z;

    printf(" calkowita: %d rzeczywista: %f",z,y);
    return;
}

int main()
{
    dekompozycja();
    return 0;
}
