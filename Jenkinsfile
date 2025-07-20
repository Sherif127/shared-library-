@Library('shared-lib') _

pipeline {
    agent { label 'ec2-agent' }

    environment {
        DOCKER_IMAGE = 'leoughhh/jenkins-shared-lab'
        IMAGE_TAG = "v${BUILD_ID}"
        DEPLOYMENT_FILE = 'deployment.yaml'
    }

    stages {
        stage('Run Unit Test') {
            steps {
                runUnitTest()
            }
        }

        stage('Build App') {
            steps {
                buildApp()
            }
        }

        stage('Build Docker Image') {
            steps {
                buildImage()
            }
        }

        stage('Scan Docker Image') {
            steps {
                scanImage()
            }
        }

        stage('Push Docker Image') {
            steps {
                pushImage()
            }
        }

        stage('Remove Image Locally') {
            steps {
                removeImageLocally()
            }
        }

        stage('Deploy on Kubernetes') {
            steps {
                deployOnK8s(env.DEPLOYMENT_FILE, env.DOCKER_IMAGE, env.IMAGE_TAG)
            }
        }
    }

    post {
        always {
            echo '📦 Pipeline finished!'
        }
        success {
            echo '✅ Deployment successful!'
        }
        failure {
            echo '❌ Deployment failed!'
        }
    }
}
