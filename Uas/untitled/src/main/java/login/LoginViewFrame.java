package login;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.util.prefs.Preferences;

public class LoginViewFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JButton batalButton;

    public LoginViewFrame(){
        setContentPane(mainPanel);
        loginButton.addActionListener(e -> {
            if  (textField1.getText().equals("admin")){
                if (new String(textField2.getText()).equals("admin")){
                    Preferences pref = Preferences.userRoot().node(Main.class.getName());
                    pref.put("USER_ID","1");
                    LoginViewFrame LV = new LoginViewFrame();
                    dispose();
                }
            }
        });
    }
}
