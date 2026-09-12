/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // HashMap to store mapping from original nodes to copied nodes
        Map<Node, Node> oldToNewMap = new HashMap<>();
      
        // Create a dummy node to simplify list construction
        Node dummyHead = new Node(0);
        Node currentTail = dummyHead;
      
        // First pass: Create all nodes and build the next pointers
        // Also populate the mapping from original to copied nodes
        for (Node currentOriginal = head; currentOriginal != null; currentOriginal = currentOriginal.next) {
            // Create a new node with the same value as the original
            Node newNode = new Node(currentOriginal.val);
          
            // Connect the new node to the copied list
            currentTail.next = newNode;
            currentTail = newNode;
          
            // Store the mapping from original node to copied node
            oldToNewMap.put(currentOriginal, newNode);
        }
      
        // Second pass: Set the random pointers for all copied nodes
        for (Node currentOriginal = head; currentOriginal != null; currentOriginal = currentOriginal.next) {
            // Get the corresponding copied node
            Node copiedNode = oldToNewMap.get(currentOriginal);
          
            // Set the random pointer of the copied node
            // If original's random is null, set to null; otherwise, get the corresponding copied node
            copiedNode.random = (currentOriginal.random == null) ? null : oldToNewMap.get(currentOriginal.random);
        }
      
        // Return the head of the copied list (skip dummy node)
        return dummyHead.next;
    }
}
