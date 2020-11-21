
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

# Day 1 

## to read 

1. j2ee specification 
2. web server vs application server in case of j2ee? 
3. why j2ee ?
    
4. Why HttpServlet classs is declared as abstract class BUT with 100 % concrete functionality ?
-
1. It is abstract because the implementations of key servicing methods have to be provided by (e.g. overridden by) servlet developer. 
- Since it's abstract , it's instance can't be created.

2. A subclass of HttpServlet must override at least one method, usually one of these:
- 
1. doGet, if the servlet supports HTTP GET requests
2. doPost, for HTTP POST requests
3. doPut, for HTTP PUT requests
4. doDelete, for HTTP DELETE requests
- also compulsory to override init and destroy, to manage resources that are held for the life of the servlet

3. If you extend the class without overriding any methods, you will get a useless servlet; i.e. it will  give an error response for all requests.(HTTP 405 : Method not implemented) . 
-  So , if the class was not abstract, then any direct instance of HttpServlet would be useless.

4. So the reason for making the HttpServlet class abstract is to prevent a  programming error.
- As a servlet developer , you can choose to override the functionality of your requirement (eg : doPost) & ignore other methods. 

## notes 
### Version Java EE 8 (J2EE 1.8) maintained under Oracle  / Jakarta EE 8 (maintained by eclipse foundation)

1. What is J2EE ?
- Consists of specifications only .

2. Which specs ? (Rules or contract )
- Specifications of services required for any enterprise application.

3. What is enterprise application ?
- An enterprise application (EA) is a large software system platform designed to operate in a corporate environment .

- It includes online shopping and payment processing, interactive product catalogs, computerized billing systems, security, content management, IT service management,  business intelligence, human resource management, manufacturing, process automation, enterprise resource planning ....

- These specifications include ---
- Servlet API,JSP(Java server page) API,Security,Connection pooling ,EJB (Enterprise Java Bean), JNDI(Naming service -- Java naming & directory i/f),JPA(java persistence API),JMS(java messaging service),Java Mail, Java Server Faces , Java Transaction API, Webservices support(SOAP/REST) etc...

- Vendor of J2EE specs -- Oracle / Sun / Eclipse
---
- Implementation -- left to vendors (J2EE server vendors)
+ J2EE compliant web server --- Apache -- Tomcat (web container)
+ Services implemented --- servlet API,JSP API,Security,Connection pooling,JNDI(naming service)

+ J2EE complaint application server --- web container + EJB (enterprise java bean) container
+ ALL J2EE services implementation
---

### J2EE server Vendors & Products
1. Apache -- tomcat(web server) / Tomee (app server)
2. Oracle / Sun --- reference implementation --- Glassfish
3. Red Hat -- JBoss (wild fly)
4. Oracle / BEA -- weblogic
5. IBM -- Websphere
- 

4. WHY J2EE
- 1.  Can support different types of clnts ---
1. thin client(web clnt)
2. thick clnt --- application clnt(eg : TCP client)
3. smart clnts -- mobile clnts
- 
- 2. J2EE server independence -
-  Create & deploy server side appln on ANY J2ee compliant server
-   guaranteed to produce SAME results w/o touching or re-deploying on ANY other J2EE server

- 3. Ready made implementation of primary services
- eg security, conn,pooling,email...
-  so that J2EE developer DOESn't have to worry about primary services 
-  rather can concentrate on actual business logic.


5. Layers involved in HTTP request-response flow (refer to day1-data\day1_help\diags\request-response-flow.png)

- Web browser sends the request (URL)
 eg : http://www.abc.com:8080/day1.1 
/day1.1  --- root / context path /web app name

- Host --Web server--Web Container(server side JVM)--Web application---HTML/JSP/Servlet....


6. What is dyn web application
-  server side appln deployed on web server meant for servicing typically web clnts(thin)  using application layer protocol  HTTP /HTTPS
- (ref : diag request-resp flow)

### Read --HTTP basics including request & response structure from day1-data\day1_help\j2ee_prerequisites\HTTP Basics


1. Objective ?: Creating & deploying dyn web appln on Tomcat -- For HTML content


2. IDE automatically creates J2EE compliant web application folder structure .
Its details -- Refer to diag (J2EE compliant web app folder structure)


7. What is Web container --- (WC) & its jobs
- 1. Server side JVM residing within web server.
- Its run-time env for dyn web components(Servlet & JSP,Filter) . 
Jobs ---
- 2. Creating Http Request & Http response objects 
- 3. Controlling life-cycle of dyn web comps (manages life cycle of servlet,JSP,Filters)
- 4. Giving ready-made support for services --- Naming,security,Conn pooling .
- 5. Handling concurrent request from multiple clients .
- 6. Managing session tracking...

8. What is web.xml ?
-  Deployment descriptor one per web appln
1. created by -- dev
2. who reads it -- WC
3. when --- @ deployment 
4. what --- dep instrs --- welcome page, servlet deployment tags, sess config, sec config......

-
9. Why servlets? 
-  To add dynamic nature to the web application

10. What is a servlet ?
- Java class (with NO main method) -
-  represents dynamic web component 
     - whose life cycle will be managed by WC(web container : server side JVM)
- no main method
- contains of overriding form of life cycle methods
- life cycle methods --- init,service,destroy
- call back mechanism 
- Job list
1. Request processing
2. B.L 
3. Dynamic response generation
4. Data access logic(DAO class --managing DAO layer)
5. Page navigation

- Servlet API details --refer to diag servlet-api.png

### Objective 1: Test basic servlet life cycle  -- init , service ,destroy
-  Creating & deploying Hello Servlet. 

11. Deployment of the servlet
-
1. Via annotation
```java
eg : @WebServlet(value="/validate")
public class LoginServlet extends H.S {....}
Map : 
key -- /validate
value -- F.Q servlet cls name
URL : http://host:port/day1.1/validate?....
```
2. Using XML tags
- How to deploy a servlet w/o annotations --- via XML tags
web.xml
```xml
<servlet>
 <servlet-name>abc</servlet-name>
		<servlet-class>pages.SecondServlet</servlet-class>
</servlet>
<servlet-mapping>
		<servlet-name>abc</servlet-name>
		<url-pattern>/test2</url-pattern>
</servlet-mapping>
WC : map 
key : /test2
value  : pages.SecondServlet

eg URL --http://host:port/day1_web/hello

```
3.  At the time of web app deployment 
- WC tries to populate map of url patterns ,
-  from XML tags (from web.xml). Later it  will check for @WebServlet annotation



### Objective 2: Test basic servlet life cycle  -- init , service ,destroy (deployed via xml)

1. How to read request params sent from the clnt ?

- javax.servlet.ServletRequest i/f methods
1. public String getParameter(String paramName)

2. public String[] getParameterValues(String paramName)

### Objective 3 : Accept different type of i/ps from user , in HTML form.Write a servlet to display request parameters.




# Day2 

## Page Navigation Techniques
- Page Navigation=Taking user from 1 page to another page.

-  2 Ways
1. Client Pull
- Taking the client to the next page in the NEXT request
- 1. 1 User takes some action -
- eg : clicking on a button or link & then client browser generates new URL to take user to the next page.

1. 2 Redirect Scenario
- User doesn't take any action. Client browser automatically generates new URL to take user to the next page.(next page can be from same web appln , or diff web appln on same server or any web page on any srvr)

API of HttpServletResponse
public void sendRedirect(String redirectURL)
eg : For redirecting client from Servlet1 (/s1) to Servlet2 (/s2) , use
response.sendRedirect("s2");

If the response already has been committed(pw flushed or closed) , this method throws(WC) an IllegalStateException.(since WC can't redirect the client after response is alreadt committed)


2. Server Pull.
Taking the client to the next page in the same request.
Also known as resource chaining or request dispatching technique.
Client sends the request to the servlet / JSP. Same request can be chained to the next page for further servicing of the request.


Steps
1. Create Request Dispatcher object for wrapping the next page(resource --can be static or dynamic) 
API of ServletRequest
javax.servlet.RequestDispatcher getRequestDispatcher(String path)

2.Forward scenario
API of RequestDispatcher
public void forward(ServletRequest rq,ServletResponse rs)

This method allows one servlet to do initial processing of a request and another resource to generate the response. (i.e division of responsibility)

Uncommitted output in the response buffer is automatically cleared before the forward. 

If the response already has been committed(pw flushed or closed) , this method throws an IllegalStateException.

Limitation --only last page in the chain can generate dynamic response.

3. Include scenario
API of RequestDispatcher
public void include(ServletRequest rq,ServletResponse rs)

Includes the content of a resource @run time (servlet, JSP page, HTML file) in the response. --  server-side includes. 

Limitation -- The included servlet/JSP cannot change the response status code or set headers; any attempt to make a change is ignored. 



## What is a Session?

Session is a conversional state between client and server and it can consists of multiple request and response between client and server. Since HTTP and Web Server both are stateless, the only way to maintain a session is when some unique information about the session  is passed between server and client in every request and response.

HTTP protocol and Web Servers are stateless, what it means is that for web server every request is a new request to process and they cant identify if its coming from client that has been sending request previously.

But sometimes in web applications, we should know who the client is and process the request accordingly. For example, a shopping cart application should know who is sending the request to add an item and in which cart the item has to be added or who is sending checkout request so that it can charge the amount to correct client.

What is the need of session tracking?

1. To identify the clnt among multiple clnts
2. To remember the conversational state of the clnt(eg : list of the purchased books/ shopping cart/bank acct details/stocks) throughout current session

session = Represents duration or time interval 

Consists of all requests/resps coming from/ sent to SAME clnt from login to logout or till session expiration tmout.

There are several techniques for session tracking.
1. Plain Cookie based scenario
2. HttpSession interface 
3. HttpSession + URL rewriting
----------------------------------------------
Techniques

1. Plain Cookie based scenario

What is a cookie?
Cookie is small amount of text data.
Created by -- server (servlet or JSP prog or WC) & downloaded (sent) to clnt browser---within response header
 Cookie represents data shared across multiple dyn pages from the SAME web appln.(meant for the same client)

Steps :

1. Create cookie/s instance/s
javax.servlet.http.Cookie(String cName,String cVal)

2.Add the cookie/s to the resp hdr.
HttpServletResponse API :
void addCookie(Cookie c)

3. To retrieve the cookies :
HttpServletRequest :
Cookie[] getCookies()

4.Cookie class methods : 
String getName()
String getValue()
void setMaxAge(int ageInSeconds)
def age =-1 ---> browser stores cookie in cache
=0 ---> clnt browser should delete cookie
>0 --- persistent cookie --to be stored on clnt's hard disk.

int getMaxAge()

Disadvantages of pure cookie based scenario
0. Web developer (servlet prog) has to manage cookies.
1. Cookies can handle only text data : storing Java obj or bin data difficult.
2. As no of cookies inc., it will result into increased net traffic.
3. In cookie based approach : entire state of the clnt is saved on the clnt side. If the clnt browser rejects the cookies: state will be lost : session tracking fails.


How to redirect client automatically to next page ? (in the NEXT request)
API of HttpServletResponse
public void sendRedirect(String redirectLoc)
eg : resp.sendRedirect("s2");

IMPORTANT : 
WC -- throws 
java.lang.IllegalStateException: Cannot call sendRedirect() after the response has been committed(eg : pw.flush(),pw.close()...)
	


Technique # 2 : Session tracking based on HttpSession API
In this technique : 
Entire state of the client is not saved on client side , instead saved on the server side data structure (Http Sesion object) BUT the key to this Http Session object is STILL sent to client in form of a cookie.(cookie management is done by WC)


Servlet programmer  can store/restore java objects directly under the session scope(API : setAttribute/getAttribute)


Above mentioned , disadvantages ---0, 1 & 2 are reomved.
BUT entire session tracking again fails , if cookies are disabled.

Steps for javax.servlet.http.HttpSession i/f based session tracking.

1. Get Http Session object from WC

API of HttpServletRequest ---
HttpSession getSession()
Meaning --- Servlet requests WC to either create n return a NEW HttpSession object(for new clnt) or ret the existing one from WC's heap for existing client.


HttpSession --- i/f from javax.servlet.http
In case of new client : 
 HttpSession<String,Object> --empty map
String,Object ---- (entry)= attribute

OR
HttpSession getSession(boolean create)

2. : How to save data in HttpSession?(scope=entire session)
API of HttpSession i/f
public void setAttribute(String attrName,Object attrVal)
eg : hs.setAttribute("clnt_info",validatedCustomer);//no javac err
 attribute : server side object ---server side entry (key n value pair) --map


equivalent to map.put(k,v)
eg : hs.setAttribute("cart",l1);



3. For retrieving session data(getting attributes)
public Object getAttribute(String attrName) //key
eg : Customer cust=(Customer) hs.getAttribute("clnt_info");

4. To get session ID (value of the cookie whose name is jsessionid  -- unique per client by WC)
String getId()

4.5 How to remove attribute from the session scope?
public void removeAttribute(String attrName)
eg : hs.removeAttribute("clnt_info");

5. How to invalidate session?
HttpSession API
public void invalidate()
(WC marks HS object on the server side for GC ---BUT cookie  is NOT deleted from clnt browser)

6. HttpSession API
public boolean isNew()
Rets true for new client & false for existing client.

7.How to find all attr names from the session ?
public Enumeration<String> getAttributeNames()
--rets java.util.Enumeration of attr names.

8. Default session timeout value for Tomcat = 30 mins
How to change session tmout ?
HttpSession  i/f method
public void setMaxInactiveInterval(int secs)
eg : hs.setMaxInactiveInterval(300); --for 5 mins .

OR via xml tags in web.xml
<session-config>
  <session-timeout>5</session-timeout>
</session-config>


NOTE : 
What is an attribute ?
attribute = server side object(entry/mapping=key value pair)
who creates server side attrs ? -- web developer (servlet or JSP prog)
Each attribute has --- attr name(String) & attr value (java.lang.Object)
Attributes can exist in one of 3 scopes --- req. scope,session scope or application scope
1. Meaning of req scoped attr = attribute is visible for current req.
2. Meaning of session scoped attr = attribute is visible for current session.(shared across multiple reqs coming from SAME clnt)
3. Meaning of application scoped attr = attribute is visible for current web appln.(shared across multiple reqs from ANY clnt BUT for the SAME web application)









# Day3



# Day4 

## Today's topics
1. Complete Servlet Life cycle + ServletConfig
2. Executor Framework (used by WC to support concurrent handling of multiple client requests)
3. CGI Vs Servlets
4. Server pull
5. Scopes of attributes in web programming
6. ServletConfig vs ServletContext
7. Web application listeners
---
1.  day 4.1 : DB independent web app

- Complete Servlet Life cycle (including thread pool)
- Apply servlet config.
- How to Make web application DB independent (use ServletConfig)
(i.e if underlying DB changes ---no changes in java code BUT add DB specific details(JDBC drvr class, dbURL,userName , pwd) in xml based config files)


2. Scopes of attributes in web programming
refer to diag.

3. Refer to day4.3 
Replace client pull by server pull. (for LoginServlet--->CatalogServlet)  : forward
Request Dispatching technique
refer : readme n diagrams

4. Refer to day4.4 
Replace client pull by server pull. (for LoginServlet--->CatalogServlet) : include
Request Dispatching technique
refer : readme n diagrams

5. Refer to day4.5
How to Make web application DB independent (use ServletContext)
(i.e if underlying DB changes ---no changes in java code BUT add DB specific details(JDBC drvr class, dbURL,userName , pwd) in xml based config files)

6. Create web app listener (implementing ServletRequest, Session & ContextListener)
- Objective : Create a context listener , singleton instance of DB connection .
- 5.1 web.xml
- add ctx parameter : for DB config
- 5.2 Create a class imple ServletContextListener i/f 
     - contextInitialized
     - contextDestroyed
- 5.3 Edit DBUtils
- 5.4 Edit DAO layers.

---------------------------
Reading H.W ---
1.differentiate between getSession() vs getSesssion(create) of HttpServletRequest.

2.GenericServlet's overloaded init methods
3.Creating RequestDispatcher using ServletRequest or ServletContext
4. HttpSession internals
refer to --session internals & WC Heap pics.


## notes

### Regarding SERVLET CONFIG	

- A servlet specific configuration object created by a servlet container to pass information to a servlet during initialization.

1. Represents Servlet specific configuration.
Defined in javax.servlet.ServletConfig -- interface.

2. Who creates its instance  ?
Web container(WC)
3. When ?
After WC creates servlet instance(via def constr), ServletConfig instance is created & then it invokes init() method of the servlet.
4. Usage
To store servlet specific init parameters.
(i.e the init-param is accessible to one servlet only or you can say that the init-param data is private for a particular servlet.)

5. Where to add servlet specific init parameters?
Can be added either in web.xml or @WebServlet annotation.

XML Tags
```xml
<servlet>
    <servlet-name>init</servlet-name>
    <servlet-class>ex.TestInitParam</servlet-class>
    <init-param>
      <param-name>name</param-name>
      <param-value>value</param-value>
    </init-param>
</servlet>
<servlet-mapping>
<servlet-name>init</servlet-name>
<url-pattern>/test_init</url-pattern>
</servlet-mapping>
```
6. How to access servlet specific init params from a servlet ?
6.1 Override init() method
6.2 Get ServletConfig
Method of Servlet i/f 
public ServletConfig getServletConfig()
6.3 Get the init params from ServletConfig
Method of ServletConfig i/f
String getInitparameter(String paramName) : rets the param value.






### Executor Framework

- Introduced in Java 5.

1. **What's earlier support i.e in core java we used?**
- Extends Thread 
- Implements Runnable 

2. **Why Executor Framework?**
- 1. If you have thousands of task to be executed and if you create each thread for thousands of tasks, you will get performance overheads as creation and maintenance of each thread is  an overhead. 
- 2. Executor framework  solves this problem. 
- 3. In executor framework, you can create specified number of threads and reuse them to execute more tasks once it completes its current task.
- 4. It simplifies the design of creating multithreaded application and manages thread life cycles.
- 5. The programmer does not have to create or manage threads themselves, that’s the biggest advantage of executor framework.

3. **Important classes / interfaces for executor framework.**
- 
1. java.util.concurrent.Executor
- This interface is used to submit new task.
- It has a method called “execute”.

 ```java
public interface Executor {
 void execute(Runnable task);
}
```

2. ExecutorService
- It is sub-interface of Executor.
- Provides methods for 
     -     Submitting / executing Callable/Runnable tasks
     - Shutting down service
     - Executing multiple tasks etc.

3. ScheduledExecutorService
- It is sub-interface of executor service which provides methods for scheduling tasks at fixed intervals or with initial delay.

4. Executors
- This class provides factory methods for creating thread pool based executors.
- Important factory methods(=static method rets instance of ExecutorService) of Executors are:

- 4.1.  newFixedThreadPool:
     -  This method returns thread pool executor whose maximum size is fixed.
     -  If all n threads are busy performing the task and additional tasks are submitted, then they will have to wait  in the queue until thread is available.
- 4.2 newCachedThreadPool:
     -  this method returns an unbounded thread pool. It doesn’t have maximum size but if it has less number of tasks, then it will tear down unused thread.
     -   If a thread has been unused for keepAliveTime , then it will tear it down.
- 4.3 newSingleThreadedExecutor: 
     - this method returns an executor which is guaranteed to use the single thread. 
- 4.4 newScheduledThreadPool:
     -  this method returns a fixed size thread pool that can schedule commands to run after a given delay, or to execute periodically.

4. **Steps for Runnable** 
- 
1. Create a thread-pool executor , using suitable factory method of Executors.
- eg : For fixed no of threads
> ExecutorService executor = Executors.newFixedThreadPool(10);

2. Create Runnable task

3. Use inherited method
> public void execute(Runnable command)
- Executes this Runnable task , in a separate thread.

4. Shutdown the service
> public void shutdown()
- Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. 

5. > boolean awaitTermination(long timeout,TimeUnit unit) throws InterruptedException
- Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs.

6. > List<Runnable> shutdownNow()
- Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.
---

7. BUT disadvantages with Runnable interface 
- 1. Can't return result from the running task
- 2. Doesn't include throws Exception .

5. **Better API**
> java.util.concurrent.Callable<V>
> V : result type of call method
- Represents a task that returns a result and may throw an exception. 
- Functional i/f
> SAM : public V call() throws Exception
- Computes a result, or throws an exception if unable to do so.

6. **Steps in using Callable i/f**
-
1. Create a thread-pool executor , using suitable factory method of Executors.
- eg : For fixed no of threads
> ExecutorService executor = Executors.newFixedThreadPool(10);

2. Create Callable task , which returns a result.

3. To submit a task to executor service , use method of ExecutorService i/f : 
> public  Future<T> submit(Callable<T> task)
- Submits a value-returning task for execution and returns a Future representing the pending results of the task. 
- It's a non blocking method (i.e rets immediately)
- The Future's get method will return the task's result upon successful completion.
- If you would like to immediately block waiting for a task, invoke get() on Future. 
- eg :  result = exec.submit(aCallable).get();

- OR 
- main thread can perform some other jobs in the mean time & then invoke get on Future , to actually get the results. 
- (get : blocking call ,waits  till the computation is completed n then rets result)

4. Other methods of ExecutorService i/f

> public  List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException

- It's a blocking call.(waits till all tasks are complete)
- Executes the given tasks, returning a list of Futures holding their status and results when all complete.
-  Future.isDone() is true for each element of the returned list.

5. Shutdown the service
> public void shutdown()
- Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. 

6. >  boolean awaitTermination(long timeout,TimeUnit unit) throws InterruptedException
- Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs.

7.  > List<Runnable> shutdownNow()
- Attempts to stop all actively executing tasks, halts the processing of waiting tasks, and returns a list of the tasks that were awaiting execution.