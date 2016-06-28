current_s = input()

array = ['h', 'e', 'l', 'l', 'o']

index = 0

for i in range(len(current_s)):
	if current_s[i] == array[index]:
		print(array[index])
		index += 1
		print(current_s[i: ])
	if index == len(array):
		print("YES")
		quit()

print("NO")
quit()