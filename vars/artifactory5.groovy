def uploadToArtifactory() {

    rtUpload (
    serverId: 'itlabs',
    spec: '''{
    "files": [
            {
              "pattern": "app/build/distributions/*",
              "target": "simple-pipeline/simple-app-files/"
            }
         ]
    }''',
)
}

def downloadToArtifactory() {
          
          rtDownload (
    serverId: 'itlabs',
    spec: '''{
          "files": [
            {
              "pattern": "simple-pipeline/simple-app-files/*.tar",
              "target": "."
            }
          ]
    }''',
)
}