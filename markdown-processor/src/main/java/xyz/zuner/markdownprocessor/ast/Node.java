package xyz.zuner.markdownprocessor.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * The {@code Node} class serves as the foundational building block for constructing an Abstract Syntax Tree (AST)
 * representing a Markdown document's structure. The AST encapsulates the hierarchical nature of the document,
 * allowing for transformative operations, such as HTML generation or syntactic manipulations.
 * </p>
 *
 * <p>
 * This abstract class provides the framework for defining common attributes and behaviors shared among various
 * specialized node types within the AST. Each concrete subclass of {@code Node} is responsible for implementing
 * the {@code accept} method, which facilitates the Visitor design pattern, allowing external operations to be
 * applied to the AST without modifying its internal structure.
 * </p>
 *
 * <p>
 * Extending the {@code Node} class enables the creation of diverse node types to accurately represent Markdown
 * constructs, such as code blocks, headers, lists, and tables. Furthermore, it allows the introduction of new
 * operations on the AST, thereby enhancing its functionality and adaptability to different Markdown flavors or
 * document transformations.
 * </p>
 *
 * <p>
 * The design of the {@code Node} class emphasizes modularity and extensibility, ensuring that it can accommodate
 * the intricacies and variances of different Markdown documents with ease.
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Abstract_syntax_tree">Abstract Syntax Tree (Wikipedia)</a>
 * @see <a href="https://en.wikipedia.org/wiki/Visitor_pattern">Visitor Design Pattern (Wikipedia)</a>
 *
 * @author Zeyad Rashed
 * @version 1.0.0
 * @since 2023-12-07
 */
public abstract class Node {

    private Node parent;
    private List<Node> children;

    /**
     * Constructs an empty {@code Node} with no children.
     */
    public Node() {
        this.children = new ArrayList<>();
    }

    /**
     * Adds a child node to this node.
     *
     * @param child The child node to add.
     */
    public void addChild(Node child) {
        children.add(child);
        child.setParent(this);
    }

    /**
     * Retrieves the parent of this node.
     *
     * @return The parent node.
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Sets the parent of this node.
     *
     * @param parent The node to set as the parent.
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Retrieves the children of this node.
     *
     * @return A list of child nodes.
     */
    public List<Node> getChildren() {
        return children;
    }

    /**
     * Accepts a visitor that implements the {@code Visitor} interface.
     * This method is part of the Visitor design pattern and allows for
     * operations to be performed on the node.
     *
     * @param visitor The visitor that performs operations on this node.
     */
    public abstract void accept(Visitor visitor);
}
