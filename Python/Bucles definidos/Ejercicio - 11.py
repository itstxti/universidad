"""Escriba un programa modularizado en Python que genere 5 frases a partir de
palabras en la siguiente lista:

['perro','niño','nube','padre','es','esta','come','mira','ama','el','la','al','en']

Las frases, que deben tener entre 3 y 10 palabras, deben generarse eligiendo un
número aleatorio de palabras cada vez, de modo que la primera frase puede tener
3 palabras, mientras que la segunda podría tener 6 palabras. Una vez generada
una frase, el programa la mostrará por pantalla. Y así hasta 5 frases en total."""

palabras = ['perro','niño','nube','padre','es','esta','come','mira','ama','el','la','al','en']

import random

def frase(n):
    for i in range(0, n):
        num_palabras = random.randint(3, 10)
        frase = ""
        for j in range(0, num_palabras):
            c = random.randint(0, len(palabras)-1)
            frase = frase + " " + palabras[c]
        print(frase)
    
# PROBADOR

frase(5) 