def call(buildPlan = [:]) {
  node(buildPlan.jenkinsNode) {
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
    /*if (buildPlan.npm.tslint) {
      stage("TSlint") {
        sh "npm run tslint"
      }
    }*/
  }
}