r, c = map(int, input().split())

for _ in range(r):
    if _ % 2 == 0:
        print('#' * c)
    elif _ % 4 == 1:
        print('.' * (c - 1) + '#')
    else:
        print('#' + '.' * (c - 1))