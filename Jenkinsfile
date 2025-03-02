pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'feature', url: 'https://github.com/tharun2258/Jenkins.git'
            }
        }

        stage('Terraform Init') {
            steps {
                dir('AWS_S3') {  // Navigate to the correct directory
                    bat 'terraform init'
                }
            }
        }

        stage('Terraform Plan') {
            steps {
                dir('AWS_S3') {
                    bat 'terraform plan -out=tfplan'
                }
            }
        }

        stage('Terraform Apply') {
            steps {
                dir('AWS_S3') {
                    bat 'terraform apply -auto-approve tfplan'
                }
            }
        }
    }
}
