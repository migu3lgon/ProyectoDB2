pipeline {
    agent any
    stages {  
        stage('first') {
            agent { label 'master' }
            steps {
               sh "printenv | sort"
            }
        }       
        stage('--- clean ---') {
            steps{
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn clean"
                }
            }
        }
        stage('-- package --') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    sh "mvn package"
                }
            }
        }
        stage('-- sonar --') {
            steps {
                withEnv(["PATH+MAVEN=${tool 'Maven'}/bin:JAVA_HOME/bin"]) {
                    step([$class: 'Mailer', recipients: 'gonzalez161256@unis.edu.gt',content:'This is a test'])
                    sh "mvn sonar:sonar -Dsonar.jdbc.url=jdbc:h2:tcp://192.168.1.37:9000/sonar -Dsonar.host.url=http://192.168.1.37:9000"
                        
                }
            }
        }
        stage('-- Merge to QA --') {
            steps {
                if(!build.result.toString().equals('FAILURE')){
                    sh "git checkout origin/QA && git merge dev && git push && git checkout dev"
                }
                
            }
        }
    }
}
