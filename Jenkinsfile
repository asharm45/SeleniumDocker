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
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'user', passwordVariable: 'pass')]) {
                    //bat
			        sh "docker login --username ${user} --password-stdin < ~/file-containing-access-token.txt"
			        sh "docker push amitdocker/selenium-docker:latest"
			    }
            }
        }
    }
}