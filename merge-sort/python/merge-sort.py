#!/usr/bin/python
#coding:utf8

def merge(list, left, mid, right):
    leftIndex = left
    rightIndex = mid + 1
    index = 0
    tempList = range(right - left + 1)
    while leftIndex <= mid and rightIndex <= right:
        if (list[leftIndex] <= list[rightIndex]):
            tempList[index] = list[leftIndex]
            leftIndex += 1
        else:
            tempList[index] = list[rightIndex]
            rightIndex += 1
        index += 1
    while leftIndex <= mid:
        tempList[index] = list[leftIndex]
        leftIndex += 1
        index += 1
    while rightIndex <= right:
        tempList[index] = list[rightIndex]
        rightIndex += 1
        index += 1
    for i in range(left, right + 1):
        list[i] = tempList[i - left]

def mergeSortRecursion(list, left, right):
    if left >= right:
        return;
    mid = (left + right) / 2
    mergeSortRecursion(list, left, mid)
    mergeSortRecursion(list, mid + 1, right)
    merge(list, left, mid, right)

def mergeSort(list):
    mergeSortRecursion(list, 0, len(list) - 1)

list = [4, 2, 8, 5, 7, 0, 3, 9, 1, 6]

print 'before merge sort: ', list

mergeSort(list)

print 'after merge sort: ', list


   
