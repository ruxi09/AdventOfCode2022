# f = open("simple.txt", "r")
f = open("input_radu.txt", "r")

total = 0
# for i in range(6):
for i in range(300):
  line1 = f.readline().strip()
  line2 = f.readline().strip()
  line3 = f.readline().strip()

  set1 = set()
  for elem in line1:
    set1.add(elem)

  set2 = set()
  for elem in line2:
    set2.add(elem)

  set3 = set()
  for elem in line3:
    set3.add(elem)

  # Lowercase item types a through z have priorities 1 through 26.
  # Uppercase item types A through Z have priorities 27 through 52
  intersection = set1.intersection(set2).intersection(set3)

  if intersection is not None:
    for elem in intersection:
      if elem.islower():
        total += ord(elem) - ord('a') + 1
        print(ord(elem) - ord('a') + 1)
      else:
        total += ord(elem) - ord('A') + 27
        print(ord(elem) - ord('A') + 27)
    # print(total)

f.close()


# print(ord('L')- ord('A') + 26 +  1)