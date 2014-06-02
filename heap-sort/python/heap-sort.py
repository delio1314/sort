#!/usr/bin/python
#coding:utf8

def swap(list, i, j):
    temp = list[i]
    list[i] = list[j]
    list[j] = temp

def findLeft(i):
    return 2*i+1

def findRight(i):
    return 2*i+2

def keepMaxHeap(list, i, heapSize):
    left = findLeft(i)
    right = findRight(i)
    max = i
    if left <= heapSize and list[left] > list[max]:
	max = left
    if right <= heapSize and list[right] > list[max]:
	max = right
    if max != i:
	swap(list, i, max)
	keepMaxHeap(list, max, heapSize)

def heapSort(list):
    length = len(list)
    for i in range(length/2, -1, -1):
        keepMaxHeap(list, i, length-1)
    for i in range(length-1, 0, -1):
	swap(list, 0, i)
	keepMaxHeap(list, 0, i-1)

list = [4, 2, 8, 5, 7, 0, 3, 9, 1, 6]

print 'before heap sort: ', list

heapSort(list)

print 'after heap sort: ', list

