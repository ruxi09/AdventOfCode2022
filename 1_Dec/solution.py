f = open("input.txt", "r")
# f = open("easy_input.txt", "r")
curr_quantity = 0
l = []

# for i in range(14): 
for i in range(2248):
  line = f.readline()
  if line != "\n" and line != '':
    curr_quantity += int(line)
  else:
    l.append(curr_quantity)
    curr_quantity = 0

l = sorted(l)
print(sum(l[(len(l) - 3):]))


