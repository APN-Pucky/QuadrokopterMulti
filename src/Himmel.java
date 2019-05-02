
public class Himmel extends InsideRSSBPContainer
{
    public Himmel(double x, double y, double z, double sx, double sy, double sz, String[] txts)
    {
        InsideRSSBP tmp;
        tmp = new Quader(x+sx*2,y,z,sx,sy,sz,new String[]{txts[0],txts[0],txts[0],txts[0],txts[0],txts[0]});
        add(tmp);
        tmp = new Quader(x-sx*2,y,z,sx,sy,sz,new String[]{txts[1],txts[1],txts[1],txts[1],txts[1],txts[1]});
        add(tmp);
        tmp = new Quader(x,y+sy*2,z,sx,sy,sz,new String[]{txts[2],txts[2],txts[2],txts[2],txts[2],txts[2]});
        add(tmp);
        tmp = new Quader(x,y,z+sz*2,sx,sy,sz,new String[]{txts[3],txts[3],txts[3],txts[3],txts[3],txts[3]});
        add(tmp);
        tmp = new Quader(x,y,z-sz*2,sx,sy,sz,new String[]{txts[4],txts[4],txts[4],txts[4],txts[4],txts[4]});
        add(tmp);
    }
}
