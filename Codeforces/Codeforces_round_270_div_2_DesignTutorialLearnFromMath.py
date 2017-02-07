num = int(input())

if num % 2 == 0:
	answer = num - 8
else:
	answer = num - 9

print(answer, num - answer)