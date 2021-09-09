node {
    checkout scm
    stage('Build') {
        steps {
                sh 'make' 
            }
    }
    stage('Test') {
        echo 'Testing...'
    }
    stage('Deploy') {
        echo 'Deploying...'
    }
}
