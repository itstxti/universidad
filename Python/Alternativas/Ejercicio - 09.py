""" 9. En el menú actual, se presenta un problema:
las alternativas están pensadas para hacer cosas distintas, sin embargo,
el código presenta muchas redundancias ¿Puedes hacer otra versión que la evite?"""


def enteroPedido(n1, n2, msg):
    try: 
        a = int(input(msg))
        if a < n1 or a > n2:
            print('INTRODUCE UN NUMERO VALIDO.')
            return enteroPedido(n1, n2, msg)
        return a
    except:
        print('INTRODUCE UN NUMERO VALIDO.')
        return enteroPedido(n1, n2, msg)
    

opcion=enteroPedido(1,6,'INTRODUCE LA OPCIÓN QUE DESEE: ')

if opcion != 6:
    print('pido p1')
    if opcion != 1 :
        print('pido p2')       
    if opcion==2:       
        print('hago derivada')
    elif opcion==3:        
        print('multiplica')
    elif opcion==4:        
        print('potencia')
    elif opcion==5:         
        print('suma')
    print('imprimo solución')

else: print('Saliendo del programa')