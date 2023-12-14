#ifndef ARBOLES_H
#define ARBOLES_H

#include <iostream>


class Nodo
{
    private:
        // Miembros:
        int dato;
        Nodo *izquierdo;
        Nodo *derecho;
        friend class ArbolABB;

    public:
        // Constructor:
        Nodo(const int dat, Nodo *izq=NULL, Nodo *der=NULL) :
            dato(dat), izquierdo(izq), derecho(der) {}

};

class ArbolABB
{
    private:
        // Punteros de la lista, para cabeza y nodo actual:
        Nodo *raiz;
        Nodo *actual;
        int contador;
        int altura;

    public:
        // Constructor y destructor b�sicos:
        ArbolABB() : raiz(NULL), actual(NULL) {}
        ~ArbolABB();
         // Insertar en �rbol ordenado:
        void Insertar(const int dat);
        // Borrar un elemento del �rbol:
        void Borrar(const int dat);
        // Funci�n de b�squeda:
        bool Buscar(const int dat);
        // Comprobar si el �rbol est� vac�o:
        bool Vacio(Nodo *r);
        // Comprobar si es un nodo hoja:
        bool EsHoja(Nodo *r);
        // Contar n�mero de nodos:
        const int NumeroNodos();
        const int AlturaArbol();
        // Calcular altura de un int:
        int Altura(const int dat);
        // Moverse al nodo raiz:
        void Raiz();
        // Aplicar una funci�n a cada elemento del �rbol:
        void InOrden(void (*func)(int&), Nodo *nodo=NULL, bool r=true);
        void PreOrden(void (*func)(int&), Nodo *nodo=NULL, bool r=true);
        void PostOrden(void (*func)(int&), Nodo *nodo=NULL, bool r=true);

    private:
        // Funciones auxiliares
        void Podar(Nodo* &);
        void auxContador(Nodo*);
        void auxAltura(Nodo*, int);
};

#endif

