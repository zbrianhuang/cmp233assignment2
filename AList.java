import java.util.ArrayList;

//Brian Huang
//10/18/22
//Assignment #2
public class AList<T> implements ListInterface<T> {
    private int count;
    private int originalSize;
    private T[] TList = (T[]) new Object[20];
    public AList(int size){
        count=0;
        TList = (T[]) new Object[size];
        originalSize = size;
    }
    public void add(T item) throws ListException{
        if(count==TList.length){
            
            TList = resize(originalSize);
            //throw new ListException("Error. Unable to add. List is full or not enough memory.");
        }
        if(item==null){
            throw new ListException("Error. Unable to add. Cannot add null entries");
        }
        TList[count]=item;
        count++;

    }
    private T[] resize(int newSize)throws ListException{
        try{
        T[] temp = (T[]) new Object[count+newSize] ;
        for(int i= 0;i<TList.length;i++){
            
            temp[i] = TList[i];
        }
            
            return temp;
        
        }catch(OutOfMemoryError e){
            throw new ListException("Error. Unable to resize. Cannot add to array.");
        }
    }
    public void add(T item, int pos) throws ListException{//insert
        if(item == null){
            throw new ListException("Cannot insert. Nulls not allowed");
        }
        if(pos<1){
            throw new ListException("");
        }
        for(int k= count-1;k>=pos-1;k--){
            TList[k+1]=TList[k];
        }
        
        TList [pos-1]=item;
        count++;
        if(count == TList.length-1){
            resize(count+10);
        }
    }
    public T get(int pos) throws ListException{
        //gets 
        if(pos<1||pos>count){
            throw new ListException("Error. Unable to get. Bad position.");
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
    public int getCapcity(){
        return TList.length;
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
    public boolean equals(AList<T> other){
        if(count != other.size()){
            System.out.println(count+1+"+"+other.size());
            return false;
        }
        for(int i = 1; i <= this.size(); i++){
            try {
                
                System.out.println(get(i)+" "+other.get(i));
                if(!get(i).equals(other.get(i)))
                {
                    return false;
                }
            } catch (ListException e) {
                System.out.println(e);
                return false;
            }
        }
        return true;
    }
}
    
