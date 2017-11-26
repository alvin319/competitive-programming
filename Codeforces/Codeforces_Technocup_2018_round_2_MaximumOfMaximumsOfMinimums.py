from collections import deque

n, k = map(int, input().split())
nums = list(map(int, input().split()))

if k == 1:
	print(min(nums))
elif k == 2:
	prefix = []
	postfix = deque()
	current = float('inf')
	for i in nums:
		current = min(i, current)
		prefix.append(current)
	current = float('inf')
	for i in range(len(nums) - 1, -1, -1):
		current = min(current, nums[i])
		postfix.appendleft(current)
	best = float('-inf')
	for i in range(len(nums)):
		best = max(best, max(prefix[i], postfix[i]))
	print(best)
else:
	print(max(nums))