package xyz.zuner.markdownprocessor.ast;

import xyz.zuner.markdownprocessor.ast.impl.HeadingNode;
import xyz.zuner.markdownprocessor.ast.impl.ParagraphNode;
import xyz.zuner.markdownprocessor.ast.impl.TextNode;

/**
 * A visitor interface for traversing the AST nodes.
 */
public interface Visitor {

    void visit(TextNode node);
    void visit(HeadingNode node);
    void visit(ParagraphNode node);
    // More visit methods for different node types.
}
