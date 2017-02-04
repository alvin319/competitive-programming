a = raw_input()
b = raw_input()
x = int(a, 2) ^ int(b, 2)
answer = '{0:b}'.format(x)

for i in range(len(b) - len(answer)):
	answer = "0" + answer

print(answer)