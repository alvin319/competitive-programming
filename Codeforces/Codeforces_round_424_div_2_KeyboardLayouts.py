first = input()
second = input()
request = input()

first_d = {}
second_d = {}

for _, c in enumerate(first):
	first_d[c] = _

for _, c in enumerate(second):
	second_d[_] = c

ans = ""

for c in request:
	lower_c = c.lower()
	if lower_c not in first:
		ans += c
	else:
		corr_c = second_d[first_d[lower_c]]
		if c.lower() == c:
			ans += corr_c
		else:
			ans += corr_c.upper()

print(ans)