pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bat
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //bat
                sh "docker build -t='amitdocker/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			        //bat
			        user = "bhardwajamit"
			        //sh "cat /Users/amitsharma/file-containing-access-token.txt"
			        sh "docker login --username $user --password-stdin < /Users/amitsharma/file-containing-access-token.txt"
			        sh "docker push amitdocker/selenium-docker:latest"
            }
        }
    }
}

