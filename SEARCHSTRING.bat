@echo off
set /p input="Enter Path::"
echo "Please Note : Your logs file will be genrated in C drive "
echo "#########################################################"
java -jar SearchHardcodedString.jar %input%
pause