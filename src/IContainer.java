

public interface IContainer<T>
{
    public int add(T t);
    
    public void remove(int i);
    
    public void remove(T t);
    
    public T get(int i);
    
    public int getSize();
}
