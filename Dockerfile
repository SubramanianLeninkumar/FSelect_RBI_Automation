# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Install dependencies (Google Chrome, ChromeDriver, Gradle)
RUN apt-get update && \
    apt-get install -y \
    wget \
    curl \
    unzip \
    ca-certificates \
    libx11-dev \
    libgconf-2-4 \
    libfontconfig1 \
    gnupg2 \
    lsb-release && \
    apt-get clean

# Install Google Chrome (Stable version)
RUN wget -q -O /etc/apt/trusted.gpg.d/google-linux-signing-key.asc https://dl.google.com/linux/linux_signing_key.pub && \
    DISTRO=$(lsb_release -c | awk '{print $2}') && \
    echo "deb [signed-by=/etc/apt/trusted.gpg.d/google-linux-signing-key.asc] http://dl.google.com/linux/chrome/deb/ stable main" | tee /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    apt-get clean

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-7.5-bin.zip -P /tmp && \
    unzip /tmp/gradle-7.5-bin.zip -d /opt && \
    rm /tmp/gradle-7.5-bin.zip && \
    ln -s /opt/gradle-7.5/bin/gradle /usr/local/bin/gradle

# Install Chromium and ChromeDriver
RUN apt-get update && \
    apt-get install -y chromium-driver && \
    apt-get clean

# Set environment variables for Chrome and ChromeDriver
ENV CHROME_BIN=/usr/bin/google-chrome-stable
ENV CHROME_DRIVER=/usr/lib/chromium-browser/chromedriver

# Add ChromeDriver to the PATH
RUN ln -s /usr/lib/chromium-browser/chromedriver /usr/local/bin/chromedriver

# Copy the entire project into the container
COPY . .

# Set the command to run tests using Gradle (This will be overridden by GitHub Actions)
CMD ["gradle", "clean", "test", "--no-daemon"]
