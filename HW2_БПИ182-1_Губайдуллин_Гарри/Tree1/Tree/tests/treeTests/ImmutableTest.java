package treeTests;

import TreeClasses.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImmutableTest {
    ImmutableTree tree;
    ImmutableNode<Integer> testNode;
    ImmutableNode<Integer> testNode1;
    @BeforeEach
    void setUp() {
        tree = new ImmutableTree<Integer>( Integer::sum, Integer::compare, 0);
        MutableNode<Integer> root = new MutableNode<>();
        root.setValue(1);
        MutableNode<Integer> node = new MutableNode<>();
        node.setValue(-2);
        node.setParent(root);
        ((MutableNode<Integer>)(root)).addChild(node);
        MutableNode<Integer> Node = new MutableNode<>();
        Node.setValue(-3);
        Node.setParent(root);
        ((MutableNode<Integer>)(root)).addChild(Node);
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
        ((MutableNode<Integer>)(Node)).addChild(node4);
        MutableNode<Integer> node5 = new MutableNode<>();
        node5.setValue(-8);
        node5.setParent(node);
        ((MutableNode<Integer>)(Node)).addChild(node5);
        ImmutableNode<Integer> imRoot = new ImmutableNode<>(root, null);
        tree.setRoot(imRoot);
        ImmutableNode<Integer> im_node = new ImmutableNode<>(node, imRoot);
        testNode = new ImmutableNode<>(Node, imRoot);
        ImmutableNode<Integer> im_node1 = new ImmutableNode<>(node1, im_node);
        testNode1 = new ImmutableNode<>(node2, im_node);
        ImmutableNode<Integer> im_node3 = new ImmutableNode<>(node3, im_node);
        ImmutableNode<Integer> im_node4 = new ImmutableNode<>(node4, testNode);
        ImmutableNode<Integer> im_node5 = new ImmutableNode<>(node5, testNode);
    }

    @AfterEach
    void tearDown() {
        tree = null;
    }

    @Test
    void removeSubtree() {
        tree.removeSubtree(testNode);
        assertEquals(-16, tree.getSum());
    }

//    @Test
//    void maximize() {
//        tree.maximize();
//        assertEquals(1, tree.getSize());
//    }

    @Test
    void getSize(){
        assertEquals(8, tree.getSize());
    }

    @Test
    void getSum(){
        assertEquals(-34, tree.getSum());
    }
}
