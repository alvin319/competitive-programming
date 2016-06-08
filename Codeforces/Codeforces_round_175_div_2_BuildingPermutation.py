count = map(int, input())
num_list = map(int, input().split())
num_list = sorted(num_list)

start = 1
total = 0

for i in num_list:
	total += abs(start - i)
	start += 1

print(total)