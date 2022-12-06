# rakuten_review_getter.py
# output: rakuten_review.csv
# format: score, date, comment

import requests
import lxml.html
import pandas as pd
import time
import sys
from itertools import count


URL = "https://review.rakuten.co.jp/item/1/330517_10002841/1.1/"


def pages(url, page_interval=30):
    for page in count(1):
        print()
        print(f" page {page} ".center(70, '-'))
        print("\rRetlieving reviews... ", end='')
        html = requests.get(url).text
        xml = lxml.html.fromstring(html)
        yield xml
        print("done.\r")
        next_page = xml.find_class("revPagination")[0].xpath('a')[-1]
        if not next_page.text.startswith('次の15件'):
            return
        url = next_page.xpath('@href')[0]
        print(f"... move to the next page in {page_interval} seconds:")
        print(f"  {url}")
        time.sleep(page_interval)


def reviews(xmls):
    for xml in xmls:
        reviews = xml.find_class("revRvwUserMain")
        for review in reviews:
            score = review.find_class("revUserRvwerNum value")[0].text
            comment = review.find_class("revRvwUserEntryCmt description")[0].text
            date_reviewed = review.find_class("revUserEntryDate dtreviewed")[0].text
            yield score, date_reviewed, comment


def save(review_lines, file_name="rakuten_review.csv", encoding='utf_8_sig'):
    print("\nPreparing the csv file to save...")
    columns = ["score", "date_reviewed", "comment"]
    df = pd.DataFrame(review_lines, columns=columns)
    df.to_csv(file_name, encoding=encoding)


def main():
    url = URL if len(sys.argv) <= 1 else sys.argv[1]
    xmls = pages(url)
    review_lines = reviews(xmls)
    save(review_lines)


if __name__ == '__main__':
    main()
