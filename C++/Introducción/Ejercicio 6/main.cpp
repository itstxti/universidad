#include <iostream>
#include <stdlib.h>
#include <ctime>

using namespace std;

int calcularPosicionAleatoria() {
    return rand() % 7;
}

int main() {
    srand(time(NULL));

    /*string aerolineas[] = {"IBE3412", "ACA4832", "RYR2781", "MSR1032", "UAL5389", "AEA2334", "KLM976"};

    for (int i = 1; i < 10; i++) {
        int posicion = calcularPosicionAleatoria();

        cout << "Codigo de vuelo aleatorio " << i << ": " << aerolineas[posicion] << endl;
    }*/

    string numeros[] = {"3412", "4832", "2781", "1032", "5389", "2334", "976"};
    string letras[] = {"IBE", "ACA", "RYR", "MSR", "UAL", "AEA", "KLM"};

    for (int i = 1; i < 10; i++) {
        int posicionN = calcularPosicionAleatoria();
        int posicionL = calcularPosicionAleatoria();

        cout << "Codigo de vuelo aleatorio " << i << ": " << letras[posicionL] << numeros[posicionN] << endl;

    }

    /*string letras[] = {"IBE", "ACA", "RYR", "MSR", "UAL", "AEA", "KLM"};

    for (int i = 1; i < 10; i++) {
        int posicion = calcularPosicionAleatoria();
        int numero = rand() % 9999;

        cout << "Codigo de vuelo aleatorio " << i << ": " << letras[posicion] << numero << endl;
    }*/


    return 0;
}
