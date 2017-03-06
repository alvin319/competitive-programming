n = int(input())
l = list(map(int, input().split()))

mask = [0] * (n + 1)
index = n

for i in l:
    mask[i] = 1
    while mask[index] == 1:
    	print("{} ".format(index), end='')
    	index -= 1
    print()