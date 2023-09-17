""" 10. Haz un subprograma que recibe un texto en claro y devuelve su criptograma,
con un determinado desplazamiento que es la clave compartida. Haz el subprograma que descifra. 
Para que el programa sea fácil de mantener recuerda no usar directamente los valores de la tabla ASCII.
Usa las funciones ord, y chr."""

def encriptar(texto, desplazamiento):
    criptograma = ""
    for caracter in texto:
        if caracter.isalpha():
            if caracter.isupper():
                codigo = (ord(caracter) - ord('A') + desplazamiento) % 26 + ord('A')
            else:
                codigo = (ord(caracter) - ord('a') + desplazamiento) % 26 + ord('a')
            criptograma += chr(codigo)
        else:
            criptograma += caracter
    return criptograma

def desencriptar(criptograma, desplazamiento):
    texto = ""
    for caracter in criptograma:
        if caracter.isalpha():
            if caracter.isupper():
                codigo = (ord(caracter) - ord('A') - desplazamiento) % 26 + ord('A')
            else:
                codigo = (ord(caracter) - ord('a') - desplazamiento) % 26 + ord('a')
            texto += chr(codigo)
        else:
            texto += caracter
    return texto


print(encriptar('KAFKA VUELVE A CASA', 8))
print(desencriptar(encriptar('KAFKA VUELVE A CASA', 8), 8))