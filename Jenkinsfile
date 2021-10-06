pipeline {
    agent any
    tools {
        maven "M3"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'fffcb7a6-67ad-44fe-b49d-7ef2a07860ff', url: 'https://git.mezzp.com/izzp/hello.git']]])
                echo 'Hello World'
            }
        }
        stage('Build Jar') {
            steps {
                //编译jar
                sh "mvn clean package"
                echo 'Hello World'
            }
        }
        stage('Build Docker') {
            steps {
                //编译，构建本地镜像
                sh "docker build"
                echo '构建本地镜像'
            }
        }
        stage('Deploy') {
            steps {
                 //删除本地镜像
//                 sh "docker rmi -f ${imageName}"
//                 sh "docker rmi -f ${harbor_url}/${harbor_project_name}/${imageName}"
                echo 'Hello World'
            }
        }
    }
}
