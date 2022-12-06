import re
from urllib.request import urlopen

url = "https://adventofcode.com/2022/day/4"

page = urlopen(url)
html = page.read().decode("utf-8")

pattern = "<article[\s\S]*?<\/article.*>"

match_results = re.search(pattern, html, re.IGNORECASE)
statement = match_results.group()
statement = re.sub("<.*?>", "", statement) # Remove HTML tags
print(statement)

# input_url = "https://adventofcode.com/2022/day/4/input"
# page = urlopen(input_url)
# html = page.read().decode("utf-8")
# print(html)
# pattern = "<article[\s\S]*?<\/article.*>"

# match_results = re.search(pattern, html, re.IGNORECASE)
# statement = match_results.group()
# statement = re.sub("<.*?>", "", statement) # Remove HTML tags
# print(statement)
