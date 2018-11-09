n = int(input())
choices = {}

def get_price(pick, choices):
	if pick not in choices:
		return -1
	return choices[pick]

for _ in range(n):
	price, line = input().split()
	price = int(price)
	line = ''.join(sorted(line))

	if line not in choices:
		choices[line] = price
	else:
		choices[line] = min(choices[line], price)

cheapest = float('inf')

for path in [['A', 'BC'], ['AB', 'C'], ['AC', 'B'], ['A', 'B', 'C'], ['ABC'], ['AB', 'BC'], ['AB', 'AC'], ['AC', 'BC']]:
	cost = 0
	failed = False

	for option in path:
		price = get_price(option, choices)

		if price == -1:
			failed = True
			break
		else:
			cost += price

	if not failed:
		cheapest = min(cheapest, cost)

if cheapest != float('inf'):
	print(cheapest)
else:
	print(-1)