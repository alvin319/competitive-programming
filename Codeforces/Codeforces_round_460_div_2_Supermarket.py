n, m = map(int, input().split())
min_ = float('inf')

for _ in range(n):
	a, b = map(int, input().split())
	cost = (float(a) / b) * m
	min_ = min(min_, cost)

print(min_)