class Node{
    int count;
    Node next;
    Node prev;
    HashSet<String> hs;
    Node(int count){
        this.count=count;
        this.hs=new HashSet<>();
        this.next=null;
        this.prev=null;
    }
}

class AllOne {

    HashMap<String,Node> map;
    Node head;
    Node tail;

    public AllOne() {
        this.map=new HashMap<>();
        this.head=new Node(-1);
        this.tail=new Node(-1);
        this.head.next=tail;
        this.tail.prev=head;
        
    }
    
    public void inc(String key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            if( n.next.count!=n.count+1 || n.next==tail){
                Node x = new Node(n.count+1);
                insertAfter(n,x);
                map.put(key,x);
                swap(key,n,x);
            }
            else
            {   // case : (n.next.count==n.count+1)
                swap(key,n,n.next);
            }

        }
        else{   // map doesn't contains key
            if(head.next==tail||head.next.count!=1){
                Node x = new Node(1);
                insertAfter(head,x);
                map.put(key,x);
                x.hs.add(key);
            }
            else{
                Node n = head.next;
                n.hs.add(key);
                map.put(key,head.next);
            }
        }
    }
    
    public void dec(String key) {
        Node n = map.get(key);
        n.hs.remove(key);
        if(n.hs.isEmpty())   delete(n);

        if(n.count==1){
            map.remove(key);
        }
        else if(n.prev==head||n.prev.count!=n.count-1){ 
            Node x = new Node(n.count-1);
            x.hs.add(key);
            Node y = n.prev;
            insertAfter(y,x);
            map.put(key,x);
        }
        else{
            n.prev.hs.add(key);
            map.put(key,n.prev);
        }
    }
    
    public String getMaxKey() {
        HashSet<String>  hs = tail.prev.hs;
        if(hs.isEmpty())    return "";
        String s = hs.iterator().next();
        return s;
    }
    
    public String getMinKey() {
        HashSet<String>  hs = head.next.hs;
        if(hs.isEmpty())    return "";
        String s = hs.iterator().next();
        return s;
    }

    public void insertAfter(Node x,Node y){
        if(x.next!=null){x.next.prev=y;}
        y.next=x.next;
        x.next=y;
        y.prev=x;
    }
    public void delete(Node x){
        x.prev.next=x.next;
        if(x.next!=null)    x.next.prev=x.prev;
        x=null;
    }
    public void swap(String key,Node x,Node y){
        map.put(key,y);
        x.hs.remove(key);
        y.hs.add(key);
        if(x.hs.isEmpty()){
            delete(x);
        }
    }
}


/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */