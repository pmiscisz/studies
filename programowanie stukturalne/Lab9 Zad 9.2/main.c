#include <stdio.h>
#include <stdlib.h>

void zamiana(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
    return;
}

int main()
{
    int x,y;
    printf("Podaj pierwsza liczbe: ");
    scanf("%d",&x);
    printf("Podaj druga liczbe: ");
    scanf("%d",&y);

    printf("Liczby przed zamiana: %d, %d\n",x,y);

    zamiana(&x,&y);

    printf("Liczby po zamianie: %d, %d\n",x,y);

    return 0;
}
