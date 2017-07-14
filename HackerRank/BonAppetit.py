def bonAppetit(n, k, b, ar):
    split = sum(ar)
    split -= ar[k]
    split /= 2
    return abs(int(split) - b) if int(split) != b else "Bon Appetit" 

n, k = input().strip().split(' ')
n, k = [int(n), int(k)]
ar = list(map(int, input().strip().split(' ')))
b = int(input().strip())
result = bonAppetit(n, k, b, ar)
print(result)