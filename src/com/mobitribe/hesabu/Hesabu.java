package com.mobitribe.hesabu;

import com.codename1.io.Log;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Toolbar;
import com.codename1.io.Storage;
import java.io.IOException;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class Hesabu 
{

    private Form current;
    private Resources theme;

    public void init(Object context) 
    {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        //theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        //Log.bindCrashProtection(true);

        /*
        addNetworkErrorListener(err -> 
        {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) 
            {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });   
        */
    }
    
    public void start() 
    {
        if(current != null)
        {
            current.show();
            return;
        }
        
        if(Storage.getInstance().exists("loginstatus") == true)
        {
            String str_Login_Status = (String)Storage.getInstance().readObject("loginstatus"); 
            if("OKL".equals(str_Login_Status))
            {
                if(Storage.getInstance().exists("keepmeloggedin") == true)
                {
                    String str_keepmeinside = (String) Storage.getInstance().readObject("keepmeloggedin");  
                    if("yes".equals(str_keepmeinside))
                    {
                        MainMenu homer = new MainMenu();
                        homer.showMainMenu();
                    }
                    else
                    {
                        LoginMenu loginer = new LoginMenu();
                        loginer.showLoginScreen();
                    }
                }
                else
                {
                    LoginMenu loginer = new LoginMenu();
                    loginer.showLoginScreen(); 
                }
            }
            else if("NOL".equals(str_Login_Status))
            {
                LoginMenu loginer = new LoginMenu();
                loginer.showLoginScreen();
            }
        }
        else
        {
            Connect.storage.writeObject("screen", "login");
            Connect.storage.writeObject("parameter1", "settings");
            Connect.storage.writeObject("parameter2", "Ksda_Church");
            Connect.storage.writeObject("parameter3", "");
            Connect.storage.writeObject("parameter4", "");
            Connect.storage.writeObject("parameter5", "");
            Connect.storage.writeObject("parameter6", "");
            Connect.storage.writeObject("parameter7", "");
            Connect.storage.writeObject("parameter8", "");
            Connect.storage.writeObject("parameter9", "");
            Connect.storage.writeObject("parameter10", "");
            Connect.storage.writeObject("parameter11", "");
            Connect.storage.writeObject("parameter12", "");
            Connect.storage.writeObject("parameter13", "");
            Connect.storage.writeObject("parameter14", "");
            Connect.storage.writeObject("parameter15", "");
            Connect.storage.writeObject("parameter16", "");
            Connect.storage.writeObject("parameter17", "");
            Connect.storage.writeObject("parameter18", "");
            Connect.storage.writeObject("parameter19", "");
            Connect.storage.writeObject("parameter20", "");

            //we have some connection
            Log.p("Sending data to the database server.", 1);
            Connect connector = new Connect();
            try 
            {
                connector.process();
            } 
            catch (IOException io) 
            {
                Log.p("Error: "+io, 1);
            }
        }
    }

    public void stop() 
    {
        current = getCurrentForm();
        
        if(current instanceof Dialog) 
        {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() 
    {
    }

}
