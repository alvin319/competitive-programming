size = int(input())
array = list(map(int, input().split()))
index = 0
value = 0

while index < size and array[index] > value:
    value = array[index]
    index += 1

while index < size and array[index] == value:
    index += 1

while index < size and array[index] < value:
    value = array[index]
    index += 1

print("YES" if index == size else "NO")