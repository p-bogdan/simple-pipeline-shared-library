def uploadToBucket() {
  googleStorageUpload bucket: 'gs://simple-pipeline-artifact2', credentialsId: 'simple-pipeline-app', pattern: 'app/build/distributions/*'
}