def call () {
    stage('Checkout SCM') {
        deleteDir()
        checkout scm
    }
}