public interface ListInterface<T> {
    public void add(T item,int pos) throws ListException;
    public void add(T item) throws ListException;
    public T remove(int pos) throws ListException;
    
}
