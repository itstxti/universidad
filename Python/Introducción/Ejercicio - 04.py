# Haz la tabla de verdad de p and not q or r teniendo en cuenta el orden de prelación de los operadores en Python. 

pos = [[True, True, True], [True, True, False], [True, False, True], [True, False, False],
       [False, True, True],[False, True, False], [False, False, True], [False, False, False]]

v1= 'p'
v2 = 'q'
v3 = 'r'
v4 = 'res'

print('%10s%10s%10s%10s' % (v1, v2, v3, v4))

for i in range(0, len(pos)):
    p = pos[i][0]
    q = pos[i][1]
    r = pos[i][2]
    print('%10s%10s%10s%10s' % (p, q, r, p and not q or r))