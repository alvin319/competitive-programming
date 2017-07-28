s, v1, v2, t1, t2 = map(int, input().split())
first = t1 + v1 * s + t1
second = t2 + v2 * s + t2

if first < second:
	print('First')
elif first > second:
	print('Second')
else:
	print('Friendship')