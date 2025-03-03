terraform {
  required_providers {
    aws={
        source = "hashicorp/aws"
        version = "~> 5.2"
    }
  }
}


terraform {
  backend "s3" {
    bucket         = "tharun-demo-terraform-state-bucket"
    key            = "AWS_S3/terraform.tfstate"
    region         = "us-east-1"
  }
}


provider "aws" {
    region = "us-east-1"
  
}
