pipeline {

agent any

     tools {
          maven 'maven3916'
     }
     stages{

          stage('Lancement des tests unitaires') {

               steps {
                         sh 'mvn clean test'
               }
			   
          }

          stage('Création du jar') {

               steps {
                         sh 'mvn package'
                    }	

          }  
     }
}
