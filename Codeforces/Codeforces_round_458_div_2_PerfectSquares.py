import math

n = int(input())
nums = list(map(int, input().split()))

best = float('-inf')

for v in nums:
	good = True
	for i in range(1002):
		if i ** 2 == v:
			good = False
			break

	if good:
		best = max(best, v)

print(best)