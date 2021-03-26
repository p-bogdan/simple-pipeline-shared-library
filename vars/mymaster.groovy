def call(Closure getVar) {
  pipeline {
    agent any
    stages {
      stage('one') {
        steps {
          echo 'Initialize terraform'
          sh   "terraform init"
        }
      }
    }
  }
}