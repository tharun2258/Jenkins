pipeline {
    agent any

    environment {
        AWS_ACCESS_KEY_ID = credentials('AWS_ACCESS_KEY_ID')
        AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
        AWS_REGION = 'us-east-1'
        TF_WORKING_DIR = 'AWS_S3'  // Update with your Terraform directory
    }

    triggers {
        githubPush()  // Auto-trigger on GitHub push
    }

    options {
        timeout(time: 10, unit: 'MINUTES')  // Fail if pipeline takes too long
        disableConcurrentBuilds()  // Prevent multiple pipeline runs at the same time
    }

    stages {
        
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/tharun2258/Jenkins.git'
            }
        }

        stage('Setup Terraform') {
            steps {
                dir("${TF_WORKING_DIR}") {
                    bat 'terraform version'  // Verify Terraform installation
                    bat 'terraform init -reconfigure'
                }
            }
        }

        stage('Terraform Plan') {
            steps {
                dir("${TF_WORKING_DIR}") {
                    bat 'terraform plan -out=tfplan'
                }
            }
        }

        stage('Terraform Apply') {
            steps {
                dir("${TF_WORKING_DIR}") {
                    input message: 'Proceed with Terraform Apply?', ok: 'Apply'  // Manual approval
                    bat 'terraform apply -auto-approve tfplan'
                }
            }
        }
    }

    post {
        success {
            echo '✅ Infrastructure applied successfully!'
        }
        failure {
            echo '❌ Pipeline failed! Check the logs for details.'
        }
    }
}
