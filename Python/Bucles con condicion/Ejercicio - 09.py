""" 9. Empleando el esquema menú , haz una aplicación que
muestra un menú con cada una de las operaciones. 
Si el usuario solicita una opción existente, la realiza. Si pide una opción incorrecta,
le vuelve a pedir la opción. En ambos casos, el programa vuelve a pintar el menú
hasta que el usuario seleccione la opción salir."""


def menu(n, n2):
    pedir = True
    while pedir == True:
        print('ELIGE UNA OPERACIÓN.')
        signo = input('(1) SUMA \n' +
            '(2) RESTA \n' +
            '(3) MULTIPLICAR \n' + '(4) DIVIDIR \n' + '(5) SALIR \n' + '- ')
        
        if signo == '1':
            print('EL RESULTADO DE', n, '+', n2 ,'ES:', n + n2)
            pedir = True

        if signo == '2':
            print('EL RESULTADO DE', n, '-', n2 ,'ES:', n - n2)
            pedir = True

        if signo == '3':
            print('EL RESULTADO DE', n, '*', n2 ,'ES:', n * n2)
            pedir = True
            
        if signo == '4':
            print('EL RESULTADO DE', n, '/', n2 ,'ES:', n / n2)
            pedir = True
            
        if signo == '5':
            break
    
def calcular():
    try:
        n = int(input('INTRODUCE UN NUMERO: '))
        n2 = int(input('INTRODUCE UN SEGUNDO NUMERO: '))
        menu(n, n2)
    except:
        print('INTRODUCE UN NUMERO VALIDO')
        calcular()

calcular()