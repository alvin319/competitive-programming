n, index = map(int, input().split())
cells = list(map(int, input().split()))

i = 1
while i <= len(cells):
	i = i + cells[i-1]
	if i == index:
		print("YES")
		exit(0)

print("NO")