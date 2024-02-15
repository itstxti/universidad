#include <iostream>
#include "header.h"
#include "metodos.cpp"

using namespace std;

int main()
{
    Caja caja1 = {"IBE3412", "Alcala", "jamon"};
    Caja caja2 = {"RYR2781", "Alcala", "leche"};
    Caja caja3 = {"MSR1032", "Alcala", "medicina"};
    Caja caja4 = {"UAL5389", "Alcala", "herramientas"};
    Caja caja5 = {"AEA2334", "Alcala", "ordenador"};
    Caja auxiliar;

    Cola cola;
    cola.encolar(caja1);

    cout << "Encolando caja " << "con id " << caja1.id << " con contenido " << caja1.contenido << endl;
    cola.encolar(caja2);
    cout << "Encolar: " << caja2.id << endl;

    auxiliar = cola.desencolar();
    cout << "Desencolar: " << auxiliar.id << endl;

    cola.encolar(caja3);
    cout << "Encolar: " << caja3.id << endl;
    cola.encolar(caja4);
    cout << "Encolar: " << caja4.id << endl;

    auxiliar = cola.desencolar();
    cout << "Desencolar: " << auxiliar.id << endl;
    auxiliar = cola.desencolar();
    cout << "Desencolar: " << auxiliar.id << endl;

    cola.encolar(caja5);
    cout << "Encolar: " << caja5.id << endl;

    auxiliar = cola.desencolar();
    cout << "Desencolar: " << auxiliar.id << endl;
    auxiliar = cola.desencolar();
    cout << "Desencolar: " << auxiliar.id << endl;

    return 0;
}
