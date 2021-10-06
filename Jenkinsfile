pipeline {
    agent any
    //gitlab的凭证
    def git_auth = "68f2087f-a034-4d39-a9ff-1f776dd3dfa8"
    //构建版本的名称
    def tag = "latest"
    //Harbor私服地址
    def harbor_url = "192.168.66.102:85"
    //Harbor的项目名称
    def harbor_project_name = "tensquare"
    //Harbor的凭证
    def harbor_auth = "ef499f29-f138-44dd-975e-ff1ca1d8c933"
    stages {
        stage('Hello') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'fffcb7a6-67ad-44fe-b49d-7ef2a07860ff', url: 'https://git.mezzp.com/izzp/hello.git']]])
                echo 'Hello World'
            }
        }
        stage('Hello1') {
            steps {
                //定义镜像名称
                def imageName = "${project_name}:${tag}"
                //编译，构建本地镜像
                sh "mvn -f ${project_name} clean package dockerfile:build"
                echo 'Hello World'
            }
        }
        stage('Hello1') {
            steps {
                 //删除本地镜像
                sh "docker rmi -f ${imageName}"
                sh "docker rmi -f ${harbor_url}/${harbor_project_name}/${imageName}"
                echo 'Hello World'
            }
        }
    }
}
