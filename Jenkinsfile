pipeline {
    agent any

    environment {
        AWS_ACCESS_KEY_ID = credentials('AWS_ACCESS_KEY_ID')  // Jenkins credential ID
        AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
        AWS_REGION = 'us-east-1'  // Change to your AWS region
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'feature', url: 'https://github.com/tharun2258/Jenkins.git'
            }
        }

        stage('Terraform Init') {
            steps {
                dir('AWS_S3') {
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

        stage('Terraform Destroy'){
            steps{
                dir('AWS_S3'){
                    bat 'terraform destroy -auto-approve tfplan'
                }
            }
        }
        }
    }
}
