import random

def generarMatricula(matriculas_usadas):
    """
    Genera una matrícula nueva y comprueba 
    que no está en la lista de matrículas ya usadas.
    Condición-> la matrícula española consta de 4 dígitos 
                y 3 letras que no sean vocales
    list -> string
    """
    matricula = ''                                                          #declaramos la variable a devolver
    letras = 'BCDFGHJKLMNPQRSTVWXYZ'                                        #lista de letras para las matrículas, sin las vocales

    while matricula == '' or matricula in matriculas_usadas:                #comprueba que la variable no está vacía y mira si no está dentro de las matrículas ya usadas
        matricula = str(random.randint(0000, 9999))+random.choice(letras)+random.choice(letras)+random.choice(letras)
    
    return matricula

def generarEmpresa():
    """
    Esta función genera el nombre de una empresa
    a partir de un numero aleatorio entre 1 y 10.000
    Condición -> Si ese número es 5000, el nombre de la empresa es UPS
    void -> string
    """
    nombre_empresa = ''
    num = int(random.randint(1, 10000))
    if(num == 5000):    nombre_empresa = 'UPS'
    else:               nombre_empresa = 'Empresa'+str(num)
        
    return nombre_empresa

def generarRegistro(id_camion, matriculas_usadas):
    """
    Esta función genera un registro con información aleatoria.
    int, list, list -> string
    """
    registro = ''

    matricula = generarMatricula(matriculas_usadas)                         #generamos una nueva matrícula
    empresa = generarEmpresa()                                              #generamos una empresa o elegimos 'UPS' de manera aleatoria
    kilometros = random.randint(0, 500000)                                  #elegimos al azar un kilometraje
    registro = f"{id_camion},{matricula},{empresa},{kilometros}\n"          #escribimos todos los datos generados anteriormente en el registro

    return registro                                                         #devolvemos el registro a la función

def generarFichero(num_registros):
    """
    creamos un fichero de texto con 
    la cantidad de registros que nos llega a la función.
    int -> fichero
    """
    matriculas_usadas = []

    with open("camiones.txt", "w") as file:
        for i in range(1, num_registros + 1):
            registro = generarRegistro(i, matriculas_usadas)                #generamos el nuevo registro
            matricula_aux = registro.split(',')[1]                          #guardamos la matrícula del registro generado en una variable auxiliar
            matriculas_usadas.append(matricula_aux)                         #agregamos la matrícula a la lista de matrículas usadas para que no se vualva a usar
            file.write(registro)                                            #agregamos el registro a nuestro fichero

def main():
    generarFichero(20000000)

main()
