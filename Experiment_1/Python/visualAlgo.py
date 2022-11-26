import matplotlib.pyplot as plt
import numpy as np
from matplotlib.ticker import ScalarFormatter
import statistics

f = open("stringAlgorithmTest.txt", "r")

metadata = f.read().split(',')

wn = []
ppi = []
unc = []


for i in range(len(metadata)):
    x = metadata[i]
    if("WN" in x):
        wn.append(int(x[4:]))
    if("PPI" in x):
        ppi.append(int(x[5:]))
    if("UNC" in x):
        unc.append(int(x[5:]))

#arrays of results for each number of digits/strings

# 1 digit/character 
d1_10 = [[],[],[]]
d1_100 = [[],[],[]]
d1_1000 = [[],[],[]]

# 2 digits/characters
d2_10 = [[],[],[]]
d2_100 = [[],[],[]]
d2_1000 = [[],[],[]]

# 3 digits/characters
d3_10 = [[],[],[]]
d3_100 = [[],[],[]]
d3_1000 = [[],[],[]]

# 4 digits/characters
d4_10 = [[],[],[]]
d4_100 = [[],[],[]]
d4_1000 = [[],[],[]]

# 5 digits/characters
d5_10 = [[],[],[]]
d5_100 = [[],[],[]]
d5_1000 = [[],[],[]]




for i in range(len(wn)):
    if(i >= 1400 and i < 1500):
        d5_1000[0].append(wn[i])
        d5_1000[1].append(ppi[i])
        d5_1000[2].append(unc[i])

    if(i >= 1300 and i < 1400):
        d5_100[0].append(wn[i])
        d5_100[1].append(ppi[i])
        d5_100[2].append(unc[i])
    if(i >= 1200 and i < 1300):
        d5_10[0].append(wn[i])
        d5_10[1].append(ppi[i])
        d5_10[2].append(unc[i])
    if(i >= 1100 and i < 1200):
        d4_1000[0].append(wn[i])
        d4_1000[1].append(ppi[i])
        d4_1000[2].append(unc[i])
    if(i >= 1000 and i < 1100):
        d4_100[0].append(wn[i])
        d4_100[1].append(ppi[i])
        d4_100[2].append(unc[i])
    if(i >= 900 and i < 1000):
        d4_10[0].append(wn[i])
        d4_10[1].append(ppi[i])
        d4_10[2].append(unc[i])
    if(i >= 800 and i < 900):
        d3_1000[0].append(wn[i])
        d3_1000[1].append(ppi[i])
        d3_1000[2].append(unc[i])
    if(i >= 700 and i < 800):
        d3_100[0].append(wn[i])
        d3_100[1].append(ppi[i])
        d3_100[2].append(unc[i])
    if(i >= 600 and i < 700):
        d3_10[0].append(wn[i])
        d3_10[1].append(ppi[i])
        d3_10[2].append(unc[i])
    if(i >= 500 and i < 600):
        d2_1000[0].append(wn[i])
        d2_1000[1].append(ppi[i])
        d2_1000[2].append(unc[i])
    if(i >= 400 and i < 500):
        d2_100[0].append(wn[i])
        d2_100[1].append(ppi[i])
        d2_100[2].append(unc[i])
    if(i >= 300 and i < 400):
        d2_10[0].append(wn[i])
        d2_10[1].append(ppi[i])
        d2_10[2].append(unc[i])
    if(i >= 200 and i < 300):
        d1_1000[0].append(wn[i])
        d1_1000[1].append(ppi[i])
        d1_1000[2].append(unc[i])
    if(i >= 100 and i <200):
        d1_100[0].append(wn[i])
        d1_100[1].append(ppi[i])
        d1_100[2].append(unc[i])
    if(i <= 99):
        d1_10[0].append(wn[i])
        d1_10[1].append(ppi[i])
        d1_10[2].append(unc[i])

data = [d1_10[0],d1_10[1],d1_10[2]]

# print("Max, min and")
# for i in range(0,3):
#     print(max(d1_10[i]))
#     print(min(d1_10[i]))
#     print(statistics.mean(d1_10[i]))

#plot the data

fig, ax = plt.subplots()
ax.set_title('Arrays of 10, 1 characters')
ax.boxplot(data,showfliers=False)
ax.set_xticklabels(['WN','PPI','UNC'])
ax.set_ylabel('Time in ns')
ax.set_xlabel('Algorithms')
ax.get_yaxis().get_major_formatter().set_useOffset(False)
# ax.get_yaxis().get_major_formatter().set_scientific(False)
plt.savefig("Arrays10_1char.png")
plt.show()

    