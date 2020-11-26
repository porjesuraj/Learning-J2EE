# j2EE syllabus 

1. Java Server Pages,
2.  JDBC, 
3.  JavaBeans,
4.   Java Security,
5.   Naming Services,
6.   Java Annotations,
7.    Java Mail,
8.     Java Messaging Services,
9.     Transactions, 
10.    Apache maven, 
11.    Introduction to hibernate,
12.     HQL,
13.      Hibernate, 
14.      Spring Framework, 
15.      Hands on Web services – JSON/XML/oData (data format conversation)


# day1

### demo 

1. add external tomcat server to eclipse java 

- for formatting 
```
cltr + shift + F 
```

2. Servelets in 
  > javax.servlet
```java
javax.servlet
public interface Servlet
```
- Defines methods that all servlets must implement.
- A servlet is a small Java program that runs within a Web server.
 Servlets receive and respond to requests from Web clients, usually across HTTP, the HyperText Transfer Protocol.
- To implement this interface, you can write a generic servlet that extends javax.servlet.GenericServlet or
-  an HTTP servlet that extends javax.servlet.http.HttpServlet 

3. Generic Servelet
```java
public abstract class GenericServlet
extends Object
implements Servlet, ServletConfig, Serializable
```
- Defines a generic, protocol-independent servlet. To write an HTTP servlet for use on the Web, extend HttpServlet instead.


4. HTTP Servlet

```java
public abstract class HttpServlet
extends GenericServlet
```
- Provides an abstract class to be subclassed to create an HTTP servlet suitable for a Web site.
-  A subclass of HttpServlet must override at least one method, usually one of these:
1. doGet, if the servlet supports HTTP GET requests
2. doPost, for HTTP POST requests
3. doPut, for HTTP PUT requests
4. doDelete, for HTTP DELETE requests
- init and destroy, to manage resources that are held for the life of the servlet
- getServletInfo, which the servlet uses to provide information about itself
- There's almost no reason to override the service method. 
- service handles standard HTTP requests by dispatching them to the handler methods for each HTTP request type (the doXXX methods listed above).

- Likewise, there's almost no reason to override the doOptions and doTrace methods.


## demo in eclipse 
5. method for deployment of servlet in app 
-  declare survolate in a dynamic web app
   
- 1. using xml 
-  server deployment tags in web.xml file 
```xml
 <!-- server deployment tags -->
  <servlet>
  <servlet-name>abc</servlet-name>
  <servlet-class>pages.HelloServlet2</servlet-class>
  <load-on-startup>2</load-on-startup>
  
  </servlet>
  <servlet-mapping>
  <servlet-name>abc</servlet-name>
  <url-pattern>/test3</url-pattern>
  <url-pattern>/hello</url-pattern>
  
  </servlet-mapping>
```

- 2. using annotation 
```java
    // URL ://host:port/lab_1.1/test
	// URI : context path (lab_1.1)
	// URL Pattern : /test



@WebServlet(value= {"/test","/test2"},loadOnStartup = 1)
//WC processes this annotation , at the deployment time and adds the mapping between URL pattern and servlet 
//WC creates an empty map (Hash Map)
//key : URL pattern (/test)
//value : Fully qualified servlet class name 

// this is same in both methods 
public class HelloServlet extends HttpServlet {
//todo step 3
}

```
- 3. rest of code , in both method
- need to override method (init,destroy, and service method ) 

```java
// this is same in both methods 
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		System.out.println("in do-get " + Thread.currentThread());
		// set response content type for the cln broswwer 
		resp.setContentType("text/html");	
		// open print writer to send response from servlet --> clnt (text)		
		try(PrintWriter pw = resp.getWriter())
		{
			pw.print("<h1> hello from HelloServlet @" + LocalDateTime.now() + "</h2>"); 
		}
	}
	@Override
	public void destroy() {
	
		System.out.println("in destroy  "  + Thread.currentThread());
	}
	@Override
	public void init() throws ServletException {
		
		System.out.println("in init of " + this.getClass().getName() + " " + Thread.currentThread());
    }	
}
```

7. having two servlet with same url pattern,or without '/' ,gives exception 
```java
Caused by: java.lang.IllegalArgumentException: The servlets named [pages.HelloServlet] and [pages.HelloServlet2] are both mapped to the url-pattern [/test] which is not permitted
```

8. get info from request object using 
- 1. getParameters  - single value 
- 2. getParametersValues - for array
```java
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
            pw.print("<h2> Email : " + request.getParameter("email"));
			pw.print("<h2> Password : " + request.getParameter("password"));
		}	
	}

```


# Day2

## to read
1. overriding form of the method cannot add any new or Broader checked exception

## notes


### demos

1. 

- 1. 
```java

```
- 2. 
```java

```
- 3. it redirects doesnt print pw given here 
- as WC clears discard pw buffer , and send redirect response only 
```java
try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h5> Successfully Login </h5>");
			// http proto stateless, so new request no data of pre request 
			pw.print("Details" + request.getParameter("em"));
			
		}
	}
```


2. 

- 1. 
```java

```
- 2. 
```java

```
- 3. 
```java

```

3. 

- 1. 
```java

```
- 2. 
```java

```
- 3. 
```java

```

4. 

- 1. 
```java

```
- 2. 
```java

```
- 3. 
```java

```


# Day3

## to read
1. read Interface HttpSession 

## notes


### demos

1. 

- 1. 
```java

```
- 2. 
```java

```
- 3. 
```java

```


2. 

- 1. 
```java

```
- 2. 
```java

```
- 3. 
```java

```

3. 

- 1. 
```java

```
- 2. 
```java

```
- 3. 
```java

```

4. 

- 1. 
```java

```
- 2. 
```java

```
- 3. 
```java

```

# Day4

## to read
Lab sequence

Common instructions after you import web application in your workspace
1. Import  project in your workspace
2. Fix build errors (How R click on project --build path --configure build path --Edit )
3. Copy your DBUtils under utils package.(remove mine) OR make the changes in web.xml

- In case of problems : follow clean up instructions , explained in theory session


1. Import day4.1 .
-  Follow common instructions
- Demo of servlet config , init-params & writing DB independent web application(using xml config)
-  Open : web.xml , DBUtils & LoginServlet
 
2. Import day4.3 . Follow common instructions
- Revise server pull (Request dispatching : forward scenario)
- OPen LoginServlet & CatalogServlet

3. Import day4.4 . Follow common instructions
-  Revise server pull (Request dispatching : include scenario)
- OPen LoginServlet & CatalogServlet

4. Import day4.5 Follow common instructions
- Demo to Make web application DB independent (using  ServletContext)
- (i.e if underlying DB changes ---no changes in java code BUT add DB specific details(JDBC drvr class, dbURL,userName , pwd) in xml based config files)
- Open : web.xml, DBConnectionManager(listener), DBUtils , DAOs.

5. Solve assignemnt





# DAY5 


## notes


### demos

1. 

- 1. 
```java

```
- 2. 
```java

```
- 3. 
```java

```


# Day 7

## to read Common instructions 


1. Create from scratch , hibernate based Java SE application. Test the same.

2. Steps for Hibernate + Java SE
- 1. Change perspective to Java
- 2. Create Java project(Java SE project) , in the same workspace (DON'T change the workspace)
- 3. Create new user lib containing hibernate JARs.+ JDBC JARs
- (window--preferences---user lib --hib_lib --add external jars  
- from (hibernate-help/hibernate 5 jars/) -
- go to preference ---> select All (Ctrl A) ---apply n close


4. Add user lib to project's build path
- R click on project ---build path --configure build path --add user lib

5. Create <resources> folder --as a new src folder.
- Copy from (day7_data/day7_help/hibernate-help/config-files) -- hibernate.cfg.xml & EDIT it as per your DB settings.
- (r click on <src> --new --src folder ---resources)

6. Copy <utils> folder under <src>
- (Contains HibernateUtils)

7. Create a class TestHibernate under <tester> package.
- Add following code. 
```java
import static utils.HibernateUtils.*;
import org.hibernate.*;

public class TestHibernate {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf())
		{
			System.out.println("Hibernate booted.....");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```
8. Run this as java application ,
-  check console to see , sf created & hib booted .
- Above confirms bootstrapping of hibernate framework.

9. Create a POJO n test auto table creation
- 9.1.  Create a User POJO
  - Add these Data members
  - userId (PK) ,name,email,password,role(enum),confirmPassword, regAmount;
	 LocalDate/Date regDate;
	 byte[] image;
  - Add JPA annotations
  - Confirm auto table creation.

- 9.2 Add <mapping> entry per POJO in hibernate.cfg.xml

10. Create Hibernate based DAO layer , to insert a record.
- 10.1 DAO layer i/f
- String registerUser(User user);
- 10.2 Hibenrate based DAO implementation class
- no data mebers, no constr,no clean up
-  CRUD method

11. Create a main(...) based tester to test entire application , for user registration.
- Next Objective : time permitting

- 1. Import  day7.2 project in your workspace
- 2. Fix build errors (How R click on project --build path --configure build path --Edit )
- 3. Edit web.xml

- In case of problems : follow clean up instructions , explained in theory session
- Revise : Open login.jsp & trace the flow 


## demos

0. Test URl rewriting,Centralized Error Handling in JSP,include directive
```html
<body>

<h5> <a href="test1.jsp?pid=123&price=200&category=book">Test URl rewriting: client pull I  </a> </h5>

<h5> <a href="test3.jsp?pid=123&price=200&category=book">Test URl rewriting: client pull II  </a> </h5>


<h5> <a href="test4.jsp?pid=123&price=200&category=book">Test URl rewriting: client pull I using JSTL   </a> </h5>

<h5> <a href="test5.jsp?pid=123&price=200&category=book">Test URl rewriting: client pull II using JSTL   </a> </h5>

<h5> <a href="test6.jsp">Test Centralized Error Handling in JSP </a> </h5>

<h5> <a href="test7.jsp"> Testing include directive</a> </h5>
</body>

```

1. Test URl rewriting: client pull I 
- using jsp action
```java
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<body>

<%-- save product details under session scope w/o using scriplet --%>

<c:set var="product_dtls" value ="${param.pid} : ${param.price} : ${param.category}" scope="session" />
<%  
// use url rewriting : method of http servlet response : encodeURL 
    String encodedURL = response.encodeURL("test2.jsp"); 
%>
<h4> <a href="<%= encodedURL %>"> Next</a></h4>
</body>

--- test2
<body>
<h5 >Prodct details : ${sessionScope.product_dtls} </h5>
</body>

```

2. Test URl rewriting: client pull II
```java
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<%-- save product details under session scope w/o using scriplet --%>
<c:set var="product_dtls" value ="${param.pid} : ${param.price} : ${param.category}" scope="session" />
<%  
// use url rewriting : method of htpp servlet response : encodeURL 
    String encodedURL = response.encodeRedirectURL("test2.jsp");
response.sendRedirect(encodedURL); 
%>
</body>

```

3. Test URl rewriting: client pull I using JSTL
```java
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<body>
<%-- save product details under session scope using JSTL --%>
<c:set var="product_dtls" value ="${param.pid} : ${param.price} : ${param.category}" scope="session" />
<%-- <c:url value="next page location (test2.jsp)" />  --%>
<h4> <a href="<c:url value='test2.jsp'/>"> Next</a></h4>
</body>
```

4. Test URl rewriting: client pull II using JSTL
```java
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<body>
<%-- save product details under session scope--%>
<c:set var="product_dtls" value ="${param.pid} : ${param.price} : ${param.category}" scope="session" />
<c:redirect url="test2.jsp" />
```

5. Test Centralized Error Handling in JSP
```xml
--- in web.xml file 
  <!--  error page tags used for centralized error handling -->
  <error-page>
  <exception-type> java.lang.Exception</exception-type>
  <location>/err_Handler.jsp</location>
  </error-page>
  <!-- <error-page>
  <error-code>404</error-code>
  <location>/page_not_found.jsp</location>
  </error-page> -->
```

- err_Handling.jsp 
  
```java
%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<body>

<%-- get error data --%>
<h5> Error Causing page : ${pageContext.errorData.requestURI}  </h5>
<h4 >Error message: ${pageContext.exception.message} </h4>
<h4> Error Status code :${pageContext.errorData.statusCode}</h4>
<h4> Error details: ${pageContext.errorData.throwable} </h4>
<h4 >Via Expression Tag Errro Details : <%= exception %></h4>
</body>
```
- 
6. Testing include directive
- both pages get merged, into the page in which include tag is used
```java

--- 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<%! String message="hello..."; // what is it? : instance var available : private %> 
<body>
<%
int data = 1234; // what is it? : method local variable : within _jspService of test7.jsp
%>
<%-- page scoped attribute available to current page only  --%>
<c:set var="server_date" value="<%= LocalDateTime.now() %>" />
<%-- use include directive  --%>
<%@ include file="test8.jsp" %>
</body>

--- test8.jsp 

<body>

<h5> Instance var:<%= message %></h5>
<h5> Instance var:<%= data%></h5>
<h5> ${pageScope.server_date} </h5>
</body>

```

### 7. Hibernate app to for user table 

1. hibernate.cfg.xml 
```xml

<hibernate-configuration>

	<session-factory>
		<property name="hibernate.connection.autocommit">false</property>
		<property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
		<property name="hibernate.connection.password">password</property>
		<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/day2?useSSL=false</property>
		<property name="hibernate.connection.username">dac</property>
		<property name="hibernate.current_session_context_class">thread</property>
		<property name="hibernate.connection.pool_size">2</property>
		<!-- <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property> -->
		<property name="hibernate.show_sql">true</property>
		<property name="hibernate.format_sql">true</property>
		<property name="hibernate.hbm2ddl.auto">update</property>
		<mapping class="pojos.User"/>

	</session-factory>
</hibernate-configuration>

```

2. hb utils
```java
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		System.out.println("in static init block");
		try {
			// create std service reg instance from its builder
			StandardServiceRegistry reg = 
					new StandardServiceRegistryBuilder().
					configure().build();
			// build session factory from Metadata
			sf = new MetadataSources(reg).
					buildMetadata().buildSessionFactory();
			System.out.println("sf created....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSf() {
		return sf;
	}
}

```

3. hb pojo with annotation for ORM 
```java
import javax.persistence.*; // import all JPA compliant annotations 

@Entity // mandetory: to inform hibernate whatever follows is pojo/entity : whose life cycle has to be 
// managed by hibernate framework 
@Table(name = "users") // optional anno
public class User {
	private Integer userId; // hibernate mandates to add unique ID property :
	// Serializable (e.g Integer,Long,int,long,String ..)
	private String name,email,password,confirmPassword;
	private Role role; 
	private double regAmount; 
	private Date regDate;
	private byte[] image;
	
	// mandetory  :provide argumentless constructor 
	
	public User() {
		System.out.println("in user const");
	}
	// optional : can add parameterized ctor

	// mandetory : all setters and getters 

	@Id // mandetory : unique ID property : constraint : PK 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // to tell hb for auto ID generation 
	// constraint : auto increment : for oracle : sequence gen 
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	@Column(length = 20) // varchar size 20
	public String getName() {
		return name;
	}

	@Column(length = 20,unique = true) // unique constraint 
	public String getEmail() {
		return email;
	}

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	@Transient // to tell HB to skip this from persistence (no column created)
	public String getConfirmPassword() {
		return confirmPassword;
	}

	@Enumerated(EnumType.STRING) // to generate column as per enum name : varchar
	@Column(length = 20)
	public Role getRole() {
		return role;
	}

	@Column(name = "reg_amount")
	public double getRegAmount() {
		return regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_date")
	public Date getRegDate() {
		return regDate;
	}

	@Lob // large binary object(BLOB) : property type is byte[] : long BLOB in db 
	// if char[] : CLOB datatype created in DB
 	public byte[] getImage() {
		return image;
	}
}


```

4. dao 

```java
public interface IUserDao {
//add a method for user registeration 
	String registerUser(User user); 	
}

--- implementation 

import static utils.HibernateUtils.getSf;
import org.hibernate.*;
// below is native hibernate based DAO layer (completely hibernate specific ) 
public class UserDaoImpl implements IUserDao {
	@Override
	public String registerUser(User user) {
	String message = "User registration failed...";
	// 1. get hibernate session from session Factory: opensession / getCurrentSession()
		Session session = getSf().openSession(); 

	// 2. begin a transaction : as recommended as any operation in hb should be in transaction
	Transaction tx = session.beginTransaction(); // pools out DB connection,wraps db conn in Session 
   // L1 cache associated with session : created in empty manner 
	try {
			// operation save : insert
			session.save(user); 
			// success : commit transaction  
			tx.commit(); // automatic dirty checking 
			message = "user registeration  successfully with ID" + user.getUserId(); 	
		} catch (HibernateException e) {
			if(tx != null)
			tx.rollback();
			// inform /alert the caller about exception  :rethrow the same exception to caller(main() tester)
			 throw e; 	
		}finally {
		if(session != null)
		session.close(); // L1 cache destroyed and n pooled out DB conn returnds to conn pool 
		// so that same DB connection can be reused for another request 	
		}
		return message;	
	}
}

```

5. test/ main method to call 

```java
import static utils.HibernateUtils.getSf;
import org.hibernate.*;
public class RegisterNewUser {
	public static void main(String[] args) {
		
	// Testing bootstrapping of hibernate configuration (creating singleton n 
	// immutable instance of SessionFactory(sf)
		
	// to parse string to --> Date 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
	try(org.hibernate.SessionFactory sf = getSf() ; Scanner sc = new Scanner(System.in);)
	{
	System.out.println("Enter user details : name,email,password,confirmPassword,role,regAmount,regdate");
			
	// create a transient POJO (not yet persistent )
	User u1 = new User(sc.next(), sc.next(), sc.next(), sc.next(), Role.valueOf(sc.next().toUpperCase()), sc.nextDouble(),sdf.parse(sc.next()) ); 
    
	// create dao instance n invoke method 
	UserDaoImpl dao = new UserDaoImpl();
			
	System.out.println("Reg status " + dao.registerUser(u1));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
}
```




# day 8 

## to read


## demo on JPA 

1. structure of transaction in java bean / main() method
```java
main()
{
		// getting session from session factory 
		
		Session session = getSf().getCurrentSession();
		
		// begin trans 
		Transaction tx = session.beginTransaction();
		
		try {
			
			
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx != null)
				tx.rollback();
		}
		
		return null;
	}
```
  
- main method call 
```java

	public static void main(String[] args) {
		
		// Testing bootstrapping of hibernate configuration (creating singleton n 
		// immutable instance of SessionFactory(sf)
		
		try(org.hibernate.SessionFactory sf = getSf()) {
			
			System.out.println("hibernate up and running ");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
```
1. CRUD operation  :save 

```java
@Override
	public String registerUser(User user) {
	
		String msg = "User reg failed";
		
		// instance of  user  :TRANSIENT (not in L1 cache and not in DB) :EXISTS  only in java heap 
		//1 .get session from sf  :openSession 
		Session session = getSf().getCurrentSession();   // new session , empty cache 
	    Session session2 = getSf().getCurrentSession();
	    
	    System.out.println(session == session2); // true  
		//2. start/begin  transaction  , managed by programmer
		
	  Transaction tx = session.beginTransaction(); 
	  // db conn is pooled out and wrapped in session n returned to the caller 
	  // Empty L1 cache is created, empty 
 System.out.println("after begin tx : session open "+session.isOpen()+" conn "+session.isConnected());//true true
	  
	  // 3.try catch block for trans
	  
	  try {
		  // insert new users info 
		 
		Integer id =  (Integer) session.save(user); // user : PERSISTENT (only added in L1 cache  : not yet part of DB  
		  System.out.println("generated id " + id);
		  
		  tx.commit(); //at the time of commit, Hibernate performs : automatic dirty checking(check state of L1, DB)
		  //after check as user ref not in db: insert query fired: to synch state of L1 cache with DB 
		  // session is implicitely closed here i.e db conn returns to pool and L1 cache is destroyed
		msg = "User registered with ID" + id; 
	System.out.println("after commit tx : session open "+session.isOpen()+" conn "+session.isConnected());// false false 
	} catch (HibernateException e) {
		// TODO: handle exception
		// roolback trx n re throw the exc to the caller 
	
		
		if(tx != null)
		{
			tx.rollback();
			// session is implicitely closed here i.e db conn returns to pool and L1 cache is destroyed
		}
		throw e; 
	}
	  System.out.println(" before returning from dao : session open "+session.isOpen()+" conn "+session.isConnected());//false false 
	  
	  
		return msg; // user : DETACHED : here L1 cache user is destroyed , but it exists in DB
	}
```

- main 
```java
public static void main(String[] args) {
		
		// Testing bootstrapping of hibernate configuration (creating singleton n 
		// immutable instance of SessionFactory(sf)
		
		// to parse string to --> Date 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		try(org.hibernate.SessionFactory sf = getSf() ; Scanner sc = new Scanner(System.in);)
		{
			System.out.println("Enter user details : name,email,password,confirmPassword,role,regAmount,regdate");
			
			// create a transient POJO (not yet persistent )
			User u1 = new User(sc.next(), sc.next(), sc.next(), sc.next(), Role.valueOf(sc.next().toUpperCase()), sc.nextDouble(),sdf.parse(sc.next()) ); 
			// u1 : exists in java Heap : TRANSIENT 
			// create dao instance n invoke method 
			
			UserDaoImpl dao = new UserDaoImpl();
			
			System.out.println("Reg status " + dao.registerUser(u1));
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

```  
3. get 
- find by primary key so use this, or jpql 
```java
@Override
	public User fetchUserDetails(int userId) {
	    User u = null; // u  :Not applicable 
		// get session 
		
		Session session = getSf().getCurrentSession(); 
		
		 Transaction tx = session.beginTransaction(); 
		
		 try {
			 // Session API : Tget(Class<T> class,Serializable id) 
			 u = session.get(User.class,userId); // int datatype of userId : --> Integer(auto boxing) ---> Serializable (up casting)
			 // u: in case of valid id, u : PERSISTENT 
			 
			 u = session.get(User.class,userId);
			 
			 u = session.get(User.class,userId);
			 
			 tx.commit();
			// perform auto dirty checking, and L! and DB same : no queries fired , db conn returns the pool iand L1 cache is destroyed
		} catch (HibernateException e) {
			// TODO: handle exception
			
			if(tx != null)
			tx.rollback();// db conn returns to the pool and L1 cache is destroyed
			throw e; 
		}
		 
		return u; // u  :DETACHED
	}

```

- main 
```java
public static void main(String[] args) {
		
		// Testing bootstrapping of hibernate configuration (creating singleton n 
		// immutable instance of SessionFactory(sf)
		
		try(org.hibernate.SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			
			// dao instance 
			
			UserDaoImpl dao = new UserDaoImpl(); 
			
			
			System.out.println("Enter User ID");
			
			System.out.println(dao.fetchUserDetails(sc.nextInt()));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
```

4. using jpql(java persistence query language) ,
 - session createQuery() method 
 - setParameter() method in jpql statment 
```java
@Override
	public List<User> fetchAllUserDetails() {
		
		// getting session from session factory 
		
		String jpql = "select u from User u ";
		List<User> users = null; // ussers  :null
		Session session = getSf().getCurrentSession();
		
		// begin trans 
		Transaction tx = session.beginTransaction();
		
		try {
			// create query from session and execute the same 
			users = session.createQuery(jpql, User.class).getResultList(); 
			// users : list of Persistent pojo  
			/*
			 * users = session.createQuery(jpql, User.class).getResultList(); users =
			 * session.createQuery(jpql, User.class).getResultList();
			 */
			// here 3 times select is called , not take it from L1 cache 
			tx.commit(); // 
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx != null)
				tx.rollback(); // l1 cache destroed and db conn returned to pool
		}
		
		return users;// users  : list of Detached pojos  : i.e detached from l1 cache that is destroyed on commit 
	}
```

- main 

```java

	public static void main(String[] args) {
		
		// Testing bootstrapping of hibernate configuration (creating singleton n 
		// immutable instance of SessionFactory(sf)
		
		try(org.hibernate.SessionFactory sf = getSf()) {
			
			
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Existing user details ");
	dao.fetchAllUserDetails().forEach(System.out::println); 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

```

5. demo on jpql
- dao implementaiton
```java
// Display all users registered between strt date n end date & under a specific role
		@Override
		public List<User> fetchSelectedUserDetails(Date strtDate, Date endDate, Role userRole) {
			List<User> users = null;
			String jpql = "select u from User u where u.regDate between :start and :end and u.role=:rl";
			// get session from SF
			Session session = getSf().getCurrentSession();
			// begin tx
			Transaction tx = session.beginTransaction();
			try {
				users = session.createQuery(jpql, User.class).setParameter("start", strtDate).
						setParameter("end", endDate)
						.setParameter("rl", userRole).getResultList();
				// users : list of persistent pojos/entities
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();// db cn rets to the pool n L1 cache is destroyed.
				throw e;
			}
			return users;
		}
		
```

- main method call
```java
public static void main(String[] args) {
		// for parsing string ---Date : use SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Testing bootstrapping of hibernate configuration (creating singleton n
		// immutable instance of SessionFactory (SF)
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter begin date end date n role");
			// dao instance
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Selected  Users : ");
			dao.fetchSelectedUserDetails(sdf.parse(sc.next()), sdf.parse(sc.next()),
					Role.valueOf(sc.next().toUpperCase())).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


```
6. 
```java
	@Override
	public List<String> fetchSelectedUserName(Date strtDate, Date endDate, Role userRole) {

		// getting session from session factory 
		List<String> users = null;
		/*
		 * this.name = name; this.email = email; this.password = password;
		 * this.confirmPassword = confirmPassword; this.role = role; this.regAmount =
		 * regAmount; this.regDate = regDate;
		 */
		
		String jpql = "select u.name from User u where u.regDate between :start and :end and u.role=:rl";
				Session session = getSf().getCurrentSession();
				
				// begin trans 
				Transaction tx = session.beginTransaction();
				
				try {
					users = session.createQuery(jpql, String.class).setParameter("start", strtDate).setParameter("end", endDate).setParameter("rl", userRole).getResultList(); 
					
					// user : list of persistent pojos /entites 
					
					
					tx.commit();
				} catch (Exception e) {
					// TODO: handle exception
					
					if(tx != null)
						tx.rollback();
				}
				
				return users;
	}
```
- same main as 5 

7. using constructor 
- dao 
```java
@Override
	public List<User> fetchSelectedDetails(Date strtDate, Date endDate, Role userRole) {
		List<User> users = null;
		String jpql = "select new pojos.User(name,regAmount,regDate) from User u where u.regDate between :start and :end and u.role=:rl";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start", strtDate).
					setParameter("end", endDate)
					.setParameter("rl", userRole).getResultList();
			// users : list of persistent pojos/entities
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();// db cn rets to the pool n L1 cache is destroyed.
			throw e;
		}
		return users;//users : list of detached pojos/entities
	}
```
- main 

```java
public static void main(String[] args) {

			// for parsing string ---Date : use SimpleDateFormat
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			// Testing bootstrapping of hibernate configuration (creating singleton n
			// immutable instance of SessionFactory (SF)
			try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter begin date end date n role");
				// dao instance
				UserDaoImpl dao = new UserDaoImpl();
				System.out.println("Selected  User Details : ");
				dao.fetchSelectedDetails(sdf.parse(sc.next()), sdf.parse(sc.next()),
						Role.valueOf(sc.next().toUpperCase())).forEach(u -> 
						System.out.println(u.getName()+" "+u.getRegAmount()+" reged on "+u.getRegDate()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

```

8. using PERSISTENCE object to update DB, at commit 

- dao 

```java
@Override
	public String changePassword(String email, String oldPwd, String newPwd) {
	String msg = "password change failed";
	String jpql = "select u from User u where u.email=:em and u.password=:pass";
	// session 
	Session session = getSf().getCurrentSession(); 
	// begin  trans
	User u =  null;
	Transaction tx = session.beginTransaction(); 
	try {
		// create session query  ,set IN params ,get single result 
		 u = session.createQuery(jpql, User.class)
					.setParameter("em", email)
					.setParameter("pass", oldPwd)
					.getSingleResult();
			
			// in case of valid credentials method returns : PERSISTENT POJO reference 
		// no null checking is required : since methods throws exception in case no reuslt found 
		// u : PERSISTENT : exist in L1 cache , exist in DB
		u.setPassword(newPwd); // abcd : modifying state of Persistent POJo 
		tx.commit(); // hb  perform auto dirty checking : detects change : update,session close 
		// db conn returnds to the pool, L1 cache is destroyed 
		msg = "password changed successfully"; 	
		} catch (Exception e) {
			if(tx != null)
		    tx.rollback();
		}
		// u: DETACHED : hibernate does not propogate the changes done to state of detached pojo 
		u.setPassword(newPwd.toUpperCase()); // ABCD 
		return msg;
	}
	
```

- main 

```java
public static void main(String[] args) {
		// Testing bootstrapping of hibernate configuration (creating singleton n 
		// immutable instance of SessionFactory(sf)	
	try(org.hibernate.SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
		// dao instance 	
			UserDaoImpl dao = new UserDaoImpl(); 
			System.out.println("Enter User email , old password , new password");	
			System.out.println(dao.changePassword(sc.next(), sc.next(), sc.next()));	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
```
insert into suppliers values(2,"raj@gmail.com","1234",200,'2018-1-1',"VENDOR");

insert into suppliers values(3,"ram@gmail.com","ram#123",1000,'2014-1-1',"VENDOR");

insert into suppliers values(4,"sam@gmail.com","sam#123",500,'2012-1-1',"VENDOR");