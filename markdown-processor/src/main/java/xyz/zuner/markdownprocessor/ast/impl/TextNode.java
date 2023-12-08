package xyz.zuner.markdownprocessor.ast.impl;

import xyz.zuner.markdownprocessor.ast.Node;
import xyz.zuner.markdownprocessor.ast.Visitor;

public class TextNode extends Node {

    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public String toHtml() {
        return text;
    }

    public String toMarkdown() {
        return text;
    }

    public String toLatex() {
        return text;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
