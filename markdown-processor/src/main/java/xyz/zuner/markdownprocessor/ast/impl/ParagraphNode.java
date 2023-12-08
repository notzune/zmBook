package xyz.zuner.markdownprocessor.ast.impl;

import xyz.zuner.markdownprocessor.ast.Node;
import xyz.zuner.markdownprocessor.ast.Visitor;

/**
 * A node representing a Markdown paragraph.
 */
public class ParagraphNode extends Node {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
