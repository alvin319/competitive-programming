n, k = map(int, input().split())

num_list = list(map(int, input().split()))

current_contest = num_list[k - 1]

left_over = list(filter(lambda x: x >= current_contest and x > 0, num_list))

print(len(left_over))
