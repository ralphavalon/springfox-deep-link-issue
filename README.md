# Springfox Deep Link Test

- It starts with Springfox version 2.9.2 (which deep linking doesn't work).

- After starting the application, calling the URL (it would be better call on incognito mode and then close after calling it):

http://localhost:8080/swagger-ui.html#/some-controller/deepLinkUsingGET

- It won't expand the operation with that id.

- After changing on pom.xml to version 2.8.0, restarting the application and calling again in the browser, it will expand the method.
