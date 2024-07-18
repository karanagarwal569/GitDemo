pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
               git credentialsId: 'gittt', url: 'https://github.com/karanagarwal569/GitDemo.git'
            }
        }
        
        stage('Build') {
            steps {
                // Clean and build Maven project
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Deploy artifacts or perform additional steps
                echo 'Deploying artifacts...'
                // Example: deploy to a server or artifact repository
            }
        }
    }
    
    post {
        success {
            // Send notifications on success
            echo 'Build successful! Sending notifications...'
            // Example: send email notifications
        }
        
        failure {
            // Send notifications on failure
            echo 'Build failed! Sending notifications...'
            // Example: send email notifications
        }
    }
}
