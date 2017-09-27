n = int(input())
line = input()

s = set()
l = -1
index = 0

while index < len(line):
	if line[index].lower() == line[index]:
		s.add(line[index])
	else:
		l = max(l, len(s))
		s.clear()
	index += 1

print(max(l, len(s)))