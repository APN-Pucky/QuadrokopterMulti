import GLOOP.*;
import java.awt.Image;
public class Welt  implements InsideRSSBP
{
    GLTerrain ter;
    GLLicht l;
    
    public Welt(String world)
    {
        for(RSSPoint p : Global.config.light_pos.array){new GLLicht(p.x,p.y,p.z);}
        ter = new GLTerrain(0,0,0,Global.config.ground);
        ter.setzeAbmessungen(Global.config.size_x,Global.config.size_y,Global.config.size_z);
        ter.setzeTextur(Global.config.ground_txt);
        for(int i = 0; i < Global.config.quader_pos.getSize();i++)
        {
            RSSPoint pos = Global.config.quader_pos.get(i);
            RSSPoint scl = Global.config.quader_scl.get(i);
            RSSPoint ang = Global.config.quader_ang.get(i);
            String[] txt = new String[]{Global.config.quader_txt.get(i*6),Global.config.quader_txt.get(i*6+1),Global.config.quader_txt.get(i*6+2),Global.config.quader_txt.get(i*6+3),Global.config.quader_txt.get(i*6+4),Global.config.quader_txt.get(i*6+5)};
            Quader q = new Quader(pos.x,pos.y,pos.z,scl.x,scl.y,scl.z,txt);
            q.dreheDich(ang.x,ang.y,ang.z);
            Global.quader.add(q);
        }
        Global.himmel = new Himmel(0,Global.config.size_y/2,0,Global.config.size_x/2,Global.config.size_y/2,Global.config.size_z/2,Global.config.himmel_txt);
    }
    
    public RSSPoint getPoint(double x, double z)
    {
        return new RSSPoint(x,ter.gibHoehe(x,z),z);
    }
    
    public boolean inside(RSSPoint p)
    {
        if(getPoint(p.x,p.z).y==p.y)
        {
            return true;
        }
        return false;
    }
    
    public boolean inside(RSSBox b)
    {
        double size = Math.max(Math.max(b.sx,b.sy),b.sz);
        for(double dx = -size*1.42;dx <(size*1.42);dx+=0.5)
        {
            for(double dz = -(size*1.42);dz <(size*1.42);dz+=0.5)
            {
                if(b.inside(Global.welt.getPoint(b.x+dx,b.z+dz)))return true;
            }
        }
        return false;
    }
}
