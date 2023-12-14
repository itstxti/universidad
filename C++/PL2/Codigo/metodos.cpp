#include "header.h"
#include <iostream>
#include <stdlib.h>
#include <ctime>
#include <iomanip>
#include <fstream>

using namespace std;

Lista::~Lista()
{
    pnodo aux;
    esCabeza();
    while(cabeza)
    {
        aux = cabeza;
        cabeza = cabeza->siguiente;
        delete aux;
    }
    cabeza=NULL;
    actual=NULL;
    final=NULL;
}

void Lista::insertarNodo(Caja v, char c)
{
    pnodo aux;
    char tipoInsercion;
    tipoInsercion=c;

    if(listaVacia())   // Si la lista está vacía
    {
        aux = new Nodo(v,NULL,NULL);
        final=cabeza=aux;
    }
    else if (tipoInsercion=='f')  //Inserción por el final
    {
        aux= new Nodo(v,NULL,NULL);
        aux->anterior=final;
        final->siguiente=aux;
        final=aux;
    }
    else if (tipoInsercion=='p')  //Inserción por el principio
    {
        aux= new Nodo(v,NULL,NULL);
        aux->siguiente=cabeza;
        cabeza->anterior=aux;
        cabeza=aux;
    }
}

void Lista::borrarNodo(char c)
{
    char tipoBorrado;
    tipoBorrado=c;

    if(tipoBorrado=='f')  //Eliminación por el final
    {
        pnodo aux=NULL;
        if((cabeza==final))   //Sólo hay 1 elemento
        {
            aux=final;
            cabeza = final = NULL;
            aux=NULL;
            delete aux;
        }
        else
        {
            aux=final;
            final=final->anterior;
            aux->anterior=NULL;
            final->siguiente=NULL;
            delete aux;
        }
    }
    else if(tipoBorrado=='p')  //Eliminación por el Principio
    {
        pnodo aux=NULL;
        if((cabeza==final))  //Sólo hay 1 elemento
        {
            aux=cabeza;
            cabeza = final = NULL;
            aux=NULL;
            delete aux;
        }
        else
        {
            aux=cabeza;
            cabeza=cabeza->siguiente;
            aux->siguiente=NULL;
            cabeza->anterior=NULL;
            delete aux;
        }
    }
}

void Lista::recorrerLista(int modo)
{
    pnodo actual;
    if (modo == 0)
    {
        actual = cabeza;
    }
    else
    {
        actual = final;
    }
    cout <<  "-------------------------------------------------------------------------------------" << endl;
    cout << "|" << setw(10) << "ID CAJA" << setw(4) << "|" << setw(12) << "CENTRO REF." << setw(4) << "|" << setw(12) << "ID CENTRO." << setw(2) << "|" << setw(11) << "CONTENIDO"
         << setw(4) << "|" << setw(18) << "FECHA DE CONSUMO" << setw(2) << "|" << setw(4) << "DIA"
         << "|" << endl;
    cout <<  "-------------------------------------------------------------------------------------" << endl;

    while (actual != NULL)
    {
        // Imprime la información de la caja
        cout << "| " << setw(10) << actual->valor.id_caja << setw(4)
             << " | " << setw(12) << actual->valor.centro_ref << setw(4)
             << " | " << setw(11) << actual->valor.id_centro << setw(2)
             << " | " << setw(12) << actual->valor.contenido << setw(2)
             << " | " << setw(11) << actual->valor.fechaCad.mes << setw(2)
             << "/" << setw(4) << actual->valor.fechaCad.anno << " |"
             << setw(3) << actual->valor.dia << setw(2) << " |" << endl;

        if (modo == 0)
        {
            actual = actual->siguiente;
        }
        else
        {
            actual = actual->anterior;
        }
    }
    cout << endl;
}

bool Lista::listaVacia()
{
    return cabeza == NULL;
}

void Lista::esSiguiente()
{
    if(actual) actual = actual->siguiente;
}

void Lista::esAnterior()
{
    if(actual) actual = actual->anterior;
}

void Lista::esCabeza()
{
    actual=cabeza;
}

void Lista::esFinal()
{
    actual=final;
}

bool Lista::esActual()
{
    return actual != NULL;
}

Caja Lista::valorActual()
{
    Fecha fecha = {0,0};
    Caja vacio = {"","", "", fecha, 0, 0};
    if (!listaVacia()) return actual->valor;
    else return vacio;
}

int Lista::contarCajas()
{
    int contador = 0;
    pnodo temp = cabeza;

    while (temp != NULL)
    {
        contador++;
        temp = temp->siguiente;
    }

    return contador;
}

int Lista::contarCajasPais(string pais)
{
    int contador = 0;
    pnodo temp = cabeza;

    while (temp != NULL)
    {
        if (temp->valor.id_caja.substr(0, 3) == pais)
        {
            contador++;
        }
        temp = temp->siguiente;

    }
    return contador;
}

void Lista::borrarCajaPorID(string id)
{
    pnodo temp = cabeza;
    pnodo anterior = NULL;

    while (temp != NULL)
    {
        if (temp->valor.id_caja == id)
        {
            if (temp == cabeza)
            {
                cabeza = temp->siguiente;
                if (cabeza != NULL)
                {
                    cabeza->anterior = NULL;
                }
                delete temp;
            }
            else
            {
                anterior->siguiente = temp->siguiente;
                if (temp->siguiente != NULL)
                {
                    temp->siguiente->anterior = anterior;
                }
                else
                {
                    final = anterior;
                }
                delete temp;
            }

            return;
        }

        // Avanzar al siguiente nodo
        anterior = temp;
        temp = temp->siguiente;
    }


}

int calcularPosicionAleatoria(int n)
{
    return rand() % n;
}

Fecha fechaAleatoria()
{
    Fecha fecha;
    fecha.mes = calcularPosicionAleatoria(12) + 1;
    fecha.anno = calcularPosicionAleatoria(20) + 2023;

    return fecha;
}

string idAleatorio()
{
    string numeros = "";

    for (int i = 0; i < 4; i++)
    {
        numeros = numeros + to_string(rand() % 10);
    }

    string origenes[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                         "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
                        };
    string origen = origenes[rand()%26];

    string destinos[] = {"MAR", "LIS", "GRE"};
    string destino = destinos[rand() % 3];


    string id = destino + numeros+ origen;
    return id;
}

string contenidoAleatorio()
{
    string contenidosPosibles[] = {"harina", "pasta","legumbres", "leche", "medicinas", "higiene", "agua",
                                   "aceite", "sal", "azucar", "galletas",
                                   "latas_cons", "iluminacion", "herramientas",
                                   "combustible", "tiendas_camp", "ropa", "mantas", "limpieza"
                                  };

    string contenido = contenidosPosibles[calcularPosicionAleatoria(19)];

    return contenido;

}

centro centroAleatorio()
{
    int id = rand() % 899 + 100;
    string centros[] = {"Mostoles", "Alcala", "Leganes", "Fuenlabrada", "Getafe", "Alcorcon", "Torrejon",
                        "Parla", "Alcobendas", "Coslada", "Pozuelo", "Rivas", "Valdemoro", "Majadahonda",
                        "Aranjuez", "Arganda", "Boadilla", "Pinto", "Colmenar", "Tres Cantos"
                       };
    string localidad = centros[rand()%20];

    Lista *lista = new Lista();
    centro nuevoCentro;
    nuevoCentro.id = id;
    nuevoCentro.localidad = localidad;
    nuevoCentro.lista = lista;
    return nuevoCentro;
}


//Destructor
ArbolABB::~ArbolABB()
{
    Podar(raiz);
}

//Árbol vacío
bool ArbolABB::Vacio(NodoArbol *r)
{
    return r == NULL;
}

//Nodo es de tipo hoja
bool ArbolABB::EsHoja(NodoArbol *r)
{
    return !r->derecho && !r->izquierdo;
}

//Coloca el nodo actual en raíz
void ArbolABB::Raiz()
{
    actual = raiz;
}

// Poda: borrar todos los nodos a partir de uno incluido
void ArbolABB::Podar(NodoArbol *&nodo)
{
    // Algoritmo recursivo, recorrido en postorden
    if (nodo)
    {
        Podar(nodo->izquierdo); // Podar izquierdo
        Podar(nodo->derecho);   // Podar derecho
        delete nodo;            // Eliminar nodo
        nodo = NULL;
    }
}

// Insertar un int en el árbol ABB
void ArbolABB::Insertar(const centro dat)
{
    NodoArbol *padre = NULL;

    actual = raiz;
    // Buscar el centro en el árbol, manteniendo un puntero al nodo padre
    while (!Vacio(actual) && dat.id != actual->dato.id)
    {
        padre = actual;
        if (dat.id > actual->dato.id)
            actual = actual->derecho;
        else if (dat.id < actual->dato.id)
            actual = actual->izquierdo;
    }

    // Si se ha encontrado el elemento, regresar sin insertar
    if (!Vacio(actual))
        return;
    // Si padre es NULL, entonces el árbol estaba vacío, el nuevo nodo será
    // el nodo raiz
    if (Vacio(padre))
        raiz = new NodoArbol(dat);
    // Si el centro es menor que el que contiene el nodo padre, lo insertamos
    // en la rama izquierda
    else if (dat.id < padre->dato.id)
        padre->izquierdo = new NodoArbol(dat);
    // Si el centro es mayor que el que contiene el nodo padre, lo insertamos
    // en la rama derecha
    else if (dat.id > padre->dato.id)
        padre->derecho = new NodoArbol(dat);
}

// Eliminar un elemento de un árbol ABB
void ArbolABB::Borrar(const centro dat)
{
    NodoArbol *padre = NULL;
    NodoArbol *nodo;
    centro aux;

    actual = raiz;
    // Mientras sea posible que el valor esté en el árbol
    while (!Vacio(actual))
    {
        if (dat.id == actual->dato.id)
        {
            // Si el valor está en el nodo actual
            if (EsHoja(actual))
            {
                // Y si además es un nodo hoja: lo borramos
                if (padre)
                {
                    // Si tiene padre (no es el nodo raiz)
                    // Anulamos el puntero que le hace referencia
                    if (padre->derecho == actual)
                        padre->derecho = NULL;
                    else if (padre->izquierdo == actual)
                        padre->izquierdo = NULL;
                }
                else
                    raiz = NULL;

                delete actual; // Borrar el nodo
                actual = NULL;
                return;
            }
            else
            {
                // Si el valor está en el nodo actual, pero no es hoja
                // Buscar nodo
                padre = actual;
                // Buscar nodo más izquierdo de rama derecha
                if (actual->derecho)
                {
                    nodo = actual->derecho;
                    while (nodo->izquierdo)
                    {
                        padre = nodo;
                        nodo = nodo->izquierdo;
                    }
                }
                // O buscar nodo más derecho de rama izquierda
                else
                {
                    nodo = actual->izquierdo;
                    while (nodo->derecho)
                    {
                        padre = nodo;
                        nodo = nodo->derecho;
                    }
                }
                // Intercambiar valores de no a borrar u nodo encontrado
                // y continuar, cerrando el bucle. El nodo encontrado no tiene
                // por qué ser un nodo hoja, cerrando el bucle nos aseguramos
                // de que sólo se eliminan nodos hoja.
                aux = actual->dato;
                actual->dato = nodo->dato;
                nodo->dato = aux;
                actual = nodo;
            }
        }
        else
        {
            // Todavía no hemos encontrado el valor, seguir buscándolo
            padre = actual;
            if (dat.id > actual->dato.id)
                actual = actual->derecho;
            else if (dat.id < actual->dato.id)
                actual = actual->izquierdo;
        }
    }
}

// Recorrido de árbol en inorden, aplicamos la función func, que tiene
// el prototipo:
// void func(centro&);
void ArbolABB::InOrden(void (*func)(centro&), NodoArbol *nodo, bool r)
{
    if (raiz == NULL)
    {
        cout << "Arbol vacio" << endl;
        return;
    }
    if (r)
        nodo = raiz;
    if (nodo->izquierdo)
        InOrden(func, nodo->izquierdo, false);
    func(nodo->dato);
    if (nodo->derecho)
        InOrden(func, nodo->derecho, false);
}

// Recorrido de árbol en preorden, aplicamos la función func, que tiene
// el prototipo:
// void func(centro&);
void ArbolABB::PreOrden(void (*func)(centro&), NodoArbol *nodo, bool r)
{
    if (raiz == NULL)
    {
        cout << "Arbol vacio" << endl;
        return;
    }
    if (r)
        nodo = raiz;
    func(nodo->dato);
    if (nodo->izquierdo)
        PreOrden(func, nodo->izquierdo, false);
    if (nodo->derecho)
        PreOrden(func, nodo->derecho, false);
}

// Recorrido de árbol en postorden, aplicamos la función func, que tiene
// el prototipo:
// void func(centro&);
void ArbolABB::PostOrden(void (*func)(centro&), NodoArbol *nodo, bool r)
{
    if (raiz == NULL)
    {
        cout << "Arbol vacio" << endl;
        return;
    }
    if (r)
        nodo = raiz;
    if (nodo->izquierdo)
        PostOrden(func, nodo->izquierdo, false);
    if (nodo->derecho)
        PostOrden(func, nodo->derecho, false);
    func(nodo->dato);
}

// Buscar un valor en el árbol
bool ArbolABB::Buscar(const centro dat)
{
    actual = raiz;

    // Todavía puede aparecer, ya que quedan nodos por mirar
    while (!Vacio(actual))
    {
        if (dat.id == actual->dato.id)
            return true; // centro encontrado
        else if (dat.id > actual->dato.id)
            actual = actual->derecho; // Seguir
        else if (dat.id < actual->dato.id)
            actual = actual->izquierdo;
    }
    return false; // No está en árbol
}

// Calcular la altura del nodo que contiene el centro dat
int ArbolABB::Altura(const centro dat)
{
    int altura = 0;
    actual = raiz;

    // Todavía puede aparecer, ya que quedan nodos por mirar
    while (!Vacio(actual))
    {
        if (dat.id == actual->dato.id)
            return altura; // centro encontrado
        else
        {
            altura++; // Incrementamos la altura, seguimos buscando
            if (dat.id > actual->dato.id)
                actual = actual->derecho;
            else if (dat.id < actual->dato.id)
                actual = actual->izquierdo;
        }
    }
    return -1; // No está en árbol
}

// Contar el número de nodos
const int ArbolABB::NumeroNodos()
{
    contador = 0;

    auxContador(raiz); // Función auxiliar
    return contador;
}

// Función auxiliar para contar nodos. Función recursiva de recorrido en
//   preorden, el proceso es aumentar el contador
void ArbolABB::auxContador(NodoArbol *nodo)
{
    contador++; // Otro nodo
    // Continuar recorrido
    if (nodo->izquierdo)
        auxContador(nodo->izquierdo);
    if (nodo->derecho)
        auxContador(nodo->derecho);
}

int ArbolABB::CajasTotales()
{
    contador = 0;

    auxCajasTotales(raiz); // Función auxiliar
    return contador;
}

void ArbolABB::auxCajasTotales(NodoArbol *nodo)
{
    contador = contador + nodo->dato.lista->contarCajas();
    if (nodo->izquierdo)
        auxCajasTotales(nodo->izquierdo);
    if (nodo->derecho)
        auxCajasTotales(nodo->derecho);
}

int ArbolABB::CajasTotalPais(string pais)
{
    contador = 0;
    auxCajasPais(raiz, pais);
    return contador;
}

void ArbolABB::auxCajasPais(NodoArbol *nodo, string pais)
{
    contador = contador + nodo->dato.lista->contarCajasPais(pais);
    if (nodo->izquierdo)
        auxCajasPais(nodo->izquierdo, pais);
    if (nodo->derecho)
        auxCajasPais(nodo->derecho, pais);
}

centro ArbolABB::centroConMasCajasAPais(string pais)
{
    contador = 0;
    centro centroMaximo;
    auxCentroConMasCajasAPais(raiz, pais, centroMaximo);
    return centroMaximo;
}

void ArbolABB::auxCentroConMasCajasAPais(NodoArbol *nodo, string pais, centro& centroMaximo)
{
    if (nodo != NULL)
    {
        int cajasEnPais = nodo->dato.lista->contarCajasPais(pais);

        if (cajasEnPais > contador)
        {
            contador = cajasEnPais;
            centroMaximo = nodo->dato;
        }

        auxCentroConMasCajasAPais(nodo->izquierdo, pais, centroMaximo);
        auxCentroConMasCajasAPais(nodo->derecho, pais, centroMaximo);
    }
}

centro ArbolABB::centroConMasCajasEnTotal()
{
    contador = 0;
    centro centroMaximo;
    auxCentroConMasCajasEnTotal(raiz, centroMaximo);
    return centroMaximo;
}

void ArbolABB::auxCentroConMasCajasEnTotal(NodoArbol* nodo, centro& centroMaximo)
{
    if (nodo != NULL)
    {
        int cajasEnTotal = nodo->dato.lista->contarCajas();

        if (cajasEnTotal > contador)
        {
            contador = cajasEnTotal;
            centroMaximo = nodo->dato;
        }

        auxCentroConMasCajasEnTotal(nodo->izquierdo, centroMaximo);
        auxCentroConMasCajasEnTotal(nodo->derecho, centroMaximo);
    }
}

centro ArbolABB::centroConMenosCajasEnTotal()
{
    centro centroMinimo;
    auxCentroConMenosCajasEnTotal(raiz, centroMinimo);
    return centroMinimo;
}

void ArbolABB::auxCentroConMenosCajasEnTotal(NodoArbol* nodo, centro& centroMinimo)
{
    if (nodo != nullptr)
    {
        int cajasEnTotal = nodo->dato.lista->contarCajas();

        if (cajasEnTotal < contador)
        {
            contador = cajasEnTotal;
            centroMinimo = nodo->dato;
        }

        auxCentroConMenosCajasEnTotal(nodo->izquierdo, centroMinimo);
        auxCentroConMenosCajasEnTotal(nodo->derecho, centroMinimo);
    }
}




// Calcular la altura del árbol, que es la altura del nodo de mayor altura.
const int ArbolABB::AlturaArbol()
{
    altura = 0;

    auxAltura(raiz, 0); // Función auxiliar
    return altura;
}

// Función auxiliar para calcular altura. Función recursiva de recorrido en
// postorden, el proceso es actualizar la altura sólo en nodos hojas de mayor
// altura de la máxima actual
void ArbolABB::auxAltura(NodoArbol *nodo, int a)
{
    // Recorrido postorden
    if (nodo->izquierdo)
        auxAltura(nodo->izquierdo, a + 1);
    if (nodo->derecho)
        auxAltura(nodo->derecho, a + 1);
    // Proceso, si es un nodo hoja, y su altura es mayor que la actual del
    // árbol, actualizamos la altura actual del árbol
    if (EsHoja(nodo) && a > altura)
        altura = a;
}

// Función de prueba para recorridos del árbol
void Mostrar(centro &c)
{
    cout << "ID: " << c.id << "  Localidad: " << c.localidad;
    if (c.lista != NULL)
    {
        cout << "  Num de cajas: " << c.lista->contarCajas();
    }
    else
    {
        cout << "  Lista no inicializada";
    }
    cout << endl;
}

void MostrarID(centro &c)
{
    cout << c.id << ", ";
}

void ImprimirCabecera()
{
    cout <<  "-------------------------------------------------------------------------------------" << endl;

    cout << "|" << setw(10) << "ID CAJA" << setw(4) << "|" << setw(12) << "CENTRO REF." << setw(4) << "|" << setw(12) << "ID CENTRO." << setw(2) << "|" << setw(11) << "CONTENIDO"
         << setw(4) << "|" << setw(18) << "FECHA DE CONSUMO" << setw(2) << "|" << setw(4) << "DIA"
         << "|" << endl;
    cout <<  "-------------------------------------------------------------------------------------" << endl;
}

void MostrarCaja(Caja caja)
{
    cout << "| " << setw(10) << caja.id_caja << setw(4)
         << " | " << setw(12) << caja.centro_ref << setw(4)
         << " | " << setw(11) << caja.id_centro << setw(2)
         << " | " << setw(12) << caja.contenido << setw(2)
         << " | " << setw(11) << caja.fechaCad.mes << setw(2)
         << "/" << setw(4) << caja.fechaCad.anno << " |"
         << setw(3) << caja.dia << setw(2) << " |" << endl;
}

centro ArbolABB::obtenerNodoAleatorio()
{
    int altura = AlturaArbol();
    int num_mov = rand() % (altura+1);

    NodoArbol *actual = raiz;

    // Realiza movimientos aleatorios en el árbol
    for (int i = 0; i < num_mov && actual != NULL; i++)
    {
        int mov = rand() % 2;

        if (mov == 0 && !Vacio(actual->izquierdo))
        {
            // Mover el puntero a la izquierda si hay un nodo a la izquierda
            actual = actual->izquierdo;
        }
        else if (mov == 1 && !Vacio(actual->derecho))
        {
            // Mover el puntero a la derecha si hay un nodo a la derecha
            actual = actual->derecho;
        }
    }

    // Devuelve el centro al que apunta el puntero después de los movimientos aleatorios
    return actual->dato;
}

Caja cajaAleatoriaFinal(ArbolABB &abb)
{
    centro centroReferencia = abb.obtenerNodoAleatorio();
    string centro = centroReferencia.localidad;
    int id_centro = centroReferencia.id;

    string id = idAleatorio();
    string contenido = contenidoAleatorio();

    Fecha fechaCad;

    if (contenido == "iluminación" || contenido == "herramientas" ||
            contenido == "tiendas_camp" || contenido == "ropa" || contenido == "limpieza" || contenido == "mantas")
    {
        fechaCad = {12, 2100};
    }
    else
    {
        fechaCad = fechaAleatoria();
    }

    Caja caja;
    caja.contenido = contenido;
    caja.fechaCad = fechaCad;
    caja.id_caja = id;
    caja.centro_ref = centro;
    caja.id_centro = id_centro;
    caja.dia = calcularPosicionAleatoria(30)+1;

    return caja;
}

void ArbolABB::distribuirCajas(Caja caja)
{
    NodoArbol* actual = raiz;

    while (actual != NULL)
    {
        if (actual->dato.id == caja.id_centro)
        {
            // Encontró el centro con el ID correspondiente
            actual->dato.lista->insertarNodo(caja, 'f'); // Agrega la caja a la lista del centro
            break; // Sale del bucle ya que encontró el centro
        }
        else if (actual->dato.id < caja.id_centro)
        {
            // Buscar en el subárbol derecho
            actual = actual->derecho;
        }
        else
        {
            // Buscar en el subárbol izquierdo
            actual = actual->izquierdo;
        }
    }
}

centro ArbolABB::obtenerNodo(int id)
{
    NodoArbol *actual = raiz;

    centro vacio;
    vacio.id = 0;
    vacio.localidad = "";
    vacio.lista = NULL;

    // Buscar el nodo con el ID específico
    while (actual != NULL && actual->dato.id != id)
    {
        if (id < actual->dato.id)
        {
            actual = actual->izquierdo;
        }
        else
        {
            actual = actual->derecho;
        }
    }

    // Devuelve el centro encontrado (o un centro vacio si no se encuentra)
    return (actual != NULL) ? actual->dato : vacio;
}


void imprimirDatosCC(int id, ArbolABB &abb)
{
    abb.obtenerNodo(id).lista->recorrerLista(0);
}

void buscarCCPorId(ArbolABB &abb)
{
    char respuesta;

    do
    {
        int id;

        cout << "Introduzca el ID del Centro de Clasificacion que desea buscar: ";
        abb.InOrden(MostrarID);
        cout << endl;

        cin >> id;
        cout << endl;

        if (abb.Buscar(abb.obtenerNodo(id)) == 1)
        {
            cout << endl;
            cout << "Central encontrada." << endl;
            cout << "ID central: " << abb.obtenerNodo(id).id << endl;
            cout << "Localidad: " << abb.obtenerNodo(id).localidad << endl;
            cout << "Numero de cajas: "  << abb.obtenerNodo(id).lista->contarCajas()<< endl;
            cout << endl;
            cout << "Cola del Centro de clasificacion:" << endl;
            imprimirDatosCC(id, abb);
        }
        else
        {
            cout << "No hay un Centro de Clasificacion con ese ID.";
        }

        cout << endl;


        do
        {
            cout << "Quieres realizar otra busqueda? (y/n): ";
            cin >> respuesta;
            cout << endl;

            if (respuesta == 'n' || respuesta == 'N' || respuesta == 'y' || respuesta == 'Y')
            {
                break;
            }
            else
            {
                cout << "Respuesta no válida. Por favor, introduce 'y' o 'n'." << endl;
                cout << endl;

            }

        }
        while (true);

    }
    while (respuesta == 'y' || respuesta == 'Y');
}


void introducirCC(ArbolABB &abb)
{
    char respuesta;
    centro nuevoCentro;
    do
    {
        do
        {
            cout << "ID ya usados: ";
            abb.InOrden(MostrarID);
            cout << endl;
            cout << "Ingrese el ID del nuevo Centro de Clasificacion: ";
            cin >> nuevoCentro.id;

            if (abb.Buscar(abb.obtenerNodo(nuevoCentro.id)) != 1)
            {
                break;
            }
            else
            {
                cout << "Ya hay un Centro de Clasificacion con ese ID." << endl;
                cout << endl;

            }
        }
        while (true);



        cout << "Ingrese la localidad del Centro de Clasificacion: ";
        cin >> nuevoCentro.localidad;

        Lista *lista = new Lista();
        nuevoCentro.lista = lista;
        abb.Insertar(nuevoCentro);

        cout << "Centro de Clasificacion introducido." << endl;
        cout << endl;

        do
        {
            cout << "Quieres introducir otro Centro de Clasificacion? (y/n): ";
            cin >> respuesta;
            cout << endl;

            if (respuesta == 'n' || respuesta == 'N' || respuesta == 'y' || respuesta == 'Y')
            {
                break;
            }
            else
            {
                cout << "Respuesta no válida. Por favor, introduce 'y' o 'n'." << endl;
                cout << endl;

            }

        }
        while (true);

    }
    while (respuesta == 'y' || respuesta == 'Y');

}

void eliminarCC(ArbolABB &abb)
{
    int id;
    char respuesta;

    do
    {
        cout << "Ingrese el ID del Centro de Clasificacion que quiere elimininar: ";
        abb.InOrden(MostrarID);
        cout << endl;
        cin >> id;


        if (abb.Buscar(abb.obtenerNodo(id)) == 1)
        {
            cout << "Central borrada." << endl;

            abb.Borrar(abb.obtenerNodo(id));
        }
        else
        {
            cout << "No hay un Centro de Clasificacion con ese ID." << endl;
            cout << endl;

        }

        do
        {
            cout << "Quieres eliminar otro Centro de Clasificacion? (y/n): ";
            cin >> respuesta;
            cout << endl;

            if (respuesta == 'n' || respuesta == 'N' || respuesta == 'y' || respuesta == 'Y')
            {
                break;
            }
            else
            {
                cout << "Respuesta no válida. Por favor, introduce 'y' o 'n'." << endl;
                cout << endl;

            }

        }
        while (true);

    }
    while (respuesta == 'y' || respuesta == 'Y');
}

void CrearYDistribuirCajas(ArbolABB &abb, int n)
{
    Caja caja;
    ImprimirCabecera();
    for (int i = 0; i < n; i++)
    {
        caja = cajaAleatoriaFinal(abb);
        MostrarCaja(caja);

        abb.distribuirCajas(caja);

    }
}

Caja Lista::BuscarCaja(string id)
{
    pnodo temp = cabeza;
    Fecha fecha = {0,0};
    Caja vacio = {"","", "", fecha, 0, 0};

    while (temp != NULL)
    {
        if (temp -> valor.id_caja == id)
        {
            return temp -> valor;
        }
        temp = temp->siguiente;
    }

    return vacio;
}


void ArbolABB::BuscarCajaPorID(string id, NodoArbol *nodo)
{
    if (nodo == NULL)
    {
        return;
    }

    Caja cajaEncontrada = nodo->dato.lista->BuscarCaja(id);

    if (cajaEncontrada.id_caja == id)
    {
        cout << endl;
        ImprimirCabecera();
        MostrarCaja(cajaEncontrada);
    }
    else
    {
        // Buscar en los nodos izquierdo y derecho
        BuscarCajaPorID(id, nodo->izquierdo);
        BuscarCajaPorID(id, nodo->derecho);
    }

}



NodoArbol* ArbolABB::ObtenerRaiz()
{
    return raiz;
}


void buscarCajaPorID(ArbolABB &abb)
{
    string id;
    char respuesta;

    do
    {

        cout << "Introduce el ID de la caja que quieres buscar: ";
        cin >> id;

        //convertir el id introducido a mayusculas
        for (char &c : id)
        {
            c = toupper(c);
        }


        abb.BuscarCajaPorID(id, abb.ObtenerRaiz());

        do
        {
            cout << endl;
            cout << "Quieres buscar otra caja? (y/n): ";
            cin >> respuesta;
            cout << endl;

            if (respuesta == 'n' || respuesta == 'N' || respuesta == 'y' || respuesta == 'Y')
            {
                break;
            }
            else
            {
                cout << "Respuesta no válida. Por favor, introduce 'y' o 'n'." << endl;
                cout << endl;

            }

        }
        while (true);

    }
    while (respuesta == 'y' || respuesta == 'Y');
}


void borrarCaja(ArbolABB &abb)
{
    int idCentro;
    string idCaja;

    char respuesta;

    do
    {

        cout << "Introduce el ID del Centro de Clasificacion de la caja que quieres eliminar: ";
        abb.InOrden(MostrarID);
        cout << endl;
        cin >> idCentro;
        cout << endl;
        if (abb.Buscar(abb.obtenerNodo(idCentro)) == 1)
        {
            if (abb.obtenerNodo(idCentro).lista->contarCajas() != 0)
            {
                abb.obtenerNodo(idCentro).lista->recorrerLista(0);

                cout << "Introduce el ID de la caja que quieres eliminar: ";
                cin >> idCaja;

                //convertir el id introducido a mayusculas
                for (char &c : idCaja)
                {
                    c = toupper(c);
                }

                if (abb.obtenerNodo(idCentro).lista->BuscarCaja(idCaja).id_caja != "")
                {
                    abb.obtenerNodo(idCentro).lista->borrarCajaPorID(idCaja);
                    cout << "Caja con ID " << idCaja << " eliminada." << endl;
                }
                else
                {
                    cout << "No hay ninguna caja con ese ID." << endl;
                }


            }
            else
            {
                cout << "Este Centro de Clasificacion no tiene cajas." << endl;
            }
        }
        else
        {
            cout << "No hay ningun Centro de Clasificacion con ese ID." << endl;
            cout << endl;
        }


        do
        {
            cout << endl;
            cout << "Quieres eliminar otra caja? (y/n): ";
            cin >> respuesta;
            cout << endl;

            if (respuesta == 'n' || respuesta == 'N' || respuesta == 'y' || respuesta == 'Y')
            {
                break;
            }
            else
            {
                cout << "Respuesta no válida. Por favor, introduce 'y' o 'n'." << endl;
                cout << endl;

            }

        }
        while (true);

    }
    while (respuesta == 'y' || respuesta == 'Y');

}

void moverCaja(ArbolABB &abb)
{
    int idCentro;
    string idCaja;
    Caja caja;

    char respuesta;

    do
    {
        cout << "Introduce el ID del Centro de Clasificacion de la caja que quieres mover: ";
        abb.InOrden(MostrarID);
        cout << endl;
        cin >> idCentro;
        cout << endl;
        if (abb.Buscar(abb.obtenerNodo(idCentro)) == 1)
        {
            if (abb.obtenerNodo(idCentro).lista->contarCajas() != 0)
            {
                abb.obtenerNodo(idCentro).lista->recorrerLista(0);

                cout << "Introduce el ID de la caja que quieres mover: ";
                cin >> idCaja;

                //convertir el id introducido a mayusculas
                for (char &c : idCaja)
                {
                    c = toupper(c);
                }

                if (abb.obtenerNodo(idCentro).lista->BuscarCaja(idCaja).id_caja != "")
                {
                    caja = abb.obtenerNodo(idCentro).lista->BuscarCaja(idCaja);
                    int idDestino;
                    cout << "Introduce el ID del Centro de Clasificacion a donde la quieres mover: ";
                    abb.InOrden(MostrarID);
                    cout << endl;
                    cin >> idDestino;
                    cout << endl;

                    if (abb.Buscar(abb.obtenerNodo(idDestino)) == 1)
                    {
                        abb.obtenerNodo(idDestino).lista->insertarNodo(caja, 'f');
                        abb.obtenerNodo(idCentro).lista->borrarCajaPorID(idCaja);

                        cout << "Centro de donde se ha movido la caja." << endl;
                        centro origen = abb.obtenerNodo(idCentro);

                        cout << "ID: " << origen.id << "  Localidad: " << origen.localidad << "  Num de cajas: " << origen.lista->contarCajas() << endl;
                        abb.obtenerNodo(idCentro).lista->recorrerLista(0);
                        cout << endl;
                        cout << endl;
                        cout << "Centro a donde se ha movido la caja" << endl;
                        centro destino = abb.obtenerNodo(idDestino);
                        cout << "ID: " << destino.id << "  Localidad: " << destino.localidad << "  Num de cajas: " << destino.lista->contarCajas() << endl;
                        abb.obtenerNodo(idDestino).lista->recorrerLista(0);


                    }
                }
                else
                {
                    cout << "No hay ninguna caja con ese ID." << endl;
                }


            }
            else
            {
                cout << "Este Centro de Clasificacion no tiene cajas." << endl;
            }
        }
        else
        {
            cout << "No hay ningun Centro de Clasificacion con ese ID." << endl;
            cout << endl;
        }

        do
        {
            cout << endl;
            cout << "Quieres mover otra caja? (y/n): ";
            cin >> respuesta;
            cout << endl;

            if (respuesta == 'n' || respuesta == 'N' || respuesta == 'y' || respuesta == 'Y')
            {
                break;
            }
            else
            {
                cout << "Respuesta no válida. Por favor, introduce 'y' o 'n'." << endl;
                cout << endl;

            }

        }
        while (true);

    }
    while (respuesta == 'y' || respuesta == 'Y');
}

void estadisticas(ArbolABB &abb)
{
    int cajasTotalesMarruecos = abb.CajasTotalPais("MAR");
    int cajasTotalesLisboa = abb.CajasTotalPais("LIS");
    int cajasTotalesGrecia = abb.CajasTotalPais("GRE");

    cout << endl;
    cout << "Numero de cajas en todos los centros de clasificacion: " << abb.CajasTotales() << endl;
    cout << "Numero de cajas con destino a Marruecos en todos los centros de clasificacion: " << cajasTotalesMarruecos << endl;
    cout << "Numero de cajas con destino a Lisboa en todos los centros de clasificacion: " << cajasTotalesLisboa << endl;
    cout << "Numero de cajas con destino a Grecia en todos los centros de clasificacion: " << cajasTotalesGrecia << endl;
    cout << endl;

// Países que más y menos cajas van a recibir
    if (cajasTotalesMarruecos == cajasTotalesLisboa && cajasTotalesLisboa == cajasTotalesGrecia)
    {
        cout << "Todos los países van a recibir la misma cantidad de cajas." << endl;
    }
    else
    {
        // Países que más cajas van a recibir
        cout << "Paises que más cajas van a recibir: ";
        if (cajasTotalesMarruecos >= cajasTotalesLisboa && cajasTotalesMarruecos >= cajasTotalesGrecia)
        {
            cout << "Marruecos. ";
        }
        if (cajasTotalesLisboa >= cajasTotalesMarruecos && cajasTotalesLisboa >= cajasTotalesGrecia)
        {
            cout << "Lisboa. ";
        }
        if (cajasTotalesGrecia >= cajasTotalesMarruecos && cajasTotalesGrecia >= cajasTotalesLisboa)
        {
            cout << "Grecia. ";
        }
        cout << endl;

        // Países que menos cajas van a recibir
        cout << "Paises que menos cajas van a recibir: ";
        if (cajasTotalesMarruecos <= cajasTotalesLisboa && cajasTotalesMarruecos <= cajasTotalesGrecia)
        {
            cout << "Marruecos. ";
        }
        if (cajasTotalesLisboa <= cajasTotalesMarruecos && cajasTotalesLisboa <= cajasTotalesGrecia)
        {
            cout << "Lisboa. ";
        }
        if (cajasTotalesGrecia <= cajasTotalesMarruecos && cajasTotalesGrecia <= cajasTotalesLisboa)
        {
            cout << "Grecia. ";
        }
        cout << endl;
    }


    cout<<endl;
    centro centroMAR = abb.centroConMasCajasAPais("MAR");
    cout << "El Centro de Clasificacion con mas cajas hacia Marruecos es el CC con ID " << centroMAR.id << ", ubicado en " << centroMAR.localidad << ", con un total de " << centroMAR.lista->contarCajasPais("MAR") << " cajas enviadas a Marruecos." << endl;

    centro centroLIS = abb.centroConMasCajasAPais("LIS");
    cout << "El Centro de Clasificacion con mas cajas hacia Lisboa es el CC con ID " << centroLIS.id << ", ubicado en " << centroLIS.localidad << ", con un total de " << centroLIS.lista->contarCajasPais("LIS") << " cajas enviadas a Lisboa." << endl;

    centro centroGRE = abb.centroConMasCajasAPais("GRE");
    cout << "El Centro de Clasificacion con mas cajas hacia Grecia es el CC con ID " << centroGRE.id << ", ubicado en " << centroGRE.localidad << ", con un total de " << centroGRE.lista->contarCajasPais("GRE") << " cajas enviadas a Grecia." << endl;
    cout << endl;
    centro centroMayor = abb.centroConMasCajasEnTotal();
    centro centroMenor = abb.centroConMenosCajasEnTotal();
    cout << "El Centro de Clasificacion que mas cajas es el CC con ID " << centroMayor.id << ", ubicado en " << centroMayor.localidad << ", con un total de " << centroMayor.lista->contarCajas() << " cajas enviadas." << endl;
    cout << "El Centro de Clasificacion con menos cajas es el CC con ID " << centroMenor.id << ", ubicado en " << centroMenor.localidad << ", con un total de " << centroMenor.lista->contarCajas()  << " cajas enviadas." << endl;

}

void Lista::ordenarCajasDia()
{

    if (listaVacia() || cabeza->siguiente == NULL)
    {
        // La lista está vacía o tiene solo un elemento, no hay nada que ordenar
        return;
    }

    pnodo ptr1, ptr2;
    Caja temp;




    for (ptr1 = cabeza; ptr1 != NULL; ptr1 = ptr1->siguiente)
    {
        for (ptr2 = ptr1->siguiente; ptr2 != NULL; ptr2 = ptr2->siguiente)
        {
            // Compara las fechas de consumo y realiza el intercambio si es necesario
            if (ptr1->valor.dia > ptr2->valor.dia)
            {
                temp = ptr1->valor;
                ptr1->valor = ptr2->valor;
                ptr2->valor = temp;
            }
        }
    }



}


void ordenarLista(ArbolABB &abb)
{
    char respuesta;


    do
    {
        int id;

        cout << "Introduzca el ID del Centro de Clasificacion que desea buscar: ";
        abb.InOrden(MostrarID);
        cout << endl;

        cin >> id;
        cout << endl;

        if (abb.Buscar(abb.obtenerNodo(id)) == 1)
        {


            abb.obtenerNodo(id).lista->ordenarCajasDia();
            abb.obtenerNodo(id).lista->recorrerLista(0);




        }
        else
        {
            cout << "No hay un Centro de Clasificacion con ese ID.";
        }

        cout << endl;


        do
        {
            cout << "Quieres ordenar las cajas de otro centro de clasificacion? (y/n): ";
            cin >> respuesta;
            cout << endl;

            if (respuesta == 'n' || respuesta == 'N' || respuesta == 'y' || respuesta == 'Y')
            {
                break;
            }
            else
            {
                cout << "Respuesta no válida. Por favor, introduce 'y' o 'n'." << endl;
                cout << endl;

            }

        }
        while (true);

    }
    while (respuesta == 'y' || respuesta == 'Y');
}



