n, a, b = map(int, input().split())
e = 0
p = map(int, input().split())

ans = 0
for l in p:
	if l == 1:
		if a > 0:
			a -= 1
		elif b > 0:
			b -= 1
			e += 1
		elif e > 0:
			e -= 1
		else:
			ans += 1
	else:
		if b > 0:
			b -= 1
		else:
			ans += 2

print(ans) 