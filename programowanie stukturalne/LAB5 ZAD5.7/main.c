#include <stdio.h>
#include <stdlib.h>
int miesiac;
int miesiace(int x)
{
    switch(x)
    {
    case 1:
        printf("Styczen\n 31 dni\n 1 kwartal");
        break;
    case 2:
        printf("Luty\n 28 dni lub 29 w rok przestepny\n 1 kwartal");
        break;
    case 3:
        printf("Marzec\n 31 dni\n 1 kwartal");
        break;
    case 4:
        printf("Kwiecien\n 30 dni\n 2 kwartal");
        break;
    case 5:
        printf("Maj\n 31 dni\n 2 kwartal");
        break;
    case 6:
        printf("Czerwiec\n 30 dni\n 2 kwartal");
        break;
    case 7:
        printf("Lipiec\n 31 dni\n 3 kwartal");
        break;
    case 8:
        printf("Sierpien\n 31 dni\n 3 kwartal");
        break;
    case 9:
        printf("Wrzesien\n 30 dni\n 3 kwartal");
        break;
    case 10:
        printf("Pazdziernik\n 31 dni\n 4 kwartal");
        break;
    case 11:
        printf("Listopad\n 30 dni\n 4 kwartal");
        break;
    case 12:
        printf("Grudzien\n 31 dni\n 4 kwartal");
        break;

    }
}
int main()
{
    printf("Podaj numer miesiaca: ");
    scanf("%d",&miesiac);
    if (miesiac > 0 && miesiac < 13)
        miesiace(miesiac);
    else
        printf("Nie ma takiego miesiaca");
    return 0;
}
