import java.io.*;
public class Config
{
    File dir;
    File config;
    String path;
    
    double size_x = 512;
    double size_y = 255;
    double size_z = 512;
    String ground = "hoehen.jpg";
    String ground_txt = "txt.jpg";
    
    double qk_size = 10;
    double qk_movspeed = 0.5;
    double qk_upspeed = 0.5;
    double qk_rotspeed = 0.1;
    double qk_rotorspeed = 2;
    double qk_health = 10;
    double qk_reload = 30;
    String qk_txt = "Texturen\\Quadrokopter\\GruenMilitaer";
    
    double qk_1_x = 0;
    double qk_1_y = 100;
    double qk_1_z = 0;
    
    double qk_2_x = 100;
    double qk_2_y = 100;
    double qk_2_z = 0;
    
    RSSPointContainer light_pos = new RSSPointContainer();
    
    RSSPointContainer quader_pos = new RSSPointContainer();
    RSSPointContainer quader_scl = new RSSPointContainer();
    RSSPointContainer quader_ang = new RSSPointContainer();
    StringContainer quader_txt = new StringContainer(); 
    
    double gesch_movspeed = 2;
    double gesch_damage = 2;
    double gesch_size = 2;
    String gesch_txt = "Texturen\\Geschoss\\Gold";
    
    double cam_x = 0;
    double cam_y = 0;
    double cam_z = 0;
    double cam_view_y = 0;
    
    String[] himmel_txt = new String[]{"himmel.jpg","himmel.jpg","himmel.jpg","himmel.jpg","himmel.jpg"}; 
    
    public Config(String path)
    {
        this.path = path;
        dir = new File(path);
        config = new File(path,"welt.conf");
        try
        {
            update();
        }
        catch(Exception e)
        {
            Global.err.e(e.getMessage());
        }
    }
    
    public void update() throws Exception
    {
        FileInputStream fis = new FileInputStream(config);
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null)   
        {
            handleString(line);
        }
    }
    
    public void handleString(String s)
    {
        if(s.charAt(0)=='#')return;
        String[] split = s.split(":");
        if(split.length<2)return;
        switch(split[0].toLowerCase())
        {
            case("weltgroesse"):  
                            if(split.length<4)return;
                            size_x = Double.parseDouble(split[1]);
                            size_y = Double.parseDouble(split[2]);
                            size_z = Double.parseDouble(split[3]);
                            break;
            case("boden"):  
                            ground = path + "\\" + split[1];
                            break;
            case("bodentxt"):  
                            ground_txt = path + "\\" + split[1];
                            break;
            case("qkgroesse"):
                            qk_size = Double.parseDouble(split[1]);
                            break;
            case("qkbewegung"):
                            qk_movspeed = Double.parseDouble(split[1]);
                            break;
            case("qkdrehung"):
                            qk_rotspeed = Double.parseDouble(split[1]);
                            break;
            case("qksteigung"):
                            qk_upspeed = Double.parseDouble(split[1]);
                            break;
            case("qkrotor"):
                            qk_rotorspeed = Double.parseDouble(split[1]);
                            break;
            case("qktxt"):
                            qk_txt = split[1];
                            break;
            case("qkleben"):
                            qk_health = Double.parseDouble(split[1]);
                            break;
            case("qknachladen"):
                            qk_reload = Double.parseDouble(split[1]);
                            break;
            case("qu1"):  
                            if(split.length<4)return;
                            qk_1_x = Double.parseDouble(split[1]);
                            qk_1_y = Double.parseDouble(split[2]);
                            qk_1_z = Double.parseDouble(split[3]);
                            break;
            case("qu2"):  
                            if(split.length<4)return;
                            qk_2_x = Double.parseDouble(split[1]);
                            qk_2_y = Double.parseDouble(split[2]);
                            qk_2_z = Double.parseDouble(split[3]);
                            break;
            case("licht"):  
                            if(split.length<4)return;
                            light_pos.add(new RSSPoint(
                            Double.parseDouble(split[1]),
                            Double.parseDouble(split[2]),
                            Double.parseDouble(split[3])));
                            break;
            case("geschschaden"):
                            gesch_damage = Double.parseDouble(split[1]);
                            break;
            case("geschbewegung"):
                            gesch_movspeed = Double.parseDouble(split[1]);
                            break;
            case("geschgroesse"):
                            gesch_size = Double.parseDouble(split[1]);
                            break;
            case("objekt"):
                            if(split.length<16)return;
                            quader_pos.add(new RSSPoint(
                            Double.parseDouble(split[1]),
                            Double.parseDouble(split[2]),
                            Double.parseDouble(split[3])));
                            quader_scl.add(new RSSPoint(
                            Double.parseDouble(split[4]),
                            Double.parseDouble(split[5]),
                            Double.parseDouble(split[6])));
                            quader_ang.add(new RSSPoint(
                            Double.parseDouble(split[7]),
                            Double.parseDouble(split[8]),
                            Double.parseDouble(split[9])));
                            quader_txt.add(split[10]);
                            quader_txt.add(split[11]);
                            quader_txt.add(split[12]);
                            quader_txt.add(split[13]);
                            quader_txt.add(split[14]);
                            quader_txt.add(split[15]);
                            break;
            case("himmeltxt"):  
                            if(split.length<6)return;
                            himmel_txt[0] = path + "\\" + split[1];
                            himmel_txt[1] = path + "\\" + split[2];
                            himmel_txt[2] = path + "\\" + split[3];
                            himmel_txt[3] = path + "\\" + split[4];
                            himmel_txt[4] = path + "\\" + split[5];
                            break;
            case("kamera"):  
                            if(split.length<5)return;
                            cam_x = Double.parseDouble(split[1]);
                            cam_y = Double.parseDouble(split[2]);
                            cam_z = Double.parseDouble(split[3]);
                            cam_view_y = Double.parseDouble(split[4]);
                            break;             
        }
    }
}
