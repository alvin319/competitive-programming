n = int(input())
d = {}
f_list = []
s = set()

for i in range(n):
	first, second = map(str, input().split(" "))
	d[first] = second
	f_list.append(first)
	s.add(second)

first = ""
for x in f_list:
	if x not in s:
		first = x
		break

answer = []
answer.append(first)
answer.append(d["0"])

for i in range(n - 2):
	counter = i + 2
	answer.append(d[answer[counter - 2]])

print(" ".join(answer))