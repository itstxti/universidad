/*Programa que utiliza punteros a entero y a car�cter.
Muestra los contenidos de las variables de dichos tipos as� como
el contenido de los punteros a las variables y las direcciones en que se almacenan �stos.*/

#include <iostream>

using namespace std;

int main()
{
    int n=75;
    int* p = &n;  //p es un puntero de tipo entero que contiene la direcci�n de n
    char c='A';
    char* pc=&c;

    cout << "n = " << n << ", &n = " << &n << endl << endl;
    cout << "p = " << p << ", &p = " << &p << endl << endl;
    cout << "c = " << c << ", &c = " << &c << endl << endl; //necesaria conversi�n expl�cita de tipos (int*) &c
    cout << "pc = " << pc << ", &pc = " << &pc << endl << endl;

    return 0;
}
