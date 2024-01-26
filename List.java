public class List<T> {
    public int length;
    public Node<T> head;

    public List() {
        length=0;
        head=null;
        //sibuyile;
    }

    public String toString() {
        String result="";
        Node<T> traverse=head;
        int count=1;
        
        while(traverse != null)
        {
            result +=  traverse.data;

            if(count==length)
            {

            }
            else{

                result+=",";
            }
            traverse=traverse.next;
            count++;

        }

        return result;
    }


    public void append(T val) {
        Node<T> add= new Node<T>(val);

        if(length==0 || head==null){
            head=add;
            length++;
            return;
        }

        Node<T> traverse=head;

        while(traverse.next != null)    
            traverse=traverse.next;

        
        traverse.next=add;
        length++;
    }



    public void reconnect(Node<T> remove)
    {
        if(length==1){
            head=null;
            return;
        }

        Node<T> current=head;
        Node<T> previous=null;

    
        while( current != null && !current.data.equals(remove.data) )
        {
            previous=current;
            current=current.next;
        }
        if(current==null)//could not find it
            return;

        if(previous==null){
            head=current.next;
            return;
        }

        previous.next=current.next;


    }

    public boolean remove(T val) {
        if(head==null || length==0)
            return false;

        if(contains(val)==false)
            return false;    

        Node<T> traverse=head;
        while(traverse != null && !traverse.data.equals(val))
            traverse=traverse.next;

        reconnect(traverse);
        length--;
        
        return false;
    }

    public boolean remove(List<T> val) {
        if( val==null)
            return false;

        if(head==null)
            return false;    

        Node<T> traverse=val.head;
        int OL=length;
        while(traverse != null)
        {
            this.remove(traverse.data);
            traverse=traverse.next;

        }
        if(OL >= length)
            return true;

        return false;
    }

    public boolean contains(T search) {
        if(head==null || length==0)
            return false;

        Node<T> traverse=head;

        while(traverse != null && !traverse.data.equals(search) )
            traverse=traverse.next;

        if(traverse==null)
            return false;



        return true;
    }

    public boolean equals(List<T> other) {
        if(other==null)
            return false;
            
        if(head==(other.head))    
            return true;

        if(length != other.length)
            return false;

        Node<T> traverse1=head;
        Node<T> traverse2=other.head;
        
        while(traverse1 != null || traverse2 != null)
        {
            if( !traverse1.data.equals(traverse2.data))
                return false;

            traverse1=traverse1.next;
            traverse2=traverse2.next;
        }
        if(traverse1 ==null && traverse2==null)
            return true;

        return false;
    }
}
