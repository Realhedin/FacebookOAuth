# FacebookOAuth
Test application to show work of QAuth protocol to login via Facebook

## About application
This small test java application allows to use Facebook account (via Facebook Web Application) to login into this application.<br>
This procedure is done via QAuth protocol<br>
(application uses token from Facebook instead of user's login/password).


## Requirements to start an application
A Facebook Web Application should be created on https://developers.facebook.com/.<br>
Necessary settings: App Domains - "localhost" and Site URL - "http://localhost/".<br>
Auto-created parameters: "App ID" and "App Secret" should be used as FB_APP_ID and FB_APP_SECRET
in FBConnection.java.


## Resources
FacebookOAuth is written based on a source from tutorial by <br>
http://javapapers.com/java/java-facebook-login-with-oauth-authentication/.<br>
There are small changes in code + project is made using Maven build automation tool.


## How to run
The application could be run via Jetty plugin. <br>
After starting of web server - go to page:
<a href="http://localhost:8080/FacebookOAuth/">http://localhost:8080/FacebookOAuth/</a>.
