"""13. Escribir una función que permita mostrar los caracteres de una cadena del final
al principio, pero nunca mostrando la letra “a”. Ejemplo: si la entrada es “barco
amarillo”, la función devolverá: “ollirm ocrb”. """

def eliminar_a(n):
    str = ""
    for i in range(len(n)-1, -1, -1):
        str = str + n[i]
    str = str.replace("a", "")
    str =  str.replace("A", "")
    return str

print(eliminar_a("Barco Amarillo"))