n, k = map(int, input().split())
line = input()
m = {}

for w in line:
	if w not in m:
		m[w] = 0
	m[w] += 1

l = -1
for v in m:
	l = max(l, m[v])

if l > k:
	print('NO')
else:
	print('YES')