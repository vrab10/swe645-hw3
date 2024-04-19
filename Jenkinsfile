pipeline {
    agent any
    tools {
        maven '3.9.5'
    }
    environment {
        registry = "yaswanthlingamaneni/swe645"
        credential = 'dockerhub'
    }
    stages {
        stage('Init') {
            steps {
                script {
                    env.date = new Date().format("ddMMyyyy")
                }
            }
        }
        stage('BuildJar') {
            steps {
                script{
                    sh 'mvn clean'
                    sh 'mvn install'
                }
            }
        }
        stage('BuildImage') {
            steps {
                script {
                    docker.withRegistry('', credential) {
                        def image = docker.build("${registry}:${env.date}", ". --no-cache --platform=linux/amd64")
                    }
                }
            }
        }
        stage('PushImage') {
            steps {
                script {
                    docker.withRegistry('', credential) {
                        def image = docker.image("${registry}:${env.date}")
                        image.push()
                    }
                }
            }
        }
        stage('DeployImage') {
            steps {
                script {
                    sh "kubectl set image deployment/feedback-survey-deployment feedback-survey=${registry}:${env.date}"
                }
            }
        }
    }
    post {
        always {
            sh 'docker logout'
        }
    }
}