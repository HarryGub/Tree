package TreeClasses;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class ImmutableTree<T extends Number> extends AbstractTree<T> {
    public ImmutableTree(BinaryOperator<T> operator, Comparator<T> comparator, T zero){
        adder = operator;
        this.comparator = comparator;
        this.zero = zero;
    }

    @Override
    public AbstractTree<T> removeSubtree(Node<T> rootSubTree) {
        ImmutableTree<T> newTree = this;
        if(newTree.getRoot().getValue() == rootSubTree.getValue() &&
                newTree.getRoot().getChildren().size() == rootSubTree.getChildren().size())
            this.setRoot(null);
        else
            remove(newTree.getRoot(), rootSubTree);
        return newTree;
    }

    private void remove(Node<T> currentRoot, Node<T> rootSubTree){
        for (Node<T> elem : currentRoot.getChildren()) {
            if(elem.getValue() == rootSubTree.getValue() &&
                    elem.getParent().getValue() == rootSubTree.getParent().getValue() &&
                    elem.getChildren().size() == rootSubTree.getChildren().size()) {
                currentRoot.getChildren().remove(elem);
                elem = new ImmutableNode<>(null, null);
            }
            else
                if(!elem.getChildren().isEmpty())
                    remove(elem, rootSubTree);
        }
    }

    @Override
    public AbstractTree<T> maximize(int k) {
        return null;
    }

    @Override
    public AbstractTree<T> maximize() {
        ImmutableNode<T> node = (ImmutableNode<T>)getRoot();
        if(node.getChildren().isEmpty() && getComparator().compare((T)node.getValue(), Zero()) == 1){
            removeSubtree(node);
        } else {
            if(node.getChildren().isEmpty())
                return this;
            else {
                for(Node<T> elem : node.getChildren()){
                    setRoot(elem);
                    maximize();
                    if(getComparator().compare((T)getSum(), Zero()) == 1){
                        removeSubtree(elem);
                    }
                } do {
                    setRoot(node.getParent());
                    node = (ImmutableNode<T>) node.getParent();
                }while (getRoot().getParent() != null);
            }
        }
        return this;
    }
}
