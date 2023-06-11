""" 4. Los siguientes códigos hacen lo que se desea, pero…
Mejóralos, justificando tu propuesta."""

"""

while x!=y:
    x+=inc
    print(x) 
    
"""

x = 1
y = 10
inc = 0.1

while x <= y: 
    x = round(x, len(str(inc)))
    print(x)
    x += inc

#el bucle tambien pare cuando x > y, porque no simpre x = y.
#redondeo x para el solucionar el problema que tiene python al sumar doubles.
#el redondeo se realiza segun la longitud del inc (lo paso a str antes de sacar la long).
#imprimo x antes de sumar el inc para que x, se imprima redondeado.