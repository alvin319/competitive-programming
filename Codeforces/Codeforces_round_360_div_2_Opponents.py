n, d = map(int, input().split())

current_s = ""

for i in range(n):
    current_s += "1"

current_streak = 0
max_streak = -1

for i in range(d):
    current_day = input()
    if current_day != current_s:
        current_streak += 1
    else:
        max_streak = max(current_streak, max_streak)
        current_streak = 0

max_streak = max(max_streak, current_streak)
print(max_streak)