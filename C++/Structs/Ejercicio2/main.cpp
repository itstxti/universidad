#include <iostream>
using namespace std;
int main()
{
    int i=1;
    char s[8]; //�ejemplo� consta de 7 letras m�s \0, luego dimensi�n 8
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
