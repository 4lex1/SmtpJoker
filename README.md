# Description
SmtpJoker allows you to create and execute basic phishing mails as jokes to set up your friends.
Through the app you will be able to create a group of "victims" which will contain one sender, whose address will be the one supposed to be sending the message, and the
the others will be the receivers.

# MockMock
MockMock is a simulated SMTP server which was used to test the transmission of messages in large quantities while avoiding annoying traffic on a real server. This tool allowed us to implement our solution step by step while verifying its proper functioning while performing a large number of tests. 

# Setting up your mock SMTP server
Here is a quick guide that will allow you to run a Mock SMTP server, MockMock in this case, in order to test *SmtpJoker* while avoiding the risks that could result from a joke that would have gone wrong. In order to optimize the performance of the tool, we advise you to run it in a Docker container. To do so, follow the steps described below:

**Disclaimer**: in order to run Docker on a Windows system, it is necessary to be allowed to activate hyper-V, which is not the case on all versions. The family version, for example, does not allow it.


# Description
SmtpJoker allows you to create and execute basic phishing mails as jokes to set up your friends.
Through the app you will be able to create a group of "victims" which will contain one sender, whose address will be the one supposed to be sending the message, and the
the others will be the receivers.

# What is MockMock
MockMock is a simulated SMTP server which was used to test the transmission of messages in large quantities while avoiding annoying traffic on a real server. This tool allowed us to implement our solution step by step while verifying its proper functioning while performing a large number of tests. 

# Setting up your mock SMTP server
Here is a quick guide that will allow you to run a Mock SMTP server, MockMock in this case, in order to test *SmtpJoker* while avoiding the risks that could result from a joke that would have gone wrong. In order to optimize the performance of the tool, we advise you to run it in a Docker container. To do so, follow the steps described below:

**Disclaimer**: in order to run Docker on a Windows system, it is necessary to be allowed to activate hyper-V, which is not the case on all versions. The family version, for example, does not allow it.
However, since 2019, it is possible to run Docker Desktop through WSL2 (https://fr.wikipedia.org/wiki/Windows_Subsystem_for_Linux). Starting from this principle, we suggest you to use WSL2 directly. You can find out how to install it on your machine here https://learn.microsoft.com/en-us/windows/wsl/install.

1.	Once WSL2 is installed, you can install Docker Desktop (https://www.docker.com/products/docker-desktop/)
2.	Optional: build the MockMock project and place the output file (MockMock.jar) in the "docker" folder of our project (SmtpJoker)
3.	To build the docker image, launch the build-image.sh script via wsl and docker: wsl docker ./build-image.sh, the Dockerfile is already configured.
4.	To launch the docker container, launch the script run-container.sh via wsl and docker : wsl docker ./run-container.sh

# Configuring and running a prank campaign with SmtpJoker

# SmtpJoker's implementation


# Configuring and running a prank campaign with SmtpJoker

# SmtpJoker's implementation
