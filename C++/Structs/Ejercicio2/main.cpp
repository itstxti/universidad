#include <iostream>
using namespace std;
int main()
{
    int i=1;
    char s[8]; //”ejemplo” consta de 7 letras más \0, luego dimensión 8
    cout << "Lectura de un string con cin" << endl;
    do
    {
        cin >> s;
        cout << i << ": " << s << endl;
        i++;
    }
    while (i<5);
    return 0;
}
