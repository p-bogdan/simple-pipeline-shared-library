def uploadToBucket() {
  googleStorageUpload bucket: 'gs://simple-pipeline-artifact2', credentialsId: 'simple-pipeline-app', pattern: 'app/build/distributions/*'
}

def downloadFromBucket() {
  step([$class: 'DownloadStep', credentialsId: env
                        .CREDENTIALS_ID,  bucketUri: "gs://${env.BUCKET}/${env.PATTERN}",
                      localDirectory: env.LOCAL_DIR])
}
