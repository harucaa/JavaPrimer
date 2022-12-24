# input: Rakuten review page
# output: rakuten_review.csv in the same directory
# format: score \t comment   TSV: Tab Separated Value

import requests
import lxml.html
import pandas as pd
import time
import sys
import os
from itertools import count

# INPUT_URL = "https://review.rakuten.co.jp/item/1/330517_10002841/1.1/"  # 10 pages
# INPUT_URL = "https://review.rakuten.co.jp/item/1/330517_10002630/1.1/"  # one page
# INPUT_URL = "https://review.rakuten.co.jp/item/1/330517_10003205/1.1/"  # 35
# INPUT_URL = "https://review.rakuten.co.jp/item/1/351180_10001030/1.1/"  # 74210
# INPUT_URL = "https://review.rakuten.co.jp/item/1/351180_10001229/1.1/"  # 10917
# INPUT_URL = "https://review.rakuten.co.jp/item/1/351180_10000738/1.1/"  # 6771
INPUT_URL = "https://review.rakuten.co.jp/item/1/351180_10001217/1.1/"  # 590

# 1500件=100ページまでしか表示されないらしい。
# 件数を集めるには、商品を次々と渡り歩いていくアルゴリズムが必要。


OUTPUT_FILE = os.path.dirname(__file__) + "/rakuten_review.csv"
PAGE_INTERVAL = 10  # 10 seconds


def pages(url, page_interval=PAGE_INTERVAL):
    for page in count(1):
        print()
        print(f" page {page} ".center(70, '-'))
        print("\rRetlieving reviews... ", end='')
        html = requests.get(url).text
        xml = lxml.html.fromstring(html)
        yield xml
        print("done.\r")
        # there is no link to the next page if the product item has only one page of review
        try:
            next_page = xml.find_class("revPagination")[0].xpath('a')[-1]
            #  it's done if it is the last page
            if not next_page.text.startswith('次の15件'):
                return
        except IndexError:
            return
        url = next_page.xpath('@href')[0]
        print(f"... move to the next page in {page_interval} seconds:")
        print(f"  {url}")
        time.sleep(page_interval)


# コメント内改行を""に変換、つまり、改行なしの連結に"
def reviews(xmls):
    for xml in xmls:
        reviews = xml.find_class("revRvwUserSec")
        for review in reviews:
            score = review.find_class("revUserRvwerNum value")[0].text
            comment = review.find_class("revRvwUserEntryCmt description")[0].text_content()  # the whole comment
            comment = comment.replace("\n", "")
            yield score, comment


def save(review_lines, file_name=OUTPUT_FILE, encoding='utf_8_sig'):
    print("\nPreparing the csv file to save...")
    columns = ["score", "comment"]
    df = pd.DataFrame(review_lines, columns=columns)
    df.to_csv(file_name, encoding=encoding, sep="\t")


if __name__ == '__main__':
    url = INPUT_URL if len(sys.argv) <= 1 else sys.argv[1]
    xmls = pages(url, page_interval=3)
    review_lines = reviews(xmls)
    save(review_lines, file_name=OUTPUT_FILE)
