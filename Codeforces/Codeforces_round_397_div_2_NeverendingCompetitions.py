count = int(raw_input())
home = raw_input()
flights = []


def is_not_empty(d):
	for k in d:
		if len(d[k]) != 0:
			return True
	return False

for _ in range(count):
	flights.append(raw_input())

flight_map = {}

for f in flights:
	info = f.split('->')
	from_ = info[0]
	to_ = info[1]
	if from_ not in flight_map.keys():
		flight_map[from_] = []
	flight_map[from_].append(to_)

next_destination = flight_map[home].pop(0)

while is_not_empty(flight_map):
	if next_destination in flight_map and len(flight_map[next_destination]) != 0:
		next_destination = flight_map[next_destination].pop(0)
	else:
		print('contest')
		exit(0)

if next_destination != home:
	print('contest')
else:
	print('home')
