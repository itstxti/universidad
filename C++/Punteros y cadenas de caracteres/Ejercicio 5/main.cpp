/*Programa que utiliza punteros a cadenas de caracteres y operadores incrementales.*/

#include <iostream>
#include <string.h>

using namespace std;

int main()
{
    unsigned int i=0;
    char cadena1[] = "Esto es una cadena de caracteres";
    char cadena2[42] = "Esto es un puntero a cadena de caracteres";
    char* ptr;

    ptr = &cadena2[0];

    cout << "cadena1[0]= " << cadena1[0] << endl;
    cout << "*ptr= " << *ptr << endl;

    cout << "1: " << endl;
    for(i=0;i<strlen(cadena1);i++)
    {
        cout << cadena1[i];
    }

    cout << endl << "2: " << endl;
    for(i=0;i<42;i++)
    {
        cout << *(ptr+i);
    }

    cout << endl << "3: " << endl;
    while (*ptr) cout << *ptr++;

    cout << endl;
    return 0;
}
