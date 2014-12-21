package com.softexploration.xmas.tree;

import com.softexploration.xmas.tree.entity.TriangleXMasTree;
import com.softexploration.xmas.tree.entity.XMasTree;

public class XMasTreeApp {

	public static final int DEFAULT_ALTITUDE = 33;

	public static void main(String[] args) {

		final XMasTree xMasTree = new TriangleXMasTree(getAltitude(args));
		xMasTree.print(System.out);
	}

	static int getAltitude(String[] args) {
		int altitude;
		try {
			altitude = Integer.valueOf(args[1]);
		} catch (Exception ex) {
			altitude = DEFAULT_ALTITUDE;
		}
		return altitude;
	}
}
