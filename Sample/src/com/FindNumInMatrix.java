package com;

import java.util.Arrays;

public class FindNumInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{4,1,11,7},
				{3,6,9,16},
				{2,5,8,12},
				{13,10,17,14}
		};
		int target = 5;
		int [][] sortedMatrix = sortMatrix(matrix);
		boolean res = searchMatrix(matrix,target);
		
		
		
		
		
		
		
		
//		boolean res = searchMatrix(matrix,target);
		System.out.println("match found" + res);

	}

	private static int[][] sortMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		//convert matrix in one dimensional
		int[] flat = new int[rows * cols];
		int index = 0;
		for(int [] row : matrix) {
			for(int num : row) {
				flat[index++] = num;
			}
		}
//		for(int i=0;i<flat.length;i++) {
//			System.out.println(flat[i]);
//		}
		//sort the array
		Arrays.sort(flat);
		//convert 1D into 2D array
		index = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				matrix[i][j] = flat[index++];
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.println(matrix[i][j]+ "");
			}
		}
		return matrix;
	}

	private static boolean searchMatrix(int[][] matrix, int target) {
		// TODO Auto-generated method stub
		if(matrix == null||matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		int rows = matrix.length;
		System.out.println("rows "+rows);
		int cols = matrix[0].length;
		System.out.println("col "+cols);
		
		int row = 0;
		int col = cols - 1;
		
		while(row < rows && col >= 0) {
			if(matrix[row][col] == target) {
				System.out.println("Roww"+row);
				System.out.println("Coll"+col);
				return true;
			}else if(matrix[row][col] > target) {
				col --;
			}else {
				row ++;
			}
		}
		
		return false;
	}

}
