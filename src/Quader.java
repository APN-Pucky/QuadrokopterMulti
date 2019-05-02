import GLOOP.*;
public class Quader extends RSSContainer implements InsideRSSBP
{
    RSSBox rb;
    QuaderGL gl;
    public Quader(double x, double y, double z, double sx, double sy, double sz, String[] txts)
    {
        gl = new QuaderGL(x,y,z,sx,sy,sz,txts);
        add(gl);
        rb = new RSSBox(x,y,z,sx,sy,sz);
        add(rb);
    }
    
    public boolean inside(RSSPoint p)
    {
        return rb.inside(p);
    }
    
    public boolean inside(RSSBox b)
    {
        return rb.inside(b);
    }
    
    class QuaderGLTextur extends GLTexturContainer
    {
        public QuaderGLTextur(String[] txts)
        {
            GLTextur t;
            t = new GLTextur(txts[0]);
            add(t);
            for(String s : txts)
            {
                t = new GLTextur(s);
                add(t);
            }
        }
        
    }
    
    class QuaderGL extends GLObjektContainer
    {
        public QuaderGL(double x, double y, double z, double sx, double sy, double sz, String[] txts)
        {
            GLObjekt tmp;
            tmp = new GLKugel(x,y,z,0);
            add(tmp);
            tmp = new GLQuader(x+sx,y,z,0,sy*2,sz*2);
            add(tmp);
            tmp = new GLQuader(x-sx,y,z,0,sy*2,sz*2);
            add(tmp);
        
            tmp = new GLQuader(x,y+sy,z,sx*2,0,sz*2);
            add(tmp);
            tmp = new GLQuader(x,y-sy,z,sx*2,0,sz*2);
            add(tmp);
        
            tmp = new GLQuader(x,y,z+sz,sx*2,sy*2,0);
            add(tmp);
            tmp = new GLQuader(x,y,z-sz,sx*2,sy*2,0);
            add(tmp);
            setzeTextur(new QuaderGLTextur(txts));
        }
    }
}
