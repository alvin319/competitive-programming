n, m = map(int, input().split(' '))

ans = []

def recursion(steps, current_moves, multi_moves):
	if current_moves % multi_moves == 0 and steps == 0:
		ans.append(current_moves)
	elif steps > 0:
		recursion(steps - 1, current_moves + 1, multi_moves)
		recursion(steps - 2, current_moves + 1, multi_moves)

recursion(n, 0, m)
if len(ans) == 0:
	print(-1)
else:
	print(min(ans))