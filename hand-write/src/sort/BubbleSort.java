package sort;

import java.util.Arrays;

/**
 * @author allen
 * @Date 2019-11-22
 */
public class BubbleSort {
	public static void main(String[] args) {

		int[] array = new int[]{3,4,1,4,9,7,5,6,5,3,6};
		sort(array);
		System.out.println(Arrays.toString(array));


	}

	static void sort(int[] array){
		//有序区 排序次数
		for (int i = 0; i < array.length - 1 ; i++){
			//排序区
			for(int j = 0; j < array.length -1 -i; j++){
				int tmp = 0;
				if (array[j] > array[j+1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}

		}
	}
}
