# Basic web app to test session replication and sticky session in JBoss EAP 7.x / Wildfly 26(or lower)

**NOTE:** For EAP 8.x / Wildfly 28 (or uppper) refers to the [Jakarta](https://github.com/alexbarbosa1989/SessionReplication/tree/Jakarta) branch in current repo.

Original code (@author  Stan Silvert) and usage description in Red Hat solution article https://access.redhat.com/solutions/46373

Usage

1- Clone project:
~~~
git clone -b main https://github.com/alexbarbosa1989/SessionReplication
~~~
2- Generate war file:
~~~
mvn clean install
~~~


**IMPORTANT**: To enable the application to use **[hotrod-session-management](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.4/html-single/development_guide/index#session-managenemt-via-hotrod)** configuration to store Web Session Data in remote Data Grid, it is required to remove `<replication-config>` in **[jboss-web.xml](https://github.com/alexbarbosa1989/SessionReplication/blob/main/src/main/webapp/WEB-INF/jboss-web.xml)**. The file should look like below:
~~~
<?xml version="1.0" encoding="UTF-8"?>
<jboss-web>
    <context-root>/counter</context-root>
</jboss-web>
~~~
