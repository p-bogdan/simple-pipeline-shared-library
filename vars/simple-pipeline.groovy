#!/usr/bin/env groovy
def hello() {
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
}
  
