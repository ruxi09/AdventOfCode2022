# f = open("easy.txt", "r")
f = open("input.txt", "r")

lines = 0
cranes = {}

while True:
  line = f.readline()
  if line.split():
    n = 4
    chunks = [line[i:i+n] for i in range(0, len(line), n)]
    idx = 1
    for c in chunks:
      if c.strip() != '' and not c[1:2].isnumeric():
        if idx in cranes:
          cranes[idx].append(c[1:2])
        else:
          cranes[idx] = [c[1:2]]
      idx += 1
  else:
    break
 

for c,v in cranes.items():
  v = v.reverse()

print(cranes)
while True:
  line = f.readline()
  # print(line)
  if line.split():
    line = line.strip().split(' ')
    c = []
    for l in line:
      if l.isnumeric():
        c.append(int(l))
    print(c)
    moves = cranes[c[1]][len(cranes[c[1]]) - c[0]:]
    print(type(moves))
    print(moves)
    cranes[c[1]] =  cranes[c[1]][:len(cranes[c[1]]) - c[0]]
    print(cranes[c[1]])
    cranes[c[2]].extend(moves)
    print(cranes)
    print("------------")
  else:
    break 

r = []
for i in range(1,len(cranes)+1):
  r.append(cranes[i][-1])

print("RESULT", ''.join(r))

f.close()
