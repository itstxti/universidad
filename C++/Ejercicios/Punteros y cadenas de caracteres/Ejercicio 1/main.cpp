/*Programa que permite acceder al contenido de una variable y conocer la dirección en la que se almacena dicho contenido.
Además se muestra la diferencia entre copiar un valor en otra variable y en crear un alias.*/

#include <iostream>

using namespace std;

int main()
{
    int n = 75;
    int m = n;
    int& r=n; //con la declaración int& se indica que r es un alias de n

    cout << "n = " << n << ", m = " << m << ", r = " << r << endl << endl;
    cout << "&n = " << &n <<", " << "&m = " << &m << endl << endl;
    cout << "&n = " << &n <<", " << "&r = " << &r << endl << endl;

    return 0;
}
