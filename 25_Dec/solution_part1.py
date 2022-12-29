D = {'0': 0, '1': 1, '2': 2, '-': -1, '=': -2}
E = {0: '0', 1: '1', 2: '2', -1: '-', -2: '='}

def decrypt(n):
  r = 0
  for c in n.strip():
    r = 5 * r + D[c]
  return r

def encrypt(n):
  s = []
  while n:
    s.append(E[n%5 - 5*(n%5>2)])
    n = n//5 + (n%5>2)
  return ''.join(s[::-1])

def solve():
  s = 0
  for x in open("input_radu.txt").read().strip().split("\n"):
    s += decrypt(x)
  print(encrypt(s))

solve()