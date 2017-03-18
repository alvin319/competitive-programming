n = int(input())

d = {}
l = []
m = None

for _ in range(n):
    info = input().split()
    score = int(info[1])
    name = info[0]

    if name in d:
        d[name] += score
    else:
        d[name] = score

    l.append([name, d[name]])

m = max(d.values())

for [win, s] in l:
    if d[win] == m and s >= m:
        print(win)
        break