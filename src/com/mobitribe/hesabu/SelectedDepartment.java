package com.mobitribe.hesabu;

import com.mobitribe.hesabu.DepartmentsMenu;
import com.codename1.charts.ChartComponent;
import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.MediaPlayer;
import com.codename1.components.MultiButton;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.facebook.FaceBookAccess;
import com.codename1.io.BufferedInputStream;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.ui.*;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Calendar;


import java.io.IOException;

import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.animations.CommonTransitions;
import static com.codename1.ui.events.ActionEvent.Type.Log;
import com.codename1.ui.events.FocusListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.ImageIO;
import com.codename1.util.StringUtil;
//import com.imediakenya.afdmobile.Utilz.Commonz;
//import com.imediakenya.afdmobile.Utilz.Connect;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Timer;
import com.codename1.io.Log;
import com.codename1.social.FacebookConnect;
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.animations.BubbleTransition;

import com.codename1.charts.ChartUtil;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.io.JSONParser;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.events.DataChangedListener;
//import com.enterprisemobi.churchapp.Utilz.Commonz;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

//import com.pmovil.telephony.Telephony;
//import com.pmovil.telephony.NativeTelephony;


/**
 *
 * @author Mogaka
 */
public class SelectedDepartment //extends SideMenuBaseForm
{
    //FORMS
    private Form fm_main;
    
    //BUTTONS
    public Button btn_login, btn_later, btn_signme, btn_forgot;
    private Button btn_register;
    private Button btn_getlogins, btn_getregistered;
    
    //IMAGES
    private Image img_backgroundP, img_backgroundL;
    private Image img_header;
    private Image img_title;
    private Image img_body;
    private Image img_footer;
    private Image user_id;
    private Image pass_wd;
    private Image img_avatar;
    private Image img_person, img_wife, img_husband, img_child;
    private Image img_info, img_back;
    
    //LABELS
    private Label lbl_header;
    private Label lbl_title;
    private Label lbl_footer;
    
    //CONTAINERS
    private Container cont_title, cnt_titlebar;
    private Container cont_header;
    private Container cnt_body;
    private Container cont_footer;
    
    
    
    //TEXTAREAS
    public static TextArea txt_username;
    public static TextArea txt_password;
    public static TextArea txt_transaction;
    public static TextField txf_username;
    public static TextField txf_password;
    
    private String str_country;
    
    private String str_Login_staus;
    private boolean bool_Login_staus, booldownloaded;
    
    //DIALOG
    private Dialog dlg_login;
    
    
    int displayWidth = Display.getInstance().getDisplayWidth();
    int displayHeight = Display.getInstance().getDisplayHeight();
    
    /**
     *
     */
    public static NetworkManager networkManager;
    Storage storage = Storage.getInstance();
    
    //Commonz commonz = new Commonz();
    //Synchronise sinkanyuabongo = new Synchronise();
    
    private static final int POLL_FREQUENCY = 5000;
    private long lastPolling;
    private boolean responseReceived = true;

    private Timer timer;
    
    private String un;
    
    private BufferedInputStream bis;
    
    private InputStream in;
    
    private String text;
    private String str_username, str_password;
    
    private boolean bool_username;
    
    private String str_Login_Status, str_usergender;
    
    private Container cnt_dlgSouth, cnt_dlgNorth;
        
    private Container cnt_nav;
    private Button btn_bible, btn_hymnal, btn_lesson, btn_bulletin, btn_menu;
    private Image img_bible, img_hymnal, img_lesson, img_bulletin, img_profile;
    
    private Command cmd_tbRight;
    
    private Container cnt_photo, cnt_avatar, cnt_basicData, cnt_familyDetails, cnt_basicInfo, cnt_locationMap, cnt_locationData, cnt_locationInfo, cnt_location, cnt_contactsCol1, cnt_contactsCol2, cnt_contactsInfo, cnt_membershipCol1, cnt_membershipCol2, cnt_membershipCol3, cnt_memberInfo, cnt_offeringInfo, cnt_occupationInfo, cnt_biodataInfo;
    private Container cnt_confirmORcancel_1, cnt_confirmORcancel_2;
    private Label lbl_taskName, lbl_taskDescription, lbl_taskBegining, lbl_taskEnding, lbl_allDay;
    private TextField txtf_taskName, txtf_taskDescription, txtf_taskBegining, txtf_taskEnding;
    private Calendar cldr_begin, cldr_end, cldr_anniversary;
    private Dialog dlg_profile;
    private Dialog dlg_startDate;
    private Dialog dlg_endDate;
    private Tabs tabs; 
    private Style s; 
    private RadioButton rb1, rb2, rbmale, rbfemale;
    private ComboBox combo_members;
    private BrowserComponent browser, browse_map;
    private int int_tasksid, int_count_Oldtasks, int_count_Newtasks; 
    private String str_oldTaskid, str_newTaskid, str_oldTaskcount, str_newTaskcount;
    
    private ButtonGroup rbg_allDay, rbgGender;
    private String str_allDay;
     
    private Container cnt_dlgiSouth_btns, cnt_dlgiSouth;
    private Label lbl_shareTask, lbl_recurringTask;
    private GenericListCellRenderer renderer;
    private Button btn_admin, btn_legal, btn_robert, btn_tomy, btn_olive, btn_rose, btn_matthew, btn_hildah; 
    private Button btn_hearing, btn_ruling, btn_mention, btn_datesetting;
    private Button btn_legalWork, btn_companySecretarial, btn_payment;
    
    private Button btn_dayPicker1, btn_dayPicker2;
    private Button btn_confirmDayPicker1, btn_confirmDayPicker2;
    private Button btn_cancelDayPicker1, btn_cancelDayPicker2;
    
    private Picker picker_datePicker1, picker_dateTimePicker1, picker_timePicker1, picker_stringPicker1;
    private Picker picker_datePicker2, picker_dateTimePicker2, picker_timePicker2, picker_stringPicker2;
    private Label lbl_dayPicker1, lbl_dayPicker2;
    private Image img_tasksheduler;
    private InteractionDialog dlgi_task;
    private Button btn_close, btn_save, btn_discard, btn_confirm;

    private Border bdr, bdr_no;
    private FontImage imgf_info, imgf_avatar, imgf_profession, imgf_finances, imgf_healthinfo, imgf_category, imgf_contacts, imgf_location, imgf_attachment, imgf_milestones;
    private FontImage imgf_legalWork, imgf_companySec, imgf_payments;
    private Container cnt_coodinates, cnt_locLabels, cnt_locTexts, cnt_locNess;
    
    private TextField txtf_country, txtf_city, txtf_county, txtf_residenceEstate, txtf_streetRoad, txtf_courtFlatBuilding, txtf_doorNumberHouse;
    private Label lbl_country, lbl_city, lbl_town, lbl_county, lbl_residenceEstate, lbl_streetCourt, lbl_houseNumbe, lbl_doorNumber;
    
    private Label lbl_phonePersonal1, lbl_phonePersonal2, lbl_phoneHome, lbl_phoneWork, lbl_emailPersonal1, lbl_emailPersonal2, lbl_emailHome, lbl_emailWork;
    private TextField txtf_phonePersonal1, txtf_phonePersonal2, txtf_phoneHome, txtf_phoneWork, txtf_emailPersonal1, txtf_emailPersonal2, txtf_emailHome, txtf_emailWork;
    
    private Label lbl_emergencyContact, lbl_emergencyContactName, lbl_postboxHome, lbl_postboxWork, lbl_postboxPersonal, lbl_postzipPersonal, lbl_postzipHome, lbl_postzipWork;
    private TextField txtf_emergencyContact, txtf_emergencyContactName, txtf_postboxHome, txtf_postboxWork, txtf_postboxPersonal, txtf_postzipPersonal, txtf_postzipHome, txtf_postzipWork;
        
    private ImageViewer imv;
    
    private Image img_share, img_close, img_logo, img_placeholder_person;
    private EncodedImage eImg, imge;
    private ImageViewer imgv;
    private Image img;
    
    private ShareButton sbtn; 
    private String str_imageFile;
    private Image img_screenshot;
    
    private Button btn_addSpouse;
    private AutoCompleteTextField txtc_spouce, txtc_children;
    private Picker picker_anniversary;
    private Toolbar tb;
    
    private Dialog dlg_avatar;
    private Button btn_logout, btn_profile, btn_accounts, btn_exit, btn_info, btn_back;
    private Resources theme;
    
    private Label lbl_isaDventist, lbl_isKarengatan, lbl_membernumber, lbl_isregistered, lbl_membershipby, lbl_registrdate, lbl_transferdate, lbl_lastMembership;
    private TextField txtf_isAdventist, txtf_isKarengatan, txtf_membernumber, txtf_isregistered, txtf_membershipby, txtf_registrdate, txtf_transferdate, txtf_lastMembership;
    
    private Label lbl_baptismStatus, lbl_baptismPlace, lbl_nearestChurch, lbl_regularChurch, lbl_homechurch, lbl_prayerCell, lbl_SabbathScl, lbl_amoWmGroup;      
    private TextField txtf_baptismStatus, txtf_baptismPlace, txtf_nearestChurch, txtf_regularChurch, txtf_homechurch, txtf_prayerCell, txtf_SabbathScl, txtf_amoWmAyGroup;  
    
    private Label lbl_department1, lbl_department2, lbl_department3, lbl_department4, lbl_spiritualg1, lbl_spiritualg2, lbl_spiritualg3, lbl_ministry;
    private TextField txtf_department1, txtf_department2, txtf_department3, txtf_department4, txtf_spiritualg1, txtf_spiritualg2, txtf_spiritualg3, txtf_ministry;    
    
    private Label lbl_Place_of_Work, lbl_JobTitle, lbl_Industry, lbl_Occupation, lbl_Education_Level, lbl_Employment_Status, lbl_Experience, lbl_Department, lbl_Skills_Talents, lbl_Hobbies_Interests, lbl_AwardsAccredations;
    private TextField txtf_Place_of_Work, txtf_JobTitle, txtf_Industry, txtf_Occupation, txtf_Education_Level, txtf_Employment_Status, txtf_Experience, txtf_Department, txtf_Skills_Talents, txtf_Hobbies_Interests, txtf_AwardsAccredations;
    
    private Label lbl_blood_type, lbl_heamoglobin, lbl_weight, lbl_height, lbl_bmi, lbl_blood_pressure, lbl_dietary_need, lbl_food_allergies, lbl_medicine_allergies, lbl_muscle_strength, lbl_special_medical_condition;
    private TextField txtf_start, txtf_blood_type, txtf_heamoglobin, txtf_weight, txtf_height, txtf_bmi, txtf_blood_pressure, txtf_dietary_need, txtf_food_allergies, txtf_medicine_allergies, txtf_muscle_strength, txtf_special_medical_condition;
    
    private String str_collection, str_start;
    
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
    
    private String str_leaders_details, str_leaders_name, str_leaders_title, str_leaders_photo, str_leaders_job;
    private String str_staffs_details, str_staffs_name, str_staffs_title, str_staffs_photo, str_staffs_job;
    private String str_ttl_activities, str_cnt_activities, str_mission, str_ttl_mission, str_cnt_mission, str_description, str_ttl_resourses, str_cnt_resourses, str_ttl_statements, str_cnt_statements, str_ttl_calendars, str_cnt_calendars,
            str_ttl_projections, str_cnt_projections, str_ttl_calendar, str_cnt_calendar;
    
    private String str_needle, str_haystack;
    private int int_lastIndex, int_count;
    
    
    Button[] button_resource;
    Label[] lbl_resource, lbl_ctn_resource, lbl_resource_ctn_tle, lbl_resource_ctn_img, lbl_resource_ctn_dsc, lbl_statements, lbl_ctn_statements, lbl_statements_ctn_tle, lbl_statements_ctn_img, lbl_statements_ctn_dsc, lbl_calendars, lbl_ctn_calendars, lbl_calendars_ctn_tle, lbl_calendars_ctn_img, lbl_calendars_ctn_dsc;
    SpanLabel[] splbl_resource, splbl_ctn_resource, splbl_ctn_resource_desc, splbl_statements, splbl_ctn_statements, splbl_ctn_statements_desc, splbl_calendars, splbl_ctn_calendars, splbl_ctn_calendars_desc;
    private int i, j;
    private int int_no_resources, int_no_resource_ctn, int_no_statements, int_no_statements_ctn, int_no_calendars, int_no_calendars_ctn;
    
    private String str_resources, str_resource_data, str_resource_ttle, str_resource_desc, str_resource_cont;
    private String str_resource_cnt_data, str_resource_ctn_tle, str_resource_ctn_img, str_resource_ctn_dsc;
    private String str_statements, str_statements_data, str_statements_ttle, str_statements_desc, str_statements_cont, str_calendars, str_calendars_data, str_calendars_ttle, str_calendars_desc, str_calendars_cont;
    private String str_statements_cnt_data, str_statements_ctn_date, str_statements_ctn_des, str_statements_ctn_amnt, str_calendars_cnt_data, str_calendars_ctn_date, str_calendars_ctn_desc, str_calendars_ctn_loca, str_calendars_ctn_time;
    
    private Container cnt_resource, cont_resource_data, cnt_statements, cont_statements_data, cnt_calendars, cont_calendars_data;
    
    
    private Image img_RESOURCEplaceholder, img_resource;
    
    private Command cmd_back;
    
    private Image img_church;
    /**
    * Creates a renderer for the specified colors.
    */
    private InputStream is;
    private Image img_sto;
    
    Style sty_lg, sty; 
    Label lbl_titleL, lbl_titleR; 
    Border border;
    
    private Dialog dlg_setDate;
    private Calendar cldr_bday, cldr_start;
    private Date dt_timer, dt_start, dt_selected, dt_end, dt_alert;
    private String str_saahii, str_hrs, str_min, str_ssaahii, str_sday, str_sdate, str_smonth, str_syear, str_shrs, str_smin, str_sapm, str_esaahii, str_eday, str_edate, str_emonth, str_eyear, str_ehrs, str_emin, str_eapm;
    
    
    private DefaultRenderer buildCategoryRenderer(int[] colors) 
    {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) 
        {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }
    /**
    * Builds a category series using the provided values.
    * @param titles the series titles
    * @param values the values
    * @return the category series
    */
    
    protected CategorySeries buildCategoryDataset(String title, double[] values) 
    {
        CategorySeries series = new CategorySeries(title);
        int k = 0;
        for (double value : values) 
        {
            if(k == 0)
            {
                 str_collection = "Church Building";
            }
            if(k == 1)
            {
                 str_collection = "Tithes";
            }
            if(k == 2)
            {
                 str_collection = "Offering";
            }
            if(k == 3)
            {
                 str_collection = "Torosei";
            }
            if(k == 4)
            {
                 str_collection = "Samburu";
            }
                
            //series.add(str_collection + ++k, value);
            series.add(str_collection + ++k, value);
        }
        return series;
    }
    
    private String str_cell, str_sschool, str_church, str_station, str_conference, str_union, str_division, str_denomination;
    
    private Font font_RageItalic, font_HPSimplified, font_HPSimplifiedBold, font_HPSimplifiedLight, font_HPSimplifiedLightItalic;
    double pixelsPerMM = ((double)Display.getInstance().convertToPixels(10, true)) / 10.0;
    private Font font_small_bold, font_small_plain, font_medium_uline, font_medium_bold, font_medium_plain, font_large_bold, font_large_plain;
    int int_zero_pt_five, int_one, int_one_pt_five, int_two, int_three, int_five_Pt_five;
    private Style sty_icon;
    
    private  FontImage ifont_burger, ifont_avatar;
    
    
    public SelectedDepartment()
    {
        
    }
    
    /**
     *
     */
    public void showMainScreen()
    {
        
      try
      {
       theme = Resources.openLayered("/theme");
       //theme = UIManager.initNamedTheme("/theme_1", "Theme");
       UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
       //Display.getInstance().getCurrent().refreshTheme();
       
       font_RageItalic = Font.createTrueTypeFont("Rage Italic", "Rage Italic.ttf");
       font_RageItalic = font_RageItalic.derive((int)(5.1 * pixelsPerMM), Font.STYLE_PLAIN);
       
       font_HPSimplified = Font.createTrueTypeFont("HP Simplified", "HP Simplified.ttf");
       font_HPSimplified = font_HPSimplified.derive((int)(3.1 * pixelsPerMM), Font.STYLE_BOLD);
       
       font_HPSimplifiedBold = Font.createTrueTypeFont("HP Simplified", "HP Simplified.ttf");
       font_HPSimplifiedBold = font_HPSimplifiedBold.derive((int)(4.0 * pixelsPerMM), Font.STYLE_BOLD);
       
       font_HPSimplifiedLight = Font.createTrueTypeFont("HP Simplified Light", "HP Simplified Light.ttf");
       font_HPSimplifiedLight = font_HPSimplifiedLight.derive((int)(2.5 * pixelsPerMM), Font.STYLE_PLAIN);
       
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
       
       
       if (displayHeight >= 200)
       {
        //img_title = Image.createImage("/title_login.png").scaledHeight(displayHeight/4);
       }
       //img_backgroundP  = Image.createImage("/background_potrait.jpg");
       //img_backgroundL  = Image.createImage("/background_landscape.jpg");
       //img_info = Image.createImage("/info.png");
       //img_profile = Image.createImage("/profile.png");
       //img_back = Image.createImage("/back.png");
       //img_tasksheduler = Image.createImage("/calendar.png");
       
       //img_avatar = Image.createImage("/avatar.png");
       //img_husband = Image.createImage("/husband.png");
       //img_wife = Image.createImage("/wife.png");
       
       //img_church = Image.createImage("/church.png");
       
       img_logo = Image.createImage("/logo.jpg");
       
       img_placeholder_person = Image.createImage("/placeholder_person.jpg");
       img_resource = Image.createImage("/department.png");
      }
      catch (IOException ioexception)
      {
       ioexception.printStackTrace();
      }
      
      displayWidth = Display.getInstance().getDisplayWidth();
      displayHeight = Display.getInstance().getDisplayHeight();
      
      //border = Border.createCompoundBorder(null, Border.createLineBorder(1, 0xC0C0C0), null, null);
      
      //Telephony.
      
      //Display.getInstance().notifyStatusBar("An new update available.", "jibu updte available", "LoginMenu to your app and click update, please proceed to download the content.", true, true, null);
      //Toolbar.setGlobalToolbar(true);
      //Form
      
      //Toolbar tbm = getToolbar();
      
        
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
        
        
        Display disp = Display.getInstance();
        //disp.setProperty("windows.StatusBar.ForegroundColor", String.valueOf(0xff0000)); // red
        //disp.setProperty("windows.StatusBar.BackgroundColor", String.valueOf(0xffffff)); // white
        //disp.setProperty("windows.StatusBar.BackgroundOpacity", String.valueOf(255));    // fully opaque
        disp.setProperty("android.statusbar_hidden", "false");
                //ios.statusbar_hidden
        //disp.getCurrent().refreshTheme();

        
            
      //HEAD
      lbl_header = new Label(img_header);
      lbl_header.setAlignment(CENTER);
      //lbl_header.getStyle().setBgColor(0x255000.5); //0x4E5DFF  //0xFF3333
      lbl_header.getStyle().setBgTransparency(0, false);
      //lbl_header.getStyle().setOpacity(0);
      lbl_header.getStyle().setMargin(0, 0, 0, 0);
      lbl_header.getStyle().setPadding(0, 10, 0, 30);  
      
      Button btn = new Button("Musical Hymns");
      btn.setUIID("ButtonMain");
      //btn.getStyle().setPadding(97, 73, 0, 0);
      //btn.getStyle().setMargin(97, 73, 0, 0);
      //btn.setHeight(97);
      //btn.setWidth(73);
      
      Label lbl_line1 = new Label("Musical");
      Label lbl_line2 = new Label("Hymns");
      
      MultiButton mbtn = new MultiButton();
      mbtn.setUIID("MultiButtonMain");
      mbtn.setTextLine1("");
      mbtn.setTextLine2("Musical");
      mbtn.setTextLine3("Hymns");
      
        SpanButton sbtn = new SpanButton("Musical Hymns");
        //sbtn.setUIID("ButtonMain");
        //sbtn.getStyle().setPadding(0, 0, 97, 73);
        sbtn.getStyle().setMargin(0, 0, 100, 100);
        
      Container cnt_btn = new Container();
      cnt_btn.setWidth(displayWidth);
      cnt_btn.setLayout(new GridLayout(1, 3));//new FlowLayout() //new GridLayout(1, 3) //new BoxLayout(BoxLayout.X_AXIS)
        TextArea txa = new TextArea("Musical \nHymn");
        txa.setUIID("TextAreaMain");
        txa.getStyle().setMargin(0, 0, 10, 10);
        //txa.getStyle().setPadding(0, 0, 30, 30);
        txa.getStyle().setAlignment(CENTER, false);
      cnt_btn.addComponent(txa);

        TextArea txa1 = new TextArea("Musical \nHymn");
        txa1.setUIID("TextAreaMain");
        //txa1.getStyle().setMargin(0, 0, 170, 170);
        txa1.getStyle().setMargin(0, 0, 10, 10);
        txa1.getStyle().setAlignment(CENTER, false);
      cnt_btn.addComponent(txa1);

        TextArea txa2 = new TextArea("Musical \nHymn");
        txa2.setUIID("TextAreaMain");
        //txa2.getStyle().setMargin(0, 0, 170, 170);
        txa2.getStyle().setMargin(0, 0, 10, 10);
        txa2.getStyle().setAlignment(CENTER, false);
      cnt_btn.addComponent(txa2);
      
      //mbtn.getStyle().set
      //mbtn.addComponent(BorderLayout.NORTH, lbl_line1);
      //mbtn.addComponent(BorderLayout.SOUTH, lbl_line2);
        
      //fm_home.addComponent(btn);
      //fm_home.addComponent(mbtn);
      //fm_home.addComponent(sbtn);
      //fm_home.addComponent(txa);
      
      Style sty_lg = new Style();
        sty_lg.setBgTransparency(0, false);
        sty_lg.setFgColor(0xffffff);//0xff3333 //0x5DDB00
        //sty_lg.setMargin(0, 0, 0, 0);
        sty_lg.setMarginUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        sty_lg.setUnderline(false);
      
      //BODY
      //ppg1_leader
      
      Container cnt_leader = new Container();
        cnt_leader.setLayout(new GridLayout(1, 2));
        
      Container cnt_leaderL = new Container();
        cnt_leaderL.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            Label lbl0_leader = new Label(Storage.getInstance().readObject("lbl0_leader").toString());
                    lbl0_leader.getAllStyles().setAlignment(LEFT);
                    lbl0_leader.getStyle().setFont(font_HPSimplified);
                    
            str_leaders_photo = Storage.getInstance().readObject("lbl1_leader").toString();
            /*
            Util.downloadUrlToStorageInBackground("http://"+Commonz.host+"/admin/content/Images/"+str_leaders_photo, str_leaders_photo, new  ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {

                }
            });
            */
            //Util.Util.dowloadFileTo
            try
            {
                EncodedImage eImg = EncodedImage.createFromImage(img_placeholder_person, true);
                
                str_staffs_photo = Storage.getInstance().readObject("lbl1_leader").toString();
                
                System.out.println(Connect.str_host+"admin/content/Images/"+str_leaders_photo); //str_staffs_photo
                
                img_sto = URLImage.createToStorage(eImg, str_staffs_photo, Connect.str_host+"admin/content/Images/"+str_leaders_photo, URLImage.RESIZE_SCALE);
                 
                is = Storage.getInstance().createInputStream(str_leaders_photo);
                imge = EncodedImage.create(is, is.available());
                imgv = new ImageViewer(imge);
                //img_person = EncodedImage.createImage(is).scaledHeight(displayWidth/2); ////img_sto = EncodedImage.createImage(is).scaled(displayWidth/9, displayHeight/9);//.scaledHeight(displayHeight)
            }
            catch (IOException ioexception)
            {
                //ioexception.printStackTrace();
            }
            
                    
                    
                
            Label lbl1_leader = new Label();
                    lbl1_leader.setIcon(img_placeholder_person.scaledWidth(displayWidth/2)); //imgv.getImage().scaledHeight(displayWidth/2)   //imge //img_placeholder_person.scaledWidth(displayWidth/2) //Storage.getInstance().readObject("lbl1_leader").toString()
                    //lbl1_leader.getAllStyles().setBgImage(img_placeholder_person);
                    //lbl1_leader.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL); 
                    lbl1_leader.getAllStyles().setAlignment(CENTER);
               
            Label lbl2_leader = new Label(Storage.getInstance().readObject("lbl2_leader").toString());
                    lbl2_leader.getAllStyles().setAlignment(CENTER);
                    lbl2_leader.getStyle().setFont(font_HPSimplified);
                
            Label lbl3_leader = new Label(Storage.getInstance().readObject("lbl3_leader").toString());
                    lbl3_leader.getAllStyles().setAlignment(CENTER);
                    lbl3_leader.getStyle().setFont(font_HPSimplifiedLightItalic);
                    lbl3_leader.getAllStyles().setPaddingBottom(int_three);
                    lbl3_leader.setGap(-3);
            
            cnt_leaderL.add(lbl0_leader);
            cnt_leaderL.add(lbl1_leader);
            cnt_leaderL.add(lbl2_leader);
            cnt_leaderL.add(lbl3_leader);
            
      Container cnt_leaderR = new Container();
        cnt_leaderR.setLayout(new BoxLayout(BoxLayout.Y_AXIS)); //new GridLayout(6, 1)
        cnt_leaderR.getAllStyles().setAlignment(CENTER);
        //cnt_leaderR.getAllStyles().setMarginTop((int)(1.5 * pixelsPerMM));
        //cnt_leaderR.setWidth(displayWidth/3);
            Label lbl_email = new Label("email");
                lbl_email.setIcon(theme.getImage("email.png"));
                lbl_email.getAllStyles().setAlignment(LEFT);
                cnt_leaderR.add(lbl_email);
            Label lbl_text = new Label("text");
                lbl_text.setIcon(theme.getImage("text.png"));  
                lbl_text.getAllStyles().setAlignment(LEFT);
                cnt_leaderR.add(lbl_text);
            Label lbl_call = new Label("call");    
                lbl_call.setIcon(theme.getImage("call.png"));  
                lbl_call.getAllStyles().setAlignment(LEFT);
                cnt_leaderR.add(lbl_call);
            Label lbl_post = new Label("post");    
                lbl_post.setIcon(theme.getImage("post.png")); 
                lbl_post.getAllStyles().setAlignment(LEFT);
                //cnt_leaderR.add(lbl_post);
            Label lbl_chat = new Label("chat");    
                lbl_chat.setIcon(theme.getImage("chat.png")); 
                lbl_chat.getAllStyles().setAlignment(LEFT);
                cnt_leaderR.add(lbl_chat);
            Label lbl_support = new Label("support");    
                lbl_support.setIcon(theme.getImage("text.png")); 
                lbl_support.getAllStyles().setAlignment(LEFT);
                cnt_leaderR.add(lbl_support);
            Label lbl_donate = new Label("donate");    
                lbl_donate.setIcon(theme.getImage("donate.png"));
                lbl_donate.getAllStyles().setAlignment(LEFT);
                cnt_leaderR.add(lbl_donate);
                
                int pixels = (int)(1.5 * pixelsPerMM);
                int height = (int)(33.9 * pixelsPerMM);
                int width = (int)(20 * pixelsPerMM);
                
                cnt_body = new Container();
                cnt_body.setLayout(new BoxLayout(BoxLayout.Y_AXIS)); 
                cnt_body.setScrollableY(true);
                cnt_body.getAllStyles().setPadding(pixels, pixels, pixels, pixels);
        
                
                //lbl0_description. 
                
                SpanLabel answer = new SpanLabel(text);
                    //answer.setIcon(roundedHimOrHerImage);
                    //answer.setIconPosition(BorderLayout.EAST);
                    answer.setTextUIID("BubbleThem");
                    answer.setTextBlockAlign(Component.RIGHT);
                                
                Border border1 = Border.createCompoundBorder(Border.createLineBorder(1, 0x000fff), Border.createLineBorder(1, 0x000fff), Border.createLineBorder(1, 0x000fff), Border.createLineBorder(1, 0x000fff));
                
                
                Label lbl0_description = new Label(Storage.getInstance().readObject("lbl0_description").toString());
                    lbl0_description.getAllStyles().setPadding(10, 0, 0, 0);
                    lbl0_description.getAllStyles().setAlignment(LEFT);
                    lbl0_description.getStyle().setFont(font_HPSimplified);           
                
                SpanLabel spnlbl1_description = new SpanLabel();
                    spnlbl1_description.setText(Storage.getInstance().readObject("lbl1_description").toString().replace('\n', ' '));
                    spnlbl1_description.getTextAllStyles().setAlignment(LEFT);
                    spnlbl1_description.getTextAllStyles().setFont(font_HPSimplifiedLight);
                    spnlbl1_description.getTextAllStyles().setMargin(0, 0, 0, 0);
                    spnlbl1_description.getTextAllStyles().setPadding(0, 0, 0, 0);
                    spnlbl1_description.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                    spnlbl1_description.getStyle().setPadding(0, 0, 0, 0);
                    spnlbl1_description.getStyle().setMargin(0, 20, 0, 0);
                    
                Container cnt_description = new Container();
                        cnt_description.setWidth(displayWidth);
                        cnt_description.setLayout(new BorderLayout());
                        //cnt_description.add(BorderLayout.CENTER_BEHAVIOR_TOTAL_BELOW, spnlbl1_description);
                
                
                TextArea txta_description = new TextArea();
                        txta_description.setText(Storage.getInstance().readObject("lbl1_description").toString());
                                
                txta_description.setRows(2);
                        txta_description.setColumns(100);
                        txta_description.setEditable(false);
                        txta_description.setUIID("SmallFontLabel");
                        txta_description.setName("Text_Area_1");
                        txta_description.setColumns(100);
                        txta_description.setRows(2);
                        
                /*Label lbl_staff = new Label();
                        lbl_staff.setText(Storage.getInstance().readObject("lbl0_staff").toString());
                        lbl_staff.getAllStyles().setPadding(10, 0, 0, 0);
                        lbl_staff.getAllStyles().setAlignment(LEFT);
                        lbl_staff.getStyle().setFont(font_HPSimplified);*/
                        
                Label lbl_staff = new Label("Staff");
                    lbl_staff.getAllStyles().setAlignment(CENTER);
                    lbl_staff.getStyle().setFont(font_HPSimplified);
                    lbl_staff.getStyle().setPaddingTop(10);
                        
                
                            
                        
                //Storage.getInstance().writeObject("staff_size", staff.size());
                int staff_size = Integer.parseInt(Storage.getInstance().readObject("staff_size").toString()); //System.out.println("Staff Size: "+staff_size);
                 Container cnt_staff = new Container();
                    //cnt_staff.getStyle().setBorder(border);
                    GridLayout grd = new GridLayout(staff_size, 2);
                    grd.setAutoFit(true);
                    cnt_staff.setLayout(grd); //
                    //cnt_staff.getStyle().set
                    for (int i=0; i<staff_size; i++) 
                    {
                        str_staffs_details = (String) Connect.storage.readObject("staff_"+i); //= StringUtil.tokenize(str_response, "|").get(0).trim();
                        str_staffs_name  = StringUtil.tokenize(str_staffs_details, "|").get(0); System.out.println(i+". Staff's Name: "+str_staffs_name);
                        str_staffs_title = StringUtil.tokenize(str_staffs_details, "|").get(1); 
                        str_staffs_photo = StringUtil.tokenize(str_staffs_details, "|").get(2);
                        str_staffs_job   = StringUtil.tokenize(str_staffs_details, "|").get(3);
                        
                        
                        /*try
                        {
                         img_placeholder_person = Image.createImage("/placeholder_person.jpg"); //DEPTplaceholder.png
                         eImg = EncodedImage.createFromImage(img_placeholder_person, false);
                         img_person =  URLImage.createToStorage(eImg, str_staffs_photo, "http://"+Commonz.host+"/admin/content/Images/"+str_staffs_photo, URLImage.RESIZE_SCALE);
                            System.out.println("Downloading Image: "+"http://"+Commonz.host+"/admin/content/Images/"+str_staffs_photo);
                         //button_department[k] = new Button(str_departments_uname, Image.createImage("/"+img_pic));
                        }
                        catch (IOException ioexception)
                        {
                         ioexception.printStackTrace();
                        }*/
                        
                        //Util.downloadUrlToStorageInBackground("http://"+Commonz.host+"/admin/content/Images/"+str_staffs_photo, str_staffs_photo);
                        
                        //eImg = EncodedImage.createFromImage(img_placeholder_person, true);
                        //img_person = URLImage.createToStorage(eImg, str_staffs_photo, "http://"+Commonz.host+"/admin/content/Images/"+str_staffs_photo, URLImage.RESIZE_SCALE);
                        
                        //TODO: First Check if image(str_staffs_photo) is in storage, if not do direct download else do normal download                    
                        /*try
                        {
                            EncodedImage eImg = EncodedImage.createFromImage(img_placeholder_person, true);
                            img_sto = URLImage.createToStorage(eImg, str_staffs_photo, "http://"+Commonz.host+"/admin/content/Images/"+str_staffs_photo, URLImage.RESIZE_SCALE);
                            System.out.println("http://"+Commonz.host+"/admin/content/Images/"+str_staffs_photo); 
                            is = Storage.getInstance().createInputStream(str_staffs_photo);
                            img_person = EncodedImage.createImage(is).scaledHeight(displayWidth/4); ////img_sto = EncodedImage.createImage(is).scaled(displayWidth/9, displayHeight/9);//.scaledHeight(displayHeight)   
                        }
                        catch (IOException ioexception)
                        {
                            ioexception.printStackTrace();
                        }*/
                        
                        booldownloaded = Storage.getInstance().exists(str_staffs_photo);
                        if(booldownloaded == true)
                        {
                            //Storage.getInstance().writeObject("", "");
                            System.out.println("Already downloaded image "+j+" - "+str_staffs_photo+".");
                        }
                        else
                        {
                            /*Util.downloadUrlToStorageInBackground("http://"+Commonz.host+"admin/content/Images/"+str_staffs_photo, str_staffs_photo, new ActionListener() 
                            {
                                @Override
                                public void actionPerformed(ActionEvent evt) 
                                {
                                    System.out.println("Finished downloading image "+j+" - "+str_staffs_photo+".");
                                }
                            });*/
                            Util.downloadUrlToStorage(Connect.str_host+"admin/content/Images/"+str_staffs_photo, str_staffs_photo, true);
                        }
                        
                        
                        
                        Label lbl0_staff_job = new Label(str_staffs_job);
                                lbl0_staff_job.getAllStyles().setAlignment(CENTER);
                                lbl0_staff_job.getStyle().setFont(font_HPSimplified);
                                //lbl0_staff.getStyle().setMargin(150, 150, 150, 150);
                                                                
                        Label lbl1_staff_Icon = new Label();
                                //lbl1_staff_Icon.setIcon(img_person); //img_person //img_person.scaledWidth(displayWidth/4) //Storage.getInstance().readObject("lbl1_leader").toString()
                                //lbl1_leader.getAllStyles().setBgImage(img_placeholder_person);
                                //lbl1_leader.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL); 
                                lbl1_staff_Icon.getAllStyles().setAlignment(CENTER);
                                //lbl1_staff_Icon.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
                                //lbl1_staff_Icon.getAllStyles().setPadding(pixels, pixels, pixels, pixels);

                        Label lbl2_staff_name = new Label(str_staffs_name);
                                lbl2_staff_name.getAllStyles().setAlignment(CENTER);
                                lbl2_staff_name.getStyle().setFont(font_HPSimplified);

                        Label lbl3_staff_title = new Label(str_staffs_title);
                                lbl3_staff_title.getAllStyles().setAlignment(CENTER);
                                lbl3_staff_title.getStyle().setFont(font_HPSimplifiedLightItalic);
                                lbl3_staff_title.getAllStyles().setPaddingBottom(int_three);

                        //Read images from storage and add to each persons photo
                        try
                        {
                            //str_view = str_tazamo.replace(karoOld, karoNew).trim();
                            //str_tazamo = StringUtil.tokenize(str_views, ",").get(i).trim().replace(karoOld, karoNew).trim();
                            //System.out.println(i+" "+str_tazamo);
                            is = Storage.getInstance().createInputStream(str_staffs_photo);
                            imge = EncodedImage.create(is, is.available());
                            imgv = new ImageViewer(imge);
                            //Image img_view = EncodedImage.createImage(is).scaledHeight(displayWidth/2);
                            //lbl1_staff_Icon[i].set(imgv.getImage(), false);
                            lbl1_staff_Icon.setIcon(imgv.getImage().scaledHeight(displayWidth/4));
                        } 
                        catch (Exception e) 
                        {
                            //Set place holder
                            String str_errorType = StringUtil.tokenize(e.toString(), ":").get(0);
                            if(str_errorType.equals("java.io.FileNotFoundException"))
                            {
                                System.out.println(">> 1."+e);
                                //Dialog.show("Error Occured!", "Image unavailable.", "Ok", null);
                                //TODO: Here set the image place holder
                            }
                            else
                            {
                                //Dialog.show("Error Occured!", ">> "+e, "Ok", null);
                                System.out.println(">> 2."+e); //java.io.FileNotFoundException: C:\Users\Tommy Mogaka\.cn1\MyImage.png (The system cannot find the file specified)
                            }
                        }
                        
                        cnt_staff.add(BoxLayout.encloseY(lbl1_staff_Icon, lbl2_staff_name, lbl3_staff_title));
                    }
                    
                    
                    
                    
                    
                    
                    Label lbl0_mission = new Label(Storage.getInstance().readObject("lbl0_mission").toString());
                    lbl0_mission.getAllStyles().setAlignment(LEFT);
                    lbl0_mission.getStyle().setFont(font_HPSimplified);
                    //lbl0_mission.getStyle().setPaddingTop(10);
                    
                    TextArea txta_mission = new TextArea();
                        txta_mission.setText(Storage.getInstance().readObject("lbl1_mission").toString());
                        txta_mission.setRows(2);
                        txta_mission.setColumns(100);
                        txta_mission.setEditable(false);
                        txta_mission.setUIID("SmallFontLabel");
                        txta_mission.setName("Text_Area_1");
                        txta_mission.setColumns(100);
                        txta_mission.setRows(2);
                    
                    
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
                        
                    String str_mission = Storage.getInstance().readObject("lbl1_mission").toString().replace('\n', ' ');
                    SpanLabel spnlbl1_mission = new SpanLabel();
                    spnlbl1_mission.setText(Storage.getInstance().readObject("lbl1_mission").toString().replace('\n', ' '));
                    //spnlbl1_mission.setUIID("Label");
                    //spnlbl1_mission.setTextBlockAlign(Component.LEFT);
                    //spnlbl1_mission.setTextUIID("BlockLeftDesc");
                    spnlbl1_mission.getTextAllStyles().setAlignment(LEFT);
                    spnlbl1_mission.getTextAllStyles().setFont(font_HPSimplifiedLight);
                    spnlbl1_mission.getTextAllStyles().setMargin(0, 0, 0, 0);
                    spnlbl1_mission.getTextAllStyles().setPadding(0, 0, 0, 0);
                    spnlbl1_mission.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                    spnlbl1_mission.getStyle().setPadding(0, 0, 0, 0);
                    spnlbl1_mission.getStyle().setMargin(0, 20, 0, 0);
                    ////spnlbl1_mission.setWidth(displayWidth);
                    //spnlbl1_mission.getStyle().setFont(font_HPSimplifiedLight);
                    //spnlbl1_mission.getStyle().setBorder(border1);
                    
                str_ttl_activities = Storage.getInstance().readObject("lbl0_activities").toString();  
                Label lbl0_activities = new Label(str_ttl_activities);
                    lbl0_activities.getAllStyles().setPadding(10, 0, 0, 0);
                    lbl0_activities.getAllStyles().setAlignment(LEFT);
                    lbl0_activities.getStyle().setFont(font_HPSimplified); 
                    
                str_cnt_activities = Storage.getInstance().readObject("lbl1_activities").toString().replace('\n', ' ');
                SpanLabel spnlbl1_activities = new SpanLabel();
                    spnlbl1_activities.setText(str_cnt_activities);
                    spnlbl1_activities.getTextAllStyles().setAlignment(LEFT);
                    spnlbl1_activities.getTextAllStyles().setFont(font_HPSimplifiedLight);
                    spnlbl1_activities.getTextAllStyles().setMargin(0, 0, 0, 0);
                    spnlbl1_activities.getTextAllStyles().setPadding(0, 0, 0, 0);
                    spnlbl1_activities.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                    spnlbl1_activities.getStyle().setPadding(0, 0, 0, 0);
                    spnlbl1_activities.getStyle().setMargin(0, 20, 0, 0);
                   
                str_ttl_resourses = Storage.getInstance().readObject("ttl_resources").toString();
                Label lbl0_resourses = new Label(str_ttl_resourses);
                    lbl0_resourses.getAllStyles().setPadding(10, 0, 0, 0);
                    lbl0_resourses.getAllStyles().setAlignment(LEFT);
                    lbl0_resourses.getStyle().setFont(font_HPSimplified);
                    
                str_cnt_resourses = Storage.getInstance().readObject("cnt_resources").toString();  //Are you still dating?|Many, not just in adventist circles, are abandoning the age old practice and instead are choosing to wait to get married.|Letters to Young Lovers~ltyl.png~Ellen G. White - Guided by the Spirit of Prophecy takes it a notch higher by saying that some activities of courtship are better carried out after the wedding than before.^I Kissed Dating Goodbye~Ikissed.png~Forwarded by acclaimed artist Rebecah St. James, this books is testament that young people can do just fine if not better without dating$Are you still dating?|Many, not just in adventist circles, are abandoning the age old practice and instead are choosing to wait to get married.|Letters to Young Lovers~ltyl.png~Ellen G. White - Guided by the Spirit of Prophecy takes it a notch higher by saying that some activities of courtship are better carried out after the wedding than before.^I Kissed Dating Goodbye~Ikissed.png~Forwarded by acclaimed artist Rebecah St. James, this books is testament that young people can do just fine if not better without dating.  
                    str_needle   = "$";
                    str_haystack = str_cnt_resourses;
                    int_lastIndex = 0;
                    int_count = 0;

                    while (int_lastIndex != -1) 
                    {
                        int_lastIndex = str_haystack.indexOf(str_needle, int_lastIndex);

                        if (int_lastIndex != -1) 
                        {
                            int_count++;
                            int_lastIndex += str_needle.length();
                        }
                    }
                    int offset = int_count+1;
                    Storage.getInstance().writeObject("no_resources", offset);
                    System.out.println("No. of Resources: ->"+offset+"<");
                    
                
                int_no_resources = Integer.parseInt(Storage.getInstance().readObject("no_resources").toString());
                lbl_resource = new Label[int_no_resources]; 
                splbl_resource = new SpanLabel[int_no_resources];
                
                cnt_resource = new Container(new GridLayout(int_no_resources, 1)); 
                for (i = 0; i < int_no_resources; i++) 
                {
                    str_resource_data = StringUtil.tokenize(str_cnt_resourses, "$").get(i).trim(); //Are you still dating?|Many, not just in adventist circles, are abandoning the age old practice and instead are choosing to wait to get married.|Letters to Young Lovers~ltyl.png~Ellen G. White - Guided by the Spirit of Prophecy takes it a notch higher by saying that some activities of courtship are better carried out after the wedding than before.^I Kissed Dating Goodbye~Ikissed.png~Forwarded by acclaimed artist Rebecah St. James, this books is testament that young people can do just fine if not better without dating
                    str_resource_ttle = StringUtil.tokenize(str_resource_data, "|").get(0).trim(); //Are you still dating?
                    str_resource_desc = StringUtil.tokenize(str_resource_data, "|").get(1).trim(); //Many, not just in adventist circles, are abandoning the age old practice and instead are choosing to wait to get married! Does this even make sense? Below is a read that proves that in not only that is surely does but also that it is the way of the Master as planned from the creation of this world.
                    str_resource_cont = StringUtil.tokenize(str_resource_data, "|").get(2).trim(); //Letters to Young Lovers~ltyl.png~Ellen G. White - Guided by the Spirit of Prophecy takes it a notch higher by saying that some activities of courtship are better carried out after the wedding than before.^I Kissed Dating Goodbye~Ikissed.png~Forwarded by acclaimed artist Rebecah St. James, this books is testament that young people can do just fine if not better without dating
                    
                    str_needle   = "^";
                    str_haystack = str_resource_cont;
                    int_lastIndex = 0;
                    int_count     = 0;

                    while (int_lastIndex != -1) 
                    {
                        int_lastIndex = str_haystack.indexOf(str_needle, int_lastIndex);
                        if (int_lastIndex != -1) 
                        {
                            int_count++;
                            int_lastIndex += str_needle.length();
                        }
                    }
                    int offset2 = int_count+1;
                    Storage.getInstance().writeObject("no_resource_ctn", offset2);
                    System.out.println("No. of Resource Contents: ->"+offset2+"<");

                    int_no_resource_ctn = Integer.parseInt(Storage.getInstance().readObject("no_resource_ctn").toString());
                    //lbl_ctn_resource = new Label[int_no_resource_ctn]; 
                    lbl_resource_ctn_tle = new Label[int_no_resource_ctn];
                    lbl_resource_ctn_img = new Label[int_no_resource_ctn];
                    lbl_resource_ctn_dsc = new Label[int_no_resource_ctn];
                    splbl_ctn_resource_desc = new SpanLabel[int_no_resource_ctn];

                    cont_resource_data = new Container(); 
                    GridLayout lay_grid_res = new GridLayout(int_no_resource_ctn, 2);
                    lay_grid_res.setAutoFit(true);
                    cont_resource_data.setLayout(lay_grid_res);
                    for (j = 0; j < int_no_resource_ctn; j++) 
                    {
                        str_resource_cnt_data = StringUtil.tokenize(str_resource_cont, "^").get(j).trim();    //Letters to Young Lovers~ltyl.png~Ellen G. White - Guided by the Spirit of Prophecy takes it a notch higher by saying that some activities of courtship are better carried out after the wedding than before.^I Kissed Dating Goodbye~Ikissed.png~Forwarded by acclaimed artist Rebecah St. James, this books is testament that young people can do just fine if not better without dating
                        str_resource_ctn_tle = StringUtil.tokenize(str_resource_cnt_data, "~").get(0).trim(); //Letters to Young Lovers
                        str_resource_ctn_img = StringUtil.tokenize(str_resource_cnt_data, "~").get(1).trim(); //ltyl.png
                        str_resource_ctn_dsc = StringUtil.tokenize(str_resource_cnt_data, "~").get(2).trim(); //Ellen G. White - Guided by the Spirit of Prophecy takes it a notch higher by saying that some activities of courtship are better carried out after the wedding than before.^I Kissed Dating Goodbye~Ikissed.png~Forwarded by acclaimed artist Rebecah St. James, this books is testament that young people can do just fine if not better without dating
                        
                        try
                        {
                         img_RESOURCEplaceholder = Image.createImage("/adventist_icon.jpg");
                         eImg = EncodedImage.createFromImage(img_RESOURCEplaceholder, true);
                         img_resource =  URLImage.createToStorage(eImg, str_resource_ctn_img, Connect.str_host+"admin/content/Images/"+str_resource_ctn_img, URLImage.RESIZE_SCALE);
                         //img_person = EncodedImage.createImage(is).scaledHeight(displayWidth/4);
                         System.out.println("Downloading Resource Image: "+Connect.str_host+"admin/content/Images/"+str_resource_ctn_img);
                        }
                        catch (IOException ioexception)
                        {
                         ioexception.printStackTrace();
                        }
                        
                        /*lbl_resource_ctn_tle[i] = new Label();
                        lbl_resource_ctn_tle[i].setText(str_resource_ctn_tle);
                        lbl_resource_ctn_tle[i].setName(str_resource_ctn_tle);*/
                        
                        Label lbl1_res_Icon = new Label();
                                lbl1_res_Icon.setIcon(img_resource.scaledHeight(displayWidth/4));
                                lbl1_res_Icon.getAllStyles().setAlignment(CENTER);
                                
                        SpanLabel spl_res_desc = new SpanLabel();
                                //spl_res_desc.setIcon(img_resource);
                                spl_res_desc.setText(str_resource_ctn_tle);
                                spl_res_desc.setIconPosition("North");
                                spl_res_desc.getStyle().setBgColor(0x000000); 
                                spl_res_desc.getStyle().setFgColor(0xffffff);
                                spl_res_desc.getStyle().setPadding(0, 15, 0, 0);
                                //spl_deparment.getStyle().setMargin(0, 0, 130, 130);
                                spl_res_desc.getStyle().setBgTransparency(0, false);
                                spl_res_desc.getStyle().setFont(font_HPSimplified);
                                spl_res_desc.addPointerPressedListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        //Log.p(leader.get(2)+" label pressed.", 1);
                                        //SelectedDepartment depselector = new SelectedDepartment();
                                        //depselector.showMainScreen();
                                        //showDepartment();
                                    }
                                });
                        
                        //lbl_resource_ctn_tle[i] = new Label();
                        //lbl_resource_ctn_tle[i].setIcon(img_resource);
                        //lbl_resource_ctn_tle[i].setName(str_resource_ctn_tle);
                        //lbl_resource_ctn_tle[i].setText(str_resource_ctn_tle);
                        //lbl_resource_ctn_tle[i].setTextPosition(BOTTOM);
                        
                        cont_resource_data.addComponent(BoxLayout.encloseY(lbl1_res_Icon, spl_res_desc));
                    }
                    
                    
                    //lbl_resource[i] = new Label();
                    //lbl_resource[i].setText(str_resource_ttle);
                    //lbl_resource[i].setName(str_resource_ttle);
                    
                    SpanLabel spl_res_ttl = new SpanLabel(str_resource_ttle);
                                spl_res_ttl.getStyle().setBgColor(0x000000); 
                                spl_res_ttl.getStyle().setFgColor(0xffffff);
                                spl_res_ttl.getStyle().setPadding(0, 15, 0, 0);
                                //spl_deparment.getStyle().setMargin(0, 0, 130, 130);
                                spl_res_ttl.getStyle().setBgTransparency(0, false);
                                spl_res_ttl.getStyle().setFont(font_HPSimplified);
                                spl_res_ttl.addPointerPressedListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        //Log.p(leader.get(2)+" label pressed.", 1);
                                        //SelectedDepartment depselector = new SelectedDepartment();
                                        //depselector.showMainScreen();
                                        //showDepartment();
                                    }
                                });
                    
                    SpanLabel spnlbl1_res_desc = new SpanLabel();
                    spnlbl1_res_desc.setText(str_resource_desc);
                    spnlbl1_res_desc.getTextAllStyles().setAlignment(LEFT);
                    spnlbl1_res_desc.getTextAllStyles().setFont(font_HPSimplifiedLight);
                    spnlbl1_res_desc.getTextAllStyles().setMargin(0, 0, 0, 0);
                    spnlbl1_res_desc.getTextAllStyles().setPadding(0, 0, 0, 0);
                    spnlbl1_res_desc.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                    spnlbl1_res_desc.getStyle().setPadding(0, 0, 0, 0);
                    spnlbl1_res_desc.getStyle().setMargin(0, 20, 0, 0);
                    
                    cnt_resource.add(BoxLayout.encloseY(spl_res_ttl, spnlbl1_res_desc, cont_resource_data)); //lbl_resource[i]
                }
                
                
                //["Financial Statements", "Quarter~1st|February 3rd~Staff Training~90, 000~Treasury~Budgetary Allocation|February 20th~Staff Training~90, 000~Treasury~Budgetary Allocation", ""]
                
                
                
                
                //#####################################################################
                //
                //              STATEMENTS STUFF START
                //
                //#####################################################################
                
                str_ttl_statements = Storage.getInstance().readObject("ttl_statements").toString();
                Label lbl0_statements = new Label(str_ttl_statements);
                    lbl0_statements.getAllStyles().setPadding(0, 0, 0, 0);
                    lbl0_statements.getAllStyles().setMargin(20, 0, 0, 0);
                    lbl0_statements.getAllStyles().setAlignment(LEFT);
                    lbl0_statements.getStyle().setFont(font_HPSimplified);
                    
                str_cnt_statements = Storage.getInstance().readObject("cnt_statements").toString();  //2017|1st Quarter|February 3rd~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation$1st Quarter|February 26th~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation
                    str_needle   = "$";
                    str_haystack = str_cnt_statements;
                    int_lastIndex = 0;
                    int_count = 0;

                    while (int_lastIndex != -1) 
                    {
                        int_lastIndex = str_haystack.indexOf(str_needle, int_lastIndex);

                        if (int_lastIndex != -1) 
                        {
                            int_count++;
                            int_lastIndex += str_needle.length();
                        }
                    }
                    //int offset = int_count+1;
                    Storage.getInstance().writeObject("no_statements", offset);
                    System.out.println("No. of statements: ->"+offset+"<");
                    
                
                int_no_statements = Integer.parseInt(Storage.getInstance().readObject("no_statements").toString());
                lbl_statements = new Label[int_no_statements]; 
                splbl_statements = new SpanLabel[int_no_statements];
                
                cnt_statements = new Container(new GridLayout(int_no_statements, 1)); 
                for (i = 0; i < int_no_statements; i++) 
                {
                    str_statements_data = StringUtil.tokenize(str_cnt_statements, "$").get(i).trim(); System.out.println("Statments content: "+str_statements_data);//2017|1st Quarter|February 3rd~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation
                    str_statements_ttle = StringUtil.tokenize(str_statements_data, "|").get(0).trim(); //2017
                    
                    str_statements_desc = StringUtil.tokenize(str_statements_data, "|").get(1).trim(); //1st Quarter
                    str_statements_cont = StringUtil.tokenize(str_statements_data, "|").get(2).trim(); //February 3rd~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation
                    
                    str_needle   = "^";
                    str_haystack = str_statements_cont;
                    int_lastIndex = 0;
                    int_count     = 0;

                    while (int_lastIndex != -1) 
                    {
                        int_lastIndex = str_haystack.indexOf(str_needle, int_lastIndex);
                        if (int_lastIndex != -1) 
                        {
                            int_count++;
                            int_lastIndex += str_needle.length();
                        }
                    }
                    int offset2 = int_count+1;
                    Storage.getInstance().writeObject("no_statements_ctn", offset2);
                    System.out.println("No. of statements Contents: ->"+offset2+"<");

                    int_no_statements_ctn = Integer.parseInt(Storage.getInstance().readObject("no_statements_ctn").toString());
                    //lbl_ctn_statements = new Label[int_no_statements_ctn]; 
                    lbl_statements_ctn_tle = new Label[int_no_statements_ctn];
                    lbl_statements_ctn_img = new Label[int_no_statements_ctn];
                    lbl_statements_ctn_dsc = new Label[int_no_statements_ctn];
                    splbl_ctn_statements_desc = new SpanLabel[int_no_resource_ctn];

                    cont_statements_data = new Container(); 
                    GridLayout lay_grid_fin = new GridLayout(int_no_statements_ctn, 3);
                    lay_grid_fin.setAutoFit(true);
                    cont_statements_data.setLayout(lay_grid_fin);
                    cont_statements_data.getStyle().setPadding(0, 0, 0, 0);
                    cont_statements_data.getStyle().setMargin(0, 0, 0, 0);
                    for (j = 0; j < int_no_statements_ctn; j++) 
                    {
                        str_statements_cnt_data = StringUtil.tokenize(str_statements_cont, "^").get(j).trim();    //February 3rd~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation
                        str_statements_ctn_date = StringUtil.tokenize(str_statements_cnt_data, "~").get(0).trim(); //February 3rd
                        str_statements_ctn_des = StringUtil.tokenize(str_statements_cnt_data, "~").get(1).trim(); //Staff Training
                        str_statements_ctn_amnt = StringUtil.tokenize(str_statements_cnt_data, "~").get(2).trim(); //90000
                        
                        /*try
                        {
                         img_RESOURCEplaceholder = Image.createImage("/adventist_icon.jpg");
                         eImg = EncodedImage.createFromImage(img_RESOURCEplaceholder, true);
                         img_resource =  URLImage.createToStorage(eImg, str_statements_ctn_img, "http://"+Commonz.host+"/admin/content/Images/"+str_statements_ctn_img, URLImage.RESIZE_SCALE);
                         //img_person = EncodedImage.createImage(is).scaledHeight(displayWidth/4);
                         System.out.println("Downloading statements Image: "+"http://"+Commonz.host+"/admin/content/Images/"+str_statements_ctn_img);
                        }
                        catch (IOException ioexception)
                        {
                         ioexception.printStackTrace();
                        }*/
                        
                        /*lbl_resource_ctn_tle[i] = new Label();
                        lbl_resource_ctn_tle[i].setText(str_resource_ctn_tle);
                        lbl_resource_ctn_tle[i].setName(str_resource_ctn_tle);*/
                        
                        /*Label lbl1_fin_Icon = new Label();
                                lbl1_fin_Icon.setIcon(img_resource.scaledHeight(displayWidth/4));
                                lbl1_fin_Icon.getAllStyles().setAlignment(CENTER);*/
                                
                        SpanLabel spl_fin_date = new SpanLabel();
                                spl_fin_date.setText(str_statements_ctn_date+" - ");
                                spl_fin_date.getTextAllStyles().setAlignment(LEFT);
                                spl_fin_date.getTextAllStyles().setFont(font_HPSimplifiedLight);
                                spl_fin_date.getTextAllStyles().setMargin(0, 0, 0, 0);
                                spl_fin_date.getTextAllStyles().setPadding(0, 0, 0, 0);
                                spl_fin_date.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                spl_fin_date.getStyle().setPadding(0, 0, 0, 0);
                                spl_fin_date.getStyle().setMargin(0, 0, 0, 0);
                                
                                
                                
                        SpanLabel spl_fin_des = new SpanLabel();
                                  spl_fin_des.setText(str_statements_ctn_des+" - ");
                                  spl_fin_des.getTextAllStyles().setAlignment(LEFT);
                                  spl_fin_des.getTextAllStyles().setFont(font_HPSimplifiedLight);
                                  spl_fin_des.getTextAllStyles().setMargin(0, 0, 0, 0);
                                  spl_fin_des.getTextAllStyles().setPadding(0, 0, 0, 0);
                                  spl_fin_des.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                  spl_fin_des.getStyle().setPadding(0, 0, 0, 0);
                                  spl_fin_des.getStyle().setMargin(0, 0, 0, 0);
                                  
                                  
                        SpanLabel spl_fin_amnt = new SpanLabel();
                                  spl_fin_amnt.setText(str_statements_ctn_amnt.replace('\n', ' '));
                                  //spl_fin_amnt.getTextAllStyles().setAlignment(LEFT);
                                  spl_fin_amnt.getTextAllStyles().setFont(font_HPSimplifiedLight);
                                  spl_fin_amnt.getTextAllStyles().setMargin(0, 0, 0, 0);
                                  spl_fin_amnt.getTextAllStyles().setPadding(0, 0, 0, 0);
                                  spl_fin_amnt.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                  spl_fin_amnt.getStyle().setPadding(0, 0, 0, 0);
                                  spl_fin_amnt.getStyle().setMargin(0, 0, 0, 0);
                                  
                        Label lbl_amnt = new Label();
                                  lbl_amnt.setText(str_statements_ctn_amnt.replace('\n', ' '));
                                  //spl_fin_amnt.getTextAllStyles().setAlignment(LEFT);
                                  lbl_amnt.getStyle().setFont(font_HPSimplifiedLight);
                                  lbl_amnt.getStyle().setMargin(0, 0, 0, 0);
                                  lbl_amnt.getStyle().setPadding(0, 0, 0, 0);
                                  lbl_amnt.getStyle().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                  lbl_amnt.getStyle().setPadding(0, 0, 0, 0);
                                  lbl_amnt.getStyle().setMargin(0, 0, 0, 0);
                        
                                  
//                        SpanLabel spnlbl1_res_desc = new SpanLabel();
//                                  spnlbl1_res_desc.setText(str_resource_desc);
//                                  spnlbl1_res_desc.getTextAllStyles().setAlignment(LEFT);
//                                  spnlbl1_res_desc.getTextAllStyles().setFont(font_HPSimplifiedLight);
//                                  spnlbl1_res_desc.getTextAllStyles().setMargin(0, 0, 0, 0);
//                                  spnlbl1_res_desc.getTextAllStyles().setPadding(0, 0, 0, 0);
//                                  spnlbl1_res_desc.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
//                                  spnlbl1_res_desc.getStyle().setPadding(0, 0, 0, 0);
//                                  spnlbl1_res_desc.getStyle().setMargin(0, 20, 0, 0);
                                
                        
                        //lbl_resource_ctn_tle[i] = new Label();
                        //lbl_resource_ctn_tle[i].setIcon(img_resource);
                        //lbl_resource_ctn_tle[i].setName(str_resource_ctn_tle);
                        //lbl_resource_ctn_tle[i].setText(str_resource_ctn_tle);
                        //lbl_resource_ctn_tle[i].setTextPosition(BOTTOM);
                        
                        cont_statements_data.addComponent(BoxLayout.encloseX(spl_fin_date, spl_fin_des, lbl_amnt)); //lbl1_fin_Icon, 
                    }
                    
                    SpanLabel spl_sta_ttl = new SpanLabel(str_statements_ttle);
                                spl_sta_ttl.getStyle().setBgColor(0x000000); 
                                spl_sta_ttl.getStyle().setFgColor(0xffffff);
                                spl_sta_ttl.getStyle().setPadding(0, 15, 0, 0);
                                spl_sta_ttl.getStyle().setBgTransparency(0, false);
                                spl_sta_ttl.getStyle().setFont(font_HPSimplified);
                                spl_sta_ttl.addPointerPressedListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        //Log.p(leader.get(2)+" label pressed.", 1);
                                        //SelectedDepartment depselector = new SelectedDepartment();
                                        //depselector.showMainScreen();
                                        //showDepartment();
                                    }
                                });
                    
                    SpanLabel spnlbl1_sta_desc = new SpanLabel();
                    spnlbl1_sta_desc.setText(str_statements_desc);
                    spnlbl1_sta_desc.getTextAllStyles().setAlignment(LEFT);
                    spnlbl1_sta_desc.getTextAllStyles().setFont(font_HPSimplified);
                    spnlbl1_sta_desc.getTextAllStyles().setMargin(0, 0, 0, 0);
                    spnlbl1_sta_desc.getTextAllStyles().setPadding(0, 0, 0, 0);
                    spnlbl1_sta_desc.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                    spnlbl1_sta_desc.getStyle().setPadding(0, 0, 0, 0);
                    spnlbl1_sta_desc.getStyle().setMargin(0, 20, 0, 0);
                    
                    cnt_statements.add(BoxLayout.encloseY(spnlbl1_sta_desc, cont_statements_data)); //spl_sta_ttl, 
                }
                
                
                //#####################################################################
                //
                //               CALENDAR STUFF
                //
                //####################################################################
                
                
                str_ttl_calendars = Storage.getInstance().readObject("ttl_calendars").toString();
                Label lbl0_calendars = new Label(str_ttl_calendars);
                    lbl0_calendars.getAllStyles().setPadding(0, 0, 0, 0);
                    lbl0_calendars.getAllStyles().setMargin(20, 0, 0, 0);
                    lbl0_calendars.getAllStyles().setAlignment(LEFT);
                    lbl0_calendars.getStyle().setFont(font_HPSimplified);
                    
                str_cnt_calendars = Storage.getInstance().readObject("cnt_calendars").toString();  //2017|1st Quarter|February 3rd~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation$1st Quarter|February 26th~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation
                    str_needle   = "$";
                    str_haystack = str_cnt_calendars;
                    int_lastIndex = 0;
                    int_count = 0;

                    while (int_lastIndex != -1) 
                    {
                        int_lastIndex = str_haystack.indexOf(str_needle, int_lastIndex);

                        if (int_lastIndex != -1) 
                        {
                            int_count++;
                            int_lastIndex += str_needle.length();
                        }
                    }
                    //int offset = int_count+1;
                    Storage.getInstance().writeObject("no_calendars", offset);
                    System.out.println("No. of calendars: ->"+offset+"<");
                    
                
                int_no_calendars = Integer.parseInt(Storage.getInstance().readObject("no_calendars").toString());
                lbl_calendars = new Label[int_no_calendars]; 
                splbl_calendars = new SpanLabel[int_no_calendars];
                
                cnt_calendars = new Container(new GridLayout(int_no_calendars, 1)); 
                for (i = 0; i < int_no_calendars; i++) 
                {
                    str_calendars_data = StringUtil.tokenize(str_cnt_calendars, "$").get(i).trim(); System.out.println("Calendars content: "+str_calendars_data);//2017|1st Quarter|February 3rd~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation
                    str_calendars_ttle = StringUtil.tokenize(str_calendars_data, "|").get(0).trim(); //2017
                    
                    str_calendars_desc = StringUtil.tokenize(str_calendars_data, "|").get(1).trim(); //1st Quarter
                    str_calendars_cont = StringUtil.tokenize(str_calendars_data, "|").get(2).trim(); //February 3rd~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation
                    
                    str_needle   = "^";
                    str_haystack = str_calendars_cont;
                    int_lastIndex = 0;
                    int_count     = 0;

                    while (int_lastIndex != -1) 
                    {
                        int_lastIndex = str_haystack.indexOf(str_needle, int_lastIndex);
                        if (int_lastIndex != -1) 
                        {
                            int_count++;
                            int_lastIndex += str_needle.length();
                        }
                    }
                    int offset2 = int_count+1;
                    Storage.getInstance().writeObject("no_calendars_ctn", offset2);
                    System.out.println("No. of calendars Contents: ->"+offset2+"<");

                    int_no_calendars_ctn = Integer.parseInt(Storage.getInstance().readObject("no_calendars_ctn").toString());
                    //lbl_ctn_calendars = new Label[int_no_calendars_ctn]; 
                    lbl_calendars_ctn_tle = new Label[int_no_calendars_ctn];
                    lbl_calendars_ctn_img = new Label[int_no_calendars_ctn];
                    lbl_calendars_ctn_dsc = new Label[int_no_calendars_ctn];
                    splbl_ctn_calendars_desc = new SpanLabel[int_no_resource_ctn];

                    cont_calendars_data = new Container(); 
                    GridLayout lay_grid_fin = new GridLayout(int_no_calendars_ctn, 3);
                    lay_grid_fin.setAutoFit(true);
                    cont_calendars_data.setLayout(lay_grid_fin);
                    cont_calendars_data.getStyle().setPadding(0, 0, 0, 0);
                    cont_calendars_data.getStyle().setMargin(0, 0, 0, 0);
                    for (j = 0; j < int_no_calendars_ctn; j++) 
                    {
                        str_calendars_cnt_data = StringUtil.tokenize(str_calendars_cont, "^").get(j).trim();    //February 3rd~Staff Training~90000~Treasury~Budgetary Allocation^February 20th~Staff Training~90000~Treasury~Budgetary Allocation
                        str_calendars_ctn_date = StringUtil.tokenize(str_calendars_cnt_data, "~").get(0).trim(); //February 3rd
                        str_calendars_ctn_desc = StringUtil.tokenize(str_calendars_cnt_data, "~").get(1).trim(); //Staff Training
                        str_calendars_ctn_loca = StringUtil.tokenize(str_calendars_cnt_data, "~").get(2).trim(); //90000
                        str_calendars_ctn_time = StringUtil.tokenize(str_calendars_cnt_data, "~").get(3).trim();
                        
                                
                        SpanLabel spl_fin_date = new SpanLabel();
                                spl_fin_date.setText(str_calendars_ctn_date+" - ");
                                spl_fin_date.getTextAllStyles().setAlignment(LEFT);
                                spl_fin_date.getTextAllStyles().setFont(font_HPSimplifiedLight);
                                spl_fin_date.getTextAllStyles().setMargin(0, 0, 0, 0);
                                spl_fin_date.getTextAllStyles().setPadding(0, 0, 0, 0);
                                spl_fin_date.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                spl_fin_date.getStyle().setPadding(0, 0, 0, 0);
                                spl_fin_date.getStyle().setMargin(0, 0, 0, 0);
                                
                                
                                
                        SpanLabel spl_fin_des = new SpanLabel();
                                  spl_fin_des.setText(str_calendars_ctn_desc+" - ");
                                  spl_fin_des.getTextAllStyles().setAlignment(LEFT);
                                  spl_fin_des.getTextAllStyles().setFont(font_HPSimplifiedLight);
                                  spl_fin_des.getTextAllStyles().setMargin(0, 0, 0, 0);
                                  spl_fin_des.getTextAllStyles().setPadding(0, 0, 0, 0);
                                  spl_fin_des.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                  spl_fin_des.getStyle().setPadding(0, 0, 0, 0);
                                  spl_fin_des.getStyle().setMargin(0, 0, 0, 0);
                                  
                                  
                        SpanLabel spl_fin_amnt = new SpanLabel();
                                  spl_fin_amnt.setText(str_calendars_ctn_loca.replace('\n', ' '));
                                  //spl_fin_amnt.getTextAllStyles().setAlignment(LEFT);
                                  spl_fin_amnt.getTextAllStyles().setFont(font_HPSimplifiedLight);
                                  spl_fin_amnt.getTextAllStyles().setMargin(0, 0, 0, 0);
                                  spl_fin_amnt.getTextAllStyles().setPadding(0, 0, 0, 0);
                                  spl_fin_amnt.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                  spl_fin_amnt.getStyle().setPadding(0, 0, 0, 0);
                                  spl_fin_amnt.getStyle().setMargin(0, 0, 0, 0);
                                  
                        Label lbl_loca = new Label();
                                  lbl_loca.setText(str_calendars_ctn_loca+" - ".replace('\n', ' '));
                                  //spl_fin_amnt.getTextAllStyles().setAlignment(LEFT);
                                  lbl_loca.getStyle().setFont(font_HPSimplifiedLight);
                                  lbl_loca.getStyle().setMargin(0, 0, 0, 0);
                                  lbl_loca.getStyle().setPadding(0, 0, 0, 0);
                                  lbl_loca.getStyle().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                  lbl_loca.getStyle().setPadding(0, 0, 0, 0);
                                  lbl_loca.getStyle().setMargin(0, 0, 0, 0);
                                  
                        Label lbl_time = new Label();
                                  lbl_time.setText(str_calendars_ctn_time.replace('\n', ' '));
                                  //spl_fin_amnt.getTextAllStyles().setAlignment(LEFT);
                                  lbl_time.getStyle().setFont(font_HPSimplifiedLight);
                                  lbl_time.getStyle().setMargin(0, 0, 0, 0);
                                  lbl_time.getStyle().setPadding(0, 0, 0, 0);
                                  lbl_time.getStyle().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                                  lbl_time.getStyle().setPadding(0, 0, 0, 0);
                                  lbl_time.getStyle().setMargin(0, 0, 0, 0);
                        
                                  
//                        SpanLabel spnlbl1_res_desc = new SpanLabel();
//                                  spnlbl1_res_desc.setText(str_resource_desc);
//                                  spnlbl1_res_desc.getTextAllStyles().setAlignment(LEFT);
//                                  spnlbl1_res_desc.getTextAllStyles().setFont(font_HPSimplifiedLight);
//                                  spnlbl1_res_desc.getTextAllStyles().setMargin(0, 0, 0, 0);
//                                  spnlbl1_res_desc.getTextAllStyles().setPadding(0, 0, 0, 0);
//                                  spnlbl1_res_desc.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
//                                  spnlbl1_res_desc.getStyle().setPadding(0, 0, 0, 0);
//                                  spnlbl1_res_desc.getStyle().setMargin(0, 20, 0, 0);
                                
                        
                        //lbl_resource_ctn_tle[i] = new Label();
                        //lbl_resource_ctn_tle[i].setIcon(img_resource);
                        //lbl_resource_ctn_tle[i].setName(str_resource_ctn_tle);
                        //lbl_resource_ctn_tle[i].setText(str_resource_ctn_tle);
                        //lbl_resource_ctn_tle[i].setTextPosition(BOTTOM);
                        
                        cont_calendars_data.addComponent(BoxLayout.encloseX(spl_fin_date, spl_fin_des, lbl_loca, lbl_time)); //lbl1_fin_Icon, 
                    }
                    
                    SpanLabel spl_sta_ttl = new SpanLabel(str_calendars_ttle);
                                spl_sta_ttl.getStyle().setBgColor(0x000000); 
                                spl_sta_ttl.getStyle().setFgColor(0xffffff);
                                spl_sta_ttl.getStyle().setPadding(0, 15, 0, 0);
                                spl_sta_ttl.getStyle().setBgTransparency(0, false);
                                spl_sta_ttl.getStyle().setFont(font_HPSimplified);
                                spl_sta_ttl.addPointerPressedListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        //Log.p(leader.get(2)+" label pressed.", 1);
                                        //SelectedDepartment depselector = new SelectedDepartment();
                                        //depselector.showMainScreen();
                                        //showDepartment();
                                    }
                                });
                    
                    SpanLabel spnlbl1_sta_desc = new SpanLabel();
                    spnlbl1_sta_desc.setText(str_calendars_desc);
                    spnlbl1_sta_desc.getTextAllStyles().setAlignment(LEFT);
                    spnlbl1_sta_desc.getTextAllStyles().setFont(font_HPSimplified);
                    spnlbl1_sta_desc.getTextAllStyles().setMargin(0, 0, 0, 0);
                    spnlbl1_sta_desc.getTextAllStyles().setPadding(0, 0, 0, 0);
                    spnlbl1_sta_desc.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
                    spnlbl1_sta_desc.getStyle().setPadding(0, 0, 0, 0);
                    spnlbl1_sta_desc.getStyle().setMargin(0, 20, 0, 0);
                    
                    cnt_calendars.add(BoxLayout.encloseY(spnlbl1_sta_desc, cont_calendars_data)); //spl_sta_ttl, 
                }
        
                cnt_body.add(GridLayout.encloseIn(2, cnt_leaderL, FlowLayout.encloseLeftMiddle(cnt_leaderR)));
                //cnt_body.add(lbl0_description);
                cnt_body.add(spnlbl1_description); //cnt_description 
                cnt_body.add(lbl_staff);
                cnt_body.add(cnt_staff);
                cnt_body.add(lbl0_mission);
                cnt_body.add(spnlbl1_mission); 
                cnt_body.add(lbl0_activities);
                cnt_body.add(spnlbl1_activities); 
                cnt_body.add(lbl0_resourses);
                cnt_body.add(cnt_resource);
                cnt_body.add(lbl0_statements);
                cnt_body.add(cnt_statements);
                cnt_body.add(lbl0_calendars);
                cnt_body.add(cnt_calendars);
                //spnlbl1_mission
                //cnt_body.add(GridLayout.encloseIn(1, lbl0_mission, spnlbl1_mission).setWidth(width));
                // cnt_body.add(BoxLayout.encloseX(spnlbl1_mission));
                
       
        
      //lbl1_leader.setIcon(Image.createImage(in));
      
      //cnt_leader.
      
      //FOOTER
      /*
      cnt_nav = new Container(new FlowLayout(CENTER, BOTTOM));
        //cnt_nav.getAllStyles().setAlignment(CENTER);
        cnt_nav.setScrollableX(true);
            btn_bible = new Button("Bible", theme.getImage("bible.png"));
                btn_bible.setTextPosition(BOTTOM);
                btn_bible.setUnselectedStyle(sty_lg);
                btn_bible.setSelectedStyle(sty_lg);
            btn_hymnal = new Button("Hymnal",  theme.getImage("hymnal.png"));
                btn_hymnal.setTextPosition(BOTTOM);
                btn_hymnal.setUnselectedStyle(sty_lg);
                btn_hymnal.setSelectedStyle(sty_lg);
            btn_lesson = new Button("Lesson",  theme.getImage("lesson.png"));
                btn_lesson.setTextPosition(BOTTOM);
                btn_lesson.setUnselectedStyle(sty_lg);
                btn_lesson.setSelectedStyle(sty_lg);
            btn_bulletin = new Button("Bulletin",  theme.getImage("bulletin.png"));
                btn_bulletin.setTextPosition(BOTTOM);
                btn_bulletin.setUnselectedStyle(sty_lg);
                btn_bulletin.setSelectedStyle(sty_lg);
      cnt_nav.add(btn_bible).add(btn_hymnal).add(btn_lesson).add(btn_bulletin);
      */
      String str_department = Storage.getInstance().readObject("department").toString();
      
      
        MainMenu.cont_header.remove();
        MainMenu.lbl_header.setText(str_department);
        MainMenu.lbl_logo.remove();
        
        Style sty_lg_banner = new Style();
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
        
        fm_main.addComponent(BorderLayout.NORTH, BoxLayout.encloseY(MainMenu.cont_header, cnt_titlebar));
        fm_main.addComponent(BorderLayout.CENTER, cnt_body);
        //fm_main.addComponent(BorderLayout.SOUTH, cnt_nav);
      
        /*
        cmd_back = new Command("Back")
        {
         @Override
         public void actionPerformed(ActionEvent ev) 
         {
          
         }
        };
        fm_home.addCommand(cmd_back);
        fm_home.setBackCommand(cmd_back);
        */
        
      fm_main.show();
   }
    
    
    
    public void showProfileDlg()
    {
        System.out.println("Showing edit profile dialog");
        
        //String str_json_read = (String) Storage.getInstance().readObject("userdetails.json");
        //byte[] dataa = str_json_read.getBytes();
        
        
        String str_json_read = (String) Storage.getInstance().readObject("login.json");
        byte[] dataa = str_json_read.getBytes();
        
        Object rawString = Storage.getInstance().readObject("login.json");  
        /*try 
        {
            JSONObject j = new JSONObject(rawString.toString());
            JSONObject obj = (JSONObject) j.get("data");
            String dataFromFile = (String) j.get("data").toString();
        }
        catch (JSONException e) 
        {
            e.printStackTrace();
        }*/
        
        JSONParser json = new JSONParser();
        //try(Reader reader = new InputStreamReader(Display.getInstance().getResourceAsStream(getClass(), "/anapioficeandfire.json"), "UTF-8"))
        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
        {
            Map<String, Object> map_content = json.parseJSON(is_content); //System.out.println("Userdetails.json map_content: "+map_content);
            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root"); //System.out.println("Userdetails.json obj_content: "+obj_content);
            
            for(Map<String, Object> obj : obj_content) 
            {              
                if(str_users_title == null || str_users_title.length() == 0){}else{}
                
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
                
                /*
                java.util.List<String> titles = (java.util.List<String>)obj.get("titles");
                if(str_resptext == null || str_resptext.length() == 0) 
                {
                    java.util.List<String> aliases = (java.util.List<String>)obj.get("aliases");
                    if(aliases != null && aliases.size() > 0) 
                    {
                        str_resptext = aliases.get(0);
                    }
                }
                
                MultiButton mb = new MultiButton(str_resptext);
                if(titles != null && titles.size() > 0) 
                {
                    mb.setTextLine2(titles.get(0));
                }
                mb.addActionListener((e) -> Display.getInstance().execute(str_respcode));
                */
            }
        } 
        catch(IOException err) 
        {
                //Log.e(err);
        }
        //str_users_userid = (String) Connect.storage.readObject("usersuserid");
        //str_users_title = (String) Connect.storage.readObject("userstitle");
        //str_users_firstname = (String) Connect.storage.readObject("usersfirstname");
        //str_users_lastname = (String) Connect.storage.readObject("userslastname");
        //str_users_birth_date = (String) Connect.storage.readObject("usersbirth_date");
        //str_users_ppno = (String) Connect.storage.readObject("usersppno");
        //str_users_idno = (String) Connect.storage.readObject("usersidno");
        //str_users_gender = (String) Connect.storage.readObject("usersgender");
        //str_users_country = (String) Connect.storage.readObject("userscountry");
        //str_users_city = (String) Connect.storage.readObject("userscity");
        //str_users_industry = (String) Connect.storage.readObject("usersindustry");
        //str_users_occupation = (String) Connect.storage.readObject("usersoccupation");
        //str_users_organisation = (String) Connect.storage.readObject("loginstatus");
        //str_users_department = (String) Connect.storage.readObject("usersdepartment");
        //str_users_cellphone = (String) Connect.storage.readObject("userscellphone");
        //str_users_phone = (String) Connect.storage.readObject("usersphone");
        //str_users_email_address = (String) Connect.storage.readObject("usersemail_address");
        //str_users_physical_address = (String) Connect.storage.readObject("usersphysical_address");
        //str_users_longitude = (String) Connect.storage.readObject("userslongitude");
        //str_users_latitude = (String) Connect.storage.readObject("userslatitude");
        //str_users_postal_address = (String) Connect.storage.readObject("userspostal_address");
        //str_users_approvedby = (String) Connect.storage.readObject("usersapprovedby");
        //str_users_emergency_contact = (String) Connect.storage.readObject("usersemergency_contact");
        //str_users_emergency_contact_phone = (String) Connect.storage.readObject("usersemergency_contact_phone");
        //str_users_dietary_need = (String) Connect.storage.readObject("usersdietary_need");
        //str_users_food_allergies = (String) Connect.storage.readObject("usersfood_allergies");
        //str_users_language = (String) Connect.storage.readObject("userslanguage");
        //str_users_role = (String) Connect.storage.readObject("usersrole");
        //str_users_level = (String) Connect.storage.readObject("userslevel");
        //str_users_adminid = (String) Connect.storage.readObject("usersadminid");
        //str_users_admincellphone = (String) Connect.storage.readObject("usersadmincellphone");
        //str_users_status = (String) Connect.storage.readObject("usersactive");
                                                  
                            imv = new ImageViewer(img_avatar);
                                imv.setZoom((float) 1);
                                imv.getStyle().setBgColor(0x000000, false); 
        
                            cnt_avatar = new Container(new BorderLayout());
                                cnt_avatar.add(BorderLayout.NORTH, imv); //new Label(img_avatar)
                                cnt_avatar.add(BorderLayout.SOUTH, new Button("Change Photo"));
                                
                                TextField txtf_bday = new TextField(str_users_birth_date);
                                txtf_bday.addPointerPressedListener(new ActionListener() 
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) 
                                    {
                                        //Log.p("Preparing to show calendar.", 1);
                                        storage.writeObject("transaction", "set_bdate");
                                        showDaySelector();             
                                    }
                                });
                                
                            cnt_basicData =  new Container(new GridLayout(8, 2));
                                cnt_basicData.add(new Label("Title"));          cnt_basicData.add(new TextField(str_users_title));
                                cnt_basicData.add(new Label("First Name"));     cnt_basicData.add(new TextField(str_users_firstname));
                                cnt_basicData.add(new Label("Family Name"));    cnt_basicData.add(new TextField(str_users_lastname));
                                cnt_basicData.add(new Label("Gender"));         rbmale = new RadioButton("Male"); rbfemale = new RadioButton("Female"); 
                                rbgGender = new ButtonGroup(rbmale, rbfemale); rbmale.setSelected(true); rbfemale.setSelected(true); cnt_basicData.add(BoxLayout.encloseX(rbmale, rbfemale));
                                if((str_users_gender).equalsIgnoreCase("Male"))
                                { 
                                    rbgGender.setSelected(rbmale); /*rbmale.setSelected(true); rbfemale.setSelected(false);*/ //cnt_basicData.revalidate(); fm_home.repaint(); 
                                }
                                else
                                { 
                                    rbgGender.setSelected(rbfemale); /*rbmale.setSelected(false); rbfemale.setSelected(true); */ 
                                }
                                cnt_basicData.add(new Label("Birth Date"));     cnt_basicData.add(txtf_bday); //new Picker()
                                cnt_basicData.add(new Label("Id/PP Number"));   cnt_basicData.add(new TextField(str_users_idno));
                                cnt_basicData.add(new Label("Nationality"));    cnt_basicData.add(new TextField(str_users_nationality));
                                cnt_basicData.add(new Label("Marital Status")); 
                                
                            MultiButton btnm3 = new MultiButton();
                                btnm3.setLinesTogetherMode(true);
                                
                            MultiButton btnm4 = new MultiButton();
                                btnm4.setLinesTogetherMode(true);
                                GenericListCellRenderer renderer2 = new GenericListCellRenderer<>(btnm3, btnm4);
                                
                            ComboBox combo_maritalStatus = new ComboBox();
                                combo_maritalStatus.setRenderingPrototype(new RadioButton(str_users_marital_status));
                                combo_maritalStatus.setRenderer(renderer2);
                                combo_maritalStatus.addItem("Single");
                                combo_maritalStatus.addItem("Married");
                                combo_maritalStatus.addItem("Engaged");
                                combo_maritalStatus.addItem("Widowed");
                                combo_maritalStatus.addItem("Divorced");
                                combo_maritalStatus.addItem("Separated");
                                combo_maritalStatus.getStyle().setBgColor(0x504874);
                                //conCombo.getStyle().setBgSelectionColor(0xff0000);
                                combo_maritalStatus.getStyle().setBgTransparency(100);
                                
                                
                            cnt_basicData.add(combo_maritalStatus); 
                                
                            cnt_basicInfo = new Container(new GridLayout(1, 2));
                                //cnt_basicInfo.getStyle().setBg
                                //cnt_basicInfo.getStyle().setBgTransparency(255);
                                cnt_basicInfo.add(cnt_avatar);
                                cnt_basicInfo.add(cnt_basicData);
                                      
                                
                                lbl_phonePersonal1    = new Label("Phone Personal 1");
                                lbl_phonePersonal2    = new Label("Phone Personal 2");
                                lbl_phoneHome       = new Label("Phone Home");
                                lbl_phoneWork       = new Label("Phone Work");
                                lbl_emailPersonal1    = new Label("Email Personal 1");  
                                lbl_emailPersonal2    = new Label("Email Personal 2");
                                lbl_emailHome       = new Label("Email Home");
                                lbl_emailWork       = new Label("Email Work");
                                
                                txtf_phonePersonal1  = new TextField(str_users_phone); txtf_phonePersonal1.setConstraint(TextField.PHONENUMBER);
                                txtf_phonePersonal2  = new TextField(str_users_phone_alt); txtf_phonePersonal2.setConstraint(TextField.PHONENUMBER);
                                txtf_phoneHome       = new TextField(str_users_phone_home); txtf_phoneHome.setConstraint(TextField.PHONENUMBER);
                                txtf_phoneWork       = new TextField(str_users_phone_work); txtf_phoneWork.setConstraint(TextField.PHONENUMBER);
                                txtf_emailPersonal1  = new TextField(str_users_email_address); txtf_emailPersonal1.setConstraint(TextField.EMAILADDR);
                                txtf_emailPersonal2  = new TextField(str_users_email_alt); txtf_emailPersonal2.setConstraint(TextField.EMAILADDR);
                                txtf_emailHome       = new TextField(str_users_email_home);  txtf_emailHome.setConstraint(TextField.EMAILADDR);
                                txtf_emailWork       = new TextField(str_users_email_work);  txtf_emailWork.setConstraint(TextField.EMAILADDR);
                                
                                lbl_emergencyContact        = new Label("Emergency Name");
                                lbl_emergencyContactName  = new Label("Emergency Phone");
                                lbl_postboxPersonal         = new Label("Post Personal");
                                lbl_postzipPersonal         = new Label("Zip Personal");
                                lbl_postboxHome             = new Label("Post Home");  
                                lbl_postzipHome             = new Label("Zip Home");
                                lbl_postboxWork             = new Label("Post Work");
                                lbl_postzipWork             = new Label("Zip Work");
                                
                                txtf_emergencyContact       = new TextField(str_users_emergency_contact);
                                txtf_emergencyContactName = new TextField(str_users_emergency_contact_phone);
                                txtf_postboxPersonal        = new TextField(str_users_postal_address);
                                txtf_postzipPersonal        = new TextField(str_users_postal_code);
                                txtf_postboxHome            = new TextField(str_users_postal_address_home);
                                txtf_postzipHome            = new TextField(str_users_postal_code_home);
                                txtf_postboxWork            = new TextField(str_users_postal_address_work);
                                txtf_postzipWork            = new TextField(str_users_postal_code_work);
                                                                
                            cnt_contactsCol1 = new Container(new GridLayout(8, 2));
                                cnt_contactsCol1.add(lbl_phonePersonal1);  cnt_contactsCol1.add(txtf_phonePersonal1);         
                                cnt_contactsCol1.add(lbl_phonePersonal2);  cnt_contactsCol1.add(txtf_phonePersonal2);          
                                cnt_contactsCol1.add(lbl_phoneHome);       cnt_contactsCol1.add(txtf_phoneHome);            
                                cnt_contactsCol1.add(lbl_phoneWork);       cnt_contactsCol1.add(txtf_phoneWork); 
                                cnt_contactsCol1.add(lbl_emailPersonal1);  cnt_contactsCol1.add(txtf_emailPersonal1);     
                                cnt_contactsCol1.add(lbl_emailPersonal2);  cnt_contactsCol1.add(txtf_emailPersonal2);      
                                cnt_contactsCol1.add(lbl_emailHome);       cnt_contactsCol1.add(txtf_emailHome);
                                cnt_contactsCol1.add(lbl_emailWork);       cnt_contactsCol1.add(txtf_emailWork);
                                
                            cnt_contactsCol2 = new Container(new GridLayout(8, 2));
                                cnt_contactsCol2.add(lbl_emergencyContact);       cnt_contactsCol2.add(txtf_emergencyContact);         
                                cnt_contactsCol2.add(lbl_emergencyContactName);   cnt_contactsCol2.add(txtf_emergencyContactName);          
                                cnt_contactsCol2.add(lbl_postboxPersonal);        cnt_contactsCol2.add(txtf_postboxPersonal);            
                                cnt_contactsCol2.add(lbl_postzipPersonal);        cnt_contactsCol2.add(txtf_postzipPersonal); 
                                cnt_contactsCol2.add(lbl_postboxHome);            cnt_contactsCol2.add(txtf_postboxHome);     
                                cnt_contactsCol2.add(lbl_postzipHome);            cnt_contactsCol2.add(txtf_postzipHome);      
                                cnt_contactsCol2.add(lbl_postboxWork);            cnt_contactsCol2.add(txtf_postboxWork);      
                                cnt_contactsCol2.add(lbl_postzipWork);            cnt_contactsCol2.add(txtf_postzipWork);      
                                
                        cnt_contactsInfo = new Container(new GridLayout(1, 2));
                                cnt_contactsInfo.setScrollableY(true);
                                cnt_contactsInfo.add(cnt_contactsCol1);
                                cnt_contactsInfo.add(cnt_contactsCol2);
                                                         
                                
                                
                            cnt_locationMap = new Container(new BorderLayout());
                                browse_map = new BrowserComponent(); //TODO: use native map cn1libs - either google or non google or custom
                                browse_map.setURL("http://"+"localhost"+"/ChurchApp/location.php");
                                browse_map.setScrollableY(true);
                                cnt_locationMap.add(BorderLayout.CENTER, browse_map);
                                    cnt_coodinates = new Container(new GridLayout(1, 2)); 
                                        TextField txtf_longitude = new TextField("0.98876443"); txtf_longitude.setHint("Longitude");
                                        TextField txtf_latitude = new TextField("0.78906443"); txtf_longitude.setHint("Latitude");
                                        cnt_coodinates.add(txtf_longitude); cnt_coodinates.add(txtf_latitude);
                                        cnt_locationMap.add(BorderLayout.SOUTH, cnt_coodinates);
                                                       
                                txtf_country = new TextField(str_users_country);
                                txtf_city = new TextField(str_users_city);
                                txtf_county = new TextField(str_users_county);
                                txtf_residenceEstate = new TextField(str_users_residence);
                                txtf_streetRoad = new TextField(str_users_street_road);
                                txtf_courtFlatBuilding = new TextField(str_users_floor_court_flat_building);
                                txtf_doorNumberHouse = new TextField(str_users_door_house_number);
                                
                                lbl_country = new Label("Country/State");
                                lbl_county = new Label("County/Province");
                                lbl_city = new Label("City/Town"); 
                                lbl_town = new Label("District/Region"); 
                                lbl_residenceEstate = new Label("Residence/Estate");
                                lbl_streetCourt = new Label("Street/Court");
                                lbl_houseNumbe = new Label("House Number");
                                lbl_doorNumber = new Label("Door/Gate #");
                                
                            cnt_locationData = new Container(new GridLayout(7, 2));
                                cnt_locationData.add(lbl_country);                cnt_locationData.add(txtf_country);         
                                cnt_locationData.add(lbl_county);                 cnt_locationData.add(txtf_county);          
                                cnt_locationData.add(lbl_city);                   cnt_locationData.add(txtf_city);            
                                cnt_locationData.add(lbl_residenceEstate);        cnt_locationData.add(txtf_residenceEstate); 
                                cnt_locationData.add(lbl_streetCourt);            cnt_locationData.add(txtf_streetRoad);     
                                cnt_locationData.add(lbl_houseNumbe);             cnt_locationData.add(txtf_courtFlatBuilding);      
                                cnt_locationData.add(lbl_doorNumber);             cnt_locationData.add(txtf_doorNumberHouse);      
                                
                        cnt_locationInfo = new Container(new GridLayout(1, 2));
                                cnt_locationInfo.add(cnt_locationMap);
                                cnt_locationInfo.add(cnt_locationData);   
                                                       
                                
                                
                        cnt_location = new Container(new GridLayout(1, 2));
                            //cnt_location.add(cnt_locationMap);
                            //cnt_location.add(cnt_locationInfo);
        
                       GridLayout grid = new GridLayout(8,2); grid.setAutoFit(true);
                       cnt_location = new Container(grid); cnt_location.getStyle().setAlignment(CENTER); BoxLayout.encloseY(new Label("Label1"), new Label("Label2"));
                        lbl_taskName = new Label("Title"); lbl_taskName.getStyle().setAlignment(RIGHT); txtf_taskName = new TextField(""); txtf_taskName.setHint("Title");
                        lbl_taskDescription = new Label("Description"); lbl_taskDescription.getStyle().setAlignment(RIGHT); txtf_taskDescription = new TextField(""); txtf_taskDescription.setHint("Description");
                        lbl_taskBegining = new Label("Task Begins"); lbl_taskBegining.getStyle().setAlignment(RIGHT); cldr_begin = new Calendar(); txtf_taskBegining = new TextField(new Date(cldr_begin.getSelectedDay()).toString());
                        lbl_taskEnding = new Label("Task Ends"); lbl_taskEnding.getStyle().setAlignment(RIGHT); cldr_end = new Calendar(); txtf_taskEnding = new TextField(new Date(cldr_end.getSelectedDay()).toString());
                        lbl_allDay = new Label("All Day"); lbl_allDay.getStyle().setAlignment(RIGHT); rb1 = new RadioButton("Yes"); rb2 = new RadioButton("No"); rb2.setSelected(true); rbg_allDay = new ButtonGroup(rb1, rb2);
                        lbl_shareTask = new Label("Share Task");  lbl_shareTask.getStyle().setAlignment(RIGHT);
                        
                        //NewRadioButtonRenderer renderer = new NewRadioButtonRenderer();
                        MultiButton btnm = new MultiButton();
                        btnm.setLinesTogetherMode(true);
                        //btnm.setTextLine2("Line 2");

                        MultiButton btnm2 = new MultiButton();
                        btnm2.setLinesTogetherMode(true);
                        //btnm2.setTextLine2("Line 2");

                        renderer = new GenericListCellRenderer<>(btnm, btnm2);

                        //create combobox, set rendering prototype and renderer
                        combo_members = new ComboBox();
                        combo_members.setRenderingPrototype(new RadioButton("Private Task"));
                        combo_members.setRenderer(renderer);

                        //add items to combobox
                        combo_members.addItem("Public Task");
                        combo_members.addItem("Legal");
                        combo_members.addItem("Finance");
                        combo_members.addItem("Field Ops");
                        combo_members.addItem("Secretariate");
                        combo_members.addItem("tommy");

                        //set combobox style
                        combo_members.getStyle().setBgColor(0x504874);
                        //conCombo.getStyle().setBgSelectionColor(0xff0000);
                        combo_members.getStyle().setBgTransparency(100);

                        lbl_recurringTask = new Label("Recurring Task");  lbl_recurringTask.getStyle().setAlignment(RIGHT); Label lbl_recurringEnd = new Label("End");

                        picker_datePicker1 = new Picker();
                            picker_datePicker1.setType(Display.PICKER_TYPE_DATE);
                            picker_datePicker1.setDate(new Date());
                        picker_dateTimePicker1 = new Picker();
                            picker_dateTimePicker1.setType(Display.PICKER_TYPE_DATE_AND_TIME);
                            picker_dateTimePicker1.setDate(new Date());
                        picker_timePicker1 = new Picker();
                            picker_timePicker1.getStyle().setAlignment(CENTER);
                            picker_timePicker1.setType(Display.PICKER_TYPE_TIME);
                            picker_timePicker1.setTime(10 * 60);    
                        picker_stringPicker1 = new Picker();
                            picker_stringPicker1.setType(Display.PICKER_TYPE_STRINGS);
                            picker_stringPicker1.setStrings("A Game of Thrones", "A Clash Of Kings", "A Storm Of Swords", "A Feast For Crows", "A Dance With Dragons", "The Winds of Winter", "A Dream of Spring");
                            picker_stringPicker1.setSelectedString("A Game of Thrones");

                        picker_datePicker2 = new Picker();
                            picker_datePicker2.setType(Display.PICKER_TYPE_DATE);
                            picker_datePicker2.setDate(new Date());
                        picker_dateTimePicker2 = new Picker();
                            picker_dateTimePicker2.setType(Display.PICKER_TYPE_DATE_AND_TIME);
                            picker_dateTimePicker2.setDate(new Date());
                        picker_timePicker2 = new Picker();
                            picker_timePicker2.getStyle().setAlignment(CENTER);
                            picker_timePicker2.setType(Display.PICKER_TYPE_TIME);
                            picker_timePicker2.setTime(10 * 60);    
                        picker_stringPicker2 = new Picker();
                            picker_stringPicker2.setType(Display.PICKER_TYPE_STRINGS);
                            picker_stringPicker2.setStrings("A Game of Thrones", "A Clash Of Kings", "A Storm Of Swords", "A Feast For Crows", "A Dance With Dragons", "The Winds of Winter", "A Dream of Spring");
                            picker_stringPicker2.setSelectedString("A Game of Thrones");

                        dlg_startDate = new Dialog("Start Date and Time");
                            dlg_startDate.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                            dlg_startDate.getStyle().setAlignment(CENTER);
                            dlg_startDate.add(picker_timePicker1);
                            dlg_startDate.add(cldr_begin);
                            //dlg_startDate.add(datePicker);
                            //dlg_startDate.add(dateTimePicker);
                            //dlg_startDate.add(stringPicker);

                            btn_confirmDayPicker1 = new Button("Cancel");
                                btn_confirmDayPicker1.setUIID("Label");
                                btn_confirmDayPicker1.addActionListener(new ActionListener() 
                                {
                                 @Override
                                 public void actionPerformed(ActionEvent evt) 
                                 {
                                  dlg_startDate.dispose();
                                 }
                                });

                            btn_confirmDayPicker2 = new Button("Confirm");
                                btn_confirmDayPicker2.setUIID("Label");
                                btn_confirmDayPicker2.addActionListener(new ActionListener() 
                                {
                                 @Override
                                 public void actionPerformed(ActionEvent evt) 
                                 {
                                  Date date1 = new Date(cldr_begin.getSelectedDay());
                                  Date time1 = new Date(picker_timePicker1.getTime());
                                        //Integer newTime1 = Integer.parseInt(picker_timePicker1);
                                        //String str_newtime1 = picker_timePicker1.getSelectedString();//newTime1.toString();
                                        /*
                                        Integer int_newtime1; String str_newtime1;
                                        int_newtime1 = picker_timePicker1.getTime(); //Integer.parseInt(picker_timePicker1.getTime());
                                        str_newtime1 = int_newtime1.toString(); 
                                        */
                                  txtf_taskBegining.setText(date1.toString());  //+" "+time1.toString() //+" "+picker_timePicker1.getSelectedString()

                                  //Log.p("Timetrax 1 selected: " + new Date(cldr_begin.getSelectedDay()));
                                  //Log.p("Timetrax 2 selected: " +picker_timePicker1.getSelectedString());
                                  dlg_startDate.dispose();
                                 }
                                });

                            cnt_confirmORcancel_1 = new Container(new BorderLayout());
                                    cnt_confirmORcancel_1.add(BorderLayout.WEST, btn_confirmDayPicker1);
                                    cnt_confirmORcancel_1.add(BorderLayout.EAST, btn_confirmDayPicker2);

                            dlg_startDate.add(cnt_confirmORcancel_1);

                            dlg_endDate = new Dialog("End Date and Time");
                                    dlg_endDate.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                                    dlg_endDate.getStyle().setAlignment(CENTER);
                                    dlg_endDate.add(picker_timePicker2);
                                            dlg_endDate.add(cldr_end);
                                            //dlg_startDate.add(datePicker);
                                            //dlg_startDate.add(dateTimePicker);
                                            //dlg_startDate.add(stringPicker); 

                                            btn_confirmDayPicker1 = new Button("Cancel");
                                                btn_confirmDayPicker1.setUIID("Label");
                                                btn_confirmDayPicker1.addActionListener(new ActionListener() 
                                                {
                                                 @Override
                                                 public void actionPerformed(ActionEvent evt) 
                                                 {
                                                  dlg_endDate.dispose();
                                                 }
                                             });

                                            btn_confirmDayPicker2 = new Button("Confirm");
                                                btn_confirmDayPicker2.setUIID("Label");
                                                btn_confirmDayPicker2.addActionListener(new ActionListener() 
                                                {
                                                 @Override
                                                 public void actionPerformed(ActionEvent evt) 
                                                 {
                                                  //Date date2 = new Date(cldr_end.getSelectedDay());
                                                    //txtf_taskBegining.setText(date2.toString()+" "+picker_timePicker2.getSelectedString());
                                                    dlg_endDate.dispose();
                                                 }
                                             });

                                            cnt_confirmORcancel_2 = new Container(new BorderLayout());
                                                    cnt_confirmORcancel_2.add(BorderLayout.WEST, btn_confirmDayPicker1);
                                                    cnt_confirmORcancel_2.add(BorderLayout.EAST, btn_confirmDayPicker2);

                                    dlg_endDate.add(cnt_confirmORcancel_2);
                
                                lbl_dayPicker1 = new Label(img_tasksheduler); 
                                   //lbl_dayPicker1.addPointerPressedListener((e) -> dlg_startDate.show()); //Log.p("You picked: " + new Date(cldr_begin.getSelectedDay()))
                                   lbl_dayPicker1.addPointerReleasedListener(new ActionListener() 
                                   {
                                        @Override
                                        public void actionPerformed(ActionEvent evt) 
                                        {
                                         dlg_startDate.show();
                                         //Log.p("Timetrax 1 selected: " + new Date(cldr_begin.getSelectedDay()));
                                        }
                                    });

                               lbl_dayPicker2 = new Label(img_tasksheduler); //lbl_dayPicker2.addPointerPressedListener((e) -> dlg_endDate.show());

                               btn_dayPicker1 = new Button(img_tasksheduler);
                                   btn_dayPicker1.setUIID("Label");
                                   btn_dayPicker1.addActionListener(new ActionListener() 
                                   {
                                        @Override
                                        public void actionPerformed(ActionEvent evt) 
                                        {
                                           dlg_startDate.show();
                                           //Log.p("Timetrax 1 selected: " + new Date(cldr_begin.getSelectedDay()));  
                                        }
                                    });


                               btn_dayPicker2 = new Button(img_tasksheduler);
                                   btn_dayPicker2.setUIID("Label");
                                   btn_dayPicker2.addActionListener(new ActionListener() 
                                   {
                                        @Override
                                        public void actionPerformed(ActionEvent evt) 
                                        {
                                           dlg_endDate.show();
                                           //Log.p("Timetrax 2 selected: " + new Date(cldr_end.getSelectedDay()));  
                                        }
                                    });
                                   
                               cnt_location.add(lbl_taskName); cnt_location.add(txtf_taskName);
                               cnt_location.add(lbl_taskDescription); cnt_location.add(txtf_taskDescription);
                               cnt_location.add(lbl_taskBegining); cnt_location.add(BoxLayout.encloseX(txtf_taskBegining, btn_dayPicker1)); //lbl_dayPicker1
                               cnt_location.add(lbl_taskEnding); cnt_location.add(BoxLayout.encloseX(txtf_taskEnding, btn_dayPicker2)); //new Label(img_tasksheduler)
                               cnt_location.add(lbl_allDay); cnt_location.add(new Container().add(rb1).add(rb2));//cnt_info.add(rb1).add(rb2);
                               cnt_location.add(lbl_shareTask); cnt_location.add(combo_members); 
                               cnt_location.add(lbl_recurringTask); cnt_location.add(lbl_recurringEnd); //combo_routine             
                
                               
                                //Column1
                                lbl_isaDventist    = new Label("Adventist");  
                                lbl_isKarengatan    = new Label("Karengatan");
                                lbl_membernumber    = new Label("Number");
                                lbl_isregistered       = new Label("Status");
                                lbl_membershipby    = new Label("Member By");
                                lbl_registrdate      = new Label("Registred Date");
                                lbl_transferdate      = new Label("Transfer Date");
                                lbl_lastMembership       = new Label("Last Membership");
                                txtf_isAdventist   = new TextField(); //txtf_isAdventist.setConstraint(TextField.ANY);
                                txtf_isKarengatan   = new TextField(); //txtf_isKarengatan.setConstraint(TextField.ANY);
                                txtf_membernumber   = new TextField(); //txtf_membernumber.setConstraint(TextField.ANY | TextField.UNEDITABLE);
                                txtf_isregistered   = new TextField(); //txtf_isregistered.setConstraint(TextField.ANY | TextField.UNEDITABLE);
                                txtf_membershipby   = new TextField(); //txtf_membershipby.setConstraint(TextField.ANY | TextField.UNEDITABLE);
                                txtf_registrdate    = new TextField();  //txtf_registrdate.setConstraint(TextField.ANY | TextField.UNEDITABLE);
                                txtf_transferdate   = new TextField();  //txtf_transferdate.setConstraint(TextField.ANY | TextField.UNEDITABLE);
                                txtf_lastMembership    = new TextField(); //txtf_lastMembership.setConstraint(TextField.ANY);
                                //Column2
                                lbl_baptismStatus        = new Label("Babtism Status");
                                lbl_baptismPlace    = new Label("Church Babtised");
                                lbl_nearestChurch         = new Label("Nearest Church");
                                lbl_regularChurch         = new Label("Regular Church");
                                lbl_homechurch      = new Label("Home Church");  
                                lbl_prayerCell      = new Label("Prayer Cell");
                                lbl_SabbathScl             = new Label("Sabbath School");
                                lbl_amoWmGroup          = new Label("Group/Club"); //Put Drop Down | Uneditable | Supplied by server added by dept leader
                                txtf_baptismStatus   = new TextField();
                                txtf_baptismPlace  = new TextField();
                                txtf_nearestChurch   = new TextField();
                                txtf_regularChurch   = new TextField();
                                txtf_homechurch      = new TextField();
                                txtf_prayerCell      = new TextField();
                                txtf_SabbathScl      = new TextField();
                                txtf_amoWmAyGroup      = new TextField("WM Group 1"); txtf_amoWmAyGroup.setEditable(false); //setConstraint(TextField.ANY | TextField.UNEDITABLE);
                                //Column3
                                lbl_department1        = new Label("Primary Department"); //TODO: change roll by drop down
                                lbl_department2    = new Label("Secondary Department");
                                lbl_department3         = new Label("Tertiary Department");
                                lbl_department4          = new Label("Propective Department");
                                lbl_spiritualg1         = new Label("Primary S.Gift");
                                lbl_spiritualg2      = new Label("Secondary S.Gift");  
                                lbl_spiritualg3      = new Label("Tertiary S.Gift");
                                lbl_ministry             = new Label("Ministry");
                                txtf_department1    = new TextField("Emergency Contact");
                                txtf_department2  = new TextField("Emergency Contact Name");
                                txtf_department3    = new TextField();
                                txtf_department4    = new TextField();
                                txtf_spiritualg1    = new TextField();
                                txtf_spiritualg2    = new TextField();
                                txtf_spiritualg3    = new TextField();
                                txtf_ministry       = new TextField();
                                                                
                            cnt_membershipCol1 = new Container(new GridLayout(8, 2));
                                cnt_membershipCol1.add(lbl_isaDventist);   cnt_membershipCol1.add(txtf_isAdventist);         
                                cnt_membershipCol1.add(lbl_isKarengatan);  cnt_membershipCol1.add(txtf_isKarengatan);          
                                cnt_membershipCol1.add(lbl_membernumber);  cnt_membershipCol1.add(txtf_membernumber);            
                                cnt_membershipCol1.add(lbl_isregistered);  cnt_membershipCol1.add(txtf_isregistered); 
                                cnt_membershipCol1.add(lbl_membershipby);  cnt_membershipCol1.add(txtf_membershipby);     
                                cnt_membershipCol1.add(lbl_registrdate);   cnt_membershipCol1.add(txtf_registrdate);      
                                cnt_membershipCol1.add(lbl_transferdate);  cnt_membershipCol1.add(txtf_transferdate);
                                cnt_membershipCol1.add(lbl_lastMembership);cnt_membershipCol1.add(txtf_lastMembership);
                                
                            cnt_membershipCol2 = new Container(new GridLayout(8, 2));
                                cnt_membershipCol2.add(lbl_baptismStatus);       cnt_membershipCol2.add(txtf_baptismStatus);         
                                cnt_membershipCol2.add(lbl_baptismPlace);        cnt_membershipCol2.add(txtf_baptismPlace);          
                                cnt_membershipCol2.add(lbl_nearestChurch);       cnt_membershipCol2.add(txtf_nearestChurch);            
                                cnt_membershipCol2.add(lbl_regularChurch);       cnt_membershipCol2.add(txtf_regularChurch); 
                                cnt_membershipCol2.add(lbl_homechurch);          cnt_membershipCol2.add(txtf_homechurch);     
                                cnt_membershipCol2.add(lbl_prayerCell);          cnt_membershipCol2.add(txtf_prayerCell);      
                                cnt_membershipCol2.add(lbl_SabbathScl);          cnt_membershipCol2.add(txtf_SabbathScl); 
                                cnt_membershipCol2.add(lbl_amoWmGroup);          cnt_membershipCol2.add(txtf_amoWmAyGroup); 
                               
                            cnt_membershipCol3 = new Container(new GridLayout(8, 2));
                                cnt_membershipCol3.add(lbl_department1);    cnt_membershipCol3.add(txtf_department1);    
                                cnt_membershipCol3.add(lbl_department2);    cnt_membershipCol3.add(txtf_department2);         
                                cnt_membershipCol3.add(lbl_department3);    cnt_membershipCol3.add(txtf_department3);      
                                cnt_membershipCol3.add(lbl_department4);    cnt_membershipCol3.add(txtf_department4);
                                cnt_membershipCol3.add(lbl_spiritualg1);    cnt_membershipCol3.add(txtf_spiritualg1);
                                cnt_membershipCol3.add(lbl_spiritualg2);    cnt_membershipCol3.add(txtf_spiritualg2);
                                cnt_membershipCol3.add(lbl_spiritualg3);    cnt_membershipCol3.add(txtf_spiritualg3);
                                cnt_membershipCol3.add(lbl_ministry);       cnt_membershipCol3.add(txtf_ministry);
                                
                            cnt_memberInfo = new Container(new GridLayout(1, 3));
                                cnt_memberInfo.setScrollableY(true);
                                //cnt_memberInfo.setScrollableX(true);
                                cnt_memberInfo.add(cnt_membershipCol1);
                                cnt_memberInfo.add(cnt_membershipCol2);
                                cnt_memberInfo.add(cnt_membershipCol3);
                                               
                        
                            
//                                public Container createPieChartForm() 
//                                {}
                                    // Generate the values
                                    double[] values = new double[]{10, 14, 14, 9, 19};
                                    // Set up the renderer
                                    int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN,
                                    ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
                                    DefaultRenderer renderer = buildCategoryRenderer(colors);
                                    renderer.setZoomButtonsVisible(true);
                                    renderer.setZoomEnabled(true);
                                    renderer.setChartTitleTextSize(20);
                                    renderer.setDisplayValues(true);
                                    renderer.setShowLabels(true);
                                    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
                                    r.setGradientEnabled(true);
                                    r.setGradientStart(0, ColorUtil.BLUE);
                                    r.setGradientStop(0, ColorUtil.GREEN);
                                    r.setHighlighted(true);
                                    // Create the chart ... pass the values and renderer to the chart object.
                                    PieChart chart_pie = new PieChart(buildCategoryDataset("Collection", values), renderer);
                                    // Wrap the chart in a Component so we can add it to a form
                                    ChartComponent chartCompo = new ChartComponent(chart_pie);
                                    // Create a form and show it.
                                    //Form f = new Form("Budget");
                                    //f.setLayout(new BorderLayout());
                                    //f.addComponent(BorderLayout.CENTER, c);
                                    //return f;
                                    cnt_offeringInfo = new Container();
                                    cnt_offeringInfo.getStyle().setBgColor(0x000000);
                                    cnt_offeringInfo.getStyle().setBgTransparency(255);
                                    cnt_offeringInfo.setLayout(new BorderLayout());
                                    cnt_offeringInfo.addComponent(BorderLayout.NORTH, new SpanLabel("Your Giviing in April 2016"));
                                    cnt_offeringInfo.addComponent(BorderLayout.CENTER, chartCompo);
                                    //return cnt_offeringInfo;
                                
                            
                        
                        
                                lbl_Occupation         = new Label("Occupation");     
                                lbl_Place_of_Work      = new Label("Place of Work");
                                lbl_JobTitle           = new Label("Job Title");
                                lbl_Industry           = new Label("Industry");
                                lbl_Education_Level    = new Label("Education");  
                                lbl_Employment_Status  = new Label("Employment Status");
                                lbl_Experience         = new Label("Experience");
                                lbl_Department         = new Label("Department");
                                lbl_Skills_Talents     = new Label("Skills & Talents");
                                lbl_Hobbies_Interests = new Label("Hobbies & Interests");
                                lbl_AwardsAccredations = new Label("Awards & Accredations");
                                txtf_Place_of_Work     = new TextField("");
                                txtf_JobTitle          =  new TextField("");
                                txtf_Industry          = new TextField();
                                txtf_Occupation        = new TextField();
                                txtf_Education_Level   = new TextField();
                                txtf_Employment_Status = new TextField();
                                txtf_Experience        = new TextField();
                                txtf_Department        = new TextField();
                                txtf_Skills_Talents    = new TextField();
                                txtf_Hobbies_Interests  = new TextField();
                                txtf_AwardsAccredations= new TextField();
                               
                        cnt_occupationInfo = new Container(new GridLayout(10, 2));
                                //browser = new BrowserComponent();
                                //browser.setURL("http://"+"localhost"+"/EnterprisePDA/php/uploadfiles.php");
                                //browser.setScrollableY(true);
                                //cnt_occupationInfo.add(browser);
                                cnt_occupationInfo.add(lbl_Occupation        );  cnt_occupationInfo.add(txtf_Occupation        );
                                cnt_occupationInfo.add(lbl_Place_of_Work     );   cnt_occupationInfo.add(txtf_Place_of_Work     );         
                                cnt_occupationInfo.add(lbl_JobTitle          );  cnt_occupationInfo.add(txtf_JobTitle          ); 
                                cnt_occupationInfo.add(lbl_Department        );cnt_occupationInfo.add(txtf_Department        );
                                cnt_occupationInfo.add(lbl_Industry          );  cnt_occupationInfo.add(txtf_Industry          ); 
                                cnt_occupationInfo.add(lbl_Education_Level   );  cnt_occupationInfo.add(txtf_Education_Level   );     
                                cnt_occupationInfo.add(lbl_Employment_Status );   cnt_occupationInfo.add(txtf_Employment_Status );      
                                cnt_occupationInfo.add(lbl_Experience        );  cnt_occupationInfo.add(txtf_Experience        );
                                cnt_occupationInfo.add(lbl_AwardsAccredations);cnt_occupationInfo.add(txtf_AwardsAccredations);
                                cnt_occupationInfo.add(lbl_Skills_Talents    );cnt_occupationInfo.add(txtf_Skills_Talents    );
                                cnt_occupationInfo.add(lbl_Hobbies_Interests);cnt_occupationInfo.add(txtf_Hobbies_Interests);
                                
                                
                               
                                lbl_blood_type          = new Label("Blood Type");     
                                lbl_heamoglobin         = new Label("Haemoglobin");
                                lbl_weight              = new Label("Weight");
                                lbl_height              = new Label("Height");
                                lbl_bmi                 = new Label("B.M.I");  
                                lbl_blood_pressure      = new Label("Blood Pressure");
                                lbl_dietary_need        = new Label("Dietary Need");
                                lbl_food_allergies      = new Label("Food Allergies");
                                lbl_medicine_allergies  = new Label("Medicine Allergies");
                                lbl_muscle_strength     = new Label("Muscle Strength");
                                lbl_special_medical_condition = new Label("Medical Conditions");
                                txtf_blood_type         = new TextField("");
                                txtf_heamoglobin        =  new TextField("");
                                txtf_weight             = new TextField();
                                txtf_height             = new TextField();
                                txtf_bmi                = new TextField();
                                txtf_blood_pressure     = new TextField();
                                txtf_dietary_need       = new TextField();
                                txtf_food_allergies     = new TextField();
                                txtf_medicine_allergies = new TextField();
                                txtf_muscle_strength    = new TextField();
                                txtf_special_medical_condition = new TextField();
                                
                               
                        cnt_biodataInfo = new Container(new GridLayout(11, 2));
                                //browser = new BrowserComponent();
                                //browser.setURL("http://"+"localhost"+"/EnterprisePDA/php/uploadfiles.php");
                                //browser.setScrollableY(true);
                                //cnt_occupationInfo.add(browser);
                                cnt_biodataInfo.add(lbl_blood_type          ); cnt_biodataInfo.add(txtf_blood_type         );
                                cnt_biodataInfo.add(lbl_heamoglobin         ); cnt_biodataInfo.add(txtf_heamoglobin        );         
                                cnt_biodataInfo.add(lbl_weight              ); cnt_biodataInfo.add(txtf_weight             );
                                cnt_biodataInfo.add(lbl_height              ); cnt_biodataInfo.add(txtf_height             );
                                cnt_biodataInfo.add(lbl_bmi                 ); cnt_biodataInfo.add(txtf_bmi                );
                                cnt_biodataInfo.add(lbl_blood_pressure      ); cnt_biodataInfo.add(txtf_blood_pressure     );    
                                cnt_biodataInfo.add(lbl_dietary_need        ); cnt_biodataInfo.add(txtf_dietary_need       );      
                                cnt_biodataInfo.add(lbl_food_allergies      ); cnt_biodataInfo.add(txtf_food_allergies     );
                                cnt_biodataInfo.add(lbl_medicine_allergies  ); cnt_biodataInfo.add(txtf_medicine_allergies );
                                cnt_biodataInfo.add(lbl_muscle_strength     ); cnt_biodataInfo.add(txtf_muscle_strength    );
                                cnt_biodataInfo.add(lbl_special_medical_condition);  cnt_biodataInfo.add(txtf_special_medical_condition);
                               
                        
                        
                        
                        dlgi_task = new InteractionDialog((String) Storage.getInstance().readObject("task_1_title"));
                            dlgi_task.setLayout(new BorderLayout());
                            dlgi_task.setScrollableY(true);
                            //fadeScrollBarBool
                            //UIManager.getInstance().
                        btn_close = new Button("Close");
                            btn_close.addActionListener((ee) -> dlgi_task.dispose());
                                                
                        tabs = new Tabs();
                            //tabs.setUIID("Tabzzee");
                                tabs.getUnselectedStyle().setBgColor(0xffffff);
                                tabs.getSelectedStyle().setBgColor(0xffffff);
                                tabs.setTabTextPosition(BOTTOM);
                            s = UIManager.getInstance().getComponentStyle("Tab");
                            s.setFgColor(0x000000);
                                imgf_info = FontImage.createMaterial(FontImage.MATERIAL_INFO, s);
                                imgf_category = FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_BOOKS, s);
                                imgf_location = FontImage.createMaterial(FontImage.MATERIAL_LOCATION_ON, s);
                                imgf_profession = FontImage.createMaterial(FontImage.MATERIAL_WORK, s);
                                imgf_attachment = FontImage.createMaterial(FontImage.MATERIAL_ATTACHMENT, s);
                                imgf_finances = FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_BALANCE_WALLET, s);
                                imgf_milestones = FontImage.createMaterial(FontImage.MATERIAL_BATTERY_UNKNOWN, s);
                                imgf_healthinfo = FontImage.createMaterial(FontImage.MATERIAL_BATTERY_UNKNOWN, s);
                                imgf_avatar = FontImage.createMaterial(FontImage.MATERIAL_HEALING, s);
                                imgf_contacts = FontImage.createMaterial(FontImage.MATERIAL_CONTACTS, s);
                                tabs.setAnimateTabSelection(true);
                                tabs.setTabPlacement(TOP); //Prayercell, Contacts, Bio-data, Membership, Milestones 
                                tabs.addTab("Profile", imgf_info, cnt_basicInfo);
                                tabs.addTab("Contacts", imgf_contacts, cnt_contactsInfo);
                                tabs.addTab("Location", imgf_location, cnt_locationInfo);
                                tabs.addTab("Membership", imgf_category, cnt_memberInfo); //new SpanLabel("Some text directly in the tab")
                                tabs.addTab("Collection", imgf_finances, cnt_offeringInfo);
                                tabs.addTab("Occupation", imgf_profession, cnt_occupationInfo);
                                tabs.addTab("HealthInfo", imgf_healthinfo, cnt_biodataInfo);
                                //dlgi_task.add(BorderLayout.NORTH, cnt_info);
                                dlgi_task.add(BorderLayout.CENTER, tabs);
                        dlgi_task.setWidth(cnt_basicInfo.getWidth());                                                   
                            
                        btn_discard = new Button("Discard");
                            btn_discard.addActionListener(new ActionListener() 
                            {
                                @Override
                                public void actionPerformed(ActionEvent evt) 
                                {
                                  dlgi_task.dispose();
                                  //Display.getInstance().lockOrientation(true);
                                  Storage.getInstance().writeObject("isprofileDialog_open", "NO");
                                }
                            });
                            
                        btn_save = new Button("Save");
                            btn_save.addActionListener(new ActionListener() 
                            {
                                @Override
                                public void actionPerformed(ActionEvent evt) 
                                {
                                 //Update user's tasks count cache on device
                                    if(Storage.getInstance().exists("tasks_count") == true)
                                    {
                                     str_oldTaskcount = (String) Storage.getInstance().readObject("tasks_count");
                                     Storage.getInstance().deleteStorageFile("tasks_count");
                                     int_count_Oldtasks = Integer.parseInt(str_oldTaskcount);

                                        if (int_count_Oldtasks >= 1)
                                        {
                                         Integer newcount;
                                         newcount = int_count_Oldtasks+1;
                                         str_newTaskcount = newcount.toString(); 

                                         //Save to local storgage
                                         //str_contactid = "contactid"+str_contactid
                                         Storage.getInstance().writeObject("tasks_count", str_newTaskcount);
                                        }
                                        else
                                        {
                                         Storage.getInstance().writeObject("tasks_count", "1");   
                                        }
                                    }
                                    else
                                    {
                                        Storage.getInstance().writeObject("tasks_count", "1");
                                    }

                                    if(Storage.getInstance().exists("lastTaskid") == true)
                                    {
                                        str_oldTaskid = (String) Storage.getInstance().readObject("lastTaskid");
                                        Storage.getInstance().deleteStorageFile("lastTaskid");
                                        int_tasksid = Integer.parseInt(str_oldTaskid);
                                        if (int_tasksid >= 1)
                                        {
                                         Integer newcount;
                                         newcount = int_tasksid+1;
                                         str_newTaskid = newcount.toString(); 

                                         //Save to local storgage
                                         //str_contactid = "contactid"+str_contactid
                                            //str_i = Integer.toString(i);
                                            Storage.getInstance().writeObject("task_"+str_newTaskid, ""); //Complete this...very important for displaying individual tasks 
                                            Storage.getInstance().writeObject("task_id", str_newTaskid);   //Is the same as id except if app is offline and creates it's own task_ids.                      
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_title", txtf_taskName.getText());
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_category", "");
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_description", txtf_taskDescription.getText());
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_beginning", txtf_taskBegining.getText());
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_ending", txtf_taskEnding.getText());
                                             if(rbg_allDay.getSelectedIndex() == 0){str_allDay = "yes";}else{str_allDay = "no";}
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_allDay", str_allDay);
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_members", combo_members.getSelectedItem());
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_recurring", "");
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_recurringUntil", "");
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_exportedTo", "");
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_location", "");
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_attachements", "");
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_sharetoemail", "");
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_milestones", "");  
                                            Storage.getInstance().writeObject("task_"+str_newTaskid+"_taskstatus", "");
                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("lastTaskid", "1");
                                            Storage.getInstance().writeObject("task_id", "1");
                                            Storage.getInstance().writeObject("task_1_title", btn_hearing.getText());
                                            Storage.getInstance().writeObject("task_1_category", "Legal Work");
                                            Storage.getInstance().writeObject("task_1_beginning", "");
                                            Storage.getInstance().writeObject("task_1_ending", "");
                                            Storage.getInstance().writeObject("task_1_allDay", "yes"); //no
                                            Storage.getInstance().writeObject("task_1_members", "6~admin~olive~rose~tommy~matthew~hildah"); //Use userID instead, everyone, everydept
                                            Storage.getInstance().writeObject("task_1_recurring", "no"); //Daily, Weekly, Fortnightly, Monthly, Yearly
                                            Storage.getInstance().writeObject("task_1_recurringUntil", ""); //2016-04-12
                                            Storage.getInstance().writeObject("task_1_exportedTo", ""); //Google, Yahoo, Live, ICS, Outlook, SMS
                                            Storage.getInstance().writeObject("task_1_location", ""); //longitude&latitude
                                            Storage.getInstance().writeObject("task_1_attachements", ""); //att_count~att_path
                                            Storage.getInstance().writeObject("task_1_sharetoemail", ""); //emial address if someone doesn't have app
                                            Storage.getInstance().writeObject("task_1_milestones", ""); //stone_count~stone1~stone1name~stone1status(complete, incomplete, abandoned, postponed)
                                            Storage.getInstance().writeObject("task_1_taskstatus", ""); //percentage calculation of all milestones
                                        }                            
                                    }
                                    else
                                    {
                                        Storage.getInstance().writeObject("lastTaskid", "1");
                                        Storage.getInstance().writeObject("task_id", "1");
                                        Storage.getInstance().writeObject("task_1_title", "");
                                        Storage.getInstance().writeObject("task_1_category", "Legal Work");
                                        Storage.getInstance().writeObject("task_1_beginning", "");
                                        Storage.getInstance().writeObject("task_1_ending", "");
                                        Storage.getInstance().writeObject("task_1_allDay", "yes"); //no
                                        Storage.getInstance().writeObject("task_1_members", "6~admin~olive~rose~tommy~matthew~hildah"); //Use userID instead, everyone, everydept
                                        Storage.getInstance().writeObject("task_1_recurring", "no"); //Daily, Weekly, Fortnightly, Monthly, Yearly
                                        Storage.getInstance().writeObject("task_1_recurringUntil", ""); //2016-04-12
                                        Storage.getInstance().writeObject("task_1_exportedTo", ""); //Google, Yahoo, Live, ICS, Outlook, SMS
                                        Storage.getInstance().writeObject("task_1_location", ""); //longitude&latitude
                                        Storage.getInstance().writeObject("task_1_attachements", ""); //att_count~att_path
                                        Storage.getInstance().writeObject("task_1_sharetoemail", ""); //emial address if someone doesn't have app
                                        Storage.getInstance().writeObject("task_1_milestones", ""); //stone_count~stone1~stone1name~stone1status(complete, incomplete, abandoned, postponed)
                                        Storage.getInstance().writeObject("task_1_taskstatus", ""); //percentage calculation of all milestones
                                    }         

                                    //If iko net, DO SERVER UPDATE
                                      //If success, display sucess note as below. If not, save to device and do check then dislay note that local save was done  then dispose dialog.
                                    
                                    
                                    //If hakuna net, DO LOCAL STORAGE
                                    
                                    //Check whether newtaskid = lasttask+1, if so show success dialog with name of new taskid if not show error suggest options... save to text file and dispose dialog
                                        dlgi_task.dispose();
                                        Storage.getInstance().writeObject("isprofileDialog_open", "NO");
                                }
                            });
                        //Dimension pre = dlgi_taskBasicInfo.getContentPane().getPreferredSize();
                        //dlgi_task.show(0, 0, Display.getInstance().getDisplayWidth() - (pre.getWidth() + pre.getWidth() / 6), 0);
                        btn_addSpouse = new Button("+"); 
                                if(Storage.getInstance().exists("usersgender"))
                                {
                                 str_usergender = (String) Storage.getInstance().readObject("usersgender");
                                    if(str_usergender == "Male")
                                    {
                                        //btn_addDetails.setIcon(img_wife);
                                    }
                                    else
                                    {
                                        //btn_addDetails.setIcon(img_husband);
                                    }
                                }
                                else
                                {
                                
                                }
                                btn_addSpouse.setName("BubbleButton");
                                Style sty_btnBubble = btn_addSpouse.getAllStyles();
                                sty_btnBubble.setBorder(Border.createEmpty());
                                sty_btnBubble.setFgColor(0xffffff);
                                sty_btnBubble.setBgPainter((g, rect) -> {
                                    g.setColor(0xff);
                                    int actualWidth = rect.getWidth();
                                    int actualHeight = rect.getHeight();
                                    int xPos, yPos;
                                    int size;
                                    if(actualWidth > actualHeight) {
                                        yPos = rect.getY();
                                        xPos = rect.getX() + (actualWidth - actualHeight) / 2;
                                        size = actualHeight;
                                    } else {
                                        yPos = rect.getY() + (actualHeight - actualWidth) / 2;
                                        xPos = rect.getX();
                                        size = actualWidth;
                                    }
                                    g.setAntiAliased(true);
                                    g.fillArc(xPos, yPos, size, size, 0, 360);
                                });
                                btn_addSpouse.addActionListener((ActionEvent e) -> 
                                {
                                    Dialog dlg = new Dialog(); //TODO:
                                        dlg.setLayout(new GridLayout(2, 1));
                                        dlg.getStyle().setBgColor(0x000000);
                                        dlg.getStyle().setFgColor(0xFFD800);
                                        //dlg.setUnselectedStyle(sty_lg);
                                        //dlg.setSelectedStyle(sty_lg); 
                                        
                                    SpanLabel sl = new SpanLabel("Add Spouce", "DialogBody");
                                        sl.getTextUnselectedStyle().setFgColor(0xffffff);
                                        dlg.add(sl);
                                        
                                    txtc_spouce = new AutoCompleteTextField("Ariane Mugisha", "Annete Waruguru", "Betsie Wilder", "Aisha Msichana");
                                        txtc_spouce.setHint("Type spouces name");
                                        txtc_spouce.setMinimumElementsShownInPopup(5);
                                        dlg.add(txtc_spouce);
                                        
                                    picker_anniversary = new Picker();
                                        picker_anniversary.setType(Display.PICKER_TYPE_DATE);
                                        picker_anniversary.setText("Select wedding date");
                                        picker_anniversary.setTextPosition(LEFT);
                                        dlg.add(picker_anniversary);
                                        
                                    txtc_children = new AutoCompleteTextField("Ariane Mugisha", "Annete Waruguru", "Betsie Wilder", "Aisha Msichana");
                                        txtc_children.setHint("Type childs name");
                                        txtc_children.setMinimumElementsShownInPopup(5);
                                        //dlg.add(txtc_children);
                                                                                
                                        dlg.setTransitionInAnimator(new BubbleTransition(500, "BubbleButton"));
                                        dlg.setTransitionOutAnimator(new BubbleTransition(500, "BubbleButton"));
                                        dlg.setDisposeWhenPointerOutOfBounds(true);
                                        //dlg.getTitleStyle().setFgColor(0xffffff);
                                        //dlg.remove(btn_bus);


                                    Style dlgStyle = dlg.getDialogStyle();
                                        dlgStyle.setBorder(Border.createEmpty());
                                        dlgStyle.setBgColor(0xff);
                                        dlgStyle.setBgTransparency(0xff);
                                        dlg.showPacked(BorderLayout.SOUTH, true);
                                        
                                });
                                fm_main.setTintColor(0);
                                
                        cnt_familyDetails = new Container();
                                //cnt_familyDetails.add(FlowLayout.encloseRightMiddle(combo_maritalStatus, btn_addDetails));
                                cnt_familyDetails.add(btn_addSpouse);
                                
                        cnt_dlgiSouth_btns = new Container(new FlowLayout(CENTER, CENTER));
                            cnt_dlgiSouth_btns.add(btn_discard);
                            cnt_dlgiSouth_btns.add(btn_save);
                            
                        cnt_dlgiSouth = new Container(new BorderLayout());
                            cnt_dlgiSouth.add(BorderLayout.CENTER, cnt_dlgiSouth_btns);
                            cnt_dlgiSouth.add(BorderLayout.EAST, cnt_familyDetails);
                            dlgi_task.addComponent(BorderLayout.SOUTH, cnt_dlgiSouth);  
                        dlgi_task.show(0,0,0,0);
                        
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
            
        btn_later = new Button("Remind me to later");
            btn_later.getStyle().setMarginRight(10);
            btn_later.addActionListener((ActionListener) new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    SelectedDepartment homer = new SelectedDepartment();
                    homer.showMainScreen();
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
    
    public void showDaySelector()
    {
        Dialog dlg_setDate = new Dialog();
        if(storage.readObject("transaction").toString().equals("set_bdate"))
        {
            dlg_setDate.setTitle("Select Date of Birth");
            dlg_setDate.add(cldr_bday);
        }
        if(storage.readObject("transaction").toString().equals("set_sdate"))
        {
            dlg_setDate.setTitle("Set Policy Start Date");
            dlg_setDate.add(cldr_start);
        }
        
        dlg_setDate.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        dlg_setDate.getStyle().setAlignment(CENTER);
        //dlg_startDate.add(picker_timePicker1);
        
        //dlg_startDate.add(datePicker);
        //dlg_startDate.add(dateTimePicker);
        //dlg_startDate.add(stringPicker);

        Button btn_cancelStart = new Button("Cancel");
            btn_cancelStart.setUIID("Label");
            btn_cancelStart.addActionListener(new ActionListener() 
            {
             @Override
             public void actionPerformed(ActionEvent evt) 
             {
              dlg_setDate.dispose();
              dlg_setDate.removeAll();
             }
            });

        Button btn_confirmStart = new Button("Confirm");
            btn_confirmStart.setUIID("Label");
            btn_confirmStart.addActionListener(new ActionListener() 
            {
             @Override
             public void actionPerformed(ActionEvent evt) 
             {
                if(storage.readObject("transaction").toString().equals("set_bdate"))
                {
                    dt_selected = new Date(cldr_bday.getSelectedDay());
                }
                if(storage.readObject("transaction").toString().equals("set_sdate"))
                {
                    dt_selected = new Date(cldr_start.getSelectedDay());
                }
              
              
                str_ssaahii = StringUtil.tokenize(StringUtil.tokenize(dt_selected.toString(), " ").get(3), ":").get(0)+":"+StringUtil.tokenize(StringUtil.tokenize(dt_selected.toString(), " ").get(3), ":").get(1);
                str_sday = StringUtil.tokenize(dt_selected.toString(), " ").get(0);
                str_sdate = StringUtil.tokenize(dt_selected.toString(), " ").get(2);
                str_smonth = StringUtil.tokenize(dt_selected.toString(), " ").get(1);
                str_syear = StringUtil.tokenize(dt_selected.toString(), " ").get(5);

                cldr_bday.addDataChangeListener(new DataChangedListener() 
                {
                  @Override
                  public void dataChanged(int type, int index) 
                  {
                  }
                });
                //cldr_begin.addActionListener((e) ->System.out.println("User picked: " + new Date(cldr_begin.getSelectedDay())));
                cldr_bday.addActionListener(new ActionListener() 
                {
                  @Override
                  public void actionPerformed(ActionEvent evt) 
                  {
                  }
              });
                            
              //Log.p("Converting date to format that server accepts.", 1);
              System.out.println("Day picked: " + dt_selected); 
                if(str_smonth.equals("Jan")){ str_smonth = "01"; }
                if(str_smonth.equals("Feb")){ str_smonth = "02";}
                if(str_smonth.equals("Mar")){ str_smonth = "03"; }
                if(str_smonth.equals("Apr")){ str_smonth = "04"; }
                if(str_smonth.equals("May")){ str_smonth = "05"; }
                if(str_smonth.equals("Jun")){ str_smonth = "06"; }
                if(str_smonth.equals("Jul")){ str_smonth = "07"; }
                if(str_smonth.equals("Aug")){ str_smonth = "08"; }
                if(str_smonth.equals("Sep")){ str_smonth = "09"; }
                if(str_smonth.equals("Oct")){ str_smonth = "10"; }
                if(str_smonth.equals("Nov")){ str_smonth = "11"; }
                if(str_smonth.equals("Dec")){ str_smonth = "12"; }
              
              
              SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);
                
                
                if(str_start.equals("")){str_start = picker_leo.getText();}
                txtf_start = new TextField(str_start, ""); 
                cldr_start = new Calendar(); 
                cldr_start.setChangesSelectedDateEnabled(true); //txtf_taskBegining = new TextField(str_task_beginning); 
                txtf_start.getAllStyles().setMargin(0, int_one_pt_five, int_five_Pt_five, int_five_Pt_five); 
                txtf_start.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_start.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_start.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getUnselectedStyle().getBorder().setThickness(3);
                txtf_start.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getSelectedStyle().getBorder().setThickness(3);
                txtf_start.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getPressedStyle().getBorder().setThickness(3);
                txtf_start.setEditable(false);
                txtf_start.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        //Log.p("Preparing to show place to set start date.", 1);
                        storage.writeObject("transaction", "set_sdate");
                        showDaySelector();
                    }
                });

                txtf_start.setText(str_syear+"-"+str_smonth+"-"+str_sdate);
                storage.writeObject("start_date", str_syear+"-"+str_smonth+"-"+str_sdate);
              
              dlg_setDate.dispose();
              dlg_setDate.removeAll();
             }
            });

        Container cnt_confirmORcancel_date = new Container(new BorderLayout());
            cnt_confirmORcancel_date.add(BorderLayout.WEST, btn_cancelStart);
            cnt_confirmORcancel_date.add(BorderLayout.EAST, btn_confirmStart);

        dlg_setDate.add(cnt_confirmORcancel_date);
        
        dlg_setDate.show();
    }

    protected void showOtherForm(Resources res) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}