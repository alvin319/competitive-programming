count = int(input())
l = list(map(int, input().split(" ")))
l = sorted(l)

b_i = len(l) - 1
n_i = len(l) - 1
b = sum(l[0: b_i])
n = sum(l[n_i: len(l)])

while b >= n:
	b_i -= 1
	n_i -= 1
	b = sum(l[0: b_i])
	n = sum(l[n_i: len(l)])

print(len(l) - n_i)