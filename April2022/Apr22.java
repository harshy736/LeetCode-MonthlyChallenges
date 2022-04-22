/*
706. Design HashMap
Easy

Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 

Constraints:

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.
*/
class MyHashMap {//NOt
    //some less space
    //using Hashing -> Hash Index for every ley value pair
    //map is on basis of key
    //Index is on basis of key
    
    ListNode[] buckets;//stores nodes(key - value)
    
    public MyHashMap() {
        buckets = new ListNode[10000];
    }
    
    public void put(int key, int value) {
        int idx = index(key);//hahsed index
        
        if(buckets[idx] == null)//no pair exists already
            buckets[idx] = new ListNode(-1, -1);//dummy node which avoids runtime errors
        
        ListNode prev = find(buckets[idx], key);//last node 
        //Or prev of key node if key already exists

        if(prev.next == null)//last node
            prev.next = new ListNode(key, value);
        else//update value on key node 
            prev.next.val = value;
        
    }
    
    public int get(int key) {
        int idx = index(key);//hashed index
        
        if(buckets[idx] == null)//no node at this index
            return -1;
        
        ListNode prev = find(buckets[idx], key);
        
        if (prev.next == null)//key node doesn't exists
            return -1;
        
        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = index(key);//hashed Index
        
        if(buckets[idx] == null)
            return;
        
        ListNode prev = find(buckets[idx], key);
        
        if (prev.next == null)//no key node exists
            return;
        
        prev.next = prev.next.next;//remove key node -> prev.next
    }
    
    public ListNode find(ListNode node, int key) {
        ListNode cur = node;
        ListNode prev = null;
        
        while(cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        
        return prev;
    }
    
    public int index(int key) {
        return Integer.hashCode(key) % buckets.length;//gives hashed index in range of arr
    }
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
