def call(Map config=[:], Closure body) {
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
}