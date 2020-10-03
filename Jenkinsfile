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
		    bat 'mvn -Dmaven.test.failure.ignore=false test'
            }
        }    
	stage('Sonar Job') {
           steps{
		   echo 'Sonar job starting...'
           bat 'mvn -X -Djacoco.destFile=./coverage/jacoco.exec clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
		 
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
