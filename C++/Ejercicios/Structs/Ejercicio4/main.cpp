#include <iostream>

using namespace std;

struct direccion
{
    int codigoPostal;
    string calle;
};

struct estudiante
{
    int edad;
    string nombre;
    direccion direccion;
};

int main()
{
    estudiante alumno;

    /*estudiante tati = {19, "tatiana"};
    cout << "paul mescal is awesome!" << endl;
    cout << "-----------" << endl;
    cout << "nombre: " << tati.nombre << endl;
    cout << "edad: " << tati.edad << endl;*/

    cout << "Introduzca el nombre del estudiante: " << endl;
    cin >> alumno.nombre;
    cout << "Introduzca la edad del estudiante: " << endl;
    cin >> alumno.edad;
    cout << "Introduce la calle de la direccion del estudiante: " << endl;
    cin >> alumno.direccion.calle;
    cout << "Introduce el codigo postal de la direccion del estudiante: " << endl;
    cin >> alumno.direccion.codigoPostal;
    cout << endl;
    cout << "-----------" << endl;
    cout << endl;
    cout << "nombre: " << alumno.nombre << endl;
    cout << "edad: " << alumno.edad << endl;
    cout << "calle: " << alumno.direccion.calle << endl;
    cout << "codigo postal: " << alumno.direccion.codigoPostal << endl;


    return 0;
}
