package com.mobitribe.hesabu;

import com.codename1.components.InteractionDialog;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.BufferedInputStream;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.*;
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
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.mobitribe.hesabu.Connect;
import com.mobitribe.hesabu.MainMenu;
import com.mobitribe.hesabu.LoginMenu;
//import com.mobitribe.hesabu.departments.DepartmentsMenu;
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
import com.mobitribe.hesabu.MainMenu;
//import static com.mobitribe.hesabu.MainMenu.dlg_avatar;
//import com.mobitribe.hesabu.mission.MissionMenu;
//import javax.xml.bind.ParseConversionEvent;

public class AccountsMenu implements LocalNotificationCallback 
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
    
    private Image img_info, img_avatar, img_home, img_back, img_berger, img_banner, img_logo, img_blueish_btn;
    
    private Image img_share, img_close;
    
    private Resources theme;
    
    private Dimension dim_btn;
    
    private String str_car0, str_order;

    
    private Integer int_displayW;
    private String str_displayW;
    
    private Style sty, sty_lg;
    private String str_imageFile;
    
    private Image img_toshare;
    
    //private Storage storage = Storage.getInstance();
    
    private Container cnt_road, cnt_nav, cnt_button, cnt_titlebar, cnt_taskbar, cnt_grid, cnt_hymns, cnt_page1, cnt_page2, cnt_page3, cnt_next, cnt_last;
    
    private Button btn_back, btn_start, btn_scores, btn_about, btn_department;
    private boolean bool_Login_staus;
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
    private Button btn_bible, btn_hymnal, btn_lesson, btn_bulletin, btn_home, btn_departments, btn_spiritualGifts, btn_ministries, btn_resourses, btn_worldchurch, btn_contactus;
    
    
    private Font font_ArialBold, font_RageItalic, font_HPSimplified, font_HPSimplifiedBold, font_HPSimplifiedBoldBig, font_HPSimplifiedLight, font_HPSimplifiedLightItalic;
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
    String[] str_stanza, str_line;
    SpanLabel[] splbl_line;
    Container[] cnt_stanza;
    private int i, j, k, int_no_of_lines, int_no_of_stanzas;
    private String str_no_of_lines, str_no_of_stanzas;
    
    private Image img_DEPTplaceholder;
    
    //DIALOG
    private Dialog dlg_login;
    
    private Container cnt_dlgSouth, cnt_dlgNorth;
    
    private String str_hymn;
    private  BufferedInputStream bis;
    
    private String str_response_code, str_response_data, str_needle, str_haystack, str_content;
    
    private Container cnt_table, cnt_tablehead, cnt_tablebody, cnt_tablefoot;
    private Label lbl_id_column, lbl_date_column, lbl_code_column, lbl_amount_column, lbl_currency_column, lbl_method_column, lbl_actions_column;
    
    Label[] lbl_view, lbl_course_ttle, lbl_score, lbl_icon, lbl_likes, lbl_comments, lbl_views, lbl_shares, lbl_talking, 
            lbl_voteup, lbl_votedown, lbl_author, lbl_datetime, lbl_organisation, lbl_divider, lbl_spacer, lbl_weight, lbl_grademarks, 
            lbl_range, lbl_percent, lbl_gradeletter, lbl_contribution, lbl_totals, lbl_attempts, lbl_attempts_smade, lbl_attempts_allowed, lbl_attempts_grade, lbl_attempts_grading, lbl_attempts_reported, lbl_attempts_lastsync;
    SpanLabel[] splbl_item, splbl_desc, splbl_div;
    TextField[] txtf_view;
    Container[] cnt_tablerow, cnt_score, cnt_desc, cnt_icon, cnt_no, cnt_date, cnt_amount, cnt_item;
    Container[] cnt_id, cnt_user_id, cnt_code, cnt_type, cnt_method, cnt_currency, cnt_description, cnt_quantity, cnt_cost, cnt_vat, cnt_total_cost, cnt_discount, cnt_grand_total, cnt_paid, cnt_due, 
            cnt_refund, cnt_account_no, cnt_category_id, cnt_product_id, cnt_item_id, cnt_agent_id, cnt_added_by, cnt_added_on, cnt_updatedon, cnt_updatedby, cnt_approvedby, cnt_approvedon, 
            cnt_action_on, cnt_action_by, cnt_status, cnt_actions;
    
    
    Label[] lbl_id, lbl_date, lbl_user_id, lbl_code, lbl_type, lbl_method, lbl_currency, lbl_description, lbl_quantity, lbl_cost, lbl_amount, lbl_vat, lbl_total_cost, lbl_discount, lbl_grand_total, lbl_paid, lbl_due, lbl_refund, lbl_account_no, lbl_category_id, 
            lbl_product_id, lbl_item_id, lbl_agent_id, lbl_added_by, lbl_added_on, lbl_updatedon, lbl_updatedby, lbl_approvedby, lbl_approvedon, lbl_action_on, lbl_action_by, lbl_status;
    
    Button[] btn_view, btn_edit, btn_send, btn_delete;
    
    private String str_jina, str_pay_mode;
    
    
    
    public void showMainForm()
    {
        System.out.println("Inside showMainForm() of AccountsMenu.java");
        
     try
     {
      img_background = Image.createImage("/Askari.png").scaledHeight(displayHeight);
      img_banner = Image.createImage("/banner.png");
      img_logo = Image.createImage("/logo.jpg");
      img_blueish_btn = Image.createImage("/blueish_button.png");
      img_info = Image.createImage("/info.png");
      //img_avatar = Image.createImage("/avatar.png");
      img_back = Image.createImage("/back.png");
      img_placeholder = Image.createImage("/placeholderBaro.jpg");
      img_uhurug = Image.createImage("/uhuru_gardens.png");
      img_wilson = Image.createImage("/wilson.png");
      img_barracks = Image.createImage("/barracks.png");
      img_tmall = Image.createImage("/tmall_roundabout.png");
      img_mdaraka = Image.createImage("/madaraka.png");
      img_department = Image.createImage("/department.png");
      
//      img_home = Image.createImage("/home.png");
//      img_home = Image.createImage("/home.png");
//      img_berger = Image.createImage("/berger.png");
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
       
       font_ArialBold = Font.createTrueTypeFont("Arial Black", "Arial Bold.ttf");
       font_ArialBold = font_ArialBold.derive((int)(5.0 * pixelsPerMM), Font.STYLE_BOLD);
       
       
       
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
        FontImage ifont_burger = FontImage.createMaterial(FontImage.MATERIAL_MENU, sty_icon, 4); //MATERIAL_MORE_HORIZ
        FontImage ifont_avatar = FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty_icon, 4);
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
        sty.setFgColor(0xffffff);
        sty.setMargin(0, 0, 0, 0);
        sty.setPadding(0, 0, 0, 0);
        sty.setMarginUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        sty.setUnderline(false);
        sty.setBgTransparency(0, false);
        sty.setAlignment(CENTER);
        sty.setBorder(null);
        
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
        
//        btn_send = new Button();
//        btn_send.setFocusable(false);
//        btn_send.setUIID("Label");
//        btn_send.setFocusable(false);
//        btn_send.setUnselectedStyle(sty_lg);
//        btn_send.setSelectedStyle(sty_lg);
//        btn_send.setPressedStyle(sty_lg);
//        btn_send.setIcon(img_info);
//        btn_send.addActionListener(new ActionListener() 
//        {
//         public void actionPerformed(ActionEvent evt) 
//         {
//          //AboutMenu aboutus = new AboutMenu();
//          //aboutus.showAboutMenu();
//         }
//        });
                
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
        if(Display.getInstance().isDesktop() == false)
        {
            //cnt_titlebar.addComponent(BorderLayout.CENTER, GridLayout.encloseIn(2, lbl_titleL, lbl_titleR)); //lbl_title
        }
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
        
       
      //tb_mainfm = new Toolbar();
      //tb_mainfm.setTitleCentered(true);
      //fm_main.setToolbar(tb_mainfm);
      ////fm_main.getToolbar().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
      //tb_mainfm.setTitle("Departments Menu");
      //tb_mainfm.getTitleComponent().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
      //tb_mainfm.getTitleComponent().getStyle().setFgColor(0xffffff);
      
      
      tb = new Toolbar();
      tb.setTitleCentered(true);
      fm_main.setToolbar(tb);
      //fm_main.getToolbar().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
      if(Storage.getInstance().readObject("role").toString().equals("treasurer"))
      {
          tb.setTitle("Accounts Menu");
      }
      else
      {
          tb.setTitle("Accounts Menu");
      }
      
      tb.getTitleComponent().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
      tb.getTitleComponent().getStyle().setFgColor(0xffffff);
      //tb.add(BorderLayout.EAST, LayeredLayout.encloseIn(cnt_titlebar));
      if(Display.getInstance().isDesktop() == true)
      {
          tb.getTitleComponent().setUnselectedStyle(sty_lg);
      }
      
      sty_icon = fm_main.getUIManager().getComponentStyle("Title"); 
      sty_icon.setFgColor(0xffffff);
      sty_icon.setBgColor(0xffffff);
      sty_icon.setBgTransparency(0, false);
      
      ifont_burger = FontImage.createMaterial(FontImage.MATERIAL_MENU, sty_icon, 4); //MATERIAL_MORE_HORIZ
      ifont_avatar = FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty, 4); //MATERIAL_MORE_HORIZ 
      ifont_close = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, sty_icon, 4); //MATERIAL_MORE_HORIZ ifont_close
      /*fm_main.getToolbar().addCommandToSideMenu("Sidemenu", ifont_burger, new ActionListener() //ifont_burger
      {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
              
          }
      });*/
      
      
      Image img_profilePic = theme.getImage("logo-official.jpg");
        Image img_mask = theme.getImage("round-mask.png");
        img_mask = img_mask.scaledHeight(img_mask.getHeight() / 4 * 3);
        img_profilePic = img_profilePic.fill(img_mask.getWidth(), img_mask.getHeight());
        Label lbl_profilePicLabel = new Label("  SDA Church Karengata", img_profilePic, "SideMenuTitle");
        lbl_profilePicLabel.setMask(img_mask.createMask());

        Container cnt_sidemenuTop = BorderLayout.center(lbl_profilePicLabel);
        cnt_sidemenuTop.setUIID("SidemenuTop");
        
        //fm_main.getToolbar().addMaterialCommandToSideMenu("  Spiritual Gifts", FontImage.MATERIAL_PRESENT_TO_ALL,  e -> System.out.println("Spiritual Gifts button pressed."));
        //fm_main.getToolbar().addMaterialCommandToSideMenu("  Ministries", FontImage.MATERIAL_TRENDING_UP,  e -> System.out.println("Ministries button pressed."));
        //fm_main.getToolbar().addMaterialCommandToSideMenu("  Resources", FontImage.MATERIAL_ACCESS_TIME,  e -> System.out.println("Resources button pressed."));
        //fm_main.getToolbar().addMaterialCommandToSideMenu("  World Church", FontImage.MATERIAL_SETTINGS,  e -> System.out.println("World Church button pressed."));
        //fm_main.getToolbar().addMaterialCommandToSideMenu("  Contact Us", FontImage.MATERIAL_EXIT_TO_APP,  e -> System.out.println("Contact Us button pressed."));
          
        
        btn_home = new Button("Home");
        btn_home.setUIID("SideCommand");
        FontImage.setMaterialIcon(btn_home, FontImage.MATERIAL_HOME);
        btn_home.setSelectedStyle(btn_home.getUnselectedStyle());
        btn_home.setPressedStyle(btn_home.getUnselectedStyle());
        btn_home.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                MainMenu nyumbani = new MainMenu();
                nyumbani.showMainMenu();
            }
        });
        
        
        btn_departments = new Button("  Departments");
        btn_departments.setUIID("SideCommand");
        FontImage.setMaterialIcon(btn_departments, FontImage.MATERIAL_APPS);
        btn_departments.setSelectedStyle(btn_home.getUnselectedStyle());
        btn_departments.setPressedStyle(btn_home.getUnselectedStyle());
        btn_departments.addActionListener(new ActionListener() 
        {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
              System.out.println("Departments Button Pressed.");
              
              System.out.println("Checking login status.");
                if(Storage.getInstance().exists("loginstatus") == true)
                {
                    System.out.println("User has a login status.");
                    
                    str_Login_Status = (String) Connect.storage.readObject("loginstatus");
                    if("OKL".equals(str_Login_Status))
                    {   
                        System.out.println("User's login status is OKL.");
                        
                        if(Storage.getInstance().exists("departments.json") == true)
                        {
                            //Storage.getInstance().writeObject("screen", "departments");
                            //DepartmentsMenu deparmentor = new DepartmentsMenu();
                            //deparmentor.showMainForm();
                        }
                        else
                        {
                            System.out.println("Downloading department details from server.");
                            
                                Storage.getInstance().writeObject("parameter1", "departments");
                                Connect conn = new Connect();
                                try 
                                {
                                    conn.process();
                                } 
                                catch (Exception e) 
                                {
                                }
                        }
                    }
                    else
                    {
                        System.out.println("User's login status isn't OKL.");
                        
                        storage.writeObject("screen", "departments");
                        showLoginDialog();
                    }
                }
                else
                {
                    System.out.println("User has no login status.");
                    
                    storage.writeObject("screen", "departments");
                    showLoginDialog();
                }
          }
        });
        
        btn_spiritualGifts = new Button("  Spiritual Gifts");
        btn_spiritualGifts.setUIID("SideCommand");
        FontImage.setMaterialIcon(btn_spiritualGifts, FontImage.MATERIAL_PRESENT_TO_ALL);
        btn_spiritualGifts.setSelectedStyle(btn_home.getUnselectedStyle());
        btn_spiritualGifts.setPressedStyle(btn_home.getUnselectedStyle());
        
        btn_ministries = new Button("  Ministries");
        btn_ministries.setUIID("SideCommand");
        FontImage.setMaterialIcon(btn_ministries, FontImage.MATERIAL_TRENDING_UP);
        btn_ministries.setSelectedStyle(btn_home.getUnselectedStyle());
        btn_ministries.setPressedStyle(btn_home.getUnselectedStyle());
        
        btn_resourses = new Button("  Resourses");
        btn_resourses.setUIID("SideCommand");
        FontImage.setMaterialIcon(btn_resourses, FontImage.MATERIAL_ACCESS_TIME);
        btn_resourses.setSelectedStyle(btn_home.getUnselectedStyle());
        btn_resourses.setPressedStyle(btn_home.getUnselectedStyle());
        
        
        btn_worldchurch = new Button("  World Church");
        btn_worldchurch.setUIID("SideCommand");
        FontImage.setMaterialIcon(btn_worldchurch, FontImage.MATERIAL_SETTINGS);
        btn_worldchurch.setSelectedStyle(btn_home.getUnselectedStyle());
        btn_worldchurch.setPressedStyle(btn_home.getUnselectedStyle());
        btn_worldchurch.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //MissionMenu mishoni = new MissionMenu();
                //mishoni.showMainForm();
            }
        });
        
        btn_contactus = new Button("  Contact Us");
        btn_contactus.setUIID("SideCommand");
        FontImage.setMaterialIcon(btn_contactus, FontImage.MATERIAL_EXIT_TO_APP);
        btn_contactus.setSelectedStyle(btn_home.getUnselectedStyle());
        btn_contactus.setPressedStyle(btn_home.getUnselectedStyle());
        
        fm_main.getToolbar().addComponentToSideMenu(cnt_sidemenuTop);
        //fm_main.getToolbar().addComponentToSideMenu(btn_home);
        fm_main.getToolbar().addComponentToSideMenu(btn_departments);
        fm_main.getToolbar().addComponentToSideMenu(btn_spiritualGifts);
        fm_main.getToolbar().addComponentToSideMenu(btn_ministries);
        fm_main.getToolbar().addComponentToSideMenu(btn_resourses);
        fm_main.getToolbar().addComponentToSideMenu(btn_worldchurch);
        fm_main.getToolbar().addComponentToSideMenu(btn_contactus);
        
        
        
        
        //        Command c = new Command("ABOUT KARENGATA");
//        Label l = new Label("ABOUT KARENGATA") 
//        {
//            public void paint(Graphics g) 
//            {
//                super.paint(g);
//                g.drawLine(getX(), getY() + getHeight() - 1, getX() + getWidth(), getY() + getHeight() - 1);
//            }
//        };
//        l.setUIID("Separator");
//        c.putClientProperty("SideComponent", l);
//        //main.addCommand(c);
//        tb.addCommandToSideMenu(c);
        /*fm_home.getToolbar().addCommandToLeftBar(null, ifont_burger, new ActionListener() 
        {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
              System.out.println("sidebar button pressed");
              SideMenuBar smenu = new SideMenuBar();
              smenu.add(new Label("Item One"));
              smenu.openMenu(null);
              //smenu.showMenu();
              //getToolbar().getMenuBar().openMenu(null);
              
              //fm_home.getToolbar().getMenuBar().showMenu();
              //fm_home.getMenuBar().showMenu();
          }
        });*/
        //tb.setTitleComponent(FlowLayout.encloseIn(btn_menu));
        //getToolbar().addComponentToSideMenu(sidemenuTop);
        
        
        fm_main.getToolbar().addCommandToLeftBar(null, ifont_burger, new ActionListener() 
        {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
              fm_main.getToolbar().openSideMenu();
          }
        });
        
        Button btn_profile = new Button("");
        btn_profile.setUIID("Title");
        FontImage.setMaterialIcon(btn_profile, FontImage.MATERIAL_PERSON);
        //btn_menu.addActionListener(e -> ((SideMenuBar)getToolbar().getMenuBar()).openMenu(null));
        fm_main.getToolbar().addCommandToRightBar(null, ifont_avatar, new ActionListener() 
        {
          @Override
            public void actionPerformed(ActionEvent ev) 
            {
                Dialog dlg_avatar = new Dialog(); //Select an Action
                    dlg_avatar.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                    
                    btn_close = new Button(theme.getImage("cancel.png")); //ifont_close
                    btn_close.setUIID("Label");
                    btn_close.addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            dlg_avatar.dispose();
                        }
                    });
                    
                    dlg_avatar.add(BorderLayout.east(btn_close));
                    
                    Button btn_logout = new Button("Logout");
                        btn_logout.setUIID("Label");
                        btn_logout.getStyle().setMarginLeft(10);
                        btn_logout.getStyle().setFgColor(0xff);
                        btn_logout.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                Storage.getInstance().deleteStorageFile("keepmeloggedin");
                                
                                LoginMenu loginer = new LoginMenu();
                                loginer.showLoginScreen();
                            }
                        });
                        
                    btn_login = new Button("Login");
                        btn_login.setUIID("Label");
                        btn_login.getStyle().setMarginLeft(10);
                        btn_login.getStyle().setFgColor(0xff);
                        btn_login.addActionListener(new ActionListener() 
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
                                    storage.writeObject("screen", "home");
                                    LoginMenu loginer = new LoginMenu();
                                    loginer.showLoginScreen();
                                 }
                                }
                                else
                                {
                                    storage.writeObject("screen", "home");
                                    LoginMenu loginer = new LoginMenu();
                                    loginer.showLoginScreen();
                                }
                            }
                        });

                    Button btn_profile = new Button("Edit Profile");
                        btn_profile.setUIID("Label");
                        btn_profile.getStyle().setMarginLeft(10);
                        btn_profile.getStyle().setFgColor(0xff);
                        btn_profile.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                               System.out.println("Edit Profile Link Pressed");
                               dlg_avatar.dispose();
                               //Display.getInstance().lockOrientation(false);
                               
                               System.out.println("Checking login status.");
                               if(Storage.getInstance().exists("loginstatus") == true)
                               {
                                   str_Login_Status = (String) Storage.getInstance().readObject("loginstatus");
                                   if("OKL".equals(str_Login_Status))
                                   {
                                            System.out.println("Checking dialog open status.");
                                            //check if show state exists in storage, If show state exists, read show state from storage
                                            if(Storage.getInstance().exists("isprofileDialog_open") == true)
                                            {
                                             String isprofileDialog_open = (String) Storage.getInstance().readObject("isprofileDialog_open");
                                             //If show state is show, hide tasks, write show state in storage
                                                if("YES".equals(isprofileDialog_open))
                                                {
                                                    Storage.getInstance().writeObject("isprofileDialog_open", "NO");   
                                                }
                                              //if show state is hide, show tasks, //write show state in storage
                                                else
                                                {
                                                 Storage.getInstance().writeObject("isprofileDialog_open", "YES");
                                                 //new MainMenu().showProfileDlg();
                                                }
                                            }
                                            else
                                            {
                                                Storage.getInstance().writeObject("isprofileDialog_open", "YES");
                                                //new MainMenu().showProfileDlg();
                                            }
                                   }
                                   else
                                   {
                                       showLoginDialog();
                                   }
                               }
                               else
                               {
                                   showLoginDialog();
                               }
                            }
                        });

                    Button btn_accounts = new Button("View Statements");
                        btn_accounts.setUIID("Label");
                        btn_accounts.getStyle().setMarginLeft(10);
                        btn_accounts.getStyle().setFgColor(0xff);
                        btn_accounts.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                //System.out.print("Showing username login pop dialog");
                                //showLoginDialog2();

                                
                               System.out.println("Checking login status.");
                               if(Storage.getInstance().exists("loginstatus") == true)
                               {
                                   str_Login_Status = (String) Connect.storage.readObject("loginstatus");
                                   if("OKL".equals(str_Login_Status))
                                   {
                                        //System.out.print("Closing the avatar popup dialog.");
                                        //dlg_avatar.dispose();
                                       
                                        System.out.print("Going to fetch collection details from server.");
                                        Storage.getInstance().writeObject("parameter1", "collections");
                                        Storage.getInstance().writeObject("parameter4", Storage.getInstance().readObject("userid"));
                                        Storage.getInstance().writeObject("parameter5",Storage.getInstance().readObject("role"));
                                        Storage.getInstance().writeObject("parameter6", Storage.getInstance().readObject("level")); 
                                        Storage.getInstance().writeObject("parameter7", "0"); //limit
                                        Storage.getInstance().writeObject("parameter8", "0"); //offset
                                        
                                        Connect conn = new Connect();
                                        try 
                                        {
                                            conn.process();
                                        } 
                                        catch (Exception e) 
                                        {
                                            e.printStackTrace();
                                        }
                                   }
                                   else
                                   {
                                       Storage.getInstance().writeObject("screen", "accounts");
                                       showLoginDialog();
                                   }
                               }
                               else
                               {
                                   Storage.getInstance().writeObject("screen", "accounts");
                                   showLoginDialog();
                               }
                                
                            }
                        });
                        
                    Button btn_sendMoney = new Button("Send Money");
                        btn_sendMoney.setUIID("Label");
                        btn_sendMoney.getStyle().setMarginLeft(10);
                        btn_sendMoney.getStyle().setFgColor(0xff);
                        btn_sendMoney.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                dlg_avatar.dispose();
                                
                                //new HomeMenu().showPayDialog1();
                                MainMenu nyomba = new MainMenu();
                                nyomba.showMainMenu();
                            }
                        });

                    Button btn_exit = new Button("Exit");
                        btn_exit.setUIID("Label");
                        btn_exit.getStyle().setMarginLeft(10);
                        btn_exit.getStyle().setFgColor(0xff);
                        btn_exit.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                Display.getInstance().exitApplication();
                            }
                        });

                    if(storage.exists("loginstatus") == true)
                    {
                        str_Login_Status = (String) Connect.storage.readObject("loginstatus");
                        if("OKL".equals(str_Login_Status))
                        {
                            if(storage.exists("keepmeloggedin"))
                            {
                                if(storage.readObject("keepmeloggedin") == "yes")
                                {
                                    dlg_avatar.add(btn_logout);
                                }
                            }
                        }
                    }

                    if(storage.exists("loginstatus") == true)
                    {
                        str_Login_Status = (String) Connect.storage.readObject("loginstatus");
                        if("OKL".equals(str_Login_Status))
                        {
                            dlg_avatar.removeAll();
                            dlg_avatar.add(btn_logout);
                            dlg_avatar.add(btn_profile);
                            dlg_avatar.add(btn_accounts);
                            dlg_avatar.add(btn_sendMoney);
                        }
                        else
                        {
                            dlg_avatar.add(btn_login);
                        }
                    }
                    else
                    {
                        dlg_avatar.add(btn_login);
                    }
                    dlg_avatar.add(btn_exit);
                    dlg_avatar.setDisposeWhenPointerOutOfBounds(true);
                    dlg_avatar.showDialog();
                    //dlg_avatar.showPopupDialog(tb.findCommandComponent(cmd_tbRight)); //cmd_tbRight
                    //dlg_avatar.showPacked(BorderLayout.EAST, false);
            }  
        });
        
        
 
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
            
            TableLayout laytab = new TableLayout(1, 4);
                        
            cnt_tablehead = new Container();
            cnt_tablehead.setScrollableY(false);
            cnt_tablehead.getAllStyles().setPadding((int)(5.0 * pixelsPerMM), 0, (int)(2.0 * pixelsPerMM), (int)(2.0 * pixelsPerMM));
            cnt_tablehead.setLayout(laytab);    
            
            lbl_id_column = new Label("#");
            lbl_id_column.getAllStyles().setMargin(0, 0, 0, 0);
            lbl_id_column.getAllStyles().setPadding(0, 0, 0, 0);
            lbl_id_column.setTextPosition(Component.TOP);
            lbl_id_column.getAllStyles().setAlignment(CENTER);
            lbl_id_column.getAllStyles().setFgColor(0xffffff, false);
            
            lbl_code_column = new Label("Code");
            lbl_code_column.getAllStyles().setMargin(0, 0, 0, 0);
            lbl_code_column.getAllStyles().setPadding(0, 0, 0, 0);
            lbl_code_column.setTextPosition(Component.TOP);
            lbl_code_column.getAllStyles().setAlignment(CENTER);
            lbl_code_column.getAllStyles().setFgColor(0xffffff, false);
            
            lbl_date_column = new Label("Date");
            lbl_date_column.getAllStyles().setMargin(0, 0, 0, 0);
            lbl_date_column.getAllStyles().setPadding(0, 0, 0, 0);
            lbl_date_column.setTextPosition(Component.TOP);
            lbl_date_column.getAllStyles().setAlignment(CENTER);
            lbl_date_column.getAllStyles().setFgColor(0xffffff, false);
            
            lbl_method_column = new Label("Method");
            lbl_method_column.getAllStyles().setMargin(0, 0, 0, 0);
            lbl_method_column.getAllStyles().setPadding(0, 0, 0, 0);
            lbl_method_column.setTextPosition(Component.TOP);
            lbl_method_column.getAllStyles().setAlignment(CENTER);
            lbl_method_column.getAllStyles().setFgColor(0xffffff, false);
            
            lbl_amount_column = new Label("Amount");
            lbl_amount_column.getAllStyles().setMargin(0, 0, 0, 0);
            lbl_amount_column.getAllStyles().setPadding(0, 0, 0, 0);
            lbl_amount_column.setTextPosition(Component.TOP);
            lbl_amount_column.getAllStyles().setAlignment(CENTER);
            lbl_amount_column.getAllStyles().setFgColor(0xffffff, false);
            
            lbl_actions_column = new Label("Actions");
            lbl_actions_column.getAllStyles().setMargin(0, 0, 0, 0);
            lbl_actions_column.getAllStyles().setPadding(0, 0, 0, 0);
            lbl_actions_column.setTextPosition(Component.TOP);
            lbl_actions_column.getAllStyles().setAlignment(CENTER);
            lbl_actions_column.getAllStyles().setFgColor(0xffffff, false);
            
            //TODO: show more if device is tab, desktop or in landscape mode
            //cnt_tablehead.add(laytab.createConstraint().widthPercentage(10), lbl_id_column);
            cnt_tablehead.add(laytab.createConstraint().widthPercentage(30), lbl_date_column);
            cnt_tablehead.add(laytab.createConstraint().widthPercentage(20), lbl_method_column);
            cnt_tablehead.add(laytab.createConstraint().widthPercentage(20), lbl_amount_column);
            cnt_tablehead.add(laytab.createConstraint().widthPercentage(30), lbl_actions_column);
            
            
            cnt_tablebody = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            cnt_tablebody.getAllStyles().setPadding(0, (int)(5.0 * pixelsPerMM), (int)(2.0 * pixelsPerMM), (int)(2.0 * pixelsPerMM));
            cnt_tablebody.setScrollableY(false);
            
            
                FileSystemStorage inst = FileSystemStorage.getInstance();
                final String homePath = inst.getAppHomePath();
                final char sep = inst.getFileSystemSeparator();
                try 
                {
                    InputStream is = inst.openInputStream(homePath+sep+"statements.txt");
                    byte[] b = Util.readInputStream(is);
                    str_content = new String(b);
                    
                    System.out.println("Content..: "+str_content);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
                
            
                String str_json_read = str_content;//(String) Storage.getInstance().readObject("login.json");
                byte[] dataa = str_json_read.getBytes();

                JSONParser json = new JSONParser();
                try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                {
                    Map<String, Object> map_content = json.parseJSON(is_content); //System.out.println("login.json map_content: "+map_content);
                    java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root"); //System.out.println("login.json obj_content: "+obj_content.get(0));

                    i=0;
                    for(Map<String, Object> obj : obj_content) 
                    {   
                        //k = k+1;
                        
                        //if(str_users_title == null || str_users_title.length() == 0){}else{}
                        //Storage.getInstance().writeObject("trxid", (String)obj.get("id"));
                        /*String str_id = (String)obj.get("id");
                        String str_user_id = (String)obj.get("user_id");
                        String str_code = (String)obj.get("code");
                        String str_type = (String)obj.get("type");                      //funds
                        String str_method = (String)obj.get("method");
                        String str_currency = (String)obj.get("currency");
                        String str_description = (String)obj.get("description");
                        String str_quantity = (String)obj.get("quantity");
                        String str_cost = (String)obj.get("cost");
                        String str_vat = (String)obj.get("vat");
                        String str_total_cost = (String)obj.get("total_cost");
                        String str_discount = (String)obj.get("discount");
                        String str_grand_total = (String)obj.get("grand_total");
                        String str_paid = (String)obj.get("paid");
                        String str_due = (String)obj.get("due");
                        String str_refund = (String)obj.get("refund");
                        String str_account_no = (String)obj.get("account_no");
                        String str_category_id = (String)obj.get("category_id");
                        String str_product_id = (String)obj.get("product_id");
                        String str_item_id = (String)obj.get("item_id");
                        String str_agent_id = (String)obj.get("agent_id ");
                        String str_added_by = (String)obj.get("added_by");
                        String str_added_on = (String)obj.get("added_on");
                        String str_updatedon = (String)obj.get("updatedon");
                        String str_updatedby = (String)obj.get("updatedby");
                        String str_approvedby = (String)obj.get("approvedby");
                        String str_approvedon = (String)obj.get("approvedon");
                        String str_action_on = (String)obj.get("action_on");
                        String str_action_by = (String)obj.get("action_by");
                        String str_status = (String)obj.get("status");*/
                        
                        String str_id = (String)obj.get("id");
                        String str_member_no = (String)obj.get("member_no");
                        String str_sent_status = (String)obj.get("sent_status");
                        String str_Year = (String)obj.get("Year");
                        String str_Month_ = (String)obj.get("Month_");
                        String str_Quarter_ = (String)obj.get("Quarter_");
                        String str_date_collected = (String)obj.get("date_collected");
                        str_pay_mode = (String)obj.get("pay_mode");
                        if(str_pay_mode != "CASH" || str_pay_mode != "PDQ")
                        {
                            str_pay_mode = "MPESA";
                        }
                       
                        String str_cash_payment = (String)obj.get("cash_payment");
                        String str_cheque_payment = (String)obj.get("cheque_payment");
                        String str_PDQ = (String)obj.get("PDQ");
                        String str_Mpesa = (String)obj.get("Mpesa");
                        String str_Total_Given = (String)obj.get("Total_Given");
                        String str_Gods_Tithe = (String)obj.get("Gods_Tithe");
                        String str_Combined_Offering = (String)obj.get("Combined_Offering");
                        String str_Local_Budget = (String)obj.get("Local_Budget");
                        String str_Evangelism = (String)obj.get("Evangelism");
                        String str_General = (String)obj.get("General");
                        String str_Walls = (String)obj.get("Walls");
                        String str_Premix = (String)obj.get("Premix");
                        String str_Roof = (String)obj.get("Roof");
                        String str_Electricals = (String)obj.get("Electricals");
                        String str_Tiles = (String)obj.get("Tiles");
                        String str_Audio_Visual = (String)obj.get("Audio_Visual");
                        String str_Steel_Reinforcements = (String)obj.get("Steel_Reinforcements");
                        String str_Doors = (String)obj.get("Doors");
                        String str_Windows = (String)obj.get("Windows");
                        String str_ChurchBuilding = String.valueOf(Double.valueOf(str_General)+Double.valueOf(str_Walls)
                                +Double.valueOf(str_Premix)+Double.valueOf(str_Roof)+Double.valueOf(str_Electricals)+
                                Double.valueOf(str_Tiles)+Double.valueOf(str_Audio_Visual)+
                                Double.valueOf(str_Steel_Reinforcements)+Double.valueOf(str_Doors)+Double.valueOf(str_Windows));
                        String str_Guests = (String)obj.get("Guests");
                        String str_Camp_Offerings = (String)obj.get("Camp_Offerings");
                        String str_Camp_Expenses = (String)obj.get("Camp_Expenses");
                        String str_Welfare = (String)obj.get("Welfare");
                        String str_Women_Ministry = (String)obj.get("Women_Ministry");
                        String str_Insurance = (String)obj.get("Insurance");
                        String str_Torossei = (String)obj.get("Torossei");
                        String str_Quarterly_Lesson = (String)obj.get("Quarterly_Lesson");
                        String str_Pathfinder_Club = (String)obj.get("Pathfinder_Club");
                        String str_Adventures_Club = (String)obj.get("Adventures_Club");
                        String str_Youth = (String)obj.get("Youth");
                        String str_Name = (String)obj.get("Name");
                        String str_date_added = (String)obj.get("date_added");
                        String str_added_by = (String)obj.get("added_by");

                        lbl_icon = new Label[obj_content.size()];
                        splbl_desc = new SpanLabel[obj_content.size()];
                        lbl_score = new Label[obj_content.size()];
                        lbl_id = new Label[obj_content.size()];
                        lbl_date = new Label[obj_content.size()];
                        splbl_item = new SpanLabel[obj_content.size()];
                        lbl_amount = new Label[obj_content.size()];
                        lbl_user_id = new Label[obj_content.size()];
                        lbl_code = new Label[obj_content.size()];
                        lbl_type = new Label[obj_content.size()];
                        lbl_method = new Label[obj_content.size()];
                        lbl_currency = new Label[obj_content.size()];
                        lbl_description = new Label[obj_content.size()];
                        lbl_quantity = new Label[obj_content.size()];
                        lbl_cost = new Label[obj_content.size()];
                        lbl_vat = new Label[obj_content.size()];
                        lbl_total_cost = new Label[obj_content.size()];
                        lbl_discount = new Label[obj_content.size()];
                        lbl_grand_total = new Label[obj_content.size()];
                        lbl_paid = new Label[obj_content.size()];
                        lbl_due = new Label[obj_content.size()];
                        lbl_refund = new Label[obj_content.size()];
                        lbl_account_no = new Label[obj_content.size()];
                        lbl_category_id = new Label[obj_content.size()];
                        lbl_product_id = new Label[obj_content.size()];
                        lbl_item_id = new Label[obj_content.size()];
                        lbl_agent_id = new Label[obj_content.size()];
                        lbl_added_by = new Label[obj_content.size()];
                        lbl_added_on = new Label[obj_content.size()];
                        lbl_updatedon = new Label[obj_content.size()];
                        lbl_updatedby  = new Label[obj_content.size()];
                        lbl_approvedby = new Label[obj_content.size()];
                        lbl_approvedon = new Label[obj_content.size()];
                        lbl_action_on = new Label[obj_content.size()];
                        lbl_action_by = new Label[obj_content.size()];
                        lbl_status  = new Label[obj_content.size()];
                        
                        btn_view = new Button[obj_content.size()];
                        btn_edit = new Button[obj_content.size()];
                        btn_send = new Button[obj_content.size()];
                        btn_delete = new Button[obj_content.size()];

                        cnt_id = new Container[obj_content.size()];
                        cnt_user_id = new Container[obj_content.size()];
                        cnt_code = new Container[obj_content.size()];
                        cnt_type = new Container[obj_content.size()];
                        cnt_method = new Container[obj_content.size()];
                        cnt_currency = new Container[obj_content.size()];
                        cnt_description = new Container[obj_content.size()];
                        cnt_quantity = new Container[obj_content.size()];
                        cnt_cost = new Container[obj_content.size()];
                        cnt_vat = new Container[obj_content.size()];
                        cnt_total_cost = new Container[obj_content.size()];
                        cnt_discount = new Container[obj_content.size()];
                        cnt_grand_total = new Container[obj_content.size()];
                        cnt_paid = new Container[obj_content.size()];
                        cnt_due = new Container[obj_content.size()];
                        cnt_refund = new Container[obj_content.size()];
                        cnt_account_no = new Container[obj_content.size()];
                        cnt_category_id = new Container[obj_content.size()];
                        cnt_product_id = new Container[obj_content.size()];
                        cnt_item_id = new Container[obj_content.size()];
                        cnt_agent_id = new Container[obj_content.size()];
                        cnt_added_by = new Container[obj_content.size()];
                        cnt_added_on = new Container[obj_content.size()];
                        cnt_updatedon = new Container[obj_content.size()];
                        cnt_updatedby  = new Container[obj_content.size()];
                        cnt_approvedby = new Container[obj_content.size()];
                        cnt_approvedon = new Container[obj_content.size()];
                        cnt_action_on = new Container[obj_content.size()];
                        cnt_action_by = new Container[obj_content.size()];
                        cnt_status  = new Container[obj_content.size()];
                        cnt_actions = new Container[obj_content.size()];
                        
                        cnt_icon = new Container[obj_content.size()];
                        cnt_desc = new Container[obj_content.size()];
                        cnt_score = new Container[obj_content.size()];
                        cnt_no = new Container[obj_content.size()];
                        cnt_date = new Container[obj_content.size()];
                        cnt_item = new Container[obj_content.size()];
                        cnt_amount = new Container[obj_content.size()];
                        
                        System.out.println("Iteration = "+i);
                        
                        lbl_id[i] = new Label(String.valueOf((i+1)));
                        lbl_id[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_id[i].getAllStyles().setPadding(0,0,0,0);
                        lbl_id[i].setTextPosition(Component.TOP);

                        String str_date, str_dd, str_mm, str_yyyy;

                        str_date = StringUtil.tokenize(str_date_added, ' ').get(0); //str_added_on
                        str_dd = StringUtil.tokenize(str_date, '-').get(2);
                        str_mm = StringUtil.tokenize(str_date, '-').get(1);
                        str_yyyy = StringUtil.tokenize(str_date, '-').get(0);

                        lbl_date[i] = new Label(str_dd+"/"+str_mm+"/"+str_yyyy);
                        lbl_date[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_amount[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_date[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_date[i].getAllStyles().setPadding(0,0,0,0);
                        lbl_date[i].setTextPosition(Component.TOP);
                        lbl_date[i].getAllStyles().setAlignment(CENTER);

                        splbl_item[i] = new SpanLabel();
                        splbl_item[i].setFocusable(false);
                        splbl_item[i].setTextBlockAlign(LEFT);
                        splbl_item[i].getTextComponent().setSingleLineTextArea(true);

                        try 
                        {
                            str_jina = String.valueOf((String)obj.get("product_id")); //Storage.getInstance().readObject("product_"+str_product_id).toString(); //String.valueOf((String)obj.get("product_id")
                        } 
                        catch (Exception e) 
                        {
                            System.out.println("Error: "+e);
                            e.printStackTrace();
                        }

                        splbl_item[i].setText(str_jina); //str_item_id.trim()


                        splbl_item[i].getTextAllStyles().setAlignment(LEFT, false);
                        splbl_item[i].getTextAllStyles().setPadding(0, 0, 0, 0);
                        splbl_item[i].getTextAllStyles().setMargin(0, 0, 0, 0);
                        splbl_item[i].getAllStyles().setFgColor(0xa2a1b8, false);
                        splbl_item[i].getAllStyles().setFont(font_medium_plain, false);
                        splbl_item[i].getAllStyles().setMargin(0,0,0,0);
                        splbl_item[i].getAllStyles().setPadding(0,0,0,0);

                        //str_product_id

                        lbl_amount[i] = new Label();
                        lbl_amount[i].setText(str_Total_Given.trim());
                        lbl_amount[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_amount[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_amount[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_amount[i].getAllStyles().setPadding(0,0,0,0);
                        lbl_amount[i].setTextPosition(Component.TOP);
                        lbl_amount[i].getAllStyles().setAlignment(CENTER);

                        lbl_user_id[i] = new Label();
                        lbl_user_id[i].setText(str_member_no);
                        lbl_user_id[i].getAllStyles().setFgColor(0xffffff, false);
                        //lbl_amount[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_user_id[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_user_id[i].getAllStyles().setPadding(0,0,0,0);
                        lbl_user_id[i].setTextPosition(Component.TOP);
                        //lbl_user_id[i].getAllStyles().setFont(font_medium_plain, false);
                        //lbl_user_id[i].getAllStyles().setMargin(0,0,(int)(5.0 * pixelsPerMM),(int)(5.0 * pixelsPerMM));
                        //lbl_user_id[i].getAllStyles().setPadding(0,0,(int)(5.0 * pixelsPerMM),(int)(5.0 * pixelsPerMM));
                        
                        lbl_code[i] = new Label();
                        //lbl_code[i].setText(str_code);
                        lbl_code[i].setTextPosition(Component.TOP);
                        lbl_code[i].getAllStyles().setAlignment(CENTER);
                        lbl_code[i].getAllStyles().setMargin(0, 0, 0, 0);
                        lbl_code[i].getAllStyles().setPadding(0, 0, 0, 0);
                        lbl_code[i].getAllStyles().setFgColor(0x000000, false);
                        
                        lbl_type[i] = new Label();
                        //lbl_type[i].setText(str_type);
                        lbl_type[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_type[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_type[i].setTextPosition(Component.TOP);
                        lbl_type[i].getAllStyles().setAlignment(CENTER);
                        lbl_type[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_type[i].getAllStyles().setPadding(0,0,0,0);
                        
                        lbl_method[i] = new Label();
                        lbl_method[i].setText(str_pay_mode.trim()); //str_method
                        lbl_method[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_method[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_method[i].setTextPosition(Component.TOP);
                        lbl_method[i].getAllStyles().setAlignment(CENTER);
                        lbl_method[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_method[i].getAllStyles().setPadding(0,0,0,0);
                        
                        lbl_currency[i] = new Label();
                        //lbl_currency[i].setText(str_currency);
                        lbl_currency[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_currency[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_currency[i].setTextPosition(Component.TOP);
                        lbl_currency[i].getAllStyles().setAlignment(CENTER);
                        lbl_currency[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_currency[i].getAllStyles().setPadding(0,0,0,0);
                        
                        lbl_description[i] = new Label();
                        //lbl_description[i].setText(str_description);
                        lbl_description[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_description[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_description[i].setTextPosition(Component.TOP);
                        lbl_description[i].getAllStyles().setAlignment(CENTER);
                        lbl_description[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_description[i].getAllStyles().setPadding(0,0,0,0);
                        
                        lbl_quantity[i] = new Label();
                        //lbl_quantity[i].setText(str_quantity);
                        lbl_quantity[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_quantity[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_quantity[i].setTextPosition(Component.TOP);
                        lbl_quantity[i].getAllStyles().setAlignment(CENTER);
                        lbl_quantity[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_quantity[i].getAllStyles().setPadding(0,0,0,0);
                        
                        lbl_total_cost[i] = new Label();
                        //lbl_total_cost[i].setText(str_total_cost);
                        lbl_total_cost[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_total_cost[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_total_cost[i].setTextPosition(Component.TOP);
                        lbl_total_cost[i].getAllStyles().setAlignment(CENTER);
                        lbl_total_cost[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_total_cost[i].getAllStyles().setPadding(0,0,0,0);
                        
                        lbl_status[i] = new Label();
                        //lbl_status[i].setText(str_status);
                        lbl_status[i].getAllStyles().setFgColor(0x000000, false);
                        //lbl_status[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_status[i].setTextPosition(Component.TOP);
                        lbl_status[i].getAllStyles().setAlignment(CENTER);
                        lbl_status[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_status[i].getAllStyles().setPadding(0,0,0,0);
                        
                        
                        btn_view[i] = new Button();
                        btn_view[i].setIcon(theme.getImage("info.png"));
                        btn_view[i].getAllStyles().setFgColor(0xffffff, false);
                        btn_view[i].getAllStyles().setMargin(0, 0, 0, 0);
                        btn_view[i].getAllStyles().setPadding(0, 0, 0, 0);
                        btn_view[i].setTextPosition(Component.TOP);
                        btn_view[i].setBlockLead(true);
                        btn_view[i].setAutoRelease(false);
                        btn_view[i].addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                /*Log.p("Going to fetch collection details from server.", 1);
                                Storage.getInstance().writeObject("parameter1", "collections");
                                Storage.getInstance().writeObject("parameter4", Storage.getInstance().readObject("userid"));
                                Storage.getInstance().writeObject("parameter5",Storage.getInstance().readObject("role"));
                                Storage.getInstance().writeObject("parameter6", Storage.getInstance().readObject("level")); 
                                Storage.getInstance().writeObject("parameter7", "0"); //limit
                                Storage.getInstance().writeObject("parameter8", "0"); //offset

                                Connect conn = new Connect();
                                try 
                                {
                                    conn.process();
                                } 
                                catch (Exception e) 
                                {
                                    e.printStackTrace();
                                }*/
                                Log.p("Showing statement item popup.", 1);
                                Dialog dlg_payment = new Dialog();
                                dlg_payment.setLayout(new BorderLayout());
                                
                                btn_close = new Button(theme.getImage("cancel.png"));
                                btn_close.setUIID("Label");
                                btn_close.addActionListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        //storage.writeObject("screen", "dependants");
                                        dlg_payment.dispose();
                                    }
                                });

                                Container cnt_till = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                                cnt_till.getStyle().setAlignment(LEFT, false);
                                cnt_till.setScrollableY(true);
                                
                                Label lbl_DateCollected = new Label("Date Collected");
                                lbl_DateCollected.getAllStyles().setPaddingLeft((int)(2.0 * pixelsPerMM));
                                lbl_DateCollected.getAllStyles().setAlignment(LEFT, false);
                                lbl_DateCollected.getAllStyles().setFgColor(0x000000, false);
                                lbl_DateCollected.getAllStyles().setBgColor(0xffffff, false);
                                lbl_DateCollected.getAllStyles().setBgTransparency(0, false);
                                
                                Label lbl_PaymentMethos = new Label("Collection Method");
                                lbl_PaymentMethos.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                lbl_PaymentMethos.setSelectedStyle(lbl_DateCollected.getSelectedStyle());
                                lbl_PaymentMethos.setPressedStyle(lbl_DateCollected.getPressedStyle());
                                
                                Label lbl_TotalCollected = new Label("Total Collected");
                                lbl_TotalCollected.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_GodsTithe = new Label("God's Tithe");
                                lbl_GodsTithe.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_CombOffering = new Label("Comb. Offering");
                                lbl_CombOffering.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_LocalBudget = new Label("Local Budget");
                                lbl_LocalBudget.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Evangelism = new Label("Evangelism");
                                lbl_Evangelism.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_ChurchBuilding = new Label("Church Building");
                                lbl_ChurchBuilding.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_CampOfferings = new Label("Camp Offerings");
                                lbl_CampOfferings.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_CampExpenses = new Label("Camp Expenses");
                                lbl_CampExpenses.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Welfare = new Label("Welfare");
                                lbl_Welfare.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Women_Ministry = new Label("Women's Ministry");
                                lbl_Women_Ministry.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Insurance = new Label("Insurance");
                                lbl_Insurance.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Torossei = new Label("Torossei");
                                lbl_Torossei.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Quartely = new Label("Lesson Quarterly");
                                lbl_Quartely.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Pathfinder = new Label("Pathfinders");
                                lbl_Pathfinder.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Adventurer = new Label("Adventurers");
                                lbl_Adventurer.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_Youth = new Label("Youth Ministries");
                                lbl_Youth.setUnselectedStyle(lbl_DateCollected.getUnselectedStyle());
                                
                                Label lbl_DateCollected_value = new Label(str_date_collected); 
                                lbl_DateCollected_value.getAllStyles().setAlignment(LEFT, false);
                                lbl_DateCollected_value.getAllStyles().setFgColor(0x000000, false);
                                lbl_DateCollected_value.getAllStyles().setBgColor(0xffffff, false);
                                lbl_DateCollected_value.getAllStyles().setBgTransparency(0, false);
                                
                                Label lbl_PaymentMethos_value = new Label(str_pay_mode); 
                                lbl_PaymentMethos_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_TotalCollected_value = new Label(str_Total_Given); 
                                lbl_TotalCollected_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_GodsTithe_value = new Label(str_Gods_Tithe); 
                                lbl_GodsTithe_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_CombOffering_value = new Label(str_Combined_Offering);
                                lbl_CombOffering_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_LocalBudget_value = new Label(str_Local_Budget); lbl_LocalBudget_value.getAllStyles().setFgColor(0x000000);
                                lbl_LocalBudget_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Evangelism_value = new Label(str_Evangelism); lbl_Evangelism_value.getAllStyles().setFgColor(0x000000);
                                lbl_Evangelism_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_ChurchBuilding_value = new Label(str_ChurchBuilding); lbl_ChurchBuilding_value.getAllStyles().setFgColor(0x000000);
                                lbl_ChurchBuilding_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_CampOfferings_value = new Label(str_Camp_Offerings); lbl_CampOfferings_value.getAllStyles().setFgColor(0x000000);
                                lbl_CampOfferings_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_CampExpenses_value = new Label(str_Camp_Expenses); lbl_CampExpenses_value.getAllStyles().setFgColor(0x000000);
                                lbl_CampExpenses_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Welfare_value = new Label(str_Welfare); lbl_Welfare_value.getAllStyles().setFgColor(0x000000);
                                lbl_Welfare_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Women_Ministry_value = new Label(str_Women_Ministry); lbl_Women_Ministry_value.getAllStyles().setFgColor(0x000000);
                                lbl_Women_Ministry_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Insurance_value = new Label(str_Insurance); lbl_Insurance_value.getAllStyles().setFgColor(0x000000);
                                lbl_Insurance_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Torossei_value = new Label(str_Torossei); lbl_Torossei_value.getAllStyles().setFgColor(0x000000);
                                lbl_Torossei_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Quartely_value = new Label(str_Quarterly_Lesson); lbl_Quartely_value.getAllStyles().setFgColor(0x000000);
                                lbl_Quartely_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Pathfinder_value = new Label(str_Pathfinder_Club); lbl_Pathfinder_value.getAllStyles().setFgColor(0x000000);
                                lbl_Pathfinder_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Adventurer_value = new Label(str_Adventures_Club); lbl_Adventurer_value.getAllStyles().setFgColor(0x000000);
                                lbl_Adventurer_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                
                                Label lbl_Youth_value = new Label(str_Youth); lbl_Youth_value.getAllStyles().setFgColor(0x000000);
                                lbl_Youth_value.setUnselectedStyle(lbl_DateCollected_value.getUnselectedStyle());
                                                                
                                
                                
                                cnt_till.add(GridLayout.encloseIn(2, lbl_DateCollected, lbl_DateCollected_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_PaymentMethos, lbl_PaymentMethos_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_TotalCollected, lbl_TotalCollected_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_GodsTithe, lbl_GodsTithe_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_CombOffering, lbl_CombOffering_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_LocalBudget, lbl_LocalBudget_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Evangelism, lbl_Evangelism_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_ChurchBuilding, lbl_ChurchBuilding_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_CampOfferings, lbl_CampOfferings_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_CampExpenses, lbl_CampExpenses_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Welfare, lbl_Welfare_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Women_Ministry, lbl_Women_Ministry_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Insurance, lbl_Insurance_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Torossei, lbl_Torossei_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Quartely, lbl_Quartely_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Pathfinder, lbl_Pathfinder_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Adventurer, lbl_Adventurer_value));
                                cnt_till.add(GridLayout.encloseIn(2, lbl_Youth, lbl_Youth_value));
                                
                                Button btn_cancel = new Button("Commend");
                                btn_cancel.addActionListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        dlg_payment.dispose();
                                        //storage.writeObject("screen", "cancelorder");
                                        /*Connect connector = new Connect();
                                        try 
                                        {
                                            connector.cancelOrder();//we can only cancel an order not a cart... a cart is simply closed.
                                        } 
                                        catch (Exception ex) 
                                        {
                                            ex.printStackTrace();
                                        }*/
                                    }
                                });           

                                Button btn_confirm = new Button("Complain");
                                btn_confirm.addActionListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        dlg_payment.dispose();
                                    }
                                });

                                dlg_payment.add(BorderLayout.NORTH, LayeredLayout.encloseIn(new Label(theme.getImage("logo_sapia.png")), FlowLayout.encloseRight(btn_close)));
                                dlg_payment.add(BorderLayout.CENTER, cnt_till);
                                dlg_payment.add(BorderLayout.SOUTH, FlowLayout.encloseCenterMiddle(btn_cancel, btn_confirm));
                                
                                dlg_payment.isDisposeWhenPointerOutOfBounds();
                                dlg_payment.showPacked(BorderLayout.CENTER, true);
                            }
                            
                        });

                        btn_edit[i] = new Button();
                        btn_edit[i].setIcon(theme.getImage("edit.png"));
                        btn_edit[i].getAllStyles().setFgColor(0xffffff, false);
                        btn_edit[i].getAllStyles().setMargin(0, 0, 0, 0);
                        btn_edit[i].getAllStyles().setPadding(0, 0, 0, 0);
                        btn_edit[i].setTextPosition(Component.TOP);
                        btn_edit[i].setBlockLead(true);
                        btn_edit[i].setAutoRelease(false);
                        btn_edit[i].addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {

                            }
                        });

                        btn_send[i] = new Button();
                        btn_send[i].setIcon(theme.getImage("send.png"));
                        btn_send[i].getAllStyles().setFgColor(0xffffff, false);
                        btn_send[i].getAllStyles().setMargin(0, 0, 0, 0);
                        btn_send[i].getAllStyles().setPadding(0, 0, 0, 0);
                        btn_send[i].setTextPosition(Component.TOP);
                        btn_send[i].setBlockLead(true);
                        btn_send[i].setAutoRelease(false);
                        btn_send[i].addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                //Log.p("Transfer button pressed for item " + k + ". " + (String) obj_mysaccos.get("sacco_name"), 1);
                            }
                        });
                        
                        btn_delete[i] = new Button();
                        //btn_delete[i].setIcon(theme.getImage("delete.png"));
                        btn_delete[i].getAllStyles().setFgColor(0xffffff, false);
                        btn_delete[i].getAllStyles().setMargin(0, 0, 0, 0);
                        btn_delete[i].getAllStyles().setPadding(0, 0, 0, 0);
                        btn_delete[i].setTextPosition(Component.TOP);
                        btn_delete[i].setBlockLead(true);
                        btn_delete[i].setAutoRelease(false);
                        btn_delete[i].addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                //Log.p("Transfer button pressed for item " + k + ". " + (String) obj_mysaccos.get("sacco_name"), 1);
                            }
                        });
                        
                        
                        
                        
                        cnt_no[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_no[i].setWidth(20);
                        cnt_no[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_no[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_no[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                        cnt_date[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_date[i].setWidth(20);
                        cnt_date[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_date[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_date[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                        cnt_item[i] = new Container(new FlowLayout(LEFT, CENTER));
                        cnt_item[i].setWidth(350);
                        cnt_item[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_item[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_item[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                        cnt_amount[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_amount[i].setWidth(50);
                        cnt_amount[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_amount[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_amount[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                        
                        cnt_id[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_id[i].setWidth(50);
                        cnt_id[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_id[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_id[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_user_id[i] = new Container(new FlowLayout(CENTER, CENTER));
                        //cnt_user_id[i].setWidth(50);
                        cnt_user_id[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_user_id[i].getAllStyles().setPadding(0,0,0,0);
                        //cnt_user_id[i].getAllStyles().setPadding(0,0,(int)(5.0 * pixelsPerMM),(int)(5.0 * pixelsPerMM));
                        cnt_user_id[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_code[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_code[i].setWidth(50);
                        cnt_code[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_code[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_code[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_type[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_type[i].setWidth(50);
                        cnt_type[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_type[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_type[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_method[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_method[i].setWidth(50);
                        cnt_method[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_method[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_method[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_currency[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_currency[i].setWidth(50);
                        cnt_currency[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_currency[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_currency[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_description[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_description[i].setWidth(50);
                        cnt_description[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_description[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_description[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_quantity[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_quantity[i].setWidth(50);
                        cnt_quantity[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_quantity[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_quantity[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_total_cost[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_total_cost[i].setWidth(50);
                        cnt_total_cost[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_total_cost[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_total_cost[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_status[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_status[i].setWidth(50);
                        cnt_status[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_status[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_status[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                        
                        cnt_actions[i] = new Container(new FlowLayout(CENTER, CENTER)); //new GridLayout(1, 4)
                        cnt_actions[i].setLeadComponent(null);
                        cnt_actions[i].setWidth(50);
                        cnt_actions[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_actions[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_actions[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                                                
                        
                            //cnt_id[i].add(lbl_id[i]);
                            //cnt_user_id[i].add(lbl_user_id[i]);
                            //cnt_code[i].add(lbl_code[i]);
                            //cnt_type[i].add(lbl_type[i]);
                            //cnt_method[i].add(lbl_method[i]);
                            //cnt_currency[i].add(lbl_currency[i]);
                            //cnt_description[i].add(lbl_description[i]);
                            //cnt_quantity[i].add(lbl_quantity[i]);
                            //cnt_cost[i].add(lbl_cost[i]);
                            //cnt_vat[i].add(lbl_vat[i]);
                            //cnt_total_cost[i].add(lbl_total_cost[i]);
                            //cnt_discount[i].add(lbl_discount[i]);
                            //cnt_grand_total[i].add(lbl_grand_total[i]);
                            //cnt_paid[i].add(lbl_paid[i]);
                            //cnt_due[i].add(lbl_due[i]);
                            //cnt_refund[i].add(lbl_refund[i]);
                            //cnt_account_no[i].add(lbl_account_no[i]);
                            //cnt_category_id[i].add(lbl_category_id[i]);
                            //cnt_product_id[i].add(lbl_product_id[i]);
                            //cnt_item_id[i].add(lbl_item_id[i]);
                            //cnt_agent_id[i].add(lbl_agent_id[i]);
                            //cnt_added_by[i].add(lbl_added_by[i]);
                            //cnt_added_on[i].add(lbl_added_on[i]);
                            //cnt_updatedon[i].add(lbl_updatedon[i]);
                            //cnt_updatedby [i].add(lbl_updatedby[i]);
                            //cnt_approvedby[i].add(lbl_approvedby[i]);
                            //cnt_approvedon[i].add(lbl_approvedon[i]);
                            //cnt_action_on[i].add(lbl_action_on[i]);
                            //cnt_action_by[i].add(lbl_action_by[i]);
                            //cnt_status [i].add(lbl_status[i]);
                            

                        cnt_tablerow = new Container[obj_content.size()];

                        GridLayout laygrid = new GridLayout(10); //10 columns //obj_content.size() = no of rows 
                        laygrid.setAutoFit(false);

                        TableLayout laytab_tablebody = new TableLayout(obj_content.size(), 4);

                        lbl_icon[i] = new Label();
                        /*lbl_icon[i] = new Label();
                        if(item_module.equals("scorm"))
                        {
                            lbl_icon[i].setIcon(theme.getImage("sanduku.png"));
                        }
                        else
                        {
                            lbl_icon[i].setIcon(theme.getImage("karatasi.png"));
                        }*/
                        lbl_icon[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_icon[i].getAllStyles().setPadding(0,0,0,0);
                        lbl_icon[i].setTextPosition(Component.TOP);

                        //str_unit_name = Stor
                        splbl_desc[i] = new SpanLabel();
                        splbl_desc[i].setText(str_id.trim());
                        splbl_desc[i].getTextAllStyles().setAlignment(LEFT, false);
                        //splbl_desc[i].setIconPosition(BorderLayout.WEST);
                        splbl_desc[i].setFocusable(true);
                        splbl_desc[i].getAllStyles().setFgColor(0xa2a1b8, false);
                        splbl_desc[i].getAllStyles().setFont(font_medium_plain, false);
                        splbl_desc[i].getAllStyles().setMargin(0,0,0,0);
                        splbl_desc[i].getAllStyles().setPadding(0,0,0,0);



                        lbl_score[i] = new Label();
                        //lbl_score[i].setText(str_user_id);
                        lbl_score[i].getAllStyles().setFgColor(0x000000, false);
                        lbl_score[i].getAllStyles().setFont(font_medium_plain, false);
                        lbl_score[i].getAllStyles().setMargin(0,0,0,0);
                        lbl_score[i].getAllStyles().setPadding(0,0,0,0);
                        //lbl_score[i].setIcon(theme.getImage("spacer.png"));
                        //lbl_score[i].setTextPosition(Component.TOP);



                        cnt_icon[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_icon[i].setWidth(20);
                        cnt_icon[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_icon[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_icon[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                        cnt_desc[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_desc[i].setWidth(350);
                        cnt_desc[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_desc[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_desc[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                        cnt_score[i] = new Container(new FlowLayout(CENTER, CENTER));
                        cnt_score[i].setWidth(50);
                        cnt_score[i].getAllStyles().setMargin(0,0,0,0);
                        cnt_score[i].getAllStyles().setPadding(0,0,(int)(1.0 * pixelsPerMM),(int)(1.0 * pixelsPerMM));
                        cnt_score[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                        cnt_icon[i].add(lbl_icon[i]);
                        cnt_desc[i].add(splbl_desc[i]);
                        cnt_score[i].add(lbl_score[i]);
                        
                        cnt_code[i].add(lbl_code[i]);
                        cnt_date[i].add(lbl_date[i]);
                        cnt_method[i].add(lbl_method[i]);
                        cnt_amount[i].add(lbl_amount[i]);
                        cnt_actions[i].add(btn_view[i]);
                        //cnt_actions[i].add(btn_edit[i]);
                        cnt_actions[i].add(btn_send[i]);
                        //cnt_actions[i].add(btn_delete[i]);

                        //cnt_coursebody.add(BoxLayout.encloseX(cnt_icon[i],  cnt_desc[i], cnt_score[i]));
                        //cnt_tablebody.add(GridLayout.encloseIn(3, cnt_icon[i],  cnt_desc[i], cnt_score[i]));

                        cnt_tablerow[i] = new Container();
                        cnt_tablerow[i].setLeadComponent(null);
                        cnt_tablerow[i].setScrollableY(false);
                        cnt_tablerow[i].getAllStyles().setPadding(0, 0, 0, 0);
                        cnt_tablerow[i].setLayout(laytab_tablebody);
                        
                        //cnt_tablerow[i].add(cnt_icon[i]);
                        //cnt_tablerow[i].add(cnt_desc[i]); //laytab.createConstraint().widthPercentage(70), cnt_desc[i]
                        //cnt_tablerow[i].add(cnt_score[i]);                       
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(2), cnt_id[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_user_id[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_code[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_type[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_method[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_currency[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_description[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_quantity[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_total_cost[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_status[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_actions[i]);
                        //cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(10), cnt_code[i]);
                        cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(30), cnt_date[i]);
                        cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(20), cnt_method[i]);
                        cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(20), cnt_amount[i]);
                        cnt_tablerow[i].add(laytab_tablebody.createConstraint().widthPercentage(30), cnt_actions[i]);
                                                
                        
                        cnt_tablebody.add(cnt_tablerow[i]);
                        
                        i++;
                    }
                }
                catch(Exception err) 
                {
                    System.out.println("Error: "+err);
                    err.printStackTrace();
                }
                
                //$startpoint = ($page * $limit) - $limit;
        

                Button btn_page1 = new Button(" 1 ");
                btn_page1.getAllStyles().setBorder(null);
                btn_page1.getAllStyles().setBgImage(img_blueish_btn);
                btn_page1.getAllStyles().setBgColor(0x000000, false);
                btn_page1.getAllStyles().setBgTransparency(0, false);
                btn_page1.getAllStyles().setFgColor(0xffffff, false);
                btn_page1.getAllStyles().setFont(Font.createTrueTypeFont("Arial Narrow Bold", "Arial Narrow Bold.ttf").derive((int)(4.0 * pixelsPerMM), Font.STYLE_PLAIN), false);
                btn_page1.addActionListener(new ActionListener() 
                {
                   @Override
                   public void actionPerformed(ActionEvent evt) 
                   {
                        Log.p("Offset page number "+btn_page1.getText().trim()+" selected.", 1);
                        
                        System.out.print("Writing server params to storage.");
                        Storage.getInstance().writeObject("parameter1", "collections");
                        Storage.getInstance().writeObject("parameter4", Storage.getInstance().readObject("userid"));
                        Storage.getInstance().writeObject("parameter5", Storage.getInstance().readObject("role"));
                        Storage.getInstance().writeObject("parameter6", Storage.getInstance().readObject("level")); 
                        Storage.getInstance().writeObject("parameter7", "3"); //limit
                        Storage.getInstance().writeObject("parameter8", btn_page1.getText().trim()); //offset
                        
                        System.out.print("Going to fetch collection details from server.");
                        Connect conn = new Connect();
                        try 
                        {
                            conn.process();
                        } 
                        catch (Exception e) 
                        {
                            e.printStackTrace();
                        }
                   }
                });
                
                Button btn_page2 = new Button(" 2 ");
                btn_page2.getAllStyles().setBorder(null);
                btn_page2.getAllStyles().setBgImage(img_blueish_btn);
                btn_page2.getAllStyles().setBgColor(0x000000, false);
                btn_page2.getAllStyles().setBgTransparency(0, false);
                btn_page2.getAllStyles().setFgColor(0xffffff, false);
                btn_page2.getAllStyles().setFont(Font.createTrueTypeFont("Arial Narrow Bold", "Arial Narrow Bold.ttf").derive((int)(4.0 * pixelsPerMM), Font.STYLE_PLAIN), false);
                btn_page2.addActionListener(new ActionListener() 
                {
                   @Override
                   public void actionPerformed(ActionEvent evt) 
                   {
                        Log.p("Offset page number "+btn_page2.getText().trim()+" selected.", 1);
                       
                        System.out.print("Writing server params to storage.");
                        Storage.getInstance().writeObject("parameter1", "collections");
                        Storage.getInstance().writeObject("parameter4", Storage.getInstance().readObject("userid"));
                        Storage.getInstance().writeObject("parameter5", Storage.getInstance().readObject("role"));
                        Storage.getInstance().writeObject("parameter6", Storage.getInstance().readObject("level")); 
                        Storage.getInstance().writeObject("parameter7", "2"); //limit
                        Storage.getInstance().writeObject("parameter8", btn_page2.getText().trim()); //offset
                        
                        System.out.print("Going to fetch collection details from server.");
                        Connect conn = new Connect();
                        try 
                        {
                            conn.process();
                        } 
                        catch (Exception e) 
                        {
                            e.printStackTrace();
                        }
                   }
                });
                
                Button btn_page3 = new Button(" 3 ");
                btn_page3.getAllStyles().setBorder(null);
                btn_page3.getAllStyles().setBgImage(img_blueish_btn);
                btn_page3.getAllStyles().setBgColor(0x000000, false);
                btn_page3.getAllStyles().setBgTransparency(0, false);
                btn_page3.getAllStyles().setFgColor(0xffffff, false);
                btn_page3.getAllStyles().setFont(Font.createTrueTypeFont("Arial Narrow Bold", "Arial Narrow Bold.ttf").derive((int)(4.0 * pixelsPerMM), Font.STYLE_PLAIN), false);
                btn_page3.addActionListener(new ActionListener() 
                {
                   @Override
                   public void actionPerformed(ActionEvent evt) 
                   {
                        Log.p("Offset page number "+btn_page3.getText().trim()+" selected.", 1);
                       
                        System.out.print("Writing server params to storage.");
                        Storage.getInstance().writeObject("parameter1", "collections");
                        Storage.getInstance().writeObject("parameter4", Storage.getInstance().readObject("userid"));
                        Storage.getInstance().writeObject("parameter5", Storage.getInstance().readObject("role"));
                        Storage.getInstance().writeObject("parameter6", Storage.getInstance().readObject("level")); 
                        Storage.getInstance().writeObject("parameter7", "2"); //limit
                        Storage.getInstance().writeObject("parameter8", "4"); //offset
                        
                        System.out.print("Going to fetch collection details from server.");
                        Connect conn = new Connect();
                        try 
                        {
                            conn.process();
                        } 
                        catch (Exception e) 
                        {
                            e.printStackTrace();
                        }
                   }
                });
                
                Button btn_next = new Button(" Next ");
                btn_next.getAllStyles().setBorder(null);
                btn_next.getAllStyles().setBgImage(img_blueish_btn);
                btn_next.getAllStyles().setBgColor(0x000000, false);
                btn_next.getAllStyles().setBgTransparency(0, false);
                btn_next.getAllStyles().setFgColor(0xffffff, false);
                btn_next.getAllStyles().setFont(Font.createTrueTypeFont("Arial Narrow Bold", "Arial Narrow Bold.ttf").derive((int)(4.0 * pixelsPerMM), Font.STYLE_PLAIN), false);
                btn_next.addActionListener(new ActionListener() 
                {
                   @Override
                   public void actionPerformed(ActionEvent evt) 
                   {
                       Log.p("Offset page number "+btn_next.getText().trim()+" selected.", 1);
                   }
                });
                
                Button btn_last = new Button(" Last ");
                btn_last.getAllStyles().setBorder(null);
                btn_last.getAllStyles().setBgImage(img_blueish_btn);
                btn_last.getAllStyles().setBgColor(0x000000, false);
                btn_last.getAllStyles().setBgTransparency(0, false);
                btn_last.getAllStyles().setFgColor(0xffffff, false);
                btn_last.getAllStyles().setFont(Font.createTrueTypeFont("Arial Narrow Bold", "Arial Narrow Bold.ttf").derive((int)(4.0 * pixelsPerMM), Font.STYLE_PLAIN), false);
                btn_last.addActionListener(new ActionListener() 
                {
                   @Override
                   public void actionPerformed(ActionEvent evt) 
                   {
                       Log.p("Offset page number "+btn_last.getText().trim()+" selected.", 1);
                   }
                });


                cnt_page1 = new Container();
                cnt_page1.getAllStyles().setBorder(null);
                cnt_page1.getStyle().setBgColor(0x000000, false);
                cnt_page1.getStyle().setBgTransparency(0, false);
                cnt_page1.getStyle().setPadding(0, 0, 0, 0);
                cnt_page1.getStyle().setMargin(0, 0, 0, 0);
                //cnt_page1.add(btn_page1);
                    
                        
                    
        cnt_tablefoot = new Container(new BoxLayout(BoxLayout.X_AXIS)); 
        cnt_tablefoot.getAllStyles().setPadding(0, (int)(10.0 * pixelsPerMM), (int)(3.0 * pixelsPerMM), 0);
        cnt_tablefoot.add(new Label("page 1 of 3"));
        cnt_tablefoot.add(btn_page1);
        cnt_tablefoot.add(btn_page2);
        cnt_tablefoot.add(btn_page3);
        cnt_tablefoot.add(btn_next);
        cnt_tablefoot.add(btn_last);
        
        cnt_tablebody.revalidate();
        cnt_tablebody.repaint();
        
        cnt_table = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_table.setScrollableX(true);
        cnt_table.setScrollableY(true);
        cnt_table.setLeadComponent(null);
        cnt_table.add(cnt_tablehead);
        cnt_table.add(cnt_tablebody);
        
        
        fm_main.addComponent(BorderLayout.NORTH, cnt_titlebar);
        fm_main.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(cnt_table)); //cnt_button
        fm_main.addComponent(BorderLayout.SOUTH, cnt_tablefoot);

        Command backCommand = new Command("")
         {
          public void actionPerformed(ActionEvent ev) 
          {
              MainMenu homer = new MainMenu();
              homer.showMainMenu();
          }
         };

        
        fm_main.addCommand(backCommand);
        fm_main.setBackCommand(backCommand);
        fm_main.setTransitionOutAnimator(CommonTransitions.createUncover(CommonTransitions.SLIDE_HORIZONTAL, true, 300));
        fm_main.show();
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