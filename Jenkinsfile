pipeline {
    agent any

   tools {

        maven 'maven3916'    // Utilise Maven 3.9.16
    }

    stages {
        stage('Vérification de l\'environnement') {
            steps {
                sh '''
                    echo "=== Java Version ==="
                    java -version
                    echo "=== Maven Version ==="
                    mvn -version
                '''
            }
        }

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