line = raw_input()
total = 0
result = 1

for c in line:
	if c == 'b':
		total += (result - 1) % 1000000007
	else:
		result = (result * 2) % 1000000007

print(total % 1000000007)