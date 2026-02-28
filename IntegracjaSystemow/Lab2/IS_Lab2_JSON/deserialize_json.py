# -*- coding: utf-8 -*-
"""
deserialize json
"""
import json
from collections import defaultdict


class DeserializeJson:
    def __init__(self, source):
        print("let's deserialize something")

        if isinstance(source, str):  # Jeśli to ścieżka do pliku
            with open(source, encoding="utf8") as tempdata:
                self.data = json.load(tempdata)
        elif isinstance(source, dict):  # Jeśli to już załadowany JSON jako obiekt
            self.data = source
        else:
            raise ValueError("Unsupported data source type")

        self.data = self.data["baza teleadresowa jst"]

    # przykładowe statystyki
    """
    def somestats(self):
        example_stat = 0
        for dep in self.data:
            # print(type(dep), dep)
            if dep['typ_JST'] == 'GM' and dep['Województwo'] == 'dolnośląskie':
                example_stat += 1
                print('liczba urzędów miejskich w województwie dolnośląskim: ' + ' ' + str(example_stat))
    """

    def somestats(self):
        stats = defaultdict(lambda: defaultdict(int))

        for dep in self.data:
            wojewodztwo = dep["Województwo"].strip().title()
            typ_jst = dep["typ_JST"]
            stats[wojewodztwo][typ_jst] += 1

        for woj, typy in stats.items():
            print(f"\nWojewództwo: {woj}")
            for typ, liczba in typy.items():
                print(f"  - {typ}: {liczba}")