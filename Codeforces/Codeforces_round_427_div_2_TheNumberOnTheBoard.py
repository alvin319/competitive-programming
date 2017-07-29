k = int(input())
s = str(input())
t = 0

for c in s:
	t += int(c)

if t > k or (k - t) == 0:
	print(0)
else:
	diff = k - t
	ans = 0
	s = sorted(s)
	for c in s:
		if int(c) != 9:
			ans += 1
			diff -= 9 - int(c)
		if diff <= 0:
			break
	print(ans)