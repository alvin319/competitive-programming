line = input()

if line[0] != '-':
	print(line)
else:
	a = int(line[0:-1])
	b = int(line[0:-2] + str(line[-1]))
	print(max(a, b))