pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
		 sh 'mvn -DskipTests clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
