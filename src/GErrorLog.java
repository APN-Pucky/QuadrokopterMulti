
import javax.swing.JOptionPane;
public class GErrorLog
{
    
    public static void e(String msg)
    {
        JOptionPane.showMessageDialog(null, msg);
        System.exit(1);
    }
}
