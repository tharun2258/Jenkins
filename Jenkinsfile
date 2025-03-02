pipeline {
    agent any

    parameters {
        booleanParam(name: 'autoApprove', defaultValue: false, description: 'Automatically apply Terraform plan?')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'feature', url: 'https://github.com/tharun2258/Jenkins.git'
            }
        }

        stage('Terraform Init & Plan') {
            steps {
                withCredentials([
                    string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID'),
                    string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY')
                ]) {
                    dir('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\AWS-EC2-Terraform') {  // Ensuring correct working directory
                        bat """
                            set AWS_ACCESS_KEY_ID=%AWS_ACCESS_KEY_ID%
                            set AWS_SECRET_ACCESS_KEY=%AWS_SECRET_ACCESS_KEY%
                            terraform init
                            terraform plan -out=tfplan
                            terraform show -no-color tfplan > tfplan.txt
                        """
                    }
                }
            }
        }

        stage('Approval') {
            when {
                not { equals expected: true, actual: params.autoApprove }
            }
            steps {
                script {
                    def planContent = readFile('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\AWS-EC2-Terraform\\tfplan.txt')
                    input message: "Do you want to apply the Terraform plan?",
                          parameters: [text(name: 'Plan', defaultValue: planContent, description: 'Terraform Plan Output')]
                }
            }
        }

        stage('Terraform Apply') {
            steps {
                withCredentials([
                    string(credentialsId: 'AWS_ACCESS_KEY_ID', variable: 'AWS_ACCESS_KEY_ID'),
                    string(credentialsId: 'AWS_SECRET_ACCESS_KEY', variable: 'AWS_SECRET_ACCESS_KEY')
                ]) {
                    dir('C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\AWS-EC2-Terraform') {  // Ensuring correct working directory
                        bat """
                            set AWS_ACCESS_KEY_ID=%AWS_ACCESS_KEY_ID%
                            set AWS_SECRET_ACCESS_KEY=%AWS_SECRET_ACCESS_KEY%
                            terraform apply -input=false tfplan
                        """
                    }
                }
            }
        }
    }
}
