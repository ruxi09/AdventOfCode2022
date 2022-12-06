# f = open("easy.txt", "r")
f = open("input.txt", "r")

total = 0
# for i in range(6):
for i in range(1000):
  line = f.readline().strip().split(',')
  first = line[0].split('-') 
  fs = int(first[0])
  fe = int(first[1])
  second = line[1].split('-') 
  ss = int(second[0])
  se = int(second[1])
  if fs  <= ss and fe >= ss or ss  <= fs and se >= fs:
    print(fs,fe,ss,se)
    total += 1
print(total)
  

f.close()
