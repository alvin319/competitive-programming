n, m = map(int, input().split())
orig = input()
test = list(orig)

for _ in range(m):
	l, r, c1, c2 = input().split()
	l, r = int(l), int(r)

	for i in range(l - 1, r):
		if test[i] == c1:
			test[i] = c2

print(''.join(test))