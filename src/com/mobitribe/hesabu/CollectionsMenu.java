package com.mobitribe.hesabu;

import com.codename1.components.Accordion;
import com.codename1.components.InteractionDialog;
import com.codename1.components.ScaleImageButton;
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
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
//import static com.mobitribe.hesabu.MainMenu.tb_form;
//import com.mobitribe.hesabu.Utilz.Commonz;
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

public class CollectionsMenu extends Exception
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
    private String str_imageFile, str_jina;
    
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
    
    private Label lbl_find, lbl_sort, lbl_tile, lbl_item_column, lbl_grade_column;
    
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
    //private String str_description;
    
    private  FontImage ifont_burger, ifont_avatar, ifont_close;
    
    private InteractionDialog dlgi_department;
    
    private Toolbar tb;
    
    private Button btn_close, btn_save, btn_discard, btn_confirm, btn_login, btn_later, btn_signme, btn_forgot;
    Button[] button_department;
    private int i;
    private Image img_DEPTplaceholder;
    
    //DIALOG
    private Dialog dlg_login;
    
    private Container cnt_dlgSouth, cnt_dlgNorth;
    private Container cnt_table, cnt_tableheader, cnt_tablebody;
    
    Accordion [] accr_courses, accr_grade_weight, accr_grade_marks, accr_grade_range, accr_grade_percent, accr_grade_letter, accr_grade_subtotal, accr_grade_totals, accr_attempts, 
            accr_attempts_smade, accr_attempts_allowed, accr_attempts_grade, accr_attempts_grading, accr_attempts_reported, accr_attempts_lastsync;
    Button[] button_course, button_unit_enter, button_subject;
    Label[] lbl_view, lbl_course_ttle, lbl_amount, lbl_likes, lbl_comments, lbl_views, lbl_shares, lbl_talking, 
            lbl_voteup, lbl_votedown, lbl_author, lbl_datetime, lbl_organisation, lbl_divider, lbl_spacer, lbl_weight, lbl_grademarks, 
            lbl_range, lbl_percent, lbl_gradeletter, lbl_contribution, lbl_totals, lbl_attempts, lbl_attempts_smade, lbl_attempts_allowed, lbl_attempts_grade, lbl_attempts_grading, lbl_attempts_reported, lbl_attempts_lastsync;
    Label[] lbl_id, lbl_date, lbl_user_id, lbl_code, lbl_type, lbl_method, lbl_currency, lbl_description, lbl_quantity, lbl_cost, lbl_vat, lbl_total_cost, lbl_discount, lbl_grand_total, lbl_paid, lbl_due, lbl_refund, lbl_account_no, lbl_category_id, 
            lbl_product_id, lbl_item_id, lbl_agent_id, lbl_added_by, lbl_added_on, lbl_updatedon, lbl_updatedby, lbl_approvedby, lbl_approvedon, lbl_action_on, lbl_action_by, lbl_status;
    SpanLabel[] splbl_item, splbl_div;
    TextField[] txtf_view;
    Container[] cnt_tablerow, cnt_no, cnt_date, cnt_amount, cnt_item;
    
    Container[] cnt_id, cnt_user_id, cnt_code, cnt_type, cnt_method, cnt_currency, cnt_description, cnt_quantity, cnt_cost, cnt_vat, cnt_total_cost, cnt_discount, cnt_grand_total, cnt_paid, cnt_due, 
            cnt_refund, cnt_account_no, cnt_category_id, cnt_product_id, cnt_item_id, cnt_agent_id, cnt_added_by, cnt_added_on, cnt_updatedon, cnt_updatedby, cnt_approvedby, cnt_approvedon, 
            cnt_action_on, cnt_action_by, cnt_status;
    
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
        //cnt_titlebar.addComponent(BorderLayout.SOUTH, new Container(new BorderLayout()).add(BorderLayout.WEST, lbl_sort).add(BorderLayout.CENTER, FlowLayout.encloseCenterMiddle(txtf_search)).add(BorderLayout.EAST, lbl_tile)); //, lbl_find)
        
       
      //tb_mainfm = new Toolbar();
      //tb_mainfm.setTitleCentered(true);
      //fm_main.setToolbar(tb_mainfm);
      ////fm_main.getToolbar().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
      //tb_mainfm.setTitle("Departments Menu");
      //tb_mainfm.getTitleComponent().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
      //tb_mainfm.getTitleComponent().getStyle().setFgColor(0xffffff);
      
       sty_icon = fm_main.getUIManager().getComponentStyle("Title"); sty_icon.setFgColor(0xffffff);
      ifont_burger = FontImage.createMaterial(FontImage.MATERIAL_MENU, sty_icon, 4); //MATERIAL_MORE_HORIZ
      ifont_avatar = FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty_icon, 4); //MATERIAL_MORE_HORIZ 
      
      MainMenu nissanhomy = new MainMenu();
      //nissanhomy.getToolbar();
      
      //fm_main.setToolbar(tb_form);
      //fm_home.getToolbar().getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
      //tb_form.setTitle("Accounts Menu");
            
       //Header
        lbl_header = new Label();//img_header
            lbl_header.setAlignment(CENTER);
            lbl_header.getStyle().setMargin(0, 0, 0, 0);
            lbl_header.getStyle().setPadding(0, 0, 0, 0);

       //Body
       cnt_table = new Container(new BorderLayout());    
        cnt_table.getAllStyles().setMargin(0, 0, 0, 0);
        cnt_table.getAllStyles().setPadding(0, 0, 0, 0);
        cnt_table.getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(2, 0xDDDDDD), Border.createLineBorder(2, 0xDDDDDD), Border.createLineBorder(1, 0xffffff), Border.createLineBorder(1, 0xffffff)));
        
        lbl_item_column = new Label();
        lbl_item_column.setText("Item Name");
        lbl_item_column.getAllStyles().setFgColor(0x000000, false);
        lbl_item_column.getAllStyles().setFont(font_medium_bold, false);
        lbl_item_column.getAllStyles().setMargin(0,0,(int)(2.0 * pixelsPerMM),0);
        lbl_item_column.setIcon(theme.getImage("spacer.png"));
        lbl_item_column.setTextPosition(Component.LEFT);
        
        lbl_grade_column = new Label();
        lbl_grade_column.setText("Grade");
        lbl_grade_column.getAllStyles().setFgColor(0x000000, false);
        lbl_grade_column.getAllStyles().setFont(font_medium_bold, false);
        lbl_grade_column.getAllStyles().setMargin(0,0,(int)(2.0 * pixelsPerMM),0);
        lbl_grade_column.setIcon(theme.getImage("spacer.png"));
        lbl_grade_column.setTextPosition(Component.RIGHT);

        cnt_tablebody = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        
        String str_json_products = (String) Storage.getInstance().readObject("products.json");
        byte[] dataa_products = str_json_products.getBytes();
        JSONParser json_products = new JSONParser();
        try(Reader is_products = new InputStreamReader(new ByteArrayInputStream(dataa_products), "UTF-8"))
        {
            Map<String, Object> map_products = json_products.parseJSON(is_products);
            java.util.List<Map<String, Object>> obj_products = (java.util.List<Map<String, Object>>)map_products.get("root");  
            System.out.println("No of product items:---------> "+obj_products.size());

            i = 0;
            for(Map<String, Object> obj_prod : obj_products) 
            {    
                System.out.println("Object Keys: "+(String)obj_prod.keySet().toString());   // Object Keys: [id, name, type, category_id, sub_category_id, organisation_id, agent_id, manufactured_by, manufactured_on, expires_on, expired_by, added_by, added_on, updated_by, status]
                System.out.println("Object Values: "+(String)obj_prod.values().toString()); // Object Values: [1, Collection, 0, 0, 0, 1, 1, God, ~6000BC, 7000AD, The Messiah, 1, 2017-12-19 08:42:00, , 1]
                
                String str_product_id = (String)obj_prod.get("id").toString();
                String str_product_name = (String)obj_prod.get("name").toString();
                String str_product_type = (String)obj_prod.get("type").toString();
                String str_product_category_id = (String)obj_prod.get("category_id").toString();
                String str_product_sub_category_id = (String)obj_prod.get("sub_category_id").toString();
                
                System.out.println("id: "+(String)obj_prod.get("id"));                      //id: 1
                System.out.println("name: "+(String)obj_prod.get("name"));                  //name: Collection
                System.out.println("type: "+(String)obj_prod.get("type"));
                System.out.println("category_id: "+(String)obj_prod.get("category_id"));    //category_id: 0
                System.out.println("sub_category_id: "+(String)obj_prod.get("sub_category_id"));//sub_category_id: 0
                
                if(str_product_type.equals("1") && str_product_category_id.equals("0"))
                {
                    Storage.getInstance().writeObject("product_"+str_product_id, str_product_name);
                }
                
             i++;
            }
        }
        catch(IOException err) 
        {
                Log.e(err);
                printStackTrace();
        }
        
        
       //Table goes here>>              
        String str_json_read = (String) Storage.getInstance().readObject("collections.json"); //"accounts.json"
        byte[] dataa = str_json_read.getBytes();
        JSONParser json = new JSONParser();
        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
        {
            Map<String, Object> map_content = json.parseJSON(is_content);
            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");  
            System.out.println("No of collection items:---------> "+obj_content.size());

            i = 0;
            for(Map<String, Object> obj : obj_content) 
            {    
                //System.out.println("Object Keys: "+(String)obj.keySet().toString());   // [id, member_no, Year, Month_, Quarter_, date_collected, sent_status, pay_mode, cash_payment, mpesa_payment, cheque_payment, bank_payment, Gods_Tithe, Combined_Offering, Thanks_Giving, Church_Building, Camp_Offering, Local_Budget, Children_Ministry, Women_Ministry, Youth_Kitty, AMO_Fund, Pathfinder_Club, Adventures_Club, Sabbath_School, Quarterly_Lesson, Msamaria _Mwema, Club_Registration, VBS_, Personal_Ministry, Kuwinda_, Torosei_, Portluck_, Loose_Offering, Total_Given, date_added, added_by
                //System.out.println("Object Values: "+(String)obj.values().toString()); // [1, 800090, 2017, December, 4th Quarter, 2/12/2017, send, , 5000, 0, 0, 0, 2500, 2500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5000, 2017-12-17 18:04:06, 1]
                
                String str_id = (String)obj.get("id");
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
                String str_status = (String)obj.get("status");
                
                
                
                            lbl_id = new Label[obj_content.size()];
                            lbl_date = new Label[obj_content.size()];
                            splbl_item = new SpanLabel[obj_content.size()];
                            lbl_amount = new Label[obj_content.size()];
                            
                             
                            
//                            lbl_id = new Label[obj_content.size()];
//                            lbl_user_id = new Label[obj_content.size()];
//                            lbl_code = new Label[obj_content.size()];
//                            lbl_type = new Label[obj_content.size()];
//                            lbl_method = new Label[obj_content.size()];
//                            lbl_currency = new Label[obj_content.size()];
//                            lbl_description = new Label[obj_content.size()];
//                            lbl_quantity = new Label[obj_content.size()];
//                            lbl_cost = new Label[obj_content.size()];
//                            lbl_vat = new Label[obj_content.size()];
//                            lbl_total_cost = new Label[obj_content.size()];
//                            lbl_discount = new Label[obj_content.size()];
//                            lbl_grand_total = new Label[obj_content.size()];
//                            lbl_paid = new Label[obj_content.size()];
//                            lbl_due = new Label[obj_content.size()];
//                            lbl_refund = new Label[obj_content.size()];
//                            lbl_account_no = new Label[obj_content.size()];
//                            lbl_category_id = new Label[obj_content.size()];
//                            lbl_product_id = new Label[obj_content.size()];
//                            lbl_item_id = new Label[obj_content.size()];
//                            lbl_agent_id = new Label[obj_content.size()];
//                            lbl_added_by = new Label[obj_content.size()];
//                            lbl_added_on = new Label[obj_content.size()];
//                            lbl_updatedon = new Label[obj_content.size()];
//                            lbl_updatedby  = new Label[obj_content.size()];
//                            lbl_approvedby = new Label[obj_content.size()];
//                            lbl_approvedon = new Label[obj_content.size()];
//                            lbl_action_on = new Label[obj_content.size()];
//                            lbl_action_by = new Label[obj_content.size()];
//                            lbl_status  = new Label[obj_content.size()];
//
//                            cnt_id = new Container[obj_content.size()];
//                            cnt_user_id = new Container[obj_content.size()];
//                            cnt_code = new Container[obj_content.size()];
//                            cnt_type = new Container[obj_content.size()];
//                            cnt_method = new Container[obj_content.size()];
//                            cnt_currency = new Container[obj_content.size()];
//                            cnt_description = new Container[obj_content.size()];
//                            cnt_quantity = new Container[obj_content.size()];
//                            cnt_cost = new Container[obj_content.size()];
//                            cnt_vat = new Container[obj_content.size()];
//                            cnt_total_cost = new Container[obj_content.size()];
//                            cnt_discount = new Container[obj_content.size()];
//                            cnt_grand_total = new Container[obj_content.size()];
//                            cnt_paid = new Container[obj_content.size()];
//                            cnt_due = new Container[obj_content.size()];
//                            cnt_refund = new Container[obj_content.size()];
//                            cnt_account_no = new Container[obj_content.size()];
//                            cnt_category_id = new Container[obj_content.size()];
//                            cnt_product_id = new Container[obj_content.size()];
//                            cnt_item_id = new Container[obj_content.size()];
//                            cnt_agent_id = new Container[obj_content.size()];
//                            cnt_added_by = new Container[obj_content.size()];
//                            cnt_added_on = new Container[obj_content.size()];
//                            cnt_updatedon = new Container[obj_content.size()];
//                            cnt_updatedby  = new Container[obj_content.size()];
//                            cnt_approvedby = new Container[obj_content.size()];
//                            cnt_approvedon = new Container[obj_content.size()];
//                            cnt_action_on = new Container[obj_content.size()];
//                            cnt_action_by = new Container[obj_content.size()];
//                            cnt_status  = new Container[obj_content.size()];
                            
                            cnt_no = new Container[obj_content.size()];
                            cnt_date = new Container[obj_content.size()];
                            cnt_item = new Container[obj_content.size()];
                            cnt_amount = new Container[obj_content.size()];
                            
                            cnt_tablerow = new Container[obj_content.size()];

                            GridLayout laygrid = new GridLayout(3); //obj_content.size(), 
                            laygrid.setAutoFit(false);

                            TableLayout laytab = new TableLayout(obj_content.size(), 4);
                            
                                lbl_id[i] = new Label(String.valueOf((i+1)));
                                lbl_id[i].getAllStyles().setMargin(0,0,0,0);
                                lbl_id[i].getAllStyles().setPadding(0,0,0,0);
                                lbl_id[i].setTextPosition(Component.TOP);
                                
                                String str_date, str_dd, str_mm, str_yyyy;
                                
                                str_date = StringUtil.tokenize(str_added_on, ' ').get(0);
                                str_dd = StringUtil.tokenize(str_date, '-').get(2);
                                str_mm = StringUtil.tokenize(str_date, '-').get(1);
                                str_yyyy = StringUtil.tokenize(str_date, '-').get(0);
                                
                                lbl_date[i] = new Label(str_dd+"/"+str_mm+"/"+str_yyyy);
                                lbl_date[i].getAllStyles().setMargin(0,0,0,0);
                                lbl_date[i].getAllStyles().setPadding(0,0,0,0);
                                lbl_date[i].setTextPosition(Component.TOP); 
                                
                                splbl_item[i] = new SpanLabel();
                                splbl_item[i].setFocusable(false);
                                splbl_item[i].setTextBlockAlign(LEFT);
                                splbl_item[i].getTextComponent().setSingleLineTextArea(true);
                                
                                try 
                                {
                                    str_jina = Storage.getInstance().readObject("product_"+str_product_id).toString(); //String.valueOf((String)obj.get("product_id")
                                } 
                                catch (Exception e) 
                                {
                                    System.out.println("Error: "+e);
                                    printStackTrace();
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
                                lbl_amount[i].setText(str_paid.trim());
                                lbl_amount[i].getAllStyles().setFgColor(0xffffff, false);
                                //lbl_amount[i].getAllStyles().setFont(font_medium_plain, false);
                                lbl_amount[i].getAllStyles().setMargin(0,0,0,0);
                                lbl_amount[i].getAllStyles().setPadding(0,0,0,0);
                                lbl_amount[i].setTextPosition(Component.TOP);
                                
                               
                                
                                
                           

                                
                                
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
         
                                
                                
                                cnt_no[i].add(lbl_id[i]);
                                cnt_date[i].add(lbl_date[i]);
                                cnt_item[i].add(splbl_item[i]);
                                cnt_amount[i].add(lbl_amount[i]);
                                                         
                                cnt_tablerow[i] = new Container();
                                cnt_tablerow[i].setScrollableY(false);
                                cnt_tablerow[i].getAllStyles().setPadding(0, 0, (int)(2.0 * pixelsPerMM), 0);
                                cnt_tablerow[i].setLayout(laytab);

                                //Add to form only the collections
                                if(str_category_id.equals("1") && str_user_id.equals(Storage.getInstance().readObject("userid").toString()))
                                {
                                    cnt_tablerow[i].add(cnt_no[i]);
                                    cnt_tablerow[i].add(cnt_date[i]);
                                    cnt_tablerow[i].add(laytab.createConstraint().widthPercentage(40), cnt_item[i]);
                                    cnt_tablerow[i].add(cnt_amount[i]);
                                }
                                                                
                                cnt_tablebody.add(cnt_tablerow[i]);      
                                
             i++;
            }
        }
        catch(IOException err) 
        {
                Log.e(err);
                printStackTrace();
        }
       
       //<<here goes Table
                
        
        cnt_tableheader = new Container(new BorderLayout());
        cnt_tableheader.add(BorderLayout.WEST, lbl_item_column);
        cnt_tableheader.add(BorderLayout.EAST, lbl_grade_column);
        cnt_tableheader.add(BorderLayout.SOUTH, new Label("Collections Statement"));
        
       
        //cnt_table.addComponent(BorderLayout.NORTH, cnt_tableheader);
        cnt_table.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(cnt_tablebody)); //cnt_tablebody, new Label("Totals: "+"2,000")
        //cnt_table.addComponent(BorderLayout.SOUTH, new Label("Totals: "+"2,000"));
        
        fm_main.addComponent(BorderLayout.NORTH, cnt_titlebar);
        fm_main.addComponent(BorderLayout.CENTER, cnt_table); //cnt_button
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