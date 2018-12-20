pipeline
{
    agent
    {
        label 'master'
    }
    stages
    {
        stage('Build')
        {
            steps
            {
                sh 'mvn clean package'
            }
            post
            {
                success
                {
                   echo 'Successful'
                   emailext (
                              subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                              body: """SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':
                                       Check console output at '${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]""",
                              recipientProviders: [[$class: 'DevelopersRecipientProvider']]
                           )
                }
                failure
                {
                    echo 'failure'
                }
                
            }   
        }
        stage('Deploy on Production')
        {
            steps
            {
                /*timeout(time:5,unit:'DAYS')
                {
                    input message : 'Approve Deployment on production?'
                }*/
                sh 'ansible-playbook deploy.yml -i ansiserver'
            }
        }
    }
}
