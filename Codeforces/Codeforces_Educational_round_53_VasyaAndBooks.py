from collections import deque

n = int(input())
stacks = deque(list(map(int, input().split())))
order = list(map(int, input().split()))
exist = set(list(stacks))
answers = []

for num in order:
	if num not in exist:
		answers.append(0)
	else:
		count = 0
		while len(stacks) > 0:
			left = stacks[0]
			count += 1
			stacks.popleft()
			exist.remove(left)

			if left == num:
				break
		answers.append(count)

print(' '.join([str(_) for _ in answers]))