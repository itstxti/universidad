"""11. Escriba un programa que “codifique” una frase modificando todas las vocales
según el siguiente código: a por 4, e por 3, i por 1, o por 0 y u por el símbolo #.
Por ejemplo, la frase: “Un perro del hortelano”, deberá devolverse: “#n p3rr0 d3l
h0rt3l4n0”. """


def codificar(n):
    n = n.replace("a", "4")
    n = n.replace("A", "4")
    n = n.replace("i", "1")
    n = n.replace("I", "1")
    n = n.replace("e", "3")
    n = n.replace("E", "3")
    n = n.replace("o", "0")
    n = n.replace("O", "0")
    n = n.replace("u", "#")
    n = n.replace("U", "#")
    return n


print(codificar("Un perro del hortelano"))
