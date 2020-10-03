pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
		bat 'mvn -Dmaven.test.failure.ignore=true install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }    
	stage('Sonar Job') {
            steps {
                echo 'Sonar ..'
            }
        }
	stage('Jacoco Job') {
            steps {
                echo 'Jacoco ..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
