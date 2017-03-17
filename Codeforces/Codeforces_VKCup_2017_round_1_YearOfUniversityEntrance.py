n = int(input())
k = input().split(" ")
l = []

for _ in k:
	l.append(int(_))

l = sorted(l)

print(l[int(len(l) / 2)])