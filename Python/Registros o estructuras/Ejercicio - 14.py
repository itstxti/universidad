"""14. Programa un software que lea los datos de 10 personas y calcule la media de edad general, la media por sexo, la cantidad de
mujeres que tienen entre 13 y 16 años y el número de hombres menores de 20 años."""

persona = {"nombre", "sexo", "edad"}

personas = []

def añadir_persona():
    nombre = input("Introduce el nombre: ")
    sexo = input("Introduce el sexo: ")
    edad = input("Introduce la edad: ")
    return {"nombre": nombre, "sexo": sexo, "edad": edad}

n = 3
for i in range(0, n):
    print("Persona", i+1)
    personas.append(añadir_persona())

#EDAD MEDIA
def edad_media(lista):
    edad_total = 0
    for i in range(0, len(lista)):
        edad_total += int(lista[i]["edad"])
    return edad_total / len(lista)

print("Media de edad:", edad_media(personas))

#MEDIA DE SEXO
#F = female
#M = male

def edad_media_sexo(sexo, lista):
    contador_edad = 0
    contador_personas = 0
    for i in lista:
        if i["sexo"].upper() == sexo:
            contador_edad += int(i["edad"])
            contador_personas +=1
    return contador_edad/contador_personas

print("Media de edad de las mujeres:", edad_media_sexo("F", personas))
print("Media de edad de los hombres:", edad_media_sexo("M", personas))

#la cantidad de mujeres que tienen entre 13 y 16 años

def personas_entre_edad(n1, n2, lista, sexo):
    contador = 0
    for i in lista:
        if i["sexo"].upper() == sexo and int(i["edad"]) >= n1 and int(i["edad"]) <= n2:
            contador += 1
    return contador


print("La cantidad de mujeres que tienen entre 13 y 16 años:", personas_entre_edad(13,16, personas, "F"))
print("La cantidad de hombres menores de 20 años:", personas_entre_edad(0, 20, personas, "M"))