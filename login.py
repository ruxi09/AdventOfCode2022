import requests
from dotenv import load_dotenv
import os

# load_dotenv()

env_var = os.environ
  
# Print the list of user's
# environment variables
print("User's Environment variable:")
print(dict(env_var))

# AOC_COOKIE = os.environ['AOC_COOKIE']   # Connection cookie from https://adventofcode.com/ ("session" cookie)
# AUTHOR = os.environ['AUTHOR'] 

# url = "https://adventofcode.com/2022/day/4/input"
# r = requests.get(url=url, cookies={"session": AOC_COOKIE})

# print(r.content)