import GLOOP.*;
import javax.swing.JOptionPane;
public class Quadrokopter extends RSSContainer implements Updateable,InsideRSSBP,Damageable,Destroyable
{
    int id;
    GLKameraC kam;
    GLQuadrokopter glqu;
    RSSBox rb;
    double size;
    double health;
    String txtfolder;
    double reload_save;
    double reload;
    private static double movspeed;
    private static double upspeed;
    private static double rotspeed;
    private static double rotorspeed;
    
    public Quadrokopter(double x, double y, double z, int i)
    {
        id = i;
        movspeed = Global.config.qk_movspeed;
        rotspeed = Global.config.qk_rotspeed;
        upspeed = Global.config.qk_upspeed;
        rotorspeed = Global.config.qk_rotorspeed;
        size = Global.config.qk_size;
        txtfolder = Global.config.qk_txt;
        reload_save = Global.config.qk_reload;
        reload = Global.config.qk_reload;
        kam = new GLKameraC(i);
        kam.setzePosition(x+Global.config.cam_x,y+Global.config.cam_y,z+Global.config.cam_z);
        kam.setzeBlickpunkt(x,y+Global.config.cam_view_y,z);
        glqu = new GLQuadrokopter(x,y,z,size,txtfolder);
        rb = new RSSBox(x,y,z,size/2,size/8,size/2);
        health = Global.config.qk_health;
        add(glqu);
        add(kam);
        add(rb);
    }
    
    public void vor()
    {
        GLVektor v = kam.gibBlickrichtung();
        v.normalisiere();
        v.multipliziere(movspeed);
        verschiebe(v.x,0,v.z);
    }
    
    public void zurueck()
    {
        GLVektor v = kam.gibBlickrichtung();
        v.normalisiere();
        v.multipliziere(movspeed);
        verschiebe(-v.x,0,-v.z);
    }
    
    public void rechts()
    {
        GLVektor v = kam.gibBlickrichtung();
        v.normalisiere();
        v.multipliziere(movspeed);
        v.drehe(0,-90,0);
        verschiebe(v.x,0,v.z);
    }
    
    public void links()
    {
        GLVektor v = kam.gibBlickrichtung();
        v.normalisiere();
        v.multipliziere(movspeed);
        v.drehe(0,90,0);
        verschiebe(v.x,0,v.z);
    }
    
    public void hoch()
    {
        verschiebe(0,movspeed,0);
    }
    
    public void runter()
    {
        verschiebe(0,-movspeed,0);
    }
    
    public void rotRechts()
    {
        dreheDich(0,-rotspeed,0);
    }
    
    public void rotLinks()
    {
        dreheDich(0,rotspeed,0);
    }
    
    public void update()
    {
        glqu.update();
        if(collides())destroy();
    }
    
    public boolean inside(RSSPoint p)
    {
        return rb.inside(p);
    }
    
    public boolean inside(RSSBox b)
    {
        return rb.inside(b);
    }
    
    public void damaged(double d)
    {
        health-=d;
        if(health<=0)destroy();
    }
    
    public void damaged(Damager d)
    {
        damaged(d.getDamage());
    }
    
    public boolean collides()
    {
        if(Global.welt.inside(rb)||Global.quader.inside(rb) || Global.himmel.inside(rb))return true;
        return false;
    }
    
    public void shot()
    {
        if(reload > 0)
        {
            reload--;
            return;
        }
        GLVektor v = kam.gibBlickrichtung();
        v.multipliziere(size+Global.config.gesch_size/2);
        Geschoss g = new Geschoss(gibX()+v.x,gibY(),gibZ()+v.z,v);
        Global.updates.add(g);
        reload = reload_save;
    }
    
    
    public void destroy()
    {
        JOptionPane.showMessageDialog(null, "Player " + ((id+1)%2+1) + " wins (" + (id==1?"top":"bottom") + ")","Done" , JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    class GLQuadrokopterTextur extends GLTexturContainer
    {
        public GLQuadrokopterTextur(String txtfolder)
        {
            GLTextur t;
            t = new GLTextur(txtfolder + "\\Kugel.jpg");
            add(t);
            t = new GLTextur(txtfolder + "\\Torus.jpg");
            add(t);
            add(t);
            add(t);
            add(t);
            t = new GLTextur(txtfolder + "\\Kegelstumpf.jpg");
            add(t);
            add(t);
            add(t);
            add(t);
            t = new GLTextur(txtfolder + "\\Zylinder.jpg");
            add(t);
            add(t);
            add(t);
            add(t);
            t = new GLTextur(txtfolder + "\\Kegel.jpg");
            add(t);
            add(t);
            add(t);
            add(t);
            t = new GLTextur(txtfolder + "\\Quader.jpg");
            add(t);
            add(t);
            add(t);
            add(t);
            add(t);
            add(t);
            add(t);
            add(t);
        }
    }
    
    class GLQuadrokopter extends GLObjektContainer implements Updateable
    {
        
        public GLQuadrokopter(double x,double y, double z, double size, String txtfolder)
        {
            final double h_size = size/2;
            final double f_size = size/4;
            final double o_size = size/8;
            final double f_kug = size/8;
            final double f_tor = size/40;
            final double f_kegst1 = size/60;
            final double f_kegst2 = size/150;
            final double f_zylR = size/100;
            final double f_keg = 0;
            final double f_qua = size/8;
            final double f_quaS = 0;
            final double f_quaW = 45;
            //KUG <- Main{0}
            GLObjekt tmp;
            tmp = new GLKugel(x,y,z, f_kug);
            add(tmp);
            //TOR{1,2,3,4}
            tmp = new GLTorus(x+f_size,y,z+f_size,(f_size)-f_tor,f_tor);
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLTorus(x-f_size,y,z+f_size,(f_size)-f_tor,f_tor);
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLTorus(x+f_size,y,z-f_size,(f_size)-f_tor,f_tor);
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLTorus(x-f_size,y,z-f_size,(f_size)-f_tor,f_tor);
            tmp.dreheDich(90,0,0);
            add(tmp);
            //KEGS{5,6,7,8}
            tmp = new GLKegelstumpf(x+o_size,y,z+o_size,f_kegst1,f_kegst2,Math.sqrt(2*Math.pow(h_size, 2))/2);
            tmp.dreheDich(0,225,0);
            add(tmp);
            tmp = new GLKegelstumpf(x-o_size,y,z+o_size,f_kegst1,f_kegst2,Math.sqrt(2*Math.pow(h_size, 2))/2);
            tmp.dreheDich(0,-225,0);
            add(tmp);
            tmp = new GLKegelstumpf(x+o_size,y,z-o_size,f_kegst1,f_kegst2,Math.sqrt(2*Math.pow(h_size, 2))/2);
            tmp.dreheDich(0,-45,0);
            add(tmp);
            tmp = new GLKegelstumpf(x-o_size,y,z-o_size,f_kegst1,f_kegst2,Math.sqrt(2*Math.pow(h_size, 2))/2);
            tmp.dreheDich(0,45,0);
            add(tmp);
            //ZYL{9,10,11,12}
            tmp = new GLZylinder(x+f_size,y,z+f_size,f_zylR,f_tor);
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLZylinder(x-f_size,y,z+f_size,f_zylR,f_tor);
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLZylinder(x+f_size,y,z-f_size,f_zylR,f_tor);
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLZylinder(x-f_size,y,z-f_size,f_zylR,f_tor);
            tmp.dreheDich(90,0,0);
            add(tmp);
            //KEG{13,14,15,16}
            tmp = new GLKegel(x+f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW)/2,z+f_size,f_zylR,(f_tor/2)*Math.sin(f_quaW));
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLKegel(x-f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW)/2,z+f_size,f_zylR,(f_tor/2)*Math.sin(f_quaW));
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLKegel(x+f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW)/2,z-f_size,f_zylR,(f_tor/2)*Math.sin(f_quaW));
            tmp.dreheDich(90,0,0);
            add(tmp);
            tmp = new GLKegel(x-f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW)/2,z-f_size,f_zylR,(f_tor/2)*Math.sin(f_quaW));
            tmp.dreheDich(90,0,0);
            add(tmp);
            //QUA{17,18,19,20,21,22,23,24}
            tmp = new GLQuader(x+f_size+f_qua/2,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z+f_size,f_qua,f_quaS,f_tor);
            tmp.dreheDich(f_quaW,0,0);
            add(tmp);
            tmp = new GLQuader(x+f_size-f_qua/2,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z+f_size,f_qua,f_quaS,f_tor);
            tmp.dreheDich(-f_quaW,0,0);
            add(tmp);
            
            tmp = new GLQuader(x-f_size+f_qua/2,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z+f_size,f_qua,f_quaS,f_tor);
            tmp.dreheDich(f_quaW,0,0);
            tmp.dreheDich(0,30,0,x-f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z+f_size);
            add(tmp);
            tmp = new GLQuader(x-f_size-f_qua/2,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z+f_size,f_qua,f_quaS,f_tor);
            tmp.dreheDich(-f_quaW,0,0);
            tmp.dreheDich(0,30,0,x-f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z+f_size);
            add(tmp);
            
            tmp = new GLQuader(x+f_size+f_qua/2,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z-f_size,f_qua,f_quaS,f_tor);
            tmp.dreheDich(f_quaW,0,0);
            tmp.dreheDich(0,60,0,x+f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z-f_size);
            add(tmp);
            tmp = new GLQuader(x+f_size-f_qua/2,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z-f_size,f_qua,f_quaS,f_tor);
            tmp.dreheDich(-f_quaW,0,0);
            tmp.dreheDich(0,60,0,x+f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z-f_size);
            add(tmp);
            
            tmp = new GLQuader(x-f_size+f_qua/2,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z-f_size,f_qua,f_quaS,f_tor);
            tmp.dreheDich(f_quaW,0,0);
            tmp.dreheDich(0,130,0,x-f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z-f_size);
            add(tmp);
            tmp = new GLQuader(x-f_size-f_qua/2,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z-f_size,f_qua,f_quaS,f_tor);
            tmp.dreheDich(-f_quaW,0,0);
            tmp.dreheDich(0,130,0,x-f_size,y+f_tor/2+(f_tor/2)*Math.sin(f_quaW),z-f_size);
            add(tmp);
            setzeTextur(new GLQuadrokopterTextur(txtfolder));
        }
        
        public void dreheRotoren()
        {
            for(int i = 13;i < 17;i++)
            {
                int d = (i-13)*2;
                GLObjekt o = get(i);
                double x = o.gibX();
                double y = o.gibY();
                double z = o.gibZ();
                o.dreheDich(0,1,0);
                get(17+d).dreheDich(0,rotorspeed,0,x,y,z);
                get(17+d+1).dreheDich(0,rotorspeed,0,x,y,z);
            }
        }
        
        public void update()
        {
            dreheRotoren();
        }
    }
}
