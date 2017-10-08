a, b = map(int, input().split())

if a == b:
	print(1)
elif a > b:
	print(0)
else:
	diff = b - a - 1
	if diff >= 5:
		print(0)
	else:
		l = [x for x in range(b, b - diff - 1, -1)]
		c = 1
		for x in l:
			c *= x
		print('{}'.format(c)[-1])

