def call(Closure createGCPinstance) {
  pipeline {
    agent any
    stages {
      stage('Initializing terraform') {
        steps {
          echo 'Initialize terraform'
          sh   "terraform init"
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
}