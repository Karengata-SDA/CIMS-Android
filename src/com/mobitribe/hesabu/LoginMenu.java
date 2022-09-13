
package com.mobitribe.hesabu;

import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.*;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
//import com.tribedigital.omega.Utilz.Commonz;
//import com.tribedigital.jibumobile.Utilz.StringSplit;

import java.io.IOException;

import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.FlowLayout;
//import com.tribedigital.omega.Utilz.Images;
//import com.tribedigital.omega.Utilz.Synchronise;
import java.util.Timer;

import com.mobitribe.hesabu.Connect;
import static com.mobitribe.hesabu.MainMenu.txtf_memberno;
import java.io.InputStream;
//import org.littlemonkey.connectivity.Connectivity;

public class LoginMenu 
{
    //FORMS
    private Form fm_main;
    
    //DIALOGUES
    Dialog dlg_language;
    
    //BUTTONS
    private Button btn_submit, btn_exit, btn_tuma; 
    private Button btn_language;
    private Button btn_register, btn_jisajili;
        
    //RADIOBUTTONS
    private RadioButton btnRd_English, btnRd_Kiswahili;
    
    //ButtonGroups
    private ButtonGroup btnGp_Language;
    
    //IMAGES
    private Image img_title;
    private Image img_header;
    private Image img_body;
    private Image img_footer;
    private Image user_id;
    private Image pass_wd;
    private Image img_background, img_logo;
    
    //LABELS
    private Label lbl_language, lbl_english, lbl_swahili;
    private Label lbl_title;
    private Label lbl_header;
    private Label lbl_footer;
       
    private Label lbl_Tbar;
    
    
    //classes
    //private SplashScreen cls_splash;
    //private Images cls_images;
    
    //CONTAINERS
    private Container cont_language, cont_rbEnglish, cont_rbSwahili;
    private Container cont_title;
    private Container cont_header;
    private Container cont_body;
    private Container cont_footer;
    private Container cnt_usnpwd;
    private Container cnt_usn, cnt_usnicon, cnt_usntext;
    private Container cnt_pwd, cnt_pwdicon, cnt_pwdtext;
    private Container cnt_btn;
    
    //LABEL
    private Label lbl_usnicon, lbl_pwdicon;
    
    
    //TEXTAREAS
    
    public static TextArea txt_transaction;
    
    //TEXTFIELDS
    public static TextField txtf_username;
    public static TextField txtf_password;
    TextField txf_jinatumizi;
    public TextField txf_nywila;
    
    //STORAGES
    //private Storage storage = Storage.getInstance();
    
    //FONTS
    private Font font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    
    int displayWidth = Display.getInstance().getDisplayWidth();
    int displayHeight = Display.getInstance().getDisplayHeight();
    
    public static NetworkManager networkManager;
    
    
    //Commonz commonz = new Commonz();
    //Synchronise sinkanyuabongo = new Synchronise();
    
    private static final int POLL_FREQUENCY = 5000;
    private long lastPolling;
    private boolean responseReceived = true;

    private Timer timer;
    
    //STRINGS
    private String un;
    private String str_username;
    private String str_password;
    
    private String str_Login_Status;
    private boolean bool_Login_staus;
    
    
    private String str_Language_english;
    private String str_Language_kiswahili;
    
    private String str_prep;
    
    private String str_Language, str_login_status, str_data;
    private String str_agent_id, str_agent_name, str_aspirant_id, str_station_id;
    private boolean bool_Language;
    
    private Resources theme;
    
    private Font font_small_bold, font_small_plain, font_medium_uline, font_medium_bold, font_medium_plain, font_large_bold, font_large_plain;
    int int_zero_pt_five, int_one, int_one_pt_five, int_two, int_three, int_five_Pt_five;
    
    private FontImage ifont_username, ifont_password;
    
    private Style sty_iconsbar, sty_usn_icon, sty_pwd_icon;
    
    double pixelsPerMM = ((double)Display.getInstance().convertToPixels(10, true)) / 10.0; 
    
    private Label lbl_rememberme, lbl_logmein, lbl_forgotpw;
    public static CheckBox cb_rmemberme;
    private SpanLabel splbl_signmeup, slbl_activate;
    
    
    private String str_bool_loggedin, str_bool_keepmeloggedin;
    private boolean bool_loggedin, bool_keepmeloggedin;


    private String str_scandika;


    private FontImage imgf_love;
    private Style s;

    public static CheckBox chbox_keepmeloggedin;
    private Label lbl_keepmeloggedin, lbl_loginsomeoneelse, lbl_signmeup, lbl_forgotcreds;
    private Container cnt_rememberme;

    private Command cmd_back;
    
    private int int_dispW, int_dispH;
    
    public LoginMenu()
    {
    }
      

    public void showLoginScreen()
    {
      
        int_dispW = Display.getInstance().getDisplayWidth();
        int_dispH = Display.getInstance().getDisplayHeight();
        
        try
        {
            InputStream is = Storage.getInstance().createInputStream("theme.res");
            theme = Resources.open(is);
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0])); 
            
            img_background = Image.createImage(Connect.storage.createInputStream("background.jpg")).scaledHeight(int_dispH);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.err.println("Error: "+ex);
        }
      
      double pixelsPerMM = ((double)Display.getInstance().convertToPixels(10, true)) / 10.0;

         font_small_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL);
         font_medium_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
         font_large_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
         font_small_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
         font_medium_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
         font_large_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);
         
      
      
      fm_main = new Form();
      fm_main.setTitle("");
      fm_main.getTitleArea().setPreferredSize(new Dimension(0, 0));
      fm_main.getTitleArea().removeAll();
      fm_main.setLayout(new BorderLayout());
      fm_main.setScrollableY(true); //--TODO: put sticky header here.
      fm_main.getAllStyles().setAlignment(CENTER);
      fm_main.getStyle().setBgImage(img_background, false); 
      fm_main.getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL, false);
      
      
      Display.getInstance().setScreenSaverEnabled(false);
      fm_main.getStyle().setBgColor(0x000000); //0xa43500 //0xff6600 - orange //0xe23333 - redish //0xFF3333   //0x000000 -- black
      fm_main.setScrollableY(true);
      Display.getInstance().lockOrientation(true);
      Display.getInstance().setScreenSaverEnabled(false);
      
      
      int width = fm_main.getWidth();
      
      fm_main.getTitleStyle().setPadding(0, 0, 0, 0);
      fm_main.getTitleStyle().setBgColor(0x000000, false);
      fm_main.getTitleComponent().getStyle().setBgColor(0x000000);
      //fm_login.setPreferredW(width);
      fm_main.setScrollable(false);
      fm_main.getStyle().setPadding(0, 0, 0, 0);
      fm_main.getStyle().setMargin(0, 0, 0, 0);
      
      
      lbl_title = new Label("Login Screen"); //img_title
      //lbl_title.setIcon(img_title);
      lbl_title.setAlignment(CENTER);
      lbl_title.getStyle().setBgColor(0x000000); //redish -- 0xFF3333
      lbl_title.getStyle().setFgColor(0xff6600);
      lbl_title.getStyle().setMargin(0, 0, 0, 0);
      lbl_title.getStyle().setPadding(0, 0, 0, 0);
      //lbl_title.getStyle(Style.BACKGROUND_IMAGE_SCALED_FIT, false);
      //lbl_title.setIcon(img_body.Style.BACKGROUND_IMAGE_SCALED_FIT, false);
      //fm_main.setTitleComponent(lbl_title);
      
      lbl_header = new Label(); //img_logo
      lbl_header.setIcon(theme.getImage("logo.png"));
      //lbl_header.setText("Health Wallet");
      lbl_header.setTextPosition(BOTTOM);        
      //lbl_header.setPreferredSize(dim);
      lbl_header.setAlignment(CENTER);
      lbl_header.getStyle().setMargin(0, 0, 0, 0);
      lbl_header.getStyle().setPadding(0, 0, 0, 0);
      lbl_header.getStyle().setBgTransparency(0, false);
      lbl_header.getStyle().setFgColor(0xffffff);
      lbl_header.getStyle().setFont(font_large_bold);
      
           
      cont_header = new Container(new BoxLayout(BoxLayout.X_AXIS));
      cont_header.setScrollableY(true);
      TableLayout tablelayout = new TableLayout(2, 1);
      tablelayout.setGrowHorizontally(true);
      tablelayout.isGrowHorizontally();
      tablelayout.hasHorizontalSpanning();
      cont_header.setLayout(tablelayout);
      //cont_header.addComponent(lbl_header);
      
      sty_usn_icon = new Style(); 
      sty_usn_icon.setBorder(null, false);
      sty_usn_icon.setBgTransparency(255, false);
      sty_usn_icon.setFgColor(0xffffff, false);
      sty_usn_icon.setBgColor(0x448d21, false);
      //sty_icons_loginform.getMaterialDesignFont
      
      ifont_username = FontImage.createMaterial(FontImage.MATERIAL_EMAIL, sty_usn_icon, 4);
      
      lbl_usnicon = new Label(ifont_username);
      lbl_usnicon.getAllStyles().setBgTransparency(0, false);
      lbl_usnicon.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_usnicon.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_usnicon = new Container();
      cnt_usnicon.getUnselectedStyle().setBgTransparency(255, false);
      cnt_usnicon.getUnselectedStyle().setBgColor(0x448d21, false); //0x448d21
      cnt_usnicon.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_usnicon.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_usnicon.add(lbl_usnicon);
      
      txtf_username = new TextField("");
      txtf_username.setHint(" Username"); 
      //txta_username.setHintIcon(ifont_username);
      //txta_username.setHintIcon(FontImage.createMaterial(FontImage.MATERIAL_EMAIL, cnt_usnicon.getUnselectedStyle()));
      txtf_username.getHintLabel().setUnselectedStyle(sty_usn_icon);
      txtf_username.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txtf_username.getHintLabel().getAllStyles().setFgColor(0x999999);
      txtf_username.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txtf_username.setConstraint(TextField.SENSITIVE);
      txtf_username.setFocusable(true);
      txtf_username.setRows(2);
      txtf_username.setSingleLineTextArea(true);
      txtf_username.setVerticalAlignment(CENTER);
      
      Style sty = new Style();
      sty.setBorder(null);
      sty.setFgColor(0x5B2BFB);
      sty.setBgTransparency(220, false);
            
      Style s1 = new Style();
      s1.setBgColor(0x000000);
      s1.setFgColor(0x5B2BFB);
      txtf_username.setSelectedStyle(s1);
      txtf_username.setUnselectedStyle(sty);
      txtf_username.setPressedStyle(s1);
      txtf_username.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_usn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      cnt_usn.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_usn.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_usn.add(BoxLayout.encloseX(cnt_usnicon, txtf_username));
      
      
      
      sty_pwd_icon = new Style(); 
      sty_pwd_icon.setBorder(null, false);
      sty_pwd_icon.setBgTransparency(255, false);
      sty_pwd_icon.setFgColor(0xffffff, false);
      sty_pwd_icon.setBgColor(0x448d21, false);
      
      ifont_password = FontImage.createMaterial(FontImage.MATERIAL_LOCK, sty_pwd_icon, 4);
      
      lbl_pwdicon = new Label(ifont_password);
      lbl_pwdicon.getAllStyles().setBgTransparency(0, false);
      lbl_pwdicon.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_pwdicon.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_pwdicon = new Container();
      cnt_pwdicon.getUnselectedStyle().setBgTransparency(255, false);
      cnt_pwdicon.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_pwdicon.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_pwdicon.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_pwdicon.add(lbl_pwdicon);
      
      txtf_password= new TextField("");
      txtf_password.setHint(" Password"); 
      txtf_password.getHintLabel().setUnselectedStyle(sty_usn_icon);
      txtf_password.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txtf_password.getHintLabel().getAllStyles().setFgColor(0x999999);
      txtf_password.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txtf_password.setConstraint(TextField.PASSWORD | TextField.SENSITIVE);
      txtf_password.setFocusable(true);
      txtf_password.setRows(2);
      txtf_password.setSingleLineTextArea(true);
      txtf_password.setVerticalAlignment(CENTER);  
      txtf_password.setSelectedStyle(s1);
      txtf_password.setUnselectedStyle(sty);
      txtf_password.setPressedStyle(s1);
      txtf_password.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_pwd = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      cnt_pwd.getUnselectedStyle().setPadding(0, 0, 0, 0); //(int)(4 * pixelsPerMM)
      cnt_pwd.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_pwd.add(BoxLayout.encloseX(cnt_pwdicon, txtf_password));
      
      cb_rmemberme = new CheckBox("Remember me");
      cb_rmemberme.setUIID("Label");
      cb_rmemberme.setTickerEnabled(false);
      cb_rmemberme.getAllStyles().setBorder(null, false);
      cb_rmemberme.getAllStyles().setFgColor(0xffffff);
      //cb_rmemberme.getAllStyles().setBgColor(0xffffff);
      cb_rmemberme.getUnselectedStyle().setBgTransparency(255, false);
      cb_rmemberme.getUnselectedStyle().setBgColor(0x448d21, false);
      //cb_rmemberme.getAllStyles().setBgTransparency(0, false);
      cb_rmemberme.getAllStyles().setFont(font_small_plain, false);
      cb_rmemberme.getUnselectedStyle().setPadding((int)(1 * pixelsPerMM), (int)(1 * pixelsPerMM), 0, 0);
      cb_rmemberme.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                str_bool_keepmeloggedin = String.valueOf(cb_rmemberme.isSelected());
                System.out.println("chbox_keepmeloggedin checked: "+str_bool_keepmeloggedin);

                if(cb_rmemberme.isSelected())
                {
                    //Storage.getInstance().writeObject("keepmeloggedin", "no");
                    cb_rmemberme.setSelected(false);
                    //Dialog.show("Alert!", "You have chosen to stay logged in.", "OK", null);
                }
                else if(cb_rmemberme.isSelected() == false)
                {
                    //Storage.getInstance().writeObject("keepmeloggedin", "yes");
                    //Dialog.show("Alert!", "You have choosen not to stay looged in.", "OK", null);
                    cb_rmemberme.setSelected(true);
                }
            }
        });
            
      lbl_forgotpw = new Label("I forgot my login credentials!"); //Forgot password? //Don't know password?
      lbl_forgotpw.getAllStyles().setFgColor(0xffffff); //0x448d21
      lbl_forgotpw.getAllStyles().setBgTransparency(0, false);
      lbl_forgotpw.getAllStyles().setFont(font_small_plain, false); 
      lbl_forgotpw.getUnselectedStyle().setPadding((int)(1 * pixelsPerMM), (int)(1 * pixelsPerMM), 0, 0);
      lbl_forgotpw.addPointerPressedListener(new ActionListener() 
      {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
                TextArea txta_instructions = new TextArea();
                txta_instructions.setText("Please enter the phone number and/or email that registered with and we will send you a One Time Passcode (OTP) number that you'll use to reset your password."); //WARNING!!! /n This will 
                txta_instructions.setGrowByContent(true);
                txta_instructions.setSingleLineTextArea(false);
                txta_instructions.setEditable(false);
                txta_instructions.setFocusable(false);
                txta_instructions.setUIID("Label");
                
                Style sty_icon = new Style(); 
                sty_icon.setBorder(null, false);
                sty_icon.setBgTransparency(255, false);
                sty_icon.setFgColor(0xffffff, false);
                sty_icon.setBgColor(0x448d21, false);

                Style sty_icon_eml = new Style(); 
                sty_icon_eml.setBorder(null, false);
                sty_icon_eml.setBgTransparency(255, false);
                sty_icon_eml.setFgColor(0xffffff, false);
                sty_icon_eml.setBgColor(0x448d21, false);
                FontImage ifont_eml = FontImage.createMaterial(FontImage.MATERIAL_EMAIL, sty_icon_eml, 4);

                Label lbl_icon_eml = new Label(ifont_eml);
                lbl_icon_eml.getAllStyles().setBgTransparency(0, false);
                lbl_icon_eml.getAllStyles().setPadding(4, 4, 4, 4);
                lbl_icon_eml.getAllStyles().setMargin(4, 4, 4, 4);     

                Container cnt_icon_eml = new Container();
                cnt_icon_eml.getUnselectedStyle().setBgTransparency(255, false);
                cnt_icon_eml.getUnselectedStyle().setBgColor(0x448d21, false);
                cnt_icon_eml.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
                cnt_icon_eml.getUnselectedStyle().setMargin(0, 0, 0, 0);
                cnt_icon_eml.add(lbl_icon_eml);  

                TextField txtf_eml = new TextField("");
                txtf_eml.setHint(" Email Address"); 
                //txta_username.setHintIcon(ifont_username);
                //txta_username.setHintIcon(FontImage.createMaterial(FontImage.MATERIAL_EMAIL, cnt_emlicon.getUnselectedStyle()));
                txtf_eml.getHintLabel().setUnselectedStyle(sty_icon);
                txtf_eml.getHintLabel().getAllStyles().setBgTransparency(255, false);
                txtf_eml.getHintLabel().getAllStyles().setFgColor(0x999999);
                txtf_eml.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
                txtf_eml.setConstraint(TextField.SENSITIVE);
                txtf_eml.setFocusable(true);
                txtf_eml.setRows(2);
                txtf_eml.setSingleLineTextArea(true);
                txtf_eml.setVerticalAlignment(CENTER);
                txtf_eml.setSelectedStyle(s1);
                txtf_eml.setUnselectedStyle(sty);
                txtf_eml.setPressedStyle(s1);
                txtf_eml.getAllStyles().setPadding(10, 10, 10, 10);

                Container cnt_eml = new Container();
                cnt_eml.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
                cnt_eml.getUnselectedStyle().setMargin(0, 0, 0, 0);
                cnt_eml.add(BoxLayout.encloseX(cnt_icon_eml, txtf_eml));
        
                Style sty_icon_phn = new Style(); 
                sty_icon_phn.setBorder(null, false);
                sty_icon_phn.setBgTransparency(255, false);
                sty_icon_phn.setFgColor(0xffffff, false);
                sty_icon_phn.setBgColor(0x448d21, false);
                FontImage ifont_phn = FontImage.createMaterial(FontImage.MATERIAL_PHONE, sty_icon_phn, 4);

                Label lbl_icon_phn = new Label(ifont_phn);
                lbl_icon_phn.getAllStyles().setBgTransparency(0, false);
                lbl_icon_phn.getAllStyles().setPadding(4, 4, 4, 4);
                lbl_icon_phn.getAllStyles().setMargin(4, 4, 4, 4);     

                Container cnt_icon_phn = new Container();
                cnt_icon_phn.getUnselectedStyle().setBgTransparency(255, false);
                cnt_icon_phn.getUnselectedStyle().setBgColor(0x448d21, false);
                cnt_icon_phn.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
                cnt_icon_phn.getUnselectedStyle().setMargin(0, 0, 0, 0);
                cnt_icon_phn.add(lbl_icon_phn);

                TextField txtf_phn = new TextField("");
                txtf_phn.setHint(" Phone Number"); 
                txtf_phn.getHintLabel().setUnselectedStyle(sty_icon);
                txtf_phn.getHintLabel().getAllStyles().setBgTransparency(255, false);
                txtf_phn.getHintLabel().getAllStyles().setFgColor(0x999999);
                txtf_phn.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
                txtf_phn.setConstraint(TextField.SENSITIVE);
                txtf_phn.setFocusable(true);
                txtf_phn.setRows(2);
                txtf_phn.setSingleLineTextArea(true);
                txtf_phn.setVerticalAlignment(CENTER);
                txtf_phn.setSelectedStyle(s1);
                txtf_phn.setUnselectedStyle(sty);
                txtf_phn.setPressedStyle(s1);
                txtf_phn.getAllStyles().setPadding(10, 10, 10, 10);

                Container cnt_phn = new Container();
                cnt_phn.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
                cnt_phn.getUnselectedStyle().setMargin(0, 0, 0, 0);
                cnt_phn.add(BoxLayout.encloseX(cnt_icon_phn, txtf_phn));
                
                boolean bool_phone = Storage.getInstance().exists("phone");
                if(bool_phone)
                {
                    String str_phone = Storage.getInstance().readObject("phone").toString();
                    txtf_phn.setText(str_phone);
                }
                else
                {
                    String str_phone = "";
                    txtf_phn.setText(str_phone);
                }

                boolean bool_email = Storage.getInstance().exists("email");
                if(bool_email)
                {
                    String str_email = Storage.getInstance().readObject("email").toString();
                    txtf_eml.setText(str_email);
                }
                else
                {
                    String str_email = "";
                }

                SpanLabel slbl = new SpanLabel("Do you want to proceed to get an OTP number?");
                slbl.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Yes");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {                       
                       
                       if(txtf_eml.getText().trim().equals("") && txtf_eml.getText().trim().equals(""))
                       {
                           Dialog.show("Oops!", "You must enter either the email address or the phone number that you registered with to proceed.", "OK", null);
                       }
                       else
                       {
                            Storage.getInstance().deleteStorageFile("keepmeloggedin");
                            Storage.getInstance().writeObject("loginstatus", "NOL");
                            
                            Storage.getInstance().writeObject("email", txtf_eml.getText().trim());
                            Storage.getInstance().writeObject("phone", txtf_phn.getText().trim());
                                
                            dialog.dispose();

                            Log.p("Going to fetch OTP Code from server.", 1);

                            Connect.storage.writeObject("parameter1", "otp");
                            Connect.storage.writeObject("parameter2", txtf_eml.getText().trim());
                            Connect.storage.writeObject("parameter3", txtf_phn.getText().trim());
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
                            Connect.storage.writeObject("parameter21", "");

                            Connect connector = new Connect();
                            try 
                            {
                                connector.process();
                            } 
                            catch (Exception ex) 
                            {
                                ex.printStackTrace();
                            }
                       }
                   }
                });

                Button btn_no = new Button("No");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, txta_instructions);
                dialog.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(cnt_eml, cnt_phn));
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
          }
      });
      
        lbl_loginsomeoneelse = new Label("Login as different user!");
        lbl_loginsomeoneelse.getAllStyles().setPadding(0, 0, 0, 0);
        lbl_loginsomeoneelse.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_loginsomeoneelse.getAllStyles().setBgTransparency(0);
        lbl_loginsomeoneelse.getAllStyles().setAlignment(LEFT, false);
        lbl_loginsomeoneelse.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                TextArea alertText = new TextArea();
                alertText.setText("Do you want to proceed login as different user?"); //WARNING!!! /n This will 
                alertText.setGrowByContent(true);
                alertText.setSingleLineTextArea(false);
                alertText.setEditable(false);
                alertText.setFocusable(false);
                alertText.setUIID("Label");

                SpanLabel slbl = new SpanLabel("Do you want to proceed login as different user?");
                slbl.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Yes");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {                       
                       Storage.getInstance().clearStorage();

                       dialog.dispose();

                       //LoginMenu loginer = new LoginMenu();
                       //loginer.showMainScreen();

                       //TODO: Return the below and remove the above (to help repain the screen and remove the 'Log me in as a different user link' and put the 'Not Registered' link).
                       //SplashScreen splasher = new SplashScreen();
                       //splasher.showMainForm();
                   }
                });

                Button btn_no = new Button("No");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                dialog.addComponent(BorderLayout.CENTER, slbl);
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
      
    chbox_keepmeloggedin = new CheckBox();
    //chbox_keepmeloggedin.setText("Keep me loggined in.");
    chbox_keepmeloggedin.setEnabled(true);
    chbox_keepmeloggedin.setTickerEnabled(false);
    chbox_keepmeloggedin.getAllStyles().setMargin((int)(0.5 * pixelsPerMM), 0, 0, 0);
    //checkBox.setTextPosition(LEFT);
    chbox_keepmeloggedin.getAllStyles().setAlignment(CENTER);
    //checkBox.isOppositeSide();
    //checkBox.getStyle().setFont(font);
    chbox_keepmeloggedin.getUnselectedStyle().setBgTransparency(255, false);
    chbox_keepmeloggedin.getUnselectedStyle().setBgColor(0x448d21, false);
    chbox_keepmeloggedin.getUnselectedStyle().setFgColor(0xffffff, false);
    //checkBox.setPreferredSize(new Dimension(100, 2));
    //checkBox.setShiftText(-3);
    //chbox_keepmeloggedin.setTactileTouch(true); 
    //checkBox.getStyle().setBgColor(0xdddd99);
    chbox_keepmeloggedin.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            str_bool_keepmeloggedin = String.valueOf(chbox_keepmeloggedin.isSelected());
            System.out.println("chbox_keepmeloggedin checked: "+str_bool_keepmeloggedin);

            if(str_bool_keepmeloggedin.equals("false"))
            {
                Storage.getInstance().writeObject("keepmeloggedin", "no");
                //cb_rmemberme.setSelected(false);
                //Dialog.show("Alert!", "You have chosen to stay logged in.", "OK", null);
            }
            else
            {
                Storage.getInstance().writeObject("keepmeloggedin", "yes");
                //Dialog.show("Alert!", "You have choosen not to stay looged in.", "OK", null);
                cb_rmemberme.setSelected(true);
            }
        }
    });

    lbl_keepmeloggedin = new Label("Keep me logged in.");
    lbl_keepmeloggedin.getAllStyles().setFgColor(0xffffff); //0x448d21
    lbl_keepmeloggedin.getAllStyles().setBgTransparency(0, false);
    lbl_keepmeloggedin.getAllStyles().setFont(font_small_bold, false);
    lbl_keepmeloggedin.addPointerPressedListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent evt) 
        {
            str_bool_keepmeloggedin = String.valueOf(chbox_keepmeloggedin.isSelected());
            System.out.println("chbox_keepmeloggedin checked: "+str_bool_keepmeloggedin);

            if(chbox_keepmeloggedin.isSelected())
            {
                Storage.getInstance().writeObject("keepmeloggedin", "no");
                chbox_keepmeloggedin.setSelected(false);
                //Dialog.show("Alert!", "You have chosen to stay logged in.", "OK", null);
            }
            else if(chbox_keepmeloggedin.isSelected() == false)
            {
                Storage.getInstance().writeObject("keepmeloggedin", "yes");
                chbox_keepmeloggedin.setSelected(true);
                //Dialog.show("Alert!", "You have choosen not to stay looged in.", "OK", null);
            }
        }
    });
        
    btn_submit = new Button();
    btn_submit.setText("SIGN IN");
    btn_submit.setAlignment(CENTER);    
    btn_submit.getStyle().setFgColor(0xffffff);
    btn_submit.getStyle().setBgColor(0x448d21);  //0x90CD48
    //btn_login.getStyle().setPadding(2, 0, 20, 20);
    //btn_login.setWidth(width-5);
    btn_submit.getUnselectedStyle().setBgTransparency(255, false);
    btn_submit.getUnselectedStyle().setBgColor(0x448d21, false);
    btn_submit.getAllStyles().setPadding(2, 2, 0, 0);
    btn_submit.getAllStyles().setMargin(2, 0, 0, 0);
    btn_submit.addActionListener(new ActionListener() 
    {
     @Override
     public void actionPerformed(ActionEvent evt) 
     {
        if (txtf_username.getText().equals("")) 
        {
            Connect.okayDialog("Oops!!!", "You must enter your email to proceed.");
            LocalNotification lcn = new LocalNotification();
            lcn.setId("demo-notification");
            lcn.setAlertBody("It's time to take a break and look at me");
            lcn.setAlertTitle("Break Time!");
            //lcn.setAlertSound("beep-01a.mp3");

            Display.getInstance().scheduleLocalNotification
            (
              lcn,
              System.currentTimeMillis() + 10 * 1000, // fire date/time
              LocalNotification.REPEAT_NONE           // Whether to repeat and what frequency
            );
        } 
        else if (txtf_password.getText().equals("")) 
        {
            Connect.okayDialog("Oops!!!", "You must enter a password to proceed.");   
        } 
        else 
        {
         bool_loggedin = Connect.storage.exists("loginstatus");
         if(bool_loggedin == true)
         {
          str_bool_loggedin = (String) Connect.storage.readObject("loginstatus");
          if("OKL".equals(str_bool_loggedin))
          {
           //str_password = (String) Connect.storage.readObject("password");
           //if(str_username == txf_username.getText() && str_password == txf_password.getText())
           //if(str_username == txf_username.getText().trim() && str_password == txf_password.getText().trim())
           //if((str_username == null ? txf_username.getText().trim() == null : str_username.equals(txf_username.getText().trim())) && str_password == txf_password.getText().trim())
                
              
            /*
                Krambacrypta kramba = new Krambacrypta();
                try 
                {
                    kramba.retrieve();
                } 
                catch (Exception ex) 
                {    
                }

                str_username = (String) Storage.getInstance().readObject("username");
                str_password = (String) Storage.getInstance().readObject("password");
                if(Krambacrypta.str_encrypted_un.equals(str_username) && Krambacrypta.str_encrypted_pw.equals(str_password)) 
                {
                }
              
                Krambacrypta kramba = new Krambacrypta();
                try 
                {
                    kramba.store();
                } 
                catch (Exception ex) 
                {    
                }

                str_username = (String) Commonz.storage.readObject("username");
                str_password = (String) Commonz.storage.readObject("password");
                if(Krambacrypta.str_encrypted_un.equals(str_username) && Krambacrypta.str_encrypted_pw.equals(str_password))  
                {
                }
            */
              
               if(txtf_username.getText().equals(Connect.storage.readObject("username").toString()) && 
                  txtf_password.getText().equals(Connect.storage.readObject("password").toString())) 
                {
                 //Dialog.show("Welcome!", "Your login was successful", "Ok", null);
                 //SubscriptionMenu subscriber = new SubscriptionMenu();
                 //subscriber.showMainScreen();

                     if("departments".equals((String) Storage.getInstance().readObject("screen")))
                     {
                         Storage.getInstance().writeObject("screen", "departments");
                         //DepartmentsMenu deparmentor = new DepartmentsMenu();
                         //deparmentor.showMainForm();
                     }
                     else
                     {
                         Storage.getInstance().writeObject("screen", "home");
                         MainMenu menuer = new MainMenu();
                         menuer.showMainMenu();
                     }
                }
                else //if(str_username != txf_username.getText().trim() || str_password != txf_password.getText().trim())
                {
                     Dialog.show("Oops!", "The username password combination you entered may be wrong. Please Try Again!", "Ok", null);
                }
               }
               else if("NOL".equals(str_bool_loggedin))
               {
                //Dialog.show("Mambo Bado!", "The username password combination you entered may be wrong. Please Try Again!", "Ok", null);
                //LoginScreen cls_login = new LoginScreen();
                //cls_login.showLoginScreen();

                    Connect.storage.writeObject("parameter1", "login"); //"authorisation"
                    //Connect.storage.writeObject("screen", "Login"); //TODO: Fond a logic of when and where to add this
                    Connect.storage.writeObject("parameter2", txtf_username.getText().trim());
                    Connect.storage.writeObject("parameter3", txtf_password.getText().trim());
                    Connect.storage.writeObject("parameter4", "");
                    Connect.storage.writeObject("parameter5", "");
                    Connect.storage.writeObject("parameter6", "");
                    Connect.storage.writeObject("parameter7", "");
                    Connect.storage.writeObject("parameter8", "");

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
               else
               {
                    Connect.storage.writeObject("parameter1", "login"); //"authorisation"
                    //Connect.storage.writeObject("screen", "Login"); //TODO: Fond a logic of when and where to add this
                    Connect.storage.writeObject("parameter2", txtf_username.getText().trim());
                    Connect.storage.writeObject("parameter3", txtf_password.getText().trim());
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
                    Connect.storage.writeObject("parameter21", "");

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
              else
              {
                    Connect.storage.writeObject("screen", "Login"); //TODO: Fond a logic of when and where to add this
                    
                    Connect.storage.writeObject("parameter1", "login");  //"authorisation"
                    Connect.storage.writeObject("parameter2", txtf_username.getText().trim());
                    Connect.storage.writeObject("parameter3", txtf_password.getText().trim());
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
                    Connect.storage.writeObject("parameter21", "");

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
      }
    });
      
     splbl_signmeup = new SpanLabel("I am not registered so sign me up!"); //Sign me up.
     splbl_signmeup.setFocusable(true);
     splbl_signmeup.getTextAllStyles().setFgColor(0xffffff);
     splbl_signmeup.getTextAllStyles().setBgTransparency(0, false);
     splbl_signmeup.getTextAllStyles().setFont(font_small_plain, false); 
     splbl_signmeup.getUnselectedStyle().setPadding((int)(1 * pixelsPerMM), (int)(1 * pixelsPerMM), 0, 0); 
     splbl_signmeup.addPointerPressedListener(new ActionListener() 
     {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
                Log.p("Sign me up label pressed.", 1);
                RegisterMenu landsregistra = new RegisterMenu();
                landsregistra.showMainMenu();
          }
      });
     
     slbl_activate = new SpanLabel(""); //Already a member! //Click here to activate your account or to register!
     slbl_activate.setFocusable(true);
     slbl_activate.getTextAllStyles().setFgColor(0xffffff);
     slbl_activate.getTextAllStyles().setBgTransparency(0, false);
     slbl_activate.getTextAllStyles().setFont(font_small_bold, false); 
     slbl_activate.getTextAllStyles().setPadding((int)(1 * pixelsPerMM), (int)(1 * pixelsPerMM), 0, 0);
     slbl_activate.addPointerPressedListener(new ActionListener() 
     {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
            Log.p("Activate label pressed.", 1);
            //Dialog.show("Notice!", "You will shortly recieve a Transaction Code via SMS. Enter it in the space ptovided", "Ok", null);
              
            /*
            Storage.getInstance().writeObject("parameter1", "search");
            Storage.getInstance().writeObject("parameter2", txta_phn.getText().trim());
            Storage.getInstance().writeObject("parameter3", Storage.getInstance().readObject("userid")); //txta_username.getText().trim()
            Storage.getInstance().writeObject("parameter4", ""); 
            Storage.getInstance().writeObject("parameter5", ""); 
            Storage.getInstance().writeObject("parameter6", ""); 
            Storage.getInstance().writeObject("parameter7", ""); 
            Storage.getInstance().writeObject("parameter8", ""); 
            Storage.getInstance().writeObject("parameter9", "");

            Connect connector = new Connect();
            try 
            {
                connector.process();
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
            */
            
            
            /*
            SMSInterceptor.grabNextSMS((value) -> 
            {
                if (value.contains(code)) 
                { //check if the sms contains the code that was sent to user phone number
                    //codeTextField.setText(code);
                    //verify(code); // verify user with the code
                }
            });
            */
          }
      });
     
    //Listen to incoming sms on the code input form
//    myForm.addShowListener(evt -> 
//    {
//        SMSInterceptor.grabNextSMS((value) -> 
//        {
//            if (value.contains(code)) 
//            { //check if the sms contains the code that was sent to user phone number
//                codeTextField.setText(code);
//                verify(code); // verify user with the code
//            }
//        });
//    });
        
      
     cnt_btn = new Container(new BorderLayout());
     //cnt_btn.add(BorderLayout.CENTER, btn_submit);
     
     btn_exit = new Button();
     btn_exit.setText("EXIT");
     btn_exit.setAlignment(CENTER);
     btn_exit.addActionListener(new ActionListener() 
     {
      public void actionPerformed(ActionEvent evt) 
      {
          Display.getInstance().exitApplication();
      }
     });
     
     
     cont_body = new Container(new BoxLayout(BoxLayout.Y_AXIS));
     //cont_body.setScrollableY(true);
     cont_body.getStyle().setPadding(0, 0, (int)(5 * pixelsPerMM), (int)(5 * pixelsPerMM));
     //cont_body.getStyle().setPaddingTop(displayHeight/2);
     cont_body.addComponent(cnt_usn); //FlowLayout.encloseCenterMiddle(cnt_usn)
     cont_body.addComponent(cnt_pwd); //FlowLayout.encloseCenterMiddle(cnt_pwd)
     cont_body.addComponent(BorderLayout.centerEastWest(null, null, BoxLayout.encloseX(chbox_keepmeloggedin, lbl_keepmeloggedin))); //cb_rmemberme
     cont_body.addComponent(btn_submit);
     cont_body.addComponent(BoxLayout.encloseY(BoxLayout.encloseXNoGrow(splbl_signmeup, slbl_activate), lbl_forgotpw));
     
     cont_footer = new Container(new BorderLayout());
     //cont_footer.add(BorderLayout.WEST, btn_exit);
     //cont_footer.add(BorderLayout.EAST, btn_submit);
        
      //fm_main.addComponent(BorderLayout.NORTH, lbl_header);
      fm_main.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterMiddle(BoxLayout.encloseY(lbl_header, cont_body))); //lbl_header, cont_body
      //fm_main.addComponent(BorderLayout.SOUTH, cont_footer);
    
      fm_main.showBack();
   }
  
    
}