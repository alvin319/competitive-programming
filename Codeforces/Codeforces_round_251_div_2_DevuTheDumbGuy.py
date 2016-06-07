n, x = map(int, input().split())
num_list = list(map(int, input().split()))
num_list = sorted(num_list)

total = 0
for i in num_list:
    total += (i * x)
    if x > 1:
        x -= 1

print(total)
