/*Programa que utiliza punteros a cadenas de caracteres.*/

#include <iostream>

using namespace std;


int main()
{
    char alfabeto[27]="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char *p;

    p=&alfabeto[0];
    cout << *p << *(p+1) << *(p+2) << endl;

    for(int i=0;i <= 26; i++)
       cout << *(p+i);
    cout << endl;

    p=&alfabeto[15];
    cout << *p << endl;

    p=alfabeto;
    cout << *(p+9) << endl;

    return 0;
}
