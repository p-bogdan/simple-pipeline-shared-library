/*def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/p-bogdan/simple-pipeline-shared-library.git"
        stage("Initializing terraform") {
          echo 'Initialize terraform'
          sh   "terraform init"
        }
        stage("Create GCP instance") {
            echo 'Creating compute instance in GCP'
            sh 'terraform apply --auto-approve'
        } 
        stage("Deploy") {
            if (config.deploy) {
                sh "npm publish"
            }
        }
        body()
    }
}*/

def call(Map config=[:], Closure body) {
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
       stage('Destroy GCP instance') {
            if (config.destroy) {
            steps {
            timeout(time: 5, unit: 'MINUTES') {
            input(id: "Destroying terraform instance", message: "Are you sure to destroy ${params.project_name}?", ok: 'Destroy')
            echo 'Destroying GCP instance'
            sh 'terraform destroy -force'
            }
            }
        }
      }
      body()
        /*stage('Destroy GCP instance') {
            if (config.destroy_instance) {
            steps {
            timeout(time: 5, unit: 'MINUTES') {
            input(id: "Destroying terraform instance", message: "Are you sure to destroy ${params.project_name}?", ok: 'Destroy')
            echo 'Destroying GCP instance'
            sh 'terraform destroy -force'
            }
            }
        }
      }*/
    }
  }
}