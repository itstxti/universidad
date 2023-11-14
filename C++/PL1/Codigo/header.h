#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED
#include <iostream>

using namespace std;

struct ID
{
    string destino;
    string num;
    string origen;
};

struct Fecha
{
    int mes;
    int anno;
};

struct Caja
{
    ID id;
    string contenido;
    string centro_ref;
    Fecha fechaCad;
};

class Nodo
{
    private:
        Caja valor;
        Nodo *siguiente;
        friend class Pila;
        friend class Cola;
    public:
        Nodo(Caja v, Nodo *sig = NULL)
        {
            valor = v;
            siguiente = sig;
        }
};

typedef Nodo *pNodo;

class Cola
{
    public:
        Cola() : frente(NULL), final(NULL) {}
        ~Cola();
        void encolar(Caja v);
        Caja desencolar();
        void mostrarCola();
        Caja primero();
    private:
        pNodo frente, final;
};

class Pila
{
    private:
        pNodo cima;
    public:
        Pila() : cima(NULL) {}          //Constructor de la Pila
        ~Pila();
        void apilar(Caja v);
        Caja desapilar();
        void mostrarPila();
        int tamPila();
};




#endif // HEADER_H_INCLUDED
