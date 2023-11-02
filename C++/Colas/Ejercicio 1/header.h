#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED
#include <iostream>
#include <stdlib.h>
#include <ctime>

using namespace std;


struct Caja
{
    string id;
    string centro;
    string contenido;
};

class Nodo
{
    private:
        Caja valor;
        Nodo *siguiente;
        friend class Cola;
    public:
        Nodo(Caja v, Nodo *sig = NULL)
        {
            valor = v;
            siguiente = sig;
        }
};
typedef Nodo *pnodo;

class Cola
{
    public:
        Cola() : frente(NULL), final(NULL) {}
        ~Cola();
        void encolar(Caja v);
        Caja desencolar();
    private:
        pnodo frente, final;
};

#endif // HEADER_H_INCLUDED
