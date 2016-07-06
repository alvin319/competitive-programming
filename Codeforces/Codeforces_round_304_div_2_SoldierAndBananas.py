k, n, w = map(int, input().split())

total_amount = int((w * (w + 1)) / 2)

print((total_amount * k) - n if (total_amount * k) - n >= 0 else 0)