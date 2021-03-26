def call(Closure getVar) {
  pipeline {
    agent any
    stages {
      stage('one') {
        steps {
          echo "This is Pipeline one"
          script {
            getVar()
          }
        }
      }
    }
  }
}