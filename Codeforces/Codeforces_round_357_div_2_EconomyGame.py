n = int(input())

at_best = 1000

for i in range(0, at_best):
	for j in range(0, at_best):
		current = (i * 1234567) + (j * 123456)
		remain = n - current
		if (n % 1234 == 0) or (current == n) or (remain % 1234 == 0 and remain > 0):
			print("YES")
			quit()

print("NO")