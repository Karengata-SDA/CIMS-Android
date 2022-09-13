package com.mobitribe.hesabu;

import com.codename1.components.InteractionDialog;
import com.codename1.components.ScaleImageButton;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.*;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.events.ActionEvent;
import static com.mobitribe.hesabu.Connect.str_protocol;
import static com.mobitribe.hesabu.Connect.str_host;
import static com.mobitribe.hesabu.Connect.str_port;
import static com.mobitribe.hesabu.Connect.str_path;

import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
//import com.mobitribe.hesabu.Utilz.Commonz;
import java.io.ByteArrayInputStream;
//import com.engineussystems.bitraffic.MainMenu;
//import com.imediakenya.eventapp.Utilz.Commonz;
//import com.imediakenya.eventapp.Utilz.Synkanyuabongo;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.littlemonkey.qrscanner.QRScanner;

public class DepartmentsMenu extends Exception
{
    private Form fm_roads, fm_main, fm_department;
    private Label lbl_titleL, lbl_titleR;
    //private CourseButtons courseButtons = new CourseButtons();
    private Image img_bg, img_bck, img_fwd;
    private Image img_roads, img_places, img_routes, img_weather, img_locations, img_gallery, img_surveys, img_scanner;
    private Image img_uhurug, img_wilson, img_barracks, img_tmall, img_mdaraka, img_department;
    
    int displayWidth = Display.getInstance().getDisplayWidth();
    int displayHeight = Display.getInstance().getDisplayHeight();
    int int_alpha = 0;
    
    private Image img_background;
    
    private Image img_info, img_avatar, img_home, img_back, img_berger, img_banner, img_logo;
    
    private Image img_share, img_close;
    
    private Resources theme;
    
    private Dimension dim_btn;
    
    private String str_car0;
    
    private Integer int_displayW;
    private String str_displayW;
    
    private Style sty, sty_lg, sty_lg_banner;
    private String str_imageFile;
    
    private Image img_toshare;
    
    //private Storage storage = Storage.getInstance();
    
    private Container cnt_road, cnt_nav, cnt_button, cnt_titlebar, cnt_taskbar, cnt_grid, cnt_departments;
    
    private Button btn_info,btn_back, btn_start, btn_scores, btn_about, btn_department;
    private boolean bool_Login_staus, bool_icon_department, bool_icon_leader, bool_icon_member, bool_icon_resource;
    private String str_Login_Status;
    
    private  BrowserComponent browser;
    private Image img_placeholder;
    
    private Font font_CaviarDreams;
    
    //private String str_car0;
    private String str_barabara, str_Sub_barabara;
    
    private Storage storage;
    
    private Label label_footer, lbl_header, lbl_subroad;
    
    private Border border;
    
    private EncodedImage eImg, imge;
    private Image img;
    
    private ShareButton sbtn;
    private InputStream is;
    
    private Toolbar tb_mainfm;
    private Command cmd_tbRight;
    
    private Font font_RageItalic, font_HPSimplified, font_HPSimplifiedBold, font_HPSimplifiedLight, font_HPSimplifiedLightItalic;
    double pixelsPerMM = ((double)Display.getInstance().convertToPixels(10, true)) / 10.0;
    private Font font_small_bold, font_small_plain, font_medium_uline, font_medium_bold, font_medium_plain, font_large_bold, font_large_plain;
    int int_zero_pt_five, int_one, int_one_pt_five, int_two, int_three, int_five_Pt_five;
    private Style sty_icon;
    
    private Label lbl_find, lbl_sort, lbl_tile, lbl_pic;
    
    private TextField txtf_search;
    
    private String str_ttle_leader, str_ppg1_leader, str_ppg2_leader, str_ppg3_leader, str_ppg4_leader;
    private String str_ttle_description, str_ppg1_description;
    private String str_ttle_staff, str_ppg1_staff;
    private String str_ttle_mission, str_ppg1_mission;
    private String str_ttle_activities, str_ppg1_activities;
    private String str_ttle_resources, str_ppg1_resources;
    private String str_ttle_projections, str_ppg1_projections;
    private String str_ttle_statements, str_ppg1_statements;
    private String str_ttle_calendar, str_ppg1_calendar;
    private String str_description;
    
    private  FontImage ifont_burger, ifont_avatar, ifont_close;
    
    private InteractionDialog dlgi_department;
    
    private Toolbar tb;
    
    private Button btn_close, btn_save, btn_discard, btn_confirm, btn_login, btn_later, btn_signme, btn_forgot;
    Button[] button_department;
    SpanButton [] sbtn_department;
    
    private int i;
    private Image img_DEPTplaceholder;
    
    //DIALOG
    private Dialog dlg_login;
    
    private Container cnt_dlgSouth, cnt_dlgNorth;
    
    public void showMainForm()
    {
     try
     {
      //img_background = Image.createImage("/Askari.png").scaledHeight(displayHeight);
      //img_banner = Image.createImage("/banner.png");
      img_logo = Image.createImage("/logo.jpg");
      //img_info = Image.createImage("/info.png");
      //img_avatar = Image.createImage("/avatar.png");
      //img_back = Image.createImage("/back.png");
      //img_placeholder = Image.createImage("/placeholderBaro.jpg");
      img_department = Image.createImage("/department.png");
      //img_home = Image.createImage("/home.png");
      //img_home = Image.createImage("/home.png");
      //img_berger = Image.createImage("/berger.png");
      theme = Resources.openLayered("/theme");
      //img_placeholder = Image.createImage("/background.jpg"); //.scaledHeight(displayHeight);
      UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
      
      font_CaviarDreams = Font.createTrueTypeFont("Caviar Dreams.ttf", "Caviar Dreams.ttf");//Caviar Dreams.ttf
      
      
       font_RageItalic = Font.createTrueTypeFont("Rage Italic", "Rage Italic.ttf");
       font_RageItalic = font_RageItalic.derive((int)(5.1 * pixelsPerMM), Font.STYLE_PLAIN);
       
       font_RageItalic = Font.createTrueTypeFont("Rage Italic", "Rage Italic.ttf");
       font_RageItalic = font_RageItalic.derive((int)(5.1 * pixelsPerMM), Font.STYLE_PLAIN);
       
       font_HPSimplified = Font.createTrueTypeFont("HP Simplified", "HP Simplified.ttf");
       font_HPSimplified = font_HPSimplified.derive((int)(3.1 * pixelsPerMM), Font.STYLE_BOLD);
       
       font_HPSimplifiedBold = Font.createTrueTypeFont("HP Simplified", "HP Simplified.ttf");
       font_HPSimplifiedBold = font_HPSimplifiedBold.derive((int)(4.0 * pixelsPerMM), Font.STYLE_BOLD);
       
       font_HPSimplifiedLight = Font.createTrueTypeFont("HP Simplified Light", "HP Simplified Light.ttf");
       font_HPSimplifiedLight = font_HPSimplifiedLight.derive((int)(1.1 * pixelsPerMM), Font.STYLE_PLAIN);
       
       font_HPSimplifiedLightItalic = Font.createTrueTypeFont("HP Simplified Light", "HP Simplified Light.ttf");
       font_HPSimplifiedLightItalic = font_HPSimplifiedLightItalic.derive((int)(2.5 * pixelsPerMM), Font.STYLE_ITALIC);
       
  
       font_medium_uline = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_UNDERLINED, Font.SIZE_MEDIUM);
         font_small_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL);
         font_medium_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
         font_large_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
         font_small_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
         font_medium_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
         font_large_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);
                 
         int_zero_pt_five = (int)(0.5 * pixelsPerMM);
         int_one = (int)(1.0 * pixelsPerMM);
         int_one_pt_five = (int)(1.5 * pixelsPerMM);
         int_two = (int)(2.0 * pixelsPerMM);
         int_three = (int)(3.0 * pixelsPerMM);
         int_five_Pt_five = (int)(5.5 * pixelsPerMM);
     }
     catch (IOException ioexception)
     {
      ioexception.printStackTrace();
     }
     
     Display.getInstance().lockOrientation(true);
     Display.getInstance().setScreenSaverEnabled(false);
     
     border = Border.createCompoundBorder(null, null, null, null);
     
        fm_main = new Form();
        fm_main.setLayout(new BorderLayout());
        fm_main.getTitleArea().setPreferredSize(new Dimension(0, 0));
        fm_main.getTitleArea().removeAll();
        fm_main.setLayout(new BorderLayout());
        fm_main.setScrollableY(true);
        //fm_main.getStyle().setBgImage(img_background, false);
        fm_main.getStyle().setBgColor(0x969698);
        //fm_main.getStyle().setBackgroundType(Style.BACKGROUND_GRADIENT_LINEAR_VERTICAL, false); //BACKGROUND_IMAGE_SCALED_FILL
        
        storage = new Storage();
        
        sty_icon = fm_main.getUIManager().getComponentStyle("Title"); sty_icon.setFgColor(0xffffff);
        ifont_burger = FontImage.createMaterial(FontImage.MATERIAL_MENU, sty_icon, 4); //MATERIAL_MORE_HORIZ
        ifont_avatar = FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty_icon, 4);
        FontImage ifont_find = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, sty_icon, 4);
        FontImage ifont_sort = FontImage.createMaterial(FontImage.MATERIAL_SORT_BY_ALPHA, sty_icon, 4); //MATERIAL_SORT
        FontImage ifont_tile = FontImage.createMaterial(FontImage.MATERIAL_MENU, sty_icon, 4);
     
        
        //Title
        lbl_titleL = new Label();
        //lbl_title.setUIID("TitleFont");
        lbl_titleL.setIcon(theme.getImage("logo_karengata_vertical.png"));  //img_logo.scaledWidth(displayWidth/2)
        lbl_titleL.getStyle().setAlignment(LEFT);
        //lbl_title.setIcon(img_banner.scaledWidth(displayWidth));
        //lbl_title.setIcon(theme.getImage("banner.png").scaledWidth(displayWidth));
        //lbl_title.getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL, false);
        lbl_titleL.getStyle().setBgColor(0xffffff); 
        lbl_titleL.getStyle().setFgColor(0x000000); 
        lbl_titleL.getStyle().setBgTransparency(255, false);
        lbl_titleL.getStyle().setPadding(0, 0, 0, 0);
        lbl_titleL.getStyle().setMargin(0, 10, 0, 0);
        lbl_titleL.getStyle().setBorder(border);
        
        lbl_titleR = new Label();
        lbl_titleR.setText("Karengata");
        lbl_titleR.getStyle().setFont(font_RageItalic);
        lbl_titleR.getAllStyles().setAlignment(CENTER, false);
        lbl_titleR.getStyle().setBorder(border);
        //lbl_titleR.setTextPosition(0);
        //lbl_title.setUIID("TitleFont");
        //lbl_titleR.setIcon(img_logo.scaledWidth(displayWidth/2)); lbl_titleL.getStyle().setAlignment(CENTER);
        //lbl_titleR.setIcon(img_banner.scaledWidth(displayWidth));
        //lbl_titleR.setIcon(theme.getImage("banner.png").scaledWidth(displayWidth));
        //lbl_titleR.getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL, false);
        lbl_titleR.getStyle().setBgColor(0xffffff); 
        lbl_titleR.getStyle().setFgColor(0x000000); 
        lbl_titleR.getStyle().setBgTransparency(255, false);
        lbl_titleR.getStyle().setMargin(0, 10, 0, 0);
        lbl_titleR.getStyle().setPadding(0, 0, 0, 0);

                
        sty = new Style();
        sty.setBgColor(0xffffff);
        sty.setFgColor(0x000000);
        sty.setMargin(0, 0, 0, 0);
        sty.setPadding(0, 0, 0, 0);
        sty.setMarginUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        sty.setUnderline(false);
        sty.setBgColor(0xffffff);
        sty.setBgTransparency(0, false);
        sty.setAlignment(CENTER);
        sty.setBorder(border);
        
        sty_lg = new Style();
        sty_lg.setFgColor(0x000000);
        sty_lg.setMargin(0, 0, 0, 0);
        sty_lg.setPadding(0, 0, 0, 0);
        //sty_lg.setMarginUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        sty_lg.setUnderline(false);
        sty_lg.setBgColor(0xffffff);
        sty_lg.setBgTransparency(0, false);
        sty_lg.setAlignment(CENTER);
        sty_lg.setBorder(border);
        
        btn_info = new Button();
        btn_info.setFocusable(false);
        btn_info.setUIID("Label");
        btn_info.setFocusable(false);
        btn_info.setUnselectedStyle(sty_lg);
        btn_info.setSelectedStyle(sty_lg);
        btn_info.setPressedStyle(sty_lg);
        btn_info.setIcon(img_info);
        btn_info.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent evt) 
         {
          //AboutMenu aboutus = new AboutMenu();
          //aboutus.showAboutMenu();
         }
        });
                
        btn_back = new Button();
        btn_back.setUIID("Label");
        btn_back.getStyle().setBgTransparency(155, false);
        btn_back.getStyle().setBgColor(0x000000); 
        btn_back.getStyle().setMargin(0, 0, 0, 0);
        btn_back.setIcon(img_back);
        btn_back.addActionListener(new ActionListener() 
        {
         public void actionPerformed(ActionEvent evt) 
         {
          //fm_roads.show();
          
         }
        });

        cnt_titlebar = new Container(new BorderLayout());
        cnt_titlebar.setUnselectedStyle(sty_lg);
        cnt_titlebar.setSelectedStyle(sty_lg);
        cnt_titlebar.getAllStyles().setMargin(0, 10, 0, 0);
          
        //cnt_titlebar.addComponent(BorderLayout.WEST, lbl_titleL);
        cnt_titlebar.addComponent(BorderLayout.CENTER, GridLayout.encloseIn(2, lbl_titleL, lbl_titleR)); //lbl_title
        //cnt_titlebar.addComponent(BorderLayout.EAST, BorderLayout.center(lbl_titleR));
        
        cnt_taskbar = new Container(new BorderLayout());
            cnt_taskbar.getAllStyles().setMargin(0, 10, 0, 0);
            cnt_taskbar.getAllStyles().setPadding(0, 10, 0, 0);
        
        lbl_find = new Label(ifont_find);
            lbl_find.setUnselectedStyle(sty);
            lbl_find.setSelectedStyle(sty);
            lbl_find.setPressedStyle(sty);
                        
        lbl_sort = new Label(ifont_sort);
            lbl_sort.setUnselectedStyle(sty);
            lbl_sort.setSelectedStyle(sty);
            lbl_sort.setPressedStyle(sty);
         
        lbl_tile = new Label(ifont_tile);
            lbl_tile.setUnselectedStyle(sty);
            lbl_tile.setSelectedStyle(sty);
            lbl_tile.setPressedStyle(sty);
            
        txtf_search  = new TextField("", "", 15, TextField.ANY);
            txtf_search.setHint("Search");
            //txtf_search.setHintIcon(ifont_find);
            //txtf_search.getAllStyles().setMargin(0, int_one_pt_five, int_five_Pt_five, int_five_Pt_five); 
            txtf_search.getHintLabel().getStyle().setFgColor(0xffffff, false);
            txtf_search.getHintLabel().getStyle().setFont(font_medium_plain, false);
            txtf_search.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xffffff, true)); 
            txtf_search.getUnselectedStyle().getBorder().setThickness(16);
            txtf_search.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xffffff, true)); 
            txtf_search.getSelectedStyle().getBorder().setThickness(16);
            txtf_search.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xffffff, true)); 
            txtf_search.getPressedStyle().getBorder().setThickness(16);
            txtf_search.getAllStyles().setBgColor(0xffffff);
            txtf_search.getAllStyles().setBgTransparency(0);
        
        //cnt_titlebar.addComponent(BorderLayout.SOUTH, BorderLayout.center(lbl_find, lbl_sort, lbl_tile)); //FontImage.create(" \ue8d5 ", iconStyle) e8ef
        cnt_titlebar.addComponent(BorderLayout.SOUTH, new Container(new BorderLayout()).add(BorderLayout.WEST, lbl_sort).add(BorderLayout.CENTER, FlowLayout.encloseCenterMiddle(txtf_search)).add(BorderLayout.EAST, lbl_tile)); //, lbl_find)
        
      sty_icon = fm_main.getUIManager().getComponentStyle("Title"); sty_icon.setFgColor(0xffffff);
      ifont_burger = FontImage.createMaterial(FontImage.MATERIAL_MENU, sty_icon, 4); //MATERIAL_MORE_HORIZ
      ifont_avatar = FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty_icon, 4); //MATERIAL_MORE_HORIZ 

      //HomeMenu nissanhomy = new HomeMenu();
      //nissanhomy.getToolbar();
      
      //fm_main.setToolbar(tb_form);
      //fm_home.getToolbar().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
      //tb_form.setTitle("Departments Menu");
      
       //Header
        lbl_header = new Label();//img_header
            lbl_header.setAlignment(CENTER);
            lbl_header.getStyle().setMargin(0, 0, 0, 0);
            lbl_header.getStyle().setPadding(0, 0, 0, 0);

       //Body
        cnt_button = new Container();
            cnt_button = new Container(new GridLayout(3, 2));
            cnt_button.setScrollableY(true);
            cnt_button.getStyle().setAlignment(CENTER, false);
            cnt_button.getStyle().setMargin(10, 0, 0, 0);
        
                    String str_json_read = (String) Storage.getInstance().readObject("departments.json");
                    byte[] dataa = str_json_read.getBytes();
                    JSONParser json = new JSONParser();
                    try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                    {
                        Map<String, Object> map_content = json.parseJSON(is_content);
                        java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data");
                        System.out.println("No of Departments:---------> "+obj_content.size()); 
                        
                        cnt_departments = new Container(new GridLayout(obj_content.size(), 2)); //
                        
                        
                        button_department = new Button[obj_content.size()];
                        sbtn_department = new SpanButton[obj_content.size()];
                        
                        
                        i = 0;
                        for(Map<String, Object> obj : obj_content) 
                        {    
                            String str_department_id = (String)obj.get("id");
                            String str_department_nm = (String)obj.get("name");
                            String str_department_ic = (String)obj.get("icon");
                            //String str_department_ld = (String)obj.get("leader"); //if(str_department_ld == null || str_department_ld.length() == 0){}                           
                            
                            System.out.println("Department Name: "+str_department_nm);
                            
                            //java.util.ArrayList<String> leader = (java.util.ArrayList<String>)obj.get("leader"); //"leader":"[\"Leader\", \"Steve Kinanga\", \"Communication Secretary\", \"A001592016.png\", \"\"]"
                            //System.out.println("Leader Data Item 1: "+leader.get(0));
                            
                            //ArrayList<String[]> data = new ArrayList<>();
                            //Object[][] arr = new Object[data.size()][];
                            
                            java.util.List<String> leader = (java.util.List<String>)obj.get("leader");
                            if(leader != null && leader.size() > 0) 
                            {
                                System.out.println("Leader Data Item 1: "+leader.get(0));
                                System.out.println("Leader Data Item 2: "+leader.get(1));
                                System.out.println("Leader Data Item 3: "+leader.get(2));
                                                             
                                //Check if department icon exists in storage.
                                bool_icon_leader = Storage.getInstance().exists(leader.get(1));
                                if(bool_icon_leader == true)
                                {
                                    System.out.println("Leader photo already downloaded: "+leader.get(1));
                                }
                                else
                                {
                                    System.out.println("Dowloading Leader's image from "+"http://localhost/content/Images/"+leader.get(1));
                                    
                                    Util.downloadUrlToStorageInBackground("http://localhost/content/Images/"+leader.get(1), leader.get(1), new  ActionListener() 
                                    {
                                        @Override
                                        public void actionPerformed(ActionEvent evt) 
                                        {
                                            System.out.println("Photo -> Image downloaded");
                                        }
                                    });
                                }
                                
                            }
                            
                            java.util.List<String> description = (java.util.List<String>)obj.get("description");
                            if(description != null && description.size() > 0) 
                            {
                                //System.out.println("Description Size: "+description.size());
                                //System.out.println("Description Data Item 1: "+description.get(0));
                                //System.out.println("Description Data Item 2: "+description.get(1));
                                //System.out.println("Description Data Item 3: "+description.get(2));
                            } 
                            
                            java.util.List<String> staff = (java.util.List<String>)obj.get("staff");
                            if(staff != null && staff.size() > 0) 
                            {
                                //System.out.println("Staff Size: "+staff.size());
                                //System.out.println("Staff Data Item 1: "+staff.get(0));
                                //System.out.println("Staff Data Item 2: "+staff.get(1));
                                //System.out.println("Staff Data Item 3: "+staff.get(2));
                            }
                            
                            java.util.List<String> mission = (java.util.List<String>)obj.get("mission");
                            java.util.List<String> activities = (java.util.List<String>)obj.get("activities");
                            java.util.List<String> resources = (java.util.List<String>)obj.get("resources");
                            java.util.List<String> projections = (java.util.List<String>)obj.get("projections");
                            java.util.List<String> statements = (java.util.List<String>)obj.get("statements");
                            java.util.List<String> calendar = (java.util.List<String>)obj.get("calendar");
                            
                            
                            
                                
                                
                            Label lbl_department = new Label(str_department_nm);
                            //lbl_department.getAllStyles().setPadding(0, 15, 0, 0);
                            lbl_department.getAllStyles().setAlignment(LEFT);
                            lbl_department.getStyle().setFont(font_HPSimplified);
                                
                                                     
                                
                            //int mm = Display.getInstance().convertToPixels(3);
                            //EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);
                            
                            button_department[i] = new Button();
                            sbtn_department[i] = new SpanButton();
                            
                            //Check if department icon exists in storage.
                            bool_icon_department = Storage.getInstance().exists(str_department_ic);
                            if(bool_icon_department == true)
                            {
                                try 
                                {
                                    System.out.println("Image already downloaded: "+'"'+str_department_ic+'"'); //"communication.png"
                                    //is = Storage.getInstance().createInputStream(str_department_ic); //Storage.getInstance().readObject('"'+str_department_ic+'"').toString()
                                    //img_department = EncodedImage.createImage(is);
                                } 
                                catch (Exception e) 
                                {
                                    System.err.println("Error: "+e);
                                }
                            }
                            else
                            {
                                try
                                {
                                    img_DEPTplaceholder = Image.createImage("/adventist_icon.jpg"); //DEPTplaceholder.png
                                    eImg = EncodedImage.createFromImage(img_DEPTplaceholder, true);
                                    img_department =  URLImage.createToStorage(eImg, str_department_ic, str_protocol + str_host + str_port + str_path+"content/Images/"+str_department_ic, URLImage.RESIZE_SCALE);
                                       System.out.println("Downloading Image: "+str_protocol + str_host + str_port + str_path+"content/Images/"+str_department_ic+"\n\n");
                                    //button_department[k] = new Button(str_departments_uname, Image.createImage("/"+img_pic));
                                }
                                catch (IOException ioexception)
                                {
                                    System.err.println("Error2: "+ioexception);
                                }
                            } 
                            
                            ScaleImageButton btnscl = new ScaleImageButton();
                            
                            button_department[i].getAllStyles().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
                            int pixels = (int)(1.5 * pixelsPerMM);
                            int height = (int)(33.9 * pixelsPerMM);
                            int width = (int)(20 * pixelsPerMM);
                            button_department[i].getAllStyles().setPadding(pixels, pixels, pixels, pixels);
                            
                            System.out.println("Image Width: "+img_department.getWidth());
                            
                            button_department[i].setIcon(img_department.scaledWidth(250)); //createImage(width, height) //.scaledWidth(img_department.getWidth()) //theme.getImage("adventist_icon.jpg")
                            button_department[i].setText(str_department_nm);
                            button_department[i].setUIID("Label");
                            button_department[i].setTextPosition(BOTTOM);
                            button_department[i].getStyle().setBgTransparency(0, false);
                            button_department[i].getStyle().setBgColor(0x000000); 
                            button_department[i].getStyle().setFgColor(0xFFD800);
                            button_department[i].getStyle().setPadding(10,10,25,25);
                            button_department[i].setSelectedStyle( button_department[i].getUnselectedStyle());
                            button_department[i].setPressedStyle(button_department[i].getUnselectedStyle());
                            button_department[i].addActionListener(new ActionListener() 
                            {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        Log.p(leader.get(2)+" button pressed.", 1);
                                        Log.p(str_department_nm+" Department got selected.", 1);
                                        
                                        Storage.getInstance().writeObject("department", str_department_nm);
                                        
                                        Storage.getInstance().writeObject("lbl0_leader", leader.get(0));
                                        Storage.getInstance().writeObject("lbl1_leader", leader.get(1));
                                        Storage.getInstance().writeObject("lbl2_leader", leader.get(2));
                                        Storage.getInstance().writeObject("lbl3_leader", leader.get(3));
                                                                               
                                        Storage.getInstance().writeObject("lbl0_description", description.get(0));
                                        Storage.getInstance().writeObject("lbl1_description", description.get(1));
                                        
                                        Storage.getInstance().writeObject("lbl_staff", staff.get(0));                                        
                                        Storage.getInstance().writeObject("staff_size", staff.size());
                                        for (int i = 0; i < staff.size(); i++) 
                                        { 
                                            Storage.getInstance().writeObject("staff_"+i, staff.get(i)); 
                                            //Tommy Mogaka|
                                            //Deputy Secretary - Equipment|
                                            //A002847678.png|
                                            //The communication secretary should have
                                            //the ability to meet people and rightly represent the Church, sound judgment, good organization, effective writing skills, and a willingness to carry
                                            //out assignments.
                                        }
                                        
                                        Storage.getInstance().writeObject("lbl0_mission", mission.get(0));
                                        Storage.getInstance().writeObject("lbl1_mission", mission.get(1));
                                        
                                        Storage.getInstance().writeObject("lbl0_activities", activities.get(0));
                                        Storage.getInstance().writeObject("lbl1_activities", activities.get(1));
                                        
                                        Storage.getInstance().writeObject("lbl0_resources", resources.get(0));
                                        Storage.getInstance().writeObject("lbl1_resources", resources.get(1));
                                        
                                        Storage.getInstance().writeObject("ttl_resources", resources.get(0));
                                        Storage.getInstance().writeObject("cnt_resources", resources.get(1));
                                        
                                        Storage.getInstance().writeObject("ttl_statements", statements.get(0));
                                        Storage.getInstance().writeObject("cnt_statements", statements.get(1));
                                        
                                        Storage.getInstance().writeObject("ttl_calendars", calendar.get(0));
                                        Storage.getInstance().writeObject("cnt_calendars", calendar.get(1));
                                        
                                        Storage.getInstance().writeObject("size_projections", projections.size());
                                        for (int i = 0; i < projections.size(); i++) 
                                        { 
                                            Storage.getInstance().writeObject("projections_"+i, projections.get(i));
                                        }
                                        
                                        Storage.getInstance().writeObject("size_statements", statements.size());
                                        for (int i = 0; i < statements.size(); i++) 
                                        { 
                                            Storage.getInstance().writeObject("statements_"+i, statements.get(i));
                                        }
                                        
                                        Storage.getInstance().writeObject("size_calendar", calendar.size());
                                        for (int i = 0; i < calendar.size(); i++) 
                                        { 
                                            Storage.getInstance().writeObject("calendar_"+i, calendar.get(i));
                                        }
                                        
                                        //SelectedDepartment depselector = new SelectedDepartment();
                                        //depselector.showMainScreen();
                                        //showDepartment();
                                    }
                                });
                            
                            
                            //sbtn_department[i].getAllStyles().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
                            //sbtn_department[i].getAllStyles().setPadding(pixels, pixels, pixels, pixels);
                            //sbtn_department[i].setIcon(img_department.scaledWidth(250));  //createImage(width, height) //.scaledWidth(img_department.getWidth()) //theme.getImage("adventist_icon.jpg")
                            sbtn_department[i].setText(str_department_nm);
                            //sbtn_department[i].setUIID("Label");
                            sbtn_department[i].setTextPosition(BOTTOM);
                            sbtn_department[i].getStyle().setBgTransparency(0, false);
                            sbtn_department[i].getStyle().setBgColor(0x000000); 
                            sbtn_department[i].getStyle().setFgColor(0xffffff); //0xFFD800
                            //sbtn_department[i].getStyle().setPadding(10,10,25,25);
                            sbtn_department[i].setSelectedStyle(sbtn_department[i].getUnselectedStyle());
                            sbtn_department[i].setPressedStyle(sbtn_department[i].getUnselectedStyle());
                            
                            //cnt_departments.add(BoxLayout.encloseY(button_department[i], sbtn_department[i])); 
                            //cnt_departments.add(sbtn_department[i]); 
                            
                            Button btn_dept = new Button(); //theme.getImage("bible.png")
                            btn_dept.setIcon(img_department.scaledWidth(250));
                            btn_dept.getAllStyles().setBgTransparency(0, false);
                            btn_dept.getAllStyles().setMargin(0, (int)(7.5 * pixelsPerMM),  0, 0);
                            btn_dept.getAllStyles().setPadding(0, 0, 0, 0);
                            //btn_dept.getAllStyles().setMarginUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                            btn_dept.setUIID("Label");
                            btn_dept.setTextPosition(BOTTOM);
                            btn_dept.addActionListener(new ActionListener() 
                            {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        Log.p(leader.get(2)+" button pressed.", 1);
                                        Log.p(str_department_nm+" Department got selected.", 1);
                                        
                                        Storage.getInstance().writeObject("department", str_department_nm);
                                        
                                        Storage.getInstance().writeObject("lbl0_leader", leader.get(0));
                                        Storage.getInstance().writeObject("lbl1_leader", leader.get(1));
                                        Storage.getInstance().writeObject("lbl2_leader", leader.get(2));
                                        Storage.getInstance().writeObject("lbl3_leader", leader.get(3));
                                                                               
                                        Storage.getInstance().writeObject("lbl0_description", description.get(0));
                                        Storage.getInstance().writeObject("lbl1_description", description.get(1));
                                        
                                        Storage.getInstance().writeObject("lbl_staff", staff.get(0));                                        
                                        Storage.getInstance().writeObject("staff_size", staff.size());
                                        for (int i = 0; i < staff.size(); i++) 
                                        { 
                                            Storage.getInstance().writeObject("staff_"+i, staff.get(i)); 
                                            //Tommy Mogaka|
                                            //Deputy Secretary - Equipment|
                                            //A002847678.png|
                                            //The communication secretary should have
                                            //the ability to meet people and rightly represent the Church, sound judgment, good organization, effective writing skills, and a willingness to carry
                                            //out assignments.
                                        }
                                        
                                        Storage.getInstance().writeObject("lbl0_mission", mission.get(0));
                                        Storage.getInstance().writeObject("lbl1_mission", mission.get(1));
                                        
                                        Storage.getInstance().writeObject("lbl0_activities", activities.get(0));
                                        Storage.getInstance().writeObject("lbl1_activities", activities.get(1));
                                        
                                        Storage.getInstance().writeObject("lbl0_resources", resources.get(0));
                                        Storage.getInstance().writeObject("lbl1_resources", resources.get(1));
                                        
                                        Storage.getInstance().writeObject("ttl_resources", resources.get(0));
                                        Storage.getInstance().writeObject("cnt_resources", resources.get(1));
                                        
                                        Storage.getInstance().writeObject("ttl_statements", statements.get(0));
                                        Storage.getInstance().writeObject("cnt_statements", statements.get(1));
                                        
                                        Storage.getInstance().writeObject("ttl_calendars", calendar.get(0));
                                        Storage.getInstance().writeObject("cnt_calendars", calendar.get(1));
                                        
                                        Storage.getInstance().writeObject("size_projections", projections.size());
                                        for (int i = 0; i < projections.size(); i++) 
                                        { 
                                            Storage.getInstance().writeObject("projections_"+i, projections.get(i));
                                        }
                                        
                                        Storage.getInstance().writeObject("size_statements", statements.size());
                                        for (int i = 0; i < statements.size(); i++) 
                                        { 
                                            Storage.getInstance().writeObject("statements_"+i, statements.get(i));
                                        }
                                        
                                        Storage.getInstance().writeObject("size_calendar", calendar.size());
                                        for (int i = 0; i  < calendar.size(); i++) 
                                        { 
                                            Storage.getInstance().writeObject("calendar_"+i, calendar.get(i));
                                        }
                                        
                                        SelectedDepartment depselector = new SelectedDepartment();
                                        depselector.showMainScreen();
                                        
                                        //showDepartment();
                                    }
                                });

                            SpanLabel splbl_dept = new SpanLabel();
                            splbl_dept.setTextBlockAlign(Component.CENTER);
                            splbl_dept.setText(str_department_nm);
                            splbl_dept.setTextPosition(BOTTOM);
                            splbl_dept.getTextAllStyles().setAlignment(CENTER, false);
                            splbl_dept.getAllStyles().setAlignment(CENTER, false);
                            splbl_dept.getAllStyles().setFont(font_small_plain);
                            splbl_dept.getStyle().setFgColor(0xffffff);
                            splbl_dept.getStyle().setBgColor(0x448d21);
                            splbl_dept.getStyle().setBgTransparency(0, false);
                            splbl_dept.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), 0, (int)(4.9 * pixelsPerMM), (int)(4.9 * pixelsPerMM));
                            splbl_dept.getAllStyles().setMargin((int)(15.5 * pixelsPerMM), 0, 0, 0);

                            Container cnt_dept = new Container(); //new BoxLayout(BoxLayout.Y_AXIS)
                            //cnt_dept.setLayout(new TableLayout(2, 1));
                            cnt_dept.setLayout(new BorderLayout());
                            //cnt_dept.setLayout(new GridLayout(2, 1));
                            cnt_dept.getAllStyles().setBgColor(0xffffff, false);
                            cnt_dept.getAllStyles().setBgTransparency(0, false);
                            cnt_dept.getAllStyles().setPadding(0, 0, 0, 0);
                            cnt_dept.getAllStyles().setMargin(0, 0, 0, 0);
                            cnt_dept.add(BorderLayout.NORTH, FlowLayout.encloseCenterMiddle(btn_dept));
                            cnt_dept.add(BorderLayout.SOUTH, splbl_dept);
                            //cnt_dept.add(FlowLayout.encloseCenterMiddle(btn_dept));
                            //cnt_dept.add(splbl_dept);
                            
                            
                            cnt_departments.add(cnt_dept); 
                            
                            i = i+1;
                        }
                    } 
                    catch(IOException err) 
                    {
                            Log.e(err);
                    }
                    
                    
                    
                    
                    
                    //Container cnt_dept = new Container(new GridLayout(1, 4)); 
                    //cnt_dept.getAllStyles().setPadding(0, 0, 0, 0);
                    //cnt_dept.getAllStyles().setMargin(0, 0, 0, 0);
                    //cnt_dept.add(cnt_dept_details);
                    
                    
        
        MainMenu.cont_header.remove();
        MainMenu.lbl_logo.remove();
        MainMenu.lbl_header.setText("Departments Menu");
        
        sty_lg_banner = new Style();
        sty_lg_banner.setFgColor(0x000000);
        sty_lg_banner.setMargin(0, 0, 0, 0);
        sty_lg_banner.setPadding(0, 0, 0, 0);
        sty_lg_banner.setUnderline(false);
        sty_lg_banner.setBgColor(0xffffff);
        sty_lg_banner.setBgTransparency(0, false);
        sty_lg_banner.setAlignment(CENTER);
        sty_lg_banner.setBorder(border);
        
        cnt_titlebar = new Container(new BorderLayout());
        cnt_titlebar.setUnselectedStyle(sty_lg_banner);
        cnt_titlebar.setSelectedStyle(sty_lg_banner);
        cnt_titlebar.getAllStyles().setMargin(0, 10, 0, 0);
        
        
        //Title
        lbl_titleL = new Label();
        //lbl_title.setUIID("TitleFont");
        lbl_titleL.setIcon(img_logo.scaledWidth(displayWidth/2)); lbl_titleL.getStyle().setAlignment(LEFT);
        //lbl_title.setIcon(img_banner.scaledWidth(displayWidth));
        //lbl_title.setIcon(theme.getImage("banner.png").scaledWidth(displayWidth));
        //lbl_title.getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL, false);
        lbl_titleL.getStyle().setBgColor(0xffffff); 
        lbl_titleL.getStyle().setFgColor(0x000000); 
        lbl_titleL.getStyle().setBgTransparency(255, false);
        lbl_titleL.getStyle().setPadding(0, 0, 0, 0);
        lbl_titleL.getStyle().setMargin(0, 10, 0, 0);
        lbl_titleL.getStyle().setBorder(border);
        
        lbl_titleR = new Label();
        lbl_titleR.setText("Karengata");
        lbl_titleR.getStyle().setFont(font_RageItalic);
        lbl_titleR.getAllStyles().setAlignment(CENTER, false);
        lbl_titleR.getStyle().setBorder(border);
        //lbl_titleR.setTextPosition(0);
        //lbl_title.setUIID("TitleFont");
        //lbl_titleR.setIcon(img_logo.scaledWidth(displayWidth/2)); lbl_titleL.getStyle().setAlignment(CENTER);
        //lbl_titleR.setIcon(img_banner.scaledWidth(displayWidth));
        //lbl_titleR.setIcon(theme.getImage("banner.png").scaledWidth(displayWidth));
        //lbl_titleR.getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL, false);
        lbl_titleR.getStyle().setBgColor(0xffffff); 
        lbl_titleR.getStyle().setFgColor(0x000000); 
        lbl_titleR.getStyle().setBgTransparency(255, false);
        lbl_titleR.getStyle().setMargin(0, 10, 0, 0);
        lbl_titleR.getStyle().setPadding(0, 0, 0, 0);
        
        cnt_titlebar.addComponent(BorderLayout.CENTER, GridLayout.encloseIn(2, lbl_titleL, lbl_titleR));
        
        fm_main.addComponent(BorderLayout.NORTH, BoxLayout.encloseY(MainMenu.cont_header, cnt_titlebar));     //cnt_titlebar
        fm_main.addComponent(BorderLayout.CENTER, BorderLayout.south(cnt_departments)); //cnt_button
        //fm_main.addComponent(BorderLayout.SOUTH, cnt_);

        Command backCommand = new Command("")
         {
          public void actionPerformed(ActionEvent ev) 
          {
              //fm_roads.show();
              
          }
         };

        
        fm_main.addCommand(backCommand);
        fm_main.setBackCommand(backCommand);
        fm_main.setTransitionOutAnimator(CommonTransitions.createUncover(CommonTransitions.SLIDE_HORIZONTAL, true, 300));
        fm_main.show();
    }
    
    public void showDepartment()
    {
            for (int i = 0; i < 10; i++) 
            { 
                //selection| 
            }

            dlgi_department = new InteractionDialog(); //(String) Storage.getInstance().readObject("task_1_title")
            dlgi_department.setLayout(new BorderLayout());
            dlgi_department.setScrollableY(true);
            dlgi_department.show(0,0,0,0); 
    }
    
    public void showLoginDialog()
    {
                sbtn = new ShareButton();
                sbtn.setIcon(img_share);
                //sbtn.setText("Share Screenshot");
                //fm_main.add(sbtn);
                //screenshot = Image.createImage(dialog.getWidth(), dialog.getHeight());
                /*
                str_imageFile = FileSystemStorage.getInstance().getAppHomePath() + "pic1.jpg";
                //screenshot = Image.createImage(img_pic1);
                
                InputStream is = null;
                try 
                {
                 is = FileSystemStorage.getInstance().openInputStream(str_imageFile);
                 img_screenshot = Image.createImage(is);
                } 
                catch (IOException ex) 
                {
                 //Logger.getLogger(GalleryMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try(OutputStream os = FileSystemStorage.getInstance().openOutputStream(str_imageFile)) 
                {
                 ImageIO.getImageIO().save(img_screenshot, os, ImageIO.FORMAT_PNG, 1);
                } 
                catch(IOException err) 
                {
                 //Log.e(err); //TODO: return this
                 System.out.println("Error: "+err);
                }
                sbtn.setImageToShare(str_imageFile, "image/png");*/
                sbtn.setTextToShare("Hi! Checkout the new SDA Church Karengata App. Search for 'Karengata' at your phone's app store or go get it from the church website at www.karengatachurch.com.");
                
        btn_close = new Button();
            btn_close.setIcon(img_close);
            btn_close.setUIID("Label");
            btn_close.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                  dlg_login.dispose();
                }
            });
                
        cnt_dlgNorth = new Container(new BorderLayout());
            cnt_dlgNorth.addComponent(BorderLayout.WEST, sbtn);//btn_share
            cnt_dlgNorth.addComponent(BorderLayout.EAST, btn_close);
                                
        
        btn_login = new Button("Log me in now");
            btn_login.addActionListener((ActionListener) new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    if(storage.exists("loginstatus") == true)
                    {
                     str_Login_Status = (String) Connect.storage.readObject("loginstatus");
                     if("OKL".equals(str_Login_Status))
                     {
                        storage.writeObject("screen", "profile");
                        LoginMenu loginer = new LoginMenu();
                        loginer.showLoginScreen();
                     }
                     else
                     {
                        //storage.writeObject("screen", "home");
                        LoginMenu loginer = new LoginMenu();
                        loginer.showLoginScreen();
                     }
                    }
                    else
                    {
                        //storage.writeObject("screen", "home");
                        LoginMenu loginer = new LoginMenu();
                        loginer.showLoginScreen();
                    }
                    
                }
            });
            
        btn_later = new Button("Remind me to later");
            btn_later.getStyle().setMarginRight(10);
            btn_later.addActionListener((ActionListener) new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    MainMenu homer = new MainMenu();
                    homer.showMainMenu();
                }
            });
            
        btn_signme = new Button("I don't have logins.");
            btn_later.getStyle().setMarginLeft(10);
            btn_signme.addActionListener((ActionListener) new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    
                }
            });
            
        btn_forgot = new Button("I've forgotten my logins.");
            btn_forgot.addActionListener((ActionListener) new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    
                }
            });
            
        cnt_dlgSouth = new Container(new FlowLayout(CENTER, CENTER));
            cnt_dlgSouth.add(btn_later);
            cnt_dlgSouth.add(btn_login);
            
        dlg_login = new Dialog("Login Required!!!");
            dlg_login.setLayout(new BorderLayout());
            dlg_login.add(BorderLayout.NORTH, cnt_dlgNorth);
            dlg_login.add(BorderLayout.CENTER, new SpanLabel("Sorry, you must be logged in to access the profiles menu.", "DialogBody"));
            dlg_login.add(BorderLayout.SOUTH, cnt_dlgSouth);
            dlg_login.showPacked(BorderLayout.CENTER, true);
    }

    public void stop()
    {
        Form current = Display.getInstance().getCurrent();
    }  


   
    public void doShare()
    {
     InputStream is = null;
                try 
                {
                 //is = FileSystemStorage.getInstance().openInputStream(str_imageFile);
                 //screenshot = Image.createImage(is);
                 
                 is =  Storage.getInstance().createInputStream("current.jpg");
                 imge = EncodedImage.create(is, is.available());
                } 
                catch (IOException ex) 
                {
                }

                str_imageFile = FileSystemStorage.getInstance().getAppHomePath() + "current.jpg";
                try(OutputStream os = FileSystemStorage.getInstance().openOutputStream(str_imageFile)) 
                {
                 ImageIO.getImageIO().save(imge, os, ImageIO.FORMAT_PNG, 1);
                } 
                catch(IOException err) 
                {
                 Log.e(err);
                }
                
                sbtn.setImageToShare(str_imageFile, "image/jpeg");//image/png
                sbtn.setTextToShare("Hi! Checkout the traffic on "+str_barabara+" around "+str_Sub_barabara+". ///--BITTRAFFIC--//");
    }
   
    public void localNotificationReceived(String notificationId) 
    {
        System.out.println("Received local notification "+str_car0+" in callback localNotificationReceived");
        Dialog.show("You have a new message!", "Please go to your inbox to.", "Ok", null);
        Display.getInstance().cancelLocalNotification(str_car0);
        //NoticesMenu noticer = new NoticesMenu();
        //noticer.showNoticesMenu();
    }
}