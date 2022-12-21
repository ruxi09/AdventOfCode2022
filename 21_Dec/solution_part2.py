from os import path

def evaluate(curr):
  if curr == "humn":
    return curr
  if curr.isnumeric():
      return int(curr)
  else:
      a, op, b = curr.split(" ")
      a = evaluate(monkeys[a])
      b = evaluate(monkeys[b])
      if not isinstance(a, int) or not isinstance(b, int):
          return (a, op, b)
      if op == "*":
          return a * b
      if op == "/":
          return a // b
      if op == "+":
          return a + b
      if op == "-":
          return a - b

def find_humn_val(humn, other):
  while humn != "humn":
    a, op, b = humn
    humn, other2 = (b, a) if isinstance(a, int) else (a, b)
    if op == "*":
      other //= other2
    elif op == "+":
      other -= other2
    elif op == "-":
      if a == humn:
        other += other2
      else:
        other = other2 - other
    elif op == "/":
      if a == humn:
        other *= other2
      else:
        other = other2 // other
  return other

with open("input_radu.txt") as f:
  monkeys = {} 
  for line in f.read().splitlines():
    line = line.split(": ")
    monkeys[line[0]] = line[1]
  monkeys["humn"] = "humn"
  a, op, b =  evaluate(monkeys["root"])
  humn, other = (b, a) if isinstance(a, int) else (a, b)
  val = find_humn_val(humn, other)
  print(val)