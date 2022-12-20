import functools


def compare_values(v1, v2):
    if isinstance(v1, int) and isinstance(v2, int):
        return v2 - v1

    if isinstance(v1, list) and isinstance(v2, int):
        return compare_values(v1, [v2])

    if isinstance(v1, int) and isinstance(v2, list):
        return compare_values([v1], v2)

    for pair in zip(v1, v2):
        comp = compare_values(*pair)
        if comp != 0:
            return comp

    return len(v2) - len(v1)


pairs = []

with open("input_radu.txt") as f:
    for l in f.read().splitlines():
        if l != "":
            pairs.append(eval(l))

p1 = 0
pair_index = 1

for i in range(0, len(pairs), 2):
    if compare_values(pairs[i], pairs[i + 1]) > 0:
        p1 += pair_index
    pair_index += 1

print(p1)

pairs.append([[2]])
pairs.append([[6]])

pairs.sort(
    key=functools.cmp_to_key(compare_values),
    reverse=True,
)

p2 = (pairs.index([[2]]) + 1) * (pairs.index([[6]]) + 1)
print(p2)