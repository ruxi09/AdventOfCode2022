from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import Select
import time

browser = webdriver.Chrome(ChromeDriverManager().install())

url_skip = "https://library-calendars.ucl.ac.uk/r/new"
url = "https://library-calendars.ucl.ac.uk/r"

browser.get(url)

time.sleep(0.5)

reserve_button = browser.find_element_by_link_text("Reserve")
reserve_button.click()

time.sleep(0.5)

select_location_field = Select(browser.find_element_by_id("s-lc-location"))
select_location_field.select_by_visible_text("Student Centre")

time.sleep(0.5)

select_category_field = Select(browser.find_element_by_id("s-lc-group"))
select_category_field.select_by_visible_text("Group Study")

time.sleep(0.5)

select_capacity_field = Select(browser.find_element_by_id("s-lc-type"))
select_capacity_field.select_by_visible_text("Maximum capacity 5")

time.sleep(0.5)

#show_availability_button = browser.find_element_by_link_text("Show Availability")
show_availability_button = browser.find_element_by_id("s-lc-go")
show_availability_button.click()

show_availability_button = browser.find_element_by_class_name("fc-next-button btn btn-default btn-sm")
show_availability_button.click()
show_availability_button.click()
show_availability_button.click()


time.sleep(5)

browser.close()
