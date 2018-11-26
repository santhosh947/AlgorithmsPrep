package prac;

public class MergeArray {

	public static void main(String[] args) {

		int[] arr1 = new int[] { 1, 2, 3, 4 };
		int[] arr2 = new int[] { 15, 16, 17, 18 };
		int[] arr3 = new int[] { 6, 7, 8, 9 };

		int[] op = merge(arr1, arr2, arr3);
		for (int i : op) {
			System.out.println(i);
		}

	}

	private static int[] merge(int[] arr1, int[] arr2, int[] arr3) {
		int total = arr1.length + arr2.length + arr3.length;
		int[] mergedArr = new int[total];
		int i = 0, j = 0, index = 0;
		int[] intermediateArray = new int[arr1.length + arr2.length];

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] > arr2[j]) {
				intermediateArray[index] = arr2[j];
				j++;
			} else {
				intermediateArray[index] = arr1[i];
				i++;
			}
			index++;
		}
		while (i < arr1.length) {
			intermediateArray[index] = arr1[i];
			index++;
			i++;
		}
		while (j < arr2.length) {
			intermediateArray[index] = arr2[j];
			index++;
			j++;
		}

		i = 0;
		j = 0;
		index = 0;
		while (i < intermediateArray.length && j < arr3.length) {
			if (intermediateArray[i] > arr3[j]) {
				mergedArr[index] = arr3[j];
				j++;
			} else {
				mergedArr[index] = intermediateArray[i];
				i++;
			}
			index++;
		}

		while (i < intermediateArray.length) {
			mergedArr[index] = intermediateArray[i];
			i++;
			index++;

		}
		while (j < arr2.length) {
			mergedArr[index] = arr3[j];
			j++;
			index++;

		}

		return mergedArr;
	}

}
