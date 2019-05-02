
public class InsideRSSBPContainer extends Container<InsideRSSBP> implements InsideRSSBP
{
    public boolean inside(RSSPoint p)
    {
        for(InsideRSSBP q : array)
        {
            if(q.inside(p))return true;
        }
        return false;
    }
    
    public boolean inside(RSSBox b)
    {
        for(InsideRSSBP q : array)
        {
            if(q.inside(b))return true;
        }
        return false;
    }
}
