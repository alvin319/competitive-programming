n = int(input())
num_list = list(map(int, input().split()))
operations = int(input())

total = 0
n_prefix_list = []
for i in num_list:
	n_prefix_list.append(total + i)
	total += i

total = 0
s_prefix_list = []
s_list = sorted(num_list)

for i in s_list:
	s_prefix_list.append(total + i)
	total += i

for i in range(operations):
	op_list = list(map(int, input().split()))
	left = op_list[1]
	right = op_list[2]
	if op_list[0] == 1:
		print(n_prefix_list[right - 1] - n_prefix_list[left - 1] + num_list[left - 1])
	else:
		print(s_prefix_list[right - 1] - s_prefix_list[left - 1] + s_list[left - 1])