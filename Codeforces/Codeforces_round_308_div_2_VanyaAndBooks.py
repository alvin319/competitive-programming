num = int(input())
total = 0

for x in range(1, 11):
    if x == len(str(num)):
        total += (num - 10**(x - 1) + 1) * x
    elif x < len(str(num)):
        total += (9 * 10**(x - 1)) * x
    else:
        break

print(total)
