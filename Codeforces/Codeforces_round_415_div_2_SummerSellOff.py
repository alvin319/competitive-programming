n, f = map(int, input().split())
total = 0
data = []
ans = []
s = set()

for _ in range(n):
	k, l = map(int, input().split())
	if min(2 * k, l) != min(k, l):
		ans.append((_, min(2 * k, l) - min(k, l)))
	data.append((_, k, l))

ans = sorted(ans, key=lambda t: -t[1])
for _ in range(min(len(ans), f)):
	s.add(ans[_][0])

for t in data:
	if t[0] not in s:
		total += min(t[1], t[2])
	else:
		total += min(2 * t[1], t[2])

print(total)