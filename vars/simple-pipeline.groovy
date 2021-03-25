#!groovy
@Library('simple-pipeline')_
pipeline {
    agent any
    stages {
        stage('Initialize terraform') {
            steps {
                echo 'Initialize terraform'
                sh "terraform init"
                
                /*archiveArtifacts artifacts: 'dist/trainSchedule.zip'*/
            }
        }
        stage('Create GCP instance') {
            steps {
            echo 'Creating compute instance in GCP'
            sh 'terraform apply --auto-approve'
              
            }
        }
    }
}