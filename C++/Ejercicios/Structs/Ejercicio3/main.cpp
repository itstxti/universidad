#include <iostream>
using namespace std;
int main()
{
    //char Nombre[21];
    string Nombre;

    cout << "Escriba su nombre completo: ";

    //cin.getline(Nombre,21);
    getline(cin, Nombre);

    cout << endl << "Su nombre completo es: " << Nombre;
    return 0;
}
