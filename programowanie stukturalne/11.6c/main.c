#include <stdio.h>
#include <stdlib.h>

double *new_tab(int n) {
    double *tab = (double *) malloc(n * sizeof(double));
    if (tab == NULL) {
        printf("ZA MA£O PAMIÊCI\n");
        exit(EXIT_FAILURE);
    }
    return tab;
}

void input_data(double *tab, int n, int m) {
    printf("Podaj wszystkie wartoœci tablicy dwuwymiarowej");
    for (int i = 0; i < n * m; i++) {
        scanf("%lf", (tab + i));
    }
}

double *f1(double *tab, int n, int m, int ile_d) {
    double *tab_d = new_tab(ile_d);
    int q = 0;
    for (int i = 0; i < n * m; i++)
        if (*(tab + i) > 0.0)
            *(tab_d + q++) = *(tab + i);
    return tab_d;
}

double *f2(double *tab, int n, int m, int ile_u) {
    double *tab_u = new_tab(ile_u);
    int q = 0;
    for (int i = 0; i < n * m; i++)
        if (*(tab + i) < 0.0)
            *(tab_u + q++) = *(tab + i);
    return tab_u;
}

void print_tab(double *tab, int n) {
    for (int i = 0; i < n; i++)
        printf("%lf ", *(tab + i));
}

int main() {
    int n, m;
    printf("Podaj n i m: ");
    scanf("%d%d", &m, &n);
    double *tab = new_tab(n * m);
    input_data(tab, n, m);
    int ile_d = 0, ile_u = 0;
    for (int i = 0; i < n * m; i++)
        if (*(tab + i) > 0.0)
            ile_d++;
        else if (*(tab + i) < 0.0)
            ile_u++;
    double *tab_d = f1(tab, n, m, ile_d);
    double *tab_u = f2(tab, n, m, ile_u);
    print_tab(tab_d, ile_d);
    free(tab_d);
    print_tab(tab_u, ile_u);
    free(tab_u);
}
