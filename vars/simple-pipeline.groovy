def call(int buildNumber) {
  if (buildNumber % 2 == 0) {
    pipeline {
      agent any
      stages {
        stage('Step1') {
          steps {
            echo "Hello world"
          }
        }
      }
    }
  } else {
    pipeline {
      agent any
      stages {
        stage('Step2') {
          steps {
            echo "Hello from the shared library"
          }
        }
      }
    }
  }
}