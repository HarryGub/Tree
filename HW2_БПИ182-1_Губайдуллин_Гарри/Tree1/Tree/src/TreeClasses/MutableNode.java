package TreeClasses;

import java.util.Collection;
import java.util.HashSet;

public class MutableNode<T extends Number> implements Node<T>{
    T value;
    MutableNode<T> parent;
    Collection<Node<T>> children = new HashSet<Node<T>>();

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

    public void setValue(T value){
        this.value = value;
    }

    public void setParent(MutableNode<T> parent){
        this.parent = parent;
    }

    public void setChildren(Collection<MutableNode<T>> children){
            this.children.addAll(children);
    }

    public void addChild(MutableNode<T> child){
        children.add(child);
    }

    public void removeChild(MutableNode<T> child){
        children.remove(child);
    }
}
