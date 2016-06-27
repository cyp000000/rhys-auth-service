###########################################################################
###########################################################################
#
# Project-Level Makefile
#
# This Makefile does the following:
# -Switch branch to the relevant branch for the environment.
# -Pull the relevant branch from the remote repo.
# -Builds the project.
# -Builds the docker container.
#
###########################################################################
###########################################################################
 
image_name = infrastructure/oauth
 
DEV: DEV-REPO dev-clean-and-build
 
QA: QA-REPO qa-clean-and-build
 
UAT: UAT-REPO uat-clean-and-build
 
PROD: PROD-REPO prod-clean-and-build
 
DEV-REPO:
	echo 'Running build for QA...' && git checkout dev_Oauth
 
QA-REPO:
	echo 'Running build for QA...' && git checkout secure-master
 
UAT-REPO:
	echo 'Running build for QA...' && git checkout uat-master
 
PROD-REPO:
	echo 'Running build for QA...' && git checkout prod-master
 
dev-clean-and-build:
	@./gradlew clean build -x test createDockerfile -Penv=dev && cd ./build && echo "build" && docker build -t $(image_name):secure . && cd ../
 
qa-clean-and-build:
	@gradle clean build -x test createDockerfile -Penv=QA && cd ./build && echo "build" && docker build -t $(image_name):secure . && cd ../
 
uat-clean-and-build:
	@gradle clean build -x test createDockerfile -Penv=QA && cd ./build && echo "build" && docker build -t $(image_name):uat . && cd ../
 
prod-clean-and-build:
	@gradle clean build -x test createDockerfile -Penv=prod && cd ./build && echo "build" && docker build -t $(image_name):prod . && cd ../