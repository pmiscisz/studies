#include <iostream>
#include "zlab06.h"

using namespace std;



int main()
{
    Kwadrat kwadrat("Kwadrek",4);

    Kwadrat & refDoKwadrat = kwadrat;

    double r0 = kwadrat.promienKolaWgPola();
    double r1 = kwadrat.promienOkreguWgObwodu();

    cout << "ro=" << r0 << endl
         << "r1=" << r1 << endl;

    return 0;
}
