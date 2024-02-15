#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

/*Programa que utiliza una estructura para almacenar datos relativos a
un estudiante. Muestra formas válidas y erróneas de inicializar e
insertar datos en una estructura. */

struct Estudiante
{
    char nombre[30];
    int numEstudiante;
    float nota;
    string otrosDatos;
};

int main()
{
    Estudiante nadie = {" ",0,0," "};
    Estudiante manolo = {"Manuel Perez",2345,9.57,"Alumno inventado"};
    Estudiante pepe;
    Estudiante *alumno;
    alumno=&nadie;

    cout << "Introduzca el nombre del estudiante: " << endl;
    gets(alumno->nombre);
    cout << "Introduzca el numero de estudiante: " << endl;
    cin >> alumno->numEstudiante;
    cout << "Introduzca la calificacion: " << endl;
    cin >> alumno->nota;
    cout << "Introduzca otros datos de interes: " << endl;

    fflush(stdin);
    getline(cin,alumno->otrosDatos);

    cout << endl;
    cout << alumno->nombre << " " << alumno->numEstudiante << " "
         << alumno->nota << " " << alumno->otrosDatos << endl;
    cout << manolo.nombre << " " << manolo.numEstudiante << " "
         << manolo.nota << " " << manolo.otrosDatos << endl;

    pepe=manolo;

    cout << pepe.nombre << " " << pepe.numEstudiante << " " << pepe.nota
         << " " << pepe.otrosDatos << endl;

    // Las siguientes asignaciones dan error en el caso de usar una
    // cadena de caracteres para el nombre

    //pepe={"Jose Torralba Gomez",3254,7.7}; // Da error
    //pepe.nombre="Jose Gomez "; //Da error

    // La forma correcta es ésta:

    strcpy(pepe.nombre,"Jose Gomez");
    pepe.numEstudiante=3254;
    pepe.nota=10.0;
    cout << pepe.nombre << " " << pepe.numEstudiante << " "
    << pepe.nota << " ";

    /*Pero al usar tipos string, las operaciones con cadenas de
    caracteres son más sencillas*/

    pepe.otrosDatos="Es un alumno excelente";
    cout << pepe.otrosDatos << endl;

    return 0;
}
