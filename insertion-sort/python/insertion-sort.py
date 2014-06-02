#!/usr/bin/python

list = [7, 4, 3, 5, 8, 6, 0, 9, 2, 1]

print 'before insertion sort: ', list

# for i in range(1, len(list)) :
#     temp = list[i]
#     j = i - 1
#     while j >= 0 and temp < list[j] :
# 	list[j+1] = list[j]
# 	j -= 1
#     list[j+1] = temp

def insertionSort(list) :
    for i in range(1, len(list)) :
        temp = list[i]
        j = i
        while j > 0 and temp < list[j-1] :
            list[j] = list[j-1]
            j -= 1
        list[j] = temp

insertionSort(list)

print 'after insertion sort: ', list   
