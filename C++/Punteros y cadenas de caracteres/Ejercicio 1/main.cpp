/*Programa que permite acceder al contenido de una variable y conocer la direcci�n en la que se almacena dicho contenido.
Adem�s se muestra la diferencia entre copiar un valor en otra variable y en crear un alias.*/

#include <iostream>

using namespace std;

int main()
{
    int n = 75;
    int m = n;
    int& r=n; //con la declaraci�n int& se indica que r es un alias de n

    cout << "n = " << n << ", m = " << m << ", r = " << r << endl << endl;
    cout << "&n = " << &n <<", " << "&m = " << &m << endl << endl;
    cout << "&n = " << &n <<", " << "&r = " << &r << endl << endl;

    return 0;
}
