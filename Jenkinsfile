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
        stage('构建jar') {
            steps {
                //编译jar
                sh "mvn clean package"
            }
        }
        stage('构建本地镜像') {
            steps {
                //编译，构建本地镜像
                sh "docker build -t hello/hello:v1 ."
            }
        }
        stage('Deploy') {
            steps {
             //删除本地镜像
//              sh "docker rmi -f ${imageName}"
//              sh "docker rmi -f ${harbor_url}/${harbor_project_name}/${imageName}"
                sh "docker run -d -p 9999:8080 hello/hello:v1 ."
                echo 'Hello World'
            }
        }
    }
}
