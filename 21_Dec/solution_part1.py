from os import path

def evaluate(curr):
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


with open("input_radu.txt") as f:
  monkeys = {}
  for line in f.read().splitlines():
    line = line.split(": ")
    monkeys[line[0]] = line[1]
  p1 =  evaluate(monkeys["root"])
  print(p1)