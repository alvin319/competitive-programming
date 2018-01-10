a, b = map(int, input().split())
x, y, z = map(int, input().split())

yellow, blue = 0, 0

yellow += x * 2
yellow += y
blue += y
blue += 3 * z

y_need = max(0, yellow - a)
b_need = max(0, blue - b) 
print(y_need + b_need)