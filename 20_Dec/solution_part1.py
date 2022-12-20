def move(nums, i):
  p, val = [(pos, v) for pos, v in enumerate(nums) if v[0] == i][0]
  nums.pop(p)
  nums.insert((p + val[1]) % len(nums), val)
  return nums

def solve():
  elems_idx = []
  idx = 0
  zeros = None

  for x in open("input_radu.txt").read().strip().split("\n"):
    if int(x) == 0:
      zeros = (idx, int(x))
    elems_idx.append((idx, int(x)))
    idx += 1

  for i in range(len(elems_idx)):
      elems_idx = move(elems_idx, i)

  print(sum(elems_idx[(elems_idx.index(zeros) + c) % len(elems_idx)][1] for c in [1000, 2000, 3000]))

solve()