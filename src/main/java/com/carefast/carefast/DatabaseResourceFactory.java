/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carefast.carefast;

import com.carefast.carefast.json.JsonDivision;
import com.carefast.carefast.json.JsonEmployee;
import com.carefast.carefast.json.JsonJob;
import com.carefast.carefast.json.JsonPaymentMethod;
import com.carefast.carefast.json.JsonProject;
import com.carefast.carefast.json.JsonRegion;
import com.carefast.carefast.json.JsonReligion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ghazi
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DatabaseResourceFactory {
    
    public DatabaseResourceFactory(){
        
    }
    
    @Path("employee")
    @GET
    public Response getEMployeeData(@QueryParam("tableName") String tableName){
        ArrayList<JsonEmployee> list = new ArrayList<>();
        try {
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM " + tableName);
            while(rs.next()){
                JsonEmployee emp = new JsonEmployee();
                emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
                emp.setEmployeeCode(rs.getString("EMPLOYEE_CODE"));
                emp.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
                emp.setAddress(rs.getString("ADDRESS"));
                emp.setPhone(rs.getString("PHONE"));
                emp.setBirthDate(rs.getDate("BIRTHDATE"));
                emp.setBirthPlace(rs.getString("BIRTHPLACE"));
                emp.setIdNumber(rs.getString("ID_NUMBER"));
                emp.setIsMale(rs.getInt("IS_MALE"));
                emp.setIsMarried(rs.getInt("IS_MARRIED"));
                emp.setReligionId(rs.getInt("RELIGION_ID"));
                emp.setReligionName(rs.getString("RELIGION_NAME"));
                emp.setPaymentMethodId(rs.getInt("PAYMENT_METHOD_ID"));
                emp.setPaymentMethodName(rs.getString("PAYMENT_METHOD_NAME"));
                emp.setBankAccountNumber(rs.getString("BANK_ACCOUNT_NUMBER"));
                emp.setBpjsTkNumber(rs.getString("BPJS_TK_NUMBER"));
                emp.setBpjsKsNumber(rs.getString("BPJS_KS_NUMBER"));
                emp.setJobId(rs.getInt("JOB_ID"));
                emp.setJobName(rs.getString("JOB_NAME"));
                emp.setProjectId(rs.getInt("PROJECT_ID"));
                emp.setProjectCode(rs.getString("PROJECT_CODE"));
                emp.setProjectName(rs.getString("PROJECT_NAME"));
                emp.setCreatedBy(rs.getString("CREATED_BY"));
                emp.setBeginDate(rs.getDate("BEGIN_DATE"));
                emp.setEndDate(rs.getDate("END_DATE"));
                list.add(emp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Response.ok(list).build();
    }
    
    @Path("project")
    @GET
    public Response getProject(){
        ArrayList<JsonProject> list = new ArrayList<>();
        
        try{
            
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM V_PROJECT");
            while(rs.next()){
                JsonProject project = new JsonProject();
                project.setProjectId(rs.getInt("PROJECT_ID"));
                project.setProjectCode(rs.getString("PROJECT_CODE"));
                project.setProjectName(rs.getString("PROJECT_NAME"));
                project.setDivisionId(rs.getInt("DIVISION_ID"));
                project.setDivisionName(rs.getString("DIVISION_NAME"));
                project.setRegionId(rs.getInt("REGION_ID"));
                project.setRegionName(rs.getString("REGION_NAME"));
                project.setBeginDate(rs.getDate("BEGIN_DATE"));
                project.setEndDate(rs.getDate("END_DATE"));
                project.setCreatedBy(rs.getString("CREATED_BY"));
                list.add(project);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Response.ok(list).build();
    }
    
    @Path("division")
    @GET
    public Response getDivision(){
        ArrayList<JsonDivision> list = new ArrayList<>();
        
        try{
            
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM DIVISION");
            while(rs.next()){
                JsonDivision div = new JsonDivision();
                div.setDivisionId(rs.getInt("DIVISION_ID"));
                div.setDivisionCode(rs.getString("DIVISION_CODE"));
                div.setDivisionName(rs.getString("DIVISION_NAME"));
                div.setCreatedBy(rs.getString("CREATE_BY"));
                list.add(div);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Response.ok(list).build();
    }
    
    @Path("religion")
    @GET
    public Response getReligion(){
        ArrayList<JsonReligion> list = new ArrayList<>();
        
        try{
            
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM RELIGION");
            while(rs.next()){
                JsonReligion rlg = new JsonReligion();
                rlg.setReligionId(rs.getInt("RELIGION_ID"));
                rlg.setReligionCode(rs.getString("RELIGION_CODE"));
                rlg.setReligionName(rs.getString("RELIGION_NAME"));
                rlg.setCreatedBy(rs.getString("CREATED_BY"));                
                list.add(rlg);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Response.ok(list).build();
    }
    
    @Path("region")
    @GET
    public Response getRegion(){
        ArrayList<JsonRegion> list = new ArrayList<>();
        
        try{
            
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM REGION");
            while(rs.next()){
                JsonRegion reg = new JsonRegion();
                reg.setRegionId(rs.getInt("REGION_ID"));
                reg.setRegionCode(rs.getString("REGION_CODE"));
                reg.setRegionName(rs.getString("REGION_NAME"));
                reg.setCreatedBy(rs.getString("CREATED_BY"));                
                list.add(reg);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Response.ok(list).build();
    }
    
    @Path("payment-method")
    @GET
    public Response getPaymentMethod(){
        ArrayList<JsonPaymentMethod> list = new ArrayList<>();
        
        try{
            
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM PAYMENT_METHOD");
            while(rs.next()){
                JsonPaymentMethod payment = new JsonPaymentMethod();
                payment.setPaymentMethodId(rs.getInt("PAYMENT_METHOD_ID"));
                payment.setPaymentMethodCode(rs.getString("PAYMENT_METHOD_CODE"));
                payment.setPaymentMethodName(rs.getString("PAYMENT_METHOD_NAME"));
                payment.setCreatedBy(rs.getString("CREATED_BY"));                
                list.add(payment);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Response.ok(list).build();
    }
    
    @Path("job")
    @GET
    public Response getJob(){
        ArrayList<JsonJob> list = new ArrayList<>();
        
        try{
            
            Connection c = this.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM V_JOB");
            while(rs.next()){
                JsonJob job = new JsonJob();
                job.setJobId(rs.getInt("JOB_ID"));
                job.setJobCode(rs.getString("JOB_CODE"));
                job.setJobName(rs.getString("JOB_NAME"));
                job.setDivisionId(rs.getInt("DIVISION_ID"));
                job.setDivisionName(rs.getString("DIVISION_NAME"));
                job.setCreatedBy(rs.getString("CREATED_BY"));                
                list.add(job);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Response.ok(list).build();
    }
    
    @POST
    @Path("/input-division")
    public void inputDiv(JsonDivision div){
        try{
        Connection c = this.getConnection();
        Statement s = c.createStatement();        
        int stmt = s.executeUpdate("INSERT INTO DIVISION (DIVISION_ID, DIVISION_CODE, DIVISION_NAME, CREATED_AT, UDPATED_AT, CREATE_BY) "
                + "VALUES(GEN_ID(GEN_PK,1), '"+div.divisionCode+"', '"+div.divisionName+"', current_timestamp, current_timestamp, 'ADMIN')");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @POST
    @Path("/input-religion")
    public void inputReligion(JsonReligion rlg){
        try{
        Connection c = this.getConnection();
        Statement s = c.createStatement();        
        String query = "INSERT INTO RELIGION (RELIGION_ID, RELIGION_CODE, RELIGION_NAME, CREATED_AT, UPDATED_AT, CREATED_BY)"
                + "VALUES (GEN_ID(GEN_PK,1), '"+rlg.religionCode+"', '"+rlg.religionName+"', current_timestamp, current_timestamp, 'ADMIN')";
        int stmt = s.executeUpdate(query);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @POST
    @Path("/input-payment")
    public void inputPaymentMethod(JsonPaymentMethod pym){
        try{
        Connection c = this.getConnection();
        Statement s = c.createStatement();        
        String query = "INSERT INTO PAYMENT_METHOD (PAYMENT_METHOD_ID, PAYMENT_METHOD_CODE, PAYMENT_METHOD_NAME, CREATED_AT, UPDATED_AT, CREATED_BY)"
                + "VALUES (GEN_ID(GEN_PK,1), '"+pym.paymentMethodCode+"', '"+pym.paymentMethodName+"', current_timestamp, current_timestamp, 'ADMIN')";
        int stmt = s.executeUpdate(query);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @POST
    @Path("/input-region")
    public void inputRegion(JsonRegion reg){
        try{
        Connection c = this.getConnection();
        Statement s = c.createStatement();        
        String query = "INSERT INTO REGION (REGION_ID, REGION_CODE, REGION_NAME, CREATED_AT, UPDATED_AT, CREATED_BY)"
                + "VALUES (GEN_ID(GEN_PK,1), '"+reg.regionCode+"', '"+reg.regionName+"', current_timestamp, current_timestamp, 'ADMIN')";
        int stmt = s.executeUpdate(query);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @POST
    @Path("/input-job")
    public void inputJob(JsonJob job){
        try{
        Connection c = this.getConnection();
        Statement s = c.createStatement();        
        String query = "INSERT INTO JOB (JOB_ID, JOB_CODE, JOB_NAME, DIVISION_ID, CREATED_AT, UPDATED_AT, CREATED_BY)"
                + "VALUES (GEN_ID(GEN_PK,1), '"+job.jobCode+"', '"+job.jobName+"', '"+ job.divisionId +"', current_timestamp, current_timestamp, 'ADMIN')";
        int stmt = s.executeUpdate(query);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @POST
    @Path("/input-project")
    public void inputProject(JsonProject project){
        try{
        Connection c = this.getConnection();
        Statement s = c.createStatement();        
        String query = "INSERT INTO PROJECT (PROJECT_ID, PROJECT_CODE, PROJECT_NAME, DIVISION_ID, REGION_ID, BEGIN_DATE, END_DATE, CREATED_AT, UPDATED_AT, CREATED_BY)"
                + "VALUES (GEN_ID(GEN_PK,1), '"+project.projectCode+"', '"+project.projectName+"', '"+ project.divisionId +"', '"+project.regionId+"', current_timestamp, current_timestamp, 'ADMIN')";
        int stmt = s.executeUpdate(query);
        System.out.println(project.projectCode);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @POST
    @Path("/input-emp")
    public void inputEmployee(JsonEmployee emp){
        try{
        Connection c = this.getConnection();
        Statement s = c.createStatement();
        String tableName = emp.employeeType;
        String query = "INSERT INTO "+tableName+" (EMPLOYEE_ID, EMPLOYEE_CODE, EMPLOYEE_NAME, ADDRESS, PHONE, BIRTHDATE, BIRTHPLACE, ID_NUMBER, IS_MALE, IS_MARRIED, RELIGION_ID, PAYMENT_METHOD_ID, BANK_ACCOUNT_NUMBER, BPJS_TK_NUMBER, BPJS_KS_NUMBER, JOB_ID, PROJECT_ID, CREATED_AT, UPDATE_AT, CREATED_BY, BEGIN_DATE)"
                + " VALUES (GEN_ID(GEN_PK,1), '"+emp.employeeCode+"', '"+emp.employeeName+"', '"+ emp.address +"', '"+emp.phone+"', '"+emp.birthDate+"', '"+emp.birthPlace+"', '"+emp.idNumber+"', '"+emp.isMale+"', '"+emp.isMarried+"', '"+emp.religionId+"', '"+emp.paymentMethodId+"', '"+emp.bankAccountNumber+"', '"+emp.bpjsTkNumber+"', '"+emp.bpjsKsNumber+"', '"+emp.jobId+"', '"+emp.projectId+"', current_timestamp, current_timestamp, 'ADMIN', '"+emp.beginDate+"')";
        
        //String query = "INSERT INTO CSO_1 (EMPLOYEE_ID, EMPLOYEE_CODE, EMPLOYEE_NAME, BEGIN_DATE, END_DATE) VALUES (GEN_ID(GEN_PK,1), '"+emp.employeeCode+"', '"+emp.employeeName+"', '"+emp.beginDate+"', '"+emp.endDate+"')";
        int stmt = s.executeUpdate(query);
        System.out.println(emp.employeeType);
        System.out.println(emp.employeeCode);
        System.out.println(emp.employeeName);
        System.out.println(emp.address);
        System.out.println(emp.phone);
        System.out.println(emp.beginDate);
        System.out.println(emp.birthDate);
        System.out.println(emp.birthPlace);
        System.out.println(emp.idNumber);
        System.out.println("gender: " + emp.isMale);
        System.out.println("Marital status: " + emp.isMarried);
        System.out.println(emp.religionId);
        System.out.println(emp.paymentMethodId);
        System.out.println(emp.bankAccountNumber);
        System.out.println(emp.bpjsTkNumber);
        System.out.println(emp.bpjsKsNumber);
        System.out.println(emp.jobId);
        System.out.println(emp.projectId);
        
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @POST
    @Path("/delete-emp")
    public void deleteEmp(@QueryParam("id") Integer employeeId){
        
    }
    
    
    private Connection getConnection() throws SQLException {
        String url = "jdbc:firebirdsql:localhost/3050:D://CAREFAST.FDB";
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "SYSDBA");
        connectionProps.put("password", "masterkey");

        conn = DriverManager.getConnection(url, "SYSDBA", "masterkey");
        return conn;
    }
}
