def call() {
    def branch = env.BRANCH_NAME
    if (branch == 'release') {
        withCredentials([string(credentialsId: 'gitlab-api', variable: 'GIT_PASSWORD')]) {
            sh """
                git config --global credential.username root
                git config --global credential.helper '!f() { echo password=$GIT_PASSWORD; }; f'
                git tag ${env.VERSION}-${env.BRANCH_NAME}
                git push --tags
            """
        }
    }

    if (branch.startsWith('uat')) {
        def GIT_HASH = sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
        withCredentials([string(credentialsId: 'gitlab-api', variable: 'GIT_PASSWORD')]) {
            sh """
                git config --global credential.username root
                git config --global credential.helper '!f() { echo password=$GIT_PASSWORD; }; f'
                git tag ${env.VERSION}-${env.BRANCH_NAME}-$GIT_HASH
                git push --tags
            """
        }
    }
    
}