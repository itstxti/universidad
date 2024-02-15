#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED
#include <iostream>

using namespace std;

struct Alumno
{
    int edad;
    string nombre;
};

class Nodo
{
    private:
        Alumno valor;
        Nodo *siguiente;
        friend class Pila;
    public:
        Nodo(Alumno v, Nodo *sig = NULL)
        {
            valor = v;
            siguiente = sig;
        }
};

typedef Nodo *pNodo;

class Pila
{
    private:
        pNodo cima;
    public:
        Pila() : cima(NULL) {}          //Constructor de la Pila
        ~Pila();
    void apilar(Alumno v);
    Alumno desapilar();
    void mostrarCima();

};

#endif // HEADER_H_INCLUDED
