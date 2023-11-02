#include "header.h"
#include "metodos.cpp"


using namespace std;

int main()
{
    Alumno estudiante1 = {19, "Sofia"};
    Alumno estudiante2 = {11, "Pedro"};
    Alumno estudiante3 = {54, "Maria"};
    Alumno estudiante4 = {23, "Juan"};
    Alumno estudiante5 = {9, "Laura"};
    Alumno auxiliar;



    Pila pila;
    pila.apilar(estudiante1);
    cout << "Apilando: " << estudiante1.nombre << " " << estudiante1.edad << endl;

    pila.apilar(estudiante2);
    cout << "Apilando: " << estudiante2.nombre << " " << estudiante2.edad << endl;

    cout << "" << endl;

    auxiliar = pila.desapilar();
    cout << "Desapilando: " << auxiliar.nombre << " " <<auxiliar.edad << endl;

    cout << "" << endl;

    pila.apilar(estudiante3);
    cout << "Apilando: " << estudiante3.nombre << " " << estudiante3.edad << endl;

    pila.apilar(estudiante4);
    cout << "Apilando: " << estudiante4.nombre << " " << estudiante4.edad << endl;

    cout << "" << endl;


    auxiliar = pila.desapilar();
    cout << "Desapilando: " << auxiliar.nombre << " " <<auxiliar.edad << endl;

    auxiliar = pila.desapilar();
    cout << "Desapilando: " << auxiliar.nombre << " " <<auxiliar.edad << endl;

    cout << "" << endl;


    pila.apilar(estudiante5);
    cout << "Apilando: " << estudiante5.nombre << " " << estudiante5.edad << endl;

    cout << "" << endl;


    auxiliar = pila.desapilar();
    cout << "Desapilando: " << auxiliar.nombre << " " <<auxiliar.edad << endl;

    auxiliar = pila.desapilar();
    cout << "Desapilando: " << auxiliar.nombre << " " <<auxiliar.edad << endl;

    return 0;
}
