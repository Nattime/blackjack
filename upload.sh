#! /bin/bash
# created 11/27/2017
# upload files to git

TEXT="Adding upload file for easier uploading to git"

clear
# echo $TEXT
git add .
git commit -m "$TEXT"
git push origin master
