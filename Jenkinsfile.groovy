pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *') // Периодическая проверка репозитория каждые 5 минут
    }

    environment {
        GIT_CREDENTIALS_ID = 'GithubCreds' // ID для хранения ваших GitHub учетных данных в Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                withCredentials([usernamePassword(credentialsId: env.GIT_CREDENTIALS_ID,
                        usernameVariable: 'USER',
                        passwordVariable: 'TOKEN')]) {
                    git branch: 'master', url: 'https://github.com/yevhenii97/report-portal.git'
                }
            }
        }
        stage('Build') {
            steps {
                bat './gradlew build'
            }
        }
        stage('Test') {
            steps {
                bat './gradlew test'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'build/libs/*.jar', allowEmptyArchive: true
        }
    }
}
