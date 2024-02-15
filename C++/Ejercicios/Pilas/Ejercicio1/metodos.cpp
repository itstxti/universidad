#include "header.h"

Pila::~Pila()                           //Destructor de la Pila
{
    while(cima) desapilar();
}

void Pila::apilar(Alumno v)                //Meter elemento en la Pila
{
    pNodo nuevo;                        //Var aux para manipular el nuevo nodo

    nuevo = new Nodo(v, cima);          //Se crea un nodo nuevo

    cima = nuevo;                       //El comienzo de la pila es el nuevo nodo
}


Alumno Pila::desapilar()                   //Sacar elemento de la Pila
{
    pNodo nodo;                         //Var aux para manipular el nodo
    Alumno v;
    Alumno vacio = {0,""};                              //Var aux para el retorno del valor del nodo

    if(!cima) return vacio;                 // Si no hay nodos en la pila se devuelve 0

    nodo = cima;                        // Nodo apunta al primer elemento de la pila

    cima= nodo->siguiente;              // Se asigna a pila toda la pila menos el primer elemento

    v = nodo->valor;                    //Se guarda el retorno del valor del nodo

    delete nodo;                        //Se borra el nodo
    return v;
}
