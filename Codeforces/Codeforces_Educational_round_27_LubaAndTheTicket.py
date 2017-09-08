num = input()
l = [int(_) for _ in num]

if sum(l[3:]) > sum(l[:3]):
	l[:3], l[3:] = l[3:], l[:3]

l[:3] = sorted(l[:3], reverse=True)
l[3:] = sorted(l[3:], reverse=True)

answer = 0
i = 0
j = 5

while sum(l[:3]) > sum(l[3:]):
	answer += 1
	if l[i] > 9 - l[j]:
		l[i] = 0
		i += 1
	else:
		l[j] = 9
		j -= 1

print(answer)