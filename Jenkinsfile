pipeline {

agent any

     tools {
          maven 'maven3916'
     }
     stages{
          stage('Vérification de l\'environnement') {
            steps {
                sh '''
                    echo "=== Vérification Java ==="
                    java -version
                    echo "=== Vérification Maven ==="
                    mvn -version
                    echo "=== Variables d\'environnement ==="
                    echo "JAVA_HOME: $JAVA_HOME"
                '''
            }
        }
     }
}
