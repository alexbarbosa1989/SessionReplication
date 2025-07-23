# Basic web app to test session replication and sticky session in JBoss EAP 8.x / Wildfly 28 (or upper)

**NOTE:** For EAP 7.x / Wildfly 27 (or lower) refers to the [main](https://github.com/alexbarbosa1989/SessionReplication/tree/main) branch in current repo.

Original code (@author  Stan Silvert) and usage description in Red Hat solution article https://access.redhat.com/solutions/46373

Usage:

### Build the application

1- Clone project:
~~~
git clone -b protostream https://github.com/alexbarbosa1989/SessionReplication
~~~
2- Generate war file:
~~~
mvn clean install
~~~

### JBoss EAP 8 deployment

1- Start a JBoss EAP 8 instance with **standalone-ha.xml** profile:
~~~
cd $JBOSS_EAP_HOME
~~~
~~~
./bin/standalone.sh --server-config=standalone-ha.xml
~~~

2 -In another terminal session, connect to the `jboss-cli`:
~~~
./bin/jboss-cli.sh
~~~
~~~            
[disconnected /] connect
~~~

3- Add the PROTOSTREAM marshaller to the `infinispan-session-management` into the `distributable-web` subsystem:
~~~
[standalone@localhost:9990 /] /subsystem=distributable-web/infinispan-session-management=default:write-attribute(name=marshaller,value=PROTOSTREAM)
~~~
Command output:
~~~
{
    "outcome" => "success",
    "response-headers" => {
        "operation-requires-reload" => true,
        "process-state" => "reload-required"
    }
}
~~~

4- Reload
~~~
[standalone@localhost:9990 /] :reload
~~~

5. Deploy the application:
~~~
[standalone@localhost:9990 /] deploy target/counter-0.0.1-SNAPSHOT.war
~~~


### Test the app

1. Make a first request to create a cookies file:
~~~
curl -c cookies.txt http://localhost:8080/counter/
~~~

2. Loop a cURL request to increase the counter:
~~~
for i in {0..10} ; do curl -b cookies.txt http://localhost:8080/counter/ ; done
~~~
