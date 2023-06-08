from recordclass import recordclass
tComplejo=recordclass ('Complejo','r, i') 

#PROBADOR
c1=tComplejo(1.0,3.0)
print(c1.i, 'debe dar 3.0')
