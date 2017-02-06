l = raw_input().split()
a = int(l[0])
b = int(l[1])
c = int(l[2])

d = 0

def gcd(x, y):
	if x == 0:
		return y
	return gcd(y % x, x)

while c >= 0:
	d += 1
	if d % 2 == 1:
		c -= gcd(a, c)
	else:
		c -= gcd(b, c)

if d % 2 == 1:
	print(1)
else:
	print(0)
