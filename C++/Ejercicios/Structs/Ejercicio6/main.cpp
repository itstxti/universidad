#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

struct hora
{
    int hh;
    int mm;
    int ss;
};

hora horaAleatoria()
{
    hora haleat;
    haleat.hh = rand() % 24;
    haleat.mm = rand() % 60;
    haleat.ss = rand() % 60;

    return haleat;
}

int main()
{
    for (int i = 1; i < 11; i++)
    {
        hora horaAl = horaAleatoria();
        cout << "HORA " << i << " : " << horaAl.hh << ":" << horaAl.mm << ":" << horaAl.ss << endl;
    }

    return 0;
}
