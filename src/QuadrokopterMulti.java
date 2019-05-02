import GLOOP.*;
import javax.swing.JOptionPane;

public class QuadrokopterMulti
{   
    Quadrokopter qu1;
    Quadrokopter qu2;
    Welt w;
    public 
    GLMaus m;
    GLTastaturC t;
    
    
    
    public void start()
    {
        String world = null;
        try
        {
            world = WorldSelector.showWorldSelectionInput();
        }
        catch(Exception e)
        {
            Global.err.e(e.getMessage());
        }
        if(world == null)Global.err.e("No World selected");
        Config c = null;
        try
        {
            c = new Config(world);
        }
        catch(Exception e)
        {
            Global.err.e("Error during loading World");
        }
        if(c == null)Global.err.e("No World loaded");
        Global.config = c;
        t = new KeyBoard();
        w = new Welt(world);
        qu1 = new Quadrokopter(0,200,0,0);
        Global.qk1 = qu1;
        qu2 = new Quadrokopter(100,200,0,1);
        Global.qk2 = qu2;
        Global.updates.add(qu1);
        Global.updates.add(qu2);
        Global.welt = w;
        m = new GLMaus();
        renderWhile();
    }
    
    public void renderWhile()
    {
        while(!t.esc())
        {
            if(t.istGedrueckt('w'))qu1.vor();
            if(t.istGedrueckt('a'))qu1.links();
            if(t.istGedrueckt('s'))qu1.zurueck();
            if(t.istGedrueckt('d'))qu1.rechts();
            if(t.istGedrueckt('t'))qu1.hoch();
            if(t.istGedrueckt('g'))qu1.runter();
            if(t.istGedrueckt('f'))qu1.rotLinks();
            if(t.istGedrueckt('h'))qu1.rotRechts();
            if(t.istGedrueckt('r'))qu1.shot();
            if(t.istGedrueckt('z'));
            if(t.oben())qu2.vor();
            if(t.unten())qu2.zurueck();
            if(t.rechts())qu2.rechts();
            if(t.links())qu2.links();
            if(t.istGedrueckt('8'))qu2.hoch();
            if(t.istGedrueckt('5'))qu2.runter();
            if(t.istGedrueckt('4'))qu2.rotLinks();
            if(t.istGedrueckt('6'))qu2.rotRechts();
            if(t.istGedrueckt('7'))qu2.shot();
            if(t.istGedrueckt('9'));
            Global.updates.update();
            for(Updateable u : Global.removeupdates.array)Global.updates.remove(u);
            Global.removeupdates.array.clear();
            Sys.warte();
        }
        Sys.beenden();
    }
}
