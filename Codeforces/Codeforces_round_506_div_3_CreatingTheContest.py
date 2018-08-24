from collections import deque

num = map(int, input().split())
values = list(map(int, input().split()))

best_value = 0
queue = deque()

for i, value in enumerate(values):
    if len(queue) == 0:
        queue.append(value)
        best_value = 1
    else:
        peek = queue[-1]

        if value <= (2 * peek):
            queue.append(value)
        else:
            queue.clear()
            queue.append(value)

        best_value = max(best_value, len(queue))

print(max(best_value, len(queue)))