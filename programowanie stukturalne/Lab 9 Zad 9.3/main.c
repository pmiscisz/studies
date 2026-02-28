#include <stdio.h>
#include <stdlib.h>
void zamiana_wartosci_suma_roznica(int *x, int *y)
{
    int temp = *x;
    *x -= *y;
    *y += temp;
    return;
}

int main()
{
    int x, y;
    printf("podaj pierwsza liczbe: ");
    scanf("%d",&x);
    printf("podaj druga liczbe: ");
    scanf("%d",&y);
    printf("x: %d\ny: %d \n",x,y);
    zamiana_wartosci_suma_roznica(&x,&y);
    printf("suma: %d\nroznica: %d \n",y,x);
    return 0;
}
