#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

#include <iostream>

using namespace std;
class Lista;

struct centro
{
    int id;
    string localidad;
    Lista* lista;
};

struct Fecha
{
    int mes;
    int anno;
};

struct Caja
{
    string id_caja;
    string contenido;
    string centro_ref;
    Fecha fechaCad;
    int id_centro;
    int dia; //dia de recogida (1-31)
};

const int ASCENDENTE=0;
const int DESCENDENTE=1;

class Nodo
{
private:
    Caja valor;
    Nodo *siguiente;
    Nodo *anterior;
    friend class Lista;

public:
    Nodo(Caja v, Nodo *sig = NULL, Nodo *ant = NULL)
    {
        valor = v;
        siguiente = sig;
        anterior = ant;
    }
};

typedef Nodo *pnodo;

class Lista
{
private:
    pnodo cabeza, final, actual;

public:
    Lista()
    {
        cabeza=actual=final=NULL;
    }
    ~Lista();
    void insertarNodo(Caja v, char c);
    void borrarNodo(char c);
    bool listaVacia();
    void esCabeza();
    void esFinal();
    void esSiguiente();
    void esAnterior();
    bool esActual();
    Caja valorActual();
    void recorrerLista(int);
    int contarCajas();
    Caja BuscarCaja(string id);
    void borrarCajaPorID(string id);
    int contarCajasPais(string pais);
    void ordenarCajasDia();



};


class NodoArbol
{
private:
    centro dato;
    NodoArbol* izquierdo;
    NodoArbol* derecho;
    friend class ArbolABB;

public:
    // Constructor:
    NodoArbol(const centro dat, NodoArbol* izq = NULL, NodoArbol* der = NULL) :
        dato(dat), izquierdo(izq), derecho(der) {}

};

class ArbolABB
{
private:
    NodoArbol* raiz;
    NodoArbol* actual;
    int contador;
    int altura;

public:
    ArbolABB() : raiz(NULL), actual(NULL) {}
    ~ArbolABB();
    void Insertar(const centro dat);
    void Borrar(const centro dat);
    bool Buscar(const centro dat);
    bool Vacio(NodoArbol* r);
    bool EsHoja(NodoArbol* r);
    const int NumeroNodos();
    const int AlturaArbol();
    int Altura(const centro dat);
    void Raiz();
    void InOrden(void (*func)(centro&), NodoArbol* nodo = NULL, bool r = true);
    void PreOrden(void (*func)(centro&), NodoArbol* nodo = NULL, bool r = true);
    void PostOrden(void (*func)(centro&), NodoArbol* nodo = NULL, bool r = true);
    centro obtenerNodoAleatorio();
    void distribuirCajas(Caja caja);
    centro obtenerNodo(int id);
    void BuscarCajaPorID(string id, NodoArbol *nodo);
    NodoArbol* ObtenerRaiz();
    int CajasTotales();
    int CajasTotalPais(string pais);
    centro centroConMasCajasAPais(string pais);
    centro centroConMasCajasEnTotal();
    centro centroConMenosCajasEnTotal();

private:
    void Podar(NodoArbol*&);
    void auxContador(NodoArbol*);
    void auxAltura(NodoArbol*, int);
    void auxCajasTotales(NodoArbol *nodo);
    void auxCajasPais(NodoArbol *nodo, string pais);
    void auxCentroConMasCajasAPais(NodoArbol *nodo, string pais, centro& centroMaximo);
    void auxCentroConMasCajasEnTotal(NodoArbol* nodo, centro& centroMaximo);
    void auxCentroConMenosCajasEnTotal(NodoArbol* nodo, centro& centroMinimo);

};



#endif // HEADER_H_INCLUDED
