import GLOOP.*;
import java.awt.Toolkit;

public class GLKameraC extends GLKamera implements RSS
{
    public GLKameraC(int i)
    {
        super((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        if(i==1)setzeFensterposition(0, (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
    }
    
    public GLKameraC()
    {
        super();
    }
    
    public double gibX()
    {
        return super.gibX();
    }
    
    public double gibY()
    {
        return super.gibY();
    }
    
    public double gibZ()
    {
        return super.gibZ();
    }
    
    public void setzePosition(double x, double y, double z)
    {
        verschiebe(x-gibX(),y-gibY(),z-gibZ());
    }
    
    public void verschiebe(double x, double y, double z)
    {
        GLVektor v = super.gibBlickpunkt();
        super.setzeBlickpunkt(v.x+x,v.y+y,v.z+z);
        super.setzePosition(gibX()+x,gibY()+y,gibZ()+z);
    }
    
    public void dreheDich(double ax, double ay, double az)
    {
        dreheDich(ax,ay,az,gibX(),gibY(),gibZ());
    }
    
    public void dreheDich(double ax, double ay, double az,double x, double y, double z)
    {
        GLVektor v = super.gibBlickpunkt();
        v.x -= x;
        v.y -= y;
        v.z -= z;
        v.drehe(ax, ay, az);
        super.setzeBlickpunkt(v.x+x,v.y+y,v.z+z);
        
        v = new GLVektor(gibX()-x,gibY()-y,gibZ()-z);
        v.drehe(ax, ay, az);
        super.setzePosition(v.x+x,v.y+y,v.z+z);
        
    }
}
