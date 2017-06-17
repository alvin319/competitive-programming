matrix = [list(map(int, input().split())) for _ in range(4)]

p1 = any([matrix[0][1], matrix[0][2], matrix[0][0], matrix[1][0], matrix[2][1], matrix[3][2]])
p2 = any([matrix[0][2], matrix[1][0], matrix[1][2], matrix[1][1], matrix[2][0], matrix[3][1]])
p3 = any([matrix[0][1], matrix[1][2], matrix[2][0], matrix[2][1], matrix[2][2], matrix[3][0]])
p4 = any([matrix[0][0], matrix[1][1], matrix[2][2], matrix[3][0], matrix[3][1], matrix[3][2]])

if (matrix[0][3] and p1) or (matrix[1][3] and p2) or (matrix[2][3] and p3) or (matrix[3][3] and p4):
	print('Yes')
else:
    print('NO')