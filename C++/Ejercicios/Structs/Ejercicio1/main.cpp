#include <iostream>
using namespace std;
int main()
{
    char c;
    cout << "Elige el numero en el menu:\n\n";
    cout << "1 - Cargar fichero\n";
    cout << "2 - Guardar en un fichero\n";
    cout << "3 - Otras operaciones\n";
    cout << "4 - Mostrar datos\n";
    cout << "0 - Salir\n\n";
    cout << "Opcion: ";
    c=getchar(); //getchar devuelve un int pero en la asignación a la
//variable c se aplica una conversión de tipo a char.
    cout << "\nHas elegido: " << c << endl;
    return 0;
}
