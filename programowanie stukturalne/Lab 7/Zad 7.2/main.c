#include <stdio.h>
#include <stdlib.h>

int szlaczek(int a)
{
    for (int i = 0; i < a; i++)
    {
        printf("^");
    }
}
int main()
{
    int x;
    printf("Podaj dlugosc szlaczka: ");
    scanf("%d", &x);
    szlaczek(x);



 return 0;
}
