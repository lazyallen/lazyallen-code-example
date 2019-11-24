package sort;

import java.util.Arrays;

/**
 * @author allen
 * @Date 2019-11-24
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] array = new int[]{3,4,1,4,9,7,5,6,5,3,6};
		quickSort(array,0,array.length -1);
		System.out.println(Arrays.toString(array));
	}

	public static void quickSort(int[] array,int startIndex,int endIndex){
		if (startIndex>=endIndex) {
			return;
		}
		int pivot = partition(array,startIndex,endIndex);
		//递归基准左边
		quickSort(array,startIndex,pivot -1);
		//递归基准右边
		quickSort(array,pivot + 1,endIndex);

	}

	public static int partition(int[] array,int startIndex,int endIndex){
		int pivot = array[startIndex];
		int left = startIndex;
		int right = endIndex;
		while (left!=right){
			//从右往左移，找到比pivot小的为止
			while (left<right && array[right] > pivot){
				right--;
			}
			//从左往右移，找到比pivot大的为止
			while (left<right && array[left] <= pivot){
				left++;
			}
			//交换left right
			if (left < right) {
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
			}
		}
		//交换基准pivot和left
		array[startIndex] = array[left];
		array[left] = pivot;
		return left;

	}
}
