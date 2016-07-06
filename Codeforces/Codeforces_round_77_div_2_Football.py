current_s = input()

count0 = 0
count1 = 0

mode = None

if current_s[0] == '0':
	count0 += 1
	mode = False
else:
	count1 += 1
	mode = True

for i in range(1, len(current_s)):
	if current_s[i] == '0' and not mode:
		count0 += 1
	elif current_s[i] == '0' and mode:
		count1 = 0
		mode = False
		count0 = 1
	elif current_s[i] == '1' and mode:
		count1 += 1
	elif current_s[i] == '1' and not mode:
		mode = True
		count1 = 1
		count0 = 0

	if count1 >= 7 or count0 >= 7:
		print("YES")
		quit()

print("NO")