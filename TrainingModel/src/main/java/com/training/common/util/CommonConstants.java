package com.training.common.util;

import java.util.Calendar;
import java.util.Date;


public class CommonConstants {

	public final static Long STATUS_ACTIVE = 1L;
	public final static Long STATUS_INACTIVE = 0L;
	
	public final static int STATUS_ACTIVE_INT = 1;
	public final static int STATUS_INACTIVE_INT = 0;
	
	public final static int STATUS_PASS = 1;
	public final static int STATUS_FAILED = 0;
	
	public final static int STATUS_APPROVAL = 1;
	public final static int STATUS_REJECT = 0;

	public final static Long ADMIN_ROLE = 1L;
	public final static Long USER_ROLE = 2L;

	public static final long DOCUMENT_MAX_SIZE_UPLOAD = 10; // MB

	// DATE FORMAT
	public static final String DATE_FORMAT_DDMMYYYY = "dd-MM-yyyy";
	public static final String DATE_FORMAT_DDMMMYY = "dd-MMM-yy";
	public static final String DATE_FORMAT_DDMMMYYYY = "dd-MMM-yyyy";
	public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String DATE_FORMAT_ddMMyyyy = "dd/MM/yyyy";

	// FILE
	public static final String DOT = ".";
	public static final String UNDER_LINE = "_";
	public static final String FOLDER_REFERENCE_ID_FORMAT = "SL-%04d%02d%02d";

	// TRAINING CLASS

	public static final String TRAINING_CLASS_CELL0 = "TT";
	public static final String TRAINING_CLASS_CELL1 = "Tên khóa học";
	public static final String TRAINING_CLASS_CELL2 = "Mã kỳ thi";
	public static final String TRAINING_CLASS_CELL3 = "StartDate";
	public static final String TRAINING_CLASS_CELL4 = "EndDate";
	public static final String TRAINING_CLASS_CELL5 = "Ngày thi (*)";
	public static final String TRAINING_CLASS_CELL6 = "Giờ thi (*)";
	public static final String TRAINING_CLASS_CELL7 = "Tỉnh/thành phố (*)";
	public static final String TRAINING_CLASS_CELL8 = "Quận/Huyện/Thành phố/Thị xã (*)";
	public static final String TRAINING_CLASS_CELL9 = "Xã/Phường/Thị trấn (*)";
	public static final String TRAINING_CLASS_CELL10 = "Số nhà, phố (*)";
	public static final String TRAINING_CLASS_CELL11 = "SL thi dự kiến (*)";
	public static final String TRAINING_CLASS_CELL12 = "Thi trực tuyến tập trung (*)";
	public static final String TRAINING_CLASS_CELL13 = "Tự tổ chức thi trực tuyến";
	public static final String TRAINING_CLASS_CELL14 = "CT Thi (*)";
	public static final String TRAINING_CLASS_CELL15 = "Trainer";
	public static final String TRAINING_CLASS_CELL16 = "Mã chi nhánh";
	
	public static final String TRNGCLAS_EXAM_IDNUM_HEADER = "Số CMND";
	public static final String TRNGCLAS_EXAM_SCORE_HEADER = "Điểm";
	
	public static final String AVICAD_IDNUM_HEADER = "IDNUM";
	public static final String AVICAD_AGTSTS_HEADER = "AGTSTS";
	
	public static final String DOC_UPLOAD_TRAINING_CLASS="DOC_00";
	public static final String DOC_UPLOAD_AVICAD="DOC_01";
	public static final String DOC_UPLOAD_RESULT="DOC_02";
	public static final String DOC_UPLOAD_ATDE="DOC_03";
	
	//ATTEMP TYPE
	public static final String EXAM_TYPE_CODE = "EXAM_TYP";
	public static final String ATTEMP_TIME_1ST = "01";
	
	//FIND AVICAD STATUS
	public static final String CANDIDATE_STATUS_LOV_TYPE = "CAD_ST";
	public static final String CANDIDATE_STATUS_AVICAD = "AVICAD";
	public static final String CANDIDATE_STATUS_INIT = "INIT";
	public static final String CANDIDATE_STATUS_APPROVED = "APPROVED";
	public static final String CANDIDATE_STATUS_REJECT = "REJECT";
	
	
	//FIND TRAINING CLASS STATUS
	public static final String TRAINING_CLASS_STATUS_LOV_TYPE = "CLAS_ST";
	
	public static final String TRAINING_CLASS_INPROGESS = "CLAS_GO";
	public static final String TRAINING_CLASS_TERMINATED = "CLAS_TER";
	public static final String TRAINING_CLASS_PENDING = "CLAS_PEND";
	public static final String TRAINING_CLASS_COMPLETED = "CLAS_COMP";
	
	//TRAINING CLASS ATTENDEE
	public static final String ATDE_ATTEMP_LOV_TYPE = "ATED_TYP";
	public static final String ATDE_ATTEMP_1ST = "01";
	public static final String ATDE_ATTEMP_RETEST = "02";
	public static final String ATDE_ATTEMP_REJOIN = "03";
	
	// FIND CONTACT TYPE
	public static final String CLIENT_CONTACT_LOV_TYPE = "CNTCT_TYP";	
	public static final String CLIENT_CONTACT_EMAIL = "E";
	public static final String CLIENT_CONTACT_MOBILE = "M";
	public static final String POST_EMAIL_TEMPLATE = "@sales.sunlife.com.vn";
	
	
	//EXPORT  
	public static final String REPORT_HEADER_DATA = "attachment; filename=\"%s\"";
	public static final String REPORT_IRT_FILE_NAME = "IRT_checking.xlsx";
    public static final String REPORT_DATA_KEY = "data";
    public static final String REPORT_FONT_NAME = "Calibri";
	
    
    //GENDER TYPE
    public static final String MALE = "Nam";
    public static final String FEMALE = "Nữ";
    
    public static final String SEX_MALE_CODE = "M";
    public static final String SEX_FEMALE_CODE = "F";
    public static final String SEX_LOV_TYPE = "GEN";
    
    //ADDRESS
    public static final String ADDRESS_LOV_TYPE = "ADDR_TYP";
    public static final String ADDRESS_RESIDENT_CODE = "RES";
    public static final String ADDRESS_CONTACT_CODE = "CON";
    
    //MAIRTIAL
    public static final String MARITIAL_LOV_TYPE = "MARL";
    public static final String MARITIAL_MARRIED_CODE = "M";
    public static final String MARITIAL_SINGLE_CODE = "S";
    
    //OCCUPATION LOVE TYPE
    public static final String OCCUPATION_LOV_TYPE = "OCCP";
    
    //EDUCATION
    public static final String EDU_LOV_TYPE = "EDU";
    public static final String EDU_VOCATION_SCHOOL_CODE = "UNS";
    public static final String EDU_HIGHT_SCHOOL_CODE = "HS";
    public static final String EDU_COLLEGE_CODE = "COL";
    public static final String EDU_UNIVERSITY_CODE = "UNI";
    public static final String EDU_MASTER_CODE = "MAS";
    
    //EXAM TYPE
    public static final String EXAMTYPE_TYPE = "EXAM_TYP";
    
    public static final String IRT_DOCUMENT = "IRT";
    public static final String ATTENDEE_LIST_CONFIRM = "Attendee_list_confirm";
    public static final String ATTENDEE_LIST_TRACKING = "Attendee_list_tracking";
    
    public static final String QUERY_GET_NEXTVAL = "Select %s.nextVal FROM DUAL";
    public static final String SEQ_AGENT_CD = "SEQ_AGT_CD";
    
    //TRAINING TYPE - COURSE
    public static final String COURSE_DLBH = "SSU";
    
    //Job titles
    public static final String AGENT_TITLE_LOV = "AGT_TITLE";
    public static final String AGENT_TITLE_CANDT = "CNDDT";
    public static final String AGENT_TITLE_AGT = "AG";
    public static final String AGENT_TITLE_PUM = "PUM";
    public static final String AGENT_TITLE_UM = "UM";
    public static final String AGENT_TITLE_SUM = "SUM";
    public static final String AGENT_TITLE_BM = "BM";
    public static final String AGENT_TITLE_ZD = "ZD";
    public static final String AGENT_TITLE_TD = "TD";
    
    public static final String UNIT_TEAM_CD = "UNT";
    public static final String BRANCH_TEAM_CD = "BRANCH";
    public static final String ZONE_TEAM_CD = "ZD";
    
    //Agent Status
    public static final String AGENT_STATUS_LOV_TYP = "AGT_STAT_FLG";
    public static final String AGENT_STATUS_ACTIVE = "1";
    public static final String AGENT_STATUS_DISABLE = "0";
    public static final String AGENT_STATUS_TERMINATED = "-1";
    
    //Deafult channel code
    public static final String AGENT_DEFAULT_CHANNEL = "AGNT_CHNL";
    public static final long AGENT_DEFAULT_CHANNEL_ID = 1;
    public static final String AGENT_DEFAULT_HIERARCHY = "AGT_HIER";
    public static final String AD_HIERARCHY = "AD_HIER";
    
    //Default for agent
    public static final String AGENT_CATEGORY_TYPE_COD = "AGT_CAT";
    public static final String AGENT_CATEGORY_DEFAULT_COD = "FA";
    public static final String AGENT_AGRMT_TYPE_COD = "AGR_TYP";
    public static final String AGENT_AGRMT_DEFAULT_COD = "CAN";
    
    public static final String BUSINESS_TYPE_COD = "BUS_TYP";
    public static final String STATE_MANAGEMENT_COD = "STA";
    public static final String FINANCE_COD = "FIN";
    public static final String INSURANCE_COD = "INS";
    public static final String OTHER_COD = "OTH";
    public static final String MANAGER_COD = "MAN";
    public static final String DIRECTOR_COD = "DIR";
    public static final String OTHER_PREFIX_COD = "O_";
    
    public static final String MOVEMENT_LOV_TYPE = "MOV_TYP";
    public static final String REINSTATE_LOV_CODE = "REINSTATE";
    public static final String TERMINATED_LOV_CODE = "TERMINATE";
    public static final String DEMOTE_LOV_CODE = "DEMOTE";
    public static final String NEW_LOV_CODE = "ONBOARD";
    
    public static final int REINSTATE_UNCHECK_DATE = 90;
    public static final int REINSTATE_CHECK_DATE = 180;
    
    public static Date addDay(Date timestamp, int amount) {
		if (timestamp != null) {
			Date date = new Date(timestamp.getTime());
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, amount);
			return calendar.getTime();
		}
		return null;
	}
	
	public static Date convertToStartOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date == null ? new Date() : date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	public static Date convertToEndOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date == null ? new Date() : date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static long getDateCountBetween(Date start, Date end) {
		return (end.getTime() - start.getTime())/ (24*60*60*1000);
	}
	
	public static Date getDateBefore(Date dateInput, boolean startOfDateFlag) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateInput == null ? new Date() : dateInput);
		calendar.add(Calendar.DATE, -1);
		if (startOfDateFlag) {
			return convertToStartOfDay(calendar.getTime());
		} else {
			return convertToEndOfDay(calendar.getTime());
		}
	}
}

