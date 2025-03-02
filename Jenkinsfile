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
                bat 'terraform init'
            }
        }

        stage('Terraform Plan') {
            steps {
                bat 'terraform plan -out=tfplan'
            }
        }

        stage('Terraform Apply') {
            steps {
                bat 'terraform apply -auto-approve tfplan'
            }
        }
    }
}
