package TreeClasses;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class MutableTree<T extends Number> extends AbstractTree<T> {
    public MutableTree(BinaryOperator<T> operator, Comparator<T> comparator, T zero){
        adder = operator;
        this.comparator = comparator;
        this.zero = zero;
        sum = zero;
    }

    @Override
    public AbstractTree<T> removeSubtree(Node<T> rootSubTree) {
        if (!(((MutableNode<T>) rootSubTree).getParent() == null)) {
            ((MutableNode<T>) ((MutableNode<T>) rootSubTree).getParent()).removeChild((MutableNode<T>) rootSubTree);
            return this;
        } else
            return null;
    }

    @Override
    public AbstractTree<T> maximize(int k) {
        return null;
    }

    @Override
    public AbstractTree<T> maximize() {
        this.maximize(root);
        return this;
    }
    private void maximize(Node<T> Root) {
        if (!Root.getChildren().isEmpty()) {
            for(Node<T> elem : Root.getChildren()) {
                this.maximize(elem);
                if (this.getComparator().compare(adder.apply(getSum(elem), elem.getValue()), zero) == -1)
                    ((MutableNode<T>)Root).removeChild((MutableNode<T>)elem);
            }
        }
        else
            if(this.getComparator().compare(Root.getValue(), zero) == -1)
                this.removeSubtree(Root);
    }
}
