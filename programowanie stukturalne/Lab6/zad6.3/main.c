#include <stdio.h>
#include <stdlib.h>
void SredniaParzysteNieparzyste ()
{
    float sumaParzyste, sumaNieparzyste, sredniaParzyste, sredniaNieparzyste, lp = 0, lnp = 0;
    int x;
    do
    {
        printf("Podaj liczbe: ");
        scanf("%d",&x);
        if (x != 0)
        {
            if (x % 2 == 0)
            {
                sumaParzyste += x;
                lp++;
            }
            else
            {
                sumaNieparzyste += x;
                lnp++;
            }
        }

    }while (x != 0);
    sredniaNieparzyste = sumaNieparzyste / lnp;
    sredniaParzyste = sumaParzyste / lp;
    printf("Srednia liczb parzystych to: %f\n",sredniaParzyste);
    printf("Srednia liczb nieparzystych to: %f\n",sredniaNieparzyste);
}

int main()
{
    SredniaParzysteNieparzyste();
    return 0;
}
