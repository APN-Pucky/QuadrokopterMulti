import GLOOP.*;
public class RSSBox implements RSS,InsideRSSBP
{
    double x,y,z;
    double sx,sy,sz;
    double ax,ay,az;
    public RSSBox(double x, double y, double z, double sx, double sy, double sz)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        
        this.sx = sx;
        this.sy = sy;
        this.sz = sz;
        
        this.ax = 0;
        this.ay = 0;
        this.az = 0;
    
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
        setzePosition(gibX()+x,gibY()+y,gibZ()+z);
    }
    public void dreheDich(double ax, double ay, double az)
    {
        this.ax += ax;
        this.ay += ay;
        this.az += az;
    }
    public void dreheDich(double ax, double ay, double az,double x, double y, double z)
    {
        dreheDich(ax,ay,az);
        GLVektor v = new GLVektor(gibX()-x,gibY()-y,gibZ()-z);
        v.drehe(ax, ay, az);
        setzePosition(v.x+x,v.y+y,v.z+z);
    }
    
    public RSSPoint[] getPoints()
    {
        return new RSSPoint[]{
        new RSSPoint(x+sx,y+sy,z+sz),
        new RSSPoint(x-sx,y+sy,z+sz),
        new RSSPoint(x+sx,y-sy,z+sz),
        new RSSPoint(x+sx,y+sy,z-sz),
        
        new RSSPoint(x-sx,y-sy,z-sz),
        new RSSPoint(x+sx,y-sy,z-sz),
        new RSSPoint(x-sx,y+sy,z-sz),
        new RSSPoint(x-sx,y-sy,z+sz),};
    }
        
    public boolean inside(RSSPoint p)
    {
        
        RSSPoint tmp = new RSSPoint(p.x,p.y,p.z);
        tmp.dreheDich(-ax,-ay,-az,gibX(),gibY(),gibZ());
        return !((tmp.x>(this.x+sx))||(tmp.x<(this.x-sx))||(tmp.y>(this.y+sy))||(tmp.y<(this.y-sy))||(tmp.z>(this.z+sz))||(tmp.z<(this.z-sz)));
    }
    
    public boolean inside(RSSBox b)
    {
        for(RSSPoint p : b.getPoints())
        {
            if(inside(p))return true;
        }
        for(RSSPoint p : getPoints())
        {
            if(b.inside(p))return true;
        }
        return false;
    }
}
