#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float a,b,c;
float ptrojkata(float x, float y, float z)
{
    if(x + y > z && x + z > y && z + y > x)
    {
        float pobw = (x + y + z)/2;//polowa obwoodu
        float pole = sqrt(pobw*(pobw-x)*(pobw-y)*(pobw-z));
        printf("Pole tego trojkata wynosi: %f",pole);
    }
    else
        printf("Z podanych bokow nie da sie utworzyc trojkata");
}
int main()
{
    printf("Podaj 1 bok trojkata: \n");
    scanf("%f",&a);
    printf("Podaj 2 bok trojkata: \n");
    scanf("%f",&b);
    printf("Podaj 3 bok trojkata: \n");
    scanf("%f",&c);
    ptrojkata(a,b,c);
    return 0;
}
