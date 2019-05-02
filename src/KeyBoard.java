
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class KeyBoard implements GLTastaturC, KeyEventDispatcher 
{
    ArrayList<Key> keys = new ArrayList<Key>();
    
    public KeyBoard()
    {
        KeyboardFocusManager manager =
             KeyboardFocusManager.getCurrentKeyboardFocusManager();
                manager.addKeyEventDispatcher(this);
    }
    
    public boolean pressed(Key k)
    {
        return keys.contains(k);
    }
    
    public boolean istGedrueckt(char c)
    {
        switch(c)
        {
            case('w'):return pressed(Key.W);
            case('a'):return pressed(Key.A);
            case('s'):return pressed(Key.S);
            case('d'):return pressed(Key.D);
            
            case('r'):return pressed(Key.R);
            case('t'):return pressed(Key.T);
            case('z'):return pressed(Key.Z);
            case('f'):return pressed(Key.F);
            case('g'):return pressed(Key.G);
            case('h'):return pressed(Key.H);
            
            case('4'):return pressed(Key.VIER);
            case('5'):return pressed(Key.FÜNF);
            case('6'):return pressed(Key.SECHS);
            case('7'):return pressed(Key.SIEBEN);
            case('8'):return pressed(Key.ACHT);
            case('9'):return pressed(Key.NEUN);
        }
        return false;
    }
    
    public boolean esc()
    {
        return pressed(Key.ESC);
    }
    
    public boolean oben()
    {
        return pressed(Key.OBEN);
    }
    
    public boolean unten()
    {
        return pressed(Key.UNTEN);
    }
    
    public boolean rechts()
    {
        return pressed(Key.RECHTS);
    }
    
    public boolean links()
    {
        return pressed(Key.LINKS);
    }

    public void keyPressed(KeyEvent k) 
    {
        if (k.getKeyCode() == KeyEvent.VK_W)
        {
            if(!pressed(Key.W))keys.add(Key.W);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_S)
        {
            if(!pressed(Key.S))keys.add(Key.S);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_D)
        {
            if(!pressed(Key.D))keys.add(Key.D);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_A)
        {
            if(!pressed(Key.A))keys.add(Key.A);
        }
        
        
        if (k.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            if(!pressed(Key.ESC))keys.add(Key.ESC);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_R)
        {
            if(!pressed(Key.R))keys.add(Key.R);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_T)
        {
            if(!pressed(Key.T))keys.add(Key.T);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_Z)
        {
            if(!pressed(Key.Z))keys.add(Key.Z);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_F)
        {
            if(!pressed(Key.F))keys.add(Key.F);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_G)
        {
            if(!pressed(Key.G))keys.add(Key.G);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_H)
        {
            if(!pressed(Key.H))keys.add(Key.H);
        }
        
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD4)
        {
            if(!pressed(Key.VIER))keys.add(Key.VIER);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD5)
        {
            if(!pressed(Key.FÜNF))keys.add(Key.FÜNF);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD6)
        {
            if(!pressed(Key.SECHS))keys.add(Key.SECHS);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD7)
        {
            if(!pressed(Key.SIEBEN))keys.add(Key.SIEBEN);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD8)
        {
            if(!pressed(Key.ACHT))keys.add(Key.ACHT);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD9)
        {
            if(!pressed(Key.NEUN))keys.add(Key.NEUN);
        }
        
        
        if (k.getKeyCode() == KeyEvent.VK_UP)
        {
            if(!pressed(Key.OBEN))keys.add(Key.OBEN);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(!pressed(Key.UNTEN))keys.add(Key.UNTEN);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(!pressed(Key.RECHTS))keys.add(Key.RECHTS);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(!pressed(Key.LINKS))keys.add(Key.LINKS);
        }
    }

    public void keyReleased(KeyEvent k) 
    {
        if (k.getKeyCode() == KeyEvent.VK_W)
        {
            keys.remove(Key.W);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_S)
        {
            keys.remove(Key.S);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_D)
        {
            keys.remove(Key.D);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_A)
        {
            keys.remove(Key.A);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            keys.remove(Key.ESC);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_R)
        {
            keys.remove(Key.R);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_T)
        {
            keys.remove(Key.T);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_Z)
        {
           keys.remove(Key.Z);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_F)
        {
            keys.remove(Key.F);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_G)
        {
            keys.remove(Key.G);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_H)
        {
           keys.remove(Key.H);
        }
        
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD4)
        {
           keys.remove(Key.VIER);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD5)
        {
            keys.remove(Key.FÜNF);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD6)
        {
            keys.remove(Key.SECHS);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD7)
        {
            keys.remove(Key.SIEBEN);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD8)
        {
            keys.remove(Key.ACHT);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_NUMPAD9)
        {
            keys.remove(Key.NEUN);
        }
        
        
        if (k.getKeyCode() == KeyEvent.VK_UP)
        {
            keys.remove(Key.OBEN);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_DOWN)
        {
            keys.remove(Key.UNTEN);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_RIGHT)
        {
           keys.remove(Key.RECHTS);
        }
        
        if (k.getKeyCode() == KeyEvent.VK_LEFT)
        {
            keys.remove(Key.LINKS);
        }
    }
    
    public boolean dispatchKeyEvent(KeyEvent e) 
    {
        if(e.getID() == KeyEvent.KEY_PRESSED)keyPressed(e);
        if(e.getID() == KeyEvent.KEY_RELEASED)keyReleased(e);
        return true;
    }
    
    
    public enum Key
    {
        OBEN,UNTEN,RECHTS,LINKS,ESC,W,A,S,D,R,T,Z,F,G,H,VIER,ACHT,FÜNF,SECHS,SIEBEN,NEUN;
    }

}
