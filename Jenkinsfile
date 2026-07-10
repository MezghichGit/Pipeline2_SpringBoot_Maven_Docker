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

        stage('Suppression conteneur Docker existant') {
            steps {
                echo 'Suppression du conteneur Docker existant...'
                script {
                    sh '''
                        echo "=== Suppression du conteneur ==="
                        docker stop ibcegos_cont10 || echo "Conteneur non trouvé (stop)"
                        docker rm ibcegos_cont10 || echo "Conteneur non trouvé (rm)"
                    '''
                }
            }
        }

        stage('Suppression image Docker existante') {
            steps {
                echo 'Suppression de l\'image Docker existante...'
                script {
                    sh '''
                        echo "=== Suppression de l'image ==="
                        docker rmi ibcegosamine10 || echo "Image non trouvée"
                        docker image prune -f || echo "Nettoyage images terminé"
                    '''
                }
            }
        }

        stage('Construction de l\'image Docker') {
            steps {
                echo 'Construction de l\'image Docker...'
                sh 'docker build -t ibcegosamine10 .'
            }
        }

        stage('Création du conteneur Docker') {
            steps {
                echo 'Création du conteneur Docker...'
                sh 'docker run -d -p 8777:8484 --name ibcegos_cont10 ibcegosamine10'
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