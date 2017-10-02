n = int(input())
line = input()

in_sf = line[0] == 'F'
sf_seattle = 0
seattle_sf = 0

for v in line[1:]:
	if v == 'F' and not in_sf:
		in_sf = True
		seattle_sf += 1
	elif v == 'S' and in_sf:
		sf_seattle += 1
		in_sf = False

if seattle_sf > sf_seattle:
	print('YES')
else:
	print('NO')