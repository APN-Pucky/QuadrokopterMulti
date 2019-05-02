import GLOOP.*;
public class Geschoss extends RSSContainer implements Updateable,InsideRSSBP,Damager,Destroyable
{
    GLGeschoss glgesch;
    RSSBox rb;
    GLVektor dir;
    double size;
    String txtfolder;
    private static double movspeed;
    private static double damage;
    
    public Geschoss(double x, double y, double z, GLVektor dir)
    {
        movspeed = Global.config.gesch_movspeed;
        damage= Global.config.gesch_damage;
        size = Global.config.gesch_size;
        txtfolder = Global.config.gesch_txt;
        glgesch = new GLGeschoss(x,y,z,size,txtfolder);
        rb = new RSSBox(x,y,z,size/10,size/10,size/2);
        glgesch.dreheDich(0,180,0);
        add(glgesch);
        add(rb);
        dir.normalisiere();
        double angle = Math.asin(dir.x)*180/Math.PI;
        dreheDich(0,(dir.z>0?angle:180-angle),0);
        dir.multipliziere(movspeed);
        this.dir = dir;
    }
    
    public void vor()
    {
        verschiebe(dir.x,0,dir.z);
    }
    
    public void update()
    {
        vor();
        glgesch.update();
        collides();
    }
    
    public void collides()
    {
        if(Global.welt.inside(rb) || Global.quader.inside(rb) || Global.himmel.inside(rb))destroy();
        if(Global.qk1.inside(rb))
        {
            damage(Global.qk1);
            destroy();
        }
        if(Global.qk2.inside(rb))
        {
            damage(Global.qk2);
            destroy();
        }
    }
    
    public boolean inside(RSSPoint p)
    {
        return rb.inside(p);
    }
    
    public boolean inside(RSSBox b)
    {
        return rb.inside(b);
    }
    
    public double getDamage()
    {
        return damage;
    }
    
    public void damage(Damageable d)
    {
        d.damaged(damage);
    }
    
    public void destroy()
    {
        Global.removeupdates.add(this);
        glgesch.loesche();
    }
    
    class GLGeschossTextur extends GLTexturContainer
    {
        public GLGeschossTextur(String txtfolder)
        {
            GLTextur t;
            t = new GLTextur(txtfolder + "\\Zylinder.jpg");
            add(t);
            add(t);
            t = new GLTextur(txtfolder + "\\Kegelstumpf.jpg");
            add(t);
            t = new GLTextur(txtfolder + "\\Torus.jpg");
            add(t);
            t = new GLTextur(txtfolder + "\\Kegelstumpf.jpg");
            add(t);
            t = new GLTextur(txtfolder + "\\Zylinder.jpg");
            add(t);
            t = new GLTextur(txtfolder + "\\Kegel.jpg");
            add(t);
        }
    }
    
    class GLGeschoss extends GLObjektContainer implements Updateable
    {
        
        public GLGeschoss(double x,double y, double z, double size, String txtfolder)
        {
            final double h_size = size/2;
            final double t_size = size/3;
            final double s_size = size/6;
            final double n_size = size/9;
            final double et_size = size/18;
            final double ts_size = size/27;
            final double f_rad = size/10;
            final double f_tor = size/54;
            final double f_kegr = size/20;
            
            GLObjekt tmp;
            //Zyl-Main-0
            tmp = new GLZylinder(x,y,z,f_rad,t_size);
            add(tmp);
            //Zyl2
            tmp = new GLZylinder(x,y,z+s_size+n_size,f_rad,2*n_size);
            add(tmp);
            //KEGST-- ggf change radii
            tmp = new GLKegelstumpf(x,y,z+h_size-2*ts_size+f_tor/2,f_rad-2*f_tor,f_rad,2*ts_size+f_tor);
            add(tmp);
            //Torus
            tmp = new GLTorus(x,y,z+h_size-ts_size/2,f_rad-f_tor,f_tor);
            add(tmp);
            //KEGST2-- ggf change radii
            tmp = new GLKegelstumpf(x,y,z-s_size-et_size,f_rad,f_kegr,n_size);
            add(tmp);
            //ZYL3
            tmp = new GLZylinder(x,y,z-s_size-n_size-et_size,f_kegr,n_size);
            add(tmp);
            //KEG
            tmp = new GLKegel(x,y,z-s_size-2*n_size-et_size,f_kegr,n_size);
            add(tmp);
            
            setzeTextur(new GLGeschossTextur(txtfolder));
            
        }
        
        public void update()
        {
            
        }
    }
}
