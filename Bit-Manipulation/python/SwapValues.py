
def SwapValues(a,b):
	a = a^b
	b = a^b
	a = a^b
	return a,b
	
a = 100
b = 200
print "Before swap A = {}  B = {} ".format(a,b)
a,b=SwapValues(a,b)
print "After swap A = {}  B = {} ".format(a,b)
