""" 13. El siguiente código, aunque hace lo que se deseaba hacer, contiene errores conceptuales.
Corrígelos e indica qué parámetros de calidad has mejorado."""

# a y b están definidos previamente en el código
a = 37589
b = 945672.3

for i in range(44):
    if i % 2 == 0: 
        # Realizar una gestión específica sobre 'a' en las iteraciones pares
        print('Gestión sobre "a" en la iteración', i)
    else:

        b += 4  # Sumar 4 a 'b' en las iteraciones impares
        print('Sumar 4 a "b" en la iteración', i)

print(b)