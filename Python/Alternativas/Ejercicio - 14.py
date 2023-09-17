""" 14. El siguiente código, aunque hace lo que se deseaba hacer, contiene errores conceptuales.
Corrígelos e indica qué parámetros de calidad has mejorado."""

# Doble del trabajo necesario

fin=5
total=0

for i in range(fin): # SUMA 3 CADA NUMERO PAR QUE HAY EN EL RANGO DE 0 A FIN
    if i%2 == 0:
        total += 3

print(total)