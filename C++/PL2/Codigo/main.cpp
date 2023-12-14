#include "header.h"
#include "metodos.cpp"
#include <ctime>
#include <iomanip>
#include <iostream>

#define n1 10
#define n2 30


using namespace std;

int main()
{
    int contador = 0;
    char tecla;

    Caja caja;
    Lista lista;
    centro centro1;
    int opcion;
    srand(time(NULL));

    ArbolABB abb;

    for (int i = 0; i < n1; ++i)
    {
        centro nuevoCentro;
        nuevoCentro = centroAleatorio();
        abb.Insertar(nuevoCentro);
    }

    cout << "Creado el ABB con los siguientes 10 nodos:" << endl;
    cout << endl;
    cout << "Arbol vacio creado: " << endl;
    abb.InOrden(Mostrar);
    cout << endl;
    cout << endl;

    cout << "Creando las siguientes cajas nuevas:" << endl;
    CrearYDistribuirCajas(abb, n2);

    tecla = getchar();

    if (tecla == 10)
    {
        contador++;
    }

    if (contador > 0)
    {

            cout << "Cajas repartidas. Estado del arbol: " << endl;

        do
        {
            abb.InOrden(Mostrar);

            cout << endl;
            cout << "Listado de identificadores de CC creados: ";
            abb.InOrden(MostrarID);
            cout << endl;
            cout << endl;

            cout << "Opciones disponibles." << endl;

            cout << endl;

            cout << "1. Insertar un CC de forma manual" << endl;
            cout << "2. Borrar un CC del árbol." << endl;
            cout << "3. Mostrar los datos de las cajas que se distribuirán desde un CC dado." << endl;
            cout << "4. Buscar una caja concreta por su ID." << endl;
            cout << "5. Extraer una caja concreta." << endl;
            cout << "6. Llevar una caja concreta de un CC a otro." << endl;
            cout << "7. Mostrar una estadística de los CC de la ONG." << endl;
            cout << "8. Continuar con la distribución de cajas."<< endl;
            cout << "9. Ordenar cajas de un CC segun el dia de llegada de las cajas." << endl;

            cout << endl;

            cout << "0. Salir del programa" << endl;

            cout << endl;

            cout << "Seleccione una opcion: ";
            cin.clear();

            cin >> opcion;

            switch (opcion)
            {
                case 1:
                {
                    introducirCC(abb);
                    break;
                }
                case 2:
                {
                    eliminarCC(abb);
                    break;
                }
                case 3:
                {
                    buscarCCPorId(abb);
                    break;
                }
                case 4:
                {
                    buscarCajaPorID(abb);
                    break;
                }
                case 5:
                {
                    borrarCaja(abb);
                    break;
                }
                case 6:
                {
                    moverCaja(abb);
                    break;
                }
                case 7:
                {
                    estadisticas(abb);
                    break;
                }
                case 8:
                {
                    cout << endl;
                    cout << endl;

                    CrearYDistribuirCajas(abb, n2);
                    break;
                }
                case 9:
                {
                    ordenarLista(abb);
                    break;
                }

                default:
                {
                    cout << "Opcion invalida. Seleccione una opcion valida." << endl;
                    break;
                }

            }
            cout << endl;

        }
        while (opcion != 0);

        return 0;
    }


}
