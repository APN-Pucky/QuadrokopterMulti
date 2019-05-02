import GLOOP.*;
public class GLObjektC implements RSS
{
    GLObjekt o;
    public GLObjektC(GLObjekt o)
    {
        this.o = o;
    }
    
    public double gibX()
    {
        return o.gibX();
    }
    
    public double gibY()
    {
        return o.gibY();
    }
    
    public double gibZ()
    {
        return o.gibZ();
    }
    
    public void dreheDich(double ax, double ay, double az)
    {
        o.dreheDich(ax,ay,az);
    }
    
    public void dreheDich(double ax, double ay, double az, double x, double y, double z)
    {
        o.dreheDich(ax,ay,az,x,y,z);
    }
    
    public void verschiebe(double x, double y, double z)
    {
        o.verschiebe(x,y,z);
    }
    
    public void setzePosition(double x, double y, double z)
    {
        o.setzePosition(x,y,z);
    }
}
