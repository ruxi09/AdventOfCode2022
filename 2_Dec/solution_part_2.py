# f = open("easy.txt", "r")
f = open("input.txt", "r")

# opp -> A for Rock, B for Paper, and C for Scissors
# you -> X  Rock, Y for Paper, and Z for Scissors
# 1 for Rock, 2 for Paper, and 3 for Scissors
# 0 if you lost, 3 if the round was a draw, and 6 if you won

# X means you need to lose,
# Y means you need to end the round in a draw
# Z means you need to win

total = 0
val = {'X': 1, 'Y': 2, 'Z': 3}
decode = {'A':'X', 'B':'Y', 'C':'Z'}
beats = {'C':'Y', 'A':'Z', 'B':'X'}
beaten_by = {'C':'X', 'A':'Y', 'B':'Z'}

for i in range(2500):
# for i in range(3):
  line = f.readline()
  line = line.strip().split(" ")
  outcome = line[1]
  opp = line[0]
  if outcome == 'X':
    total += (val[beats[opp]])
  elif outcome == 'Y':
    total += (3 + val[decode[opp]])
  else:
    total += (6 + val[beaten_by[opp]])
  
  
print(total)

f.close()