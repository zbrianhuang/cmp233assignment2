

public class AList<T> implements ListInterface<T> {
    private int count=0;
    private Object[] TList = new Object[1000];
    public void add(T item){
        //default add method, throw exception when list is full.
    }
    public void add(T item, int pos) throws ListException{
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
    public T get(){
        //gets 
        return null;
    }
    public T remove(int pos)throws ListException{
        return (T)TList[0];
    }
}
