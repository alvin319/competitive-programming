n = int(input())
tokens = list(map(int, input().split()))

chest = 0
bicep = 0
back = 0

for i, v in enumerate(tokens):
	if i % 3 == 0:
		chest += v
	elif i % 3 == 1:
		bicep += v
	else:
		back += v

max_value = max(chest, bicep, back)

if max_value == chest:
	print('chest')
elif max_value == bicep:
	print('biceps')
else:
	print('back')
