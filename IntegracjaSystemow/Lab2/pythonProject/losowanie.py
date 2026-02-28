import random

def losuj_pary(tier1, tier2):
    random.shuffle(tier1)
    random.shuffle(tier2)
    pary = list(zip(tier1, tier2))
    return pary


tier1 = ["Krecik", "Kamil", "Velon", "", "Gracz5_T1", "Gracz6_T1", "Gracz7_T1", "Gracz8_T1"]
tier2 = ["Gracz1_T2", "Gracz2_T2", "Gracz3_T2", "Gracz4_T2", "Gracz5_T2", "Gracz6_T2", "Gracz7_T2", "Gracz8_T2"]

pary = losuj_pary(tier1, tier2)

print("Wylosowane pary:")
for gracz1, gracz2 in pary:
    print(f"{gracz1} - {gracz2}")
