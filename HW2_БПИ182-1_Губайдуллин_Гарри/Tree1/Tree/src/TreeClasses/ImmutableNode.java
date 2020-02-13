package TreeClasses;

import java.util.Collection;
import java.util.HashSet;

public class ImmutableNode<T extends Number> implements Node<T> {
    T value;
    ImmutableNode<T> parent;
    Collection<Node<T>> children = new HashSet<Node<T>>();

    public ImmutableNode(MutableNode<T> node, ImmutableNode<T> parent){
        if(node != null) {
            this.value = node.getValue();
            this.children = node.getChildren();
        }
        if(parent != null)
            this.parent = parent;
    }

    @Override
    public Node<T> getParent() {
        return parent;
    }

    @Override
    public Collection<Node<T>> getChildren() {
        return children;
    }

    @Override
    public void print(int indents) {
        for (int i = 0; i < indents; i++)
            System.out.print(" ");
        System.out.println(value);
    }

    @Override
    public T getValue() {
        return value;
    }
}
