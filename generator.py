import os

directory = "test"

dir_names = ["{}_Dec".format(i) for i in range(5,26)]
file_names = ["easy.txt", "input.txt", "Part1.txt","Part2.txt"]
print(dir_names)

# Parent Directory path
parent_dir = "/Users/ruxi/Desktop/AdventOfCode"
  
# Path
path_dir = os.path.join(parent_dir, directory)
# a = os.listdir(parent_dir)
# print(a)

os.mkdir(path_dir)

os.chdir(path_dir)

for dir in dir_names:
  path = os.path.join(path_dir, dir)
  os.mkdir(path)
  # Create solution files
  os.chdir(path)
  for i in range(2):
    f = open("solution_part{}.py".format(i + 1), "x")
    text = '''
f = open("easy.txt", "r")
# f = open("input.txt", "r")

for i in range():
# for i in range():
  pass

f.close()'''
    f.write(text)
    f.close()
  
  # Create input files and problem statement files
  for file in file_names:
    f = open(file, "x")
    f.close()
  os.chdir(path_dir)
  

