# Application Setup and Run Guide

### Prerequisites
Before running the application, you need to install the following:
1. **Docker and Docker Compose**
2. **Java Development Kit (JDK) 17**
3. **Gradle 8.7**

### Installing Docker and Docker Compose
**For Windows and macOS**:
    - Download and install Docker Desktop from the [official Docker website](https://www.docker.com/products/docker-desktop).
    - Docker Compose is included with Docker Desktop.

### Installing Java Development Kit (JDK) 17
#### On Windows

1. Download JDK 17 from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or use an open-source version such as OpenJDK from [AdoptOpenJDK](https://adoptopenjdk.net/).
2. Run the installer and follow the instructions to install JDK 17.
3. Set the `JAVA_HOME` environment variable:
   - Open the Start Menu and search for "Environment Variables".
   - Click on "Edit the system environment variables".
   - In the System Properties window, click on the "Environment Variables" button.
   - Click "New" under "System variables" and add a new variable with the name `JAVA_HOME` and the path to your JDK installation directory (e.g., `C:\Program Files\Java\jdk-17`).
   - Find the `Path` variable in the "System variables" section, select it, and click "Edit". Add a new entry for `%JAVA_HOME%\bin`.
4. Verify the installation by running the following command in Command Prompt:

```bash
java -version
```
You should see an output indicating that Java 17 is installed.

#### On macOS
1. Open your terminal.

2. Install Homebrew if you haven't already, by running:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```
3. Install Java 17 by running:

```bash
brew install openjdk@17
```

4. Add the installed JDK to your system's PATH. You can do this by adding the following lines to your `~/.zshrc` (if you're using zsh) or `~/.bash_profile` (if you're using bash):

```bash
export PATH="/usr/local/opt/openjdk@17/bin:$PATH"
export CPPFLAGS="-I/usr/local/opt/openjdk@17/include"
```
5. Reload your terminal configuration:

```bash
source ~/.zshrc   # for zsh users
source ~/.bash_profile   # for bash users
```

Verify the installation by running:

```bash
java -version
````

### Installing Gradle 8.7
### Manual Installation:

- Download Gradle 8.7 from the [official Gradle website](https://gradle.org/install/).
- Unpack the distribution and set the `GRADLE_HOME` environment variable to point to the Gradle installation directory.
- Add the `bin` directory of Gradle to your system's `PATH`.

### Using a Package Manager:

Windows: Install with chocolatey: `choco install gradle --version=8.7`.
macOS: Install with Homebrew: brew install gradle@8.7.
Linux: Follow the instructions specific to your distribution, or use SDKMAN: `sdk install gradle 8.7`.

Verify the installation by running:

```bash
gradle -v
```
You should see an output indicating that Gradle 8.7 is installed.

### Running the Application
##### Step 1: Start MongoDB using Docker Compose
Navigate to the directory containing your `docker-compose.yml` file and run the following command:
```bash
docker-compose up --build
```
This command will build and start the MongoDB service defined in your Docker Compose configuration.

##### Step 2: Run the Spring Boot Application
Navigate to the root directory of your Spring Boot project and run the following command:
```bash
./gradlew bootRun
```
This will build and start your Spring Boot application using Gradle.

Your application should now be up and running, connected to the MongoDB instance started by Docker Compose.

### Additional Information
- Stopping the MongoDB Service: To stop the MongoDB service, you can use `Ctrl+C` in the terminal where docker-compose is running, or run `docker-compose down` in another terminal.
- Building the Application: If you need to rebuild the application, you can use `./gradlew build`.

