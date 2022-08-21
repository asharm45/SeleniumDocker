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
                //bat - use it for windoww
                // logout from dockerHub
                sh "docker logout"
                // build the image
                sh "docker build -t='amitdocker/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			        // login to dockerHub with access token
			        sh "docker login --username bhardwajamit --password-stdin < /Users/amitsharma/file-containing-access-token.txt"
			        // rename the image as per the dockerHub standard - by using tag [docker.io/userName/repositoryName]
			        sh "docker image tag amitdocker/selenium-docker bhardwajamit/selenium-docker"
                    // remove the duplicate image
			        //sh "docker rm amitdocker/selenium-docker"
			        //push the image to dockerHub
			        sh "docker image push bhardwajamit/selenium-docker:latest"
            }
        }
    }
}

