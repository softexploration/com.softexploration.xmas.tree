package com.softexploration.xmas.tree.entity;

import java.io.PrintStream;

/**
 * 
 * Base XMasTree definition
 */
public abstract class XMasTree {

	/**
	 * Print current tree into given stream
	 * 
	 * @param out
	 *            - stream to print the tree into it
	 */
	public abstract void print(final PrintStream out);
}
