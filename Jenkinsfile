node {
     stage('Clone repository') {
         checkout scm
     }

     stage('Build BackEnd') {
        sh'''
        mvn clean compile package
        '''
     }

     stage('Build image') {
        app = docker.build("${REPOSITORY_NAME}/${CONTAINER_NAME}:latest")
     }

     stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
            app.push()
        }
     }

     stage('Code Deploy') {
        sh '''
            docker stop -f $(docker ps -aq) || true && docker rm -f $(docker ps -aq) || true
            docker run -d -p ${PORT}:${PORT} --name ${CONTAINER_NAME} ${REPOSITORY_NAME}/${CONTAINER_NAME}:latest
        '''
     }
}