package TreeClasses;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public abstract class AbstractTree<T extends Number> {
    protected Node<T> root;
    protected BinaryOperator<T> adder;
    protected Comparator<T> comparator;
    protected T zero;
    protected T sum;
    protected int size;

    public Comparator<T> getComparator(){
        return comparator;
    }

    public T Zero(){
        return zero;
    }

    public Node<T> getRoot(){
        return root;
    }

    public void setRoot(Node<T> newRoot){
        root = newRoot;
    }

    private int getSize(Node<T> node){
        if(!node.getChildren().isEmpty()) {
            size += node.getChildren().size();
            for (Node<T> elem : node.getChildren()) {
                getSize(elem);
            }
        }
        else
            return 1;
        return size;
    }
    public int getSize() {
        if(root != null) {
            size = 1;
            return getSize(root);
        }
        else
            return 0;
    }

    public T getSum(){
        sum = zero;
        if(root.getChildren().isEmpty())
            return root.getValue();
        else
            return adder.apply(getSum(root), root.getValue());
    }

    protected T getSum(Node<T> node){
        if(!node.getChildren().isEmpty()) {
            for (Node<T> elem : node.getChildren()) {
                sum = adder.apply(sum, elem.getValue());
                getSum(elem);
            }
        }
        else
            return node.getValue();
        return sum;
    }

    public abstract AbstractTree<T> removeSubtree(Node<T> rootSubTree);
    public abstract AbstractTree<T> maximize(int k);
    public abstract AbstractTree<T> maximize();
}
