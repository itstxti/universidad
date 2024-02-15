#ifndef LISTAS_H_INCLUDED
#define LISTAS_H_INCLUDED

#include <iostream>

class Nodo
{
private:
    int valor;
    Nodo *siguiente;
    friend class Lista;

public:
    Nodo(int v, Nodo *sig = NULL)
    {
        valor = v;
        siguiente = sig;
    }
};
typedef Nodo *pnodo;

class Lista
{
private:
    pnodo cabeza, actual, final;

public:
    Lista()
    {
        cabeza = actual = final= NULL;
    }
    ~Lista();

    void insertarNodo(int v);
    void borrarNodo(int v);
    bool listaVacia();
    void esCabeza();
    void esFinal();
    void esSiguiente();
    bool esActual();
    int valorActual();
    void recorrerLista();

};

#endif // LISTAS_H_INCLUDED
