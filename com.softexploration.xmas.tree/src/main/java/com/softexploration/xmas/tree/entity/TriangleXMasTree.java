package com.softexploration.xmas.tree.entity;

import java.io.PrintStream;

/**
 * XMasTree implementation with an idea of Pascal's Triangle and Sierpinski
 * triangle to draw the tree
 *
 */
public class TriangleXMasTree extends XMasTree {

	public static final int STAR_ALTITUDE = 1;
	public static final String ITEM_FOR_STAR = "*";
	public static final String ITEM_FOR_ODD_NUMBER = "^";
	public static final String ITEM_FOR_EVEN_NUMBER = "@";

	private final int treeAltitude;

	/**
	 * 
	 * @param totalAltitude
	 *            - total altitude of the tree including a star on the top.
	 *            Allowed values: [2..Integer.MAX_VALUE]
	 */
	public TriangleXMasTree(final int totalAltitude) {
		validateTotalAltitude(totalAltitude);
		this.treeAltitude = totalAltitude - STAR_ALTITUDE;
	}

	private void validateTotalAltitude(final int totalAltitude) {
		if (totalAltitude < 2) {
			throw new IllegalArgumentException(
					"totalAltitude can not be lower than 2");
		}
	}

	@Override
	public void print(final PrintStream out) {
		printStar(out, getStarDistanceBasedOnTreeAltitude());
		printTree(out);
	}

	private int getStarDistanceBasedOnTreeAltitude() {
		return getTreeAltitude();
	}

	public int getTreeAltitude() {
		return treeAltitude;
	}

	private void printStar(final PrintStream out, final int distance) {
		final String format = "%" + distance + "s%s";
		out.println(String.format(format, " ", ITEM_FOR_STAR));
	}

	private void printTree(final PrintStream out) {
		for (int row = 0; row < getTreeAltitude(); ++row) {
			printEmptySpace(out, row);
			for (int column = 0; column <= row; ++column) {
				printTreeItem(out, row, column);
			}
			out.println();
		}
	}

	private void printEmptySpace(final PrintStream out, final int distance) {
		final String format = "%" + (getTreeAltitude() - distance) + "s";
		out.print(String.format(format, " "));
	}

	private void printTreeItem(final PrintStream out, final int row,
			final int column) {
		final int number = XMasTreeNumbers.getNumberFromPascalTriangle(row,
				column);
		final String valueToPrint = XMasTreeNumbers.isEvenNumber(number) ? ITEM_FOR_EVEN_NUMBER
				: ITEM_FOR_ODD_NUMBER;
		out.print(String.format("%s ", valueToPrint));
	}

	@Override
	public String toString() {
		return "PascalTriangleXMasTree [treeAltitude=" + treeAltitude + "]";
	}

}
