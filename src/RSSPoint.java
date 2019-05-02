import GLOOP.*;

public class RSSPoint implements RSS,InsideRSSBP
{
    double x,y,z;
    public RSSPoint(double x,double y,double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double gibX()
    {
        return x;
    }
    public double gibY()
    {
        return y;
    }
    public double gibZ()
    {
        return z;
    }
    public void setzePosition(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void verschiebe(double x, double y, double z)
    {
        this.x+=x;
        this.y+=y;
        this.z+=z;
    }
    public void dreheDich(double ax, double ay, double az)
    {
        dreheDich(ax,ay,az,x,y,z);
    }
    public void dreheDich(double ax, double ay, double az,double x, double y, double z)
    {
        GLVektor v = new GLVektor(gibX()-x,gibY()-y,gibZ()-z);
        v.drehe(ax, ay, az);
        setzePosition(v.x+x,v.y+y,v.z+z);
    }
    
    public boolean inside(RSSPoint p)
    {
        return (this.x==p.x&&this.y==p.y&&this.z==p.z);
    }
    
    public boolean inside(RSSBox b)
    {
        return b.inside(this);
    }
}
