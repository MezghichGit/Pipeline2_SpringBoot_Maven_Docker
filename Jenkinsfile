pipeline {
    agent any

    tools {
        jdk 'JDK17'          // Ajout du JDK 17
        maven 'maven3916'    // Votre Maven
    }

    stages {
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