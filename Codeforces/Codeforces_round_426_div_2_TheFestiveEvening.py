n, k = map(int, input().split())
s = str(input())
m = {}
z = set()

for i, t in enumerate(s):
	m[t] = i

for i, t in enumerate(s):
	if m[t] != i:
		z.add(t)
		if len(z) > k:
			print('YES')
			exit()
	else:
		if t in z:
			z.remove(t)
		elif len(z) + 1 > k:
			print('YES')
			exit()

print('NO')