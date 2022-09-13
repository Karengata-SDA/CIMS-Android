package com.mobitribe.hesabu;

import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.components.Accordion;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.File;
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

import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.validation.Validator;
import com.codename1.util.StringUtil;
//import com.tribedigital.omega.Utilz.Images;
//import com.tribedigital.omega.Utilz.Synchronise;
import java.util.Timer;

import java.io.InputStream;
import com.codename1.l10n.SimpleDateFormat;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.plaf.RoundBorder;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.spinner.Picker;
import java.util.Date;


import ca.weblite.codename1.json.JSONArray;
import ca.weblite.codename1.json.JSONObject;

public class MessagesMenu 
{
    //FORMS
    private Form fm_main;
    
    //DIALOGUES
    Dialog dlg_language;
    
    //BUTTONS
    private Button btn_submit, btn_recieveMoney, btn_seeMessages, btn_chngpin, btn_manageUsers, btn_manageAccounts; 
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
    private Label lbl_header, lbl_humberger_icon, lbl_avatar_icon, lbl_messages_icon;
    private Label lbl_footer;
    private Label lbl_logo;
       
    private Label lbl_Tbar;
    
    
    //classes
    //private SplashScreen cls_splash;
    //private Images cls_images;
    
    //CONTAINERS
    private Container cont_language, cont_rbEnglish, cont_rbSwahili;
    private Container cont_title;
    private Container cont_header, cnt_topbar;
    private Container cont_body;
    private Container cnt_footer;
    private Container cnt_usnpwd;
    private Container cnt_usn, cnt_usnicon, cnt_usntext;
    private Container cnt_pwd, cnt_pwdicon, cnt_pwdtext;
    private Container cnt_btn;

    private Container cnt_brkdwn_coins, cnt_brkdwn_notes;
  
    
    //LABEL
    private Label lbl_usnicon, lbl_pwdicon;
    
    
    //TEXTAREAS
    public static TextArea txt_username;
    public static TextArea txt_password;
    public static TextArea txt_transaction;
    
    //TEXTFIELDS
    public TextField txta_username;
    public TextField txta_password;
    TextField txf_jinatumizi;
    public TextField txf_nywila;
    
    //STORAGES
    //private Storage storage = Storage.getInstance();
    
    //FONTS
    private Font font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    
    //int int_dispW = Display.getInstance().getint_dispW();
    //int int_dispH = Display.getInstance().getint_dispH();
    
    //public static NetworkManager networkManager;
    
    
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
    
    //private String str_Login_Status;
    //private boolean bool_Login_staus;
    
    
    private String str_Language_english;
    private String str_Language_kiswahili;
    
    private String str_prep;
    
    private String str_Language, str_login_status, str_data, str_train, str_carriage;
    private String str_agent_id, str_agent_name, str_aspirant_id, str_station_id;
    private boolean bool_Language;
    
    private Resources theme;
    
    private boolean bool_selected, bool_temp_memno;
    
    //private Font font_small_bold, font_small_plain, font_medium_uline, font_medium_bold, font_medium_plain, font_large_bold, font_large_plain;
    //int int_zero_pt_five, int_one, int_one_pt_five, int_two, int_three, int_five_Pt_five;
    
    private FontImage ifont_username, ifont_password;
    
    private Style sty_iconsbar, sty_usn_icon, sty_pwd_icon;
    
    private Font font_RageItalic, font_HPSimplified, font_HPSimplifiedSmall, font_HPSimplifiedBold, font_HPSimplifiedLight, font_HPSimplifiedLightItalic;
    double pixelsPerMM = ((double)Display.getInstance().convertToPixels(10, true)) / 10.0; 
    private Font font_small_bold, font_small_plain, font_medium_uline, font_medium_bold, font_medium_plain, font_large_bold, font_large_plain;
    int int_zero_pt_five, int_one, int_one_pt_five, int_two, int_three, int_five_Pt_five;
    private Style sty_icon, sty_icon_dlgPay;
    
    private Container cnt_description;
    private SpanLabel spnlbl_description, spnlbl_description1, spnlbl_description2, spnlbl_description3, spnlbl_description4;
    
    private FontImage ifont_burger, ifont_avatar, ifont_messages, ifont_close, ifont_down;
    
    private Button btn_incomes, btn_expenses, btn_reconciliations, btn_vouchers, btn_reports, btn_budgets;
    
    private FloatingActionButton fabtn, fabtn_help, fabtn_settings;
    
    
    //FORMS
    //private Form fm_main;
    
    //BUTTONS
    public Button btn_login, btn_later, btn_signme, btn_forgot;
    //private Button btn_register;
    private Button btn_getlogins, btn_getregistered;
    
    //IMAGES
    private Image img_backgroundP, img_backgroundL;
    //private Image img_header;
    //private Image img_title;
    //private Image img_body;
    //private Image img_footer;
    //private Image user_id;
    //private Image pass_wd;
    private Image img_avatar;
    private Image img_wife, img_husband, img_child;
    
    //LABELS
    //private Label lbl_header;
    //private Label lbl_title;
    //private Label lbl_footer;
    
    //CONTAINERS
    //private Container cont_title;
    //private Container cont_header;
    //private Container cnt_brkdwn_coins, cnt_brkdwn_notes;
    //private Container cont_footer;
    
    //TEXTAREAS
    //private TextArea txta_username;
    //private TextArea txta_password;
    private TextArea txta_1timepin;
    
    public static AutoCompleteTextField ac_search;
    public static TextField txtf_trxno, txtf_memberno, txtf_firstname, txtf_lastname, txtf_phone, txtf_email, txtf_tithe, txtf_offering, txtf_building, txtf_budget, txtf_tithev, txtf_offeringv, txtf_buildingv, txtf_budgetv;
    private Validator val_payform, val_payform1, val_payform3, val_,val_firstname, val_lastname, val_memberno, val_phone, val_email;
    private FloatingHint fhint_firstname, fhint_lastname;
    
    private SpanLabel spl_message;
    
    private String str_country;
    
    private String str_Login_staus;
    private boolean bool_Login_staus;
    
    //DIALOG
    private Dialog dlg_login, dlg_accounts, dlg_payments, dlg_payments2, dlg_map;
    
    public static Dialog dlg_payments3;
    
    
    int int_dispW;
    int int_dispH;
    
    public static NetworkManager networkManager;
    Storage storage = Storage.getInstance();
    
    //private static final int POLL_FREQUENCY = 5000;
    //private long lastPolling;
    //private boolean responseReceived = true;

    //private Timer timer;
    
    //private String un;
    
    //private BufferedInputStream bis;
    
    private InputStream in;
    
    private String text;
    //private String str_username, str_password;
    
    private boolean bool_username;
    
    private String str_Login_Status, str_usergender;
    
    private Container cnt_dlgSouth, cnt_dlgNorth, cnt_items, cnt_payment_methods, cnt_payment_providers, cnt_payment_methods1, cnt_payment_providers1, cnt_payment_methods2, cnt_payment_providers2, cnt_details; //cnt_payment_methods2, cnt_payment_providers2, 
    
    private RadioButton btnRd_airtel, btnRd_mpesa, btnRd_paypal, btnRd_visa, btnRd_mastercard, btnRd_orange;
    private Container cnt_airtel, cnt_mpesa, cnt_paypal, cnt_visa, cnt_mastercard, cnt_orange;
    RadioButton [] rd_payoption;
    Container [] cnt_payoption;
    String [] str_acoptions_new_item, str_acoptions; 
    
    private Label lbl_optionsTitle, lbl_airtelzap, lbl_telkom, lbl_equitel, lbl_mpesa, lbl_paypal, lbl_visa, lbl_mastercard, lbl_orangemoney, lbl_card, lbl_bank, lbl_deposit, lbl_cheque, lbl_cash, lbl_mobile, lbl_direct, lbl_payprovider_spacer, lbl_payprovider_spacer1, lbl_payprovider_spacer2;
    private String str_paydate, str_payprovider, str_paymethod, str_payinstructions, str_payinstructions1, str_payinstructions2, str_payinstructions3, str_airtel, str_mpesa, str_paypal, str_visa, str_mastercard, str_orange;
    private ButtonGroup btnGp_payoption;
    private StringBuilder sb_main_item, sb_new_item, sb_acoptions_new_item, sb_options, sb_recp_item;
        
    private Container cnt_nav, cnt_home, cnt_users, cnt_messages, cnt_finance, cnt_settings;
    private Button btn_bible, btn_hymnal, btn_lesson, btn_bulletin, btn_home, btn_departments, btn_spiritualGifts, btn_ministries, btn_resourses, btn_worldchurch, btn_contactus;
    private Image img_bible, img_hymnal, img_lesson, img_bulletin, img_profile;
    private Label lbl_bible, lbl_hymnal, lbl_lesson, lbl_bulletin;
    private Container cnt_bible, cnt_hymnal, cnt_lesson, cnt_bulletin;
    
    private Command cmd_tbRight;
    
    private Container cnt_photo, cnt_avatar, cnt_basicData, cnt_familyDetails, cnt_basicInfo, cnt_locationMap, cnt_locationData, cnt_locationInfo, cnt_location, cnt_contactsCol, cnt_contactsCol1, cnt_contactsCol2, cnt_contactsInfo, cnt_membershipCol1, cnt_membershipCol2, cnt_membershipCol3, cnt_memberInfo, cnt_offeringInfo, cnt_occupationInfo, cnt_biodataInfo;
    private Container cnt_confirmORcancel_1, cnt_confirmORcancel_2;
    private Label lbl_taskName, lbl_taskDescription, lbl_taskBegining, lbl_taskEnding, lbl_allDay;
    private TextField txtf_taskName, txtf_taskDescription, txtf_taskBegining, txtf_taskEnding;
    private Calendar cldr_begin, cldr_end, cldr_anniversary;
    private Dialog dlg_profile;
    private Dialog dlg_startDate;
    private Dialog dlg_endDate;
    private Tabs tabs, tabs_dashboard; 
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
    
    private Container cnt_confirmORcancel_date;
    private SimpleDateFormat dateformat;
    
    private Image img_tasksheduler;
    private InteractionDialog dlgi_task;
    private Button btn_pay, btn_close, btn_closePayDlg, btn_minimise, btn_save, btn_discard, btn_cancel, btn_confirm;

    private Border bdr, bdr_no, border;
    private FontImage imgf_coins, imgf_avatar, imgf_profession, imgf_finances, imgf_healthinfo, imgf_category, imgf_money, imgf_location, imgf_attachment, imgf_milestones;
    private FontImage imgf_legalWork, imgf_companySec, imgf_payments;
    private Container cnt_coodinates, cnt_locLabels, cnt_locTexts, cnt_locNess;
    
    private TextField txtf_country, txtf_city, txtf_county, txtf_residenceEstate, txtf_streetRoad, txtf_courtFlatBuilding, txtf_doorNumberHouse;
    private Label lbl_country, lbl_city, lbl_town, lbl_district, lbl_county, lbl_state, lbl_province, lbl_region, lbl_estate, lbl_court, lbl_gate, lbl_residenceEstate, lbl_streetCourt, lbl_houseNumbe, lbl_doorNumber;
    
    private Label lbl_phonePersonal1, lbl_phonePersonal2, lbl_phoneHome, lbl_phoneWork, lbl_emailPersonal1, lbl_emailPersonal2, lbl_emailHome, lbl_emailWork;
    private TextField txtf_phonePersonal1, txtf_phonePersonal2, txtf_phoneHome, txtf_phoneWork, txtf_emailPersonal1, txtf_emailPersonal2, txtf_emailHome, txtf_emailWork;
    
    private Label lbl_emergencyContact, lbl_emergencyContactName, lbl_postboxHome, lbl_postboxWork, lbl_postboxPersonal, lbl_postzipPersonal, lbl_postzipHome, lbl_postzipWork;
    private TextField txtf_emergencyContact, txtf_emergencyContactName, txtf_postboxHome, txtf_postboxWork, txtf_postboxPersonal, txtf_postzipPersonal, txtf_postzipHome, txtf_postzipWork;
        
    private ImageViewer imv;
    
    private Image img_share, img_close;
    
    private ShareButton sbtn; 
    private String str_imageFile;
    private Image img_screenshot;
    
    private Button btn_addSpouse;
    private AutoCompleteTextField txtc_spouce, txtc_children;
    private Picker picker_anniversary;
    public static Toolbar tb_form, tb_dialog;
    
    public static Dialog dlg_avatar;
    private Button btn_logout, btn_profile, btn_accounts, btn_messages, btn_sendMoney,  btn_exit;
    //private Resources theme;
    
    private Label lbl_isaDventist, lbl_isKarengatan, lbl_membernumber, lbl_isregistered, lbl_membershipby, lbl_registrdate, lbl_transferdate, lbl_lastMembership;
    private TextField txtf_isAdventist, txtf_isKarengatan, txtf_membernumber, txtf_isregistered, txtf_membershipby, txtf_registrdate, txtf_transferdate, txtf_lastMembership;
    
    private Label lbl_baptismStatus, lbl_baptismPlace, lbl_nearestChurch, lbl_regularChurch, lbl_homechurch, lbl_prayerCell, lbl_SabbathScl, lbl_amoWmGroup;      
    private TextField txtf_baptismStatus, txtf_baptismPlace, txtf_nearestChurch, txtf_regularChurch, txtf_homechurch, txtf_prayerCell, txtf_SabbathScl, txtf_amoWmAyGroup;  
    
    private Label lbl_department1, lbl_department2, lbl_department3, lbl_department4, lbl_spiritualg1, lbl_spiritualg2, lbl_spiritualg3, lbl_ministry;
    private TextField txtf_department1, txtf_department2, txtf_department3, txtf_department4, txtf_spiritualg1, txtf_spiritualg2, txtf_spiritualg3, txtf_ministry;    
    
    private Label lbl_Place_of_Work, lbl_JobTitle, lbl_Industry, lbl_Occupation, lbl_Education_Level, lbl_Employment_Status, lbl_Experience, lbl_Department, lbl_Skills_Talents, lbl_Hobbies_Interests, lbl_AwardsAccredations;
    private TextField txtf_Place_of_Work, txtf_JobTitle, txtf_Industry, txtf_Occupation, txtf_Education_Level, txtf_Employment_Status, txtf_Experience, txtf_Department, txtf_Skills_Talents, txtf_Hobbies_Interests, txtf_AwardsAccredations;
    
    private Label lbl_blood_type, lbl_heamoglobin, lbl_weight, lbl_height, lbl_bmi, lbl_blood_pressure, lbl_dietary_need, lbl_food_allergies, lbl_medicine_allergies, lbl_muscle_strength, lbl_special_medical_condition;
    private TextField txtf_sabbath, txtf_startdate, txtf_start, txtf_blood_type, txtf_heamoglobin, txtf_weight, txtf_height, txtf_bmi, txtf_blood_pressure, txtf_dietary_need, txtf_food_allergies, txtf_medicine_allergies, txtf_muscle_strength, txtf_special_medical_condition;
    
    private String str_collection, str_amount;
    
    public String str_users_id, str_users_memnos, str_users_family_id, str_users_firstname, str_users_middlename, str_users_lastname, 
            str_users_nickname, str_users_title, str_users_userid, str_users_family, str_users_email_address, str_users_role, str_users_level, str_users_birth_date, str_users_age, 
            str_users_ppno, str_users_idno, str_users_gender, str_users_country, str_users_nationality, str_users_county, str_users_city, 
            str_users_phone, str_users_phone_alt, str_users_email, str_users_physical_address, 
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
    
    private Command cmd_back;
    
    private Image img_church;
    
    private Dialog dlg_setDate;
    private Calendar cldr_bday, cldr_start, cldr_sabbath;
    private Date dt_timer, dt_start, dt_selected, dt_end, dt_alert;
    private String str_saahii, str_hrs, str_min, str_ssaahii, str_sday, str_sdate, str_smonth, str_syear, str_shrs, str_smin, str_sapm, str_esaahii, str_eday, str_edate, str_emonth, str_eyear, str_ehrs, str_emin, str_eapm;
    
    private String str_totals, str_subtotals, str_totalItems, str_tithe, str_offering, str_building, str_budget, str_tithev, str_offeringv, str_buildingv, str_building_roof, str_building_premix, str_building_walling, str_building_elec, str_building_plumb, str_building_pulpit, str_building_window, str_buildingv_roof, str_buildingv_premix, str_buildingv_wall, str_buildingv_elec, str_buildingv_plumb, str_buildingv_pulpit, str_buildingv_window, str_budgetv, str_item, str_main_item, str_itemv, str_itemd, str_main_itemv;
    private String str_id, str_message, str_phone, str_from, str_from_id, str_reference, str_cost, str_reg_timestamp, str_pagedata;
    private String str_trxno, str_trxdt, str_trxtm, str_refno, str_memnu, str_memno, str_family_id, str_spouse_id, str_temp_family_id, str_temp_spouse_id, str_temp_gender, str_title, str_name, str_firstname, str_lastname, str_fname, str_lname, str_gender, str_dob, str_idpp, str_aob, str_btn_back, str_btn_ok, str_email, str_fnhint, str_unhint, str_pwhint, str_organization, str_department;
    AutoCompleteTextField [] txtac_main_item, txtac_new_item;
    TextField [] txtf_item, txtf_new_itemv, txtf_main_itemv;
    String [] str_itemOptions;
    SpanLabel[] splbl_item, splbl_name, splbl_name_row, splbl_amount_row, splbl_amount_row2, splbl_name_row2;
    Label[] lbl_item, lbl_name_row, lbl_amount_row, lbl_amount_row2, lbl_name_row2;
    private int i, j, k, l, m;
    
    
    
    private int int_no_main_items, int_no_new_items, int_no_vitus, int_no_total_items, int_newno_items, int_rows_items, int_rows_item, int_totals, int_new_totals, int_subtotal, int_subtotals1, int_subtotals2, int_temptotals1, int_temptotals2, int_temptotals3, int_subtotals3, int_txtf_amount, int_totalItems;
    private String str_no_main_items, str_no_new_items, str_no_total_items, str_no_vitus, str_kitukipya, str_kitukipya_id;
    boolean bool_no_main_items, bool_no_new_items, bool_no_vitus, bool_no_total_items, bool_item, bool_itemv, bool_itemd, bool_main_item, bool_main_itemv, bool_pay_instructions, bool_tithev, bool_offeringv, bool_buildingv, bool_budgetv, bool_payment_provider, bool_payment_method, bool_totals;
    boolean bool_buildingv_items, bool_buildingv_roof, bool_buildingv_premix, bool_buildingv_wall, bool_buildingv_elec, bool_buildingv_plumb, bool_buildingv_pulpit, bool_buildingv_window;
    boolean bool_refno, bool_trxno, bool_trxdt, bool_memno, bool_fname, bool_lname, bool_phone, bool_email, bool_family_id;
    private Label lbl_removeTithe, lbl_removeOffering, lbl_removeBuilding, lbl_removeBudget, lbl_removeKitty;
    private Label lbl_items, lbl_totals;
    
    private GridLayout laygrid_item;
    
    private Border border2;
    private Style sty, s1, s2, sty_icontbar;
    private Container cnt_building;
    private TextField txtf_building_roof, txtf_building_premix, txtf_building_wall, txtf_building_elec, txtf_building_plumb, txtf_building_pulpit, txtf_building_window, txtf_buildingv_roof, txtf_buildingv_premix, txtf_buildingv_wall, txtf_buildingv_elec, txtf_buildingv_plumb, txtf_buildingv_pulpit, txtf_buildingv_window;
    
    private String str_new_item_nme, str_new_item_val;
    
    private Label lbl_info, lbl_clear;
    
    private Button btn_0_5, btn_1, btn_5, btn_10, btn_20, btn_40, btn_50, btn_100, btn_200, btn_500, btn_1000;
    private Label lbl_0_5v, lbl_1v, lbl_5v, lbl_10v, lbl_20v, lbl_40v, lbl_50v, lbl_100v, lbl_200v, lbl_500v, lbl_1000v;
    
    private Button btn_0_5_minus;
    private Label lbl_0_5;
    private TextField txtf_0_5;
    private Button btn_0_5_add;
    
    private Button btn_1_minus;
    private Label lbl_1;
    private TextField txtf_1;
    private Button btn_1_add;
	
    private Button btn_5_minus;
    private Label lbl_5;
    private TextField txtf_5;
    private Button btn_5_add;
	
    private Button btn_10_minus;
    private Label lbl_10;
    private TextField txtf_10;
    private Button btn_10_add;
	
    private Button btn_20_minus;
    private Label lbl_20;
    private TextField txtf_20;
    private Button btn_20_add;
	
    private Button btn_40_minus;
    private Label lbl_40;
    private TextField txtf_40;
    private Button btn_40_add;
	
    private Button btn_50_minus;
    private Label lbl_50;
    private TextField txtf_50;
    private Button btn_50_add;
	
    private Button btn_100_minus;
    private Label lbl_100;
    private TextField txtf_100;
    private Button btn_100_add;
	
    private Button btn_200_minus;
    private Label lbl_200;
    private TextField txtf_200;
    private Button btn_200_add;
	
    private Button btn_500_minus;
    private Label lbl_500;
    private TextField txtf_500;
    private Button btn_500_add;
	
    private Button btn_1000_minus;
    private Label lbl_1000;
    private TextField txtf_1000;
    private Button btn_1000_add;
    
    private Container cont_0_5;
    private Container cont_1;
    private Container cont_5;
    private Container cont_10;
    private Container cont_20;
    private Container cont_40;
    private Container cont_200;
    private Container cont_100;
    private Container cont_50;
    private Container cont_500;
    private Container cont_1000;
    
    private TextField txf_0_5;
    private TextField txf_1;
    private TextField txf_5;
    private TextField txf_10;
    private TextField txf_20;
    private TextField txf_40;
    private TextField txf_20_note;
    private TextField txf_50;
    private TextField txf_100;
    private TextField txf_200;
    private TextField txf_500;
    private TextField txf_1000;
    
    private String str_listcontent;
    //private Container cnt_tablerow;
    private Button[] btn_pic, btn_view, btn_edit, btn_delete, btn_message, btn_copy, btn_pin, btn_markpresent;
    private Button[] btn_pic_row, btn_payoption1_main_row, btn_poption7_row, btn_payoption6_row, btn_payoption2_main_row, btn_payoption5_row, btn_payoption4_row, btn_payoption3_main_row;
    private Button[] btn_pic_row2, btn_payoption2_new_row2, btn_payoption1_new_row2, btn_delete_row2, btn_payoption3_new_row2, btn_copy_row2, btn_pin_row2, btn_markpresent_row2;
    private Button btn_view_tbar, btn_edit_tbar, btn_delete_tbar, btn_message_tbar, btn_copy_tbar, btn_pin_tbar, btn_markpresent_tbar;
    private CheckBox[] cb_box, cb_fam, cb_box_row, cb_box_row2;
    private Label[] lbl_rowid, lbl_id_row, lbl_id_row2;
    private CheckBox cb_members, cb_member;
    private Image img_avatar_male, img_avatar_female;
    private Container cnt_table, cnt_taskbar, cnt_tablehead, cnt_tablebody, cnt_tablefoot;
    private Container cnt_departments;
    private Button btn_all, btn_cbd, btn_amo, btn_awm, btn_aym, btn_amb, btn_rtm, btn_ppt, btn_pri, btn_kgt, btn_crd, btn_cims;
    
    private Label lbl_id_column, lbl_head_name, lbl_head_id, lbl_thead_status, lbl_currency_column, lbl_thead_cnvid, lbl_actions_column;
    private Container[] cnt_cbox, cnt_name, cnt_item, cnt_gender, cnt_actions, cnt_tablerow, cnt_cbox_row, cnt_name_row, cnt_amount_row, cnt_gender_row,  cnt_actions_row, cnt_tablerow_row;
    private Container[] cnt_cbox_row2, cnt_name_row2, cnt_amount_row2, cnt_gender_row2,  cnt_actions_row2, cnt_tablerow_row2;
    private Container cnt_actions_tbar;
    
    private TextField txtf_search;
    
    private String str_bool_loggedin, str_bool_keepmeloggedin, str_bool_isMemberSelected, str_bool_isEveryoneSelected;
    private boolean bool_loggedin, bool_keepmeloggedin, bool_isMemberSelected, bool_isEveryoneSelected;
    
    private boolean bool_department;
    
    private String str_search_term;
    
    private ComboBox combo_filter;
    private FontImage ifont_filter;
    
    
    private int int_no_mem, int_no_memsel, int_no_new_memsel;
    private String str_no_mem, str_no_memsel, str_memsel, str_new_memsel;
    private boolean bool_no_mem, bool_no_memsel, bool_memsel;
    private String [] strA_memsel; 
    private StringBuilder sb_memsel;
    
    
    private String str_smsMessage, emailMessage, str_phoneContact, emailContact;
    private String str_msgurl, str_msgres_status;
    private String str_msg, str_msgto, str_msgfrom, str_msgtyp;
    
    private boolean bool_listcriteria, bool_filtercriteria, bool_role, bool_level;
    private String str_listcriteria, str_filtercriteria, str_role, str_level;
    
    private File docRoot;
    
    private String str_itemsel, str_no_itemsel, str_user_id;
    private Accordion acc_family;
    private Accordion[] acc_member;
    private Container cnt_family, cnt_fam;
    private boolean bool_lastaccopen;
    private String str_lastaccopen;
    private boolean bool_no_fam_mems;
    private String str_no_fam_mems;
    private int int_no_fam_mems;
    
    private boolean bool_spouseid;
    private int int_spouseid;
    private String str_spouseid;
    
    private boolean bool_vitu, bool_vitu1, bool_vitu2;
    private int int_vitu, int_vitu1, int_vitu2;
    
    private StringBuilder sb_randomLetters;
    String [] str_randomLetters;
    
    private String  str_itemopm1, str_itemop1, str_itemop1v, str_itemop1d, str_itemop1r, str_itemopm2, str_itemop2, str_itemop2v, str_itemop2d, str_itemop2r,str_itemopm3, str_itemop3, str_itemop3v, str_itemop3d, str_itemop3r;
    private boolean bool_itemopm1, bool_itemop1, bool_itemop1v, bool_itemop1d, bool_itemop1r, bool_itemopm2, bool_itemop2, bool_itemop2v, bool_itemop2d, bool_itemop2r, bool_itemopm3, bool_itemop3, bool_itemop3v, bool_itemop3d, bool_itemop3r;
    
    private String str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr, str_messageid;
    private boolean bool_itemopm, bool_itemop, bool_itemopv, bool_itemopd, bool_itemopr;
    
    private String str_messages;
    private SpanLabel [] slbl_message;
    private SpanLabel[] slbl_name;
    
    Container[] cnt_no, cnt_id, cnt_conversation_id, cnt_status;
    Label[] lbl_id, lbl_conversation_id, lbl_status, lbl_delete, lbl_view;
    Button[] btn_deposit, btn_withdraw, btn_search;

    private String str_transaction, str_phoneno, str_saccono, str_sacconm, str_amounty, str_mpesaurl;
    private Button btn_back, btn_send;
    private TextField txtf_amount, txtf_sacconum;
    
    private String str_no_messages;
    private Button[] btn_page;
    private Button btn_next, btn_prev;
    private int int_no_messages;
    
    private String str_conversation_id, str_status;
    private SpanLabel slbl_selected_message;
    private Button btn_add;
    
    private boolean bool_pagecurr, bool_pageprev, bool_pagenext, bool_pagesize, bool_offset, bool_start_msg, bool_end_msg;
    private Integer int_pagecurr, int_pageprev, int_pagenext, int_pagesize, int_pagettls, int_id, int_offset, int_msgid, int_start_msg, int_end_msg;
    private String str_resphint, str_pagecount, str_pagecurr, str_pageprev, str_pagenext, str_pagettls, str_pagesize, str_offset, str_start_msg, str_end_msg;
    private Label lbl_pagecurr, lbl_pagettls, lbl_pagesize;
    private Label[] lbl_pagenext, lbl_pagelast;
  
        
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
    
    private boolean bool_no_recp_items, bool_recp_items;
    private String str_no_recp_items, str_recp_items, str_recp_item;
    private int int_no_recp_items, int_newno_recp_items;
        
    private boolean bool_usertype;
    private String str_usertype;   
    
    private JSONArray jsonarr, arr_page;
    private JSONObject jsonobj, obj_line;
    
    
    public MessagesMenu()
    {
    }
      

    public void showMainMenu()
    {
      Log.p("Inside messages menu.", 1);
      
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
      
      int_dispW = Display.getInstance().getDisplayWidth();
      int_dispH = Display.getInstance().getDisplayHeight();
      
      pixelsPerMM = ((double)Display.getInstance().convertToPixels(10, true)) / 10.0;
      
      border = Border.createCompoundBorder(Border.createLineBorder(3, 0x5BC8FB), Border.createLineBorder(3, 0x5BC8FB), Border.createLineBorder(3, 0x5BC8FB), Border.createLineBorder(3, 0x5BC8FB));
      
      
       font_RageItalic = Font.createTrueTypeFont("Rage Italic", "Rage Italic.ttf");
       font_RageItalic = font_RageItalic.derive((int)(15.1 * pixelsPerMM), Font.STYLE_PLAIN);
       
       /*
       font_HPSimplified = Font.createTrueTypeFont("HP Simplified", "HP Simplified.ttf");
       font_HPSimplified = font_HPSimplified.derive((int)(3.1 * pixelsPerMM), Font.STYLE_BOLD);
       
       font_HPSimplifiedSmall = Font.createTrueTypeFont("HP Simplified", "HP Simplified.ttf");
       font_HPSimplifiedSmall = font_HPSimplifiedSmall.derive((int)(0.1 * pixelsPerMM), Font.STYLE_PLAIN);
       
       font_HPSimplifiedBold = Font.createTrueTypeFont("HP Simplified", "HP Simplified.ttf");
       font_HPSimplifiedBold = font_HPSimplifiedBold.derive((int)(4.0 * pixelsPerMM), Font.STYLE_BOLD);
       
       font_HPSimplifiedLight = Font.createTrueTypeFont("HP Simplified Light", "HP Simplified Light.ttf");
       font_HPSimplifiedLight = font_HPSimplifiedLight.derive((int)(2.5 * pixelsPerMM), Font.STYLE_PLAIN);
       
       font_HPSimplifiedLightItalic = Font.createTrueTypeFont("HP Simplified Light", "HP Simplified Light.ttf");
       font_HPSimplifiedLightItalic = font_HPSimplifiedLightItalic.derive((int)(2.5 * pixelsPerMM), Font.STYLE_ITALIC);
       */
       
      sty_icon = new Style();
      sty_icon.setFgColor(0xffffff);
      sty_icon.setBgColor(0xffffff);
      sty_icon.setBgTransparency(0, false);
       
       ifont_down = FontImage.createMaterial(FontImage.MATERIAL_EXPAND_MORE, sty_icon, 4);
       
        font_medium_uline = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_UNDERLINED, Font.SIZE_MEDIUM);
        font_small_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL);
        font_medium_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
        font_large_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
        font_small_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        font_medium_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
        font_large_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);
               
        fm_main = new Form();
        fm_main.setLayout(new BorderLayout());
        fm_main.getTitleArea().setPreferredSize(new Dimension(0, 0));
        fm_main.getTitleArea().removeAll();
        fm_main.setLayout(new BorderLayout());
        fm_main.setScrollableY(true);
        fm_main.getStyle().setBgImage(img_background, false);
        fm_main.getStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL, false);
        //fm_main.getTitleStyle().setFColor(0xF18C24 );//.getStyle().setBgColor(0xF18C24 );
      
      
      
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
      
      //Body
        cont_body = new Container();
        cont_body.setScrollableY(true);
        cont_body.getAllStyles().setBgTransparency(155);
        cont_body.getStyle().setBgColor(0x000000);
        cont_body.getStyle().setFgColor(0xffffff);
        cont_body.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        cont_body.setLeadComponent(null);
        
        cnt_table = new Container(new BorderLayout());
        cnt_table.setLeadComponent(null);
        cnt_table.getAllStyles().setMargin(0, 0, 0, 0);
        cnt_table.getAllStyles().setPadding(0, 0, 0, 0);
        cnt_table.getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(2, 0xDDDDDD), Border.createLineBorder(2, 0xDDDDDD), Border.createLineBorder(1, 0xffffff), Border.createLineBorder(1, 0xffffff)));

        TableLayout laytab_tableheader = new TableLayout(1, 5);

        cnt_tablehead = new Container();
        cnt_tablehead.setScrollableY(false);
        cnt_tablehead.getAllStyles().setPadding((int)(5.0 * pixelsPerMM), 0, (int)(2.0 * pixelsPerMM), (int)(2.0 * pixelsPerMM));
        cnt_tablehead.setLayout(laytab_tableheader);    


        lbl_head_id = new Label("#");
        lbl_head_id.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_head_id.getAllStyles().setPadding(0, 0, 0, 0);
        lbl_head_id.setTextPosition(Component.TOP);
        lbl_head_id.getAllStyles().setAlignment(CENTER);
        lbl_head_id.getAllStyles().setFgColor(0xffffff, false);

        lbl_head_name = new Label("Name");
        lbl_head_name.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_head_name.getAllStyles().setPadding(0, 0, 0, 0);
        lbl_head_name.setTextPosition(Component.TOP);
        lbl_head_name.getAllStyles().setAlignment(CENTER);
        lbl_head_name.getAllStyles().setFgColor(0xffffff, false);

        lbl_thead_cnvid = new Label("MsgId");
        lbl_thead_cnvid.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_thead_cnvid.getAllStyles().setPadding(0, 0, 0, 0);
        lbl_thead_cnvid.setTextPosition(Component.TOP);
        lbl_thead_cnvid.getAllStyles().setAlignment(CENTER);
        lbl_thead_cnvid.getAllStyles().setFgColor(0xffffff, false);

        lbl_thead_status = new Label("Status");
        lbl_thead_status.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_thead_status.getAllStyles().setPadding(0, 0, 0, 0);
        lbl_thead_status.setTextPosition(Component.TOP);
        lbl_thead_status.getAllStyles().setAlignment(CENTER);
        lbl_thead_status.getAllStyles().setFgColor(0xffffff, false);

        lbl_actions_column = new Label("Actions");
        lbl_actions_column.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_actions_column.getAllStyles().setPadding(0, 0, 0, 0);
        lbl_actions_column.setTextPosition(Component.TOP);
        lbl_actions_column.getAllStyles().setAlignment(CENTER);
        lbl_actions_column.getAllStyles().setFgColor(0xffffff, false);

        
        cnt_tablehead.add(laytab_tableheader.createConstraint().widthPercentage(10), lbl_head_id);
        cnt_tablehead.add(laytab_tableheader.createConstraint().widthPercentage(30), lbl_head_name);
        cnt_tablehead.add(laytab_tableheader.createConstraint().widthPercentage(20), lbl_thead_cnvid);
        cnt_tablehead.add(laytab_tableheader.createConstraint().widthPercentage(20), lbl_thead_status);
        cnt_tablehead.add(laytab_tableheader.createConstraint().widthPercentage(20), lbl_actions_column);
        
        
        cnt_tablebody = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_tablebody.setLeadComponent(null);
        cnt_tablebody.getAllStyles().setPadding((int) (1.5 * pixelsPerMM), 0, (int) (2.0 * pixelsPerMM), (int) (2.0 * pixelsPerMM));

        //cnt_tablebody.add(BorderLayout.centerCenterEastWest(txta_sacconum, btn_submit, null));
        cnt_messages = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_messages.setScrollableY(true);
        cnt_messages.getAllStyles().setBorder(Border.createEmpty());
        cnt_messages.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        cnt_messages.getAllStyles().setBgTransparency(0);
        cnt_messages.getAllStyles().setBgColor(0x006064);
        cnt_messages.getAllStyles().setBorder(null);
        cnt_messages.getAllStyles().setMargin((int) (1.5 * pixelsPerMM), (int) (1.5 * pixelsPerMM), (int) (1.5 * pixelsPerMM), (int) (1.5 * pixelsPerMM));

//        boolean bool_messages = Storage.getInstance().exists("messages.json");
//        if(bool_messages == true)
//        {
//            //str_messages = (String) Storage.getInstance().readObject("sacconumber.json");
//        }
//        else
//        {
//            //str_messages = (String) Storage.getInstance().readObject("messages.json");
//        }
        

        
        

        try
        {
            
            
            Log.p("Reading >>>>>>>>>>>>>> Messages <<<<<<<<<<< .json from storage.", 1);
            
            /*
            bool_pagecurr = Storage.getInstance().exists("pagecurr");
            if(bool_pagecurr == true)
            {
                str_pagecurr = Storage.getInstance().readObject("pagecurr").toString();
                
                bool_pagecurr = Storage.getInstance().exists("page_"+str_pagecurr+".json");
                if(bool_pagecurr == true)
                {
                    str_messages = (String) Storage.getInstance().readObject("page_"+str_pagecurr+".json");
                
                    jsonarr = new JSONArray(str_messages);
                }
                else
                {
                    str_messages = (String) Storage.getInstance().readObject("messages"+".json");
                
                    jsonobj = new JSONObject(str_messages);
                    jsonarr = jsonobj.getJSONArray("data");
                } 
            }
            else
            {
                str_messages = (String) Storage.getInstance().readObject("messages"+".json");
                
                jsonobj = new JSONObject(str_messages);
                jsonarr = jsonobj.getJSONArray("data");
            }
            */
            
            
            str_messages = (String) Storage.getInstance().readObject("messages"+".json");
                
            jsonobj = new JSONObject(str_messages);
            jsonarr = jsonobj.getJSONArray("data");
            
            
            
            slbl_name = new SpanLabel[jsonarr.length()];
            lbl_id = new Label[jsonarr.length()];
            lbl_item = new Label[jsonarr.length()];
            lbl_conversation_id = new Label[jsonarr.length()];
            lbl_status = new Label[jsonarr.length()];
            btn_delete = new Button[jsonarr.length()];
            btn_message = new Button[jsonarr.length()];
            btn_search = new Button[jsonarr.length()];
            lbl_delete = new Label[jsonarr.length()];
            lbl_view = new Label[jsonarr.length()];

            cnt_no = new Container[jsonarr.length()];
            cnt_id = new Container[jsonarr.length()];
            cnt_name = new Container[jsonarr.length()];
            cnt_conversation_id = new Container[jsonarr.length()];
            cnt_status = new Container[jsonarr.length()];
            cnt_actions = new Container[jsonarr.length()];

            cnt_tablerow = new Container[jsonarr.length()];

            
            arr_page = new JSONArray();
            
            for (k = 0; k < jsonarr.length(); k++) 
            {
                    
                str_id = jsonarr.getJSONObject(k).getString("id");
                str_name = jsonarr.getJSONObject(k).getString("to_name");
                str_phone = jsonarr.getJSONObject(k).getString("to");
                str_message = jsonarr.getJSONObject(k).getString("message");
                str_conversation_id = jsonarr.getJSONObject(k).getString("conversation_id");
                str_status = jsonarr.getJSONObject(k).getString("status");
                str_from = jsonarr.getJSONObject(k).getString("from");
                str_from_id = jsonarr.getJSONObject(k).getString("from_id");
                str_reference = jsonarr.getJSONObject(k).getString("reference");
                str_cost = jsonarr.getJSONObject(k).getString("cost");
                str_reg_timestamp = jsonarr.getJSONObject(k).getString("reg_timestamp");
                
                
                if(k == 0)
                {
                    bool_start_msg = Storage.getInstance().exists("start_msg");
                    if(bool_start_msg == true)
                    {
                        str_end_msg = Storage.getInstance().readObject("end_msg").toString();
                        
                        int_start_msg = Integer.parseInt(str_end_msg);
                        str_start_msg = String.valueOf(int_start_msg);
                        
                        Storage.getInstance().writeObject("start_msg", str_start_msg);
                    }
                    else
                    {
                        Storage.getInstance().writeObject("start_msg", str_id);
                        str_start_msg = str_id;
                        int_start_msg = Integer.parseInt(str_start_msg);
                    }
                }
                

                GridLayout laygrid = new GridLayout(3); //obj_content.size(), 
                laygrid.setAutoFit(false);
                
                Label lbl_msg_details = new Label(str_id);
                lbl_msg_details.setName(String.valueOf(k));
                lbl_msg_details.setUIID(str_id+"|"+str_name+"|"+str_phone+"|"+str_message+"|"+str_conversation_id+"|"+str_status+"|"+str_from+"|"+str_from_id+"|"+str_reference+"|"+str_cost+"|"+str_reg_timestamp);
                
                //System.err.println("\n\n========="+str_id+"|"+str_name+"|"+str_phone+"|"+str_conversation_id+"|"+str_status+"|"+str_from+"|"+str_from_id+"|"+str_reference+"|"+str_cost+"|"+str_reg_timestamp+"============\n\n");


                TableLayout laytab = new TableLayout(jsonarr.length(), 5);

                lbl_id[k] = new Label();
                lbl_id[k].setText(String.valueOf((k + 1)));
                lbl_id[k].getAllStyles().setMargin(0, 0, 0, 0);
                lbl_id[k].getAllStyles().setPadding(0, 0, 0, 0);
                lbl_id[k].setTextPosition(Component.TOP);
                lbl_id[k].getAllStyles().setFgColor(0xffffff, false);
                
                slbl_name[k] = new SpanLabel();
                slbl_name[k].setText(str_name.charAt(0)+". "+StringUtil.tokenize(str_name, " ").get(1));
                slbl_name[k].setName(str_id);
                slbl_name[k].getAllStyles().setBgTransparency(0);
                slbl_name[k].getTextAllStyles().setFgColor(0xffffff);
                slbl_name[k].getTextComponent().setSingleLineTextArea(true);
                slbl_name[k].setTextBlockAlign(LEFT);
                slbl_name[k].setFocusable(false);
                slbl_name[k].getTextAllStyles().setAlignment(LEFT, false);

                /*
                slbl_name[k].getTextAllStyles().setPadding(0, 0, 0, 0);
                slbl_name[k].getTextAllStyles().setMargin(0, 0, 0, 0);
                slbl_name[k].getAllStyles().setFgColor(0xa2a1b8, false);
                slbl_name[k].getAllStyles().setFont(font_medium_plain, false);
                slbl_name[k].getAllStyles().setMargin(0,0,0,0);
                slbl_name[k].getAllStyles().setPadding(0,0,0,0);*/
                
                str_data = str_message; //Your giving of Ksh.30 ha
                str_train = "Ksh. "; //StringUtil.tokenize(str_data, "Ksh.").get(1); System.err.println("Trn: "+str_train);
                str_carriage = ""; //StringUtil.tokenize(str_train, " ").get(0); 
                
                if (str_carriage.equals("")) 
                {
                    str_amount = "";
                } 
                else 
                {
                    str_amount = str_carriage;
                }
                
                

                lbl_conversation_id[k] = new Label();
                lbl_conversation_id[k].setText(str_conversation_id); //str_id //"Env. "+str_conversation_id
                lbl_conversation_id[k].setName(str_id); //
                lbl_conversation_id[k].getAllStyles().setFgColor(0xffffff, false);
                lbl_conversation_id[k].getAllStyles().setMargin(0, 0, 0, 0);
                lbl_conversation_id[k].getAllStyles().setPadding(0, 0, 0, 0);
                lbl_conversation_id[k].setTextPosition(Component.TOP);
                lbl_conversation_id[k].setVerticalAlignment(CENTER);
                
                lbl_id[k] = new Label(String.valueOf((k + 1)));
                lbl_id[k].getAllStyles().setMargin(0, 0, 0, 0);
                lbl_id[k].getAllStyles().setPadding(0, 0, 0, 0);
                lbl_id[k].setTextPosition(Component.TOP);
                lbl_id[k].getAllStyles().setFgColor(0xffffff, false);
                
                
                lbl_status[k] = new Label();
                lbl_status[k].setText(str_status);
                lbl_status[k].setName(str_status);
                lbl_status[k].getAllStyles().setFgColor(0xffffff, false);
                lbl_status[k].getAllStyles().setMargin(0, 0, 0, 0);
                lbl_status[k].getAllStyles().setPadding(0, 0, 0, 0);
                lbl_status[k].setTextPosition(Component.TOP);
                lbl_status[k].setVerticalAlignment(CENTER);

                btn_delete[k] = new Button();
                btn_delete[k].setIcon(theme.getImage("delete_48px.png"));
                btn_delete[k].getAllStyles().setFgColor(0xffffff, false);
                btn_delete[k].getAllStyles().setMargin(0, 0, 0, 0);
                btn_delete[k].getAllStyles().setPadding(0, 0, 0, 0);
                btn_delete[k].setTextPosition(Component.TOP);
                btn_delete[k].setBlockLead(true);
                btn_delete[k].setAutoRelease(false);
               
                btn_message[k] = new Button();
                btn_message[k].setIcon(theme.getImage("message_48px.png"));
                btn_message[k].getAllStyles().setFgColor(0xffffff, false);
                btn_message[k].getAllStyles().setMargin(0, 0, 0, 0);
                btn_message[k].getAllStyles().setPadding(0, 0, 0, 0);
                btn_message[k].setTextPosition(Component.TOP);
                btn_message[k].setBlockLead(true);
                btn_message[k].setAutoRelease(false);
                btn_message[k].addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        Log.p("\n\nSend Message button pressed for msg " + lbl_msg_details.getName() + "\n\n" + lbl_msg_details.getUIID(), 1);
                        
                        //str_id+"|"+str_name+"|"+str_phone+"|"+str_message+"|"+str_conversation_id+"|"+str_status+"|"+str_from+"|"+str_from_id+"|"+str_reference+"|"+str_cost+"|"+str_reg_timestamp
                        
                        str_id = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(0);
                        str_name = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(1);
                        str_phone = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(2);
                        str_message = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(3);
                        str_conversation_id = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(4);
                        str_status = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(5);
                        str_from = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(6);
                        str_from_id = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(7);
                        str_reference = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(8);
                        str_cost = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(9);
                        //str_reg_timestamp = StringUtil.tokenize(lbl_msg_details.getUIID(), '|').get(10);
                        
                        
                        TextArea txt_message = new TextArea(15, 75);   //3, 15
                        txt_message.setText(str_message); //"Dear "+StringUtil.tokenize(str_name, " ").get(0)+",\n"+
                        txt_message.setGrowByContent(true);
                        txt_message.setSingleLineTextArea(false);
                        txt_message.setEditable(true);
                        txt_message.setFocusable(true);
                        //txt_message.setUIID("Label");
                        txt_message.getAllStyles().setBorder(border);

                        SpanLabel slbl_instructions = new SpanLabel("Edit the message and click send.");
                        slbl_instructions.getTextAllStyles().setFgColor(0x000000, false);

                        Dialog dialog = new Dialog("");
                        dialog.setLayout(new BorderLayout());

                        Button btn_yes = new Button("Send");
                        btn_yes.addActionListener(new ActionListener()
                        {
                           public void actionPerformed(ActionEvent evt)
                           {
                                dialog.dispose();

                                Storage.getInstance().writeObject("type", "single");
                                Storage.getInstance().writeObject("msg", txt_message.getText().trim());
                                Storage.getInstance().writeObject("to", "254"+str_phone.trim().substring(str_phone.length() -9)); //lbl_phoneno.getText()
                                Storage.getInstance().writeObject("id", str_id); //lbl_phoneno.getText()
                                Storage.getInstance().writeObject("temp_firstname", StringUtil.tokenize(str_name, " ").get(0));

                                //if(lbl_phoneno.getText().trim().substring(-9) == "") //.substr($number, -9)
                                //Log.p("Sending message to ("+lbl_phoneno.getText().trim()+")"+lbl_phoneno.getText().trim().substring(2), 1);
                                //Log.p("Sending message to 254"+str_phone.trim().substring(str_phone.trim().length() -9), 1); //TODO: determine if includes country suffix before adding 254
                                System.out.println("id: "+Storage.getInstance().readObject("id"));
                                System.out.println("to: "+Storage.getInstance().readObject("to"));
                                System.out.println("msg: "+Storage.getInstance().readObject("msg"));
                                System.out.println("name: "+Storage.getInstance().readObject("temp_firstname"));


                                //str_msgtyp = Storage.getInstance().readObject("type").toString();
                                /*bool_filtercriteria = Storage.getInstance().exists("filtercriteria");
                                if(bool_filtercriteria == true)
                                {
                                    str_filtercriteria = Storage.getInstance().readObject("filtercriteria").toString();
                                    if(str_filtercriteria.equals("First Name"))
                                    {
                                    }
                                }
                                else
                                {
                                    str_filtercriteria = Storage.getInstance().readObject("filtercriteria").toString();
                                }*/


                                //sendMessage();
                                System.out.print("\nGoing to connect class to send single message to user from server.");
                                Storage.getInstance().writeObject("parameter1", "message");
                                Storage.getInstance().writeObject("parameter2", Storage.getInstance().readObject("id"));    //id
                                Storage.getInstance().writeObject("parameter3", Storage.getInstance().readObject("to"));    //to
                                Storage.getInstance().writeObject("parameter4", Storage.getInstance().readObject("msg"));   //msg
                                Storage.getInstance().writeObject("parameter5", Storage.getInstance().readObject("userid"));//uid //TODO: Replace with UDID
                                //Storage.getInstance().writeObject("parameter6", str_msgtyp); //msg
                                //Storage.getInstance().writeObject("parameter7", str_filtercriteria); //msg //TODO: Replace with UDID
                                //Storage.getInstance().writeObject("parameter8", str_filtercriteria);
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

                                Connect conn = new Connect();
                                try 
                                {
                                    conn.process();
                                } 
                                catch (Exception e) 
                                {
                                    System.out.println("Error 2: "+e);
                                    //e.printStackTrace();
                                }
                           }
                        });

                        Button btn_no = new Button("Back");
                        btn_no.addActionListener(new ActionListener()
                        {
                            public void actionPerformed(ActionEvent evt)
                            {
                               Log.p("Back button pressed...  now closing message dialog. "+str_phone, 1);
                               dialog.dispose();
                            }
                        });

                        dialog.addComponent(BorderLayout.NORTH, slbl_instructions);
                        dialog.addComponent(BorderLayout.CENTER, txt_message);
                        dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                        dialog.show();
                    }
                });

                btn_search[k] = new Button();
                btn_search[k].setIcon(theme.getImage("search_48px.png"));
                btn_search[k].getAllStyles().setFgColor(0xffffff, false);
                btn_search[k].getAllStyles().setMargin(0, 0, 0, 0);
                btn_search[k].getAllStyles().setPadding(0, 0, 0, 0);
                btn_search[k].setTextPosition(Component.TOP);
                btn_search[k].setBlockLead(true);
                btn_search[k].setAutoRelease(false);
                btn_search[k].addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        Log.p("View button pressed for msg " + k + "for " + str_name, 1);
                        
                        Dialog dlg_action = new Dialog("");
                        dlg_action.setLayout(new BorderLayout());

                        slbl_selected_message = new SpanLabel();
                        slbl_selected_message.setText(str_message);
                        slbl_selected_message.setName("slbl_selected_message");
                        slbl_selected_message.getAllStyles().setBgTransparency(0);
                        slbl_selected_message.getTextAllStyles().setFgColor(0xff);
                        slbl_selected_message.getTextComponent().setSingleLineTextArea(false);
                        slbl_selected_message.setTextBlockAlign(LEFT);
                        slbl_selected_message.setFocusable(false);
                        slbl_selected_message.getTextAllStyles().setAlignment(LEFT, false);

                        btn_back = new Button();
                        btn_back.setText("  Back  ");
                        //btn_submit.setIcon(ifont_rightArrow);
                        btn_back.setTextPosition(LEFT);
                        btn_back.setUIID("RaisedButton");
                        btn_back.setAlignment(CENTER);
                        btn_back.getStyle().setFgColor(0xffffff);
                        btn_back.getStyle().setBgColor(0x4CAF50); //4CAF50 - green
                        //btn_login.getStyle().setPadding(2, 0, 20, 20);
                        //btn_login.setWidth(width-5);
                        btn_back.getUnselectedStyle().setBgTransparency(255, false);
                        btn_back.getUnselectedStyle().setBgColor(0x4CAF50, false);
                        btn_back.getAllStyles().setPadding(2, 2, 0, 0);
                        btn_back.getAllStyles().setMargin(0, 0, (int) (0.5 * pixelsPerMM), 0);
                        btn_back.addActionListener(new ActionListener() 
                        {
                            public void actionPerformed(ActionEvent evt) 
                            {
                                dlg_action.dispose();
                            }
                        });

                        btn_send = new Button();
                        btn_send.setText("  Send  ");
                        //btn_submit.setIcon(ifont_rightArrow);
                        btn_send.setTextPosition(LEFT);
                        btn_send.setUIID("RaisedButton");
                        btn_send.setAlignment(CENTER);
                        btn_send.getStyle().setFgColor(0xffffff);
                        btn_send.getStyle().setBgColor(0xF44336); //4CAF50 - green
                        //btn_login.getStyle().setPadding(2, 0, 20, 20);
                        //btn_login.setWidth(width-5);
                        btn_send.getUnselectedStyle().setBgTransparency(255, false);
                        btn_send.getUnselectedStyle().setBgColor(0xF44336, false);
                        btn_send.getAllStyles().setPadding(2, 2, 0, 0);
                        btn_send.getAllStyles().setMargin(0, 0, 0, (int) (0.5 * pixelsPerMM));
                        btn_send.addActionListener(new ActionListener() 
                        {
                            public void actionPerformed(ActionEvent evt) 
                            {
                                dlg_action.dispose();
                            }
                        });

                        dlg_action.add(BorderLayout.NORTH, slbl_selected_message);
                        //dlg_action.add(BorderLayout.CENTER, txtf_amount);
                        dlg_action.add(BorderLayout.SOUTH, BorderLayout.centerCenterEastWest(null, btn_send, btn_back));

                        //dlg_action.show(int_dispH /2, int_dispH /2, int_dispW/2, int_dispW/2);
                        //dlg_action.showPopupDialog(btn_deposit[k]);
                        dlg_action.setDisposeWhenPointerOutOfBounds(true);
                        dlg_action.show();
                    }
                });

                cnt_id[k] = new Container(new FlowLayout(LEFT, CENTER));
                cnt_id[k].setWidth(20);
                cnt_id[k].getAllStyles().setMargin(0, 0, 0, 0);
                cnt_id[k].getAllStyles().setPadding(0, 0, (int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM));
                cnt_id[k].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                cnt_name[k] = new Container(new FlowLayout(LEFT, CENTER));
                cnt_name[k].setWidth(450);
                cnt_name[k].getAllStyles().setMargin(0, 0, 0, 0);
                cnt_name[k].getAllStyles().setPadding(0, 0, (int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM));
                cnt_name[k].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                cnt_conversation_id[k] = new Container(new FlowLayout(CENTER, CENTER));
                //cnt_amount[k].getAllStyles().
                cnt_conversation_id[k].setWidth(50);
                cnt_conversation_id[k].getAllStyles().setMargin(0, 0, 0, 0);
                cnt_conversation_id[k].getAllStyles().setPadding(0, 0, (int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM));
                cnt_conversation_id[k].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                cnt_status[k] = new Container(new FlowLayout(LEFT, CENTER));
                //cnt_amount[k].getAllStyles().
                cnt_status[k].setWidth(50);
                cnt_status[k].getAllStyles().setMargin(0, 0, 0, 0);
                cnt_status[k].getAllStyles().setPadding(0, 0, (int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM));
                cnt_status[k].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                
                cnt_actions[k] = new Container(new FlowLayout(LEFT, CENTER));
                cnt_actions[k].setLeadComponent(null);
                cnt_actions[k].setWidth(50);
                cnt_actions[k].getAllStyles().setMargin(0, 0, 0, 0);
                cnt_actions[k].getAllStyles().setPadding(0, 0, (int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM));
                cnt_actions[k].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                cnt_actions[k].add(btn_message[k]);
                cnt_actions[k].add(btn_search[k]);
                //cnt_actions[k].add(btn_delete[k]);
                

                cnt_id[k].add(lbl_id[k]);
                cnt_name[k].add(slbl_name[k]);
                cnt_conversation_id[k].add(FlowLayout.encloseCenterMiddle(lbl_conversation_id[k]));
                cnt_status[k].add(lbl_status[k]);
                
                //cnt_actions[k].add(); //lbl_deposit[k], btn_withdraw[k], btn_transfer[k], lbl_delete[k]

                cnt_tablerow[k] = new Container();
                cnt_tablerow[k].setLeadComponent(null);
                cnt_tablerow[k].setScrollableY(false);
                cnt_tablerow[k].getAllStyles().setPadding(0, 0, 0, 0);
                cnt_tablerow[k].setLayout(laytab);

                //Add to form only the collections
                //if(str_category_id.equals("1") && str_user_id.equals(Storage.getInstance().readObject("userid").toString())){}
                cnt_tablerow[k].add(laytab.createConstraint().widthPercentage(10), cnt_id[k]);
                cnt_tablerow[k].add(laytab.createConstraint().widthPercentage(30), cnt_name[k]);
                cnt_tablerow[k].add(laytab.createConstraint().widthPercentage(20), cnt_conversation_id[k]);
                cnt_tablerow[k].add(laytab.createConstraint().widthPercentage(20), cnt_status[k]);
                cnt_tablerow[k].add(laytab.createConstraint().widthPercentage(20), cnt_actions[k]);
                
    
                bool_pagesize = Storage.getInstance().exists("pagesize");
                if(bool_pagesize == true)
                {
                    str_pagesize = Storage.getInstance().readObject("pagesize").toString();
                    int_pagesize = Integer.parseInt(str_pagesize);     //
                    
                    bool_end_msg = Storage.getInstance().exists("end_msg");
                    if(bool_end_msg == true)
                    {
                        str_end_msg = Storage.getInstance().readObject("end_msg").toString();
                        int_end_msg = Integer.parseInt(str_end_msg);       //2475
                        
                        int_msgid = Integer.parseInt(str_id);
                        if(int_msgid <= (int_end_msg) && int_msgid >= (int_end_msg-int_pagesize+1) )  //2485 >= (2485 - 4)   --> 2481   |   2481 >= (2481 - 4)   -->  2477
                        {//2475 <= (2476 - 1)   2475 -->   |   2475 >= (2476 - 10)   -->  2466
                            Log.p("A. Adding Message - "+(k+1)+". "+str_id, 1);
                            cnt_tablebody.add(cnt_tablerow[k]);

                            //Storage.getInstance().writeObject("end_msg", String.valueOf(int_msgid));

                            obj_line = new JSONObject();
                            obj_line.put("id", str_id);
                            obj_line.put("conversation_id", str_conversation_id);
                            obj_line.put("from", str_from);
                            obj_line.put("to", str_phone);
                            obj_line.put("to_name", str_name);
                            obj_line.put("from_id", str_from_id);
                            obj_line.put("message", str_message);
                            obj_line.put("reference", "");
                            obj_line.put("cost", str_cost);
                            obj_line.put("status", str_status);
                            obj_line.put("reg_timestamp", str_reg_timestamp);

                            //System.err.println("============= "+obj_line.toString());

                            arr_page.put(obj_line);
                        }
                    }
                    else
                    {
                        str_start_msg = Storage.getInstance().readObject("start_msg").toString();
                        int_start_msg = Integer.parseInt(str_start_msg);
                        
                        int_end_msg = int_start_msg;  //int_start_msg+1
                        
                    
                        int_msgid = Integer.parseInt(str_id);
                        if(int_msgid >= (int_start_msg-int_pagesize+1))
                        {//   2485   >= 2485 - 10  --->
                            Log.p("B.1 Adding Message - "+(k+1)+". "+str_id, 1);
                            cnt_tablebody.add(cnt_tablerow[k]);

                            //Storage.getInstance().writeObject("end_msg", String.valueOf(int_msgid));

                            obj_line = new JSONObject();
                            obj_line.put("id", str_id);
                            obj_line.put("conversation_id", str_conversation_id);
                            obj_line.put("from", str_from);
                            obj_line.put("to", str_phone);
                            obj_line.put("to_name", str_name);
                            obj_line.put("from_id", str_from_id);
                            obj_line.put("message", str_message);
                            obj_line.put("reference", "");
                            obj_line.put("cost", str_cost);
                            obj_line.put("status", str_status);
                            obj_line.put("reg_timestamp", str_reg_timestamp);

                            //System.err.println("============= "+obj_line.toString());

                            arr_page.put(obj_line);
                        }
                    } 
                    
                    
                }
                else
                {
                    /*bool_pagesize = Storage.getInstance().exists("pagesize");
                    if(bool_pagesize == true)
                    {
                        str_pagesize = Storage.getInstance().readObject("pagesize").toString();
                        int_pagesize = Integer.parseInt(str_pagesize);
                    }
                    else
                    {
                        int_pagesize = 9;
                    }*/
                    
                    int_pagesize = 9;
                    
                    int_msgid = Integer.parseInt(str_id);
                    if(int_msgid >= (int_start_msg-int_pagesize))
                    {//   2485   >= 2485 - 10  --->
                        Log.p("B.2 Adding Message - "+(k+1)+". "+str_id, 1);
                        cnt_tablebody.add(cnt_tablerow[k]);
                        
                        //Storage.getInstance().writeObject("end_msg", String.valueOf(int_msgid));
                        
                        obj_line = new JSONObject();
                        obj_line.put("id", str_id);
                        obj_line.put("conversation_id", str_conversation_id);
                        obj_line.put("from", str_from);
                        obj_line.put("to", str_phone);
                        obj_line.put("to_name", str_name);
                        obj_line.put("from_id", str_from_id);
                        obj_line.put("message", str_message);
                        obj_line.put("reference", "");
                        obj_line.put("cost", str_cost);
                        obj_line.put("status", str_status);
                        obj_line.put("reg_timestamp", str_reg_timestamp);
                        
                        //System.err.println("============= "+obj_line.toString());
                        
                        arr_page.put(obj_line);
                    }
                }
                
                //TODO: Add below when reading from cached page from storagee.g page_1.json that is created and deleted on the fly.
                /*if(k == (arr.length()-1))
                {
                    str_offset = str_id;
                    Storage.getInstance().writeObject("offset", str_offset);
                    System.err.println("Writing Offset: "+str_offset);
                }*/
                
                /*if(k == 0)
                {
                    Storage.getInstance().writeObject("end_msg", str_id);
                }*/
                
                //if(str_id == )
                //str_end_msg
                
                //cnt_tablebody.add(cnt_tablerow[k]);
                

                //k++;
            }
            
            
            
            bool_pagecurr = Storage.getInstance().exists("pagecurr");
            if(bool_pagecurr == true)
            {
                str_pagecurr = Storage.getInstance().readObject("pagecurr").toString();
            }
            else
            {
                str_pagecurr = "1";
                Storage.getInstance().writeObject("pagecurr", str_pagecurr);
            }

            System.out.println("\nWriting page_"+str_pagecurr+" to Storage: \n");  //+arr_page.toString()+
            Storage.getInstance().writeObject("page_"+str_pagecurr+".json", arr_page.toString());
        } 
        catch (Exception e) 
        {
            System.out.println("Error 1: " + e);
            e.printStackTrace();
        }

        Label lbl_addSacco = new Label("X");
        lbl_addSacco.getUnselectedStyle().setAlignment(Component.CENTER);
        lbl_addSacco.getUnselectedStyle().setBorder(RoundBorder.create());
        //cnt_body.add(lbl_addSacco);

        cnt_tablebody.revalidate();
        cnt_tablebody.repaint();

        cont_body.add(cnt_tablehead);
        cont_body.add(cnt_tablebody);
        
        btn_back = new Button("Back");
        btn_back.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("Back button pressed, going back to Main Menu.", 1);
                MainMenu mainmenu = new MainMenu();
                mainmenu.showMainMenu();
            }
        });
        
        
        //Page Count
        Container cnt_pagecount = new Container();
        cnt_pagecount.getAllStyles().setMargin((int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM), 0, 0);
        cnt_pagecount.getAllStyles().setPadding(0, 0, 0, 0);
        
        
        
        
        bool_pagecurr = Storage.getInstance().exists("pagecurr");
        if(bool_pagecurr == true)
        {
            //str_pageprev = Storage.getInstance().readObject("pageprev").toString();
            str_pagecurr = Storage.getInstance().readObject("pagecurr").toString();
        }
        else
        {
            str_pagecurr = "1";
            Storage.getInstance().writeObject("pagecurr", str_pagecurr);
        }
           
        bool_pagesize = Storage.getInstance().exists("pagesize");
        if(bool_pagesize == true)
        {
            str_pagesize = Storage.getInstance().readObject("pagesize").toString();
            int_pagesize = Integer.parseInt(str_pagesize);
            
            str_start_msg = Storage.getInstance().readObject("start_msg").toString();
            int_start_msg = Integer.parseInt(str_start_msg);
            
            
            int_end_msg = int_start_msg-int_pagesize;
            str_end_msg = String.valueOf(int_end_msg);
            
            System.err.println("\nWriting end mesg to storage: "+str_end_msg);
            Storage.getInstance().writeObject("end_msg", str_end_msg);
            
        }
        else
        {   //TODO: Change these to float so as to get an accurate page count e.g 0.8 pages should be considered a page.
            str_pagesize = "10";
            int_pagesize = Integer.parseInt(str_pagesize);
            
            str_start_msg = Storage.getInstance().readObject("start_msg").toString();
            int_start_msg = Integer.parseInt(str_start_msg);
            
            
            int_end_msg = int_start_msg-int_pagesize;
            str_end_msg = String.valueOf(int_end_msg);
            
            System.err.println("\nWriting end mesg to storage: "+str_end_msg);
            Storage.getInstance().writeObject("end_msg", str_end_msg);
        }
        
        int_pagesize = Integer.parseInt(str_pagesize);
        str_no_messages = "50"; //Storage.getInstance().readObject("no_messages").toString();  //TODO: Make dynamic by picking from text file writen in from server.
        int_no_messages = Integer.parseInt(str_no_messages);

        int_pagettls = int_no_messages/int_pagesize; 
        str_pagettls = String.valueOf(int_pagettls);
        System.err.println(int_pagettls+" = "+int_no_messages+" / "+int_pagesize);      //28 = 288 / 10
        
        str_start_msg = Storage.getInstance().readObject("start_msg").toString();
        str_end_msg = Storage.getInstance().readObject("end_msg").toString();
        
        System.err.println("Start Msg: "+str_start_msg);                                //Start Msg: 2485
        System.err.println("End Msg: "+str_end_msg);                                    //End Msg: 2476
        
        
        Label lbl_pagecount = new Label("Page "+str_pagecurr+" of "+str_pagettls);
        lbl_pagecount.setVerticalAlignment(CENTER);
        lbl_pagecount.getAllStyles().setFgColor(0xffffff);
        lbl_pagecount.getAllStyles().setMargin((int) (1.5 * pixelsPerMM), (int) (1.5 * pixelsPerMM), 0, 0);
        cnt_pagecount.add(lbl_pagecount);
        
        //Pagination
        Container cnt_pagination = new Container();
        cnt_pagination.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        cnt_pagination.getAllStyles().setMargin((int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM), 0, 0);
        cnt_pagination.getAllStyles().setPadding(0, 0, 0, 0);
        
        //btn_page = new Button[int_no_messages];
        
        /*
        for(i=0; i < int_no_messages; i++)
        {
            btn_page[i] = new Button();
            btn_page[i].setText(String.valueOf((i+1)));
            btn_page[i].getAllStyles().setFgColor(0xff, false);
            btn_page[i].getAllStyles().setBgColor(0x448d21, false); //0x929292
            btn_page[i].getAllStyles().setBgTransparency(255);
            btn_page[i].getAllStyles().setMargin(0, 0, (int) (0.05 * pixelsPerMM), (int) (0.05 * pixelsPerMM));
            //btn_page[i].getAllStyles().setPadding((int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM));
            
            
            cnt_pagination.add(btn_page[i]);        
        }
        */
        
        btn_prev = new Button("Prev");
        btn_prev.setUIID("RaisedButton");
        //btn_prev.getAllStyles().setMargin(0, 0, 0, (int) (0.05 * pixelsPerMM));
        btn_prev.getAllStyles().setPadding(0, 0, 0, 0);
        btn_prev.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("Previous button pressed", 1);
                
                bool_pagecurr = Storage.getInstance().exists("pagecurr");
                if(bool_pagecurr == true)
                {
                    str_pagecurr = Storage.getInstance().readObject("pagecurr").toString();
                    int_pagecurr = Integer.parseInt(str_pagecurr);
                    
                    if(int_pagecurr > 1)
                    {
                        Log.p("Decrimenting current page count by 1.", 1);
                        
                        int_pagecurr = Integer.parseInt(str_pagecurr)-1;
                        Storage.getInstance().writeObject("pagecurr", String.valueOf(int_pagecurr));
                        
                        Log.p("Going to Messages Menu to reload messages.json with new stopper so as to show next page.", 1);
                        fm_main.setTransitionOutAnimator(CommonTransitions.createUncover(CommonTransitions.SLIDE_HORIZONTAL, false, 300));
                        
                        
                        str_pagesize = Storage.getInstance().readObject("pagesize").toString();
                        int_pagesize = Integer.parseInt(str_pagesize);
                        
                        str_end_msg = Storage.getInstance().readObject("end_msg").toString();
                        int_end_msg = Integer.parseInt(str_end_msg);
                        
                        str_start_msg = Storage.getInstance().readObject("start_msg").toString();
                        int_start_msg = Integer.parseInt(str_start_msg)+int_pagesize;
                        
                        //Storage.getInstance().writeObject("start_msg", String.valueOf(int_start_msg));
                        
                        
                        Storage.getInstance().writeObject("end_msg", String.valueOf(int_start_msg));
                        
                        

                        MessagesMenu ujumbe = new MessagesMenu();
                        ujumbe.showMainMenu();
                    }
                    else
                    {
                    }
                }
                else
                {  
                } 
            }
        });
        
        btn_next = new Button("Next");
        btn_next.setUIID("RaisedButton");
        //btn_next.getAllStyles().setMargin(0, 0, (int) (0.05 * pixelsPerMM), 0);
        btn_next.getAllStyles().setPadding(0, 0, 0, 0);
        btn_next.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("Next button pressed.", 1);
                //$prev = $page - 1;							
    	        //$next = $page + 1;
                
                Log.p("Incrimenting current page count by 1.", 1);
                bool_pagecurr = Storage.getInstance().exists("pagecurr");
                if(bool_pagecurr == true)
                {
                    str_pagecurr = Storage.getInstance().readObject("pagecurr").toString();
                    int_pagecurr = Integer.parseInt(str_pagecurr);
                    
                    int_pagecurr = int_pagecurr+1;
                    
                    Storage.getInstance().writeObject("pagecurr", String.valueOf(int_pagecurr));
                }
                else
                {
                    str_pagecurr = "1";
                    int_pagecurr = Integer.parseInt(str_pagecurr)+1;
                    
                    Storage.getInstance().writeObject("pagecurr", String.valueOf(int_pagecurr));
                }
                
                Storage.getInstance().writeObject("pagesize", str_pagesize);
                
                Log.p("Going to Messages Menu to reload messages.json with new stopper so as to show next page.", 1);
                MessagesMenu ujumbe = new MessagesMenu();
                ujumbe.showMainMenu();
            }
        });
        
        cnt_pagination.add(btn_prev); 
        cnt_pagination.add(btn_next); 
        
        //Page Size
        Container cnt_pagesize = new Container();
        cnt_pagesize.getAllStyles().setMargin((int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM), 0, 0);
        
        Label lbl_show = new Label("Show");
        lbl_show.setVerticalAlignment(CENTER);
        lbl_show.getAllStyles().setFgColor(0xffffff);
        lbl_show.getAllStyles().setMargin((int) (1.5 * pixelsPerMM), (int) (1.5 * pixelsPerMM), 0, 0);
        
        lbl_pagesize = new Label();
        lbl_pagesize.setText(str_pagesize);
        lbl_pagesize.setTextPosition(LEFT);
        lbl_pagesize.setIcon(ifont_down);
        lbl_pagesize.setVerticalAlignment(CENTER);
        lbl_pagesize.getAllStyles().setFgColor(0xffffff);
        lbl_pagesize.getAllStyles().setMargin((int) (1.5 * pixelsPerMM), (int) (1.5 * pixelsPerMM), (int) (0.05 * pixelsPerMM), (int) (0.05 * pixelsPerMM));
        lbl_pagesize.getAllStyles().setBorder(border);
        lbl_pagesize.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                showPageSizeDlg();
            }
        });
        
        Label lbl_entries = new Label("Msgs");
        lbl_entries.setVerticalAlignment(CENTER);
        lbl_entries.getAllStyles().setFgColor(0xffffff);
        lbl_entries.getAllStyles().setMargin((int) (1.5 * pixelsPerMM), (int) (1.5 * pixelsPerMM), 0, 0);
        
        cnt_pagesize.add(lbl_show);
        cnt_pagesize.add(lbl_pagesize);
        cnt_pagesize.add(lbl_entries);
        
        

        //Footer
        cnt_tablefoot = new Container();
        cnt_tablefoot.setLayout(new BorderLayout());
        //cnt_foot.getAllStyles().setBgTransparency(0);
        //cnt_btn.setLayout(new BorderLayout());
        //cnt_foot.getStyle().setBgColor(0x000000);
        //cnt_foot.getStyle().setFgColor(0xF18C24);
        //cnt_foot.setLayout(new GridLayout(1, 4));
        //cnt_btns.setUnselectedStyle(sty_lg);
        //cnt_btns.setSelectedStyle(sty_lg);
        //cnt_foot.getAllStyles().setMargin((int) (1.0 * pixelsPerMM), (int) (1.0 * pixelsPerMM), 0, 0);
        //cnt_foot.getAllStyles().setPadding(0, 0, 0, 0);
        cnt_tablefoot.getAllStyles().setBgTransparency(155);
        cnt_tablefoot.getStyle().setBgColor(0x000000);
        cnt_tablefoot.getStyle().setFgColor(0xffffff);
        cnt_tablefoot.add(BorderLayout.WEST, cnt_pagecount);
        cnt_tablefoot.add(BorderLayout.CENTER, FlowLayout.encloseCenter(cnt_pagination));
        cnt_tablefoot.add(BorderLayout.EAST, cnt_pagesize);
        
        cont_body.add(cnt_tablefoot);
      
      
      MainMenu nyumbani = new MainMenu();
      //nyumbani.fm_main.removeComponent(cont_header);
      
      //fm_main.addComponent(BorderLayout.NORTH, cont_header);
      //fm_main.addComponent(BorderLayout.CENTER, cont_body);
      //fm_main.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(cont_body, cnt_foot));
      //fm_main.addComponent(BorderLayout.SOUTH, cnt_footer);
      
       Command backCommand = new Command("Logout") 
        {
            public void actionPerformed(ActionEvent ev) 
            {
                //Display.getInstance().exitApplication();
            }
        };
        
        MainMenu.cont_header.remove();
        MainMenu.lbl_header.setText("Messages Menu");
        
        fm_main.addComponent(BorderLayout.NORTH, MainMenu.cont_header);
        fm_main.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(cont_body));
        //fm_main.addComponent(BorderLayout.SOUTH, cnt_foot);
        //fm_main.addComponent(BorderLayout.SOUTH, cnt_btn);
        //fm_main.addComponent(BorderLayout.SOUTH, cnt_foot);   //LayeredLayout.encloseIn(cnt_btn, FlowLayout.encloseRight(btn_bubble))
        fm_main.setTransitionOutAnimator(CommonTransitions.createUncover(CommonTransitions.SLIDE_HORIZONTAL, true, 300));

        fm_main.repaint();
        fm_main.revalidate();
        
        fm_main.setLeadComponent(null);
        fm_main.show();
   }
    
  
    public void showPageSizeDlg()
    {
        Log.p("Showing pagesize dialog.", 1);
        Dialog dlg_pagesize = new Dialog();
        dlg_pagesize.setLayout(new BorderLayout());
        dlg_pagesize.getTitleArea().setPreferredSize(new Dimension(0, 0));
        dlg_pagesize.getTitleArea().removeAll();
        
        Label lbl_5msgs = new Label();
        lbl_5msgs.getAllStyles().setPaddingBottom((int)(2.5 * pixelsPerMM));
        lbl_5msgs.setText("5");
        lbl_5msgs.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("5 label pressed.");
                Storage.getInstance().writeObject("pagesize", "5");
                lbl_pagesize.setText("5");
                
                Storage.getInstance().deleteStorageFile("pagecurr");
                Storage.getInstance().deleteStorageFile("start_msg");
                Storage.getInstance().deleteStorageFile("end_msg");
                
                MessagesMenu ujumbe = new MessagesMenu();
                ujumbe.showMainMenu();
            }
        });
        
        Label lbl_10msgs = new Label();
        lbl_10msgs.getAllStyles().setPaddingBottom((int)(2.5 * pixelsPerMM));
        lbl_10msgs.setText("10");
        lbl_10msgs.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("10 label pressed.");
                Storage.getInstance().writeObject("pagesize", "10");
                lbl_pagesize.setText("10");
                
                Storage.getInstance().deleteStorageFile("pagecurr");
                Storage.getInstance().deleteStorageFile("start_msg");
                Storage.getInstance().deleteStorageFile("end_msg");
                
                MessagesMenu ujumbe = new MessagesMenu();
                ujumbe.showMainMenu();
            }
        });
        
        Label lbl_15msgs = new Label();
        lbl_15msgs.getAllStyles().setPaddingBottom((int)(2.5 * pixelsPerMM));
        lbl_15msgs.setText("15");
        lbl_15msgs.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("15 label pressed.");
                Storage.getInstance().writeObject("pagesize", "15");
                lbl_pagesize.setText("15");
                
                Storage.getInstance().deleteStorageFile("pagecurr");
                Storage.getInstance().deleteStorageFile("start_msg");
                Storage.getInstance().deleteStorageFile("end_msg");
                
                MessagesMenu ujumbe = new MessagesMenu();
                ujumbe.showMainMenu();
            }
        });
        
        Label lbl_25msgs = new Label();
        lbl_25msgs.getAllStyles().setPaddingBottom((int)(2.5 * pixelsPerMM));
        lbl_25msgs.setText("25");
        lbl_25msgs.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("25 label pressed.");
                Storage.getInstance().writeObject("pagesize", "25");
                lbl_pagesize.setText("25");
                
                Storage.getInstance().deleteStorageFile("pagecurr");
                Storage.getInstance().deleteStorageFile("start_msg");
                Storage.getInstance().deleteStorageFile("end_msg");
                
                MessagesMenu ujumbe = new MessagesMenu();
                ujumbe.showMainMenu();
            }
        });
        
        Label lbl_50msgs = new Label();
        lbl_50msgs.getAllStyles().setPaddingBottom((int)(2.5 * pixelsPerMM));
        lbl_50msgs.setText("50");
        lbl_50msgs.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("50 label pressed.");
                Storage.getInstance().writeObject("pagesize", "50");
                lbl_pagesize.setText("50");
                
                Storage.getInstance().deleteStorageFile("pagecurr");
                Storage.getInstance().deleteStorageFile("start_msg");
                Storage.getInstance().deleteStorageFile("end_msg");
                
                MessagesMenu ujumbe = new MessagesMenu();
                ujumbe.showMainMenu();
            }
        });
        
        Label lbl_100msgs = new Label();
        lbl_100msgs.getAllStyles().setPaddingBottom((int)(2.5 * pixelsPerMM));
        lbl_100msgs.setText("100");
        lbl_100msgs.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("100 label pressed.");
                Storage.getInstance().writeObject("pagesize", "100");
                lbl_pagesize.setText("100");
                
                Storage.getInstance().deleteStorageFile("pagecurr");
                Storage.getInstance().deleteStorageFile("start_msg");
                Storage.getInstance().deleteStorageFile("end_msg");
                
                MessagesMenu ujumbe = new MessagesMenu();
                ujumbe.showMainMenu();
            }
        });
        
        Container cnt_pagesizes = new Container();
        cnt_pagesizes.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_pagesizes.add(lbl_5msgs);
        cnt_pagesizes.add(lbl_10msgs);
        cnt_pagesizes.add(lbl_15msgs);
        cnt_pagesizes.add(lbl_25msgs);
        cnt_pagesizes.add(lbl_50msgs);
        cnt_pagesizes.add(lbl_100msgs);
        
        dlg_pagesize.add(BorderLayout.NORTH, cnt_pagesizes);
        dlg_pagesize.showPopupDialog(lbl_pagesize);
    }
  
    
}