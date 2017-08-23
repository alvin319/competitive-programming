n, t = map(int, input().split())

num = ''

for _ in range(0, n - len(str(t))):
	num += '0'

num = str(t) + num

if len(num) != n:
	print(-1)
else:
	print(num)