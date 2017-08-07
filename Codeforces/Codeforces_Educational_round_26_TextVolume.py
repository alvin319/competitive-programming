n = int(input())
s = input()
tokens = s.split(' ')

m = 0
for w in tokens:
	current = 0
	for c in w:
		if c.isupper():
			current += 1
	m = max(current, m)

print(m)