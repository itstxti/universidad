#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    int resultado;
    resultado = 6+18+124;

    cout << "Texto sin formato" << endl;
    cout << 6 << endl
         << 18 << endl
         << 124 << endl
         << "---" << endl
         << resultado << endl << endl;

    cout << setw(20) << "Texto con formato" << endl;
    cout << setw(20) << 6 << endl
         << setw(20) << 18 << endl
         << setw(20) << 124 << endl
         << setw(20) << "---" << endl
         << setw(20) << resultado << endl;

    return 0;
}
