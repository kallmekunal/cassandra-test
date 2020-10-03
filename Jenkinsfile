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
           bat "gradlew jacocoTestReport sonarqube -x check"               
           step( [$class: 'JacocoPublisher',
                  exclusionPattern: '**/*Exception*,**/*Configuration*,**/ApiApplication*,**/*Test*'] )
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
