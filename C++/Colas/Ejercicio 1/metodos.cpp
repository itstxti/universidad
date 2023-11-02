#include "header.h"

//Destructor
Cola::~Cola()
{
    while(frente) desencolar();
}

//Añadir elemento en la cola
void Cola::encolar(Caja v)
{
    pnodo nuevo;
    nuevo = new Nodo(v); // Se crea un nodo nuevo

    // Si cola no vacía, se añade el nuevo a continuación de ultimo
    if(final) final->siguiente = nuevo;

    //El último elemento de la cola es el nuevo nodo
    final= nuevo;

    // Si frente es NULL, la cola está vacía y el nuevo nodo pasa a ser el primero
    if(!frente) frente = nuevo;
}

//Leer elemento de la cola
Caja Cola::desencolar()
{
    pnodo nodo; //Var aux para manipular nodo
    Caja v; //Var aux para retorno del valor
    // Nodo apunta al primer elemento de la pila
    nodo = frente;

    //if(!nodo) return 0; // Si no hay nodos en la pila se devuelve 0
    //Se asigna a frente la dirección del segundo nodo
    frente = nodo->siguiente;
    //Se guarda el valor de retorno
    v = nodo->valor;
    delete nodo; // Se borra el nodo

    // Si cola vacía, ultimo debe ser NULL también
    if(!frente) final = NULL;
    return v;
}
