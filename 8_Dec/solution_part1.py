from os import path

with open(path.join(path.dirname(__file__), "input.txt")) as f:
    grid = [list(map(int, line)) for line in f.read().splitlines()]
    visibles = 0

    for y in range(len(grid)):
        for x in range(len(grid[0])):
            visible = False
            c = grid[y][x]

            for i in range(x + 1, len(grid[0])):
                if grid[y][i] >= c:
                    break
            else:
                visible = True

            for i in range(x - 1, -1, -1):
                if grid[y][i] >= c:
                    break
            else:
                visible = True

            for i in range(y + 1, len(grid)):
                if grid[i][x] >= c:
                    break
            else:
                visible = True

            for i in range(y - 1, -1, -1):
                if grid[i][x] >= c:
                    break
            else:
                visible = True

            if visible:
                visibles += 1

    print("Part 1:", visibles)