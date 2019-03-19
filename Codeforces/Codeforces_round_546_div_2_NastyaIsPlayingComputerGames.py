n, k = map(int, input().split())
index = k - 1

# opening the holes
total_move = n

# Going to the closer side and then go back to the other end
short_move = min(index, n - index - 1)
total_move += short_move + (n - 1)

# throwing the rocks
total_move += 3 + max(0, n - 2)

print(total_move)