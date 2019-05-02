import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FilenameFilter;

public class WorldSelector
{
    public static String showWorldSelectionInput() throws Exception
    {
        File f = new File("Maps");
        if(!(f.exists()&&f.isDirectory()))throw new Exception("No Maps folder!");
        String[] worlds = f.list(new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                File f = new File(dir,name);
                if(!f.isDirectory())return false;
                File conf = new File(f,"welt.conf");
                if((!conf.exists())||conf.isDirectory())return false;
                return true;
            }
        }
        );
        
        WorldSelectionPanel wsp = new WorldSelectionPanel(worlds);
        
		JOptionPane.showMessageDialog(null, wsp);
		
		
		return "Maps\\" + wsp.getSelectedWorld();
    }
    
    static class WorldSelectionPanel extends JPanel
    {
        JList list;
        DefaultListModel listModel;
        String[] worlds;
    
        public WorldSelectionPanel(String[] show)
        {
            super(new BorderLayout());
            worlds = show;
            listModel = new DefaultListModel();
            for(String s : show)
            {
                listModel.addElement(s/*s.split("\\")[s.split("\\").length-1]*/);
            }
            //Create the list and put it in a scroll pane.
            list = new JList(listModel);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setSelectedIndex(0);
            list.setVisibleRowCount(5);
            JScrollPane listScrollPane = new JScrollPane(list);
        
            add(listScrollPane, BorderLayout.CENTER);
        }
    
        public String getSelectedWorld()
        {
            return worlds[list.getSelectedIndex()];
        }
    }
}
