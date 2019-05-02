import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Audio
{
    public static void playSound(final String s) 
    {
        new Thread(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new FileInputStream(new File(s)));
                    clip.open(inputStream);
                    clip.start();
                    while(clip.isRunning())
                    {
                        Thread.sleep(1000);
                    }
                } 
                catch (Exception e) 
                {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
