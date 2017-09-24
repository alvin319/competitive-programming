from collections import defaultdict

n = int(input())
m = defaultdict(int)

for _ in range(n):
	v = int(input())
	m[v] += 1

if len(m.keys()) == 2:
	m_list = list(m.keys())
	if m[m_list[0]] == m[m_list[1]]:
		print('YES')
		print('{} {}'.format(m_list[0], m_list[1]))
		exit(0)
print('NO')
