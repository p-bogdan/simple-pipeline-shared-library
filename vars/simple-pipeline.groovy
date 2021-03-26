def call(Map config) {
    node {
        git url: "https://github.com/p-bogdan/simple-pipeline-shared-library"
        //sh 'mvn install'
        echo "Hello World"
    }
}