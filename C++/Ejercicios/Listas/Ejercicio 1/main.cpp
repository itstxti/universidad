#include "listas.h"
#include "listas.cpp"
#include <iostream>

using namespace std;

int main() {
    Lista lista;

	lista.insertarNodo(20);
	lista.insertarNodo(10);
	lista.insertarNodo(40);
	lista.insertarNodo(30);
	lista.insertarNodo(50);

    cout << endl << "Lista:" << endl;
	lista.recorrerLista();

	cout << endl << "Elementos:" << endl;
	lista.esCabeza();

	while(lista.esActual()) {
		cout << lista.valorActual() << endl;
		lista.esSiguiente();
		}

	lista.esCabeza();
	cout << endl << "Primero: " << lista.valorActual() << endl;

	lista.esFinal();
	cout << "Ultimo: " << lista.valorActual() << endl;

	cout << endl << "Borrar 10:" << endl;
	lista.borrarNodo(10);
	lista.recorrerLista();

	cout << endl << "Borrar 15 (no esta en la lista):" << endl;
	lista.borrarNodo(15);
	lista.recorrerLista();

	cout << endl << "Borrar 20:" << endl;
	lista.borrarNodo(20);
	lista.recorrerLista();

	cout << endl << "Borrar 50:" << endl;
	lista.borrarNodo(50);
	lista.recorrerLista();

	return 0;
}
