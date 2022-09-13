package com.mobitribe.hesabu;

import com.codename1.components.InteractionDialog;
import com.codename1.components.ShareButton;
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

//import com.imediakenya.eventsapp.Utilz.Images;
//import com.imediakenya.eventapp.Utilz.Images;

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
import com.codename1.util.StringUtil;
import static com.mobitribe.hesabu.Connect.str_protocol;
import static com.mobitribe.hesabu.Connect.str_host;
import static com.mobitribe.hesabu.Connect.str_port;
import static com.mobitribe.hesabu.Connect.str_path;
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

public class MembersMenu extends Exception
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
    
    private Style sty, sty_lg;
    private String str_imageFile;
    
    private Image img_toshare;
    
    //private Storage storage = Storage.getInstance();
    
    private Container cnt_road, cnt_nav, cnt_button, cnt_titlebar, cnt_taskbar, cnt_grid, cnt_members;
    
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
    Button[] button_member;
    private int i;
    private Image img_DEPTplaceholder;
    
    //DIALOG
    private Dialog dlg_login;
    
    private Container cnt_dlgSouth, cnt_dlgNorth;
    
    public String str_users_id, str_users_memnos, str_users_family, str_users_firstname, str_users_middlename, str_users_lastname, 
            str_users_nickname, str_users_title, str_users_userid, str_users_role, str_users_level, str_users_birth_date, str_users_age, 
            str_users_ppno, str_users_idno, str_users_gender, str_users_country, str_users_nationality, str_users_county, str_users_city, 
            str_users_phone, str_users_phone_alt, str_users_email_address, str_users_physical_address, 
            str_users_postal_code, str_users_residence, str_users_street_road, str_users_floor_court_flat_building, str_users_door_house_number, str_users_longitude, str_users_latitude, str_users_postal_address, str_users_postal_address_home, str_users_postal_code_home, str_users_postal_address_work, str_users_postal_code_work, str_users_approvedby, str_users_approvedon, 
            str_users_emergency_contact, str_users_emergency_contact_phone, str_users_dietary_need, str_users_food_allergies, str_users_medicine_allergies, 
            str_users_blood_type, str_users_heamoglobin, str_users_weight, str_users_height, str_users_bmi, str_users_blood_pressure, str_users_muscle_strength, str_users_special_medical_condition,
            str_users_language, str_users_adminid, str_users_admincellphone, str_users_status, str_users_phone_work, str_users_phone_home, str_users__email,
            str_users_email_alt, str_users_email_work, str_users_email_home, str_users_photo, str_users_marital_status, str_users_marital_time, 
            str_users_marital_date, str_users_spouse, str_users_children, str_users_department, str_users_department1, str_users_department2, 
            str_users_department3, str_users_department_prospects, str_users_departments, str_users_spiritual_gifts, str_users_ministry, 
            str_users_cell_church, str_users_ss_class, str_users_board_member, str_users_babtism_status, str_users_babtism_date, str_users_membership, 
            str_users_member_by, str_users_irregular, str_users_regular_at, str_users_adventist, str_users_occupation, str_users_place_of_work, str_users_industry, 
            str_users_education, str_users_experience, str_users_employment, str_users_employment_status, str_users_reminder;
    
    private String str_content;
    
    private Container cnt_home, cnt_users, cnt_messages, cnt_finance, cnt_settings;
    
    private CheckBox[] cb_member;
    private CheckBox cb_mshiriki;
    private Image img_avatar_male, img_avatar_female;
    
    private String str_bool_loggedin, str_bool_keepmeloggedin, str_bool_isMemberSelected;
    private boolean bool_loggedin, bool_keepmeloggedin, bool_isMemberSelected; 
    
    public void showMainForm()
    {
     try
     {
      img_background = Image.createImage("/Askari.png").scaledHeight(displayHeight);
      img_banner = Image.createImage("/banner.png");
      img_logo = Image.createImage("/logo.jpg");
      img_info = Image.createImage("/info.png");
      //img_avatar = Image.createImage("/avatar.png");
      img_back = Image.createImage("/back.png");
      img_placeholder = Image.createImage("/placeholderBaro.jpg");
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

      MainMenu nissanhomy = new MainMenu();
      //nissanhomy.getToolbar();
      
      //fm_main.setToolbar(tb_form);
      //fm_home.getToolbar().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
      //tb_form.setTitle("Members Menu");
      
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
        
            FileSystemStorage inst = FileSystemStorage.getInstance();
        final String homePath = inst.getAppHomePath();
        final char sep = inst.getFileSystemSeparator();
      
      Label lbl_no_data_users = new Label("No Data");
        lbl_no_data_users.getAllStyles().setAlignment(CENTER, false);
        lbl_no_data_users.setVerticalAlignment(CENTER);
        lbl_no_data_users.getAllStyles().setFgColor(0xffffff, false);
        lbl_no_data_users.getAllStyles().setBgColor(0x000000, false);
        lbl_no_data_users.getAllStyles().setBgTransparency(120, false);
      
        cnt_users = new Container();
        cnt_users.setScrollableY(true);
        cnt_users.getAllStyles().setFgColor(0x000000, false);
      
        
        final String str_filepath = homePath+sep+"members.txt";
        
        if(inst.exists(str_filepath) == true)
        {
            cnt_users.setLayout(new FlowLayout(LEFT, CENTER));
        }
        else
        {
            cnt_users.setLayout(new FlowLayout(CENTER, CENTER));
            cnt_users.add(lbl_no_data_users);
        }
        
        try 
        {
            InputStream is = inst.openInputStream(str_filepath);
            byte[] b = Util.readInputStream(is);
            str_content = new String(b); //System.out.println("Content..: "+str_content);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        Label lbl_photo = new Label("Photo");
        lbl_photo.getAllStyles().setAlignment(LEFT);
        lbl_photo.getStyle().setFont(font_HPSimplified);
        lbl_photo.getAllStyles().setFgColor(0x000000, false);
        lbl_photo.getAllStyles().setBgColor(0xffffff, false);
        lbl_photo.getAllStyles().setBgTransparency(0, false);
        lbl_photo.getAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
        
        Label lbl_jina = new Label("Name");
        lbl_jina.getAllStyles().setAlignment(LEFT);
        lbl_jina.getStyle().setFont(font_HPSimplified);
        lbl_jina.getAllStyles().setFgColor(0x000000, false);
        lbl_jina.getAllStyles().setBgColor(0xffffff, false);
        lbl_jina.getAllStyles().setBgTransparency(0, false);
        lbl_jina.getAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(3.3 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
        
        Label lbl_jinsia = new Label("Gender");
        lbl_jinsia.getAllStyles().setAlignment(LEFT);
        lbl_jinsia.getStyle().setFont(font_HPSimplified);
        lbl_jinsia.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_jinsia.getAllStyles().setPadding(0, 0, 0, 0);
        lbl_jinsia.getAllStyles().setFgColor(0x000000, false);
        lbl_jinsia.getAllStyles().setBgColor(0xffffff, false);
        lbl_jinsia.getAllStyles().setBgTransparency(0, false);
        lbl_jinsia.getAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(9.2 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
        
        cb_mshiriki = new CheckBox();
        cb_mshiriki.setText("");
        cb_mshiriki.setEnabled(true);
        cb_mshiriki.getAllStyles().setMargin(0, 0, 0, 0);
        //checkBox.setTextPosition(LEFT);
        cb_mshiriki.getAllStyles().setAlignment(CENTER);
        //checkBox.isOppositeSide();
        //checkBox.getStyle().setFont(font);
        cb_mshiriki.getStyle().setFgColor(0x5555ff);
        cb_mshiriki.getStyle().setBgTransparency(1);
        //checkBox.setPreferredSize(new Dimension(100, 2));
        //checkBox.setShiftText(-3);
        cb_mshiriki.setTactileTouch(true); 
        //checkBox.getStyle().setBgColor(0xdddd99);
        cb_mshiriki.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                //str_bool_keepmeloggedin = String.valueOf(cb_mshiriki.isSelected());
                //System.out.println("chbox_keepmeloggedin checked: "+str_bool_keepmeloggedin);
            }
        });
        
        Button btn_photo = new Button("Photo");
        btn_photo.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
        btn_photo.getAllStyles().setAlignment(LEFT, false);
        //btn_photo.setIcon(img_avatar_male.scaledWidth(100));
        btn_photo.setUIID("Label");
        //btn_photo.setTextPosition(BOTTOM);
        btn_photo.getStyle().setBgTransparency(0, false);
        btn_photo.getStyle().setBgColor(0xffffff); 
        btn_photo.getStyle().setFgColor(0x000000); //0xFFD800
        btn_photo.getStyle().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(6.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
        btn_photo.setSelectedStyle(btn_photo.getUnselectedStyle());
        btn_photo.setPressedStyle(btn_photo.getUnselectedStyle());
        
        SpanLabel spl_jina = new SpanLabel("Name");
        spl_jina.getTextAllStyles().setAlignment(LEFT, false);
        spl_jina.getAllStyles().setAlignment(LEFT, false);
        spl_jina.getStyle().setBgColor(0xffffff); 
        spl_jina.getStyle().setFgColor(0x000000);
        spl_jina.getStyle().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(0.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
        spl_jina.getStyle().setMargin(0, (int)(0.5 * pixelsPerMM), (int)(0.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
        spl_jina.getTextAllStyles().setFgColor(0x000000, false);
        spl_jina.getTextAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
        spl_jina.getTextAllStyles().setMargin(0, (int)(0.5 * pixelsPerMM), (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
        //spl_member.setWidth(100);
        spl_jina.setPreferredW((int)(20.5 * pixelsPerMM)); //img_avatar_male.getWidth()
        spl_jina.getStyle().setBgTransparency(0, false);
        spl_jina.getStyle().setFont(font_HPSimplified);
        
        cnt_members = new Container(new BoxLayout(BoxLayout.Y_AXIS)); //new GridLayout(obj_content.size(), 2)
        cnt_members.setScrollableY(true);
        //BoxLayout.encloseY(BoxLayout.encloseX(FlowLayout.encloseLeftMiddle(cb_mshiriki),  FlowLayout.encloseCenterMiddle(lbl_photo),        FlowLayout.encloseCenterMiddle(lbl_jina),   FlowLayout.encloseCenterMiddle(lbl_jinsia)), cnt_members)
        
        
            String str_json_read = str_content;//(String) Storage.getInstance().readObject("members.json");
            byte[] dataa = str_json_read.getBytes();
                
            JSONParser json = new JSONParser();
            //try(Reader reader = new InputStreamReader(Display.getInstance().getResourceAsStream(getClass(), "/anapioficeandfire.json"), "UTF-8"))
            try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
            {
                Map<String, Object> map_content = json.parseJSON(is_content); //System.out.println("Userdetails.json map_content: "+map_content);
                java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root"); //System.out.println("Userdetails.json obj_content: "+obj_content);
                System.out.println("No of Members:---------> "+obj_content.size()); 
                
                button_member = new Button[obj_content.size()];
                cb_member = new CheckBox[obj_content.size()];
                        
                i = 0;
                for(Map<String, Object> obj : obj_content) 
                {              
                    if(str_users_title == null || str_users_title.length() == 0){}else{}

                    str_users_userid = (String)obj.get("id");
                    str_users_userid = (String)obj.get("id");
                    str_users_memnos = (String)obj.get("member_no");
                    str_users_family = (String)obj.get("family_id");
                    str_users_title = (String)obj.get("title");
                    str_users_firstname = (String)obj.get("firstname");
                    str_users_middlename = (String)obj.get("middlename");
                    str_users_lastname = (String)obj.get("lastname");
                    str_users_nickname = (String)obj.get("nickname");
                    str_users_birth_date = (String)obj.get("dob");
                    str_users_age = (String)obj.get("age");
                    str_users_ppno = (String)obj.get("ppno");
                    str_users_idno = (String)obj.get("idno");
                    str_users_gender = (String)obj.get("gender"); Storage.getInstance().writeObject("users_gender", str_users_gender);
                    str_users_nationality = (String)obj.get("nationality");
                    str_users_country = (String)obj.get("country");
                    str_users_county = (String)obj.get("county");
                    str_users_city = (String)obj.get("city");
                    str_users_email_address = (String)obj.get("id");
                    str_users_physical_address = (String)obj.get("id");
                    str_users_longitude = (String)obj.get("longitude");
                    str_users_latitude = (String)obj.get("latitude");
                    str_users_postal_address = (String)obj.get("postal_address");
                    str_users_postal_code = (String)obj.get("postal_code");
                    str_users_postal_address_home = (String)obj.get("postal_address_home");
                    str_users_postal_code_home = (String)obj.get("postal_code_home");
                    str_users_postal_address_work = (String)obj.get("postal_address_work");
                    str_users_postal_code_work = (String)obj.get("postal_code_work");
                    str_users_residence = (String)obj.get("residence");
                    str_users_street_road = (String)obj.get("street_road");
                    str_users_floor_court_flat_building = (String)obj.get("court_flat_building");
                    str_users_door_house_number = (String)obj.get("door_house_number");
                    str_users_phone = (String)obj.get("phone");
                    str_users_phone_alt = (String)obj.get("phone_alt");
                    str_users_phone_work = (String)obj.get("phone_work");
                    str_users_phone_home = (String)obj.get("phone_home");
                    str_users__email = (String)obj.get("email");
                    str_users_email_alt = (String)obj.get("email_alt");
                    str_users_email_work = (String)obj.get("email_work");
                    str_users_email_home = (String)obj.get("email_home");
                    str_users_photo = (String)obj.get("photo");
                    str_users_approvedby = (String)obj.get("approved_by");
                    str_users_approvedon = (String)obj.get("approved_on");
                    str_users_emergency_contact = (String)obj.get("emergency_contact");
                    str_users_emergency_contact_phone = (String)obj.get("emergency_contact_phone");
                    str_users_dietary_need = (String)obj.get("dietary_need");
                    str_users_food_allergies = (String)obj.get("food_allergies");
                    str_users_medicine_allergies = (String)obj.get("medicine_allergies");
                    str_users_blood_type = (String)obj.get("medicine_allergies");
                    str_users_heamoglobin = (String)obj.get("medicine_allergies");
                    str_users_weight = (String)obj.get("medicine_allergies");
                    str_users_height = (String)obj.get("medicine_allergies");
                    str_users_bmi = (String)obj.get("medicine_allergies");
                    str_users_blood_pressure = (String)obj.get("medicine_allergies");
                    str_users_muscle_strength = (String)obj.get("medicine_allergies");
                    str_users_special_medical_condition = (String)obj.get("medicine_allergies");
                    str_users_language = (String)obj.get("language");
                    str_users_role = (String)obj.get("role");
                    str_users_level = (String)obj.get("level");
                    str_users_adminid = (String)obj.get("added_by");
                    str_users_status = (String)obj.get("status");
                    str_users_marital_status = (String)obj.get("marital_status");
                    str_users_marital_time = (String)obj.get("marital_time");
                    str_users_marital_date = (String)obj.get("marital_date");
                    str_users_spouse = (String)obj.get("spouse");
                    str_users_children = (String)obj.get("children");
                    str_users_department = (String)obj.get("department");
                    str_users_department1 = (String)obj.get("department1");
                    str_users_department2 = (String)obj.get("department2");
                    str_users_department3 = (String)obj.get("department3");
                    str_users_department_prospects = (String)obj.get("department_prospects");
                    str_users_departments = (String)obj.get("departments");
                    str_users_spiritual_gifts = (String)obj.get("spiritual_gifts");
                    str_users_ministry = (String)obj.get("ministry");
                    str_users_cell_church = (String)obj.get("church");
                    str_users_ss_class = (String)obj.get("class");
                    str_users_board_member = (String)obj.get("board_member");
                    str_users_babtism_status = (String)obj.get("babtism_status");
                    str_users_babtism_date = (String)obj.get("babtism_date");
                    str_users_membership = (String)obj.get("membership");
                    str_users_member_by = (String)obj.get("member_by");
                    str_users_irregular = (String)obj.get("irregular");
                    str_users_regular_at = (String)obj.get("regular_at");
                    str_users_adventist = (String)obj.get("adventist");
                    str_users_occupation = (String)obj.get("occupation");
                    str_users_place_of_work = (String)obj.get("place_of_work");
                    str_users_industry = (String)obj.get("industry");
                    str_users_education = (String)obj.get("education");
                    str_users_experience = (String)obj.get("experience");
                    str_users_employment = (String)obj.get("employment");
                    str_users_employment_status = (String)obj.get("employment_status");
                    str_users_reminder = (String)obj.get("reminder");
                    
                    //Dimension dim_photo = new Dimension(displayWidth, theme.getImage("photo_placeholder.jpg").getHeight()+2);
                    //tabs.setPreferredSize(dim_photo);
                    
                    SpanLabel spl_name = new SpanLabel(str_users_firstname+" "+str_users_lastname);
                    spl_name.getStyle().setBgColor(0xffffff); 
                    spl_name.getStyle().setFgColor(0x000000);
                    spl_name.getStyle().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
                    spl_name.getStyle().setMargin(0, (int)(0.5 * pixelsPerMM), (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
                    spl_name.getTextAllStyles().setAlignment(LEFT, false);
                    spl_name.getTextAllStyles().setFgColor(0x000000, false);
                    spl_name.getTextAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
                    spl_name.getTextAllStyles().setMargin(0, (int)(0.5 * pixelsPerMM), (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
                    //spl_member.setWidth(100);
                    spl_name.setPreferredW((int)(20.5 * pixelsPerMM)); //img_avatar_male.getWidth()
                    spl_name.getStyle().setBgTransparency(0, false);
                    spl_name.getStyle().setFont(font_HPSimplified);
                    spl_name.addPointerPressedListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            Log.p(" label pressed.", 1);
                        }
                    });


                    Label lbl_member = new Label(str_users_firstname+" "+str_users_lastname);
                    //lbl_department.getAllStyles().setPadding(0, 15, 0, 0);
                    lbl_member.getAllStyles().setAlignment(LEFT);
                    lbl_member.getStyle().setFont(font_HPSimplified);
                    lbl_member.setName(String.valueOf(i));



                    //int mm = Display.getInstance().convertToPixels(3);
                    //EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);

                    cb_member[i] = new CheckBox();
                    cb_member[i].setText(""); //Keep me loggined in.
                    cb_member[i].setEnabled(true);
                    cb_member[i].getAllStyles().setMargin(0, 0, 0, 0);
                    cb_member[i].setTextPosition(BOTTOM);
                    cb_member[i].setGap((int)(5.5 * pixelsPerMM));
                    cb_member[i].getAllStyles().setAlignment(CENTER);
                    cb_member[i].setVerticalAlignment(CENTER);
                    //checkBox.isOppositeSide();
                    //checkBox.getStyle().setFont(font);
                    cb_member[i].getStyle().setFgColor(0x5555ff);
                    cb_member[i].getStyle().setBgTransparency(1);
                    //checkBox.setPreferredSize(new Dimension(100, 2));
                    //checkBox.setShiftText(-3);
                    cb_member[i].setTactileTouch(true); 
                    //checkBox.getStyle().setBgColor(0xdddd99);
                    cb_member[i].addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent evt)
                        {
                            bool_isMemberSelected = cb_member[Integer.parseInt(lbl_member.getName())].isSelected();
                            System.out.println("cb_member["+lbl_member.getName()+"] checked: "+bool_isMemberSelected);
                        }
                    });
                    
                    
                    button_member[i] = new Button();
                    button_member[i].getAllStyles().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
                    int pixels = (int)(1.5 * pixelsPerMM);
                    int height = (int)(33.9 * pixelsPerMM);
                    int width = (int)(20 * pixelsPerMM);
                    //button_member[i].getAllStyles().setPadding(pixels, pixels, pixels, pixels);

                    System.out.println("Image Width: "+img_avatar_male.getWidth());
                    
                    try
                    {
                            if(str_users_photo != null && str_users_photo.length() != 0)
                            {
                                EncodedImage imge_photo_placeholder = EncodedImage.createFromImage(img_avatar_male, true); //theme.getImage("photo_placeholder.jpg")
                                Image img_photo = URLImage.createCachedImage(str_users_photo, str_protocol + str_host + str_port + str_path + str_users_photo, imge_photo_placeholder, URLImage.FLAG_RESIZE_SCALE);

                                Log.p("Loading photo url -> "+str_protocol + str_host + str_port + str_path + str_users_photo, 1);
                                button_member[i].setIcon(img_photo.scaledWidth(100));

                            }
                            else
                            {   //TODO: Check for age and add pony tails for girls and scruffy hair for boys
                                if(str_users_gender != null && str_users_gender.length() != 0)
                                {
                                    if(str_users_gender.equals("Male"))
                                    {
                                        button_member[i].setIcon(img_avatar_male.scaledWidth(100));
                                    }
                                    else
                                    {
                                        button_member[i].setIcon(img_avatar_female.scaledWidth(100));
                                    }
                                }
                                else
                                {   //TODO: Put neutor image
                                    button_member[i].setIcon(img_avatar_male.scaledWidth(100));
                                }
                            }
                            
                            
                            //Image img_photo = Image.createImage(str_homepath+"/img"+"/"+"products"+"/"+str_category+"/"+str_subcategory+"/"+str_item_id+"/"+str_photo_file);
                            //ImageViewer imgv = new ImageViewer(img_photo); //imge
                            //imgv.getStyle().setAlignment(CENTER);
                            //lbl_item_image.setIcon(imgv.getImage().scaledWidth(displayWidth));
                            

                            //button_member[i].setIcon(imgv.getImage());

                            //button_member[i].getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FIT, false);
                            //button_member[i].getStyle().setBgImage(imgv.getImage(), false);
                            //button_member[i].setAutoSizeMode(true);
                    } 
                    catch (Exception e) 
                    {
                            //Set place holder
                            String str_errorType = StringUtil.tokenize(e.toString(), ":").get(0);
                            if(str_errorType.equals("java.io.FileNotFoundException"))
                            {
                                    //Dialog.show("Error Occured!", "Image unavailable.", "Ok", null);
                                    //TODO: Here set the image place holder
                                    System.out.println(">>"+e);
                            }
                            else
                            {
                                    //Dialog.show("Error Occured!", ">> "+e, "Ok", null);
                                    //System.out.println(">>"+e); //java.io.FileNotFoundException: C:\Users\Tommy Mogaka\.cn1\MyImage.png (The system cannot find the file specified)
                                    e.printStackTrace();
                            }
                    }

                    //button_member[i].setIcon(img_avatar_male.scaledWidth(250)); //createImage(width, height) //.scaledWidth(img_department.getWidth()) //theme.getImage("adventist_icon.jpg")
                    //button_department[i].setText(str_department_nm);
                    button_member[i].setUIID("Label");
                    button_member[i].setTextPosition(BOTTOM);
                    button_member[i].getStyle().setBgTransparency(0, false);
                    button_member[i].getStyle().setBgColor(0x000000); 
                    button_member[i].getStyle().setFgColor(0xFFD800);
                    //button_member[i].getStyle().setPadding(10,10,25,25);
                    button_member[i].getStyle().setPadding(0, (int)(0.5 * pixelsPerMM), (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
                    button_member[i].setSelectedStyle(button_member[i].getUnselectedStyle());
                    button_member[i].setPressedStyle(button_member[i].getUnselectedStyle());
                    button_member[i].addActionListener(new ActionListener() 
                    {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                            }
                    });
                    
                    Label lbl_gender = new Label(str_users_gender);
                    //lbl_department.getAllStyles().setPadding(0, 15, 0, 0);
                    lbl_gender.getAllStyles().setAlignment(LEFT);
                    lbl_gender.getAllStyles().setFont(font_HPSimplified);
                    lbl_gender.getAllStyles().setFgColor(0x000000, false);
                    lbl_gender.getAllStyles().setBgColor(0xffffff, false);
                    lbl_gender.getAllStyles().setBgTransparency(0, false);
                    
                    if(i == 0)
                    {
                        //cnt_members.addComponent(BoxLayout.encloseX(FlowLayout.encloseLeftMiddle(cb_mshiriki), FlowLayout.encloseCenterMiddle(btn_photo), FlowLayout.encloseCenterMiddle(lbl_jina), FlowLayout.encloseCenterMiddle(lbl_jinsia))); 
                    }
                    
                    cnt_members.addComponent(BoxLayout.encloseX(FlowLayout.encloseLeftMiddle(cb_member[i]), FlowLayout.encloseCenterMiddle(button_member[i]), FlowLayout.encloseCenterMiddle(spl_name), FlowLayout.encloseCenterMiddle(lbl_gender))); 

                    i = i+1;                    
                }
            } 
            catch(IOException err) 
            {
                    //Log.e(err);
            }
            
            
             
        fm_main.addComponent(BorderLayout.NORTH, cnt_titlebar);
        fm_main.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(BoxLayout.encloseX(FlowLayout.encloseLeftMiddle(cb_mshiriki), FlowLayout.encloseCenterMiddle(btn_photo), FlowLayout.encloseCenterMiddle(lbl_jina), FlowLayout.encloseCenterMiddle(lbl_jinsia)), cnt_members)); //cnt_button
        //fm_subroads.addComponent(BorderLayout.SOUTH, cnt_nav);

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