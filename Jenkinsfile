pipeline {

    agent any
    
    tools {
        maven 'DevOpsMaven'
    }

    environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    }

    stages {

        stage('Checkout git'){
            steps{
                cleanWs()
                checkout(
                    [
                        $class: 'GitSCM', 
                        branches: [[name: '*/main']], 
                        doGenerateSubmoduleConfigurations: false, 
                        extension: [], 
                        submoduleCfg: [], 
                        userRemoteConfigs: [[credentialsId: 'personalgithub', url: 'https://github.com/carlosruiz005/examen.git']]
                    ]
                )
            }
        }

        stage('Pruebas unitarias'){
            steps{
                sh "mvn -Dmaven.test.skip=false -U clean test"
            }
        }

        stage('Build'){
            steps{
                sh "mvn clean package"
                
            }
        }

        stage('SonarQube'){
            steps{
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
            }
        }

        stage('Crear imagen'){
            steps{
                sh 'docker build -t carlosruizcrr6/examen .'
            }
        }

        stage('Login to DockerHub') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }

        stage('Push') {
            steps {
                sh 'docker push carlosruizcrr6/examen'
            }
        }
    }

}