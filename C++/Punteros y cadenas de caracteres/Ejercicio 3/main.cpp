/*Programa que utiliza punteros a punteros a varios niveles.*/

#include <iostream>

using namespace std;

int main()
{
    char c = 'z'; //inicialización estática de punteros
    char* pc = &c;
    char** ppc = &pc;
    char*** pppc = &ppc;

    cout << "c = " << c << endl;

    cout << "&pppc = " << &pppc << ", pppc = " << pppc << endl;
    cout << "&ppc = " << &ppc << ", ppc = " << ppc << endl;
    cout << "&pc = " << &pc  << ", pc = " << (int**)pc << endl;
    cout << "&c = " << (int*)&c  << ", c = " << c << endl << endl;

    cout << "Accedemos al contenido de c a traves del puntero pppc: " << ***pppc << endl << endl;

    cout << "Asignamos ***pppc = 'q'" << endl;
    ***pppc = 'q';
    cout << "c = " << c  << endl;

    return 0;
}
