package pack3;
import javax.swing.*;
import java.nio.file.Path;

public class desktop
{
    public String disp;
    public  Path getInputPath(String s) {/*Send a path (a String path) to open in a specific directory
         or if null default directory */

        JFileChooser jd = s == null ? new JFileChooser() : new JFileChooser(s);

        jd.setDialogTitle("Choose input file");
        int returnVal = jd.showOpenDialog(null);

        /* If user didn't select a file and click ok, return null Path object*/
        if (returnVal != JFileChooser.APPROVE_OPTION) return null;
        Path p1 = jd.getSelectedFile().toPath();
        disp = p1.toAbsolutePath().toString();
        disp=disp.replace("\\","/");
        System.out.println(disp);
        return jd.getSelectedFile().toPath();


    }
}

