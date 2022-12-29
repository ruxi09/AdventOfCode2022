from locale import currency
import re

dir = [(1,0), (0,1), (-1,0), (0,-1)]

with open("easy.txt") as f:
  lines = f.read().splitlines()
  path = re.findall(r"(\d+|L|R)", lines[-1])
  grid = []

  for y, line in enumerate(lines[:-2]):
    grid.append([])
    for i in line:
      grid[y].append(i)

  curr_y = 0
  for i, ch in enumerate(grid[0]):
    if ch == ".":
      curr_x = i
      break
  print(curr_x)
  d = 0
  for p in path:
    if p == 'L':
      d = (d + 3) % 4
      continue
    elif p == 'R':
      d = (d + 1) % 4
      continue
    else:
      for i in range(int(p)):
        dx, dy = dir[d]
        new_x = curr_x + dx
        new_y = curr_y + dy
        if grid[new_x][new_y] == ' ':
          if dx < 0:
            new_x = 
          if dx > 0:
            new_x = 
          if dy < 0:
            new_y = 
          if dy > 0:
            new_y = 
        elif grid[new_x][new_y] == '#':
          break
        curr_x = new_x
        curr_y = new_y
  print((curr_y + 1) * 1000 + 4 * (curr_x + 1) + d)

