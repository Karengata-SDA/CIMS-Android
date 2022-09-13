package com.mobitribe.hesabu;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.BufferedInputStream;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.Util;
import com.codename1.processing.Result;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.util.StringUtil;
import com.codename1.xml.Element;
import com.codename1.xml.XMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

import static com.mobitribe.hesabu.LoginMenu.cb_rmemberme;
import static com.mobitribe.hesabu.MainMenu.ac_search;
import static com.mobitribe.hesabu.MainMenu.dlg_payments3;
import org.littlemonkey.connectivity.Connectivity;


public class Connect
{
    //public static String str_host = "localhost/ChurchApp/"; //karengatachurch.org/ChurchApp/ //imediakenya.com/ChurchApp
    //public static String host2 = "localhost/ChurchApp/";    //karengatachurch.org/ChurchApp/ //imediakenya.com/ChurchApp
    //public static String str_host = "imedia.co.ke/ChurchApp/"; //imedia.co.ke/ChurchApp/
    //public static String host2 = "imedia.co.ke/ChurchApp/";
    
    /*
        Username:       tommy@mobitribe.co.ke
        Password:       You will receive a separate email with your password
        Your Business
        Merchant Name:  MobiTribe
        Merchant Code:  4420192739
    
        Username:       4420192739
        Password:       qA2V64QgcsrIvAfuJieOdJh6Y79e5F10G
        Basic:          Basic Q3dsYjdKMUtIM3UwM0VpOVp0V2RTcjJWa1plTElHZGw6SzdUU09vMEdBWXdOeTJDbg==
    */
    
    public static String str_apiusn = "6335445031"; //
    public static String str_apipwd = "eFJQj3ZHH47Pegk3KcIudRmUIUl0mW3t"; //
    public static String str_apikey = "Basic d1lWQzdCRGpyMnVQRHdUbkF2WkdySGpVVWVNUHNGVE46TnBUekF5d1lwWWZXbmIzdA=="; //
    public static String str_ctype = "application/x-www-form-urlencoded";
    //POST /identity-test/v2/token HTTP/1.1
    
    /*
    Username: tommy@mobitribe.co.ke
Merchant Name: MobiTribe
Merchant Code: 4420192739
    Your Test Password is: Tommy123!
Test URL: https://test.jengahq.io/#!/authenticate

    */
    
    public static String str_loginUrl = "http://138.201.27.52:8080/GenElectionKe/GeKeAPI";    //http://localhost/Alpha/mobi/login_soap.php //http://138.201.27.52:8080/GenElectionKe/GeKeAPI
    public static String str_positionsUrl = "http://138.201.27.52:8080/GenElectionKe/GeKeAPI";
    public static String str_aspirantsUrl = "http://138.201.27.52:8080/GenElectionKe/GeKeAPI"; //http://"+Commonz.host+"/mobi/aspirants.xml //http://138.201.27.52:8080/GenElectionKe/GeKeAPI
    
    //public static Storage storage = Storage.getInstance();

    private String un;
    private int int_count_image, int_count_Cosimage, int_count_Subimage, int_count_Topimage, int_count_Pagimage;
    private Component[] btn_Cosimage;
    
    private Image img_placeholder;
    private EncodedImage encImg_placeholder;
    
    private Image img;
    private Image img_sto;
    
    private Label lbl_img;
    private Label lbl_imgSto;
    
    private Storage sto;
    private InputStream is;
    
    private int counter = 1;
    
    //private String str_response;

    String ld;
    String ap;
    String pl;
    String ua;
    String ime;
    String vr;  //App Version
    String os;  //OS Type
    String ov;  //OS Version
    String ms;  //MSISD Number
    String ud;  //UDID Number
    int kb;     //Keyboard type
    int he;     //Display Height
    int wi;     //Display Width
    int de;     //Display Density
    boolean di; //device has dialing capabilities
    boolean or; //device allows forcing the orientation
    String[] ks;//Virtual Keyboards
    boolean ss; //Screen Saver Stop
    boolean cam;//Camera Present
    boolean to; //Touch Capability
    int sms;    //SMS Suport
    boolean pb;
    

    private String sno; //Serial Number
    private String snm; //Service Number - for Support
    private String sln; //Service Lines - for PRS
    private String sur; //Service URLs
    private String spl; //Service Personel - Mentor, supervisor, recruiter
    private String sem; //Service Email
    private String spt; //Service Point - Cohorth
    private String trx; //
    
    private String str_pinpass;
    public String str_recruits;
  
    //public String str_users_adder, str_users_sosno;
    //public String str_users_title, str_users_userid, str_users_birth_date, str_users_ppno, str_users_idno, str_users_gender, str_users_country, str_users_city, str_users_industry, str_users_occupation, str_users_organisation, str_users_department, str_users_cellphone, str_users_email_address, str_users_physical_address, str_users_longitude, str_users_latitude, str_users_postal_address, str_users_approvedby, str_users_emergency_contact, str_users_emergency_contact_phone, str_users_dietary_need, str_users_food_allergies, str_users_language, str_users_adminid, str_users_admincellphone, str_users_active;
    
    public String str_roli;
    public String str_levoli;
    public String str_ward, str_wodi;
    //public String str_cellphone, str_users_phone;
    //public String str_users_level, str_users_role;
    //public String str_email, str_users_email;
    public String str_twitter;
    public String str_facebook;
    public String str_dateob;
    
    private String payload, str_engine, str_train, str_carriage, str_data;
    
    
    
    private String str_screen;
    private String str_updatedon;
    
    private boolean bool_Login_staus, bool_upload_status;
    
    //private String str_host1, str_host2;
    private String str_username, str_usernameTemp;
    private String str_password, str_passwordTemp;
    
    private String str_reciever, str_message;
    
    private String str_role;
    
    private String str_station, str_constituency, str_county;
    private String str_idnumber;
    private String str_partyname;
    private String str_door_2_door;
    private String str_civic_education;
    private String str_media_sensitisation;
    //private String str_voter_protection;
    private String str_safety_personel;
    private String str_trainer;
    private String str_other_volution;
    private String str_dateofbirth;
    private String str_hasID;
    private String str_hasOkoa;
    private String str_isVoter;
    
    private String str_number;
    private String str_language;
    private String str_question;
    private String str_answer;
    private String str_option1;
    private String str_option2;
    
    //private String str_login_status, str_upload_status, str_user_details, str_personal_details, str_server_locnes, str_voting_details, str_fileName, str_filePath, str_mimeType;
    
    //TaskCatList Status
    private String str_TaskCatList_status;
    //Tasks Count
    private String str_TaskCatscount;
    private String str_l;
    //Tasks
    private String str_TaskCatList;
    //Task Contents
    private String str_TaskCat;
     //TaskCat Contents
    private String str_lastTaskCatid, str_lastTaskCatlist, str_oldTaskCatcount, str_newTaskCatcount, str_TaskCatid, str_TaskCatname, str_TaskCatcategory,
    str_TaskCatIcon, str_TaskCatCount, str_TaskCatDescr, str_TaskCatDeprt, str_TaskCatBgcol, str_TaskCatFgcol, str_TaskCatshape, str_TaskCatBywho, str_TaskSubCats;
    
    //TaskList Status
    private String str_TaskList_status;
    //Tasks Count
    private String str_Taskscount;
    private String str_i;
    //Tasks
    private String str_TaskList;
    //Task Contents
    private String str_Task;
    //Task Details
    private String str_caseNo, str_plaintiffsName, str_defendantsName, str_dateFiled, str_currentStatus; 
     //Task Contents
    private String str_lastTaskid, str_lastTasklist, str_oldTaskcount, str_newTaskcount, str_Taskid, str_Taskname, str_Taskcategory, str_Taskbeginning, str_Taskending, str_Taskallday, str_Taskperiod, str_Taskmembers, str_Taskdepartments, str_Taskdescription, 
    str_Taskdetails, str_Taskrecurring, str_Taskrecurring_until, str_Taskexport_to, str_Taskimported_from, str_Tasklocation, str_Taskattachements, str_Taskemail_to, str_Taskmilestones, str_Taskstatus, 
    str_Taskcomments, str_Taskcreated_on, str_Taskcreated_by, str_Taskupdated_on, str_Taskupdated_by, str_Taskcompleted_on, str_Taskcompleted_by, str_Taskchecked_by, str_Taskapproved_by, str_Taskabandoned_by;
    
    private String str_volunteer_status, str_volunteer_username, str_volunteer__pass;
    
    private NetworkManager networkManager;
    
    private Dialog dialog;
    
    private TextArea txta_alert;
    
    private int int_count_tasks, int_count_Oldtasks, int_count_Newtasks;
    private int int_count_taskCats, int_count_OldtaskCats, int_count_NewtaskCats;
    
    private Slider sld_process;
    private Button btn_process;
    //private String str_param_1, str_param_2, str_param_3;
    
    private String str_agent_id, str_agent_name, str_aspirant_id, str_station_id;
    private String str_response_code, str_response_data, str_needle, str_haystack;
    
    //public static String str_host;
    //public static String str_photoUrl;
    
    
    ////public static String  str_host = "http://localhost/kanisalive/"; //http://localhost/ChurchApp/
    //public static String  str_host2 = "http://localhost/ChurchApp/";
                
    //public static String  str_host =  "https://cims.karengatasda.org/ChurchApp/";
    //public static String str_host2 = "https://cims.karengatasda.org/content/Images/";
    
    //public static String  str_host =  "https://162.144.85.80/ChurchApp/";
    //public static String str_host2 = "https://162.144.85.80/content/Images/";

    

    //str_host = "https://api.africastalking.com/version1/messaging";
                 
    //str_protocol + str_host + str_port + str_path_authLogin
    
    //public static String str_photoUrl = str_host+"/upload_photo.php";
    //public static String str_gmapsUrl = str_host+"/location.php";
    
    public static Storage storage = Storage.getInstance();
    
    private boolean bool_screen;

    private String str_response;
    private BufferedInputStream bis;
    private InputStream in;
    private String text;
    
    //private String str_username, str_usernameTemp;
    //private String str_password, str_passwordTemp;
    
    //private String payload, str_engine, str_train, str_carriage, str_data;
    //private NetworkManager networkManager;
    private String str_payload, str_param_1, str_param_2, str_param_3, str_param_4, str_param_5, str_param_6, 
            str_param_7, str_param_8, str_param_9, str_param_10, str_param_11, str_param_12, str_param_13, 
            str_param_14, str_param_15, str_param_16, str_param_17, str_param_18, str_param_19, str_param_20,
            str_param_21;
    
    private Boolean bool_userid, bool_trxnid;
    private String str_userid, str_trxnid;
    
    
    private String str_login_status, str_upload_status, str_user_details, str_personal_details, str_server_locnes, str_voting_details, str_fileName, str_filePath, str_mimeType;
    //private InputStream is;
    
    public String str_users_id, str_users_memnos, str_users_otpcode, str_users_family_id, str_users_firstname, str_users_middlename, str_users_other_name, str_users_lastname, 
            str_users_nickname, str_users_title, str_users_userid, str_users_role, str_users_level, str_users_birth_date, str_users_age, 
            str_users_ppno, str_users_idno, str_users_gender, str_users_country, str_users_nationality, str_users_county, str_users_city, 
            str_users_phone, str_users_phone_alt, str_users_email_address, str_users_physical_address, 
            str_users_postal_code, str_users_residence, str_users_street_road, str_users_floor_court_flat_building, str_users_door_house_number, str_users_longitude, str_users_latitude, str_users_postal_address, str_users_postal_address_home, str_users_postal_code_home, str_users_postal_address_work, str_users_postal_code_work, str_users_approvedby, str_users_approvedon, 
            str_users_emergency_contact, str_users_emergency_contact_phone, str_users_dietary_need, str_users_food_allergies, str_users_medicine_allergies, 
            str_users_blood_type, str_users_heamoglobin, str_users_weight, str_users_height, str_users_bmi, str_users_blood_pressure, str_users_muscle_strength, str_users_special_medical_condition,
            str_users_language, str_users_adminid, str_users_admincellphone, str_users_status, str_users_phone_work, str_users_phone_home, str_users_email,
            str_users_email_alt, str_users_email_work, str_users_email_home, str_users_photo, str_users_marital_status, str_users_marital_time, 
            str_users_marital_date, str_users_spouse, str_users_children, str_users_department, str_users_department1, str_users_department2, 
            str_users_department3, str_users_department_prospects, str_users_departments, str_users_spiritual_gifts, str_users_ministry, 
            str_users_cell_church, str_users_ss_class, str_users_board_member, str_users_babtism_status, str_users_babtism_date, str_users_membership, 
            str_users_member_by, str_users_irregular, str_users_regular_at, str_users_adventist, str_users_occupation, str_users_place_of_work, str_users_industry, 
            str_users_education, str_users_experience, str_users_employment, str_users_employment_status, str_users_reminder;
    
    private int int_no_mem, int_no_itemsel, int_no_new_itemsel;
    private String str_no_mem, str_no_itemsel, str_itemsel, str_new_itemsel;
    private boolean bool_no_mem, bool_no_itemsel, bool_itemsel;
    private String [] strA_itemsel; 
    private StringBuilder sb_itemsel;
    
    //private String str_screen;
    
    private int i, j, k, l, m;
    private int int_no_main_item, int_no_new_items, int_no_total_items, int_newno_items, int_rows_items, int_rows_item, int_totals, int_new_totals, int_subtotals1, int_subtotals2, int_totalItems;
    private String str_no_main_items, str_no_new_items, str_no_total_items;
    boolean bool_no_recp_items, bool_no_new_items, bool_no_total_items, bool_item, bool_itemv, bool_no_main_items, bool_main_item, bool_main_itemv, bool_pay_instructions, bool_tithev, bool_offeringv, bool_buildingv, bool_budgetv, bool_payment_provider, bool_payment_method, bool_totals;
    boolean bool_buildingv_items, bool_buildingv_roof, bool_buildingv_premix, bool_buildingv_wall, bool_buildingv_elec, bool_buildingv_plumb, bool_buildingv_pulpit, bool_buildingv_window;
    boolean bool_trxno, bool_memno, bool_fname, bool_lname, bool_phone, bool_email;
    private Label lbl_removeTithe, lbl_removeOffering, lbl_removeBuilding, lbl_removeBudget, lbl_removeKitty;
    private Label lbl_items, lbl_totals;
    
    private String str_totals, str_subtotals, str_totalItems, str_tithe, str_offering, str_building, str_budget, str_tithev, str_offeringv, str_buildingv, str_building_roof, str_building_premix, str_building_walling, str_building_elec, str_building_plumb, str_building_pulpit, str_building_window, str_buildingv_roof, str_buildingv_premix, str_buildingv_wall, str_buildingv_elec, str_buildingv_plumb, str_buildingv_pulpit, str_buildingv_window, str_budgetv, str_item, str_main_item, str_itemv, str_main_itemv;
    private String str_trxno, str_memno, str_title, str_name, str_firstname, str_lastname, str_fname, str_lname, str_dob, str_idpp, str_aob, str_btn_back, str_btn_ok, str_email, str_phone, str_fnhint, str_unhint, str_pwhint, str_organization;
    
    private String str_listcontent, str_listcriteria;
    private StringBuilder sb_main_item, sb_new_item, sb_acoptions_new_item, sb_options, sb_recp_item;
    String [] str_acoptions_new_item, str_acoptions; 
    
    boolean bool_isTablet = Display.getInstance().isTablet();
    boolean bool_isDesktop = Display.getInstance().isDesktop();
    boolean bool_isSimulator = Display.getInstance().isSimulator();
    boolean bool_isConnected;
    
    private boolean bool_login, bool_settings;
    private String str_json_login, str_json_settings;
    
    byte[] bytes_data_login, bytes_data_settings;
    private int int_size;
    
    private boolean bool_img;
    private String str_bgimg;
    private boolean bool_response;
    
    
    public static String str_endpoint;
    public static String str_url;
    
//    public static String str_protocol = "http://";
//    public static String str_host = "localhost";
//    public static String str_port = "/";
//    public static String str_path = "ChurchApp/";
    
    public static String str_protocol = "https://";
    public static String str_host = "cims.karengatasda.org";
    public static String str_port = "/";
    public static String str_path = "ChurchApp/";
    
    //public static String str_host2 =  str_protocol + str_host + str_port + str_path + "files/";
    
    public static String str_photoUrl = str_host+"/upload_photo.php";
                    
    
    public void process() throws IOException        
    {
        
        try 
        {
            bool_isConnected = Connectivity.isConnected();
        } 
        catch (Exception e) 
        {
            Log.p("Connectivity Check Error: "+e, 1);
        }
                
        if(bool_isConnected == true) 
        {
            //we have a connection
            connect();
        } 
        else 
        {
            // we have no connection
            if(bool_isSimulator == true)
            {
                connect();
            }
            else
            {
                 Dialog.show("Yikes!!", "Connection Error!!! Are you connected to the internet?", "Ok", null);
            }
        }
        
    }
    
     
    public void connect() throws IOException        
    {
        
            Log.p(">>>>>>>>>>>>>>>Inside connect method.", 1);
            
            Log.p("Creating hashtable", 1);
            Hashtable hash = new Hashtable();

            Log.p("Reading data to be packed on the hashtable bus from storage.", 1);
            if(Storage.getInstance().exists("parameter1") == true){str_param_1 = (String) Storage.getInstance().readObject("parameter1");}else{str_param_1 = "null";}  //transaction //apikey
            if(Storage.getInstance().exists("parameter2") == true){str_param_2 = (String) Storage.getInstance().readObject("parameter2");}else{str_param_2 = "null";}  //username    //token
            if(Storage.getInstance().exists("parameter3") == true){str_param_3 = (String) Storage.getInstance().readObject("parameter3");}else{str_param_3 = "null";}  //password
            if(Storage.getInstance().exists("parameter4") == true){str_param_4 = (String) Storage.getInstance().readObject("parameter4");}else{str_param_4 = "null";}
            if(Storage.getInstance().exists("parameter5") == true){str_param_5 = (String) Storage.getInstance().readObject("parameter5");}else{str_param_5 = "null";}
            if(Storage.getInstance().exists("parameter6") == true){str_param_6 = (String) Storage.getInstance().readObject("parameter6");}else{str_param_6 = "null";}
            if(Storage.getInstance().exists("parameter7") == true){str_param_7 = (String) Storage.getInstance().readObject("parameter7");}else{str_param_7 = "null";}
            if(Storage.getInstance().exists("parameter8") == true){str_param_8 = (String) Storage.getInstance().readObject("parameter8");}else{str_param_8 = "null";}
            if(Storage.getInstance().exists("parameter9") == true){str_param_9 = (String) Storage.getInstance().readObject("parameter9");}else{str_param_9 = "null";}
            if(Storage.getInstance().exists("parameter10") == true){str_param_10 = (String) Storage.getInstance().readObject("parameter10");}else{str_param_10 = "null";}
            if(Storage.getInstance().exists("parameter11") == true){str_param_11 = (String) Storage.getInstance().readObject("parameter11");}else{str_param_11 = "null";}
            if(Storage.getInstance().exists("parameter12") == true){str_param_12 = (String) Storage.getInstance().readObject("parameter12");}else{str_param_12 = "null";}
            if(Storage.getInstance().exists("parameter13") == true){str_param_13 = (String) Storage.getInstance().readObject("parameter13");}else{str_param_13 = "null";}
            if(Storage.getInstance().exists("parameter14") == true){str_param_14 = (String) Storage.getInstance().readObject("parameter14");}else{str_param_14 = "null";}
            if(Storage.getInstance().exists("parameter15") == true){str_param_15 = (String) Storage.getInstance().readObject("parameter15");}else{str_param_15 = "null";}
            if(Storage.getInstance().exists("parameter16") == true){str_param_16 = (String) Storage.getInstance().readObject("parameter16");}else{str_param_16 = "null";}
            if(Storage.getInstance().exists("parameter17") == true){str_param_17 = (String) Storage.getInstance().readObject("parameter17");}else{str_param_17 = "null";}
            if(Storage.getInstance().exists("parameter18") == true){str_param_18 = (String) Storage.getInstance().readObject("parameter18");}else{str_param_18 = "null";}
            if(Storage.getInstance().exists("parameter19") == true){str_param_19 = (String) Storage.getInstance().readObject("parameter19");}else{str_param_19 = "null";}
            if(Storage.getInstance().exists("parameter20") == true){str_param_20 = (String) Storage.getInstance().readObject("parameter20");}else{str_param_20 = "null";}
            if(Storage.getInstance().exists("parameter21") == true){str_param_21 = (String) Storage.getInstance().readObject("parameter21");}else{str_param_21 = "null";}

            
            
            Log.p("Packing the data on the hashtable bus to be sent to the server.", 1);
            try
            {
                if(str_param_1.equals("sendmsg"))
                {
                  

                    hash.put("username", "tommy");
                    hash.put("to", str_param_2);
                    hash.put("message", str_param_3);
                    hash.put("from", "KSDA_Church");
                    //hash.put("bulkSMSMode", "1");
                    //hash.put("enqueue", "0");
                    hash.put("Content-Type", "application/json");
                    hash.put("apikey", "2e658c456820f4ae2ae1e03bf3a14ff3094a1d38a1315f05777db03dafe92667");
                    hash.put("Accept", "application/json");
                }
                else if(str_param_1.equals("authenticate"))
                {
                    //str_host = "https://api.africastalking.com/auth-token/generate";
                }
                else if(str_param_1.equals("authorisation"))
                {
                    //str_host =  "https://uat.jengahq.io/identity/v2/token";
                        
                    //hash.put("username", "4420192739");
                    //hash.put("password", "qA2V64QgcsrIvAfuJieOdJh6Y79e5F10G");
                    //
                    //hash.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); //application/x-www-form-urlencoded
                    //hash.put("Authorization", "Basic Q3dsYjdKMUtIM3UwM0VpOVp0V2RTcjJWa1plTElHZGw6SzdUU09vMEdBWXdOeTJDbg==");
                    //hash.put("Accept", "application/json");  //
                }
                else
                {
                    hash.put("parameter1", str_param_1);
                    hash.put("parameter2", str_param_2);
                    hash.put("parameter3", str_param_3);
                    hash.put("parameter4", str_param_4);
                    hash.put("parameter5", str_param_5);
                    hash.put("parameter6", str_param_6);
                    hash.put("parameter7", str_param_7);
                    hash.put("parameter8", str_param_8);
                    hash.put("parameter9", str_param_9);
                    hash.put("parameter10", str_param_10);
                    hash.put("parameter11", str_param_11);
                    hash.put("parameter12", str_param_12);
                    hash.put("parameter13", str_param_13);
                    hash.put("parameter14", str_param_14);
                    hash.put("parameter15", str_param_15);
                    hash.put("parameter16", str_param_16);
                    hash.put("parameter17", str_param_17);
                    hash.put("parameter18", str_param_18);
                    hash.put("parameter19", str_param_19);
                    hash.put("parameter20", str_param_20);
                    hash.put("parameter21", str_param_21);
                }
            }
            catch(Exception e) 
            {
                    System.out.println("Error: "+e);
                    e.printStackTrace();
            }


            Log.p("Preparing to make connection request.", 1);
            final Result res = Result.fromContent(hash);

            Log.p("Creating a json string from the data.", 1);
            
            if(str_param_1.equals("authorisation"))
            {
                str_payload =  "username="+str_apiusn+"&password="+str_apipwd;//res.toString();
                System.err.println("Payload: "+str_payload);
            }
            else
            {
                str_payload =  res.toString();
                //System.err.println("Payload: "+str_payload);
            }
            
            
            

            ConnectionRequest request = new ConnectionRequest() 
            {
                //Log.p("Handles a server response code that is not 200 and not a redirect", 1);
                @Override //Handles a server response code that is not 200 and not a redirect.
                protected void handleErrorResponseCode(int code, String message) 
                {

                }

                //Log.p("Handles an exception thrown when performing a network operation", l);
                @Override
                protected void handleException(Exception err) 
                {
                    //Dialog.show("Error: "+err, "A network error occured, please check your internet connection.", "Ok", null);
                }

                @Override
                protected void postResponse() 
                {
                    //// invoked on the EDT after processing is complete to allow the networking code readResponse() method to finish
                    //// The UI is updated here so as to avoid race conditions that might be triggered by modifications within readResponse.
                    //// Done on a successful response and will not be invoked in case of a failure.
                    //HomeMenu menuer = new HomeMenu();
                    //menuer.showMainScreen();
                }

                //Invoked when send body is true, by default sends the request arguments based * on "POST" conventions
                @Override
                protected void buildRequestBody(OutputStream os) throws IOException 
                {
                    Writer writer = null;
                    writer = new OutputStreamWriter(os, "UTF-8");
                    writer.write(str_payload);
                    writer.flush();
                    writer.close();
                }
            };

            Log.p("Making connection request by calling the login endpoint.", 2);//1-DEBUG, 2-INFO, 3-WARNING, 4-ERROR
            request.setReadResponseForErrors(true);

            if(str_param_1.equals("sendmsg"))
            {                //str_protocol + str_host + str_port + str_path
                request.setUrl(str_protocol + str_host + str_port + str_path);
                ////request.setContentType("application/x-www-form-urlencoded"); //multipart/form-data
                ////request.setContentType("application/json");
                //request.addRequestHeader("Content-Type", "application/json");
                //request.addRequestHeader("apikey", "2e658c456820f4ae2ae1e03bf3a14ff3094a1d38a1315f05777db03dafe92667");
                //request.addRequestHeader("Accept", "application/json");
                //request.addArguments("Content-Type", "application/json");
                //request.addArguments("Accept", "application/json");
                //request.setUserAgent("UTF-8");
                //request.setHttpMethod("POST");

                request.setPost(true);
                request.setWriteRequest(true);
                request.addRequestHeader("Content-Type", "application/json");
                request.addRequestHeader("apikey", "2e658c456820f4ae2ae1e03bf3a14ff3094a1d38a1315f05777db03dafe92667");
                request.addRequestHeader("Accept", "application/json");
                request.setContentType("");
            }
            else if(str_param_1.equals("authorisation"))
            {
                //hash.put("username", "4420192739");
                //hash.put("password", "qA2V64QgcsrIvAfuJieOdJh6Y79e5F10G");

                //hash.put("Content-Type", "application/x-www-form-urlencoded");
                //hash.put("Authorization", "Basic Q3dsYjdKMUtIM3UwM0VpOVp0V2RTcjJWa1plTElHZGw6SzdUU09vMEdBWXdOeTJDbg==");
                //hash.put("Accept", "application/json");
                
                request.setUrl(str_host); //str_protocol + str_host + str_port + str_path_authLogin
                
                //request.setHttpMethod("HTTP/1.1");
                
                //request.addRequestHeader("Authorization", "Basic Q3dsYjdKMUtIM3UwM0VpOVp0V2RTcjJWa1plTElHZGw6SzdUU09vMEdBWXdOeTJDbg==");
                //request.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                
                request.addRequestHeader("Authorization", str_apikey);
                request.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
                
                //request.addArgument("username", "4420192739");
                //request.addArgument("password", "qA2V64QgcsrIvAfuJieOdJh6Y79e5F10G");
                
                //request.addRequestHeader("Host", "api.jengahq.io");
                //request.setContentType("application/x-www-form-urlencoded"); //application/json
                
                //request.addArgument("Authorization", "Basic Q3dsYjdKMUtIM3UwM0VpOVp0V2RTcjJWa1plTElHZGw6SzdUU09vMEdBWXdOeTJDbg==");
                //request.addArgument("Content-Type", "application/x-www-form-urlencoded");
                
                
                request.setPost(true);
                request.setWriteRequest(true);
            }
            else
            {
                request.setUrl(str_protocol + str_host + str_port + str_path + str_param_1); //str_protocol + str_host + str_port + str_path_authLogin
                request.setContentType("application/json");
                request.addRequestHeader("Accept", "application/json");
                request.setPost(true);
                request.setWriteRequest(true);
            }




            Log.p("Callin server url: "+request.getUrl(), 1);

            /*
            sld_process = new Slider();
            //sld_process.setPreferredSize(new Dimension(300, 50));
            //sld_process.getStyle().setPadding(15, 15, 0, 0);
            //sld_process.getStyle().setMargin(15, 25, 0, 0);
            //sld_process.setSize(new Dimension(300, 50));      
            //ToastBar.showConnectionProgress("Downloading video", request, null, null);
            SliderBridge.bindProgress(request, sld_process);
            */

            InfiniteProgress inftprogress = new InfiniteProgress();
            Dialog dlg_progress = new Dialog();
            dlg_progress.setDialogUIID("Container");
            dlg_progress.setLayout(new BorderLayout());

            Label lbl_progress = new Label("Loading "+str_param_1+"...\n, Please Wait...");
            lbl_progress.getStyle().setFgColor(0xffffff, false);
            lbl_progress.getStyle().setBgTransparency(0);
            dlg_progress.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterBottom(lbl_progress, inftprogress));
            dlg_progress.setTransitionInAnimator(CommonTransitions.createEmpty());
            dlg_progress.setTransitionOutAnimator(CommonTransitions.createEmpty());
            dlg_progress.showPacked(BorderLayout.CENTER, false);
            request.setDisposeOnCompletion(dlg_progress);
            
            NetworkManager.getInstance().addToQueueAndWait(request);


            //byte[] dataa = request.getResponseData();//This method will return a valid value for only some of the responses and only after the response was processed
            //int rescode = request.getResponseCode(); //Returns the response code for this request, this is only relevant after the request completed and might contain a temporary (e.g. redirect) code while the request is in progress

            //request.setFailSilently(true);
            //NetworkManager.getInstance().addToQueueAndWait(request);
            //if(request.getResponseCode() != 200) {/*probably an error...*/}

            Log.p("Reading response from server.", 1);

            Log.p("Processing response code: "+request.getResponseCode(), 1);
            Log.p("Processing response mesg: "+request.getResponseErrorMessage(), 1);
            //Log.p("Processing response data: "+Arrays.toString(request.getResponseData()), 1);
            Log.p("\n", 1);
            
            Storage.getInstance().writeObject("respcode", String.valueOf(request.getResponseCode()));
            Storage.getInstance().writeObject("resptext", request.getResponseErrorMessage());
            Storage.getInstance().writeObject("respdata", request.getResponseData());

            /*NetworkManager.getInstance().addErrorListener(new ActionListener<NetworkEvent>() 
            {
                @Override
                public void actionPerformed(NetworkEvent evt) 
                {
                    Dialog.show("Error Occured!", "The message to "+evt.getMessage(), "OK", null);
                }
            });*/

            //Log.p("Processing response data: "+Arrays.toString(request.getResponseData()), 2);
            /*if(request.getResponseCode() != 200)
            {
                //Storage.getInstance().writeObject("respcode",  String.valueOf(request.getResponseCode()));
                //Storage.getInstance().writeObject("resptext", "Please contact the application service provider!");
                //handleError();
                Storage.getInstance().writeObject("respcode",  String.valueOf(request.getResponseCode()));
                Storage.getInstance().writeObject("resptext", "Please contact the application service provider!");
            }*/

            //storage.writeObject("response_code", request.getResponseCode()); //--> It daent work.
            //storage.writeObject("response_text", request.());

            //CodenameOneImplementation impl = Util.getImplementation();
            //Util impl = new Util();
            //impl.getResponseMessage(request);
            //CodenameOneImplementation cn1 = new CodenameOneImplementation()
            //cn1.getResponseMessage(request);


            //Log.p("Processing response data: "+dataa);
            //Log.p("Processing response data: "+dataa.toString());
            //Log.p("Processing response data: "+request.getResponseData());
            //Log.p("Processing response data: "+request.getResponseData().toString());
            //Storage.getInstance().writeObject("userdetails.json", str_respdata);
            //System.out.println("Server response: "+dataa.toString()); //daent work.

            /*InputStream input = new InputStream() 
            {
                @Override
                public int read() throws IOException {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }*/

            byte[] dataa = request.getResponseData();
            if (dataa != null) 
            {
                Reader reader = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8");
                int chr;
                StringBuffer sb = new StringBuffer();
                String str_server_response = "";
                while ((chr = reader.read()) != -1)
                {
                    sb.append((char) chr);
                    //System.out.println(sb.length());
                }
                str_server_response = sb.toString(); 

                if(str_param_1.equals("collections") || str_param_1.equals("members") || str_param_1.equals("statements"))
                {
                    //str_response = Storage.getInstance().readObject("response").toString();
                    str_train = StringUtil.tokenize(str_server_response, '[').get(1);
                    str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                    str_data = '['+str_carriage+']';

                    //System.out.println("Train: "+str_train);
                    //System.out.println("Car: "+str_carriage);
                    //System.out.println("Data: "+str_data);

                    Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                    //storage.writeObject("userdetails.json", dataa.toString());
                    //Storage.getInstance().writeObject(str_param_1+".json", str_data);
                    FileSystemStorage fsto = FileSystemStorage.getInstance();
                    final String homePath = fsto.getAppHomePath();
                    final char sep = fsto.getFileSystemSeparator();

                    try 
                    {
                        //FileSystemStorage.getInstance().openOutputStream("jibu_content.txt").write(response.getBytes());
                        //FileSystemStorage.getInstance().openOutputStream(homePath + sep + "collections.txt").write(response.getBytes("UTF-8"));
                        FileSystemStorage.getInstance().openOutputStream(FileSystemStorage.getInstance().getAppHomePath()+str_param_1+".txt").write(str_data.getBytes("UTF-8"));

                        Storage.getInstance().writeObject("listcriteria", str_param_1);
                    }
                    catch (Exception ex) 
                    {
                        ex.printStackTrace();
                    }
                }
                else
                {
                    Log.p("Writing server respons to storage.", 1);
                    try 
                    {
                        Storage.getInstance().writeObject("response", str_server_response);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println("Error: "+e+"\n"+str_server_response);
                        e.printStackTrace();
                    }
                    //System.out.println("Server response to "+str_param_1+": "+response);
                }
            }
            else
            {
                Storage.getInstance().writeObject("respcode",  String.valueOf(request.getResponseCode()));
                Storage.getInstance().writeObject("resptext", "Please contact the application service provider!");
            }

            ////str_engine, str_train
            //str_train = StringUtil.tokenize(response, '[').get(1);
            //
            ////str_carriage = str_train.substring(0, (str_train.lastIndexOf("]")));
            ////str_carriage = StringUtil.tokenize(str_train, ']').get(0);
            ////str_data = '['+str_carriage+']';
            //str_carriage = StringUtil.tokenize(str_train, "]\"}]").get(0);
            //str_data = '['+str_carriage+"]\"}]"; //"}]

            //System.out.println("Train: "+str_train);
            //System.out.println("Car: "+str_carriage);
            //System.out.println("Data: "+str_data);

                Log.p("Processing "+str_param_1+"'s json response for from server.", 1);
                if(str_param_1.equals("authorisation"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    Log.p("Server response data: "+request.getResponseData(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_token_type = map_response.get("token_type").toString();     //bearer
                        String str_issued_at = map_response.get("issued_at").toString();       //1584604570698
                        String str_expires_in = map_response.get("expires_in").toString();     //3599
                        String str_access_token = map_response.get("access_token").toString(); //sCdG2sQ6DTVVIB0Z7vSnYA7E999o
                                                
                        Storage.getInstance().writeObject("token_type", str_token_type);
                        Storage.getInstance().writeObject("issued_at", str_issued_at);
                        Storage.getInstance().writeObject("expires_in", str_expires_in);      
                        Storage.getInstance().writeObject("access_token", str_access_token);  
                        
                        str_screen = Storage.getInstance().readObject("screen").toString();
                        if(str_screen.equals("Login"))
                        {
                            Log .p("Going to perform login after authentication.", 1);
                            Storage.getInstance().writeObject("parameter1", "login");
                            Connect conn = new Connect();
                            conn.process();
                        }
                        else
                        {
                            Log .p("Going to perform signing after authentication.", 1);
                            Storage.getInstance().writeObject("parameter1", "signature");
                            Connect conn = new Connect();
                            conn.process();
                        }

                        
                    }//TODO: Remove the below and let them be handled in the handleerror() method.
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "Error "+request.getResponseCode()+": Authentication Failed!");
                    }
                    else if(request.getResponseCode() == 403)
                    {
                        storage.writeObject("loginstatus", "NOL");
                        okayDialog("Ayayaya!\n: ", "The username/password combination that you entered is wrong. You have again to proceed.");
                        MainMenu homer = new MainMenu();
                        homer.showMainMenu();
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("otp"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("ldcode").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        
                        //Storage.getInstance().writeObject("otp_number", str_resptext);
                        
                        JSONParser json = new JSONParser(); //JSONParser.setIncludeNulls(false);

                        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                        {
                            Map<String, Object> map_content = json.parseJSON(is_content); //System.out.println("login.json map_content: "+map_content);
                            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data"); //System.out.println("login.json obj_content: "+obj_content.get(0));

                            for(Map<String, Object> obj : obj_content) 
                            {              
                                //if(str_users_title == null || str_users_title.length() == 0){}else{}
                                
                                //"firstname": "'.$fname.'", "lastname": "'.$lname.'", "member_no": "'.$smember_no.'", "otpdata": "'

                                if((String)obj.get("member_no")!=null){str_users_memnos = (String)obj.get("member_no");}else{str_users_memnos = "";}
                                if((String)obj.get("otp")!=null){str_users_otpcode = (String)obj.get("otp");}else{str_users_otpcode = "";}

                                Storage.getInstance().writeObject("member_no", str_users_memnos);
                                Storage.getInstance().writeObject("otp", str_users_otpcode);
                            }
                        }
                        catch(IOException err) 
                        {
                                Log.p("Error: "+err, 3);
                        }
                        
                        okayDialog("Almost there!\n: ", "We've sent an OTP code to your email and/or phone. Use it in the next form to reset your passord.");
                        
                        Log .p("Going to show the Password reset dialog.", 1);
                        PasswordMenu nywila = new PasswordMenu();
                        nywila.showMainMenu();
                    }
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "Account not found or email or phone number is wrong. Please enter it correctly and try again.");
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("password"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        
                        Storage.getInstance().writeObject("otp_number", str_resptext);
                        
                        Log .p("Going to show the Password reset dialog.", 1);
                        PasswordMenu nywila = new PasswordMenu();
                        nywila.showMainMenu();
                    }
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "OPT code not found! Please enter it correctly or request another one.");
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("settings"))
                {
                Log.p("Processing "+str_param_1+"'s json response for from server.", 1);

                if(request.getResponseCode() == 200)
                {
                    str_response = Storage.getInstance().readObject("response").toString();
                    //str_train = StringUtil.tokenize(str_response, '[').get(1);
                    //str_carriage = StringUtil.tokenize(str_train, "]\"}]").get(0);
                    //str_data = '['+str_carriage+"]\"}]"; //"}]

                    JSONParser json_parser = new JSONParser();
                    Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));

                    String str_respcode = map_response.get("code").toString();
                    String str_resptext = map_response.get("message").toString();
                    String str_respdata = map_response.get("data").toString();

                    Log .p("Writing "+str_param_1+"'s server response to storage.", 1);
                    Storage.getInstance().writeObject(str_param_1+".json", str_response);

                    Storage.getInstance().writeObject("respcode", str_respcode);
                    Storage.getInstance().writeObject("resptext", str_resptext);
                    Storage.getInstance().writeObject("respdata", str_respdata);

                    //Storage.getInstance().writeObject("updatestatus", "2018-06-25 10:35:48"); //TODO, get this from sertings.json

                    if(str_respcode.equals("200"))
                    {
                        if (request.getResponseCode() == 200){} //check length or size of data, if greater than 0, write uderdetails.json to storage

                        Log.p("Reading "+str_param_1+".json from storage.", 1);
                        str_json_settings = (String) Storage.getInstance().readObject(str_param_1+".json");
                        bytes_data_settings = str_json_settings.getBytes();


                        JSONParser json_data_login = new JSONParser();
                        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(bytes_data_settings), "UTF-8"))
                        {
                            Map<String, Object> map_content = json_data_login.parseJSON(is_content);
                            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data");
                            System.out.println("Number of Items:---------> "+obj_content.size()); 

                            Log.p("Looping through the logins read.", 1);

                            i = 0;
                            for(Map<String, Object> obj : obj_content) 
                            {    
                                String str_id = (String)obj.get("id");
                                String str_name = (String)obj.get("name");
                                String str_type = (String)obj.get("type");
                                String str_value = (String)obj.get("value");

                                if(str_type.equals("image"))
                                {
                                    bool_img = Storage.getInstance().exists(str_value);
                                    if(bool_img == true)
                                    {
                                        //int_size = Integer.parseInt(Storage.getInstance().readObject("huhi"+".png").toString().length());
                                        //Storage.getInstance().writeObject("", "");
                                        System.out.println("Already downloaded image "+i+" "+str_value+" for "+str_firstname+" = "+int_size+" bytes.");
                                        //Storage.getInstance().deleteStorageFile(str_view+".png");
                                        //LoginMenu soaime = new LoginMenu();
                                        //soaime.showLoginScreen();
                                    }
                                    else
                                    {           //str_protocol+str_host+str_path+str_port+str_param_1
                                        str_url = str_protocol + str_host + str_port + str_path+"files/backgrounds/"+str_value; //cims.karengatasda.orgfiles/backgrounds/background.jpg
                                        System.out.println("Downloading image at "+str_url);
                                        /*Util.downloadUrlToStorageInBackground(str_url, str_view+".png", new Actionloginener() 
                                        {
                                            @Override
                                            public void actionPerformed(ActionEvent evt) 
                                            {
                                                System.out.println("Finished downloading image "+j+" "+str_view+" for "+str_road+".");str_url
                                            }
                                        });*/

                                        lbl_progress.setText("Downloading background image, Please Wait...");

                                        //Util.downloadUrlToStorage(str_url, str_value, true);
                                        Util.downloadUrlToStorage(str_url, str_value, true);  //"https://cims.karengatasda.org/files/backgrounds/"+str_value
                                        dlg_progress.dispose();

                                        if(!Storage.getInstance().exists(str_value))
                                        {
                                            Display.getInstance().vibrate(1000);
                                            Dialog.show("Connection Error", "You should have a working internet connection to continue. Thank you.","Ok",null);
                                            Display.getInstance().exitApplication();
                                        }
                                    }
                                }
                                else if(str_type.equals("icon"))
                                {
                                    bool_img = Storage.getInstance().exists(str_value);
                                    if(bool_img == true)
                                    {
                                        //int_size = Integer.parseInt(Storage.getInstance().readObject("huhi"+".png").toString().length());
                                        //Storage.getInstance().writeObject("", "");
                                        System.out.println("Already downloaded image "+i+" "+str_value+" for "+str_firstname+" = "+int_size+" bytes.");
                                        //Storage.getInstance().deleteStorageFile(str_view+".png");
                                        //LoginMenu soaime = new LoginMenu();
                                        //soaime.showLoginScreen();
                                    }
                                    else
                                    {          
                                        str_url = str_protocol + str_host + str_port + str_path+"files/icons/"+str_value; //cims.karengatasda.orgfiles/backgrounds/background.jpg
                                        
                                        System.out.println("Downloading image at "+str_url);
                                        /*Util.downloadUrlToStorageInBackground(str_url, str_view+".png", new Actionloginener() 
                                        {
                                            @Override
                                            public void actionPerformed(ActionEvent evt) 
                                            {
                                                System.out.println("Finished downloading image "+j+" "+str_view+" for "+str_road+".");str_url
                                            }
                                        });*/

                                        lbl_progress.setText("Downloading background image, Please Wait...");

                                        //Util.downloadUrlToStorage(str_url, str_value, true);
                                        Util.downloadUrlToStorage(str_url, str_value, true);  //"https://cims.karengatasda.org/files/backgrounds/"+str_value
                                        dlg_progress.dispose();

                                        if(!Storage.getInstance().exists(str_value))
                                        {
                                            Display.getInstance().vibrate(1000);
                                            Dialog.show("Connection Error", "You should have a working internet connection to continue. Thank you.","Ok",null);
                                            Display.getInstance().exitApplication();
                                        }
                                    }
                                }
                                else if(str_type.equals("theme"))
                                {
                                    try
                                    {
                                        if(!Storage.getInstance().exists(str_value))
                                        {
                                            //frmHome.setTitle("Getting your theme from iClips-Server...");
                                            Log.p("Going to download resource file... "+str_protocol + str_host +  str_port + str_path+"files/themes/"+str_value, 1);
                                            Util.downloadUrlToStorage(str_protocol + str_host +  str_port + str_path+"files/themes/"+str_value, str_value, true);
                                            //Util.downloadUrlToStorage("https://cims.karengatasda.org/files/themes/theme.res", "theme.res", true);


                                            if(!Storage.getInstance().exists("theme.res"))
                                            {
                                                Display.getInstance().vibrate(1000);
                                                Dialog.show("Connection Error", "You should have a working internet connection to continue. Thank you.","Ok",null);
                                                Display.getInstance().exitApplication();
                                            }
                                        }
                                        else
                                        {
                                            Log.p("Theme.res resource file already downloaded.", 1);
                                        }
                                    }
                                    catch(Exception ex) 
                                    {
                                        Log.e(ex);
                                    }
                                }
                                else
                                {
                                    //Log.p("Heading to login menu.", 1);
                                    //LoginMenu soaime = new LoginMenu();
                                    //soaime.showLoginScreen();
                                }

                                i = i+1;
                            }


                        }
                        catch(Exception ex) 
                        {
                                Log.e(ex);
                        }


                        Log.p("Heading to login menu.", 1);
                        LoginMenu soaime = new LoginMenu();
                        soaime.showLoginScreen();

                    }
                    else
                    {
                         handleError();
                    }
                }
                else
                {
                    handleError();
                }
            }
                else if(str_param_1.equals("login"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        if(str_response.contains("["))
                        {
                            str_train = StringUtil.tokenize(str_response, '[').get(1);
                            str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                            str_data = '['+str_carriage+']';
                        }
                        else
                        {
                            str_data = "null";
                        }
                        
                        
                        //System.out.println("Train: "+str_train);
                        //System.out.println("Car: "+str_carriage);
                        //System.out.println("Data: "+str_data);

                        Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                        //storage.writeObject("userdetails.json", dataa.toString());
                        Storage.getInstance().writeObject(str_param_1+".json", str_data);
                        //String str_json_read = (String) Storage.getInstance().readObject("userdetails.json");

                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();  //200
                        String str_resptext = map_response.get("message").toString(); //OK
                        
                        System.out.println("CODE: "+str_respcode);
                        System.out.println("MESG: "+str_resptext);
                        
                        
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        
                        if(!str_respcode.equals("200"))
                        {
                            Storage.getInstance().writeObject("loginstatus", "NOL");
                            okayDialog("Sorry!\n: ", "The username/password combination that you entered is wrong.");
                        }
                        else
                        {
                            if(str_response.contains("["))
                            {
                                String str_respdata = map_response.get("data").toString(); //
                                Storage.getInstance().writeObject("respdata", str_respdata);
                            }
                            else
                            {
                                String str_respdata = ""; //
                                Storage.getInstance().writeObject("respdata", str_respdata);
                            }

                            //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                            if (request.getResponseCode() == 200){} //check length or size of data, if greater than 0, write uderdetails.json to storage

                            JSONParser json = new JSONParser(); //JSONParser.setIncludeNulls(false);

                            try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                            {
                                Map<String, Object> map_content = json.parseJSON(is_content); //System.out.println("login.json map_content: "+map_content);
                                java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data"); //System.out.println("login.json obj_content: "+obj_content.get(0));

                                for(Map<String, Object> obj : obj_content) 
                                {              
                                    //if(str_users_title == null || str_users_title.length() == 0){}else{}

                                    if((String)obj.get("id")!=null){str_users_id = (String)obj.get("id");}else{str_users_id = "";}
                                    if((String)obj.get("board_member")!=null){str_users_board_member = (String)obj.get("board_member");}else{str_users_board_member = "";}
                                    if((String)obj.get("adventist")!=null){str_users_adventist = (String)obj.get("adventist");}else{str_users_adventist = "";}
                                    if((String)obj.get("ss_class")!=null){str_users_ss_class = (String)obj.get("ss_class");}else{str_users_ss_class = "";}
                                    if((String)obj.get("status")!=null){str_users_status = (String)obj.get("status");}else{str_users_status = "";}
                                    if((String)obj.get("role")!=null){str_users_role = (String)obj.get("role");}else{str_users_role = "";}
                                    if((String)obj.get("level")!=null){str_users_level = (String)obj.get("level");}else{str_users_level = "";}
                                    if((String)obj.get("member_no")!=null){str_users_memnos = (String)obj.get("member_no");}else{str_users_memnos = "";}
                                    if((String)obj.get("title")!=null){str_users_title = (String)obj.get("title");}else{str_users_title = "";}
                                    if((String)obj.get("firstname")!=null){str_users_firstname = (String)obj.get("firstname");}else{str_users_firstname = "";}
                                    if((String)obj.get("lastname")!=null){str_users_lastname = (String)obj.get("lastname");}else{str_users_lastname = "";}
                                    if((String)obj.get("email")!=null){str_users_email = (String)obj.get("email");}else{str_users_email = "";}
                                    if((String)obj.get("phone")!=null){str_users_phone = (String)obj.get("phone");}else{str_users_phone = "";}
                                    if((String)obj.get("department")!=null){str_users_department = (String)obj.get("department");}else{str_users_department = "";}
                                    if((String)obj.get("spouse")!=null){str_users_spouse = (String)obj.get("spouse");}else{str_users_spouse = "";}

                                    Storage.getInstance().writeObject("userid", str_users_id);
                                    Storage.getInstance().writeObject("role", str_users_role);
                                    Storage.getInstance().writeObject("level", str_users_level);
                                    Storage.getInstance().writeObject("member_no", str_users_memnos);
                                    Storage.getInstance().writeObject("title", str_users_title);
                                    Storage.getInstance().writeObject("firstname", str_users_firstname);
                                    Storage.getInstance().writeObject("lastname", str_users_lastname);
                                    Storage.getInstance().writeObject("email", str_users_email);
                                    Storage.getInstance().writeObject("phone", str_users_phone);
                                    Storage.getInstance().writeObject("department", str_users_department);
                                    Storage.getInstance().writeObject("board_member", str_users_board_member);
                                    Storage.getInstance().writeObject("adventist", str_users_adventist);
                                    Storage.getInstance().writeObject("status", str_users_status);
                                    Storage.getInstance().writeObject("ss_class", str_users_ss_class);
                                    Storage.getInstance().writeObject("spouseid", str_users_spouse);
                                }
                            }
                            catch(IOException err) 
                            {
                                    Log.p("Error: "+err, 3);
                            }

                            storage.writeObject("loginstatus", "OKL");
                            str_usernameTemp = (String) storage.readObject("parameter2");
                            str_passwordTemp = (String) storage.readObject("parameter3");
                            storage.writeObject("username", str_usernameTemp);
                            storage.writeObject("password", str_passwordTemp);


                            if(cb_rmemberme.isSelected())
                            {
                                Storage.getInstance().writeObject("keepmeloggedin", "yes");
                            }
                            else if(cb_rmemberme.isSelected() == false)
                            {
                                Storage.getInstance().writeObject("keepmeloggedin", "no");
                            }


                            //System.out.println("Here in Connect.java IF str_login_status = OKL Loop just before Successful Login Dialog");//DEBUG

                            //Log - Check if this is first time login
                            if(Storage.getInstance().exists("updatestatus")) //TODO: Instead of this, check if parameter1 is home, if not initiate update sequence
                            {
                                //Check last item of content update

                                //Check lenght or size of content

                                //Check timestamp of content

                                //If all of the above is acceptable
                                MainMenu homer = new MainMenu();
                                homer.showMainMenu();

                                //if conditions above are not met
                                //storage.writeObject("parameter1", "departments");
                                //Connect conn = new Connect();
                                //conn.process();

                            }
                            else
                            {   //if not first time, show Home Menu else fetch departments data
                                Storage.getInstance().writeObject("parameter1", "departments");
                                Connect conn = new Connect();
                                conn.process();
                                //Dialog.show("Login Successful!", "Welcome dear friend! This app will be your companion throughout your journey of faith at Karengata. We hope that it will help you be more fruitful in your walk with Christ.", "Ok", null);
                            }
                        }
                    }
                    else
                    {
                        Storage.getInstance().writeObject("respcode", String.valueOf(request.getResponseCode()));
                        handleError();
                    }
                }
                else if(str_param_1.equals("departments"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(String.valueOf(request.getResponseCode()).equals("200"))
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        //str_train = StringUtil.tokenize(str_response, '[').get(1);
                        //str_carriage = StringUtil.tokenize(str_train, "]\"}]").get(0);
                        //str_data = '['+str_carriage+"]\"}]"; //"}]

                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();

                        //boolean available = (boolean) Dataa.get("available");
                        //System.out.println("Blaaaaa---------> "+Dataa);      

                        //Map<String,Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(r.getResponseData()), "UTF-8"));
                        //String[] Dataa = Result.fromContent(map_response).getAsStringArray("//data");
                        //System.out.println("Blaaaaa---------> "+Dataa.toString()); 

                        //JSONParser p = new JSONParser();
                        //Hashtable h = p.parse(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //// "status" : "REQUEST_DENIED"
                        //String Dataaa = (String)h.get("data");
                        //System.out.println("Dataaaaa---------> "+Dataaa); 

                        /*
                        JSONParser json = new JSONParser();
                        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                        {
                            Map<String, Object> map_content = json.parseJSON(is_content);
                            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data");
                            System.out.println("Dataaaaa Size:---------> "+obj_content.size()); 
                            for(Map<String, Object> obj : obj_content) 
                            { 
                                String str_department_id = (String)obj.get("id");
                                String str_department_nm = (String)obj.get("name");
                                System.out.println("Dataaaaa---------> "+str_department_nm); 
                            }

                        }
                        catch(IOException err) 
                        {
                                Log.e(err);
                        }
                        */

                        Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                        Storage.getInstance().writeObject(str_param_1+".json", str_response);

                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_respdata);

                        if(Storage.getInstance().exists("updatestatus")) //TODO: Instead of this, check if parameter1 is home, if not initiate update sequence
                        {
                            //Check last item of content update

                            //Check lenght or size of content

                            //Check timestamp of content

                            //If all of the above is acceptable
                            MainMenu homer = new MainMenu();
                            homer.showMainMenu();

                            //if conditions above are not met
                            //storage.writeObject("parameter1", "departments");
                            //Connect conn = new Connect();
                            //conn.process();

                        }
                        else
                        {   //if not first time, show Home Menu else fetch departments data
                            storage.writeObject("parameter1", "products");
                            Connect conn = new Connect();
                            conn.process();
                            //Dialog.show("Login Successful!", "Welcome dear friend! This app will be your companion throughout your journey of faith at Karengata. We hope that it will help you be more fruitful in your walk with Christ.", "Ok", null);
                        }
                    }
                    else
                    {
                        Log.p("Server response code: "+request.getResponseCode(), 1);
                        handleError();
                    }
                }
                else if(str_param_1.equals("products"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        str_train = StringUtil.tokenize(str_response, '[').get(1);
                        str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                        str_data = '['+str_carriage+']';

                        //System.out.println("Train: "+str_train);
                        //System.out.println("Car: "+str_carriage);
                        //System.out.println("Data: "+str_data);

                        Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                        //storage.writeObject("userdetails.json", dataa.toString());
                        Storage.getInstance().writeObject(str_param_1+".json", str_data);
                        //String str_json_read = (String) Storage.getInstance().readObject("userdetails.json");

                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        bool_screen = Storage.getInstance().exists("screen");
                        if(bool_screen == true)
                        {
                            if(Storage.getInstance().readObject("screen").toString().equals("departments"))
                            {
                                Log.p("Going to show main screen.", 1);
                                //DepartmentsMenu departor = new DepartmentsMenu();
                                //departor.showMainForm();
                            }
                            else
                            {
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
                                conn.process();
                            }
                        }
                        else
                        {
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
                            conn.process();
                        }
                    }
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "The transaction failed, service not found! Please try again later.");
                    }
                    else if(request.getResponseCode() == 403)
                    {
                        Storage.getInstance().writeObject("loginstatus", "NOL");
                        okayDialog("Sorry!\n: ", "The username/password combination that you entered is wrong.");
                        //MainMenu homer = new MainMenu();
                        //homer.showMainMenu();
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("members"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        //Storage.getInstance().writeObject("respdata", str_respdata);
                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        if (request.getResponseCode() == 200){} //check length or size of data, if greater than 0, write uderdetails.json to storage

                        /*JSONParser json = new JSONParser();
                        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                        {
                            Map<String, Object> map_content = json.parseJSON(is_content); //System.out.println("login.json map_content: "+map_content);
                            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data"); //System.out.println("login.json obj_content: "+obj_content.get(0));

                            for(Map<String, Object> obj : obj_content) 
                            {              
                                //if(str_users_title == null || str_users_title.length() == 0){}else{}
                                Storage.getInstance().writeObject("userid", (String)obj.get("id"));
                                Storage.getInstance().writeObject("role", (String)obj.get("role"));
                                Storage.getInstance().writeObject("level", (String)obj.get("level"));
                                Storage.getInstance().writeObject("member_no", (String)obj.get("member_no"));
                                Storage.getInstance().writeObject("title", (String)obj.get("title"));
                                Storage.getInstance().writeObject("firstname", (String)obj.get("firstname"));
                                Storage.getInstance().writeObject("lastname", (String)obj.get("lastname"));
                                Storage.getInstance().writeObject("email", (String)obj.get("email"));
                                Storage.getInstance().writeObject("phone", (String)obj.get("phone"));
                            }
                        }
                        catch(IOException err) 
                        {
                                //Log.e(err);
                        }*/


                        bool_screen = Storage.getInstance().exists("screen");
                        if(bool_screen == true)
                        {
                            str_screen = Storage.getInstance().readObject("screen").toString();
                            if(str_screen.equals("members"))
                            {
                                Log.p("Going to MembersMenu() to showMainForm().", 1);
                                MembersMenu abanto = new MembersMenu();
                                abanto.showMainForm();
                            }
                            else if(str_screen.equals("pay"))
                            {
                                MainMenu nyumbani = new MainMenu();
                                nyumbani.showMainMenu();
                                nyumbani.showPayDialog1();
                            }
                            else
                            {
                                Log.p("Going to HomeMenu() to showMainScreen().", 1);
                                MainMenu homer = new MainMenu();
                                homer.showMainMenu();
                            }
                        }
                        else
                        {
                            Log.p("Going to HomeMenu() to showMainScreen().", 1);
                            MainMenu homer = new MainMenu();
                            homer.showMainMenu();
                        }
                    }
                    else
                    {
                        Log.p("Going to handleError() -> "+String.valueOf(request.getResponseCode()), 1);
                        Storage.getInstance().writeObject("respcode", String.valueOf(request.getResponseCode()));
                        handleError();
                    }
                }
                else if(str_param_1.equals("accounts"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        str_train = StringUtil.tokenize(str_response, '[').get(1);
                        str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                        str_data = '['+str_carriage+']';

                        //System.out.println("Train: "+str_train);
                        //System.out.println("Car: "+str_carriage);
                        //System.out.println("Data: "+str_data);

                        Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                        //storage.writeObject("userdetails.json", dataa.toString());
                        Storage.getInstance().writeObject(str_param_1+".json", str_data);
                        //String str_json_read = (String) Storage.getInstance().readObject("userdetails.json");

                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        //storage.writeObject("loginstatus", "OKL");

                        CollectionsMenu accounant = new CollectionsMenu();
                        accounant.showMainForm();
                    }
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "The transaction pin you entered was not found, please try again.");
                    }
                    else if(request.getResponseCode() == 403)
                    {
                        storage.writeObject("loginstatus", "NOL");
                        okayDialog("Ayayaya!\n: ", "The username/password combination that you entered is wrong. You have again to proceed.");
                        MainMenu homer = new MainMenu();
                            homer.showMainMenu();
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("collections"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        //storage.writeObject("loginstatus", "OKL");

                        Log .p("Going to accounts menu.", 1);
                        AccountsMenu accounant = new AccountsMenu();
                        accounant.showMainForm();
                    }//TODO: Remove the below and let them be handled in the handleerror() method.
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "No data found! You have not done any giving yet.");
                    }
                    else if(request.getResponseCode() == 403)
                    {
                        storage.writeObject("loginstatus", "NOL");
                        okayDialog("Ayayaya!\n: ", "The username/password combination that you entered is wrong. You have again to proceed.");
                        MainMenu homer = new MainMenu();
                            homer.showMainMenu();
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("statements"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        //storage.writeObject("loginstatus", "OKL");

                        Log .p("Going to accounts menu.", 1);
                        AccountsMenu accounant = new AccountsMenu();
                        accounant.showMainForm();
                    }//TODO: Remove the below and let them be handled in the handleerror() method.
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "No data found! You have not done any giving yet.");
                    }
                    else if(request.getResponseCode() == 403)
                    {
                        storage.writeObject("loginstatus", "NOL");
                        okayDialog("Ayayaya!\n: ", "The username/password combination that you entered is wrong. You have again to proceed.");
                        MainMenu homer = new MainMenu();
                            homer.showMainMenu();
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("pay"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        str_train = StringUtil.tokenize(str_response, '[').get(1);
                        str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                        str_data = '['+str_carriage+']';

                        //System.out.println("Train: "+str_train);
                        //System.out.println("Car: "+str_carriage);
                        //System.out.println("Data: "+str_data);

                        Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                        //storage.writeObject("userdetails.json", dataa.toString());
                        Storage.getInstance().writeObject(str_param_1+".json", str_data);
                        //String str_json_read = (String) Storage.getInstance().readObject("userdetails.json");

                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        if(str_resptext.equals("OK"))
                        {
                            Log .p("Data uploaded successfuly, now going to upload photo", 1);
                            doPhotoUpload();

                        }
                        else
                        {

                        }
                    }
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "No data found! You have not done any giving yet.");
                    }
                    else if(request.getResponseCode() == 403)
                    {
                        storage.writeObject("loginstatus", "NOL");
                        okayDialog("Ayayaya!\n: ", "The username/password combination that you entered is wrong. You have again to proceed.");
                        MainMenu homer = new MainMenu();
                            homer.showMainMenu();
                    }
                    else
                    {
                        handleError();
                    }
                }

                else if(str_param_1.equals("sendmsg"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        //storage.writeObject("loginstatus", "OKL");

                        Log .p("Going to accounts menu.", 1);
                        AccountsMenu accounant = new AccountsMenu();
                        accounant.showMainForm();
                    }//TODO: Remove the below and let them be handled in the handleerror() method.
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "No data found! You have not done any giving yet.");
                    }
                    else if(request.getResponseCode() == 403)
                    {
                        storage.writeObject("loginstatus", "NOL");
                        okayDialog("Ayayaya!\n: ", "The username/password combination that you entered is wrong. You have again to proceed.");
                        MainMenu homer = new MainMenu();
                            homer.showMainMenu();
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("message"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        //String str_respdata = map_response.get("data").toString();

                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        //Storage.getInstance().writeObject("respdata", str_respdata);

                        String str_firstname = Storage.getInstance().readObject("temp_firstname").toString();

                        Log .p("Returning to HomeMenu", 1);
                        if(str_resptext.equals("Success"))
                        {
                            Log.p("Showing message sent successfully dialog.", 1);
                            Dialog.show("Success", "The message to "+str_firstname+" has been sent successfully.", "OK", null);

                            Log.p("Deleteing temp_firstname from storage.", 1);
                            Storage.getInstance().deleteStorageFile("temp_firstname");
                        }
                        else
                        {
                            Log.p("Showing message sent failed dialog.", 1);
                            okayDialog("Sorry!: ", "The message to "+str_firstname+" was sent. The following error occured: \n"+str_resptext);
                        }
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("messages"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        str_train = StringUtil.tokenize(str_response, '[').get(1);
                        str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                        str_data = '['+str_carriage+']';

                        //System.out.println("Train: "+str_train);
                        //System.out.println("Car: "+str_carriage);
                        //System.out.println("Data: "+str_data);


                        Log .p("Writing "+str_param_1+"'s server response to storage.", 1);
                        Storage.getInstance().writeObject(str_param_1+".json", str_response); //str_data
                        
                        FileSystemStorage inst = FileSystemStorage.getInstance();
                        final String homePath = inst.getAppHomePath();
                        final char sep = inst.getFileSystemSeparator();

                        str_listcriteria = "messages";

                        final String str_filepath = homePath+sep+str_param_1+".txt";

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
                        
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_resphint = map_response.get("count").toString();
                        //String str_respdata = map_response.get("data").toString();

                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("resphint", str_resphint);
                        //Storage.getInstance().writeObject("respdata", str_resptext);

                        //String str_firstname = Storage.getInstance().readObject("temp_firstname").toString();

                        if(str_param_9.equals("out"))
                        {
                            Storage.getInstance().deleteStorageFile("pagecurr");
                            Storage.getInstance().deleteStorageFile("start_msg");
                            Storage.getInstance().deleteStorageFile("end_msg");
                            Storage.getInstance().deleteStorageFile("pagesize");
                            
                            Log.p("Going to show messages menu.", 1);
                            MessagesMenu ujumbe = new MessagesMenu();
                            ujumbe.showMainMenu();
                        }
                        else
                        {
                            Log .p("Returning to HomeMenu", 1);
                            if(str_resptext.equals("Success"))
                            {
                                Log.p("Showing messages sent successfully dialog.", 1);
                                Dialog.show("Success", "The messages have been sent successfully.", "OK", null);

                                Log.p("Deleteing temp_firstname from storage.", 1);
                                Storage.getInstance().deleteStorageFile("memsel");
                            }
                            else
                            {
                                Log.p("Showing message sent failed dialog.", 1);
                                okayDialog("Sorry!: ", "The messages may have not been sent successfully. The following error occured: \n"+str_resptext);
                            }
                        }
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("authenticate"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));

                        String str_resptoken = map_response.get("token").toString();


                        Log .p("Token Obtained: "+str_resptoken, 1);

                    }//TODO: Remove the below and let them be handled in the handleerror() method.
                    else if(request.getResponseCode() == 404)
                    {
                        okayDialog("Oops!\n: ", "Error "+request.getResponseCode()+": Authentication Failed!");
                    }
                    else if(request.getResponseCode() == 400)
                    {
                        okayDialog("Oops!\n: ", "Error "+request.getResponseCode()+": Authentication Failed!");
                    }
                    else if(request.getResponseCode() == 403)
                    {
                        storage.writeObject("loginstatus", "NOL");
                        okayDialog("Ayayaya!\n: ", "The username/password combination that you entered is wrong. You have again to proceed.");
                        MainMenu homer = new MainMenu();
                            homer.showMainMenu();
                    }
                    else
                    {
                        handleError();
                    }
                }
                else if(str_param_1.equals("verification"))
                {
                    Log.p("Server response code: "+request.getResponseCode(), 1);
                    if(request.getResponseCode() == 200)
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        str_train = StringUtil.tokenize(str_response, '[').get(1);
                        str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                        str_data = '['+str_carriage+']';

                        //System.out.println("Train: "+str_train);
                        //System.out.println("Car: "+str_carriage);
                        //System.out.println("Data: "+str_data);

                        Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                        //storage.writeObject("userdetails.json", dataa.toString());
                        Storage.getInstance().writeObject(str_param_1+".json", str_data);
                        //String str_json_read = (String) Storage.getInstance().readObject("userdetails.json");

                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();
                        //String str_respdata = map_response.get("data").toString();
                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);
                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        if (request.getResponseCode() == 200){} //check length or size of data, if greater than 0, write uderdetails.json to storage

                        JSONParser json = new JSONParser(); //JSONParser.setIncludeNulls(false);

                        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                        {
                            Map<String, Object> map_content = json.parseJSON(is_content); //System.out.println("login.json map_content: "+map_content);
                            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data"); //System.out.println("login.json obj_content: "+obj_content.get(0));

                            for(Map<String, Object> obj : obj_content) 
                            {              
                                //if(str_users_title == null || str_users_title.length() == 0){}else{}

                                if((String)obj.get("id")!=null){str_users_id = (String)obj.get("id");}else{str_users_id = "";}
                                if((String)obj.get("board_member")!=null){str_users_board_member = (String)obj.get("board_member");}else{str_users_board_member = "";}
                                if((String)obj.get("adventist")!=null){str_users_adventist = (String)obj.get("adventist");}else{str_users_adventist = "";}
                                if((String)obj.get("ss_class")!=null){str_users_ss_class = (String)obj.get("ss_class");}else{str_users_ss_class = "";}
                                if((String)obj.get("status")!=null){str_users_status = (String)obj.get("status");}else{str_users_status = "";}
                                if((String)obj.get("role")!=null){str_users_role = (String)obj.get("role");}else{str_users_role = "";}
                                if((String)obj.get("level")!=null){str_users_level = (String)obj.get("level");}else{str_users_level = "";}
                                if((String)obj.get("member_no")!=null){str_users_memnos = (String)obj.get("member_no");}else{str_users_memnos = "";}
                                if((String)obj.get("family_id")!=null){str_users_family_id = (String)obj.get("family_id");}else{str_users_family_id = "";}
                                if((String)obj.get("title")!=null){str_users_title = (String)obj.get("title");}else{str_users_title = "";}
                                if((String)obj.get("firstname")!=null){str_users_firstname = (String)obj.get("firstname");}else{str_users_firstname = "";}
                                if((String)obj.get("middlename")!=null){str_users_middlename = (String)obj.get("middlename");}else{str_users_middlename = "";}
                                if((String)obj.get("other_name")!=null){str_users_other_name = (String)obj.get("other_name");}else{str_users_other_name = "";}
                                if((String)obj.get("lastname")!=null){str_users_lastname = (String)obj.get("lastname");}else{str_users_lastname = "";}
                                if((String)obj.get("email")!=null){str_users_email = (String)obj.get("email");}else{str_users_email = "";}
                                if((String)obj.get("phone")!=null){str_users_phone = (String)obj.get("phone");}else{str_users_phone = "";}
                                if((String)obj.get("department")!=null){str_users_department = (String)obj.get("department");}else{str_users_department = "";}   
                                if((String)obj.get("spouse")!=null){str_users_spouse = (String)obj.get("spouse");}else{str_users_spouse = "";}
                                if((String)obj.get("gender")!=null){str_users_gender = (String)obj.get("gender");}else{str_users_gender = "";}

                                Storage.getInstance().writeObject("temp_userid", str_users_id);
                                Storage.getInstance().writeObject("temp_role", str_users_role);
                                Storage.getInstance().writeObject("temp_level", str_users_level);
                                Storage.getInstance().writeObject("temp_member_no", str_users_memnos);
                                Storage.getInstance().writeObject("temp_family_id", str_users_family_id.trim());
                                Storage.getInstance().writeObject("temp_title", str_users_title);
                                Storage.getInstance().writeObject("temp_firstname", str_users_firstname);
                                Storage.getInstance().writeObject("temp_middlename", str_users_middlename);
                                Storage.getInstance().writeObject("temp_other_name", str_users_other_name);
                                Storage.getInstance().writeObject("temp_lastname", str_users_lastname);
                                Storage.getInstance().writeObject("temp_email", str_users_email);
                                Storage.getInstance().writeObject("temp_phone", str_users_phone);
                                Storage.getInstance().writeObject("temp_department", str_users_department);
                                Storage.getInstance().writeObject("temp_board_member", str_users_board_member);
                                Storage.getInstance().writeObject("temp_adventist", str_users_adventist);
                                Storage.getInstance().writeObject("temp_status", str_users_status);
                                Storage.getInstance().writeObject("temp_ss_class", str_users_ss_class);
                                Storage.getInstance().writeObject("temp_spouse_id", str_users_spouse);
                                Storage.getInstance().writeObject("temp_gender", str_users_gender);
                                //txtf_trxno, txtf_memberno, txtf_firstname, txtf_lastname, txtf_phone, txtf_email


                                MainMenu homer = new MainMenu();
                                homer.ac_search.setText(str_users_firstname+" "+str_users_lastname);
                                homer.txtf_memberno.setText(str_users_memnos);
                                homer.txtf_firstname.setText(str_users_firstname);
                                homer.txtf_middlename.setText(str_users_middlename);
                                homer.txtf_other_name.setText(str_users_other_name);
                                homer.txtf_lastname.setText(str_users_lastname);
                                homer.txtf_phone.setText(str_users_phone);
                                homer.txtf_email.setText(str_users_email);
                            }
                        }
                        catch(IOException err) 
                        {
                                Log.p("Error: "+err);
                        }
                    }
                    else
                    {
                        Storage.getInstance().writeObject("respcode", String.valueOf(request.getResponseCode()));
                        handleError();
                    }
                }
                else if(str_param_1.equals("transaction"))
                {
                    if(request.getResponseCode() == 200)
                    { 
                        str_response = Storage.getInstance().readObject("response").toString();
                                                
                        str_response = Storage.getInstance().readObject("response").toString();
                        if(str_response.contains("["))
                        {
                            str_train = StringUtil.tokenize(str_response, '[').get(1);
                            str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                            str_data = '['+str_carriage+']';
                        }
                        else
                        {
                            str_data = "null";
                        }

                        //System.out.println("Train: "+str_train);
                        //System.out.println("Car: "+str_carriage);
                        //System.out.println("Data: "+str_data);


                        Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                        Storage.getInstance().writeObject(str_param_1+"s.json", str_data);

                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();

                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);

                        bool_screen = Storage.getInstance().exists("screen");
                        if(bool_screen == true)
                        {   
                            str_screen = Storage.getInstance().readObject("screen").toString();
                            if(str_screen.equals("collect")){}else{}
                        }
                        else
                        {
                        }

                        if(str_resptext.equals("InvalidPhoneNumber"))
                        {
                            Log.p("Showing Failed Transaction was captured dialog. - InvalidPhoneNumber", 1);
                            okayDialog("Send Failed"+"!", str_resptext+"\nSerial No: "+str_respdata);
                            
                            deleteTransaction();
                        }
                        else if(str_resptext.equals("OK") || str_resptext.equals("Success") || str_resptext.contains("inserted into"))
                        {
                            
                            Log.p("Showing Success Transaction was captured dialog.", 1);
                            okayDialog("Success"+"!", "Transaction was captured\n"+str_resptext+"\nSerial No: "+str_respdata);

                            deleteTransaction();
                        }
                        else
                        {
                             Log.p("Showing Failed Transaction was captured dialog. - "+str_resptext, 1);
                            okayDialog("Send Failed"+"!", str_resptext+"\nSerial No: "+str_respdata);
                            if(!str_respdata.equals(""))
                            {
                                //deleteTransaction();
                            }
                            deleteTransaction();
                        }

                    }
                    else
                    {
                        
                        /*JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                        //System.out.println("Server Response: " + map_response);

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();

                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_resptext);*/
                        
                        
                        
                                
                        handleError();
                    }
                }
                else
                {
                    handleError();
                }
            //* 
            //<<<<<<<<<<
        
    }
    
    public void handleError()// throws UnsupportedEncodingException, IOException//, JSONException 
    {
        System.err.println("========= handling Error ========");
        
        String rescode = (String) Storage.getInstance().readObject("respcode");
        String resmesg = (String) Storage.getInstance().readObject("resptext");
        

        if(Double.parseDouble(rescode) == 403.0) //if (Double.parseDouble(rescode) == 3002.0) 
        {
            okayDialog("Login Failed!\n: ", "Your username/password combination may be wrong.");
            //LoginMenu loginer = new LoginMenu();
            //loginer.showMainScreen();
        } 
        else if(Double.parseDouble(rescode) == 401.0) //if (Double.parseDouble(rescode) == 3002.0) 
        {
            //okayDialog("Login Failed!\n: ", "Your username is in the wrong format.... it should be an email."); //TODO: force email as username during registration
            okayDialog("Login Failed!\n: ", "Your username/password combination may be wrong.");
            //LoginMenu loginer = new LoginMenu();
            //loginer.showMainScreen();
        }
        else if(Double.parseDouble(rescode) == 3004.0) 
        {
            okayDialog("Sorry, Session Expired!\n: ", "The Process could not complete, please login and try again later.");
            //doBackgroundLogin();
                Log.p("Deleting content of stoage.", 1);
                storage.clearStorage();

                Log.p("Writing logout status in storage.", 1);
                storage.writeObject("loginstatus", "NOL");

                Log.p("Writing current screen in storage.", 1);
                storage.writeObject("screen", "home");

                Log.p("Going to the Main Menu.", 1);
                //MainMenu menuer = new MainMenu();
               //menuer.showMainScreen();
        } 
        else if (Double.parseDouble(rescode) == 3003.0) 
        {
            okayDialog("Sorry!\n: ", "Your Account is inactive, contact support for help.");
        } 
        else if (Double.parseDouble(rescode) == 4002.0) 
        {
            okayDialog("Error!\n: ", "The email you entered is not valid, check it and try again.");
        } 
        else if (Double.parseDouble(rescode) == 4003.0) 
        {
            okayDialog("Sorry!\n: ", "The email address you entered is already in use, please choose another one.");
        } 
        else if (Double.parseDouble(rescode) == 6001.0) 
        {
            okayDialog("Sorry!\n: ", "Your cart is empty, add a beneficiary to make the order.");
        } 
        else if (Double.parseDouble(rescode) == 7004.0) 
        {
            okayDialog("Error!\n: ", "The policy's start date cannot be in the past, select a valid date to continue.");
        } else if (Double.parseDouble(rescode) == 7005.0) {
            okayDialog("Error!\n: ", "The beneficiary already exists.");
        } else if (Double.parseDouble(rescode) == 1011.0) {
            okayDialog("Error!\n: ", "There are Input values that are missing.");
        }
        else if (Double.parseDouble(rescode) == 1012.0) {
            okayDialog("Note: \n: ", "Select the Policy Start Date to Proceed.");
        }
        else if (Double.parseDouble(rescode) == 2002.0) 
        {
            okayDialog("Card Invalid!", "The card you have entered has already been used or has expired.");
            storage.writeObject("screen", "card");
            //viewCart();       
            
        }
        else if (Double.parseDouble(rescode) == 2001.0) 
        {
            okayDialog("Card Invalid!", "The card is Invalid. Check the PIN and try again");
        }
        else if (Double.parseDouble(rescode) == 2005.0) 
        {
            okayDialog("Payment Error!", "The scratch card can only be used to Pay for one individual at a time. Your Cart has more than one Item. Please delete the extra Items from the cart to continue.");
        }
        else if (Double.parseDouble(rescode) == 200.0) 
        {
            //Impossible... not handled here
        }
        else if (Double.parseDouble(rescode) == 409.0) 
        {
            //TODO: Give a more detailed response as per server.
            okayDialog("Sorry"+"!", "Reference # already used!\nPlease check that you have entered the correcr one and try again.");
        }
        
        //Informational 1xx
        /*
        100 => '100 Continue',
        101 => '101 Switching Protocols',
        
        //Successful 2xx
        200 => '200 OK',
        201 => '201 Created',
        202 => '202 Accepted',
        203 => '203 Non-Authoritative Information',
        204 => '204 No Content',
        205 => '205 Reset Content',
        206 => '206 Partial Content',
        
        //Redirection 3xx
        300 => '300 Multiple Choices',
        301 => '301 Moved Permanently',
        302 => '302 Found',
        303 => '303 See Other',
        304 => '304 Not Modified',
        305 => '305 Use Proxy',
        306 => '306 (Unused)',
        307 => '307 Temporary Redirect',
        
        //Client Error 4xx
        400 => '400 Bad Request',
        401 => '401 Unauthorized',
        402 => '402 Payment Required',
        403 => '403 Forbidden',
        404 => '404 Not Found',
        405 => '405 Method Not Allowed',
        406 => '406 Not Acceptable',
        407 => '407 Proxy Authentication Required',
        408 => '408 Request Timeout',
        409 => '409 Conflict',
        410 => '410 Gone',
        411 => '411 Length Required',
        412 => '412 Precondition Failed',
        413 => '413 Request Entity Too Large',
        414 => '414 Request-URI Too Long',
        415 => '415 Unsupported Media Type',
        416 => '416 Requested Range Not Satisfiable',
        417 => '417 Expectation Failed',
        418 => '418 I\'m a teapot',
        422 => '422 Unprocessable Entity',
        423 => '423 Locked',
        
        //Server Error 5xx
        500 => '500 Internal Server Error',
        501 => '501 Not Implemented',
        502 => '502 Bad Gateway',
        503 => '503 Service Unavailable',
        504 => '504 Gateway Timeout',
        505 => '505 HTTP Version Not Supported'*/
        
        else 
        {
            okayDialog("Sorry!\n: ", "Something went wrong,\n Error: "+rescode+" - "+ resmesg);
            
            if(str_param_1.equals("transaction"))
            {
                /*if(rescode.equals("409"))
                {
                    //String resdata = (String) Storage.getInstance().readObject("respdata");
                    //System.err.println(">>>>>>>> "+Storage.getInstance().readObject("respdata")+" >>>>>>>>");
                    //Storage.getInstance().writeObject("temp_member_no", Storage.getInstance().readObject("respdata"));
                    
                    //Storage.getInstance().writeObject("usertype", "member");
                }
                else
                {
                    dlg_payments3.dispose();
                }
                */
                dlg_payments3.dispose();
                
            }
            else
            {
            }
               
            //Dialog.show("Oops!!!", "A network error occured.\nError "+code+": "+message, "Ok", null);
            //HomeMenu home = new HomeMenu();
            //home.showMainScreen();
        }
    }
    

    
    
    /*  
        //TODO: Add logic for checking if photo was already uploaded.
        bool_upload_status = Storage.getInstance().exists("uploadstatus");
        if(bool_upload_status == true)
        {
            str_upload_status = Storage.getInstance().readObject("uploadstatus").toString();
            if(str_upload_status.equals("ok"))
            {
                System.out.println("Photo was already uploaded, please click view pic and delete the previous."); //TODO: Add provision for this.
                sendPhoto();
            }
            else
            {
                sendPhoto();
            }
        }
        else
        {
            System.out.println("Photo not yet uploaded, doing upload now.");
            sendPhoto();
        }
    */
    public void doPhotoUpload() 
    {
        System.out.println("Inside Connect.java - doPhotoUpload");
        
        MultipartRequest request = new MultipartRequest() 
        {
           protected void readResponse(InputStream input) throws IOException  
           {
              JSONParser jp = new JSONParser();
              Map<String, Object> result = jp.parseJSON(new InputStreamReader(input, "UTF-8"));
              
                Object str_stat = (String)result.get("Status");
                Object obj_resp = result.get("Response"); 
                str_response = (String)result.get("Status");
                System.out.println("JSON Response Status from server: "+str_stat);
                
                if(str_stat.equals("ok"))
                {
                    Storage.getInstance().writeObject("uploadstatus", "ok");
                    Dialog.show("Transaction Successful!!", "Thanks for supporting the work of the Lord. Please await a confirmation SMS from us.", "Ok", null);
                    MainMenu homer = new MainMenu();
                        homer.showMainMenu();
                }
                else
                {
                    Storage.getInstance().writeObject("uploadstatus", "no");
                    Dialog.show("Error Occured!", "The server was unable to save your photo. It may be an invalid file, may be too large or an unknown error occured! "+str_stat, "Ok", null);
                    MainMenu homer = new MainMenu();
                        homer.showMainMenu();
                }
           }
           
           protected void handleErrorResponseCode(int code, String message)
           {
                Log.p("Error Response->" + message);
           }

           protected void readHeaders(Object connection) throws IOException 
           {
                String val = getHeader(connection, "MyHeaderName");
                Log.p("Header Response->" + val);

           }

           protected void handleException(Exception err) 
           {
                Dialog.show("Connection Err!!", "Are you connected to the internet? Check your connection", "Ok", null);
           }
        };
        request.setUrl(str_photoUrl);
                
        str_userid = Storage.getInstance().readObject("userid").toString();
                
        bool_trxnid = Storage.getInstance().exists("trx_number");
        if(bool_trxnid == true)
        {
            
            if(!str_trxnid.equals(""))
            {
                str_trxnid = Storage.getInstance().readObject("trx_number").toString();
            }
            else
            {
                str_trxnid = Integer.toString(new Random().nextInt(1999));
            }
        }
        else
        {
            str_trxnid = Integer.toString(new Random().nextInt(1999));
        }
        
        System.out.println("Uploading Image: station_"+str_trxnid+".jpg");
        
        str_mimeType = "image/png";
        str_fileName = "MyImage.png";
        
        try 
        {
            is = Storage.getInstance().createInputStream(str_fileName);
                        
            str_mimeType = "image/jpeg"; //image/png
            request.addData("file", is, Storage.getInstance().entrySize(str_fileName), str_mimeType);
            //request.addData("file", picture, "image/jpeg");
            request.addArgument("userid", str_userid);
            request.setFilename("file", str_trxnid+".jpg");
            
            request.setReadResponseForErrors(true);
            request.addResponseCodeListener(new ActionListener<NetworkEvent>() 
            {
                @Override
                public void actionPerformed(NetworkEvent evt) 
                {
                    NetworkEvent event = (NetworkEvent) evt;
                    Log.p("Err Rsp Code->" + event.getResponseCode());
                    Log.p("ResponseCodeListener:");
                    Log.p(evt.toString());
                }
            });
            
            NetworkManager.getInstance().addToQueue(request);
            System.err.println("Response Data: "+Arrays.toString(request.getResponseData()));
        } 
        catch(IOException err) 
        {
            err.printStackTrace();
        }
    
}
    
    public void getUser()
    {
        Log.p("Inside Connect.java - getUser", l);
        
        str_username = Storage.getInstance().readObject("username").toString();
        str_password = Storage.getInstance().readObject("password").toString();
        
        final String InputParameter = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:gek=\"http://GeKeAPI/\">\n" +
                                                "   <soap:Header/>\n" +
                                                "   <soap:Body>\n" +
                                                "      <gek:getUser>\n" +
                                                "         <!--Optional:-->\n" +
                                                "         <phonenum>"+str_username+"</phonenum>\n" +
                                                "         <!--Optional:-->\n" +
                                                "         <appid>APX17V1506kGE</appid>\n" +
                                                "         <!--Optional:-->\n" +
                                                "         <userpin>"+str_password+"</userpin>\n" +
                                                "      </gek:getUser>\n" +
                                                "   </soap:Body>\n" +
                                                "</soap:Envelope>";
                  
                  
                  ConnectionRequest request = new ConnectionRequest()
                  {
                        @Override
                        protected void buildRequestBody(OutputStream os) throws IOException 
                        {
                            //os.write(InputParameter.getBytes("UTF-8"));
                            
                            Writer writer = null;
                            writer = new OutputStreamWriter(os, "UTF-8");
                            writer.write(InputParameter);
                            writer.flush();
                            writer.close();
                        }
                        
                        @Override
                        protected void postResponse() 
                        {
                            //super.postResponse();
                        }
                        
                        int chr;
                        StringBuffer sb = new StringBuffer();
                        String str_response;
                        @Override
                        protected void readResponse(InputStream input) throws IOException 
                        {
                            XMLParser parser = new XMLParser();
                            Element elem = parser.parse(new InputStreamReader(input));
                            str_response = elem.getChildAt(0).getChildAt(0).getChildAt(0).getChildAt(0).getText().trim();
                            
                            str_login_status = StringUtil.tokenize(str_response, "|").get(0).trim();
                            str_data = StringUtil.tokenize(str_response, "|").get(1).trim();

                            if (str_login_status.equals("OK"))  
                            {
                                str_agent_id    = StringUtil.tokenize(str_data, ";").get(0).trim();
                                str_agent_name  = StringUtil.tokenize(str_data, ";").get(1).trim();
                                str_aspirant_id = StringUtil.tokenize(str_data, ";").get(2).trim();
                                str_station_id  = StringUtil.tokenize(str_data, ";").get(3).trim();
                                
                                Storage.getInstance().writeObject("agent_id", str_agent_id);
                                Storage.getInstance().writeObject("agent_name", str_agent_name);
                                Storage.getInstance().writeObject("aspirant_id", str_aspirant_id);
                                Storage.getInstance().writeObject("station_id", str_station_id);
                                
                                Dialog.show("Login Successful!!", "Thanks for using the campaign app.", "Ok", null);
                                //HomeScreen cls_home = new HomeScreen();
                                //cls_home.showHomeScreen();
                            }
                            else
                            {
                                Dialog.show("Login Failed!!", "Your login credentials are wrong.", "OK", null);
                                LoginMenu loginer = new LoginMenu();
                                loginer.showLoginScreen();
                            }
                        }  
                        
                        protected void handleErrorResponseCode(int code, String message)
                        {
                             Log.p("Error Response->" + message);
                        }

                        protected void readHeaders(Object connection) throws IOException 
                        {
                             String val = getHeader(connection, "MyHeaderName");
                             Log.p("Header Response->" + val);

                        }

                        protected void handleException(Exception err) 
                        {
                             Dialog.show("Yikes!!", "Connection Error!!! Are you connected to the internet?", "Ok", null);
                        }
                  };
                  request.setUrl(str_loginUrl);
                  request.setPost(true);
                  request.setContentType("application/soap+xml;charset=UTF-8");
                  request.addRequestHeader("accept", "application/soap+xml");
                  request.setReadResponseForErrors(true);
                  
                  InfiniteProgress inftprogress = new InfiniteProgress();
                  Dialog dlg_progress = new Dialog();
                  dlg_progress.setDialogUIID("Container");
                  dlg_progress.setLayout(new BorderLayout());
                    
                  Label lbl_progress = new Label("Connecting...\n, Please Wait...");
                  lbl_progress.getStyle().setFgColor(0xffffff, false);
                  lbl_progress.getStyle().setBgTransparency(0);
                  dlg_progress.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterBottom(lbl_progress, inftprogress));
                  dlg_progress.setTransitionInAnimator(CommonTransitions.createEmpty());
                  dlg_progress.setTransitionOutAnimator(CommonTransitions.createEmpty());
                  dlg_progress.showPacked(BorderLayout.CENTER, false);
                    
        
                  NetworkManager.getInstance().addToQueueAndWait(request);
                  request.setDisposeOnCompletion(dlg_progress);
    }
    
    public void getPortfolio()
    {
        Log.p("Inside Connect.java - getAspirants", l);
        
        Storage.getInstance().writeObject("screen", "aspirants");
         final String InputParameter = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:gek=\"http://GeKeAPI/\">\n" +
"   <soap:Header/>\n" +
"   <soap:Body>\n" +
"      <gek:getAllAspirants>\n" +
"         <!--Optional:-->\n" +
"         <userid>"+Storage.getInstance().readObject("agent_id").toString()+"</userid>\n" +
"         <!--Optional:-->\n" +
"         <appid>APX17V1506kGE</appid>\n" +
"         <!--Optional:-->\n" +
"         <position_name>"+Storage.getInstance().readObject("position")+"</position_name>\n" +
"      </gek:getAllAspirants>\n" +
"   </soap:Body>\n" +
"</soap:Envelope>";
          
                  ConnectionRequest request = new ConnectionRequest()
                  {
                        /*@Override
                        protected void handleErrorResponseCode(int code, String message)
                        {
                             Log.p("Error Response->" + message);
                        }
                        
                        @Override
                        protected void handleException(Exception err) 
                        {
                             Dialog.show("Yikes!!", "Connection Error!!! Are you connected to the internet?"+err, "Ok", null);
                        }

                        @Override
                        protected void readHeaders(Object connection) throws IOException 
                        {
                             String val = getHeader(connection, "MyHeaderName");
                             Log.p("Header Response->" + val);
                        }*/
                        
                        @Override
                        protected void buildRequestBody(OutputStream os) throws IOException 
                        {
                            Writer writer = null;
                            writer = new OutputStreamWriter(os, "UTF-8");
                            writer.write(InputParameter);
                            writer.flush();
                            writer.close();
                        }
                        
                        /*@Override
                        protected void postResponse() 
                        {
                        }*/
                        
                        int chr;
                        StringBuffer sb = new StringBuffer();
                        String str_response;
                        @Override
                        protected void readResponse(InputStream input) throws IOException 
                        {
                            XMLParser parser = new XMLParser();
                            Element elem = parser.parse(new InputStreamReader(input));
                            
                            str_response = elem.getChildAt(0).getChildAt(0).getChildAt(0).getChildAt(0).getText().trim();
                            str_response_code = StringUtil.tokenize(str_response, "|").get(0).trim(); System.out.println("Fetch Aspirants Response Data: >>"+str_response_code);//DEBUG
                            str_response_data = StringUtil.tokenize(str_response, "|").get(1).trim(); System.out.println("Fetch Aspirants Response Code: >>"+str_response_data);//DEBUG
                            
                            Storage.getInstance().writeObject("aspirants", str_response_data);
                            
                            if(str_response_code.equals("OK"))  
                            {    
                                str_needle = "^";
                                str_haystack = str_response_data;
                                int lastIndex = 0;
                                int count = 0;
                                
                                while (lastIndex != -1) 
                                {
                                    lastIndex = str_haystack.indexOf(str_needle, lastIndex);

                                    if (lastIndex != -1) 
                                    {
                                        count++;
                                        lastIndex += str_needle.length();
                                    }
                                }
                                Storage.getInstance().writeObject("no_aspirants", count); System.out.println("No. of Aspirants: >"+count);
                                //PortfolioMenu porti = new PortfolioMenu();
                                //porti.showMainScreen();
                            }
                            else//(str_response_code.equals("FAIL"))  
                            {
                                Dialog.show(str_response_code+" - Awww!!!", "Unable to fetch list of Aspirants. "+str_response_data, "OK", null);
                                //PortfolioMenu porti = new PortfolioMenu();
                                //porti.showMainScreen();
                            }
                        }
                  };
                  
                  request.setReadResponseForErrors(true);
                  request.setUrl(str_aspirantsUrl);
                  request.setContentType("application/soap+xml;charset=UTF-8");
                  request.addRequestHeader("accept", "application/soap+xml");
                  request.setPost(true);
                  request.setWriteRequest(true);
                  
                  
                  InfiniteProgress inftprogress = new InfiniteProgress();
                  Dialog dlg_progress = new Dialog();
                  dlg_progress.setDialogUIID("Container");
                  dlg_progress.setLayout(new BorderLayout());
  
                  Label lbl_progress = new Label("Connecting...\n, Please Wait...");
                  lbl_progress.getStyle().setFgColor(0xffffff, false);
                  lbl_progress.getStyle().setBgTransparency(0);
                  dlg_progress.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterBottom(lbl_progress, inftprogress));
                  dlg_progress.setTransitionInAnimator(CommonTransitions.createEmpty());
                  dlg_progress.setTransitionOutAnimator(CommonTransitions.createEmpty());
                  dlg_progress.showPacked(BorderLayout.CENTER, false);
                  
                  NetworkManager.getInstance().addToQueueAndWait(request);
                  request.setDisposeOnCompletion(dlg_progress);
                  
//                    byte[] dataa = request.getResponseData();
//                    if (dataa == null) 
//                    {
//                        Dialog.show("Connection Failed", "Network Error, Check Your Internet Connection", "Ok", null); 
//                        return;
//                    }
                    
                    
                  
    }
    
    public static void okayDialog(String title, String messageToDisplay) 
    {
        final Dialog dialog = new Dialog(title);
        dialog.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Button button = new Button("Okay");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dialog.dispose();
            }
        });
        Container okayDialog = new Container();
        Container messageDialog = new Container();
        TextArea message = new TextArea(messageToDisplay);
        message.setEditable(false);
        okayDialog.setLayout(new FlowLayout(Component.CENTER));
        messageDialog.setLayout(new FlowLayout(Component.CENTER));
        messageDialog.addComponent(message);
        okayDialog.addComponent(button);
        messageDialog.addComponent(okayDialog);
        dialog.addComponent(messageDialog);
        dialog.show();
    }

    public void deleteTransaction() 
    {
        Log.p("Deleting Previous Transaction from storage.", 1);
        
        Storage.getInstance().deleteStorageFile("temp_srl_number");
        Storage.getInstance().deleteStorageFile("temp_trx_number");
        Storage.getInstance().deleteStorageFile("temp_ref_number");
        Storage.getInstance().deleteStorageFile("temp_member_no");
        Storage.getInstance().deleteStorageFile("temp_firstname");
        Storage.getInstance().deleteStorageFile("temp_middlename");
        Storage.getInstance().deleteStorageFile("temp_other_name");
        Storage.getInstance().deleteStorageFile("temp_lastname");
        Storage.getInstance().deleteStorageFile("temp_phone");
        Storage.getInstance().deleteStorageFile("temp_email");
        Storage.getInstance().deleteStorageFile("temp_idnumber");
        Storage.getInstance().deleteStorageFile("usertype");

        Storage.getInstance().deleteStorageFile("start_pdate");
        Storage.getInstance().deleteStorageFile("temp_paymethod");
        Storage.getInstance().deleteStorageFile("security_pin");
        Storage.getInstance().deleteStorageFile("paymethod");
        Storage.getInstance().deleteStorageFile("payprovider");
        Storage.getInstance().deleteStorageFile("pay_instructions");
        Storage.getInstance().deleteStorageFile("totals");


        bool_no_main_items = Storage.getInstance().exists("no_main_items");
        if(bool_no_main_items) //TODO: Remove this as it is redundant since a transaction must have take place.
        {
            str_no_main_items = Storage.getInstance().readObject("no_main_items").toString();
            int_no_main_item = Integer.parseInt(str_no_main_items);

            for (i = 0; i < int_no_main_item+2; i++) //i = 0; i < int_no_main_item; i++
            {
                System.out.println("Deleting... "+"main_item_"+i); //+" = "+str_item
                System.out.println("Deleting... "+"main_itemv_"+i);//+" = "+str_item

                Storage.getInstance().deleteStorageFile("main_item_"+i);
                Storage.getInstance().deleteStorageFile("main_itemv_"+i);

                                                       //main_itemop
                Storage.getInstance().deleteStorageFile("main_itemopm"+"1"+"_"+i);
                Storage.getInstance().deleteStorageFile("main_itemop"+"1"+"_"+i);  //str_itemop1  //"Mpesa"
                Storage.getInstance().deleteStorageFile("main_itemop"+"1"+"v_"+i);              //str_itemop1v //"2000"
                Storage.getInstance().deleteStorageFile("main_itemop"+"1"+"d_"+i); //str_itemop1v //"2020-01-09"
                Storage.getInstance().deleteStorageFile("main_itemop"+"1"+"r_"+i);     //str_itemop1v //"ABC123"

                Storage.getInstance().deleteStorageFile("main_itemopm"+"2"+"_"+i);
                Storage.getInstance().deleteStorageFile("main_itemop"+"2"+"_"+i);  //str_itemop1  //"Mpesa"
                Storage.getInstance().deleteStorageFile("main_itemop"+"2"+"v_"+i);              //str_itemop1v //"2000"
                Storage.getInstance().deleteStorageFile("main_itemop"+"2"+"d_"+i); //str_itemop1v //"2020-01-09"
                Storage.getInstance().deleteStorageFile("main_itemop"+"2"+"r_"+i); //str_itemop1v //"ABC123"

                Storage.getInstance().deleteStorageFile("main_itemopm"+"3"+"_"+i);
                Storage.getInstance().deleteStorageFile("main_itemop"+"3"+"_"+i);  //str_itemop1  //"Mpesa"
                Storage.getInstance().deleteStorageFile("main_itemop"+"3"+"v_"+i);              //str_itemop1v //"2000"
                Storage.getInstance().deleteStorageFile("main_itemop"+"3"+"d_"+i); //str_itemop1v //"2020-01-09"
                Storage.getInstance().deleteStorageFile("main_itemop"+"3"+"r_"+i);
            }
            Storage.getInstance().deleteStorageFile("no_main_items");
            Storage.getInstance().deleteStorageFile("main_item");
        }
        else
        {
        }
        
        bool_no_new_items = Storage.getInstance().exists("no_new_items");
        if(bool_no_new_items) //TODO: Remove this as it is redundant since a transaction must have take place.
        {
            str_no_new_items = Storage.getInstance().readObject("no_new_items").toString();
            int_no_new_items = Integer.parseInt(str_no_new_items);

            for(k=0; k < int_no_new_items; k++)
            {
                System.out.println("Deleting... "+"new_item_"+k); //+" = "+str_item
                System.out.println("Deleting... "+"new_itemv_"+k);//+" = "+str_item

                Storage.getInstance().deleteStorageFile("new_item_"+k);
                Storage.getInstance().deleteStorageFile("new_itemv_"+k);

                Storage.getInstance().deleteStorageFile("new_itemopm"+"1"+"_"+k);
                Storage.getInstance().deleteStorageFile("new_itemop"+"1"+"_"+k);  //str_itemop1  //"Mpesa"
                Storage.getInstance().deleteStorageFile("new_itemop"+"1"+"v_"+k);              //str_itemop1v //"2000"
                Storage.getInstance().deleteStorageFile("new_itemop"+"1"+"d_"+k); //str_itemop1v //"2020-01-09"
                Storage.getInstance().deleteStorageFile("new_itemop"+"1"+"r_"+k);     //str_itemop1v //"ABC123"

                Storage.getInstance().deleteStorageFile("new_itemopm"+"2"+"_"+k);
                Storage.getInstance().deleteStorageFile("new_itemop"+"2"+"_"+k);  //str_itemop1  //"Mpesa"
                Storage.getInstance().deleteStorageFile("new_itemop"+"2"+"v_"+k);              //str_itemop1v //"2000"
                Storage.getInstance().deleteStorageFile("new_itemop"+"2"+"d_"+k); //str_itemop1v //"2020-01-09"
                Storage.getInstance().deleteStorageFile("new_itemop"+"2"+"r_"+k); //str_itemop1v //"ABC123"

                Storage.getInstance().deleteStorageFile("new_itemopm"+"3"+"_"+k);
                Storage.getInstance().deleteStorageFile("new_itemop"+"3"+"_"+k);  //str_itemop1  //"Mpesa"
                Storage.getInstance().deleteStorageFile("new_itemop"+"3"+"v_"+k);              //str_itemop1v //"2000"
                Storage.getInstance().deleteStorageFile("new_itemop"+"3"+"d_"+k); //str_itemop1v //"2020-01-09"
                Storage.getInstance().deleteStorageFile("new_itemop"+"3"+"r_"+k);
            }
            Storage.getInstance().deleteStorageFile("no_new_items");
        }
        else
        {
        }

            
        bool_no_recp_items = Storage.getInstance().exists("no_recp_items");
        if(bool_no_recp_items) //TODO: Remove this as it is redundant since a transaction must have take place.
        {
            boolean bool_recp_items = Storage.getInstance().exists("no_recp_items");
            if(bool_recp_items == true)
            {
                String str_no_recp_items = Storage.getInstance().readObject("no_recp_items").toString();
                int int_no_recp_items = Integer.parseInt(str_no_recp_items);

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

                String str_json_content = str_listcontent;
                byte[] dataa_content = str_json_content.getBytes();

                JSONParser json = new JSONParser();

                try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa_content), "UTF-8"))
                {
                    Map<String, Object> map_content = json.parseJSON(is_content);
                    java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("root");
                    System.out.println("No of Members:---------> "+obj_content.size()); 


                    i = 0;
                    for(Map<String, Object> obj : obj_content) 
                    {
                        bool_recp_items = Storage.getInstance().exists("recp_item_"+i);
                        if(bool_recp_items == true)
                        {
                            str_name = (String)obj.get("name").toString().trim();

                            System.out.println("Deleting Recipients: "+i+". "+str_name);
                            Storage.getInstance().deleteStorageFile("recp_item_"+i);
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



                System.out.println("Deleting Recipients & Recipients count.");
                Storage.getInstance().deleteStorageFile("no_recp_items");
                Storage.getInstance().deleteStorageFile("recp_items");
                Storage.getInstance().deleteStorageFile("acc_open");
                Storage.getInstance().deleteStorageFile("no_fam_mems");

            }
        }
        else
        {
        }

        

        Log.p("Closing finish transaction menu.", 1);
        dlg_payments3.dispose();

        Log.p("Opening new transaction menu.", 1);
        MainMenu nyumbani = new MainMenu();
        nyumbani.showMainMenu();
        nyumbani.showPayDialog1();
    }

}
