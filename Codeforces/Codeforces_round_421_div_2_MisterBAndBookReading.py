c, v_0, v_1, a, l = map(int, input().split())

days = 0
multiplier = 1
while c > 0:
	if days == 0:
		c -= v_0
	else:
		c += l
		c -= min(v_1, v_0 + multiplier * a)
		multiplier += 1
	days += 1

print(days)