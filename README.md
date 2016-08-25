# MQTEST
EJEMPLOS DE MQ


#Pasos para crear proyectos

1.- Crear proyectos maven

mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DarchetypeVersion=RELEASE -DgroupId=net.msonic.pedidos.mqmtest -DartifactId=net.msonic.mqmtest -DinteractiveMode=false

cd net.msonic.mqmtest

mvn archetype:generate -DgroupId=net.msonic.mqmtest -DartifactId=net.msonic.mqmtest.commom -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn archetype:generate -DgroupId=net.msonic.mqmtest -DartifactId=net.msonic.mqmtest.dao -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn archetype:generate -DgroupId=net.msonic.mqmtest -DartifactId=net.msonic.mqmtest.services -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn archetype:generate -DgroupId=net.msonic.mqmtest -DartifactId=net.msonic.mqmtest.web -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false



2.- Registrar dependencias MQ

mvn install:install-file -Dfile=/Compartido/MQ_Dependencias/com.ibm.mqjms.jar -DgroupId=com.ibm.mq -DartifactId=com.ibm.mqjms -Dversion=7.5 -Dpackaging=jar


mvn install:install-file -Dfile=/Compartido/MQ_Dependencias/com.ibm.mq.jmqi.jar -DgroupId=com.ibm.mq -DartifactId=com.ibm.mq.jmqi -Dversion=7.5 -Dpackaging=jar

mvn install:install-file -Dfile=/Compartido/MQ_Dependencias/dhbcore.jar -DgroupId=com.ibm.mq -DartifactId=dhbcore -Dversion=7.5.0 -Dpackaging=jar

mvn install:install-file -Dfile=/Compartido/MQ_Dependencias/connector.jar -DgroupId=com.ibm.mq -DartifactId=connector -Dversion=7.5.0-Dpackaging=jar

mvn -e install:install-file -Dfile=/Compartido/MQ_Dependencias/jms-1.1.jar -DartifactId=jms -DgroupId=javax.jms -Dversion=1.1 -Dpackaging=jar

mvn install:install-file -Dfile=/Compartido/MQ_Dependencias/com.ibm.mq.jar -DgroupId=com.ibm.mq -DartifactId=com.ibm.mq -Dversion=7.5 -Dpackaging=jar

mvn install:install-file -Dfile=/Compartido/MQ_Dependencias/com.ibm.mq.headers.jar -DgroupId=com.ibm.mq -DartifactId=com.ibm.mq.headers -Dversion=7.5 -Dpackaging=jar


mvn install:install-file -Dfile=/Compartido/MQ_Dependencias/com.ibm.mq.commonservices.jar -DgroupId=com.ibm.mq -DartifactId=com.ibm.mq.commonservices -Dversion=7.5.0 -Dpackaging=jar