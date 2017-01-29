n = int(input())
a = []
b = []
answer = 0

for i in range(n):
	x, y = map(int, input().split())
	a.append(x)
	b.append(y)

for i in range(n):
	for j in range(n): 
		if a[i] == b[j]:
			answer+=1

print(answer)