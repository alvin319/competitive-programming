n, a, b = map(int, input().split())

l = []

for _ in range(n):
	l.append(0)

for _ in range(n - 1, n - b - 2, -1):
	l[_] = 1

for _ in range(a):
	l[_] = -1

ans = 0

for _ in l:
	if _ == 1:
		ans += 1

print(ans)