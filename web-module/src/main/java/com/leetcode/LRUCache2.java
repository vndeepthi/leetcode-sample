package com.leetcode;

import java.util.*;

public class LRUCache2<V> {

    private int capacity;
    private Map<String, CacheNode<Integer>> cacheMap = new HashMap<>();
    private  DLCacheNode<Integer> dlCacheNode = new DLCacheNode<>();

    class DLCacheNode<V> {
        private CacheNode<V> head, tail;

        public DLCacheNode() {
            this.head = null;
            this.tail = null;
        }

        public void moveNodeToHead(CacheNode<V> node){
            if (head == node){
               return;
            } else if(tail == node){
                removeNodFromTail();
                addNodeToHead(node);
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                addNodeToHead(node);
            }
        }

        public void addNodeToHead(CacheNode<V> node){
          if (head == null){
              head = tail = node;
          } else {
              node.next = head;
              head.prev = node;
              head = node;
          }
        }

        public void removeNodFromTail(){
            if(tail == null) {
                return;
            }
            if(tail == head) {
                tail = head = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
    }

    class CacheNode<V>{
        private V value;
        private String key;
        private CacheNode<V> prev;
        private CacheNode<V> next;

        public CacheNode(V value, String key) {
            this.value = value;
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }

    public Integer get(String key) {
        // read from map
        if (cacheMap.get(key) != null) {
            dlCacheNode.moveNodeToHead(cacheMap.get(key));
            return cacheMap.get(key).value;
        }
        //read from the database and put in the cache;
        return -1;
    }

    public void put(String key, Integer value){
        if (cacheMap.get(key) != null) {
            dlCacheNode.moveNodeToHead(cacheMap.get(key));
        } else {
            if (cacheMap.size() > capacity){
                dlCacheNode.removeNodFromTail();
                cacheMap.remove(key);
            }
            CacheNode<Integer> newNode = new CacheNode<>(value, key);
            dlCacheNode.addNodeToHead(newNode);
            cacheMap.put(key, newNode);
        }
    }
}
