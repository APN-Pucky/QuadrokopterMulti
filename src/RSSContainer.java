import java.util.*;
public class RSSContainer extends Container<RSS> implements RSS
{
    
    public double gibX()
    {
        return array.get(0).gibX();
    }
    
    public double gibY()
    {
        return array.get(0).gibY();
    }
    
    public double gibZ()
    {
        return array.get(0).gibZ();
    }
    
    public void dreheDich(double ax, double ay, double az)
    {
        dreheDich(ax,ay,az,gibX(),gibY(),gibZ());
    }
    
    public void dreheDich(double ax, double ay, double az, double x, double y, double z)
    {
        for(RSS o : array)
        {
            o.dreheDich(ax,ay,az,x,y,z);
        }
    }
    
    public void verschiebe(double x, double y, double z)
    {
        for(RSS o : array)
        {
            o.verschiebe(x,y,z);
        }
    }
    
    public void setzePosition(double x, double y, double z)
    {
        double gx = gibX();
        double gy = gibY();
        double gz = gibZ();
        for(RSS o : array)
        {
            o.verschiebe(x-gx,y-gy,z-gz);
        }
    }
}
