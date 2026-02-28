#include <stdio.h>
#include <stdlib.h>

void pr_powrot(char *str){
    printf("OK\n"); return;
}

int main()
{
    for(int num=1;num<=10;num++)
        if(num%2)
        printf("%d",num);

    pr_powrot("Grzes");

    return 0;

}
