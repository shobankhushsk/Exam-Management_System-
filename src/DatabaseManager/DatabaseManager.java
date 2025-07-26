package DatabaseManager;
import BeanClasses.*;
import java.sql.*;
import java.util.*;
import EncoderDecoder.*;
//import SeatListBean;


public class DatabaseManager {

    private static Connection con;
    private static Statement st=null;
    private static ResultSet rs =null;
    
    static{
       try{
            init(); 
       }catch(Exception e){
           e.printStackTrace();
       }
       
    }//end of static

    private static void init()throws Exception{
        
          // Connect to the database
         String dbPath =  "E:\\Bell_Labs_Program\\DataBase\\Examination.accdb";
       // String dbPath = "E:\\JAVA_Programs_A_To_Z\\DataBase\\Examination.accdb";
        String url = "jdbc:ucanaccess://" + dbPath;
        con = DriverManager.getConnection(url);
        System.out.println("Connection successfully");
    
    }//end of init;
    
    public static Vector getFaculty()throws Exception{
        
        String query="SELECT * FROM Faculty FAC_ID";
        System.out.println(query);
       
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            
            while(rs.next()){
            FacultyBean bean=new FacultyBean();
            bean.setFacId(rs.getInt("FAC_ID"));
            bean.setFacName(rs.getString("FAC_NAME"));
            bean.setRemarks(rs.getString("REMARKS"));
            v.addElement(bean);
            
          }//end of while
            
           return v;
        }finally{
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }//end of finally 
    }//end of vector getfaculty
    
    
    
public static Vector getDepartment(int facId) throws Exception{
    
        String query="SELECT * FROM Department where FAC_ID="+facId;
        System.out.println(query);  
        try{
             st = con.createStatement();
             rs = st.executeQuery(query);
             Vector v = new Vector();
           while(rs.next()){
             DepartmentBean bean=new DepartmentBean();
             bean.setFacId(rs.getInt("FAC_ID"));
             bean.setDeptId(rs.getInt("DEPT_ID"));
             bean.setDeptName(rs.getString("DEPT_NAME"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// end of finally
}//end of vector getDepartment

public static Vector getProgram(int deptId)throws Exception{
    
    String query="SELECT * FROM Program where DEPT_ID="+deptId;
        System.out.println(query);  
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                ProgramsBean bean=new ProgramsBean();
                bean.setDeptId(rs.getInt("DEPT_ID"));
                bean.setProgId(rs.getInt("PROG_ID"));
                bean.setProgName(rs.getString("PROG_NAME"));
                bean.setProgDuration(rs.getInt("PROG_DURATION_IN_SEM"));
                bean.setRemarks(rs.getString("REMARKS"));
            
                v.addElement(bean);
            }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// end of finally

}/// end of Vector getProgram 

public static Vector  getBatch(int progId)throws Exception{
    
        String query="SELECT * FROM Batch where PROG_ID="+progId;
        System.out.println(query);
        try{
             st = con.createStatement();
             rs = st.executeQuery(query);
             Vector v = new Vector();
             
           while(rs.next()){
             BatchBean bean=new BatchBean();
             bean.setProgId(rs.getInt("PROG_ID"));
             bean.setBatchId(rs.getInt("BATCH_ID"));
             bean.setShift(rs.getString("SHIFT"));
             bean.setBatchYear(rs.getString("BATCH_YEAR"));
             bean.setGroupDes(rs.getString("GROUP_DES"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// end of finally

}/// end of Vector getBatch 

public static Vector  getStudent(int batchId)throws Exception{
    
 String query="SELECT * FROM Student where BATCH_ID="+batchId;
        System.out.println(query);
        try{
             st = con.createStatement();
             rs = st.executeQuery(query);
             Vector v = new Vector();
           while(rs.next()){
             StudentsBean bean=new StudentsBean();
             
             bean.setBatchId(rs.getInt("BATCH_ID"));
             bean.setStudId(rs.getInt("STUD_ID"));
             bean.setStudName(rs.getString("STUD_NAME"));
             bean.setFname(rs.getString("FATHER_NAME"));
             bean.setSurName(rs.getString("SURNAME"));
             bean.setRollNo(rs.getString("ROLL_NO"));
             bean.setCellNo(rs.getString("PHONE_NO"));
             bean.setRemarks(rs.getString("REMARKS"));
             
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// end of finally
}// end of Vector getStudent 


public static Vector  getStudent()throws Exception{
    
 String query="SELECT * FROM Student";
        System.out.println(query);
        try{
             st = con.createStatement();
             rs = st.executeQuery(query);
             Vector v = new Vector();
           while(rs.next()){
             StudentsBean bean=new StudentsBean();
             
             bean.setBatchId(rs.getInt("BATCH_ID"));
             bean.setStudId(rs.getInt("STUD_ID"));
             bean.setStudName(rs.getString("STUD_NAME"));
             bean.setFname(rs.getString("FATHER_NAME"));
             bean.setSurName(rs.getString("SURNAME"));
             bean.setRollNo(rs.getString("ROLL_NO"));
             bean.setCellNo(rs.getString("PHONE_NO"));
             bean.setRemarks(rs.getString("REMARKS"));
             
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// end of finally
}// end of Vector getStudent 



 public static Vector getPart(int batchId)throws Exception{
        String query="SELECT * FROM Part where BATCH_ID="+batchId;
       // System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
            PartBean bean=new PartBean();

            bean.setBatchId(rs.getInt("BATCH_ID"));
            bean.setPart(rs.getInt("PART"));
            bean.setPartYear(rs.getString("PART_YEAR"));
            bean.setRemarks(rs.getString("REMARKS"));
            v.addElement(bean);
          }//end of while
           return v;
        }finally{
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }//end of finally 
    }//end of getpart
 
  public static Vector getStudentPart(int batchId)throws Exception{
      
        String query="SELECT * FROM StudentsPart where BATCH_ID="+batchId; 
     ///   System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                
            StudentPartBean bean=new StudentPartBean();
            bean.setBatchId(rs.getInt("BATCH_ID"));
            bean.setPart(rs.getInt("PART"));
            bean.setRollNo(rs.getString("ROLL_NO"));
            bean.setStatus(rs.getString("STATUS"));
            bean.setRemarks(rs.getString("REMARKS"));
            v.addElement(bean);
          }//end of while
           return v;
        }finally{
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }//end of finally 
    }//end of getStudentpart
  
  public static Vector getSeatList(int batchId,int part)throws Exception{
      
        String query="SELECT * FROM Seat_List where BATCH_ID="+batchId+" AND PART="+part; 
       // System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                
            SeatListBean bean=new SeatListBean();
            bean.setBatchId(rs.getInt("BATCH_ID"));
            bean.setPart(rs.getInt("PART"));
            bean.setSeatListId(rs.getInt("SL_ID"));
            bean.setSeatListYear(rs.getInt("SL_YEAR"));
            bean.setType(rs.getString("TYPE"));
            bean.setRemarks(rs.getString("REMARKS"));
            v.addElement(bean);
          }//end of while
           return v;
        }finally{
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }//end of finally 
    }//end of getSeatList
  
  public static Vector getSeatListDetail(int seatListId)throws Exception{
        String query="SELECT * FROM SeatListDetail where SL_ID="+seatListId; 
      //  System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                
            SeatListDetailBean bean=new SeatListDetailBean();
            bean.setBatchId(rs.getInt("BATCH_ID"));
            bean.setPart(rs.getInt("PART"));
            bean.setSeatListId(rs.getInt("SL_ID"));
            bean.setRollNo(rs.getString("ROLL_NO"));
            bean.setStatus(rs.getString("STATUS"));
            bean.setRemarks(rs.getString("REMARKS"));
            v.addElement(bean);
          }//end of while
           return v;
        }finally{
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }//end of finally 
    }//end of getSeatListDetail
  
  public static Vector getScheme(int progId)throws Exception{
    
        String query="SELECT * FROM Scheme where PROG_ID="+progId+" order by SCHEME_YEAR";
        System.out.println(query);
        try{
             st = con.createStatement();
             rs = st.executeQuery(query);
             Vector v = new Vector();
           while(rs.next()){
             SchemeBean bean=new SchemeBean();
             
             bean.setProgId(rs.getInt("PROG_ID"));
             bean.setSchemeId(rs.getInt("SCHEME_ID"));
             bean.setSchemeYear(rs.getInt("SCHEME_YEAR"));
             bean.setGroupDes(rs.getString("GROUP_DES"));
             bean.setMiniMarks(rs.getInt("MINI_MARKS"));
             bean.setRemarks(rs.getString("REMARKS"));
         
             v.addElement(bean);
             
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// end of finally
}/// end of Vector getScheme

  
  public static Vector getSchemePart(int schemeId)throws Exception{
      
        String query="SELECT * FROM SchemePart where SCHEME_ID="+schemeId;
        //System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                SchemePartBean bean=new SchemePartBean();
                bean.setSchemeId(rs.getInt("SCHEME_ID"));
                bean.setSchemePart(rs.getInt("SCHEME_PART"));
                bean.setRemarks(rs.getString("REMARKS"));
                v.addElement(bean);
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getSchemepart
  
  public static Vector getSchemeSemester(int schemePart,int schemeId)throws Exception{
      
        String query="SELECT * FROM Scheme_Semester where SCHEME_PART="+schemePart+" AND SCHEME_ID="+schemeId;
        System.out.println(query);
        
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                SchemeSemesterBean bean=new SchemeSemesterBean();
                bean.setSchemeId(rs.getInt("SCHEME_ID"));
                bean.setPartScheme(rs.getInt("SCHEME_PART"));
                bean.setSemester(rs.getInt("SEMESTER"));
                bean.setRemarks(rs.getString("REMARKS"));
                v.addElement(bean);
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getSchemeSemester
  
  public static Vector getSchemeDetail(int semester,int schemeId,int schemePart)throws Exception{
       String query="SELECT *  FROM Scheme_Detail where SEMESTER="+semester+" AND SCHEME_ID="+schemeId+" AND SCHEME_PART="+schemePart;
        System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                SchemeDetailBean bean=new SchemeDetailBean();
                
                bean.setSchemeId(rs.getInt("SCHEME_ID"));
                bean.setSchemePart(rs.getInt("SCHEME_PART"));
                bean.setSemester(rs.getInt("SEMESTER"));
                bean.setCourseNo(rs.getString("COURSE_NO"));
                bean.setCourseTtile(rs.getString("COURSE_TITLE"));
                bean.setMaxMarks(rs.getInt("MAX_MARKS"));
                bean.setcreditHours(rs.getInt("CREDIT_HOURS"));
                bean.setSubType(rs.getString("SUB_TYPE"));
                bean.setRemarks(rs.getString("REMARKS"));
                v.addElement(bean);
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getSchemeDetail
  
  
  
  
   public static Vector getNotification(int semester,int schemeId,int schemePart,int notificationId)throws Exception{
       String query="SELECT *  FROM Notification_Of_Class where SEMESTER="+semester+" AND SCHEME_ID="+schemeId+" AND SCHEME_PART="+schemePart+" AND NOTIFICATION_ID="+notificationId;
        System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                NotificationClassBean bean=new NotificationClassBean();
                
                bean.setSchemeId(rs.getInt("SCHEME_ID"));
                bean.setSchemePart(rs.getInt("SCHEME_PART"));
                bean.setSemester(rs.getInt("SEMESTER"));
                bean.setCourseNo(rs.getString("COURSE_NO"));
                bean.setNotificationId(rs.getInt("NOTIFICATION_ID"));
                bean.setData_Of_Class(rs.getString("DATE_OF_CLASS"));
                bean.setTime_Of_Class(rs.getString("TIME_OF_CLASS"));
                bean.setNotification_Send(rs.getString("NOTIFICATION_SEND"));
                
                bean.setRemarks(rs.getString("REMARKS"));
                v.addElement(bean);
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getSchemeDetail
  
   
     public static Vector getNotification()throws Exception{
       String query="SELECT *  FROM Notification_Of_Class";
        System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                NotificationClassBean bean=new NotificationClassBean();
                
                bean.setSchemeId(rs.getInt("SCHEME_ID"));
                bean.setSchemePart(rs.getInt("SCHEME_PART"));
                bean.setSemester(rs.getInt("SEMESTER"));
                bean.setCourseNo(rs.getString("COURSE_NO"));
                bean.setNotificationId(rs.getInt("NOTIFICATION_ID"));
                bean.setData_Of_Class(rs.getString("DATE_OF_CLASS"));
                bean.setTime_Of_Class(rs.getString("TIME_OF_CLASS"));
                bean.setNotification_Send(rs.getString("NOTIFICATION_SEND"));
                
                bean.setRemarks(rs.getString("REMARKS"));
                v.addElement(bean);
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getSchemeDetail
  
  
  
  public static Vector getLedger(int seatListId,int schemeId)throws Exception{
      
       String query="SELECT * FROM Ledger where SL_ID="+seatListId+" AND SCHEME_ID="+schemeId;
        System.out.println(query);
        
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                LedgerBean bean=new LedgerBean();
                bean.setSLId(rs.getInt("SL_ID"));
                bean.setSchemeId(rs.getInt("SCHEME_ID"));
                bean.setTabulatorName(rs.getString("TABULATOR_NAME"));
                bean.setCheckerName(rs.getString("CHECKER_NAME"));
                bean.setDateOfAnnouncement(rs.getDate("DATE_OF_ANNOUNCEMENT"));
                bean.setRemarks(rs.getString("REMARKS"));
                v.addElement(bean);
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getLedger
  
    public static Vector getLedgerDetail(String courseNo)throws Exception{ 
       String query="SELECT * FROM LedgerDetail where COURSE_NO like '"+courseNo+"' ";
        System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                
                LedgerDetailBean bean=new LedgerDetailBean(); 
                bean.setSeatListId(rs.getInt("SL_ID"));
                bean.setSchemeId(rs.getInt("SCHEME_ID"));
                bean.setSchemePart(rs.getInt("SCHEME_PART"));
                bean.setSemester(rs.getInt("SCHEME_SEMESTER"));
                bean.setCourseNO(rs.getString("COURSE_NO"));
                bean.setRollNo(rs.getString("ROLL_NO"));
                bean.setMarksObt(rs.getInt("OBT_MARKS"));
                bean.setQP(rs.getInt("QP"));
                bean.setGrade(rs.getString("GRADE"));
                bean.setResult(rs.getString("RESULT"));
                bean.setRemarks(rs.getString("REMARKS"));
                v.addElement(bean);
                
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getLedgerDetail
    

   
    
   public static Vector getLedgerDetailSummary(int slId)throws Exception{ 
       String query="SELECT * FROM Ledger_Detail_Summary where SL_ID="+slId;
        System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                
                LedgerDetailSummaryBean bean=new LedgerDetailSummaryBean(); 
                bean.setSeatListId(rs.getInt("SL_ID"));
                bean.setRollNo(rs.getString("ROLL_NO"));
                bean.setGPA(rs.getString("GPA"));
                bean.setTotalMarks(rs.getInt("TOTAL_MARKS"));
                bean.setMarksObt(rs.getInt("OBT_MARKS"));
                bean.setResult(rs.getString("RESULT"));
                bean.setPercentage(rs.getString("PERCENTAGE"));
                bean.setIndividaulDateOfAnn(rs.getDate("INDIVIDUAL_DATE_ANNOUNCEMENT"));
                bean.setRemarks(rs.getString("REMARKS"));
                v.addElement(bean);
                
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getLedgerDetailSummary
     
   
   
     public static Vector getTimeTable(int deptId)throws Exception{ 
       String query="SELECT * FROM TIME_TABLE where DEPT_ID="+deptId;
        System.out.println(query);
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Vector v = new Vector();
            while(rs.next()){
                
                TimeTableBean bean=new TimeTableBean();
                
                bean.setDeptId(rs.getInt("DEPT_ID"));
                bean.setTimeTableId(rs.getInt("TIME_TABLE_ID"));
                bean.setDescription(rs.getString("DESC"));
                 bean.setRemarks(rs.getString("REMARKS"));
                
                v.addElement(bean);
                
            }//end of while
            return v;
        }finally{
            if(rs!=null)
                rs.close();
            if(st!=null)st.close();
        }//end of finally 
  }//end of getTimeTable
     
   public static Vector  getTeacher(int deptId)throws Exception{
    
 //String query="SELECT * FROM students";
   //     System.out.println(query);
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM teacher where DEPT_ID="+deptId);
             Vector v = new Vector();
           while(rs.next()){
             TeacherBean bean=new TeacherBean();
             
             bean.setDeptId(rs.getInt("DEPT_ID"));
           
             bean.setTeacherId(rs.getInt("TEACHER_ID"));
             bean.setTeacherName(rs.getString("TEACHER_NAME"));
             bean.setFname(rs.getString("FATHER_NAME"));
             bean.setSurName(rs.getString("SUR_NAME"));
             bean.setDataOfBirth(rs.getString("DATE_OF_BIRTH"));
             bean.setRemarks(rs.getString("REMARKS"));
             bean.setNic(rs.getString("NIC"));
             bean.setEmail(rs.getString("EMAIL"));
             bean.setContactNo(rs.getString("CONTACT_NO"));
             bean.setDateOfAppointment(rs.getString("DATE_OF_APPOINTMENT"));
             bean.setDesignationAppointment(rs.getString("DESIGNATION_AT_THE_TIME_OF_APPOINTMENT"));
             bean.setCurrentDesignation(rs.getString("CURRENT_DESIGNATION"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally


}/// end of getTeacher Method
   
 public static Vector  getTeacher()throws Exception{
    
 //String query="SELECT * FROM students";
   //     System.out.println(query);
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM teacher");
             Vector v = new Vector();
           while(rs.next()){
             TeacherBean bean=new TeacherBean();
             
             bean.setDeptId(rs.getInt("DEPT_ID"));
           
             bean.setTeacherId(rs.getInt("TEACHER_ID"));
             bean.setTeacherName(rs.getString("TEACHER_NAME"));
             bean.setFname(rs.getString("FATHER_NAME"));
             bean.setSurName(rs.getString("SUR_NAME"));
             bean.setDataOfBirth(rs.getString("DATE_OF_BIRTH"));
             bean.setRemarks(rs.getString("REMARKS"));
             bean.setNic(rs.getString("NIC"));
             bean.setEmail(rs.getString("EMAIL"));
             bean.setContactNo(rs.getString("CONTACT_NO"));
             bean.setDateOfAppointment(rs.getString("DATE_OF_APPOINTMENT"));
             bean.setDesignationAppointment(rs.getString("DESIGNATION_AT_THE_TIME_OF_APPOINTMENT"));
             bean.setCurrentDesignation(rs.getString("CURRENT_DESIGNATION"));
             bean.setRemarks(rs.getString("REMARKS"));
            
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally

    }/// end of getTeacher Method   
    
 
 
 public static Vector  getAssignment(int teacherId)throws Exception{
    
 //String query="SELECT * FROM students";
   //     System.out.println(query);
        try{
             st = con.createStatement();
             rs = st.executeQuery("SELECT * FROM ASSIGNMENT where TEACHER_ID="+teacherId);
             Vector v = new Vector();
           while(rs.next()){
             AssignmentBean bean=new AssignmentBean();
             
             bean.setAssginId(rs.getInt("ASSIGN_ID"));
             bean.setTeacherId(rs.getInt("TEACHER_ID"));
             bean.setAssigTitle(rs.getString("ASSIGN_TITLE"));
             bean.setStartDate(rs.getString("START_DATE"));
             bean.setLastDate(rs.getString("LAST_DATE"));
             bean.setAssignDesc(rs.getString("ASSIGN_DESC"));
             bean.setRemarks(rs.getString("REMARKS"));
             bean.setWhoDoTheAssign(rs.getString("WHO_DO_THE_ASSIGN"));
             v.addElement(bean);
           }//end of while
            return v; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally

 }
 
public static int addFaculty(String facName,String remarks)throws Exception{
        String query="insert into Faculty (FAC_NAME,REMARKS) values ('"+facName+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }//end of finally
        }//end of addFaculty


public static int updateFaculty(int facId,String facName,String remarks) throws Exception{
        String query= "update Faculty set FAC_NAME='"+facName+"',REMARKS='"+remarks+"' where FAC_ID="+facId;
        System.out.println(query);
        Statement st=null;
        try{
            
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    } //end of updateFaculty
 

 public static int deleteFaculty(int facId)throws Exception{
        String query="delete from Faculty where FAC_ID="+facId;
         System.out.println(query);
         Statement st=null;
         try{
             st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
        }finally{
             if(st!=null){
                 st.close();
             }
        }//end of finally
    }//end of deleteFaculty
 
 
 public static int addDepartment(int facId,String deptName, String remarks)throws Exception{
        
    String query="insert into Department(FAC_ID,DEPT_NAME,REMARKS) values ("+facId+",'"+deptName+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }//end of finally
        }// end of addDepartment
 
 public static int updateDepartment(int deptId, String deptName, String remarks)throws Exception{
        String query = "update Department set DEPT_NAME='"+deptName+"', REMARKS='"+remarks+"'where DEPT_ID="+deptId;
        
        
        System.out.println(query);
        Statement st=null;
        try{
            
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
              st.close();
            }
        }// end of finally
    }// end of updateDepartment

    
 public static int deleteDepartment(int deptId)throws Exception{
        String query="delete from Department where DEPT_ID="+deptId;
         System.out.println(query);
         Statement st=null;
        try{
             st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
        }finally{
             if(st!=null){
                 st.close();
             }
        }//end of finally
    }// end of deleteDepartment
 
 
 public static int addProgram(int deptId,String progName,int progDuration, String remarks)throws Exception{
        String query="insert into Program (DEPT_ID,PROG_NAME,PROG_DURATION_IN_SEM,REMARKS) values ("+deptId+",'"+progName+"',"+progDuration+",'"+remarks+"')";
        
            System.out.println(query);
          //  Statement st=null;
            try{
                Statement st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }//end of finally
        }// end of addProgram

 
 public static int updateProgram(int progId, String progName, String progDuration, String remarks)throws Exception{
      String query= "update Program set PROG_NAME='"+progName+"',PROG_DURATION_IN_SEM='"+progDuration+"',REMARKS='"+remarks+"'where PROG_ID="+progId;
                  
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    }// end of upadteProgram
 
 public static int deleteProgram(int progId)throws Exception{
        String query="delete from Program where PROG_ID="+progId;
         System.out.println(query);
         Statement st=null;
        try{
             st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
             if(st!=null){
                 st.close();
             }
        }//end of finally
        
    }//end of deleteProgram
 
 public static int addBatch(int progId, String batchYear,String shift,String groupDes,String remarks)throws Exception{
        String query="insert into Batch (PROG_ID,BATCH_YEAR,SHIFT,GROUP_DES,REMARKS) values ("+progId+","+batchYear+",'"+shift+"','"+groupDes+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }//end of finally
        }// end of addBatch

 public static int updateBatch(int batchId, String shift, String batchYear, String groupDes, String remarks)throws Exception{
        String query= "update Batch set BATCH_YEAR='"+batchYear+"',SHIFT='"+shift+"',GROUP_DES='"+groupDes+"',REMARKS='"+remarks+"'where BATCH_ID="+batchId;
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    }// end of updateBatch
    
  public static int deleteBatch(int batchId)throws Exception{
        String query="delete from Batch where BATCH_ID="+batchId;
         System.out.println(query);
         Statement st=null;
        try{
             st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
             if(st!=null){
                 st.close();
             }
        } // end of finally
    } // end of deleteBatch

  public static int addStudent(int batchId,String studName,String fatherName,String surName,String rollNo,String remarks)throws Exception{
        String query="insert into Student (BATCH_ID,STUD_NAME,FATHER_NAME,SURNAME,ROLL_NO,REMARKS) values ("+batchId+",'"+studName+"','"+fatherName+"','"+surName+"','"+rollNo+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }//end of finally
        }// end of addStudent
  
 public static int updateStudent(int studId,String studName,String fatherName,String surName,String rollNo,String remarks)throws Exception{
        String query= "update Student set STUD_NAME='"+studName+"',FATHER_NAME='"+fatherName+"',SURNAME='"+surName+"',ROLL_NO='"+rollNo+"',REMARKS='"+remarks+"'where STUD_ID="+studId;
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
 }//end of updateStudent

 public static int deleteStudent(int studId)throws Exception{
        String query="delete from Student where STUD_ID="+studId;
         System.out.println(query);
         Statement st=null;
        try{

            st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
            
             if(st!=null){
                 st.close();
             }  
         } // end of finally
    } // end of deleteStudent
 
    public static int addPart(int batchId, int part, String partYear, String remarks)throws Exception{
      String query="insert into Part (BATCH_ID,PART,PART_YEAR,REMARKS) values ("+batchId+","+part+",'"+partYear+"','"+remarks+"')";
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
              return rows;
            }finally{
                if(st!=null)st.close();
            }//end of finally
    }//end of addpart
 
    public static int updatePart(int part, String partYear, String remarks) throws Exception{
        String query= "update Part set PART_YEAR='"+partYear+"',REMARKS='"+remarks+"'where PART="+part;
        System.out.println(query);
        Statement st=null;
        try{
           st=con.createStatement();
           int rows=st.executeUpdate(query);
           return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    } //end of updatePart
 
    public static int deletePart(int part)throws Exception{
        String query="delete from Part where PART="+part;
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
             if(st!=null){
                 st.close();
            }
        }//end of finally
    }//end of deletePart

    
    public static int addStudentPart(int batchId, int part, String rollNo,String status, String remarks)throws Exception{
      String query="insert into StudentsPart (BATCH_ID,PART,ROLL_NO,STATUS,REMARKS) values ("+batchId+","+part+",'"+rollNo+"','"+status+"','"+remarks+"')";
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
              return rows;
            }finally{
                if(st!=null)st.close();
            }//end of finally
    }//end of addStudentpart
    
    public static int updateStudentPart(int part, String rollNo,String remarks) throws Exception{
        String query= "update StudentsPart set ROLL_NO='"+rollNo+"',REMARKS='"+remarks+"'where PART="+part;
        System.out.println(query);
        Statement st=null;
        try{
           st=con.createStatement();
           int rows=st.executeUpdate(query);
           return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    } //end of updateStudentPart
    
        public static int deleteStudentPart(int part)throws Exception{
        String query="delete from StudentsPart where PART="+part;
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
             if(st!=null){
                 st.close();
            }
        }//end of finally
    }//end of deletePart
        
            public static int addSeatList(int batchId, int part, int seatListYear,String type, String remarks)throws Exception{
                String query="insert into Seat_List (BATCH_ID,PART,SL_YEAR,TYPE,REMARKS) values ("+batchId+","+part+","+seatListYear+",'"+type+"','"+remarks+"')";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addseatList

            public static int updateSeatList(int seatListId, int seatListYear, String type ,String remarks) throws Exception{
                String query= "update Seat_List set SL_YEAR="+seatListYear+",TYPE='"+type+"',REMARKS='"+remarks+"'where SL_ID="+seatListId;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    } //end of updateseatList
            
            public static int deleteSeatList(int slId)throws Exception{
        String query="delete from Seat_List where SL_ID="+slId;
        System.out.println(query);
        Statement st=null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
             if(st!=null){
                 st.close();
            }
        }//end of finally
    }//end of deleteseatList

            public static int addSeatListDetails(int sLId,String rollNo,String status,int batchId,int part,String remarks)throws Exception{
             String query="insert into SeatListDetail(SL_ID,ROLL_NO,STATUS,BATCH_ID,PART,REMARKS) values ("+sLId+",'"+rollNo+"','"+status+"',"+batchId+","+part+",'"+remarks+"')";   
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addSeatListDetail
            
            public static int updateSeatListDetail(String rollNo,int part,int batchId,String status,String remarks) throws Exception{
                String query= "update SeatListDetail set STATUS='"+status+"',REMARKS='"+remarks+"'where BATCH_ID="+batchId+" and PART="+part+" AND ROLL_NO='"+rollNo+"'";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    } //end of updateseatList
            
            public static int deleteSeatListDetails(int slId,int batchId,int part,String rollNo)throws Exception{
                String query="delete from SeatListDetail where SL_ID="+slId+" AND BATCH_ID="+batchId+" AND PART="+part+" AND ROLL_NO='"+rollNo+"'";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of deleteseatList
            
            
            public static int addScheme(int progId,int schemeYear,String groupDes,int miniMarks,String remarks)throws Exception{
                String query="insert into Scheme (PROG_ID,SCHEME_YEAR,GROUP_DES,MINI_MARKS,REMARKS) values ("+progId+","+schemeYear+",'"+groupDes+"',"+miniMarks+",'"+remarks+"')";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addScheme
            
            public static int updateScheme(int schemeId, int schemeYear, String groupDes ,int miniMarks,String remarks) throws Exception{
                String query= "update Scheme set SCHEME_YEAR="+schemeYear+",GROUP_DES='"+groupDes+"',MINI_MARKS="+miniMarks+",REMARKS='"+remarks+"'where SCHEME_ID="+schemeId;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    } //end of updatescheme
            
          public static int deleteScheme(int SchemeId,int progId)throws Exception{
                String query="delete from Scheme where SCHEME_ID="+SchemeId+" AND PROG_ID="+progId;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }// end of finally
            }//end of deleteScheme  
     
     
            
            public static int addSchemePart(int schemeId,int schemePart,String remarks)throws Exception{
                String query="insert into SchemePart (SCHEME_ID,SCHEME_PART,REMARKS) values ("+schemeId+","+schemePart+",'"+remarks+"')";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addSchemePart
            
            
            public static int updateSchemePart(int schemePart,String remarks) throws Exception{
                String query= "update SchemePart set REMARKS='"+remarks+"'where SCHEME_PART="+schemePart;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
            if(st!=null){
                st.close();
            }
        }//end of finally
    } //end of updateschemePart
            public static int deleteSchemePart(int schemePart,int schemeId)throws Exception{
                String query="delete from SchemePart where SCHEME_PART="+schemePart+" AND SCHEME_ID="+schemeId;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of deleteSchemePart
            
            public static int addSchemeSemester(int schemeId,int schemePart,int semester,String remarks)throws Exception{
                String query="insert into Scheme_Semester (SCHEME_ID,SCHEME_PART,SEMESTER,REMARKS) values ("+schemeId+","+schemePart+","+semester+",'"+remarks+"')";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addSchemeSemester
            
            public static int updateSchemeSemester(int schemeId,int partScheme,int semester,String remarks)throws Exception{
               String query = "update Scheme_Semester set SCHEME_PART=" + partScheme +",SCHEME_ID="+schemeId+", REMARKS='" + remarks + "' where SEMESTER=" +semester;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of updateScheme
            public static int deleteSchemeSemester(int semester,int schemeId,int schemePart)throws Exception{
                String query="delete from Scheme_Semester where SEMESTER="+semester+" AND SCHEME_ID="+schemeId+" AND SCHEME_PART="+schemePart;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of deleteSchemeSemester
            
            
            public static int addSchemeDetail(int schemeId,int schemePart,int semester,String courseNo,String courseTitle,int maxMarks,int credithrs,String subType,String remarks)throws Exception{
                String query="insert into Scheme_Detail (SCHEME_ID,SCHEME_PART,SEMESTER,COURSE_NO,COURSE_TITLE,MAX_MARKS,CREDIT_HOURS,SUB_TYPE,REMARKS) values ("+schemeId+","+schemePart+","+semester+",'"+courseNo+"','"+courseTitle+"',"+maxMarks+","+credithrs+",'"+subType+"','"+remarks+"')";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addSchemeDetail
                
            
            public static int updateSchemeDetail(int schemeId,int maxMarks,String courseNO,String courseTitle,int schemePart,int semester,String remarks)throws Exception{
               //String query = "update SchemeDetail set SCHEME_ID=" + partScheme +",MAX_MARKS="+schemeId+", COURSE_TITLE='" + remarks + "' where SEMESTER=" +semester;
               String query = "UPDATE Scheme_Detail SET MAX_MARKS =" + maxMarks + ", COURSE_TITLE = '" + courseTitle + "', REMARKS = '" + remarks + "' WHERE SCHEME_ID = " + schemeId + " AND COURSE_NO = '"+courseNO+"' and SCHEME_PART="+schemePart+" and SEMESTER="+semester; 
               System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of updateSchemeDetail
            
            public static int deleteSchemeDetail(String courseNo)throws Exception{
                String query="delete from Scheme_Detail where COURSE_NO="+courseNo;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of deleteSchemeDetail
            
            
            public static int addLedger(int seatListId,int schemeId,String tabulatorName,String checkerName,String doa,String remarks)throws Exception{
                if(doa.equals(""))
              doa=null;
            else
                doa="#"+doa+"#";
                
                String query="insert into Ledger (SL_ID,SCHEME_ID,TABULATOR_NAME,CHECKER_NAME,DATE_OF_ANNOUNCEMENT,REMARKS) values ("+seatListId+","+schemeId+",'"+tabulatorName+"','"+checkerName+"',"+doa+",'"+remarks+"')";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addLedger
            
            public static int updateLedger(int schemeId,String tabulatorName,String checkerName,String doa,String remarks)throws Exception{
                if(doa.equals(""))
              doa=null;
            else
                doa="#"+doa+"#";    
               String query = "Update Ledger set TABULATOR_NAME='" + tabulatorName + "', CHECKER_NAME= '" + checkerName + "',DATE_OF_ANNOUNCEMENT="+doa+", REMARKS = '" + remarks + "' where SCHEME_ID="+schemeId; 
               System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of updateLegder
            
            public static int deleteLedger(int schemeId,int slId)throws Exception{
                String query="delete from Ledger where SCHEME_ID="+schemeId+" AND SL_ID="+slId;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of deleteLedger
            
            public static int addLedgerDetail(String rollNo, int seatListId ,int schemeId,int schemePart,int semester,String courseNo, int obtMarks,int qp,String grade,String result,String remarks) throws SQLException{
                String query="insert into LedgerDetail (ROLL_NO,SL_ID,SCHEME_ID, SCHEME_PART, SCHEME_SEMESTER, COURSE_NO,OBT_MARKS,QP,GRADE,RESULT,REMARKS) values ('"+rollNo+"',"+seatListId+","+schemeId+","+schemePart+","+semester+",'"+courseNo+"',"+obtMarks+","+qp+",'"+grade+"','"+result+"','"+remarks+"')";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addLedgerDetail
            
            public static int updateLedgerDetail(int seatListId,int schemeId,int schemePart,int semester,String courseNo, String rollNo,int obtMarks,int qp,String grade,String result,String remarks) throws SQLException{
               String query ="UPDATE LedgerDetail SET ROLL_NO='"+rollNo+"', OBT_MARKS = "+obtMarks+", QP = "+qp+", GRADE='"+grade+"',RESULT='"+result+"' ,REMARKS = '" + remarks + "'WHERE COURSE_NO = '"+courseNo+"' and SCHEME_SEMESTER="+semester+"  and SCHEME_PART="+schemePart+" and SCHEME_ID="+schemeId+" and SL_ID="+seatListId;
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of updateLedgerDetail
            
          public static int deleteLedgerDetail(String courseNo,int semester, int schemePart, int schemeId,int seatListId, String rollNo ) throws SQLException {
            String query = "DELETE FROM LedgerDetail WHERE COURSE_NO = '" + courseNo + "' AND SCHEME_SEMESTER = " + semester + " AND SCHEME_PART = " + schemePart + " AND SCHEME_ID = " + schemeId + " AND SL_ID = " + seatListId + " AND ROLL_NO = '" + rollNo + "'";
            System.out.println(query);
            Statement st = null;
            try {
                st = con.createStatement();
                int rows = st.executeUpdate(query);
                return rows;
            } finally {
                if (st != null) {
                    st.close();
                }
            }
        }

            
            public static int addLedgerDetailSummary(int seatListId,String rollNo,String gpa,int totalMarks,int obtMarks,String result,String percentage,String IDA,String remarks) throws SQLException{
                if(IDA.equals(""))
              IDA=null;
            else
                IDA="#"+IDA+"#";
                String query="insert into Ledger_Detail_Summary (SL_ID,ROLL_NO,GPA,TOTAL_MARKS,OBT_MARKS,RESULT,PERCENTAGE,INDIVIDUAL_DATE_ANNOUNCEMENT,REMARKS) values ("+seatListId+",'"+rollNo+"','"+gpa+"',"+totalMarks+","+obtMarks+",'"+result+"','"+percentage+"',"+IDA+",'"+remarks+"')";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null)st.close();
                }//end of finally
            }//end of addLedgerDetail
            
            public static int updateLedgerDetailSummary(int seatListId,String rollNo,String gpa,int totalMarks,int obtMarks,String result,String percentage,String IDA,String remarks)throws Exception{
                if(IDA.equals(""))
              IDA=null;
            else
                IDA="#"+IDA+"#";    
               String query = "Update Ledger_Detail_Summary  set GPA= '"+gpa+"' ,TOTAL_MARKS= "+totalMarks+" ,OBT_MARKS="+obtMarks+" ,RESULT='"+result+"' ,PERCENTAGE='"+percentage+"' ,INDIVIDUAL_DATE_ANNOUNCEMENT= "+IDA+" ,REMARKS = '" + remarks + "' where ROLL_NO = '"+rollNo+"' and SL_ID="+seatListId; 
               System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of updateLegder
            
            public static int deleteLedgerDetailSummary(int seatListId,String rollNo)throws Exception{
                String query="delete from Ledger_Detail_Summary where SL_ID="+seatListId+" AND ROLL_NO='"+rollNo+"'";
                System.out.println(query);
                Statement st=null;
                try{
                    st=con.createStatement();
                    int rows=st.executeUpdate(query);
                    return rows;
                }finally{
                    if(st!=null){
                        st.close();
                    }
                }//end of finally
            }//end of deleteLedgerDetailSummary
            
            
            

   public static LoginBean userLoginFrom(String userName, String pass) throws Exception {
    
        try{
            String sql = "SELECT * FROM Login WHERE USER_NAME='"+userName+"' AND USER_PASS='"+pass+"'";
            System.out.println(sql);
            st = con.createStatement();
             rs = st.executeQuery(sql);
             
             LoginBean bean = null; 
           if(rs.next()){
               bean = new LoginBean();
               bean.setROLE(rs.getString("ROLE"));
               bean.setUSER_ID(rs.getInt("USER_ID"));
               bean.setUSER_NAME(rs.getString("USER_NAME"));
               bean.setUSER_PASS(rs.getString("USER_PASS"));
             
               return bean;
           }//end of while
            return bean; 
        }finally{
        
            if(rs!=null)
                rs.close();
           if(st!=null)st.close();
        }/// emd of finally


}/// end of getTeacher Method
            
            
//   public static int userLoginFrom(String userName, String pass) throws Exception {
//    String sql = "SELECT * FROM Login WHERE USER_NAME=? AND USER_PASS=?";
//    System.out.println(sql);
//    PreparedStatement pst = null;
//    ResultSet rs = null;
//    try {
//        pst = con.prepareStatement(sql);
//        pst.setString(1, userName);
//        pst.setString(2, pass);
//        rs = pst.executeQuery();
//
//        if (rs.next()) {
//            // If the query returns at least one row, the username and password are correct
//            return 1;
//        } else {
//            // If the query returns no rows, the username and password do not match
//            return 0;
//        }
//    } finally {
//        // Close resources in the finally block to ensure proper cleanup
//        if (rs != null) rs.close();
//        if (pst != null) pst.close();
//    }
//}
            
            
            
        
            
   
     public static int addRegsterFrom(String userName,String pass, String email)throws Exception{
        String query="insert into Login (USER_NAME,USER_PASS,EMAIL) values ('"+userName+"','"+pass+"','"+email+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }//end add customer
           
    
     public static int addTimeTable(int deptId, String dec, String remarks) throws Exception {
        String query = "INSERT INTO TIME_TABLE (DEPT_ID, DESC, REMARKS) VALUES (?, ?, ?)";
        System.out.println(query);

    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setInt(1, deptId);
        preparedStatement.setString(2, dec);
        preparedStatement.setString(3, remarks);
        int rows = preparedStatement.executeUpdate();
        return rows;
    } catch (SQLException e) {
        // Handle the exception appropriately
        e.printStackTrace();
        throw e;
    }
}

     public static int updateTimeTable(int teacherId, String newDesc, String newRemarks) throws Exception {
    String query = "UPDATE TIME_TABLE SET DESC = ?, REMARKS = ? WHERE TIME_TABLE_ID = ?";
    System.out.println(query);

    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setString(1, newDesc);
        preparedStatement.setString(2, newRemarks);
        preparedStatement.setInt(3, teacherId);

        int rows = preparedStatement.executeUpdate();
        return rows;
    } catch (SQLException e) {
        // Handle the exception appropriately
        e.printStackTrace();
        throw e;
    }
}
     
     
     public static int deleteTimeTable(int TimeId) throws Exception {
    String query = "DELETE FROM TIME_TABLE WHERE TIME_TABLE_ID = ?";
    System.out.println(query);

    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setInt(1, TimeId);

        int rows = preparedStatement.executeUpdate();
        return rows;
    } catch (SQLException e) {
        // Handle the exception appropriately
        e.printStackTrace();
        throw e;
    }
}


     
     
//   static int getMaxTimeTableId() throws Exception {
//    String query = "SELECT MAX(time_table_id) FROM TIME_TABLE";
//    System.out.println(query);
//
//    try {
//        st = con.createStatement();
//        rs = st.executeQuery(query);
//
//        int num = 0;
//
//        if (rs.next()) {
//            num = rs.getInt(1);
//        }
//
//        return num;
//    } finally {
//        // Close resources in the finally block
//        if (rs != null) rs.close();
//        if (st != null) st.close();
//    }
//}

     
     
  public static int addTeacher(int deptId,String contactNo,String teacherName,String fatherName,String surName,String dateOfBirth,String  dateOfAppointment,String  designationAtTheOfAppointment,String currentDesignation,String cNic,String email,String remarks)throws Exception{
        String query="insert into teacher (DEPT_ID,TEACHER_NAME,FATHER_NAME,SUR_NAME,DATE_OF_BIRTH,CONTACT_NO,DATE_OF_APPOINTMENT,DESIGNATION_AT_THE_TIME_OF_APPOINTMENT,CURRENT_DESIGNATION,NIC,EMAIL,REMARKS) values ("+deptId+",'"+teacherName+"','"+fatherName+"','"+surName+"','"+dateOfBirth+"','"+contactNo+"','"+dateOfAppointment+"','"+designationAtTheOfAppointment+"','"+currentDesignation+"','"+cNic+"','"+email+"','"+remarks+"')";
            System.out.println(query);
            Statement st=null;
            try{
                st=con.createStatement();
                int rows=st.executeUpdate(query);
                return rows;
            }finally{
                if(st!=null)st.close();
            }
        }// end add Stduent
        
         public static int updateTeacher(int teacherId,String contactNo,String teacherName,String fatherName,String surName,String dateOfBirth,String  dateOfAppointment,String  designationAtTheOfAppointment,String currentDesignation,String cNic,String email,String remarks)throws Exception{
        String query= "update teacher set CONTACT_NO='"+contactNo+"',TEACHER_NAME='"+teacherName+"',FATHER_NAME='"+fatherName+"',SUR_NAME='"+surName+"',DATE_OF_BIRTH='"+dateOfBirth+"',DATE_OF_APPOINTMENT='"+dateOfAppointment+"',DESIGNATION_AT_THE_TIME_OF_APPOINTMENT='"+designationAtTheOfAppointment+"',CURRENT_DESIGNATION='"+currentDesignation+"',NIC='"+cNic+"',EMAIL='"+email+"',REMARKS='"+remarks+"'where TEACHER_ID="+teacherId;
        System.out.println(query);
        Statement st=null;
        try{    
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;
        }finally{
            if(st!=null){
                st.close();
            }
        }
    }// end upadte Student
   
        public static int deleteTeacher(int teacherId)throws Exception{
        String query="delete from teacher where TEACHER_ID="+teacherId;
         System.out.println(query);
         Statement st=null;
        try{

            st=con.createStatement();
             int rows=st.executeUpdate(query);
             return rows;
             
         }finally{
            
             if(st!=null){
                 st.close();
             }
             
         } // end finally
        
    } // end DeleteTeacher
              
      
          
  public static int addAssignment(int teacherId, String assigTitle, String startDate, String lastDate, String assignDesc, String whoDoTheAssign, String remarks) throws Exception {
    String query = "INSERT INTO ASSIGNMENT (TEACHER_ID, ASSIGN_TITLE, START_DATE, LAST_DATE, ASSIGN_DESC, WHO_DO_THE_ASSIGN, REMARKS) VALUES (?, ?, ?, ?, ?, ?, ?)";
    System.out.println(query);

    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setInt(1, teacherId);
        preparedStatement.setString(2, assigTitle);
        preparedStatement.setString(3, startDate);
        preparedStatement.setString(4, lastDate);
        preparedStatement.setString(5, assignDesc);
        preparedStatement.setString(6, whoDoTheAssign);
        preparedStatement.setString(7, remarks);

        int rows = preparedStatement.executeUpdate();
        return rows;
    } catch (SQLException e) {
        // Handle the exception appropriately
        e.printStackTrace();
        throw e;
    }
}
  
  public static int updateAssignment(int assignmentId, String assigTitle, String startDate, String lastDate, String assignDesc, String whoDoTheAssign, String remarks) throws Exception {
    String query = "UPDATE ASSIGNMENT SET ASSIGN_TITLE=?, START_DATE=?, LAST_DATE=?, ASSIGN_DESC=?, WHO_DO_THE_ASSIGN=?, REMARKS=? WHERE ASSIGN_ID=?";
    System.out.println(query);

    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setString(1, assigTitle);
        preparedStatement.setString(2, startDate);
        preparedStatement.setString(3, lastDate);
        preparedStatement.setString(4, assignDesc);
        preparedStatement.setString(5, whoDoTheAssign);
        preparedStatement.setString(6, remarks);
        preparedStatement.setInt(7, assignmentId);

        int rows = preparedStatement.executeUpdate();
        return rows;
    } catch (SQLException e) {
        // Handle the exception appropriately
        e.printStackTrace();
        throw e;
    }
}
  public static int deleteAssignment(int assignmentId) throws Exception {
    String query = "DELETE FROM ASSIGNMENT WHERE ASSIGN_ID=?";
    System.out.println(query);

    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
        preparedStatement.setInt(1, assignmentId);

        int rows = preparedStatement.executeUpdate();
        return rows;
    } catch (SQLException e) {
        // Handle the exception appropriately
        e.printStackTrace();
        throw e;
    }
}

public static int addNotification(int schemeId, int schemePart, int semester, String courseNo, String data_Of_Class, String time_Of_Class, String notification_Send, String remarks) throws Exception {
    String query = "INSERT INTO Notification_Of_Class (SCHEME_ID, SCHEME_PART, SEMESTER, COURSE_NO, DATE_OF_CLASS, TIME_OF_CLASS, NOTIFICATION_SEND, REMARKS) VALUES (" + schemeId + "," + schemePart + "," + semester + ",'" + courseNo + "','" + data_Of_Class + "','" + time_Of_Class + "','" + notification_Send + "','" + remarks + "')";
    System.out.println(query);
    Statement st = null;
    try {
        st = con.createStatement();
        int rows = st.executeUpdate(query);
        return rows;
    } finally {
        if (st != null) st.close();
    } // end of finally
    
}

public static int updateNotification(int notificationId, int schemeId, int schemePart, int semester, String courseNo, String data_Of_Class, String time_Of_Class, String notification_Send, String remarks) throws Exception {
    String query = "UPDATE Notification_Of_Class SET SCHEME_ID=" + schemeId + ", SCHEME_PART=" + schemePart + ", SEMESTER=" + semester
            + ", COURSE_NO='" + courseNo + "', DATE_OF_CLASS='" + data_Of_Class + "', TIME_OF_CLASS='" + time_Of_Class
            + "', NOTIFICATION_SEND='" + notification_Send + "', REMARKS='" + remarks + "' WHERE NOTIFICATION_ID=" + notificationId;
    System.out.println(query);
    Statement st = null;
    try {
        st = con.createStatement();
        int rows = st.executeUpdate(query);
        return rows;
    } finally {
        if (st != null) st.close();
    } // end of finally
}


public static int deleteNotification(int notificationId) throws Exception {
    String query = "DELETE FROM Notification_Of_Class WHERE NOTIFICATION_ID=?";
    System.out.println(query);
    PreparedStatement preparedStatement = null;
    try {
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, notificationId);

        int rows = preparedStatement.executeUpdate();
        return rows;
    } finally {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }//end of finally
}

  
          
          
          
          
            
            public  static void main(String arg[]){
             DatabaseManager ob=new DatabaseManager();
       
   }//END OF MAIN METHOD
            
}//END OF DatabaseManager
