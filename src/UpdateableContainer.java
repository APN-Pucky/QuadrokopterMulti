
public class UpdateableContainer extends Container<Updateable> implements Updateable
{
    public void update()
    {
        for(Updateable u : array)
        {
            u.update();
        }
    }
}
