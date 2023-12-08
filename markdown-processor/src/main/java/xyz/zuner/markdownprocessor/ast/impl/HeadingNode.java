package xyz.zuner.markdownprocessor.ast.impl;

import xyz.zuner.markdownprocessor.ast.Node;
import xyz.zuner.markdownprocessor.ast.Visitor;

/**
 * A node representing a Markdown heading.
 */
public class HeadingNode extends Node {

    private int level; // The level of the heading, e.g., 1 for H1, 2 for H2, etc.

    public HeadingNode(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
