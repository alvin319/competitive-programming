n = int(input())
p = list(map(int, input().split()))
total = sum(p)
m = int(input())
t = -1

for _ in range(m):
	s, e = map(int, input().split())
	if (s <= total and e >= total):
		t = total
		break
	elif min(s, e) >= total:
		t = s
		break

print(t)