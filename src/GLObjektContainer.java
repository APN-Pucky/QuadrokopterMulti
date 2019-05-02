import GLOOP.*;
import java.util.*;

public class GLObjektContainer extends Container<GLObjekt> implements RSS
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
        for(GLObjekt o : array)
        {
            o.dreheDich(ax,ay,az,x,y,z);
        }
    }
    
    public void verschiebe(double x, double y, double z)
    {
        for(GLObjekt o : array)
        {
            o.verschiebe(x,y,z);
        }
    }
    
    public void setzePosition(double x, double y, double z)
    {
        double gx = gibX();
        double gy = gibY();
        double gz = gibZ();
        for(GLObjekt o : array)
        {
            o.verschiebe(x-gx,y-gy,z-gz);
        }
    }
    
    public void loesche()
    {
        for(GLObjekt o : array)
        {
            o.loesche();
        }
    }
    
    public void setzeTextur(GLTexturContainer gltc)
    {
        if(gltc.getSize() != getSize())return;
        for(int i = 0; i < getSize();i++)
        {
            get(i).setzeTextur(gltc.get(i));
        }
    }
}
