package com.msrm.algorithms;

import java.util.Arrays;

import com.msrm.algorithms.util.ProgramUtil;

public class BinarySearch {

    public int searchRecursive(int[] nums, int number) {
	return search(nums, number, 0, nums.length - 1);
    }

    private int search(int[] nums, int number, int start, int end) {
	if (start > end)
	    return -1;
	int mid = start + (end - start) / 2;
	if (nums[mid] == number)
	    return mid;
	// System.out.printf("%s - (%d, %d, %d)%n", Arrays.toString(nums),
	// start, mid, end);
	if (nums[mid] > number)
	    return search(nums, number, start, mid - 1);
	else if (nums[mid] < number)
	    return search(nums, number, mid + 1, end);
	return mid;
    }

    public int searchIterative(int[] nums, int number) {
	if (nums == null || nums.length == 0)
	    return -1;
	int start = 0;
	int end = nums.length;
	while (start <= end) {
	    int mid = start + (end - start) / 2;
	    if (nums[mid] == number)
		return mid;
	    if (nums[mid] > number)
		end = mid - 1;
	    else if (nums[mid] < number)
		start = mid + 1;
	}
	return -1;
    }

    public static void main(String[] args) {
	BinarySearch bs = new BinarySearch();
	int[] nums = ProgramUtil.sortedNumbers(15);
	int[] numberToSearch = ProgramUtil.numbers(10, nums);

	for (int i = 0; i < numberToSearch.length; i++) {
	    // int res1 = bs.searchRecursive(nums, numberToSearch[i]);
	    int res2 = bs.searchIterative(nums, numberToSearch[i]);
	    if (res2 == -1)
		System.out.printf("%s - %3d NOT FOUND%n", Arrays.toString(nums), numberToSearch[i]);
	    else
		System.out.printf("%s - %3d FOUND @ %d%n", Arrays.toString(nums), numberToSearch[i], res2);
	}
    }
}
