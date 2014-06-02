#!/usr/bin/python
#coding:utf8

def bubbleSort(list):
    i = 0
    ordered = False
    while i<len(list)-2 and not ordered:
	ordered = True
	j = len(list)-1
	while j > i:
	    if list[j] < list[j-1]:
		ordered = False
		temp = list[j]
		list[j] = list[j-1]
		list[j-1] = temp
	    j-=1
	i+=1

list = [4, 1, 2, 9, 6, 5, 0, 8, 3, 7]

print 'before bubble sort: ', list

bubbleSort(list)

print 'after bubble sort: ', list

