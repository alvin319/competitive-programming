a, b = map(int, input().split())

c = min(a, b)

a -= c
b -= c

d = (a / 2) + (b / 2)

print("{} {}".format(c, int(d)))