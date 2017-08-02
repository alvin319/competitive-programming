n, k = map(int, raw_input().split())
n /= k

if n == 1:
	print('YES')
else:
	if n % 2 == 0:
		print('NO')
	else:
		print('YES')
