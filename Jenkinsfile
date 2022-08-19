pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bash
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //bash
                sh "docker build -t='amitdocker/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'Amit@1234', usernameVariable: 'bhardwajamit')]) {
                    //bash
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push amitdocker/selenium-docker:latest"
			    }
            }
        }
    }
}