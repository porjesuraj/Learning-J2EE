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
