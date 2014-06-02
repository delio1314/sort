#!/usr/bin/python
#coding:utf8

def selectionSort(list) :
    for i in range (len(list)-1) :
	min = i
	for j in range(i+1, len(list)) :
	    if list[min] > list[j] :
		min = j
	temp = list[i]
	list[i] = list[min]
	list[min] = temp

list = [4, 2, 8, 5, 7, 0, 3, 9, 1, 6]

print 'before selection sort: ', list

selectionSort(list)

print 'after selection sort: ', list
