#include <iostream>
#include <stdlib.h>
#include <ctime>

using namespace std;

int calcularSecuenciaAleatoria(void)
{
    int numaleat;
    numaleat = rand()%9999;
    return numaleat;
}

int main()
{
    srand(time(NULL));
    for (int i = 1; i < 10; i++)
    {
        int resultado = calcularSecuenciaAleatoria();
        cout << "Secuencia aleatoria: " << i << endl;
        cout << resultado;
        cout << endl << endl;
    }

    return 0;
}
