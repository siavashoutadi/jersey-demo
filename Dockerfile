FROM tomcat:8.5.39-alpine

ADD target/jersey-demo.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]
