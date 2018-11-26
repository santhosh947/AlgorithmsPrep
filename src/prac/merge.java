package prac;

import java.util.List;

import javax.xml.transform.Templates;

public class merge {

	static int[] arr;
	static int[] temp;
	static int length;

	public static void main(String[] args) {
		int[] inp = new int[] { 5, 1, 5, 1, 1, 1, 5 };// ,3,121,1,2};

		mergeSort(inp);
		for (int i : arr) {
			System.out.println(i);
		}
		// System.out.println("sorted Array :" + arr.toString());
	}

	public static void mergeSort(int[] inp) {
		length = inp.length;
		int lowIndex = 0;
		int highIndex = length - 1;
		arr = inp;
		temp = new int[length];
		domerge(lowIndex, highIndex);
	}

	private static void domerge(int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int middle = (lowIndex + highIndex) / 2;

			domerge(lowIndex, middle);
			domerge(middle + 1, highIndex);

			ActualMerge(lowIndex, middle, highIndex);
		}
	}

	private static void ActualMerge(int lowIndex, int middle, int highIndex) {
		for (int i = lowIndex; i <= highIndex; i++) {
			temp[i] = arr[i];

		}

		int i = lowIndex;
		int j = middle + 1;
		int k = lowIndex;

		while (i <= middle && j <= highIndex) {
			if (temp[i] < temp[j]) {
				arr[k] = temp[i];
				i++;
				
			} else {
				arr[k] = temp[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			arr[k] = temp[i];
			k++;
			i++;
		}
	}
}
