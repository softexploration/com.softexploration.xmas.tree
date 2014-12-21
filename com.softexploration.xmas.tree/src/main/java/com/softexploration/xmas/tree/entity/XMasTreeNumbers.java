package com.softexploration.xmas.tree.entity;

public class XMasTreeNumbers {

	public static int getNumberFromPascalTriangle(final int row,
			final int column) {
		if (column == 0 || column == row) {
			return 1;
		} else {
			return getNumberFromPascalTriangle(row - 1, column - 1)
					+ getNumberFromPascalTriangle(row - 1, column);
		}
	}

	public static boolean isEvenNumber(final int number) {
		return number % 2 == 0;
	}
}
