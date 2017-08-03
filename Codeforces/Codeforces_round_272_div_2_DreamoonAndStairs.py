n, m = map(int, input().split())
ans = []
for x in range(1, n):
	if (n - x) % m == 0:
		z = (n - x) / m
		y = n - (2 * x)
		if x >= 0 and y >= 0:
			ans.append(x + y)

if len(ans) == 0:
	if n < m:
		print(-1)
	else:
		print(n)
else:
	print(min(ans))