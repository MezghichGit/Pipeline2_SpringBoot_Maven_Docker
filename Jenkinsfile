pipeline {

    agent any

    tools {
        jdk 'jdk'
        maven 'maven3916'
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
        
         stage('Construction de image docker') {
            steps {
                echo 'Construction de image docker...'
                sh 'docker build -t ibcegosamine2 .'
            }
        }
        
           stage('Creation de container docker') {
            steps {
                echo 'Creation de container docker...'
                sh 'docker run -d -p 8986:8484 --name ibcegos_cont2 ibcegosamine2'
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