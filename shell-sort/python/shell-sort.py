#!/usr/bin/python
#coding:utf8

def shellSort(list):
    d = len(list)/2
    while d > 0:
	for i in range(len(list)):
	    temp = list[i]
	    j = i-d
	    while j >= 0 and list[j] > temp:
		list[j+d] = list[j]
		j-=d
	    list[j+d] = temp
	d/=2

list = [4, 2, 8, 5, 7, 0, 3, 9, 1, 6]

print 'before shell sort: ', list

shellSort(list)

print 'after shell sort: ', list

