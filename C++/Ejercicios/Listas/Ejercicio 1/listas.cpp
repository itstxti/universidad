#include "listas.h"

using namespace std;

Lista::~Lista()
{
    pnodo aux;
    while(cabeza)
    {
        aux = cabeza;
        cabeza = cabeza->siguiente;
        delete aux;
    }
    actual = NULL;
}

void Lista::insertarNodo(int v) {
    pnodo aux;

    if (listaVacia())
    {
        cabeza = new Nodo(v, NULL);
        final=cabeza;
    }
    else
    {
        aux= new Nodo(v,NULL);
        final->siguiente=aux;
        final=aux;
    }
}

void Lista::borrarNodo(int v) {
    pnodo anterior;

    actual = cabeza;

    while (actual->valor!=v && (actual->siguiente)!=NULL)
    {
        anterior=actual;
        actual=actual->siguiente;
    }

    if (actual->valor == v){ //comprobación de que está v en la lista
        if(actual==cabeza)
            cabeza = actual->siguiente;
        else
        {
            anterior->siguiente = actual->siguiente;
            if (actual==final)
            {
                final=anterior;
            }
        }
        actual->siguiente=NULL;
        delete actual;
    }
}


bool Lista::listaVacia(){
    return cabeza == NULL;
}

void Lista::esCabeza()
{
    actual = cabeza;
}

void Lista::esFinal()
{
    esCabeza();
    if(!listaVacia())
        while(actual->siguiente)
            esSiguiente();
}

void Lista::esSiguiente()
{
    if(actual) actual = actual->siguiente;
}

bool Lista::esActual()
{
    return actual != NULL;
}

int Lista::valorActual()
{
    return actual->valor;
}


void Lista::recorrerLista()
{
    pnodo aux;
    aux = cabeza;

    while(aux)
    {
        cout << aux->valor << "-> ";
        aux = aux->siguiente;
    }
    cout << endl;
}





