pipeline {
    agent any
    
    environment {
        GRADLE_OPTS = '-Dorg.gradle.daemon=false -Dorg.gradle.jvmargs="-Xmx512m -XX:MaxMetaspaceSize=256m"'
        DB_CREDS = credentials('db-credentials')
        BRANCH_NAME = "${env.BRANCH_NAME}"
        DB_NAME = BRANCH_NAME == 'main' ? 'starvive' : 'starvive_dev'
        SERVER_PORT = BRANCH_NAME == 'main' ? '8081' : '8082'
        CONTAINER_NAME = BRANCH_NAME == 'main' ? 'springboot-container' : 'springboot-container-dev'
        IMAGE_TAG = BRANCH_NAME == 'main' ? 'latest' : 'dev'
        SPRING_PROFILES_ACTIVE = BRANCH_NAME == 'main' ? 'prod' : 'dev'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Clean Workspace') {
            steps {
                sh 'rm -rf ~/.gradle/caches/ || true'
            }
        }
        
        stage('Build') {
            steps {
                sh './gradlew clean build -x test --no-daemon'
            }
        }
        
        stage('Docker Build') {
            steps {
                sh "docker build -t springboot-app:${IMAGE_TAG} ."
            }
        }
        
        stage('Deploy') {
            when {
                anyOf {
                    branch 'main'
                    branch 'dev'
                }
            }
            steps {
                sh '''
                    # 기존 컨테이너 중지 및 제거
                    docker stop ${CONTAINER_NAME} || true
                    docker rm ${CONTAINER_NAME} || true
                    
                    # 새로운 컨테이너 실행
                    docker run -d --name ${CONTAINER_NAME} \
                    -e SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/${DB_NAME} \
                    -e SPRING_DATASOURCE_USERNAME=${DB_CREDS_USR} \
                    -e SPRING_DATASOURCE_PASSWORD=${DB_CREDS_PSW} \
                    -e SERVER_PORT=${SERVER_PORT} \
                    --network=host \
                    springboot-app:${IMAGE_TAG}
                    
                    # 컨테이너가 제대로 시작되었는지 확인
                    sleep 30
                    if ! docker ps | grep -q ${CONTAINER_NAME}; then
                        echo "Container failed to start"
                        docker logs ${CONTAINER_NAME}
                        exit 1
                    fi
                    
                    # 애플리케이션이 응답하는지 확인
                    for i in {1..30}; do
                        if curl -s http://localhost:${SERVER_PORT}/actuator/health > /dev/null; then
                            echo "Application is up and running"
                            exit 0
                        fi
                        echo "Waiting for application to start... (attempt $i/30)"
                        sleep 2
                    done
                    
                    echo "Application failed to start"
                    docker logs ${CONTAINER_NAME}
                    exit 1
                '''
            }
        }
    }
    
    post {
        always {
            sh 'rm -rf ~/.gradle/caches/ || true'
        }
    }
}