
package com.mobitribe.hesabu;

import com.codename1.components.MultiButton;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.ui.*;
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
import com.codename1.ui.geom.Dimension;
import static com.codename1.ui.layouts.BorderLayout.NORTH;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
//import com.tribedigital.omega.Utilz.Images;
//import com.tribedigital.omega.Utilz.Synchronise;
import java.util.Timer;

import com.mobitribe.hesabu.Connect;
import com.sun.javafx.font.FontConstants;
import java.io.InputStream;

public class RegisterMenu 
{
    //FORMS
    private Form fm_main;
    
    //DIALOGUES
    Dialog dlg_language;
    
    //BUTTONS
    private Button btn_submit, btn_exit, btn_portfolio, btn_propects, btn_withdraw, btn_chngpin, btn_borrow, btn_payloan; 
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
    
    
    private Container cnt_btn;
    
   
    
    //TEXTAREAS
    public TextArea txta_category, txta_type, txta_eno, txta_idno, txta_fname, txta_lname, txta_eml, txta_phn, txta_usn, txta_pwd, txta_pwd2;
       
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
    
    private FontImage ifont_category, ifont_type, ifont_eno, ifont_fname, ifont_lname, ifont_eml, ifont_phn, ifont_idno, ifont_usn, ifont_pwd, ifont_pwd2;
    
    private Style sty_iconsbar, sty_icon, sty_icon_fname, sty_icon_lname;
    
   
    private Container cnt_catg, cnt_icon_category, cnt_text_category;
    private Container cnt_type, cnt_icon_type, cnt_text_type;
    private Container cnt_eno, cnt_icon_eno, cnt_text_eno;
    private Container cnt_fname, cnt_icon_fname, cnt_text_fname;
    private Container cnt_lname, cnt_icon_lname, cnt_text_lname;
    private Container cnt_idno, cnt_icon_idno, cnt_text_idno;
    private Container cnt_eml, cnt_icon_eml, cnt_text_eml;
    private Container cnt_phn, cnt_icon_phn, cnt_text_phn;
    private Container cnt_usn, cnt_icon_usn, cnt_text_usn;
    private Container cnt_pwd, cnt_icon_pwd, cnt_text_pwd;
    private Container cnt_pwd2, cnt_icon_pwd2, cnt_text_pwd2;
    
     //LABEL
    private Label lbl_icon_category, lbl_icon_type, lbl_icon_eno, lbl_icon_fname, lbl_icon_lname, lbl_icon_eml, lbl_icon_phn, lbl_icon_idno, lbl_icon_usn, lbl_icon_pwd, lbl_icon_pwd2;
    
    
    double pixelsPerMM = ((double)Display.getInstance().convertToPixels(10, true)) / 10.0; 
    
    private int i, j, k;
    
    private int int_dispW, int_dispH;
    
    public RegisterMenu()
    {
    }
      

    public void showMainMenu()
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
      ((BorderLayout)fm_main.getLayout()).setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER);
      //fm_main.setScrollableY(true); //--TODO: put sticky header here.
      fm_main.getAllStyles().setAlignment(CENTER);
      fm_main.getStyle().setBgImage(img_background, false); 
      fm_main.getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL, false);
      
      
      Display.getInstance().setScreenSaverEnabled(false);
      fm_main.getStyle().setBgColor(0x000000); //0xa43500 //0xff6600 - orange //0xe23333 - redish //0xFF3333   //0x000000 -- black
      Display.getInstance().lockOrientation(true);
      Display.getInstance().setScreenSaverEnabled(false);
      
      
      int width = fm_main.getWidth();
      
      fm_main.getTitleStyle().setPadding(0, 0, 0, 0);
      fm_main.getTitleStyle().setBgColor(0x000000, false);
      fm_main.getTitleComponent().getStyle().setBgColor(0x000000);
      //fm_login.setPreferredW(width);
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
      
      
      
      lbl_header = new Label(theme.getImage("logo.png")); //img_logo
      //lbl_header.setPreferredSize(dim);
      lbl_header.setAlignment(CENTER);
      lbl_header.getStyle().setMargin(0, 0, 0, 0);
      lbl_header.getStyle().setPadding(0, 0, 0, 0);
      lbl_header.getStyle().setBgTransparency(0, false);
           
      cont_header = new Container(new BoxLayout(BoxLayout.X_AXIS));
      cont_header.setScrollableY(true);
      TableLayout tablelayout = new TableLayout(2, 1);
      tablelayout.setGrowHorizontally(true);
      tablelayout.isGrowHorizontally();
      tablelayout.hasHorizontalSpanning();
      cont_header.setLayout(tablelayout);
      cont_header.addComponent(lbl_header);
      
      Style sty = new Style();
      sty.setBorder(null);
      sty.setFgColor(0x5B2BFB);
      sty.setBgTransparency(220, false);
            
      Style s1 = new Style();
      s1.setBgColor(0x000000);
      s1.setFgColor(0x5B2BFB);
      
      sty_icon = new Style(); 
      sty_icon.setBorder(null, false);
      sty_icon.setBgTransparency(255, false);
      sty_icon.setFgColor(0xffffff, false);
      sty_icon.setBgColor(0x448d21, false);
      
      Style sty_icon_cat = new Style(); 
      sty_icon_cat.setBorder(null, false);
      sty_icon_cat.setBgTransparency(255, false);
      sty_icon_cat.setFgColor(0xffffff, false);
      sty_icon_cat.setBgColor(0x448d21, false);
      
      ifont_category = FontImage.createMaterial(FontImage.MATERIAL_BUILD, sty_icon_cat, 4);
      
      lbl_icon_category = new Label(ifont_category);
      lbl_icon_category.getAllStyles().setBgTransparency(0, false);
      lbl_icon_category.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_category.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_category = new Container();
      cnt_icon_category.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_category.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_category.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_category.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_category.add(lbl_icon_category);
      
      cnt_text_category = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      cnt_text_category.setScrollableY(true);
      cnt_text_category.getUnselectedStyle().setBgTransparency(255, false);
      cnt_text_category.getUnselectedStyle().setBgColor(0x999999, false);
      cnt_text_category.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_text_category.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_text_category.setSelectedStyle(s1);
      cnt_text_category.setUnselectedStyle(sty);
      cnt_text_category.setPressedStyle(s1);
      cnt_text_category.getAllStyles().setPadding(10, 10, 10, 10);
      
      txta_category = new TextField("");
      txta_category.setHint(" Choose Investor Type"); 
      //txta_username.setHintIcon(ifont_username);
      //txta_username.setHintIcon(FontImage.createMaterial(FontImage.MATERIAL_EMAIL, cnt_categoryicon.getUnselectedStyle()));
      txta_category.getHintLabel().setUnselectedStyle(sty_icon);
      txta_category.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_category.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_category.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_category.setConstraint(TextField.SENSITIVE);
      txta_category.setFocusable(true);
      txta_category.setRows(2);
      txta_category.setSingleLineTextArea(true);
      txta_category.setVerticalAlignment(CENTER);
      txta_category.setSelectedStyle(s1);
      txta_category.setUnselectedStyle(sty);
      txta_category.setPressedStyle(s1);
      txta_category.getAllStyles().setPadding(10, 10, 10, 10);
      txta_category.addPointerPressedListener(new ActionListener() 
      {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
              Dialog dlg_category = new Dialog();
              dlg_category.setScrollableY(true);
              dlg_category.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
              dlg_category.getAllStyles().setBorder(null);
              dlg_category.getAllStyles().setBgColor(0xffffff, false);
              dlg_category.getAllStyles().setBgTransparency(255, false);
                for(i=0; i <2; i++)
                {
                    MultiButton mb = new MultiButton();
                    if(i==0){mb.setTextLine1("Corporate");}else{mb.setTextLine1("Individual");}
                    mb.addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            Log.p("Category selected is "+mb.getTextLine1(), 1);
                            Storage.getInstance().writeObject("category", mb.getTextLine1());
                            txta_category.setText(mb.getTextLine1());
                            dlg_category.dispose();
                        }
                    });
                    dlg_category.add(mb);
                }
                //dlg_category.showPopupDialog(txta_category);
                dlg_category.setDisposeWhenPointerOutOfBounds(true);
                dlg_category.setDraggable(true);
                dlg_category.showPacked(NORTH, false);
          }
      });
      cnt_text_category.add(txta_category);
      
      cnt_catg = new Container();
      cnt_catg.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_catg.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_catg.add(BoxLayout.encloseX(cnt_icon_category, cnt_text_category));
      
      
      Style sty_icon_type = new Style(); 
      sty_icon_type.setBorder(null, false);
      sty_icon_type.setBgTransparency(255, false);
      sty_icon_type.setFgColor(0xffffff, false);
      sty_icon_type.setBgColor(0x448d21, false);
      
      ifont_type = FontImage.createMaterial(FontImage.MATERIAL_WIDGETS, sty_icon_type, 4);
      
      lbl_icon_type = new Label(ifont_type);
      lbl_icon_type.getAllStyles().setBgTransparency(0, false);
      lbl_icon_type.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_type.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_type = new Container();
      cnt_icon_type.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_type.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_type.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_type.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_type.add(lbl_icon_type);
      
      txta_type = new TextField("");
      txta_type.setHint(" Type"); 
      //txta_username.setHintIcon(ifont_username);
      //txta_username.setHintIcon(FontImage.createMaterial(FontImage.MATERIAL_EMAIL, cnt_typeicon.getUnselectedStyle()));
      txta_type.getHintLabel().setUnselectedStyle(sty_icon);
      txta_type.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_type.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_type.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_type.setConstraint(TextField.SENSITIVE);
      txta_type.setFocusable(true);
      txta_type.setRows(2);
      txta_type.setSingleLineTextArea(true);
      txta_type.setVerticalAlignment(CENTER);
      txta_type.setSelectedStyle(s1);
      txta_type.setUnselectedStyle(sty);
      txta_type.setPressedStyle(s1);
      txta_type.getAllStyles().setPadding(10, 10, 10, 10);
      txta_type.addPointerPressedListener(new ActionListener() 
      {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
              Dialog dlg_type = new Dialog();
              dlg_type.setScrollableY(true);
              dlg_type.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
              dlg_type.getAllStyles().setBorder(null);
              dlg_type.getAllStyles().setBgColor(0xffffff, false);
              dlg_type.getAllStyles().setBgTransparency(255, false);
                for(i=0; i <2; i++)
                {
                    MultiButton mb = new MultiButton();
                    if(i==0){mb.setTextLine1("Borrower");}else{mb.setTextLine1("Investor");}
                    mb.addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            Log.p("Type selected is "+mb.getTextLine1(), 1);
                            Storage.getInstance().writeObject("type", mb.getTextLine1());
                            txta_type.setText(mb.getTextLine1());
                            dlg_type.dispose();
                        }
                    });
                    dlg_type.add(mb);
                }
                //dlg_type.showPopupDialog(txta_type);
                dlg_type.setDisposeWhenPointerOutOfBounds(true);
                dlg_type.setDraggable(true);
                dlg_type.showPacked(NORTH, false);
          }
      });
      
      cnt_type = new Container();
      cnt_type.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_type.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_type.add(BoxLayout.encloseX(cnt_icon_type, txta_type));
      
      
      Style sty_icon_eno = new Style(); 
      sty_icon_eno.setBorder(null, false);
      sty_icon_eno.setBgTransparency(255, false);
      sty_icon_eno.setFgColor(0xffffff, false);
      sty_icon_eno.setBgColor(0x448d21, false);
      
      ifont_eno = FontImage.createMaterial(FontImage.MATERIAL_WORK, sty_icon_eno, 4);
      
      lbl_icon_eno = new Label(ifont_eno);
      lbl_icon_eno.getAllStyles().setBgTransparency(0, false);
      lbl_icon_eno.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_eno.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_eno = new Container();
      cnt_icon_eno.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_eno.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_eno.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_eno.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_eno.add(lbl_icon_eno);
      
      txta_eno = new TextField("");
      txta_eno.setHint(" Employer No"); 
      txta_eno.getHintLabel().setUnselectedStyle(sty_icon);
      txta_eno.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_eno.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_eno.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_eno.setConstraint(TextField.SENSITIVE);
      txta_eno.setFocusable(true);
      txta_eno.setRows(2);
      txta_eno.setSingleLineTextArea(true);
      txta_eno.setVerticalAlignment(CENTER);
      txta_eno.setSelectedStyle(s1);
      txta_eno.setUnselectedStyle(sty);
      txta_eno.setPressedStyle(s1);
      txta_eno.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_eno = new Container();
      cnt_eno.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_eno.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_eno.add(BoxLayout.encloseX(cnt_icon_eno, txta_eno));
      
      
      sty_icon_fname = new Style(); 
      sty_icon_fname.setBorder(null, false);
      sty_icon_fname.setBgTransparency(255, false);
      sty_icon_fname.setFgColor(0xffffff, false);
      sty_icon_fname.setBgColor(0x448d21, false);
      
      ifont_fname = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, sty_icon_fname, 4);
      
      lbl_icon_fname = new Label(ifont_fname);
      lbl_icon_fname.getAllStyles().setBgTransparency(0, false);
      lbl_icon_fname.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_fname.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_fname = new Container();
      cnt_icon_fname.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_fname.getUnselectedStyle().setBgColor(0x448d21, true);
      cnt_icon_fname.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_fname.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_fname.add(lbl_icon_fname);
      
      txta_fname = new TextField("");
      txta_fname.setHint(" First name"); 
      txta_fname.getHintLabel().setUnselectedStyle(sty_icon);
      txta_fname.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_fname.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_fname.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_fname.setConstraint(TextField.SENSITIVE);
      txta_fname.setFocusable(true);
      txta_fname.setRows(2);
      txta_fname.setSingleLineTextArea(true);
      txta_fname.setVerticalAlignment(CENTER);
      txta_fname.setSelectedStyle(s1);
      txta_fname.setUnselectedStyle(sty);
      txta_fname.setPressedStyle(s1);
      txta_fname.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_fname = new Container();
      cnt_fname.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_fname.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_fname.add(BoxLayout.encloseX(cnt_icon_fname, txta_fname));
      
      
      
      sty_icon_lname = new Style(); 
      sty_icon_lname.setBorder(null, false);
      sty_icon_lname.setBgTransparency(255, false);
      sty_icon_lname.setFgColor(0xffffff, false);
      sty_icon_lname.setBgColor(0x448d21, false);
      
      ifont_lname = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, sty_icon_lname, 4);
      
      lbl_icon_lname = new Label(ifont_lname);
      lbl_icon_lname.getAllStyles().setBgTransparency(0, false);
      lbl_icon_lname.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_lname.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_lname = new Container();
      cnt_icon_lname.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_lname.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_lname.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_lname.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_lname.add(lbl_icon_lname);
      
      txta_lname = new TextField("");
      txta_lname.setHint(" Last name"); 
      txta_lname.getHintLabel().setUnselectedStyle(sty_icon);
      txta_lname.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_lname.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_lname.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_lname.setConstraint(TextField.SENSITIVE);
      txta_lname.setFocusable(true);
      txta_lname.setRows(2);
      txta_lname.setSingleLineTextArea(true);
      txta_lname.setVerticalAlignment(CENTER);
      txta_lname.setSelectedStyle(s1);
      txta_lname.setUnselectedStyle(sty);
      txta_lname.setPressedStyle(s1);
      txta_lname.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_lname = new Container();
      cnt_lname.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_lname.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_lname.add(BoxLayout.encloseX(cnt_icon_lname, txta_lname));
      
      
      
      
      Style sty_icon_idno = new Style(); 
      sty_icon_idno.setBorder(null, false);
      sty_icon_idno.setBgTransparency(255, false);
      sty_icon_idno.setFgColor(0xffffff, false);
      sty_icon_idno.setBgColor(0x448d21, false);
      ifont_idno = FontImage.createMaterial(FontImage.MATERIAL_PICTURE_IN_PICTURE, sty_icon_idno, 4);
      
      lbl_icon_idno = new Label(ifont_idno);
      lbl_icon_idno.getAllStyles().setBgTransparency(0, false);
      lbl_icon_idno.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_idno.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_idno = new Container();
      cnt_icon_idno.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_idno.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_idno.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_idno.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_idno.add(lbl_icon_idno);
      
      txta_idno = new TextField("");
      txta_idno.setHint(" Id Number"); 
      //txta_username.setHintIcon(ifont_username);
      //txta_username.setHintIcon(FontImage.createMaterial(FontImage.MATERIAL_EMAIL, cnt_idnoicon.getUnselectedStyle()));
      txta_idno.getHintLabel().setUnselectedStyle(sty_icon);
      txta_idno.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_idno.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_idno.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_idno.setConstraint(TextField.SENSITIVE);
      txta_idno.setFocusable(true);
      txta_idno.setRows(2);
      txta_idno.setSingleLineTextArea(true);
      txta_idno.setVerticalAlignment(CENTER);
      txta_idno.setSelectedStyle(s1);
      txta_idno.setUnselectedStyle(sty);
      txta_idno.setPressedStyle(s1);
      txta_idno.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_idno = new Container();
      cnt_idno.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_idno.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_idno.add(BoxLayout.encloseX(cnt_icon_idno, txta_idno));
      
      
      Style sty_icon_eml = new Style(); 
      sty_icon_eml.setBorder(null, false);
      sty_icon_eml.setBgTransparency(255, false);
      sty_icon_eml.setFgColor(0xffffff, false);
      sty_icon_eml.setBgColor(0x448d21, false);
      ifont_eml = FontImage.createMaterial(FontImage.MATERIAL_EMAIL, sty_icon_eml, 4);
      
      lbl_icon_eml = new Label(ifont_eml);
      lbl_icon_eml.getAllStyles().setBgTransparency(0, false);
      lbl_icon_eml.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_eml.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_eml = new Container();
      cnt_icon_eml.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_eml.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_eml.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_eml.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_eml.add(lbl_icon_eml);
      
      txta_eml = new TextField("");
      txta_eml.setHint(" Email Address"); 
      //txta_username.setHintIcon(ifont_username);
      //txta_username.setHintIcon(FontImage.createMaterial(FontImage.MATERIAL_EMAIL, cnt_emlicon.getUnselectedStyle()));
      txta_eml.getHintLabel().setUnselectedStyle(sty_icon);
      txta_eml.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_eml.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_eml.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_eml.setConstraint(TextField.SENSITIVE);
      txta_eml.setFocusable(true);
      txta_eml.setRows(2);
      txta_eml.setSingleLineTextArea(true);
      txta_eml.setVerticalAlignment(CENTER);
      txta_eml.setSelectedStyle(s1);
      txta_eml.setUnselectedStyle(sty);
      txta_eml.setPressedStyle(s1);
      txta_eml.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_eml = new Container();
      cnt_eml.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_eml.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_eml.add(BoxLayout.encloseX(cnt_icon_eml, txta_eml));
      
      
      Style sty_icon_phn = new Style(); 
      sty_icon_phn.setBorder(null, false);
      sty_icon_phn.setBgTransparency(255, false);
      sty_icon_phn.setFgColor(0xffffff, false);
      sty_icon_phn.setBgColor(0x448d21, false);
      ifont_phn = FontImage.createMaterial(FontImage.MATERIAL_PHONE, sty_icon_phn, 4);
      
      lbl_icon_phn = new Label(ifont_phn);
      lbl_icon_phn.getAllStyles().setBgTransparency(0, false);
      lbl_icon_phn.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_phn.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_phn = new Container();
      cnt_icon_phn.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_phn.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_phn.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_phn.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_phn.add(lbl_icon_phn);
      
      txta_phn = new TextField("");
      txta_phn.setHint(" Phone No"); 
      txta_phn.getHintLabel().setUnselectedStyle(sty_icon);
      txta_phn.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_phn.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_phn.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_phn.setConstraint(TextField.SENSITIVE);
      txta_phn.setFocusable(true);
      txta_phn.setRows(2);
      txta_phn.setSingleLineTextArea(true);
      txta_phn.setVerticalAlignment(CENTER);
      txta_phn.setSelectedStyle(s1);
      txta_phn.setUnselectedStyle(sty);
      txta_phn.setPressedStyle(s1);
      txta_phn.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_phn = new Container();
      cnt_phn.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_phn.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_phn.add(BoxLayout.encloseX(cnt_icon_phn, txta_phn));
      
      Style sty_icon_usn = new Style(); 
      sty_icon_usn.setBorder(null, false);
      sty_icon_usn.setBgTransparency(255, false);
      sty_icon_usn.setFgColor(0xffffff, false);
      sty_icon_usn.setBgColor(0x448d21, false);
      ifont_usn = FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty_icon_usn, 4);
      
      lbl_icon_usn = new Label(ifont_usn);
      lbl_icon_usn.getAllStyles().setBgTransparency(0, false);
      lbl_icon_usn.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_usn.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_usn = new Container();
      cnt_icon_usn.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_usn.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_usn.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_usn.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_usn.add(lbl_icon_usn);
      
      txta_usn = new TextField("");
      txta_usn.setHint(" Username"); 
      //txta_username.setHintIcon(ifont_username);
      //txta_username.setHintIcon(FontImage.createMaterial(FontImage.MATERIAL_EMAIL, cnt_usnicon.getUnselectedStyle()));
      txta_usn.getHintLabel().setUnselectedStyle(sty_icon);
      txta_usn.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_usn.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_usn.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_usn.setConstraint(TextField.SENSITIVE);
      txta_usn.setFocusable(true);
      txta_usn.setRows(2);
      txta_usn.setSingleLineTextArea(true);
      txta_usn.setVerticalAlignment(CENTER);
      txta_usn.setSelectedStyle(s1);
      txta_usn.setUnselectedStyle(sty);
      txta_usn.setPressedStyle(s1);
      txta_usn.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_usn = new Container();
      cnt_usn.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_usn.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_usn.add(BoxLayout.encloseX(cnt_icon_usn, txta_usn));
      
      
      Style sty_icon_pwd = new Style(); 
      sty_icon_pwd.setBorder(null, false);
      sty_icon_pwd.setBgTransparency(255, false);
      sty_icon_pwd.setFgColor(0xffffff, false);
      sty_icon_pwd.setBgColor(0x448d21, false);
      ifont_pwd = FontImage.createMaterial(FontImage.MATERIAL_LOCK, sty_icon_pwd, 4);
      
      lbl_icon_pwd = new Label(ifont_pwd);
      lbl_icon_pwd.getAllStyles().setBgTransparency(0, false);
      lbl_icon_pwd.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_pwd.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_pwd = new Container();
      cnt_icon_pwd.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_pwd.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_pwd.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_pwd.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_pwd.add(lbl_icon_pwd);
      
      txta_pwd = new TextField("");
      txta_pwd.setHint(" Password"); 
      txta_pwd.getHintLabel().setUnselectedStyle(sty_icon);
      txta_pwd.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_pwd.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_pwd.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_pwd.setConstraint(TextField.SENSITIVE);
      txta_pwd.setFocusable(true);
      txta_pwd.setRows(2);
      txta_pwd.setSingleLineTextArea(true);
      txta_pwd.setVerticalAlignment(CENTER);  
      txta_pwd.setSelectedStyle(s1);
      txta_pwd.setUnselectedStyle(sty);
      txta_pwd.setPressedStyle(s1);
      txta_pwd.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_pwd = new Container();
      cnt_pwd.getUnselectedStyle().setPadding(0, 0, 0, 0); //(int)(4 * pixelsPerMM)
      cnt_pwd.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_pwd.add(BoxLayout.encloseX(cnt_icon_pwd, txta_pwd));
      
      
      Style sty_icon_pwd2 = new Style(); 
      sty_icon_pwd2.setBorder(null, false);
      sty_icon_pwd2.setBgTransparency(255, false);
      sty_icon_pwd2.setFgColor(0xffffff, false);
      sty_icon_pwd2.setBgColor(0x448d21, false);
      ifont_pwd2 = FontImage.createMaterial(FontImage.MATERIAL_LOCK, sty_icon_pwd2, 4);
      
      lbl_icon_pwd2 = new Label(ifont_pwd2);
      lbl_icon_pwd2.getAllStyles().setBgTransparency(0, false);
      lbl_icon_pwd2.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_icon_pwd2.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_icon_pwd2 = new Container();
      cnt_icon_pwd2.getUnselectedStyle().setBgTransparency(255, false);
      cnt_icon_pwd2.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_icon_pwd2.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_icon_pwd2.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_icon_pwd2.add(lbl_icon_pwd2);
      
      txta_pwd2= new TextField("");
      txta_pwd2.setHint(" Confirm Password"); 
      txta_pwd2.getHintLabel().setUnselectedStyle(sty_icon);
      txta_pwd2.getHintLabel().getAllStyles().setBgTransparency(255, false);
      txta_pwd2.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_pwd2.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_pwd2.setConstraint(TextField.SENSITIVE);
      txta_pwd2.setFocusable(true);
      txta_pwd2.setRows(2);
      txta_pwd2.setSingleLineTextArea(true);
      txta_pwd2.setVerticalAlignment(CENTER);  
      txta_pwd2.setSelectedStyle(s1);
      txta_pwd2.setUnselectedStyle(sty);
      txta_pwd2.setPressedStyle(s1);
      txta_pwd2.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_pwd2 = new Container();
      cnt_pwd2.getUnselectedStyle().setPadding(0, 0, 0, 0); //(int)(4 * pixelsPerMM)
      cnt_pwd2.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_pwd2.add(BoxLayout.encloseX(cnt_icon_pwd2, txta_pwd2));
      
      
     
     Button btn_spacer = new Button();
     btn_spacer.setText("Prospects");
     btn_spacer.setAlignment(CENTER);    
     btn_spacer.getStyle().setFgColor(0xffffff);
     btn_spacer.getStyle().setBgColor(0x448d21);
     btn_spacer.getUnselectedStyle().setBgTransparency(255, false);
     btn_spacer.getUnselectedStyle().setBgColor(0x448d21, false);
     btn_spacer.getAllStyles().setPadding(2, 0, (int)(12 * pixelsPerMM), (int)(12 * pixelsPerMM));
     btn_spacer.getAllStyles().setMargin(2, 0, 0, 0);
     btn_spacer.setVisible(false);
      
     btn_submit = new Button();
     btn_submit.setText("SUBMIT");
     btn_submit.setAlignment(CENTER);    
     btn_submit.getStyle().setFgColor(0xffffff);
     btn_submit.getStyle().setBgColor(0x448d21);
     //btn_login.getStyle().setPadding(2, 0, 20, 20);
     //btn_login.setWidth(width-5);
     btn_submit.getUnselectedStyle().setBgTransparency(255, false);
     btn_submit.getUnselectedStyle().setBgColor(0x448d21, false);
     btn_submit.getAllStyles().setPadding(2, 2, 0, 0);
     btn_submit.getAllStyles().setMargin((int)(0.2 * pixelsPerMM), 0, 0, 0);
     btn_submit.addActionListener(new ActionListener() 
     {
      public void actionPerformed(ActionEvent evt) 
      {
                if (txta_category.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must select investor type to proceed.");
                } 
                else if (txta_type.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must select investor type to proceed.");
                } 
                else if (txta_eno.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must enter your employment no to proceed.");   
                } 
                else if (txta_fname.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must enter your name to proceed.");
                } 
                else if (txta_idno.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must enter your ID number to proceed.");   
                }
                else if (txta_eml.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must enter an email address to proceed.");   
                } 
                else if (txta_phn.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must enter a phone number to proceed.");
                } 
                else if (txta_usn.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must enter a user to proceed.");   
                }
                else if (txta_pwd.getText().equals("")) 
                {
                    Connect.okayDialog("Oops!!!", "You must enter a password to proceed."); 
                }
                else if (txta_pwd2.getText().equals("")) 
                {
                       Connect.okayDialog("Oops!!!", "You must confirm the password to proceed.");  
                }
                else 
                { 
                    //Storage.getInstance().writeObject("username", txta_usn.getText().trim());
                    //Storage.getInstance().writeObject("password", txta_pwd.getText().trim());
                    
                    //Connect connector = new Connect();
                    //connector.getUser();
                    
                    //PortfolioMenu porti = new PortfolioMenu();
                    //porti.showMainScreen();
                    
                    //Storage.getInstance().writeObject("temp_member_no", txta_phn.getText().trim());
                    //Storage.getInstance().deleteStorageFile("temp_firstname");
                    //Storage.getInstance().deleteStorageFile("temp_lastname");
                    //Storage.getInstance().deleteStorageFile("temp_phone");
                    //Storage.getInstance().deleteStorageFile("temp_email");
                                    
                    Dialog.show("Notice!", "You will shortly recieve a Transaction Code via SMS. Enter it in the space ptovided", "Ok", null);
                    
                    Storage.getInstance().writeObject("parameter1", "register");
                    Storage.getInstance().writeObject("parameter2", txta_fname.getText().trim());
                    Storage.getInstance().writeObject("parameter3", txta_lname.getText().trim()); //txta_username.getText().trim()
                    Storage.getInstance().writeObject("parameter4", txta_eml.getText().trim()); 
                    Storage.getInstance().writeObject("parameter5", txta_phn.getText().trim()); 
                    Storage.getInstance().writeObject("parameter6", txta_usn.getText().trim()); 
                    Storage.getInstance().writeObject("parameter7", txta_pwd.getText().trim()); 
                    Storage.getInstance().writeObject("parameter8", txta_pwd2.getText().trim()); 
                    
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
     cont_body.setScrollableY(true);
     cont_body.getAllStyles().setAlignment(CENTER, false);
     cont_body.getAllStyles().setPadding(0, 0, (int)(5 * pixelsPerMM), (int)(5 * pixelsPerMM));
     //cont_body.getAllStyles().setMargin(0, 0, (int)(5 * pixelsPerMM), (int)(5 * pixelsPerMM));
     //cont_body.getStyle().setPaddingTop(displayHeight/2);
     
     cont_body.addComponent((cont_header));
     //cont_body.addComponent((cnt_catg));
     //cont_body.addComponent((cnt_type));
     //cont_body.addComponent((cnt_eno));
     cont_body.addComponent((cnt_fname));
     cont_body.addComponent((cnt_lname));
     //cont_body.addComponent((cnt_idno));
     cont_body.addComponent((cnt_eml));
     cont_body.addComponent((cnt_phn));
     cont_body.addComponent((cnt_usn));
     cont_body.addComponent((cnt_pwd));
     cont_body.addComponent((cnt_pwd2));
     cont_body.addComponent(btn_submit);
     cont_body.addComponent(btn_spacer);
     
          
     
   
     cont_footer = new Container(new BorderLayout());
     //cont_footer.add(BorderLayout.WEST, btn_exit);
     //cont_footer.add(BorderLayout.EAST, btn_submit);
     
      LayeredLayout laylay = new LayeredLayout();
      //laylay.setInsets(btn_portfolio, "auto auto auto auto");
      //laylay.setInsets(btn_portfolio, "auto auto -55 auto");
      //cont_body.setLayout(laylay);
        
      //fm_main.addComponent(BorderLayout.NORTH, cont_header);
      fm_main.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterMiddle(BoxLayout.encloseY(cont_body)));
      //fm_main.addComponent(BorderLayout.SOUTH, cont_body);
      
      Command cmd_back = new Command("")
      {
       public void actionPerformed(ActionEvent ev) 
       {
           LoginMenu loginer = new LoginMenu();
           loginer.showLoginScreen();
       }
      };
  
        
        fm_main.addCommand(cmd_back);
        fm_main.setBackCommand(cmd_back);
    
      fm_main.showBack();
   }
  
    
}