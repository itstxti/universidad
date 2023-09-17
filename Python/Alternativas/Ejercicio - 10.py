""" 10. Indica qué problema resuelve el siguiente programa, sin probarlo en tu ordenador.
No indiques línea por línea qué va haciendo el programa. Sintetiza una sola frase."""

"""    ¿cuanto mola una carcajada?     """

jaja=int(input('¿CUÁNTO MOLAN LOS JAJAS?: '))
jiji=int(input('¿CUÁNTO MOLAN LOS JIJIS?: '))
jojo=int(input('¿CUÁNTO MOLAN LOS JOJOS?: '))

if jaja>jiji:
	if jaja>jojo:
		mola=jaja
	else:
		mola = jojo
else:
	if jiji>jojo:
		mola= jiji
	else:
		mola = jojo
		
print('LA QUE MÁS MOLA ES:', mola)

# El código devuelve el numero más alto.