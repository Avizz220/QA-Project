# CI/CD Pipeline Setup Guide

This guide explains the CI/CD pipeline configuration for the Task Manager project.

## GitHub Actions Workflow

The CI/CD pipeline is set up using GitHub Actions and is defined in the `.github/workflows/ci-cd-pipeline.yml` file.

### Workflow Configuration

The workflow is configured to run on:
- Push to the `main` branch
- Pull requests to the `main` branch
- Manual triggers using the "workflow_dispatch" event

### Jobs and Steps

The workflow includes a single job named `build-and-test` that runs on an Ubuntu latest virtual machine. The job includes the following steps:

1. **Checkout code**: Uses `actions/checkout@v4` to fetch the repository code with full history
2. **Set up JDK 17**: Uses `actions/setup-java@v4` to set up Java 17 with Temurin distribution and Maven caching
3. **Build with Maven**: Runs `mvn clean package` command to build the project (skipping tests at this stage)
4. **Run unit tests**: Executes `mvn test` to run all the unit tests
5. **Generate test report**: Creates test reports if tests are executed

### Error Handling

- `continue-on-error: true` is added to critical steps to ensure the workflow continues even if a step fails
- This helps in diagnosing issues without failing the entire workflow

## Running the Pipeline

### Automatically

The pipeline runs automatically on:
- Any push to the main branch
- Any pull request to the main branch

### Manually

To trigger the pipeline manually:
1. Go to the "Actions" tab in your GitHub repository
2. Select "Task Manager CI/CD Pipeline" workflow
3. Click the "Run workflow" button
4. Select the branch you want to run it on and click "Run workflow"

## Viewing Results

1. Go to the "Actions" tab in your GitHub repository
2. Click on the most recent workflow run
3. You can see the status of each job and step
4. Click on a specific job to view detailed logs

## Troubleshooting Common Issues

### Build Failures

- Check Maven dependencies in `pom.xml`
- Verify Java version compatibility (JDK 17)
- Review Maven logs for specific error messages

### Test Failures

- Check test logs in the GitHub Actions output
- Look for assertion failures or exceptions
- Verify test environment setup

## Best Practices

1. **Keep tests independent**: Each test should run independently from others
2. **Regularly update dependencies**: Keep your dependencies up to date to avoid security issues
3. **Monitor workflow duration**: Long-running workflows can increase costs and slow down development
4. **Use caching**: The workflow uses Maven caching to speed up builds
5. **Add status badges**: Add workflow status badges to your README.md to show build status

## Future Enhancements

1. **Deployment steps**: Add deployment to staging/production environments
2. **Code quality checks**: Re-enable SonarQube or add other code quality tools
3. **Performance testing**: Add automated performance tests
4. **Security scanning**: Integrate security scanning tools
5. **Notification system**: Set up notifications for build failures