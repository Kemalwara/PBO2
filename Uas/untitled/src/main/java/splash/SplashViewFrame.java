package splash;

import com.sun.tools.javac.Main;
import frame.RentalViewFrame;
import login.LoginViewFrame;

import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

public class SplashViewFrame extends JFrame{
    private JPanel mainPanel;

    public SplashViewFrame(){
        setContentPane(mainPanel);
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Preferences pref = Preferences.userRoot().node(Main.class.getName());
        String userID = pref.get("USER_ID", "");
        System.out.println(userID);

        try {
            TimeUnit.SECONDS.sleep(2);
            if(userID.equals("")){
                setVisible(false);
                LoginViewFrame lf = new LoginViewFrame();
                lf.setVisible(true);
                lf.setSize(320,140);
            } else {
                setVisible(false);
                RentalViewFrame RV = new RentalViewFrame();
                RV.setVisible(true);
                RV.setSize(320,120);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
