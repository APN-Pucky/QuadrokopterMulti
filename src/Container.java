import java.util.*;

public abstract class Container<T> implements IContainer<T>
{
    ArrayList<T> array = new ArrayList<T>();
    
    public int add(T t)
    {
        array.add(t);
        return array.size();
    }
    
    public void remove(int i)
    {
        array.remove(i);
    }
    
    public void remove(T t)
    {
        array.remove(t);
    }
    
    public T get(int i)
    {
        return array.get(i);
    }
    
    public int getSize()
    {
        return array.size();
    }
}
