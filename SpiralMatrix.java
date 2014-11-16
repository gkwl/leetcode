package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
    public static List<Integer> spiralMatrix(int[][] matrix) {
    	List<Integer> result = new ArrayList<Integer>();
    	if (matrix.length == 0)
    		return result;
    	
    	int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        
        int row = 0;
        int column = 0;
        int direction = 0;
        
        while (true) {
        	result.add(matrix[row][column]);
        	
        	if (direction == 0) {
            	if (column < right) {
            		column++;
            	} else {
            		if (row < bottom) {
            			direction = 1;
            			row++;
            		} else {
            			break;
            		}
            	}
        	} else if (direction == 1) {
        		if (row < bottom) {
        			row++;
        		} else {
        			if (column > left) {
	        			direction = 2;
	        			column--;
        			} else {
        				break;
        			}
        		}
        	} else if (direction == 2) {
        		if (column > left) {
        			column--;
        		} else {
        			if (row - 1 > top) {
        				direction = 3;
	        			row--;
        			} else {
        				break;
        			}
        		}
        	} else if (direction == 3) {
        		if (row - 1 > top) {
        			row--;
    			} else {
    				column++;
        			if (row < bottom && column < right) {
        				direction = 0;
        				top = top + 1;
        				left = left + 1;
        				right = right - 1;
        				bottom = bottom - 1;
        			} else {
        				break;
        			}
    			}
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(spiralMatrix(new int[][]{ {1, 2, 3}, {4, 5, 6}, {7, 8, 9} }));
	}
}
