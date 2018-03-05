n = map(int, input().split())
nums = list(map(int, input().split()))
nums = sorted(nums)
stopped_index = 0

for i, v in enumerate(nums):
	if v <= 0:
		stopped_index += 1
	else:
		break

print(sum(nums[stopped_index:]) - sum(nums[0:stopped_index]))