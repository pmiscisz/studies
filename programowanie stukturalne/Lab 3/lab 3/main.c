#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

const char status[20] = "student";
char imie[10], nazwisko[10], plec[10];
const float srednia = 4.0;
int wiek;

void wyswietlenie(void)
{
    printf("Podaj swoje imie: ");
    scanf("%s",&imie);
    printf("Podaj swoje nazwisko: ");
    scanf("%s",&nazwisko);
    printf("Podaj swoj wiek: ");
    scanf("%d",&wiek);
    printf("Podaj swoja p³ce: ");
    scanf("%s",&plec);
    printf("Twoje imiê to: %s,Twoje nazwisko to: %s,Twoj wiek to: %d,Twoja plec to:  %s\n",imie,nazwisko,wiek,plec);
    printf("Twój status to: %s,Twoja œrednia to:  %f\n",status,srednia);

}

int main(int argc, char *argv[]){
//setlocale(LC_ALL,"");
//const char status[20] = "student";
//char imie[10], nazwisko[10], plec[10];
//const float srednia = 4.0;
//int wiek;
    //printf("Podaj swoje imie: ");
  //  scanf("%s",&imie);
   // printf("Podaj swoje nazwisko: ");
  //  scanf("%s",&nazwisko);
  //  printf("Podaj swoj wiek: ");
  //  scanf("%d",&wiek);
  //  printf("Podaj swoja p³ce: ");
  //  scanf("%s",&plec);
   // printf("Twoje imiê to: %s,Twoje nazwisko to: %s,Twoj wiek to: %d,Twoja plec to:  %s\n",imie,nazwisko,wiek,plec);
  //  printf("Twój status to: %s,Twoja œrednia to:  %f\n",status,srednia);
wyswietlenie();

return 0;
}
