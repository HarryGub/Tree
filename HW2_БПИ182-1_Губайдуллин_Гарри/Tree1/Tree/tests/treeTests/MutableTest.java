package treeTests;

import TreeClasses.MutableNode;
import TreeClasses.MutableTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MutableTest {
    MutableTree<Integer> tree;
    MutableNode<Integer> testNode;
    @BeforeEach
    void setUp() {
        tree = new MutableTree<Integer>(Integer::sum, Integer::compare, 0);
        MutableNode<Integer> root = new MutableNode<>();
        root.setValue(1);
        tree.setRoot(root);
        MutableNode<Integer> node = new MutableNode<>();
        node.setValue(-2);
        node.setParent(root);
        ((MutableNode<Integer>)(tree.getRoot())).addChild(node);
        testNode = new MutableNode<>();
        testNode.setValue(-3);
        testNode.setParent(root);
        ((MutableNode<Integer>)(tree.getRoot())).addChild(testNode);
        MutableNode<Integer> node1 = new MutableNode<>();
        node1.setValue(-4);
        node1.setParent(node);
        ((MutableNode<Integer>)(node)).addChild(node1);
        MutableNode<Integer> node2 = new MutableNode<>();
        node2.setValue(-5);
        node2.setParent(node);
        ((MutableNode<Integer>)(node)).addChild(node2);
        MutableNode<Integer> node3 = new MutableNode<>();
        node3.setValue(-6);
        node3.setParent(node);
        ((MutableNode<Integer>)(node)).addChild(node3);
        MutableNode<Integer> node4 = new MutableNode<>();
        node4.setValue(-7);
        node4.setParent(node);
        ((MutableNode<Integer>)(testNode)).addChild(node4);
        MutableNode<Integer> node5 = new MutableNode<>();
        node5.setValue(-8);
        node5.setParent(node);
        ((MutableNode<Integer>)(testNode)).addChild(node5);
    }

    @AfterEach
    void tearDown() {
        tree = null;
    }

//    @Test
//    void maximize() {
//        tree.maximize();
//        assertEquals(1, tree.getSum());
//    }

    @Test
    void removeSubtree() {
        tree.removeSubtree(testNode);
        assertEquals(-16, tree.getSum());
    }

    @Test
    void getSize(){
        assertEquals(8, tree.getSize());
    }

    @Test
    void getSum(){
        assertEquals(-34, tree.getSum());
    }
}
