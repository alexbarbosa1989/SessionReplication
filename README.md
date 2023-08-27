# Basic web app to test session replication and sticky session in JBoss/Wildfly


Original code (@author  Stan Silvert) and usage description in Red Hat solution article https://access.redhat.com/solutions/46373

Usage

1- Clone project:
~~~
git clone https://github.com/alexbarbosa1989/SessionReplication
~~~
2- Generate war file:
~~~
mvn clean install
~~~


**IMPORTANT**: To make work **[hotrod-session-management](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html-single/development_guide/index#session-managenemt-via-hotrod)** to store Web Session Data in remote Data Grid, must remove `<replication-config>` in **[jboss-web.xml](https://github.com/alexbarbosa1989/SessionReplication/blob/main/src/main/webapp/WEB-INF/jboss-web.xml)**. The file should looks like below:
~~~
<?xml version="1.0" encoding="UTF-8"?>
<jboss-web>
    <context-root>/counter</context-root>
</jboss-web>
~~~
