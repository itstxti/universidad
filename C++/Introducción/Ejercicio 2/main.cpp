#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
    int celsius;
    float fahrenheit;

    cout << setw(10) << "grados" << setw(15) << "grados" << endl;
    cout << setw(10) << "celsius" << setw(15) << "fahrenheit" << endl;
    cout << setw(10) << "-------" << setw(15) << "-------" << endl;


    for (int i = 1; i < 11; i++)
    {
            celsius = i*5;
            fahrenheit = (9.0/5.0)*celsius+32.0;

            cout << setw(10) << celsius << setw(15) << fahrenheit << endl;

    }

    return 0;
}
