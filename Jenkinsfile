pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'maven3916'
    }

    environment {
        JAVA_HOME = tool 'JDK21'
        MAVEN_HOME = tool 'maven3916'
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Récupération du code source...'
                checkout scm
            }
        }


        stage('Verify Java Version') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }


        stage('Clean & Compile') {
            steps {
                echo 'Compilation du projet avec Java 21...'
                sh 'mvn clean compile'
            }
        }


        stage('Unit Tests') {
            steps {
                echo 'Execution des tests unitaires...'
                sh 'mvn test'
            }
        }


        stage('Package') {
            steps {
                echo 'Création du package Spring Boot...'
                sh 'mvn clean package -DskipTests'
            }
        }


        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar',
                fingerprint: true
            }
        }
    }


    post {

        success {
            echo '✅ Build terminé avec succès'
        }

        failure {
            echo '❌ Erreur pendant le pipeline Jenkins'
        }

        always {
            echo 'Nettoyage workspace...'
            cleanWs()
        }
    }
}