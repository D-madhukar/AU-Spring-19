Project Initial set up
	change the following properties in web.xml context parameters 
	logfilepath
	dbname 
	setup tomcat server to the project

packages:
	com.servletapplication.log
		ServletApplicationLogger ->Custom Logger
	com.servletapplication.model
		User model
	com.servletapplication.db
		DatabaseManager 	->Establishing connection and Executing user queries
		DatabaseInitializer	->Creating Users table and inserting a default row
	com.servletapplication.listener
		This package contains only one class (ServletApplicationContextListener) which is used to perform 
		initialisation of application(like loading ServletApplicationLogger,establishing connection to the 
		database and storing DatabaseManager object in ServletContext.)
	com.servletapplication.filter
		LogFilter 		->Logs user requests
	com.servletapplication.service
		AuthenticateService	->Authenticate user(username, password)
	com.servletapplication.servlet
Login:
	use the following data to login(Default data in users table)
	username:D-madhukar
	password:madhukar
	
	
		
