import javax.management.ListenerNotFoundException;
import javax.xml.transform.Templates;

public class AList<T> implements ListInterface<T> {
    private int count=0;
    private T[] TList = (T[]) new Object[1000];


    public void add(T item) throws ListException{
        if(count==TList.length){
            throw new ListException("Error. Unable to add. List is full or not enough memory.");
        }
        if(item==null){
            throw new ListException("Error. Unable to add. Cannot add null entries");
        }
        TList[count]=item;
        count++;

    }

    public void add(T item, int pos) throws ListException{//insert
        if(item == null){
            throw new ListException("Cannot insert. Nulls not allowed");
        }
        if(pos<1){
            throw new ListException("");
        }
        for(int k= count-1;count>=pos-1;k--){
            TList[k+1]=TList[k];
        }
        TList [pos-1]=item;
        count++;
    }
    public T get(int pos) throws ListException{
        //gets 
        if(pos<1||pos>count){
            throw new ListException("Error. Unable to insert. Bad position.");
        }
        if(count==0){
            throw new ListException("Error. Unable to get. List is empty.");
        }
        return TList[pos-1];
    }
    public T set(T item, int pos) throws ListException{

        if (item.equals(null)) {
            throw new ListException("Error. Unable to replace. Replacement cannot be null");
        }
        if (pos < 1 || pos > count) {
            throw new ListException("Error. Unable to replace. Bad position.");
        }
        if (count == 0) {
            throw new ListException("Error. Unable to replace. List is empty.");
        }
        T temp = TList[pos-1];
        TList[pos-1] = item;
        return temp;
    }
    public int find(T item, int startPos, int endPos)throws ListException{
        if (startPos < 1  || endPos> count) {
            throw new ListException("Error. Unable to find. Start and/or end position bad.");
        }
        if(startPos==endPos){
            if(TList[startPos].equals(item)){
                return startPos;
            }else{
                return -1;
            }
        }else{
            for(int i= 0;i<startPos;i++){
                if(TList[i].equals(item)){
                    return i;
                }
            }
        }
        return -1;
    }
    public int size(){
        return count;
    }
    public String toString(){
        if(count==0){
            return "The list is empty.";
        }
        String out="";
        for(int i=0 ;i<count;i++){
            out+=TList[i];
            out+="\n";
        }
        return out;
    }
    public T remove(int pos)throws ListException{
        if(count==0){
            throw new ListException("Error. Unable to remove. List is empty.");
        }

        if(pos<1 || pos>count){
            throw new ListException("Error. Unable to remove. Bad Position");
        }
        
        T temp=TList[pos-1];
        for(int i=pos;i<count;i++){
            TList[i-1]=TList[i];
        }
        count--;
        return temp;
    }
    public void clear(){
        T[] temp = (T[]) new Object[20];
        TList = temp;
    }
    public Object[] toArray(){
        Object[] temp = new Object[count];
        if(isEmpty()){
            return temp;
        }
        for(int i= 0;i<count;i++){
            temp[i]=TList[i];
        }
        return temp;
    }
    public boolean isEmpty(){
        if(count>0){
            return false;
        }
        return true;
    }
}
    
