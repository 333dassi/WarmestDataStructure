package com.example.warmest;

import java.util.HashMap;
import java.util.Map;

public class WarmestDataStructure implements WarmestDataStructureInterface {

    private static class Node {
        String key;
        Node prev, next;

        Node(String key) {
            this.key = key;
        }
    }

    private final Map<String, Integer> map = new HashMap<>();
    private final Map<String, Node> nodeMap = new HashMap<>();
    private Node head = null;
    private Node tail = null;

    @Override
    public Integer put(String key, int value) {
        Integer prev = map.put(key, value);
        if (nodeMap.containsKey(key)) {
            moveToTail(nodeMap.get(key));
        } else {
            Node node = new Node(key);
            appendNode(node);
            nodeMap.put(key, node);
        }
        return prev;
    }

    @Override
    public Integer get(String key) {
        Integer value = map.get(key);
        if (value != null) {
            Node node = nodeMap.get(key);
            moveToTail(node);
        }
        return value;
    }

    @Override
    public Integer remove(String key) {
        Integer removed = map.remove(key);
        Node node = nodeMap.remove(key);
        if (node != null) {
            removeNode(node);
        }
        return removed;
    }

    @Override
    public String getWarmest() {
        return tail != null ? tail.key : null;
    }

    private void moveToTail(Node node) {
        removeNode(node);
        appendNode(node);
        nodeMap.put(node.key, node);
    }

    private void appendNode(Node node) {
        node.prev = tail;
        node.next = null;
        if (tail != null)
            tail.next = node;
        tail = node;
        if (head == null)
            head = node;
    }

    private void removeNode(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;

        node.prev = null;
        node.next = null;
    }
}
