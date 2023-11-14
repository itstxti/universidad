#include "header.h"
#include "metodos.cpp"
#include <iostream>
#include <ctime>
#include <iomanip>

#define nc 8
#define ncam 20
#define nllenado 10

using namespace std;

int main()
{
    Pila furgonetaM, furgonetaD, furgonetaL, furgonetaT, camionL, camionM, camionG, pila;

    Cola centro;
    Caja auxiliar;
    srand(time(NULL));
    int contador = 1;
    char tecla;

    while (contador <= 10)
    {
        cout << "DIA: " << contador << endl;

        int n1 = rand() % 2;
        int n2 = rand() % 2;

        int n3 = rand() % 2;
        int n4 = rand() % 2;

        if (contador > 1)
        {
            if (furgonetaM.tamPila() != 0)
            {
                for (int i = 0; i < nc; i++)
                {
                    auxiliar = furgonetaM.desapilar();
                    centro.encolar(auxiliar);

                }
            }

            if (furgonetaD.tamPila() != 0)
            {
                for (int i = 0; i < nc; i++)
                {
                    auxiliar = furgonetaD.desapilar();
                    centro.encolar(auxiliar);

                }
            }

            if (furgonetaL.tamPila() != 0)
            {
                for (int i = 0; i < nc; i++)
                {
                    auxiliar = furgonetaL.desapilar();
                    centro.encolar(auxiliar);

                }
            }

            if (furgonetaT.tamPila() != 0)
            {
                for (int i = 0; i < nc; i++)
                {
                    auxiliar = furgonetaT.desapilar();
                    centro.encolar(auxiliar);

                }
            }

        }


        if (n1 == 0)
        {
            for (int i = 0; i < nc; i++)
            {
                auxiliar = cajaAleatoria("M");
                furgonetaM.apilar(auxiliar);
            }
        }

        if (n2 == 0)
        {
            for (int i = 0; i < nc; i++)
            {
                auxiliar = cajaAleatoria("D");
                furgonetaD.apilar(auxiliar);
            }
        }

        if (n3 == 0)
        {
            for (int i = 0; i < nc; i++)
            {
                auxiliar = cajaAleatoria("L");
                furgonetaL.apilar(auxiliar);
            }
        }

        if (n4 == 0)
        {
            for (int i = 0; i < nc; i++)
            {
                auxiliar = cajaAleatoria("T");
                furgonetaT.apilar(auxiliar);
            }
        }

        cout << endl;

        cout << "CONTENIDO DE LAS FURGONETAS." << endl;

        imprimirCabeceraFurgoneta("M");
        furgonetaM.mostrarPila();

        imprimirCabeceraFurgoneta("D");
        furgonetaD.mostrarPila();

        imprimirCabeceraFurgoneta("L");
        furgonetaL.mostrarPila();

        imprimirCabeceraFurgoneta("T");
        furgonetaT.mostrarPila();


        cout << endl;
        cout << "CONTENIDO DEL CENTRO DE DISTRIBUCION." << endl;

        imprimirCabeceraCentro();
        centro.mostrarCola();

        cout << endl;
        cout << "CONTENIDO DE LOS CAMIONES." << endl;

        imprimirCabeceraCamion("LIS");
        camionL.mostrarPila();

        imprimirCabeceraCamion("GRE");
        camionG.mostrarPila();

        imprimirCabeceraCamion("MAR");
        camionM.mostrarPila();

        cout << endl;

        if (camionG.tamPila() == ncam)
        {


            cout << "Camion destino a Grecia lleno. Parte al aeropuerto." << endl;
            camionG.~Pila();
        }

        if (camionL.tamPila() == ncam)
        {
            cout << "Camion destino a Lisboa lleno. Parte al aeropuerto." << endl;
            camionL.~Pila();
        }

        if (camionM.tamPila() == ncam)
        {
            cout << "Camion destino a Marruecos lleno. Parte al aeropuerto." << endl;
            camionM.~Pila();
        }

        for (int i = 0; i < nllenado; i++)
        {
            auxiliar = centro.primero();
            if (auxiliar.id.destino == "LIS")
            {
                if (camionL.tamPila() < ncam)
                {
                    auxiliar = centro.desencolar();
                    camionL.apilar(auxiliar);
                }
            }

            if (auxiliar.id.destino == "GRE")
            {
                if (camionG.tamPila() < ncam)
                {
                    auxiliar = centro.desencolar();
                    camionG.apilar(auxiliar);
                }
            }

            if (auxiliar.id.destino == "MAR")
            {
                if (camionM.tamPila() < ncam)
                {
                    auxiliar = centro.desencolar();
                    camionM.apilar(auxiliar);
                }
            }
        }

        tecla = getchar();

        if (tecla == 10) // 10 es el valor de la tecla Enter
        {
            contador++;
        }

    }

    return 0;
}



