""" 4. Los siguientes códigos hacen lo que se desea, pero…
Mejóralos, justificando tu propuesta."""

"""

while x!=y:
    x+=inc
    print(x) 
    
"""

x = 1
y = 2
inc = 0.15

while x <= y: 
    x = round(x, len(str(inc)))
    print(x)
    x += inc

#el bucle tambien para cuando x > y, porque no simpre x = y.
#x se redondea para solucionar el problema que tiene python con los doubles.
#el redondeo se realiza segun la longitud del inc (lo paso a str antes de sacar la longitud).
#imprimo x antes de sumar el inc para que x, se imprima redondeado.