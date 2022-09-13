package com.mobitribe.hesabu;

import com.codename1.capture.Capture;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.components.Accordion;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.FloatingHint;
import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.File;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.io.Util;
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
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.validation.Validator;
import com.codename1.util.StringUtil;
//import com.tribedigital.omega.Utilz.Images;
//import com.tribedigital.omega.Utilz.Synchronise;
import java.util.Timer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Map;
import java.util.Random;

import com.codename1.io.FileSystemStorage;
import com.codename1.l10n.L10NManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.processing.Result;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import static com.codename1.ui.Component.TOP;
import static com.codename1.ui.TextArea.ANY;
import static com.codename1.ui.TextArea.NUMERIC;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.list.GenericListCellRenderer;
import static com.codename1.ui.plaf.Style.BACKGROUND_NONE;
import com.codename1.ui.spinner.Picker;
import static com.mobitribe.hesabu.Connect.str_host;
import java.util.Date;
import java.util.Hashtable;
//import java.util.Locale;

public class MainMenu 
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
    private Label lbl_humberger_icon, lbl_avatar_icon, lbl_messages_icon;
    public static Label lbl_header;
    private Label lbl_footer;
    public static Label lbl_logo;
       
    private Label lbl_Tbar;
    
    
    
    //classes
    //private SplashScreen cls_splash;
    //private Images cls_images;
    
    //CONTAINERS
    private Container cont_language, cont_rbEnglish, cont_rbSwahili;
    private Container cont_title;
    public static Container cont_header, cnt_topbar;
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
    public static TextField txta_username;
    public static TextField txta_password;
    TextField txf_jinatumizi;
    public TextField txf_nywila;
    
    //STORAGES
    //private Storage storage = Storage.getInstance();
    
    //FONTS
    private Font font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
    
    //int displayWidth = Display.getInstance().getDisplayWidth();
    //int displayHeight = Display.getInstance().getDisplayHeight();
    
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
    
    private String str_Language, str_login_status, str_data;
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
    
    private Container cnt_description, cnt_envelope_ttl, cnt_pay_option, cnt_smsto, cnt_refno;
    private SpanLabel spnlbl_description, spnlbl_description1, spnlbl_description2, spnlbl_description3, spnlbl_description4;
    
    private Label lbl_envelope_ttl, lbl_payoption, lbl_smsto, lbl_refno;
    private Label lbl_envelope_ttl_val, lbl_payoption_val, lbl_smsto_val, lbl_refno_val;
    
    private FontImage ifont_burger, ifont_avatar, ifont_messages, ifont_close;
    
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
    public static TextField txtf_trxno, txtf_memberno, txtf_firstname, txtf_middlename, txtf_other_name, txtf_lastname, txtf_phone, txtf_email, txtf_tithe, txtf_offering, txtf_building, txtf_budget, txtf_tithev, txtf_offeringv, txtf_buildingv, txtf_budgetv;
    private Validator val_payform, val_payform1, val_payform3, val_,val_firstname, val_lastname, val_memberno, val_phone, val_email;
    private FloatingHint fhint_firstname, fhint_lastname;
    
    private SpanLabel spl_message;
    
    private String str_country;
    
    private String str_Login_staus;
    private boolean bool_Login_staus;
    
    //DIALOG
    private Dialog dlg_login, dlg_accounts, dlg_payments, dlg_payments2, dlg_map;
    
    public static Dialog dlg_payments3;
    
    
    int int_dispW = Display.getInstance().getDisplayWidth();
    int int_dispH = Display.getInstance().getDisplayHeight();
    
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
    
    private Label lbl_trxn_date, lbl_blood_type, lbl_heamoglobin, lbl_weight, lbl_height, lbl_bmi, lbl_blood_pressure, lbl_dietary_need, lbl_food_allergies, lbl_medicine_allergies, lbl_muscle_strength, lbl_special_medical_condition;
    private TextField txtf_trxn_date, txtf_startdate, txtf_start, txtf_blood_type, txtf_heamoglobin, txtf_weight, txtf_height, txtf_bmi, txtf_blood_pressure, txtf_dietary_need, txtf_food_allergies, txtf_medicine_allergies, txtf_muscle_strength, txtf_special_medical_condition;
    
    private String str_collection, str_start, str_amount;
    
    public String str_users_id, str_users_memnos, str_users_family_id, str_users_firstname, str_users_middlename, str_users_lastname, 
            str_users_nickname, str_users_title, str_users_userid, str_users_role, str_users_level, str_users_birth_date, str_users_age, 
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
    private String str_id, str_trxno, str_trxdt, str_trxtm, str_inst, str_refno, str_memnu, str_memno, str_family_id, str_spouse_id, str_temp_family_id, str_temp_spouse_id, str_temp_gender, str_title, str_name, str_firstname, str_middlename, str_lastname, str_other_name, str_fname, str_mname, str_oname, str_lname, str_gender, str_dob, str_idpp, str_aob, str_btn_back, str_btn_ok, str_email, str_phone, str_nangos, str_fnhint, str_unhint, str_pwhint, str_organization, str_department;
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
    boolean bool_inst, bool_refno, bool_trxno, bool_trxdt, bool_memno, bool_fname, bool_mname, bool_oname, bool_lname, bool_phone, bool_email, bool_family_id;
    private Label lbl_removeTithe, lbl_removeOffering, lbl_removeBuilding, lbl_removeBudget, lbl_removeKitty;
    private Label lbl_items, lbl_totals;
    
    private GridLayout laygrid_item;
    
    private Border border2;
    private Style sty, s1, s2, sty_icontbar;
    private Container cnt_building;
    private TextField txtf_building_roof, txtf_building_premix, txtf_building_wall, txtf_building_elec, txtf_building_plumb, txtf_building_pulpit, txtf_building_window, txtf_buildingv_roof, txtf_buildingv_premix, txtf_buildingv_wall, txtf_buildingv_elec, txtf_buildingv_plumb, txtf_buildingv_pulpit, txtf_buildingv_window;
    
    private String str_new_item_nme, str_new_item_val;
    
    private Label lbl_info, lbl_clear1, lbl_clear2, lbl_clear3;
    
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
    
    private Label lbl_id_column, lbl_date_column, lbl_code_column, lbl_amount_column, lbl_currency_column, lbl_method_column, lbl_actions_column;
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
    
    private String str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr;
    private boolean bool_itemopm, bool_itemop, bool_itemopv, bool_itemopd, bool_itemopr;
    
    private L10NManager l10n;
        
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
    
    
    public MainMenu()
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
      
      l10n = L10NManager.getInstance();
      l10n.setLocale("KE", "EN");
      
      
      
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
       
       font_medium_uline = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_UNDERLINED, Font.SIZE_MEDIUM);
        font_small_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL);
        font_medium_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
        font_large_bold = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
        font_small_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        font_medium_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
        font_large_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);
               
      fm_main = new Form();
      fm_main.setName("fm_main");
      fm_main.setTitle("");
      fm_main.getTitleArea().setPreferredSize(new Dimension(0, 0));
      fm_main.getTitleArea().removeAll();
      fm_main.setLayout(new BorderLayout());
      ((BorderLayout)fm_main.getLayout()).setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER);
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
      
      
      /*
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
      */
      
    
    try 
    {
        /*
        String str_messages = (String) Storage.getInstance().readObject("messages"+".json");
        //Log.p("Reading >>>>>>>>>>>>>> "+str_messages+"<<<<<<<<<<< .json from storage.", 1);

        byte[] bytes_messages = str_messages.getBytes();

        JSONObject obj = new JSONObject(str_messages);
        //String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        //System.out.println(pageName);
        
        JSONArray arr = obj.getJSONArray("data");
        for (int i = 0; i < arr.length(); i++) 
        {
            String str_to_name = arr.getJSONObject(i).getString("to_name");
            System.out.println(str_to_name);
        }
        */

        
        //JSONParser json_parser = new JSONParser();
        //Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(bytes_messages), "UTF-8"));
        
        //String str_respdata = map_response.get("data").toString();
        //System.out.println("Data: "+str_respdata);
    
        /*JSONArray json_arr = new JSONArray(str_respdata);
        for (k = 0; k < json_arr.length(); k++) 
        {
            //Integer int_id = json_arr.getJSONObject(k).getInt("id");
            //String  str_id = json_arr.getJSONObject(k).getString("id");
            String  str_ref = json_arr.getJSONObject(k).getString("reference");

            Log.p("Nessage ID:  "+(k+1)+". "+str_ref, 1);
        }*/
    } 
    catch (Exception e) 
    {
        System.err.println("Error: "+e);
    }
      
      
      
      fm_main.getTitleStyle().setPadding(0, 0, 0, 0);
      fm_main.getTitleStyle().setBgColor(0x000000, false);
      fm_main.getTitleComponent().getStyle().setBgColor(0x000000);
      //fm_login.setPreferredW(width);
      fm_main.setScrollable(false);
      fm_main.getStyle().setPadding(0, 0, 0, 0);
      fm_main.getStyle().setMargin(0, 0, 0, 0);
      
      
      
      sty_icon = fm_main.getUIManager().getComponentStyle("Title"); 
      sty_icon.setFgColor(0xffffff);
      sty_icon.setBgColor(0xffffff);
      sty_icon.setBgTransparency(0, false);
      
      sty_icon_dlgPay = fm_main.getUIManager().getComponentStyle("Title"); sty_icon_dlgPay.setFgColor(0xC0C0C0);
      ifont_burger = FontImage.createMaterial(FontImage.MATERIAL_MENU, sty_icon, 4); //MATERIAL_MORE_HORIZ
      ifont_avatar = FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty_icon, 4); //MATERIAL_MORE_HORIZ 
      ifont_messages = FontImage.createMaterial(FontImage.MATERIAL_MESSAGE, sty_icon, 4); 
      ifont_close = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, sty_icon, 4);
      
        Image img_profilePic = theme.getImage("logo.png"); //logo-official.jpg
        Image img_mask = theme.getImage("round-mask.png");
        img_mask = img_mask.scaledHeight(img_mask.getHeight() / 4 * 3);
        img_profilePic = img_profilePic.fill(img_mask.getWidth(), img_mask.getHeight());
        Label lbl_profilePicLabel = new Label("  SDA Church Karengata", img_profilePic, "SideMenuTitle");
        lbl_profilePicLabel.setMask(img_mask.createMask());

        Container cnt_sidemenuTop = BorderLayout.center(lbl_profilePicLabel);
        cnt_sidemenuTop.setUIID("SidemenuTop");
      
      
        btn_home = new Button("Home");
        btn_home.setUIID("SideCommand");
        FontImage.setMaterialIcon(btn_home, FontImage.MATERIAL_HOME);
        btn_home.setPressedStyle(btn_home.getUnselectedStyle());
        btn_home.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("Home button pressed.", 1);
                
                //Log.p("Setting list filter setting in storage.", 1);
                //Storage.getInstance().writeObject("listcriteria", "members");
                
                Log.p("Deleting listfilter setting from storage.", 1);
                Storage.getInstance().deleteStorageFile("listcriteria");
                
                Log.p("Reloading home page.", 1);
                MainMenu homifier = new MainMenu();
                homifier.showMainMenu();
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
                            Storage.getInstance().writeObject("screen", "departments");
                            DepartmentsMenu deparmentor = new DepartmentsMenu();
                            deparmentor.showMainForm();
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
                        //showLoginDialog();
                    }
                }
                else
                {
                    System.out.println("User has no login status.");
                    
                    storage.writeObject("screen", "departments");
                    //showLoginDialog();
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
        fm_main.getToolbar().addComponentToSideMenu(btn_home); //TODO: remove this if we are already in home by detecting "screen" from storage.
        fm_main.getToolbar().addComponentToSideMenu(btn_departments);
        fm_main.getToolbar().addComponentToSideMenu(btn_spiritualGifts);
        fm_main.getToolbar().addComponentToSideMenu(btn_ministries);
        fm_main.getToolbar().addComponentToSideMenu(btn_resourses);
        fm_main.getToolbar().addComponentToSideMenu(btn_worldchurch);
        fm_main.getToolbar().addComponentToSideMenu(btn_contactus);
        //fm_main.getToolbar().addCommandToLeftBar(null, ifont_burger, new ActionListener() 
        //{
        //  @Override
        //  public void actionPerformed(ActionEvent evt) 
        //  {
        //      fm_main.getToolbar().openSideMenu();
        //  }
        //});
        
        
      
      
      
      
      lbl_title = new Label("Main Menu"); //img_title
      //lbl_title.setIcon(img_title);
      lbl_title.setAlignment(CENTER);
      lbl_title.getStyle().setBgColor(0x000000); //redish -- 0xFF3333
      lbl_title.getStyle().setFgColor(0xff6600);
      lbl_title.getStyle().setMargin(0, 0, 0, 0);
      lbl_title.getStyle().setPadding(0, 0, 0, 0);
      //lbl_title.getStyle(Style.BACKGROUND_IMAGE_SCALED_FIT, false);
      //lbl_title.setIcon(img_body.Style.BACKGROUND_IMAGE_SCALED_FIT, false);
      //fm_main.setTitleComponent(lbl_title);
      
      sty_usn_icon = new Style(); 
      sty_usn_icon.setBorder(null, false);
      sty_usn_icon.setBgTransparency(220, false);
      sty_usn_icon.setFgColor(0xffffff, false);
      sty_usn_icon.setBgColor(0x448d21, false);
      //sty_icons_loginform.getMaterialDesignFont
      
      ifont_username = FontImage.createMaterial(FontImage.MATERIAL_EMAIL, sty_usn_icon, 4);
      
      lbl_usnicon = new Label(ifont_username);
      lbl_usnicon.getAllStyles().setBgTransparency(0, false);
      lbl_usnicon.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_usnicon.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_usnicon = new Container();
      cnt_usnicon.getUnselectedStyle().setBgTransparency(220, false);
      cnt_usnicon.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_usnicon.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_usnicon.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_usnicon.add(lbl_usnicon);
      
      txta_username = new TextField("", 15);
      txta_username.setHint(" Username"); 
      //txta_username.setHintIcon(ifont_username);
      //txta_username.setHintIcon(FontImage.createMaterial(FontImage.MATERIAL_EMAIL, cnt_usnicon.getUnselectedStyle()));
      txta_username.getHintLabel().setUnselectedStyle(sty_usn_icon);
      txta_username.getHintLabel().getAllStyles().setBgTransparency(220, false);
      txta_username.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_username.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_username.setConstraint(TextField.SENSITIVE);
      txta_username.setFocusable(true);
      txta_username.setRows(2);
      txta_username.setSingleLineTextArea(true);
      txta_username.setVerticalAlignment(CENTER);
      
      Style sty = new Style();
      sty.setBorder(null);
      sty.setFgColor(0x5B2BFB);
      sty.setBgTransparency(220, false);
            
      Style s1 = new Style();
      s1.setBgColor(0x000000);
      s1.setFgColor(0x5B2BFB);
      txta_username.setSelectedStyle(s1);
      txta_username.setUnselectedStyle(sty);
      txta_username.setPressedStyle(s1);
      txta_username.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_usn = new Container();
      cnt_usn.getUnselectedStyle().setPadding(0, (int)(3 * pixelsPerMM), 0, 0);
      cnt_usn.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_usn.add(BoxLayout.encloseX(cnt_usnicon, txta_username));
      
      
      sty_pwd_icon = new Style(); 
      sty_pwd_icon.setBorder(null, false);
      sty_pwd_icon.setBgTransparency(220, false);
      sty_pwd_icon.setFgColor(0xffffff, false);
      sty_pwd_icon.setBgColor(0x448d21, false);
      
      ifont_password = FontImage.createMaterial(FontImage.MATERIAL_LOCK, sty_pwd_icon, 4);
      
      lbl_pwdicon = new Label(ifont_password);
      lbl_pwdicon.getAllStyles().setBgTransparency(0, false);
      lbl_pwdicon.getAllStyles().setPadding(4, 4, 4, 4);
      lbl_pwdicon.getAllStyles().setMargin(4, 4, 4, 4);     
      
      cnt_pwdicon = new Container();
      cnt_pwdicon.getUnselectedStyle().setBgTransparency(220, false);
      cnt_pwdicon.getUnselectedStyle().setBgColor(0x448d21, false);
      cnt_pwdicon.getUnselectedStyle().setPadding((int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM), (int)(2 * pixelsPerMM));
      cnt_pwdicon.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_pwdicon.add(lbl_pwdicon);
      
      txta_password= new TextField("", 15);
      txta_password.setHint(" Password"); 
      txta_password.getHintLabel().setUnselectedStyle(sty_usn_icon);
      txta_password.getHintLabel().getAllStyles().setBgTransparency(220, false);
      txta_password.getHintLabel().getAllStyles().setFgColor(0x999999);
      txta_password.getHintLabel().getAllStyles().setFont(font_medium_plain, false);
      txta_password.setConstraint(TextField.SENSITIVE);
      txta_password.setFocusable(true);
      txta_password.setRows(2);
      txta_password.setSingleLineTextArea(true);
      txta_password.setVerticalAlignment(CENTER);  
      txta_password.setSelectedStyle(s1);
      txta_password.setUnselectedStyle(sty);
      txta_password.setPressedStyle(s1);
      txta_password.getAllStyles().setPadding(10, 10, 10, 10);
      
      cnt_pwd = new Container();
      cnt_pwd.getUnselectedStyle().setPadding(0, 0, 0, 0); //(int)(4 * pixelsPerMM)
      cnt_pwd.getUnselectedStyle().setMargin(0, 0, 0, 0);
      cnt_pwd.add(BoxLayout.encloseX(cnt_pwdicon, txta_password));
      
      
      lbl_header = new Label();
      lbl_header.setText("Main Menu");
      lbl_header.setTextPosition(TOP);
      //lbl_header.setIcon(theme.getImage("logo.png"));
      //lbl_header.setPreferredSize(dim);
      lbl_header.getStyle().setFont(font_medium_bold);
      lbl_header.setAlignment(CENTER);
      lbl_header.getStyle().setFgColor(0xffffff);
      lbl_header.getStyle().setBgColor(0x448d21);
      lbl_header.getStyle().setBgTransparency(255, false);
      lbl_header.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), (int)(2.5 * pixelsPerMM), 0, 0);
      lbl_header.getAllStyles().setMargin(0, 0, 0, 0);
      
      lbl_humberger_icon = new Label(ifont_burger);
      lbl_humberger_icon.setAlignment(CENTER);
      lbl_humberger_icon.getStyle().setFgColor(0xffffff);
      lbl_humberger_icon.getStyle().setBgColor(0x448d21);
      lbl_humberger_icon.getStyle().setBgTransparency(255, false);
      lbl_humberger_icon.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), (int)(2.5 * pixelsPerMM), 0, 0);
      lbl_humberger_icon.getAllStyles().setMargin(0, 0, 0, 0);
      lbl_humberger_icon.addPointerPressedListener(new ActionListener() 
      {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
               fm_main.getToolbar().openSideMenu();
          }
      });
      
      
      
        //Button btn_chat = new Button("");
        //FontImage.setMaterialIcon(btn_chat, FontImage.MATERIAL_CHAT, 7);

        
      
      
      
      lbl_messages_icon = new Label(ifont_messages);
      lbl_messages_icon.setAlignment(CENTER);
      lbl_messages_icon.getStyle().setFgColor(0xffffff);
      lbl_messages_icon.getStyle().setBgColor(0x448d21);
      lbl_messages_icon.getStyle().setBgTransparency(255, false);
      lbl_messages_icon.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), (int)(2.5 * pixelsPerMM), 0, (int)(2.5 * pixelsPerMM));
      lbl_messages_icon.getAllStyles().setMargin(0, 0, 0, 0);
      lbl_messages_icon.addPointerPressedListener(new ActionListener() 
      {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
                //fm_main.getToolbar().openSideMenu();
                Log.p("Going to show messaging center.", 1);
                                
                str_user_id = Storage.getInstance().readObject("userid").toString();
                str_role = Storage.getInstance().readObject("role").toString();
                str_level = Storage.getInstance().readObject("level").toString();

                Storage.getInstance().writeObject("parameter1", "messages");
                Storage.getInstance().writeObject("parameter2", str_user_id);  //TODO: //Replace this with Device UDID.
                Storage.getInstance().writeObject("parameter3", "");
                Storage.getInstance().writeObject("parameter4", "all");
                Storage.getInstance().writeObject("parameter5", "");
                Storage.getInstance().writeObject("parameter6", "");
                Storage.getInstance().writeObject("parameter7", ""); //message
                Storage.getInstance().writeObject("parameter8", ""); 
                Storage.getInstance().writeObject("parameter9", "out"); //in, out, sent, draft, deleted, replied to
                Storage.getInstance().writeObject("parameter10", "");//delete, view, send, search
                Storage.getInstance().writeObject("parameter11", str_role);
                Storage.getInstance().writeObject("parameter12", str_level);
                Storage.getInstance().writeObject("parameter13", "");
                Storage.getInstance().writeObject("parameter14", "");
                Storage.getInstance().writeObject("parameter15", "");
                Storage.getInstance().writeObject("parameter16", "");
                Storage.getInstance().writeObject("parameter17", "");
                Storage.getInstance().writeObject("parameter18", "");
                Storage.getInstance().writeObject("parameter19", "");
                Storage.getInstance().writeObject("parameter20", "");
                Storage.getInstance().writeObject("parameter21", "");

                Connect conn = new Connect();
                try 
                {
                    conn.process();
                } 
                catch (Exception e) 
                {
                    System.out.println("Error: "+e);
                    //e.printStackTrace();
                }
          }
      });
      
        
      
      
      lbl_avatar_icon = new Label(ifont_avatar);
      lbl_avatar_icon.setAlignment(CENTER);
      lbl_avatar_icon.getStyle().setFgColor(0xffffff);
      lbl_avatar_icon.getStyle().setBgColor(0x448d21);
      lbl_avatar_icon.getStyle().setBgTransparency(255, false);
      lbl_avatar_icon.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), (int)(2.5 * pixelsPerMM), 0, 0);
      lbl_avatar_icon.getAllStyles().setMargin(0, 0, 0, 0);
      lbl_avatar_icon.addPointerPressedListener(new ActionListener() 
      {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
              Style sty_dlg = new Style();
              sty_dlg.setBgColor(0xffffff);
              sty_dlg.setBgTransparency(0);
      
      
                dlg_avatar = new Dialog(); //Select an Action
                    //dlg_avatar.getAllStyles().setBgColor(0xffffff);
                    //dlg_avatar.getAllStyles().setBgTransparency(0);
                    //dlg_avatar.getUnselectedStyle().setBgColor(0xffffff);
                    //dlg_avatar.getUnselectedStyle().setBgTransparency(0);
                    //dlg_avatar.getSelectedStyle().setBgColor(0xffffff);
                    //dlg_avatar.getSelectedStyle().setBgTransparency(0);
                    //dlg_avatar.getPressedStyle().setBgColor(0xffffff);
                    //dlg_avatar.getPressedStyle().setBgTransparency(0);
                    //dlg_avatar.getStyle().setBgColor(0xffffff);
                    //dlg_avatar.getStyle().setBgTransparency(0);
                    //dlg_avatar.setUnselectedStyle(sty_dlg);
                    //dlg_avatar.setSelectedStyle(sty_dlg);
                    //dlg_avatar.setPressedStyle(sty_dlg);
                    //dlg_avatar.setUnselectedStyle(sty_dlg);
      
                    dlg_avatar.setDialogUIID("PopupDialogAvatar");
      
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
                    
                    btn_logout = new Button("Logout");
                        btn_logout.getStyle().setFont(font);
                        btn_logout.setIcon(theme.getImage("avt_logout.png"));
                        btn_logout.setTextPosition(RIGHT);
                        btn_logout.setUIID("Label");
                        btn_logout.getStyle().setMarginLeft(10);
                        btn_logout.getStyle().setFgColor(0xff);
                        btn_logout.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                Storage.getInstance().deleteStorageFile("keepmeloggedin");
                                Storage.getInstance().writeObject("loginstatus", "NOL");
                                
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
                                    //loginer.showMainScreen();  
                                 }
                                 else
                                 {
                                    storage.writeObject("screen", "home");
                                    LoginMenu loginer = new LoginMenu();
                                    //loginer.showMainScreen();
                                 }
                                }
                                else
                                {
                                    storage.writeObject("screen", "home");
                                    LoginMenu loginer = new LoginMenu();
                                    //loginer.showMainScreen();
                                }
                            }
                        });
                        
                    str_role = "";

                    btn_profile = new Button("Manage Profile");
                        btn_profile.setIcon(theme.getImage("avt_profile.png"));
                        btn_profile.setTextPosition(RIGHT);
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
                                                    dlg_avatar.dispose();
                                                    //showProfileDlg();
                                                }
                                                //if show state is hide, show tasks, //write show state in storage
                                                else
                                                {
                                                 //showProfileDlg();
                                                }
                                            }
                                            else
                                            {
                                                //showProfileDlg();
                                            }
                                   }
                                   else
                                   {
                                       //showLoginDialog();
                                   }
                               }
                               else
                               {
                                   //showLoginDialog();
                               }
                            }
                        });

                    btn_accounts = new Button("View Statements");
                        btn_accounts.setIcon(theme.getImage("avt_statements.png"));
                        btn_accounts.setTextPosition(RIGHT);
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
                                        Storage.getInstance().writeObject("parameter1", "statements"); //"collections"
                                        Storage.getInstance().writeObject("parameter4", Storage.getInstance().readObject("userid"));
                                        Storage.getInstance().writeObject("parameter5",Storage.getInstance().readObject("role"));
                                        Storage.getInstance().writeObject("parameter6", Storage.getInstance().readObject("level")); 
                                        Storage.getInstance().writeObject("parameter7", "0"); //limit
                                        Storage.getInstance().writeObject("parameter8", "0"); //offset
                                        Storage.getInstance().writeObject("parameter9", Storage.getInstance().readObject("member_no"));
                                        
                                        Connect conn = new Connect();
                                        try 
                                        {
                                            conn.process();
                                        } 
                                        catch (Exception e) 
                                        {
                                            System.out.println("Error: "+e);
                                            //e.printStackTrace();
                                        }
                                   }
                                   else
                                   {
                                       Storage.getInstance().writeObject("screen", "accounts");
                                       //showLoginDialog();
                                   }
                               }
                               else
                               {
                                   Storage.getInstance().writeObject("screen", "accounts");
                                   //showLoginDialog();
                               }
                                
                            }
                        });
                        
                    btn_messages = new Button("Messaging Center");
                        btn_messages.setIcon(theme.getImage("avt_messages.png"));
                        btn_messages.setTextPosition(RIGHT);
                        btn_messages.setUIID("Label");
                        btn_messages.getStyle().setMarginLeft(10);
                        btn_messages.getStyle().setFgColor(0xff);
                        btn_messages.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                Log.p("Closing avatar dialogue.", 1);
                                dlg_avatar.dispose();
                                
                                Log.p("Going to show messaging center.", 1);
                                
                                str_user_id = Storage.getInstance().readObject("userid").toString();
                                str_role = Storage.getInstance().readObject("role").toString();
                                str_level = Storage.getInstance().readObject("level").toString();

                                Storage.getInstance().writeObject("parameter1", "messages");
                                Storage.getInstance().writeObject("parameter2", str_user_id);  //TODO: //Replace this with Device UDID.
                                Storage.getInstance().writeObject("parameter3", "");
                                Storage.getInstance().writeObject("parameter4", "all");
                                Storage.getInstance().writeObject("parameter5", "");
                                Storage.getInstance().writeObject("parameter6", "");
                                Storage.getInstance().writeObject("parameter7", ""); //message
                                Storage.getInstance().writeObject("parameter8", ""); 
                                Storage.getInstance().writeObject("parameter9", "out"); //in, out, sent, draft, deleted, replied to
                                Storage.getInstance().writeObject("parameter10", "");//delete, view, send, search
                                Storage.getInstance().writeObject("parameter11", str_role);
                                Storage.getInstance().writeObject("parameter12", str_level);
                                Storage.getInstance().writeObject("parameter13", "");
                                Storage.getInstance().writeObject("parameter14", "");
                                Storage.getInstance().writeObject("parameter15", "");
                                Storage.getInstance().writeObject("parameter16", "");
                                Storage.getInstance().writeObject("parameter17", "");
                                Storage.getInstance().writeObject("parameter18", "");
                                Storage.getInstance().writeObject("parameter19", "");
                                Storage.getInstance().writeObject("parameter20", "");
                                Storage.getInstance().writeObject("parameter21", "");
                                
                                Connect conn = new Connect();
                                try 
                                {
                                    conn.process();
                                } 
                                catch (Exception e) 
                                {
                                    System.out.println("Error: "+e);
                                    //e.printStackTrace();
                                } 
                            }
                        });    
                    
                        
                    btn_sendMoney = new Button();
                    
                    bool_role = Storage.getInstance().exists("role");
                    if(bool_role == true)
                    {
                        str_role = Storage.getInstance().readObject("role").toString();
                        if(str_role.equals("Assistant Treasurer") || str_role.contains("Treasurer"))
                        {
                            btn_sendMoney.setText("Recieve Money");
                        }
                        else
                        {
                            btn_sendMoney.setText("Send Money");
                        }
                    }
                    else
                    {
                        btn_sendMoney.setText("Send Money");
                    }
                    
                        btn_sendMoney.setIcon(theme.getImage("avt_money.png"));
                        btn_sendMoney.setTextPosition(RIGHT);
                        btn_sendMoney.setUIID("Label");
                        btn_sendMoney.getStyle().setMarginLeft(10);
                        btn_sendMoney.getStyle().setFgColor(0xff);
                        btn_sendMoney.addActionListener(new ActionListener() 
                        {
                            @Override
                            public void actionPerformed(ActionEvent evt) 
                            {
                                dlg_avatar.dispose();
                                
                                Storage.getInstance().writeObject("screen", "pay");
                                
                                //showPayDialog1();
                                
                                str_users_department = Storage.getInstance().readObject("department").toString();
                                str_users_board_member = Storage.getInstance().readObject("board_member").toString();
                                str_users_adventist = Storage.getInstance().readObject("adventist").toString();
                                str_users_status = Storage.getInstance().readObject("status").toString();
                                str_users_ss_class = Storage.getInstance().readObject("ss_class").toString();
                                str_users_role = Storage.getInstance().readObject("role").toString();
                                str_users_level = Storage.getInstance().readObject("level").toString();
                                str_users_memnos = Storage.getInstance().readObject("member_no").toString();

                                Storage.getInstance().writeObject("parameter1", "members");
                                Storage.getInstance().writeObject("parameter2", str_users_department);
                                Storage.getInstance().writeObject("parameter3", str_users_board_member);
                                Storage.getInstance().writeObject("parameter4", str_users_adventist);
                                Storage.getInstance().writeObject("parameter5", str_users_status);
                                Storage.getInstance().writeObject("parameter6", str_users_ss_class);
                                Storage.getInstance().writeObject("parameter7", str_users_role);
                                Storage.getInstance().writeObject("parameter8", str_users_level);
                                Storage.getInstance().writeObject("parameter9", str_users_memnos);

                                Connect conn = new Connect();
                                try 
                                {
                                   conn.process(); 
                                } 
                                catch (Exception e) 
                                {
                                    Log.p("Error: "+e, 3);
                                }
                            }
                        });

                    btn_exit = new Button("Exit");
                        btn_exit.setIcon(theme.getImage("avt_exit.png"));
                        btn_exit.setTextPosition(RIGHT);
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
                            dlg_avatar.add(btn_messages);
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
                    
                    //dlg_avatar.setBlurBackgroundRadius(-1);
                    //dlg_avatar.setDefaultBlurBackgroundRadius(10.200);
                    dlg_avatar.setDisposeWhenPointerOutOfBounds(true);
                    dlg_avatar.showDialog();
                    //dlg_avatar.showPopupDialog(tb.findCommandComponent(cmd_tbRight)); //cmd_tbRight
                    //dlg_avatar.showPacked(BorderLayout.EAST, false);
            }  
        });
      
      
      
      
      lbl_logo = new Label();
      lbl_logo.setIcon(theme.getImage("logo_karengata_vertical.png")); //logo.jpg //logo_karengata_no-symbol-white.png   //logo_karengata_vertical.png
      lbl_logo.setText("Karengata");
      lbl_logo.setTextPosition(BOTTOM);
      lbl_logo.setUIID("LabelLogo");
      //lbl_logo.setPreferredSize(dim);
      font_RageItalic = font_RageItalic.derive((int)(50.5 * pixelsPerMM), Font.STYLE_PLAIN);
      lbl_title.getStyle().setFont(font_RageItalic);
      lbl_logo.setAlignment(CENTER);
      lbl_logo.getStyle().setFgColor(0xffffff);
      //lbl_logo.getStyle().setBgColor(0x448d21);
      lbl_logo.getAllStyles().setPadding(0, 0, 0, 0);
      lbl_logo.getAllStyles().setMargin((int)(1.5 * pixelsPerMM), 0, 0, 0);
      lbl_logo.getStyle().setBgTransparency(0, false);
      
      FloatingActionButton fabtn_badge = FloatingActionButton.createBadge("5");
      fabtn_badge.getAllStyles().setAlignment(CENTER);
      //fabtn_badge.getAllStyles().setPaddingTop((int)(1.5 * pixelsPerMM));
        //hi.add(fabtn_badge.bindFabToContainer(lbl_messages_icon, Component.RIGHT, Component.TOP));
        

    //FontImage.setMaterialIcon(lbl_messages_icon, FontImage.MATERIAL_CHAT, 7);
    //Label lbl_badge = new Label("33");
    //lbl_badge.getAllStyles().setPaddingTop((int)(1.5 * pixelsPerMM));
    //lbl_badge.getAllStyles().setBorder(RoundBorder.create().rectangle(true));
    //lbl_badge.getAllStyles().setAlignment(Component.CENTER);
    //int int_size = Display.getInstance().convertToPixels(1.5f);
    //lbl_badge.getAllStyles().setFont(Font.createTrueTypeFont("native:MainLight", "native:MainLight").derive(int_size, Font.STYLE_PLAIN));
    //Container cnt_badge = LayeredLayout.encloseIn(lbl_messages_icon, FlowLayout.encloseRight(lbl_badge));
    //cnt_badge.setLeadComponent(lbl_messages_icon);

        TextField txtf_changeBadgeValue = new TextField("33");
        //txtf_changeBadgeValue.getAllStyles().setPaddingTop((int)(0.5 * pixelsPerMM));
        txtf_changeBadgeValue.addDataChangedListener((i, ii) -> 
        {
            fabtn_badge.setText(txtf_changeBadgeValue.getText());
            fabtn_badge.getParent().revalidate();
        });
      
      cnt_topbar = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      cnt_topbar.getStyle().setBgColor(0x448d21);
      cnt_topbar.getStyle().setBgTransparency(255, false);
      cnt_topbar.add(BorderLayout.centerCenterEastWest(lbl_header, BoxLayout.encloseX(fabtn_badge.bindFabToContainer(lbl_messages_icon, Component.RIGHT, Component.TOP), lbl_avatar_icon), lbl_humberger_icon));
      //cnt_topbar.add(BorderLayout.centerCenterEastWest(lbl_header, BoxLayout.encloseX(cnt_badge, lbl_avatar_icon), lbl_humberger_icon));
           
      cont_header = new Container(new BoxLayout(BoxLayout.X_AXIS));
      cont_header.setName("cont_header");
      cont_header.setScrollableY(true);
      cont_header.getStyle().setBgTransparency(0, false);
      TableLayout tablelayout = new TableLayout(2, 1);
      tablelayout.setGrowHorizontally(true);
      tablelayout.isGrowHorizontally();
      tablelayout.hasHorizontalSpanning();
      cont_header.setLayout(tablelayout);
      cont_header.addComponent(cnt_topbar);
      cont_header.addComponent(lbl_logo);
      
      
     
    
    Style sty_lg = new Style();
        sty_lg.setFgColor(0xffffff);//0xff3333 //0x5DDB00
        sty_lg.setBgColor(0x448d21);
        sty_lg.setBgTransparency(0, false);
        sty_lg.setMargin(0, 0,  0, 0); //(int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM)
        sty_lg.setPadding(0, 0, 0, 0);
        sty_lg.setMarginUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        sty_lg.setUnderline(false);
     
     
    cnt_nav = new Container(new FlowLayout(CENTER, BOTTOM));
    cnt_nav.getAllStyles().setAlignment(CENTER);
    cnt_nav.setScrollableX(true);

    btn_bible = new Button(theme.getImage("bible.png"));
        //btn_bible.setText("Bible");
        btn_bible.setUIID("Label");
        btn_bible.setTextPosition(BOTTOM);
        btn_bible.setUnselectedStyle(sty_lg);
        btn_bible.setSelectedStyle(sty_lg);
        btn_bible.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if(Storage.getInstance().exists("bible.json") == true)
                {
                    //BibleMenu biblemenu = new BibleMenu();
                    //bible.
                }
                else
                {
                    Dialog.show("Sorry!", "The feature you have selected is not available yet. We will notify you when it is available.", "OK", null);   
                }
            }
        });

    btn_hymnal = new Button(theme.getImage("hymnal.png"));
        //btn_hymnal.setText("Hymnal");
        btn_hymnal.setUIID("Label");
        btn_hymnal.setTextPosition(BOTTOM);
        btn_hymnal.setUnselectedStyle(sty_lg);
        btn_hymnal.setSelectedStyle(sty_lg);
        btn_hymnal.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //HymnalMenu hymner = new HymnalMenu();
                //hymner.showMainForm();
            }
        });

    btn_lesson = new Button(theme.getImage("lesson.png"));
        //btn_lesson.setText("Lesson");
        btn_lesson.setUIID("Label");
        btn_lesson.setTextPosition(BOTTOM);
        btn_lesson.setUnselectedStyle(sty_lg);
        btn_lesson.setSelectedStyle(sty_lg);

    btn_bulletin = new Button(theme.getImage("bulletin.png"));
        //btn_bulletin.setText("Bulletin");
        btn_bulletin.setUIID("Label");
        btn_bulletin.setTextPosition(BOTTOM);
        btn_bulletin.setUnselectedStyle(sty_lg);
        btn_bulletin.setSelectedStyle(sty_lg);
        btn_bulletin.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //CalendarMenu calmenu = new CalendarMenu();
                //calmenu.showMainScreen();
            }
        });
        
        
    lbl_bible = new Label();
        lbl_bible.setText("Bible");
        lbl_bible.setTextPosition(TOP);
        lbl_bible.getStyle().setFont(font_small_plain);
        lbl_bible.setAlignment(CENTER);
        lbl_bible.getStyle().setFgColor(0xffffff);
        lbl_bible.getStyle().setBgColor(0x448d21);
        lbl_bible.getStyle().setBgTransparency(255, false);
        lbl_bible.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), (int)(2.5 * pixelsPerMM), 0, 0);
        lbl_bible.getAllStyles().setMargin(0, 0, 0, 0);
      
      lbl_hymnal = new Label();
        lbl_hymnal.setText("Hymnal");
        lbl_hymnal.setTextPosition(TOP);
        lbl_hymnal.getStyle().setFont(font_small_plain);
        lbl_hymnal.setAlignment(CENTER);
        lbl_hymnal.getStyle().setFgColor(0xffffff);
        lbl_hymnal.getStyle().setBgColor(0x448d21);
        lbl_hymnal.getStyle().setBgTransparency(255, false);
        lbl_hymnal.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), (int)(2.5 * pixelsPerMM), 0, 0);
        lbl_hymnal.getAllStyles().setMargin(0, 0, 0, 0);
        
      lbl_lesson = new Label();
        lbl_lesson.setText("Lesson");
        lbl_lesson.setTextPosition(TOP);
        lbl_lesson.getStyle().setFont(font_small_plain);
        lbl_lesson.setAlignment(CENTER);
        lbl_lesson.getStyle().setFgColor(0xffffff);
        lbl_lesson.getStyle().setBgColor(0x448d21);
        lbl_lesson.getStyle().setBgTransparency(255, false);
        lbl_lesson.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), (int)(2.5 * pixelsPerMM), 0, 0);
        lbl_lesson.getAllStyles().setMargin(0, 0, 0, 0);
        
      lbl_bulletin = new Label();
        lbl_bulletin.setText("Bulletin");
        lbl_bulletin.setTextPosition(TOP);
        lbl_bulletin.getStyle().setFont(font_small_plain);
        lbl_bulletin.setAlignment(CENTER);
        lbl_bulletin.getStyle().setFgColor(0xffffff);
        lbl_bulletin.getStyle().setBgColor(0x448d21);
        lbl_bulletin.getStyle().setBgTransparency(255, false);
        lbl_bulletin.getAllStyles().setPadding((int)(2.5 * pixelsPerMM), (int)(2.5 * pixelsPerMM), 0, 0);
        lbl_bulletin.getAllStyles().setMargin(0, 0, 0, 0);
                
      //cnt_nav.add(btn_bible).add(btn_hymnal).add(btn_lesson).add(btn_bulletin);
     
      Container cnt_ = new Container(new GridLayout(1, 4)); 
      cnt_.getAllStyles().setPadding(0, 0, 0, 0);
      cnt_.getAllStyles().setMargin(0, 0, 0, 0);
      //cnt_.add(btn_bible).add(btn_hymnal).add(btn_lesson).add(btn_bulletin);
      //cnt_.add(lbl_bible).add(lbl_hymnal).add(lbl_lesson).add(lbl_bulletin);
      
        
      
      
      cnt_bible = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      cnt_bible.getAllStyles().setPadding(0, 0, 0, 0);
      cnt_bible.getAllStyles().setMargin(0, 0, 0, 0);
      cnt_bible.add(FlowLayout.encloseCenterMiddle(btn_bible)); //new FlowLayout(CENTER, CENTER)
      cnt_bible.add(lbl_bible);
      
      cnt_hymnal = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      cnt_hymnal.getAllStyles().setPadding(0, 0, 0, 0);
      cnt_hymnal.getAllStyles().setMargin(0, 0, 0, 0);
      cnt_hymnal.add(FlowLayout.encloseCenterMiddle(btn_hymnal));
      cnt_hymnal.add(lbl_hymnal);
      
      cnt_lesson = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      cnt_lesson.getAllStyles().setPadding(0, 0, 0, 0);
      cnt_lesson.getAllStyles().setMargin(0, 0, 0, 0);
      cnt_lesson.add(FlowLayout.encloseCenterMiddle(btn_lesson));
      cnt_lesson.add(lbl_lesson);
      
      cnt_bulletin = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      cnt_bulletin.getAllStyles().setPadding(0, 0, 0, 0);
      cnt_bulletin.getAllStyles().setMargin(0, 0, 0, 0);
      cnt_bulletin.add(FlowLayout.encloseCenterMiddle(btn_bulletin));
      cnt_bulletin.add(lbl_bulletin);
      
      cnt_.add(cnt_bible).add(cnt_hymnal).add(cnt_lesson).add(cnt_bulletin);
      
     
   
     cnt_footer = new Container(new BorderLayout());
     cnt_footer.getAllStyles().setPadding(0, 0, 0, 0);
     cnt_footer.getAllStyles().setMargin(0, 0, 0, 0);
     //cnt_footer.add(BorderLayout.WEST, btn_exit);
     //cnt_footer.add(BorderLayout.EAST, btn_submit);
        //try 
        //{
        //    cnt_footer.add(CENTER, new ScaleImageLabel(GifImage.decode(getResourceAsStream("/hakuna_matata.gif"), 1177720)));
        //} 
        //catch(IOException err) 
        //{
        //    //log(err);
        //}
            
           
        
     //cnt_footer.add(BorderLayout.CENTER, cnt_);
     cnt_footer.add(BorderLayout.SOUTH, cnt_);
     
      LayeredLayout laylay = new LayeredLayout();
      //laylay.setInsets(btn_portfolio, "auto auto auto auto");
      //laylay.setInsets(btn_portfolio, "auto auto -55 auto");
      //cont_body.setLayout(laylay);
        
      fm_main.addComponent(BorderLayout.NORTH, cont_header);
      //fm_main.addComponent(BorderLayout.CENTER, cont_body);
      fm_main.addComponent(BorderLayout.SOUTH, cnt_footer);
      
      Command cmd_back = new Command("")
      {
       public void actionPerformed(ActionEvent ev) 
       {
           //LoginMenu loginer = new LoginMenu();
           //loginer.showLoginScreen();
       }
      };
  
        
        fm_main.addCommand(cmd_back);
        fm_main.setBackCommand(cmd_back);
    
      fm_main.showBack();
   }
  
    
    public void showPayDialog1()
    {
        try 
        {
            theme = Resources.openLayered("/theme");
            //theme = UIManager.initNamedTheme("/theme_1", "Theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            sty_icon_dlgPay = new Style(); 
            sty_icon_dlgPay.setFgColor(0xC0C0C0);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: "+e);
            //e.printStackTrace();
        }
        
        
        
        bool_memno = Storage.getInstance().exists("temp_member_no");
        if(bool_memno == true)
        {
            str_memno = Storage.getInstance().readObject("temp_member_no").toString();
        }
        else
        {
            bool_role = Storage.getInstance().exists("role");
            if(bool_role == true)
            {
                str_role = Storage.getInstance().readObject("role").toString();
                if(str_role.equals("Assistant Treasurer") || str_role.contains("Treasurer"))
                {
                    str_memno = "";
                }
                else
                {
                    str_memno = Storage.getInstance().readObject("member_no").toString();
                }
            }
            else
            {
                str_memno = Storage.getInstance().readObject("member_no").toString();
            }
        }
        
        bool_fname = Storage.getInstance().exists("temp_firstname");
        if(bool_fname == true)
        {
            str_fname = Storage.getInstance().readObject("temp_firstname").toString();
        }
        else
        {
            bool_role = Storage.getInstance().exists("role");
            if(bool_role == true)
            {
                str_role = Storage.getInstance().readObject("role").toString();
                if(str_role.equals("Assistant Treasurer") || str_role.contains("Treasurer"))
                {
                    str_fname = "";
                }
                else
                {
                    str_fname = Storage.getInstance().readObject("firstname").toString();
                }
            }
            else
            {
                str_fname = Storage.getInstance().readObject("firstname").toString();
            }
        }
        
        bool_mname = Storage.getInstance().exists("temp_middlename");
        if(bool_mname == true)
        {
            str_mname = Storage.getInstance().readObject("temp_middlename").toString();
        }
        else
        {
            bool_role = Storage.getInstance().exists("role");
            if(bool_role == true)
            {
                str_role = Storage.getInstance().readObject("role").toString();
                if(str_role.equals("Assistant Treasurer") || str_role.contains("Treasurer"))
                {
                    str_mname = "";
                }
                else
                {
                    str_mname = Storage.getInstance().readObject("middlename").toString();
                }
            }
            else
            {
                str_mname = Storage.getInstance().readObject("middlename").toString();
            }
        }
        
        bool_oname = Storage.getInstance().exists("temp_other_name");
        if(bool_oname == true)
        {
            str_oname = Storage.getInstance().readObject("temp_other_name").toString();
        }
        else
        {
            bool_role = Storage.getInstance().exists("role");
            if(bool_role == true)
            {
                str_role = Storage.getInstance().readObject("role").toString();
                if(str_role.equals("Assistant Treasurer") || str_role.contains("Treasurer"))
                {
                    str_oname = "";
                }
                else
                {
                    str_oname = Storage.getInstance().readObject("other_name").toString();
                }
            }
            else
            {
                str_oname = Storage.getInstance().readObject("other_name").toString();
            }
        }
        
        bool_lname = Storage.getInstance().exists("temp_lastname");
        if(bool_lname == true)
        {
            str_lname = Storage.getInstance().readObject("temp_lastname").toString();
        }
        else
        {
            bool_role = Storage.getInstance().exists("role");
            if(bool_role == true)
            {
                str_role = Storage.getInstance().readObject("role").toString();
                if(str_role.equals("Assistant Treasurer") || str_role.contains("Treasurer"))
                {
                    str_lname = "";
                }
                else
                {
                    str_lname = Storage.getInstance().readObject("lastname").toString();
                }
            }
            else
            {
                str_lname = Storage.getInstance().readObject("lastname").toString();
            }
        }
        
        bool_phone = Storage.getInstance().exists("temp_phone");
        if(bool_phone == true)
        {
            str_phone = Storage.getInstance().readObject("temp_phone").toString();
        }
        else
        {
            bool_role = Storage.getInstance().exists("role");
            if(bool_role == true)
            {
                str_role = Storage.getInstance().readObject("role").toString();
                if(str_role.trim().equals("Assistant Treasurer") || str_role.trim().contains("Treasurer"))
                {
                    str_phone = "";
                }
                else
                {
                    str_phone = Storage.getInstance().readObject("phone").toString();
                }
            }
            else
            {
                str_phone = Storage.getInstance().readObject("phone").toString();
            }
        }
         
        bool_email = Storage.getInstance().exists("temp_email");
        if(bool_email == true)
        {
            str_email = Storage.getInstance().readObject("temp_email").toString();
        }
        else
        {
            bool_role = Storage.getInstance().exists("role");
            if(bool_role == true)
            {
                str_role = Storage.getInstance().readObject("role").toString();
                if(str_role.equals("Assistant Treasurer") || str_role.contains("Treasurer"))
                {
                    str_email = "";
                }
                else
                {
                    str_email = Storage.getInstance().readObject("email").toString();
                }
            }
            else
            {
                str_email = Storage.getInstance().readObject("email").toString();
            }
        }
        
        
        
        
                
                
        txtf_trxno = new TextField("", "Transaction No");
        //TODO: SMS intercept and see if the code was already recieved in the inbox/perhaps at the beginning of app.
//        Random rand = new Random();
//        int randomNum = rand.nextInt(1999);
//        //char randomChr = rand.next
//        char randomChr = (char) (rand.nextInt(26) + 'a');
//        
//        
//        //String str_randno = ""+rand.nextLong();
//        /*
//        String str_randno = "" + r.nextInt(10000);
//        while(val.length() < 4) 
//        {
//            str_randno = "0" + val;
//        }
//        */ // --> This should work.
//        String str_randno = Integer.toString(randomNum)+randomChr; // --> This works
        
        Random rand = new Random();
        int randomNum = rand.nextInt(1999);

        sb_randomLetters = new StringBuilder(); 
        str_randomLetters = new String[3];

        for (i = 0; i < 3; i++) 
        {
            char randomChr = (char) (rand.nextInt(26) + 'A');
            str_randomLetters[i] = String.valueOf(randomChr);
            sb_randomLetters.append(str_randomLetters[i]);
        }
        String str_randno = Integer.toString(randomNum)+sb_randomLetters;
        
        bool_trxno = Storage.getInstance().exists("temp_trx_number");
        if(bool_trxno == true)
        {
            str_trxno = Storage.getInstance().readObject("temp_trx_number").toString();
            txtf_trxno.setText(str_trxno);
            txtf_trxno.setEditable(false);
            txtf_trxno.setFocusable(false);
        }
        else
        {
            str_trxno = str_randno;
            txtf_trxno.setText(str_trxno);
            txtf_trxno.setEditable(false);
            txtf_trxno.setFocusable(false);
        }
              
        txtf_trxno.setVisible(false);
        txtf_trxno.setConstraint(TextField.NUMERIC);
        txtf_trxno.getAllStyles().setMargin(0, 2, 2, 2);
        txtf_trxno.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txtf_trxno.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtf_trxno.getSelectedStyle().setBgColor(0xffffff);
        txtf_trxno.getStyle().setFgColor(0xC0C0C0);
        txtf_trxno.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_trxno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_trxno.getUnselectedStyle().getBorder().setThickness(3);
        txtf_trxno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_trxno.getSelectedStyle().getBorder().setThickness(3);
        txtf_trxno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_trxno.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtf_trxno.getStyle().setBgTransparency(255);}

        /*final DefaultListModel<String> options = new DefaultListModel<>();
        ac_search = new AutoCompleteTextField(options) 
        {
            @Override
            protected boolean filter(String text) 
            {
                if(text.length() == 0) 
                {
                    return false;
                }
                String[] l = searchLocations(text);
                if(l == null || l.length == 0) 
                {
                    return false;
                }

                options.removeAll();
                for(String s : l) 
                {
                    options.addItem(s);
                    String str_memberNa = StringUtil.tokenize(s, "(").get(0);
                    //String str_memberNu = StringUtil.tokenize(StringUtil.tokenize(ac.getText().trim(), "(").get(1), ")").get(0);
                    //options.addItem(str_memberNa);
                }
                return true;
            }
        };*/
        
        ac_search = new AutoCompleteTextField();
        //ac_search.setGrabsPointerEvents(false);
        //ac_search.setBlockLead(false);
        //ac_search.setHandlesInput(false);
        //ac_search.setIgnorePointerEvents(true);
        //ac_search.setTraversable(false);
        ac_search.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, true)); 
        ac_search.getUnselectedStyle().getBorder().setThickness(3);
        ac_search.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, true)); 
        ac_search.getSelectedStyle().getBorder().setThickness(3);
        ac_search.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, true)); 
        ac_search.getPressedStyle().getBorder().setThickness(3);
        
        final int size = Display.getInstance().convertToPixels(7);
        final EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(size, size, 0xffcccccc), true);
        
        
        FileSystemStorage inst = FileSystemStorage.getInstance();
        final String homePath = inst.getAppHomePath();
        final char sep = inst.getFileSystemSeparator();
        
        str_listcriteria = "members";
            
        final String str_filepath = homePath+sep+str_listcriteria+".txt";

        try 
        {
            InputStream is = inst.openInputStream(str_filepath);
            byte[] b = Util.readInputStream(is);
            str_listcontent = new String(b); //SystBem.out.println("Content..: "+str_content);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: "+e);
            //e.printStackTrace();
        }

        String str_json_read = str_listcontent;
        byte[] dataa = str_json_read.getBytes();

        JSONParser json = new JSONParser();
        
        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
        {
            Map<String, Object> map_content = json.parseJSON(is_content);
            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");
            System.out.println("No of Members 1:---------> "+obj_content.size()); 
            
            ac_search.setMinimumElementsShownInPopup(5); //obj_content.size()
            
            sb_options = new StringBuilder(); 
            str_acoptions = new String[obj_content.size()];
            
            i = 0;
            for(Map<String, Object> obj : obj_content) 
            { 
                str_name = (String)obj.get("name").toString().trim();
                //str_name = (String)obj.get("firstname").toString().trim()+" "+(String)obj.get("middlename").toString().trim()+" "+(String)obj.get("lastname").toString().trim();//(String)obj.get("name").toString().trim();
                str_nangos = (String)obj.get("phone").toString().trim();            
                str_memnu = (String)obj.get("member_no").toString().trim();
                str_temp_family_id = (String)obj.get("family_id").toString().trim();
                
                 //Log.p("Adding members to auctocomplete options "+i+". Name: "+(String)obj.get("name").toString().trim()+" (MemNos: "+(String)obj.get("member_no").toString().trim()+") "+str_familyid.trim(), 1);
                
                str_acoptions[i] = str_name+" ("+str_memnu+")   -   "+str_nangos;
                sb_options.append(str_acoptions[i]);
                
                //if(str_familyid.equals())
                                 
                i++;                
            }
           
            //CircleProgress.markComponentLoading(ac_search).getStyle().setFgColor(0xff0000);
            //CircleProgress.markComponentReady(ac_search, CommonTransitions.createFade(300));
            ac_search.setCompletion(str_acoptions);
        } 
        catch(IOException err) 
        {
                Log.p("Search error occured: "+err, 1);
        }
        
        cnt_family = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_family.getAllStyles().setBorder(Border.createEmpty());
        cnt_family.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        cnt_family.getAllStyles().setBgTransparency(255);
        cnt_family.getAllStyles().setBgColor(0x006064);
        cnt_family.getAllStyles().setBorder(null);
        
        acc_family = new Accordion();
        acc_family.setName("acc_family");
        
        
        ac_search.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                try 
                {
                    
                        //we have some connection
                        Storage.getInstance().deleteStorageFile("no_fam_mems");
                        //Storage.getInstance().writeObject("no_fam_mems", "0");

                        if(ac_search.getText().trim().contains("("))
                        {
                            String str_memberNa = StringUtil.tokenize(ac_search.getText(), "(").get(0);
                            String str_memberNu = StringUtil.tokenize(StringUtil.tokenize(ac_search.getText().trim(), "(").get(1), ")").get(0);
                            Log.p("ac refined: "+str_memberNa.trim()+" "+str_memberNu, 1);
                            ac_search.setText(""); //str_memberNa.trim()
                            ac_search.setEditable(false);
                            ac_search.setFocusable(false);
                            ac_search.setEnabled(false);
                            txtf_memberno.setEditable(false);
                            txtf_memberno.setFocusable(false);

                            ac_search.removeListListener(this);
                            ac_search.setCompletion("");

                            Storage.getInstance().writeObject("memnos", str_memberNu);

                            //doSetMemberData();
                            Storage.getInstance().writeObject("temp_member_no", str_memberNu); //txtf_memberno.getText().trim()

                            //Dialog.show("Notice!", "You will shortly recieve a Transaction Code via SMS. Enter it in the space ptovided", "Ok", null);
                            Connect.storage.writeObject("parameter1", "verification");  //verification_mpesa  - For Mpesa verification
                            Connect.storage.writeObject("parameter2", str_memberNu); //txtf_memberno.getText().trim()
                            Connect.storage.writeObject("parameter3", Storage.getInstance().readObject("userid")); //txta_username.getText().trim()
                            Connect.storage.writeObject("parameter4", "");   //0720689160 - For Mpesa verification
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

                            FileSystemStorage inst = FileSystemStorage.getInstance();
                            final String homePath = inst.getAppHomePath();
                            final char sep = inst.getFileSystemSeparator();

                            str_listcriteria = "members";

                            final String str_filepath = homePath+sep+str_listcriteria+".txt";

                            try 
                            {
                                InputStream is = inst.openInputStream(str_filepath);
                                byte[] b = Util.readInputStream(is);
                                str_listcontent = new String(b); //SystBem.out.println("Content..: "+str_content);
                            } 
                            catch (Exception e) 
                            {
                                System.out.println("Error: "+e);
                                //e.printStackTrace();
                            }

                            String str_json_read = str_listcontent;
                            byte[] dataa = str_json_read.getBytes();

                            JSONParser json = new JSONParser();

                            try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                            {
                                Map<String, Object> map_content = json.parseJSON(is_content);
                                java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");
                                System.out.println("No of Members 2:---------> "+obj_content.size()); 

                                sb_options = new StringBuilder(); 
                                str_acoptions = new String[obj_content.size()];

                                cb_fam = new CheckBox[obj_content.size()];

                                acc_member = new Accordion[obj_content.size()];

                                i = 0;
                                for(Map<String, Object> obj : obj_content) 
                                { 
                                    str_id = (String)obj.get("id").toString().trim();
                                    str_name = (String)obj.get("name").toString().trim();
                                    str_memno = (String)obj.get("member_no").toString().trim();
                                    str_family_id = (String)obj.get("family_id").toString().trim();

                                    //bool_family_id = Storage.getInstance()
                                    str_temp_family_id = Storage.getInstance().readObject("temp_family_id").toString();
                                    //if(str_temp_family_id.equals((String)obj.get("family_id").toString().trim()) && !str_family_id.equals(""))
                                    
                                    if(str_temp_family_id.equals((String)obj.get("family_id").toString().trim()))
                                    {
                                        System.out.println(str_temp_family_id+" = "+(String)obj.get("family_id").toString().trim());
                                        Log.p("Adding family to auctocomplete options "+i+". Name: "+(String)obj.get("name").toString().trim()+" (MemNos: "+(String)obj.get("member_no").toString().trim()+") "+str_temp_family_id.trim(), 1);

                                        cb_fam[i] = new CheckBox();
                                        cb_fam[i].setText(str_name);
                                        cb_fam[i].setUIID(str_memno);

                                        bool_no_fam_mems = Storage.getInstance().exists("no_fam_mems");
                                        if(bool_no_fam_mems == true)
                                        {
                                            str_no_fam_mems = Storage.getInstance().readObject("no_fam_mems").toString();
                                            int_no_fam_mems = Integer.parseInt(str_no_fam_mems);

                                            System.out.println("No of family members 1: "+str_no_fam_mems);

                                            if(int_no_fam_mems >= 1)
                                            {
                                                Integer newcount;
                                                newcount = int_no_fam_mems+1;
                                                str_no_fam_mems = newcount.toString();

                                                System.out.println("Updating "+str_no_fam_mems+" to fam mem count in storage.");
                                                Storage.getInstance().writeObject("no_fam_mems", str_no_fam_mems);
                                            }
                                            else
                                            {
                                                System.out.println("Updating 1 to fam mem count to storage.");
                                                Storage.getInstance().writeObject("no_fam_mems", "1");
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Updating 1 to fam mem count to storage.");
                                            Storage.getInstance().writeObject("no_fam_mems", "1");
                                        }

                                        acc_member[i] = new Accordion();
                                        acc_member[i].addContent(cb_fam[i], new SpanLabel("The quick brown fox jumps over the lazy dog\n"
                                                + "The quick brown fox jumps over the lazy dog"));
                                        /*acc_member[i].addContent("Item2", new SpanLabel("The quick brown fox jumps over the lazy dog\n"
                                                + "The quick brown fox jumps over the lazy dog\n "
                                                + "The quick brown fox jumps over the lazy dog\n "
                                                + "The quick brown fox jumps over the lazy dog\n "
                                                + ""));*/

                                        /*acc_member[i].addContent("Item3", BoxLayout.encloseY(new Label("Label"), new TextField(), new Button("Button"), new CheckBox("CheckBox")));*/

                                        cnt_family.add(acc_member[i]);
                                    }
                                    else
                                    {
                                        //System.err.println("Updating 0 to fam mem count to storage.");
                                        //Storage.getInstance().writeObject("no_fam_mems", "0");
                                        
                                        System.err.println("Not adding family to auctocomplete options "+i+". Name: "+(String)obj.get("name").toString().trim()+" (MemNos: "+(String)obj.get("member_no").toString().trim()+") "+str_temp_family_id.trim());
                                    }

                                    str_acoptions[i] = str_name+" ("+str_memno+")";
                                    sb_options.append(str_acoptions[i]);


                                    //if(str_familyid.equals())

                                    i++;                
                                }

                                cnt_family.remove();
                                acc_family.addContent("Family Members", cnt_family);

                                //CircleProgress.markComponentLoading(ac_search).getStyle().setFgColor(0xff0000);
                                //CircleProgress.markComponentReady(ac_search, CommonTransitions.createFade(300));
                                ac_search.setCompletion(str_acoptions);

                                str_no_fam_mems = Storage.getInstance().readObject("no_fam_mems").toString();
                                lbl_info.setText("Family Members: "+str_no_fam_mems);
                            } 
                            catch(IOException err) 
                            {
                                    Log.p("Search error occured: "+err, 1);
                            }
                        }
                        else
                        {
                            Log.p("ac raw data: "+ac_search.getText().trim());
                        }
                    
                } 
                catch (Exception e) 
                {
                    Log.p("Network error occured: "+e, 1);
                }
            }
        });
        ac_search.setHint("Click here to search by Name or Member No.");
        ac_search.getAllStyles().setMargin(0, 2, 2, 2);
        ac_search.getHintLabel().getStyle().setFgColor(0xff0000, false);
        ac_search.getUnselectedStyle().setBgColor(0xf8f8f8);
        ac_search.getSelectedStyle().setBgColor(0xffffff);
        ac_search.getStyle().setFgColor(0xC0C0C0);
        ac_search.getHintLabel().getStyle().setFont(font_medium_plain, false);
        ac_search.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        ac_search.getUnselectedStyle().getBorder().setThickness(3);
        ac_search.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        ac_search.getSelectedStyle().getBorder().setThickness(3);
        ac_search.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        ac_search.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){ac_search.getStyle().setBgTransparency(255);}
        ac_search.setMinimumElementsShownInPopup(5);
        
        
        txtf_memberno = new TextField(str_memno, "Member No*");
        txtf_memberno.setGrabsPointerEvents(false);
        txtf_memberno.setBlockLead(false);
        txtf_memberno.setHandlesInput(false);
        txtf_memberno.setIgnorePointerEvents(true);
        txtf_memberno.setTraversable(false);
        txtf_memberno.setConstraint(TextField.NUMERIC);
        txtf_memberno.getAllStyles().setMargin(0, 2, 2, 2);
        txtf_memberno.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txtf_memberno.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtf_memberno.getSelectedStyle().setBgColor(0xffffff);
        txtf_memberno.getStyle().setFgColor(0xC0C0C0);
        txtf_memberno.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_memberno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, false)); 
        txtf_memberno.getUnselectedStyle().getBorder().setThickness(3);
        txtf_memberno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, false)); 
        txtf_memberno.getSelectedStyle().getBorder().setThickness(3);
        txtf_memberno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, false)); 
        txtf_memberno.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtf_memberno.getStyle().setBgTransparency(255);}else{txtf_memberno.getStyle().setBgTransparency(255);}
        
        
        CheckBox cb_member = new CheckBox("Member");
        cb_member.setToggle(true);
        cb_member.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //txtf_memberno.setText("");
                //txtf_memberno.setEditable(true);
                //txtf_memberno.setFocusable(true);
                //ac_search.clear();
                
                Storage.getInstance().deleteStorageFile("temp_srl_number");
                Storage.getInstance().deleteStorageFile("temp_ref_number");
                Storage.getInstance().deleteStorageFile("temp_trx_number");
                Storage.getInstance().deleteStorageFile("temp_member_no");
                Storage.getInstance().deleteStorageFile("temp_firstname");
                Storage.getInstance().deleteStorageFile("temp_middlename");
                Storage.getInstance().deleteStorageFile("temp_lastname");
                Storage.getInstance().deleteStorageFile("temp_other_name");
                Storage.getInstance().deleteStorageFile("temp_phone");
                Storage.getInstance().deleteStorageFile("temp_email");
                
                Storage.getInstance().writeObject("usertype", "member");
                    
                dlg_payments.dispose();
                
                Storage.getInstance().deleteStorageFile("acc_open");
                showPayDialog1();
            }
        });
        
        CheckBox cb_ssmember = new CheckBox("SS.Member");
        cb_ssmember.setToggle(true);
        cb_ssmember.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                txtf_memberno.setText("S");
                txtf_memberno.setEditable(true);
                txtf_memberno.setFocusable(true);
            }
        });
        
        CheckBox cb_visitor = new CheckBox("Visitor");
        cb_visitor.setToggle(true);
        cb_visitor.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                txtf_memberno.setText("Visitor");
                txtf_firstname.setText("");
                txtf_middlename.setText("");
                txtf_other_name.setText("");
                txtf_lastname.setText("");
                txtf_phone.setText("");
                txtf_email.setText("");
                txtf_memberno.setEditable(false);
                txtf_memberno.setFocusable(false);
                txtf_firstname.setEditable(true);
                txtf_firstname.setFocusable(true);
                txtf_middlename.setEditable(true);
                txtf_middlename.setFocusable(true);
                txtf_lastname.setFocusable(true);
                txtf_lastname.setFocusable(true);
                txtf_other_name.setEditable(true);
                txtf_other_name.setFocusable(true);
                txtf_phone.setEditable(true);
                txtf_phone.setFocusable(true);
                txtf_email.setEditable(true);
                txtf_email.setFocusable(true);
                
                Storage.getInstance().writeObject("usertype", "visitor");
            }
        });
        
        
        
        CheckBox cb_anonymous = new CheckBox("Anonymous");
        cb_anonymous.setToggle(true);
        cb_anonymous.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                txtf_memberno.setText("Anonymous");
                txtf_firstname.setText("No Firstname");
                txtf_middlename.setText("No Middlename");
                txtf_lastname.setText("No Lastname");
                txtf_phone.setText("No Phonenumber");
                txtf_email.setText("No Emailaddress");
                txtf_memberno.setEditable(false);
                txtf_memberno.setFocusable(false);
                txtf_firstname.setEditable(false);
                txtf_firstname.setFocusable(false);
                txtf_middlename.setFocusable(false);
                txtf_middlename.setEditable(false);
                txtf_lastname.setEditable(false);
                txtf_lastname.setFocusable(false);
                txtf_other_name.setEditable(false);
                txtf_other_name.setFocusable(false);
                txtf_phone.setEditable(false);
                txtf_phone.setFocusable(false);
                txtf_email.setEditable(false);
                txtf_email.setFocusable(false);
                
                Storage.getInstance().writeObject("usertype", "anonymous");
            }
        });
        
        
        RadioButton rb1 = new RadioButton("Member");
        rb1.setSelected(true);
        rb1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Storage.getInstance().deleteStorageFile("no_fam_mems");
                
                
                lbl_info.setText("Family Members: "+"0");
                
                ac_search.setHint("Click here to search by Name or Member No.");
                ac_search.setText("");
                //ac_search.setEnabled(true);
                ac_search.setEditable(true);
                ac_search.setFocusable(true);
                ac_search.repaint();
                ac_search.getParent().revalidate();
                
                txtf_memberno.setText("Member");
                txtf_firstname.setText("");
                txtf_middlename.setText("");
                txtf_lastname.setText("");
                txtf_phone.setText("");
                txtf_email.setText("");
                txtf_memberno.setEditable(false);
                txtf_memberno.setFocusable(false);
                txtf_firstname.setEditable(true);
                txtf_firstname.setFocusable(true);
                txtf_middlename.setEditable(true);
                txtf_middlename.setFocusable(true);
                txtf_lastname.setEditable(true);
                txtf_lastname.setFocusable(true);
                txtf_other_name.setEditable(true);
                txtf_other_name.setFocusable(true);
                txtf_phone.setEditable(true);
                txtf_phone.setFocusable(true);
                txtf_email.setEditable(true);
                txtf_email.setFocusable(true);
                
                Storage.getInstance().deleteStorageFile("temp_srl_number");
                Storage.getInstance().deleteStorageFile("temp_ref_number");
                Storage.getInstance().deleteStorageFile("temp_trx_number");
                Storage.getInstance().deleteStorageFile("temp_member_no");
                Storage.getInstance().deleteStorageFile("temp_firstname");
                Storage.getInstance().deleteStorageFile("temp_middlename");
                Storage.getInstance().deleteStorageFile("temp_lastname");
                Storage.getInstance().deleteStorageFile("temp_other_name");
                Storage.getInstance().deleteStorageFile("temp_phone");
                Storage.getInstance().deleteStorageFile("temp_email");
                Storage.getInstance().deleteStorageFile("temp_idnumber");
                
                Storage.getInstance().writeObject("usertype", "member");
                    
                dlg_payments.dispose();
                
                Storage.getInstance().deleteStorageFile("acc_open");
                showPayDialog1();
            }
        });
        
        RadioButton rb2 = new RadioButton("Visitor");
        rb2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Storage.getInstance().deleteStorageFile("no_fam_mems");
                
                
                lbl_info.setText("Family Members: "+"0");
                
                ac_search.setHint("");
                ac_search.setText("");
                //ac_search.setEnabled(false);
                ac_search.setEditable(false);
                ac_search.setFocusable(false);
                ac_search.repaint();
                ac_search.getParent().revalidate();
                
                txtf_memberno.setText("Visitor");
                txtf_firstname.setText("");
                txtf_middlename.setText("");
                txtf_lastname.setText("");
                txtf_other_name.setText("");
                txtf_phone.setText("");
                txtf_email.setText("");
                txtf_memberno.setEditable(false);
                txtf_memberno.setFocusable(false);
                txtf_firstname.setEditable(true);
                txtf_firstname.setFocusable(true);
                txtf_middlename.setEditable(true);
                txtf_middlename.setFocusable(true);
                txtf_lastname.setEditable(true);
                txtf_lastname.setFocusable(true);
                txtf_other_name.setEditable(true);
                txtf_other_name.setFocusable(true);
                txtf_phone.setEditable(true);
                txtf_phone.setFocusable(true);
                txtf_email.setEditable(true);
                txtf_email.setFocusable(true);
                
                Storage.getInstance().writeObject("usertype", "visitor");
                
                Storage.getInstance().deleteStorageFile("temp_srl_number");
                Storage.getInstance().deleteStorageFile("temp_ref_number");
                Storage.getInstance().deleteStorageFile("temp_trx_number");
                Storage.getInstance().deleteStorageFile("temp_member_no");
                Storage.getInstance().deleteStorageFile("temp_firstname");
                Storage.getInstance().deleteStorageFile("temp_middlename");
                Storage.getInstance().deleteStorageFile("temp_lastname");
                Storage.getInstance().deleteStorageFile("temp_other_name");
                Storage.getInstance().deleteStorageFile("temp_phone");
                Storage.getInstance().deleteStorageFile("temp_email");
                Storage.getInstance().deleteStorageFile("temp_idnumber");
            }
        });
        
        RadioButton rb3 = new RadioButton("Anonymous");
        rb3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Storage.getInstance().deleteStorageFile("no_fam_mems");
                
                
                lbl_info.setText("Family Members: "+"0");
                
                ac_search.setHint("");
                ac_search.setText("");
                //ac_search.setEnabled(false);
                ac_search.setEditable(false);
                ac_search.setFocusable(false);
                ac_search.repaint();
                ac_search.getParent().revalidate();
                
                txtf_memberno.setText("Anonymous");
                txtf_firstname.setText("No Firstname");
                txtf_middlename.setText("No Middlename");
                txtf_lastname.setText("No Lastname");
                txtf_other_name.setText("No other_name");
                txtf_phone.setText("No Phonenumber");
                txtf_email.setText("No Emailaddress");
                
                txtf_memberno.setEditable(false);
                txtf_memberno.setFocusable(false);
                
                txtf_firstname.setEditable(false);
                txtf_firstname.setFocusable(false);
                txtf_middlename.setEditable(false);
                txtf_middlename.setFocusable(false);
                txtf_lastname.setFocusable(false);
                txtf_lastname.setFocusable(false);
                txtf_other_name.setEditable(false);
                txtf_other_name.setFocusable(false);
                txtf_phone.setEditable(false);
                txtf_phone.setFocusable(false);
                txtf_email.setEditable(false);
                txtf_email.setFocusable(false);
                
                Storage.getInstance().writeObject("usertype", "anonymous");
                
                Storage.getInstance().deleteStorageFile("temp_srl_number");
                Storage.getInstance().deleteStorageFile("temp_ref_number");
                Storage.getInstance().deleteStorageFile("temp_trx_number");
                Storage.getInstance().deleteStorageFile("temp_member_no");
                Storage.getInstance().deleteStorageFile("temp_firstname");
                Storage.getInstance().deleteStorageFile("temp_middlename");
                Storage.getInstance().deleteStorageFile("temp_lastname");
                Storage.getInstance().deleteStorageFile("temp_other_name");
                Storage.getInstance().deleteStorageFile("temp_phone");
                Storage.getInstance().deleteStorageFile("temp_email");
                Storage.getInstance().deleteStorageFile("temp_idnumber");
            }
        });
        
        new ButtonGroup(rb1, rb2, rb3);
        
        
        
        
        
        txtf_firstname = new TextField(str_fname, "First Name*");
        txtf_firstname.setConstraint(TextField.INITIAL_CAPS_WORD);
        txtf_firstname.getAllStyles().setMargin(0, 2, 2, 2);
        txtf_firstname.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txtf_firstname.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtf_firstname.getSelectedStyle().setBgColor(0xffffff);
        txtf_firstname.getStyle().setFgColor(0xC0C0C0);
        txtf_firstname.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_firstname.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, false)); 
        txtf_firstname.getUnselectedStyle().getBorder().setThickness(3);
        txtf_firstname.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, false)); 
        txtf_firstname.getSelectedStyle().getBorder().setThickness(3);
        txtf_firstname.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_firstname.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtf_firstname.getStyle().setBgTransparency(255);}else{txtf_firstname.getStyle().setBgTransparency(255);}
        
        txtf_middlename = new TextField(str_mname, "Middle Name*");
        txtf_middlename.setConstraint(TextField.INITIAL_CAPS_WORD);
        txtf_middlename.getAllStyles().setMargin(0, 2, 2, 2);
        txtf_middlename.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txtf_middlename.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtf_middlename.getSelectedStyle().setBgColor(0xffffff);
        txtf_middlename.getStyle().setFgColor(0xC0C0C0);
        txtf_middlename.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_middlename.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_middlename.getUnselectedStyle().getBorder().setThickness(3);
        txtf_middlename.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_middlename.getSelectedStyle().getBorder().setThickness(3);
        txtf_middlename.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_middlename.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtf_middlename.getStyle().setBgTransparency(255);}
        
        txtf_other_name = new TextField(str_oname, "Other Name*");
        txtf_other_name.setConstraint(TextField.INITIAL_CAPS_WORD);
        txtf_other_name.getAllStyles().setMargin(0, 2, 2, 2);
        txtf_other_name.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txtf_other_name.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtf_other_name.getSelectedStyle().setBgColor(0xffffff);
        txtf_other_name.getStyle().setFgColor(0xC0C0C0);
        txtf_other_name.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_other_name.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_other_name.getUnselectedStyle().getBorder().setThickness(3);
        txtf_other_name.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_other_name.getSelectedStyle().getBorder().setThickness(3);
        txtf_other_name.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_other_name.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtf_other_name.getStyle().setBgTransparency(255);}
        
        txtf_lastname = new TextField(str_lname, "Last Name*");
        txtf_lastname.setConstraint(TextField.INITIAL_CAPS_WORD);
        txtf_lastname.getAllStyles().setMargin(0, 2, 2, 2);
        txtf_lastname.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txtf_lastname.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtf_lastname.getSelectedStyle().setBgColor(0xffffff);
        txtf_lastname.getStyle().setFgColor(0xC0C0C0);
        txtf_lastname.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_lastname.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_lastname.getUnselectedStyle().getBorder().setThickness(3);
        txtf_lastname.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_lastname.getSelectedStyle().getBorder().setThickness(3);
        txtf_lastname.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        txtf_lastname.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtf_lastname.getStyle().setBgTransparency(255);}
                   
        
        txtf_phone = new TextField(str_phone, "Phone No*"); //str_phone HERE
        txtf_phone.setConstraint(TextField.PHONENUMBER);
        txtf_phone.getAllStyles().setMargin(0, 2, 2, 2);
        txtf_phone.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txtf_phone.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtf_phone.getSelectedStyle().setBgColor(0xffffff);
        txtf_phone.getStyle().setFgColor(0xC0C0C0);
        txtf_phone.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_phone.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
        txtf_phone.getUnselectedStyle().getBorder().setThickness(3);
        txtf_phone.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
        txtf_phone.getSelectedStyle().getBorder().setThickness(3);
        txtf_phone.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
        txtf_phone.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtf_phone.getStyle().setBgTransparency(255);}        
        
        txtf_email = new TextField(str_email, "Email*");
        txtf_email.setConstraint(TextField.EMAILADDR);
        txtf_email.getAllStyles().setMargin(0, 2, 2, 2);
        txtf_email.getHintLabel().getStyle().setFgColor(0xC0C0C0, false); //0x888
        txtf_email.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtf_email.getSelectedStyle().setBgColor(0xffffff);
        txtf_email.getStyle().setFgColor(0xC0C0C0);
        txtf_email.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_email.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, false)); 
        txtf_email.getUnselectedStyle().getBorder().setThickness(3);
        txtf_email.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, false)); 
        txtf_email.getSelectedStyle().getBorder().setThickness(3);
        txtf_email.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, false)); 
        txtf_email.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtf_email.getStyle().setBgTransparency(255);}
        
        /*val_memberno = new Validator();
        val_memberno.addConstraint(txtf_memberno, new LengthConstraint(1));
        val_firstname = new Validator();
        val_firstname.addConstraint(txtf_firstname, new LengthConstraint(2));
        val_lastname = new Validator();
        val_lastname.addConstraint(txtf_lastname, new LengthConstraint(2));
        val_phone = new Validator();
        val_phone.addConstraint(txtf_phone, new LengthConstraint(1));
        //val_phone.addConstraint(txtf_phone, new RegexConstraint(phoneRegex, "Must be valid phone number"));
        val_email = new Validator();
        val_email.addConstraint(txtf_email, RegexConstraint.validEmail());*/
                                
        dlg_payments = new Dialog();
        dlg_payments.setLayout(new BorderLayout());
        dlg_payments.getStyle().setBgColor(0xeee);
        //dlg_payments.setScrollableY(true);
        
        Label lbl_step1 = new Label("Step 1/3");
        lbl_step1.getStyle().setBgColor(0xffffff);
        lbl_step1.getStyle().setFgColor(0x000000);
        lbl_step1.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_LARGE));
                
        Label lbl_step1_desc = new Label("Personal Details:");
        lbl_step1_desc.getStyle().setBgColor(0xffffff);
        lbl_step1_desc.getStyle().setFgColor(0x888);
        lbl_step1_desc.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        
        
                
        btn_closePayDlg = new Button(theme.getImage("cancel.png")); //ifont_close
        btn_closePayDlg.setUIID("Label");
        btn_closePayDlg.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("Close[x]icon pressed 1.");
                
                bool_no_new_items = Storage.getInstance().exists("no_new_items");
                if(bool_no_new_items == true)
                {
                    System.out.println("Deleting temporary form data");
                
                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                    int_no_new_items = Integer.parseInt(str_no_new_items);
                    
                    Storage.getInstance().deleteStorageFile("temp_srl_number");
                    Storage.getInstance().deleteStorageFile("temp_ref_number");
                    Storage.getInstance().deleteStorageFile("temp_trx_number");
                    Storage.getInstance().deleteStorageFile("temp_member_no");
                    Storage.getInstance().deleteStorageFile("temp_firstname");
                    Storage.getInstance().deleteStorageFile("temp_middlename");
                    Storage.getInstance().deleteStorageFile("temp_other_name");
                    Storage.getInstance().deleteStorageFile("temp_lastname");
                    Storage.getInstance().deleteStorageFile("temp_phone");
                    Storage.getInstance().deleteStorageFile("temp_email");
                    Storage.getInstance().deleteStorageFile("tithev");
                    Storage.getInstance().deleteStorageFile("offeringv");
                    Storage.getInstance().deleteStorageFile("buildingv");
                    Storage.getInstance().deleteStorageFile("budgetv");
                    
                    Storage.getInstance().deleteStorageFile("buildingv_roof");
                    Storage.getInstance().deleteStorageFile("buildingv_premix");
                    Storage.getInstance().deleteStorageFile("buildingv_wall");
                    Storage.getInstance().deleteStorageFile("buildingv_elec");
                    Storage.getInstance().deleteStorageFile("buildingv_plumb");
                    Storage.getInstance().deleteStorageFile("buildingv_pulpit");
                    Storage.getInstance().deleteStorageFile("buildingv_window");

                    //System.out.println(""+int_no_items)
                    for(k=0; k < int_no_new_items; k++)
                    {
                        System.out.println("Deleting... "+k);
                        Storage.getInstance().deleteStorageFile("new_item_"+k);
                        Storage.getInstance().deleteStorageFile("new_itemv_"+k);
                    }
                    
                    Storage.getInstance().deleteStorageFile("no_new_items");
                    Storage.getInstance().deleteStorageFile("payprovider");
                    Storage.getInstance().deleteStorageFile("paymethod");
                    Storage.getInstance().deleteStorageFile("pay_instructions");
                    Storage.getInstance().deleteStorageFile("totals");
                }
                else
                {
                }
                
                bool_no_main_items = Storage.getInstance().exists("no_main_items");
                if(bool_no_main_items == true)
                {
                    System.out.println("Deleting temporary form "+int_no_main_items+" main_item(s).");
                
                    str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                    int_no_main_items = Integer.parseInt(str_no_main_items);
                    
                    Storage.getInstance().deleteStorageFile("tithev");
                    Storage.getInstance().deleteStorageFile("offeringv");
                    Storage.getInstance().deleteStorageFile("buildingv");
                    Storage.getInstance().deleteStorageFile("budgetv");
                    
                    Storage.getInstance().deleteStorageFile("buildingv_roof");
                    Storage.getInstance().deleteStorageFile("buildingv_premix");
                    Storage.getInstance().deleteStorageFile("buildingv_wall");
                    Storage.getInstance().deleteStorageFile("buildingv_elec");
                    Storage.getInstance().deleteStorageFile("buildingv_plumb");
                    Storage.getInstance().deleteStorageFile("buildingv_pulpit");
                    Storage.getInstance().deleteStorageFile("buildingv_window");

                    for(k=1; k < int_no_main_items+1; k++)
                    {
                        System.out.println("Deleting main_item "+k);
                        Storage.getInstance().deleteStorageFile("main_item_"+k);
                        Storage.getInstance().deleteStorageFile("main_itemv_"+k);
                    }
                    Storage.getInstance().deleteStorageFile("no_main_items");
                    Storage.getInstance().deleteStorageFile("main_item");
                }
                else
                {
                }
                
                System.out.println("Closing payment popup dialog 1.");
                dlg_payments.dispose();
            }
        });
        
        btn_minimise = new Button(theme.getImage("minimise.png")); //ifont_close
        btn_minimise.setUIID("Label");
        btn_minimise.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //CLose dialog
                dlg_payments.dispose();
                //Delete temporary form details
            }
        });
        
        Container cnt_dlgCMDs = new Container(new BorderLayout());
        cnt_dlgCMDs.getStyle().setBgColor(0xffffff);
        cnt_dlgCMDs.getStyle().setBgTransparency(255);
        cnt_dlgCMDs.add(BorderLayout.WEST, btn_minimise);
        cnt_dlgCMDs.add(BorderLayout.EAST, btn_closePayDlg);
        
        Container cnt_dlgHeader = new Container(new BorderLayout());
        cnt_dlgHeader.getStyle().setBgColor(0xffffff);
        cnt_dlgHeader.getStyle().setBgTransparency(255);
        cnt_dlgHeader.add(BorderLayout.WEST, BoxLayout.encloseY(lbl_step1, lbl_step1_desc));
        cnt_dlgHeader.add(BorderLayout.EAST, FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty_icon_dlgPay, 8));
        
        
        
        Button btn_next = new Button("Next");
        btn_next.getUnselectedStyle().setBgColor(0x448d21); //0x448d21 - frog green //0x19B9E7 - light bluish   //0x35E041 - light green
        btn_next.getUnselectedStyle().setBgTransparency(255);
        btn_next.getUnselectedStyle().setBorder(null);
        btn_next.getSelectedStyle().setBorder(null);
        btn_next.getStyle().setFgColor(0xffffff);
        btn_next.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                /*if(!txtf_trxno.getText().trim().equals("") || !txtf_memberno.getText().trim().equals("")) 
                {
                    
                    System.out.println("Next button pressed, going to Form 2.");
                    if(!txtf_trxno.getText().trim().equals(""))
                    {
                        Storage.getInstance().writeObject("trx_number", txtf_trxno.getText().trim());
                    }
                    else
                    {
                        Storage.getInstance().writeObject("trx_number", "0");
                    }
                    
                    if(!txtf_memberno.getText().trim().equals(""))
                    {
                        Storage.getInstance().writeObject("temp_memberno", txtf_memberno.getText().trim());
                    }
                    else
                    {
                        Storage.getInstance().writeObject("temp_memberno", "0");
                    }
                    
                    Storage.getInstance().writeObject("first_name", txtf_firstname.getText().trim());
                    Storage.getInstance().writeObject("last_name", txtf_lastname.getText().trim());
                    Storage.getInstance().writeObject("phone_number", txtf_phone.getText().trim());
                    Storage.getInstance().writeObject("email_address", txtf_email.getText().trim());
                    
                    
                    
                    dlg_payments.dispose();
                    showPayDialog2();
                }
                else
                {
                    
                }*/
                
                System.out.println("Transaction No.: "+txtf_trxno.getText().trim()+"\nMember No.: "+txtf_memberno.getText().trim()+"\nFirst Name: "+txtf_firstname.getText().trim()+"\nLast Name: "+txtf_lastname.getText().trim()+"\nPhone No.: "+txtf_phone.getText().trim()+"\nEmail Add.: "+txtf_email.getText().trim());
                
                bool_role = Storage.getInstance().exists("role");
                if(bool_role == true)
                {
                    str_role = Storage.getInstance().readObject("role").toString().trim();
                    if(str_role.equals("Assistant Treasurer") || str_role.equals("Treasurer"))
                    {                        
                        if(txtf_firstname.getText().trim().equals(""))
                        {
                            Connect.okayDialog("Oops!", "You must enter your first name to proceed.");

                            //txtf_email.clear();
                            //txtf_phone.clear();
                            //Storage.getInstance().deleteStorageFile("temp_email");
                            
                            //txtf_email.setText("no@mail.com");
                            //txtf_phone.setText("1234567");
                        }
                        else if(txtf_firstname.getText().trim().length() < 2) 
                        {
                             //lbl_email_error.setText("You have entered an invalid email.");
                             Connect.okayDialog("Oops!", "The firstname you have entered is too short.");

                             //txtf_email.clear();
                             //txtf_phone.clear();
                             //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else if(txtf_lastname.getText().trim().equals(""))
                        {
                            Connect.okayDialog("Oops!", "You must enter your lastname to proceed.");

                            //txtf_email.clear();
                            //txtf_phone.clear();
                            //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else if(txtf_lastname.getText().trim().length() < 2) 
                        {
                             //lbl_email_error.setText("You have entered an invalid email.");
                             Connect.okayDialog("Oops!", "The lastname you have entered is too short.");

                             //txtf_email.clear();
                             //txtf_phone.clear();
                             //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else
                        {
                            if(txtf_email.getText().trim().equals(""))
                            {
                                txtf_email.setText("no@mail.com");
                            }
                            if(txtf_phone.getText().trim().equals(""))
                            {
                                txtf_phone.setText("1234567");
                            }
                            
                            System.out.println("Next button pressed, Writing Form 1 data to storage and going to Form 2.");
                            System.out.println("--------------------------------------------"); 
                            
                            
                            bool_refno = Storage.getInstance().exists("temp_ref_number");
                            if(bool_refno == true)
                            {
                                //str_trxno = Storage.getInstance().readObject("temp_ref_number").toString();
                                //Storage.getInstance().writeObject("temp_ref_number", "-------");
                            }
                            else
                            {
                                Storage.getInstance().writeObject("temp_ref_number", "-------");
                            }
                            
                            L10NManager l10n = L10NManager.getInstance();
                            //l10n.
                            
                            StringUtil.tokenize(txtf_firstname.getText().toUpperCase().trim(), '[').get(0);
                            
                            //txtf_firstname.getText().toUpperCase().trim().charAt(0);
                            //txtf_firstname.getText().toUpperCase().trim().substring(0, 1);
                            //txtf_firstname.getText().toLowerCase().trim().substring(1);
                            
                            //txtf_firstname.getText().substring(0, 1).toUpperCase()).append(txtf_firstname.getText().substring(1).toLowerCase();
                            
                            
                            Storage.getInstance().writeObject("temp_trx_number", txtf_trxno.getText().trim());
                            Storage.getInstance().writeObject("temp_member_no", txtf_memberno.getText().trim()); //Locale(String language, String country, String variant)
                            Storage.getInstance().writeObject("temp_firstname", txtf_firstname.getText().toUpperCase().trim().substring(0, 1)+""+txtf_firstname.getText().toLowerCase().trim().substring(1));
                            Storage.getInstance().writeObject("temp_middlename", txtf_middlename.getText());
                            Storage.getInstance().writeObject("temp_lastname", txtf_lastname.getText());
                            Storage.getInstance().writeObject("temp_other_name", txtf_other_name.getText());
                            Storage.getInstance().writeObject("temp_phone", txtf_phone.getText().trim());
                            Storage.getInstance().writeObject("temp_email", txtf_email.getText().trim());

                            dlg_payments.dispose();
                            try 
                            {
                                showPayDialog2();

                            } 
                            catch (Exception ex) 
                            {
                                System.err.println("Error: "+ex);
                                ex.printStackTrace();
                            }
                        }
                    }
                    else
                    {
                        if(txtf_firstname.getText().trim().equals(""))
                        {
                            Connect.okayDialog("Oops!", "You must enter your first name to proceed.");

                            //txtf_email.clear();
                            //txtf_phone.clear();
                            //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else if(txtf_firstname.getText().trim().length() < 2) 
                        {
                             //lbl_email_error.setText("You have entered an invalid email.");
                             Connect.okayDialog("Oops!", "The firstname you have entered is too short.");

                             //txtf_email.clear();
                             //txtf_phone.clear();
                             //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else if(txtf_middlename.getText().trim().equals(""))
                        {
                            Connect.okayDialog("Oops!", "You must enter your middlename to proceed.");

                            //txtf_email.clear();
                            //txtf_phone.clear();
                            //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else if(txtf_middlename.getText().trim().length() < 2) 
                        {
                             //lbl_email_error.setText("You have entered an invalid email.");
                             Connect.okayDialog("Oops!", "The middlename you have entered is too short.");

                             //txtf_email.clear();
                             //txtf_phone.clear();
                             //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else if(txtf_lastname.getText().trim().equals(""))
                        {
                            Connect.okayDialog("Oops!", "You must enter your lastname to proceed.");

                            //txtf_email.clear();
                            //txtf_phone.clear();
                            //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else if(txtf_lastname.getText().trim().length() < 2) 
                        {
                             //lbl_email_error.setText("You have entered an invalid email.");
                             Connect.okayDialog("Oops!", "The lastname you have entered is too short.");

                             //txtf_email.clear();
                             //txtf_phone.clear();
                             //Storage.getInstance().deleteStorageFile("temp_email");
                        }
                        else if(txtf_email.getText().trim().equals(""))
                        {
                            Connect.okayDialog("Oops!", "You must enter your email address to proceed.");
                        }
                        else if(txtf_email.getText().trim().indexOf("@") == -1) 
                        {
                            //lbl_email_error.setText("You have entered an invalid email.");
                            Connect.okayDialog("Oops!", "You have entered an invalid email.");
                        }
                        else if(txtf_email.getText().trim().indexOf("@", txtf_email.getText().trim().indexOf("@")) == -1) 
                        {
                            //lbl_email_error.setText("You have entered an invalid email.");
                            Connect.okayDialog("Oops!", "You have entered an invalid email.");
                        }
                        else if(txtf_email.getText().trim().indexOf(".") == -1) 
                        {
                            //lbl_email_error.setText("You have entered an invalid email.");
                            Connect.okayDialog("Oops!", "You have entered an invalid email.");
                        }
                        else if(txtf_email.getText().trim().indexOf(".",  txtf_email.getText().trim().indexOf(".")) == -1) 
                        {
                            //lbl_email_error.setText("You have entered an invalid email.");
                            Connect.okayDialog("Oops!", "You have entered an invalid email.");
                        }
                        /*else if(txtf_email.getText().trim().indexOf("@") > txtf_email.getText().trim().indexOf(".")) 
                        {
                            //lbl_email_error.setText("You have entered an invalid email.");
                            Connect.okayDialog("Oops!", "You have entered an invalid email.");

                            System.err.println(txtf_email.getText().trim().indexOf(".")+"--- .");
                            System.err.println(txtf_email.getText().trim().indexOf("@")+"--- @");

                            if((txtf_email.getText().trim().indexOf(".")) == -1)
                            {

                            }
                            else
                            {
                            }
                        }
                            String string = "a.b.c.d";
                            String []splitArray = string.split("\\.",-1);
                            System.out.println("No of . chars is : " + (splitArray.length-1));
                        */
                        else if(txtf_email.getText().trim().indexOf("@") == txtf_email.getText().trim().indexOf(".")-1) 
                        {
                            //lbl_email_error.setText("You have entered an invalid email.");
                            Connect.okayDialog("Oops!", "You have entered an invalid email.");
                        }
                        else if(txtf_email.getText().trim().indexOf(".") < txtf_email.getText().trim().indexOf("@")) 
                        {
                            //lbl_email_error.setText("You have entered an invalid email.");
                            Connect.okayDialog("Oops!", "You have entered an invalid email.");
                        }
                        else if(txtf_email.getText().trim().length() < 6) 
                        {
                             //lbl_email_error.setText("You have entered an invalid email.");
                             Connect.okayDialog("Oops!", "You have entered an invalid email.");
                        }
                        else if(txtf_phone.getText().trim().equals(""))
                        {
                            Connect.okayDialog("Oops!", "You must enter your phonenumber to proceed.");
                        }
                        else if(txtf_phone.getText().trim().contains("A") || txtf_phone.getText().trim().indexOf("N") >= 0 || 
                        txtf_phone.getText().trim().indexOf("B") >= 0 || txtf_phone.getText().trim().indexOf("O") >= 0 || 
                        txtf_phone.getText().trim().indexOf("C") >= 0 || txtf_phone.getText().trim().indexOf("P") >= 0 ||
                        txtf_phone.getText().trim().indexOf("D") >= 0 || txtf_phone.getText().trim().indexOf("Q") >= 0 || 
                        txtf_phone.getText().trim().indexOf("E") >= 0 || txtf_phone.getText().trim().indexOf("R") >= 0 ||
                        txtf_phone.getText().trim().indexOf("F") >= 0 || txtf_phone.getText().trim().indexOf("S") >= 0 ||
                        txtf_phone.getText().trim().indexOf("G") >= 0 || txtf_phone.getText().trim().indexOf("T") >= 0 || 
                        txtf_phone.getText().trim().indexOf("H") >= 0 || txtf_phone.getText().trim().indexOf("U") >= 0 ||
                        txtf_phone.getText().trim().indexOf("I") >= 0 || txtf_phone.getText().trim().indexOf("V") >= 0 || 
                        txtf_phone.getText().trim().indexOf("J") >= 0 || txtf_phone.getText().trim().indexOf("W") >= 0 ||
                        txtf_phone.getText().trim().indexOf("K") >= 0 || txtf_phone.getText().trim().indexOf("X") >= 0 ||
                        txtf_phone.getText().trim().indexOf("L") >= 0 || txtf_phone.getText().trim().indexOf("Y") >= 0 || 
                        txtf_phone.getText().trim().indexOf("M") >= 0 || txtf_phone.getText().trim().indexOf("Z") >= 0)
                        {
                            Connect.okayDialog("Oops!", "You have entered an invalid phonenumber. Please remove any letters to proceed.");
                        }
                        else if(txtf_phone.getText().trim().indexOf("[") >= 0 || txtf_phone.getText().trim().indexOf("_") >= 0 || 
                                txtf_phone.getText().trim().indexOf("~") >= 0 || txtf_phone.getText().trim().indexOf("=") >= 0 || 
                                txtf_phone.getText().trim().indexOf("!") >= 0 || txtf_phone.getText().trim().indexOf("=") >= 0 ||
                                txtf_phone.getText().trim().indexOf("@") >= 0 || txtf_phone.getText().trim().indexOf("[") >= 0 || 
                                txtf_phone.getText().trim().indexOf("#") >= 0 || txtf_phone.getText().trim().indexOf("{") >= 0 ||
                                txtf_phone.getText().trim().indexOf("$") >= 0 || txtf_phone.getText().trim().indexOf("]") >= 0 ||
                                txtf_phone.getText().trim().indexOf("%") >= 0 || txtf_phone.getText().trim().indexOf("}") >= 0 || 
                                txtf_phone.getText().trim().indexOf("^") >= 0 || txtf_phone.getText().trim().indexOf("|") >= 0 ||
                                txtf_phone.getText().trim().indexOf("&") >= 0 || txtf_phone.getText().trim().indexOf(";") >= 0 || 
                                txtf_phone.getText().trim().indexOf("*") >= 0 || txtf_phone.getText().trim().indexOf(":") >= 0 ||
                                txtf_phone.getText().trim().indexOf("(") >= 0 || txtf_phone.getText().trim().indexOf("<") >= 0 ||
                                txtf_phone.getText().trim().indexOf(")") >= 0 || txtf_phone.getText().trim().indexOf(">") >= 0 || 
                                txtf_phone.getText().trim().indexOf("-") >= 0 || txtf_phone.getText().trim().indexOf("/") >= 0)
                        {
                              Connect.okayDialog("Oops!", "You have entered an invalid telephone number. Only the '+' character is allowed.");
                        }
                        else if(txtf_phone.getText().trim().length() < 7) 
                        {
                             //lbl_email_error.setText("You have entered an invalid email.");
                             Connect.okayDialog("Oops!", "The phonenumber you have entered is too short.");
                        }
                        else
                        {
                            System.out.println("Next button pressed, Writing Form 1 data to storage and going to Form 2.");
                            System.out.println("--------------------------------------------"); 
                            Storage.getInstance().writeObject("temp_trx_number", txtf_trxno.getText().trim());
                            Storage.getInstance().writeObject("temp_member_no", txtf_memberno.getText().trim());
                            Storage.getInstance().writeObject("temp_firstname", txtf_firstname.getText().trim());
                            Storage.getInstance().writeObject("temp_middlename", txtf_middlename.getText().trim());
                            Storage.getInstance().writeObject("temp_lastname", txtf_lastname.getText().trim());
                            Storage.getInstance().writeObject("temp_other_name", txtf_other_name.getText().trim());
                            Storage.getInstance().writeObject("temp_phone", txtf_phone.getText().trim());
                            Storage.getInstance().writeObject("temp_email", txtf_email.getText().trim());



                            dlg_payments.dispose();
                            try 
                            {
                                showPayDialog2();

                            } 
                            catch (Exception ex) 
                            {
                                System.err.println("Error: "+ex);
                                ex.printStackTrace();
                            }
                        }
                    }
                }
                else
                {
                    //Not possible, through user our and alert server of possible malice attack.
                }
                
                
                
            }
        });
        
        
        lbl_info = new Label();
        lbl_info.setIcon(theme.getImage("info.png"));
        //lbl_info.setText("clear form");
        lbl_info.setTextPosition(RIGHT);
        lbl_info.getAllStyles().setFont(font_small_bold);
        lbl_info.getAllStyles().setFgColor(0x000000);
        lbl_info.getAllStyles().setAlignment(LEFT);
        lbl_info.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("Showing user's family relations.", 1);
                
                bool_no_fam_mems = Storage.getInstance().exists("no_fam_mems");
                if(bool_no_fam_mems == true)
                {
                    str_no_fam_mems = Storage.getInstance().readObject("no_fam_mems").toString();
                    int_no_fam_mems = Integer.parseInt(str_no_fam_mems);

                    System.out.println("No of family members 2: "+str_no_fam_mems);

                    if(int_no_fam_mems >= 1)
                    {
                        showFamMembersDlg();
                    }
                    else
                    {
                        Dialog.show("Sorry!", "There is no family data for this member.", "Ok", null);
                    }
                }
                else
                {
                    Dialog.show("Sorry!", "There is no family data.", "Ok", null);
                }
            }
        });
        
        bool_usertype = Storage.getInstance().exists("usertype");
        if(bool_usertype == true)
        {
            str_usertype = Storage.getInstance().readObject("usertype").toString();
            if(str_usertype.equals("member"))
            {
                rb1.setSelected(true);
                rb2.setSelected(false);
                rb3.setSelected(false);
            }
            else if(str_usertype.equals("visitor"))
            {
                rb1.setSelected(false);
                rb2.setSelected(true);
                rb3.setSelected(false);
            }
            else
            {
                rb1.setSelected(false);
                rb2.setSelected(false);
                rb3.setSelected(true);
            }
        }
        else
        {
                rb1.setSelected(true);
                rb2.setSelected(false);
                rb3.setSelected(false);
        }
        
        bool_temp_memno = Storage.getInstance().exists("no_fam_mems");
        if(bool_temp_memno == true)
        {
            str_no_fam_mems = Storage.getInstance().readObject("no_fam_mems").toString();
            if(str_no_fam_mems.equals(""))
            {
            }
            else
            {
                if(Integer.parseInt(str_no_fam_mems) > 0)
                {
                    FileSystemStorage inst2 = FileSystemStorage.getInstance();
                    final String homePath2 = inst2.getAppHomePath();
                    final char sep2 = inst.getFileSystemSeparator();

                    str_listcriteria = "members";

                    final String str_filepath2 = homePath2+sep2+str_listcriteria+".txt";

                    try 
                    {
                        InputStream is = inst.openInputStream(str_filepath2);
                        byte[] b = Util.readInputStream(is);
                        str_listcontent = new String(b); //SystBem.out.println("Content..: "+str_content);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println("Error: "+e);
                        //e.printStackTrace();
                    }

                    String str_json_read2 = str_listcontent;
                    byte[] dataa2 = str_json_read2.getBytes();

                    JSONParser json2 = new JSONParser();

                    try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa2), "UTF-8"))
                    {
                        Map<String, Object> map_content = json2.parseJSON(is_content);
                        java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");
                        System.out.println("No of Members 3:---------> "+obj_content.size()); 

                        sb_options = new StringBuilder(); 
                        str_acoptions = new String[obj_content.size()];

                        cb_fam = new CheckBox[obj_content.size()];

                        acc_member = new Accordion[obj_content.size()];

                        i = 0;
                        for(Map<String, Object> obj : obj_content) 
                        { 
                            str_id = (String)obj.get("id").toString().trim();
                            str_name = (String)obj.get("name").toString().trim();
                            str_memno = (String)obj.get("member_no").toString().trim();
                            str_family_id = (String)obj.get("family_id").toString().trim();

                            //bool_family_id = Storage.getInstance()
                            str_temp_family_id = Storage.getInstance().readObject("temp_family_id").toString();
                            if(str_temp_family_id.equals((String)obj.get("family_id").toString().trim()) && !str_family_id.equals(""))
                            {
                                Log.p("Adding family to auctocomplete options "+i+". Name: "+(String)obj.get("name").toString().trim()+" (MemNos: "+(String)obj.get("member_no").toString().trim()+") "+str_temp_family_id.trim(), 1);

                                cb_fam[i] = new CheckBox();
                                cb_fam[i].setText(str_name);
                                cb_fam[i].setUIID(str_memno);

                                bool_no_fam_mems = Storage.getInstance().exists("no_fam_mems");
                                if(bool_no_fam_mems == true)
                                {
                                    str_no_fam_mems = Storage.getInstance().readObject("no_fam_mems").toString();
                                    int_no_fam_mems = Integer.parseInt(str_no_fam_mems);

                                    System.out.println("No of family members 3: "+str_no_fam_mems);

                                    /*if(int_no_fam_mems >= 1)
                                    {
                                        Integer newcount;
                                        newcount = int_no_fam_mems+1;
                                        str_no_fam_mems = newcount.toString();

                                        System.out.println("Updating "+str_no_fam_mems+" to fam mem count in storage.");
                                        Storage.getInstance().writeObject("no_fam_mems", str_no_fam_mems);
                                    }
                                    else
                                    {
                                        System.out.println("Updating 1 to fam mem count to storage.");
                                        Storage.getInstance().writeObject("no_fam_mems", "1");
                                    }*/
                                }
                                else
                                {
                                    //System.out.println("Updating 1 to fam mem count to storage.");
                                    //Storage.getInstance().writeObject("no_fam_mems", "1");
                                }

                                acc_member[i] = new Accordion();
                                acc_member[i].addContent(cb_fam[i], new SpanLabel("The quick brown fox jumps over the lazy dog\n"
                                        + "The quick brown fox jumps over the lazy dog"));
                                /*acc_member[i].addContent("Item2", new SpanLabel("The quick brown fox jumps over the lazy dog\n"
                                        + "The quick brown fox jumps over the lazy dog\n "
                                        + "The quick brown fox jumps over the lazy dog\n "
                                        + "The quick brown fox jumps over the lazy dog\n "
                                        + ""));*/

                                /*acc_member[i].addContent("Item3", BoxLayout.encloseY(new Label("Label"), new TextField(), new Button("Button"), new CheckBox("CheckBox")));*/

                                cnt_family.add(acc_member[i]);
                            }
                            else
                            {
                                //System.out.println("Updating 0 to fam mem count to storage.");
                                //Storage.getInstance().writeObject("no_fam_mems", "0");
                            }

                            str_acoptions[i] = str_name+" ("+str_memno+")";
                            sb_options.append(str_acoptions[i]);


                            //if(str_familyid.equals())

                            i++;                
                        }

                        cnt_family.remove();
                        acc_family.addContent("Family Members", cnt_family);

                        //CircleProgress.markComponentLoading(ac_search).getStyle().setFgColor(0xff0000);
                        //CircleProgress.markComponentReady(ac_search, CommonTransitions.createFade(300));
                        ac_search.setCompletion(str_acoptions);

                        //if(!txtf_memberno.getText().trim().equals(""))
                        //{
                        //    str_no_fam_mems = Storage.getInstance().readObject("no_fam_mems").toString();
                        //    lbl_info.setText("Family Members: "+str_no_fam_mems);
                        //}
                        
                    } 
                    catch(IOException err) 
                    {
                            Log.p("Search error occured: "+err, 1);
                    }
                }
            }
        }
        else
        {
        }
        
        bool_no_fam_mems = Storage.getInstance().exists("no_fam_mems");
        if(bool_no_fam_mems == true)
        {
            str_no_fam_mems = Storage.getInstance().readObject("no_fam_mems").toString();
            int_no_fam_mems = Integer.parseInt(str_no_fam_mems);
            
            if(int_no_fam_mems >= 1)
            {
                lbl_info.setText("Family Members: "+str_no_fam_mems);
            }
            else
            {
                lbl_info.setText("Family Members: "+"0");
            }
        }
        else
        {
            lbl_info.setText("Family Members: "+"0");
        }
        
        lbl_clear1 = new Label();
        lbl_clear1.setIcon(theme.getImage("trash.png"));
        lbl_clear1.setText("clear form");
        lbl_clear1.setTextPosition(BOTTOM);
        lbl_clear1.getAllStyles().setFont(font_small_bold);
        lbl_clear1.getAllStyles().setFgColor(0x000000);
        lbl_clear1.getAllStyles().setAlignment(CENTER);
        lbl_clear1.addPointerPressedListener(new ActionListener() 
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

                SpanLabel slbl_message = new SpanLabel("Do you really want to clear the form?");
                slbl_message.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Yes");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {                       
                       dialog.dispose();
                       
                        //ac_search.clear();
                        //txtf_memberno.clear();
                        //txtf_firstname.clear();
                        //txtf_lastname.clear();
                        //txtf_phone.clear();
                        //txtf_email.clear();

                        //ac_search.setEditable(true);
                        //ac_search.setFocusable(true);

                        Storage.getInstance().deleteStorageFile("temp_srl_number");
                        Storage.getInstance().deleteStorageFile("temp_trx_number");
                        Storage.getInstance().deleteStorageFile("temp_member_no");
                        Storage.getInstance().deleteStorageFile("temp_firstname");
                        Storage.getInstance().deleteStorageFile("temp_middlename");
                        Storage.getInstance().deleteStorageFile("temp_other_name");
                        Storage.getInstance().deleteStorageFile("temp_lastname");
                        Storage.getInstance().deleteStorageFile("temp_phone");
                        Storage.getInstance().deleteStorageFile("temp_email");
                        Storage.getInstance().deleteStorageFile("no_fam_mems");

                        lbl_info.setText("Family Members: "+"0");

                        dlg_payments.dispose();

                        Storage.getInstance().deleteStorageFile("acc_open");
                        showPayDialog1();
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
                dialog.addComponent(BorderLayout.CENTER, slbl_message);
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
                
        Container cnt_dlgFooter = new Container(new BorderLayout());
        cnt_dlgFooter.add(BorderLayout.WEST, btn_next);
        cnt_dlgFooter.add(BorderLayout.EAST, lbl_clear1);
        
        Container cnt_dlgBody = new Container();
        cnt_dlgBody.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_dlgBody.setScrollableY(true);
        cnt_dlgBody.add(GridLayout.encloseIn(3, rb1, rb2, rb3)); //rb2, //txtf_trxno  //BoxLayout.encloseX(cb_ssmember, cb_visitor)
        //cnt_dlgBody.add(txtf_trxno);
        cnt_dlgBody.add(ac_search);
        cnt_dlgBody.add(txtf_memberno);
        cnt_dlgBody.add(txtf_firstname);
        cnt_dlgBody.add(txtf_middlename);
        cnt_dlgBody.add(txtf_other_name);
        cnt_dlgBody.add(txtf_lastname);
        cnt_dlgBody.add(txtf_phone);
        cnt_dlgBody.add(txtf_email);
        //cnt_dlgBody.add(acc_family);//cnt_family
        cnt_dlgBody.add(lbl_info);
        
        
        dlg_payments.add(BorderLayout.NORTH, BoxLayout.encloseY(cnt_dlgCMDs, cnt_dlgHeader)); //cnt_dlgCMDs
        dlg_payments.add(BorderLayout.CENTER, FlowLayout.encloseCenterMiddle(cnt_dlgBody));
        dlg_payments.add(BorderLayout.SOUTH, cnt_dlgFooter);
        
        
        
        dlg_payments.getUnselectedStyle().setBorder(Border.createRoundBorder(60, 60, 0xC0C0C0, false)); 
        dlg_payments.getUnselectedStyle().getBorder().setThickness(3);
        dlg_payments.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        dlg_payments.getSelectedStyle().getBorder().setThickness(3);
        dlg_payments.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, false)); 
        dlg_payments.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){dlg_payments.getStyle().setBgTransparency(255);}
        dlg_payments.growOrShrink();
        dlg_payments.showPacked(BorderLayout.CENTER, true);
        //dlg_payments.showAtPosition(displayHeight/8, displayHeight/8, displayWidth/8, displayWidth/8, false);
        //dlg_payments.setDisposeWhenPointerOutOfBounds(true);
       
    }
    
    public void showPayDialog2() throws NullPointerException
    {
        //txtf_tithe, txtf_offering, txtf_building, txtf_budget, txtf_tithev, txtf_offeringv, txtf_buildingv, txtf_budgetv
        
        dlg_payments2 = new Dialog();
        dlg_payments2.setLayout(new BorderLayout());
        dlg_payments2.getStyle().setBgColor(0xeee);
        
        Label lbl_step2 = new Label("Step 2/3");
        lbl_step2.getStyle().setBgColor(0xffffff);
        lbl_step2.getStyle().setFgColor(0x000000);
        lbl_step2.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_LARGE));
                
        Label lbl_step2_desc = new Label("Collection Details:"); //Tithes & Offerings:
        lbl_step2_desc.getStyle().setBgColor(0xffffff);
        lbl_step2_desc.getStyle().setFgColor(0x888);
        lbl_step2_desc.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        
                
        btn_closePayDlg = new Button(theme.getImage("cancel.png")); //ifont_close
        btn_closePayDlg.setUIID("Label");
        btn_closePayDlg.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("Close[x]icon pressed 2.");
                
                bool_no_new_items = Storage.getInstance().exists("no_new_items");
                if(bool_no_new_items == true)
                {
                    System.out.println("Deleting temporary form data");
                
                    
                    
                    Storage.getInstance().deleteStorageFile("trx_number");
                    Storage.getInstance().deleteStorageFile("mem_number");
                    Storage.getInstance().deleteStorageFile("first_name");
                    Storage.getInstance().deleteStorageFile("last_name");
                    Storage.getInstance().deleteStorageFile("phone_number");
                    Storage.getInstance().deleteStorageFile("email_address");
                    Storage.getInstance().deleteStorageFile("tithev");
                    Storage.getInstance().deleteStorageFile("offeringv");
                    Storage.getInstance().deleteStorageFile("buildingv");
                    Storage.getInstance().deleteStorageFile("budgetv");
                    
                    
                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                    int_no_new_items = Integer.parseInt(str_no_new_items);

                    for(k=0; k < int_no_new_items; k++)
                    {
                        System.out.println("Deleting new_item "+k);
                        Storage.getInstance().deleteStorageFile("new_item_"+k);
                        Storage.getInstance().deleteStorageFile("new_itemv_"+k);
                    }
                    Storage.getInstance().deleteStorageFile("no_new_items");
                    
                    
                    
                    Storage.getInstance().deleteStorageFile("payprovider");
                    Storage.getInstance().deleteStorageFile("pay_instructions");
                    Storage.getInstance().deleteStorageFile("totals");
                }
                else
                {
                }
                
                bool_no_main_items = Storage.getInstance().exists("no_main_items");
                if(bool_no_main_items == true)
                {
                    System.out.println("Deleting temporary form main_item");
                
                    str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                    int_no_main_items = Integer.parseInt(str_no_main_items);
                    
                    Storage.getInstance().deleteStorageFile("tithev");
                    Storage.getInstance().deleteStorageFile("offeringv");
                    Storage.getInstance().deleteStorageFile("buildingv");
                    Storage.getInstance().deleteStorageFile("budgetv");
                    
                    
                    Storage.getInstance().deleteStorageFile("buildingv_roof");
                    Storage.getInstance().deleteStorageFile("buildingv_premix");
                    Storage.getInstance().deleteStorageFile("buildingv_wall");
                    Storage.getInstance().deleteStorageFile("buildingv_elec");
                    Storage.getInstance().deleteStorageFile("buildingv_plumb");
                    Storage.getInstance().deleteStorageFile("buildingv_pulpit");
                    Storage.getInstance().deleteStorageFile("buildingv_window");
                    Storage.getInstance().deleteStorageFile("buildingv_items");
                    
                    for(k=0; k < int_no_main_items+2; k++) //k=0; k < int_no_main_item+1; k++
                    {
                        System.out.println("Deleting main_item "+k);
                        Storage.getInstance().deleteStorageFile("main_item_"+k);
                        Storage.getInstance().deleteStorageFile("main_itemv_"+k);
                    }
                    Storage.getInstance().deleteStorageFile("no_main_items");
                    Storage.getInstance().deleteStorageFile("main_item");
                }
                else
                {
                }
                
                System.out.println("Closing payment popup dialog 2.");
                dlg_payments2.dispose();
            }
        });
        
        btn_minimise = new Button(theme.getImage("minimise.png")); //ifont_close
        btn_minimise.setUIID("Label");
        btn_minimise.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //CLose dialog
                dlg_payments2.dispose();
                //Do not delete temporary form details
            }
        });
        
        Container cnt_dlgCMDs = new Container(new BorderLayout());
        cnt_dlgCMDs.getStyle().setBgColor(0xffffff);
        cnt_dlgCMDs.getStyle().setBgTransparency(255);
        cnt_dlgCMDs.add(BorderLayout.WEST, btn_minimise);
        cnt_dlgCMDs.add(BorderLayout.EAST, btn_closePayDlg);
        
        Container cnt_dlgHeader = new Container(new BorderLayout());
        cnt_dlgHeader.getStyle().setBgColor(0xffffff);
        cnt_dlgHeader.getStyle().setBgTransparency(255);
        cnt_dlgHeader.add(BorderLayout.WEST, BoxLayout.encloseY(lbl_step2, lbl_step2_desc));
        cnt_dlgHeader.add(BorderLayout.EAST, FontImage.createMaterial(FontImage.MATERIAL_ADD_SHOPPING_CART, sty_icon_dlgPay, 8));
        
       
        
        
        Style sty_usn_icon = new Style(); 
        sty_usn_icon.setBorder(null, false);
        sty_usn_icon.setBgTransparency(255, false);
        sty_usn_icon.setFgColor(0xffffff, false);
        sty_usn_icon.setBgColor(0x006064, false);
        
        cnt_items = new Container();
        cnt_items.getAllStyles().setBorder(Border.createEmpty());
        cnt_items.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        cnt_items.getAllStyles().setBgTransparency(255);
        cnt_items.getAllStyles().setBgColor(0x006064);
        cnt_items.getAllStyles().setBorder(null);
        //cnt_dlgBody.add(BorderLayout.WEST, BoxLayout.encloseY(lbl_step1, lbl_step1_desc));
        //cnt_dlgBody.add(BorderLayout.EAST, FontImage.createMaterial(FontImage.MATERIAL_PERSON, sty_icon_dlgPay, 8));
        
        
        addItems();
        
        
        
        //TODO: Modify this and instead just read and equate to 0 instead of writting to storage.
        bool_no_total_items = Storage.getInstance().exists("no_total_items");
        if(bool_no_total_items == true)
        {
            str_no_total_items = Storage.getInstance().readObject("no_total_items").toString();
            int_no_total_items = Integer.parseInt(str_no_total_items);

            if(int_no_total_items >= 1)
            {
            }
            else
            {
                Storage.getInstance().writeObject("no_total_items", "0");
            }
        }
        else
        {
            Storage.getInstance().writeObject("no_total_items", "0");
        }
        
        int_rows_items = 4; //Integer.parseInt(Storage.getInstance().readObject("no_total_items").toString());
        int_no_total_items = 4;
        GridLayout laygrid_items = new GridLayout(int_no_total_items, 2);
        //laygrid_items.setAutoFit(true);
        cnt_items.setLayout(laygrid_items);
        //cnt_items.setScrollableY(true);
        
        Label lbl_add = new Label(theme.getImage("add.png"));
        lbl_add.getAllStyles().setAlignment(LEFT);
        lbl_add.addPointerPressedListener(new ActionListener() 
        {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    Log.p("Add item label pressed, going to ddNewItem().", 1);
                    AddNewItem();                   
                }
        });
        
        Button btn_back2 = new Button("Back");
        btn_back2.getUnselectedStyle().setBgColor(0x448d21); //0x448d21 - frog green //0x19B9E7 - light bluish   //0x35E041 - light green
        btn_back2.getUnselectedStyle().setBgTransparency(255);
        btn_back2.getUnselectedStyle().setBorder(null);
        btn_back2.getSelectedStyle().setBorder(null);
        btn_back2.getStyle().setFgColor(0xffffff);
        btn_back2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_payments2.dispose();
                showPayDialog1();
            }
        });
        
        Button btn_next2 = new Button("Next");
        btn_next2.getUnselectedStyle().setBgColor(0x448d21); //0x448d21 - frog green //0x19B9E7 - light bluish   //0x35E041 - light green
        btn_next2.getUnselectedStyle().setBgTransparency(255);
        btn_next2.getUnselectedStyle().setBorder(null);
        btn_next2.getSelectedStyle().setBorder(null);
        btn_next2.getStyle().setFgColor(0xffffff);
        btn_next2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //TODO: check amounts for commas and strip them off before validating
                //TODO: validate values for numericity e.g. letters or other characters
                
                    bool_no_main_items = Storage.getInstance().exists("no_main_items");
                    if(bool_no_main_items == true)
                    {
                        str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                        int_no_main_items = Integer.parseInt(str_no_main_items);
                        
                        System.out.println("No of Main items: "+str_no_main_items);
                        
                        for(i=0; i < int_no_main_items+2; i++) //i=0; i < int_no_main_item; i++
                        {
                            //Storage.getInstance().writeObject("main_item_"+lbl_remove_main_item.getName(), txtac_main_item[Integer.parseInt(lbl_remove_main_item.getName())].getText().trim());
                            if(txtf_main_itemv[i].getText().trim().equals("") || txtf_main_itemv[i].getText().trim().equals("0"))
                            {
                                System.out.println("Writing main_item_"+i+" "+txtac_main_item[i].getText().trim()+" = 0");
                                Storage.getInstance().writeObject("main_item_"+i, txtac_main_item[i].getText().trim());
                                Storage.getInstance().writeObject("main_itemv_"+i, "0");
                            }
                            else
                            {
                                System.out.println("Writing main_item_"+i+" "+txtac_main_item[i].getText().trim()+" = "+txtf_main_itemv[i].getText().trim());
                                Storage.getInstance().writeObject("main_item_"+i, txtac_main_item[i].getText().trim());
                                Storage.getInstance().writeObject("main_itemv_"+i, txtf_main_itemv[i].getText().trim());
                            }
                        }
                        
                        bool_payment_method = Storage.getInstance().exists("paymethod");
                        if(bool_payment_method == true)
                        {
                            
                        }
                        else
                        {
                            Storage.getInstance().writeObject("paymethod", " -------");
                        }
                        
                            
                        
                        bool_no_new_items = Storage.getInstance().exists("no_new_items");
                        if(bool_no_new_items == true)
                        {
                            str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                            int_no_new_items = Integer.parseInt(str_no_new_items);
                            System.out.println("No of New items: "+str_no_new_items); //int_no_items+int_no_main_item

                            if(int_no_new_items > 0)
                            {
                                for(k=0; k < int_no_new_items; k++)
                                {
                                    if(txtac_new_item[k].getText().trim().equals(""))
                                    {
                                        Connect.okayDialog("Oops!", "You must enter a text for "+txtac_new_item[k].getHint()+".");
                                        break;
                                    }
                                    else if(txtf_new_itemv[k].getText().trim().equals(""))
                                    {
                                        Connect.okayDialog("Oops!", "You must enter a value for "+txtac_new_item[k].getText().trim()+".");
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println(k+" Writing the added items to storage: "+txtac_new_item[k].getText().trim()+" "+txtf_new_itemv[k].getText().trim());
                                        //str_item = Storage.getInstance().readObject("new_item_"+i).toString();
                                        Storage.getInstance().writeObject("new_item_"+k, txtac_new_item[k].getText().trim());
                                        Storage.getInstance().writeObject("new_itemv_"+k, txtf_new_itemv[k].getText().trim());
                                    }


                                    if(k+1 == int_no_new_items)
                                    {
                                        bool_totals = Storage.getInstance().exists("totals");
                                        if(bool_totals == true)
                                        {
                                            str_totals = Storage.getInstance().readObject("totals").toString();
                                            int_totals = Integer.parseInt(str_totals);
                                            if(int_totals > 0)
                                            {
                                                //Storage.getInstance().writeObject("paymethod", "mobile");
                                                dlg_payments2.dispose();
                                                showPayDialog3();
                                            }
                                            else
                                            {
                                                Connect.okayDialog("Oops!\n: ", "Please enter a value to proceed.");
                                            }
                                        }
                                        else
                                        {
                                            Connect.okayDialog("Oops!\n: ", "Please enter a value to proceed.");
                                        }
                                    }
                                }
                            }
                            else
                            {
                                bool_totals = Storage.getInstance().exists("totals");
                                if(bool_totals == true)
                                {
                                    str_totals = Storage.getInstance().readObject("totals").toString();
                                    int_totals = Integer.parseInt(str_totals);
                                    if(int_totals > 0)
                                    {
                                        //Storage.getInstance().writeObject("paymethod", "mobile");
                                        dlg_payments2.dispose();
                                        showPayDialog3();
                                    }
                                    else
                                    {
                                        Connect.okayDialog("Oops!\n: ", "Please enter a value to proceed.");
                                    }
                                }
                                else
                                {
                                    Connect.okayDialog("Oops!\n: ", "Please enter a value to proceed.");
                                }
                            }
                        }
                        else
                        {
                            bool_totals = Storage.getInstance().exists("totals");
                            if(bool_totals == true)
                            {
                                str_totals = Storage.getInstance().readObject("totals").toString();
                                int_totals = Integer.parseInt(str_totals);
                                if(int_totals > 0)
                                {
                                    //Storage.getInstance().writeObject("paymethod", "mobile");
                                    dlg_payments2.dispose();
                                    showPayDialog3();
                                }
                                else
                                {
                                    Connect.okayDialog("Oops!\n: ", "Please enter a value to proceed.");
                                }
                            }
                            else
                            {
                                Connect.okayDialog("Oops!\n: ", "Please enter a value to proceed.");
                            }
                        }
                    }
            }
        });
        
        Container cnt_dlgFoot = new Container(new BorderLayout());
        cnt_dlgFoot.add(BorderLayout.WEST, btn_back2);
        cnt_dlgFoot.add(BorderLayout.EAST, btn_next2);
        
        bool_totals = Storage.getInstance().exists("totals");
        if(bool_totals == true)
        {
            str_totals = Storage.getInstance().readObject("totals").toString();
        }
        else
        {
            str_totals = "0";
        }
        
        //TODO: Remove the two below and use int_no_total_items instead.
        str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
        int_no_main_items = Integer.parseInt(str_no_main_items);
        
        str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
        int_no_new_items = Integer.parseInt(str_no_new_items);
        
        lbl_items = new Label();
        lbl_items.setText("(Items: "+((int_no_main_items+1)+int_no_new_items)+")");
        
        Storage.getInstance().writeObject("no_itemsel", int_no_main_items+int_no_new_items);
                
        lbl_totals = new Label();
        lbl_totals.setText(StringUtil.replaceAll(l10n.formatCurrency(l10n.parseCurrency(str_totals)), "KES", "   -   Kshs. "));
        
        
        
        lbl_clear2 = new Label();
        lbl_clear2.setIcon(theme.getImage("trash.png"));
        lbl_clear2.setText("clear form");
        lbl_clear2.setTextPosition(BOTTOM);
        lbl_clear2.getAllStyles().setFont(font_small_bold);
        lbl_clear2.getAllStyles().setFgColor(0xffffff);
        lbl_clear2.getAllStyles().setAlignment(CENTER);
        
        
        
        
        
        Container cnt_dlgBody = new Container(new BorderLayout());
        cnt_dlgBody.getAllStyles().setBorder(Border.createEmpty());
        cnt_dlgBody.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        cnt_dlgBody.getUnselectedStyle().setBgTransparency(255, false);
        cnt_dlgBody.getUnselectedStyle().setBgColor(0x006064, false);
        cnt_dlgBody.getAllStyles().setBgTransparency(255);
        cnt_dlgBody.getAllStyles().setBgColor(0x006064);
        cnt_dlgBody.getAllStyles().setBorder(null);
        cnt_dlgBody.add(BorderLayout.NORTH, cnt_items);
        cnt_dlgBody.add(BorderLayout.SOUTH, BorderLayout.centerEastWest(null, lbl_clear2, BoxLayout.encloseXNoGrow(lbl_add, lbl_items, lbl_totals))); //(lbl_add, new Label("(Items: "+(int_no_items+4)+")   -   Kshs. "+str_totals))
        
        dlg_payments2.add(BorderLayout.NORTH, BoxLayout.encloseY(cnt_dlgCMDs, cnt_dlgHeader)); //cnt_dlgCMDs
        dlg_payments2.add(BorderLayout.CENTER, cnt_dlgBody); //cnt_items //lbl_add
        dlg_payments2.add(BorderLayout.SOUTH, cnt_dlgFoot);
                
        //dlg_payments2.showAtPosition(displayHeight/8, displayHeight/8, displayWidth/8, displayWidth/8, false);
        try 
        {
            dlg_payments2.showPacked(BorderLayout.CENTER, true);
        } 
        catch (Exception ex) 
        {
            //ex.printStackTrace();
            System.err.println("Error: "+ex);
        }
        //catch (NullPointerException np) 
        //{
        //    np.printStackTrace();
        //}
        
        //dlg_payments1.showPacked(BorderLayout.CENTER, true);
        //dlg_payments2.setDisposeWhenPointerOutOfBounds(true);
    }
    
    public void showPayDialog3()
    {
        dlg_payments3 = new Dialog();
        dlg_payments3.setLayout(new BorderLayout());
        dlg_payments3.getStyle().setBgColor(0xeee);
        dlg_payments3.getAllStyles().setPadding(15, 15, 15, 15);
        
        Label lbl_step2 = new Label("Step 3/3");
        lbl_step2.getStyle().setBgColor(0xffffff);
        lbl_step2.getStyle().setFgColor(0x000000);
        lbl_step2.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_LARGE));
                
        Label lbl_step2_desc = new Label("Choose Payment Option:");
        lbl_step2_desc.getStyle().setBgColor(0xffffff);
        lbl_step2_desc.getStyle().setFgColor(0x888);
        lbl_step2_desc.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
        
                
        btn_closePayDlg = new Button(theme.getImage("cancel.png")); //ifont_close
        btn_closePayDlg.setUIID("Label");
        btn_closePayDlg.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("Close[x]icon pressed 3.");
                
                bool_no_new_items = Storage.getInstance().exists("no_new_items");
                if(bool_no_new_items == true)
                {
                    System.out.println("Deleting temporary form data");
                
                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                    int_no_new_items = Integer.parseInt(str_no_new_items);
                    
                    Storage.getInstance().deleteStorageFile("trx_number");
                    Storage.getInstance().deleteStorageFile("mem_number");
                    Storage.getInstance().deleteStorageFile("first_name");
                    Storage.getInstance().deleteStorageFile("last_name");
                    Storage.getInstance().deleteStorageFile("phone_number");
                    Storage.getInstance().deleteStorageFile("email_address");
                    Storage.getInstance().deleteStorageFile("tithev");
                    Storage.getInstance().deleteStorageFile("offeringv");
                    Storage.getInstance().deleteStorageFile("buildingv");
                    Storage.getInstance().deleteStorageFile("budgetv");
                    
                    Storage.getInstance().deleteStorageFile("buildingv_roof");
                    Storage.getInstance().deleteStorageFile("buildingv_premix");
                    Storage.getInstance().deleteStorageFile("buildingv_wall");
                    Storage.getInstance().deleteStorageFile("buildingv_elec");
                    Storage.getInstance().deleteStorageFile("buildingv_plumb");
                    Storage.getInstance().deleteStorageFile("buildingv_pulpit");
                    Storage.getInstance().deleteStorageFile("buildingv_window");

                    for(k=0; k < int_no_new_items; k++)
                    {
                        Storage.getInstance().deleteStorageFile("new_item_"+k);
                        Storage.getInstance().deleteStorageFile("new_itemv_"+k);
                    }
                    
                    Storage.getInstance().deleteStorageFile("no_new_items");
                    Storage.getInstance().deleteStorageFile("payprovider");
                    Storage.getInstance().deleteStorageFile("pay_instructions");
                    Storage.getInstance().deleteStorageFile("totals");
                }
                else
                {
                }
                
                bool_no_main_items = Storage.getInstance().exists("no_main_items");
                if(bool_no_main_items == true)
                {
                    System.out.println("Deleting temporary form main_item");
                
                    str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                    int_no_main_items = Integer.parseInt(str_no_main_items);
                    
                    Storage.getInstance().deleteStorageFile("tithev");
                    Storage.getInstance().deleteStorageFile("offeringv");
                    Storage.getInstance().deleteStorageFile("buildingv");
                    Storage.getInstance().deleteStorageFile("budgetv");
                    
                    Storage.getInstance().deleteStorageFile("buildingv_roof");
                    Storage.getInstance().deleteStorageFile("buildingv_premix");
                    Storage.getInstance().deleteStorageFile("buildingv_wall");
                    Storage.getInstance().deleteStorageFile("buildingv_elec");
                    Storage.getInstance().deleteStorageFile("buildingv_plumb");
                    Storage.getInstance().deleteStorageFile("buildingv_pulpit");
                    Storage.getInstance().deleteStorageFile("buildingv_window");

                    for(k=1; k < int_no_main_items+1; k++)
                    {
                        System.out.println("Deleting main_item "+k);
                        Storage.getInstance().deleteStorageFile("main_item_"+k);
                        Storage.getInstance().deleteStorageFile("main_itemv_"+k);
                    }
                    Storage.getInstance().deleteStorageFile("no_main_items");
                    Storage.getInstance().deleteStorageFile("main_item");
                }
                else
                {
                }
                
                System.out.println("Closing payment popup dialog 3.");
                dlg_payments3.dispose();
            }
        });
        
        btn_minimise = new Button(theme.getImage("minimise.png")); //ifont_close
        btn_minimise.setUIID("Label");
        btn_minimise.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                System.out.println("Close Pay Dialog button pressed.");
                //CLose dialog
                dlg_payments3.dispose();
                //Delete temporary form details
            }
        });
        
        Container cnt_dlgCMDs = new Container(new BorderLayout());
        cnt_dlgCMDs.setName("cnt_dlgCMDs");
        cnt_dlgCMDs.getStyle().setBgColor(0xffffff);
        cnt_dlgCMDs.getStyle().setBgTransparency(255);
        cnt_dlgCMDs.add(BorderLayout.WEST, btn_minimise);
        cnt_dlgCMDs.add(BorderLayout.EAST, btn_closePayDlg);
        
        Container cnt_dlgHeader = new Container(new BorderLayout());
        cnt_dlgHeader.setName("cnt_dlgHeader");
        cnt_dlgHeader.getStyle().setBgColor(0xffffff);
        cnt_dlgHeader.getStyle().setBgTransparency(255);
        cnt_dlgHeader.add(BorderLayout.WEST, BoxLayout.encloseY(lbl_step2, lbl_step2_desc));
        cnt_dlgHeader.add(BorderLayout.EAST, FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_BALANCE_WALLET, sty_icon_dlgPay, 8));
        
        
        GridLayout laygrid_details = new GridLayout(1, 1);
        laygrid_details.setAutoFit(true);
        
        TableLayout laytab_details = new TableLayout(1, 1);
        laytab_details.setGrowHorizontally(true);
        
        cnt_details = new Container();
        cnt_details.setLayout(new BoxLayout(BoxLayout.Y_AXIS)); //new TableLayout(1, 1) //laygrid_items
        cnt_details.getAllStyles().setBorder(Border.createEmpty());
        cnt_details.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        cnt_details.getAllStyles().setBgTransparency(0);
        cnt_details.getAllStyles().setBgColor(0x006064);
        cnt_details.getAllStyles().setBorder(null);
       
        lbl_envelope_ttl = new Label();
        lbl_envelope_ttl.setText("Envelope Total:");
        lbl_envelope_ttl.setName("lbl_envelope_ttl");
        lbl_envelope_ttl.getAllStyles().setAlignment(LEFT);
        lbl_envelope_ttl.getAllStyles().setFgColor(0x000000, false);
        lbl_envelope_ttl.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_envelope_ttl.getAllStyles().setPadding(0, 0, 0, 0);
        //lbl_envelope_ttl.getAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        
        
        lbl_envelope_ttl_val = new Label();
        lbl_envelope_ttl_val.setText("");
        lbl_envelope_ttl_val.setName("lbl_envelope_ttl_val");
        lbl_envelope_ttl_val.getAllStyles().setAlignment(LEFT);
        lbl_envelope_ttl_val.getAllStyles().setFgColor(0x000000, false);
        lbl_envelope_ttl_val.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_envelope_ttl_val.getAllStyles().setPadding(0, 0, 0, 0);
        //lbl_envelope_ttl_val.getAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        
        
        
        lbl_payoption = new Label();
        lbl_payoption.setText("Payment Option:");
        lbl_payoption.setName("lbl_payoption");
        lbl_payoption.getAllStyles().setAlignment(LEFT);
        lbl_payoption.getAllStyles().setFgColor(0x000000, false);
        lbl_payoption.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_payoption.getAllStyles().setPadding(0, 0, 0, 0);
        //lbl_payoption.getAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        
        
        lbl_payoption_val = new Label();
        lbl_payoption_val.setText("");
        lbl_payoption_val.setName("lbl_payoption_val");
        lbl_payoption_val.getAllStyles().setAlignment(LEFT);
        lbl_payoption_val.getAllStyles().setFgColor(0x000000, false);
        lbl_payoption_val.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_payoption_val.getAllStyles().setPadding(0, 0, 0, 0);
        //lbl_payoption_val.getAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        
        
        
        lbl_smsto = new Label();
        lbl_smsto.setText("SMS Recepient(s):");
        lbl_smsto.setName("lbl_smsto");
        lbl_smsto.getAllStyles().setAlignment(LEFT);
        lbl_smsto.getAllStyles().setFgColor(0x000000, false);
        lbl_smsto.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_smsto.getAllStyles().setPadding(0, 0, 0, 0);
        //lbl_smsto.getAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        
        
        lbl_smsto_val = new Label();
        lbl_smsto_val.setText("");
        lbl_smsto_val.setName("lbl_smsto_val");
        lbl_smsto_val.getAllStyles().setAlignment(LEFT);
        lbl_smsto_val.getAllStyles().setFgColor(0x000000, false);
        lbl_smsto_val.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_smsto_val.getAllStyles().setPadding(0, 0, 0, 0);
        //lbl_smsto_val.getAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        
        
        
        
        lbl_refno = new Label();
        lbl_refno.setText("Referece No.:");
        lbl_refno.setName("lbl_refno");
        lbl_refno.getAllStyles().setAlignment(LEFT);
        lbl_refno.getAllStyles().setFgColor(0x000000, false);
        lbl_refno.getAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        lbl_refno.getStyle().setPadding(0, 0, 0, 0);
        lbl_refno.getStyle().setMargin(0, (int) (1.8 * pixelsPerMM), 0,  0);
        
        lbl_refno_val = new Label();
        lbl_refno_val.setText("");
        lbl_refno_val.setName("lbl_refno_val");
        lbl_refno_val.getAllStyles().setAlignment(LEFT);
        lbl_refno_val.getAllStyles().setFgColor(0x000000, false);
        lbl_refno_val.getAllStyles().setMargin(0, 0, 0, 0);
        lbl_refno_val.getAllStyles().setPadding(0, 0, 0, 0);
        //lbl_refno_val.getAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        
        
        
        
        spnlbl_description = new SpanLabel();
        spnlbl_description.setName("Payment Descriptions");
        spnlbl_description.getTextAllStyles().setAlignment(LEFT);
        spnlbl_description.getTextAllStyles().setFgColor(0x000000, false);
        spnlbl_description.getTextAllStyles().setMargin(0, 0, 0, 0);
        spnlbl_description.getTextAllStyles().setPadding(0, 0, 0, 0);
        spnlbl_description.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        spnlbl_description.getStyle().setPadding(0, 0, 0, 0);
        spnlbl_description.getStyle().setMargin(0, 20, 0, 0);
        
        spnlbl_description1 = new SpanLabel();
        spnlbl_description1.setName("Payment Descriptions 1");
        spnlbl_description1.getTextAllStyles().setAlignment(LEFT);
        spnlbl_description1.getTextAllStyles().setFgColor(0x000000, false);
        spnlbl_description1.getTextAllStyles().setMargin(0, 0, 0, 0);
        spnlbl_description1.getTextAllStyles().setPadding(0, 0, 0, 0);
        spnlbl_description1.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        spnlbl_description1.getStyle().setPadding(0, 0, 0, 0);
        spnlbl_description1.getStyle().setMargin(0, 20, 0, 0);
        //cnt_details.add(spnlbl_description);
        
        
        spnlbl_description2 = new SpanLabel();
        spnlbl_description2.setName("Payment Descriptions 2");
        spnlbl_description2.getTextAllStyles().setAlignment(LEFT);
        spnlbl_description2.getTextAllStyles().setFgColor(0x000000, false);
        spnlbl_description2.getTextAllStyles().setMargin(0, 0, 0, 0);
        spnlbl_description2.getTextAllStyles().setPadding(0, 0, 0, 0);
        spnlbl_description2.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        spnlbl_description2.getStyle().setPadding(0, 0, 0, 0);
        spnlbl_description2.getStyle().setMargin(0, 20, 0, 0);
        
        
        spnlbl_description3 = new SpanLabel();
        spnlbl_description3.setName("Payment Descriptions 3");
        spnlbl_description3.getTextAllStyles().setAlignment(LEFT);
        spnlbl_description3.getTextAllStyles().setFgColor(0x000000, false);
        spnlbl_description3.getTextAllStyles().setMargin(0, 0, 0, 0);
        spnlbl_description3.getTextAllStyles().setPadding(0, 0, 0, 0);
        spnlbl_description3.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        spnlbl_description3.getStyle().setPadding(0, 0, 0, 0);
        spnlbl_description3.getStyle().setMargin(0, 20, 0, 0);
        
        
        spnlbl_description4 = new SpanLabel();
        spnlbl_description4.setName("Payment Descriptions 4");
        spnlbl_description4.getTextAllStyles().setAlignment(LEFT);
        spnlbl_description4.getTextAllStyles().setFgColor(0x000000, false);
        spnlbl_description4.getTextAllStyles().setMargin(0, 0, 0, 0);
        spnlbl_description4.getTextAllStyles().setPadding(0, 0, 0, 0);
        spnlbl_description4.getTextAllStyles().setPaddingUnit(new byte[]{Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS});
        spnlbl_description4.getStyle().setPadding(0, 0, 0, 0);
        spnlbl_description4.getStyle().setMargin(0, 20, 0, 0);

        //Storage.getInstance().clearCache();
        //str_payinstructions = Storage.getInstance().readObject("pay_instructions").toString();
        //spnlbl_description.setText(str_payinstructions);
                
        /*bool_pay_instructions = Storage.getInstance().exists("pay_instructions");
        if(bool_pay_instructions == true)
        {
            str_payinstructions1 = Storage.getInstance().readObject("pay_instructions").toString(); //.replace('\n', ' ')
            spnlbl_description.setText(str_payinstructions1);
        }
        else
        {
            spnlbl_description.setText(str_payinstructions1+str_payinstructions2+str_payinstructions3);
        }*/
        
        showInvoice();
        
        
        TableLayout laytab = new TableLayout(1, 10);
        cnt_payment_methods = new Container(new GridLayout(1, 6)); //new BoxLayout(BoxLayout.X_AXIS) //new FlowLayout(CENTER, CENTER) //new GridLayout(1, 7)
        cnt_payment_methods.getAllStyles().setAlignment(CENTER, false);
        //cnt_payment_methods.setLayout(laytab);
        cnt_payment_methods.setScrollableX(true);
        cnt_payment_methods.setName("cnt_payment_methods");
        //cnt_pay_providers.getStyle().setBgImage(img_background);
        
        cnt_payment_providers = new Container(new BoxLayout(BoxLayout.X_AXIS)); //new BoxLayout(BoxLayout.X_AXIS) //new FlowLayout(CENTER, CENTER) //new GridLayout(1, 5)
        cnt_payment_providers.getAllStyles().setAlignment(CENTER, false);
        cnt_payment_providers.setName("Payment Options");
        cnt_payment_providers.setScrollableX(true);
        
        
        
        
        ///////////////////////////////////////////////////////////////////////////////////
        
        //str_tithev, str_offeringv, str_buildingv, str_budgetv, str_item, str_itemv
        bool_tithev   = Storage.getInstance().exists("tithev");
        bool_offeringv= Storage.getInstance().exists("offeringv");
        bool_buildingv= Storage.getInstance().exists("buildingv");
        bool_budgetv  = Storage.getInstance().exists("budgetv");
        if(bool_tithev == true)
        {
            str_tithev = Storage.getInstance().readObject("tithev").toString();
        }
        else
        {
            str_tithev = "0";
        }
        
        if(bool_offeringv == true)
        {
            str_offeringv = Storage.getInstance().readObject("offeringv").toString();
        }
        else
        {
            str_offeringv = "0";
        }
        
        if(bool_buildingv == true)
        {
            str_buildingv = Storage.getInstance().readObject("buildingv").toString();
        }
        else
        {
            str_buildingv = "0";
        }
        
        if(bool_budgetv == true)
        {
           str_budgetv   = Storage.getInstance().readObject("budgetv").toString();
        }
        else
        {
            str_budgetv = "0";
        }
        
        str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
        int_no_new_items = Integer.parseInt(str_no_new_items);
        
        //for(k=0; k < int_no_items; k++){}
        //int_subtotals = Integer.parseInt(str_tithev)+Integer.parseInt(str_offeringv)+Integer.parseInt(str_buildingv)+Integer.parseInt(str_budgetv);
        
        Button btn_add_photo = new Button();
        btn_add_photo.setText("Add Photo");
        btn_add_photo.setTextPosition(BOTTOM);
        btn_add_photo.addActionListener(new ActionListener() 
        {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
              ////doFileUploadDemo();
              //doPic();
              int width = Display.getInstance().getDisplayWidth();
              String str_imgpath = Capture.capturePhoto(width, -1);
              Storage.getInstance().writeObject("image_path", str_imgpath);

              if(str_imgpath == null){}

                  try 
                  {
                      InputStream in = FileSystemStorage.getInstance().openInputStream(str_imgpath);
                      OutputStream out = Storage.getInstance().createOutputStream("MyImage.png"); //String photoName = "" + System.currentTimeMillis();
                      Util.copy(in, out);
                      Util.cleanup(in);
                      Util.cleanup(out);

                      InputStream is = Storage.getInstance().createInputStream("MyImage.png");
                      Image img_ballotPaper = EncodedImage.createImage(is).scaledHeight(int_dispW/2);
                      //btn_add_photo.setIcon(img_ballotPaper.scaledWidth(displayWidth/4));
                      //btn_add_photo.remove();

//                      Image img = Image.createImage(img_ballotPaper).fill(circleMaskImage.getWidth(), circleMaskImage.getHeight());
//                      lbl_pic.setIcon(img.applyMask(circleMask));
                  } 
                  catch (Exception e) 
                  {
                      System.out.println("Error: "+e);
                      //e.printStackTrace();
                  }
          }
       });


        Button btn_view_photo = new Button("View Photo");
        btn_view_photo.addActionListener(new ActionListener() 
        {
             @Override
             public void actionPerformed(ActionEvent evt)
             {
                   Dialog dlg_pic = new Dialog("Captured Results Photo");
                   dlg_pic.setLayout(new BorderLayout());

                   Label lbl_photo = new Label();


                   Button btn_funga = new Button("Close");
                   btn_funga.addActionListener(new ActionListener() 
                   {
                       @Override
                       public void actionPerformed(ActionEvent evt) 
                       {
                           dlg_pic.dispose();
                       }
                   });

                   dlg_pic.add(BorderLayout.CENTER, FlowLayout.encloseCenterMiddle(lbl_photo));
                   dlg_pic.add(BorderLayout.SOUTH, btn_funga);

                   try
                   {
                       InputStream is = Storage.getInstance().createInputStream("MyImage.png");
                       Image img_ballotPaper = EncodedImage.createImage(is).scaledHeight(int_dispW/2);
                       //btn_add_photo.setIcon(img_ballotPaper.scaledWidth(displayWidth/4));
                       lbl_photo.setIcon(img_ballotPaper);
                       dlg_pic.show();
                   } 
                   catch (Exception e) 
                   {
                       String str_errorType = StringUtil.tokenize(e.toString(), ":").get(0);
                       if(str_errorType.equals("java.io.FileNotFoundException"))
                       {
                           Dialog.show("Error Occured!", "You have not added a picture yet.", "Ok", null);
                       }
                       else
                       {
                           Dialog.show("Error Occured!", ">> "+e, "Ok", null);
                           System.out.println(">>"+e); //java.io.FileNotFoundException: C:\Users\Tommy Mogaka\.cn1\MyImage.png (The system cannot find the file specified)
                       }
                   }
             }
         });

        Container cnt_cmds_pic = new Container(new BorderLayout());
        cnt_cmds_pic.add(BorderLayout.WEST, btn_add_photo);
        cnt_cmds_pic.add(BorderLayout.EAST, btn_view_photo);
       
        /*boolean bool_paymethod = Storage.getInstance().exists("paymethod");
        if(bool_paymethod == true)
        {
            str_paymethod = Storage.getInstance().readObject("paymethod").toString();
            if(str_paymethod.equals("direct"))
            {
                btn_add_photo.setText("Add Slip");
                btn_view_photo.setText("View Slip");
                cnt_cmds_pic.setVisible(true);
            }
            else
            {
                btn_add_photo.setText("Add Cheque");
                btn_view_photo.setText("View Cheque");
                cnt_cmds_pic.setVisible(true);    
            }
        }
        else
        {
            btn_add_photo.setText("Add Cheque");
            btn_view_photo.setText("View Cheque");
            cnt_cmds_pic.setVisible(true);
        }*/
        
      //private Button btn_0_5_minus;
      //private Label lbl_0_5;
      //private TextField txtf_0_5;
      //private Button btn_0_5_add;
    
      //lbl_0_5 = new Label("50cents");
      //lbl_0_5.setIcon(theme.getImage("1_shilling_coin_ke.png"));
      //lbl_0_5.getAllStyles().setFont(font_small_plain);
      //lbl_0_5.getAllStyles().setPadding(0, 0, 0, 0);
      //lbl_0_5.getAllStyles().setMargin(0, 0, 0, 0);
      
      //lbl_0_5_count = new Label("2 coins");
      //lbl_0_5_count.getStyle().setFont(font_small_plain);
      //lbl_0_5_count.getAllStyles().setPadding(0, 0, 0, 0);
      //lbl_0_5_count.getAllStyles().setMargin(0, 0, 0, 0);
      //
      //btn_0_5_add = new Button("+");
      //btn_0_5_add.getAllStyles().setPadding(0, 0, 0, 0);
      //btn_0_5_add.getAllStyles().setMargin(0, 0, 0, 0);
      
      //btn_0_5_minus = new Button("-");
      //btn_0_5_minus.getAllStyles().setPadding(0, 0, 0, 0);
      //btn_0_5_minus.getAllStyles().setMargin(0, 0, 0, 0);
      
      
      //txtf_0_5  = new TextField();
      //txtf_0_5.getAllStyles().setPadding(0, 0, 0, 0);
      //txtf_0_5.getAllStyles().setMargin(0, 0, 0, 0);
      //txtf_0_5.getAllStyles().setPadding(0, 0, 0, 0);
      //txtf_0_5.getAllStyles().setMargin(0, 0, 0, 0);
      //txtf_0_5 .setConstraint(TextField.NUMERIC);
      //txtf_0_5.setFocusable(true);
      //cont_0_5 = new Container(new BorderLayout());
      //cont_0_5.getAllStyles().setPadding(0, 0, 0, 0);
      //cont_0_5.getAllStyles().setMargin(0, 0, 0, 0);
      //cont_0_5.getAllStyles().setPadding(0, 0, 0, 0);
      //cont_0_5.getAllStyles().setMargin(0, 0, 0, 0);
      //cont_0_5.add(BorderLayout.NORTH, lbl_0_5_count);
      //cont_0_5.add(BorderLayout.CENTER, lbl_0_5);
      //cont_0_5.add(BorderLayout.SOUTH, txtf_0_5);
      //cont_0_5.add(BorderLayout.WEST, btn_0_5_minus);
      //cont_0_5.add(BorderLayout.EAST, btn_0_5_add);
      //cnt_payment_providers.addComponent(cont_0_5);
        
      
      //lbl_1 = new Label("1 shilling");
      //lbl_1.setIcon(theme.getImage("1_shilling_coin_ke.png"));
      //lbl_1.getStyle().setFont(font_small_plain);
      //lbl_1.getAllStyles().setPadding(0, 0, 0, 0);
      //lbl_1.getAllStyles().setMargin(0, 0, 0, 0);
      //lbl_1_count = new Label("5 coins");
      //lbl_1_count.getAllStyles().setFont(font_small_plain);
      //lbl_1_count.getAllStyles().setPadding(0, 0, 0, 0);
      //lbl_1_count.getAllStyles().setMargin(0, 0, 0, 0);
      //btn_1_add = new Button("+");
      //btn_1_add.getAllStyles().setPadding(0, 0, 0, 0);
      //btn_1_add.getAllStyles().setMargin(0, 0, 0, 0);
      //btn_1_minus = new Button("-");
      //btn_1_minus.getAllStyles().setPadding(0, 0, 0, 0);
      //btn_1_minus.getAllStyles().setMargin(0, 0, 0, 0);
      //txtf_1 = new TextField();
      //txtf_1.getAllStyles().setPadding(0, 0, 0, 0);
      //txtf_1.getAllStyles().setMargin(0, 0, 0, 0);
      //txtf_1.setConstraint(TextField.NUMERIC);
      //txtf_1.setFocusable(true);
      //cont_1 = new Container(new BorderLayout());
      //cont_1.getAllStyles().setPadding(0, 0, 0, 0);
      //cont_1.getAllStyles().setMargin(0, 0, 0, 0);
      //cont_1.add(BorderLayout.NORTH, lbl_1_count);
      //cont_1.add(BorderLayout.CENTER, lbl_1);
      //cont_1.add(BorderLayout.SOUTH, txtf_1);
      //cont_1.add(BorderLayout.WEST, btn_1_minus);
      //cont_1.add(BorderLayout.EAST, btn_1_add);
      //cnt_payment_providers.add(cont_1);
      
      //lbl_50 = new Label();
      //lbl_50.setText("50(2)");
      //lbl_50.setTextPosition(BOTTOM);
      //lbl_50.setIcon(theme.getImage("50_shillings_note_ke.png"));
      //lbl_50.getAllStyles().setFont(font_small_plain);
      //lbl_50.getAllStyles().setPadding(0, 0, 0, 0);
      //lbl_50.getAllStyles().setMargin(0, 0, 0, 0);
      //lbl_50_count = new Label();
      ////lbl_50_count.setText("2 notes");
      //lbl_50_count.getAllStyles().setFont(font_small_plain);
      //lbl_50_count.getAllStyles().setPadding(0, 0, 0, 0);
      //lbl_50_count.getAllStyles().setMargin(0, 0, 0, 0);
      //btn_50_add = new Button("+");
      //btn_50_add.getAllStyles().setPadding(0, 0, 0, 0);
      //btn_50_add.getAllStyles().setMargin(0, 0, 0, 0);
      //btn_50_minus = new Button("-");
      //btn_50_minus.getAllStyles().setPadding(0, 0, 0, 0);
      //btn_50_minus.getAllStyles().setMargin(0, 0, 0, 0);
      //txtf_50 = new TextField("100");
      //txtf_50.getAllStyles().setPadding(0, 0, 0, 0);
      //txtf_50.getAllStyles().setMargin(0, 0, 0, 0);
      //txtf_50.setConstraint(TextField.NUMERIC);
      //txtf_50.setFocusable(true);
      //cont_50 = new Container(new BorderLayout());
      //cont_50.getAllStyles().setPadding(0, 0, 0, 0);
      //cont_50.getAllStyles().setMargin(0, 0, 0, 0);
      //cont_50.add(BorderLayout.NORTH, lbl_50_count);
      //cont_50.add(BorderLayout.CENTER, lbl_50);
      //cont_50.add(BorderLayout.SOUTH, txtf_50);
      //cont_50.add(BorderLayout.WEST, btn_50_minus);
      //cont_50.add(BorderLayout.EAST, btn_50_add);
      //cnt_payment_providers.addComponent(lbl_50);
      
        btn_0_5 = new Button();
        btn_0_5.setIcon(theme.getImage("50_cents_coin_ke.png"));
        //btn_0_5.setText("0");
        btn_0_5.setTextPosition(BOTTOM);
        btn_0_5.getAllStyles().setFgColor(0x000000);
        btn_0_5.getAllStyles().setBgTransparency(0);
        btn_0_5.getAllStyles().setFont(font_small_plain);
        btn_0_5.getAllStyles().setPadding(0, 0, 0, 0);
        btn_0_5.getAllStyles().setMargin(0, 0, (int)(0.5 * pixelsPerMM), (int)(0.05 * pixelsPerMM));
        btn_0_5.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_1 = new Button();
        btn_1.setIcon(theme.getImage("1_shilling_coin_ke.png"));
        //btn_1.setText("0");
        btn_1.setTextPosition(BOTTOM);
        btn_1.getAllStyles().setFgColor(0x000000);
        btn_1.getAllStyles().setBgTransparency(0);
        btn_1.getAllStyles().setFont(font_small_plain);
        btn_1.getAllStyles().setPadding(0, 0, 0, 0);
        btn_1.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_1.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        btn_5 = new Button();
        btn_5.setIcon(theme.getImage("5_shillings_coin_ke.png"));
        //btn_5.setText("0");
        btn_5.setTextPosition(BOTTOM);
        btn_5.getAllStyles().setFgColor(0x000000);
        btn_5.getAllStyles().setBgTransparency(0);
        btn_5.getAllStyles().setFont(font_small_plain);
        btn_5.getAllStyles().setPadding(0, 0, 0, 0);
        btn_5.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_5.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_10 = new Button();
        btn_10.setIcon(theme.getImage("10_shillings_coin_ke.png"));
        //btn_10.setText("0");
        btn_10.setTextPosition(BOTTOM);
        btn_10.getAllStyles().setFgColor(0x000000);
        btn_10.getAllStyles().setBgTransparency(0);
        btn_10.getAllStyles().setFont(font_small_plain);
        btn_10.getAllStyles().setPadding(0, 0, 0, 0);
        btn_10.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_10.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        btn_20 = new Button();
        btn_20.setIcon(theme.getImage("20_shillings_coin_ke.png"));
        //btn_20.setText("0");
        btn_20.setTextPosition(BOTTOM);
        btn_20.getAllStyles().setFgColor(0x000000);
        btn_20.getAllStyles().setBgTransparency(0);
        btn_20.getAllStyles().setFont(font_small_plain);
        btn_20.getAllStyles().setPadding(0, 0, 0, 0);
        btn_20.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_20.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        btn_40 = new Button();
        btn_40.setIcon(theme.getImage("40_shillings_coin_ke.jpg"));
        //btn_40.setText("0");
        btn_40.setTextPosition(BOTTOM);
        btn_40.getAllStyles().setFgColor(0x000000);
        btn_40.getAllStyles().setBgTransparency(0);
        btn_40.getAllStyles().setFont(font_small_plain);
        btn_40.getAllStyles().setPadding(0, 0, 0, 0);
        btn_40.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_40.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        btn_50 = new Button();
        btn_50.setIcon(theme.getImage("50_shillings_note_ke.png"));
        //btn_50.setText("0");
        btn_50.setTextPosition(BOTTOM);
        btn_50.getAllStyles().setFgColor(0x000000);
        btn_50.getAllStyles().setBgTransparency(0);
        btn_50.getAllStyles().setFont(font_small_plain);
        btn_50.getAllStyles().setPadding(0, 0, 0, 0);
        btn_50.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_50.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        btn_100 = new Button();
        btn_100.setIcon(theme.getImage("100_shillings_note_ke.png"));
        //btn_100.setText("0");
        btn_100.setTextPosition(BOTTOM);
        btn_100.getAllStyles().setFgColor(0x000000);
        btn_100.getAllStyles().setBgTransparency(0);
        btn_100.getAllStyles().setFont(font_small_plain);
        btn_100.getAllStyles().setPadding(0, 0, 0, 0);
        btn_100.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_100.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        btn_200 = new Button();
        btn_200.setIcon(theme.getImage("200_shillings_note_ke.png"));
        //btn_200.setText("0");
        btn_200.setTextPosition(BOTTOM);
        btn_200.getAllStyles().setFgColor(0x000000);
        btn_200.getAllStyles().setBgTransparency(0);
        btn_200.getAllStyles().setFont(font_small_plain);
        btn_200.getAllStyles().setPadding(0, 0, 0, 0);
        btn_200.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_200.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        btn_500 = new Button();
        btn_500.setIcon(theme.getImage("500_shillings_note_ke.png"));
        //btn_500.setText("0");
        btn_500.setTextPosition(BOTTOM);
        btn_500.getAllStyles().setFgColor(0x000000);
        btn_500.getAllStyles().setBgTransparency(0);
        btn_500.getAllStyles().setFont(font_small_plain);
        btn_500.getAllStyles().setPadding(0, 0, 0, 0);
        btn_500.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_500.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        btn_1000 = new Button();
        btn_1000.setIcon(theme.getImage("1000_shillings_note_ke.png"));
        //btn_1000.setText("0");
        btn_1000.setTextPosition(BOTTOM);
        btn_1000.getAllStyles().setFgColor(0x000000);
        btn_1000.getAllStyles().setBgTransparency(0);
        btn_1000.getAllStyles().setFont(font_small_plain);
        btn_1000.getAllStyles().setPadding(0, 0, 0, 0);
        btn_1000.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_1000.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });
      
        lbl_payprovider_spacer1 = new Label();
        lbl_payprovider_spacer1.setIcon(theme.getImage("paymeth_spacer.png"));
        lbl_payprovider_spacer1.setText("");
        lbl_payprovider_spacer1.setTextPosition(BOTTOM);
        lbl_payprovider_spacer1.getAllStyles().setFgColor(0x000000);
        lbl_payprovider_spacer1.getAllStyles().setBgTransparency(0);
        lbl_payprovider_spacer1.getAllStyles().setFont(font_small_bold);
        lbl_payprovider_spacer1.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                
            }
        });
        
        bool_payment_method = Storage.getInstance().exists("paymethod");
        if(bool_payment_method == true)
        {
            str_paymethod = Storage.getInstance().readObject("paymethod").toString();
            if(str_paymethod.equals("-------"))
            {
                cnt_payment_providers.add(lbl_payprovider_spacer1);
            }
            else
            {
            }
        }
        else
        {
            cnt_payment_providers.add(lbl_payprovider_spacer1);
        }
       
      
        lbl_card = new Label();
        lbl_card.setIcon(theme.getImage("pay_card.png"));
        lbl_card.setText("Card");
        lbl_card.setTextPosition(BOTTOM);
        lbl_card.getAllStyles().setFgColor(0x000000);
        lbl_card.getAllStyles().setBgTransparency(0);
        lbl_card.getAllStyles().setFont(font_small_bold);
        lbl_card.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //str_paymethod = "card"; //TODO: Remove already set above
                System.out.println(str_paymethod+" label got pressed.");
                Storage.getInstance().writeObject("paymethod", str_paymethod);
                Storage.getInstance().writeObject("payprovider", "-------");
                Storage.getInstance().writeObject("temp_trx_number", "-------");
                Storage.getInstance().writeObject("temp_ref_number", "-------");
                
                System.out.println("Going to show Invoice.");
                showInvoice();

                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(lbl_mastercard);
                cnt_payment_providers.add(lbl_visa);

                lbl_card.getAllStyles().setBorder(border);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);

                //cnt_cmds_pic.setVisible(false);

                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                dlg_payments3.repaint();
            }
        });
        cnt_payment_methods.add(lbl_card);
        
        lbl_cash = new Label();
        lbl_cash.setIcon(theme.getImage("pay_cash.png"));
        lbl_cash.setText("Cash");
        lbl_cash.getAllStyles().setBgTransparency(0);
        lbl_cash.setTextPosition(BOTTOM);
        lbl_cash.getAllStyles().setFgColor(0x000000);
        lbl_cash.getAllStyles().setFont(font_small_bold);
        lbl_cash.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {                
                str_paymethod = "cash";
                str_payprovider = "cash";
                System.out.println(str_paymethod+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);
                
                Log.p("Writing paym to storage "+str_paymethod, 1);
                Log.p("Writing payp to storage "+str_payprovider, 1);
                Log.p("Writing date to storage "+picker_leo.getText(), 1); //txtf_startdate.getText()
                Log.p("Writing ref# to storage "+"N/a", 1);

                Storage.getInstance().writeObject("paymethod", str_paymethod);
                Storage.getInstance().writeObject("payprovider", str_payprovider);
                Storage.getInstance().writeObject("temp_date_time", picker_leo.getText());
                Storage.getInstance().writeObject("temp_ref_number", "N/a");

                str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                int_no_main_items = Integer.parseInt(str_no_main_items);

                for (i = 0; i < int_no_main_items+2; i++)
                {       
                    if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                    {

                    }
                    else
                    {
                        Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                        Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                        Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                        Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, "");    //str_itemop1v //"ABC123"

                        Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                        Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i,"00");             //str_itemop1v //"2000"
                        Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                        Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, "");//str_itemop1v //"ABC123"

                        Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                        Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                        Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                        Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, "");//str_itemop1v //"ABC123"

                        System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                        System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                        System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                        System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+"");
                    }
                }

                bool_no_new_items = Storage.getInstance().exists("no_new_items");
                if(bool_no_new_items == true)
                {
                        str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                        int_no_new_items = Integer.parseInt(str_no_new_items);

                        for (i = 0; i < int_no_new_items; i++) 
                        {
                            if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                            {

                            }
                            else
                            {
                                Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, "");    //str_itemop1v //"ABC123"

                                Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, "");//str_itemop1v //"ABC123"

                                Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, "");//str_itemop1v //"ABC123"

                                System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"");
                            }
                        }
                }

                System.out.println("Generating random number.");
                doRandomNum();

                System.out.println("Going to show Invoice.");
                //showInvoice();
                
                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(btn_0_5);
                cnt_payment_providers.add(btn_1);
                cnt_payment_providers.add(btn_5);
                cnt_payment_providers.add(btn_10);
                cnt_payment_providers.add(btn_20);
                cnt_payment_providers.add(btn_40);
                cnt_payment_providers.add(btn_50);
                cnt_payment_providers.add(btn_100);
                cnt_payment_providers.add(btn_200);
                cnt_payment_providers.add(btn_500);
                cnt_payment_providers.add(btn_1000);               
                
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(border);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);
                
                //cnt_cmds_pic.setVisible(false);
                
                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                dlg_payments3.repaint();

                dlg_payments3.dispose();
                showPayDialog3();            
            }
        });
        cnt_payment_methods.add(lbl_cash);
        
        lbl_bank = new Label();
        lbl_bank.setIcon(theme.getImage("pay_bank.png"));
        lbl_bank.setText("Bank");
        lbl_bank.getAllStyles().setBgTransparency(0);
        lbl_bank.setTextPosition(BOTTOM);
        lbl_bank.getAllStyles().setFgColor(0x000000);
        lbl_bank.getAllStyles().setFont(font_small_bold);
        lbl_bank.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "bank";
                str_payprovider = "bank";
                System.out.println(str_paymethod+" label got pressed.");
                
                bool_refno = Storage.getInstance().exists("temp_ref_number");
                if(bool_refno == true)
                {
                    str_refno = Storage.getInstance().readObject("temp_ref_number").toString();
                    if(str_refno.equals("-------"))
                    {
                        str_refno = "";
                        str_inst = "Please enter the "+str_payprovider+" Transaction number and confirm it.\n";
                    }
                    else
                    {
                        str_inst = "Please confirm that the "+str_payprovider+" Transaction number is correct.\n";
                    }
                }
                else
                {
                    str_refno = "";
                    str_inst = "Please enter the "+str_payprovider+" Transaction number and confirm it.\n";
                }
                
                TextArea txta_ref_number = new TextArea();
                txta_ref_number.setText(str_refno);
                txta_ref_number.setHint("Trx Number");
                txta_ref_number.setGrowByContent(true);
                txta_ref_number.setSingleLineTextArea(false);
                txta_ref_number.setEditable(true);
                txta_ref_number.setFocusable(true);
                txta_ref_number.setUIID("Label");

                SpanLabel slbl_instruction = new SpanLabel(str_inst);
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                       
                        if(txta_ref_number.getText().trim().equals(""))
                        {
                            Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                        }
                        else
                        {
                            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                            //Log.p(sdf.format(Calendar.getInstance().getTime()));
                            Picker picker_leo = new Picker();
                            picker_leo.setFormatter(sdformat);

                            Log.p("Writing paym to storage "+str_paymethod, 1);
                            Log.p("Writing payp to storage "+str_payprovider, 1);
                            Log.p("Writing date to storage "+picker_leo.getText(), 1); //txtf_startdate.getText()
                            Log.p("Writing ref# to storage "+txta_ref_number.getText().trim(), 1);

                            Storage.getInstance().writeObject("paymethod", str_paymethod);
                            Storage.getInstance().writeObject("payprovider", str_payprovider);
                            Storage.getInstance().writeObject("temp_date_time", picker_leo.getText());
                            Storage.getInstance().writeObject("temp_ref_number", txta_ref_number.getText().trim());

                            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                            int_no_main_items = Integer.parseInt(str_no_main_items);

                            for (i = 0; i < int_no_main_items+2; i++)
                            {       
                                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, txta_ref_number.getText().trim());    //str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, txta_ref_number.getText().trim());//str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, txta_ref_number.getText().trim());//str_itemop1v //"ABC123"

                                    System.err.println(i+" Setting main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                    System.err.println(i+" Setting main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                    System.err.println(i+" Setting main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                    System.err.println(i+" Setting main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+txta_ref_number.getText().trim());
                                }
                            }
                            
                            for (i = 0; i < int_no_new_items; i++) 
                            {
                                if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                    Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, txta_ref_number.getText().trim());    //str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, txta_ref_number.getText().trim());//str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, txta_ref_number.getText().trim());//str_itemop1v //"ABC123"

                                    System.err.println(i+" Setting new payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                    System.err.println(i+" Setting new payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                    System.err.println(i+" Setting new payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                    System.err.println(i+" Setting new payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+txta_ref_number.getText().trim());
                                }
                            }

                            System.out.println("Generating random number.");
                            doRandomNum();

                            System.out.println("Going to show Invoice.");
                            //showInvoice();

                            cnt_payment_providers.removeAll();
                            cnt_payment_providers.add(lbl_payprovider_spacer1); //TODO: Remove this and add bank icons


                            lbl_card.getAllStyles().setBorder(null);
                            lbl_cash.getAllStyles().setBorder(null);
                            lbl_bank.getAllStyles().setBorder(border);
                            lbl_mobile.getAllStyles().setBorder(null);
                            lbl_cheque.getAllStyles().setBorder(null);
                            lbl_direct.getAllStyles().setBorder(null);

                            //cnt_cmds_pic.setVisible(false);

                            cnt_payment_providers.revalidate();
                            cnt_payment_methods.revalidate();
                            dlg_payments3.repaint();

                            dialog.dispose();

                            dlg_payments3.dispose();
                            showPayDialog3();
                        }
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, txta_ref_number);
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
        cnt_payment_methods.add(lbl_bank);
        
        lbl_mobile = new Label();
        lbl_mobile.setIcon(theme.getImage("pay_mobile.png"));
        lbl_mobile.setText("MobileM");
        lbl_mobile.getAllStyles().setBgTransparency(0);
        lbl_mobile.setTextPosition(BOTTOM);
        lbl_mobile.getAllStyles().setFgColor(0x000000);
        lbl_mobile.getAllStyles().setFont(font_small_bold);
        lbl_mobile.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "mobile";
                System.out.println(str_paymethod+" label got pressed.");
                Storage.getInstance().writeObject("paymethod", str_paymethod);
                Storage.getInstance().writeObject("payprovider", "-------");
                Storage.getInstance().writeObject("temp_trx_number", "-------");
                Storage.getInstance().writeObject("temp_ref_number", "-------");
                
                
                showInvoice();
                
                
                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(lbl_mpesa);
                cnt_payment_providers.add(lbl_airtelzap);
                cnt_payment_providers.add(lbl_telkom);
                cnt_payment_providers.add(lbl_equitel);
                
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(border);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);
                
                //cnt_cmds_pic.setVisible(false);
                
                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                fm_main.repaint();
            }
        });
        cnt_payment_methods.add(lbl_mobile);
        
        lbl_cheque = new Label();
        lbl_cheque.setIcon(theme.getImage("pay_cheque.png"));
        lbl_cheque.setText("Cheque");
        lbl_cheque.getAllStyles().setBgTransparency(0);
        lbl_cheque.setTextPosition(BOTTOM);
        lbl_cheque.getAllStyles().setFgColor(0x000000);
        lbl_cheque.getAllStyles().setFont(font_small_bold);
        lbl_cheque.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "cheque";
                str_payprovider = "cheque";
                
                System.out.println(str_payprovider+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);

                //bool_startdate = Storage.getInstance().exists("");
                //if(str_start.equals("")){str_start = picker_leo.getText();}

                cldr_start = new Calendar(); 
                cldr_start.setChangesSelectedDateEnabled(true); //txtf_taskBegining = new TextField(str_task_beginning);

                txtf_startdate = new TextField(str_start, "Start Date");
                txtf_startdate.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_startdate.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_startdate.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_startdate.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getUnselectedStyle().getBorder().setThickness(3);
                txtf_startdate.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getSelectedStyle().getBorder().setThickness(3);
                txtf_startdate.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getPressedStyle().getBorder().setThickness(3);
                txtf_startdate.setEditable(false);
                txtf_startdate.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        Log.p("Preparing to show place to set start date.", 1);
                        storage.writeObject("transaction", "set_sdate");
                        showDaySelector();
                    }
                });
                
                TextField txtf_refno = new TextField();
                txtf_refno.setHint("Ref Number");
                txtf_refno.setConstraint(ANY);
                txtf_refno.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                
                
                SpanLabel slbl_instruction = new SpanLabel("Please enter the "+str_payprovider+" Transaction number and confirm it.");
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                        System.out.println(str_payprovider+" label got pressed.");
                        if(txtf_refno.getText().trim().equals(""))
                        {
                            Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                        }
                        else
                        {
                            Log.p("Writing paym to storage "+str_paymethod, 1);
                            Log.p("Writing payp to storage "+str_payprovider, 1);
                            Log.p("Writing date to storage "+txtf_startdate.getText(), 1); //txtf_startdate.getText()
                            Log.p("Writing ref# to storage "+txtf_refno.getText(), 1);
                           
                            Storage.getInstance().writeObject("paymethod", str_paymethod);
                            Storage.getInstance().writeObject("payprovider", str_payprovider);
                            Storage.getInstance().writeObject("temp_date_time", txtf_startdate.getText());
                            Storage.getInstance().writeObject("temp_ref_number", txtf_refno.getText());
                            
                            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                            int_no_main_items = Integer.parseInt(str_no_main_items);

                            for (i = 0; i < int_no_main_items+2; i++)
                            {       
                                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                }
                            }

                           
                            bool_no_new_items = Storage.getInstance().exists("no_new_items");
                            if(bool_no_new_items == true)
                            {
                                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                    int_no_new_items = Integer.parseInt(str_no_new_items);

                                    for (i = 0; i < int_no_new_items; i++) 
                                    {
                                        if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                        {

                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, txtf_refno.getText());    //str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, txtf_refno.getText());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, txtf_refno.getText());//str_itemop1v //"ABC123"

                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText());
                                        }
                                    }
                            }
                
                            System.out.println("Generating random number.");
                            doRandomNum();

                            System.out.println("Going to show Invoice.");
                            //showInvoice();
                            
                            btn_add_photo.setText("Add Cheque");
                            btn_view_photo.setText("View Cheque");

                            cnt_payment_providers.removeAll();
                            cnt_payment_providers.add(cnt_cmds_pic);
                            
                            cnt_cmds_pic.setVisible(true);

                            cnt_payment_providers.revalidate();
                            cnt_payment_methods.revalidate();
                            dlg_payments3.repaint();

                            dialog.dispose();

                            dlg_payments3.dispose();
                            showPayDialog3();
                        }
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(txtf_startdate, txtf_refno)); //txtf_startdate, 
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
        cnt_payment_methods.add(lbl_cheque);
                
        lbl_direct = new Label();
        lbl_direct.setIcon(theme.getImage("direct.png"));
        lbl_direct.setText("Direct");
        lbl_direct.getAllStyles().setBgTransparency(0);
        lbl_direct.setTextPosition(BOTTOM);
        lbl_direct.getAllStyles().setFgColor(0x000000);
        lbl_direct.getAllStyles().setFont(font_small_bold);
        lbl_direct.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "Direct Deposit"; 
                str_payprovider = "direct";
                System.out.println(str_paymethod+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);
                                
                Storage.getInstance().writeObject("paymethod", "-------");
                Storage.getInstance().writeObject("payprovider", "-------");
                Storage.getInstance().writeObject("temp_trx_number", "-------");
                
                TextArea txta_ref_number = new TextArea();
                txta_ref_number.setText("");
                txta_ref_number.setHint("Trx Number");
                txta_ref_number.setGrowByContent(true);
                txta_ref_number.setSingleLineTextArea(false);
                txta_ref_number.setEditable(true);
                txta_ref_number.setFocusable(true);
                txta_ref_number.setUIID("Label");

                SpanLabel slbl_instruction = new SpanLabel("Please enter the "+str_payprovider+" Bank slip and click confirm to proceed.");
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                        System.out.println(str_payprovider+" label got pressed.");
                        Storage.getInstance().writeObject("paymethod", str_paymethod);
                        Storage.getInstance().writeObject("payprovider", str_payprovider);
                        Storage.getInstance().writeObject("temp_ref_number",  txta_ref_number.getText());
                        
                        str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                        int_no_main_items = Integer.parseInt(str_no_main_items);

                        for (i = 0; i < int_no_main_items+2; i++)
                        {       
                            if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                            {

                            }
                            else
                            {
                                Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, "");    //str_itemop1v //"ABC123"

                                Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i,"00");             //str_itemop1v //"2000"
                                Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, "");//str_itemop1v //"ABC123"

                                Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, "");//str_itemop1v //"ABC123"

                                System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+"");
                            }
                        }

                        bool_no_new_items = Storage.getInstance().exists("no_new_items");
                        if(bool_no_new_items == true)
                        {
                                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                int_no_new_items = Integer.parseInt(str_no_new_items);

                                for (i = 0; i < int_no_new_items; i++) 
                                {
                                    if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                    {

                                    }
                                    else
                                    {
                                        Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                        Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                        Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                        Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, "");    //str_itemop1v //"ABC123"

                                        Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                        Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                        Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                        Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, "");//str_itemop1v //"ABC123"

                                        Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
                                        Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                        Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                        Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, "");//str_itemop1v //"ABC123"

                                        System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                        System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                        System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                        System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"");
                                    }
                                }
                        }
                
                        System.out.println("Generating random number.");
                        doRandomNum();
                        
                        System.out.println("Going to show Invoice.");
                        //showInvoice();
                        
                        btn_add_photo.setText("Add Slip");
                        btn_view_photo.setText("View Slip");

                        cnt_payment_providers.removeAll();
                        cnt_payment_providers.add(cnt_cmds_pic);

                        lbl_card.getAllStyles().setBorder(null);
                        lbl_cash.getAllStyles().setBorder(null);
                        lbl_bank.getAllStyles().setBorder(null);
                        lbl_mobile.getAllStyles().setBorder(null);
                        lbl_cheque.getAllStyles().setBorder(null);
                        lbl_direct.getAllStyles().setBorder(border);

                        cnt_cmds_pic.setVisible(true);
                        
                        dialog.dispose();

                        dlg_payments3.dispose();
                        showPayDialog3();
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, txta_ref_number);
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
                //System.out.println("Preparing to show invoice.");
                //doInvoice();
            }
        });
        cnt_payment_methods.add(lbl_direct);
                
        lbl_mpesa = new Label(theme.getImage("safaricom.png"));
        lbl_mpesa.getAllStyles().setBgTransparency(0);
        lbl_mpesa.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "mobile";
                str_payprovider = "Mpesa";
                
                System.out.println(str_payprovider+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);

                //bool_startdate = Storage.getInstance().exists("");
                //if(str_start.equals("")){str_start = picker_leo.getText();}

                cldr_start = new Calendar(); 
                cldr_start.setChangesSelectedDateEnabled(true); //txtf_taskBegining = new TextField(str_task_beginning);

                txtf_startdate = new TextField(str_start, "Start Date");
                txtf_startdate.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_startdate.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_startdate.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_startdate.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getUnselectedStyle().getBorder().setThickness(3);
                txtf_startdate.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getSelectedStyle().getBorder().setThickness(3);
                txtf_startdate.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getPressedStyle().getBorder().setThickness(3);
                txtf_startdate.setEditable(false);
                txtf_startdate.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        Log.p("Preparing to show place to set start date.", 1);
                        storage.writeObject("transaction", "set_sdate");
                        showDaySelector();
                    }
                });
                
                TextField txtf_refno = new TextField();
                txtf_refno.setHint("Ref Number");
                txtf_refno.setConstraint(ANY);
                txtf_refno.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                
                
                SpanLabel slbl_instruction = new SpanLabel("Please enter the "+str_payprovider+" Transaction number and confirm it.");
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                        System.out.println(str_payprovider+" label got pressed.");
                        if(txtf_refno.getText().trim().equals(""))
                        {
                            Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                        }
                        else
                        {
                            Log.p("Writing paym to storage "+str_paymethod, 1);
                            Log.p("Writing payp to storage "+str_payprovider, 1);
                            Log.p("Writing date to storage "+picker_leo.getText(), 1); //txtf_startdate.getText()
                            Log.p("Writing ref# to storage "+txtf_refno.getText(), 1);
                           
                            Storage.getInstance().writeObject("paymethod", str_paymethod);
                            Storage.getInstance().writeObject("payprovider", str_payprovider);
                            Storage.getInstance().writeObject("temp_date_time", picker_leo.getText());
                            Storage.getInstance().writeObject("temp_ref_number", txtf_refno.getText());
                            
                            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                            int_no_main_items = Integer.parseInt(str_no_main_items);

                            for (i = 0; i < int_no_main_items+2; i++)
                            {       
                                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                }
                            }
                            
                            
                            bool_no_new_items = Storage.getInstance().exists("no_new_items");
                            if(bool_no_new_items == true)
                            {
                                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                    int_no_new_items = Integer.parseInt(str_no_new_items);

                                    for (i = 0; i < int_no_new_items; i++) 
                                    {
                                        if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                        {

                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                        }
                                    }
                            }

                            System.out.println("Generating random number.");
                            doRandomNum();

                            System.out.println("Going to show Invoice.");
                            //showInvoice();

                            cnt_payment_providers.removeAll();
                            cnt_payment_providers.add(lbl_airtelzap);
                            cnt_payment_providers.add(lbl_mpesa);
                            cnt_payment_providers.add(lbl_telkom);
                            cnt_payment_providers.add(lbl_equitel);

                            lbl_airtelzap.getAllStyles().setBorder(null);
                            lbl_mpesa.getAllStyles().setBorder(border);
                            lbl_telkom.getAllStyles().setBorder(null);
                            lbl_equitel.getAllStyles().setBorder(null);

                            //cnt_cmds_pic.setVisible(false);

                            cnt_payment_providers.revalidate();
                            cnt_payment_methods.revalidate();
                            dlg_payments3.repaint();

                            dialog.dispose();

                            dlg_payments3.dispose();
                            showPayDialog3();
                        }
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(txtf_startdate, txtf_refno)); 
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
                
        lbl_airtelzap = new Label(theme.getImage("airtel.png"));
        lbl_airtelzap.getAllStyles().setBgTransparency(0);
        lbl_airtelzap.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "mobile";
                str_payprovider = "Airtel Money";
                
                System.out.println(str_payprovider+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);
                
                TextField txtf_refno = new TextField();
                txtf_refno.setHint("Ref Number");
                txtf_refno.setConstraint(ANY);
                txtf_refno.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                
                
                SpanLabel slbl_instruction = new SpanLabel("Please enter the "+str_payprovider+" Transaction number and confirm it.");
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                        System.out.println(str_payprovider+" label got pressed.");
                        if(txtf_refno.getText().trim().equals(""))
                        {
                            Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                        }
                        else
                        {
                            Log.p("Writing paym to storage "+str_paymethod, 1);
                            Log.p("Writing payp to storage "+str_payprovider, 1);
                            Log.p("Writing date to storage "+picker_leo.getText(), 1); //txtf_startdate.getText()
                            Log.p("Writing ref# to storage "+txtf_refno.getText(), 1);
                           
                            Storage.getInstance().writeObject("paymethod", str_paymethod);
                            Storage.getInstance().writeObject("payprovider", str_payprovider);
                            Storage.getInstance().writeObject("temp_date_time", picker_leo.getText());
                            Storage.getInstance().writeObject("temp_ref_number", txtf_refno.getText());
                            
                            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                            int_no_main_items = Integer.parseInt(str_no_main_items);

                            for (i = 0; i < int_no_main_items+2; i++)
                            {       
                                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                }
                            }
                            
                            bool_no_new_items = Storage.getInstance().exists("no_new_items");
                            if(bool_no_new_items == true)
                            {
                                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                    int_no_new_items = Integer.parseInt(str_no_new_items);

                                    for (i = 0; i < int_no_new_items; i++) 
                                    {
                                        if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                        {

                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                        }
                                    }
                            }
                            
                            

                            System.out.println("Generating random number.");
                            doRandomNum();

                            System.out.println("Going to show Invoice.");
                            //showInvoice();

                            cnt_payment_providers.removeAll();
                            cnt_payment_providers.add(lbl_airtelzap);
                            cnt_payment_providers.add(lbl_mpesa);
                            cnt_payment_providers.add(lbl_telkom);
                            cnt_payment_providers.add(lbl_equitel);

                            lbl_airtelzap.getAllStyles().setBorder(border);
                            lbl_mpesa.getAllStyles().setBorder(null);
                            lbl_telkom.getAllStyles().setBorder(null);
                            lbl_equitel.getAllStyles().setBorder(null);

                            //cnt_cmds_pic.setVisible(false);

                            cnt_payment_providers.revalidate();
                            cnt_payment_methods.revalidate();
                            dlg_payments3.repaint();

                            dialog.dispose();

                            dlg_payments3.dispose();
                            showPayDialog3();
                        }
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(txtf_refno)); //txtf_startdate, 
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
                
        lbl_telkom = new Label(theme.getImage("telkom.png"));
        lbl_telkom.getAllStyles().setBgTransparency(0);
        lbl_telkom.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "mobile";
                str_payprovider = "Telkom";
                
                System.out.println(str_payprovider+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);
                
                TextField txtf_refno = new TextField();
                txtf_refno.setHint("Ref Number");
                txtf_refno.setConstraint(ANY);
                txtf_refno.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                
                
                SpanLabel slbl_instruction = new SpanLabel("Please enter the "+str_payprovider+" Transaction number and confirm it.");
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                        System.out.println(str_payprovider+" label got pressed.");
                        if(txtf_refno.getText().trim().equals(""))
                        {
                            Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                        }
                        else
                        {
                            Log.p("Writing paym to storage "+str_paymethod, 1);
                            Log.p("Writing payp to storage "+str_payprovider, 1);
                            Log.p("Writing date to storage "+picker_leo.getText(), 1); //txtf_startdate.getText()
                            Log.p("Writing ref# to storage "+txtf_refno.getText(), 1);
                           
                            Storage.getInstance().writeObject("paymethod", str_paymethod);
                            Storage.getInstance().writeObject("payprovider", str_payprovider);
                            Storage.getInstance().writeObject("temp_date_time", picker_leo.getText());
                            Storage.getInstance().writeObject("temp_ref_number", txtf_refno.getText());
                            
                            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                            int_no_main_items = Integer.parseInt(str_no_main_items);

                            for (i = 0; i < int_no_main_items+2; i++)
                            {       
                                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                }
                            }
                            
                            bool_no_new_items = Storage.getInstance().exists("no_new_items");
                            if(bool_no_new_items == true)
                            {
                                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                    int_no_new_items = Integer.parseInt(str_no_new_items);

                                    for (i = 0; i < int_no_new_items; i++) 
                                    {
                                        if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                        {

                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                        }
                                    }
                            }

                            System.out.println("Generating random number.");
                            doRandomNum();

                            System.out.println("Going to show Invoice.");
                            //showInvoice();

                            cnt_payment_providers.removeAll();
                            cnt_payment_providers.add(lbl_airtelzap);
                            cnt_payment_providers.add(lbl_mpesa);
                            cnt_payment_providers.add(lbl_telkom);
                            cnt_payment_providers.add(lbl_equitel);

                            lbl_airtelzap.getAllStyles().setBorder(null);
                            lbl_mpesa.getAllStyles().setBorder(null);
                            lbl_telkom.getAllStyles().setBorder(border);
                            lbl_equitel.getAllStyles().setBorder(null);

                            //cnt_cmds_pic.setVisible(false);

                            cnt_payment_providers.revalidate();
                            cnt_payment_methods.revalidate();
                            dlg_payments3.repaint();

                            dialog.dispose();

                            dlg_payments3.dispose();
                            showPayDialog3();
                        }
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(txtf_refno)); //txtf_startdate, 
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
        
        lbl_equitel = new Label(theme.getImage("equitel.png"));
        lbl_equitel.getAllStyles().setBgTransparency(0);
        lbl_equitel.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "mobile";
                str_payprovider = "Equitel";
                
                System.out.println(str_payprovider+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);
                
                TextField txtf_refno = new TextField();
                txtf_refno.setHint("Ref Number");
                txtf_refno.setConstraint(ANY);
                txtf_refno.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                
                
                SpanLabel slbl_instruction = new SpanLabel("Please enter the "+str_payprovider+" Transaction number and confirm it.");
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                        System.out.println(str_payprovider+" label got pressed.");
                        if(txtf_refno.getText().trim().equals(""))
                        {
                            Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                        }
                        else
                        {
                            Log.p("Writing paym to storage "+str_paymethod, 1);
                            Log.p("Writing payp to storage "+str_payprovider, 1);
                            Log.p("Writing date to storage "+picker_leo.getText(), 1); //txtf_startdate.getText()
                            Log.p("Writing ref# to storage "+txtf_refno.getText(), 1);
                           
                            Storage.getInstance().writeObject("paymethod", str_paymethod);
                            Storage.getInstance().writeObject("payprovider", str_payprovider);
                            Storage.getInstance().writeObject("temp_date_time", picker_leo.getText());
                            Storage.getInstance().writeObject("temp_ref_number", txtf_refno.getText());
                            
                            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                            int_no_main_items = Integer.parseInt(str_no_main_items);

                            for (i = 0; i < int_no_main_items+2; i++)
                            {       
                                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                }
                            }
                            
                            bool_no_new_items = Storage.getInstance().exists("no_new_items");
                            if(bool_no_new_items == true)
                            {
                                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                    int_no_new_items = Integer.parseInt(str_no_new_items);

                                    for (i = 0; i < int_no_new_items; i++) 
                                    {
                                        if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                        {

                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                        }
                                    }
                            }

                            System.out.println("Generating random number.");
                            doRandomNum();

                            System.out.println("Going to show Invoice.");
                            //showInvoice();

                            cnt_payment_providers.removeAll();
                            cnt_payment_providers.add(lbl_airtelzap);
                            cnt_payment_providers.add(lbl_mpesa);
                            cnt_payment_providers.add(lbl_telkom);
                            cnt_payment_providers.add(lbl_equitel);

                            lbl_airtelzap.getAllStyles().setBorder(null);
                            lbl_mpesa.getAllStyles().setBorder(null);
                            lbl_telkom.getAllStyles().setBorder(null);
                            lbl_equitel.getAllStyles().setBorder(border);

                            //cnt_cmds_pic.setVisible(false);

                            cnt_payment_providers.revalidate();
                            cnt_payment_methods.revalidate();
                            dlg_payments3.repaint();

                            dialog.dispose();

                            dlg_payments3.dispose();
                            showPayDialog3();
                        }
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(txtf_refno)); //txtf_startdate, 
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
        
        lbl_mastercard = new Label(theme.getImage("mastercard.png"));
        lbl_mastercard.getAllStyles().setBgTransparency(0);
        lbl_mastercard.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "card"; //TODO: remove this... already set above under lbl_card.
                str_payprovider = "Mastercard";
                System.out.println(str_payprovider+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);

               // bool_startdate = Storage.getInstance().exists("");
               //if(str_start.equals("")){str_start = picker_leo.getText();}

                cldr_start = new Calendar(); 
                cldr_start.setChangesSelectedDateEnabled(true); //txtf_taskBegining = new TextField(str_task_beginning);

                txtf_startdate = new TextField(str_start, "Start Date");
                txtf_startdate.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_startdate.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_startdate.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_startdate.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getUnselectedStyle().getBorder().setThickness(3);
                txtf_startdate.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getSelectedStyle().getBorder().setThickness(3);
                txtf_startdate.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getPressedStyle().getBorder().setThickness(3);
                txtf_startdate.setEditable(false);
                txtf_startdate.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        Log.p("Preparing to show place to set start date.", 1);
                        storage.writeObject("transaction", "set_sdate");
                        showDaySelector();
                    }
                });

                TextField txtf_refno = new TextField();
                txtf_refno.setHint("Ref Number");
                txtf_refno.setConstraint(ANY);
                txtf_refno.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);

                TextField txtf_amount = new TextField();
                txtf_amount.setHint("Amount");
                txtf_amount.setConstraint(NUMERIC);
                txtf_amount.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_amount.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_amount.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getUnselectedStyle().getBorder().setThickness(3);
                txtf_amount.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getSelectedStyle().getBorder().setThickness(3);
                txtf_amount.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getPressedStyle().getBorder().setThickness(3);

                SpanLabel slbl_instruction = new SpanLabel("Please enter the "+str_payprovider+" Transaction number and confirm it.");
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                        System.out.println(str_payprovider+" label got pressed.");
                        
                        
                        //if(txtf_startdate.getText().equals(""))
                        //{
                        //    Dialog.show("Oops!", "You must select a date to proceed.", "Ok", null);
                        //}
                        //else if(str_paymethod.equals("-------"))
                        //{
                        //    Dialog.show("Oops!", "You must select payment method to proceed.", "Ok", null);
                        //}
                        //else if(str_payprovider.equals("-------"))
                        //{
                        //    Dialog.show("Oops!", "You must select payment service provider to proceed.", "Ok", null);
                        //}
                        if(txtf_refno.getText().trim().equals(""))
                        {
                            Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                        }
                        //else if(txtf_amount.getText().trim().equals(""))
                        //{
                        //    Log.p("Amount not entered.", 1);
                        //    Dialog.show("Oops!", "Amount not entered... Please enter it then click confirm.", "OK", null);
                        //}
                        else
                        {
                            Log.p("Writing paym to storage "+str_paymethod, 1);
                            Log.p("Writing payp to storage "+str_payprovider, 1);
                            Log.p("Writing date to storage "+picker_leo.getText(), 1); //txtf_startdate.getText()
                            Log.p("Writing ref# to storage "+txtf_refno.getText(), 1);
                            //Log.p("Writing amnt to storage "+txtf_amount.getText(), 1);

                            Storage.getInstance().writeObject("paymethod", str_paymethod);
                            Storage.getInstance().writeObject("payprovider", str_payprovider);
                            Storage.getInstance().writeObject("temp_date_time", picker_leo.getText());
                            Storage.getInstance().writeObject("temp_ref_number", txtf_refno.getText());
                            //Storage.getInstance().writeObject("temp_amt_number",  txtf_refno.getText());

                            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                            int_no_main_items = Integer.parseInt(str_no_main_items);

                            btn_payoption1_main_row = new Button[int_no_main_items+2];
                            btn_payoption2_main_row = new Button[int_no_main_items+2];
                            btn_payoption3_main_row = new Button[int_no_main_items+2];


                            for (i = 0; i < int_no_main_items+2; i++)
                            {       
                                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                //TODO: set amount divided by 3
                                 //btn_payoption1_row[i] = new Button();
                                 //btn_payoption1_row[i].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png")); //str_paymethod+"_thumb.png"
                                 //btn_payoption1_row[i].setName(str_payprovider.toLowerCase());
                                 //btn_payoption1_row[i].setUIID(txtf_amount.getText().trim());

                                 //btn_payoption2_row[i] = new Button();
                                 //btn_payoption2_row[i].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_").toLowerCase()+"_thumb.png"));
                                 //btn_payoption2_row[i].setName(str_payprovider.toLowerCase());
                                 //btn_payoption2_row[i].setUIID(txtf_amount.getText().trim());

                                 //btn_payoption3_row[i] = new Button();
                                 //btn_payoption3_row[i].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_").toLowerCase()+"_thumb.png"));
                                 //btn_payoption3_row[i].setName(str_payprovider.toLowerCase());
                                 //btn_payoption3_row[i].setUIID(txtf_amount.getText().trim());


                                 Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                 Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");//str_itemop1v //"2000"
                                 Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                 Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                 Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                 Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i, "00");//str_itemop1v //"2000"
                                 Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                 Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                 Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                 Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");//str_itemop1v //"2000"
                                 Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                 Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                 System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                 System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                 System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                 System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                }
                            }
                            
                            bool_no_new_items = Storage.getInstance().exists("no_new_items");
                            if(bool_no_new_items == true)
                            {
                                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                    int_no_new_items = Integer.parseInt(str_no_new_items);

                                    for (i = 0; i < int_no_new_items; i++) 
                                    {
                                        if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                        {

                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                        }
                                    }
                            }

                            System.out.println("Generating random number.");
                            doRandomNum();

                            System.out.println("Going to show Invoice.");
                            //showInvoice();

                            cnt_payment_providers.removeAll();
                            cnt_payment_providers.add(lbl_mastercard);
                            cnt_payment_providers.add(lbl_visa);

                            lbl_card.getAllStyles().setBorder(border);
                            lbl_cash.getAllStyles().setBorder(null);
                            lbl_bank.getAllStyles().setBorder(null);
                            lbl_mobile.getAllStyles().setBorder(null);
                            lbl_cheque.getAllStyles().setBorder(null);
                            lbl_direct.getAllStyles().setBorder(null);

                            //cnt_cmds_pic.setVisible(false);

                            cnt_payment_providers.revalidate();
                            cnt_payment_methods.revalidate();
                            dlg_payments3.repaint();

                            dialog.dispose();

                            dlg_payments3.dispose();
                            showPayDialog3();
                        }
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(txtf_refno));
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });
                
        lbl_visa = new Label(theme.getImage("visa.png"));
        lbl_visa.getAllStyles().setBgTransparency(0);
        lbl_visa.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "card"; //TODO: read this from storage... do the same for the rest of the payproviders.
                str_payprovider = "Visa";
               
                System.out.println(str_payprovider+" label got pressed.");
                
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
                //Log.p(sdf.format(Calendar.getInstance().getTime()));
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);

                //bool_startdate = Storage.getInstance().exists("");
                //if(str_start.equals("")){str_start = picker_leo.getText();}

                cldr_start = new Calendar(); 
                cldr_start.setChangesSelectedDateEnabled(true); //txtf_taskBegining = new TextField(str_task_beginning);

                txtf_startdate = new TextField(str_start, "Start Date");
                txtf_startdate.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_startdate.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_startdate.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_startdate.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getUnselectedStyle().getBorder().setThickness(3);
                txtf_startdate.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getSelectedStyle().getBorder().setThickness(3);
                txtf_startdate.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_startdate.getPressedStyle().getBorder().setThickness(3);
                txtf_startdate.setEditable(false);
                txtf_startdate.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        Log.p("Preparing to show place to set start date.", 1);
                        storage.writeObject("transaction", "set_sdate");
                        showDaySelector();
                    }
                });
                
                TextField txtf_refno = new TextField();
                txtf_refno.setHint("Ref Number");
                txtf_refno.setConstraint(ANY);
                txtf_refno.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                
                
                SpanLabel slbl_instruction = new SpanLabel("Please enter the "+str_payprovider+" Transaction number and confirm it.");
                slbl_instruction.getTextAllStyles().setFgColor(0x000000, false);

                Dialog dialog = new Dialog();
                dialog.setLayout(new BorderLayout());
                Button btn_yes = new Button("Confirm");
                btn_yes.addActionListener(new ActionListener()
                {
                   public void actionPerformed(ActionEvent evt)
                   {
                        System.out.println(str_payprovider+" label got pressed.");                        
                        //if(txtf_startdate.getText().equals(""))
                        //{
                        //    Dialog.show("Oops!", "You must select a date to proceed.", "Ok", null);
                        //}
                        //else if(str_paymethod.equals("-------"))
                        //{
                        //    Dialog.show("Oops!", "You must select payment method to proceed.", "Ok", null);
                        //}
                        //else if(str_payprovider.equals("-------"))
                        //{
                        //    Dialog.show("Oops!", "You must select payment service provider to proceed.", "Ok", null);
                        //}
                        if(txtf_refno.getText().trim().equals(""))
                        {
                            Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                        }
                        else
                        {
                            Log.p("Writing paym to storage "+str_paymethod, 1);
                            Log.p("Writing payp to storage "+str_payprovider, 1);
                            Log.p("Writing date to storage "+picker_leo.getText(), 1); //txtf_startdate.getText()
                            Log.p("Writing ref# to storage "+txtf_refno.getText(), 1);
                           
                            Storage.getInstance().writeObject("paymethod", str_paymethod);
                            Storage.getInstance().writeObject("payprovider", str_payprovider);
                            Storage.getInstance().writeObject("temp_date_time", picker_leo.getText());
                            Storage.getInstance().writeObject("temp_ref_number", txtf_refno.getText());
                            
                            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                            int_no_main_items = Integer.parseInt(str_no_main_items);

                            btn_payoption1_main_row = new Button[int_no_main_items+2];
                            btn_payoption2_main_row = new Button[int_no_main_items+2];
                            btn_payoption3_main_row = new Button[int_no_main_items+2];

                            for (i = 0; i < int_no_main_items+2; i++)
                            {       
                                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                                {

                                }
                                else
                                {
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                    System.err.println(i+" Setting main payoptions for  "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                }
                            }
                            
                            bool_no_new_items = Storage.getInstance().exists("no_new_items");
                            if(bool_no_new_items == true)
                            {
                                    str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                    int_no_new_items = Integer.parseInt(str_no_new_items);

                                    for (i = 0; i < int_no_new_items; i++) 
                                    {
                                        if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                                        {

                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i,  str_payprovider); //str_itemop1  //"Mpesa"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
                                            Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, txtf_refno.getText().trim());//str_itemop1v //"ABC123"

                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
                                            System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+txtf_refno.getText().trim());
                                        }
                                    }
                            }

                            System.out.println("Generating random number.");
                            doRandomNum();

                            System.out.println("Going to show Invoice.");
                            //showInvoice();

                            cnt_payment_providers.removeAll();
                            cnt_payment_providers.add(lbl_mastercard);
                            cnt_payment_providers.add(lbl_visa);

                            lbl_card.getAllStyles().setBorder(border);
                            lbl_cash.getAllStyles().setBorder(null);
                            lbl_bank.getAllStyles().setBorder(null);
                            lbl_mobile.getAllStyles().setBorder(null);
                            lbl_cheque.getAllStyles().setBorder(null);
                            lbl_direct.getAllStyles().setBorder(null);

                            //cnt_cmds_pic.setVisible(false);

                            cnt_payment_providers.revalidate();
                            cnt_payment_methods.revalidate();
                            dlg_payments3.repaint();

                            dialog.dispose();

                            dlg_payments3.dispose();
                            showPayDialog3();
                        }
                   }
                });

                Button btn_no = new Button("Cancel");
                btn_no.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt)
                    {
                       dialog.dispose();
                    }
                });
                
                dialog.addComponent(BorderLayout.NORTH, slbl_instruction);
                dialog.addComponent(BorderLayout.CENTER, BoxLayout.encloseY(txtf_refno)); //txtf_startdate, 
                dialog.addComponent(BorderLayout.SOUTH, FlowLayout.encloseCenterBottom(btn_no, btn_yes));
                dialog.show();
            }
        });       
       
        
        SimpleDateFormat sdformat_sabbath = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
        //Log.p(sdf.format(Calendar.getInstance().getTime()));
        Picker picker_sabbath = new Picker();
        picker_sabbath.setFormatter(sdformat_sabbath);

        //bool_startdate = Storage.getInstance().exists("");
        //if(str_start.equals("")){str_start = picker_leo.getText();}

        cldr_sabbath = new Calendar(); 
        cldr_sabbath.setChangesSelectedDateEnabled(true); //txtf_taskBegining = new TextField(str_task_beginning);

        bool_trxdt = Storage.getInstance().exists("start_pdate");
        if(bool_trxdt == true)
        {
            str_start = Storage.getInstance().readObject("start_pdate").toString();
        }
        else
        {
            str_start = "";
        }
        
        lbl_trxn_date = new Label("Trnx Date:");
        //lbl_trxn_date.setTextPosition(Component.TOP);
        lbl_trxn_date.setVerticalAlignment(CENTER);
        lbl_trxn_date.getAllStyles().setMarginBottom((int)(3.2 * pixelsPerMM));
        
        
        txtf_trxn_date = new TextField(str_start, "---------");
        txtf_trxn_date.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
        txtf_trxn_date.getHintLabel().getStyle().setFgColor(0xdc1212, false);
        txtf_trxn_date.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_trxn_date.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_trxn_date.getUnselectedStyle().getBorder().setThickness(3);
        txtf_trxn_date.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_trxn_date.getSelectedStyle().getBorder().setThickness(3);
        txtf_trxn_date.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_trxn_date.getPressedStyle().getBorder().setThickness(3);
        txtf_trxn_date.setEditable(false);
        txtf_trxn_date.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("Preparing to show place to set start date.", 1);
                Storage.getInstance().writeObject("transaction", "set_pdate");
                showDaySelector();
            }
        });
        
        ///////////////////////////////////////////////////////////////////
        //
        
        bool_payment_method = Storage.getInstance().exists("paymethod");
        if(bool_payment_provider == true)
        {
            //TODO: highlight according to the other options that the user may have previously selected.
           
            str_paymethod = Storage.getInstance().readObject("paymethod").toString(); 
            System.err.println("Setting paymethod on screen i.e. "+str_paymethod);
            
            if(str_paymethod.equals("card"))
            {
                lbl_card.getAllStyles().setBorder(border);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);
                
                cnt_payment_providers.add(lbl_mastercard);
                cnt_payment_providers.add(lbl_visa);
            }
            else if(str_paymethod.equals("cash"))
            {
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(border);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);
                
                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(btn_0_5);
                cnt_payment_providers.add(btn_1);
                cnt_payment_providers.add(btn_5);
                cnt_payment_providers.add(btn_10);
                cnt_payment_providers.add(btn_20);
                cnt_payment_providers.add(btn_40);
                cnt_payment_providers.add(btn_50);
                cnt_payment_providers.add(btn_100);
                cnt_payment_providers.add(btn_200);
                cnt_payment_providers.add(btn_500);
                cnt_payment_providers.add(btn_1000);
            }
            else if(str_paymethod.equals("bank"))
            {
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(border);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);
                
                cnt_payment_providers.add(lbl_payprovider_spacer1); //TODO: put bank icons here.
            }
            else if(str_paymethod.equals("mobile"))
            {
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(border);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);
                
                cnt_payment_providers.add(lbl_mpesa);
                cnt_payment_providers.add(lbl_airtelzap);
                cnt_payment_providers.add(lbl_telkom);
                cnt_payment_providers.add(lbl_equitel);
            }
            else if(str_paymethod.equals("cheque"))
            {
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(border);
                lbl_direct.getAllStyles().setBorder(null);
                
                cnt_payment_providers.add(cnt_cmds_pic);
            }
            else if(str_paymethod.equals("Direct Deposit"))
            {
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(border);
                
                cnt_payment_providers.add(cnt_cmds_pic);
            }
            else
            {
                //lbl_card.getAllStyles().setBorder(null);
                //lbl_cash.getAllStyles().setBorder(null);
                //lbl_bank.getAllStyles().setBorder(null);
                //lbl_mobile.getAllStyles().setBorder(border);
                //lbl_cheque.getAllStyles().setBorder(null);
                //lbl_direct.getAllStyles().setBorder(null);
                //
                //cnt_payment_providers.add(lbl_mpesa);
                //cnt_payment_providers.add(lbl_airtelzap);
                //cnt_payment_providers.add(lbl_telkom);
                //cnt_payment_providers.add(lbl_equitel);
                cnt_payment_providers.add(lbl_payprovider_spacer1);
            }
        }
        else
        {
                //lbl_card.getAllStyles().setBorder(null);
                //lbl_cash.getAllStyles().setBorder(null);
                //lbl_bank.getAllStyles().setBorder(null);
                //lbl_mobile.getAllStyles().setBorder(border);
                //lbl_cheque.getAllStyles().setBorder(null);
                //lbl_direct.getAllStyles().setBorder(null);
                //
                //cnt_payment_providers.add(lbl_mpesa);
                //cnt_payment_providers.add(lbl_airtelzap);
                //cnt_payment_providers.add(lbl_telkom);
                //cnt_payment_providers.add(lbl_equitel);
                cnt_payment_providers.add(lbl_payprovider_spacer1);
        }
        
        bool_payment_provider = Storage.getInstance().exists("payprovider");
        if(bool_payment_provider == true)
        {
            //TODO: highlight according to the other options that the user may have previously selected.
            str_payprovider = Storage.getInstance().readObject("payprovider").toString();
            if(str_payprovider.equals("Mpesa"))
            {
                lbl_airtelzap.getAllStyles().setBorder(null);
                lbl_mpesa.getAllStyles().setBorder(border);
                lbl_telkom.getAllStyles().setBorder(null);
                lbl_equitel.getAllStyles().setBorder(null);
            }
            else if(str_payprovider.equals("Airtel Money"))
            {
                lbl_airtelzap.getAllStyles().setBorder(border);
                lbl_mpesa.getAllStyles().setBorder(null);
                lbl_telkom.getAllStyles().setBorder(null);
                lbl_equitel.getAllStyles().setBorder(null);
            }
            else if(str_payprovider.equals("Telkom"))
            {
                lbl_airtelzap.getAllStyles().setBorder(null);
                lbl_mpesa.getAllStyles().setBorder(null);
                lbl_telkom.getAllStyles().setBorder(border);
                lbl_equitel.getAllStyles().setBorder(null);
            }
            else if(str_payprovider.equals("Equitel"))
            {
                lbl_airtelzap.getAllStyles().setBorder(null);
                lbl_mpesa.getAllStyles().setBorder(null);
                lbl_telkom.getAllStyles().setBorder(null);
                lbl_equitel.getAllStyles().setBorder(border);
            }
            else if(str_payprovider.equals("Visa"))
            {
                lbl_visa.getAllStyles().setBorder(border);
                lbl_mastercard.getAllStyles().setBorder(null);
            }
            else if(str_payprovider.equals("Mastercard"))
            {
                lbl_visa.getAllStyles().setBorder(null);
                lbl_mastercard.getAllStyles().setBorder(border);
            }
            else
            {
                //Should not be possible
            }
        }
        else
        {
            //Should not be possible
        }
        //
        ///////////////////////////////////////////////////////////////////////////////////
        
        
        ///////////////////////////////////////////////////////////////////////////////////
        
        Button btn_back2 = new Button("Back");
        btn_back2.getUnselectedStyle().setBgColor(0x448d21); //0x448d21 - frog green //0x19B9E7 - light bluish   //0x35E041 - light green
        btn_back2.getUnselectedStyle().setBgTransparency(255);
        btn_back2.getUnselectedStyle().setBorder(null);
        btn_back2.getSelectedStyle().setBorder(null);
        btn_back2.getStyle().setFgColor(0xffffff);
        btn_back2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //Storage.getInstance().deleteStorageFile("pay_instructions");
                dlg_payments3.removeAll();
                dlg_payments3.dispose();
                try 
                {
                    showPayDialog2();
                        
                } 
                catch (Exception ex) 
                {
                    System.err.println("Error: "+ex);
                }
            }
        });
        
        Button btn_finish = new Button("Finish");
        btn_finish.getUnselectedStyle().setBgColor(0x448d21); //0x448d21 - frog green //0x19B9E7 - light bluish   //0x35E041 - light green
        btn_finish.getUnselectedStyle().setBgTransparency(255);
        btn_finish.getUnselectedStyle().setBorder(null);
        btn_finish.getSelectedStyle().setBorder(null);
        btn_finish.getStyle().setFgColor(0xffffff);
        btn_finish.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //Storage.getInstance().deleteStorageFile("payprovider");
                //Storage.getInstance().deleteStorageFile("pay_instructions");
                //dlg_payments3.dispose();
                
                //TODO: call Connect class update db and send confirmation sms
                //Connect.storage.writeObject("parameter1", "accounts");
                //Connect.storage.writeObject("parameter2", txta_username.getText().trim());
                //Connect.storage.writeObject("parameter3", txta_password.getText().trim());
                //Connect.storage.writeObject("parameter4", Storage.getInstance().readObject("userid"));
                //Connect.storage.writeObject("parameter5", "10");     //limit
                //Connect.storage.writeObject("parameter6", "0");      //offset
                //Connect.storage.writeObject("parameter7", txta_1timepin.getText().trim());  //pinno
                //Connect.storage.writeObject("parameter8", "type");   //type
                
                str_user_id = Storage.getInstance().readObject("userid").toString();
                      
                str_itemsel = Storage.getInstance().readObject("itemsel").toString();
                str_no_itemsel = Storage.getInstance().readObject("no_itemsel").toString();
                
                str_payprovider = Storage.getInstance().readObject("payprovider").toString();
                
                str_refno = Storage.getInstance().readObject("temp_ref_number").toString();
                str_trxno = Storage.getInstance().readObject("temp_trx_number").toString();
                str_memno = Storage.getInstance().readObject("temp_member_no").toString();
                str_firstname = Storage.getInstance().readObject("temp_firstname").toString();
                str_middlename = Storage.getInstance().readObject("temp_middlename").toString();
                str_lastname = Storage.getInstance().readObject("temp_lastname").toString();
                str_other_name = Storage.getInstance().readObject("temp_other_name").toString();
                str_phone = Storage.getInstance().readObject("temp_phone").toString();
                str_email = Storage.getInstance().readObject("temp_email").toString();
                
                bool_department = Storage.getInstance().exists("temp_department");
                if(bool_department == true)
                {
                    str_department = Storage.getInstance().readObject("temp_department").toString();
                }
                else
                {
                    str_department = "n/a";
                }
                
                str_totals = Storage.getInstance().readObject("totals").toString();
                                
                Storage.getInstance().writeObject("parameter1", "transaction"); //transaction
                Storage.getInstance().writeObject("parameter2", str_user_id);  //userid -> 1 //deviceid -> 27830a45-b8ec-460a-ad89-0bfe4069fdae
                Storage.getInstance().writeObject("parameter3", str_no_itemsel);//2     
                Storage.getInstance().writeObject("parameter4", str_itemsel.trim());   //24,Cattle Auction Fees,120,2, 240 ,Mpesa,Tommy Mogaka,n/a|28,Sugarcane,1,1, 1 ,Mpesa,Tommy Mogaka,n/a|
                Storage.getInstance().writeObject("parameter5", str_firstname); 
                Storage.getInstance().writeObject("parameter6", str_lastname);      
                Storage.getInstance().writeObject("parameter7", str_phone); //"254"+str_phone
                Storage.getInstance().writeObject("parameter8", str_email);
                Storage.getInstance().writeObject("parameter9", str_memno);
                Storage.getInstance().writeObject("parameter10", str_trxno);
                Storage.getInstance().writeObject("parameter11", str_totals);
                Storage.getInstance().writeObject("parameter12", str_payprovider);
                Storage.getInstance().writeObject("parameter13", "giving");
                Storage.getInstance().writeObject("parameter14", str_department);
                Storage.getInstance().writeObject("parameter15", str_refno);
                
                Storage.getInstance().writeObject("parameter20", str_middlename); 
                Storage.getInstance().writeObject("parameter21", str_other_name); 
                
                
                //dlg_payments3.dispose();
                
                if(str_payprovider.equals("-------"))
                {
                    Dialog.show("Oops!", "You must select payment option to proceed.", "Ok", null);
                }
                else if(str_refno.equals("-------"))
                {
                    Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                }
                else if(txtf_trxn_date.getText().equals(""))
                {
                    Dialog.show("Oops!", "You must select a payment date to proceed.", "Ok", null);
                }
                else
                {
                    Storage.getInstance().deleteStorageFile("main_proceed");
                    Storage.getInstance().deleteStorageFile("new_proceed");
                    
                    //doPackTheBus();
                    doDhafuMainItems();
                    
                }
            }
        });
        
        Container cnt_dlgFooter = new Container(new BorderLayout());
        cnt_dlgFooter.add(BorderLayout.WEST, btn_back2);
        cnt_dlgFooter.add(BorderLayout.EAST, btn_finish);
        
        dlg_payments3.add(BorderLayout.NORTH, BoxLayout.encloseY(cnt_dlgCMDs, cnt_dlgHeader, BoxLayout.encloseY(cnt_payment_methods , FlowLayout.encloseCenter(cnt_payment_providers)), BoxLayout.encloseX(lbl_trxn_date, txtf_trxn_date))); //, cnt_cmds_pic //cnt_dlgCMDs, cnt_dlgHeader, BoxLayout.encloseY(cnt_payment_methods, FlowLayout.encloseCenter(cnt_payment_providers)), cnt_description, cnt_cmds_pic)
        dlg_payments3.add(BorderLayout.CENTER, BoxLayout.encloseY(cnt_description, cnt_details));
        
        dlg_payments3.add(BorderLayout.SOUTH, cnt_dlgFooter);
        //dlg_payments3.show();
        dlg_payments3.showPacked(BorderLayout.CENTER, true);
        //dlg_payments3.showAtPosition(displayHeight/4, displayHeight/8, displayWidth/8, displayWidth/8, false);
        dlg_payments3.setDisposeWhenPointerOutOfBounds(false);
    }
    
    public void doDhafu()
    {
            bool_no_main_items = Storage.getInstance().exists("no_main_items");
            if(bool_no_main_items == true)
            {
                str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                
                // null or empty
                if (str_no_main_items == null || str_no_main_items.length() == 0) 
                {
                    int_no_main_items = 0;
                }
                else
                {
                    int_no_main_items = Integer.parseInt(str_no_main_items);
                }
            }
            else
            {
                int_no_main_items = 0;
            }
            
            bool_no_new_items = Storage.getInstance().exists("no_new_items");
            if(bool_no_new_items == true)
            {
                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                if (str_no_new_items == null || str_no_new_items.length() == 0) 
                {
                    int_no_main_items = 0;
                }
                else
                {
                    int_no_new_items = Integer.parseInt(str_no_new_items);
                }
            }
            else
            {
                int_no_new_items = 0;
            }
            

            int_totals = int_no_main_items+int_no_new_items;
            Storage.getInstance().writeObject("no_total_items", int_totals);
            
            
        
            System.out.println("Setting null items in the form to zero then totalling all available items.");
        
            bool_buildingv_roof  = Storage.getInstance().exists("buildingv_roof");
            if(bool_buildingv_roof == true)
            {
                str_buildingv_roof = Storage.getInstance().readObject("buildingv_roof").toString();
                if(str_buildingv_roof.equals(""))
                {
                    str_buildingv_roof = "0";
                }
            }
            else
            {
                str_buildingv_roof = "0";
            }
            
            bool_buildingv_premix  = Storage.getInstance().exists("buildingv_premix");
            if(bool_buildingv_premix == true)
            {
                str_buildingv_premix = Storage.getInstance().readObject("buildingv_premix").toString();
                if(str_buildingv_premix.equals(""))
                {
                    str_buildingv_premix = "0";
                }
            }
            else
            {
                str_buildingv_premix = "0";
            }
            
            bool_buildingv_wall  = Storage.getInstance().exists("buildingv_wall");
            if(bool_buildingv_wall == true)
            {
                str_buildingv_wall = Storage.getInstance().readObject("buildingv_wall").toString();
                if(str_buildingv_wall.equals(""))
                {
                    str_buildingv_wall = "0";
                }
            }
            else
            {
                str_buildingv_wall = "0";
            }
            
            bool_buildingv_elec  = Storage.getInstance().exists("buildingv_elec");
            if(bool_buildingv_elec == true)
            {
                str_buildingv_elec = Storage.getInstance().readObject("buildingv_elec").toString();
                if(str_buildingv_elec.equals(""))
                {
                    str_buildingv_elec = "0";
                }
            }
            else
            {
                str_buildingv_elec = "0";
            }
            
            bool_buildingv_plumb  = Storage.getInstance().exists("buildingv_plumb");
            if(bool_buildingv_plumb == true)
            {
                str_buildingv_plumb = Storage.getInstance().readObject("buildingv_plumb").toString();
                if(str_buildingv_plumb.equals(""))
                {
                    str_buildingv_plumb = "0";
                }
            }
            else
            {
                str_buildingv_plumb = "0";
            }
            
            
            bool_buildingv_pulpit  = Storage.getInstance().exists("buildingv_pulpit");
            if(bool_buildingv_pulpit == true)
            {
                str_buildingv_pulpit = Storage.getInstance().readObject("buildingv_pulpit").toString();
                if(str_buildingv_pulpit.equals(""))
                {
                    str_buildingv_pulpit = "0";
                }
            }
            else
            {
                str_buildingv_pulpit = "0";
            } 
            
            
            bool_buildingv_window  = Storage.getInstance().exists("buildingv_window");
            if(bool_buildingv_window == true)
            {
                str_buildingv_window = Storage.getInstance().readObject("buildingv_window").toString();
                if(str_buildingv_window.equals(""))
                {
                    str_buildingv_window = "0";
                }
            }
            else
            {
                str_buildingv_window = "0";
            } 
            
            System.out.println("-------------------------------------------");
            System.out.println("Writing the Building Items to Storage");
            System.out.println("Roof = "+str_buildingv_roof);
            System.out.println("Premix = "+str_buildingv_premix);
            System.out.println("Wall = "+str_buildingv_wall);
            System.out.println("Elecrticals = "+str_buildingv_elec);
            System.out.println("Plumbing = "+str_buildingv_plumb);
            System.out.println("Pulpit = "+str_buildingv_pulpit);
            System.out.println("Window = "+str_buildingv_window);
            System.out.println("-------------------------------------------");
            
            int int_building_totals = Integer.parseInt(str_buildingv_roof)+Integer.parseInt(str_buildingv_premix)+Integer.parseInt(str_buildingv_wall)+Integer.parseInt(str_buildingv_elec)+Integer.parseInt(str_buildingv_plumb)+Integer.parseInt(str_buildingv_pulpit)+Integer.parseInt(str_buildingv_window);
            System.out.println("Building Totals: "+int_building_totals);
            
            str_buildingv = String.valueOf(int_building_totals);
            if(str_buildingv.equals("0"))
            {
                 str_buildingv = "0";
                 Storage.getInstance().writeObject("buildingv", str_buildingv);
            }
            else
            {
                Storage.getInstance().writeObject("buildingv", str_buildingv);
            }
            
        
            try 
            {
                bool_no_main_items = Storage.getInstance().exists("no_main_items");
                if(bool_no_main_items == true)
                {
                    str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                    int_no_main_items = Integer.parseInt(str_no_main_items);

                    int sum = 0;
                    for (i = 0; i < int_no_main_items+1; i++)
                    {
                      System.out.println("No of main items... "+str_no_main_items);
                      System.out.println("Reading... "+"main_itemv_"+i);
                      bool_main_item = Storage.getInstance().exists("main_itemv_"+i);
                      if(bool_main_item == true)
                      {
                          str_main_item = Storage.getInstance().readObject("main_itemv_"+i).toString();
                          if(str_main_item.equals("")){str_main_item = "0";}
                      }
                      else
                      {
                          str_main_item = "0";
                      }
                      System.out.println("..........."+"main_itemv_"+i+" = "+str_main_item);
                      //Integer n = Integer.parseInt(str_main_item);
                      Double n = Double.valueOf(str_main_item);

                      sum += n;
                    }
                    int_subtotals1 = sum;
                    System.out.println("Sub total 1(Main Items): "+int_subtotals1);

                    System.out.println("Total(Main Items): "+int_subtotals1);
                    Storage.getInstance().writeObject("totals", int_subtotals1);
                }
                else
                {

                }
            } 
            catch (Exception e) 
            {
                System.out.println("Error: "+e);
                //e.printStackTrace();
            }
            
            
            System.out.println("-------------------------------------------");        

            bool_no_new_items = Storage.getInstance().exists("no_new_items");
            if(bool_no_new_items == true)
            {
                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                int_no_new_items = Integer.parseInt(str_no_new_items);

                int sum = 0;
                for (i = 0; i < int_no_new_items; i++)
                {
                  System.out.println("Reading... "+"new_itemv_"+i);
                  str_item = Storage.getInstance().readObject("new_itemv_"+i).toString();
                  if(str_item.equals("")){str_item = "0";}
                  Integer n = Integer.parseInt(str_item);
                  sum += n;
                }
                int_subtotals2 = sum;
                System.out.println("Sub total 2(Added Items): "+int_subtotals2);

                int_totals = int_subtotals1+int_subtotals2;
                System.out.println("Total Amount(Added Items): "+int_totals);
                Storage.getInstance().writeObject("totals", int_totals);
            }
            else
            {

            }
            
            System.out.println("-------------------------------------------");
        
        //dlg_payments2.dispose();
        //showPayDialog2();
        
        System.out.println("Setting zero items back to null then totalling all available items.");
        try 
        {
            
            bool_buildingv_roof  = Storage.getInstance().exists("buildingv_roof");
            if(bool_buildingv_roof == true)
            {
                str_buildingv_roof = Storage.getInstance().readObject("buildingv_roof").toString();
                if(str_buildingv_roof.equals("0"))
                {
                    str_buildingv_roof = "";
                }
            }
            else
            {
                str_buildingv_roof = "";
            }

            bool_buildingv_premix  = Storage.getInstance().exists("buildingv_premix");
            if(bool_buildingv_premix == true)
            {
                str_buildingv_premix = Storage.getInstance().readObject("buildingv_premix").toString();
                if(str_buildingv_premix.equals("0"))
                {
                    str_buildingv_premix = "";
                }
            }
            else
            {
                str_buildingv_premix = "";
            }

            bool_buildingv_wall  = Storage.getInstance().exists("buildingv_wall");
            if(bool_buildingv_wall == true)
            {
                str_buildingv_wall = Storage.getInstance().readObject("buildingv_wall").toString();
                if(str_buildingv_wall.equals("0"))
                {
                    str_buildingv_wall = "";
                }
            }
            else
            {
                str_buildingv_wall = "";
            }

            bool_buildingv_elec  = Storage.getInstance().exists("buildingv_elec");
            if(bool_buildingv_elec == true)
            {
                str_buildingv_elec = Storage.getInstance().readObject("buildingv_elec").toString();
                if(str_buildingv_elec.equals("0"))
                {
                    str_buildingv_elec = "";
                }
            }
            else
            {
                str_buildingv_elec = "";
            }

            bool_buildingv_plumb  = Storage.getInstance().exists("buildingv_plumb");
            if(bool_buildingv_plumb == true)
            {
                str_buildingv_plumb = Storage.getInstance().readObject("buildingv_plumb").toString();
                if(str_buildingv_plumb.equals("0"))
                {
                    str_buildingv_plumb = "";
                }
            }
            else
            {
                str_buildingv_plumb = "";
            }


            bool_buildingv_pulpit  = Storage.getInstance().exists("buildingv_pulpit");
            if(bool_buildingv_pulpit == true)
            {
                str_buildingv_pulpit = Storage.getInstance().readObject("buildingv_pulpit").toString();
                if(str_buildingv_pulpit.equals("0"))
                {
                    str_buildingv_pulpit = "";
                }
            }
            else
            {
                str_buildingv_pulpit = "";
            } 


            bool_buildingv_window  = Storage.getInstance().exists("buildingv_window");
            if(bool_buildingv_window == true)
            {
                str_buildingv_window = Storage.getInstance().readObject("buildingv_window").toString();
                if(str_buildingv_window.equals("0"))
                {
                    str_buildingv_window = "";
                }
            }
            else
            {
                str_buildingv_window = "";
            }

            if(bool_buildingv == true)
            {
               str_buildingv   = Storage.getInstance().readObject("buildingv").toString();
               if(str_buildingv.equals("0"))
               {
                    str_buildingv = "";
               }
            }
            else
            {
                str_buildingv = "";
            }

            if(bool_budgetv == true)
            {
               str_budgetv   = Storage.getInstance().readObject("budgetv").toString();
               if(str_budgetv.equals("0"))
               {
                    str_budgetv = "";
               }
            }
            else
            {
                str_budgetv = "";
            }
            
        } 
        catch (Exception e) 
        {
            System.out.print("Error on line 9373");
        }

            //txtf_buildingv_roof.setText(str_buildingv_roof);
            //txtf_buildingv_premix.setText(str_buildingv_premix);
            //txtf_buildingv_wall.setText(str_buildingv_wall);
            //txtf_buildingv_elec.setText(str_buildingv_elec);
            //txtf_buildingv_plumb.setText(str_buildingv_plumb);
            //txtf_buildingv_pulpit.setText(str_buildingv_pulpit);
            //txtf_buildingv_window.setText(str_buildingv_window);

        System.out.println("-------------------------------------------");
        
        System.out.println("Setting new text to Items & Totals label on Screen.");
        System.out.println("(Items: "+(int_no_new_items+int_no_main_items)+")   -   Kshs. "+int_totals);
        
            lbl_items.setText("(Items: "+(int_no_new_items+int_no_main_items)+")");
            lbl_totals.setText("   -   Kshs. "+int_totals);
        
        System.out.println("-------------------------------------------");
        
        addItems();
                
        //cnt_items.revalidate();
        //dlg_payments2.revalidate();
        //fm_main.repaint();
    }
    
    private void addItems()
    {
        System.out.println("Adding Items(Main and New) to Screen...");
        System.out.println("--------------------------------------------"); 
        
        cnt_items.removeAll();
        
        String str_json_read = (String) Storage.getInstance().readObject("products.json");
        byte[] dataa = str_json_read.getBytes();
        JSONParser json = new JSONParser();
        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
        {
            Map<String, Object> map_content = json.parseJSON(is_content);
            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");
            
            //System.out.println("No of All Main items: "+obj_content.size());
            //Storage.getInstance().writeObject("no_main_items", String.valueOf(obj_content.size()));
            
            txtac_main_item = new AutoCompleteTextField[obj_content.size()];
            txtf_main_itemv = new TextField[obj_content.size()];
            
            i=0;
            for(Map<String, Object> obj : obj_content) 
            {
                int int_offset = i+1;
                
                String str_item_id = (String)obj.get("id");
                String str_item_nm = (String)obj.get("name");
                String str_item_pr = (String)obj.get("priority");
                               
                txtac_main_item[i] = new AutoCompleteTextField();
                txtac_main_item[i].setText(str_item_nm);
                txtac_main_item[i].setMinimumElementsShownInPopup(5);
                txtac_main_item[i].setMinimumLength(0);
                txtac_main_item[i].setHint("Main Item "+int_offset+" i.e "+str_item_nm);
                txtac_main_item[i].setName("main_item_"+i);
                txtac_main_item[i].setUIID(str_item_id);
                txtac_main_item[i].setEditable(false);
                txtac_main_item[i].setEnabled(false);
                txtac_main_item[i].setLeftAndRightEditingTrigger(true);
                txtac_main_item[i].setConstraint(TextField.INITIAL_CAPS_WORD);
                txtac_main_item[i].getAllStyles().setMargin(0, 2, 2, 2);
                txtac_main_item[i].getHintLabel().getStyle().setFgColor(0xC0C0C0, false); //0x888
                txtac_main_item[i].getUnselectedStyle().setBgColor(0xf8f8f8);
                txtac_main_item[i].getSelectedStyle().setBgColor(0xffffff);
                txtac_main_item[i].getStyle().setFgColor(0xC0C0C0);
                txtac_main_item[i].getStyle().setFont(font_medium_plain, false);
                txtac_main_item[i].getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtac_main_item[i].getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                txtac_main_item[i].getUnselectedStyle().getBorder().setThickness(3);
                txtac_main_item[i].getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                txtac_main_item[i].getSelectedStyle().getBorder().setThickness(3);
                txtac_main_item[i].getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                txtac_main_item[i].getPressedStyle().getBorder().setThickness(3);
                if(Display.getInstance().getPlatformName().equals("ios")){txtac_main_item[i].getStyle().setBgTransparency(255);}
                
                txtf_main_itemv[i] = new TextField();
                //txtf_main_itemv[i].setText(str_item);
                txtf_main_itemv[i].setHint("Amount...");
                txtf_main_itemv[i].setName("main_itemv_"+i);
                txtf_main_itemv[i].setEnableInputScroll(false);
                txtf_main_itemv[i].setConstraint(TextField.NUMERIC);
                txtf_main_itemv[i].getAllStyles().setMargin(0, 2, 2, 2);
                txtf_main_itemv[i].getHintLabel().getStyle().setFgColor(0xC0C0C0, false); //0x888
                txtf_main_itemv[i].getUnselectedStyle().setBgColor(0xf8f8f8);
                txtf_main_itemv[i].getSelectedStyle().setBgColor(0xffffff);
                txtf_main_itemv[i].getStyle().setFgColor(0xC0C0C0);
                txtf_main_itemv[i].getHintLabel().getStyle().setFont(font_medium_plain, false);
                txtf_main_itemv[i].getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                txtf_main_itemv[i].getUnselectedStyle().getBorder().setThickness(3);
                txtf_main_itemv[i].getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                txtf_main_itemv[i].getSelectedStyle().getBorder().setThickness(3);
                txtf_main_itemv[i].getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                txtf_main_itemv[i].getPressedStyle().getBorder().setThickness(3);
                if(Display.getInstance().getPlatformName().equals("ios")){txtf_main_itemv[i].getStyle().setBgTransparency(255);}
                               
                
                Label lbl_remove_main_item = new Label(theme.getImage("remove.png"));
                lbl_remove_main_item.setName(String.valueOf(i)); //"main_itemv_"+int_offset
                lbl_remove_main_item.setUIID(str_item_id);
                lbl_remove_main_item.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                            System.out.println("Remove label "+lbl_remove_main_item.getName()+" pressed.");
                    }
                });
                
                
                if(str_item_id.equals("99")) //9
                {
                    Log.p("Item id = 9 so showing the building fund categories.", 1);
                    
                    txtf_main_itemv[i].addPointerPressedListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            border2 = Border.createCompoundBorder(Border.createLineBorder(3, 0x5BC8FB), Border.createLineBorder(3, 0x5BC8FB), Border.createLineBorder(3, 0x5BC8FB), Border.createLineBorder(3, 0x5BC8FB));

                            sty = new Style();
                            sty.setBorder(null);
                            sty.setBgColor(0xffffff);
                            sty.setFgColor(0x5B2BFB);
                            sty.setBorder(border2);

                            s1 = new Style();
                            s1.setBgColor(0xffffff);
                            s1.setFgColor(0x5B2BFB);
                            s1.setBorder(border2);

                            //font_small_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
                            //font_medium_plain = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);

                            Dialog dlg_building = new Dialog();
                            dlg_building.setLayout(new BorderLayout());
//                            bool_buildingv_roof = Storage.getInstance().exists("buildingv_roof");
//                            if(bool_buildingv_roof == true)
//                            {
//                                str_buildingv_roof = Storage.getInstance().readObject("buildingv_roof").toString();
//                                if(str_buildingv_roof.equals("0"))
//                                {
//                                    str_buildingv_roof = "";
//                                }
//                            }
//                            else
//                            {
//                                str_buildingv_roof = "";
//                            }

                            txtf_building_roof = new TextField("Roof");
                            txtf_building_roof.setEditable(false);
                            txtf_building_roof.setEnabled(false);

                            txtf_buildingv_roof = new TextField(str_buildingv_roof, "Amount..."); 
                            txtf_buildingv_roof.setConstraint(NUMERIC);
                            txtf_buildingv_roof.getAllStyles().setBgColor(0xffffff);
                            txtf_buildingv_roof.getAllStyles().setFgColor(0x000000);
                            txtf_buildingv_roof.getHintLabel().getStyle().setFont(font_medium_plain, false);
//                            txtf_buildingv_roof.addActionListener(new ActionListener() 
//                            {
//                                @Override
//                                public void actionPerformed(ActionEvent evt) 
//                                {
//                                    if(txtf_buildingv_roof.getText().trim().equals(""))
//                                    {
//                                        Storage.getInstance().writeObject("buildingv_roof", "0");
//                                    }
//                                    else
//                                    {
//                                        Storage.getInstance().writeObject("buildingv_roof", txtf_buildingv_roof.getText().trim());
//                                    }
//                                }
//                            });


                            bool_buildingv_premix = Storage.getInstance().exists("buildingv_premix");
                            if(bool_buildingv_premix == true)
                            {
                                str_buildingv_premix = Storage.getInstance().readObject("buildingv_premix").toString();
                                if(str_buildingv_premix.equals("0"))
                                {
                                    str_buildingv_premix = "";
                                }
                            }
                            else
                            {
                                str_buildingv_premix = "";
                            }
                            txtf_building_premix = new TextField("Premix");
                            txtf_building_premix.setEditable(false);
                            txtf_building_premix.setEnabled(false);

                            txtf_buildingv_premix = new TextField(str_buildingv_premix, "Amount..."); 
                            txtf_buildingv_premix.setConstraint(NUMERIC);
                            txtf_buildingv_premix.getAllStyles().setBgColor(0xffffff);
                            txtf_buildingv_premix.getAllStyles().setFgColor(0x000000);
                            txtf_buildingv_premix.getHintLabel().getStyle().setFont(font_medium_plain, false);


                            bool_buildingv_wall = Storage.getInstance().exists("buildingv_wall");
                            if(bool_buildingv_wall == true)
                            {
                                str_buildingv_wall = Storage.getInstance().readObject("buildingv_wall").toString();
                                if(str_buildingv_wall.equals("0"))
                                {
                                    str_buildingv_wall = "";
                                }
                            }
                            else
                            {
                                str_buildingv_wall = "";
                            }
                            txtf_building_wall = new TextField("Walling");
                            txtf_building_wall.setEditable(false);
                            txtf_building_wall.setEnabled(false);

                            txtf_buildingv_wall = new TextField(str_buildingv_wall, "Amount..."); 
                            txtf_buildingv_wall.setConstraint(NUMERIC);
                            txtf_buildingv_wall.getAllStyles().setBgColor(0xffffff);
                            txtf_buildingv_wall.getAllStyles().setFgColor(0x000000);
                            txtf_buildingv_wall.getHintLabel().getStyle().setFont(font_medium_plain, false);



                            bool_buildingv_elec = Storage.getInstance().exists("buildingv_elec");
                            if(bool_buildingv_elec == true)
                            {
                                str_buildingv_elec = Storage.getInstance().readObject("buildingv_elec").toString();
                                if(str_buildingv_elec.equals("0"))
                                {
                                    str_buildingv_elec = "";
                                }
                            }
                            else
                            {
                                str_buildingv_elec = "";
                            }
                            txtf_building_elec = new TextField("Electricals");
                            txtf_building_elec.setEditable(false);
                            txtf_building_elec.setEnabled(false);

                            txtf_buildingv_elec = new TextField(str_buildingv_elec, "Amount..."); 
                            txtf_buildingv_elec.setConstraint(NUMERIC);
                            txtf_buildingv_elec.getAllStyles().setBgColor(0xffffff);
                            txtf_buildingv_elec.getAllStyles().setFgColor(0x000000);
                            txtf_buildingv_elec.getHintLabel().getStyle().setFont(font_medium_plain, false);


                            bool_buildingv_plumb = Storage.getInstance().exists("buildingv_plumb");
                            if(bool_buildingv_plumb == true)
                            {
                                str_buildingv_plumb = Storage.getInstance().readObject("buildingv_plumb").toString();
                                if(str_buildingv_plumb.equals("0"))
                                {
                                    str_buildingv_plumb = "";
                                }
                            }
                            else
                            {
                                str_buildingv_plumb = "";
                            }
                            txtf_building_plumb = new TextField("Plumbing");
                            txtf_building_plumb.setEditable(false);
                            txtf_building_plumb.setEnabled(false);

                            txtf_buildingv_plumb = new TextField(str_buildingv_plumb, "Amount..."); 
                            txtf_buildingv_plumb.setConstraint(NUMERIC);
                            txtf_buildingv_plumb.getAllStyles().setBgColor(0xffffff);
                            txtf_buildingv_plumb.getAllStyles().setFgColor(0x000000);
                            txtf_buildingv_plumb.getHintLabel().getStyle().setFont(font_medium_plain, false);



                            bool_buildingv_pulpit = Storage.getInstance().exists("buildingv_pulpit");
                            if(bool_buildingv_pulpit == true)
                            {
                                str_buildingv_pulpit = Storage.getInstance().readObject("buildingv_pulpit").toString();
                                if(str_buildingv_pulpit.equals("0"))
                                {
                                    str_buildingv_pulpit = "";
                                }
                            }
                            else
                            {
                                str_buildingv_pulpit = "";
                            }
                            txtf_building_pulpit = new TextField("Pulpit");
                            txtf_building_pulpit.setEditable(false);
                            txtf_building_pulpit.setEnabled(false);

                            txtf_buildingv_pulpit = new TextField(str_buildingv_pulpit, "Amount..."); 
                            txtf_buildingv_pulpit.setConstraint(NUMERIC);
                            txtf_buildingv_pulpit.getAllStyles().setBgColor(0xffffff);
                            txtf_buildingv_pulpit.getAllStyles().setFgColor(0x000000);
                            txtf_buildingv_pulpit.getHintLabel().getStyle().setFont(font_medium_plain, false);



                            bool_buildingv_window = Storage.getInstance().exists("buildingv_window");
                            if(bool_buildingv_window == true)
                            {
                                str_buildingv_window = Storage.getInstance().readObject("buildingv_window").toString();
                                if(str_buildingv_window.equals("0"))
                                {
                                    str_buildingv_window = "";
                                }
                            }
                            else
                            {
                                str_buildingv_window = "";
                            }
                            txtf_building_window = new TextField("Windows");
                            txtf_building_window.setEditable(false);
                            txtf_building_window.setEnabled(false);

                            txtf_buildingv_window = new TextField(str_buildingv_window, "Amount..."); 
                            txtf_buildingv_window.setConstraint(TextField.NUMERIC);
                            txtf_buildingv_window.getAllStyles().setBgColor(0xffffff);
                            txtf_buildingv_window.getAllStyles().setFgColor(0x000000);
                            txtf_buildingv_window.getHintLabel().getStyle().setFont(font_medium_plain, false);




                            cnt_building = new Container(new GridLayout(8, 2));
                            cnt_building.setScrollableY(true);
                            cnt_building.getStyle().setPadding(25, 0, 60, 60);

                            Label lbl_building_item_nme = new Label("Item"); lbl_building_item_nme.getAllStyles().setFgColor(0x000, false);
                            Label lbl_building_item_val = new Label("Value"); lbl_building_item_val.getAllStyles().setFgColor(0x000, false);

                            cnt_building.addComponent(FlowLayout.encloseCenterMiddle(lbl_building_item_nme));
                            cnt_building.addComponent(FlowLayout.encloseCenterMiddle(lbl_building_item_val));

                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_building_roof));
                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_buildingv_roof));

                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_building_premix));
                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_buildingv_premix));

                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_building_wall));
                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_buildingv_wall));

                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_building_elec));
                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_buildingv_elec));

                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_building_plumb));
                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_buildingv_plumb));

                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_building_pulpit));
                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_buildingv_pulpit));

                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_building_window));
                            cnt_building.addComponent(BoxLayout.encloseXNoGrow(txtf_buildingv_window));

                            Button btn_nop = new Button("Back");
                            btn_nop.addActionListener(new ActionListener() 
                            {
                                @Override
                                public void actionPerformed(ActionEvent evt) 
                                {
                                    dlg_building.dispose();
                                }
                            });

                            Button btn_yap = new Button("Save");
                            btn_yap.addActionListener(new ActionListener() 
                            {
                                @Override
                                public void actionPerformed(ActionEvent evt) 
                                {
                                        System.out.println("Writing the Building Items to Storage");
                                        System.out.println("Roof = "+txtf_buildingv_roof.getText().trim());
                                        System.out.println("Premix = "+txtf_buildingv_premix.getText().trim());
                                        System.out.println("Wall = "+txtf_buildingv_wall.getText().trim());
                                        System.out.println("Elecrticals = "+txtf_buildingv_elec.getText().trim());
                                        System.out.println("Plumbing = "+txtf_buildingv_plumb.getText().trim());
                                        System.out.println("Pulpit = "+txtf_buildingv_pulpit.getText().trim());
                                        System.out.println("Window = "+txtf_buildingv_window.getText().trim());   
                                        
                                        if(txtf_buildingv_roof.getText().trim().equals(""))
                                        {
                                            Storage.getInstance().writeObject("buildingv_roof", "0");
                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("buildingv_roof", txtf_buildingv_roof.getText().trim());
                                        }
                                        
                                        if(txtf_buildingv_premix.getText().trim().equals(""))
                                        {
                                            Storage.getInstance().writeObject("buildingv_premix", "0");
                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("buildingv_premix", txtf_buildingv_premix.getText().trim());
                                        }
                                        
                                        
                                        if(txtf_buildingv_wall.getText().trim().equals(""))
                                        {
                                            Storage.getInstance().writeObject("buildingv_wall", "0");
                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("buildingv_wall", txtf_buildingv_wall.getText().trim());
                                        }
                                        
                                        if(txtf_buildingv_elec.getText().trim().equals(""))
                                        {
                                            Storage.getInstance().writeObject("buildingv_elec", "0");
                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("buildingv_elec", txtf_buildingv_elec.getText().trim());
                                        }
                                        
                                        if(txtf_buildingv_plumb.getText().trim().equals(""))
                                        {
                                            Storage.getInstance().writeObject("buildingv_plumb", "0");
                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("buildingv_plumb", txtf_buildingv_plumb.getText().trim());
                                        }
                                        
                                        if(txtf_buildingv_pulpit.getText().trim().equals(""))
                                        {
                                            Storage.getInstance().writeObject("buildingv_pulpit", "0");
                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("buildingv_pulpit", txtf_buildingv_pulpit.getText().trim());
                                        }
                                        
                                        if(txtf_buildingv_window.getText().trim().equals(""))
                                        {
                                            Storage.getInstance().writeObject("buildingv_window", "0");
                                        }
                                        else
                                        {
                                            Storage.getInstance().writeObject("buildingv_window", txtf_buildingv_window.getText().trim());
                                        }
                                        
                                        Storage.getInstance().writeObject("buildingv_items", "ziko"); //TODO: change this into a count of the items filled in. E.g. if the value of a building items is not zero, then plus 1 on the buildingv_items count

                                        //System.out.println("Setting building total to Building textfield.");
                                        //int int_building_totals = Integer.parseInt(txtf_buildingv_roof.getText().trim())+Integer.parseInt(txtf_buildingv_premix.getText().trim())+Integer.parseInt(txtf_buildingv_wall.getText().trim())+Integer.parseInt(txtf_buildingv_elec.getText().trim())+Integer.parseInt(txtf_buildingv_plumb.getText().trim())+Integer.parseInt(txtf_buildingv_pulpit.getText().trim())+Integer.parseInt(txtf_buildingv_window.getText().trim());
                                        //System.out.println("Building Totals: "+int_building_totals);

                                        //System.out.println("Setting the total for building items in the building value texfield.");
                                        //txtf_buildingv.setText(String.valueOf(int_building_totals));

                                        System.out.println("Closing Building Items dialog.");
                                        dlg_building.dispose();
                                        
                                        System.out.println("Calling the Calculator method.");
                                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                        /*System.out.println(i+" Selected is "+txtac_main_item[Integer.parseInt(lbl_removeBindu.getName())].getName()+" i.e. "+txtac_main_item[Integer.parseInt(lbl_removeBindu.getName())].getText()+" that has a value of "+txtf_main_itemv[Integer.parseInt(lbl_removeBindu.getName())].getText().trim());
                                        if(txtac_main_item[Integer.parseInt(lbl_removeBindu.getName())].getText().trim().equals(""))
                                        {
                                            txtf_main_itemv[Integer.parseInt(lbl_removeBindu.getName())].setText("");
                                            Connect.okayDialog("Oops!!!", "Kindly fill in the name for "+txtac_main_item[Integer.parseInt(lbl_removeBindu.getName())].getName()+" first.");   
                                        }
                                        else
                                        {
                                        }
                                        */
                                        
                                        
                                        bool_buildingv_roof  = Storage.getInstance().exists("buildingv_roof");
                                        if(bool_buildingv_roof == true)
                                        {
                                            str_buildingv_roof = Storage.getInstance().readObject("buildingv_roof").toString();
                                            if(str_buildingv_roof.equals(""))
                                            {
                                                str_buildingv_roof = "0";
                                            }
                                        }
                                        else
                                        {
                                            str_buildingv_roof = "0";
                                        }

                                        bool_buildingv_premix  = Storage.getInstance().exists("buildingv_premix");
                                        if(bool_buildingv_premix == true)
                                        {
                                            str_buildingv_premix = Storage.getInstance().readObject("buildingv_premix").toString();
                                            if(str_buildingv_premix.equals(""))
                                            {
                                                str_buildingv_premix = "0";
                                            }
                                        }
                                        else
                                        {
                                            str_buildingv_premix = "0";
                                        }

                                        bool_buildingv_wall  = Storage.getInstance().exists("buildingv_wall");
                                        if(bool_buildingv_wall == true)
                                        {
                                            str_buildingv_wall = Storage.getInstance().readObject("buildingv_wall").toString();
                                            if(str_buildingv_wall.equals(""))
                                            {
                                                str_buildingv_wall = "0";
                                            }
                                        }
                                        else
                                        {
                                            str_buildingv_wall = "0";
                                        }

                                        bool_buildingv_elec  = Storage.getInstance().exists("buildingv_elec");
                                        if(bool_buildingv_elec == true)
                                        {
                                            str_buildingv_elec = Storage.getInstance().readObject("buildingv_elec").toString();
                                            if(str_buildingv_elec.equals(""))
                                            {
                                                str_buildingv_elec = "0";
                                            }
                                        }
                                        else
                                        {
                                            str_buildingv_elec = "0";
                                        }

                                        bool_buildingv_plumb  = Storage.getInstance().exists("buildingv_plumb");
                                        if(bool_buildingv_plumb == true)
                                        {
                                            str_buildingv_plumb = Storage.getInstance().readObject("buildingv_plumb").toString();
                                            if(str_buildingv_plumb.equals(""))
                                            {
                                                str_buildingv_plumb = "0";
                                            }
                                        }
                                        else
                                        {
                                            str_buildingv_plumb = "0";
                                        }


                                        bool_buildingv_pulpit  = Storage.getInstance().exists("buildingv_pulpit");
                                        if(bool_buildingv_pulpit == true)
                                        {
                                            str_buildingv_pulpit = Storage.getInstance().readObject("buildingv_pulpit").toString();
                                            if(str_buildingv_pulpit.equals(""))
                                            {
                                                str_buildingv_pulpit = "0";
                                            }
                                        }
                                        else
                                        {
                                            str_buildingv_pulpit = "0";
                                        } 


                                        bool_buildingv_window  = Storage.getInstance().exists("buildingv_window");
                                        if(bool_buildingv_window == true)
                                        {
                                            str_buildingv_window = Storage.getInstance().readObject("buildingv_window").toString();
                                            if(str_buildingv_window.equals(""))
                                            {
                                                str_buildingv_window = "0";
                                            }
                                        }
                                        else
                                        {
                                            str_buildingv_window = "0";
                                        }
                                        
                                       
                                        double double_buildingv_roof = Double.parseDouble(str_buildingv_roof);
                                        double double_buildingv_premix = Double.parseDouble(str_buildingv_premix);
                                        double double_buildingv_wall = Double.parseDouble(str_buildingv_wall);
                                        double double_buildingv_elec = Double.parseDouble(str_buildingv_elec);
                                        double double_buildingv_plumb = Double.parseDouble(str_buildingv_plumb);
                                        double double_buildingv_pulpit = Double.parseDouble(str_buildingv_pulpit);
                                        double double_buildingv_window = Double.parseDouble(str_buildingv_window);
                                                        
                                        double double_buildingv_total = double_buildingv_roof+double_buildingv_premix+double_buildingv_wall+double_buildingv_elec+double_buildingv_plumb+double_buildingv_pulpit+double_buildingv_window;

                                        //System.out.println("Units X Amount = Total");
                                        //System.out.println(double_amount+" X "+int_num_of_units+" = "+double_buildingv_total);
                                        
                                        //Log.p("Setting total buildingv to "+"main_itemv_"+String.valueOf(i)+" textfield as String "+String.valueOf(double_buildingv_total)+" or String "+Double.toString(double_buildingv_total)+" "+Integer.parseInt(String.valueOf(double_buildingv_total)), 1);
                                        //txtf_main_itemv[i].setText(String.valueOf(double_buildingv_total));
                                        
                                        
                                        //int int_buildingv_total = Integer.parseInt(String.valueOf(double_buildingv_total));//Integer.parseInt(txtf_buildingv_roof.getText().trim())+Integer.parseInt(txtf_buildingv_premix.getText().trim()+Integer.parseInt(txtf_buildingv_wall.getText().trim())+Integer.parseInt(txtf_buildingv_elec.getText().trim())+Integer.parseInt(txtf_buildingv_plumb.getText().trim())+Integer.parseInt(txtf_buildingv_pulpit.getText().trim())+Integer.parseInt(txtf_buildingv_window.getText().trim()));
                                        
                                        System.out.println("Item "+lbl_remove_main_item.getName()+". "+txtac_main_item[Integer.parseInt(lbl_remove_main_item.getName())].getText().trim()+" -> Value: "+Double.toString(double_buildingv_total));
                                        txtf_main_itemv[Integer.parseInt(lbl_remove_main_item.getName())].setText(Double.toString(double_buildingv_total));
                                        
                                        Storage.getInstance().writeObject("main_item_"+String.valueOf(Integer.parseInt(lbl_remove_main_item.getName())), txtac_main_item[Integer.parseInt(lbl_remove_main_item.getName())].getText().trim());
                                        Storage.getInstance().writeObject("main_itemv_"+String.valueOf(Integer.parseInt(lbl_remove_main_item.getName())), txtf_main_itemv[Integer.parseInt(lbl_remove_main_item.getName())].getText().trim());

                                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                        System.out.println("Calling the Calculator method.");
                                        //doDhafu();

                                        try 
                                        {
                                            bool_no_main_items = Storage.getInstance().exists("no_main_items");
                                            if(bool_no_main_items == true)
                                            {
                                                str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                                                int_no_main_items = Integer.parseInt(str_no_main_items);

                                                int sum = 0;
                                                for (i = 0; i < int_no_main_items+1; i++)
                                                {
                                                  System.out.println("No of main items... "+str_no_main_items);
                                                  System.out.println("Reading... "+"main_itemv_"+i);
                                                  bool_main_item = Storage.getInstance().exists("main_itemv_"+i);
                                                  if(bool_main_item == true)
                                                  {
                                                      str_main_item = Storage.getInstance().readObject("main_itemv_"+i).toString();
                                                      if(str_main_item.equals("")){str_main_item = "0";}
                                                  }
                                                  else
                                                  {
                                                      str_main_item = "0";
                                                  }
                                                  System.out.println("..........."+"main_itemv_"+i+" = "+str_main_item);
                                                  //Integer n = Integer.parseInt(str_main_item);
                                                  Double n = Double.valueOf(str_main_item);

                                                  sum += n;
                                                }
                                                int_subtotals1 = sum;
                                                System.out.println("Sub total 1(Main Items): "+int_subtotals1);

                                                System.out.println("Total(Main Items): "+int_subtotals1);
                                                Storage.getInstance().writeObject("totals", int_subtotals1);
                                            }
                                            else
                                            {

                                            }
                                        } 
                                        catch (Exception e) 
                                        {
                                            System.out.println("Error: "+e);
                                            //e.printStackTrace();
                                        }

                                        System.out.println("-------------------------------------------");

                                        bool_no_new_items = Storage.getInstance().exists("no_new_items");
                                        if(bool_no_new_items == true)
                                        {
                                            str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                            int_no_new_items = Integer.parseInt(str_no_new_items);

                                            int sum = 0;
                                            for (i = 0; i < int_no_new_items; i++)
                                            {
                                              System.out.println("Reading... "+"new_itemv_"+i);
                                              str_item = Storage.getInstance().readObject("new_itemv_"+i).toString();
                                              if(str_item.equals("")){str_item = "0";}
                                              Integer n = Integer.parseInt(str_item);
                                              sum += n;
                                            }
                                            int_subtotals2 = sum;
                                            System.out.println("Sub total 2(Added Items): "+int_subtotals2);

                                            int_totals = int_subtotals1+int_subtotals2;
                                            System.out.println("Total Amount(Added Items): "+int_totals);
                                            Storage.getInstance().writeObject("totals", int_totals);
                                        }
                                        else
                                        {

                                        }


                                        System.out.println("-------------------------------------------");

                                        System.out.println("Setting new text to Items & Totals label on Screen. 6515");
                                        System.out.println("(Items: "+(int_no_main_items+int_no_new_items)+")   -   Kshs. "+int_totals);

                                            lbl_items.setText("(Items: "+(int_no_main_items+int_no_new_items)+")");
                                            lbl_totals.setText("   -   Kshs. "+int_totals);

                                        System.out.println("-------------------------------------------");
                                        System.out.println("-------------------------------------------");
                                        
                                }
                            });


                            dlg_building.add(BorderLayout.CENTER, cnt_building);
                            dlg_building.add(BorderLayout.SOUTH, BorderLayout.centerCenterEastWest(null, btn_yap, btn_nop));

                            dlg_building.show();
                            dlg_building.setDisposeWhenPointerOutOfBounds(false);

                        }
                    });
                }

                //txtf_main_itemv[i].setText(i+" "+lbl_removeBindu.getName());
                bool_main_itemv = Storage.getInstance().exists("main_itemv_"+lbl_remove_main_item.getName());
                if(bool_main_itemv == true)
                {
                   str_main_itemv = Storage.getInstance().readObject("main_itemv_"+lbl_remove_main_item.getName()).toString();
                   txtf_main_itemv[Integer.parseInt(lbl_remove_main_item.getName())].setText(str_main_itemv); 
                }
                else
                {
                    str_main_itemv = "";
                    txtf_main_itemv[Integer.parseInt(lbl_remove_main_item.getName())].setText(str_main_itemv);
                }

                txtf_main_itemv[Integer.parseInt(lbl_remove_main_item.getName())].addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println(i+" Selected is "+txtac_main_item[Integer.parseInt(lbl_remove_main_item.getName())].getName()+" i.e. "+txtac_main_item[Integer.parseInt(lbl_remove_main_item.getName())].getText()+" that has a value of "+txtf_main_itemv[Integer.parseInt(lbl_remove_main_item.getName())].getText().trim());
                        if(txtac_main_item[Integer.parseInt(lbl_remove_main_item.getName())].getText().trim().equals(""))
                        {
                            txtf_main_itemv[Integer.parseInt(lbl_remove_main_item.getName())].setText("");
                            Connect.okayDialog("Oops!!!", "Kindly fill in the name for "+txtac_main_item[Integer.parseInt(lbl_remove_main_item.getName())].getName()+" first.");   
                        }
                        else
                        {
                            Storage.getInstance().writeObject("main_item_"+lbl_remove_main_item.getName(), txtac_main_item[Integer.parseInt(lbl_remove_main_item.getName())].getText().trim());
                            Storage.getInstance().writeObject("main_itemv_"+lbl_remove_main_item.getName(), txtf_main_itemv[Integer.parseInt(lbl_remove_main_item.getName())].getText().trim());
                            Storage.getInstance().writeObject("main_itemid_"+lbl_remove_main_item.getName(), lbl_remove_main_item.getUIID());
                               
                            bool_itemop1 = Storage.getInstance().exists("main_itemop1_"+lbl_remove_main_item.getName());
                            if(bool_itemop1 == true)
                            {
                                if(Storage.getInstance().readObject("main_itemop1v_"+lbl_remove_main_item.getName()).toString().equals("") || Storage.getInstance().readObject("main_itemop1v_"+lbl_remove_main_item.getName()).toString().equals("0"))
                                {
                                    Storage.getInstance().writeObject("main_itemop1_"+lbl_remove_main_item.getName(), "N/a");
                                    Storage.getInstance().writeObject("main_itemop1v_"+lbl_remove_main_item.getName(), "0");
                                }
                                else
                                {
                                }
                            }
                            else
                            {
                                Storage.getInstance().writeObject("main_itemop1_"+lbl_remove_main_item.getName(), "N/a");
                                Storage.getInstance().writeObject("main_itemop1v_"+lbl_remove_main_item.getName(), "0");
                            }
                            
                            bool_itemop2 = Storage.getInstance().exists("main_itemop2_"+lbl_remove_main_item.getName());
                            if(bool_itemop2 == true)
                            {
                                if(Storage.getInstance().readObject("main_itemop2v_"+lbl_remove_main_item.getName()).toString().equals("") || Storage.getInstance().readObject("main_itemop2v_"+lbl_remove_main_item.getName()).toString().equals("0"))
                                {
                                    Storage.getInstance().writeObject("main_itemop2_"+lbl_remove_main_item.getName(), "N/a");
                                    Storage.getInstance().writeObject("main_itemop2v_"+lbl_remove_main_item.getName(), "0");
                                }
                                else
                                {
                                }
                            }
                            else
                            {
                                Storage.getInstance().writeObject("main_itemop2_"+lbl_remove_main_item.getName(), "N/a");
                                Storage.getInstance().writeObject("main_itemop2v_"+lbl_remove_main_item.getName(), "0");
                            }
                            
                            bool_itemop3 = Storage.getInstance().exists("main_itemop3_"+lbl_remove_main_item.getName());
                            if(bool_itemop3 == true)
                            {
                                if(Storage.getInstance().readObject("main_itemop3v_"+lbl_remove_main_item.getName()).toString().equals("") || Storage.getInstance().readObject("main_itemop3v_"+lbl_remove_main_item.getName()).toString().equals("0"))
                                {
                                    Storage.getInstance().writeObject("main_itemop3_"+lbl_remove_main_item.getName(), "N/a");
                                    Storage.getInstance().writeObject("main_itemop3v_"+lbl_remove_main_item.getName(), "0");
                                }
                                else
                                {
                                }
                            }
                            else
                            {
                                Storage.getInstance().writeObject("main_itemop3_"+lbl_remove_main_item.getName(), "N/a");
                                Storage.getInstance().writeObject("main_itemop3v_"+lbl_remove_main_item.getName(), "0");
                            }
                            
                            //cnt_items.removeComponent(txtac_new_item[Integer.parseInt(lbl_removeBindu.getName())]);
                            //cnt_items.removeComponent(txtf_main_itemv[Integer.parseInt(lbl_removeBindu.getName())]);
                            //cnt_items.removeComponent(lbl_removeBindu);

                            //System.out.println("Calling the Calculator method.");
                            //doDhafu();

                            try 
                            {
                                bool_no_main_items = Storage.getInstance().exists("no_main_items");
                                if(bool_no_main_items == true)
                                {
                                    str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                                    int_no_main_items = Integer.parseInt(str_no_main_items);
                                    
                                    System.err.println("no_main_items: "+int_no_main_items);

                                    int sum = 0;
                                    for (i = 0; i < int_no_main_items+2; i++)
                                    {
                                        System.out.println("No of main items... "+str_no_main_items);
                                        System.out.println("Reading... "+"main_itemv_"+i);
                                        bool_main_item = Storage.getInstance().exists("main_itemv_"+i);
                                        if(bool_main_item == true)
                                        {
                                            str_main_item = Storage.getInstance().readObject("main_itemv_"+i).toString();
                                            if(str_main_item.equals("")){str_main_item = "0";}
                                        }
                                        else
                                        {
                                            str_main_item = "0";
                                        }
                                        System.out.println("..........."+"main_itemv_"+i+" = "+str_main_item);
                                        //Integer n = Integer.parseInt(str_main_item);
                                        Double n = Double.valueOf(str_main_item);

                                        sum += n;
                                    }
                                    int_subtotals1 = sum;
                                    System.out.println("Sub total 1(Main Items): "+int_subtotals1);

                                    System.out.println("Total(Main Items): "+int_subtotals1);
                                    Storage.getInstance().writeObject("totals", int_subtotals1);
                                }
                                else
                                {

                                }
                            } 
                            catch (Exception e) 
                            {
                                System.out.println("Error: "+e);
                                //e.printStackTrace();
                            }

                            
                            
                            System.out.println("-------------------------------------------");

                            
                            
                            bool_no_new_items = Storage.getInstance().exists("no_new_items");
                            if(bool_no_new_items == true)
                            {
                                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                int_no_new_items = Integer.parseInt(str_no_new_items);

                                int sum = 0;
                                for (i = 0; i < int_no_new_items; i++)
                                {
                                  System.out.println("Reading... "+"new_itemv_"+i);
                                  str_item = Storage.getInstance().readObject("new_itemv_"+i).toString();
                                  if(str_item.equals("")){str_item = "0";}
                                  Integer n = Integer.parseInt(str_item);
                                  sum += n;
                                }
                                int_subtotals2 = sum;
                                System.out.println("Sub total 2(Added Items): "+int_subtotals2);

                                int_totals = int_subtotals1+int_subtotals2;
                                System.out.println("Total Amount(Added Items): "+int_totals);
                                Storage.getInstance().writeObject("totals", int_totals);
                            }
                            else
                            {

                            }


                            System.out.println("-------------------------------------------");

                            System.out.println("Setting new text to Items & Totals label on Screen. 6515");
                            System.out.println("(Items: "+((int_no_main_items+1)+int_no_new_items)+")   -   Kshs. "+int_totals);

                                lbl_items.setText("(Items: "+((int_no_main_items+1)+int_no_new_items)+")");
                                lbl_totals.setText("   -   Kshs. "+int_totals);

                            System.out.println("-------------------------------------------");
                            System.out.println("-------------------------------------------");
                        }
                    }
                });
                
                //TODO: Mo
                
                String str_priority = (String)obj.get("priority");
                if(str_priority.equals("1"))
                {
                    //System.out.println("No of Main items(All): "+obj_content.size());
                     System.out.println(i+". Populating main items Autocomplete list with: "+str_item_nm);
                     //System.out.println(">>>>>>>> "+lbl_remove_main_item.getName());
                    
                    if(i == 1)
                    {
                        Storage.getInstance().deleteStorageFile("no_main_items");
                    }
                    
                    bool_no_main_items = Storage.getInstance().exists("no_main_items");
                    if(bool_no_main_items == true)
                    {
                        str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                        int_no_main_items = Integer.parseInt(str_no_main_items);

                        System.out.println("The old no of main_items: "+str_no_main_items);

                        if(int_no_main_items >= 1)
                        {
                            Integer newcount;
                            newcount = int_no_main_items+1;
                            str_no_main_items = newcount.toString(); 

                            System.out.println("Updating "+str_no_main_items+" to item count in storage.");
                            Storage.getInstance().writeObject("no_main_items", str_no_main_items);
                        }
                        else
                        {
                            System.out.println("Updating 1 to item  count to storage.");
                            Storage.getInstance().writeObject("no_main_items", "1");
                        }
                    }
                    else
                    {
                            str_no_main_items = "0";
                            System.out.println("The old no of main_items: "+str_no_main_items);
                            System.out.println("Updating 1 to item  count to storage.");
                            Storage.getInstance().writeObject("no_main_items", "1");
                    }
                    
                    str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                    int_no_main_items = Integer.parseInt(str_no_main_items);
                    System.out.println("No of Main items(priority): "+int_no_main_items); //No of Main items(priority): 5
                    
                    System.out.println("--------------------------------------------"); 
                    
                    //Storage.getInstance().writeObject("main_item_"+i, (String)obj.get("name")); //"main_item_"+(obj_content.size()-1)
                    //Storage.getInstance().writeObject("main_itemv_"+i, "");//"main_item_"+(obj_content.size()-1)
                    
                    try 
                    {
                        bool_main_itemv = Storage.getInstance().exists("main_itemv_"+i);
                        if(bool_main_itemv == true)
                        {
                           str_main_itemv = Storage.getInstance().readObject("main_itemv_"+i).toString();
                           txtf_main_itemv[i].setText(str_main_itemv); 
                        }
                        else
                        {
                            str_main_itemv = "";
                            txtf_main_itemv[i].setText(str_main_itemv);
                        }

                        cnt_items.add(txtac_main_item[i]);
                        cnt_items.add(BorderLayout.centerAbsoluteEastWest(txtf_main_itemv[i], lbl_remove_main_item, null));
                    } 
                    catch (Exception e) 
                    {
                        System.out.println("Error: "+e);
                        //e.printStackTrace();
                    }
                }
                else
                {
                }
                
                i++;
            }
            
            Storage.getInstance().writeObject("main_item", "ziko");
            
        }
        catch(Exception e) 
        {
            System.out.println("Error @ main items: "+e);
            //e.printStackTrace();
        }
        
        
        
        try 
        {
            bool_no_new_items = Storage.getInstance().exists("no_new_items");
            if(bool_no_new_items == true)
            {
                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                int_no_new_items = Integer.parseInt(str_no_new_items);
                System.out.println("Number of Newly Added items: "+int_no_new_items);

                if(int_no_new_items >= 1)
                {
                }
                else
                {
                    Storage.getInstance().writeObject("no_new_items", "0");
                }
                
                txtac_new_item = new AutoCompleteTextField[int_no_new_items];
                txtf_new_itemv = new TextField[int_no_new_items];

                for (i=0; i < int_no_new_items; i++)
                {
                    int int_offset = i+1;
                    txtac_new_item[i] = new AutoCompleteTextField();
                    txtac_new_item[i].setMinimumElementsShownInPopup(5);
                    txtac_new_item[i].setMinimumLength(0);
                    txtac_new_item[i].setHint("New Item "+int_offset);
                    txtac_new_item[i].setName("new_item_"+i);
                    //txtac_new_item[i].set
                    txtac_new_item[i].setEditable(true);
                    txtac_new_item[i].setEnabled(true);
                    txtac_new_item[i].setLeftAndRightEditingTrigger(true);
                    txtac_new_item[i].setConstraint(TextField.INITIAL_CAPS_WORD);
                    txtac_new_item[i].getAllStyles().setMargin(0, 2, 2, 2);
                    txtac_new_item[i].getHintLabel().getStyle().setFgColor(0xC0C0C0, false); //0x888
                    txtac_new_item[i].getUnselectedStyle().setBgColor(0xf8f8f8);
                    txtac_new_item[i].getSelectedStyle().setBgColor(0xffffff);
                    txtac_new_item[i].getStyle().setFgColor(0xC0C0C0);
                    txtac_new_item[i].getStyle().setFont(font_medium_plain, false);
                    txtac_new_item[i].getHintLabel().getStyle().setFont(font_medium_plain, false);
                    txtac_new_item[i].getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                    txtac_new_item[i].getUnselectedStyle().getBorder().setThickness(3);
                    txtac_new_item[i].getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                    txtac_new_item[i].getSelectedStyle().getBorder().setThickness(3);
                    txtac_new_item[i].getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                    txtac_new_item[i].getPressedStyle().getBorder().setThickness(3);
                    if(Display.getInstance().getPlatformName().equals("ios")){txtac_new_item[i].getStyle().setBgTransparency(255);}

                    //TODO: Test with string buffer prefilled with the items and in advance instead of setting the completion herei n a loop.
                    bool_item = Storage.getInstance().exists("new_item_"+i);
                    if(bool_item == true)
                    {
                        str_item = Storage.getInstance().readObject("new_item_"+i).toString();
                        txtac_new_item[i].setText(str_item);
                    }

                    String str_json_read2 = (String) Storage.getInstance().readObject("products.json");
                    byte[] dataa2 = str_json_read2.getBytes();
                    JSONParser json2 = new JSONParser();
                    try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa2), "UTF-8"))
                    {
                        Map<String, Object> map_content = json.parseJSON(is_content);
                        java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");

                        sb_acoptions_new_item = new StringBuilder(); 
                        str_acoptions_new_item = new String[obj_content.size()];

                        j=0;
                        for(Map<String, Object> obj : obj_content) 
                        {   
                            //i=i+1;
                            System.out.println((i+1)+"."+j+". Populating new items Autocomplete list with: "+(String)obj.get("name"));
                            //txtac_item[i].setCompletion((String)obj.get("name"));
                            //sb_acoptions.append((String)obj.get("name"));
                            String str_priority = (String)obj.get("priority");
                            if(str_priority.equals("2"))
                            {
                                str_acoptions_new_item[j] = (String)obj.get("name");
                                //System.out.println("Autocomplete Items:... "+str_acoptions_new_item[j]);
                                sb_acoptions_new_item.append(str_acoptions_new_item[j]);
                            }
                            else
                            {
                                //str_acoptions[j] = (String)obj.get("name");
                            }

                            j++;
                        }
                        
                        System.out.println("Autocomplete Items:... "+sb_acoptions_new_item.toString());
                        System.out.println("Autocomplete No. of Items:... "+obj_content.size());
                        
                        txtac_new_item[i].setMinimumElementsShownInPopup(obj_content.size()); //obj_content.size()
                    }
                    catch(Exception e) 
                    {
                        System.out.println("Error @ New items lsit: "+e);
                        //e.printStackTrace();
                    }

                    //str_itemOptions = new String [] {"Thanks Giving", "Camp Offering", "Local Budget", "Children Ministry", "Women Ministry", "Youth Kitty", "AMO Fund", "Pathfinder Club", "Adventures Club", "Sabbath School", "Quarterly Lesson", "Msamaria Mwema", "Club Registration", "VBS ", "Personal Ministry", "Kuwinda", "Torosei", "Portluck"};
                    //txtac_item[i].setText(Arrays.toString(str_itemOptions));
                    //String str_itemsList = "Thanks Giving", "Camp Offering", "Local Budget", "Children Ministry", "Women Ministry", "Youth Kitty", "AMO Fund", "Pathfinder Club", "Adventures Club", "Sabbath School", "Quarterly Lesson", "Msamaria Mwema", "Club Registration", "VBS ", "Personal Ministry", "Kuwinda", "Torosei", "Portluck";
                    txtac_new_item[i].setCompletion(str_acoptions_new_item); //str_itemOptions //sb_acoptions.toString()
                    
                    
                    
                    System.out.println("i = "+i);

                    txtf_new_itemv[i] = new TextField();
                    //txtf_itemv[i].setText(str_item);
                    txtf_new_itemv[i].setHint("0");
                    txtf_new_itemv[i].setName("new_itemv_"+i);
                    txtf_new_itemv[i].setConstraint(TextField.NUMERIC);
                    txtf_new_itemv[i].getAllStyles().setMargin(0, 2, 2, 2);
                    txtf_new_itemv[i].getHintLabel().getStyle().setFgColor(0xC0C0C0, false); //0x888
                    txtf_new_itemv[i].getUnselectedStyle().setBgColor(0xf8f8f8);
                    txtf_new_itemv[i].getSelectedStyle().setBgColor(0xffffff);
                    txtf_new_itemv[i].getStyle().setFgColor(0xC0C0C0);
                    txtf_new_itemv[i].getHintLabel().getStyle().setFont(font_medium_plain, false);
                    txtf_new_itemv[i].getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                    txtf_new_itemv[i].getUnselectedStyle().getBorder().setThickness(3);
                    txtf_new_itemv[i].getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                    txtf_new_itemv[i].getSelectedStyle().getBorder().setThickness(3);
                    txtf_new_itemv[i].getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
                    txtf_new_itemv[i].getPressedStyle().getBorder().setThickness(3);
                    if(Display.getInstance().getPlatformName().equals("ios")){txtf_new_itemv[i].getStyle().setBgTransparency(255);}

                    bool_itemv = Storage.getInstance().exists("new_itemv_"+i);
                    if(bool_itemv == true)
                    {
                       str_itemv = Storage.getInstance().readObject("new_itemv_"+i).toString();
                       txtf_new_itemv[i].setText(str_itemv); 
                    }
                    else
                    {
                        str_itemv = "";
                        txtf_new_itemv[i].setText(str_itemv);
                    }

                    Label lbl_remove_new_item = new Label(theme.getImage("remove.png"));
                    lbl_remove_new_item.setName(String.valueOf(i)); //"new_itemv_"+int_offset
                    lbl_remove_new_item.addPointerPressedListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                                System.out.println("Remove label "+lbl_remove_new_item.getName()+" pressed.");

                                if(txtac_new_item[Integer.parseInt(lbl_remove_new_item.getName())].getText().trim().equals(""))
                                {
                                    str_new_item_nme = txtac_new_item[Integer.parseInt(lbl_remove_new_item.getName())].getHint();
                                }
                                else
                                {
                                    str_new_item_nme = txtac_new_item[Integer.parseInt(lbl_remove_new_item.getName())].getText().trim();
                                }

                                if(txtf_new_itemv[Integer.parseInt(lbl_remove_new_item.getName())].getText().trim().equals(""))
                                {
                                    str_new_item_val = "0";
                                }
                                else
                                {
                                    str_new_item_val = txtf_new_itemv[Integer.parseInt(lbl_remove_new_item.getName())].getText();
                                }

                                System.out.println("Removing Item "+lbl_remove_new_item.getName()+" from screen i.e. "+str_new_item_nme+" whose value is "+str_new_item_val);

                                cnt_items.removeComponent(txtac_new_item[Integer.parseInt(lbl_remove_new_item.getName())]);
                                cnt_items.removeComponent(txtf_new_itemv[Integer.parseInt(lbl_remove_new_item.getName())]);


                                System.out.println("Deleting item "+lbl_remove_new_item.getName()+" from screen i.e. "+str_new_item_nme+" whose value is "+str_new_item_val);

                                Storage.getInstance().deleteStorageFile("new_item_"+Integer.parseInt(lbl_remove_new_item.getName())); 
                                Storage.getInstance().deleteStorageFile("new_itemv_"+Integer.parseInt(lbl_remove_new_item.getName())); 

                                //txtac_item[i].remove();
                                //txtf_itemv[i].remove();

                                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                                int_no_new_items = Integer.parseInt(str_no_new_items);
                                int_newno_items = int_no_new_items-1;

                                if(int_no_new_items > 1)
                                {
                                    Storage.getInstance().writeObject("no_new_items", int_newno_items);
                                }
                                else
                                {
                                    Storage.getInstance().deleteStorageFile("no_new_items");
                                }


                                bool_totals = Storage.getInstance().exists("totals");
                                if(bool_totals == true)
                                {
                                    System.out.println("Subtrating deleted item from totals");
                                    str_totals = Storage.getInstance().readObject("totals").toString();
                                    int_totals = Integer.parseInt(str_totals);
                                    if(int_totals > 0)
                                    {
                                        int_new_totals = int_totals - Integer.parseInt(str_new_item_val);
                                        Storage.getInstance().writeObject("totals", int_new_totals);
                                        System.out.println("Old Total - Value = New Total");
                                        System.out.println(int_totals+" - "+str_new_item_val+" = "+int_new_totals);
                                    }
                                    else
                                    {

                                    }
                                }
                                else
                                {

                                }

                                //TODO: Remove this and use a refresh technique instead of a reload one.
                                dlg_payments2.dispose();
                                try 
                                {
                                    showPayDialog2();

                                } 
                                catch (Exception ex) 
                                {
                                    System.err.println("Error: "+ex);
                                }
                        }
                    });
                    
                    txtac_new_item[i].addPointerPressedListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            //lbl_remove_main_item.setName(String.valueOf(i))
                            showAddNewItem_dialog("new_item_"+lbl_remove_new_item.getName(), lbl_remove_new_item.getName());
                        }
                    });


                    txtf_new_itemv[Integer.parseInt(lbl_remove_new_item.getName())].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            
                        }
                    });
                    
                    txtf_new_itemv[i].addPointerPressedListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            //lbl_remove_main_item.setName(String.valueOf(i))
                            showAddNewItem_dialog("new_item_"+lbl_remove_new_item.getName(), lbl_remove_new_item.getName());
                        }
                    });

                    if(int_no_new_items >= 1)
                    {
                        cnt_items.add(txtac_new_item[i]);
                        cnt_items.add(BorderLayout.centerAbsoluteEastWest(txtf_new_itemv[i], lbl_remove_new_item, null));
                    }
                }
            }
            else
            {
                Storage.getInstance().writeObject("no_new_items", "0");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: "+e);
            //e.printStackTrace();
        }    
    }
    
    String[] searchLocations(String text) 
    {        
        try 
        {
            if(text.length() > 0) 
            {
                //ConnectionRequest connReq = new ConnectionRequest();
                //connReq.setPost(false);
                //connReq.setUrl("https://maps.googleapis.com/maps/api/place/autocomplete/json");
                //connReq.addArgument("key", apiKey);
                //connReq.addArgument("input", text);
                
                //NetworkManager.getInstance().addToQueueAndWait(connReq);
                //Map<String,Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(connReq.getResponseData()), "UTF-8"));
                //String[] res = Result.fromContent(result).getAsStringArray("//description");
                
                //return res;              
                
                // (populate the request object here)
                Hashtable hash = new Hashtable();
                hash.put("parameter1", "search");
                hash.put("parameter2", text);
               
                // convert the object to a JSON document
                final String payload = Result.fromContent(hash).toString();

                // override, by default this method writes NVPs.
                ConnectionRequest req = new ConnectionRequest() 
                {
                    @Override //Handles a server response code that is not 200 and not a redirect.
                    protected void handleErrorResponseCode(int code, String message) 
                    {

                    }

                    //Log.p("Handles an exception thrown when performing a network operation", l);
                    @Override
                    protected void handleException(Exception err) 
                    {

                    }

                    @Override
                    protected void postResponse() 
                    {

                    }
                    protected void buildRequestBody(OutputStream os) throws IOException 
                    {
                        os.write(payload.getBytes("UTF-8"));
                    }
                };
                
                try 
                {
                    req.setPost(true);
                    req.setUrl(str_host+"search"); System.out.println("Calling search url: "+req.getUrl()); //http://localhost/ChurchApp/search
                    req.setContentType("application/json");
                    req.addRequestHeader("Accept", "application/json");
                    NetworkManager.getInstance().addToQueue(req);


                    NetworkManager.getInstance().addToQueueAndWait(req);
                    Map<String,Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));
                    //String[] res = Result.fromContent(result).getAsStringArray("//name");
                    String[] res = Result.fromContent(result).getAsStringArray("//name");

                    return res;    
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        } 
        catch(Exception err) 
        {
            Log.e(err);
        }
        return null;
    }
    
    private void doSetMemberData()
    {
        FileSystemStorage inst = FileSystemStorage.getInstance();
        final String homePath = inst.getAppHomePath();
        final char sep = inst.getFileSystemSeparator();
        
        str_listcriteria = "members";
            
        final String str_filepath = homePath+sep+str_listcriteria+".txt";

        try 
        {
            InputStream is = inst.openInputStream(str_filepath);
            byte[] b = Util.readInputStream(is);
            str_listcontent = new String(b); //SystBem.out.println("Content..: "+str_content);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: "+e);
            //e.printStackTrace();
        }

        String str_json_read = str_listcontent;
        byte[] dataa = str_json_read.getBytes();

        JSONParser json = new JSONParser();
        
        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
        {
            Map<String, Object> map_content = json.parseJSON(is_content);
            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");
            System.out.println("No of Members 4:---------> "+obj_content.size()); 

            i = 0;
            for(Map<String, Object> obj : obj_content) 
            {
                if(str_users_title == null || str_users_title.length() == 0){}else{}

                
                str_users_memnos = Storage.getInstance().readObject("memnos").toString();
                Log.p("Looping through looking for member number "+str_users_memnos, 1);
                
                if(str_users_memnos.equals((String)obj.get("member_no")))
                {
//                    JSONObject jsonobject = jarray_omcdata.getJSONObject(i);
//                    String str_OMCName = jsonobject.getString("OMCName"); 
//                    if(jsonobject.has("DepotName") == true)
//                    {
//                        str_DepotName = jsonobject.getString("DepotName"); 
//                    }
//                    else
//                    {
//                        str_DepotName = "Hurlingham"; 
//                    }
                            
                    try 
                    {
                        //String name = (String)obj.putIfAbsent(un, val_);
                        
                        
//                        V v = map.get(key);
//                        if (v == null)
//                        {
//                                v = map.put(key, value);
//                        }
                        
                        str_users_firstname = (String)obj.get("firstname");
                        str_users_lastname = (String)obj.get("lastname");
                        

                        //txtf_memberno.setText(str_users_memnos);
                        txtf_firstname.setText(str_users_firstname);
                        txtf_lastname.setText(str_users_lastname);
                        
                        
                        
                        if(map_content.get("phone").equals("n/a"))
                        {
                            txtf_phone.setText("n/a");
                        }
                        else
                        {
                            txtf_phone.setText(str_users_phone); //HERE
                        }
                        
                        if(map_content.get("email").equals("n/a"))
                        {
                            txtf_email.setText("n/a");
                        }
                        else
                        {
                            txtf_email.setText(str_users_email);
                        }
                        
                        if(map_content.get("family_id").equals("n/a"))
                        {
                            str_users_family_id = (String)obj.get("family_id");
                        }
                        else
                        {
                            str_users_family_id = (String)obj.get("family_id");
                        }
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                }
                
                if(str_users_memnos.equals(str_users_family_id))
                {

                }
                
                
            i = i+1;                
            }
        } 
        catch(IOException err) 
        {
                Log.p("Search error occured: "+err, 1);
        }
    }
    
    private void showFamMembersDlg()
    {
        Dialog dlg_fam = new Dialog();
        dlg_fam.setLayout(new BorderLayout());
        
        btn_close = new Button(theme.getImage("cancel.png")); //ifont_close
        btn_close.setUIID("Label");
        btn_close.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Storage.getInstance().deleteStorageFile("acc_open");
                dlg_fam.dispose();
            }
        });
        
        btn_minimise = new Button(theme.getImage("minimise.png")); //ifont_close
        btn_minimise.setUIID("Label");
        btn_minimise.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_fam.dispose();
            }
        }); 
           
        SpanButton sbtn_title = new SpanButton("Select Family Recipient");
        sbtn_title.getAllStyles().setPadding(0, 0, 0, 0);
        sbtn_title.getAllStyles().setMargin(0, 0, 0, 0);
        
        dlg_fam.add(BorderLayout.NORTH, BorderLayout.centerAbsoluteEastWest(sbtn_title, null, null)); //btn_close, btn_minimise
        
        cnt_fam = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_fam.getAllStyles().setBorder(Border.createEmpty());
        cnt_fam.getAllStyles().setBackgroundType(BACKGROUND_NONE);
        cnt_fam.getAllStyles().setBgTransparency(255);
        cnt_fam.getAllStyles().setBgColor(0x006064);
        cnt_fam.getAllStyles().setBorder(null);
        
        cnt_fam.removeAll();
        cnt_fam.remove();
        
        FileSystemStorage inst = FileSystemStorage.getInstance();
        final String homePath = inst.getAppHomePath();
        final char sep = inst.getFileSystemSeparator();

        str_listcriteria = "members";

        final String str_filepath = homePath+sep+str_listcriteria+".txt";

        try 
        {
            InputStream is = inst.openInputStream(str_filepath);
            byte[] b = Util.readInputStream(is);
            str_listcontent = new String(b); //SystBem.out.println("Content..: "+str_content);
        } 
        catch (Exception e) 
        {
            System.out.println("Error: "+e);
            //e.printStackTrace();
        }

        String str_json_read = str_listcontent;
        byte[] dataa = str_json_read.getBytes();

        JSONParser json = new JSONParser();
        json.setIncludeNullsInstance(true);
        json.setStrict(true);

        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
        {
            Map<String, Object> map_content = json.parseJSON(is_content);
            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");
            //System.out.println("No of Members:---------> "+obj_content.size()); 

            cb_fam = new CheckBox[obj_content.size()];
            acc_member = new Accordion[obj_content.size()];
            
            i = 0;
            for(Map<String, Object> obj : obj_content) 
            { 
                try 
                {
                    str_id = (String)obj.get("id").toString().trim();
                    str_name = (String)obj.get("name").toString().trim();
                    str_fname = (String)obj.get("firstname").toString().trim();
                    str_mname = (String)obj.get("middlename").toString().trim();
                    str_oname = (String)obj.get("other_name").toString().trim();
                    str_lname = (String)obj.get("lastname").toString().trim();
                    str_gender = (String)obj.get("gender").toString().trim();
                    str_memno = (String)obj.get("member_no").toString().trim();
                    str_family_id = (String)obj.get("family_id").toString().trim();
                    str_spouse_id = (String)obj.get("spouse").toString().trim();
                    str_phone = (String)obj.get("phone").toString().trim();
                    str_email = (String)obj.get("email").toString().trim();
                    str_department = (String)obj.get("department").toString().trim();
                    
                    System.out.println(" <<< str_id: "+str_id+" str_name: "+str_name+" str_fname: "+str_fname+" str_mname: "+str_mname+" str_lname: "+str_lname+" str_gender: "+str_gender+" str_memno: "+str_memno+" str_family_id: "+str_family_id+" str_spouse_id: "+str_spouse_id+" str_phone: "+str_phone+" str_email: "+str_email+" str_department: "+str_department);
                } 
                catch (Exception e) 
                {
                    System.err.println(" <<< str_id: "+str_id+" str_name: "+str_name+" str_fname: "+str_fname+" str_mname: "+str_mname+" str_lname: "+str_lname+" str_gender: "+str_gender+" str_memno: "+str_memno+" str_family_id: "+str_family_id+" str_spouse_id: "+str_spouse_id+" str_phone: "+str_phone+" str_email: "+str_email+" str_department: "+str_department);
                    Log.p("Error: "+e, 3);
                }
                
                
                Label lbl_memberno = new Label(str_memno);
                lbl_memberno.setName(String.valueOf(i));
                lbl_memberno.setUIID(str_fname+" "+str_lname);
                lbl_memberno.setMaskName(lbl_memberno.getText()+","+lbl_memberno.getUIID()+","+str_department+","+str_phone+","+str_email+","+str_family_id+","+str_spouse_id+","+"duplicate");
                //lbl_department.getAllStyles().setPadding(0, 15, 0, 0);
                lbl_memberno.getAllStyles().setAlignment(LEFT);
                lbl_memberno.getAllStyles().setFont(font_HPSimplified);
                lbl_memberno.getAllStyles().setFgColor(0x000000, false);
                lbl_memberno.getAllStyles().setBgColor(0xffffff, false);
                lbl_memberno.getAllStyles().setBgTransparency(0, false);
                
                //bool_family_id = Storage.getInstance()
                str_temp_family_id = Storage.getInstance().readObject("temp_family_id").toString();
                //str_temp_spouse_id = Storage.getInstance().readObject("temp_spouse_id").toString();
                //str_temp_gender = Storage.getInstance().readObject("temp_gender").toString();
                
                if(str_temp_family_id.equals(str_family_id) && !str_family_id.equals(""))
                {                   

                    cb_fam[i] = new CheckBox();
                    if(str_spouse_id.equals(""))
                    {
                        cb_fam[i].setText(str_name);
                    }
                    else
                    {
                        cb_fam[i].setText(str_name+"(S)");
                        //str_temp_spouse_id
                        //if(str_temp_gender.toLowerCase().equals("male"))
                        //{
                        //    cb_fam[i].setText(str_name+"(S)");
                        //}
                        //else
                        //{
                        //    cb_fam[i].setText(str_name+"(S)");
                        //}
                    }
                    
                    cb_fam[i].setUIID(str_memno);
                    //cb_fam[i].setGrabsPointerEvents(true);
                    cb_fam[i].setBlockLead(true);
                    //cb_fam[i].setHandlesInput(true);
                    //cb_fam[i].setIgnorePointerEvents(true);
                    //cb_fam[i].setTraversable(false);
                    cb_fam[i].setName(lbl_memberno.getText());
                    cb_fam[i].setUIID(lbl_memberno.getUIID());
                    cb_fam[i].setTextPosition(LEFT);
                    cb_fam[i].getAllStyles().setAlignment(LEFT);
                    cb_fam[i].setEnabled(true);
                    cb_fam[i].getAllStyles().setMargin(0, 0, 0, 0);
                    cb_fam[i].setTextPosition(LEFT);
                    //cb_box[i].setGap((int)(5.5 * pixelsPerMM));
                    cb_fam[i].getAllStyles().setAlignment(CENTER);
                    cb_fam[i].setVerticalAlignment(CENTER);
                    //checkBox.isOppositeSide();
                    //checkBox.getStyle().setFont(font);
                    //cb_fam[i].getStyle().setFgColor(0x5555ff);
                    //cb_fam[i].getStyle().setBgTransparency(1);
                    //checkBox.setPreferredSize(new Dimension(100, 2));
                    //checkBox.setShiftText(-3);
                    cb_fam[i].setTactileTouch(true); 
                    //checkBox.getStyle().setBgColor(0xdddd99);
                    cb_fam[i].addActionListener(new ActionListener()//cb_member.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent evt)
                        {
                            bool_selected = cb_fam[Integer.parseInt(lbl_memberno.getName())].isSelected();
                            if(bool_selected == true)
                            {
                                Log.p("Checkbox selected: "+i+" >> "+lbl_memberno.getName()+" "+lbl_memberno.getUIID()+" "+cb_fam[Integer.parseInt(lbl_memberno.getName())].getPropertyValue("phone"), 1);
                                bool_recp_items = Storage.getInstance().exists("no_recp_items");
                                if(bool_recp_items == true)
                                {
                                    str_no_recp_items = Storage.getInstance().readObject("no_recp_items").toString();
                                    int_no_recp_items = Integer.parseInt(str_no_recp_items);
                                    System.out.println("No of family recipients: "+int_no_recp_items);
                                    
                                    if(int_no_recp_items >= 1)
                                    {
                                        Integer newcount;
                                        newcount = int_no_recp_items+1;
                                        str_no_recp_items = newcount.toString();

                                        System.out.println("Updating "+str_no_recp_items+" to family recipients count in storage.");
                                        Storage.getInstance().writeObject("no_recp_items", str_no_recp_items);
                                        
                                        bool_recp_items = Storage.getInstance().exists("recp_items");
                                        if(bool_recp_items == true)
                                        {
                                            str_recp_items = Storage.getInstance().readObject("recp_items").toString();
                                            System.out.println("Reading recp_items from storage:... "+str_recp_items);
                                        }
                                        else
                                        {
                                            str_recp_items = "";
                                            System.out.println("Setting recp_items to:... "+"null");  
                                        }
                                           
                                        str_recp_item = lbl_memberno.getMaskName();
                                        System.out.println("Adding recp_item to string builder:... "+str_recp_item+"|");
                                        
                                        sb_recp_item = new StringBuilder();
					sb_recp_item.append(str_recp_items).append(str_recp_item+"|");
                                                                                
                                        System.out.println("Writing recp_item to storage:... "+sb_recp_item.toString());
                                        Storage.getInstance().writeObject("recp_items", sb_recp_item.toString());
                                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                    }
                                    else
                                    {
                                        System.out.println("Updating 1 to family recipients count to storage.");
                                        Storage.getInstance().writeObject("no_recp_items", "1");
                                        
                                        str_recp_item = lbl_memberno.getMaskName();
                                        
                                        System.out.println("Writing recp_item to storage:... "+str_recp_item+"|");
                                        Storage.getInstance().writeObject("recp_items", str_recp_item+"|");
                                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                    }
                                }
                                else
                                {
                                        System.out.println("Updating 1 to family recipients count to storage.");
                                        Storage.getInstance().writeObject("no_recp_items", "1");
                                        
                                        str_recp_item = lbl_memberno.getMaskName();
                                        
                                        System.out.println("Writing recp_item to storage:... "+str_recp_item+"|");
                                        Storage.getInstance().writeObject("recp_items", str_recp_item+"|");
                                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                }                                
                                
                                System.out.println("Writing "+"recp_item_"+lbl_memberno.getName()+" to storage: "+lbl_memberno.getMaskName());
                                Storage.getInstance().writeObject("recp_item_"+lbl_memberno.getName(), lbl_memberno.getMaskName()); //lbl_memberno.getText()+","+lbl_memberno.getUIID()+","+lbl_memberno.getPropertyValue("department")+","+lbl_memberno.getPropertyValue("phone")+","+lbl_memberno.getPropertyValue("email") 
                            }
                            else
                            {
                                Log.p("Checkbox unselected: "+i+" << "+lbl_memberno.getName()+" "+lbl_memberno.getUIID()+"\n", 1);
                                bool_recp_items = Storage.getInstance().exists("no_recp_items");
                                if(bool_recp_items == true)
                                {
                                    str_no_recp_items = Storage.getInstance().readObject("no_recp_items").toString();
                                    int_no_recp_items = Integer.parseInt(str_no_recp_items);
                                    System.out.println("No of family recipients: "+int_no_recp_items);
                                    
                                    int_newno_recp_items = int_no_recp_items-1;
                                    
                                    if(int_no_recp_items > 1)
                                    {
                                        System.out.println("Decrementing by 1 family recipients count to storage.");
                                        Storage.getInstance().writeObject("no_recp_items", int_newno_recp_items);
                                        
                                        str_recp_item = lbl_memberno.getMaskName();
                                
                                        sb_recp_item = new StringBuilder();

                                        System.out.println("Removing recp_item from string builder:... "+str_recp_item);
                                        str_recp_items = Storage.getInstance().readObject("recp_items").toString();

                                        //str_new_memsel = StringUtil.tokenize(str_memsel, '|').get(int_no_memsel);
                                        str_new_memsel = StringUtil.replaceAll(str_recp_items, str_recp_item+"|", "");

                                        System.out.println("Writing new recp_items to storage:... "+str_new_memsel);
                                        Storage.getInstance().writeObject("recp_items", str_new_memsel);

                                        System.out.println("Deleting "+"recp_item_"+lbl_memberno.getName()+" from storage: "+lbl_memberno.getMaskName());
                                        Storage.getInstance().deleteStorageFile("recp_item_"+lbl_memberno.getName());
                                    }
                                    else
                                    {
                                        System.out.println("Deleting no of recipients from storage.");
                                        Storage.getInstance().deleteStorageFile("no_recp_items");
                                    }
                                }
                                else
                                {
                                        System.out.println("Decrementing by 1 family recipients count to storage.");
                                        Storage.getInstance().writeObject("no_recp_items", "1");
                                }
                            }
                        }
                    });
                    
                    //bool_lastaccopen = Storage.getInstance().exists("acc_open");
                    //if(bool_lastaccopen == false)
                    //{
                    //    Storage.getInstance().deleteStorageFile("recp_item_"+lbl_memberno.getName());
                    //}
                    
                    
                    bool_recp_items = Storage.getInstance().exists("recp_item_"+lbl_memberno.getName());
                    if(bool_recp_items == true)
                    {
                        cb_fam[i].setSelected(true);
                    }
                    else
                    {
                    }

                    acc_member[i] = new Accordion();
                    acc_member[i].setName(String.valueOf(i));
                    //acc_member[i].setGrabsPointerEvents(false);
                    //acc_member[i].setBlockLead(false);
                    //acc_member[i].setHandlesInput(false);
                    //acc_member[i].setIgnorePointerEvents(true);
                    //acc_member[i].setTraversable(false);
                    acc_member[i].setAutoClose(true);
                    //acc_member[i].setScrollableY(false);
                    acc_member[i].addContent(FlowLayout.encloseLeftMiddle(cb_fam[i]), new SpanLabel("Memn: "+str_memno+"\nPhone: "+str_phone+"\nDeptm: "+str_department));
                    acc_member[i].addOnClickItemListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            bool_lastaccopen = Storage.getInstance().exists("acc_open");
                            if(bool_lastaccopen == true)
                            {
                                str_lastaccopen = Storage.getInstance().readObject("acc_open").toString();
                                
                                System.err.println("Accordion clicked: "+lbl_memberno.getName());
                                System.err.println("Accordion clicked: "+acc_member[Integer.parseInt(lbl_memberno.getName())].getName());
                                System.err.println("Accordion clicked: "+str_lastaccopen);
                                
                                acc_member[Integer.parseInt(str_lastaccopen)].collapse(acc_member[Integer.parseInt(str_lastaccopen)].getCurrentlyExpanded());
                                
                                /*if(acc_member[Integer.parseInt(str_lastaccopen)].getCurrentlyExpanded().getName().equals(str_lastaccopen))
                                {
                                }
                                else
                                {
                                    acc_member[Integer.parseInt(lbl_memberno.getName())].collapse(acc_member[Integer.parseInt(str_lastaccopen)].getCurrentlyExpanded());
                                }*/
                                
                                //acc_member[Integer.parseInt(lbl_memberno.getName())].collapse(acc_member[Integer.parseInt(lbl_memberno.getName())].getCurrentlyExpanded());
                                
                                if(str_lastaccopen.equals(lbl_memberno.getName()))
                                {
                                    Storage.getInstance().deleteStorageFile("acc_open");
                                }
                                else
                                {
                                    Storage.getInstance().writeObject("acc_open", lbl_memberno.getName());
                                }
                            }
                            else
                            {
                                Storage.getInstance().writeObject("acc_open", lbl_memberno.getName());
                            }
                                                        
                            dlg_fam.growOrShrink();
                        }
                    });
                    
                   
                    /*acc_member[i].addContent("Item3", BoxLayout.encloseY(new Label("Label"), new TextField(), new Button("Button"), new CheckBox("CheckBox")));*/

                    if(!txtf_memberno.getText().equals(str_memno))
                    {
                        Log.p("Adding family to auctocomplete options "+i+". Name: "+(String)obj.get("name").toString().trim()+" (MemNos: "+(String)obj.get("member_no").toString().trim()+") "+str_temp_family_id.trim(), 1);
                        cnt_fam.add(acc_member[i]);
                    }
                }
                else
                {
                }
                
                i++;                
            }
        } 
        catch(IOException err) 
        {
                Log.p("Search error occured: "+err, 1);
        }
        
        dlg_fam.addShowListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("Dialiog showListener fired.", 1);
            }
        });
        
        dlg_fam.add(BorderLayout.CENTER, cnt_fam);
        dlg_fam.setDisposeWhenPointerOutOfBounds(true);
        dlg_fam.setScrollableY(true);
        //dlg_fam.
        dlg_fam.setPopupDirectionBiasPortrait(true);
        //dlg_fam.showPacked(BorderLayout.CENTER, true);
        //dlg_fam.setPreferredW(dlg_payments.getWidth());
        dlg_fam.show();
        
    }
    
    private void AddNewItem()
    {
        System.out.println("Add label pressed.");
        System.out.println("Showing add new item popup dialog.");

        str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
        int_no_new_items = Integer.parseInt(str_no_new_items);

        System.out.println("The old no of new_items: "+str_no_new_items);

        if(int_no_new_items >= 1)
        {
            //str_loginCount = lcount+1;
            Integer newcount;
            newcount = int_no_new_items+1;
            str_no_new_items = newcount.toString(); 

            //Save to local storgage
            //str_contactid = "contactid"+str_contactid
            System.out.println("Writing "+str_no_new_items+" item counts to storage.");
            Storage.getInstance().writeObject("no_new_items", str_no_new_items);

            System.out.println("The new no of items: "+str_no_new_items);

            Storage.getInstance().writeObject("new_item_"+(Integer.parseInt(str_no_new_items)-1), ""); //int_no_new_items-1
            Storage.getInstance().writeObject("new_itemv_"+(Integer.parseInt(str_no_new_items)-1), "");//int_no_new_items-1
            
            str_kitukipya = "new_item_"+(Integer.parseInt(str_no_new_items)-1);
            str_kitukipya_id = String.valueOf(Integer.parseInt(str_no_new_items)-1);
        }
        else
        {
            System.out.println("Writing 1 item count to storage.");
            Storage.getInstance().writeObject("no_new_items", "1");

            System.out.println("The new no of items: 1");

            Storage.getInstance().writeObject("new_item_"+0, "");
            Storage.getInstance().writeObject("new_itemv_"+0, "");
            
            str_kitukipya = "new_item_"+0;
            str_kitukipya_id = String.valueOf(0);
        }

        //TODO: Here get the data from the main items form and write to sotage.
        /*
        */

        System.out.println("------------------------------------");

        //dlg_payments2.dispose();
        //showPayDialog2();
        System.out.println("Calling the Calculator method.");
        //doDhafu();

        try 
        {
            bool_no_main_items = Storage.getInstance().exists("no_main_items");
            if(bool_no_main_items == true)
            {
                str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                int_no_main_items = Integer.parseInt(str_no_main_items);

                int sum = 0;
                for (i = 0; i < int_no_main_items+1; i++)
                {
                  System.out.println("No of main items... "+str_no_main_items);
                  System.out.println("Reading... "+"main_itemv_"+i);
                  bool_main_item = Storage.getInstance().exists("main_itemv_"+i);
                  if(bool_main_item == true)
                  {
                      str_main_item = Storage.getInstance().readObject("main_itemv_"+i).toString();
                      if(str_main_item.equals("")){str_main_item = "0";}
                  }
                  else
                  {
                      str_main_item = "0";
                  }
                  System.out.println("..........."+"main_itemv_"+i+" = "+str_main_item);
                  //Integer n = Integer.parseInt(str_main_item);
                  Double n = Double.valueOf(str_main_item);

                  sum += n;
                }
                int_subtotals1 = sum;
                System.out.println("Sub total 1(Main Items): "+int_subtotals1);

                System.out.println("Total(Main Items): "+int_subtotals1);
                Storage.getInstance().writeObject("totals", int_subtotals1);
            }
            else
            {

            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: "+e);
            //e.printStackTrace();
        }

        System.out.println("-------------------------------------------");

        bool_no_new_items = Storage.getInstance().exists("no_new_items");
        if(bool_no_new_items == true)
        {
            str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
            int_no_new_items = Integer.parseInt(str_no_new_items);

            int sum = 0;
            for (i = 0; i < int_no_new_items; i++)
            {
              System.out.println("Reading... "+"new_itemv_"+i);
              str_item = Storage.getInstance().readObject("new_itemv_"+i).toString();
              if(str_item.equals("")){str_item = "0";}
              Integer n = Integer.parseInt(str_item);
              sum += n;
            }
            int_subtotals2 = sum;
            System.out.println("Sub total 2(Added Items): "+int_subtotals2);

            int_totals = int_subtotals1+int_subtotals2;
            System.out.println("Total Amount(Added Items): "+int_totals);
            Storage.getInstance().writeObject("totals", int_totals);
        }
        else
        {

        }


        System.out.println("-------------------------------------------");

        System.out.println("Setting new text to Items & Totals label on Screen. 6515");
        System.out.println("(Items: "+((int_no_main_items+1)+int_no_new_items)+")   -   Kshs. "+int_totals);

            lbl_items.setText("(Items: "+((int_no_main_items+1)+int_no_new_items)+")");
            lbl_totals.setText("   -   Kshs. "+int_totals);


            Storage.getInstance().writeObject("no_itemsel", int_no_main_items+int_no_new_items);

        System.out.println("-------------------------------------------");
        System.out.println("-------------------------------------------");
        
        showAddNewItem_dialog(str_kitukipya, str_kitukipya_id);

        
    }
    
    private void showAddNewItem_dialog(String str_kitukipya, String str_kitukipya_id)
    {
        Dialog dlg_newItem = new Dialog();
        dlg_newItem.setLayout(new BorderLayout());

        SpanButton sbtn_title = new SpanButton("Create New Item");
        sbtn_title.getAllStyles().setPadding(0, 0, 0, 0);
        sbtn_title.getAllStyles().setMargin(0, 0, 0, 0);
        
        String str_newItem_name = "";
                
        int int_offset = Integer.parseInt(str_kitukipya_id)+1;
        AutoCompleteTextField txtac_item = new AutoCompleteTextField();
        txtac_item.setEditable(false);
        //txtac_item.setMinimumElementsShownInPopup(5);  //Implemented Below
        txtac_item.setMinimumLength(0);
        txtac_item.setHint("Item Name"); //"New Item "+int_offset
        txtac_item.setName("new_item_"+str_kitukipya_id);
        txtac_item.setEditable(true); //false
        txtac_item.setEnabled(true);
        txtac_item.setLeftAndRightEditingTrigger(true);
        txtac_item.setConstraint(TextField.INITIAL_CAPS_WORD);
        txtac_item.getAllStyles().setMargin(0, 2, 2, 2);
        txtac_item.getHintLabel().getStyle().setFgColor(0xC0C0C0, false); //0x888
        txtac_item.getUnselectedStyle().setBgColor(0xf8f8f8);
        txtac_item.getSelectedStyle().setBgColor(0xffffff);
        txtac_item.getStyle().setFgColor(0xC0C0C0);
        //txtac_item.getStyle().setFont(font_large_plain, false);
        //txtac_item.getHintLabel().getStyle().setFont(font_large_plain, false);
        txtac_item.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
        txtac_item.getUnselectedStyle().getBorder().setThickness(3);
        txtac_item.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
        txtac_item.getSelectedStyle().getBorder().setThickness(3);
        txtac_item.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xddd, false)); 
        txtac_item.getPressedStyle().getBorder().setThickness(3);
        if(Display.getInstance().getPlatformName().equals("ios")){txtac_item.getStyle().setBgTransparency(255);}
        txtac_item.setUIID("Label");

        //TODO: Test with string buffer prefilled with the items and in advance instead of setting the completion herei n a loop.
        bool_item = Storage.getInstance().exists("new_item_"+str_kitukipya_id);
        if(bool_item == true)
        {
            str_item = Storage.getInstance().readObject("new_item_"+str_kitukipya_id).toString();
            txtac_item.setText(str_item);
        }
        
            
        String str_json_read2 = (String) Storage.getInstance().readObject("products.json");
        byte[] dataa2 = str_json_read2.getBytes();
        JSONParser json2 = new JSONParser();
        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa2), "UTF-8"))
        {
            Map<String, Object> map_content = json2.parseJSON(is_content);
            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");

            txtac_item.setMinimumElementsShownInPopup(15); //obj_content.size()
            
            sb_acoptions_new_item = new StringBuilder(); 
            str_acoptions_new_item = new String[obj_content.size()];
            

            j=0;
            for(Map<String, Object> obj : obj_content) 
            {   
                //i=i+1;
                System.out.println(j+". Populating new items Autocomplete list with: "+(String)obj.get("name"));
                //txtac_item[i].setCompletion((String)obj.get("name"));
                //sb_acoptions.append((String)obj.get("name"));
                String str_priority = (String)obj.get("priority");
                if(str_priority.equals("2")){}else{}
                
                str_acoptions_new_item[j] = (String)obj.get("name");
                //System.out.println("Autocomplete Items:... "+str_acoptions_new_item[j]);
                sb_acoptions_new_item.append(str_acoptions_new_item[j]);
                
                j++;
            }

            System.out.println("Autocomplete Items:... "+sb_acoptions_new_item.toString());
            System.out.println("Autocomplete No. of Items:... "+obj_content.size());

            txtac_item.setMinimumElementsShownInPopup(obj_content.size()); //obj_content.size()
        }
        catch(Exception e) 
        {
            System.out.println("Error @ New items lsit: "+e);
            //e.printStackTrace();
        }

        //str_itemOptions = new String [] {"Thanks Giving", "Camp Offering", "Local Budget", "Children Ministry", "Women Ministry", "Youth Kitty", "AMO Fund", "Pathfinder Club", "Adventures Club", "Sabbath School", "Quarterly Lesson", "Msamaria Mwema", "Club Registration", "VBS ", "Personal Ministry", "Kuwinda", "Torosei", "Portluck"};
        //txtac_item[i].setText(Arrays.toString(str_itemOptions));
        //String str_itemsList = "Thanks Giving", "Camp Offering", "Local Budget", "Children Ministry", "Women Ministry", "Youth Kitty", "AMO Fund", "Pathfinder Club", "Adventures Club", "Sabbath School", "Quarterly Lesson", "Msamaria Mwema", "Club Registration", "VBS ", "Personal Ministry", "Kuwinda", "Torosei", "Portluck";
        txtac_item.setCompletion(str_acoptions_new_item); //str_itemOptions //sb_acoptions.toString()

        
        TextArea txta_description = new TextArea();
        txta_description.setText("");
        txta_description.setHint("Description");
        txta_description.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txta_description.setGrowByContent(true);
        txta_description.setSingleLineTextArea(false);
        txta_description.setEditable(true);
        txta_description.setFocusable(true);
        txta_description.setUIID("Label");
        
        bool_itemv = Storage.getInstance().exists("new_itemv_"+str_kitukipya_id);
        if(bool_itemv == true)
        {
            bool_itemd = Storage.getInstance().exists("new_itemd_"+str_kitukipya_id);
            if(bool_itemd == true)
            {
                str_itemd = Storage.getInstance().readObject("new_itemd_"+str_kitukipya_id).toString();
                txta_description.setText(str_itemd);
            }
        }
        
        TextArea txta_amount = new TextArea();
        txta_amount.setText("");
        txta_amount.setHint("Amount");
        txta_amount.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
        txta_amount.setGrowByContent(true);
        txta_amount.setSingleLineTextArea(false);
        txta_amount.setEditable(true);
        txta_amount.setFocusable(true);
        txta_amount.setUIID("Label");
        
        bool_itemv = Storage.getInstance().exists("new_itemv_"+str_kitukipya_id);
        if(bool_itemv == true)
        {
            str_itemv = Storage.getInstance().readObject("new_itemv_"+str_kitukipya_id).toString();
            txta_amount.setText(str_itemv);
        }
        
        Button btn_cancel = new Button("Clear");
        //btn_cancel.setUIID("Label");
        btn_cancel.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_newItem.dispose();

                System.out.println("Remove label "+str_kitukipya_id+" pressed.");

                if(txtac_item.getText().trim().equals(""))
                {
                    str_new_item_nme = txtac_item.getHint();
                }
                else
                {
                    str_new_item_nme = txtac_item.getText().trim();
                }

                if(txta_amount.getText().trim().equals(""))
                {
                    str_new_item_val = "0";
                }
                else
                {
                    str_new_item_val = txta_amount.getText();
                }

                System.out.println("Removing Item "+str_kitukipya_id+" from screen i.e. "+str_new_item_nme+" whose value is "+str_new_item_val);

                cnt_items.removeComponent(txtac_new_item[Integer.parseInt(str_kitukipya_id)]);
                cnt_items.removeComponent(txtf_new_itemv[Integer.parseInt(str_kitukipya_id)]);


                System.out.println("Deleting item "+str_kitukipya_id+" from screen i.e. "+str_new_item_nme+" whose value is "+str_new_item_val);

                Storage.getInstance().deleteStorageFile("new_item_"+Integer.parseInt(str_kitukipya_id)); 
                Storage.getInstance().deleteStorageFile("new_itemv_"+Integer.parseInt(str_kitukipya_id)); 

                //txtac_item[i].remove();
                //txtf_itemv[i].remove();

                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                int_no_new_items = Integer.parseInt(str_no_new_items);
                int_newno_items = int_no_new_items-1;

                if(int_no_new_items > 1)
                {
                    Storage.getInstance().writeObject("no_new_items", int_newno_items);
                }
                else
                {
                    Storage.getInstance().deleteStorageFile("no_new_items");
                }


                bool_totals = Storage.getInstance().exists("totals");
                if(bool_totals == true)
                {
                    System.out.println("Subtrating deleted item from totals");
                    str_totals = Storage.getInstance().readObject("totals").toString();
                    int_totals = Integer.parseInt(str_totals);
                    if(int_totals > 0)
                    {
                        int_new_totals = int_totals - Integer.parseInt(str_new_item_val);
                        Storage.getInstance().writeObject("totals", int_new_totals);
                        System.out.println("Old Total - Value = New Total");
                        System.out.println(int_totals+" - "+str_new_item_val+" = "+int_new_totals);
                    }
                    else
                    {

                    }
                }
                else
                {

                }


                //TODO: Remove this and use a refresh technique instead of a reload one.
                dlg_payments2.dispose();
                try 
                {
                    showPayDialog2();

                } 
                catch (Exception ex) 
                {
                    System.err.println("Error: "+ex);
                }
            }
        });

        Button btn_confirm = new Button("Keep");
        //btn_confirm.setUIID("Label");
        btn_confirm.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                   dlg_newItem.dispose();
                   //addItems();
                   
                   System.out.println("Selected is "+txtac_item.getHint()+" that has a value of "+txtac_item.getText().trim());
                    if(txtac_item.getText().trim().equals(""))
                    {
                        txtac_item.setText("");
                        Connect.okayDialog("Oops!!!", "Kindly fill in the name for "+txtac_item.getHint()+" first.");   
                    }
                    else if(txta_amount.getText().trim().equals(""))
                    {
                        Connect.okayDialog("Oops!", "You must enter a value for "+txtac_item.getText().trim()+".");
                    }
                    else if(txta_description.getText().trim().equals(""))
                    {
                        Connect.okayDialog("Oops!", "You must enter a description for "+txtac_item.getText().trim()+".");
                    }
                    else
                    {
                        Storage.getInstance().writeObject("new_item_"+str_kitukipya_id, txtac_item.getText().trim());
                        Storage.getInstance().writeObject("new_itemv_"+str_kitukipya_id, txta_amount.getText().trim());
                        Storage.getInstance().writeObject("new_itemd_"+str_kitukipya_id, txta_description.getText().trim());
                                                
                        //System.out.println("Calling the Calculator method.");
                        //doDhafu();

                        try 
                        {
                            bool_no_main_items = Storage.getInstance().exists("no_main_items");
                            if(bool_no_main_items == true)
                            {
                                str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
                                int_no_main_items = Integer.parseInt(str_no_main_items);

                                int sum = 0;
                                for (i = 0; i < int_no_main_items+1; i++)
                                {
                                  System.out.println("No of main items... "+str_no_main_items);
                                  System.out.println("Reading... "+"main_itemv_"+i);
                                  bool_main_item = Storage.getInstance().exists("main_itemv_"+i);
                                  if(bool_main_item == true)
                                  {
                                      str_main_item = Storage.getInstance().readObject("main_itemv_"+i).toString();
                                      if(str_main_item.equals("")){str_main_item = "0";}
                                  }
                                  else
                                  {
                                      str_main_item = "0";
                                  }
                                  System.out.println("..........."+"main_itemv_"+i+" = "+str_main_item);
                                  //Integer n = Integer.parseInt(str_main_item);
                                  Double n = Double.valueOf(str_main_item);

                                  sum += n;
                                }
                                int_subtotals1 = sum;
                                System.out.println("Sub total 1(Main Items): "+int_subtotals1);

                                System.out.println("Total(Main Items): "+int_subtotals1);
                                Storage.getInstance().writeObject("totals", int_subtotals1);
                            }
                            else
                            {

                            }
                        } 
                        catch (Exception e) 
                        {
                            System.out.println("Error: "+e);
                            //e.printStackTrace();
                        }



                        System.out.println("-------------------------------------------");



                        bool_no_new_items = Storage.getInstance().exists("no_new_items");
                        if(bool_no_new_items == true)
                        {
                            str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                            int_no_new_items = Integer.parseInt(str_no_new_items);

                            int sum = 0;
                            for (i = 0; i < int_no_new_items; i++)
                            {
                              System.out.println("Reading... "+"new_itemv_"+i);
                              str_item = Storage.getInstance().readObject("new_itemv_"+i).toString();
                              if(str_item.equals("")){str_item = "0";}
                              Integer n = Integer.parseInt(str_item);
                              sum += n;
                            }
                            int_subtotals2 = sum;
                            System.out.println("Sub total 2(Added Items): "+int_subtotals2);

                            int_totals = int_subtotals1+int_subtotals2;
                            System.out.println("Total Amount(Added Items): "+int_totals);
                            Storage.getInstance().writeObject("totals", int_totals);
                        }
                        else
                        {

                        }


                        System.out.println("-------------------------------------------");

                        System.out.println("Setting new text to Items & Totals label on Screen. 6515");
                        System.out.println("(Items: "+((int_no_main_items+1)+int_no_new_items)+")   -   Kshs. "+int_totals);

                        lbl_items.setText("(Items: "+((int_no_main_items+1)+int_no_new_items)+")");
                        lbl_totals.setText("   -   Kshs. "+int_totals);

                        System.out.println("-------------------------------------------");
                        System.out.println("-------------------------------------------");
                        
                        dlg_payments2.dispose();
                        showPayDialog2();
                    }
            }
        });

        btn_close = new Button(theme.getImage("cancel.png")); //ifont_close
        btn_close.setUIID("Label");
        btn_close.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_newItem.dispose();
                
                System.out.println("close button "+str_kitukipya_id+" pressed.");

                if(txtac_item.getText().trim().equals(""))
                {
                    str_new_item_nme = txtac_item.getHint();
                }
                else
                {
                    str_new_item_nme = txtac_item.getText().trim();
                }

                if(txta_amount.getText().trim().equals(""))
                {
                    str_new_item_val = "0";
                }
                else
                {
                    str_new_item_val = txta_amount.getText();
                }

                System.out.println("Removing Item "+str_kitukipya_id+" from screen i.e. "+str_new_item_nme+" whose value is "+str_new_item_val);

                //cnt_items.removeComponent(txtac_new_item[Integer.parseInt(str_kitukipya_id)]);
                //cnt_items.removeComponent(txtf_new_itemv[Integer.parseInt(str_kitukipya_id)]);


                System.out.println("Deleting item "+str_kitukipya_id+" from screen i.e. "+str_new_item_nme+" whose value is "+str_new_item_val);

                Storage.getInstance().deleteStorageFile("new_item_"+Integer.parseInt(str_kitukipya_id)); 
                Storage.getInstance().deleteStorageFile("new_itemv_"+Integer.parseInt(str_kitukipya_id)); 

                //txtac_item[i].remove();
                //txtf_itemv[i].remove();

                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                int_no_new_items = Integer.parseInt(str_no_new_items);
                int_newno_items = int_no_new_items-1;

                if(int_no_new_items > 1)
                {
                    Storage.getInstance().writeObject("no_new_items", int_newno_items);
                }
                else
                {
                    Storage.getInstance().deleteStorageFile("no_new_items");
                }


                bool_totals = Storage.getInstance().exists("totals");
                if(bool_totals == true)
                {
                    System.out.println("Subtrating deleted item from totals");
                    str_totals = Storage.getInstance().readObject("totals").toString();
                    int_totals = Integer.parseInt(str_totals);
                    if(int_totals > 0)
                    {
                        int_new_totals = int_totals - Integer.parseInt(str_new_item_val);
                        Storage.getInstance().writeObject("totals", int_new_totals);
                        System.out.println("Old Total - Value = New Total");
                        System.out.println(int_totals+" - "+str_new_item_val+" = "+int_new_totals);
                    }
                    else
                    {

                    }
                }
                else
                {

                }


                //TODO: Remove this and use a refresh technique instead of a reload one.
                dlg_payments2.dispose();
                try 
                {
                    showPayDialog2();

                } 
                catch (Exception ex) 
                {
                    System.err.println("Error: "+ex);
                }

            }
        });

        btn_minimise = new Button(theme.getImage("minimise.png")); //ifont_close
        btn_minimise.setUIID("Label");
        btn_minimise.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_newItem.dispose();
                
                System.out.println("close button "+str_kitukipya_id+" pressed.");

                if(txtac_item.getText().trim().equals(""))
                {
                    str_new_item_nme = txtac_item.getHint();
                }
                else
                {
                    str_new_item_nme = txtac_item.getText().trim();
                }

                if(txta_amount.getText().trim().equals(""))
                {
                    str_new_item_val = "0";
                }
                else
                {
                    str_new_item_val = txta_amount.getText();
                }

                System.out.println("Removing Item "+str_kitukipya_id+" from screen i.e. "+str_new_item_nme+" whose value is "+str_new_item_val);

                //cnt_items.removeComponent(txtac_new_item[Integer.parseInt(str_kitukipya_id)]);
                //cnt_items.removeComponent(txtf_new_itemv[Integer.parseInt(str_kitukipya_id)]);


                System.out.println("Deleting item "+str_kitukipya_id+" from screen i.e. "+str_new_item_nme+" whose value is "+str_new_item_val);

                Storage.getInstance().deleteStorageFile("new_item_"+Integer.parseInt(str_kitukipya_id)); 
                Storage.getInstance().deleteStorageFile("new_itemv_"+Integer.parseInt(str_kitukipya_id)); 

                //txtac_item[i].remove();
                //txtf_itemv[i].remove();

                str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
                int_no_new_items = Integer.parseInt(str_no_new_items);
                int_newno_items = int_no_new_items-1;

                if(int_no_new_items > 1)
                {
                    Storage.getInstance().writeObject("no_new_items", int_newno_items);
                }
                else
                {
                    Storage.getInstance().deleteStorageFile("no_new_items");
                }


                bool_totals = Storage.getInstance().exists("totals");
                if(bool_totals == true)
                {
                    System.out.println("Subtrating deleted item from totals");
                    str_totals = Storage.getInstance().readObject("totals").toString();
                    int_totals = Integer.parseInt(str_totals);
                    if(int_totals > 0)
                    {
                        int_new_totals = int_totals - Integer.parseInt(str_new_item_val);
                        Storage.getInstance().writeObject("totals", int_new_totals);
                        System.out.println("Old Total - Value = New Total");
                        System.out.println(int_totals+" - "+str_new_item_val+" = "+int_new_totals);
                    }
                    else
                    {

                    }
                }
                else
                {

                }


                //TODO: Remove this and use a refresh technique instead of a reload one.
                dlg_payments2.dispose();
                try 
                {
                    showPayDialog2();

                } 
                catch (Exception ex) 
                {
                    System.err.println("Error: "+ex);
                }

            }
        });

        //showAddNewItem_dialog();

        dlg_newItem.add(BorderLayout.NORTH, BorderLayout.centerAbsoluteEastWest(sbtn_title, null, null)); //btn_close, btn_minimise
        dlg_newItem.add(BorderLayout.CENTER, BorderLayout.centerAbsoluteEastWest(BoxLayout.encloseY(txtac_item, txta_description, txta_amount), null, null));
        dlg_newItem.add(BorderLayout.SOUTH, BorderLayout.centerAbsoluteEastWest(null, btn_confirm, btn_cancel));
        
        dlg_newItem.setAutoDispose(false);
        dlg_newItem.show();
    }
    
    private void showBreakDownForm()
    {
        Dialog dlg_breakdown = new Dialog();
        //dlg_breakdown.setTitle("Set Allocation Breakdown");
        
        dlg_breakdown.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        dlg_breakdown.getStyle().setAlignment(CENTER);
        dlg_breakdown.setScrollableY(false);
        
        Button btn_min;
        Label lbl_value;
        Label lbl_units;
        Button btn_add;
        
        btn_close = new Button(theme.getImage("cancel.png")); //ifont_close
        btn_close.setUIID("Label");
        btn_close.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_breakdown.dispose();
            }
        });
        
        btn_minimise = new Button(theme.getImage("minimise.png")); //ifont_close
        btn_minimise.setUIID("Label");
        btn_minimise.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_breakdown.dispose();
            }
        }); 
                          
        
        
        SpanButton sbtn_title = new SpanButton("Set Allocation Breakdown");
        sbtn_title.getAllStyles().setPadding(0, 0, 0, 0);
        sbtn_title.getAllStyles().setMargin(0, 0, 0, 0);
        
        Label lbl_cash_coins_den = new Label("Denomination"); lbl_cash_coins_den.getAllStyles().setFgColor(0x000, false);
        Label lbl_cash_coins_unt = new Label("     Units"); lbl_cash_coins_unt.getAllStyles().setFgColor(0x000, false); lbl_cash_coins_unt.getAllStyles().setAlignment(LEFT);
        Label lbl_cahs_coins_val = new Label("Value"); lbl_cahs_coins_val.getAllStyles().setFgColor(0x000, false);
        
        Label lbl_cash_notes_den = new Label("Denomination"); lbl_cash_notes_den.getAllStyles().setFgColor(0x000, false);
        Label lbl_cash_notes_unt = new Label("     Units"); lbl_cash_notes_unt.getAllStyles().setFgColor(0x000, false); lbl_cash_notes_unt.getAllStyles().setAlignment(LEFT);
        Label lbl_cahs_notes_val = new Label("Value"); lbl_cahs_notes_val.getAllStyles().setFgColor(0x000, false);
        
        TableLayout laytab = new TableLayout(1, 3);
        
        cnt_brkdwn_coins = new Container(); //new GridLayout(8, 3)
        cnt_brkdwn_coins.setScrollableY(true);
        //cnt_brkdwn_coins.getStyle().setPadding((int)(5.0 * pixelsPerMM), 0, (int)(2.0 * pixelsPerMM), (int)(2.0 * pixelsPerMM)); //25, 0, 60, 60
        cnt_brkdwn_coins.setLayout(laytab);
        //cnt_brkdwn.addComponent(new Label(""));
        //cnt_brkdwn.addComponent(new Label(""));
        //cnt_brkdwn.addComponent(FlowLayout.encloseRightMiddle(btn_close));
        cnt_brkdwn_coins.addComponent(FlowLayout.encloseCenterMiddle(lbl_cash_coins_den));
        cnt_brkdwn_coins.addComponent(FlowLayout.encloseCenterMiddle(lbl_cash_coins_unt));
        cnt_brkdwn_coins.addComponent(FlowLayout.encloseCenterMiddle(lbl_cahs_coins_val));
        
        cnt_brkdwn_notes = new Container(); //new GridLayout(8, 3)
        cnt_brkdwn_notes.setScrollableY(true);
        //cnt_brkdwn_notes.getStyle().setPadding((int)(5.0 * pixelsPerMM), 0, 0, 0); //25, 0, 60, 60
        cnt_brkdwn_notes.setLayout(laytab);
        cnt_brkdwn_notes.addComponent(FlowLayout.encloseCenterMiddle(lbl_cash_notes_den));
        cnt_brkdwn_notes.addComponent(FlowLayout.encloseCenterMiddle(lbl_cash_notes_unt));
        cnt_brkdwn_notes.addComponent(FlowLayout.encloseCenterMiddle(lbl_cahs_notes_val));
        cnt_brkdwn_notes.add("No data");

          lbl_0_5 = new Label();
          lbl_0_5.setIcon(theme.getImage("50_cents_coin_ke.png"));
          lbl_0_5.setText("0.5");
          lbl_0_5.setTextPosition(RIGHT);
          lbl_0_5.getAllStyles().setAlignment(LEFT);
          lbl_0_5.getAllStyles().setFgColor(0x000000);
          lbl_0_5.getAllStyles().setFont(font_medium_plain);
          lbl_0_5.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_0_5.getAllStyles().setMargin(0, 0, 0, 0);
          txf_0_5  = new TextField("", 6);
          txf_0_5 .setConstraint(TextField.NUMERIC);
          txf_0_5.setFocusable(true);
          txf_0_5.getAllStyles().setPadding(0, 0, 0, 0);
          txf_0_5.getAllStyles().setMargin(0, 0, 0, 0);
          txf_0_5.getAllStyles().setPadding(0, 0, 0, 0);
          txf_0_5.getAllStyles().setMargin(0, 0, 0, 0);
          lbl_0_5v = new Label("");
          lbl_0_5v.getStyle().setFont(font_medium_plain);
          lbl_0_5v.getAllStyles().setAlignment(LEFT);
          lbl_0_5v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_0_5v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_coins.addComponent(lbl_0_5);
          cnt_brkdwn_coins.addComponent(txf_0_5);
          cnt_brkdwn_coins.addComponent(lbl_0_5v);

          lbl_1 = new Label();
          lbl_1.setIcon(theme.getImage("1_shilling_coin_ke.png"));
          lbl_1.setText("1");
          lbl_1.setTextPosition(RIGHT);
          lbl_1.getAllStyles().setAlignment(LEFT);
          lbl_1.getAllStyles().setFgColor(0x000000);
          lbl_1.getStyle().setFont(font_medium_plain);
          txf_1 = new TextField("", 6);
          txf_1.setConstraint(TextField.NUMERIC);
          txf_1.setFocusable(true);
          lbl_1v = new Label("");
          lbl_1v.getStyle().setFont(font_medium_plain);
          lbl_1v.getAllStyles().setAlignment(LEFT);
          lbl_1.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_1.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_coins.addComponent(lbl_1);
          cnt_brkdwn_coins.addComponent(txf_1);
          cnt_brkdwn_coins.addComponent(lbl_1v);

          lbl_5 = new Label();
          lbl_5.setIcon(theme.getImage("5_shillings_coin_ke.png"));
          lbl_5.setText("5");
          lbl_5.setTextPosition(RIGHT);
          lbl_5.getAllStyles().setAlignment(LEFT);
          lbl_5.getAllStyles().setFgColor(0x000000);
          lbl_5.getAllStyles().setFont(font_medium_plain);
          lbl_5.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_5.getAllStyles().setMargin(0, 0, 0, 0);
          txf_5 = new TextField("", 6);
          txf_5.setConstraint(TextField.NUMERIC);
          txf_5.setFocusable(true);
          txf_5.getAllStyles().setPadding(0, 0, 0, 0);
          txf_5.getAllStyles().setMargin(0, 0, 0, 0);
          lbl_5v = new Label("");
          lbl_5v.getAllStyles().setAlignment(LEFT);
          lbl_5v.getStyle().setFont(font_medium_plain);
          lbl_5v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_5v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_coins.addComponent(lbl_5);
          cnt_brkdwn_coins.addComponent(txf_5);
          cnt_brkdwn_coins.addComponent(lbl_5v);

          lbl_10 = new Label("");
          lbl_10.setIcon(theme.getImage("10_shillings_coin_ke.png"));
          lbl_10.setText("10");
          lbl_10.getAllStyles().setAlignment(LEFT);
          lbl_10.setTextPosition(RIGHT);
          lbl_10.getAllStyles().setFgColor(0x000000);
          lbl_10.getStyle().setFont(font_medium_plain);
          txf_10 = new TextField("", 6);
          txf_10.setConstraint(TextField.NUMERIC);
          txf_10.setFocusable(true);
          lbl_10v = new Label("");
          lbl_10v.getAllStyles().setAlignment(LEFT);
          lbl_10v.getStyle().setFont(font_medium_plain);
          lbl_10v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_10v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_coins.addComponent(lbl_10);
          cnt_brkdwn_coins.addComponent(txf_10);
          cnt_brkdwn_coins.addComponent(lbl_10v);

          lbl_20 = new Label();
          lbl_20.setIcon(theme.getImage("20_shillings_coin_ke.png"));
          lbl_20.setText("20");
          lbl_20.getAllStyles().setAlignment(LEFT);
          lbl_20.setTextPosition(RIGHT);
          lbl_20.getAllStyles().setFgColor(0x000000);
          lbl_20.getStyle().setFont(font_medium_plain);
          txf_20 = new TextField("", 6);
          txf_20.setConstraint(TextField.NUMERIC);
          txf_20.setFocusable(true);
          lbl_20v = new Label("");
          lbl_20v.getAllStyles().setAlignment(LEFT);
          lbl_20v.getStyle().setFont(font_medium_plain);
          lbl_20v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_20v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_coins.addComponent(lbl_20);
          cnt_brkdwn_coins.addComponent(txf_20);
          cnt_brkdwn_coins.addComponent(lbl_20v);

          lbl_40 = new Label();
          lbl_40.setText("40");
          lbl_40.setTextPosition(RIGHT);
          lbl_40.getAllStyles().setAlignment(LEFT);
          lbl_40.setIcon(theme.getImage("40_shillings_coin_ke.jpg"));
          lbl_40.getAllStyles().setFgColor(0x000000);
          lbl_40.getStyle().setFont(font_medium_plain);
          txf_40 = new TextField("", 6);
          txf_40.setConstraint(TextField.NUMERIC);
          txf_40.setFocusable(true);
          lbl_40v = new Label("");
          lbl_40v.getAllStyles().setAlignment(LEFT);
          lbl_40v.getStyle().setFont(font_medium_plain);
          lbl_40v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_40v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_coins.addComponent(lbl_40);
          cnt_brkdwn_coins.addComponent(txf_40);
          cnt_brkdwn_coins.addComponent(lbl_40v);
          
          
          
          
          //--------> NOTES//
          //
          
          //lbl_20 = new Label();
          //lbl_20.setIcon(theme.getImage("20_shillings_note_ke.png"));
          //lbl_20.setText("0.5");
          //lbl_20.setTextPosition(RIGHT);
          //lbl_20.getAllStyles().setAlignment(LEFT);
          //lbl_20.getAllStyles().setFgColor(0x000000);
          //lbl_20.getAllStyles().setFont(font_medium_plain);
          //lbl_20.getAllStyles().setPadding(0, 0, 0, 0);
          //lbl_20.getAllStyles().setMargin(0, 0, 0, 0);
          //txf_20  = new TextField("", 6);
          //txf_20.setConstraint(TextField.NUMERIC);
          //txf_20.setFocusable(true);
          //txf_20.getAllStyles().setPadding(0, 0, 0, 0);
          //txf_20.getAllStyles().setMargin(0, 0, 0, 0);
          //txf_20.getAllStyles().setPadding(0, 0, 0, 0);
          //txf_20.getAllStyles().setMargin(0, 0, 0, 0);
          //lbl_20v = new Label("");
          //lbl_20v.getStyle().setFont(font_medium_plain);
          //lbl_20v.getAllStyles().setAlignment(LEFT);
          //lbl_20v.getAllStyles().setPadding(0, 0, 0, 0);
          //lbl_20v.getAllStyles().setMargin(0, 0, 0, 0);
          //cnt_brkdwn_notes.addComponent(lbl_20);
          //cnt_brkdwn_notes.addComponent(txf_20);
          //cnt_brkdwn_notes.addComponent(lbl_20v);
          
          lbl_50 = new Label();
          lbl_50.setIcon(theme.getImage("1_shilling_note_ke.png"));
          lbl_50.setText("1");
          lbl_50.setTextPosition(RIGHT);
          lbl_50.getAllStyles().setAlignment(LEFT);
          lbl_50.getAllStyles().setFgColor(0x000000);
          lbl_50.getStyle().setFont(font_medium_plain);
          txf_50 = new TextField("", 6);
          txf_50.setConstraint(TextField.NUMERIC);
          txf_50.setFocusable(true);
          lbl_50v = new Label("");
          lbl_50v.getStyle().setFont(font_medium_plain);
          lbl_50v.getAllStyles().setAlignment(LEFT);
          lbl_50.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_50.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_notes.addComponent(lbl_50);
          cnt_brkdwn_notes.addComponent(txf_50);
          cnt_brkdwn_notes.addComponent(lbl_50v);

          lbl_100 = new Label();
          lbl_100.setIcon(theme.getImage("5_shillings_note_ke.png"));
          lbl_100.setText("5");
          lbl_100.setTextPosition(RIGHT);
          lbl_100.getAllStyles().setAlignment(LEFT);
          lbl_100.getAllStyles().setFgColor(0x000000);
          lbl_100.getAllStyles().setFont(font_medium_plain);
          lbl_100.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_100.getAllStyles().setMargin(0, 0, 0, 0);
          txf_100 = new TextField("", 6);
          txf_100.setConstraint(TextField.NUMERIC);
          txf_100.setFocusable(true);
          txf_100.getAllStyles().setPadding(0, 0, 0, 0);
          txf_100.getAllStyles().setMargin(0, 0, 0, 0);
          lbl_100v = new Label("");
          lbl_100v.getAllStyles().setAlignment(LEFT);
          lbl_100v.getStyle().setFont(font_medium_plain);
          lbl_100v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_100v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_notes.addComponent(lbl_100);
          cnt_brkdwn_notes.addComponent(txf_100);
          cnt_brkdwn_notes.addComponent(lbl_100v);

          lbl_200 = new Label("");
          lbl_200.setIcon(theme.getImage("10_shillings_note_ke.png"));
          lbl_200.setText("10");
          lbl_200.getAllStyles().setAlignment(LEFT);
          lbl_200.setTextPosition(RIGHT);
          lbl_200.getAllStyles().setFgColor(0x000000);
          lbl_200.getStyle().setFont(font_medium_plain);
          txf_200 = new TextField("", 6);
          txf_200.setConstraint(TextField.NUMERIC);
          txf_200.setFocusable(true);
          lbl_200v = new Label("");
          lbl_200v.getAllStyles().setAlignment(LEFT);
          lbl_200v.getStyle().setFont(font_medium_plain);
          lbl_200v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_200v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_notes.addComponent(lbl_200);
          cnt_brkdwn_notes.addComponent(txf_200);
          cnt_brkdwn_notes.addComponent(lbl_200v);

          lbl_500 = new Label();
          lbl_500.setIcon(theme.getImage("500_shillings_note_ke.png"));
          lbl_500.setText("500");
          lbl_500.getAllStyles().setAlignment(LEFT);
          lbl_500.setTextPosition(RIGHT);
          lbl_500.getAllStyles().setFgColor(0x000000);
          lbl_500.getStyle().setFont(font_medium_plain);
          txf_500 = new TextField("", 6);
          txf_500.setConstraint(TextField.NUMERIC);
          txf_500.setFocusable(true);
          lbl_500v = new Label("");
          lbl_500v.getAllStyles().setAlignment(LEFT);
          lbl_500v.getStyle().setFont(font_medium_plain);
          lbl_500v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_500v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_notes.addComponent(lbl_500);
          cnt_brkdwn_notes.addComponent(txf_500);
          cnt_brkdwn_notes.addComponent(lbl_500v);

          lbl_1000 = new Label();
          lbl_1000.setText("40");
          lbl_1000.setTextPosition(RIGHT);
          lbl_1000.getAllStyles().setAlignment(LEFT);
          lbl_1000.setIcon(theme.getImage("40_shillings_note_ke.jpg"));
          lbl_1000.getAllStyles().setFgColor(0x000000);
          lbl_1000.getStyle().setFont(font_medium_plain);
          txf_1000 = new TextField("", 6);
          txf_1000.setConstraint(TextField.NUMERIC);
          txf_1000.setFocusable(true);
          lbl_1000v = new Label("");
          lbl_1000v.getAllStyles().setAlignment(LEFT);
          lbl_1000v.getStyle().setFont(font_medium_plain);
          lbl_1000v.getAllStyles().setPadding(0, 0, 0, 0);
          lbl_1000v.getAllStyles().setMargin(0, 0, 0, 0);
          cnt_brkdwn_notes.addComponent(lbl_1000);
          cnt_brkdwn_notes.addComponent(txf_1000);
          cnt_brkdwn_notes.addComponent(lbl_1000v);

          
          //
          //<-------- NOTES
          
          
          
        tabs = new Tabs();
        tabs.getUnselectedStyle().setBgColor(0xffffff);
        tabs.getSelectedStyle().setBgColor(0xffffff);
        tabs.setTabTextPosition(BOTTOM);
        s = UIManager.getInstance().getComponentStyle("Tab");
        s.setFgColor(0x000000);
        imgf_coins = FontImage.createMaterial(FontImage.MATERIAL_LENS, s);
        imgf_money = FontImage.createMaterial(FontImage.MATERIAL_CHECK_BOX_OUTLINE_BLANK, s);
        tabs.setAnimateTabSelection(true);
        tabs.setTabPlacement(TOP);
        tabs.addTab("Coins", imgf_coins, cnt_brkdwn_coins);
        tabs.addTab("Notes", imgf_money, cnt_brkdwn_notes);
        //dlgi_task.add(BorderLayout.NORTH, cnt_info);
        //dlgi_task.add(BorderLayout.CENTER, tabs);
        //dlgi_task.setWidth(cnt_brkdwn_coins.getWidth());
    
        
        Button btn_cancel = new Button("Cancel");
        //btn_cancel.setUIID("Label");
        btn_cancel.addActionListener(new ActionListener() 
        {
         @Override
         public void actionPerformed(ActionEvent evt) 
         {
                dlg_breakdown.dispose();
                dlg_breakdown.removeAll();
         }
        });

        Button btn_confirm = new Button("Confirm");
        //btn_confirm.setUIID("Label");
        btn_confirm.addActionListener(new ActionListener() 
        {
         @Override
         public void actionPerformed(ActionEvent evt) 
         {
                dlg_breakdown.dispose();
                dlg_breakdown.removeAll();
         }
        });

        Container cmds = new Container(new BorderLayout());
        cmds.add(BorderLayout.WEST, btn_cancel);
        cmds.add(BorderLayout.EAST, btn_confirm);

        dlg_breakdown.add(BorderLayout.centerAbsoluteEastWest(sbtn_title, btn_close, btn_minimise));
        dlg_breakdown.add(tabs); //cnt_brkdwn_coins
        dlg_breakdown.add(cmds);
        
        dlg_breakdown.show();
    }
    
    private void doRandomNum()
    {
        //str_trxno = Storage.getInstance().readObject("temp_trx_number").toString();
        if(txtf_trxno.getText().equals(""))
        {
            Random rand = new Random();
            int randomNum = rand.nextInt(1999);

            sb_randomLetters = new StringBuilder(); 
            str_randomLetters = new String[3];

            for (i = 0; i < 3; i++) 
            {
                char randomChr = (char) (rand.nextInt(26) + 'A');
                str_randomLetters[i] = String.valueOf(randomChr);
                sb_randomLetters.append(str_randomLetters[i]);
            }
            String str_randno = Integer.toString(randomNum)+sb_randomLetters;
            Storage.getInstance().writeObject("temp_trx_number", str_randno); 
        }
        else
        {
            //Storage.getInstance().writeObject("temp_trx_number", txtf_trxno.getText());
            Random rand = new Random();
            int randomNum = rand.nextInt(1999);

            sb_randomLetters = new StringBuilder(); 
            str_randomLetters = new String[3];

            for (i = 0; i < 3; i++) 
            {
                char randomChr = (char)(rand.nextInt(26) + 'A');
                str_randomLetters[i] = String.valueOf(randomChr);
                sb_randomLetters.append(str_randomLetters[i]);
            }
            String str_randno = Integer.toString(randomNum)+sb_randomLetters;
            Storage.getInstance().writeObject("temp_trx_number", str_randno);
        }
    }
    
    private void showInvoice()
    {
        bool_payment_provider = Storage.getInstance().exists("payprovider");
        if(bool_payment_provider == true)
        {
            str_payprovider = Storage.getInstance().readObject("payprovider").toString();
        }
        else
        {
            str_payprovider = "-------";
            Storage.getInstance().writeObject("payprovider", str_payprovider);
        }
        
        str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
        int_no_main_items = Integer.parseInt(str_no_main_items);
        sb_main_item = new StringBuilder();
        
        System.out.println("No of Main Items: "+str_no_main_items);
        System.out.println("No of Main Items Selected: "+Storage.getInstance().readObject("no_itemsel").toString());
        
        
//        for (i = 0; i < int_no_main_item+2; i++) //i = 1; i < int_no_main_item+1; i++
//        {
//            System.out.println(i+"<");
//            if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
//            {
//                
//            }
//            else
//            {
//                sb_main_item.append("    ").append(Storage.getInstance().readObject("main_item_"+i).toString()).append(":    Ksh. ").append(Storage.getInstance().readObject("main_itemv_"+i).toString()+"\n");
//                System.out.println(i+". Added Main Item(s):... \n"+sb_main_item.toString());
//                
//                bool_itemop1 = Storage.getInstance().exists("main_itemop1_"+i);
//                if(bool_itemop1 == true)
//                {
//                    if(Storage.getInstance().readObject("main_itemop1v_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemop1v_"+i).toString().equals("0"))
//                    {
//                        Storage.getInstance().writeObject("main_itemop1_"+i, "N/a");
//                        Storage.getInstance().writeObject("main_itemop1v_"+i, "0");
//                        
//                        System.out.println("Writing to storage "+"main_itemop1_"+i+"N/a");
//                        System.out.println("Writing to storage "+"main_itemop1v_"+i+"0");
//                    }
//                    else
//                    {
//                        //Storage.getInstance().writeObject("main_itemop1_"+i, btn_payoption1_row[i].getName());
//                        //Storage.getInstance().writeObject("main_itemop1v_"+i,btn_payoption1_row[i].getUIID());
//                    }
//                }
//                else
//                {
//                    Storage.getInstance().writeObject("main_itemop1_"+i, "N/a");
//                    Storage.getInstance().writeObject("main_itemop1v_"+i, "0");
//                    
//                    System.out.println("Writing.. to storage "+"main_itemop1_"+i+"N/a");
//                    System.out.println("Writing.. to storage "+"main_itemop1v_"+i+"0");
//                }
//
//                bool_itemop2 = Storage.getInstance().exists("main_itemop2_"+i);
//                if(bool_itemop2 == true)
//                {
//                    if(Storage.getInstance().readObject("main_itemop2v_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemop2v_"+i).toString().equals("0"))
//                    {
//                        Storage.getInstance().writeObject("main_itemop2_"+i, "N/a");
//                        Storage.getInstance().writeObject("main_itemop2v_"+i, "0");
//                        
//                        System.out.println("Writing to storage "+"main_itemop2_"+i+"N/a");
//                        System.out.println("Writing to storage "+"main_itemop2v_"+i+"0");
//                    }
//                    else
//                    {
//                        //Storage.getInstance().writeObject("main_itemop2_"+i, btn_payoption2_row[i].getName());
//                        //Storage.getInstance().writeObject("main_itemop2v_"+i,btn_payoption2_row[i].getUIID());
//                    }
//                }
//                else
//                {
//                    Storage.getInstance().writeObject("main_itemop2_"+i, "N/a");
//                    Storage.getInstance().writeObject("main_itemop2v_"+i, "0");
//                    
//                    System.out.println("Writing.. to storage "+"main_itemop2_"+i+"N/a");
//                    System.out.println("Writing.. to storage "+"main_itemop2v_"+i+"0");
//                }
//
//                bool_itemop3 = Storage.getInstance().exists("main_itemop3_"+i);
//                if(bool_itemop3 == true)
//                {
//                    if(Storage.getInstance().readObject("main_itemop3v_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemop3v_"+i).toString().equals("0"))
//                    {
//                        Storage.getInstance().writeObject("main_itemop3_"+i, "N/a");
//                        Storage.getInstance().writeObject("main_itemop3v_"+i, "0");
//                        
//                        System.out.println("Writing to storage "+"main_itemop3_"+i+"N/a");
//                        System.out.println("Writing to storage "+"main_itemop3v_"+i+"0");
//                    }
//                    else
//                    {
//                        //Storage.getInstance().writeObject("main_itemop3_"+i, btn_payoption3_row[i].getName());
//                        //Storage.getInstance().writeObject("main_itemop3v_"+i,btn_payoption3_row[i].getUIID());
//                    }
//                }
//                else
//                {
//                    Storage.getInstance().writeObject("main_itemop3_"+i, "N/a");
//                    Storage.getInstance().writeObject("main_itemop3v_"+i, "0");
//                    
//                    System.out.println("Writing.. to storage "+"main_itemop3_"+i+"N/a");
//                    System.out.println("Writing.. to storage "+"main_itemop3v_"+i+"0");
//                }
//            }
//        }

        str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
        int_no_new_items = Integer.parseInt(str_no_new_items);
        sb_new_item = new StringBuilder();
        
        for (i = 0; i < int_no_new_items; i++) 
        {
            sb_new_item.append("    ").append(Storage.getInstance().readObject("new_item_"+i).toString()).append(":    Ksh. ").append(Storage.getInstance().readObject("new_itemv_"+i).toString()+"\n");
            System.out.println("Added Item(s):... \n"+sb_new_item.toString());
        }
        
        //str_itemsel = StringUtil.replaceAll(StringUtil.replaceAll(StringUtil.replaceAll(sb_main_item.toString(), ":    Ksh. ", "~"), "\n", "|"), "|    ", "|")+StringUtil.replaceAll(StringUtil.replaceAll(StringUtil.replaceAll(sb_items.toString(), ":    Ksh. ", "~"), "\n", "|"), "|    ", "|").trim();
        str_itemsel = StringUtil.replaceAll(StringUtil.replaceAll(StringUtil.replaceAll(sb_main_item.toString(), ":    Ksh. ", ","), "\n", "|"), "|    ", "|")+StringUtil.replaceAll(StringUtil.replaceAll(StringUtil.replaceAll(sb_new_item.toString(), ":    Ksh. ", ","), "\n", "|"), "|    ", "|").trim();
        Storage.getInstance().writeObject("itemsel", str_itemsel);
        System.out.println("String >>>>> Basic Invoice Data >>>>> "+str_itemsel);
        
        

        str_title = Storage.getInstance().readObject("title").toString();
        str_firstname = Storage.getInstance().readObject("firstname").toString();
        str_name = Storage.getInstance().readObject("temp_firstname").toString()+" "+Storage.getInstance().readObject("temp_middlename").toString()+" "+Storage.getInstance().readObject("temp_lastname").toString();
        str_phone = Storage.getInstance().readObject("temp_phone").toString();
        str_trxno = Storage.getInstance().readObject("temp_trx_number").toString();
        str_refno = Storage.getInstance().readObject("temp_ref_number").toString();
        

        //TODO: Change salutation according to age and uzito of msee. e.g. if Doctor say title+fisrname+lastname but if kijana just say firstname
        //TODO: Put organisation name, paybill name and paybill number dynamically.

        //Storage.getInstance().clearCache();
        //str_payinstructions = Storage.getInstance().readObject("pay_instructions").toString();
        //spnlbl_description.setText(str_payinstructions);

        GridLayout laygrid_desc = new GridLayout(4, 2);
        laygrid_desc.setAutoFit(false);
        laygrid_desc.setFillLastRow(false);
        //laygrid_desc.
        //laygrid_desc.setHideZeroSized(true);
        
        TableLayout laytab_description = new TableLayout(4, 2);
        
        cnt_description = new Container();
        cnt_description.setLayout(laytab_description); 
        cnt_description.setName("cnt_description");
        //cnt_description.getAllStyles().setMarginBottom((int) (15.8 * pixelsPerMM));
        
        
        cnt_envelope_ttl = new Container();
        cnt_envelope_ttl.setLayout(new GridLayout(1, 2)); 
        cnt_envelope_ttl.setName("cnt_envelope_ttl");
        //cnt_envelope_ttl.add(lbl_envelope_ttl);
        //cnt_envelope_ttl.add(lbl_envelope_ttl_val);
        
        cnt_pay_option = new Container();
        cnt_pay_option.setLayout(new GridLayout(1, 2)); 
        cnt_pay_option.setName("cnt_pay_option");
        //cnt_pay_option.add(lbl_payoption);
        //cnt_pay_option.add(lbl_payoption_val);
        
        cnt_smsto = new Container();
        cnt_smsto.setLayout(new GridLayout(1, 2)); 
        cnt_smsto.setName("cnt_smsto");
        //cnt_smsto.add(lbl_smsto);
        //cnt_smsto.add(lbl_smsto_val);
        
        cnt_refno = new Container();
        cnt_refno.setLayout(new GridLayout(1, 2)); 
        cnt_refno.setName("cnt_refno");
        //cnt_refno.add(lbl_refno);
        //cnt_refno.add(lbl_refno_val);
        
        
        bool_totals = Storage.getInstance().exists("totals");
        if(bool_totals == true)
        {
            str_totals = Storage.getInstance().readObject("totals").toString();
        }
        else
        {
            str_totals = "0";
        }
        
        bool_role = Storage.getInstance().exists("role");
        if(bool_role == true)
        {
            str_role = Storage.getInstance().readObject("role").toString();
            if(str_role.equals("Assistant Treasurer") || str_role.contains("Treasurer"))
            {
                //str_payinstructions1 = "Dear "+str_firstname+",\nPlease confirm that the envelope total is Ksh. "+str_totals+", payment option is "+str_payoption+" and breakdown is:\n" +"\n";
                //str_payinstructions1 = "Please confirm:\n\nEnvelope Total: Ksh. "+str_totals+"\nPayment Option: "+str_payoption+"\n\n";
                str_payinstructions1 = "Envelope Total: Ksh. "+str_totals+"\nPayment Option: "+str_payprovider+"\n";
                
                str_payinstructions2 = "";//sb_main_item.toString()+sb_items.toString();
                
                bool_payment_provider = Storage.getInstance().exists("payprovider");
                if(bool_payment_provider == true)
                {
                    str_payprovider = Storage.getInstance().readObject("payprovider").toString();
                    if(str_payprovider.equals("cash"))
                    {
                        str_payinstructions3 = "\nSMS to: "+str_name+" ("+str_phone+")\n\nRef #: "+str_refno;
                    }
                    else
                    { 
                        str_payinstructions3 = "\nSMS to: "+str_name+" ("+str_phone+")\n\nRef #: "+str_refno; //ABC123
                    }
                }
                else
                {
                    str_payprovider = "-------";
                    str_payinstructions3 = "\nSMS to: "+str_name+" ("+str_phone+")\n\nRef #: "+str_refno; //ABC123
                }
                
                spnlbl_description1.setText("Envelope Total: Ksh. "+str_totals);
                spnlbl_description2.setText("Payment Option: "+str_payprovider);
                spnlbl_description3.setText("SMS to: "+str_name+" ("+str_phone+")");
                spnlbl_description4.setText("Ref #: "+str_refno);
                
                str_totals = StringUtil.replaceAll(l10n.formatCurrency(l10n.parseCurrency(str_totals)), "KES", "Ksh. ");
                lbl_envelope_ttl_val.setText(str_totals);  //"Ksh. "+str_totals
                lbl_payoption_val.setText(str_payprovider);
                lbl_smsto_val.setText(str_name+" ("+str_phone+")");
                lbl_refno_val.setText(str_refno);
                
                
                
                cnt_description.removeComponent(lbl_envelope_ttl);
                cnt_description.removeComponent(lbl_envelope_ttl_val);
                cnt_description.removeComponent(lbl_payoption);
                cnt_description.removeComponent(lbl_payoption_val);
                cnt_description.removeComponent(lbl_smsto);
                cnt_description.removeComponent(lbl_smsto_val);
                cnt_description.removeComponent(lbl_refno);
                cnt_description.removeComponent(lbl_refno_val);
                //cnt_description.removeComponent(cnt_envelope_ttl);
                //cnt_description.removeComponent(cnt_pay_option);
                //cnt_description.removeComponent(cnt_smsto);
                //cnt_description.removeComponent(cnt_refno);
                //cnt_description.removeComponent(spnlbl_description1);
                //cnt_description.removeComponent(spnlbl_description2);
                //cnt_description.removeComponent(spnlbl_description3);
                //cnt_description.removeComponent(spnlbl_description4);
                
                cnt_description.add(laytab_description.createConstraint().widthPercentage(40), lbl_envelope_ttl);
                cnt_description.add(lbl_envelope_ttl_val);
                cnt_description.add(laytab_description.createConstraint().widthPercentage(40), lbl_payoption);
                cnt_description.add(lbl_payoption_val);
                cnt_description.add(laytab_description.createConstraint().widthPercentage(40), lbl_smsto);
                cnt_description.add(lbl_smsto_val);
                cnt_description.add(laytab_description.createConstraint().widthPercentage(40), lbl_refno);
                cnt_description.add(lbl_refno_val);
                //cnt_description.addComponent(cnt_envelope_ttl);
                //cnt_description.addComponent(cnt_pay_option);
                //cnt_description.addComponent(cnt_smsto);
                //cnt_description.addComponent(cnt_refno);
                //cnt_description.addComponent(spnlbl_description1);
                //cnt_description.addComponent(spnlbl_description2);
                //cnt_description.addComponent(spnlbl_description3);
                //cnt_description.addComponent(spnlbl_description4);
            }
            else
            {
                str_payinstructions1 = "Dear "+str_firstname+",\nYou are about to send Ksh. "+str_totals+" to Karengata SDA Church by "+str_payprovider+"(Pay Bill 288822). Your transaction breakdown is as follows:\n" +"\n";

                //str_payinstructions2 = sb_main_item.toString()+sb_items.toString();

                str_payinstructions3 = "\nClick finish to complete the transaction and we will shortly send you a confirmation message via SMS & email.";
                
                str_payinstructions = str_payinstructions1+str_payinstructions2+str_payinstructions3;
                Storage.getInstance().writeObject("pay_instructions", str_payinstructions);
                
                spnlbl_description1.setText(str_payinstructions);
                
                cnt_description.removeComponent(spnlbl_description);
                cnt_description.removeComponent(spnlbl_description1);
                cnt_description.removeComponent(spnlbl_description2);
                cnt_description.removeComponent(spnlbl_description3);
                cnt_description.removeComponent(spnlbl_description4);
                cnt_description.addComponent(spnlbl_description);
            }
        }
        else
        {
            str_payinstructions1 = "Dear "+str_firstname+",\nYou are about to send Ksh. "+str_totals+" to Karengata SDA Church by "+str_payprovider+"(Pay Bill 288822). Your transaction breakdown is as follows:\n" +"\n";

            //str_payinstructions2 = sb_main_item.toString()+sb_items.toString();

            str_payinstructions3 = "\nClick finish to complete the transaction and we will shortly send you a confirmation message via SMS & email."; /*"\nPlease remember this number, 1234. It is the tracking number if need arises to track this transaction. For your records, we will shortly send it to you via SMS.\n" +
            "\nClick finish to complete the transaction. " +
            "Once the tranaction is complete, you will receive a confirmation SMS from M-PESA.\n" +"";*/
            
            cnt_description.removeComponent(spnlbl_description);
            cnt_description.removeComponent(spnlbl_description1);
            cnt_description.removeComponent(spnlbl_description2);
            cnt_description.removeComponent(spnlbl_description3);
            cnt_description.removeComponent(spnlbl_description4);
            cnt_description.addComponent(spnlbl_description);
            
            str_payinstructions = str_payinstructions1+str_payinstructions2+str_payinstructions3;
            Storage.getInstance().writeObject("pay_instructions", str_payinstructions);
        }
        
        
        
        
        //spnlbl_description1.setText(str_payinstructions);
        
        //dlg_payments3.dispose();
        //showPayDialog3();
        
        
        
        
        /// >>--------> Table Header
        //
        
            Label lbl_ttl_col1 = new Label(" #");
            lbl_ttl_col1.getAllStyles().setAlignment(LEFT);
            //lbl_ttl_col1.getStyle().setFont(font_HPSimplified);
            lbl_ttl_col1.getAllStyles().setFgColor(0x000000, false);
            lbl_ttl_col1.getAllStyles().setBgColor(0xffffff, false);
            lbl_ttl_col1.getAllStyles().setBgTransparency(0, false);
            //lbl_ttl_col3.getAllStyles().setPadding(0, 0, (int)(3.3 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
            lbl_ttl_col1.setPreferredSize(new Dimension(70, 0));

            Label lbl_ttl_col2 = new Label("Pic");
            lbl_ttl_col2.getAllStyles().setAlignment(LEFT);
            //lbl_ttl_col2.getStyle().setFont(font_HPSimplified);
            lbl_ttl_col2.getAllStyles().setFgColor(0x000000, false);
            lbl_ttl_col2.getAllStyles().setBgColor(0xffffff, false);
            lbl_ttl_col2.getAllStyles().setBgTransparency(0, false);
            //lbl_ttl_col2.getAllStyles().setPadding(0, 0, (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
            lbl_ttl_col2.getStyle().setPadding(0, 0, (int)(1.0 * pixelsPerMM), (int)(1.0 * pixelsPerMM));

            Label lbl_ttl_col3 = new Label("Name");
            lbl_ttl_col3.getAllStyles().setAlignment(LEFT);
            //lbl_ttl_col3.getStyle().setFont(font_HPSimplified);
            lbl_ttl_col3.getAllStyles().setFgColor(0x000000, false);
            lbl_ttl_col3.getAllStyles().setBgColor(0xffffff, false);
            lbl_ttl_col3.getAllStyles().setBgTransparency(0, false);
            //lbl_ttl_col3.getAllStyles().setPadding(0, 0, (int)(3.3 * pixelsPerMM), (int)(1.0 * pixelsPerMM));
            lbl_ttl_col3.setPreferredSize(new Dimension(175, 0));

            cnt_tablehead = new Container(new BoxLayout(BoxLayout.X_AXIS));
            //cnt_tablehead.getAllStyles().setPadding(0, 0, 0, 0);
            //cnt_tablehead.getAllStyles().setPadding(0, 0, (int)(2.0 * pixelsPerMM), (int)(2.0 * pixelsPerMM));
            cnt_tablehead.getAllStyles().setPadding(0, (int)(2.0 * pixelsPerMM), 0, 0);
            cnt_tablehead.setScrollableY(false);
            cnt_tablehead.setLeadComponent(null);
            //cnt_tablehead.add(cb_members);
            cnt_tablehead.add(lbl_ttl_col1);
            cnt_tablehead.add(lbl_ttl_col2);
            cnt_tablehead.add(lbl_ttl_col3);
            //cnt_tablehead.add(cnt_Allactions);
        //    
        // <--------<< Table Head 
        
        /// >>--------> Table Body
        //
        
            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
            int_no_main_items = Integer.parseInt(str_no_main_items);
            
            TableLayout laytab_tablebody = new TableLayout(int_no_main_items+2, 1);
            //laytab_tablebody.setGrowHorizontally(true);
            
            TableLayout laytab_tablerow = new TableLayout(int_no_main_items+2, 1);
            //laytab_tablerow.setGrowHorizontally(true);
        
            cnt_tablebody = new Container();
            cnt_tablebody.setLayout(new BoxLayout(BoxLayout.Y_AXIS)); //laytab_tablebody //new BoxLayout(BoxLayout.Y_AXIS) //new FlowLayout(CENTER, TOP)
            
            //cnt_tablebody.getAllStyles().setPadding(0, (int)(5.0 * pixelsPerMM), (int)(2.0 * pixelsPerMM), (int)(2.0 * pixelsPerMM));
            cnt_tablebody.getAllStyles().setPadding(0, (int)(4.0 * pixelsPerMM), 0, 0);
            cnt_tablebody.getAllStyles().setMargin(0, 0, 0, 0);
            cnt_tablebody.getAllStyles().setAlignment(CENTER);
            cnt_tablebody.setScrollableY(false);
            
            
            cb_box_row = new CheckBox[int_no_main_items+2];
            lbl_id_row = new Label[int_no_main_items+2];
            btn_pic_row = new Button[int_no_main_items+2];
            splbl_amount_row = new SpanLabel[int_no_main_items+2];
            splbl_name_row = new SpanLabel[int_no_main_items+2];
            lbl_amount_row = new Label[int_no_main_items+2];
            lbl_name_row = new Label[int_no_main_items+2];
            
            btn_payoption1_main_row = new Button[int_no_main_items+2];
            btn_payoption2_main_row = new Button[int_no_main_items+2];
            btn_payoption3_main_row = new Button[int_no_main_items+2];
            btn_payoption4_row = new Button[int_no_main_items+2];
            btn_payoption5_row = new Button[int_no_main_items+2];
            btn_payoption6_row = new Button[int_no_main_items+2];           
            
            cnt_cbox_row = new Container[int_no_main_items+2];
            cnt_amount_row = new Container[int_no_main_items+2];
            cnt_name_row = new Container[int_no_main_items+2];
            cnt_gender_row = new Container[int_no_main_items+2];
            cnt_actions_row = new Container[int_no_main_items+2];
            cnt_tablerow_row = new Container[int_no_main_items+2];
            
            for (i = 0; i < int_no_main_items+2; i++)
            {
                
                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
                {
                    System.out.println(">"+i);
                }
                else
                {
                    System.out.println(i+"<");
                    Label lbl_iteration = new Label();
                    lbl_iteration.setText(String.valueOf(i));
                    
                    
                    splbl_name_row[i] = new SpanLabel();
                    splbl_name_row[i].setText(Storage.getInstance().readObject("main_item_"+i).toString().trim()); //str_users_firstname+"\n"+str_users_lastname
                    //splbl_name_row[i].setActAsLabel
                    splbl_name_row[i].getStyle().setBgColor(0xffffff); 
                    splbl_name_row[i].getStyle().setFgColor(0x000000);
                    splbl_name_row[i].getStyle().setPadding(0, 0, 0, 0);
                    splbl_name_row[i].getStyle().setMargin(0, 0, 0, 0);
                    splbl_name_row[i].getTextAllStyles().setAlignment(LEFT, false);
                    splbl_name_row[i].getTextAllStyles().setFgColor(0x000000, false);
                    splbl_name_row[i].getTextAllStyles().setPadding(0, 0, 0, 0);
                    splbl_name_row[i].getTextAllStyles().setMargin(0, 0, 0, 0);
                    splbl_name_row[i].setPreferredSize(new Dimension(20, 0));
                    splbl_name_row[i].getStyle().setBgTransparency(0, false);

                    splbl_amount_row[i] = new SpanLabel();
                    splbl_amount_row[i].setText(Storage.getInstance().readObject("main_itemv_"+i).toString()); //str_users_firstname+"\n"+str_users_lastname
                    splbl_amount_row[i].getStyle().setBgColor(0xffffff); 
                    splbl_amount_row[i].getStyle().setFgColor(0x000000);
                    //splbl_amount_row[i].getStyle().setPadding(0, 0, (int)(0.5 * pixelsPerMM), (int)(0.5 * pixelsPerMM));
                    //splbl_amount_row[i].getStyle().setMargin(0, 0, (int)(1.0 * pixelsPerMM), (int)(5.0 * pixelsPerMM));
                    splbl_amount_row[i].getTextAllStyles().setAlignment(LEFT, false);
                    splbl_amount_row[i].getTextAllStyles().setFgColor(0x000000, false);
                    splbl_amount_row[i].getTextAllStyles().setPadding(0, 0, 0, 0);
                    splbl_amount_row[i].getTextAllStyles().setMargin(0, 0, 0, 0);
                    //splbl_amount_row[i].setPreferredSize(new Dimension(200, 0));
                    splbl_amount_row[i].getStyle().setBgTransparency(0, false);
                    //splbl_amount_row[i].getStyle().setFont(font_HPSimplifiedSmall); //font_HPSimplified
                    
                    lbl_name_row[i] = new Label();
                    lbl_name_row[i].setText(Storage.getInstance().readObject("main_item_"+i).toString().trim()); //str_users_firstname+"\n"+str_users_lastname
                    //splbl_name_row[i].setActAsLabel
                    lbl_name_row[i].getStyle().setBgColor(0xffffff); 
                    lbl_name_row[i].getStyle().setFgColor(0x000000);
                    lbl_name_row[i].getStyle().setPadding(0, 0, 0, 0);
                    lbl_name_row[i].getStyle().setMargin(0, 0, 0, 0);
                    lbl_name_row[i].getAllStyles().setAlignment(LEFT, false);
                    lbl_name_row[i].getAllStyles().setFgColor(0x000000, false);
                    lbl_name_row[i].getAllStyles().setPadding(0, 0, 0, 0);
                    lbl_name_row[i].getAllStyles().setMargin(0, 0, 0, 0);
                    //lbl_name_row[i].setPreferredSize(new Dimension(20, 0));
                    lbl_name_row[i].getStyle().setBgTransparency(0, false);

                    lbl_amount_row[i] = new Label();
                    lbl_amount_row[i].setText(StringUtil.replaceAll(l10n.formatCurrency(l10n.parseCurrency(Storage.getInstance().readObject("main_itemv_"+i).toString().trim())), "KES", "")); //str_users_firstname+"\n"+str_users_lastname
                    lbl_amount_row[i].getStyle().setFgColor(0x000000);
                    //splbl_amount_row[i].getStyle().setPadding(0, 0, (int)(0.5 * pixelsPerMM), (int)(0.5 * pixelsPerMM));
                    //splbl_amount_row[i].getStyle().setMargin(0, 0, (int)(1.0 * pixelsPerMM), (int)(5.0 * pixelsPerMM));
                    lbl_amount_row[i].getAllStyles().setAlignment(LEFT, false);
                    lbl_amount_row[i].getAllStyles().setFgColor(0x000000, false);
                    lbl_amount_row[i].getAllStyles().setPadding(0, 0, 0, 0);
                    lbl_amount_row[i].getAllStyles().setMargin(0, 0, 0, 0);
                    //splbl_amount_row[i].setPreferredSize(new Dimension(200, 0));
                    lbl_amount_row[i].getStyle().setBgTransparency(0, false);
                    //splbl_amount_row[i].getStyle().setFont(font_HPSimplifiedSmall); //font_HPSimplified
                    

                    cnt_name_row[i] = new Container(new BoxLayout(BoxLayout.Y_AXIS)); //new GridLayout(1, 1) 
                    //cnt_name_row[i].setPreferredSize(new Dimension(220, 0)); //320,0 //480, 0
                    cnt_name_row[i].getAllStyles().setMargin(0,0,0,0);
                    cnt_name_row[i].getAllStyles().setPadding(0,(int)(0.5 * pixelsPerMM),0,0);
                    cnt_name_row[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                    //cnt_name_row[i].add(laytab_name.createConstraint().widthPercentage(100), splbl_name_row[i]);
                    cnt_name_row[i].add(lbl_name_row[i]); //splbl_name_row[i]


                    cnt_amount_row[i] = new Container(new GridLayout(1, 1));
                    //cnt_amount_row[i].setPreferredSize(new Dimension(100, 0));  //160
                    cnt_amount_row[i].getAllStyles().setMargin(0,0,0,0);
                    cnt_amount_row[i].getAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), 0, 0);
                    cnt_amount_row[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                    //cnt_amount_row[i].add(laytab_name.createConstraint().widthPercentage(100), splbl_name_row[i]);
                    cnt_amount_row[i].add(FlowLayout.encloseCenterMiddle(lbl_amount_row[i])); //splbl_amount_row[i]



                    btn_payoption1_main_row[i] = new Button();
                    //btn_payoption1_row[i].setName(String.valueOf(i));
                    btn_payoption1_main_row[i].getAllStyles().setFgColor(0xffffff, false);
                    btn_payoption1_main_row[i].getAllStyles().setMargin(0, 0, 0, 0);
                    btn_payoption1_main_row[i].getAllStyles().setPadding(0, 0, 0, 0);
                    btn_payoption1_main_row[i].setTextPosition(Component.TOP);
                    btn_payoption1_main_row[i].setBlockLead(true);
                    btn_payoption1_main_row[i].setAutoRelease(false);
                    btn_payoption1_main_row[i].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            String str_table = "main_table";
                            String str_colid = "1";
                            String str_rowid = String.valueOf(lbl_iteration.getText());
                            
                            Log.p("Showing PayOptions Dialogue. "+str_table+" "+str_colid+", "+str_rowid, 1);
                            showPayoptions(str_table, str_colid, str_rowid);
                        }
                    });
                    

                    btn_payoption2_main_row[i] = new Button();
                    //btn_payoption2_row[i].setName(String.valueOf(i));
                    btn_payoption2_main_row[i].getAllStyles().setFgColor(0xffffff, false);
                    btn_payoption2_main_row[i].getAllStyles().setMargin(0, 0, 0, 0);
                    btn_payoption2_main_row[i].getAllStyles().setPadding(0, 0, 0, 0);
                    btn_payoption2_main_row[i].setTextPosition(Component.TOP);
                    btn_payoption2_main_row[i].setBlockLead(true);
                    btn_payoption2_main_row[i].setAutoRelease(false);
                    btn_payoption2_main_row[i].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            String str_table = "main_table";
                            String str_colid = "2";
                            String str_rowid = String.valueOf(lbl_iteration.getText());
                            
                            Log.p("Showing PayOptions Dialogue. "+str_table+" "+str_colid+", "+str_rowid, 1);
                            showPayoptions(str_table, str_colid, str_rowid);
                        }
                    });


                    btn_payoption3_main_row[i] = new Button();
                    //btn_payoption3_row[i].setName(String.valueOf(i));
                    btn_payoption3_main_row[i].getAllStyles().setFgColor(0xffffff, false);
                    btn_payoption3_main_row[i].getAllStyles().setMargin(0, 0, 0, 0);
                    btn_payoption3_main_row[i].getAllStyles().setPadding(0, 0, 0, 0);
                    btn_payoption3_main_row[i].setTextPosition(Component.TOP);
                    btn_payoption3_main_row[i].setBlockLead(true);
                    btn_payoption3_main_row[i].setAutoRelease(false);
                    btn_payoption3_main_row[i].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            String str_table = "main_table";
                            String str_rowid = String.valueOf(lbl_iteration.getText());
                            String str_colid = "3";
                            
                            Log.p("Showing PayOptions Dialogue. "+str_table+" "+str_colid+", "+str_rowid, 1);
                            showPayoptions(str_table, str_colid, str_rowid);
                        }
                    });


                    
                    bool_itemop1 = Storage.getInstance().exists("main_itemop1_"+i);
                    if(bool_itemop1 == true)
                    {
                        str_itemop1 = Storage.getInstance().readObject("main_itemop1_"+i).toString();
                        str_itemop1v = Storage.getInstance().readObject("main_itemop1v_"+i).toString();
                        if(str_itemop1v.equals("") || str_itemop1v.equals("0"))
                        {
                           btn_payoption1_main_row[i].setIcon(theme.getImage("no_cash.png"));
                           btn_payoption1_main_row[i].setName("N/a");
                           btn_payoption1_main_row[i].setUIID("0");
                        }
                        else
                        {
                           btn_payoption1_main_row[i].setIcon(theme.getImage(StringUtil.replaceAll(str_itemop1, " ", "_").toLowerCase()+"_thumb.png"));
                           btn_payoption1_main_row[i].setName(str_itemop1);
                           btn_payoption1_main_row[i].setUIID(str_itemop1v);
                        }
                    }
                    else
                    {
                        btn_payoption1_main_row[i].setIcon(theme.getImage("no_cash.png"));
                        btn_payoption1_main_row[i].setName("N/a");
                        btn_payoption1_main_row[i].setUIID("0");
                    }

                    bool_itemop2 = Storage.getInstance().exists("main_itemop2_"+i);
                    if(bool_itemop2 == true)
                    {
                        str_itemop2 = Storage.getInstance().readObject("main_itemop2_"+i).toString();
                        str_itemop2v = Storage.getInstance().readObject("main_itemop2v_"+i).toString();
                        if(str_itemop2v.equals("") || str_itemop2v.equals("0"))
                        {
                           btn_payoption2_main_row[i].setIcon(theme.getImage("no_cash.png"));
                           btn_payoption2_main_row[i].setName("N/a");
                           btn_payoption2_main_row[i].setUIID("0");
                        }
                        else
                        {
                           btn_payoption2_main_row[i].setIcon(theme.getImage(StringUtil.replaceAll(str_itemop2, " ", "_").toLowerCase()+"_thumb.png"));
                           btn_payoption2_main_row[i].setName(str_itemop2);
                           btn_payoption2_main_row[i].setUIID(str_itemop2v);
                        }
                    }
                    else
                    {
                        btn_payoption2_main_row[i].setIcon(theme.getImage("no_cash.png"));
                        btn_payoption2_main_row[i].setName("N/a");
                        btn_payoption2_main_row[i].setUIID("0");
                    }
                    

                    bool_itemop3 = Storage.getInstance().exists("main_itemop3_"+i);
                    if(bool_itemop3 == true)
                    {
                        str_itemop3 = Storage.getInstance().readObject("main_itemop3_"+i).toString();
                        str_itemop3v = Storage.getInstance().readObject("main_itemop3v_"+i).toString();
                        if(str_itemop3v.equals("") || str_itemop3v.equals("0"))
                        {
                           btn_payoption3_main_row[i].setIcon(theme.getImage("no_cash.png"));
                           btn_payoption3_main_row[i].setName("N/a");
                           btn_payoption3_main_row[i].setUIID("0");
                        }
                        else
                        {
                           btn_payoption3_main_row[i].setIcon(theme.getImage(StringUtil.replaceAll(str_itemop3, " ", "_").toLowerCase()+"_thumb.png"));
                           btn_payoption3_main_row[i].setName(str_itemop3);
                           btn_payoption3_main_row[i].setUIID(str_itemop3v);
                        }
                    }
                    else
                    {
                        btn_payoption3_main_row[i].setIcon(theme.getImage("no_cash.png"));
                        btn_payoption3_main_row[i].setName("N/a");
                        btn_payoption3_main_row[i].setUIID("0");
                    }
                    


                    cnt_actions_row[i] = new Container(); //new FlowLayout(LEFT, CENTER) //new GridLayout(1, 4)
                    cnt_actions_row[i].setLayout(new BoxLayout(BoxLayout.X_AXIS));
                    //cnt_actions_row[i].setLeadComponent(null);
                    //cnt_actions_row[i].setWidth(50);
                    //cnt_actions_row[i].setPreferredSize(new Dimension(200, 0));
                    //cnt_actions_row[i].getAllStyles().setMargin(0,0,0,0);
                    cnt_actions_row[i].getAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), 0, 0);
                    cnt_actions_row[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                    cnt_actions_row[i].add(btn_payoption1_main_row[i]);
                    cnt_actions_row[i].add(btn_payoption2_main_row[i]);
                    cnt_actions_row[i].add(btn_payoption3_main_row[i]);
                    //cnt_actions_row[i].add(btn_payoption4_row[i]);
                    //cnt_actions_row[i].add(btn_payoption5_row[i]);
                    

                    cnt_tablerow_row[i] = new Container(); //new BoxLayout(BoxLayout.X_AXIS) //new GridLayout(1, 4)
                    cnt_tablerow_row[i].setLayout(new TableLayout(int_no_main_items+2, 3));
                    cnt_tablerow_row[i].setLeadComponent(null);
                    cnt_tablerow_row[i].setScrollableY(false);
                    cnt_tablerow_row[i].getAllStyles().setPadding(0, 0, 0, 0);
                    cnt_tablerow_row[i].getAllStyles().setMargin(0, 0, 0, 0);
                    cnt_tablerow_row[i].add(laytab_tablerow.createConstraint().widthPercentage(35), cnt_name_row[i]);
                    cnt_tablerow_row[i].add(laytab_tablerow.createConstraint().widthPercentage(35), cnt_amount_row[i]); //laytab_tablerow.createConstraint().widthPercentage(40), cnt_amount_row[i] 
                    cnt_tablerow_row[i].add(cnt_actions_row[i]);

                    cnt_tablebody.add(cnt_tablerow_row[i]);
                }
            }
            
            str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
            int_no_new_items = Integer.parseInt(str_no_new_items);
        
            cb_box_row2 = new CheckBox[int_no_new_items];
            lbl_id_row2 = new Label[int_no_new_items];
            btn_pic_row2 = new Button[int_no_new_items];
            splbl_amount_row2 = new SpanLabel[int_no_new_items];
            splbl_name_row2 = new SpanLabel[int_no_new_items];
            lbl_amount_row2 = new Label[int_no_new_items];
            lbl_name_row2 = new Label[int_no_new_items];
            btn_payoption2_new_row2 = new Button[int_no_new_items];
            btn_payoption1_new_row2 = new Button[int_no_new_items];
            btn_delete_row2 = new Button[int_no_new_items];
            btn_payoption3_new_row2 = new Button[int_no_new_items];
            btn_copy_row2 = new Button[int_no_new_items];
            btn_pin_row2 = new Button[int_no_new_items];
            btn_markpresent_row2 = new Button[int_no_new_items];
            cnt_cbox_row2 = new Container[int_no_new_items];
            cnt_amount_row2 = new Container[int_no_new_items];
            cnt_name_row2 = new Container[int_no_new_items];
            cnt_gender_row2 = new Container[int_no_new_items];
            cnt_actions_row2 = new Container[int_no_new_items];
            cnt_tablerow_row2 = new Container[int_no_new_items];
            
            for (i = 0; i < int_no_new_items; i++) 
            {
                if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
                {
                    System.out.println(">"+i);
                }
                else
                {
                    System.out.println(i+"<");
                    Label lbl_iteration = new Label();
                    lbl_iteration.setText(String.valueOf(i));
                    
                    splbl_name_row2[i] = new SpanLabel();
                    splbl_name_row2[i].setText(Storage.getInstance().readObject("new_item_"+i).toString().trim()); //str_users_firstname+"\n"+str_users_lastname
                    splbl_name_row2[i].getStyle().setBgColor(0xffffff); 
                    splbl_name_row2[i].getStyle().setFgColor(0x000000);
                    splbl_name_row2[i].getStyle().setPadding(0, 0, 0, 0);
                    splbl_name_row2[i].getStyle().setMargin(0, 0, 0, 0);
                    splbl_name_row2[i].getTextAllStyles().setAlignment(LEFT, false);
                    splbl_name_row2[i].getTextAllStyles().setFgColor(0x000000, false);
                    splbl_name_row2[i].getTextAllStyles().setPadding(0, (int)(1.0 * pixelsPerMM), 0, 0);
                    splbl_name_row2[i].getTextAllStyles().setMargin(0, 0, 0, 0);
                    //splbl_name_row2[i].setPreferredSize(new Dimension(20, 0));
                    splbl_name_row2[i].getStyle().setBgTransparency(0, false);

                    splbl_amount_row2[i] = new SpanLabel();
                    splbl_amount_row2[i].setText(Storage.getInstance().readObject("new_itemv_"+i).toString().trim()); //str_users_firstname+"\n"+str_users_lastname
                    splbl_amount_row2[i].getStyle().setBgColor(0xffffff); 
                    splbl_amount_row2[i].getStyle().setFgColor(0x000000);
                    //splbl_amount_row2[i].getStyle().setPadding(0, 0, (int)(0.5 * pixelsPerMM), (int)(0.5 * pixelsPerMM));
                    //splbl_amount_row2[i].getStyle().setMargin(0, 0, (int)(1.0 * pixelsPerMM), (int)(5.0 * pixelsPerMM));
                    splbl_amount_row2[i].getTextAllStyles().setAlignment(LEFT, false);
                    splbl_amount_row2[i].getTextAllStyles().setFgColor(0x000000, false);
                    splbl_amount_row2[i].getTextAllStyles().setPadding(0, 0, 0, 0);
                    splbl_amount_row2[i].getTextAllStyles().setMargin(0, 0, 0, 0);
                    //splbl_amount_row2[i].setPreferredSize(new Dimension(200, 0));
                    splbl_amount_row2[i].getStyle().setBgTransparency(0, false);
                    //splbl_amount_row2[i].getStyle().setFont(font_HPSimplifiedSmall); //font_HPSimplified
                    
                    
                    
                    lbl_name_row2[i] = new Label();
                    lbl_name_row2[i].setText(Storage.getInstance().readObject("new_item_"+i).toString().trim()); //str_users_firstname+"\n"+str_users_lastname
                    lbl_name_row2[i].getStyle().setBgColor(0xffffff); 
                    lbl_name_row2[i].getStyle().setFgColor(0x000000);
                    lbl_name_row2[i].getStyle().setPadding(0, 0, 0, 0);
                    lbl_name_row2[i].getStyle().setMargin(0, 0, 0, 0);
                    lbl_name_row2[i].getAllStyles().setAlignment(LEFT, false);
                    lbl_name_row2[i].getAllStyles().setFgColor(0x000000, false);
                    lbl_name_row2[i].getAllStyles().setPadding(0, 0, 0, 0);
                    lbl_name_row2[i].getAllStyles().setMargin(0, 0, 0, 0);
                    //lbl_name_row2[i].setPreferredSize(new Dimension(20, 0));
                    lbl_name_row2[i].getStyle().setBgTransparency(0, false);

                    lbl_amount_row2[i] = new Label();
                    //lbl_amount_row2[i].setText(Storage.getInstance().readObject("new_itemv_"+i).toString().trim()); //str_users_firstname+"\n"+str_users_lastname
                    lbl_amount_row2[i].setText(StringUtil.replaceAll(l10n.formatCurrency(l10n.parseCurrency(Storage.getInstance().readObject("new_itemv_"+i).toString().trim())), "KES", ""));
                    lbl_amount_row2[i].getStyle().setBgColor(0xffffff); 
                  //splbl_amount_row2[i].getStyle().setPadding(0, 0, (int)(0.5 * pixelsPerMM), (int)(0.5 * pixelsPerMM));
                    //splbl_amount_row2[i].getStyle().setMargin(0, 0, (int)(1.0 * pixelsPerMM), (int)(5.0 * pixelsPerMM));
                    lbl_amount_row2[i].getAllStyles().setAlignment(RIGHT, false);
                    lbl_amount_row2[i].setAlignment(RIGHT);
                    lbl_amount_row2[i].getAllStyles().setFgColor(0x000000, false);
                    lbl_amount_row2[i].getAllStyles().setPadding(0, 0, 0, 0);
                    lbl_amount_row2[i].getAllStyles().setMargin(0, 0, 0, 0);
                    //splbl_amount_row2[i].setPreferredSize(new Dimension(200, 0));
                    lbl_amount_row2[i].getStyle().setBgTransparency(0, false);
                    //splbl_amount_row2[i].getStyle().setFont(font_HPSimplifiedSmall); //font_HPSimplified
                    
                    

                    cnt_name_row2[i] = new Container(new BoxLayout(BoxLayout.Y_AXIS)); //new GridLayout(1, 1)
                    //cnt_name_row2[i].setPreferredSize(new Dimension(220, 0)); //320, 0 //480, 0
                    cnt_name_row2[i].getAllStyles().setAlignment(LEFT);
                    cnt_name_row2[i].getAllStyles().setMargin(0,0,0,0);
                    cnt_name_row2[i].getAllStyles().setPadding(0,(int)(0.5 * pixelsPerMM),0,0);
                    cnt_name_row2[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                    //cnt_name_row2[i].add(laytab_name.createConstraint().widthPercentage(100), splbl_name_row2[i]);
                    cnt_name_row2[i].add(splbl_name_row2[i]); //splbl_name_row2[i]


                    cnt_amount_row2[i] = new Container(new GridLayout(1, 1));
                    //cnt_amount_row2[i].setPreferredSize(new Dimension(100, 0)); //160, 0
                    cnt_amount_row2[i].getAllStyles().setAlignment(RIGHT);
                    cnt_amount_row2[i].getAllStyles().setMargin(0,0,0,0);
                    cnt_amount_row2[i].getAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), 0, 0);
                    cnt_amount_row2[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));
                    //cnt_amount_row2[i].add(laytab_name.createConstraint().widthPercentage(100), splbl_name_row2[i]);
                    cnt_amount_row2[i].add(FlowLayout.encloseCenterMiddle(lbl_amount_row2[i])); //(splbl_amount_row2[i]


                    btn_payoption1_new_row2[i] = new Button();
                    btn_payoption1_new_row2[i].setName(String.valueOf(i));
                    btn_payoption1_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                    btn_payoption1_new_row2[i].getAllStyles().setFgColor(0xffffff, false);
                    btn_payoption1_new_row2[i].getAllStyles().setMargin(0, 0, 0, 0);
                    btn_payoption1_new_row2[i].getAllStyles().setPadding(0, 0, 0, 0);
                    btn_payoption1_new_row2[i].setTextPosition(Component.TOP);
                    //btn_edit_row2[i].setBlockLead(true);
                    //btn_edit_row2[i].setAutoRelease(false);
                    btn_payoption1_new_row2[i].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            String str_table = "new_table";
                            String str_colid = "1";
                            String str_rowid = String.valueOf(lbl_iteration.getText());
                            
                            Log.p("Showing PayOptions Dialogue. "+str_table+" "+str_colid+", "+str_rowid, 1);
                            showPayoptions(str_table, str_colid, str_rowid);
                        }
                    });
                    

                    btn_payoption2_new_row2[i] = new Button();
                    btn_payoption2_new_row2[i].setUIID("Label");
                    btn_payoption2_new_row2[i].setName(String.valueOf(i));
                    btn_payoption2_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                    btn_payoption2_new_row2[i].getAllStyles().setFgColor(0xffffff, false);
                    btn_payoption2_new_row2[i].getAllStyles().setMargin(0, 0, 0, 0);
                    btn_payoption2_new_row2[i].getAllStyles().setPadding(0, 0, 0, 0);
                    btn_payoption2_new_row2[i].setTextPosition(Component.TOP);
                    btn_payoption2_new_row2[i].setBlockLead(true);
                    btn_payoption2_new_row2[i].setAutoRelease(false);
                    btn_payoption2_new_row2[i].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            String str_table = "new_table";
                            String str_colid = "2";
                            String str_rowid = String.valueOf(lbl_iteration.getText());
                            
                            Log.p("Showing PayOptions Dialogue. "+str_table+" "+str_colid+", "+str_rowid, 1);
                            showPayoptions(str_table, str_colid, str_rowid);
                        }
                    });
                    
                    
                    btn_payoption3_new_row2[i] = new Button();
                    //btn_payoption3_new_row2[i].setName(String.valueOf(i));
                    btn_payoption3_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                    btn_payoption3_new_row2[i].getAllStyles().setFgColor(0xffffff, false);
                    btn_payoption3_new_row2[i].getAllStyles().setMargin(0, 0, 0, 0);
                    btn_payoption3_new_row2[i].getAllStyles().setPadding(0, 0, 0, 0);
                    //btn_message_row2[i].setPropertyValue("msgtonm", str_users_firstname);
                    //btn_message_row2[i].setTextPosition(Component.TOP);
                    //btn_message_row2[i].setBlockLead(true);
                    //btn_message_row2[i].setAutoRelease(false);
                    btn_payoption3_new_row2[i].addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent evt) 
                        {
                            String str_table = "new_table";
                            String str_colid = "3";
                            String str_rowid = String.valueOf(lbl_iteration.getText());
                            
                            Log.p("Showing PayOptions Dialogue. "+str_table+" "+str_colid+", "+str_rowid, 1);
                            showPayoptions(str_table, str_colid, str_rowid);
                        }
                    });

                    bool_itemop1 = Storage.getInstance().exists("new_itemop1_"+i);
                    if(bool_itemop1 == true)
                    {
                        str_itemop1 = Storage.getInstance().readObject("new_itemop1_"+i).toString();
                        bool_itemop1v = Storage.getInstance().exists("new_itemop"+"1"+"v_"+i);
                        if(bool_itemop1v == true)
                        {
                            str_itemop1v = Storage.getInstance().readObject("new_itemop"+"1"+"v_"+i).toString();
                            if(str_itemop1v.equals("") || str_itemop1v.equals("0")) // || str_itemop1v.equals("00")
                            {
                               btn_payoption1_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                               btn_payoption1_new_row2[i].setName("N/a");
                               btn_payoption1_new_row2[i].setUIID("0");
                            }
                            else
                            {
                               btn_payoption1_new_row2[i].setIcon(theme.getImage(StringUtil.replaceAll(str_itemop1, " ", "_").toLowerCase()+"_thumb.png"));
                               btn_payoption1_new_row2[i].setName(str_itemop1);
                               btn_payoption1_new_row2[i].setUIID(str_itemop1v);
                            }
                        }
                    }
                    else
                    {
                        btn_payoption1_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                        btn_payoption1_new_row2[i].setName("N/a");
                        btn_payoption1_new_row2[i].setUIID("0");
                    }

                    bool_itemop2 = Storage.getInstance().exists("new_itemop2_"+i);
                    if(bool_itemop2 == true)
                    {
                        str_itemop2 = Storage.getInstance().readObject("new_itemop2_"+i).toString();
                        bool_itemop2v = Storage.getInstance().exists("new_itemop"+"2"+"v_"+i);
                        if(bool_itemop2v == true)
                        {
                            str_itemop2v = Storage.getInstance().readObject("new_itemop2v_"+i).toString();
                            if(str_itemop2v.equals("") || str_itemop2v.equals("0"))
                            {
                               btn_payoption2_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                               btn_payoption2_new_row2[i].setName("N/a");
                               btn_payoption2_new_row2[i].setUIID("0");
                            }
                            else
                            {
                               btn_payoption2_new_row2[i].setIcon(theme.getImage(StringUtil.replaceAll(str_itemop2, " ", "_").toLowerCase()+"_thumb.png"));
                               btn_payoption2_new_row2[i].setName(str_itemop2);
                               btn_payoption2_new_row2[i].setUIID(str_itemop2v);
                            }
                        }
                        else
                        {
                               btn_payoption2_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                               btn_payoption2_new_row2[i].setName("N/a");
                               btn_payoption2_new_row2[i].setUIID("0");
                        }
                    }
                    else
                    {
                        btn_payoption2_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                        btn_payoption2_new_row2[i].setName("N/a");
                        btn_payoption2_new_row2[i].setUIID("0");
                    }
                    

                    bool_itemop3 = Storage.getInstance().exists("new_itemop3_"+i);
                    if(bool_itemop3 == true)
                    {
                        str_itemop3 = Storage.getInstance().readObject("new_itemop3_"+i).toString();
                        bool_itemop3v = Storage.getInstance().exists("new_itemop"+"3"+"v_"+i);
                        if(bool_itemop3v == true)
                        {
                            str_itemop3v = Storage.getInstance().readObject("new_itemop3v_"+i).toString();
                            if(str_itemop3v.equals("") || str_itemop3v.equals("0")) // || str_itemop3v.equals("00")
                            {
                               btn_payoption3_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                               btn_payoption3_new_row2[i].setName("N/a");
                               btn_payoption3_new_row2[i].setUIID("0");
                            }
                            else
                            {
                               btn_payoption3_new_row2[i].setIcon(theme.getImage(StringUtil.replaceAll(str_itemop3, " ", "_").toLowerCase()+"_thumb.png"));
                               btn_payoption3_new_row2[i].setName(str_itemop3);
                               btn_payoption3_new_row2[i].setUIID(str_itemop3v);
                            }
                        }
                        else
                        {
                               btn_payoption3_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                               btn_payoption3_new_row2[i].setName("N/a");
                               btn_payoption3_new_row2[i].setUIID("0");
                        }
                    }
                    else
                    {
                        btn_payoption3_new_row2[i].setIcon(theme.getImage("no_cash.png"));
                        btn_payoption3_new_row2[i].setName("N/a");
                        btn_payoption3_new_row2[i].setUIID("0");
                    }
                    
                    




                    cnt_actions_row2[i] = new Container(); //new FlowLayout(LEFT, CENTER) //new GridLayout(1, 4)
                    cnt_actions_row2[i].setLayout(new BoxLayout(BoxLayout.X_AXIS));
                    //cnt_actions_row2[i].setLeadComponent(null);
                    //cnt_actions_row2[i].setWidth(50);
                    //cnt_actions_row2[i].setPreferredSize(new Dimension(200, 0));
                    //cnt_actions_row2[i].getAllStyles().setMargin(0,0,0,0);
                    cnt_actions_row2[i].getAllStyles().setPadding(0, (int)(0.5 * pixelsPerMM), 0, 0);
                    
                    cnt_actions_row2[i].getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD), Border.createLineBorder(1, 0xDDDDDD)));

                    cnt_actions_row2[i].add(btn_payoption1_new_row2[i]);
                    cnt_actions_row2[i].add(btn_payoption2_new_row2[i]);
                    cnt_actions_row2[i].add(btn_payoption3_new_row2[i]);
                    //cnt_actions_row2[i].add(btn_markpresent_row2[i]);
                    //cnt_actions_row2[i].add(btn_pin_row2[i]);
                    //cnt_actions_row2[i].add(btn_copy_row2[i]);
                    //cnt_actions_row2[i].add(btn_delete_row2[i]);

                    cnt_tablerow_row2[i] = new Container(); //new BoxLayout(BoxLayout.X_AXIS)  //new GridLayout(1, 4)
                    cnt_tablerow_row2[i].setLayout(new TableLayout(int_no_main_items+2, 3));
                    //cnt_tablerow_row2[i].getAllStyles().setBorder(null, Border.createLineBorder(1, 0xDDDDDD), null, null));
                    cnt_tablerow_row2[i].setLeadComponent(null);
                    cnt_tablerow_row2[i].setScrollableY(false);
                    cnt_tablerow_row2[i].getAllStyles().setPadding(0, 0, 0, 0);
                    cnt_tablerow_row2[i].getAllStyles().setMargin(0, 0, 0, 0);
                    
                    cnt_tablerow_row2[i].add(laytab_tablerow.createConstraint().widthPercentage(35), cnt_name_row2[i]);
                    cnt_tablerow_row2[i].add(laytab_tablerow.createConstraint().widthPercentage(35), cnt_amount_row2[i]); //laytab_tablerow.createConstraint().widthPercentage(40), cnt_amount_row[i] 
                    
                    cnt_tablerow_row2[i].add(cnt_actions_row2[i]);

                    cnt_tablebody.add(cnt_tablerow_row2[i]);
                
                }
                    
            }
        //    
        // <--------<< Table Body 

        
        ////cnt_description.removeComponent(cnt_tablehead);
        ////cnt_description.addComponent(cnt_tablehead);
        //cnt_description.removeComponent(cnt_tablebody);
        //cnt_description.addComponent(cnt_tablebody);
        
        //cnt_description.removeComponent(cnt_tablehead);
        //cnt_description.addComponent(cnt_tablehead);
        cnt_details.removeComponent(cnt_tablebody);
        cnt_details.addComponent(cnt_tablebody);
    }
    
    private void showPayoptions(String str_table, String str_colid, String str_rowid) //showPayoptions(str_colid, str_rowid);
    {
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                Picker picker_leo = new Picker();
                picker_leo.setFormatter(sdformat);
//                
//                str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
//                int_no_main_items = Integer.parseInt(str_no_main_items);
//
//                for (i = 0; i < int_no_main_items+2; i++)
//                {       
//                    if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
//                    {
//
//                    }
//                    else
//                    {
//                        Storage.getInstance().writeObject("main_itemop"+"1"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
//                        Storage.getInstance().writeObject("main_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
//                        Storage.getInstance().writeObject("main_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
//                        Storage.getInstance().writeObject("main_itemop"+"1"+"r_"+i, "");    //str_itemop1v //"ABC123"
//
//                        Storage.getInstance().writeObject("main_itemop"+"2"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
//                        Storage.getInstance().writeObject("main_itemop"+"2"+"v_"+i,"00");             //str_itemop1v //"2000"
//                        Storage.getInstance().writeObject("main_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
//                        Storage.getInstance().writeObject("main_itemop"+"2"+"r_"+i, "");//str_itemop1v //"ABC123"
//
//                        Storage.getInstance().writeObject("main_itemop"+"3"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
//                        Storage.getInstance().writeObject("main_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
//                        Storage.getInstance().writeObject("main_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
//                        Storage.getInstance().writeObject("main_itemop"+"3"+"r_"+i, "");//str_itemop1v //"ABC123"
//
//                        System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
//                        System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
//                        System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
//                        System.err.println(i+" Writing to Storage data for main payoptions for "+"btn_payoption1_row"+"1,2,3"+" ---> "+"");
//                    }
//                }
//
//                bool_no_new_items = Storage.getInstance().exists("no_new_items");
//                if(bool_no_new_items == true)
//                {
//                        str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
//                        int_no_new_items = Integer.parseInt(str_no_new_items);
//
//                        for (i = 0; i < int_no_new_items; i++) 
//                        {
//                            if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0"))
//                            {
//
//                            }
//                            else
//                            {
//                                Storage.getInstance().writeObject("new_itemop"+"1"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
//                                Storage.getInstance().writeObject("new_itemop"+"1"+"v_"+i, "00");             //str_itemop1v //"2000"
//                                Storage.getInstance().writeObject("new_itemop"+"1"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
//                                Storage.getInstance().writeObject("new_itemop"+"1"+"r_"+i, "");    //str_itemop1v //"ABC123"
//
//                                Storage.getInstance().writeObject("new_itemop"+"2"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
//                                Storage.getInstance().writeObject("new_itemop"+"2"+"v_"+i, "00");             //str_itemop1v //"2000"
//                                Storage.getInstance().writeObject("new_itemop"+"2"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
//                                Storage.getInstance().writeObject("new_itemop"+"2"+"r_"+i, "");//str_itemop1v //"ABC123"
//
//                                Storage.getInstance().writeObject("new_itemop"+"3"+"_"+i, str_payprovider); //str_itemop1  //"Mpesa"
//                                Storage.getInstance().writeObject("new_itemop"+"3"+"v_"+i, "00");             //str_itemop1v //"2000"
//                                Storage.getInstance().writeObject("new_itemop"+"3"+"d_"+i, picker_leo.getText());//str_itemop1v //"2020-01-09"
//                                Storage.getInstance().writeObject("new_itemop"+"3"+"r_"+i, "");//str_itemop1v //"ABC123"
//
//                                System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+str_payprovider);
//                                System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"00");
//                                System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+picker_leo.getText());
//                                System.err.println(i+" Writing to Storage data for new "+"btn_payoption1_row"+"1,2,3"+" ---> "+"");
//                            }
//                        }
//                }
                
        Dialog dlg_payOps = new Dialog();
        dlg_payOps.setLayout(new BorderLayout());
                
        Button btn_funga = new Button();
        btn_funga.setIcon(theme.getImage("cancel.png"));
        btn_funga.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_payOps.dispose();
            }
        });

        Label lbl_dlg_ttl = new Label();
        lbl_dlg_ttl.getAllStyles().setAlignment(CENTER);
        lbl_dlg_ttl.setText("Select Payment Options");

        Button btn_minise = new Button();
        btn_minise.setIcon(theme.getImage("minimise.png"));
        btn_minise.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                dlg_payOps.dispose();                   
            }
        });
        
        Container cnt_dlg_header = new Container(new BorderLayout());
        //cnt_dlg_header.add(BorderLayout.WEST, btn_minise);
        cnt_dlg_header.add(BorderLayout.CENTER, lbl_dlg_ttl);
        //cnt_dlg_header.add(BorderLayout.EAST, btn_funga);
        
        TableLayout laytab = new TableLayout(1, 10);
        cnt_payment_methods = new Container(new GridLayout(1, 6)); //new BoxLayout(BoxLayout.X_AXIS) //new FlowLayout(CENTER, CENTER) //new GridLayout(1, 7)
        cnt_payment_methods.getAllStyles().setAlignment(CENTER, false);
        //cnt_payment_methods.setLayout(laytab);
        cnt_payment_methods.setScrollableX(true);
        cnt_payment_methods.setName("cnt_payment_methods");
        //cnt_pay_providers.getStyle().setBgImage(img_background);
        
        cnt_payment_providers = new Container(new BoxLayout(BoxLayout.X_AXIS)); //new BoxLayout(BoxLayout.X_AXIS) //new FlowLayout(CENTER, CENTER) //new GridLayout(1, 5)
        cnt_payment_providers.getAllStyles().setAlignment(CENTER, false);
        cnt_payment_providers.setName("Payment Options");
        cnt_payment_providers.setScrollableX(true);
        
        
        
        
        ///////////////////////////////////////////////////////////////////////////////////
        
        str_totals = Storage.getInstance().readObject("totals").toString();
        int_totals = Integer.parseInt(str_totals);
        
        str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
        int_no_new_items = Integer.parseInt(str_no_new_items);
        
        if(str_table.equals("main_table"))
        {
            str_itemop = Storage.getInstance().readObject("main_itemop"+str_colid+"_"+str_rowid).toString(); //cash
            str_item = Storage.getInstance().readObject("main_item_"+str_rowid).toString();                  //Combined Off.

            str_subtotals = Storage.getInstance().readObject("main_itemv_"+str_rowid).toString();
            int_subtotal = Integer.parseInt(str_subtotals);

            int_subtotals1 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"1"+"v_"+str_rowid).toString());
            int_subtotals2 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"2"+"v_"+str_rowid).toString());
            int_subtotals3 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"3"+"v_"+str_rowid).toString());
        }
        else
        {
            bool_itemop = Storage.getInstance().exists("new_itemop"+str_colid+"_"+str_rowid);
            if(bool_itemop == true)
            {
                str_itemop = Storage.getInstance().readObject("new_itemop"+str_colid+"_"+str_rowid).toString(); //cash
                str_item = Storage.getInstance().readObject("new_item_"+str_rowid).toString();                  //Combined Off.
            }
            else
            {
            }
            
            
            str_subtotals = Storage.getInstance().readObject("new_itemv_"+str_rowid).toString();
            int_subtotal = Integer.parseInt(str_subtotals);

            
            bool_itemop1v = Storage.getInstance().exists("new_itemop"+"1"+"v_"+str_rowid);
            if(bool_itemop1v == true)
            {
                int_subtotals1 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"1"+"v_"+str_rowid).toString());
            }
            else
            {
                int_subtotals1 = 0;
            }
            
            bool_itemop2v = Storage.getInstance().exists("new_itemop"+"2"+"v_"+str_rowid);
            if(bool_itemop2v == true)
            {
                int_subtotals2 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"2"+"v_"+str_rowid).toString());
            }
            else
            {
                int_subtotals2 = 0;
            }
            
            bool_itemop3v = Storage.getInstance().exists("new_itemop"+"3"+"v_"+str_rowid);
            if(bool_itemop3v == true)
            {
                int_subtotals3 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"3"+"v_"+str_rowid).toString());
            }
            else
            {
                int_subtotals3 = 0;
            }
        }
        
        
        
        //for(k=0; k < int_no_items; k++){}
        //int_subtotals = Integer.parseInt(str_tithev)+Integer.parseInt(str_offeringv)+Integer.parseInt(str_buildingv)+Integer.parseInt(str_budgetv);
        
        Button btn_add_photo = new Button();
        btn_add_photo.setText("Add Photo");
        btn_add_photo.setTextPosition(BOTTOM);
        btn_add_photo.addActionListener(new ActionListener() 
        {
          @Override
          public void actionPerformed(ActionEvent evt) 
          {
                ////doFileUploadDemo();
                //doPic();
                int width = Display.getInstance().getDisplayWidth();
                String str_imgpath = Capture.capturePhoto(width, -1);
                Storage.getInstance().writeObject("image_path", str_imgpath);

                if(str_imgpath == null){}
              
                Button btn_funga = new Button();
                btn_funga.setIcon(theme.getImage("cancel.png"));
                btn_funga.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        dlg_payOps.dispose();
                    }
                });

                Label lbl_dlg_ttl = new Label();
                lbl_dlg_ttl.getAllStyles().setAlignment(CENTER);
                lbl_dlg_ttl.setText("Select Payment Options");

                Button btn_minise = new Button();
                btn_minise.setIcon(theme.getImage("minimise.png"));
                btn_minise.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt)
                    {
                        dlg_payOps.dispose();                   
                    }
                });

                Container cnt_title_bar = new Container(new BorderLayout());
                //cnt_title_bar.add(BorderLayout.WEST, btn_minise);
                cnt_title_bar.add(BorderLayout.CENTER, lbl_dlg_ttl);
                //cnt_title_bar.add(BorderLayout.EAST, btn_funga);

                  try 
                  {
                        InputStream in = FileSystemStorage.getInstance().openInputStream(str_imgpath);
                        OutputStream out = Storage.getInstance().createOutputStream("MyImage.png"); //String photoName = "" + System.currentTimeMillis();
                        Util.copy(in, out);
                        Util.cleanup(in);
                        Util.cleanup(out);

                        InputStream is = Storage.getInstance().createInputStream("MyImage.png");
                        Image img_ballotPaper = EncodedImage.createImage(is).scaledHeight(int_dispW/2);
                        //btn_add_photo.setIcon(img_ballotPaper.scaledWidth(displayWidth/4));
                        //btn_add_photo.remove();

                        //Image img = Image.createImage(img_ballotPaper).fill(circleMaskImage.getWidth(), circleMaskImage.getHeight());
                        //lbl_pic.setIcon(img.applyMask(circleMask));
                  } 
                  catch (Exception e) 
                  {
                        System.out.println("Error: "+e);
                        //e.printStackTrace();
                  }
          }
       });

        Button btn_view_photo = new Button("View Photo");
        btn_view_photo.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                  Dialog dlg_pic = new Dialog("Captured Results Photo");
                  dlg_pic.setLayout(new BorderLayout());

                  Label lbl_photo = new Label();


                  Button btn_funga = new Button("Close");
                  btn_funga.addActionListener(new ActionListener() 
                  {
                      @Override
                      public void actionPerformed(ActionEvent evt) 
                      {
                          dlg_pic.dispose();
                      }
                  });

                  dlg_pic.add(BorderLayout.CENTER, FlowLayout.encloseCenterMiddle(lbl_photo));
                  dlg_pic.add(BorderLayout.SOUTH, btn_funga);

                  try
                  {
                      InputStream is = Storage.getInstance().createInputStream("MyImage.png");
                      Image img_ballotPaper = EncodedImage.createImage(is).scaledHeight(int_dispW/2);
                      //btn_add_photo.setIcon(img_ballotPaper.scaledWidth(displayWidth/4));
                      lbl_photo.setIcon(img_ballotPaper);
                      dlg_pic.show();
                  } 
                  catch (Exception e) 
                  {
                      String str_errorType = StringUtil.tokenize(e.toString(), ":").get(0);
                      if(str_errorType.equals("java.io.FileNotFoundException"))
                      {
                          Dialog.show("Error Occured!", "You have not added a picture yet.", "Ok", null);
                      }
                      else
                      {
                          Dialog.show("Error Occured!", ">> "+e, "Ok", null);
                          System.out.println(">>"+e); //java.io.FileNotFoundException: C:\Users\Tommy Mogaka\.cn1\MyImage.png (The system cannot find the file specified)
                      }
                  }
            }
        });
        
        Container cnt_cmds_pic = new Container(new BorderLayout());
        cnt_cmds_pic.add(BorderLayout.WEST, btn_add_photo);
        cnt_cmds_pic.add(BorderLayout.EAST, btn_view_photo);
        
        
       // bool_startdate = Storage.getInstance().exists("");
       //if(str_start.equals("")){str_start = picker_leo.getText();}
       
        Style styro = new Style();
        styro.setFgColor(0xC0C0C0, true);
       
        cldr_start = new Calendar(); 
        cldr_start.setChangesSelectedDateEnabled(true); //txtf_taskBegining = new TextField(str_task_beginning);
        
        txtf_start = new TextField(str_start, "Start Date");
        txtf_start.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
        txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
        txtf_start.getHintLabel().getUnselectedStyle().setFont(font_medium_plain, false);
        txtf_start.getHintLabel().getSelectedStyle().setFgColor(0x000000, false);
        txtf_start.getHintLabel().getSelectedStyle().setFont(font_medium_plain, false);
        txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
        txtf_start.getHintLabel().setDisabledStyle(styro);
        txtf_start.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_start.getUnselectedStyle().getBorder().setThickness(3);
        txtf_start.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_start.getSelectedStyle().getBorder().setThickness(3);
        txtf_start.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_start.getPressedStyle().getBorder().setThickness(3);
        txtf_start.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_start.getDisabledStyle().getBorder().setThickness(3);
        txtf_start.setEditable(false);
        txtf_start.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("Preparing to show place to set start date.", 1);
                Storage.getInstance().writeObject("transaction", "set_sdate");
                showDaySelector();
            }
        });
                
        TextField txtf_refno = new TextField();
        txtf_refno.setHint("Ref Number");
        txtf_refno.setConstraint(ANY);
        txtf_refno.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
        txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
        txtf_refno.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
        txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_refno.getSelectedStyle().getBorder().setThickness(3);
        txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_refno.getPressedStyle().getBorder().setThickness(3);
        
        TextField txtf_amount = new TextField();
        txtf_amount.setHint("Amount");
        txtf_amount.setConstraint(NUMERIC);
        txtf_amount.getAllStyles().setMargin(0, (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM), (int)(0.2 * pixelsPerMM)); 
        txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
        txtf_amount.getHintLabel().getStyle().setFont(font_medium_plain, false);
        txtf_amount.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_amount.getUnselectedStyle().getBorder().setThickness(3);
        txtf_amount.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_amount.getSelectedStyle().getBorder().setThickness(3);
        txtf_amount.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
        txtf_amount.getPressedStyle().getBorder().setThickness(3);
                
      
        btn_0_5 = new Button();
        btn_0_5.setIcon(theme.getImage("50_cents_coin_ke.png"));
        //btn_0_5.setText("0");
        btn_0_5.setTextPosition(BOTTOM);
        btn_0_5.getAllStyles().setFgColor(0x000000);
        btn_0_5.getAllStyles().setBgTransparency(0);
        btn_0_5.getAllStyles().setFont(font_small_plain);
        btn_0_5.getAllStyles().setPadding(0, 0, 0, 0);
        btn_0_5.getAllStyles().setMargin(0, 0, (int)(0.5 * pixelsPerMM), (int)(0.05 * pixelsPerMM));
        btn_0_5.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_1 = new Button();
        btn_1.setIcon(theme.getImage("1_shilling_coin_ke.png"));
        //btn_1.setText("0");
        btn_1.setTextPosition(BOTTOM);
        btn_1.getAllStyles().setFgColor(0x000000);
        btn_1.getAllStyles().setBgTransparency(0);
        btn_1.getAllStyles().setFont(font_small_plain);
        btn_1.getAllStyles().setPadding(0, 0, 0, 0);
        btn_1.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_1.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_5 = new Button();
        btn_5.setIcon(theme.getImage("5_shillings_coin_ke.png"));
        //btn_5.setText("0");
        btn_5.setTextPosition(BOTTOM);
        btn_5.getAllStyles().setFgColor(0x000000);
        btn_5.getAllStyles().setBgTransparency(0);
        btn_5.getAllStyles().setFont(font_small_plain);
        btn_5.getAllStyles().setPadding(0, 0, 0, 0);
        btn_5.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_5.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_10 = new Button();
        btn_10.setIcon(theme.getImage("10_shillings_coin_ke.png"));
        //btn_10.setText("0");
        btn_10.setTextPosition(BOTTOM);
        btn_10.getAllStyles().setFgColor(0x000000);
        btn_10.getAllStyles().setBgTransparency(0);
        btn_10.getAllStyles().setFont(font_small_plain);
        btn_10.getAllStyles().setPadding(0, 0, 0, 0);
        btn_10.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_10.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_20 = new Button();
        btn_20.setIcon(theme.getImage("20_shillings_coin_ke.png"));
        //btn_20.setText("0");
        btn_20.setTextPosition(BOTTOM);
        btn_20.getAllStyles().setFgColor(0x000000);
        btn_20.getAllStyles().setBgTransparency(0);
        btn_20.getAllStyles().setFont(font_small_plain);
        btn_20.getAllStyles().setPadding(0, 0, 0, 0);
        btn_20.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_20.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_40 = new Button();
        btn_40.setIcon(theme.getImage("40_shillings_coin_ke.jpg"));
        //btn_40.setText("0");
        btn_40.setTextPosition(BOTTOM);
        btn_40.getAllStyles().setFgColor(0x000000);
        btn_40.getAllStyles().setBgTransparency(0);
        btn_40.getAllStyles().setFont(font_small_plain);
        btn_40.getAllStyles().setPadding(0, 0, 0, 0);
        btn_40.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_40.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_50 = new Button();
        btn_50.setIcon(theme.getImage("50_shillings_note_ke.png"));
        //btn_50.setText("0");
        btn_50.setTextPosition(BOTTOM);
        btn_50.getAllStyles().setFgColor(0x000000);
        btn_50.getAllStyles().setBgTransparency(0);
        btn_50.getAllStyles().setFont(font_small_plain);
        btn_50.getAllStyles().setPadding(0, 0, 0, 0);
        btn_50.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_50.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_100 = new Button();
        btn_100.setIcon(theme.getImage("100_shillings_note_ke.png"));
        //btn_100.setText("0");
        btn_100.setTextPosition(BOTTOM);
        btn_100.getAllStyles().setFgColor(0x000000);
        btn_100.getAllStyles().setBgTransparency(0);
        btn_100.getAllStyles().setFont(font_small_plain);
        btn_100.getAllStyles().setPadding(0, 0, 0, 0);
        btn_100.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_100.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_200 = new Button();
        btn_200.setIcon(theme.getImage("200_shillings_note_ke.png"));
        //btn_200.setText("0");
        btn_200.setTextPosition(BOTTOM);
        btn_200.getAllStyles().setFgColor(0x000000);
        btn_200.getAllStyles().setBgTransparency(0);
        btn_200.getAllStyles().setFont(font_small_plain);
        btn_200.getAllStyles().setPadding(0, 0, 0, 0);
        btn_200.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_200.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_500 = new Button();
        btn_500.setIcon(theme.getImage("500_shillings_note_ke.png"));
        //btn_500.setText("0");
        btn_500.setTextPosition(BOTTOM);
        btn_500.getAllStyles().setFgColor(0x000000);
        btn_500.getAllStyles().setBgTransparency(0);
        btn_500.getAllStyles().setFont(font_small_plain);
        btn_500.getAllStyles().setPadding(0, 0, 0, 0);
        btn_500.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_500.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        btn_1000 = new Button();
        btn_1000.setIcon(theme.getImage("1000_shillings_note_ke.png"));
        //btn_1000.setText("0");
        btn_1000.setTextPosition(BOTTOM);
        btn_1000.getAllStyles().setFgColor(0x000000);
        btn_1000.getAllStyles().setBgTransparency(0);
        btn_1000.getAllStyles().setFont(font_small_plain);
        btn_1000.getAllStyles().setPadding(0, 0, 0, 0);
        btn_1000.getAllStyles().setMargin(0, 0, (int)(0.1 * pixelsPerMM), (int)(0.1 * pixelsPerMM));
        btn_1000.addActionListener(new ActionListener() 
        {
              @Override
              public void actionPerformed(ActionEvent evt) 
              {
                  showBreakDownForm();
              }
        });

        lbl_payprovider_spacer = new Label();
        lbl_payprovider_spacer.setIcon(theme.getImage("paymeth_spacer.png"));
        lbl_payprovider_spacer.setText("");
        lbl_payprovider_spacer.setTextPosition(BOTTOM);
        lbl_payprovider_spacer.getAllStyles().setFgColor(0x000000);
        lbl_payprovider_spacer.getAllStyles().setBgTransparency(0);
        lbl_payprovider_spacer.getAllStyles().setFont(font_small_bold);
        lbl_payprovider_spacer.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                
            }
        });
        
        
        
        lbl_card = new Label();
        lbl_card.setIcon(theme.getImage("pay_card.png"));
        lbl_card.setText("Card");
        lbl_card.setTextPosition(BOTTOM);
        lbl_card.getAllStyles().setFgColor(0x000000);
        lbl_card.getAllStyles().setBgTransparency(0);
        lbl_card.getAllStyles().setFont(font_small_bold);
        lbl_card.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "card";
                System.out.println(str_paymethod+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //card label got pressed at column 1 on row 0.
                
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                }
                
                //bool_itemopv = Storage.getInstance().exists("main_itemop"+str_colid+"v_"+str_rowid);
                //if(bool_itemopv == true)
                //{
                //    str_itemopv = Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString();
                //    if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                //    {
                //        System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                //        txtf_amount.setText("");
                //    }
                //    else
                //    {
                //        //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                //        System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                //        txtf_amount.setText(str_itemopv);
                //    }
                //}
                //else
                //{
                //        System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                //        txtf_amount.setText("");
                //}
                
                //Storage.getInstance().writeObject("paymethod", str_paymethod);
                //Storage.getInstance().writeObject("payprovider", "-------");
                //Storage.getInstance().writeObject("temp_trx_number", "-------");
                //Storage.getInstance().writeObject("temp_ref_number", "-------");
                
                //str_iterid
                
                //System.out.println("Going to show Invoice.");
                //showInvoice();
                
                txtf_start.setFocusable(false);
                txtf_start.setEditable(false);
                txtf_start.setEnabled(false);
                txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                txtf_start.repaint();

                //txtf_refno.setVisible(true);
                txtf_refno.setFocusable(true);
                txtf_refno.setEditable(true);
                txtf_refno.setEnabled(true);
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                txtf_amount.setFocusable(true);
                txtf_amount.setEditable(true);
                txtf_amount.setEnabled(true);
                txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(lbl_mastercard);
                cnt_payment_providers.add(lbl_visa);

                lbl_card.getAllStyles().setBorder(border);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);

                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                dlg_payOps.repaint();
            }
        });
        cnt_payment_methods.add(lbl_card);
        
        lbl_cash = new Label();
        lbl_cash.setIcon(theme.getImage("pay_cash.png"));
        lbl_cash.setText("Cash");
        lbl_cash.getAllStyles().setBgTransparency(0);
        lbl_cash.setTextPosition(BOTTOM);
        lbl_cash.getAllStyles().setFgColor(0x000000);
        lbl_cash.getAllStyles().setFont(font_small_bold);
        lbl_cash.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {                
                str_paymethod = "cash";
                str_payprovider = "cash";
                                
                System.out.println(str_paymethod+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Cash label got pressed at column 1 on row 0.                
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                                
                                
                txtf_start.setFocusable(false);
                txtf_start.setEditable(false);
                txtf_start.setEnabled(false);
                txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                
                txtf_start.repaint();

                //txtf_refno.setVisible(false);
                txtf_refno.setFocusable(false);
                txtf_refno.setEditable(false);
                txtf_refno.setEnabled(false);
                txtf_refno.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                txtf_refno.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getDisabledStyle().getBorder().setThickness(3);
                
                txtf_amount.setFocusable(true);
                txtf_amount.setEditable(true);
                txtf_amount.setEnabled(true);
                txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                
                //Log.p("Writing paym to storage "+str_paymethod, 1);
                //Log.p("Writing payp to storage "+str_payprovider, 1);
                //Log.p("Writing date to storage "+txtf_start.getText(), 1);
                //Log.p("Writing ref# to storage "+"AE1235473", 1); //txtf_refno.getText()
                //Log.p("Writing amnt to storage "+txtf_amount.getText(), 1);
                            
                //Storage.getInstance().writeObject("paymethod", str_paymethod);
                //Storage.getInstance().writeObject("payprovider", str_payprovider);
                //Storage.getInstance().writeObject("temp_ref_number",  "AE1235473");
                
                System.out.println("Generating random number.");
                doRandomNum();

                //System.out.println("Going to show Invoice.");
                //showInvoice();
                
                
                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(btn_0_5);
                cnt_payment_providers.add(btn_1);
                cnt_payment_providers.add(btn_5);
                cnt_payment_providers.add(btn_10);
                cnt_payment_providers.add(btn_20);
                cnt_payment_providers.add(btn_40);
                cnt_payment_providers.add(btn_50);
                cnt_payment_providers.add(btn_100);
                cnt_payment_providers.add(btn_200);
                cnt_payment_providers.add(btn_500);
                cnt_payment_providers.add(btn_1000);               
                
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(border);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);
                
                //cnt_cmds_pic.setVisible(false);
                
                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                dlg_payOps.repaint();                
            }
        });
        cnt_payment_methods.add(lbl_cash);
        
        lbl_bank = new Label();
        lbl_bank.setIcon(theme.getImage("pay_bank.png"));
        lbl_bank.setText("Bank");
        lbl_bank.getAllStyles().setBgTransparency(0);
        lbl_bank.setTextPosition(BOTTOM);
        lbl_bank.getAllStyles().setFgColor(0x000000);
        lbl_bank.getAllStyles().setFont(font_small_bold);
        lbl_bank.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "bank";
                str_payprovider = "bank";
                System.out.println(str_paymethod+" label got pressed.");
                                                
                System.out.println(str_paymethod+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Cash label got pressed at column 1 on row 0.
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                
                //txtf_refno.setVisible(true);
                txtf_refno.setFocusable(true);
                txtf_refno.setEditable(true);
                txtf_refno.setEnabled(true);
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                //txtf_start.setVisible(true);
                txtf_start.setFocusable(false);
                txtf_start.setEditable(false);
                txtf_start.setEnabled(false);
                txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                
                txtf_amount.setFocusable(true);
                txtf_amount.setEditable(true);
                txtf_amount.setEnabled(true);
                txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                cnt_payment_providers.removeAll();

                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(border);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);

                cnt_cmds_pic.setVisible(true);

                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                dlg_payOps.repaint();
            }
        });
        cnt_payment_methods.add(lbl_bank);
        
        lbl_mobile = new Label();
        lbl_mobile.setIcon(theme.getImage("pay_mobile.png"));
        lbl_mobile.setText("MobileM");
        lbl_mobile.getAllStyles().setBgTransparency(0);
        lbl_mobile.setTextPosition(BOTTOM);
        lbl_mobile.getAllStyles().setFgColor(0x000000);
        lbl_mobile.getAllStyles().setFont(font_small_bold);
        lbl_mobile.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "mobile";
                System.out.println(str_paymethod+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Cash label got pressed at column 1 on row 0.
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                }
                
                Storage.getInstance().deleteStorageFile("main_itemop"+str_colid+"p_"+str_rowid);
                                
                //txtf_refno.setVisible(true);
                txtf_refno.setFocusable(true);
                txtf_refno.setEditable(true);
                txtf_refno.setEnabled(true);
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                //txtf_start.setVisible(true);
                txtf_start.setFocusable(false);
                txtf_start.setEditable(false);
                txtf_start.setEnabled(false);
                txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                
                txtf_amount.setFocusable(true);
                txtf_amount.setEditable(true);
                txtf_amount.setEnabled(true);
                txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(lbl_mpesa);
                cnt_payment_providers.add(lbl_airtelzap);
                cnt_payment_providers.add(lbl_telkom);
                cnt_payment_providers.add(lbl_equitel);
                
                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(border);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(null);
                
                //cnt_cmds_pic.setVisible(false);
                
                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                dlg_payOps.repaint();
            }
        });
        cnt_payment_methods.add(lbl_mobile);
        
        lbl_cheque = new Label();
        lbl_cheque.setIcon(theme.getImage("pay_cheque.png"));
        lbl_cheque.setText("Cheque");
        lbl_cheque.getAllStyles().setBgTransparency(0);
        lbl_cheque.setTextPosition(BOTTOM);
        lbl_cheque.getAllStyles().setFgColor(0x000000);
        lbl_cheque.getAllStyles().setFont(font_small_bold);
        lbl_cheque.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "cheque";
                str_payprovider = "cheque";
                System.out.println(str_paymethod+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Cash label got pressed at column 1 on row 0.
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                
                //txtf_refno.setVisible(true);
                txtf_refno.setFocusable(true);
                txtf_refno.setEditable(true);
                txtf_refno.setEnabled(true);
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                //txtf_start.setVisible(true);
                txtf_start.setFocusable(true);
                txtf_start.setEditable(true);
                txtf_start.setEnabled(true);
                txtf_start.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                txtf_amount.setFocusable(true);
                txtf_amount.setEditable(true);
                txtf_amount.setEnabled(true);
                txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                btn_add_photo.setText("Add Cheque");
                btn_view_photo.setText("View Cheque");
                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(cnt_cmds_pic);

                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(border);
                lbl_direct.getAllStyles().setBorder(null);

                cnt_cmds_pic.setVisible(true);

                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                dlg_payOps.repaint();
            }
        });
        cnt_payment_methods.add(lbl_cheque);
                
        lbl_direct = new Label();
        lbl_direct.setIcon(theme.getImage("direct.png"));
        lbl_direct.setText("Direct");
        lbl_direct.getAllStyles().setBgTransparency(0);
        lbl_direct.setTextPosition(BOTTOM);
        lbl_direct.getAllStyles().setFgColor(0x000000);
        lbl_direct.getAllStyles().setFont(font_small_bold);
        lbl_direct.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_paymethod = "Direct Deposit"; 
                str_payprovider = "direct";
                System.out.println(str_paymethod+" label got pressed.");
                System.out.println(str_payprovider+" label got pressed.");
                                
                System.out.println(str_paymethod+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Direct Deposit label got pressed at column 1 on row 0.
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemopm"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                
                //txtf_refno.setVisible(true);
                txtf_refno.setFocusable(true);
                txtf_refno.setEditable(true);
                txtf_refno.setEnabled(true);
                txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, true);
                txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, true);
                
                //txtf_start.setVisible(true);
                txtf_start.setFocusable(false);
                txtf_start.setEditable(false);
                txtf_start.setEnabled(false);
                txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                
                txtf_amount.setFocusable(true);
                txtf_amount.setEditable(true);
                txtf_amount.setEnabled(true);
                txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                
                btn_add_photo.setText("Add Slip");
                btn_view_photo.setText("View Slip");
                cnt_payment_providers.removeAll();
                cnt_payment_providers.add(cnt_cmds_pic);

                lbl_card.getAllStyles().setBorder(null);
                lbl_cash.getAllStyles().setBorder(null);
                lbl_bank.getAllStyles().setBorder(null);
                lbl_mobile.getAllStyles().setBorder(null);
                lbl_cheque.getAllStyles().setBorder(null);
                lbl_direct.getAllStyles().setBorder(border);

                cnt_payment_providers.revalidate();
                cnt_payment_methods.revalidate();
                dlg_payOps.repaint(); 
            }
        });
        cnt_payment_methods.add(lbl_direct);
        
        lbl_mpesa = new Label(theme.getImage("safaricom.png"));
        lbl_mpesa.getAllStyles().setBgTransparency(0);
        lbl_mpesa.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_payprovider = "Mpesa";
                System.out.println(str_payprovider+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Mastercard label got pressed at column 1 on row 0.
                
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider); //TODO: Consider removing this as seems to have no use.
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);//str_itemop1  //"Mpesa"
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                                
                lbl_airtelzap.getAllStyles().setBorder(null);
                lbl_mpesa.getAllStyles().setBorder(border);
                lbl_telkom.getAllStyles().setBorder(null);
                lbl_equitel.getAllStyles().setBorder(null);
             
                
                cnt_payment_providers.revalidate();
                dlg_payOps.repaint();
            }
        });
                
        lbl_airtelzap = new Label(theme.getImage("airtel.png"));
        lbl_airtelzap.getAllStyles().setBgTransparency(0);
        lbl_airtelzap.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_payprovider = "Airtel Money";
                System.out.println(str_payprovider+" label got pressed at column "+str_colid+" on row "+str_rowid+".");
                
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider); //TODO: Consider removing this as seems to have no use.
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);//str_itemop1  //"Mpesa"
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                
                lbl_airtelzap.getAllStyles().setBorder(border);
                lbl_mpesa.getAllStyles().setBorder(null);
                lbl_telkom.getAllStyles().setBorder(null);
                lbl_equitel.getAllStyles().setBorder(null);
                
                cnt_payment_providers.revalidate();
                dlg_payOps.repaint();
            }
        });
                
        lbl_telkom = new Label(theme.getImage("telkom.png"));
        lbl_telkom.getAllStyles().setBgTransparency(0);
        lbl_telkom.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_payprovider = "Telkom";
                System.out.println(str_payprovider+" label got pressed at column "+str_colid+" on row "+str_rowid+".");
                
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider); //TODO: Consider removing this as seems to have no use.
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);//str_itemop1  //"Mpesa"
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                
                lbl_airtelzap.getAllStyles().setBorder(null);
                lbl_mpesa.getAllStyles().setBorder(null);
                lbl_telkom.getAllStyles().setBorder(border);
                lbl_equitel.getAllStyles().setBorder(null);
                
                cnt_payment_providers.revalidate();
                dlg_payOps.repaint();
            }
        });
        
        lbl_equitel = new Label(theme.getImage("equitel.png"));
        lbl_equitel.getAllStyles().setBgTransparency(0);
        lbl_equitel.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_payprovider = "Equitel";
                System.out.println(str_payprovider+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Mastercard label got pressed at column 1 on row 0.
                
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider); //TODO: Consider removing this as seems to have no use.
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);//str_itemop1  //"Mpesa"
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                        
                lbl_airtelzap.getAllStyles().setBorder(null);
                lbl_mpesa.getAllStyles().setBorder(null);
                lbl_telkom.getAllStyles().setBorder(null);
                lbl_equitel.getAllStyles().setBorder(border);
                               
                cnt_payment_providers.revalidate();
                dlg_payOps.repaint();
            }
        });
        
        lbl_mastercard = new Label(theme.getImage("mastercard.png"));
        lbl_mastercard.getAllStyles().setBgTransparency(0);
        lbl_mastercard.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_payprovider = "Mastercard";
                System.out.println(str_payprovider+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Mastercard label got pressed at column 1 on row 0.
                
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider); //TODO: Consider removing this as seems to have no use.
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);//str_itemop1  //"Mpesa"
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                                
                lbl_visa.getAllStyles().setBorder(null);
                lbl_mastercard.getAllStyles().setBorder(border);
                
                cnt_payment_providers.revalidate();
                dlg_payOps.repaint();
            }
        });
                
        lbl_visa = new Label(theme.getImage("visa.png"));
        lbl_visa.getAllStyles().setBgTransparency(0);
        lbl_visa.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                str_payprovider = "Visa";
                System.out.println(str_payprovider+" label got pressed at column "+str_colid+" on row "+str_rowid+"."); //Mastercard label got pressed at column 1 on row 0.
                
                if(str_table.equals("main_table"))
                {
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider); //TODO: Consider removing this as seems to have no use.
                    Storage.getInstance().writeObject("main_itemop"+str_colid+"p_"+str_rowid, str_payprovider);//str_itemop1  //"Mpesa"
                }
                else
                {
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                    Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
                }
                                
                lbl_visa.getAllStyles().setBorder(border);
                lbl_mastercard.getAllStyles().setBorder(null);
                
                cnt_payment_providers.revalidate();
                dlg_payOps.repaint();
            }
        });
        
        //Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid,  str_paymethod);
        str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
        int_no_main_items = Integer.parseInt(str_no_main_items);
        sb_main_item = new StringBuilder();
        
        System.out.println("No of Main Items: "+str_no_main_items);
        //System.out.println("No of Main Items Selected: "+Storage.getInstance().readObject("no_itemsel").toString());
        //"main_itemop"+str_colid+"v_"+str_rowid
       
        //if(Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString().equals("") || Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString().equals("0"))
        //{
        //}
        
        if(str_table.equals("main_table"))
        {
            bool_payment_method = Storage.getInstance().exists("main_itemopm"+str_colid+"_"+str_rowid);
            if(bool_payment_method == true)
            {
                str_paymethod = Storage.getInstance().readObject("main_itemopm"+str_colid+"_"+str_rowid).toString(); 
                if(str_paymethod.equals("card"))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.repaint();

                    txtf_refno.setVisible(true);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(border);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(null);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(null);

                    cnt_payment_providers.add(lbl_mastercard);
                    cnt_payment_providers.add(lbl_visa);

                    bool_itemopr = Storage.getInstance().exists("main_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("main_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals("") || str_itemopr.equals("N/a"))
                        {
                            System.out.println("Setting value for "+str_paymethod+" Ref # textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                            txtf_refno.setText(str_itemopr);  
                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for "+str_paymethod+" Ref # textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                        System.out.println("Setting value for "+str_paymethod+" Ref # textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                        txtf_refno.setText("");
                    }

                    bool_itemopv = Storage.getInstance().exists("main_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {
                            System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                            txtf_amount.setText("");
                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                            System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                            txtf_amount.setText("");
                    }
                }
                else if(str_paymethod.equals("cash"))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_start.repaint();

                    txtf_refno.setFocusable(false);
                    txtf_refno.setEditable(false);
                    txtf_refno.setEnabled(false);
                    txtf_refno.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                    txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                    txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                    txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                    txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                    txtf_refno.getPressedStyle().getBorder().setThickness(3);
                    txtf_refno.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                    txtf_refno.getDisabledStyle().getBorder().setThickness(3);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);


                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(border);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(null);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(null);

                    cnt_payment_providers.removeAll();
                    cnt_payment_providers.add(btn_0_5);
                    cnt_payment_providers.add(btn_1);
                    cnt_payment_providers.add(btn_5);
                    cnt_payment_providers.add(btn_10);
                    cnt_payment_providers.add(btn_20);
                    cnt_payment_providers.add(btn_40);
                    cnt_payment_providers.add(btn_50);
                    cnt_payment_providers.add(btn_100);
                    cnt_payment_providers.add(btn_200);
                    cnt_payment_providers.add(btn_500);
                    cnt_payment_providers.add(btn_1000);

                    bool_itemopv = Storage.getInstance().exists("main_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }
                }
                else if(str_paymethod.equals("bank"))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_start.repaint();

                    //txtf_refno.setVisible(false);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(border);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(null);

                    cnt_payment_providers.add(lbl_mpesa);
                    cnt_payment_providers.add(lbl_airtelzap);
                    cnt_payment_providers.add(lbl_telkom);
                    cnt_payment_providers.add(lbl_equitel);

                    bool_itemopr = Storage.getInstance().exists("main_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("main_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals("") || str_itemopr.equals("N/a"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Ref # textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopv = Storage.getInstance().exists("main_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }
                }
                else if(str_paymethod.equals("mobile"))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_start.repaint();

                    //txtf_refno.setVisible(false);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(border);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(null);

                    cnt_payment_providers.add(lbl_mpesa);
                    cnt_payment_providers.add(lbl_airtelzap);
                    cnt_payment_providers.add(lbl_telkom);
                    cnt_payment_providers.add(lbl_equitel);

                    bool_itemopr = Storage.getInstance().exists("main_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("main_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals("") || str_itemopr.equals("N/a"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Ref # textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopv = Storage.getInstance().exists("main_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }
                }
                else if(str_paymethod.equals("cheque"))
                {
                    txtf_start.setFocusable(true);
                    txtf_start.setEditable(true);
                    txtf_start.setEnabled(true);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xdc1212, false);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                    txtf_start.repaint();

                    //txtf_refno.setVisible(false);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(null);
                    lbl_cheque.getAllStyles().setBorder(border);
                    lbl_direct.getAllStyles().setBorder(null);

                    btn_add_photo.setText("Add Cheque");
                    btn_view_photo.setText("View Cheque");
                    cnt_payment_providers.removeAll();
                    cnt_payment_providers.add(cnt_cmds_pic);

                    bool_itemopv = Storage.getInstance().exists("main_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopr = Storage.getInstance().exists("main_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("main_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals("") || str_itemopr.equals("N/a"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Ref # textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopd = Storage.getInstance().exists("main_itemop"+str_colid+"d_"+str_rowid);
                    if(bool_itemopd == true)
                    {
                        str_itemopd = Storage.getInstance().readObject("main_itemop"+str_colid+"d_"+str_rowid).toString();
                        if(str_itemopd.equals(""))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Date textfield "+"main_itemop"+str_colid+"d_"+str_rowid+" => "+str_itemopd);
                            txtf_start.setText(str_itemopd);
                        }
                    }
                    else
                    {
                    }
                }
                else if(str_paymethod.equals("direct" ))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_start.repaint();

                    //txtf_refno.setVisible(false);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(null);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(border);

                    btn_add_photo.setText("Add Slip");
                    btn_view_photo.setText("View Slip");
                    cnt_payment_providers.removeAll();
                    cnt_payment_providers.add(cnt_cmds_pic);

                    bool_itemopv = Storage.getInstance().exists("main_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("main_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopr = Storage.getInstance().exists("main_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("main_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals(""))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Ref # textfield "+"main_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                    }
                }
                else
                {
                    //No options will be highlighted [boxed]
                    cnt_payment_providers.add(lbl_payprovider_spacer);
                }
            }
            else
            { 
                txtf_start.setFocusable(false);
                txtf_start.setEditable(false);
                txtf_start.setEnabled(false);
                txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                txtf_start.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getUnselectedStyle().getBorder().setThickness(3);
                txtf_start.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getSelectedStyle().getBorder().setThickness(3);
                txtf_start.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getPressedStyle().getBorder().setThickness(3);
                txtf_start.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getDisabledStyle().getBorder().setThickness(3);
                txtf_start.repaint();

                txtf_refno.setFocusable(false);
                txtf_refno.setEditable(false);
                txtf_refno.setEnabled(false);
                txtf_refno.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
                txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                txtf_refno.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getDisabledStyle().getBorder().setThickness(3);

                txtf_amount.setFocusable(false);
                txtf_amount.setEditable(false);
                txtf_amount.setEnabled(false);
                txtf_amount.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
                txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                txtf_amount.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getUnselectedStyle().getBorder().setThickness(3);
                txtf_amount.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getSelectedStyle().getBorder().setThickness(3);
                txtf_amount.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getPressedStyle().getBorder().setThickness(3);
                txtf_amount.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getDisabledStyle().getBorder().setThickness(3);

                cnt_payment_providers.add(lbl_payprovider_spacer);
            }
            
            bool_payment_provider = Storage.getInstance().exists("main_itemop"+str_colid+"p_"+str_rowid);
            if(bool_payment_provider == true)
            {
                str_payprovider = Storage.getInstance().readObject("main_itemop"+str_colid+"p_"+str_rowid).toString();
                if(str_payprovider.equals("Mpesa"))
                {
                    lbl_airtelzap.getAllStyles().setBorder(null);
                    lbl_mpesa.getAllStyles().setBorder(border);
                    lbl_telkom.getAllStyles().setBorder(null);
                    lbl_equitel.getAllStyles().setBorder(null);
                }
                else if(str_payprovider.equals("Airtel Money"))
                {
                    lbl_airtelzap.getAllStyles().setBorder(border);
                    lbl_mpesa.getAllStyles().setBorder(null);
                    lbl_telkom.getAllStyles().setBorder(null);
                    lbl_equitel.getAllStyles().setBorder(null);
                }
                else if(str_payprovider.equals("Telkom"))
                {
                    lbl_airtelzap.getAllStyles().setBorder(null);
                    lbl_mpesa.getAllStyles().setBorder(null);
                    lbl_telkom.getAllStyles().setBorder(border);
                    lbl_equitel.getAllStyles().setBorder(null);
                }
                else if(str_payprovider.equals("Equitel"))
                {
                    lbl_airtelzap.getAllStyles().setBorder(null);
                    lbl_mpesa.getAllStyles().setBorder(null);
                    lbl_telkom.getAllStyles().setBorder(null);
                    lbl_equitel.getAllStyles().setBorder(border);
                }
                else if(str_payprovider.equals("Visa"))
                {
                    lbl_visa.getAllStyles().setBorder(border);
                    lbl_mastercard.getAllStyles().setBorder(null);
                }
                else if(str_payprovider.equals("Mastercard"))
                {
                    lbl_visa.getAllStyles().setBorder(null);
                    lbl_mastercard.getAllStyles().setBorder(border);
                }
                else
                {
                    //Should not be possible
                }
            }
            else
            {
                //Should not be possible
            }
        }
        else
        {
            bool_payment_method = Storage.getInstance().exists("new_itemopm"+str_colid+"_"+str_rowid);
            if(bool_payment_method == true)
            {
                str_paymethod = Storage.getInstance().readObject("new_itemopm"+str_colid+"_"+str_rowid).toString(); 
                if(str_paymethod.equals("card"))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.repaint();

                    txtf_refno.setVisible(true);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(border);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(null);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(null);

                    cnt_payment_providers.add(lbl_mastercard);
                    cnt_payment_providers.add(lbl_visa);

                    bool_itemopr = Storage.getInstance().exists("new_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("new_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals("") || str_itemopr.equals("N/a"))
                        {
                            System.out.println("Setting value for "+str_paymethod+" Ref # textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                            txtf_refno.setText(str_itemopr);  
                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for "+str_paymethod+" Ref # textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                        System.out.println("Setting value for "+str_paymethod+" Ref # textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                        txtf_refno.setText("");
                    }

                    bool_itemopv = Storage.getInstance().exists("new_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("new_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {
                            System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                            txtf_amount.setText("");
                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                            System.out.println("Setting value for "+str_paymethod+" Amount textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+"''");
                            txtf_amount.setText("");
                    }
                }
                else if(str_paymethod.equals("cash"))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_start.repaint();

                    txtf_refno.setFocusable(false);
                    txtf_refno.setEditable(false);
                    txtf_refno.setEnabled(false);
                    txtf_refno.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                    txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                    txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                    txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                    txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                    txtf_refno.getPressedStyle().getBorder().setThickness(3);
                    txtf_refno.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                    txtf_refno.getDisabledStyle().getBorder().setThickness(3);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);


                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(border);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(null);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(null);

                    cnt_payment_providers.removeAll();
                    cnt_payment_providers.add(btn_0_5);
                    cnt_payment_providers.add(btn_1);
                    cnt_payment_providers.add(btn_5);
                    cnt_payment_providers.add(btn_10);
                    cnt_payment_providers.add(btn_20);
                    cnt_payment_providers.add(btn_40);
                    cnt_payment_providers.add(btn_50);
                    cnt_payment_providers.add(btn_100);
                    cnt_payment_providers.add(btn_200);
                    cnt_payment_providers.add(btn_500);
                    cnt_payment_providers.add(btn_1000);

                    bool_itemopv = Storage.getInstance().exists("new_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("new_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }
                }
                else if(str_paymethod.equals("bank"))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_start.repaint();

                    //txtf_refno.setVisible(false);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(border);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(null);

                    cnt_payment_providers.add(lbl_mpesa);
                    cnt_payment_providers.add(lbl_airtelzap);
                    cnt_payment_providers.add(lbl_telkom);
                    cnt_payment_providers.add(lbl_equitel);

                    bool_itemopr = Storage.getInstance().exists("new_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("new_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals("") || str_itemopr.equals("N/a"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Ref # textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopv = Storage.getInstance().exists("new_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("new_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }
                }
                else if(str_paymethod.equals("mobile"))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_start.repaint();

                    //txtf_refno.setVisible(false);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(border);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(null);

                    cnt_payment_providers.add(lbl_mpesa);
                    cnt_payment_providers.add(lbl_airtelzap);
                    cnt_payment_providers.add(lbl_telkom);
                    cnt_payment_providers.add(lbl_equitel);

                    bool_itemopr = Storage.getInstance().exists("new_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("new_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals("") || str_itemopr.equals("N/a"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Ref # textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopv = Storage.getInstance().exists("new_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("new_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }
                }
                else if(str_paymethod.equals("cheque"))
                {
                    txtf_start.setFocusable(true);
                    txtf_start.setEditable(true);
                    txtf_start.setEnabled(true);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xdc1212, false);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);
                    txtf_start.repaint();

                    //txtf_refno.setVisible(false);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(null);
                    lbl_cheque.getAllStyles().setBorder(border);
                    lbl_direct.getAllStyles().setBorder(null);

                    btn_add_photo.setText("Add Cheque");
                    btn_view_photo.setText("View Cheque");
                    cnt_payment_providers.removeAll();
                    cnt_payment_providers.add(cnt_cmds_pic);

                    bool_itemopv = Storage.getInstance().exists("new_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("new_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopr = Storage.getInstance().exists("new_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("new_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals("") || str_itemopr.equals("N/a"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Ref # textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopd = Storage.getInstance().exists("new_itemop"+str_colid+"d_"+str_rowid);
                    if(bool_itemopd == true)
                    {
                        str_itemopd = Storage.getInstance().readObject("new_itemop"+str_colid+"d_"+str_rowid).toString();
                        if(str_itemopd.equals(""))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Date textfield "+"new_itemop"+str_colid+"d_"+str_rowid+" => "+str_itemopd);
                            txtf_start.setText(str_itemopd);
                        }
                    }
                    else
                    {
                    }
                }
                else if(str_paymethod.equals("direct" ))
                {
                    txtf_start.setFocusable(false);
                    txtf_start.setEditable(false);
                    txtf_start.setEnabled(false);
                    txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                    txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                    txtf_start.repaint();

                    //txtf_refno.setVisible(false);
                    txtf_refno.setFocusable(true);
                    txtf_refno.setEditable(true);
                    txtf_refno.setEnabled(true);
                    txtf_refno.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    txtf_amount.setFocusable(true);
                    txtf_amount.setEditable(true);
                    txtf_amount.setEnabled(true);
                    txtf_amount.getHintLabel().getStyle().setFgColor(0xdc1212, false);
                    txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xdc1212, false);

                    lbl_card.getAllStyles().setBorder(null);
                    lbl_cash.getAllStyles().setBorder(null);
                    lbl_bank.getAllStyles().setBorder(null);
                    lbl_mobile.getAllStyles().setBorder(null);
                    lbl_cheque.getAllStyles().setBorder(null);
                    lbl_direct.getAllStyles().setBorder(border);

                    btn_add_photo.setText("Add Slip");
                    btn_view_photo.setText("View Slip");
                    cnt_payment_providers.removeAll();
                    cnt_payment_providers.add(cnt_cmds_pic);

                    bool_itemopv = Storage.getInstance().exists("new_itemop"+str_colid+"v_"+str_rowid);
                    if(bool_itemopv == true)
                    {
                        str_itemopv = Storage.getInstance().readObject("new_itemop"+str_colid+"v_"+str_rowid).toString();
                        if(str_itemopv.equals("") || str_itemopv.equals("0") || str_itemopv.equals("00"))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Amount textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopv);
                            txtf_amount.setText(str_itemopv);
                        }
                    }
                    else
                    {
                    }

                    bool_itemopr = Storage.getInstance().exists("new_itemop"+str_colid+"r_"+str_rowid);
                    if(bool_itemopr == true)
                    {
                        str_itemopr = Storage.getInstance().readObject("new_itemop"+str_colid+"r_"+str_rowid).toString();
                        if(str_itemopr.equals(""))
                        {

                        }
                        else
                        {
                            //str_itemopm, str_itemop, str_itemopv, str_itemopd, str_itemopr
                            System.out.println("Setting value for Ref # textfield "+"new_itemop"+str_colid+"v_"+str_rowid+" => "+str_itemopr);
                            txtf_refno.setText(str_itemopr);
                        }
                    }
                    else
                    {
                    }
                }
                else
                {
                    //No options will be highlighted [boxed]
                    cnt_payment_providers.add(lbl_payprovider_spacer);
                }
            }
            else
            { 
                txtf_start.setFocusable(false);
                txtf_start.setEditable(false);
                txtf_start.setEnabled(false);
                txtf_start.getHintLabel().getDisabledStyle().setFgColor(0xC0C0C0, true);
                txtf_start.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                txtf_start.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getUnselectedStyle().getBorder().setThickness(3);
                txtf_start.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getSelectedStyle().getBorder().setThickness(3);
                txtf_start.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getPressedStyle().getBorder().setThickness(3);
                txtf_start.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_start.getDisabledStyle().getBorder().setThickness(3);
                txtf_start.repaint();

                txtf_refno.setFocusable(false);
                txtf_refno.setEditable(false);
                txtf_refno.setEnabled(false);
                txtf_refno.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
                txtf_refno.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                txtf_refno.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getUnselectedStyle().getBorder().setThickness(3);
                txtf_refno.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getSelectedStyle().getBorder().setThickness(3);
                txtf_refno.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getPressedStyle().getBorder().setThickness(3);
                txtf_refno.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_refno.getDisabledStyle().getBorder().setThickness(3);

                txtf_amount.setFocusable(false);
                txtf_amount.setEditable(false);
                txtf_amount.setEnabled(false);
                txtf_amount.getHintLabel().getStyle().setFgColor(0xC0C0C0, false);
                txtf_amount.getHintLabel().getUnselectedStyle().setFgColor(0xC0C0C0, false);
                txtf_amount.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getUnselectedStyle().getBorder().setThickness(3);
                txtf_amount.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getSelectedStyle().getBorder().setThickness(3);
                txtf_amount.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getPressedStyle().getBorder().setThickness(3);
                txtf_amount.getDisabledStyle().setBorder(Border.createRoundBorder(25, 25, 0xC0C0C0, true)); 
                txtf_amount.getDisabledStyle().getBorder().setThickness(3);

                cnt_payment_providers.add(lbl_payprovider_spacer);
            }
            
            
            bool_payment_provider = Storage.getInstance().exists("new_itemop"+str_colid+"p_"+str_rowid);
            if(bool_payment_provider == true)
            {
                str_payprovider = Storage.getInstance().readObject("new_itemop"+str_colid+"p_"+str_rowid).toString();
                if(str_payprovider.equals("Mpesa"))
                {
                    lbl_airtelzap.getAllStyles().setBorder(null);
                    lbl_mpesa.getAllStyles().setBorder(border);
                    lbl_telkom.getAllStyles().setBorder(null);
                    lbl_equitel.getAllStyles().setBorder(null);
                }
                else if(str_payprovider.equals("Airtel Money"))
                {
                    lbl_airtelzap.getAllStyles().setBorder(border);
                    lbl_mpesa.getAllStyles().setBorder(null);
                    lbl_telkom.getAllStyles().setBorder(null);
                    lbl_equitel.getAllStyles().setBorder(null);
                }
                else if(str_payprovider.equals("Telkom"))
                {
                    lbl_airtelzap.getAllStyles().setBorder(null);
                    lbl_mpesa.getAllStyles().setBorder(null);
                    lbl_telkom.getAllStyles().setBorder(border);
                    lbl_equitel.getAllStyles().setBorder(null);
                }
                else if(str_payprovider.equals("Equitel"))
                {
                    lbl_airtelzap.getAllStyles().setBorder(null);
                    lbl_mpesa.getAllStyles().setBorder(null);
                    lbl_telkom.getAllStyles().setBorder(null);
                    lbl_equitel.getAllStyles().setBorder(border);
                }
                else if(str_payprovider.equals("Visa"))
                {
                    lbl_visa.getAllStyles().setBorder(border);
                    lbl_mastercard.getAllStyles().setBorder(null);
                }
                else if(str_payprovider.equals("Mastercard"))
                {
                    lbl_visa.getAllStyles().setBorder(null);
                    lbl_mastercard.getAllStyles().setBorder(border);
                }
                else
                {
                    //Should not be possible
                }
            }
            else
            {
                //Should not be possible
            }
        }
        
        
        
        
        
        Button btn_hapana = new Button();
        btn_hapana.setText("Cancel");
        btn_hapana.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                dlg_payOps.dispose();
            }
        });


        Button btn_ndio = new Button();
        btn_ndio.setText("Confirm");
        btn_ndio.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                //str_paymethod = Storage.getInstance().readObject("paymethod").toString();
                //str_payprovider = Storage.getInstance().readObject("payprovider").toString();
                //str_refno = txtf_refno.getText().trim(); //Storage.getInstance().readObject("temp_ref_number").toString();
                //str_trxdt = Storage.getInstance().readObject("temp_trx_date").toString();
                
                /*
                Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider);
                */
                
                if(str_table.equals("main_table"))
                {
                    bool_payment_method = Storage.getInstance().exists("main_itemopm"+str_colid+"_"+str_rowid);
                    bool_payment_provider = Storage.getInstance().exists("main_itemop"+str_colid+"_"+str_rowid); //"main_itemop"+str_colid+"p_"+str_rowid
                    if(bool_payment_method != true)
                    {
                        Log.p("Payment method not selected!", 1);
                        Dialog.show("Oops!", "You must select payment method to proceed.", "Ok", null);
                    }
                    else if(bool_payment_provider != true)
                    {
                        Log.p("Payment service provider not selected!", 1);
                        str_itemopm = Storage.getInstance().readObject("main_itemopm"+str_colid+"_"+str_rowid).toString();
                        Dialog.show("Oops!", "You must select a "+str_itemopm+" payment service provider to proceed.", "Ok", null);
                    }
                    else
                    {
                        str_itemopm = Storage.getInstance().readObject("main_itemopm"+str_colid+"_"+str_rowid).toString();
                        str_itemop = Storage.getInstance().readObject("main_itemop"+str_colid+"_"+str_rowid).toString();
                        
                        Log.p("Payment Method is "+str_itemopm+".", 1);
                        Log.p("Payment Provider is "+str_itemop+".", 1);
                                                
                        if(txtf_amount.getText().trim().equals(""))
                        {
                            str_amount = "0";
                        }
                        else
                        {
                            str_amount = txtf_amount.getText().trim();
                        }

                        str_itemop = Storage.getInstance().readObject("main_itemop"+str_colid+"_"+str_rowid).toString();
                        if(str_itemop.equals("N/a") || str_itemop.equals(""))
                        {
                            str_itemopm = Storage.getInstance().readObject("main_itemopm"+str_colid+"_"+str_rowid).toString();
                            Dialog.show("Oops!", "You must select a "+str_itemopm+" payment service provider to proceed.", "Ok", null);
                        }
                        else
                        {
                            int_txtf_amount = Integer.parseInt(str_amount);
                            //int_temptotals1 = Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3;
                            //int_temptotals2 = int_subtotals1+(Integer.parseInt(str_amount))+int_subtotals3;
                            //int_temptotals3 = int_subtotals1+int_subtotals2+(Integer.parseInt(str_amount));

                            str_paymethod = Storage.getInstance().readObject("main_itemopm"+str_colid+"_"+str_rowid).toString();
                            if(str_paymethod.equals("cash"))
                            {
                                /*if(txtf_amount.getText().trim().equals(""))
                                {
                                    Log.p("Amount not entered.", 1);
                                    Dialog.show("Oops!", "You must enter amount to proceed.", "OK", null);
                                }
                                else*/ 
                                if(str_amount.equals("0"))
                                {
                                    Log.p("Amount entered is zero(0).", 1);
                                    Dialog.show("Oops!", "You must enter an amount that is not zero (0) to proceed.", "OK", null);
                                }
                                else if(int_txtf_amount > int_subtotal)
                                {
                                    Log.p("Invalid amount entered for "+str_item+".", 1);
                                    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("1") && int_subtotal < Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("2") && int_subtotal < int_subtotals1+Integer.parseInt(str_amount)+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("3")&& int_subtotal < int_subtotals1+int_subtotals2+Integer.parseInt(str_amount))
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                /*
                                    int_txtf_amount = Integer.parseInt(str_amount);
                                    int_temptotals1 = Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3;
                                    int_temptotals2 = int_subtotals1+(Integer.parseInt(str_amount))+int_subtotals3;
                                    int_temptotals3 = int_subtotals1+int_subtotals2+(Integer.parseInt(str_amount));
                                */
                                //else if(int_temptotals1 > int_subtotal)
                                //{
                                //    Log.p("Invalid amount entered 1."+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                //    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                //}
                                //else if(int_temptotals2 > int_subtotal)
                                //{
                                //    Log.p("Invalid amount entered 2."+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                //    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+(int_subtotals1+int_txtf_amount+int_subtotals3)+" vs "+int_subtotal, "OK", null);
                                //}
                                //else if(int_temptotals3 > int_subtotal)
                                //{
                                //    Log.p("Invalid amount entered 3."+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
                                //    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                //}
        //                        else if((int_subtotals1+int_subtotals2+int_subtotals3) > int_subtotal)
        //                        {
        //                            Log.p("Invalid amount entered."+int_subtotals1+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
        //                            Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
        //                        }
                                else
                                {
                                    Log.p("Payment Amount is "+int_txtf_amount+".", 1);
                                    System.out.println("Disposing pay dialog.");
                                    dlg_payOps.dispose();

                                    //str_payprovider = Storage.getInstance().readObject("payprovider").toString();

                                    //Log.p("Writing paym to storage "+str_paymethod, 1);
                                    //Log.p("Writing payp to storage "+str_payprovider, 1);
                                    Log.p("Writing amnt to storage main_itemop"+str_colid+"v_"+str_rowid+" => "+txtf_amount.getText(), 1);
                                    Log.p("Writing date to storage main_itemop"+str_colid+"d_"+str_rowid+" => "+picker_leo.getText(), 1);
                                    Log.p("Writing ref# to storage main_itemop"+str_colid+"r_"+str_rowid+" => "+txtf_refno.getText(), 1);

                                    //Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                                    //Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, picker_leo.getText().trim());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());

                                    System.out.println("Generating random number.");
                                    doRandomNum();

                                    dlg_payments3.dispose();
                                    showPayDialog3(); 
                                }

                            }
                            else if(str_paymethod.equals("cheque"))
                            {
                                if(txtf_start.getText().equals(""))
                                {
                                    Dialog.show("Oops!", "You must enter the cheque's maturity date to proceed.", "Ok", null);
                                }
                                else if(txtf_refno.getText().trim().equals(""))
                                {
                                    Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                                }
                                //else if(txtf_amount.getText().trim().equals(""))
                                //{
                                //    Log.p("Amount not entered.", 1);
                                //    Dialog.show("Oops!", "You must enter amount to proceed.", "OK", null);
                                //}
                                else if(str_amount.equals("0"))
                                {
                                    Log.p("Amount entered is zero(0).", 1);
                                    Dialog.show("Oops!", "You must enter an amount that is not zero (0) to proceed.", "OK", null);
                                }
                                else if(int_txtf_amount > int_subtotal)
                                {
                                    Log.p("Invalid amount entered for "+str_item+".", 1);
                                    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("1") && int_subtotal < Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("2") && int_subtotal < int_subtotals1+Integer.parseInt(str_amount)+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("3")&& int_subtotal < int_subtotals1+int_subtotals2+Integer.parseInt(str_amount))
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else
                                {
                                    Log.p("Payment Amount is "+int_txtf_amount+".", 1);
                                    
                                    System.out.println("Disposing pay dialog.");
                                    dlg_payOps.dispose();

                                    //str_payprovider = Storage.getInstance().readObject("payprovider").toString();

                                    //Log.p("Writing paym to storage "+str_paymethod, 1);
                                    //Log.p("Writing payp to storage "+str_payprovider, 1);
                                    Log.p("Writing amnt to storage main_itemop"+str_colid+"v_"+str_rowid+" => "+txtf_amount.getText(), 1);
                                    Log.p("Writing date to storage main_itemop"+str_colid+"d_"+str_rowid+" => "+txtf_start.getText(), 1);
                                    Log.p("Writing ref# to storage main_itemop"+str_colid+"r_"+str_rowid+" => "+txtf_refno.getText(), 1);
                                    

                                    //Storage.getInstance().writeObject("main_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                                    //Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid, str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());

                                    System.out.println("Generating random number.");
                                    doRandomNum();

                                    dlg_payments3.dispose();
                                    showPayDialog3();
                                }
                            }
                            else
                            {
                                str_payprovider = Storage.getInstance().readObject("main_itemop"+str_colid+"_"+str_rowid).toString();
                                if(txtf_refno.getText().trim().equals(""))
                                {
                                    Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                                }
                                else if(str_amount.equals("0"))
                                {
                                    Log.p("Amount entered is zero(0).", 1);
                                    Dialog.show("Oops!", "You must enter an amount that is not zero (0) to proceed.", "OK", null);
                                }
                                else if(int_txtf_amount > int_subtotal)
                                {
                                    Log.p("Invalid amount entered for "+str_item+".", 1);
                                    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("1") && int_subtotal < Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("2") && int_subtotal < int_subtotals1+Integer.parseInt(str_amount)+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("3")&& int_subtotal < int_subtotals1+int_subtotals2+Integer.parseInt(str_amount))
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                //else if(int_temptotals1 > int_subtotal)
                                //{
                                //    Log.p("Invalid amount entered 1."+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                //    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                //}
                                //else if(int_temptotals2 > int_subtotal)
                                //{
                                //    Log.p("Invalid amount entered 2."+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                //    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+(int_subtotals1+int_txtf_amount+int_subtotals3)+" vs "+int_subtotal, "OK", null);
                                //}
                                //else if(int_temptotals3 > int_subtotal)
                                //{
                                //    
                                //    Log.p("Invalid amount entered 3."+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
                                //    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                //}
                                //else if(txtf_amount.getText().trim().equals(""))
                                //{
                                //    Log.p("Amount not entered.", 1);
                                //    Dialog.show("Oops!", "You must enter amount to proceed.", "OK", null);
                                //}
                                else
                                {
                                    Log.p("Payment Amount is "+int_txtf_amount+".", 1);
                                    
                                    System.out.println("Disposing pay dialog.");
                                    dlg_payOps.dispose();

                                    //str_payprovider = Storage.getInstance().readObject("payprovider").toString();

                                    //Log.p("Writing paym to storage "+str_paymethod, 1);
                                    //Log.p("Writing payp to storage "+str_payprovider, 1);
                                    //Log.p("Writing date to storage "+txtf_start.getText(), 1);
                                    
                                    //Storage.getInstance().writeObject("paymethod", str_paymethod);
                                    //Storage.getInstance().writeObject("payprovider", str_payprovider);
                                    //Storage.getInstance().writeObject("temp_dtm_number",  txtf_refno.getText());
                                    //Storage.getInstance().writeObject("temp_ref_number",  txtf_refno.getText());
                                    //Storage.getInstance().writeObject("temp_amt_number",  txtf_refno.getText());
                                                                        
                                    Log.p("Writing amnt to storage main_itemop"+str_colid+"v_"+str_rowid+" => "+txtf_amount.getText(), 1);
                                    Log.p("Writing date to storage main_itemop"+str_colid+"d_"+str_rowid+" => "+picker_leo.getText(), 1);
                                    Log.p("Writing ref# to storage main_itemop"+str_colid+"r_"+str_rowid+" => "+txtf_refno.getText(), 1);
                                    
                                    //Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, picker_leo.getText().trim());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());
                                    
                                    if(str_paymethod.equals("cash"))
                                    {
                                    }
                                    else
                                    {
                                        Storage.getInstance().writeObject("temp_ref_number", "Multiple");
                                    }
                                    
                                    Storage.getInstance().writeObject("temp_payprovider", "Multiple");
                                    Storage.getInstance().writeObject("payprovider", "Multiple");  //TODO: Trace this and remove it all through so as to retain the temp version.
                                    
                                    
                                    System.out.println("Generating random number.");
                                    doRandomNum();

                                    //System.out.println("Going to show Invoice.");
                                    //showInvoice();

                //                    System.out.println("Setting Icon for "+"btn_payoption1_row"+str_colid+" ---> "+StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png");
                //                    System.out.println("Setting Name for "+"btn_payoption1_row"+str_colid+" ---> "+str_payprovider);
                //                    System.out.println("Setting UIID for "+"btn_payoption1_row"+str_colid+" ---> "+txtf_amount.getText().trim());
                //                    
                //                    if(str_colid.equals("1"))
                //                    {
                //                        btn_payoption1_row[Integer.parseInt(str_rowid)].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png")); //str_paymethod+"_thumb.png"
                //                        btn_payoption1_row[Integer.parseInt(str_rowid)].setName(str_payprovider);
                //                        btn_payoption1_row[Integer.parseInt(str_rowid)].setUIID(txtf_amount.getText().trim());
                //                        
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"
                //                        //Storage.getInstance().writeObject("main_itemop"+str_rowid+"t_"+str_iterid, btn_payoption1_row[Integer.parseInt(str_iterid)].getUIID());//str_itemop1v //"4000"
                //                    }
                //                    else if(str_colid.equals("2"))
                //                    {
                //                        btn_payoption2_row[Integer.parseInt(str_rowid)].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png")); //str_paymethod+"_thumb.png"
                //                        btn_payoption2_row[Integer.parseInt(str_rowid)].setName(str_payprovider);
                //                        btn_payoption2_row[Integer.parseInt(str_rowid)].setUIID(txtf_amount.getText().trim());
                //                        
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"
                //                    }
                //                    else if(str_colid.equals("3"))
                //                    {
                //                        btn_payoption3_row[Integer.parseInt(str_rowid)].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png")); //str_paymethod+"_thumb.png"
                //                        btn_payoption3_row[Integer.parseInt(str_rowid)].setName(str_payprovider);
                //                        btn_payoption3_row[Integer.parseInt(str_rowid)].setUIID(txtf_amount.getText().trim());
                //                        
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"
                //                    }
                //                    else
                //                    {
                //                        //Not possible
                //                    }
                                    //showInvoice();
                                    dlg_payments3.dispose();
                                    showPayDialog3();

                                    //int_subtotals1 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"1"+"v_"+str_rowid).toString());
                                    //int_subtotals2 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"2"+"v_"+str_rowid).toString());
                                    //int_subtotals3 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"3"+"v_"+str_rowid).toString());
                                    //
                                    //int_txtf_amount = Integer.parseInt(str_amount);
                                    //int_temptotals1 = Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3;
                                    //int_temptotals2 = int_subtotals1+(Integer.parseInt(str_amount))+int_subtotals3;
                                    //int_temptotals3 = int_subtotals1+int_subtotals2+(Integer.parseInt(str_amount));
                                    //
                                    //str_subtotals = Storage.getInstance().readObject("main_itemv_"+str_rowid).toString();
                                    //int_subtotal = Integer.parseInt(str_subtotals);

    //                                if(str_colid.equals("1") && int_subtotal < Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3)
    //                                {
    //                                        Log.p("Invalid amount entered "+str_colid+". "+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
    //                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
    //                                }
    //                                else if(str_colid.equals("2") && int_subtotal < int_subtotals1+Integer.parseInt(str_amount)+int_subtotals3)
    //                                {
    //                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
    //                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
    //                                }
    //                                else if(str_colid.equals("3")&& int_subtotal < int_subtotals1+int_subtotals2+Integer.parseInt(str_amount))
    //                                {
    //                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
    //                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
    //                                }
    //                                else
    //                                {
    //                                    System.out.println("Disposing pay dialog.");
    //                                    dlg_payOps.dispose();
    //
    //                                    //str_payprovider = Storage.getInstance().readObject("payprovider").toString();
    //
    //                                    //Log.p("Writing paym to storage "+str_paymethod, 1);
    //                                    //Log.p("Writing payp to storage "+str_payprovider, 1);
    //                                    //Log.p("Writing date to storage "+txtf_start.getText(), 1);
    //                                    Log.p("Writing ref# to storage "+txtf_refno.getText(), 1);
    //                                    Log.p("Writing amnt to storage "+txtf_amount.getText(), 1);
    //
    //                                    //Storage.getInstance().writeObject("paymethod", str_paymethod);
    //                                    //Storage.getInstance().writeObject("payprovider", str_payprovider);
    //                                    //Storage.getInstance().writeObject("temp_dtm_number",  txtf_refno.getText());
    //                                    //Storage.getInstance().writeObject("temp_ref_number",  txtf_refno.getText());
    //                                    //Storage.getInstance().writeObject("temp_amt_number",  txtf_refno.getText());
    //
    //                                    //Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
    //                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
    //                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
    //                                    Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());
    //
    //                                    System.out.println("Generating random number.");
    //                                    doRandomNum();
    //
    //                                    //System.out.println("Going to show Invoice.");
    //                                    //showInvoice();
    //
    //                //                    System.out.println("Setting Icon for "+"btn_payoption1_row"+str_colid+" ---> "+StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png");
    //                //                    System.out.println("Setting Name for "+"btn_payoption1_row"+str_colid+" ---> "+str_payprovider);
    //                //                    System.out.println("Setting UIID for "+"btn_payoption1_row"+str_colid+" ---> "+txtf_amount.getText().trim());
    //                //                    
    //                //                    if(str_colid.equals("1"))
    //                //                    {
    //                //                        btn_payoption1_row[Integer.parseInt(str_rowid)].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png")); //str_paymethod+"_thumb.png"
    //                //                        btn_payoption1_row[Integer.parseInt(str_rowid)].setName(str_payprovider);
    //                //                        btn_payoption1_row[Integer.parseInt(str_rowid)].setUIID(txtf_amount.getText().trim());
    //                //                        
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"
    //                //                        //Storage.getInstance().writeObject("main_itemop"+str_rowid+"t_"+str_iterid, btn_payoption1_row[Integer.parseInt(str_iterid)].getUIID());//str_itemop1v //"4000"
    //                //                    }
    //                //                    else if(str_colid.equals("2"))
    //                //                    {
    //                //                        btn_payoption2_row[Integer.parseInt(str_rowid)].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png")); //str_paymethod+"_thumb.png"
    //                //                        btn_payoption2_row[Integer.parseInt(str_rowid)].setName(str_payprovider);
    //                //                        btn_payoption2_row[Integer.parseInt(str_rowid)].setUIID(txtf_amount.getText().trim());
    //                //                        
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"
    //                //                    }
    //                //                    else if(str_colid.equals("3"))
    //                //                    {
    //                //                        btn_payoption3_row[Integer.parseInt(str_rowid)].setIcon(theme.getImage(StringUtil.replaceAll(str_payprovider.toLowerCase(), " ", "_")+"_thumb.png")); //str_paymethod+"_thumb.png"
    //                //                        btn_payoption3_row[Integer.parseInt(str_rowid)].setName(str_payprovider);
    //                //                        btn_payoption3_row[Integer.parseInt(str_rowid)].setUIID(txtf_amount.getText().trim());
    //                //                        
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
    //                //                        Storage.getInstance().writeObject("main_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());    //str_itemop1v //"ABC123"
    //                //                    }
    //                //                    else
    //                //                    {
    //                //                        //Not possible
    //                //                    }
    //                                    //showInvoice();
    //                                    dlg_payments3.dispose();
    //                                    showPayDialog3();
    //                                }
                                }
                            }
                        }
                    }
                }
                else
                {
                    bool_payment_method = Storage.getInstance().exists("new_itemopm"+str_colid+"_"+str_rowid);
                    bool_payment_provider = Storage.getInstance().exists("new_itemop"+str_colid+"_"+str_rowid); //"new_itemop"+str_colid+"p_"+str_rowid
                    if(bool_payment_method != true)
                    {
                        Log.p("Payment method not selected!", 1);
                        Dialog.show("Oops!", "You must select payment method to proceed.", "Ok", null);
                    }
                    else if(bool_payment_provider != true)
                    {
                        Log.p("Payment service provider not selected!", 1);
                        str_itemopm = Storage.getInstance().readObject("new_itemopm"+str_colid+"_"+str_rowid).toString();
                        Dialog.show("Oops!", "You must select a "+str_itemopm+" payment service provider to proceed.", "Ok", null);
                    }
                    else
                    {
                        str_itemopm = Storage.getInstance().readObject("new_itemopm"+str_colid+"_"+str_rowid).toString();
                        str_itemop = Storage.getInstance().readObject("new_itemop"+str_colid+"_"+str_rowid).toString();
                        
                        Log.p("Payment Method is "+str_itemopm+".", 1);
                        Log.p("Payment Provider is "+str_itemop+".", 1);
                        
                        if(txtf_amount.getText().trim().equals(""))
                        {
                            str_amount = "0";
                        }
                        else
                        {
                            str_amount = txtf_amount.getText().trim();
                        }

                        str_itemop = Storage.getInstance().readObject("new_itemop"+str_colid+"_"+str_rowid).toString();
                        if(str_itemop.equals("N/a"))
                        {
                            str_itemopm = Storage.getInstance().readObject("new_itemopm"+str_colid+"_"+str_rowid).toString();
                            Dialog.show("Oops!", "You must select a "+str_itemopm+" payment service provider to proceed.", "Ok", null);
                        }
                        else
                        {
                            int_txtf_amount = Integer.parseInt(str_amount);
                            //int_temptotals1 = Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3;
                            //int_temptotals2 = int_subtotals1+(Integer.parseInt(str_amount))+int_subtotals3;
                            //int_temptotals3 = int_subtotals1+int_subtotals2+(Integer.parseInt(str_amount));

                            str_paymethod = Storage.getInstance().readObject("new_itemopm"+str_colid+"_"+str_rowid).toString();
                            if(str_paymethod.equals("cash"))
                            {
                                /*if(txtf_amount.getText().trim().equals(""))
                                {
                                    Log.p("Amount not entered.", 1);
                                    Dialog.show("Oops!", "You must enter amount to proceed.", "OK", null);
                                }
                                else*/ 
                                if(str_amount.equals("0"))
                                {
                                    Log.p("Amount entered is zero(0).", 1);
                                    Dialog.show("Oops!", "You must enter an amount that is not zero (0) to proceed.", "OK", null);
                                }
                                else if(int_txtf_amount > int_subtotal)
                                {
                                    Log.p("Invalid amount entered for "+str_item+".", 1);
                                    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("1") && int_subtotal < Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("2") && int_subtotal < int_subtotals1+Integer.parseInt(str_amount)+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("3")&& int_subtotal < int_subtotals1+int_subtotals2+Integer.parseInt(str_amount))
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else
                                {
                                    Log.p("Payment Amount is "+int_txtf_amount+".", 1);
                                    
                                    System.out.println("Disposing pay dialog.");
                                    dlg_payOps.dispose();

                                    //str_payprovider = Storage.getInstance().readObject("payprovider").toString();

                                    //Log.p("Writing paym to storage "+str_paymethod, 1);
                                    //Log.p("Writing payp to storage "+str_payprovider, 1);
                                    Log.p("Writing amnt to storage new_itemop"+str_colid+"v_"+str_rowid+" => "+txtf_amount.getText(), 1);
                                    Log.p("Writing ref# to storage new_itemop"+str_colid+"d_"+str_rowid+" => "+picker_leo.getText(), 1);
                                    Log.p("Writing ref# to storage new_itemop"+str_colid+"r_"+str_rowid+" => "+txtf_refno.getText(), 1);

                                    //Storage.getInstance().writeObject("new_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                                    //Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"d_"+str_rowid, picker_leo.getText().trim());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());

                                    System.out.println("Generating random number.");
                                    doRandomNum();

                                    dlg_payments3.dispose();
                                    showPayDialog3(); 
                                }

                            }
                            else if(str_paymethod.equals("cheque"))
                            {
                                if(txtf_start.getText().equals(""))
                                {
                                    Dialog.show("Oops!", "You must enter the cheque's maturity date to proceed.", "Ok", null);
                                }
                                else if(txtf_refno.getText().trim().equals(""))
                                {
                                    Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                                }
                                //else if(txtf_amount.getText().trim().equals(""))
                                //{
                                //    Log.p("Amount not entered.", 1);
                                //    Dialog.show("Oops!", "You must enter amount to proceed.", "OK", null);
                                //}
                                else if(str_amount.equals("0"))
                                {
                                    Log.p("Amount entered is zero(0).", 1);
                                    Dialog.show("Oops!", "You must enter an amount that is not zero (0) to proceed.", "OK", null);
                                }
                                else if(int_txtf_amount > int_subtotal)
                                {
                                    Log.p("Invalid amount entered for "+str_item+".", 1);
                                    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("1") && int_subtotal < Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("2") && int_subtotal < int_subtotals1+Integer.parseInt(str_amount)+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("3")&& int_subtotal < int_subtotals1+int_subtotals2+Integer.parseInt(str_amount))
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else
                                {
                                    Log.p("Payment Amount is "+txtf_amount.getText(), 1);
                                    
                                    System.out.println("Disposing pay dialog.");
                                    dlg_payOps.dispose();

                                    //str_payprovider = Storage.getInstance().readObject("payprovider").toString();

                                    //Log.p("Writing paym to storage "+str_paymethod, 1);
                                    //Log.p("Writing payp to storage "+str_payprovider, 1);
                                                                        
                                    Log.p("Writing amnt to storage new_itemop"+str_colid+"v_"+str_rowid+" => "+txtf_amount.getText(), 1);
                                    Log.p("Writing ref# to storage new_itemop"+str_colid+"d_"+str_rowid+" => "+txtf_start.getText(), 1);
                                    Log.p("Writing ref# to storage new_itemop"+str_colid+"r_"+str_rowid+" => "+txtf_refno.getText(), 1);

                                    //Storage.getInstance().writeObject("new_itemopm"+str_colid+"_"+str_rowid, str_paymethod);
                                    //Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"d_"+str_rowid, txtf_start.getText().trim());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());

                                    System.out.println("Generating random number.");
                                    doRandomNum();

                                    dlg_payments3.dispose();
                                    showPayDialog3();
                                }
                            }
                            else
                            {
                                str_payprovider = Storage.getInstance().readObject("new_itemop"+str_colid+"_"+str_rowid).toString();
                                if(txtf_refno.getText().trim().equals(""))
                                {
                                    Dialog.show("Oops!", "You must enter the reference number to proceed.", "Ok", null);
                                }
                                else if(str_amount.equals("0"))
                                {
                                    Log.p("Amount entered is zero(0).", 1);
                                    Dialog.show("Oops!", "You must enter an amount that is not zero (0) to proceed.", "OK", null);
                                }
                                else if(int_txtf_amount > int_subtotal)
                                {
                                    Log.p("Invalid amount entered for "+str_item+".", 1);
                                    Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("1") && int_subtotal < Integer.parseInt(str_amount)+int_subtotals2+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_txtf_amount+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("2") && int_subtotal < int_subtotals1+Integer.parseInt(str_amount)+int_subtotals3)
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_txtf_amount+"+"+int_subtotals3+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else if(str_colid.equals("3") && int_subtotal < int_subtotals1+int_subtotals2+Integer.parseInt(str_amount))
                                {
                                        Log.p("Invalid amount entered "+str_colid+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_txtf_amount+" != "+int_subtotal, 1);
                                        Dialog.show("Oops!", "The amount that you have allocated is more than the total amount given for "+str_item+".", "OK", null);
                                }
                                else
                                {
                                    Log.p("Payment Amount is "+txtf_amount.getText().trim(), 1);
                                    
                                    System.out.println("Disposing pay dialog.");
                                    dlg_payOps.dispose();

                                    //str_payprovider = Storage.getInstance().readObject("payprovider").toString();

                                    //Log.p("Writing paym to storage "+str_paymethod, 1);
                                    //Log.p("Writing payp to storage "+str_payprovider, 1);
                                    //Log.p("Writing date to storage "+txtf_start.getText(), 1);

                                    //Storage.getInstance().writeObject("paymethod", str_paymethod);
                                    //Storage.getInstance().writeObject("payprovider", str_payprovider);
                                    //Storage.getInstance().writeObject("temp_dtm_number",  txtf_refno.getText());
                                    //Storage.getInstance().writeObject("temp_ref_number",  txtf_refno.getText());
                                    //Storage.getInstance().writeObject("temp_amt_number",  txtf_refno.getText());
                                    
                                    
                                    Log.p("Writing amnt to storage new_itemop"+str_colid+"v_"+str_rowid+" => "+txtf_amount.getText(), 1);
                                    Log.p("Writing ref# to storage new_itemop"+str_colid+"d_"+str_rowid+" => "+picker_leo.getText(), 1);
                                    Log.p("Writing ref# to storage new_itemop"+str_colid+"r_"+str_rowid+" => "+txtf_refno.getText(), 1);

                                    //Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid,  str_payprovider); //str_itemop1  //"Mpesa"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"v_"+str_rowid, txtf_amount.getText().trim());   //str_itemop1v //"2000"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"d_"+str_rowid, picker_leo.getText().trim());//str_itemop1v //"2020-01-09"
                                    Storage.getInstance().writeObject("new_itemop"+str_colid+"r_"+str_rowid, txtf_refno.getText().trim());
                                    
                                    //TODO: put a loop of new items to check if each has 
                                    if(str_paymethod.equals("cash"))
                                    {
                                    }
                                    else
                                    {
                                        Storage.getInstance().writeObject("temp_ref_number", "Multiple");
                                    }
                                    
                                    Storage.getInstance().writeObject("temp_payprovider", "Multiple");
                                    Storage.getInstance().writeObject("payprovider", "Multiple");  //TODO: Trace this and remove it all through so as to retain the temp version.
                                    

                                    System.out.println("Generating random number.");
                                    doRandomNum();

                                    dlg_payments3.dispose();
                                    showPayDialog3();
                                }
                            }
                        }
                    }
                }
            }
        });
        
        Container cnt_dlg_footer = new Container(new BorderLayout());
        cnt_dlg_footer.add(BorderLayout.NORTH, BoxLayout.encloseY(txtf_start, txtf_refno, txtf_amount));
        cnt_dlg_footer.add(BorderLayout.WEST, btn_hapana);
        cnt_dlg_footer.add(BorderLayout.EAST, btn_ndio);
        
        dlg_payOps.add(BorderLayout.NORTH, cnt_dlg_header);
        dlg_payOps.add(BorderLayout.CENTER, BoxLayout.encloseY(cnt_payment_methods, FlowLayout.encloseCenterMiddle(cnt_payment_providers)));
        dlg_payOps.add(BorderLayout.SOUTH, cnt_dlg_footer);
        dlg_payOps.show();
    }
    
    public void showDaySelector()
    {
        dlg_setDate = new Dialog();
        if(storage.readObject("transaction").toString().equals("set_bdate"))
        {
            dlg_setDate.setTitle("Select Date of Birth");
            dlg_setDate.add(cldr_bday);
        }
        if(storage.readObject("transaction").toString().equals("set_sdate"))
        {
            dlg_setDate.setTitle("Set Start Date");
            dlg_setDate.add(cldr_start);
        }
        if(storage.readObject("transaction").toString().equals("set_pdate"))
        {
            dlg_setDate.setTitle("Select Date");
            dlg_setDate.add(cldr_sabbath);
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
                }
                if(storage.readObject("transaction").toString().equals("set_sdate"))
                {
                    dt_selected = new Date(cldr_start.getSelectedDay());
                }
                if(storage.readObject("transaction").toString().equals("set_pdate"))
                {
                    dt_selected = new Date(cldr_sabbath.getSelectedDay());
                }
              
              
                str_ssaahii = StringUtil.tokenize(StringUtil.tokenize(dt_selected.toString(), " ").get(3), ":").get(0)+":"+StringUtil.tokenize(StringUtil.tokenize(dt_selected.toString(), " ").get(3), ":").get(1);
                str_sday = StringUtil.tokenize(dt_selected.toString(), " ").get(0);
                str_sdate = StringUtil.tokenize(dt_selected.toString(), " ").get(2);
                str_smonth = StringUtil.tokenize(dt_selected.toString(), " ").get(1);
                str_syear = StringUtil.tokenize(dt_selected.toString(), " ").get(5);

                
                            
              Log.p("Converting date to format that server accepts.", 1);
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

                if(Storage.getInstance().readObject("transaction").toString().equals("set_bdate"))
                {
                    //txtf_dob.setText(str_syear+"-"+str_smonth+"-"+str_sdate);
                    storage.writeObject("dob", str_syear+"-"+str_smonth+"-"+str_sdate);
                }
                else if(Storage.getInstance().readObject("transaction").toString().equals("set_pdate"))
                {
                    //txtf_start.setText(str_syear+"-"+str_smonth+"-"+str_sdate);
                    txtf_trxn_date.setText(str_syear+"-"+str_smonth+"-"+str_sdate);
                    Storage.getInstance().writeObject("start_pdate", str_syear+"-"+str_smonth+"-"+str_sdate);
                }
                else
                {
                    //txtf_start.setText(str_syear+"-"+str_smonth+"-"+str_sdate);
                    txtf_startdate.setText(str_syear+"-"+str_smonth+"-"+str_sdate);
                    Storage.getInstance().writeObject("start_date", str_syear+"-"+str_smonth+"-"+str_sdate);
                }
              
              dlg_setDate.dispose();
              dlg_setDate.removeAll();
             }
            });

        cnt_confirmORcancel_date = new Container(new BorderLayout());
                cnt_confirmORcancel_date.add(BorderLayout.WEST, btn_cancelStart);
                cnt_confirmORcancel_date.add(BorderLayout.EAST, btn_confirmStart);

        dlg_setDate.add(cnt_confirmORcancel_date);
        
        dlg_setDate.show();
    }
    
    public void doDhafuMainItems()
    {
        System.err.println("Inside doDhafuMainItems");
        
        str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
        int_no_main_items = Integer.parseInt(str_no_main_items);

        if(int_no_main_items > 0)
        {
            Storage.getInstance().writeObject("main_proceed", "yes");
                                    
            for (i = 0; i < int_no_main_items+2; i++)
            {       
                if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("00"))
                {

                }
                else
                {
                    str_item = Storage.getInstance().readObject("main_item_"+i).toString(); //Combined Off.

                    str_subtotals = Storage.getInstance().readObject("main_itemv_"+i).toString();
                    int_subtotal = Integer.parseInt(str_subtotals);

                    int_subtotals1 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"1"+"v_"+i).toString());
                    int_subtotals2 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"2"+"v_"+i).toString());
                    int_subtotals3 = Integer.parseInt(Storage.getInstance().readObject("main_itemop"+"3"+"v_"+i).toString());

                    if(int_subtotal != int_subtotals1+int_subtotals2+int_subtotals3 && int_subtotals1+int_subtotals2+int_subtotals3 != 0)
                    {
                        Storage.getInstance().writeObject("main_proceed", "no");

                        Log.p("Invalid amount entered "+i+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                        Dialog.show("Oops!", "The amount of Ksh."+(int_subtotals1+int_subtotals2+int_subtotals3)+" that you have allocated for "+str_item+" does not add up to its total which should be "+int_subtotal+".", "OK", null);
                        break;
                        //continue;
                    }
                    else
                    {
                        Storage.getInstance().writeObject("main_proceed", "yes");
                        //if(i == int_no_main_items && (int_subtotal == int_subtotals1+int_subtotals2+int_subtotals3))
                        //{                    
                        //    Log.p(i+". "+str_item+" ere buya "+i+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_subtotals3+" ... "+int_subtotal
                        //     +"\nnow going to calculate the new items ..", 1);

                        //    break;
                        //    //doDhafuNewItems();

                        //    //System.err.println("Hereee 1.");
                        //    //continue;
                        //}

                        //doDhafuNewItems();
                        System.err.println("Hereee A.");
                    }



    //                while(i == int_no_main_items && (int_subtotal == int_subtotals1+int_subtotals2+int_subtotals3))
    //                {
    //                     doDhafuNewItems();
    //                }

                        System.err.println("Hereee B.");
                }
                        System.err.println("Hereee C.");
                        //break;
            }
        }
        else
        {
            System.err.println("Hureee nD. yeees");
            Storage.getInstance().writeObject("main_proceed", "yes");
        }
        
        
        
        if(Storage.getInstance().readObject("main_proceed").toString().equals("yes"))
        {
            System.err.println("Hereee mD. yes");
            doDhafuNewItems();
        }
        else
        {
            System.err.println("Hereee mD. no");
        }
        
    }
    
    public void doDhafuNewItems()
    {
        System.err.println("Inside doDhafuNewItems");
        
        bool_no_new_items = Storage.getInstance().exists("no_new_items");
        if(bool_no_new_items == true)
        {
            str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
            int_no_new_items = Integer.parseInt(str_no_new_items);
            
            if(int_no_new_items > 0)
            {
                for (i = 0; i < int_no_new_items; i++) 
                {
                    //int_subtotals1 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"1"+"v_"+i).toString());
                    //int_subtotals2 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"2"+"v_"+i).toString());
                    //int_subtotals3 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"3"+"v_"+i).toString());

                    //if(int_subtotal != int_subtotals1+int_subtotals2+int_subtotals3 && int_subtotals1+int_subtotals2+int_subtotals3 != 0)
                    //{
                    //    Log.p("Invalid amount entered "+i+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                    //    Dialog.show("Oops!", "The amount of Ksh."+(int_subtotals1+int_subtotals2+int_subtotals3)+" that you have allocated for "+str_item+" does not add up to its total which should be "+int_subtotal+".", "OK", null);
                    //    break;
                    //}

                    if(Storage.getInstance().readObject("new_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("0") || Storage.getInstance().readObject("new_itemv_"+i).toString().equals("00"))
                    {

                    }
                    else
                    {
                        bool_itemop = Storage.getInstance().exists("new_itemop"+"1"+"_"+i);
                        if(bool_itemop == true) //TODO: Might need to remove this boolean check as it is covered by the above storage check.
                        {
                            str_itemop = Storage.getInstance().readObject("new_itemop"+"1"+"_"+i).toString(); //cash
                            str_item = Storage.getInstance().readObject("new_item_"+i).toString();            //Combined Off.
                        }
                        else
                        {
                        }

                        str_subtotals = Storage.getInstance().readObject("new_itemv_"+i).toString();
                        int_subtotal = Integer.parseInt(str_subtotals);

                        bool_itemop1v = Storage.getInstance().exists("new_itemop"+"1"+"v_"+i);
                        if(bool_itemop1v == true)
                        {
                            int_subtotals1 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"1"+"v_"+i).toString());
                        }
                        else
                        {
                            int_subtotals1 = 0;
                        }

                        bool_itemop2v = Storage.getInstance().exists("new_itemop"+"2"+"v_"+i);
                        if(bool_itemop2v == true)
                        {
                            int_subtotals2 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"2"+"v_"+i).toString());
                        }
                        else
                        {
                            int_subtotals2 = 0;
                        }

                        bool_itemop3v = Storage.getInstance().exists("new_itemop"+"3"+"v_"+i);
                        if(bool_itemop3v == true)
                        {
                            int_subtotals3 = Integer.parseInt(Storage.getInstance().readObject("new_itemop"+"3"+"v_"+i).toString());
                        }
                        else
                        {
                            int_subtotals3 = 0;
                        }

                        if(int_subtotal != int_subtotals1+int_subtotals2+int_subtotals3 && int_subtotals1+int_subtotals2+int_subtotals3 != 0)
                        {
                            Storage.getInstance().writeObject("new_proceed", "no");

                            Log.p("Invalid amount entered "+i+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                            Dialog.show("Oops!", "The amount of Ksh."+(int_subtotals1+int_subtotals2+int_subtotals3)+" that you have allocated for "+str_item+" is less than the actual total which is "+int_subtotal+".", "OK", null);
                            break;
                            //continue;
                        }
                        else
                        {
                            Storage.getInstance().writeObject("new_proceed", "yes");

                            Log.p("Keregento kere buya as echi new items."+i+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_subtotals3+" ... "+int_subtotal
                                 +"bone ngochisend tore ase esaba.", 1);
                            //sendTransactionData();
                        }

                        //System.err.println(i+" "+(int_no_new_items-1));
                        //if(i == int_no_new_items-1)
                        //{
                        //    if(int_subtotal != int_subtotals1+int_subtotals2+int_subtotals3 && int_subtotals1+int_subtotals2+int_subtotals3 != 0)
                        //    {
                        //        Log.p("Invalid amount entered "+i+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_subtotals3+" != "+int_subtotal, 1);
                        //        Dialog.show("Oops!", "The amount of Ksh."+(int_subtotals1+int_subtotals2+int_subtotals3)+" that you have allocated for "+str_item+" is less than the actual total which is "+int_subtotal+".", "OK", null);
                        //        //break;
                        //        //continue;
                        //    }
                        //    else
                        //    {
                        //        Log.p("Keregento kere buya as echi new items."+i+". "+int_subtotals1+"+"+int_subtotals2+"+"+int_subtotals3+" ... "+int_subtotal
                        //             +"bone ngochisend tore ase esaba.", 1);
                        //        //sendTransactionData();
                        //    }
                        //}
                    }
                }
            }
            else
            {
                System.err.println("Hureee nD. yeees");
                Storage.getInstance().writeObject("new_proceed", "yes");
            }
        }
        
        if(Storage.getInstance().readObject("new_proceed").toString().equals("yes"))
        {
            System.err.println("Hereee nD. yes");
            doPackTheBus();
        }
        else
        {
            System.err.println("Hereee nD. no");
        }
    }
    
    public void doPackTheBus()
    {
        System.err.println("Inside doPackTheBus");
        
        str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
        int_no_main_items = Integer.parseInt(str_no_main_items);
        sb_main_item = new StringBuilder();

        System.out.println("No of Main Items: "+str_no_main_items);
        System.out.println("No of Main Items Selected: "+Storage.getInstance().readObject("no_itemsel").toString());
        
        Storage.getInstance().deleteStorageFile("no_vitus");


        for (i = 0; i < int_no_main_items+2; i++) //i = 1; i < int_no_main_item+1; i++
        {
            
            if(Storage.getInstance().readObject("main_itemv_"+i).toString().equals("") || Storage.getInstance().readObject("main_itemv_"+i).toString().equals("0"))
            {

            }
            else
            {
                bool_no_vitus = Storage.getInstance().exists("no_vitus");
                if(bool_no_vitus == true)
                {
                    str_no_vitus = Storage.getInstance().readObject("no_vitus").toString();
                    int_no_vitus = Integer.parseInt(str_no_vitus);
                    
                    System.out.println("No of vitus: "+str_no_vitus);

                    if(int_no_vitus >= 1)
                    {
                        Integer newcount;
                        newcount = int_no_vitus+1;
                        str_no_vitus = newcount.toString();

                        System.out.println("No of vitus: "+str_no_vitus);
                        Storage.getInstance().writeObject("no_vitus", str_no_vitus);
                    }
                    else
                    {
                        System.out.println("Updating 1 to vitus count to storage.");
                        Storage.getInstance().writeObject("no_vitus", "1");
                    }
                }
                else
                {
                    System.out.println("Updating 1 to vitus count to storage.");
                    Storage.getInstance().writeObject("no_vitus", "1");
                }
                
                
                
                System.out.println(i+"<");
                
                str_item = Storage.getInstance().readObject("main_item_"+i).toString();   //Combined Off.
                str_itemv = Storage.getInstance().readObject("main_itemv_"+i).toString(); //500
                str_itemd = "N/a";

                str_subtotals = Storage.getInstance().readObject("main_itemv_"+i).toString();
                int_subtotal = Integer.parseInt(str_subtotals);

                str_itemop1 = Storage.getInstance().readObject("main_itemop"+"1"+"_"+i).toString();
                str_itemop2 = Storage.getInstance().readObject("main_itemop"+"2"+"_"+i).toString();
                str_itemop3 = Storage.getInstance().readObject("main_itemop"+"3"+"_"+i).toString();

                str_itemop1v = Storage.getInstance().readObject("main_itemop"+"1"+"v_"+i).toString();
                str_itemop2v = Storage.getInstance().readObject("main_itemop"+"2"+"v_"+i).toString();
                str_itemop3v = Storage.getInstance().readObject("main_itemop"+"3"+"v_"+i).toString();


                //str_itemop1r = Storage.getInstance().readObject("main_itemop"+"1"+"r_"+i).toString();
                //str_itemop2r = Storage.getInstance().readObject("main_itemop"+"2"+"r_"+i).toString();
                //str_itemop3r = Storage.getInstance().readObject("main_itemop"+"3"+"r_"+i).toString();

                bool_itemop1r = Storage.getInstance().exists("main_itemop"+"1"+"r_"+i);
                if(bool_itemop1r == true)
                {
                    str_itemop1r = Storage.getInstance().readObject("main_itemop"+"1"+"r_"+i).toString();
                }
                else
                {
                    str_itemop1r = "N/a";
                }

                bool_itemop2r = Storage.getInstance().exists("main_itemop"+"2"+"r_"+i);
                if(bool_itemop2r == true)
                {
                    str_itemop2r = Storage.getInstance().readObject("main_itemop"+"2"+"r_"+i).toString();
                }
                else
                {
                    str_itemop2r = "N/a";
                }

                bool_itemop3r = Storage.getInstance().exists("main_itemop"+"3"+"r_"+i);
                if(bool_itemop3r == true)
                {
                    str_itemop3r = Storage.getInstance().readObject("main_itemop"+"3"+"r_"+i).toString();
                }
                else
                {
                    str_itemop3r = "N/a";
                }


                //str_itemop1d = Storage.getInstance().readObject("main_itemop"+"1"+"d_"+i).toString();
                //str_itemop2d = Storage.getInstance().readObject("main_itemop"+"2"+"d_"+i).toString();
                //str_itemop3d = Storage.getInstance().readObject("main_itemop"+"3"+"d_"+i).toString();

                bool_itemop1d = Storage.getInstance().exists("main_itemop"+"1"+"d_"+i);
                if(bool_itemop1d == true)
                {
                    str_itemop1d = Storage.getInstance().readObject("main_itemop"+"1"+"d_"+i).toString();
                }
                else
                {
                    str_itemop1d = "N/a";
                }

                bool_itemop2d = Storage.getInstance().exists("main_itemop"+"2"+"d_"+i);
                if(bool_itemop2d == true)
                {
                    str_itemop2d = Storage.getInstance().readObject("main_itemop"+"2"+"d_"+i).toString();
                }
                else
                {
                    str_itemop2d = "N/a";
                }

                bool_itemop3d = Storage.getInstance().exists("main_itemop"+"3"+"d_"+i);
                if(bool_itemop3d == true)
                {
                    str_itemop3d = Storage.getInstance().readObject("main_itemop"+"3"+"d_"+i).toString();
                }
                else
                {
                    str_itemop3d = "N/a";
                } 

                sb_main_item.append("    ").append(str_item).append(":    Ksh. ").append(str_itemv).append("*").append(str_itemd).append(" ^ ("+str_itemop1+" * "+str_itemop1v+" * "+str_itemop1d+" * "+str_itemop1r+") ^ ").append("("+str_itemop2+" * "+str_itemop2v+" * "+str_itemop2d+" * "+str_itemop2r+") ^ ").append("("+str_itemop3+" * "+str_itemop3v+" * "+str_itemop3d+" * "+str_itemop3r+")").append("\n");
                System.out.println(i+". Main Item(s):... \n"+sb_main_item.toString());
            }
        }

        
        
        str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
        int_no_new_items = Integer.parseInt(str_no_new_items);
        sb_new_item = new StringBuilder();

        for (i = 0; i < int_no_new_items; i++) 
        {
            str_item = Storage.getInstance().readObject("new_item_"+i).toString();   //Combined Off.
            str_itemv = Storage.getInstance().readObject("new_itemv_"+i).toString(); //500
            str_itemd = Storage.getInstance().readObject("new_itemd_"+i).toString(); //500

            //Storage.getInstance().writeObject("new_itemop"+str_colid+"_"+str_rowid, str_payprovider);
            //Storage.getInstance().writeObject("new_itemop"+str_colid+"p_"+str_rowid, str_payprovider);
            //str_itemop1p = Storage.getInstance().readObject("new_itemop"+"1"+"p_"+i).toString();
            //str_itemop2p = Storage.getInstance().readObject("new_itemop"+"2"+"p_"+i).toString();
            //str_itemop3p = Storage.getInstance().readObject("new_itemop"+"3"+"p_"+i).toString();
            //str_itemop1 = Storage.getInstance().readObject("main_itemop"+"1"+"_"+i).toString();

            bool_itemop1 = Storage.getInstance().exists("new_itemop"+"1"+"_"+i);
            if(bool_itemop1 == true)
            {
                str_itemop1 = Storage.getInstance().readObject("new_itemop"+"1"+"_"+i).toString();
            }
            else
            {
                str_itemop1 = "N/a";
            }

            bool_itemop2 = Storage.getInstance().exists("new_itemop"+"2"+"_"+i);
            if(bool_itemop2 == true)
            {
                str_itemop2 = Storage.getInstance().readObject("new_itemop"+"2"+"_"+i).toString();
            }
            else
            {
                str_itemop2 = "N/a";
            }

            bool_itemop3 = Storage.getInstance().exists("new_itemop"+"3"+"_"+i);
            if(bool_itemop3 == true)
            {
                str_itemop3 = Storage.getInstance().readObject("new_itemop"+"3"+"_"+i).toString();
            }
            else
            {
                str_itemop3 = "N/a";
            }


            //str_itemop1v = Storage.getInstance().readObject("new_itemop"+"1"+"v_"+i).toString();
            //str_itemop2v = Storage.getInstance().readObject("new_itemop"+"2"+"v_"+i).toString();
            //str_itemop3v = Storage.getInstance().readObject("new_itemop"+"3"+"v_"+i).toString();

            bool_itemop1v = Storage.getInstance().exists("new_itemop"+"1"+"v_"+i);
            if(bool_itemop1v == true)
            {
                str_itemop1v = Storage.getInstance().readObject("new_itemop"+"1"+"v_"+i).toString();
            }
            else
            {
                str_itemop1v = "N/a";
            }

            bool_itemop2v = Storage.getInstance().exists("new_itemop"+"2"+"v_"+i);
            if(bool_itemop2v == true)
            {
                str_itemop2v = Storage.getInstance().readObject("new_itemop"+"2"+"v_"+i).toString();
            }
            else
            {
                str_itemop2v = "N/a";
            }

            bool_itemop3v = Storage.getInstance().exists("new_itemop"+"3"+"v_"+i);
            if(bool_itemop3v == true)
            {
                str_itemop3v = Storage.getInstance().readObject("new_itemop"+"3"+"v_"+i).toString();
            }
            else
            {
                str_itemop3v = "N/a";
            }


            //str_itemop1r = Storage.getInstance().readObject("new_itemop"+"1"+"r_"+i).toString();
            //str_itemop2r = Storage.getInstance().readObject("new_itemop"+"2"+"r_"+i).toString();
            //str_itemop3r = Storage.getInstance().readObject("new_itemop"+"3"+"r_"+i).toString();

            bool_itemop1r = Storage.getInstance().exists("new_itemop"+"1"+"r_"+i);
            if(bool_itemop1r == true)
            {
                str_itemop1r = Storage.getInstance().readObject("new_itemop"+"1"+"r_"+i).toString();
            }
            else
            {
                str_itemop1r = "N/a";
            }

            bool_itemop2r = Storage.getInstance().exists("new_itemop"+"2"+"r_"+i);
            if(bool_itemop2r == true)
            {
                str_itemop2r = Storage.getInstance().readObject("new_itemop"+"2"+"r_"+i).toString();
            }
            else
            {
                str_itemop2r = "N/a";
            }

            bool_itemop3r = Storage.getInstance().exists("new_itemop"+"3"+"r_"+i);
            if(bool_itemop3r == true)
            {
                str_itemop3r = Storage.getInstance().readObject("new_itemop"+"3"+"r_"+i).toString();
            }
            else
            {
                str_itemop3r = "N/a";
            }


            //str_itemop1d = Storage.getInstance().readObject("new_itemop"+"1"+"d_"+i).toString();
            //str_itemop2d = Storage.getInstance().readObject("new_itemop"+"2"+"d_"+i).toString();
            //str_itemop3d = Storage.getInstance().readObject("new_itemop"+"3"+"d_"+i).toString();

            bool_itemop1d = Storage.getInstance().exists("new_itemop"+"1"+"d_"+i);
            if(bool_itemop1d == true)
            {
                str_itemop1d = Storage.getInstance().readObject("new_itemop"+"1"+"d_"+i).toString();
            }
            else
            {
                str_itemop1d = "N/a";
            }

            bool_itemop2d = Storage.getInstance().exists("new_itemop"+"2"+"d_"+i);
            if(bool_itemop2d == true)
            {
                str_itemop2d = Storage.getInstance().readObject("new_itemop"+"2"+"d_"+i).toString();
            }
            else
            {
                str_itemop2d = "N/a";
            }

            bool_itemop3d = Storage.getInstance().exists("new_itemop"+"3"+"d_"+i);
            if(bool_itemop3d == true)
            {
                str_itemop3d = Storage.getInstance().readObject("new_itemop"+"3"+"d_"+i).toString();
            }
            else
            {
                str_itemop3d = "N/a";
            }

            sb_new_item.append("    ").append(str_item).append(":    Ksh. ").append(str_itemv).append("*").append(str_itemd).append(" ^ ("+str_itemop1+" * "+str_itemop1v+" * "+str_itemop1d+" * "+str_itemop1r+") ^ ").append("("+str_itemop2+" * "+str_itemop2v+" * "+str_itemop2d+" * "+str_itemop2r+") ^ ").append("("+str_itemop3+" * "+str_itemop3v+" * "+str_itemop3d+" * "+str_itemop3r+")").append("\n");
            System.out.println("New Item(s):... \n"+sb_new_item.toString());
        }

        str_itemsel = StringUtil.replaceAll(StringUtil.replaceAll(StringUtil.replaceAll(sb_main_item.toString(), ":    Ksh. ", "*"), "\n", "|"), "|    ", "|")+StringUtil.replaceAll(StringUtil.replaceAll(StringUtil.replaceAll(sb_new_item.toString(), ":    Ksh. ", "*"), "\n", "|"), "|    ", "|").trim();
        Storage.getInstance().writeObject("itemsel", str_itemsel);
        System.out.println(i+" "+int_no_new_items+" String >>>>> here >>>>> "+str_itemsel+"\n\n"); //God's Tithe,500|Combi. Offering,500|AYS,300|
        //String >>>>> here >>>>>     
        //God's Tithe*500 ^ (Mastercard * 200 * 2020-01-25 * ABC123) ^ (cash * 200 * 2020-01-25 * ) ^ (bank * 100 * 2020-01-25 * ERTRY)|
        //Combi. Offering*500 ^ (N/a * 0 * N/a * N/a) ^ (N/a * 0 * N/a * N/a) ^ (N/a * 0 * N/a * N/a)|
        //AYS*300 ^ (Mpesa * 300 * 2020-01-25 * XYZ890) ^ (N/a * N/a * N/a * N/a) ^ (N/a * N/a * N/a * N/a)|
        
        System.err.println("No. of Items>: "+str_itemsel.lastIndexOf("|"));
                
        //if(i == int_no_new_items)
        //{
        //    //doDhafuMainItems();
        //}
        //doDhafuMainItems();
        sendTransactionData();
    }
   
    public void sendTransactionData()
    { 
        str_user_id = Storage.getInstance().readObject("userid").toString();

        str_itemsel = Storage.getInstance().readObject("itemsel").toString();
        str_no_itemsel = Storage.getInstance().readObject("no_itemsel").toString();
        
        bool_no_recp_items = Storage.getInstance().exists("no_recp_items");
        if(bool_no_recp_items == true)
        {
            str_no_recp_items = Storage.getInstance().readObject("no_recp_items").toString();
            str_recp_items  = Storage.getInstance().readObject("recp_items").toString(); //temp_recp_items
        }
        else
        {
            str_no_recp_items = "0";
            str_recp_items  = "N/a";
        }
        
        
        str_payprovider = Storage.getInstance().readObject("payprovider").toString();

        str_refno = Storage.getInstance().readObject("temp_ref_number").toString();
        str_trxno = Storage.getInstance().readObject("temp_trx_number").toString();
        str_memno = Storage.getInstance().readObject("temp_member_no").toString();
        str_firstname = Storage.getInstance().readObject("temp_firstname").toString();
        str_middlename = Storage.getInstance().readObject("temp_middlename").toString();
        str_lastname = Storage.getInstance().readObject("temp_lastname").toString();
        str_phone = Storage.getInstance().readObject("temp_phone").toString();
        str_email = Storage.getInstance().readObject("temp_email").toString();
        
        if(str_refno.equals("Multiple"))
        {
            str_refno = str_refno+"-"+str_trxno;
        }
        
                
        
        bool_spouseid = Storage.getInstance().exists("temp_spouse_id");
        if(bool_spouseid == true)
        {
            str_spouseid = Storage.getInstance().readObject("temp_spouse_id").toString();
        }
        else
        {
            str_spouseid = "n/a";
        }
        
        bool_department = Storage.getInstance().exists("temp_department");
        if(bool_department == true)
        {
            str_department = Storage.getInstance().readObject("temp_department").toString();
        }
        else
        {
            str_department = "n/a";
        }

        str_totals = Storage.getInstance().readObject("totals").toString();
        
        
        bool_vitu1 = Storage.getInstance().exists("no_vitus");
        if(bool_vitu1 == true)
        {
            int_vitu1 = Integer.parseInt(Storage.getInstance().readObject("no_vitus").toString());
        }
        else
        {
            int_vitu1 = 0;
        }
        
        
        int_vitu2 = Integer.parseInt(Storage.getInstance().readObject("no_new_items").toString());
        int_vitu = int_vitu1+int_vitu2;

        Storage.getInstance().writeObject("parameter1", "transaction");     //transaction
        Storage.getInstance().writeObject("parameter2", str_user_id);       //userid -> 1 //deviceid -> 27830a45-b8ec-460a-ad89-0bfe4069fdae
        Storage.getInstance().writeObject("parameter3", String.valueOf(int_vitu)); //str_no_itemsel   //2     
        Storage.getInstance().writeObject("parameter4", str_itemsel);       //24,Cattle Auction Fees,120,2, 240 ,Mpesa,Tommy Mogaka,n/a|28,Sugarcane,1,1, 1 ,Mpesa,Tommy Mogaka,n/a|
        Storage.getInstance().writeObject("parameter5", str_firstname); 
        Storage.getInstance().writeObject("parameter6", str_lastname);      
        Storage.getInstance().writeObject("parameter7", str_phone);         //"254"+str_phone
        Storage.getInstance().writeObject("parameter8", str_email);
        Storage.getInstance().writeObject("parameter9", str_memno);
        Storage.getInstance().writeObject("parameter10", str_trxno);
        Storage.getInstance().writeObject("parameter11", str_totals);
        Storage.getInstance().writeObject("parameter12", str_payprovider);
        Storage.getInstance().writeObject("parameter13", "giving");
        Storage.getInstance().writeObject("parameter14", str_department);
        Storage.getInstance().writeObject("parameter15", str_refno);
        Storage.getInstance().writeObject("parameter16", str_recp_items);
        
        
        bool_recp_items = Storage.getInstance().exists("no_recp_items");
        if(bool_recp_items == true)
        {
            str_no_recp_items = Storage.getInstance().readObject("no_recp_items").toString();
            Storage.getInstance().writeObject("parameter17", str_no_recp_items);    
        }
        else
        {
            Storage.getInstance().writeObject("parameter17", "0");
        }
        
        
        Storage.getInstance().writeObject("parameter18", str_spouseid);
        
        
        
        //SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
        //Log.p(sdf.format(Calendar.getInstance().getTime()));
        //Picker picker_rero = new Picker();
        //picker_rero.setFormatter(sdformat);
        
        //str_datetoday = picker_rero.getText(); //2020-04-24  //$leo_date = date("Y-m-d", time()); //2020-02-12 
        str_paydate = Storage.getInstance().readObject("start_pdate").toString();
        Storage.getInstance().writeObject("parameter19", str_paydate);
        
        Storage.getInstance().writeObject("parameter20", str_middlename);
        Storage.getInstance().writeObject("parameter21", str_other_name);
        
        
        

        //dlg_payments3.dispose(); //Disposed in Connect.java        
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