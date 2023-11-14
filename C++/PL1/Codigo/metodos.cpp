#include "header.h"
#include <iostream>
#include <stdlib.h>
#include <ctime>
#include <iomanip>

Pila::~Pila()                           //Destructor de la Pila
{
    while(cima) desapilar();
}

void Pila::apilar(Caja v)
{
    pNodo nuevo;

    nuevo = new Nodo(v, cima);

    cima = nuevo;
}


Caja Pila::desapilar()
{
    pNodo nodo;
    Caja v;
    Fecha fecha = {0,0};
    ID id = {"","",""};
    Caja vacio = {id,"", "", fecha};

    if(!cima) return vacio;

    nodo = cima;

    cima= nodo->siguiente;

    v = nodo->valor;

    delete nodo;
    return v;
}

void Pila::mostrarPila()
{
    pNodo actual = cima;

    if (!actual)
    {
        return;
    }

    while (actual)
    {

        cout << "| " << setw(6) << actual->valor.id.destino
        << actual->valor.id.num << actual->valor.id.origen
        << setw(4) << " | " << setw(12) << actual->valor.centro_ref
        << setw(4) << " | " << setw(12) << actual->valor.contenido
        << setw(2) << " | " << setw(11) << actual->valor.fechaCad.mes
        << setw(2) << "/" << setw(4) << actual->valor.fechaCad.anno
        << " |" << endl;

        actual = actual->siguiente;
    }
}

int Pila::tamPila()
{
    pNodo actual = cima;
    int i = 0;
    if (!actual)
    {
        return 0;
    }
    while(actual)
    {
        i++;
        actual = actual->siguiente;
    }
    return i;
}

//Destructor
Cola::~Cola()
{
    while(frente) desencolar();
}

//Añadir elemento en la cola
void Cola::encolar(Caja v)
{
    pNodo nuevo;
    nuevo = new Nodo(v);

    if(final) final->siguiente = nuevo;

    final= nuevo;

    if(!frente) frente = nuevo;
}

//Leer elemento de la cola
Caja Cola::desencolar()
{
    pNodo nodo;
    Caja v;
    Fecha fecha = {0,0};
    ID id = {"","",""};
    Caja vacio = {id,"", "", fecha};

    nodo = frente;

    if(!nodo) return vacio;

    frente = nodo->siguiente;

    v = nodo->valor;
    delete nodo;


    if(!frente) final = NULL;
    return v;
}

Caja Cola::primero()
{
    Fecha fecha = {0,0};
    ID id = {"","",""};
    Caja vacio = {id,"","",fecha};

    if (frente)
    {
        return frente->valor;
    }
    else
    {
        return vacio;
    }
}

void Cola::mostrarCola()
{
    pNodo actual = frente;

    if (!actual)
    {
        return;
    }

    while (actual)
    {

        cout << "| " << setw(6) << actual->valor.id.destino <<
        actual->valor.id.num << actual->valor.id.origen << setw(4)
        << " | " << setw(12) << actual->valor.centro_ref << setw(4)
        << " | " << setw(12) << actual->valor.contenido << setw(2)
        << " | " << setw(11) << actual->valor.fechaCad.mes << setw(2)
        << "/" << setw(4) << actual->valor.fechaCad.anno << " |" << endl;

        // Avanza al siguiente nodo
        actual = actual->siguiente;
    }
}


int calcularPosicionAleatoria(int n)
{
    return rand() % n;
}

Fecha fechaAleatoria()
{
    Fecha fecha;
    fecha.mes = calcularPosicionAleatoria(12) + 1;
    fecha.anno = calcularPosicionAleatoria(20) + 2023;

    return fecha;
}

ID idAleatorio(string origen)
{
    string numeros = "";

    for (int i = 0; i < 4; i++)
    {
        numeros = numeros + to_string(rand() % 10);
    }

    string destinos[] = {"MAR", "LIS", "GRE"};
    string destino = destinos[rand() % 3];


    ID id = {destino, numeros, origen};
    return id;
}

string contenidoAleatorio()
{
    string contenidosPosibles[] = {"harina", "pasta","legumbres", "leche", "medicinas", "higiene", "agua",
                                   "aceite", "sal", "azucar", "galletas",
                                   "latas_cons", "iluminacion", "herramientas",
                                   "combustible", "tiendas_camp", "ropa", "mantas", "limpieza"
                                  };

    string contenido = contenidosPosibles[calcularPosicionAleatoria(19)];

    return contenido;

}

Caja cajaAleatoria(string origen)
{
    ID id = idAleatorio(origen);
    string contenido = contenidoAleatorio();
    string centro = "Alcala";
    Fecha fechaCad;

    if (contenido == "iluminación" or contenido == "herramientas" or
            contenido == "tiendas_camp" or contenido == "ropa" or contenido == "limpieza" or contenido == "mantas")
    {
        fechaCad = {12,2100};
    }
    else
    {
        fechaCad = fechaAleatoria();
    }

    Caja caja;
    caja.contenido = contenido;
    caja.fechaCad = fechaCad;
    caja.id = id;
    caja.centro_ref = centro;

    return caja;
}

void imprimirCabeceraFurgoneta(string origen)
{
    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;
    cout << "|" << setw(40) << "FURGONETA DE " << origen << setw(25) << "|" << endl;
    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;

    cout << "|" << setw(7) << "ID" << setw(8) << "|" << setw(12) << "CENTRO REF." << setw(4) << "|" << setw(11) << "CONTENIDO" << setw(4) << "|" << setw(18) << "FECHA DE CONSUMO" << setw(2)
         << "|" << endl;
    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;

}

void imprimirCabeceraCentro()
{

    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;
    cout << "|" << setw(46) << " CENTRO DE DISTRIBUCION " << setw(20) << "|" << endl;
    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;
    cout << "|" << setw(7) << "ID" << setw(8) << "|" << setw(12) << "CENTRO REF." << setw(4) << "|" << setw(11) << "CONTENIDO" << setw(4) << "|" << setw(18) << "FECHA DE CONSUMO" << setw(2)
         << "|" << endl;
    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;

}

void imprimirCabeceraCamion(string destino)
{


    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;
    cout << "|" << setw(38) << " CAMION " << setw(1) << destino << setw(25) << "|" << endl;
    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;

    cout << "|" << setw(7) << "ID" << setw(8) << "|" << setw(12) << "CENTRO REF." << setw(4) << "|" << setw(11) << "CONTENIDO" << setw(4) << "|" << setw(18) << "FECHA DE CONSUMO" << setw(2)
         << "|" << endl;
    cout << "|" << "-----------------------------------------------------------------" << "|" << endl;

}

