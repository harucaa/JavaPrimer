# enlarge eclipse icons
import os
from PIL import Image

SIZE_FROM = 16
SIZE_TO = 26

old_path = ""
for path, dirs, files in os.walk(r"C:\pleiades\2022-09\eclipse"):
    for file in files:
        file_path = os.path.join(path, file)
        for ext in ".gif .png".split(" "):
            if (ext == file_path[-4:]):
                img = Image.open(file_path)
                if img.size == (SIZE_FROM, SIZE_FROM):
                    if (path != old_path):
                        print("\n", path)
                        old_path = path
                    print(img.size[0], img.size[1], "\t", file)
                    img = img.resize(size=(SIZE_TO, SIZE_TO), resample=Image.LANCZOS)
                    img.save(file_path)
# print("\n{}-pixel icons enlarged to {}.".format(SIZE_FROM, SIZE_TO))
