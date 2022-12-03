# f = open("simple.txt", "r")
f = open("input.txt", "r")

total = 0
# for i in range(6):
for i in range(300):
  line = f.readline()
  part1 = line[:(len(line)//2)]

  set1 = set()
  for elem in part1:
    set1.add(elem)

  part2 = line[(len(line))//2 :]
  set2 = set()
  for elem in part2:
    set2.add(elem)

  intersection = set1.intersection(set2)

  # Lowercase item types a through z have priorities 1 through 26.
  # Uppercase item types A through Z have priorities 27 through 52
  for elem in intersection:
    if elem.islower():
      total += ord(elem) - ord('a') + 1
    else:
      total += ord(elem) - ord('A') + 27
  # print(intersection)

print(total)


f.close()
