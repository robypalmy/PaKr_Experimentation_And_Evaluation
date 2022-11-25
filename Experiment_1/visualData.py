import matplotlib.pyplot as plt
import numpy as np
from matplotlib.ticker import ScalarFormatter

PassPerItem = open("intPassPerItem.txt")
UntilNoChange = open("./intUntilNoChange.txt", "r")
WhileNeeded = open("./intWhileNeeded.txt", "r")

parse1 = PassPerItem.read()
parse2 = UntilNoChange.read()
parse3 = WhileNeeded.read()

parse1 = parse1.split(',')
parse2 = parse2.split(',')
parse3 = parse3.split(',')

data1 = []
data2 = []
data3 = []

for i in range(len(parse1)):
    x1 = parse1[i];
    x2 = parse2[i];
    x3 = parse3[i];
    if("Time" in parse1[i]):
        data1.append(int(x1[6:]))
        data2.append(int(x2[6:]))
        data3.append(int(x3[6:]))


d1_10 = [[],[],[]]
d1_100 = [[],[],[]]
d1_1000 = [[],[],[]]

d2_10 = [[],[],[]]
d2_100 = [[],[],[]]
d2_1000 = [[],[],[]]

d3_10 = [[],[],[]]
d3_100 = [[],[],[]]
d3_1000 = [[],[],[]]

d4_10 = [[],[],[]]
d4_100 = [[],[],[]]
d4_1000 = [[],[],[]]

d5_10 = [[],[],[]]
d5_100 = [[],[],[]]
d5_1000 = [[],[],[]]


for i in range(len(data1)):
    if(i >= 1400 and i < 1500):
        d5_1000[0].append(data1[i])
        d5_1000[1].append(data2[i])
        d5_1000[2].append(data3[i])

    if(i >= 1300 and i < 1400):
        d5_100[0].append(data1[i])
        d5_100[1].append(data2[i])
        d5_100[2].append(data3[i])
    if(i >= 1200 and i < 1300):
        d5_10[0].append(data1[i])
        d5_10[1].append(data2[i])
        d5_10[2].append(data3[i])
    if(i >= 1100 and i < 1200):
        d4_1000[0].append(data1[i])
        d4_1000[1].append(data2[i])
        d4_1000[2].append(data3[i])
    if(i >= 1000 and i < 1100):
        d4_100[0].append(data1[i])
        d4_100[1].append(data2[i])
        d4_100[2].append(data3[i])
    if(i >= 900 and i < 1000):
        d4_10[0].append(data1[i])
        d4_10[1].append(data2[i])
        d4_10[2].append(data3[i])
    if(i >= 800 and i < 900):
        d3_1000[0].append(data1[i])
        d3_1000[1].append(data2[i])
        d3_1000[2].append(data3[i])
    if(i >= 700 and i < 800):
        d3_100[0].append(data1[i])
        d3_100[1].append(data2[i])
        d3_100[2].append(data3[i])
    if(i >= 600 and i < 700):
        d3_10[0].append(data1[i])
        d3_10[1].append(data2[i])
        d3_10[2].append(data3[i])
    if(i >= 500 and i < 600):
        d2_1000[0].append(data1[i])
        d2_1000[1].append(data2[i])
        d2_1000[2].append(data3[i])
    if(i >= 400 and i < 500):
        d2_100[0].append(data1[i])
        d2_100[1].append(data2[i])
        d2_100[2].append(data3[i])
    if(i >= 300 and i < 400):
        d2_10[0].append(data1[i])
        d2_10[1].append(data2[i])
        d2_10[2].append(data3[i])
    if(i >= 200 and i < 300):
        d1_1000[0].append(data1[i])
        d1_1000[1].append(data2[i])
        d1_1000[2].append(data3[i])
    if(i >= 100 and i <200):
        d1_100[0].append(data1[i])
        d1_100[1].append(data2[i])
        d1_100[2].append(data3[i])
    if(i <= 99):
        d1_10[0].append(data1[i])
        d1_10[1].append(data2[i])
        d1_10[2].append(data3[i])


data = [d5_1000[0],d5_1000[1],d5_1000[2]]

print(max,min)

#plot the data

fig, ax = plt.subplots()
ax.set_title('Arrays of 1000, 5 digit')
ax.boxplot(data,showfliers=False)
ax.set_xticklabels(['PPI','UNC','WN'])
ax.set_ylabel('Time in ns')
ax.set_xlabel('Algorithms')
ax.get_yaxis().get_major_formatter().set_useOffset(False)
# ax.get_yaxis().get_major_formatter().set_scientific(False)
plt.show()

# print(d1_10)
# print(len(d5_1000))
    