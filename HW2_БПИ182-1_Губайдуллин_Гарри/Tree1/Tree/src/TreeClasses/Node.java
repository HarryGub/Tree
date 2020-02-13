package TreeClasses;

import java.util.Collection;

public interface Node<T extends Number> extends Wrapper<T> {
    public Node<T> getParent();
    public Collection<Node<T>> getChildren();
    public void print(int indents);
}
