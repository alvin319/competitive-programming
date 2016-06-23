n, x = map(int, input().split())

kids = 0

for i in range(n):
	array = list(input().split())
	if array[0] == '+':
		x += int(array[1])
	else:
		if x >= int(array[1]):
			x -= int(array[1])
		else:
			kids += 1

print("{} {}".format(x, kids))