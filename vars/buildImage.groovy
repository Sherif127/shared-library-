def call() {
    sh "docker build -t ${env.DOCKER_IMAGE}:${env.IMAGE_TAG} ."
}
