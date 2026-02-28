#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float a, b, c,pierwiastek1, pierwiastek2, delta;
float rkwadratowe(float x,float y,float z)
{
    delta = (y*y)-(4*x*z);
    if(x!=0)
        if(delta < 0)
            printf("Rownanie nie ma rozwiwazan rzeczywistych");
        else if(delta == 0)
            {
                pierwiastek1 = -y/(2*x);
                printf("Pierwiastkiem tego rownania jest: %f\n",pierwiastek1);
            }
        else
        {
            pierwiastek1 = (-y-sqrtf(delta))/(2*x);
            pierwiastek2 = (-y+sqrtf(delta))/(2*x);
            printf("Pierwiastkami tego rownania sa: x1 = %f x2 = %f",pierwiastek1,pierwiastek2);
        }
    else
        printf("To nie jest rownanie kwadratowe");
}
int main()
{
    float a, b, c,pierwiastek1, pierwiastek2, delta;
    printf("Podaj wspolczynnik a Rownania kwadratowego: ");
    scanf("%f",&a);
    printf("Podaj wspolczynnik b Rownania kwadratowego: ");
    scanf("%f",&b);
    printf("Podaj wspolczynnik c Rownania kwadratowego: ");
    scanf("%f",&c);
    rkwadratowe(a,b,c);
    return 0;
}
