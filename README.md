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